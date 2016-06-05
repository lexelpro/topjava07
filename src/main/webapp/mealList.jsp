<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<table>
<thead>
<th>
<td>Время</td>
<td>Описание</td>
<td>Калории</td>
</th>
</thead>
<tbody>
<c:forEach var="meal" items="${mealList}">
<tr>
<td>${meal}</td>
<td></td>
<td></td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>
