<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie kategorie</title>
</head>
<body>
<%@include file="../header.jsp" %>

<div align="center">
    <h3>Kategorie:</h3>
    <table border="solid black" cellpadding="10">
        <thead>
        <th>Lp.</th>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Edycja</th>
        <th>Usuwanie</th>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="category" varStatus="i">
            <tr>
                <td> ${i.index +1} </td>
                <td> ${category.name} </td>
                <td> ${category.description} </td>
                <td> <a href="/categories/${category.id}/update"> Edytuj </a> </td>
                <td> <a href="/categories/${category.id}/confirm-delete"> Usuń </a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <hr>
    <a href="/categories/add"> <h4>Dodaj nową kategorie</h4> </a>
</div>
</body>
</html>
