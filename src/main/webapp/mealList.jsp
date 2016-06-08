<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meal list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<div style="width: 500px;">
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>id</th>
            <th>Время</th>
            <th>Описание</th>
            <th>Калории</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="meal" items="${userMealWithExceeds}">
            <tr style="color: <c:if test="${meal.exceed}">red</c:if> <c:if test="${!meal.exceed}">green</c:if>">
                <td>${meal}</td>
                <td>${meal.getFormatDateTime()}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
