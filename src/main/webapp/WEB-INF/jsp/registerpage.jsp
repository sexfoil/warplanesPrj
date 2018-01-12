<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<!-- Register header -->
    <div class="jumbotron">
      <div class="container">
		<div class="col-xs-4">
			<!--<img src="img/menu/loginbutton.jpg" alt="buy" class="img-responsive">-->
        </div>
        <div class="col-xs-4" align="center">
			<img src="img/menu/registration.png" alt="register.png" class="img-responsive">	
        </div>
		<div class="col-xs-4">
			<!--<img src="img/menu/loginbutton.jpg" alt="buy" class="img-responsive">-->			
        </div>
      </div>
    </div><!-- End Register header -->
	
	
<!-- Register form -->
    <div class="container thumbs">
      <div class="col-sm-3 col-md-3">
        <div>
          <!--left-->
        </div>
      </div>
      <div class="col-sm-6 col-md-6">
        <div align="center">
		  <c:choose>
			<c:when test = "${sessionScope.hiUser == true}">
			  <font color="green">
			  <h2>Nice work ${sessionScope.newUser.name}! Registration successfully copmplete!!!</br></br>
			  <a href="login.sly?logout=false">Please LogIn to continue.</a></h2>
			  </font>
			</c:when>
			<c:otherwise>
			  <form action="" method="post">
			  
				<h3><font color="red">${sessionScope.pageError}</font></h3></br>
				
				<img src="img/menu/reg_user.png" alt="reg_user.png" >
				<input type="text" name="login" value="${oldLogin}" placeholder="JohnDou"/>
				<h5><font color="red">${sessionScope.loginError}</font></h5>
				
				<img src="img/menu/reg_pass.png" alt="reg_pass.png" >
				<input type="password" name="password" placeholder="your password"/>
				<h5><font color="red">${sessionScope.passError}</font></h5>
				
				<img src="img/menu/reg_pass_confirm.png" alt="reg_pass_confirm.png" >
				<input type="password" name="password2" placeholder="confirm password"/>
				<h5><font color="red">${sessionScope.pass2Error}</font></h5>
				
				<img src="img/menu/reg_email.png" alt="reg_email.png" >
				<input type="text" name="email" value="${oldEmail}" placeholder="johndou@gmail.com"/>
				<h5><font color="red">${sessionScope.emailError}</font></h5>
				
				<img src="img/menu/reg_age.png" alt="reg_age.png" >
				<input type="number" name="age" min="1" value="${oldAge}" placeholder="age" required/>
				<h5><font color="red">${sessionScope.ageError}</font></h5>
				
				<img src="img/menu/reg_sex.png" alt="reg_sex.png" class="img-responsive">
				<input type="radio" name="sex" value="female" checked /> Female</br>
				<input type="radio" name="sex" value="male" /> Male &emsp;</br>			
				<h5><font color="red">${sessionScope.sexError}</font></h5>
				
				<img src="img/menu/reg_agree.png" alt="reg_agree.png" class="img-responsive">
				<input type="hidden" name="agree" />
				<input type="checkbox" name="agree" value="yes" />&emsp; I agree!</br>
				
				<h5><font color="red">${sessionScope.agreeError}</font></h5>
				
				<input type="image" src="img/menu/signup.png" />
				
			  </form>
			</c:otherwise>
		  </c:choose>
        </div>
      </div>
      <div class="col-sm-3 col-md-3">
        <div>
          <!--right-->
        </div>
      </div>
    </div><!-- End Register form -->


<%@ include file="footer.jsp" %>