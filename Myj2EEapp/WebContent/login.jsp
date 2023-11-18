<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

</head>
<body>
<h1>LogIn</h1>
<div>
		<strong><%=request.getAttribute("msg")%></strong>
</div>
	<fieldset style="width: 50%">
		<legend>Log In</legend>
		<form action = "MainController?page=login_form" method="post">
			
			<label>Enter UserName/email: </label><input type="email" name="email" required="required" /><br /><br />
			<label>Enter Password: </label><input type="password" name="password" required="required" /><br /><br />
			<input type="submit" value="Login"/><br /><br />
		</form>

	</fieldset>
</body>
</html>