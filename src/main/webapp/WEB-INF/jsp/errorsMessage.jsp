<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<b>Ups. There was some errors</b>

<table border="1">
    <c:forEach items="${errors}" var="error">
        <tr>
            <td>${error.code}</td>
            <td>${error.defaultMessage}</td>
        </tr>
    </c:forEach>
</table>