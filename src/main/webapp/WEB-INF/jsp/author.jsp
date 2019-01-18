<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Author</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Author</b>

<jsp:include page="mainMenu.jsp"/>

<table border="0" style="width:600px">
    <tr>
        <td><b> Second Name </b></td>
        <td><b> Name </b></td>
        <td><b> Third Name </b></td>
        <td><b> Birth Year </b></td>
    </tr>
    <tr>
        <td> ${author.secondName} </td>
        <td> ${author.name} </td>
        <td> ${author.thirdName} </td>
        <td> ${author.birthYear} </td>
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
        <td><b> id </b></td>
        <td><b> Name </b></td>
        <td><b> Genre </b></td>
    </tr>

    <c:forEach items="${books}" var="book">
        <tr>
            <td>
                <c:url value="/library/books/book">
                    <c:param name="id" value="${book.bookId}"/>
                </c:url>
                ${book.bookId}
            </td>
            <td> ${book.name} </td>
            <td> ${book.genre.name} </td>
        </tr>
    </c:forEach>
</table>


<br/>

<input type="button" value="Add Book To This Author"
       onclick="window.location='/library/author/getAuthorAddBookForm?authorid=' + ${author.authorId};">


</body>
</html>