<%@page import="com.models.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.product_card{
border: solid;
width:28%;
padding: 10px;
margin : 10px;
float:left;
box-shadow: grey 5px 7px;

}
a{
	text-decoration: blink;
	text-shadow: fuchsia;
}
</style>
</head>
<body>
	<h1>Coustomer Dashboard</h1>

	<%
List<Products> list = (List<Products>) request.getAttribute("list_products");
for( Products p: list){
	
	%><div class="product_card">
		<h3><%=p.getTitle() %></h3>
		<p><%=p.getShort_des() %></p>
		<span>Price: INR.<%=p.getPrice() %></span> <br />
		<span>Category: <%=p.getCategory() %></span> <br /> <br />
		<a href="#">Add to cart</a>
		<br />
	</div>
	<% 
}
%>
</body>
</html>