<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
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
        <th>Montant</th>
        <th>Durée</th>
        <th>Mensualité</th>
        <th>Date de soumission</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="demande" items="${demandes}">
        <tr>
            <td>${demande.id}</td>
            <td>${demande.firstName}</td>
            <td>${demande.lastName}</td>
            <td>${demande.cinNumber}</td>
            <td>${demande.birthDate}</td>
            <td>${demande.amount}</td>
            <td>${demande.duration}</td>
            <td>${demande.monthlyPayments}</td>
            <td>${demande.submissionDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
