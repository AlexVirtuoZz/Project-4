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
			<td>
				faculty
			</td>
			<td>
				result
			</td>
			<td>
				accepted
			</td>
		</tr>
		<c:forEach var="app" items="${applications.entrySet()}">
			<tr>
				<td> <c:out value="${app.getKey()}"/> </td>
				<td> <c:out value="${app.getValue().result}"/> </td>
				<td> <c:out value="${app.getValue().accepted}"/> </td>
			</tr>
			</c:forEach>	
		</table>		
		<br>
		<c:if test="${markNullError eq true }">
			<font color="red">You cannot apply for  this faculty</font>
		</c:if>
		<form action="Controller">
			<input type="hidden" name="command" value="USER_APPLY"/>		
			apply on<br>
			<select name="faculty">
				<c:forEach var="faculty" items="${faculties}">
					<option value="${faculty.name}">${faculty.name }</option>
				</c:forEach>
			</select>
			<button type="submit"><fmt:message key="submit" bundle="${bundle }"/></button>
		</form><br>
		<button onclick="location.href = 'userPanel.jsp'"><fmt:message key="back" bundle="${bundle }"/></button><br>
	</center>
</body>
</html>