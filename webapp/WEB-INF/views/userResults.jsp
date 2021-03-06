<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="user" value="${sessionScope.user}" scope="session"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<c:set var="incorrectMarkError" value="${empty incorrectMarkError ? false : requestScope.incorrectMarkError }"
	 scope="request"/>
<c:set var="certificateMarkError" value="${empty certificateMarkError ? false : requestScope.certificateMarkError}" scope="request" />	 
<c:set var="subjects" value="${subjects}" scope="request"/>
<c:set var="userResult" value="${user.result}" scope="session"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="myGrades" bundle="${bundle}"/></title>
</head>
<body>
<center>
<h1><fmt:message key="myGrades" bundle="${bundle}"/></h1>
<form action="Controller">
<input type="hidden" name="command" value="EDIT_USER_RESULTS"/>
<c:choose>
<c:when test="${incorrectMarkError eq true }">
	<font color="red"><fmt:message key="incorrectMarkError" bundle="${bundle }"/></font>
</c:when>
<c:when test="${certificateMarkError eq true }">
	<font color="red"><fmt:message key="certificateMarkError" bundle="${bundle }"/></font>
</c:when>
</c:choose>
<table>
	<c:forEach var="sub" items="${subjects}">
		<tr>
		<td>
		<fmt:message key="${sub}" bundle="${bundle }"/>
		</td>
		<td>
		<input type="text" name="${sub}" value="${userResult.get(sub) }"/>
		</td>
		</tr>
	</c:forEach>
</table>
<input type="submit" value="<fmt:message key="submit" bundle="${bundle }"/>"> 
</form><br>
<button onclick="location.href = 'userPanel.jsp'"><fmt:message key="back" bundle="${bundle }"/></button><br>
</center>
</body>
</html>