<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/spring-form" prefix="spring-form" %>
<%@ taglib uri="/parrot" prefix="parrot" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<a href="<c:url value="/add-role.html" />">add role</a>

<table>
	<tr>
		<th><spring:message code="parrot.portal.label.id"/></th>
		<th><spring:message code="parrot.portal.label.role_name"/></th>
	</tr>

<parrot:collection collection="${list}" />

<c:forEach items="${list}" var="role" varStatus="status">

	<tr>
		<td><c:out value="${role.id}"/></td>
  		<td><c:out value="${role.name}"/></td>
  		 
  		<td>
	  		<parrot:link type="SHOW_EDIT" idInCollection="${status.index}">
  				<parrot:text><spring:message code="parrot.portal.label.edit" /></parrot:text>
  				<parrot:url><c:url value="/modify-role.html" /></parrot:url>
  			</parrot:link>
  		</td>
  		<td>
	  		<parrot:link type="REMOVE" idInCollection="${status.index}">
  				<parrot:text><spring:message code="parrot.portal.label.delete" /></parrot:text>
  				<parrot:url><c:url value="/modify-role.html" /></parrot:url>
  			</parrot:link>
  		</td>
	</tr>  

</c:forEach>

</table>
 