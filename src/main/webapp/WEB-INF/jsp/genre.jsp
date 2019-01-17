<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Genre</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<b>Genre</b>

<jsp:include page="mainMenu.jsp" />

<br/>
<br/>

<table border="0" style="width:600px">
    <tr>
        <td><b>Name</b></td>
    </tr>
    <tr>
        <td> ${genre.name} </td>
    </tr>
</table>
</body>
</html>