<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Products</h1>
	<!-- Read the attribute sent by controller-->

	<div>
		<strong><%=request.getAttribute("msg")%></strong>
	</div>
</body>
</html>