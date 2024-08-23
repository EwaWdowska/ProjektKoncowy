<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edycja Wynajmującego</title>
    <style>
        /* Stylizacja analogiczna do poprzednich widoków */
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
    <form action="${pageContext.request.contextPath}/personRent/edit/${personRent.id}" method="post" class="form-container">
<%--        //dlaczego id-Person a nie id - w encji id--%>
        <div class="form-group">
            <label for="name">Imię:</label>
            <input type="text" id="name" name="name" value="${personRent.name}" required>
        </div>
        <div class="form-group">
            <label for="surname">Nazwisko:</label>
            <input type="text" id="surname" name="surname" value="${personRent.surname}" required>
        </div>
        <div class="form-group">
            <label for="addres">Adres wynajmu:</label>
            <input type="text" id="addres" name="addres" value="${personRent.addres}" required>
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
            <label>Wynajmy:</label>
            <ul>
                <c:forEach var="personRent" items="${personRent}">
                    <li>
<%--                        nie widzi pól!!!!--%>
                        Data rozpoczęcia: <span>${personRent.rent.rent.dateStartRent}</span>,
                        Data zakończenia: <span>${personRent.rent.rent.dateEndRent}</span>,
                        Kwota kaucji: <span>${personRent.rent.rent.deposit}</span>,
                        Kwota czynszu: <span>${personRent.rent.rent.rentPrice}</span>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="form-group">
            <button type="submit">Zapisz</button>
        </div>
    </form>
</div>
</body>
</html>
