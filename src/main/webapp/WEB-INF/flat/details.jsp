<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Szczegółowe dane wynajmującego</title>
    <style>

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
        <h1>Szczegółowe dane mieszkania</h1>
    </div>
    <div class="details">
        <p><strong>City:</strong> <span>${flat.city} </span></p>
        <p><strong>Street:</strong> <span>${flat.street}</span></p>
        <p><strong>Numer Budynku:</strong> <span>${flat.numberBuild}</span></p>
        <p><strong>Numer mieszkania:</strong> <span>${flat.numberFlat}</span></p>


    <table>
        <tr>
            <th>Id</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Telefon</th>
            <th>Email</th>
            <th>Rozpoczęcie najmu</th>
            <th>Zakończenie najmu</th>
            <th>Kwota kaucji</th>
            <th>Kwota czynszu</th>

        </tr>
        <c:forEach var="flat" items="${flat}">
            <tr>
                <td>${flat.personRent.id}</td>
                <td>${flat.personRent.name}</td>
                <td>${flat.personRent.surname}</td>
                <td>${flat.personRent.numberPhone}</td>
                <td>${flat.personRent.email}</td>
                <td>${flat.personRent.rent.dateStartRent}</td>
                    <%--nie widzi pół --%>
                <td>${flat.personRent.rent.dateEndRent}</td>
                <td>${flat.personRent.rent.deposit}</td>
                <td>${flat.personRent.rent.rentPrice}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
    <div class="buttons">
        <a href="${pageContext.request.contextPath}/flats/allFlats" class="btn">Wróć</a>
    </div>
</div>
</body>
</html>
