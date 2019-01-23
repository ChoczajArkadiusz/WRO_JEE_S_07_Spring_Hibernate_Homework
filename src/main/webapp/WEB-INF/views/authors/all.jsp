<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie kategorie</title>
</head>
<body>
<%@include file="../header.jsp" %>

<div align="center">
    <h3>Autorzy</h3>
    <table border="solid black" cellpadding="10">
        <thead>
        <th>Lp.</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Edycja</th>
        <th>Usuwanie</th>
        </thead>
        <tbody>
        <c:forEach items="${authors}" var="author" varStatus="i">
            <tr>
                <td> ${i.index +1} </td>
                <td> ${author.firstName} </td>
                <td> ${author.lastName} </td>
                <td> <a href="/authors/${author.id}/update"> Edytuj </a> </td>
                <td> <a href="/authors/${author.id}/confirm-delete"> Usuń </a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <hr>
    <a href="/authors/add"> <h4>Dodaj nowego autora</h4> </a>
</div>
</body>
</html>
