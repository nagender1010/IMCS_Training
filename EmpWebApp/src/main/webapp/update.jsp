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
<body>
	<form action="/EmpWebApp/updateEmployee" id="p41" method="post">
		<input type="hidden" id="operations" name="operations" value="dummy" />
		<div class="container">
			<tr>
				<th>User ID: "${requestScope.uid}" Details, update from the
					following form</th>
			</tr>

			<table class="table table-hover">
				<tr style="display: none">
					<th>ID</th>
					<td><input class="requiredAttr" name="uid" id="uid"
						type="text" value="${requestScope.uid}"></td>
				</tr>

				<tr>
					<th>Name<span><i class="fa fa-asterisk"
							aria-hidden="true" style="color: red"></i></span></th>
					<td><input class="requiredAttr" name="uname" id="uname"
						type="text" value="${requestScope.uname}" required></td>
				</tr>



				<tr>
					<th>Age</th>
					<td><input class="requiredAttr" name="uage" id="uage"
						type="number" value="${requestScope.uage}" required></td>
				</tr>
				<tr>
					<th>DOB</th>
					<td><input class="requiredAttr" type="date" name="udob"
						id="udob" value="${requestScope.udob}" required></td>
				</tr>

				<tr>
					<th>DOJ</th>
					<td><input class="requiredAttr" type="date" name="udoj"
						id="udoj" value="${requestScope.udoj}" required></td>
				</tr>

				<tr>
					<th>Salary</th>
					<td><input class="requiredAttr" id="inp1" " type="number"
						name="usalary" id="salary" value="${requestScope.usalary}"
						required></td>
				</tr>
				<tr>
					<th>Salary Grade</th>
					<td><input class="requiredAttr" id="inp2" type="number"
						name="usalarygrade" id="usalarygrade"
						value="${requestScope.usalarygrade}" required></td>

				</tr>

				<tr>
					<th>Dept ID</th>
					<td><input class="requiredAttr" id="inp2" type="number"
						name="udeptid" id="udeptid" value="${requestScope.udeptid}"
						required></td>
				</tr>
				<tr>
					<th>Dept Name</th>
					<td><input class="requiredAttr" id="d4" type="text"
						name="udeptname" id="deptname" value="${requestScope.udeptname}"
						required></td>
				</tr>

				<tr>

					<td><input id="D6" type="submit" class="btn btn-info"
						value="Update User"></td>
				</tr>

			</table>
		</div>

	</form>
</body>
</html>