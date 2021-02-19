<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Succs4U</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/css/login.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Rock+Salt&display=swap" rel="stylesheet">
    </head>
    <body class="container">
        <div class="header">
            
            <h3><a href="/">Succs4U</a></h3>
        </div>
        <div class="nav-toggle">
            <div class="nav-toggle-bar"></div>
        </div>
        <nav class="nav">
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/howitworks">How It Works</a></li>
                <li><a href="/gallery">Gallery</a></li>
                <li><a href="/contactus">Contact Us</a></li>
                <li><a href="/whyus">Why Us?</a></li>
                <li><a href="/login">Login</a></li>
            </ul>
        </nav>
		<h1>Welcome Back!</h1>
		<img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
			<p>${loginError}</p>
		<form method="post" action="login" class="log-form">
			<div>
				<input class="form" type="email" name="email" placeholder="Email">
			</div>
			<div>
				<input class="form" type="password" name="password" placeholder="Password">
			</div>
			<br>
			<input type="submit" value="Login" id="button">
		</form>
        <footer>
            <p>Succs4U.com</p>
        </footer>
        <script src="/js/homepage.js" async defer></script>
    </body>
</html>