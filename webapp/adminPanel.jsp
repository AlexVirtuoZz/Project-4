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
<title><fmt:message key="adminControlPanel" bundle="${bundle }"/></title>
</head>
<body>
<center>
	<h1><fmt:message key="adminControlPanel" bundle="${bundle }"/></h1><br>
	<%-- <p>
		<form action = "Controller">
		<input type = "hidden" name = "command" value="ADMIN_EDIT_USERS"/>
		<button type="submit"><fmt:message key="editUsers" bundle = "${bundle}"/></button>
		</form>
	</p> --%>
	<p>
		<form action = "Controller">
		<input type = "hidden" name = "command" value="ADMIN_VIEW_APPLICATIONS"/>
		<button type="submit"><fmt:message key="editApplications" bundle = "${bundle}"/></button>
		</form>
	</p>
	<p>
		<form action = "Controller">
		<input type = "hidden" name = "command" value="ADMIN_VIEW_FACULTIES"/>
		<button type="submit"><fmt:message key="viewFaculties" bundle = "${bundle}"/></button>
		</form>
	</p>
	<p>
		<form action="Controller" method="POST">
			<input type="hidden" name="command" value="QUIT"/>
			<button type="submit"><fmt:message key="quit" bundle="${bundle }"/></button>
		</form>	
	</p>
</center>
</body>
</html>