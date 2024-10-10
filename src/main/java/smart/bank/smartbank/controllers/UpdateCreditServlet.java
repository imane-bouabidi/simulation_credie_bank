package smart.bank.smartbank.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import smart.bank.smartbank.Repository.CreditRepo;
import smart.bank.smartbank.Repository.RepoImpl.CreditImpl;
import smart.bank.smartbank.entities.DemandeCredit;
import smart.bank.smartbank.services.DemandeCreditService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet("/updateDemande")
public class UpdateCreditServlet extends HttpServlet {
    private DemandeCreditService demandeService;
    @Override
    public void init() {
        CreditRepo creditRepo = new CreditImpl();
        demandeService = new DemandeCreditService(creditRepo);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));

        DemandeCredit demande = demandeService.getDemandeById(id).orElse(null);

        if (demande != null) {
            req.setAttribute("demande", demande);

            req.getRequestDispatcher("/update.jsp").forward(req, resp);
        } else {
            resp.getWriter().write("Demande introuvable.");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        DemandeCredit demande = demandeService.getDemandeById(id).orElse(null);

        if (demande != null) {
            demande.setFirstName(req.getParameter("firstName"));
            demande.setLastName(req.getParameter("lastName"));
            demande.setCinNumber(req.getParameter("cinNumber"));
            demande.setBirthDate(LocalDate.parse(req.getParameter("birthDate")));
            demande.setCivility(req.getParameter("civility"));
            demande.setEmail(req.getParameter("email"));
            demande.setMobilePhone(req.getParameter("mobilePhone"));
            demande.setHiringDate(LocalDate.parse(req.getParameter("hiringDate")));
            demande.setTotalRevenue(Double.parseDouble(req.getParameter("totalRevenue")));
            demande.setProjet(req.getParameter("project"));
            demande.setAmount(Double.parseDouble(req.getParameter("amount")));
            demande.setDuration(Double.parseDouble(req.getParameter("duration")));
            demande.setMonthlyPayments(Double.parseDouble(req.getParameter("monthlyPayments")));
            demande.setHasOngoingCredits(req.getParameter("hasOngoingCredits") != null);

            demandeService.updateDemande(demande);

            resp.sendRedirect("Demandes.jsp");
        } else {
            resp.getWriter().write("Demande introuvable.");
        }
    }
}