<%@page import="entities.faculty.Faculty"%>
<%@page import="entities.University"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="faculties" value="${requestScope.faculties}" scope="request"/>
<c:set var="lang" value="${empty lang ? 'en_US' : sessionScope.lang}"
	scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="localization/messages" var="bundle" />
<c:set var="faculty" value="${requestScope.faculty}"
	scope="request" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
<title>Selection Committee</title>
</head>
<body>
	<center>
		<h2>
			Hello, dear enrollee! <br>Choose where are you going to pass and
			fill the form
		</h2>
		<form action="Controller">
			<input type="hidden" name="command" value="CHOOSE_FACULTY" />
			<table>
				<tr>
					<td>Faculty:</td>
					<td>
						<select name="chosenFaculty">
							<c:forEach var="chosenFaculty" items="${faculties}">
								<option value="${chosenFaculty.name}">${chosenFaculty.name}</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<button type="submit"><fmt:message key="submit" bundle="${bundle}"/></button>
					</td>
				</tr>
			</table>
		</form>
		<form>
			<table>
				<tr>
					<td>${faculty.subjectOne}</td>
					<td><input type="text" name="subjectOne" /></td>
				</tr>
				<tr>
					<td>${faculty.subjectTwo }</td>
					<td><input type="text" name="subjectTwo" /></td>
				</tr>
				<tr>
					<td>${faculty.subjectThree}</td>
					<td><input type="text" name="subjectThree" /></td>
				</tr>
					<tr>
					<td align="center" colspan="2"><button type="submit">Continue</button></td>
				</tr>	
			</table>
		</form>
	</center>
</body>
</html>