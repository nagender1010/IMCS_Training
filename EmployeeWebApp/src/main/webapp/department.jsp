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
				<div class="row">
					<div class="col-sm-6">

						<form action="/EmployeeWebApp/department" id="search" method="get">
							<tr>
								<th>Department ID</th>
								<td><input class="requiredAttr" name="dSearch" id="dSearch"
									placeholder="Enter Dept ID to get Info" type="number" required></td>
								<td><input id="eSearch1" type="submit" class="btn btn-info"
									value="Submit"></td>
							</tr>
						</form>
					</div>

					<!-- <div class="col-sm-6">
						<tr><input id="add" type="submit" class="btn btn-info" value="ADD"></tr>
					
					</div> -->

				</div>

				<br>
				<div id="msg">
					<c:if test="${not empty requestScope.msg}">${requestScope.msg}</c:if>
				</div>



				<c:if test="${not empty requestScope.deptInfo}">

					<div id="ddInfo">

						<form>

							<table class="table table-hover" style="width: 75%"
								align="center">
								<tr>
									<th>ID</th>
									<td>${requestScope.deptInfo.id}</td>
								</tr>

								<tr>
									<th>Name</th>
									<td>${requestScope.deptInfo.name}</td>
								</tr>
							</table>

						</form>

					</div>
					<div id="viewEmployees">
						<form action="/EmployeeWebApp/department" method="post">
							<table style="width: 75%" align="center">

								<tr style="display: none">
									<th>ID</th>
									<td><input class="requiredAttr" name="departId"
										id="departId" type="text" value="${requestScope.deptInfo.id}"></td>
								</tr>
								<td><input id="empSearch" type="submit"
									class="btn btn-info" value="View Employees"></td>


							</table>

						</form>
					</div>



				</c:if>


				<c:if test="${not empty requestScope.empList}">
				<form id="p5" method="get">
				<input type="hidden" id="eSearch" name="eSearch" /> <input
					type="hidden" id="DeptId" name="DeptId" /> <input type="hidden"
					id="operations" name="operations" />
				
					<div>
						<br>
						<table class="table table-hover" align="center" border="1"
							style="width: 50%">
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
								<th></th>
							</tr>

							<c:forEach items="${requestScope.empList}" var="emp">
								<tr>
									<td>${emp.id}</td>
									<td>${emp.name}</td>
									<td>${emp.age}</td>
									<td>${emp.dateOfBirth}</td>
									<td>${emp.dateOfJoining}</td>
									<td>${emp.salary}</td>
									<td>${emp.salaryGrade}</td>
									<td>${emp.deptId}</td>
									<td>${emp.deptName}</td>


									<td><input type="button" class="btn btn-info" name=""
										value="Update" onclick="updateEmp(${emp.id},${emp.deptId})"></td>
								</tr>
							</c:forEach>

						</table>

					</div>
					</form>
				</c:if>
				
				
				
				
				



			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
</body>

<script>
$(document).ready(function() {
	$("#eSearch1").click(function() {
		$("#ddInfo").show();
		$("#viewEmployees").show();
	});
	
});


function deleteEmp(id){
	$("#operations").val("deleteOper");
	$("#p5").attr("action","/EmpWebApp/DeleteEmployeeServlet");
	$("#p5").submit();
	
}

function updateEmp(id, deptId){
	$("#eSearch").val(id);
	$("#DeptId").val(deptId);
	$("#operations").val("updateOperFrmDept");
	$("#p5").attr("action","/EmployeeWebApp/employee");
	$("#p5").submit();
	
}

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