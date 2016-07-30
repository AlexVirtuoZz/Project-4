<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="userControlPanel" bundle="${bundle }"/></title>
</head>
<body>
	<center>
		<h2><fmt:message key="userControlPanel" bundle="${bundle }"/></h2><br>
		
		<button onclick="location.href = 'userInfo.jsp'"><fmt:message key="editInfo" bundle="${bundle }"/></button><br>
		<button onclick="location.href = 'userApplications.jsp'"><fmt:message key="editApplications" bundle="${bundle }"/></button><br>
		<button onclick="location.href = 'userResults.jsp'"><fmt:message key="editResults" bundle="${bundle }"/></button><br>
		
	</center>
</body>
</html>