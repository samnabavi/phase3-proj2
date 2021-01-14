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
<h1 style="color:blue">  This is the feedback that you are looking for </h1>

<h5>Feedback id:</h5>
${correctfb.id}
</br>
<h5>Feedback name:</h5>
${correctfb.name}
</br>
<h5>Feedback comment:</h5>
${correctfb.comment}
</br>
<a href="/addfb">Home Page</a>

</body>
</html>