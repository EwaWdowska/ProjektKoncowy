<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edycja Wynajmującego</title>
    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #e0e0e0;
            border: 1px solid #ccc;
            padding: 20px;
            width: 800px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container {
            display: flex;
            flex-direction: column;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input[type="text"],
        .form-group input[type="date"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .form-group button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            width: 150px;
            align-self: flex-end;
        }
        .form-group button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Edycja Wynajmującego</h1>
    </div>
    <form action="${pageContext.request.contextPath}/personRents/edit/${personRent.id}" method="post" class="form-container">

        <div class="form-group">
            <label for="name">Imię:</label>
            <input type="text" id="name" name="name" value="${personRent.name}" required>
        </div>
        <div class="form-group">
            <label for="surname">Nazwisko:</label>
            <input type="text" id="surname" name="surname" value="${personRent.surname}" required>
        </div>
        <div class="form-group">
            <label for="address">Adres wynajmu:</label>
            <input type="text" id="address" name="address" value="${personRent.address}" required>
        </div>
        <div class="form-group">
            <label for="email">E-mail:</label>
            <input type="text" id="email" name="email" value="${personRent.email}" required>
        </div>
        <div class="form-group">
            <label for="numberPhone">Telefon:</label>
            <input type="text" id="numberPhone" name="numberPhone" value="${personRent.numberPhone}" required>
        </div>
        <!-- _______________________________________________________________________________________________-->
        <div class="form-group">

            <h1>Wynajem:</h1>

            <div class="form-group">
                <label for="dateStartRent">Data rozpoczęcia:</label>
                <input type="date" id="dateStartRent" name="dateStartRent" value="${personRent.rent.dateStartRent}" required>
            </div>
            <div class="form-group">
                <label for="dateEndRent">Data zakończenia:</label>
                <input type="date" id="dateEndRent" name="dateEndRent" value="${personRent.rent.dateEndRent}" required>
            </div>
            <div class="form-group">
                <label for="deposit"> Kwota kaucji:</label>
                <input type="number" step="0.01" id="deposit" name="deposit" value="${personRent.rent.deposit}" required>
            </div>
            <div class="form-group">
                <label for="rentPrice"> Kwota czynszu :</label>
                <input type="number" step="0.01" id="rentPrice" name="rentPrice" value="${personRent.rent.rentPrice}" required>
            </div>
<%--    <label>Wynajmy:</label>--%>
<%--    <ul>--%>
<%--                    <c:forEach var="rent" items="${rent}">--%>
<%--                        <li>--%>
<%--                        Data rozpoczęcia: <span>${rent.dateStartRent}</span>,--%>
<%--                        Data zakończenia: <span>${rent.dateStartRent}</span>,--%>
<%--                        Kwota kaucji: <span>${rent.dateStartRent}</span>,--%>
<%--                        Kwota czynszu: <span>${rent.dateStartRent}</span>--%>
<%--                    </li>--%>
<%--                </c:forEach>--%>
<%--            </ul>--%>
        </div>
        <div class="form-group">
            <button type="submit">Zapisz</button>
        </div>
    </form>
</div>
</body>
</html>
