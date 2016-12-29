<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Country</title>
</head>
<body>



	<c:forEach var="country" items="${countries}">

	${country.name}
	<a href="deleteCountry/${country.id}">delete country</a>

		

		<br>
	</c:forEach>

<c:forEach var="city" items="${country.cities }">
	${city.nameOfCity}<a href="deleteCityFromCountry/${city.id}">Delete
				city</a>
		</c:forEach>

	<form action="saveCountry" method="get">

		<input name="name" placeholder="name of the country"> <select
			name="cityId" multiple="multiple">
			<option>Choose City</option>
			<c:forEach var="city" items="${cities}">

				<option value="${city.id}">${city.nameOfCity }</option>

			</c:forEach>

		</select>



		<button>Save Country</button>
	</form>

	<br>





	<br>
	<a href="City">add City</a>
</body>
</html>