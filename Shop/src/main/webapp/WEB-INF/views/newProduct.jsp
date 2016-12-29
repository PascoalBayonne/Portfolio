<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<br>
	<img src="${product.pathImage}" alt="add foto" width="50px"
		height="50px">
	<br>

	<form:form action="./saveProduct?${_csrf.parameterName}=${_csrf.token}"
		method="post" enctype="multipart/form-data">


		<input name="product_Name" placeholder="The name of product" />
		<input name="product_Description"
			placeholder="The description of  product" />
		<input name="price" placeholder="The price product" type="number" />
		<input name="weight" placeholder="The weight of product" type="number" />

		<input type="file" name="image">
		<button>save image</button>
	</form:form>


			<c:forEach var="product" items="${produts}">

		<img src="${product.productImage}" >




		<h3>${product.product_Name}</h3>


${product.product_Name}<a href="deleteProduct/${product.id}">Delete
				Product</a>


		<br>
	</c:forEach>





	


</body>
</html>