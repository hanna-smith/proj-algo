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
        <link rel="stylesheet" href="/css/register.css">
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
		<h1>Subscribe in ____ Easy Steps</h1>
		<img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
        
		<div class="reg-form">
		<h3>Tell Us Who You Are!</h3>
			<form:form method="POST" action="/subscribe" modelAttribute="user">
				<div class="form-group"> 
					<form:errors path="fName" class="errors"/>
					<br>
					<form:input path="fName" placeholder="First Name"/>
				</div>
				<div class="form-group">
					<form:errors path="lName" class="errors"/>
					<br>
					<form:input path="lName" placeholder="Last Name"/>
				</div>
				<div class="form-group">
					<form:errors path="email" class="errors"/>
					<br>
					<form:input path="email" placeholder="Email"/>
				</div>
				<div class="form-group">
					<form:errors path="password" class="errors"/>
					<br>
					<form:input type="password" path="password" placeholder="Password"/>
				</div>
				<div class="form-group">
					<form:errors path="confirmPass" class="errors"/>
					<br>
					<form:input type="password" path="confirmPass" placeholder="Confirm Password"/>
				</div>
				<input class="sub-butt" type="submit" value="Login and choose Your Subscription">
				</form:form>
			</div>
			<footer>
            	<p>Succs4U.com</p>
        	</footer>
	
	<script src="/js/homepage.js" async defer></script>
    </body>
</html>