<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/spring-form" prefix="spring-form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring-form:form commandName="roleCommand" action="?">
	<input type="hidden" name="type" value="EDIT" />
	<spring-form:errors path="*" />
	<table>
		<tr>
			<td><spring:message code="parrot.portal.label.role_name"/></td>
			<td><spring-form:input id="name" path="command.name" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="<spring:message code="parrot.portal.label.save"/>" /></td>
		</tr>
	</table>

</spring-form:form>