<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="theme.css">

</head>

<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home.jsp">Home</a>
		</div>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="signup.html"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="login.html"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>
	</div>
	</nav>


	<form id="myForm" action="/EmpApp/employee" method="get">
		<div class="container">

			<table class="table table-hover" width=70%>
				<tr>
					<th>Department ID</th>
					<td><input class="requiredAttr" name="deptId" id="deptId"
						type="number" required></td>
					<td><input id="D6" type="submit" class="btn btn-info"
						value="Select"></td>
				</tr>
			</table>
			<br> <br>
	</form>


</body>

<script src="myscripts.js"></script>