<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="container mt-3">

	<h3 class="my-3">Sales</h3>
	<p>${msg}</p>
	<hr />
	<div class="row">
	
		<div class="col-sm-6">
			<div class="panel" id="salesPanel">
				<div class="panel-body">
					<ul class="list-group" id="salesList">
						<c:forEach var="sale" items="${sales}">
							<li class="list-group-item" id="${sale.id}">${sale.name} Amount: ${sale.amount}%</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<input class="btn btn-primary" id="removeSale" type="button" value="Remove Selected Sale"/>
		</div>
		
		<div class="col-sm-6">
			
			<form:form method="POST" action="addSale" modelAttribute ="newSale">		    
				
				<!-- Binding for server-side form errors -->
				<c:set var="nameHasBindError">
					<form:errors path="name" />
				</c:set>
				<c:set var="amountHasBindError">
					<form:errors path="amount" />
				</c:set>
				
				<!-- Form fields -->
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
			    	<form:label id="amount" path="amount" class="col-sm-2 col-form-label">Discount Amount: </form:label>
			    	<div class="col-sm-3"> 
			        	<form:input id="amount" path="amount" class="form-control ${not empty amountHasBindError?'is-invalid':''}"/>
			        </div>
			        <div class="col-sm-1">
			        	%
			        </div>
			        <div class="col-sm-5">
			        	<div class="invalid-feedback">
			        		${amountHasBindError}
			       		</div>
			       	</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-12">
		        		<input class="btn btn-primary" id="sub" type="submit" value="Add Sale"/>
		        	</div>
		        </div>
		       
		  	</form:form>
		</div>
	</div>
</div>

<script>

$(document).ready(function(){
	$('#salesPanel').css("max-height", "500px")
	$('#salesPanel').css("margin-bottom", "10px")
	$('#salesPanel').css("overflow", "scroll")
	disableRemoveButton();
})

$('#salesList li').on('click', function() {
	$('#salesList li').removeClass("active");
	$(this).css("background-color", "");
	$(this).addClass("active");
	$('#removeSale').removeClass("disabled");
	$('#removeSale').removeAttr("disabled");
})

$('#removeSale').on('click', function() {
	var ID = $('#salesList li.active').attr('id');
	$.get("removeSale", { id: ID }, 
		function(data, status) {
			if(status) {
				disableListItem($('#salesList li.active'));
			}
			alert(data);
		});
})

$('#salesList li').mouseover( function() {
	if(!$(this).hasClass("active")){
		$(this).css("background-color", "AliceBlue");
	}
})

$('#salesList li').mouseout( function() {
	if(!$(this).hasClass("active")){
		$(this).css("background-color", "");
	}
})

function disableListItem(saleItem) {
	saleItem.removeClass("active");
	saleItem.addClass("disabled bg-danger");
	saleItem.attr("disabled", "true");
	disableRemoveButton();
}

function disableRemoveButton() {
	$('#removeSale').addClass("disabled");
	$('#removeSale').attr("disabled", "true");
}

</script>
