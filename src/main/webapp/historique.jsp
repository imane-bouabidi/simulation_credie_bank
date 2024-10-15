<%@ page import="smart.bank.smartbank.entities.DemandeStatut" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/historiqueCss.css">
    <title>Historique des Statuts</title>
</head>
<body>

<div class="container">
<h1>Historique des Statuts</h1>

<table border="1">
    <thead>
    <tr>
        <th>Date de Changement</th>
        <th>Statut</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<DemandeStatut> historiqueStatuts = (List<DemandeStatut>)request.getAttribute("historiqueStatuts");

        if (historiqueStatuts == null || historiqueStatuts.isEmpty()) {
    %>
    <tr>
        <td colspan="3">Aucun historique disponible pour cette demande.</td>
    </tr>
    <%
    } else {
        for (DemandeStatut statut : historiqueStatuts) {
    %>
    <tr>
        <td><%= statut.getDateChangement() %></td>
        <td><%= statut.getStatut().getNom() %></td>
        <td><%= statut.getDescription() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</div>
</body>
</html>
