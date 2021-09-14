<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<div class="row">
		<img src="resources/img/logo.jpg" class="col-sm-4 img-responsive" alt="Banner Logo">
		<h2 class="col-sm-4 text-center my-3">Michelle's Store</h2>
	</div>
	
	
	<div class="container mt-3">

     	<!-- Table at the top of the page -->
     	<table class="table table-dark">
     		<thead>
     			<tr>
     				<th>First Name</th>
     				<th>Last Name</th>
     			</tr>
     		</thead>
     		<tbody>
     			<tr>
     				<td>Marc</td>
     				<td>Teixeira</td>
     			</tr>
     			<tr>
     				<td>Michelle</td>
     				<td>Teixeira</td>
     			</tr>
     			<tr>
     				<td>Drake</td>
     				<td>Teixeira</td>
     			</tr>
     			<tr>
     				<td>Teddie</td>
     				<td>Teixeira</td>
     			</tr>
     			
     			<tr>
     				<td>${user.firstName}</td>
     				<td>${user.lastName}</td>
     			</tr>
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
       		
<!--         		<div class="form-group row"> -->
<%--         			<form:label path="gender" class="col-sm-2 col-form-label">Gender</form:label> --%>
<!--         			<div class="col-sm-2"> -->
<!--         				<select id="gender" class="form-control"> -->
<!--         					<option>Male</option> -->
<!--         					<option>Female</option> -->
<!--         					<option>Other</option> -->
<!--         				</select> -->
<!--         			</div> -->
<!--         		</div> -->
       			
       		<div class="form-group row">	
       			<div class="col-sm-10 offset-sm-2">
       				<button type="submit" class="btn btn-primary">Confirm </button>
       			</div>	
       		</div>
       		
       	</form:form>
        
    </div>