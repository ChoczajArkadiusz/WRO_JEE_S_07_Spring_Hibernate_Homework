<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wszystkie kategorie</title>
</head>
<body>
<%@include file="../header.jsp" %>

<div align="center">
    <h3>Artykuły:</h3>
    <table border="solid black" cellpadding="10">
        <thead>
        <th>Lp.</th>
        <th>Tytuł</th>
        <th>Autor</th>
        <th>Utworzony</th>
        <th>Zaktualizowany</th>
        <th>Kategorie</th>
        <th>Treść</th>
        <th>Edycja</th>
        <th>Usuwanie</th>
        </thead>
        <tbody>
        <c:forEach items="${articles}" var="article" varStatus="i">
            <tr>
                <td> ${i.index +1} </td>
                <td> ${article.title} </td>
                <td> ${article.author.lastName} </td>
                <td> ${article.created} </td>
                <td> ${article.updated} </td>
                <td>
                    <c:forEach items="${article.category}" var="category" varStatus="i">
                        ${category.name}<br>
                    </c:forEach>
                </td>
                <td> ${article.content} </td>
                <td> <a href="/articles/${article.id}/update"> Edytuj </a> </td>
                <td> <a href="/articles/${article.id}/confirm-delete"> Usuń </a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <hr>
    <a href="/articles/add"> <h4>Dodaj nowy artykuł</h4> </a>
</div>
</body>
</html>
