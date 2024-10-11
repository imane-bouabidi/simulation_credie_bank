<%--
  Created by IntelliJ IDEA.
  User: imane
  Date: 09/10/2024
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="smart.bank.smartbank.entities.DemandeCredit" %>
<%@ page import="smart.bank.smartbank.services.DemandeCreditService" %>

<%
    Long demandeId = Long.parseLong(request.getParameter("id"));
    DemandeCreditService creditService = new DemandeCreditService(new smart.bank.smartbank.Repository.RepoImpl.CreditImpl());
    DemandeCredit demande = creditService.getDemandeById(demandeId).orElse(null);

    if (demande == null) {
        System.out.println("Demande introuvable.");
        return;
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modification de la demande de crédit</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
<h1>Modifier la demande de crédit</h1>

<form action="updateDemande" method="post">
    <input type="hidden" name="id" value="<%= demande.getId() %>">

    <label for="firstName">Nom :</label>
    <input type="text" id="firstName" name="firstName" value="<%= demande.getFirstName() %>"><br>

    <label for="lastName">Prénom :</label>
    <input type="text" id="lastName" name="lastName" value="<%= demande.getLastName() %>"><br>

    <label for="cinNumber">CIN :</label>
    <input type="text" id="cinNumber" name="cinNumber" value="<%= demande.getCinNumber() %>"><br>

    <label for="birthDate">Date de naissance :</label>
    <input type="date" id="birthDate" name="birthDate" value="<%= demande.getBirthDate() %>"><br>

    <label for="civility">Civilité :</label>
    <select id="civility" name="civility">
        <option value="monsieur" <%= demande.getCivility().equals("monsieur") ? "selected" : "" %>>Monsieur</option>
        <option value="mademoiselle" <%= demande.getCivility().equals("mademoiselle") ? "selected" : "" %>>Mademoiselle</option>
        <option value="madame" <%= demande.getCivility().equals("madame") ? "selected" : "" %>>Madame</option>
    </select><br>

    <label for="email">Email :</label>
    <input type="email" id="email" name="email" value="<%= demande.getEmail() %>"><br>

    <label for="mobilePhone">Téléphone Mobile :</label>
    <input type="text" id="mobilePhone" name="mobilePhone" value="<%= demande.getMobilePhone() %>"><br>

    <label for="hiringDate">Date d'embauche :</label>
    <input type="date" id="hiringDate" name="hiringDate" value="<%= demande.getHiringDate() %>"><br>

    <label for="totalRevenue">Revenu Total :</label>
    <input type="number" id="totalRevenue" name="totalRevenue" value="<%= demande.getTotalRevenue() %>"><br>

    <label for="project">Mon projet :</label>
    <select id="project" name="project">
        <option value="argent" <%= demande.getProjet().equals("argent") ? "selected" : "" %>>J'ai besoin d'argent</option>
        <option value="auto" <%= demande.getProjet().equals("auto") ? "selected" : "" %>>Je finance mon véhicule d'occasion</option>
        <option value="imprevus" <%= demande.getProjet().equals("imprevus") ? "selected" : "" %>>Je gère mes imprévus</option>
        <option value="vehiculeNeuf" <%= demande.getProjet().equals("vehiculeNeuf") ? "selected" : "" %>>Je finance mon véhicule neuf</option>
        <option value="maison" <%= demande.getProjet().equals("maison") ? "selected" : "" %>>J'équipe ma maison</option>
    </select><br>

    <label for="amount">Montant :</label>
    <input type="number" id="amount" name="amount" value="<%= demande.getAmount() %>"><br>

    <label for="duration">Durée :</label>
    <input type="number" id="duration" name="duration" value="<%= demande.getDuration() %>"><br>

    <label for="monthlyPayments">Mensualité :</label>
    <input type="number" id="monthlyPayments" name="monthlyPayments" value="<%= demande.getMonthlyPayments() %>"><br>

    <label for="hasOngoingCredits">Crédits en cours :</label>
    <input type="checkbox" id="hasOngoingCredits" name="hasOngoingCredits" <%= demande.isHasOngoingCredits() ? "checked" : "" %>><br>

    <label for="statut">Mon projet :</label>
    <select id="statut" name="statut">
        <option value="En attente" <%= demande.getDemandeStatuts().equals("En attente") ? "selected" : "" %>>En Attente</option>
        <option value="Accepté" <%= demande.getDemandeStatuts().equals("Accepté") ? "selected" : "" %>>Accepte</option>
        <option value="Rejeté" <%= demande.getDemandeStatuts().equals("Rejeté") ? "selected" : "" %>>Refuse</option>
    </select><br>
    <button type="submit">Enregistrer les modifications</button>
</form>
</div>
</body>
</html>


