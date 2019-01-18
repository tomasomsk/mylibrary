<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>Enter The Book Details</h3>

<table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td><form:label path="pubYear">Publication Year</form:label></td>
        <td><form:input path="pubYear" placeholder="YYYY"/></td>
    </tr>
    <tr>
        <td><form:label path="genre.name">Genre</form:label></td>
        <td><form:select items="${requestScope.genres}" path="genre.name"/></td>
    </tr>
</table>