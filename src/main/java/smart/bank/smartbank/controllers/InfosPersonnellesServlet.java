package smart.bank.smartbank.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/infosPersonnelles")
public class InfosPersonnellesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        if (email == null || email.isEmpty() || phone == null || phone.isEmpty()) {
            req.setAttribute("errorMessage", "Veuillez remplir tous les champs requis.");
            req.getRequestDispatcher("mesCoordonnees.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("email", email);
        session.setAttribute("phone", phone);

        resp.sendRedirect("infosPerso.jsp");
    }
}
