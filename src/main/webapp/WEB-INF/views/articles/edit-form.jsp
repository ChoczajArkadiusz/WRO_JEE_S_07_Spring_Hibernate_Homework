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
    <h2> Edycja artykułu</h2>
    <div align="center" class="form-group">
        <form:form class="form-horizontal" method="post" modelAttribute="article">
            Tytuł: <form:input path="title"/><form:errors path="title"/><br>
            Autor: <form:select path="author"
                                items="${authors}"
                                itemLabel="lastName" itemValue="id" /><form:errors path="author"/><br>
            Kategoria: <form:select path="category"
                                    items="${categories}"
                                    itemLabel="name" itemValue="id" multiple="true"/><form:errors path="category"/><br>
            Treść: <form:textarea path="content"/><form:errors path="content"/><br>
            <input type="submit" value="Zapisz"/>
            <input type="reset" value="Wyczyśc"/>
        </form:form>
    </div>
</div>
</body>
</html>
