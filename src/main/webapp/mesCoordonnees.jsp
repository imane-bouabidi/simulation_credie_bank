<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mes Coordonnées</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Mes coordonnées</h1>

    <form action="infosPersonnelles" method="post">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="phone">Téléphone</label>
        <input type="text" id="phone" name="phone" required>
        <br>
        <button type="submit">Suivant</button>
    </form>
</div>
</body>
</html>
