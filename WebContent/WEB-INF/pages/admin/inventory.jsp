<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="container mt-3">

	<h3 class="my-3">Inventory</h3>
	<p>${msg}</p>
	<hr />
	<div class="row">
	
		<div class="col-sm-6">
			<div class="panel" id="inventoryPanel">
				<div class="panel-body">
					<ul class="list-group" id="productList">
						<c:forEach var="product" items="${products}">
							<li class="list-group-item">${product.name} Cost: ${product.cost}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<input class="btn btn-primary" id="removeProduct" type="button" value="Remove Selected Product"/>
		</div>
		
		<div class="col-sm-6">
			
			<form:form method="POST" action="addProduct" modelAttribute ="newProduct">		    
				
				<!-- Binding for server-side form errors -->
				<c:set var="imageHasBindError">
					<form:errors path="image" />
				</c:set>
				<c:set var="nameHasBindError">
					<form:errors path="name" />
				</c:set>
				<c:set var="nameHasBindError">
					<form:errors path="cost" />
				</c:set>
				
				<!-- Form fields -->
				<div class="form-group row">
			    	<form:label id="image" path="image" class="col-sm-2 col-form-label">Image: </form:label>
			    	<div class="col-sm-6"> 
			        	<form:input id="image" path="image" class="form-control ${not empty imageHasBindError?'is-invalid':''}"/>
			        	<div class="invalid-feedback">
			        		${imageHasBindError}
			       		</div>
			       	</div>
			       	<div class="col-sm-2">
			       		<input class="btn btn-primary" id="loadImage" type="button" value="Load"/>
			       	</div>
				</div>
				
				<div class="form-group row">
			    	<form:label id="name" path="name" class="col-sm-2 col-form-label">Name: </form:label>
			    	<div class="col-sm-6"> 
			        	<form:input id="name" path="name" class="form-control ${not empty nameHasBindError?'is-invalid':''}"/>
			        	<div class="invalid-feedback">
			        		${nameHasBindError}
			       		</div>
			       	</div>
				</div>
				
				<div class="form-group row">
			    	<form:label id="costDollars" path="costDollars" class="col-sm-2 col-form-label">Cost:</form:label>
			    	<div class="col-sm-2"> 
			        	<form:input id="costDollars" path="costDollars" class="form-control ${not empty costDollarsHasBindError?'is-invalid':''}"/>
			        </div>
			        <form:label id="costCents" path="costCents" class="col-sm-1 col-form-label">.</form:label>
			        <div class="col-sm-2">
			        	<form:input id="costCents" path="costCents" class="form-control ${not empty costCentsHasBindError?'is-invalid':''}"/>
			        	<div class="invalid-feedback">
			        		${costDollarsHasBindError}
			        		${costCentsHasBindError}
			       		</div>
			       	</div>
				</div>
				
				<div class="form-group row">
			    	<form:label id="description" path="description" class="col-sm-2 col-form-label">Description: </form:label>
			    </div>
			    <div class="form-group row">
			    	<div class="col-sm-8 offset-sm-2"> 
			        	<form:textarea id="description" path="description" rows="3" class="form-control ${not empty descriptionHasBindError?'is-invalid':''}"/>
			        	<div class="invalid-feedback">
			        		${descriptionHasBindError}
			       		</div>
			       	</div>
				</div>
		
		
				<div class="form-group row">
					<div class="col-sm-12">
		        		<input class="btn btn-primary" id="sub" type="submit" value="Add Product"/>
		        	</div>
		        </div>
		       
		  	</form:form>
			<hr/>
			<div class="row">
				<div class="col-sm-2 offset-sm-2">
					<input class="btn btn-primary" id="saleMenu" type="button" value="Sales Menu"/>
				</div>
				<div class="col-sm-2 offset-sm-2">
					<input class="btn btn-primary" id="discountMenu" type="button" value="Discounts Menu"/>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

$(document).ready(function(){
	$('#inventoryPanel').css("max-height", "500px")
	$('#inventoryPanel').css("margin-bottom", "10px")
	$('#inventoryPanel').css("overflow", "scroll")
})

$('#productList li').on('click', function() {
	$('#productList li').removeClass("active");
	$(this).css("background-color", "");
	$(this).addClass("active");
})

$('#productList li').mouseover( function() {
	if(!$(this).hasClass("active")){
		$(this).css("background-color", "AliceBlue");
	}
})

$('#productList li').mouseout( function() {
	if(!$(this).hasClass("active")){
		$(this).css("background-color", "");
	}
})

</script>
