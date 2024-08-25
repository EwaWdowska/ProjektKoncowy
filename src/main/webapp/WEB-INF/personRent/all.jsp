<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista wynajmujących</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .add-button {
            text-align: right;
            margin-bottom: 20px;
        }
        .add-button a {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<h1>Lista wynajmujących:</h1>
<div class="add-button">
    <a href="${pageContext.request.contextPath}/personRents/add">Dodaj</a>
    <a href="${pageContext.request.contextPath}/flats/allFlats">Lista mieszkań</a>
</div>
<table>
    <tr>
        <th>Id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Adres Zameldowania: </th>
        <th>Telefon</th>
        <th>Email</th>
        <th>Rozpoczęcie najmu</th>
        <th>Zakończenie najmu</th>
        <th>Kwota kaucji</th>
        <th>Kwota czynszu</th>
        <th>Dodatkowe informacje</th>
    </tr>
    <c:forEach var="personRent" items="${personRent}" >
        <tr>
            <td>${personRent.id}</td>
            <td>${personRent.name}</td>
            <td>${personRent.surname}</td>
            <td>${personRent.address}</td>
            <td>${personRent.numberPhone}</td>
            <td>${personRent.email}</td>
            <td>${personRent.rent.dateStartRent}</td>
<%--nie widzi pół --%>
            <td>${personRent.rent.dateEndRent}</td>
            <td>${personRent.rent.deposit}</td>
            <td>${personRent.rent.rentPrice}</td>
            <td>${personRent.moreInformation}</td>
            <td>
                <a href="${pageContext.request.contextPath}/personRents/edit/${personRent.id}">Edytuj</a>
                <a href="${pageContext.request.contextPath}/personRents/delete/${personRent.id}">Usuń</a>
                <a href="${pageContext.request.contextPath}/personRents/details/${personRent.id}">Pokaż</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
