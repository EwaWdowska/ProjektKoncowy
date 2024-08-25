<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Szczegółowe dane wynajmującego</title>
    <style>
        /* Dodaj odpowiedni styl według potrzeb */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            margin: 20px auto;
            padding: 20px;
            background-color: #e0e0e0;
            border: 1px solid #ccc;
            width: 800px;
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .header h1 {
            margin: 0;
        }
        .details {
            margin-bottom: 20px;
        }
        .details p {
            margin: 5px 0;
        }
        .dates {
            display: flex;
            justify-content: space-around;
        }
        .dates div {
            margin: 10px;
        }
        .dates input {
            width: 70px;
            text-align: center;
        }
        .buttons {
            text-align: right;
        }
        .btn {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Szczegółowe dane wynajmującego</h1>
    </div>
    <div class="details">
        <p><strong>Imię i nazwisko:</strong> <span>${personRent.name} ${personRent.surname}</span></p>
        <p><strong>E-mail:</strong> <span>${personRent.email}</span></p>
        <p><strong>Telefon:</strong> <span>${personRent.numberPhone}</span></p>
        <p><strong>Adres wynajmu:</strong> <span>${personRent.address}</span></p>
        <p><strong>Okres najmu:</strong> od <span>${personRent.rent.dateStartRent}</span> do <span>${personRent.rent.dateEndRent}</span></p>
        <p><strong>Kaucja:</strong> <span>${personRent.rent.deposit}</span> zł</p>
    </div>
    <div class="dates">
        <div>
            <label>Pościel:</label>
            <div><input type="text" value="14-02-" disabled></div>
            <div><input type="text" value="28-02-" disabled></div>
            <div><input type="text" value="14-03-" disabled></div>
            <div><input type="text" value="30-03-" disabled></div>
        </div>
        <div>
            <label>Sprzątanie:</label>
            <div><input type="text" value="14-02-" disabled></div>
            <div><input type="text" value="28-02-" disabled></div>
            <div><input type="text" value="14-03-" disabled></div>
            <div><input type="text" value="30-03-" disabled></div>
        </div>
        <div>
            <label>Czynsz:</label>
            <div><input type="text" value="28-02-" disabled></div>
            <div><input type="text" value="30-03-" disabled></div>
            <div><input type="text" value="30-04-" disabled></div>
        </div>
        <div>
            <label>Kaucja:</label>
            <div><input type="text" value="wpłacono" disabled></div>
        </div>
    </div>
    <div class="buttons">
        <a href="${pageContext.request.contextPath}/personRents/edit/${personRent.id}" class="btn">EDYTUJ</a>
    </div>
</div>
</body>
</html>
