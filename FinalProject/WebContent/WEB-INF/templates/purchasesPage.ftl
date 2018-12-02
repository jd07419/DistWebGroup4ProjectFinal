<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<#list purchases_list as pl>
	<tr>
	${pl.username}<br>
	${pl.firstname}
	${pl.lastname}<br>
	${pl.timeStamp}
	${pl.totalPrice}<br><br>
	</tr>
	</#list>
	</table>
</body>
</html>