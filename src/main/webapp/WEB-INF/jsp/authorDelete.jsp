<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Delete Author</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Delete Author</b>

<jsp:include page="mainMenu.jsp"/>

<form:form method="POST"
           action="/library/authors/delete" modelAttribute="author">

    <table>
        <tr>
            <td><form:label path="authorId">Author ID</form:label></td>
            <td><form:input path="authorId"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete"/></td>
        </tr>
    </table>

</form:form>

</body>
</html>