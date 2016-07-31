<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}" scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<c:set var="verificationError" value="${empty verificationError ? false : requestScope.verificationError}" scope="request" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="selectionCommittee" bundle="${bundle}" /></title>
</head>
<body>

	<form action="Controller">
		<input type="hidden" name="command" value="CHOOSE_LANGUAGE" /> <select
			name="chosenLanguage">
			<option value="ENG">ENG</option>
			<option value="UKR">UKR</option>
		</select>
		<table>
			<tr>
				<td colspan=2 align="center"><br> <input type="submit"
					value=<fmt:message key="select" bundle="${bundle}" />></td>
			</tr>
		</table>
	</form>

	<center>
		<h1>
			<fmt:message key="enterLoginPassword" bundle="${bundle}" />
		</h1>

		<br>
		
		<form action="Controller" method="POST">
			<input type="hidden" name="command" value="VERIFY_ACCOUNT" />
			<c:if test="${verificationError eq true }">
				<font color="red"><fmt:message key="logPassError" bundle="${bundle}"/><br><br></font>
			</c:if>
			<fmt:message key="login" bundle="${bundle}"/><input type="text" name="login" />
			<fmt:message key="password" bundle="${bundle}"/><input type="password" name="password" />
			 <br> <br>
			<button type="submit"><fmt:message key="signIn" bundle="${bundle}"/></button>
		</form>
		<br>
		<button onclick="location.href = 'registration.jsp'"><fmt:message key="registration" bundle="${bundle }"/></button>
		<br>
	</center>
</body>
</html>