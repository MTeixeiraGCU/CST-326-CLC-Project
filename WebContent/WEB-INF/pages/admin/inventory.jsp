<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="container mt-3">

	<h3 class="my-3">Inventory</h3>
	<hr />
	<div class="row">
	
		<div class=" panel col-sm-6" id="inventoryPanel">
		<div class="panel-body">
			<ul class="list-group" id="productList">
				<c:forEach var="product" items="${products}">
					<li class="list-group-item">${product.name}</li>
				</c:forEach>
			
			</ul>
		</div>
		</div>
		
		<div class="col-sm-6">
			<form:form method="POST" action="addProduct" modelAttribute ="user">		    
		
				<div class="form-group row">
					<div class="col-sm-12">
		        		<input class="btn btn-primary" id="sub" type="submit" value="Submit"/>
		        	</div>
		        </div>
		       
		  	</form:form>
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
