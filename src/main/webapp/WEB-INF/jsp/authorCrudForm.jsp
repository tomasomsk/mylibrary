<%@ include file="header.jsp" %>
<h3>Enter The Author Details</h3>

    <table>
        <tr>
            <td><form:label path="secondName">Second Name</form:label></td>
            <td><form:input path="secondName"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="thirdName">Third Name</form:label></td>
            <td><form:input path="thirdName"/></td>
        </tr>
        <tr>
            <td><form:label path="birthYear">Birth Year</form:label></td>
            <td><form:input path="birthYear" placeholder = "YYYY"/></td>
        </tr>
        <tr>
            <td><form:label path="biography">Biography</form:label></td>
            <td><form:textarea rows="15" cols="90" path="biography"/></td>
        </tr>
    </table>