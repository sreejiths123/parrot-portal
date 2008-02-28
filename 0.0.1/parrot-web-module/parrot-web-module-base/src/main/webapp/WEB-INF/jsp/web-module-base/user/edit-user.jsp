<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/spring-form" prefix="spring-form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/parrot" prefix="parrot" %>

<spring-form:form commandName="user" action="?">
	<input type="hidden" name="type" value="EDIT" />
	
	<spring-form:errors path="*" />
	<table class="content" cellpadding="2" cellspacing="0">
		<tr>
			<th colspan="3">
				<spring:message code="parrot.portal.label.basic_information"/>
			</th>
		</tr>
		<tr>
			<td><spring:message code="parrot.portal.label.first_name"/></td>
			<td><spring-form:input id="firstName" path="object.contact.name.firstName" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="parrot.portal.label.last_name"/></td>
			<td><spring-form:input id="lastName" path="object.contact.name.lastName" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="parrot.portal.label.user.login"/></td>
			<td>TODO</td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="parrot.portal.label.password"/></td>
			<td>TODO</td>
			<td></td>
		</tr>

		<tr>
			<td><spring:message code="parrot.portal.label.password_again"/></td>
			<td></td>
			<td></td>
		</tr>
		
		<tr>
			<td><spring:message code="parrot.portal.label.email"/></td>
			<td><spring-form:input id="email" path="object.contact.email" /></td>
			<td></td>
		</tr>
		
		<tr>
			<td><spring:message code="parrot.portal.label.telephone"/></td>
			<td><spring-form:input id="localNumber" path="object.contact.telephone.localNumber" /></td>
			<td></td>
		</tr>

		<tr>
			<th colspan="3"><spring:message code="parrot.portal.label.address"/></th>
		</tr>
		<tr>
			<td><spring:message code="parrot.portal.label.address.street"/></td>
			<td><spring-form:input id="streetName" path="object.contact.address.streetName" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="parrot.portal.label.address.city"/></td>
			<td><spring-form:input id="city" path="object.contact.address.city" /></td>
			<td></td>
		</tr>

		<tr>
			<td><spring:message code="parrot.portal.label.address.area_code"/></td>
			<td><spring-form:input id="areaCode" path="object.contact.address.areaCode" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="parrot.portal.label.address.region"/></td>
			<td><spring-form:input id="region" path="object.contact.address.region" /></td>
			<td></td>
		</tr>
		<tr>
			<th colspan="3"><spring:message code="parrot.portal.label.user.role_list"/></th>
		</tr>
		<c:forEach items="${user.object.roles}" var="role">
		<tr>
			<td>${role.id}</td>
			<td>${role.name}</td>
		</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td><input type="submit" value="<spring:message code="parrot.portal.label.save"/>" /></td>
			<td></td>
		</tr>
	</table>
</spring-form:form>