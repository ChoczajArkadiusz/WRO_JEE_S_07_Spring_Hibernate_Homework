<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Strona główna</title>
</head>
<body>
<%@include file="header.jsp" %>

<div align="center">
    <h1>Strona główna</h1>
    <h3>Najnowsze artykuły:</h3>
    <table border="solid black" cellpadding="10">
        <thead>
        <th>Data dodania</th>
        <th>Tytuł</th>
        <th>Początek artykułu</th>
        </thead>
        <tbody>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td> ${article.created} </td>
                <td> ${article.title} </td>
                <td> ${article.content} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <h3>Kategorie:</h3>
    <c:forEach items="${categories}" var="category">
        <a href="#">${category.name}</a>  -
    </c:forEach>
</div>
</body>
</html>
