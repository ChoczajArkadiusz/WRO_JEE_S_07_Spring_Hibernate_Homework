<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 22.01.19
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Usuwanie</title>
</head>
<body>
<%@include file="../header.jsp" %>

<div align="center">
        <h1>Potwierdź usunięcie artykułu:</h1>
        <table border="solid black" cellpadding="10">
            <thead>
            <th>Tytuł</th>
            <th>Autor</th>
            <th>Utworzony</th>
            <th>Zaktualizowany</th>
            <th>Kategorie</th>
            <th>Treść</th>
            </thead>
            <tbody>
                <tr>
                    <td> ${article.title} </td>
                    <td> ${article.author.fullName} </td>
                    <td> ${article.created} </td>
                    <td> ${article.updated} </td>
                    <td>
                        <c:forEach items="${article.category}" var="category" varStatus="i">
                            ${category.name}<br>
                        </c:forEach>
                    <td> ${article.content} </td>
                    </td>
                </tr>
            </tbody>
        </table>
        <table cellpadding="50">
            <tr>
                <td><a href="/articles" class="btn btn-primary">Anuluj</a></td>
                <td><a href="/articles/${article.id}/delete" class="btn btn-warning">Usuń</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
