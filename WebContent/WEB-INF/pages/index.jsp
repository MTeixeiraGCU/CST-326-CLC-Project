<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>HTML Demo Page</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	
	<!-- Navbar code -->
	<nav class="navbar navbar-expand-md navbar-light bg-light">
	
		<a href="#" class="navbar-brand">
			<img src="resources/img/download.png"  height="28" alt="Logo">
		</a>
		
		<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
		
		<div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav">
            <a href="#" class="nav-item nav-link active">Home</a>
            <a href="#" class="nav-item nav-link">Profile</a>
            <a href="#" class="nav-item nav-link">Messages</a>
            <a href="#" class="nav-item nav-link disabled" tabindex="-1">Reports</a>
        </div>
        <div class="navbar-nav ml-auto">
            <a href="#" class="nav-item nav-link">Login</a>
        </div>
    	</div>
		
	</nav>

	<img src="resources/img/logo.jpg" class="img-fluid" alt="Banner Logo">
    <h2 class="text-center my-3">HTML Demo Page</h2>
    <div class="container mt-3">

        
        	<!-- Table at the top of the page -->
        	<table class="table table-dark">
        		<thead>
        			<tr>
        				<th>First Name</th>
        				<th>Last Name</th>
        				<th>Gender</th>
        			</tr>
        		</thead>
        		<tbody>
        			<tr>
        				<td>Marc</td>
        				<td>Teixeira</td>
        				<td>Male</td>
        			</tr>
        			<tr>
        				<td>Michelle</td>
        				<td>Teixeira</td>
        				<td>Female</td>
        			</tr>
        			<tr>
        				<td>Drake</td>
        				<td>Teixeira</td>
        				<td>Male</td>
        			</tr>
        			<tr>
        				<td>Teddie</td>
        				<td>Teixeira</td>
        				<td>Male</td>
        			</tr>
        			<c:if test="${user.gender != -1}">
	        			<tr>
	        				<td>${user.firstName}</td>
	        				<td>${user.lastName}</td>
	        				<td>
		        				<c:choose>
		        					<c:when test="${user.gender == 0}">
		        						Male
		        					</c:when>
		        					<c:when test="${user.gender == 1}">
		        						Female
		        					</c:when>
		        					<c:otherwise>
		        						Other
		        					</c:otherwise>
		        				</c:choose>
	        				</td>
	        			</tr>
        			</c:if>
        			
        		</tbody>
        	</table>

        	<!-- Form to access users name and gender -->	
        	<h3 class="text-center my-3">Add yourself to the list</h3>
        	
        	<form:form method="POST" action="add" modelAttribute="user">
        	
        		<div class="form-group row">
        			<form:label path="firstName" class="col-sm-2 col-form-label">First Name</form:label>
        			<div class="col-sm-10">
        				<form:input path="firstName" type="text" class="form-control" placeholder="First"/>
        			</div>
        		</div>
        		
        		<div class="form-group row">
        			<form:label path="lastName" class="col-sm-2 col-form-label">Last Name</form:label>
        			<div class="col-sm-10">
        				<form:input type="text" class="form-control" path="lastName" placeholder="Last"/>
        			</div>
        		</div>
        		
        		<div class="form-group row">
        			<form:label path="gender" class="col-sm-2 col-form-label">Gender</form:label>
        			<div class="col-sm-2">
        				<select id="gender" class="form-control">
        					<option>Male</option>
        					<option>Female</option>
        					<option>Other</option>
        				</select>
        			</div>
        		</div>
        			
        		<div class="form-group row">	
        			<div class="col-sm-10 offset-sm-2">
        				<button type="submit" class="btn btn-primary">Confirm </button>
        			</div>	
        		</div>
        		
        	</form:form>
        
    </div>
</body>
</html>