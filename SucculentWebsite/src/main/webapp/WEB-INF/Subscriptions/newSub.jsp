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
        <link rel="stylesheet" href="/css/newsub.css">
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
                <li><a href="/dashboard" onclick="window.opent('/dashboard','_self')">Dashboard</a></li>
                <li><a href="<c:url value="/login?logout" />" onclick="window.open('/login?logout','_self')">Logout</a></li>	
            </ul>
        </nav>
        <div class="content">
        <h1>Give us the Details!</h1>
        <form:form method="POST" action="/newSubscription" modelAttribute="subscription">
        <form:hidden value="${user.id}" path="user"/>
        	<div class="form-group">
        		<form:label path="numOfPlants"/> How many succs?
        		<form:errors path="numOfPlants"/>
        		<form:select path="numOfPlants">
        		<c:forEach items="${numOfPlants}" var="numOfPlants">
        			<option value="${numOfPlants}">${numOfPlants}</option>
        		</c:forEach>
        		</form:select>
        	</div>
        	<div class="form-group">
        		<form:label path="subLengthInMonths"/> For how many months?
        		<form:errors path="subLengthInMonths"/>
        		<form:select path="subLengthInMonths">
        			<c:forEach items="${subLengthInMonths}" var="subLengthInMonths">
        				<option value="${subLengthInMonths}">${subLengthInMonths}</option>
        			</c:forEach>
        		</form:select>
        	</div>
        	<div class="form-group">
        		<form:label path="shipmentDate"/> What day of the month would you like your box shipped? (shipments take roughly 2-4 days to arrive)
        		<form:errors path="shipmentDate"/>
        		<form:select path="shipmentDate">
        			<c:forEach items="${shipmentDate}" var="shipmentDate">
        				<option value="${shipmentDate}">${shipmentDate}</option>
        			</c:forEach>
        		</form:select>
        	</div>
        	
        	<h3>Verify your delivery address</h3>
        	<div>
	        	<form:label path="reciever"/>Recipient: 
	        	<form:errors path="reciever"/>
	        	<form:input path="reciever" placeholder="${user.fName } ${user.lName}"/>
        	</div>
        	<div>
	        	<form:label path="recAddress"/>Recipient Shipping Address:  
	        	<form:errors path="recAddress"/>
	        	<form:input path="recAddress" placeholder="${user.streetAddress}"/>
        	</div>
        		<div>
	        	<form:label path="recAddress2"/>Building/Apt No. :  
	        	<form:errors path="recAddress2"/>
	        	<form:input path="recAddress2" placeholder="${user.streetAddress2}"/>
        	</div>
        		<div>
	        	<form:label path="recCity"/>Recipient City:   
	        	<form:errors path="recCity"/>
	        	<form:input path="recCity" placeholder="${user.city}"/>
        	</div>
        		<div>
	        	<form:label path="recState"/>Recipient State:  
	        	<form:errors path="recState"/>
	        	<form:select path="recState" placeholder="${user.state}">
				<c:forEach items="${states }" var="state">
					<option value="${state }">${state }</option>
				</c:forEach>
			</form:select>
        	</div>
        	<div>
			<form:label path="recZip"/>Recipient Zip Code: 
			<form:errors path="recZip"/>
			<form:input path="recZip" placeholder="${user.zip}"/>
		</div>
		<input class="button" type="submit" value="View Order Summary">
        </form:form> 
        </div>
        			<footer>
            	<p>Succs4U.com</p>
        	</footer>
    <script src="/js/homepage.js" async defer></script>
</body>
</html>