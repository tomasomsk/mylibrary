<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Add Author</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Add Author</b>

<jsp:include page="mainMenu.jsp"/>


<form:form method="POST"
           action="/library/authors/add" modelAttribute="author">

    <jsp:include page="authorCrudForm.jsp"/>
    <tr>
        <td><input type="submit" value="Add"/></td>
    </tr>
</form:form>

<br/>

<jsp:include page="errorsMessage.jsp"/>

</body>
</html>