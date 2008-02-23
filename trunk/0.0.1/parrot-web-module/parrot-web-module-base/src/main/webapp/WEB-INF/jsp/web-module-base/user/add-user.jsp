<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/spring-form" prefix="spring-form" %>

<spring-form:form commandName="user">
	<spring-form:errors path="*" />
	<table>
		<tr>
			<td>First Name:</td>
			<td><spring-form:input id="firstName" path="contact.name.firstName" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><spring-form:input id="lastName" path="contact.name.lastName" /></td>
		</tr>
		<tr>
			<td><input type="submit" /></td>
		</tr>
	</table>

</spring-form:form>