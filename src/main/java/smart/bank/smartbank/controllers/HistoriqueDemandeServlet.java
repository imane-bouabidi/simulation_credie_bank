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

@WebServlet("/historiqueDemande")
public class HistoriqueDemandeServlet extends HttpServlet {
    private DemandeCreditService demandeSer ;

    @Override
    public void init() {
        CreditRepo creditImpl = new CreditImpl();
        this.demandeSer = new DemandeCreditService(creditImpl);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        long id = Long.parseLong(req.getParameter("id"));
        DemandeCredit demande = demandeSer.getDemandeById(id).orElse(null);

        if(demande!=null) {
            req.setAttribute("demande", demande);
            req.getRequestDispatcher("/historique.jsp").forward(req, resp);
        }else {
            resp.getWriter().write("demande introuvable !");
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}