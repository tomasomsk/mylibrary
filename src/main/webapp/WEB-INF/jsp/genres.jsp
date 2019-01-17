<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Genres</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Genres</b>

<jsp:include page="mainMenu.jsp" />

<br/>
<br/>

<table border="1" style="width:600px">
    <tr>
        <td>id</td>
        <td>Name</td>
    </tr>

    <c:forEach items="${genres}" var="genre">
        <tr>
            <td><a href="
                   <c:url value="/library/genres/genre">
                       <c:param name="id" value="${genre.genre_id}"/>
                   </c:url>
                   ">${genre.genre_id}</a>
            </td>
            <td> ${genre.name} </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>