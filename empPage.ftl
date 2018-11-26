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
</div>
<#else>
No employees
</#list>
</body>
</html>