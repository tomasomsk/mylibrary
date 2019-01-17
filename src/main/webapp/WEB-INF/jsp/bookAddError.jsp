<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Add Book</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Add Book</b>

<jsp:include page="mainMenu.jsp"/>


<form:form method="POST"
           action="/library/books/add" modelAttribute="book">

    <jsp:include page="bookCrudForm.jsp"/>
    <tr>
        <td><input type="submit" value="Add"/></td>
    </tr>

</form:form>

<br/>

<jsp:include page="errorsMessage.jsp"/>

</body>
</html>