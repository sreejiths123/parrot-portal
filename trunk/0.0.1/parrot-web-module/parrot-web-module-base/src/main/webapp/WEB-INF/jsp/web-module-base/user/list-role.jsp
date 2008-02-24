<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/spring-form" prefix="spring-form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<table>
	<tr>
		<th><spring:message code="parrot.portal.label.id"/></th>
		<th><spring:message code="parrot.portal.label.role_name"/></th>
	</tr>

<c:forEach items="${list}" var="role">

	<tr>
		<td><c:out value="${role.id}"/></td>
  		<td><c:out value="${role.name}"/></td>
	</tr>  

</c:forEach>

</table>
 