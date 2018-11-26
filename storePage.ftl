<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<#list stores as s>
<div>
	${s.name}
	${s.address}
</div>
<#else>
No stores
</#list>
</body>
</html>