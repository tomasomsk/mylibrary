<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Add Book</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Add Book</b>

<jsp:include page="mainMenu.jsp"/>

<form:form method="POST"
           action="/library/books/add" modelAttribute="book">

    <jsp:include page="bookCrudForm.jsp"/>
    <tr>
        <td><input type="submit" value="Add"/></td>
    </tr>
</form:form>

</body>
</html>