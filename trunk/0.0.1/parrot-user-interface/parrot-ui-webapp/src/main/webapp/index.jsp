<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="/spring" %>
<%@ taglib prefix="spring-form" uri="/spring-form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
<title>Example :: Spring Application</title>
</head>
<body>
<h1>Example - Spring Application</h1>
<p>This is my new test.</p>

<spring-form:form commandName="contact">
<spring-form:errors path="*" />
<table>
	<tr>
		<td>ID:</td>
		<td><spring-form:input id="id" path="id" /></td>
	</tr>
	<tr>
		<td>First Name:</td>
		<td><spring-form:input id="firstName" path="name.firstName" /></td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td><spring-form:input id="firstName" path="name.lastName" /></td>
	</tr>
	<tr>
		<td><input type="submit" /></td>
	</tr>
</table>

</spring-form:form>


</body>
</html>