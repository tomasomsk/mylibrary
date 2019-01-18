<%@ include file="header.jsp" %>
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
                       <c:param name="id" value="${genre.genreId}"/>
                   </c:url>
                   ">${genre.genreId}</a>
            </td>
            <td> ${genre.name} </td>
        </tr>
    </c:forEach>

    <br/>

    <table border="0" style="border-spacing: 15px">
        <tr>
            <td><input type="button" value="Add Genre" onclick="window.location='/library/genres/getCrudForm?opr=add';"></td>
            <td></td>
            <td><input type="button" value="Delete Genre" onclick="window.location='/library/genres/getCrudForm?opr=delete';"></td>
        </tr>
    </table>

</table>
</body>
</html>