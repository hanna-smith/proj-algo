<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add A Category</title>
        <link rel="javascript" href="/js/homepage.js">
        <link rel="stylesheet" href="/css/template.css">
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
                <li><a href="<c:url value="/login?logout" />" onclick="window.open('/login?logout,'_self')">Logout</a></li>
            </ul>
        </nav>
         <img class="succ-icon" src="/images/succulenticon.webp">
        <img id="overlay-one" src="/images/succulenticon.webp">
        <img id="overlay-two" src="/images/succulenticon.webp">
        <div class="content">
        		<h1>New Category</h1>
		<form:form action="/admin/addCategory" method="POST" modelAttribute="category">
		    <div class="form-group">
		        <form:label path="name">Name: </form:label>
		        <form:errors path="name"/>
		        <form:input type="name" class="form-control" path="name"/>
		    </div>
		    <button>Create</button>
		</form:form>
        <h1>Current Categories</h1>
			<table>
					<thead>
						<tr>
							<th>Category</th>
							<th>Action</th>
						</tr>
					</thead>
				<tbody>
					<c:forEach items="${allCategories}" var="category">
					<tr>
						<td>${category.name}</td>
						<td><a href="/admin/editCategory">Edit</a> <a href="/admin/deleteCategory/${category.id}">Delete</a></td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>

		<form method="get" action="/admin">
			<input class="button" type="submit" value="Back to Admin Page">
		</form>
		<form method="get" action="/admin/productManagement">
			<input class="button" type="submit" value="Back to Product Management Page">
		</form>
		</div>
        <footer>
        	<p>Succs4U.com</p>
   		</footer>
    <script src="/js/homepage.js" async defer></script>
</body>
</html>

</body>
</html>