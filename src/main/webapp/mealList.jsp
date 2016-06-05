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
<table class="table table-hover table-bordered">
<thead>
<tr>
<th>Время</th>
<th>Описание</th>
<th>Калории</th>
</tr>
</thead>
<tbody>
<c:forEach var="meal" items="${mealList}">
<tr>
<td>${meal.getDateTime().toLocalDate()}</td>
<td>${meal.getDescription()}</td>
<td>${meal.getCalories()}</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>
