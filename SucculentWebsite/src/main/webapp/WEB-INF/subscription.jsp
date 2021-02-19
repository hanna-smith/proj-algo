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
        <link rel="javascript" href="/js/homepage.js">
        <link rel="stylesheet" href="/css/homepage.css">
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
              	<li><a href="/logout">Logout</a></li>	
            </ul>
        </nav>
        <h1>Choose your Subscription Type</h1>
        <form:form method="POST" action="/thismonth'ssucculents" modelAttribute="subscription">
        	<div class="form-group">
        		<form:label path="numOfPlants"/> How many plants in your box?
        		<form:errors path="numOfPlants"/>
        		<form:select path="numOfPlants">
        		<c:forEach items="${numOfPlants}" var="numOfPlants">
        			<option value="${numOfPlants}">${numOfPlants}</option>
        		</c:forEach>
        		</form:select>
        	</div>
        	<div class="form-group">
        		<form:label path="subLengthInMonths"/> For how long?
        		<form:errors path="subLengthInMonths"/>
        		<form:select path="subLengthInMonths">
        			<c:forEach items="${subLengthInMonths}" var="subLengthInMonths">
        				<option value="${subLengthInMonths}">${subLengthInMonths}</option>
        			</c:forEach>
        		</form:select>
        	</div>
        	<div class="form-group">
        		<form:label path="shipmentDate"/> When should we ship it?
        		<form:errors path="shipmentDate"/>
        		<form:input type="date" path="shipmentDate"/>
        	</div>
        	<input type="submit" value="Pick My Succulents">
        </form:form> 
</body>
</html>