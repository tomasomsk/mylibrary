<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Book</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Book</b>

<jsp:include page="mainMenu.jsp" />

<br/>
<br/>

<table border="0" style="width:600px">
    <tr>
        <td><b>Name</b></td>
        <td><b>Genre</b></td>
        <td><b>Publication Year</b></td>
        <td><b>Author(s)</b></td>
    </tr>
    <tr>
        <td> ${book.name} </td>
        <td> ${book.genre.name} </td>
        <td> ${book.pubYear} </td>
        <td>
            <c:forEach items="${book.authors}" var="author">
                <a href="
                   <c:url value="/library/authors/author">
                       <c:param name="id" value="${author.authorId}"/>
                   </c:url>
                   ">${author.secondName} ${author.name} ${author.thirdName} <br/></a>
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>