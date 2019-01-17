<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Enter The Author Details</h3>

    <table>
        <tr>
            <td><form:label path="second_Name">Second Name</form:label></td>
            <td><form:input path="second_Name"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="third_Name">Third Name</form:label></td>
            <td><form:input path="third_Name"/></td>
        </tr>
        <tr>
            <td><form:label path="birth_Year">Birth Year</form:label></td>
            <td><form:input path="birth_Year" placeholder = "YYYY"/></td>
        </tr>
        <tr>
            <td><form:label path="biography">Biography</form:label></td>
            <td><form:textarea rows="15" cols="90" path="biography"/></td>
        </tr>
    </table>