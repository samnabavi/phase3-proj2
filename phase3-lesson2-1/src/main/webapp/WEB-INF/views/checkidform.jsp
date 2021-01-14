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

<h1> Check for feedback</h1>

	<form:form modelAttribute="form">
		<form:errors path="" element="div"/>
		<div>
			<from:label path="name">Provide the id that you are looking for.</from:label>
			<form:input path="id"/>
			<form:errors path="id" />
		</div>
		
		<div>
			<input type="submit" value="check id"/>
		</div>
		
		</form:form>

</body>
</html>