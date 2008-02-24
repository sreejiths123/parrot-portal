<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/spring-form" prefix="spring-form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 

<spring-form:form commandName="role">
	<spring-form:errors path="*" />
	<table>
		<tr>
			<td><spring:message code="parrot.portal.label.role_name"/></td>
			<td><spring-form:input id="name" path="name" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="<spring:message code="parrot.portal.label.ok"/>" /></td>
		</tr>
	</table>

</spring-form:form>