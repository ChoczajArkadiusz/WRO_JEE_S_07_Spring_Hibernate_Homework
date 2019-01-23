<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodawanie kategorii</title>
    <meta charset="utf-8">
</head>
</head>
<body>
<%@include file="../header.jsp" %>

<div align="center" class="container">
    <h2> Edycja kategorii</h2>
    <div align="center" class="form-group">
        <form:form method="post" modelAttribute="category">
            Nazwa: <form:input path="name"/><form:errors path="name"/><br>
            Opis: <form:input path="description"/><form:errors path="description"/><br>
            <input type="submit" value="Zapisz"/>
            <input type="reset" value="Wyczyśc"/>
        </form:form>
    </div>
</div>
</body>
</html>
