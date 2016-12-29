<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<link rel="stylesheet" href="css/tiles/template.css">
</head>
<sec:authentication property="name" />
<body>


	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>

	<br>
	<a href="loginpage">login</a>
	<br>
	<a href="registration"> registration</a>
	<br>

	<sec:authorize access="isAuthenticated()">
		<a href="profile">profile</a>
	</sec:authorize>

	<br>

	<a href="admin">admin page</a>















</body>
</html>