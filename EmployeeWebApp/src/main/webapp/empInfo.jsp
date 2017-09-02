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



	<c:choose>
		<c:when test="${requestScope.pageType eq 'updateOperFrmDept'}">
			<form action="/EmployeeWebApp/updateEmployee" method="post">

				<table class="table table-hover">
					<tr style="display: none">
						<th>ID</th>
						<td><input class="requiredAttr" name="uid" id="uid"
							type="text" value="${requestScope.eInfo.id}"></td>
					</tr>

					<tr>
						<th>Name<span><i class="fa fa-asterisk"
								aria-hidden="true" style="color: red"></i></span></th>
						<td><input class="requiredAttr" name="uname" id="uname"
							type="text" value="${requestScope.eInfo.name}" required></td>
					</tr>



					<tr>
						<th>Age</th>
						<td><input class="requiredAttr" name="uage" id="uage"
							type="number" value="${requestScope.eInfo.age}" required></td>
					</tr>
					<tr>
						<th>DOB</th>
						<td><input class="requiredAttr" type="date" name="udob"
							id="udob" value="${requestScope.eInfo.dateOfBirth}" required></td>
					</tr>

					<tr>
						<th>DOJ</th>
						<td><input class="requiredAttr" type="date" name="udoj"
							id="udoj" value="${requestScope.eInfo.dateOfJoining}" required></td>
					</tr>

					<tr>
						<th>Salary</th>
						<td><input class="requiredAttr" type="number" name="usalary"
							id="usalary" value="${requestScope.eInfo.salary}" required></td>
					</tr>
					<tr>
						<th>Salary Grade</th>
						<td><input class="requiredAttr" type="number"
							name="usalarygrade" id="usalarygrade"
							value="${requestScope.eInfo.salaryGrade}" required></td>

					</tr>

					<tr>
						<th>Dept ID</th>
						<td><input class="requiredAttr" type="number" name="udeptid"
							id="udeptid" value="${requestScope.eInfo.deptId}" required></td>
					</tr>
					<tr>
						<th>Dept Name</th>
						<td><input class="requiredAttr" type="text" name="udeptname"
							id="udeptname" value="${requestScope.eInfo.deptName}" required></td>
					</tr>

					<tr>

						<td><input id="save" type="submit"
							class="btn btn-info" value="Save"></td>
					</tr>


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
			

			<div id="deletediv" class="col-sm-6">
				<tr>
					<input id="delete" type="submit" class="btn btn-info"
						value="Delete">
				</tr>
			</div>
		</form>

	</c:if>
			
			

		</c:when>
		<c:otherwise>
			<form action="/EmployeeWebApp/updateEmployee" method="post">

				<table class="table table-hover">
					<tr style="display: none">
						<th>ID</th>
						<td><input class="requiredAttr" name="uid" id="uid"
							type="text" value="${requestScope.eInfo.id}" disabled="disabled"></td>
					</tr>

					<tr>
						<th>Name<span><i class="fa fa-asterisk"
								aria-hidden="true" style="color: red"></i></span></th>
						<td><input class="requiredAttr" name="uname" id="uname"
							type="text" value="${requestScope.eInfo.name}"
							disabled="disabled" required></td>
					</tr>



					<tr>
						<th>Age</th>
						<td><input class="requiredAttr" name="uage" id="uage"
							type="number" value="${requestScope.eInfo.age}"
							disabled="disabled" required></td>
					</tr>
					<tr>
						<th>DOB</th>
						<td><input class="requiredAttr" type="date" name="udob"
							id="udob" value="${requestScope.eInfo.dateOfBirth}"
							disabled="disabled" required></td>
					</tr>

					<tr>
						<th>DOJ</th>
						<td><input class="requiredAttr" type="date" name="udoj"
							id="udoj" value="${requestScope.eInfo.dateOfJoining}"
							disabled="disabled" required></td>
					</tr>

					<tr>
						<th>Salary</th>
						<td><input class="requiredAttr" type="number" name="usalary"
							id="usalary" value="${requestScope.eInfo.salary}"
							disabled="disabled" required></td>
					</tr>
					<tr>
						<th>Salary Grade</th>
						<td><input class="requiredAttr" type="number"
							name="usalarygrade" id="usalarygrade"
							value="${requestScope.eInfo.salaryGrade}" disabled="disabled"
							required></td>

					</tr>

					<tr>
						<th>Dept ID</th>
						<td><input class="requiredAttr" type="number" name="udeptid"
							id="udeptid" value="${requestScope.eInfo.deptId}"
							disabled="disabled" required></td>
					</tr>
					<tr>
						<th>Dept Name</th>
						<td><input class="requiredAttr" type="text" name="udeptname"
							id="udeptname" value="${requestScope.eInfo.deptName}"
							disabled="disabled" required></td>
					</tr>

					<tr>

						<td><input id="save" style="display: none" type="submit"
							class="btn btn-info" value="Save"></td>
					</tr>

						<tr>
							<td><label id="update"  class="btn btn-info"
								>Update</label></td>
						</tr>


				</table>
				
				
			</form>

		</c:otherwise>
	</c:choose>


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