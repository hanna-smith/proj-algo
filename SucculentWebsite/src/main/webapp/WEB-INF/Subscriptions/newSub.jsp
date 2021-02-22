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
		      <li><a onclick="window.open('/', '_self')" href="/">Home</a></li>
		      <li><a href="/howitworks" onclick="window.open('/howitworks','_self')">How It Works</a></li>
		      <li><a href="/gallery" onclick="window.open('/gallery','_self')">Gallery</a></li>
		      <li><a href="/contactus" onclick="window.open('/contactus','_self')">Contact Us</a></li>
		      <li><a href="/whyus" onclick="window.open('/whyus','_self')">Why Us?</a></li>
		      <li><a href="<c:url value="/logout" />" onclick="window.open('/logout','_self')">Logout</a></li>
            </ul>
        </nav>
         <img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
<h3>Create An Event</h3>
<div>
	<form:form method="POST" action="/newevent" modelAttribute="event">
	<form:hidden value="${user_id }" path="host"/>
	<div class="form-group">
	<form:label path="name"/> Name: 
	<form:errors path="name"/>
	<form:input path="name"/>
	</div>
	<div class="form-group">
	<form:label path="date"/> Date:
	<form:errors path="date"/>
	<form:input type="date" path="date"/>
	</div>
	<div class="form-group">
	<form:label path="city"/>Location:
	<form:errors path="city"/>
	<form:input path="city"/>
	</div>
	<div class="form-group">
	<form:label path="state"/>State:
	<form:errors path="state"/>
	<form:select path="state">
		<c:forEach items="${states }" var="state">
			<option value="${state}">${state}</option>
		</c:forEach>
		</form:select>
	</div>
	<button class="btn btn-dark">Create Event</button>
	</form:form>
</body>
</html>