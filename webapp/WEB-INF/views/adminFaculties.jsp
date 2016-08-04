<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<c:set var="faculties" value="${faculties}" scope="request"/>
<c:set var="userResult" value="${user.result}" scope="session"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="faculties" bundle="${bundle }"/></title>
</head>
<body>
<center>
	<h1><fmt:message key="faculties" bundle="${bundle }"/></h1>
	<table>
	<tr>
	<th>
	<fmt:message key="id" bundle="${bundle }"/>
	</th>
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
	</th>
	<th>
	<fmt:message key="capacity" bundle="${bundle }"/>
	</th>
	</tr>
	<c:forEach var="faculty" items="${faculties}">
		<tr>
		<td> <c:out value="${faculty.id }"/> </td>
		<td> <fmt:message key="${faculty.name }" bundle="${bundle }"/> </td>
		<td> <fmt:message key="${faculty.subjectOne }" bundle="${bundle }"/> </td>
		<td> <fmt:message key="${faculty.subjectTwo }" bundle="${bundle }"/> </td>
		<td> <fmt:message key="${faculty.subjectThree }" bundle="${bundle }"/> </td>
		<td align="center"> <c:out value="${faculty.capacity }"/> </td>
		<td>  
			<form>
				<input type="hidden" name="command" value="ADMIN_VIEW_APPLIED_STUDENTS"/>
				<input type="hidden" name="faculty" value="${faculty.id }"/>
				<button type="submit"><fmt:message key="studentsWhoApplied" bundle="${bundle }"/></button>
			</form>
		</td>
		</tr>
	</c:forEach>
	</table>
	<button onclick="location.href = 'adminPanel.jsp'"><fmt:message key="back" bundle="${bundle }"/></button>
</center>
</body>
</html>