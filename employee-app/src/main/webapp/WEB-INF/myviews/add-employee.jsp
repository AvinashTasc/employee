<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>EMPLOYEE PROFILE MANAGEMENT</h1>
<hr>
<h3>ADD EMPLOYEE</h3>
<hr>
<form:form modelAttribute="empModel"  method="post" action="add-employee.html">
	Employee id: <form:input path="empId"/> 
	<br>
	<br>
	Employee name: <form:input path="empName"/> 
	<br>
	<br>
	Employee salary: <form:input path="salary"/> 
	<br>
	<br>
	Employee Age: <form:input path="age"/> 
	<br>
	<br>
	<input type="submit" value="Add Employee"> 
</form:form>
<br>
<br>
<a href="index.html">Back To Home</a>
</body>
</html>