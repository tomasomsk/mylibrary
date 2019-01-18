<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Authors</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Authors</b>

<jsp:include page="mainMenu.jsp" />

<br/>
<br/>

<table border="1" style="width:600px">
    <tr>
        <td>id</td>
        <td>Name</td>
        <td>Second Name</td>
        <td>Third Name</td>
    </tr>

    <c:forEach items="${authors}" var="author">
        <tr>
            <td><a href="
                   <c:url value="/library/authors/author">
                       <c:param name="id" value="${author.authorId}"/>
                   </c:url>
                   ">${author.authorId}</a>
            </td>
            <td> ${author.secondName} </td>
            <td> ${author.name} </td>
            <td> ${author.thirdName} </td
        </tr>
    </c:forEach>
</table>

<br/>
<br/>

<table border="0" style="border-spacing: 15px">
    <tr>
        <td><input type="button" value="Add Author" onclick="window.location='/library/authors/getaddform';"></td>
        <td></td>
        <td><input type="button" value="Delete Author" onclick="window.location='/library/authors/getdeleteform';"></td>
    </tr>
</table>

</body>
</html>