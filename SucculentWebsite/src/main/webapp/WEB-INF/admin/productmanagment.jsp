<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start Your Subscription</title>
        <link rel="javascript" href="/js/homepage.js">
        <link rel="stylesheet" href="/css/template.css">
        <link rel="stylesheet" href="/css/productmanagement.css">
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
                <li><a href="<c:url value="/login?logout" />" onclick="window.open('/login?logout','_self')">Logout</a></li>
            </ul>
        </nav>
         <img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
        <h1>Product Management Page</h1>
	<form method="get" action="/admin/addProduct">
		<input class="button" type="submit" value="Add new Product">
	</form>
	<form method="get" action="/admin/addCategory">
		<input class="button" type="submit" value="Add new Category">
	</form>
	<form method="get" action="/admin">
			<input class="button" type="submit" value="Back to Admin Page">
		</form>
    <footer>
        <p>Succs4U.com</p>
    </footer>
    <script src="/js/homepage.js" async defer></script>
</body>
</html>