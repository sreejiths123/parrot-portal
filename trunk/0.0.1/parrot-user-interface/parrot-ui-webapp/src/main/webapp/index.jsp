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


<form method="post">

<spring:nestedPath path="contact">
<table>
	<tr>
		<td>ID:</td>
		<td>
		<spring:bind path="id">
			<input type="text" name="id" value="<c:out value="${status.value}"/>" />
		</spring:bind>
		</td>
	</tr>
	<spring:nestedPath path="name">
	<tr>
		<td>First Name:</td>
		<td>
		
			<spring:bind path="firstName">
				<input type="text" name="firstName" value="<c:out value="${status.value}"/>" />
			</spring:bind>	
		</td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td>
			<spring:bind path="lastName">
				<input type="text" name="lastName" value="<c:out value="${status.value}"/>" />
			</spring:bind>
		</td>
	</tr>
	</spring:nestedPath>
	<tr>
		<td><input type="submit" /></td>
	</tr>
</table>
</spring:nestedPath>
</form>
</body>
</html>