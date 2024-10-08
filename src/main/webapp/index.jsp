<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simulateur de Crédit</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Demander mon crédit en ligne</h1>
    <div class="steps">
        <div class="step active">1 Simuler mon crédit</div>
        <div class="step">2 Mes coordonnées</div>
        <div class="step">3 Mes infos personnelles</div>
    </div>

    <form id="creditForm" action="credit" method="post">
        <div class="tab">
            <h2>Simuler mon crédit</h2>

            <c:if test="${not empty errorMessage}">
                <div class="error" style="color:red">${errorMessage}</div>
            </c:if>

            <label for="projet">Mon projet</label>
            <select id="projet" name="projet">
                <option value="argent">J'ai besoin d'argent</option>
                <option value="auto">Je finance mon véhicule d'occasion</option>
                <option value="auto">Je gére mes imprévus</option>
                <option value="auto">Je finance mon véhicule neuf</option>
                <option value="auto">J'équipe ma maison'</option>
            </select>
            <br>
            <label for="status">Je suis</label>
            <select id="status" name="status">
                <option value="fonctionnaire">Fonctionnaire</option>
                <option value="salarie">Commercant</option>
                <option value="salarie">Artisan</option>
                <option value="salarie">Profession libérale</option>
                <option value="salarie">Retraite</option>
            </select>
            <br>
            <label for="montant">Montant (en DH)</label>
            <input type="number" id="montant" name="montant" value="10000">
            <br>
            <label for="duree">Durée (en mois)</label>
            <input type="number" id="duree" name="duree" value="24">
            <br>
            <label for="monsualite">monsualite (en DH)</label>
            <input type="number" id="monsualite" name="monsualite" value="24">
            <br>
            <button type="submit" id="nextBtn" class="nextBtn">Suivant</button>
        </div>


    </form>
</div>

<%--<script src="script.js"></script>--%>
</body>
</html>
