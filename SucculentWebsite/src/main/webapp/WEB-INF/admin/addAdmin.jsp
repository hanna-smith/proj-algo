<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start Your Subscription</title>
        <link rel="javascript" href="/js/homepage.js">
        <link rel="stylesheet" href="/css/template.css">
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
                <li><a href="<c:url value="/logout" />">Logout</a></li>
            </ul>
        </nav>
    <img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
    <p><form:errors path="user.*"/></p>
    <form:form method="POST" action="/admin/addAdmin" modelAttribute="user">
		<h3>New Page Admin</h3>
		<div>
			<form:label path="fName"/>First Name:
			<form:errors path="fName"/>
			<form:input path="fName"/>
		</div>
		<div>
			<form:label path="lName"/>Last Name:
			<form:errors path="lName"/>
			<form:input path="lName"/>
		</div>
		<div>
			<form:label path="email"/>Email:
			<form:errors path="email"/>
			<form:input path="email"/>
		</div>
		<div>
			<form:label path="streetAddress"/>Address: 
			<form:errors path="streetAddress"/>
			<form:input path="streetAddress"/>
		</div>
		<div>
			<form:label path="streetAddress2"/>Address 2: 
			<form:errors path="streetAddress2"/>
			<form:input path="streetAddress2" placeholder="Apt, Building No."/>
		</div>
		<div>
			<form:label path="city"/>City: 
			<form:errors path="city"/>
			<form:input path="city"/>
		</div>
		<div>
			<form:label path="state"/>State: 
			<form:errors path="state"/>
			<form:select path="state">
				<c:forEach items="${states }" var="state">
					<option value="${state }">${state }</option>
				</c:forEach>
			</form:select>		
		</div>
		<div>
			<form:label path="zip"/>Zip Code: 
			<form:errors path="zip"/>
			<form:input path="zip"/>
		</div>
		<div>
			<form:label path="password"/> Password:
			<form:errors path="password"/>
			<form:input type="password" path="password"/>
		</div>
		<div>
			<form:label path="confirmPass"/> Confirmation Password:
			<form:errors path="confirmPass"/>
			<form:input type="password" path="confirmPass"/>
		</div>
        <input class="subscribe" type="submit" value="Register!"/>
    </form:form>
    <h3>Or</h3>
   			 <form method="get" action="/login">
            	<button class="subscribe" type="submit">Login And Subscribe Again!</button>
            </form>
			<footer>
            	<p>Succs4U.com</p>
        	</footer>
    <script src="/js/homepage.js" async defer></script>
</body>
</html>