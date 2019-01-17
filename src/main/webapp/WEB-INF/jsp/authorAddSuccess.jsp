<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Add Author</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Add Author</b>

<jsp:include page="mainMenu.jsp"/>

<form:form method="POST"
           action="/library/authors/add" modelAttribute="author">

    <jsp:include page="authorCrudForm.jsp"/>
    <tr>
        <td><input type="submit" value="Add"/></td>
    </tr>

</form:form>

<br/>

<b>Congratulations. Author added</b>

</body>
</html>