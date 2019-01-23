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

<div class="container" align="center">
    <h2> Dodaj nowego autora</h2>
    <div align="center" class="form-group">
        <form:form class="form-horizontal" method="post" modelAttribute="author">
            Imię: <form:input path="firstName"/><form:errors path="firstName"/><br>
            Nazwisko: <form:input path="lastName"/><form:errors path="lastName"/><br>
            <input type="submit" value="Zapisz"/>
            <input type="reset" value="Wyczyśc"/>
        </form:form>
    </div>
</div>
</body>
</html>
