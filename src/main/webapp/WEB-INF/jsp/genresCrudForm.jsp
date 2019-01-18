<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Genres CRUD Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<c:choose>
    <c:when test="${operation == 'add'}">
        <b><c:out value='Add Genre'/></b>
    </c:when>
    <c:otherwise>
        <b><c:out value='Delete Genre'/></b>
    </c:otherwise>
</c:choose>


<jsp:include page="mainMenu.jsp"/>

<h3>Enter The Genre Details</h3>

<form:form method="POST"
           action="/library/genres/${operation}" modelAttribute="genre">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="${operation}"/></td>
        </tr>
    </table>
</form:form>

<br/>

<b><c:out value="${msg}"/></b>

<c:if test="${not empty errors}">
    <table border="1">
        <c:forEach items="${errors}" var="error">
            <tr>
                <td>${error.code}</td>
                <td>${error.defaultMessage}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>