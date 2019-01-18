<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Books</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Books</b>

<jsp:include page="mainMenu.jsp" />

<br/>
<br/>

<table border="1" style="width:600px">
    <tr>
        <td>id</td>
        <td>Name</td>
        <td>Genre</td>
    </tr>

    <c:forEach items="${books}" var="book">
        <tr>
            <td><a href="
                   <c:url value="/library/books/book">
                       <c:param name="id" value="${book.bookId}"/>
                   </c:url>
                   ">${book.bookId}</a>
            </td>
            <td> ${book.name} </td>
            <td> ${book.genre.name} </td
        </tr>
    </c:forEach>
</table>

<br/>
<br/>

<table border="0" style="border-spacing: 15px">
    <tr>
        <td><input type="button" value="Add Book" onclick="window.location='/library/books/getaddform';"></td>
        <td></td>
        <td><input type="button" value="Delete Book" onclick="window.location='/library/books/getdeleteform';"></td>
    </tr>
</table>

</body>
</html>