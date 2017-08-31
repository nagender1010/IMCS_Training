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
	<form id="p5" method="post">
		<input type="hidden" id="dempIdc" name="deleteEmpId" /> <input
			type="hidden" id="uempIdc" name="uempId" /> <input type="hidden"
			id="operations" name="operations" />

		<table class="table table-hover" align="center" border="1"
			style="width: 100%">


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
						value="Delete" onclick="deleteEmp(${emp.id})"></td>
					<td><input type="button" class="btn btn-info" name=""
						value="Update" onclick="updateEmp(${emp.id})"></td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>
<script>
function deleteEmp(id){
	$("#dempIdc").val(id);
	$("#operations").val("deleteOper");
	$("#p5").attr("action","/EmpWebApp/DeleteEmployeeServlet");
	$("#p5").submit();
	
}function updateEmp(id){
	$("#uempIdc").val(id);
	$("#operations").val("updateOper");
	$("#p5").attr("action","/EmpWebApp/updateEmployee");
	$("#p5").submit();
	
}

</script>
</html>