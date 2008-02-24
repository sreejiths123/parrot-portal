<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/spring-form" prefix="spring-form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 

<spring-form:form commandName="user">
	<spring-form:errors path="*" />
	<table>
		<tr>
			<td><spring:message code="parrot.portal.label.first_name"/></td>
			<td><spring-form:input id="firstName" path="contact.name.firstName" /></td>
		</tr>
		<tr>
			<td><spring:message code="parrot.portal.label.last_name"/></td>
			<td><spring-form:input id="lastName" path="contact.name.lastName" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="<spring:message code="parrot.portal.label.ok"/>" /></td>
		</tr>
	</table>

</spring-form:form>