<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-light bg-light">

	<a href="/CLCProject/" class="navbar-brand">
		<img src="resources/img/download.png"  height="28" alt="Logo">
	</a>

	<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
    	<span class="navbar-toggler-icon"></span>
    </button>
	
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<div class="navbar-nav">
			<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/"}'> active</c:if>" href="/CLCProject/">Home</a>
		</div>
		
		<c:choose>
			<c:when test="${empty sessionScope.userName}">
				<div class="navbar-nav ml-auto">
					<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/login"}'> active</c:if>" href="/CLCProject/login">Login</a>
					<a class="nav-item nav-link<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/CLCProject/register"}'> active</c:if>" href="/CLCProject/register">Register</a>
				</div>
			</c:when>
			
			<c:otherwise>
			
				<!-- admin access and login specific goes here -->
				
				<div class="navbar-nav ml-auto">
					<a class="nav-item nav-link" href="/CLCProject/logout">Logout</a>
				</div>
		
			</c:otherwise>
	  	</c:choose>
	  	
  	</div>
</nav>