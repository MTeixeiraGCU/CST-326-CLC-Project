<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="row">
	<img src="resources/img/logo.jpg" class="col-sm-4 img-responsive" alt="Banner Logo">
	<h2 class="col-sm-4 text-center my-3">Michelle's Store</h2>
</div>

<div class="container mt-3">

	<!-- Each type of clothing should get its own carousel -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">

		<div class="carousel-inner">

			
			<div class="carousel-item active">
			
				<!-- Loop here for each product of this type every three needs to create a new card-group-->
				<div class="card-group">
			<c:set var="counter" value="0" scope="page"/>	
			<c:forEach var="product" items="${models.products}">
				<c:if test="${counter % 3 == 0}">
					<c:if test="${counter > 0}">
						<c:out value="</div>" escapeXml="false"/>
						<c:out value="</div>" escapeXml="false"/>
						<c:out value="<div class='carousel-item'>" escapeXml="false"/>
						<c:out value="<div class='card-group'>" escapeXml="false"/>
					</c:if>
				</c:if>
				
					<div class="card">
						<img class="card-img-top" src="..." alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${product.name}</h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 3 mins ago</small>
						</div>
					</div>
					
					<c:set var="counter" value="${counter + 1}" scope="page"/>
			</c:forEach>
			
			<c:set var="leftOvers" value="${counter % 3}" />
			<c:if test="${leftOvers != 0}">
			<c:forEach var="count" begin="0" end="${(3 - leftOvers) - 1}">
					<div class="card">
					</div>
			</c:forEach>
			</c:if>
				
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon bg-dark border border-dark rounded-circle" aria-hidden="true"  style="left: 0; position: absolute;"></span>
				<span class="sr-only">Previous</span>
			</a> 
			<a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
				<span class="carousel-control-next-icon bg-dark border border-dark rounded-circle" aria-hidden="true" style="right: 0; position: absolute;" ></span>
				<span class="sr-only">Next</span>
			</a>
			
		</div>
	</div>
</div>