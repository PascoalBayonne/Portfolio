<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>


	<br>
	<img src="${user.pathImage}" alt="add foto" width="110px"
		height="110px" style="border-radius: 50%">
	<br>




	<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
		method="post" enctype="multipart/form-data">
		<input type="file" name="image">
		<button>save image</button>
	</form:form>

	<h2 class="name">
		<h3>Username:</h3>
		${user.firstName}
	</h2>
	<h3 class="location">
		<h3>Location:</h3>
		San Francisco, CA
	</h3>
	<ul class="contact_information">
		<%---<li class="mail">${user.email}</li>---%>
		<li class="phone"><h3>Phone Number:</h3>${user.contacts}</li>
		
		
		
</body>
</html>