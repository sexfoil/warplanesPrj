<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Warplanes Market (JavaWEB final project by Slava Poliakov)</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="shortcut icon" href="img/favicon.png" type="image/png">
	
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    
    <!--Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Belgrano|Courgette&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

    
    <!--Bootshape-->
    <link href="css/bootshape.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <!-- Navigation bar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">Warplanes Market</a>
        </div>
        <nav role="navigation" class="collapse navbar-collapse navbar-right">
          <ul class="navbar-nav nav">
            
            <li class="dropdown">
              <a data-toggle="dropdown" href="#" class="dropdown-toggle">Warplanes<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="active"><a href="products.sly?category=interceptor&addId=0">Interceptor</a></li>
                <li><a href="products.sly?category=ground-attack&addId=0">Ground-attack</a></li>				
                <li><a href="products.sly?category=reconnaissance&addId=0">Reconnaissance</a></li>
                <li class="divider"></li>
                <li><a href="products.sly?category=all&addId=0">All</a></li>
              </ul>
            </li>
			
            <li><a href="contacts.sly">Contacts</a></li>
			
        <c:choose>
		  <c:when test="${sessionScope.user != null}">
		  
		    <li><a href="cart.sly?remove=false&id=0">
				Cart: <c:out value="${sessionScope.cost / 1000000}"/>
			</a></li>
			
			<li class="dropdown">
              <a data-toggle="dropdown" href="" class="dropdown-toggle"><strong>${sessionScope.user.name}</strong><b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="active"><a href="contacts.sly">Contacts</a></li>
                <li><a href="cart.sly?remove=false&id=0">Cart</a></li>              
                <li class="divider"></li>
                <li><a href="login.sly?logout=true">LogOut</a></li>
              </ul>
            </li>
		  </c:when>
		  <c:otherwise>
		  	<li class="dropdown">
              <a data-toggle="dropdown" href="" class="dropdown-toggle">Visitor<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="active"><a href="contacts.sly">Contacts</a></li>
                <!--<li><a href="cart.sly">Cart</a></li> -->
                <li><a href="register.sly">Register</a></li>
                <li class="divider"></li>
                <li><a href="login.sly?logout=false">LogIn</a></li>
              </ul>
            </li>

		  </c:otherwise>
		</c:choose>	
          </ul>
        </nav>
      </div>
    </div><!-- End Navigation bar -->

    