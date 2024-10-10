package smart.bank.smartbank.controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/credit")
public class CreditServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projet = req.getParameter("projet");
        String status = req.getParameter("status");
        String montantStr = req.getParameter("montant");
        String dureeStr = req.getParameter("duree");
        String mensualiteStr = req.getParameter("monsualite");

        if (montantStr == null || montantStr.isEmpty() || dureeStr == null || dureeStr.isEmpty()) {
            req.setAttribute("errorMessage", "Veuillez remplir tous les champs requis.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        double montant = Double.parseDouble(montantStr);
        double duree = Double.parseDouble(dureeStr);
        double mensualite = Double.parseDouble(mensualiteStr);

        HttpSession session = req.getSession();
        session.setAttribute("projet", projet);
        session.setAttribute("status", status);
        session.setAttribute("montant", montant);
        session.setAttribute("duree", duree);
        session.setAttribute("mensualite", mensualite);

        resp.sendRedirect("mesCoordonnees.jsp");
    }
}
