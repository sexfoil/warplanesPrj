<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<!-- Some content if needed... -->
    <div class="jumbotron">
      <div class="container">
        <div class="col-xs-12">
			<!-- some -->			
        </div>
      </div>
    </div><!-- Some content if needed... -->


<c:choose>
  <c:when test="${sessionScope.isEmpty == true}">
	Empty parameters!!!
  </c:when>
  <c:otherwise>
<!-- Thumbnails -->
    <div class="container thumbs">
	<c:choose>
	  <c:when test="${planeID != 0}">
		<c:forEach items="${sessionScope.productsList}" var="item">
		  <c:if test="${planeID == item.plane_id}">
		  <div class="col-sm-12 col-md-12">
			<div class="thumbnail">
			  <img src="img/planes/${item.picture}" alt=${item.picture} class="img-responsive">
			  <div class="caption" >
				<h3 class="" align="center">${item.mark}-${item.model} ${item.name}</h3>            
				<p>
					Role: ${item.role}</br>
					Country: ${item.country}</br></br>
					<b>Characteristics:</b></br>
					Crew: ${item.crew} person(s);</br>
					Maximum speed: ${item.maxSpeed} km/h;</br>
					Service ceiling: ${item.serviceCeiling} m;</br></br>
					<b>Description:</b></br>
					${item.description}</br></br></br>
					<b>Price: $ ${item.price / 1000000}M</b></br>
					
				</p>	
				<div class="btn-toolbar text-center">     
				<c:if test="${sessionScope.user != null}">
				  <a href="/" 
				  role="button" class="btn btn-primary pull-left">Buy it now</a>	
				  
				  <a href="products.sly?category=${sessionScope.prePage}&addId=${item.plane_id}" 
				  role="button" class="btn btn-primary pull-center">Add to cart</a>	
				</c:if>  
				  <a href="products.sly?category=${sessionScope.prePage}&addId=0" 
				  role="button" class="btn btn-primary pull-right">Back to list</a>	
				</div>
			  </div>
			</div>
		  </div>
		  </c:if>
		</c:forEach>
	  </c:when>
	  <c:otherwise>
	  </c:otherwise>
	</c:choose>
	
	<c:forEach items="${sessionScope.productsList}" var="item">
		<c:if test="${planeID != item.plane_id}">
		  <div class="col-sm-6 col-md-4">
			<div class="thumbnail">
			  <img src="img/planes/${item.picture}" alt=${item.picture} class="img-responsive">
			  <div class="caption" align="center">
				<h3 class="" align="center">${item.mark}-${item.model} ${item.name}</h3>            
				<p>
				  Role: ${item.role}</br>
				  Country: ${item.country}</br>			
				  <b>$ ${item.price / 1000000}M</b>
				</p>
				<div class="btn-toolbar text-center">              
				  <!--<a href="cart.sly" role="button" class="btn btn-primary pull-left">Add to cart</a>		-->		  
				  <form method="post">
					<input type="hidden" name="seeDetails" value="${item.plane_id}"/>
					<input type="submit" value="See details" role="button" class="btn btn-primary pull-center"/>
				  </form>
				</div>
			  </div>
			</div>
		  </div>
		</c:if>
	</c:forEach>
    </div><!-- End Thumbnails -->
  </c:otherwise>
</c:choose>

<%@ include file="footer.jsp" %>