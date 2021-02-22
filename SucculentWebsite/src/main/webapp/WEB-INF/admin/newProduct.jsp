<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a New Product</title>
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
                       <h1>New Product</h1>
        <form:form method="POST" action="/admin/addProduct" modelAttribute="product" enctype="multipart/form-data">
        	<div>
        		<form:label path="name"/>Product Name: 
        		<form:errors path="name"/>
        		<form:input path="name"/>
        	</div>
        	<div>
        		<form:label path="price"/>Price:
        		<form:errors path="price"/>
        		<form:input path="price"/>
        	</div>
        	<div>
        		<form:label path="productDescription"/> Product Description: 
        		<form:errors path="productDescription"/>
        		<form:input type="textarea" path="productDescription"/>
        	</div>
        	<div>
        		Select File: <input type="file" name="pic">
        	</div>
        	<div>
        		<form:label path="category"/>Category:
        		<form:errors path="category"/>
        		<form:select path="category">
        			<c:forEach items="${allCategories}" var="category">
        				<option value="${category.id}">${category.name}</option>
        			</c:forEach>
        		</form:select>
        	</div>
        	<input type="submit" value="Add Product">
      	</form:form>
      	
      	<form method="get" action="/admin">
			<input type="submit" value="Back to Admin Page">
		</form>
		<form method="get" action="/admin/productManagement">
			<input type="submit" value="Back to Product Management Page">
		</form>
                <h1>Current Products</h1>
			<table>
					<thead>
						<tr>
							<th>Name</th>
							<th>Picture</th>
							<th>Description</th>
							<th>Price</th>
							<th>Category</th>
							<th>Action</th>
						</tr>
					</thead>
				<tbody>
					<c:forEach items="${allProducts}" var="product">
					<tr>
						<td>${product.name}</td>
						<td><img src="${product.image_url}" height="60px" width="60px"></td>
						<td>${product.productDescription}</td>
						<td>$ ${product.price}</td>
						<td>${product.category.name}</td>
						<td><a href="/admin/editProduct/${product.id}">Edit</a> <a href="/admin/deleteProduct/${product.id}">Delete</a></td>
					
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

</body>
</html>