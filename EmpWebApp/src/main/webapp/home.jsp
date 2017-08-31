<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style>
.row.content {
	height: 1400px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Employee Application</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a id="a1" class="btn btn-primary">Employee Details</a>
				</p>
				<p>
					<a id="a2" class="btn btn-primary">Department Details</a>
				</p>
			</div>
			<div class="col-sm-8 text-left">
				<div id="msg">
					<br> <br>
					<c:if test="${not empty requestScope.msg}">${requestScope.msg}</c:if>
				</div>
				<div id="EmpInDept">
					<c:if test="${not empty requestScope.empList}"><jsp:directive.include
							file="EmpInDept.jsp" /></c:if>
				</div>
				<div id="update">
					<c:if test="${not empty requestScope.emp}"><jsp:directive.include
							file="update.jsp" /></c:if>
				</div>
				<div id="empInfo">
					<c:if test="${not empty requestScope.eInfo}"><jsp:directive.include
							file="empInfo.jsp" /></c:if>
				</div>

				<br> <a id="p1" style="display: none"> <input id="D1"
					type="submit" class="btn btn-info" value="ADD"> <input
					id="D2" type="submit" class="btn btn-info" value="UPDATE">
					<input id="D3" type="submit" class="btn btn-info" value="DELETE">
					<input id="D4" type="submit" class="btn btn-info" value="SEARCH">
				</a>
				<form action="/EmpWebApp/DepartmentServlet" id="p2"
					style="display: none" method="get">
					<tr>
						<th>Department ID</th>
						<td><input class="requiredAttr" name="deptId" id="deptId"
							placeholder="Enter Dpt ID" type="number" required></td>
						<td><input type="submit" class="btn btn-info" value="Submit"></td>
					</tr>
				</form>



				<form action="/EmpWebApp/employee" id="p3" style="display: none"
					method="post">
					<div class="container">

						<table class="table table-hover">
							<br>

							<tr>
								<th>Name</th>
								<td><input class="requiredAttr" name="ename" id="ename"
									type="text" required></td>
							</tr>

							<tr>
								<th>Age</th>
								<td><input class="requiredAttr" name="age" id="age"
									type="number" value="" required></td>
							</tr>
							<tr>
								<th>DOB</th>
								<td><input class="requiredAttr" id="pwd2" type="date"
									name="dob" id="dob" value="" required></td>
							</tr>

							<tr>
								<th>DOJ</th>
								<td><input class="requiredAttr" id="inp1" type="date"
									name="doj" id="doj" required></td>
							</tr>

							<tr>
								<th>Salary</th>
								<td><input class="requiredAttr" id="inp1" type="number"
									name="salary" id="salary" required></td>
							</tr>
							<tr>
								<th>Salary Grade</th>
								<td><select class="requiredAttr" id="inp2" type="number"
									name="salarygrade" id="salarygrade">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
								</select></td>
								</td>
							</tr>

							<tr>
								<th>Dept ID</th>
								<td><select class="requiredAttr" id="inp2" type="number"
									name="deptid" id="deptid">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
								</select></td>
							</tr>
							<tr>
								<th>Dept Name</th>
								<td><select class="requiredAttr" id="inp2" type="text"
									name="deptname" id="deptname">
										<option value="development" selected="selected">1-Development</option>
										<option value="account">2-Account</option>
										<option value="sales">3-Sales</option>
										<option value="hr">4-HR</option>
								</select></td>
							</tr>
							<tr>
								<td><input id="AU" type="submit" class="btn btn-info"
									value="Add User"></td>
							</tr>
						</table>
					</div>
				</form>



				<form action="/EmpWebApp/updateEmployee" id="p4"
					style="display: none" method="get">
					<br>
					<tr>
						<th>Employee ID</th>
						<td><input class="requiredAttr" name="uempId" id="uempId"
							placeholder="Enter Emp ID to Update Record" type="number"
							required></td>
						<td><input type="submit" class="btn btn-info" value="Submit"></td>
					</tr>
				</form>

				<form action="/EmpWebApp/DeleteEmployeeServlet" id="p5"
					style="display: none" method="post">
					<br>
					<tr>
						<th>Employee ID</th>
						<td><input class="requiredAttr" name="deleteEmpId"
							id="deleteEmpId" placeholder="Enter Emp ID to Delete"
							type="number" required><span id="error_msg0"
							style="color: red"></span></td>
						<td><input type="submit" class="btn btn-info" value="Submit"></td>
					</tr>
				</form>

				<form action="/EmpWebApp/employee" id="p6" style="display: none"
					method="get">
					<br>
					<tr>
						<th>Employee ID</th>
						<td><input class="requiredAttr" name="eSearch" id="eSearch"
							placeholder="Enter Emp ID to get Info" type="number" required><span
							id="error_msg0" style="color: red"></span></td>
						<td><input id="eSearch1" type="submit" class="btn btn-info"
							value="Submit"></td>
					</tr>
				</form>



			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
	</div>



</body>
<script>
	$(document).ready(function() {
		$("#a1").click(function() {
			$("#p1").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#a2").click(function() {
			$("#p2").show();
			$("#p1").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#D1").click(function() {
			$("#p1").show();
			$("#p3").show();
			$("#p2").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#p41").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#D2").click(function() {
			$("#p1").show();
			$("#p4").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#p41").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#D3").click(function() {
			$("#p5").show();
			$("#p1").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p6").hide();
			$("#p41").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#D4").click(function() {
			$("#p6").show();
			$("#p1").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p41").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();
		});

		$("#DS").click(function() {
			$("#p41").show();
			$("#p1").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();
		});

	});
</script>
</html>