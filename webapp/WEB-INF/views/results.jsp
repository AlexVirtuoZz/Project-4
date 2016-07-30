<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selection Committee</title>
</head>
<body>
	<center>Please, enter results of your exams<br>
	
	<form action="Controller">
	<input type="hidden" name="command" value="REGISTER_USER"/>
		<table>
		<tr><td>
		${sessionScope.faculty.subjectOne}
		</td></tr>
		<tr><td>
		${sessionScope.faculty.subjectTwo}
		</td></tr>
		<tr><td>
		${sessionScope.faculty.subjectThree}
		</td></tr>
		</table>
	</form>
	</center>
</body>
</html>