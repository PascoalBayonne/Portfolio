<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="css/login.css">



<c:forEach var="UserDTO" items="${userDTOs}">
	<div style="background-color: aqua">
		${userDTO.firstName}  ${userDTO.lastName}   ${userDTO.email} <a href="deleteUser/${userDTO.id}">delete</a>
	</div>
	<br>
</c:forEach>

${exception}

<form:form modelAttribute="user" action="saveUser" method="post">
	<div id="form-main">
		<div id="form-div">
			<form class="form" id="form1">

				<p class="firstName">
					<form:input path="firstName" type="text"
						class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
						placeholder="first Name" id="firstName" />
				</p>
				
				<p class="lastName">
					<form:input path="lastName" type="text"
						class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
						placeholder="last Name" id="lastName" />
				</p>
				

				<p class="email">
					<form:input path="email" type="text"
						class="validate[required,custom[email]] feedback-input" id="email"
						placeholder="Email" />
				</p>

				<p class="password">
					<form:input path="password" type="password"
						class="validate[required,custom[email]] feedback-input" id="email"
						placeholder="password" />
				</p>

				<p class="contacts">
					<form:input path="contacts" type="text"
						class="validate[required,custom[onlynumbers]] feedback-input"
						id="contacts" placeholder="phone number" />
				</p>
				





				<div class="submit">
					<input type="submit" value="SAVE" id="button-blue" />
					<div class="ease"></div>
				</div>

			</form>
		</div>
</form:form>