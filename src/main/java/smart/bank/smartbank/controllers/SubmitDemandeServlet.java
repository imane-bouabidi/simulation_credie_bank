package smart.bank.smartbank.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import smart.bank.smartbank.Repository.CreditRepo;
import smart.bank.smartbank.Repository.RepoImpl.CreditImpl;
import smart.bank.smartbank.entities.DemandeCredit;
import smart.bank.smartbank.services.DemandeCreditService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/submitDemande")
public class SubmitDemandeServlet extends HttpServlet {
    private DemandeCreditService creditService;

    @Override
    public void init() throws ServletException {
        CreditRepo creditRepo = new CreditImpl();
        creditService = new DemandeCreditService(creditRepo);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String civility = req.getParameter("civility");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String cin = req.getParameter("cin");
        String birthdate = req.getParameter("birthdate");
        String startdate = req.getParameter("startdate");
        String incomeStr = req.getParameter("income");
        String credit = req.getParameter("credit");

        if (name.isEmpty() || surname.isEmpty() || cin.isEmpty() || birthdate.isEmpty() ||
                startdate.isEmpty() || incomeStr.isEmpty() || civility.isEmpty()) {
            req.setAttribute("errorMessage", "Veuillez remplir tous les champs requis.");
            req.getRequestDispatcher("infosPerso.jsp").forward(req, resp);
            return;
        }

        double income = Double.parseDouble(incomeStr);

        session.setAttribute("civility", civility);
        session.setAttribute("name", name);
        session.setAttribute("surname", surname);
        session.setAttribute("cin", cin);
        session.setAttribute("birthdate", birthdate);
        session.setAttribute("startdate", startdate);
        session.setAttribute("income", income);
        session.setAttribute("credit", credit);

        try {
            Credit(session);
            resp.sendRedirect("Demandes.jsp");
        } catch (Exception e) {
            String fullErrorMessage = "Erreur lors de la soumission de la demande de crédit : " + e.getMessage();
            e.printStackTrace();
            req.setAttribute("errorMessage", fullErrorMessage);
            req.getRequestDispatcher("infosPerso.jsp").forward(req, resp);
        }
    }

    private void Credit(HttpSession session) throws Exception {
        String civility = (String) session.getAttribute("civility");
        String name = (String) session.getAttribute("name");
        String surname = (String) session.getAttribute("surname");
        String cin = (String) session.getAttribute("cin");
        String birthdate = (String) session.getAttribute("birthdate");
        String startdate = (String) session.getAttribute("startdate");
        Double income = (Double) session.getAttribute("income");
        String email = (String) session.getAttribute("email");
        String phone = (String) session.getAttribute("phone");
        String projet = (String) session.getAttribute("projet");
        String status = (String) session.getAttribute("status");
        Double montant = (Double) session.getAttribute("montant");
        Double duree = (Double) session.getAttribute("duree");
        Double mensualite = (Double) session.getAttribute("mensualite");

        if (civility == null || name == null || surname == null || cin == null || birthdate == null ||
                startdate == null || income == null || email == null || phone == null || projet == null ||
                status == null || montant == null || duree == null || mensualite == null) {
            throw new Exception("Informations manquantes dans la session.");
        }

        DemandeCredit demandeCredit = new DemandeCredit();
        demandeCredit.setCivility(civility);
        demandeCredit.setFirstName(name);
        demandeCredit.setLastName(surname);
        demandeCredit.setCinNumber(cin);
        demandeCredit.setBirthDate(LocalDate.parse(birthdate));
        demandeCredit.setHiringDate(LocalDate.parse(startdate));
        demandeCredit.setTotalRevenue(income);
        demandeCredit.setEmail(email);
        demandeCredit.setMobilePhone(phone);
        demandeCredit.setProjet(projet);
        demandeCredit.setAmount(montant);
        demandeCredit.setDuration(duree);
        demandeCredit.setMonthlyPayments(mensualite);
        creditService.createDemande(demandeCredit);
    }

}
