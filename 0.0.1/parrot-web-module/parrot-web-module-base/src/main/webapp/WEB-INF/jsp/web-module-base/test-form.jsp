<spring-form:form commandName="contact">
	<spring-form:errors path="*" />
	<table>
		<tr>
			<td>ID:</td>
			<td><spring-form:input id="id" path="id" /></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><spring-form:input id="firstName" path="name.firstName" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><spring-form:input id="firstName" path="name.lastName" /></td>
		</tr>
		<tr>
			<td><input type="submit" /></td>
		</tr>
	</table>

</spring-form:form>