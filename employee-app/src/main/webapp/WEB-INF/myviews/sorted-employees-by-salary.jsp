<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Employees</title>
</head>
<body>

 
<hr>
<br>
<br>
    <h2>Employee List</h2>
<br>
<br>
<hr>
 

    <table border="1">
<tr>
<tr>
<th>ID</th>
<th>Name</th>
<th>Salary</th>
<th>Age</th>
</tr>

<tbody>
<c:forEach var="employee" items="${listOfEmployees}">
<tr>
<td>${employee.empId}</td>
<td>${employee.empName}</td>
<td>${employee.salary}</td>
<td>${employee.age}</td>
</tr>
</c:forEach>
</tbody>
</table>

 

    <br/>
    <br>
<br>
<hr>
<a href="index.html">Back To Home</a>
</body>
</html>