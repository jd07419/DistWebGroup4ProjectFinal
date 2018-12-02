<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<#list employees as e>
<div>
	employee name: ${e.firstname} ${e.lastname}<br>
	employee id: ${e.id}<br>
	<form action="FinalServlet" method="post">
	<input type="text" name="userInjection" value="user">
	<input type="text" name="priceInjection" value="price">
	<button name="addEmployee" value=${e.id}> Select Employee </button>
	</form>
</div>
<#else>
No employees
</#list>
</body>
</html>