<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<#list discounts as d>
<div>
	discount id: ${d.id}<br>
	discount name: ${d.name}<br>
	percent off: ${d.percentOff!""}<br>
	description: ${d.description!""}
</div>
<#else>
No discounts
</#list>
</body>
</html>