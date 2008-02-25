<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/spring-form" prefix="spring-form" %>
<%@ taglib uri="/parrot" prefix="parrot" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<table>
	<tr>
		<th><spring:message code="parrot.portal.label.id"/></th>
		<th><spring:message code="parrot.portal.label.role_name"/></th>
	</tr>

<parrot:collection collection="${list}" />

<c:forEach items="${list}" var="user">

	<tr>
		<td><c:out value="${user.id}"/></td>
  		<td><c:out value="${user.contact.name.firstName}"/></td>
  		<td><c:out value="${user.contact.name.lastName}"/></td>
	</tr>  

</c:forEach>

</table>