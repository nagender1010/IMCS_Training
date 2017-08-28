<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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


<title>Insert title here</title>
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


	<table class="table table-hover" align="center" width="400">

		<tr>
			<th>Employee Info</th>
			<td>
				<form action="/EmpApp/employeeinfo.jsp">
					<input id="D6" type="submit" class="btn btn-info" value="Select">
				</form>
			</td>
		</tr>
		<tr>
			<th>All Employees in a given Dept</th>
			<td>
				<form action="/EmpApp/employeeinfodeptwise.jsp">
					<input id="D6" type="submit" class="btn btn-info" value="Select">
				</form>
			</td>
		</tr>

	</table>
</body>

<script src="myscripts.js"></script>
</html>