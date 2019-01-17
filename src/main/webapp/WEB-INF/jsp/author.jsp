<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Author</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Author</b>

<jsp:include page="mainMenu.jsp" />

<table border="0" style="width:600px">
    <tr>
        <td> <b> Second Name </b> </td>
        <td> <b> Name </b> </td>
        <td> <b> Third Name </b> </td>
        <td> <b> Birth Year </b> </td>
    </tr>
    <tr>
        <td> ${author.second_Name} </td>
        <td> ${author.name} </td>
        <td> ${author.third_Name} </td>
        <td> ${author.birth_Year} </td>
    </tr>
</table>



<br/>
<br/>
<br/>
<br/>

<b> Biography </b>

<br/>
<br/>

<table border="0" style="width:600px">
    <tr>
        <td> ${author.biography} </td>
    </tr>
</table>

<br/>
<br/>
<br/>

<b> Books </b>

<br/>
<br/>

<table border="0" style="width:600px">
    <tr>
        <td> <b> id </b> </td>
        <td> <b> Name </b> </td>
        <td> <b> Genre </b> </td>
    </tr>

    <c:forEach items="${books}" var="book">
        <tr>
            <td><a href="
                   <c:url value="/library/books/book">
                       <c:param name="id" value="${book.id}"/>
                   </c:url>
                   ">${book.id}</a>
            </td>
            <td> ${book.name} </td>
            <td> ${book.genre.name} </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>