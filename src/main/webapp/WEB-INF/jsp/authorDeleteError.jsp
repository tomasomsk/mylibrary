<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Delete Author</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Delete Author</b>

<jsp:include page="mainMenu.jsp"/>


<form:form method="POST"
           action="/library/authors/delete" modelAttribute="author">

    <table>
        <tr>
            <td><form:label path="id">Author ID</form:label></td>
            <td><form:input path="authorId"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete"/></td>
        </tr>
    </table>

</form:form>

<br/>

<jsp:include page="errorsMessage.jsp"/>

</body>
</html>