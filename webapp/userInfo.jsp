<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="user" value="${sessionScope.user}" scope="session"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="editInfo" bundle="${bundle}"/></title>
</head>
<body>
<center>
<form action="Controller">
<input type="hidden" name="command" value="EDIT_USER_INFO"/>
	<table>
	<tr>
	<td><fmt:message key="name" bundle="${bundle}"/></td>
	<td><input type="text" name="name" value="${user.name}"/></td>
	</tr>
	<tr>
	<td><fmt:message key="secondName" bundle="${bundle}"/></td>
	<td><input type="text" name="secondName" value="${user.secondName}"/></td>
	</tr>
	<tr>
	<td><fmt:message key="thirdName" bundle="${bundle}"/></td>
	<td><input type="text" name="thirdName" value="${user.thirdName}"/></td>
	</tr>
	<tr>
	<td><fmt:message key="login" bundle="${bundle}"/></td>
	<td><input type="text" name="login" value="${user.login }"/></td>
	</tr>
	<tr>
	<td><fmt:message key="password" bundle="${bundle}"/></td>
	<td><input type="password" name="password" value="${user.password }"/></td>
	</tr>
	<tr><td>
	<input type="submit" value="<fmt:message key="submit" bundle="${bundle}"/>"/>
	</td>
	<td>
	</td>
	</tr>
	</table>
	</form>
		<button onclick="location.href = 'userPanel.jsp'"><fmt:message key="back" bundle="${bundle }"/></button>
	
	<br>
	</center>
</body>
</html>