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
        <link rel="stylesheet" href="/css/howitworks.css">
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
        <h1>How It Works</h1>
       	<img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
        <p class="open">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sunt dolore, beatae consectetur minus architecto voluptas alias accusantium officiis nemo hic possimus nihil reiciendis omnis. Impedit quas nostrum non porro asperiores.Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sunt dolore, beatae consectetur minus architecto voluptas alias accusantium officiis nemo hic possimus nihil reiciendis omnis. Impedit quas nostrum non porro asperiores.</p>
  		<div class="sub-progress">
	  		<div class="step-1">
	  			<img src="/images/clock.png" height="190px" width="190px">
	  			<p>Create an Account and Choose Your Subscription</p>
	  		</div>
	  			<img class="arrow" src="/images/arrow.png" height="100px" width="100px">
	  		<div class="step-2">
	  			<img src="/images/shoppingcart.png" height="200px" width="200px">
	  			<p>Pick Your Succs!</p>
	  		</div>
	  		<img class="arrow" src="/images/arrow.png" height="100px" width="100px">
	  		<div class="step-3">
	  			<img src="/images/customizedplant.png" height="200px" width="200px">
	  			<p>Customize!</p>
	  		</div>
	  		<img class="arrow" src="/images/arrow.png" height="100px" width="100px">
	  		<div class="step-4">
	  			<img src="/images/shippingtruck.png" height="210px" width="220px">
	  			<p>We'll let you know when your box is shipped!</p>
	  		</div>
  		</div>
  		<div class="included">
  			<h2>What's included in your Subscription box?</h2>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sunt dolore, beatae consectetur minus architecto voluptas alias accusantium officiis nemo hic possimus nihil reiciendis omnis. Impedit quas nostrum non porro asperiores.Lorem ipsum dolor sit amet consectetur, adipisicing elit. Sunt dolore, beatae consectetur minus architecto voluptas alias accusantium officiis nemo hic possimus nihil reiciendis omnis. Impedit quas nostrum non porro asperiores.</p>
  		<img src="/images/shippingboxicon.png" height="250px" width="250px">
  		</div>
            <form method="get" action="/subscribe">
            <button class="subscribe" type="submit">Subscribe Now!</button>
            </form>
        
      
       
        <footer>
            <p>Succs4U.com</p>
        </footer>
        <script src="/js/homepage.js" async defer></script>
    </body>
</html>