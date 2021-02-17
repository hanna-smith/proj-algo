<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Back!</title>
</head>
<body>
<h1>Welcome Back!</h1>
<p>${loginError}</p>
<form method="post" action="login">
	<div>
		<label for="email">Email: </label>
		<input type="email" name="email">
	</div>
	<div>
		<label for="password">Password: </label>
		<input type="password" name="password">
	</div>
	<br>
	<input type="submit" value="Login">
</form>
</body>
</html>