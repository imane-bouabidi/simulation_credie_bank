<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="smart.bank.smartbank.entities.DemandeCredit" %>
<%@ page import="smart.bank.smartbank.services.DemandeCreditService" %>

<%
    DemandeCreditService creditService = new DemandeCreditService(new smart.bank.smartbank.Repository.RepoImpl.CreditImpl());
    List<DemandeCredit> demandes = creditService.getAllDemandes();
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Toutes les demandes de crédit</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Liste des demandes de crédit</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>CIN</th>
        <th>Date de naissance</th>
        <th>Civilité</th>
        <th>Email</th>
        <th>Téléphone Mobile</th>
        <th>Date d'embauche</th>
        <th>Revenu Total</th>
        <th>Projet</th>
        <th>Montant</th>
        <th>Durée</th>
        <th>Mensualité</th>
        <th>Crédits en cours</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (DemandeCredit demande : demandes) {
    %>
    <tr>
        <td><%= demande.getId() %></td>
        <td><%= demande.getFirstName() %></td>
        <td><%= demande.getLastName() %></td>
        <td><%= demande.getCinNumber() %></td>
        <td><%= demande.getBirthDate() %></td>
        <td><%= demande.getCivility() %></td>
        <td><%= demande.getEmail() %></td>
        <td><%= demande.getMobilePhone() %></td>
        <td><%= demande.getHiringDate() %></td>
        <td><%= demande.getTotalRevenue() %></td>
        <td><%= demande.getProjet() %></td>
        <td><%= demande.getAmount() %></td>
        <td><%= demande.getDuration() %></td>
        <td><%= demande.getMonthlyPayments() %></td>
        <td><%= demande.isHasOngoingCredits() ? "Oui" : "Non" %></td>
        <td>
            <form action="updateDemande" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%= demande.getId() %>">
                <button type="submit">Mettre à jour</button>
            </form>
            <form action="historiqueDemande" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%= demande.getId() %>">
                <button type="submit">Historique</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
