<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="/spring" %>
<%@ taglib prefix="spring-form" uri="/spring-form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<table>
	<tr>
		<th>Author</th>
		<th>Headline</th>
		<th>Content</th>
	</tr>

	<c:forEach items = "${newsCollection}" var="news">	
		<tr>
			<td><c:out value="${news.author.name.firstName}" /> <c:out value="${news.author.name.lastName}" /></td>
			<td><c:out value="${news.headline}" /></td>
			<td><c:out value="${news.content}" /></td>
		</tr>
	</c:forEach>

</table>
