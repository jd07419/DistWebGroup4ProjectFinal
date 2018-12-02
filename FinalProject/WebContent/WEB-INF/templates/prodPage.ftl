<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="scripts/addCart.js"></script>
<title>Insert title here</title>
</head>
<body>

<div id=adminAccess>
	Add Product:
	<form action="FinalServlet" method="post">
	Product name: <input type="text" name="productName"><br>
	Product price: <input type="text" name="productPrice"><br>
	<input type = "submit" name="addProduct" value="Add Product">
</div>

<#list products as p>
<div>
	product Name: ${p.name}<br>
	product price: ${p.price}	
</div>
<#else>
No products
</#list>
</body>
</html>