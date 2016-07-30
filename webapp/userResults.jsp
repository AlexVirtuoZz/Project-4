<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="user" value="${sessionScope.user}" scope="session"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<c:set var="subjects" value="${subjects}" scope="application"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="editInfo" bundle="${bundle}"/></title>
</head>
<body>
<center>
<form action="Controller">
<input type="hidden" name="command" value="EDIT_USER_RESULTS"/>
<table>
	<c:forEach var="sub" items="${subjects}">
		<tr>
		<td>
		<c:out value="${sub.name}"/>
		</td>
		<td>
		<input type="text" name="${sub.name}"/>
		</td>
		</tr>
	</c:forEach>
</table>
<input type="submit" value="<fmt:message key="submit" bundle="${bundle }"/>"> 
</form>
</center>
</body>
</html>