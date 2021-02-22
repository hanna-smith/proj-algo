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
        <link rel="stylesheet" href="/css/template.css">
        <link rel="stylesheet" href="/css/whyus.css">
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
                <li><a href="/login" onclick="window.open('/login','_self')">Login</a></li>  
            </ul>
        </nav>
        <h1>Why Us?</h1>
       	<img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
        <p class="open">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sunt dolore, beatae consectetur minus architecto voluptas alias accusantium officiis nemo hic possimus nihil reiciendis omnis. Impedit quas nostrum non porro asperiores.</p>
		<div class="origin">
			<h3>How it All Started</h3>
			<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sunt dolore, beatae consectetur minus architecto voluptas alias accusantium officiis nemo hic possimus nihil reiciendis omnis. Impedit quas nostrum non porro asperiores.</p>
		</div>
		<img class="hands" src="/images/hands.jpg" height="300px" width="500px">
		<img class="sustainable" src="/images/sustainable.jpg" height="300px">
		<div class="mission">
			<h3>Our Mission</h3>
			<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sunt dolore, beatae consectetur minus architecto voluptas alias accusantium officiis nemo hic possimus nihil reiciendis omnis. Impedit quas nostrum non porro asperiores.</p>
		</div>
		
        <footer>
            <p>Succs4U.com</p>
        </footer>
        <script src="/js/homepage.js" async defer></script>
    </body>
</html>