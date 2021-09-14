<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<div class="container mt-3">

	<h3 class="my-3">Register</h3>
	<hr />
	
	<form:form method="POST" action="registerUser" modelAttribute ="user">		    
			
		<!-- Binding for server-side form errors -->
		<c:set var="userNameHasBindError">
			<form:errors path="email" />
		</c:set>
		<c:set var="passwordHasBindError">
			<form:errors path="password" />
		</c:set>
		<c:set var="firstNameHasBindError">
			<form:errors path="firstName" />
		</c:set>
		<c:set var="lastNameHasBindError">
			<form:errors path="lastName" />
		</c:set>
		<c:set var="addressHasBindError">
			<form:errors path="address.addressOne" />
		</c:set>
		<c:set var="phoneNumberHasBindError">
			<form:errors path="address.phoneNumber" />
		</c:set>
		
		<!-- Form fields -->
		<div class="form-group row">
	    	<form:label id="email" path="email" class="col-sm-2 col-form-label">Email: </form:label>
	    	<div class="col-sm-8"> 
	        	<form:input id="email" path="email" class="form-control ${not empty userNameHasBindError?'is-invalid':''}"/>
	        	<div class="invalid-feedback">
	        		${userNameHasBindError}
	       		</div>
	       	</div>
		</div>
			
		<div class="form-group row">
	         <form:label id="password" path="password" class="col-sm-2 col-form-label">Password: </form:label>
	         <div class="col-sm-8">
	         	<form:password id="password" path="password" class="form-control ${not empty passwordHasBindError?'is-invalid':''}"/>
	         	<small id="passwordHelpBlock" class="form-text text-muted">
  					Your password must be 6-18 characters long, contain at least one letter, one number, one symbol, and must not contain spaces.
				</small>
	         	<div class="invalid-feedback">
	        		${passwordHasBindError}
	       		</div>
	       	 </div> 
		</div>
		
		<div class="form-group row">
	         <form:label id="confirmPassword" path="confirmPassword" class="col-sm-2 col-form-label">Re-Enter Password: </form:label>
	         <div class="col-sm-8">
	         	<form:password id="confirmPassword" path="confirmPassword" class="form-control"/>
	         	<div class="invalid-feedback">
	        		<span id="confirmError"></span>
	       		</div>
	       	 </div> 
		</div>
		
		<hr/>
		
		<div class="form-group row">
	         <form:label id="firstName" path="firstName" class="col-sm-2 col-form-label">First Name: </form:label>
	         <div class="col-sm-8">
	         	<form:input id="firstName" path="firstName" class="form-control ${not empty firstNameHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
	        		${firstNameHasBindError}
	       		</div>
	       	 </div> 
		</div>
		<div class="form-group row">
	         <form:label id="lastName" path="lastName" class="col-sm-2 col-form-label">Last Name: </form:label>
	         <div class="col-sm-8">
	         	<form:input id="lastName" path="lastName" class="form-control ${not empty lastNameHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
	        		${lastNameHasBindError}
	       		</div>
	       	 </div> 
		</div>
		
		<hr/>
		
		<div class="form-group row">
	         <form:label id="address" path="address.addressOne" class="col-sm-2 col-form-label">Address: </form:label>
	         <div class="col-sm-8">
	         	<form:input id="address" path="address.addressOne" class="form-control ${not empty addressHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
	        		${addressHasBindError}
	       		</div>
	       	 </div> 
		</div>
		<div class="form-group row">
	         <form:label id="phoneNumber" path="address.phoneNumber" class="col-sm-2 col-form-label">Phone Number: </form:label>
	         <div class="col-sm-8">
	         	<form:input id="phoneNumber" path="address.phoneNumber" class="form-control ${not empty phoneNumberHasBindError?'is-invalid':''}"/>
	         	<div class="invalid-feedback">
	        		${phoneNumberHasBindError}
	       		</div>
	       	 </div> 
		</div>

		<div class="form-group row">
			<div class="col-sm-12">
        		<input class="btn btn-primary" id="sub" type="submit" value="Submit"/>
        	</div>
        </div>
        
  	</form:form>
		
</div>

<script>

function checkPassword(){
	  var passwordOne = $("input#password").val();
	  var passwordTwo = $("input#confirmPassword").val();
	  var matching = passwordOne == passwordTwo;
	  
	  if(!matching){
		  $("input#confirmPassword").addClass("is-invalid");
		  $("#confirmError").text("Passwords must match!");
	  }
	  else{
		  $("input#confirmPassword").removeClass("is-invalid");
		  $("#confirmError").text("");
	  }
}

$(document).ready(function(){
	  
	  $("input#sub").mouseover(function(){
		  $(this).stop();
		  $(this).animate({"font-size": "18px"}, 250);
	  });
	  
	  $("input#sub").mouseout(function(){
		  $(this).stop();
		  $(this).animate({"font-size": "16px"}, 250);
	  });
	  
	  $("input#confirmPassword").keyup(checkPassword);
	  $("input#password").keyup(checkPassword);
});
</script>
