<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edycja Mieszkania</title>
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
        <h1>Edycja Mieszkania</h1>
    </div>
<%--    nie widzi flat.id--%>
    <form action="${pageContext.request.contextPath}/flats/edit/${flat.id}" method="post" class="form-container">
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" id="city" name="city" value="${flat.city}" required>
        </div>
        <div class="form-group">
            <label for="street">Street:</label>
            <input type="text" id="street" name="street" value="${flat.street}" required>
        </div>
        <div class="form-group">
            <label for="numberBuild">Number Build:</label>
            <input type="text" id="numberBuild" name="numberBuild" value="${flat.numberBuild}" required>
        </div>
        <div class="form-group">
            <label for="numberFlat"> Number Flat:</label>
            <input type="text" id="numberFlat" name="numberFlat" value="${flat.numberFlat}" required>
        </div>
        <div class="form-group">
            <label for="quantityRoom">quantity Room:</label>
            <input type="text" id="quantityRoom" name="quantityRoom" value="${flat.quantityRoom}" required>
        </div>

        <div class="form-group">
            <button type="submit">Zapisz</button>
        </div>
    </form>
</div>
</body>
</html>
