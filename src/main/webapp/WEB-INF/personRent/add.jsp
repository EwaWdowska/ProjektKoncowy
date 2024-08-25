<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dodaj Wynajmującego</title>
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
        <h1>Dodaj Wynajmującego</h1>
    </div>
    <div class="nav-buttons">
        <a href="${pageContext.request.contextPath}/flats/allFlats">Lista mieszkań</a>
        <a href="${pageContext.request.contextPath}/personRents">Lista Wynajmujących</a>
    </div>
    <form action="${pageContext.request.contextPath}/personRents/add" method="post">
        <div class="form-group">
            <label for="name">Imię:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="surname">Nazwisko:</label>
            <input type="text" id="surname" name="surname" required>
        </div>
        <div class="form-group">
            <label for="address">Adres wynajmu:</label>
            <input type="text" id="address" name="address" required>
        </div>
        <div class="form-group">
            <label for="numberPhone">Numer telefonu:</label>
            <input type="text" id="numberPhone" name="numberPhone" required>
        </div>
        <div class="form-group">
            <label for="email">Adres e-mail:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="numberRoom">Numer pokoju:</label>
            <input type="text" id="numberRoom" name="numberRoom" required>
        </div>
        <div class="form-group">
            <label for="dateStartRent">Data rozpoczęcia najmu:</label>
            <input type="date" id="dateStartRent" name="dateStartRent" required>
        </div>
        <div class="form-group">
            <label for="dateEndRent">Data zakończenia najmu:</label>
            <input type="date" id="dateEndRent" name="dateEndRent" required>
        </div>
        <div class="form-group">
            <label for="deposit">Kwota kaucji:</label>
            <input type="number" step="0.01" id="deposit" name="deposit" required>
        </div>
        <div class="form-group">
            <label for="payDeposit">Czy wpłacono kaucję:</label>
            <select id="payDeposit" name="payDeposit" required>
                <option value="true">TAK</option>
                <option value="false">NIE</option>
            </select>
        </div>
        <div class="form-group">
            <label for="rentPrice">Kwota czynszu:</label>
            <input type="number" step="0.01" id="rentPrice" name="rentPrice" required>
        </div>
        <div class="form-group">
            <label for="moreInformation">Dodatkowe informacje:</label>
            <input type="text" id="moreInformation" name="moreInformation">
        </div>
        <div class="form-group">
            <button type="submit">Dodaj Wynajmującego</button>
        </div>
    </form>
</div>
</body>
</html>
