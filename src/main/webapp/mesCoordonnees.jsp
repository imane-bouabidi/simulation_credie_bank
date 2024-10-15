<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mes Coordonnées</title>
    <link rel="stylesheet" href="infos.css">
</head>
<body>
<div class="container">

    <div class="tabs">
        <div class="tab ">1. Simuler mon crédit</div>
        <div class="tab active">2. Mes coordonnées</div>
        <div class="tab ">3. Mes infos personnelles</div>
    </div>

    <form action="infosPersonnelles" method="post" class="credit-form">
        <div class="form-section">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
            <br>
            <label for="phone">Téléphone</label>
            <input type="text" id="phone" name="phone" required>
            <br>
            <div class="buttons">
            <button type="submit">Suivant</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
