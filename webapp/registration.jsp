<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="logPassError" value="${empty logPassError ? false : requestScope.logPassError}" scope="request"/>
<c:set var="loginTaken" value="${empty loginTaken ? false : requestScope.loginTaken}" scope="request"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="registration" bundle="${bundle}"/></title>
</head>
<body>
<center>
<h1><fmt:message key="registration" bundle="${bundle }"/></h1>
<form action="./Controller">
<input type="hidden" name="command" value="REGISTER_USER"/>
	<table>
	<c:if test="${loginTaken eq true }"><td>
			<font color="red"><fmt:message key="loginNotAvailable" bundle="${bundle}"/></font><br></td>
	</c:if>
	<c:if test="${logPassError eq true }"><td>
			<font color="red"><fmt:message key="requiredFieldsError" bundle="${bundle}"/></font><br></td>
	</c:if>
	<tr>
	<td><fmt:message key="login" bundle="${bundle}"/> : </td>
	<td><input type="text" name="login"/></td>
	</tr>
	<tr>
	<td><fmt:message key="password" bundle="${bundle}"/> : </td>
	<td><input type="password" name="password"/></td>
	</tr>
	<tr>
	<td><fmt:message key="name" bundle="${bundle}"/> : </td>
	<td><input type="text" name="name"/></td>
	</tr>
	<tr>
	<td><fmt:message key="secondName" bundle="${bundle}"/> : </td>
	<td><input type="text" name="secondName"/></td>
	</tr>
	<tr>
	<td><fmt:message key="thirdName" bundle="${bundle}"/> : </td>
	<td><input type="text" name="thirdName"/></td>
	</tr>
	<tr><td>
	<input type="submit" value="<fmt:message key="submit" bundle="${bundle}"/>"/>
	</td>
	</tr>
	</table>
	</form>
	<button onclick="location.href = 'index.jsp'"><fmt:message key="back" bundle="${bundle }"/></button><br>
	</center>
</body>
</html>