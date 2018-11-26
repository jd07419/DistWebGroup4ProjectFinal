<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
  <#list users as u>
	<div>
	${u.username}
	</div>
  </#list>  
  <#list employees as e>
	<div>
	${e.firstname}
	${e.lastname}
	</div>
  </#list>
  <#list purchases as p>
	<div>
	${p.date}<br>
	${p.totalPrice}
	</div>
	
  <#else>
	No purchases
  </#list>
  
</div>
</body>
</html>