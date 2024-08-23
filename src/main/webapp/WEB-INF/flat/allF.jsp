<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista mieszkań</title>
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
<h1>Lista mieszkań:</h1>
<div class="add-button">
    <a href="${pageContext.request.contextPath}/flats/add">Dodaj</a>
    <a href="${pageContext.request.contextPath}/personRents">Lista Wynajmujących</a>
</div>
<table>
    <tr>
        <th>Id</th>
        <th>Miasto</th>
        <th>ulica</th>
        <th>numer budynku</th>
        <th>numer mieszkania</th>
        <th>ilośc pokoi</th>

    </tr>
    <c:forEach var="flats" items="${flats}">
        <tr>
            <td>${flats.id}</td>
            <td>${flats.city}</td>
            <td>${flats.street}</td>
            <td>${flats.numberBuild}</td>
            <td>${flats.numberFlat}</td>
            <td>${flats.quantityRoom}</td>
            <td>
<%--                brak dostępu do pół!!!!!--%>
                <a href="${pageContext.request.contextPath}/flats/edit/${flats.id}">Edytuj</a> |
                <a href="${pageContext.request.contextPath}/flats/delete/${flats.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>