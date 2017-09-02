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

	<form action="/EmployeeWebApp/updateEmployee" method="post">

		<table class="table table-hover" style="width: 75%" align="center">
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

	<form action="/EmployeeWebApp/department" method="post">
		<table style="width: 75%" align="center">

			<tr style="display: none">
				<th>ID</th>
				<td><input class="requiredAttr" name="departId" id="departId"
					type="text" value="${requestScope.deptInfo.id}"></td>
			</tr>
			<td><input id="empSearch" type="submit" class="btn btn-info"
				value="View Employees"></td>

		</table>

	</form>






	<c:if test="${requestScope.status}">
		<form action="/EmployeeWebApp/updateEmployee" method="get">
			<div style="display: none">
				<tr>
					<td><input class="requiredAttr" name="deleteId" id="uid"
						type="text" value="${requestScope.eInfo.id}"></td>
				</tr>
			</div>

			<div id="deletediv" style="display: none" class="col-sm-6">
			
				<tr>
					<input id="delete" type="submit" class="btn btn-info"
						value="Delete">
				</tr>
			</div>
		</form>

		<div id="updatediv" class="col-sm-0">
			<tr>
				<input id="update" type="submit" class="btn btn-info" value="Update">
			</tr>
		</div>

	</c:if>
</body>

<script>
$(document).ready(function() {
	$("#update").click(function() {
		$("#uid").removeAttr("disabled")
		$("#uname").removeAttr("disabled")
		$("#uage").removeAttr("disabled")
		$("#udob").removeAttr("disabled")
		$("#udoj").removeAttr("disabled")
		$("#usalary").removeAttr("disabled")
		$("#usalarygrade").removeAttr("disabled")
		$("#udeptid").removeAttr("disabled")
		$("#udeptname").removeAttr("disabled")
		$("#save").show()
		$("#deletediv").show()		
		$("#update").hide()
	});
});	
	
</script>
</html>