package smart.bank.smartbank.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import smart.bank.smartbank.entities.DemandeStatut;
import smart.bank.smartbank.services.DemandeStatutService;

import java.io.IOException;
import java.util.List;

@WebServlet("/historiqueDemande")
public class HistoriqueDemandeServlet extends HttpServlet {
    @Inject
    private DemandeStatutService demandeStatutService;


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        List<DemandeStatut> historiqueStatuts = demandeStatutService.getHistoriqueStatuts(id);
        req.setAttribute("historiqueStatuts", historiqueStatuts);
        req.getRequestDispatcher("/historique.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}