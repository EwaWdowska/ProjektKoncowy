<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dodaj mieszkanie</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }
        .container {
            width: 50%;
            margin: auto;
            background-color: #e0e0e0;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .header {
            margin-bottom: 20px;
            text-align: center;
        }
        .header h1 {
            margin: 0;
            padding-bottom: 10px;
            border-bottom: 2px solid #ccc;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input[type="text"],
        .form-group input[type="email"],
        .form-group input[type="date"],
        .form-group input[type="number"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .form-group select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #45a049;
        }
        .nav-buttons {
            text-align: right;
            margin-bottom: 20px;
        }
        .nav-buttons a {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Dodaj Mieszkanie</h1>
    </div>
    <div class="nav-buttons">
        <a href="${pageContext.request.contextPath}/flats/allFlats">Lista mieszkań</a>
        <a href="${pageContext.request.contextPath}/personRents">Lista Wynajmujących</a>
    </div>
    <form action="${pageContext.request.contextPath}/flats/add" method="post">
        <div class="form-group">
            <label for="city">Miasto:</label>
            <input type="text" id="city" name="city" required>
        </div>
        <div class="form-group">
            <label for="street">Ulica:</label>
            <input type="text" id="street" name="street" required>
        </div>
        <div class="form-group">
            <label for="numberBuild">Numer budynku:</label>
            <input type="text" id="numberBuild" name="numberBuild" required>
        </div>

        <div class="form-group">
            <label for="numberFlat">Numer mieszkania:</label>
            <input type="text" id="numberFlat" name="numberFlat" required>
        </div>
        <div class="form-group">
            <label for="quantityRoom">Ilośc pokoi:</label>
            <input type="text" id="quantityRoom" name="quantityRoom" required>
        </div>
        <div>
            <button type="submit">Dodaj Mieszkanie</button>
        </div>
    </form>
</div>
</body>
</html>
