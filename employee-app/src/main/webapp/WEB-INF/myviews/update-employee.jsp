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
<h1>Employee management system</h1>
<hr>
<h2>Update employee</h2>
<hr>
<form:form modelAttribute="emp" method="post" action="makeUpdate.html">
	Employee Id (readonly): <form:input path="empId" readonly="true"/>
	<br>
	<br>
	Employee Name: <form:input path="empName"/>
	<br>
	<br>
	Employee salary: <form:input path="salary"/>
	<br>
	<br>
	Employee age: <form:input path="age"/>
	<br>
	<br>
	<input type="submit" value="Update Employee">
</form:form>
</body>
</html>