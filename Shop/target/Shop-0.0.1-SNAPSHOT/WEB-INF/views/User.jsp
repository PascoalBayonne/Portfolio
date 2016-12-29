<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>User-Registration</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Flat Sign Up Form Responsive Widget Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<!-- //css files -->
<!-- online-fonts -->
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'><link href='//fonts.googleapis.com/css?family=Raleway+Dots' rel='stylesheet' type='text/css'>
</head>
<body>
<!--header-->
	<div class="header-w3l">
		<h1>Registration Form</h1>
	</div>
<!--//header-->
<!--main-->
<div class="main-agileits">
	<h2 class="sub-head">Sign Up</h2>
		<div class="sub-main">	
			<form action="saveUser" method="post">
				<input placeholder="First Name" name="firstName" class="name" type="text" required="">
					<span class="icon1"><i class="fa fa-user" aria-hidden="true"></i></span><br>
				<input placeholder="Last Name" name="lastName" class="name2" type="text" required="">
					<span class="icon2"><i class="fa fa-user" aria-hidden="true"></i></span><br>
				<input placeholder="Phone Number" name="contacts" class="number" type="text" required="">
					<span class="icon3"><i class="fa fa-phone" aria-hidden="true"></i></span><br>
				<input placeholder="Email" name="email" class="mail" type="text" required="">
					<span class="icon4"><i class="fa fa-envelope" aria-hidden="true"></i></span><br>
				<input  placeholder="Password" name="password" class="pass" type="password" required="">
					<span class="icon5"><i class="fa fa-unlock" aria-hidden="true"></i></span><br>
					<input placeholder="login Name" name="login" class="name" type="text" required="">
					<span class="icon1"><i class="fa fa-user" aria-hidden="true"></i></span><br>
					<input  placeholder="birthday" name="birthday" class="pass" type="date" required="">
					<span class="icon5"><i class="fa fa-unlock" aria-hidden="true"></i></span><br>
					
					
		  			<input type="radio" name="gender" value="male"> Male<br>
		  			<input type="radio" name="gender" value="female"> Female<br>
		  			<input type="radio" name="gender" value="other"> Other<br>
		  			<span class="icon5"><i class="fa fa-unlock" aria-hidden="true"></i></span><br>
				
				<input type="submit" value="Save">
			</form>
		</div>
		<div class="clear"></div>
</div>
<!--//main-->

<!--footer-->
<div class="footer-w3">
	<p>&copy; 2016  . All rights reserved | Design by <a href="http://w3layouts.com">Eddy-Bayonne</a></p>
</div>
<!--//footer-->

</body>
</html>










































































<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
<link rel="stylesheet" href="css/user.css">

</head>

<body>

Save Some Users
	<br>



	<c:forEach var="user" items="${UserDTOs}">
	${user.firstName} ${user.lastName}
	<a href="deleteUser/${user.id }">delete</a>
		<br>
	</c:forEach>
	<br>



	<br>

	<form action="saveUser" method="post">
		<input name="firstName" placeholder="first name"><br>
		<input name="lastName" placeholder="last name"><br>
		<input name="login" placeholder="user's login"><br>
		<input type=email  name="email" placeholder="email"><br>
		<input type="password" name="password" placeholder="password" ><br>
		<input name="contacts" placeholder="contacts"><br>
		 <input type="date" name="birthday" placeholder="birthday"><br>
		  <input type="radio" name="gender" value="male"> Male<br>
 		 <input type="radio" name="gender" value="female"> Female<br>
 		 <input type="radio" name="gender" value="other"> Other
		
		<button>Save User</button>
	</form>

<br>
<a href="GotoHome">Home</a>



</body>
</html> --%>