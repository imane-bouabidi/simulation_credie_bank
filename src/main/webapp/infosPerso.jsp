<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simulation de Crédit</title>
    <link rel="stylesheet" href="infos.css">
</head>
<body>
<div class="container">
    <div class="tabs">
        <div class="tab active">1. Simuler mon crédit</div>
        <div class="tab">2. Mes coordonnées</div>
        <div class="tab">3. Mes infos personnelles</div>
    </div>
    <c:if test="${not empty errorMessage}">
        <div class="error" style="color:red">${errorMessage}</div>
    </c:if>
    <form action="submitDemande" method="post" class="credit-form">
        <div class="form-section">
            <label for="civility">Civilité</label>
            <div class="civility-options">
                <input type="radio" id="madame" name="civility" value="madame" checked>
                <label for="madame">Madame</label>

                <input type="radio" id="mademoiselle" name="civility" value="mademoiselle">
                <label for="mademoiselle">Mademoiselle</label>

                <input type="radio" id="monsieur" name="civility" value="monsieur">
                <label for="monsieur">Monsieur</label>
            </div>
        </div>

        <div class="form-section">
            <label for="name">Nom*</label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="form-section">
            <label for="surname">Prénom*</label>
            <input type="text" id="surname" name="surname" required>
        </div>

        <div class="form-section">
            <label for="cin">Numéro CIN / Carte de séjour*</label>
            <input type="text" id="cin" name="cin" required>
        </div>

        <div class="form-section">
            <label for="birthdate">Date de naissance*</label>
            <input type="date" id="birthdate" name="birthdate" required>
        </div>

        <div class="form-section">
            <label for="startdate">Date d'embauche/début de l'activité*</label>
            <input type="date" id="startdate" name="startdate" required>
        </div>

        <div class="form-section">
            <label for="income">Total revenus mensuels (net en DH)*</label>
            <input type="number" id="income" name="income" required>
        </div>

        <div class="form-section">
            <label>Avez-vous des crédits en cours ?</label>
            <div>
                <input type="radio" id="credit-yes" name="credit" value="yes">
                <label for="credit-yes">Oui</label>

                <input type="radio" id="credit-no" name="credit" value="no" checked>
                <label for="credit-no">Non</label>
            </div>
        </div>

        <div class="form-section terms">
            <input type="checkbox" id="terms" name="terms" required>
            <label for="terms">J'ai lu et j'accepte les <a href="#">conditions générales d'utilisation</a></label>
        </div>

        <div class="buttons">
            <button type="submit">Demander ce crédit</button>
        </div>
    </form>

<%--    <div class="recap">--%>
<%--        <h3>Mon récapitulatif</h3>--%>
<%--        <div class="recap-section">--%>
<%--            <p>Mon projet</p>--%>
<%--            <strong>Prêt Personnel</strong>--%>
<%--        </div>--%>
<%--        <div class="recap-section">--%>
<%--            <p>Coordonnées et infos personnelles</p>--%>
<%--            <p>Email: imaneimane20201@gmail.com</p>--%>
<%--            <p>Téléphone: 0649786994</p>--%>
<%--        </div>--%>
<%--        <div class="recap-section">--%>
<%--            <p>Détails de mon crédit</p>--%>
<%--            <p>Vous êtes: <strong>Fonctionnaire</strong></p>--%>
<%--            <p>Montant: <strong>10 000 DH</strong></p>--%>
<%--            <p>Durée: <strong>24 mois</strong></p>--%>
<%--            <p>Mensualité: <strong>469,40 DH</strong></p>--%>
<%--            <p>Frais de dossier: <strong>271,50 DH</strong></p>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>
</body>
</html>
