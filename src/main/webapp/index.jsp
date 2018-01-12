<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="WEB-INF/jsp/header.jsp" %>

    <!-- Slide gallery -->
    <div class="jumbotron">
      <div class="container">
        <div class="col-xs-12">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
            <li data-target="#carousel-example-generic" data-slide-to="4"></li>
            <li data-target="#carousel-example-generic" data-slide-to="5"></li>
          </ol>
          <!-- Wrapper for slides -->
          <div class="carousel-inner">
            <div class="item active">
              <img src="img/carousel1.jpg" alt="carousel1.jpg">
              <div class="carousel-caption">
              </div>
            </div>
            <div class="item">
              <img src="img/carousel2.jpg" alt="carousel2.jpg">
              <div class="carousel-caption">
              </div>
            </div>
            <div class="item">
              <img src="img/carousel3.jpg" alt="carousel3.jpg">
              <div class="carousel-caption">
              </div>
            </div>
            <div class="item">
              <img src="img/carousel4.jpg" alt="carousel4.jpg">
              <div class="carousel-caption">
              </div>
            </div>
            <div class="item">
              <img src="img/carousel5.jpg" alt="carousel5.jpg">
              <div class="carousel-caption">
              </div>
            </div>
            <div class="item">
              <img src="img/carousel6.jpg" alt="carousel6.jpg">
              <div class="carousel-caption">
              </div>
            </div>
          </div>
          <!-- Controls -->
          <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
          </a>
          <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
        </div>
        </div>
      </div><!-- End Slide gallery -->
    </div>

    <!-- Thumbnails -->
    <div class="container thumbs">
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img src="img/menu/mainintercept.jpg" alt="mainintercept.jpg" class="img-responsive">
          <div class="caption" align="center">
            <h3 class="">Interceptor aircraft</h3>
            <p>An interceptor aircraft is a type of fighter aircraft designed 
			specifically to attack enemy aircraft, particularly bombers and 
			reconnaissance aircraft, as they approach.</p>
            <div class="btn-toolbar text-center">              
              <a href="products.sly?category=interceptor&addId=0" role="button" class="btn btn-primary pull-center">Explore</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img src="img/menu/mainground.jpg" alt="mainground.jpg" class="img-responsive">
          <div class="caption" align="center">
            <h3 class="">Ground-attack aircraft</h3>
            <p>A ground-attack is a combat aircraft designed to attack ground 
			and sea targets by dropping air-to-ground weaponry, firing 
			torpedoes or deploying air-launched cruise missiles.</p>
            <div class="btn-toolbar text-center">              
              <a href="products.sly?category=ground-attack&addId=0" role="button" class="btn btn-primary pull-center">Explore</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img src="img/menu/mainreconn.jpg" alt="mainreconn.jpg" class="img-responsive">
          <div class="caption" align="center">
            <h3 class="">Reconnaissance aircraft</h3>
            <p>A reconnaissance aircraft is a manned or unmanned military aircraft 
			designed, or adapted, to carry out aerial reconnaissance.
			Their roles are to collect intelligence.</p>
            <div class="btn-toolbar text-center">
              <a href="products.sly?category=reconnaissance&addId=0" role="button" class="btn btn-primary pull-center">Explore</a>
            </div>
          </div>
        </div>
      </div>
    </div><!-- End Thumbnails -->
    <!-- Content -->
    <div class="container">
      <div class="">
        <h3 class="">About</h3>
        <p>
			A military aircraft is any fixed-wing or rotary-wing 
			aircraft that is operated by a legal or insurrectionary 
			armed service of any type. Military aircraft can 
			be either combat or non-combat:			
			<br/>
			Combat aircraft are designed to destroy enemy equipment using their own aircraft ordnance. 
			Combat aircraft are normally developed and procured only by military forces.
			<br/>
			Non-combat aircraft are not designed for combat as their primary function, 
			but may carry weapons for self-defense. These mainly operate in support roles, 
			and may be developed by either military forces or civilian organizations.

		</p>
      </div>
      <div class="row">
        <div class="col-sm-8">
          <h3 class="">Evolution</h3>
          <img src="img/evolution.jpg" alt="evolution.jpg" class="img-responsive">
          <br>
          <p>
			In the 100th year of powered manned flight, it is appropriate that we step back and 
			review the evolution of military aviation and look ahead to the future. 
			How did the United States achieve its current dominance in the air? 
			I believe many factors have played a role - innovations by aerospace engineers from many nations, 
			the visionary ideas of a few individuals, and the means (and willingness) to spend significant 
			portions of our wealth on military equipment. America was founded by people seeking to distance 
			themselves from relatively static societies, people attracted to building 
			a new land and developing a new society. The spirit of these individuals, as embodied 
			in America’s engineers, is largely responsible for our success as a nation and particularly 
			for our success as aviation innovators.
		  </p>
        </div>
        <div class="col-sm-4">
          <h3 class="">News & Events</h3>
          <div class="event">
            <div class="text-right date">05/12/2016</div>
            <p>
			(CNN) The undisputed superstar of the skies -- the biggest airplane in the world -- 
			is taking flight on a rare delivery mission across three continents.</br>
			The Ukrainian cargo jet named "Mriya" is one of a kind. There is no other.</br>
			That's why the gawkers showed up Tuesday in Prague. They watched in awe as this big 
			boy defied gravity before it touched down at Vaclav Havel Airport in the Czech Republic.</br>
			Officially designated as the Antonov An-225, the plane was developed in the 1980s 
			to carry the Soviet version of the space shuttle on its back. 
			</p>
            <div class="text-right">
              <a href="http://edition.cnn.com/travel/article/worlds-biggest-airplane-ukraine-prague-australia/index.html">See more...</a>
            </div>
          </div>
          <div class="event">
            <div class="text-right date">03/01/2015</div>
            <p>The Australian International Aerospace and Defence Exposition 2015 
			is a project of Aerospace Australia Limited (ABN 63 091 147 787).</br>
			It will be held at Avalon concurrently with the Australian International Airshow 2015 
			which is a project of Aviation Development Australia Limited (ABN 54 114 966 175).</br>
			The Exposition and the Airshow are presented in the interest of promoting the development 
			of aviation and Australian industrial, manufacturing and information/communications 
			technology resources in the aviation, aerospace and defence sectors.
			</p>
            <div class="text-right">
              <a href="http://www.airshow.com.au/airshow2015/PUBLIC/airshow/welcome.asp">See more...</a>
            </div>
          </div>

        </div>
      </div>
    </div><!-- End Content -->

<%@ include file="WEB-INF/jsp/footer.jsp" %>

<!--
TEMPLATE
Name: Zoo Planet
Version: 1.0
Created: 23 January 2014

AUTHOR
Design and code by: http://www.bootshape.com
Free stock photos by: http://www.bootshape.com

Read full license: http://www.bootshape.com/license.php

CREDITS
Background: http://subtlepatterns.com/ (extra_clean_paper)
Fonts: http://www.google.com/fonts (Actor, Duru_Sans)

SUPPORT
E-mail: bootshape.com@gmail.com
Contact: http://www.bootshape.com/contact.php
-->