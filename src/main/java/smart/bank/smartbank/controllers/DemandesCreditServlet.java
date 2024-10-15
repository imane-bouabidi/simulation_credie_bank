package smart.bank.smartbank.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import smart.bank.smartbank.entities.DemandeCredit;
import smart.bank.smartbank.entities.DemandeStatut;
import smart.bank.smartbank.services.DemandeCreditService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/demandesList")
public class DemandesCreditServlet extends HttpServlet {

    @Inject
    private DemandeCreditService creditService;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DemandeCredit> demandes = creditService.getAllDemandes();
        String filtre = req.getParameter("statut");
        if(filtre != null && !filtre.isEmpty()) {
            demandes = demandes.stream()
                    .filter(demande -> demande.getDemandeStatuts() != null &&
                            demande.getDemandeStatuts().stream()
                                    .anyMatch(demandeStatut -> demandeStatut.getStatut().getNom().equals(filtre)))
                    .collect(Collectors.toList());
        req.setAttribute("demandes", demandes);
        req.getRequestDispatcher("/Demandes.jsp").forward(req, resp);
        }else{
        req.setAttribute("demandes", demandes);
        req.getRequestDispatcher("/Demandes.jsp").forward(req, resp);
        }

    }

}