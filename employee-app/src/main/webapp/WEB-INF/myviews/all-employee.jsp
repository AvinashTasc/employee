<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>EMPLOYEE PROFILE MANAGEMENT</h1>
<hr>
<h3>ALL Employees</h3>
<hr>
<h4>${msgForAdd }</h4>
<a href="showEmployeeForm.html">Add employee</a>
	<br>
	<br>
<table border="1">
	<tr>
		<td>Employee Id</td>
		<td>Employee Name</td>
		<td>Employee salary</td>
		<td>Employee Age</td>
		<td>Delete</td>
		<td>Update</td>
	</tr>
	<c:forEach var="p" items="${listOfEmployees }">
		<tr>
			<td><c:out value="${p.empId }"></c:out></td>
			<td><c:out value="${p.empName }"></c:out></td>
			<td><c:out value="${p.salary}"></c:out></td>
			<td><c:out value="${p.age }"></c:out></td>
			<td><a href="deleteEmployee.html?empId=${p.empId }">Delete</a> </td>
			<td><a href="showEmployeeDetails.html?empId=${p.empId }">Update</a> </td>			
		</tr>	
	</c:forEach>
</table>
<br>
<br>
<a href="index.html">Back To Home</a>
</body>
</html>