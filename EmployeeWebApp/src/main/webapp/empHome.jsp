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
			<a class="navbar-brand" href="empHome.jsp">Employee Application</a>
		</div>
		<form action="/EmployeeWebApp/loginServlet" method="post">
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><button type="submit">Logout</button></li>

				</ul>
			</div>
		</form>

	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-8 text-left">
				<br>




				<div class="container">
					<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="bootstrap-overridden.css" />
					</head>
					<body>
						<div class="container container-small">
							
							<div class="form-group">
								<form action="home.jsp">
									<button type="submit" class="btn btn-primary">Employee Details</button>
								</form>
							</div>
							<div class="form-group">
								<form action="department.jsp">
									<button type="submit" class="btn btn-primary"
										>Department Details</button>
								</form>
							</div>
						</div>
					</body>


				</div>

			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
</body>

<script>
	$(document).ready(function() {
		$("#add").click(function() {
			$("#addform").show();
			$("#eInfo").hide();
			$("#msg").hide();
		});

		$("#search").click(function() {
			$("#addform").hide();
			$("#eInfo").hide();
			$("#msg").hide();
		});

		$("#adduser").click(function() {
			$("#save").hide()
			$("#updatediv").hide()
			$("#deletediv").hide()
			$("#msg").hide();

		});
	});
</script>
<!-- <script>
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
</script> -->
</html>