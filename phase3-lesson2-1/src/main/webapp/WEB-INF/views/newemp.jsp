<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Add new Employee</h1>

	<form:form modelAttribute="form">
		<form:errors path="" element="div"/>
		<div>
			<from:label path="name">Employee Name</from:label>
			<form:input path="name"/>
			<form:errors path="name" />
		</div>
		
		<div>
			<input type="submit" value="Add Employee"/>
		</div>
		
		</form:form>

</body>
</html>