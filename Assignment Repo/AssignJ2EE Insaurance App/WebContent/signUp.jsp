<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Sign Up</h1>
	<fieldset style="width: 50%">
		<legend>Sign Up</legend>
		<form action = "MainController?page=sign_up_form" method="post">
			<label> Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="name" required="required" /><br /><br />
			<label> Age: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="number" name="age" required="required" /><br /><br />
			<label> Username: </label><input type="text" name="username" required="required" /><br /><br />
			<label> Password: &nbsp;</label><input type="password" name="password" required="required" /><br /><br />
			<input type="submit" value="Sign Up"/><br /><br />
		</form>

	</fieldset>
</body>
</html>