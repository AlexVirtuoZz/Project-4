<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="appliedStudents" value="${appliedStudents}" scope="request"/>
<c:set var="faculty" value="${faculty }" scope="request"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="studentsWhoApplied" bundle="${bundle }"/></title>
</head>
<body>
<center>
	<table>
		<tr>
		<td>
		<fmt:message key="id" bundle="${bundle }"/> :
		</td>
		<td>
		${faculty.id}
		</td>
		</tr>
		<tr>
		<td>
		<fmt:message key="facName" bundle="${bundle }"/> :
		</td>
		<td>
		${faculty.name}
		</td>
		</tr>
		<tr>
		<td>
		<fmt:message key="capacity" bundle="${bundle }"/> :
		</td>
		<td>
		${faculty.capacity }
		</td>
		</tr>
		</table>
		</center>
	<form>		
		<center>
		<form action = "Controller">
		<input type = "hidden" name = "command" value="ADMIN_VIEW_FACULTIES"/>
		<button type="submit"><fmt:message key="back" bundle = "${bundle}"/></button>
		</form>
		<h2><fmt:message key="studentsWhoApplied" bundle="${bundle }"/></h2>
		<table cellpadding="5">
		<thead>
		<tr>
			<th> <fmt:message key="name" bundle="${bundle }"/> </th>
			<th> <fmt:message key="secondName" bundle="${bundle }"/> </th>
			<th> <fmt:message key="thirdName" bundle="${bundle }"/> </th>
			<th> <fmt:message key="result" bundle="${bundle }"/> </th>
		</tr>
		</thead>
		<tr>
			<c:if test="${counter < faculty.capacity}">
				<td><font color="blue"><fmt:message key="pass" bundle="${bundle }"/></font></td>
				<c:set var="counter" value="${counter+1 }"/>
			</c:if>
			</tr>
		<c:set var="counter" value="0"/>
		<c:forEach var="appliedStudent" items="${appliedStudents.entrySet()}">
			<tr>
			<td> <c:out value="${appliedStudent.getKey().name}"/> </td>
			<td> <c:out value="${appliedStudent.getKey().secondName}"/> </td>
			<td> <c:out value="${appliedStudent.getKey().thirdName}"/> </td>
			<td> <c:out value="${appliedStudent.getValue()}"/> </td>
			<c:if test="${counter < faculty.capacity}">
				<td><font color="blue"><fmt:message key="pass" bundle="${bundle }"/></font></td>
				<c:set var="counter" value="${counter+1 }"/>
			</c:if>
			</tr>
		</c:forEach>
	</table>
	
	</center>
</form>
</body>
</html>