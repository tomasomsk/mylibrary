<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <title>Delete Book</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Delete Book</b>

<jsp:include page="mainMenu.jsp"/>

<form:form method="POST"
           action="/library/books/delete" modelAttribute="book">

    <table>
        <tr>
            <td><form:label path="id">Book ID</form:label></td>
            <td><form:input path="id"/></td>
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