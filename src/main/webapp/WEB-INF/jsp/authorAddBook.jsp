<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Add Book To Author</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Add Book To Author</b>

<jsp:include page="mainMenu.jsp"/>

<form:form method="POST"
           action="/library/author/addBook">
    <table>
        <tr>
            <td>
                <select name="book_id">
                    <c:forEach items="${books}" var="book">
                        <option value="${book.bookId}">${book.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <tr>
        <td><input type="submit" value="Add"/></td>
    </tr>

    <input name="author_id" value="${author.authorId}"/>
    ----

</form:form>

</body>
</html>