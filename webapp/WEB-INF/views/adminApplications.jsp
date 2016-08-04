<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="applications" value="${applications}" scope="session"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="applications" bundle="${bundle }"/></title>
</head>
<body>
<center>
	<h1><fmt:message key="applications" bundle="${bundle }"/></h1>
	<table>
	<thead>
		<tr>
			<th>
				<fmt:message key="id" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="student" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="faculty" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="result" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="accepted" bundle="${bundle }"/>
			</th>
		</tr>
	</thead>
		<c:forEach var="app" items="${applications}">
			<tr>
				<td> <c:out value="${app.id}"/> </td>
				<td align="center"> <c:out value="${app.userId}"/> </td>
				<td align="center"> <c:out value="${app.facultyId}"/> </td>
				<td> <c:out value="${app.result}"/> </td>
				<td> <fmt:message key="${app.accepted}" bundle="${bundle }"/> </td>
				<td>
				<form>
					<input type="hidden" name="command" value="ACCEPT_APPLICATION"/>
					<input type="hidden" name="application" value="${app.id }"/>
					<c:choose>
						<c:when test="${app.accepted eq true }">
							<button type="submit"><fmt:message key="decline" bundle="${bundle }"/></button>
							<input type="hidden" name="accept" value="false"/>
						</c:when>
						<c:when test="${app.accepted eq false }">
							<input type="hidden" name="accept" value="true"/>
							<button type="submit"><fmt:message key="accept" bundle="${bundle }"/></button>
						</c:when>
					</c:choose>
					
				</form>
				<td>
			</tr>
			</c:forEach>	
		</table><br><br>
				<button onclick="location.href = 'adminPanel.jsp'"><fmt:message key="back" bundle="${bundle }"/></button>
		</center>
</body>
</html>