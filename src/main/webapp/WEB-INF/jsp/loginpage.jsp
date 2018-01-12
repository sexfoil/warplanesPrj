<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<!-- Login logo -->
    <div class="jumbotron">
      <div class="container">
		<div class="col-xs-2">
			<!--<img src="img/menu/loginbutton.jpg" alt="buy" class="img-responsive">-->
        </div>
        <div class="col-xs-8" align="center">
			<img src="img/menu/customerlogin.png" alt="customerlogin.png" class="img-responsive">	
        </div>
		<div class="col-xs-2">
			<!--<img src="img/menu/customerlogin.jpg" alt="buy" class="img-responsive">-->			
        </div>
      </div>
    </div><!-- End Login logo -->
	
<!-- Logging -->
<c:choose>
  <c:when test="${sessionScope.user == null}">
  
  <!-- Register message -->
	<div class="jumbotron">
      <div class="container">
		<div class="col-xs-3">
			<!--<img src="img/menu/loginbutton.jpg" alt="buy" class="img-responsive">-->
        </div>
        <div class="col-xs-6" align="center">
			
			<h4><font color="red">${sessionScope.wrong}</font></h4>
			
        </div>
		<div class="col-xs-3">
			<!--<img src="img/menu/customerlogin.jpg" alt="buy" class="img-responsive">-->			
        </div>
      </div>
    </div><!-- End Register message -->
	

    <div class="container thumbs">
      <div class="col-sm-2 col-md-2">
        <div>
          <!--left-->
        </div>
      </div>
      <div class="col-sm-8 col-md-8">
        <div align="center">
          <form action="" method="post">
			<img src="img/menu/logicon.png" alt="logicon.png" class="img-responsive">
			<input type="text" name="login" value="${oldLog}" placeholder="Enter login"/></br></br>
			<img src="img/menu/passicon.png" alt="passicon.png" class="img-responsive">
			<input type="password" name="password" placeholder="Enter password"/></br>
			</br>
			<input type="image" src="img/menu/login_small.png" />	
          </form>
        </div>
      </div>
      <div class="col-sm-2 col-md-2">
        <div>
          <!--right-->
        </div>
      </div>
    </div><!-- End Logging -->
  </c:when>
  <c:otherwise>
    <div align="center">
		<h2><font color="blue">Welcome ${sessionScope.user.name}!</font></h2>
	</div>
  </c:otherwise>
</c:choose>

<%@ include file="footer.jsp" %>