<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STREET</title>
</head>
<body>

Save some streets
<br>

<c:forEach var="Street" items="${streets}">
	${Street.nameOfStreet}
	<a href="deleteStreet/${street.id }">delete</a>
		<br>
	</c:forEach>
	<br>


	<form action="saveStreet" method="get">
		<input name="nameOfStreet" placeholder="name of the street"><br>
		
		<button>Save Street</button>
	</form>
	
	<br>
<a href="Address">Go To Address</a>
</body>
</html>