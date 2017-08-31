<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="imcs.core.model.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


	<table class="table table-hover" align="center" border="1"
		style="width: 100%" title="List of Courses">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>DOB</th>
			<th>DOJ</th>
			<th>Salary</th>
			<th>Salary Grade</th>
			<th>Dept ID</th>
			<th>Dept Name</th>
		</tr>



		<td style="text-align: center">${requestScope.eInfo.id}</td>
		<td style="text-align: center">${requestScope.eInfo.name}</td>
		<td style="text-align: center">${requestScope.eInfo.age}</td>
		<td style="text-align: center">${requestScope.eInfo.dateOfBirth}
		</td>
		<td>${requestScope.eInfo.dateOfJoining}</td>
		</td>
		<td>${requestScope.eInfo.salary}</td>
		<td>${requestScope.eInfo.salaryGrade}</td>
		<td>${requestScope.eInfo.deptId}</td>
		<td>${requestScope.eInfo.deptName}</td>

		</tr>
	</table>
</body>
<script>
	
</script>
</html>