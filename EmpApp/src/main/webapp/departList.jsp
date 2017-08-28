<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
    <%@ page import="trng.imcs.core.dao.impl.*" %>
     <%@ page import="imcs.core.model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
</head>
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
<% Employee eInfo = (Employee)session.getAttribute("eInfo"); %>
<center style="margin-top:150px"><b>
Employee Info  </b>
</center>
<br>
<table align="center" border="1" style="width:50%" title="List of Courses">
<tr style="text-align:center">
<%
int eid = eInfo.getId();
String eName = eInfo.getName();
String dName= eInfo.getDeptName();
float salary =eInfo.getSalary();

%>
<tr>
<td style="text-align:center">Employee ID
</td>
<td style="text-align:center">
<%= eid %>
</td>
</tr>
<tr>
<td style="text-align:center">Employee Name
</td>
<td style="text-align:center">
<%= eName %>
</td>
</tr>
<tr>
<td style="text-align:center">Employee Department
</td>
<td style="text-align:center">
<%= dName %>
</td>
</tr>
<tr>
<td style="text-align:center">Employee Salary
</td>
<td style="text-align:center">
<%= salary %>
</td>
</tr>



</table>


</body>
</html>