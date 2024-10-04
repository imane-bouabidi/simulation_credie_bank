<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simulation de Crédit - Étape 1</title>
</head>
<body>
<div class="container">
    <h1>Simulation de Credit - Etape 1</h1>

    <div class="form">
        <h2>Informations financières</h2>
        <label for="montant">Montant du prêt :</label>
        <input type="number" id="montant" placeholder="Entrez le montant" />

        <label for="duree">Durée (mois) :</label>
        <input type="number" id="duree" placeholder="Entrez la durée" />

        <label for="taux">Taux d'intérêt (%) :</label>
        <input type="number" id="taux" placeholder="Entrez le taux" />

        <a href="etape2.html" class="next-button">Suivant</a>
    </div>

    <div class="recap">
        <h2>Récapitulatif</h2>
        <p><strong>Montant du prêt :</strong> <span id="recap-montant">0</span> MAD</p>
        <p><strong>Taux d'intérêt :</strong> <span id="recap-taux">0</span> %</p>
        <p><strong>Durée :</strong> <span id="recap-duree">0</span> mois</p>
        <p><strong>Mensualité :</strong> <span id="recap-mensualite">0</span> MAD</p>
        <p><strong>Coût total :</strong> <span id="recap-total">0</span> MAD</p>
    </div>
</div>

<script src="app.js"></script>
</body>
</html>
