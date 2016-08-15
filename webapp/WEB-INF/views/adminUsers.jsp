<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="users" value="${users}" scope="request"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="users" bundle="${bundle }"/></title>
</head>
<body>
<center>
	<h1><fmt:message key="users" bundle="${bundle }"/></h1>
	<table>
	<thead>
		<tr>
			<th>
				<fmt:message key="id" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="name" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="secondName" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="thirdName" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="login" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="admin" bundle="${bundle }"/>
			</th>
		</tr>
	</thead>
		<c:forEach var="user" items="${users}">
			<tr>
				<td align="center"> <c:out value="${user.id}"/> </td>
				<td> <c:out value="${user.name}"/> </td>
				<td> <c:out value="${user.secondName}"/> </td>
				<td> <c:out value="${user.thirdName}"/> </td>
				<td> <c:out value="${user.login }"/></td>
				<td> <c:choose>
				<c:when test="${user.admin eq true }">
					<fmt:message key="true" bundle="${bundle }"/>
				</c:when>
				<c:when test="${user.admin eq false }">
					<fmt:message key="false" bundle="${bundle }"/>
				</c:when>
				</c:choose>
				</td>
				<td>
				<form>
					<input type="hidden" name="command" value="ADMIN_SET_ADMIN"/>
					<input type="hidden" name="id" value="${user.id }"/>
					<c:choose>
						<c:when test="${user.admin eq true }">
							<input type="hidden" name="accept" value="false"/>
							<button type="submit"><fmt:message key="cancelAdmin" bundle="${bundle }"/></button>
						</c:when>
						<c:when test="${user.admin eq false }">
							<input type="hidden" name="accept" value="true"/>
							<button type="submit"><fmt:message key="setAdmin" bundle="${bundle }"/></button>
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