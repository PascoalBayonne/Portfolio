<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City</title>
</head>
<body>

	<h1>Save Some cities</h1>
	<br>


	
<c:forEach var="City" items="${cites}">
	${City.nameOfCity}
	<a href="deleteCity/${City.id }">delete</a>
		<br>
	</c:forEach>
	<br>

	

		
	
	
		
	<form action="saveCity" method="get">
		<input name="nameOfCity" placeholder="name of the city">
		<select	name="idStreet" multiple="multiple">
		<option>Choose Street</option>
		
		<c:forEach var="street" items="${streets}">

				<option value="${street.id}">${street.nameOfStreet }</option>

			</c:forEach>
		
		
		
		</select>
		
		
		<button>Save City</button>
	</form>
	
	<br>
	<a href="STREET">Add Street</a>
	<br>
	
	<a href="GotoHome">Home</a>



</body>
</html>