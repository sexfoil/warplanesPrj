<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<c:if test="${sessionScope.user != null}">

<!-- Cart -->
    <div class="jumbotron">
      <div class="container">
		<div class="col-xs-5">
			<!--<img src="img/menu/cartandbuy.png" alt="cart" class="img-responsive">-->			
        </div>
        <div class="col-xs-2" align="center">
			<img src="img/menu/cart.png" alt="cart.png" class="img-responsive">
        </div>
		<div class="col-xs-5">
			<!--<img src="img/menu/buy.jpg" alt="buy" class="img-responsive">-->		
        </div>

      </div>
    </div><!-- End cart -->

<!-- Thumbnails -->
    <div class="container thumbs">
	<c:set var="cost" scope="session" value="${0}"/>
	<c:forEach items="${sessionScope.cartList}" var="item">
	<c:set var="cost" scope="session" value="${sessionScope.cost + item.product.price}"/>	
		<div class="col-sm-4 col-md-4">
			<div class="thumbnail">
			  <img src="img/planes/${item.product.picture}" alt=${item.product.picture} class="img-responsive">
			  <div class="caption" align="center">
				<h3 class="" align="center">${item.product.mark}-${item.product.model} ${item.product.name}</h3>            
				<p>
				  Role: ${item.product.role}</br>
				  Country: ${item.product.country}</br>			
				  <b>$ ${item.product.price / 1000000}M</b>
				</p>
				<div class="btn-toolbar text-center">              
				  <a href="" role="button" class="btn btn-primary pull-left">-</a>				  
				  <a href="" role="button" class="btn btn-primary pull-left">+</a>				  
				  <a href="cart.sly?remove=true&id=${item.product.plane_id}" role="button" class="btn btn-primary pull-right">Remove</a>	
				</div>
			  </div>
			</div>
		</div>		
	</c:forEach>
    </div><!-- End Thumbnails -->



<!-- Buy -->	
	<div class="jumbotron">
      <div class="container">
		<div class="col-xs-3">
			<!--<img src="img/menu/cartandbuy.png" alt="cart" class="img-responsive">-->	
				
        </div>
        <div class="col-xs-6" align="center">
			AMOUNT: $<c:out value="${sessionScope.cost / 1000000}"/>M
			<a href="/">
				<img src="img/menu/purchase.png" alt="purchase.png" class="img-responsive">
			</a>
			Will be soon...
        </div>
		<div class="col-xs-3">
			<!--<img src="img/menu/buy.jpg" alt="buy" class="img-responsive">-->		
        </div>

      </div>
    </div><!-- End Buy -->

</c:if>
<%@ include file="footer.jsp" %>