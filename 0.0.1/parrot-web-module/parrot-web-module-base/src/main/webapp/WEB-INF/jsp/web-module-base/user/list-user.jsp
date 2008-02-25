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

<c:forEach items="${list}" var="user" varStatus="status">

	<tr>
		<td><c:out value="${user.id}"/></td>
  		<td><c:out value="${user.contact.name.firstName}"/></td>
  		<td><c:out value="${user.contact.name.lastName}"/></td>
  		<td>
	  		<parrot:link type="SHOW_EDIT" idInCollection="${status.index}">
  				<parrot:text><spring:message code="parrot.portal.label.edit" /></parrot:text>
  				<parrot:url><c:url value="/modify-user.html" /></parrot:url>
  			</parrot:link>
  		</td>
  		<td>
	  		<parrot:link type="REMOVE" idInCollection="${status.index}">
  				<parrot:text><spring:message code="parrot.portal.label.delete" /></parrot:text>
  				<parrot:url><c:url value="/modify-user.html" /></parrot:url>
  			</parrot:link>
  		</td>
	</tr>  

</c:forEach>

</table>