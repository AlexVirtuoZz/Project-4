<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="faculties" value="${faculties}" scope="request"/>
<c:set var="applications" value="${applications}" scope="session"/>
<c:set var="user" value="${user}" scope="session"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<c:set var="markNullError" value="${empty markNullError ? false : requestScope.markNullError}" scope="request" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="applications" bundle="${bundle}"/></title>
</head>
<body>
	<center>
		<h1><fmt:message key="myApplications" bundle="${bundle}"/></h1><br>
		<table>
		<tr>
			<th>
				<fmt:message key="facName" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="result" bundle="${bundle }"/>
			</th>
			<th>
				<fmt:message key="accepted" bundle="${bundle }"/>
			</th>
		</tr>
		<c:forEach var="app" items="${applications.entrySet()}">
			<tr>
				<td> <fmt:message key="${app.key}" bundle="${bundle }"/> </td>
				<td> <c:out value="${app.value.result}"/> </td>
				<td> <fmt:message key="${app.value.accepted}" bundle="${bundle }"/> </td>
			</tr>
			</c:forEach>	
		</table>		
		<br>
		<c:if test="${markNullError eq true }">
			<font color="red"><fmt:message key="markNullError" bundle="${bundle }"/></font>
		</c:if>
		<form action="Controller">
			<input type="hidden" name="command" value="USER_APPLY"/>		
			<fmt:message key="applyOn" bundle="${bundle }"/><br>
			<select name="faculty">
				<c:forEach var="faculty" items="${faculties}">
					<option value="${faculty.name}"><fmt:message key="${faculty.name}" bundle="${bundle }"/></option>
				</c:forEach>
			</select>
			<button type="submit"><fmt:message key="submit" bundle="${bundle }"/></button>
		</form><br>
		<button onclick="location.href = 'userPanel.jsp'"><fmt:message key="back" bundle="${bundle }"/></button><br>
		<h3>*<fmt:message key="info" bundle="${bundle }"/></h3><br>
		<table>
		<tr>
		<th>
		<fmt:message key="facName" bundle="${bundle }"/>
		</th>
		<th>
		<fmt:message key="subjectOne" bundle="${bundle }"/>
		</th>
		<th>
		<fmt:message key="subjectTwo" bundle="${bundle }"/>
		</th>
		<th>
		<fmt:message key="subjectThree" bundle="${bundle }"/>
		</th></tr>
		<c:forEach var="faculty" items="${faculties}">
		<tr>
					<td> <fmt:message key="${faculty.name}" bundle="${bundle }"/> </td>
					<td> <fmt:message key="${faculty.subjectOne}" bundle="${bundle }"/> </td>
					<td> <fmt:message key="${faculty.subjectTwo}" bundle="${bundle }"/> </td>
					<td> <fmt:message key="${faculty.subjectThree}" bundle="${bundle }"/> </td>
		</tr>
		</c:forEach>
		</table>
	</center>
</body>
</html>