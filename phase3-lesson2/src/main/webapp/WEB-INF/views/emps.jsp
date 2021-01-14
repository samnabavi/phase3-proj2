<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:blue">  List of Employees </h1>
<ul>
	<c:forEach items="${employees}" var="emps">
	<li>${emps.id}</li>
	<li>${emps.name}</li>
	</c:forEach>

</ul>

</br>
<a href="/addemp">Home Page</a>


</body>
</html>