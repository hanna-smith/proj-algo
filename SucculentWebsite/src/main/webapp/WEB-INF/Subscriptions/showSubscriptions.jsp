<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start Your Subscription</title>
        <link rel="javascript" href="/js/homepage.js">
        <link rel="stylesheet" href="/css/template.css">
        <link rel="stylesheet" href="/css/mysubs.css">
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
         <img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
	<h1>${user.fName}'s Subscriptions</h1>
	<table>
					<thead>
						<tr>
							<th>Subscription Details</th>
							<th>Shipment Date</th>
							
							<th>Recipient</th>
							<th>Delivery Address</th>
							<th>Message</th>
							<th>Subscription Date</th>
							<th>Actions</th>
						</tr>
					</thead>
				<tbody>
					<c:forEach items="${user.subscriptions}" var="subscription">
					<tr>
						<td>${subscription.numOfPlants}<br>${subscription.subLengthInMonths}</td>
						<td>${subscription.shipmentDate}</td>
						
						<td>${subscription.reciever}</td>
						<td>${subscription.recAddress}<br>${subscription.recAddress2}<br>${subscription.recCity}, ${subscription.recState}<br>${subscription.recZip}</td>
						<td>${subscription.optionalMessage}</td>
						<td><fmt:formatDate value="${ subscription.createdAt}" pattern="MMM dd, yyyy"/></td>
						<td><a href="/ordersummary/${subscription.id}">Order Summary</a> <a href="/deleteSub/${subscription.id}">Cancel</a></td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
    <footer>
        <p>Succs4U.com</p>
    </footer>
    <script src="/js/homepage.js" async defer></script>
</body>
</html>