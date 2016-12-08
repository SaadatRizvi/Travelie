<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">    <!-- Added it after reading from w3school -->
<html>
<head>
<title>Travelie | Home</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="${pageContext.request.contextPath}/resources/css/style2.css" rel="stylesheet" type="text/css" media="all" />	
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chocolat.css" type="text/css">

<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="Vide" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Trip Guide Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!---->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!---->
<link href='//fonts.googleapis.com/css?family=Questrial' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,800italic,800,700italic,700,600italic,600,400italic,300italic,300' rel='stylesheet' type='text/css'>
<script src="${pageContext.request.contextPath}/resources/js/jquery.chocolat.js"></script>
		<!--lightboxfiles-->
		<script type="text/javascript">
		$(function() {
			$('.gallery a').Chocolat();
		});
		</script>
<!--script-->
<!--startsmothscrolling-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources//js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources//js/easing.js"></script>
 <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>

<script src="${pageContext.request.contextPath}/resources//js/modernizr.custom.97074.js"></script>
</head>
<body>
	<div class="banner-section">
		<div class="container">
			<div class="banner-heder">
				<h3>Let Us Plan Your Trip!<span>Best Available Choice in Topi</span></h3>
			</div>
			<div class="banner-grids">
                <div class ="row">
                 <form:form commandName="newWebdata"
							name="createWebdataForm" method="POST"
							action="${pageContext.request.contextPath}/homepage?tAction=create">
						<!--  	action="${pageContext.request.contextPath}/fixedDeposit?fdAction=create">    -->
							
						<div class="col-md-2 banner-grid">
				
					
							   <!-- Spring tags added by Saadat -->
               
							<form:select path="destination" items="${destinationList}" /><font
								style="color: #C11B17;"><form:errors path="destination"/></font>
						
				
						</div>
		                <div class="col-md-2 banner-grid">
		               <form:input path="departureDate" type="date" />
		               <!--  <input type="date" name="usr_date">   -->
						</div>
						<div class="col-md-2 banner-grid">
						
						 <form:input path="departureTime" type="time" />
					 <!--     <input type="time" name="usr_time" > -->
						</div>
						<div class="col-md-2 banner-grid">
					 <!-- Spring tags added by Saadat -->
               
							<form:select path="type" items="${vanTypeList}" /><font
							style="color: #C11B17;"><form:errors path="type"/></font>
																				
							</div>
							
							<div class="col-md-2 banner-grid">
							</div>
							
												
				
			<!--  	<div class="col-md-2 banner-grid">
					<select class="sel">
						<option value="">Seats</option>
						<option value="">1</option>
                        <option value="">2</option>
                        <option value="">3</option>
					    <option value="">4</option>
					    <option value="">5</option>
					    <option value="">6</option>
					    <option value="">7</option>
					    <option value="">8</option>
					    <option value="">9</option>
					    <option value="">10</option>
					    <option value="">11</option>
					    <option value="">12</option>
					    <option value="">13</option>
					    <option value="">14</option>
					    <option value="">15</option>
					</select>									
				</div>   -->
				<div class="col-md-2 search">
					
						<input type="submit" value="Submit request">
					
				</div>
				
				</form:form>
                   </div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
    <div class="header">
		<div class="container">
			<div class="header-menu">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
						  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						  </button>
						  <div class="navbar-brand logo">
								<h1><a href="index.html"><span>Travelie</span></a></h1>
							</div>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						  <ul class="nav navbar-nav cl-effect-11">
							<li class="active"><a href="#" data-hover="Home" class="scroll">Home </a></li>
							<li><a href="#about" data-hover="Services" class="scroll">Services</a></li>
							<li><a href="#services" data-hover="Aptitude" class="scroll">Aptitude</a></li>
							<li><a href="#tours" data-hover="Destinations" class="scroll">Destinations</a></li>
				<!--			 <li><a data-hover="News" href="#news" class="scroll">News</a></li>
							  <li><a  href="#guides" data-hover="Guides" class="scroll">Guides</a></li> -->
							 <li><a data-hover="Contact" href="#contact" class="scroll">Contact</a></li>
							 
						  </ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			<div class="clearfix"></div>
			</div>	
		</div> 
	</div>
		<div class="content">
			<div class="promotions">
            <div class="container">
  
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Type</th>
                            <th>Departure time</th>
                            <th>Departure Date</th>
                            <th>Destination</th>
                            <th>Available seats</th>
                            <th>Your Selection</th>
                        </tr>
                   </thead>
                 <tbody>
             
                  <c:forEach var="tempCustomer" items="${webdatas}">
                 <tr>
                      <td>${tempCustomer.type}</td>
                      <td>${tempCustomer.departureTime}</td>
                      <td>${tempCustomer.departureDate}</td>
                      <td>${tempCustomer.destination}</td>
                      <td>${tempCustomer.availableSeats}</td>
                      <td><input type="radio" name="Van" value="Van"></td>
                   </tr>
                 
                  </c:forEach>
              </tbody>
                </table>
            </div>
              <div class="col-md-8 about-grid">  </div>
            <div class="col-md-1 about-grid">  </div>
            <div class="col-md-3 about-grid"> 
				<form action="http://google.com">
                    <input type="submit" value="Submit request" />
                   
                </form>
			</div>
                
            </div>
			<!--about--->
				<div class="about-section" id="about">
					<div class="container">
						<h3 class="tittle"> What  we  offer</h3>
						<div class="about-grids">
							<div class="col-md-4 about-grid">
								<img src="${pageContext.request.contextPath}/resources//images/tt2.png" class="img-responsive" alt=""/>
							</div>
							<div class="col-md-8 about-grid1">
								<div class="about-top">
									<div class="about-left">
										<i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i>
									</div>
									<div class="about-right">
										<h4>Online Booking Service</h4>
										<p>We offer you booking of your seats online with ease.</p>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="about-top1">
									<div class="about-left">
										<i class="glyphicon glyphicon-plane" aria-hidden="true"></i>
									</div>
									<div class="about-right">
										<h4>Cheap Rates</h4>
										<p>Travel and save your money. Both, at the same time.</p>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="about-top1">
									<div class="about-left">
										<i class="glyphicon glyphicon-dashboard" aria-hidden="true"></i>
									</div>
									<div class="about-right">
										<h4>24/7 Available Facility</h4>
										<p>Our service will always be there for you, whenever you need it.</p>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="about-top">
									<div class="about-left">
										<i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>
									</div>
									<div class="about-right">
										<h4>Travel Classes</h4>
										<p>Whether its Business class or Economy class, we cover it all.</p>
									</div>
									<div class="clearfix"></div>
								</div>  
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			<!--about--->
			<div class="featured-services" id="services">
				<div class="container">
					<h3 class="tittle">Our Aptitude</h3>
					<div class="featured-grids">
						<div class="col-md-3 featured-grid">
							<div class="featured-grd">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<h5>Quality</h5>
								<p>We assure that our customers get the highest quality 
									transport available in Topi at lowest possible costs.</p>
							<!--	<div class="more m2">
									<a href="#" class="btn effect6" data-toggle="modal" data-target="#myModal1">Learn More</a>
								</div>  -->
							</div>
						</div>
						<div class="col-md-3 featured-grid">
							<div class="featured-grd">
								<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
								<h5>Huge Network</h5>
								<p>Our already vast network of transport is continuosly expanding and enabling  
									our customers to travel to more cities.</p>
						<!--		<div class="more m2">
									<a href="#" class="btn effect6" data-toggle="modal" data-target="#myModal1">Learn More</a>
								</div>  -->
							</div>
						</div>
						<div class="col-md-3 featured-grid">
							<div class="featured-grd">
								<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>
								<h5>Safety</h5>
								<p>Safety is our number one priority. We never sacrifice
                                    on our customers' well-being and protection.</p>
							<!--	<div class="more m2">
									<a href="#" class="btn effect6" data-toggle="modal" data-target="#myModal1">Learn More</a>
								</div>  -->
							</div>
						</div>
						<div class="col-md-3 featured-grid">
							<div class="featured-grd">
								<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
								<h5>Timely travel</h5>
								<p>Unlike local transport facilities, we have proper ticketing 
									system to ensure hassle-free and timely traveling experience.</p>
						<!--		<div class="more m2">
									<a href="#" class="btn effect6" data-toggle="modal" data-target="#myModal1">Learn More</a>
								</div>  -->
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
			<!--gallery-->
				<div class="gallery" id="tours">
			<div class="container">
				<h3 class="tittle">Our Destinations</h3>
				<div class="gallery-grids">
					<section>
						<ul id="da-thumbs" class="da-thumbs">
							<li>
								<a href="${pageContext.request.contextPath}/resources/images/a1.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a1.jpg" alt="" />
									<div>
										<h5>Islamabad</h5>
									</div>
								</a>
							</li>
							<li>
								<a href="images/a2.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a2.jpg" alt="" />
									<div>
										<h5>Rawalpindi</h5>
									</div>
								</a>
							</li>
							<li>
								<a href="images/a3.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a3.jpg" alt="" />
									<div>
										<h5>Lahore</h5>
									</div>
								</a>
							</li>
							<li>
								<a href="images/a4.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a4.jpg" alt="" />
									<div>
										<h5>Faisalabad</h5>
									</div>
								</a>
							</li>
							<li>	
								<a href="images/a5.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a5.jpg" alt="" />
									<div>
										<h5>Peshawar</h5>
									</div>
								</a>
							</li>
							<li>
								<a href="images/a6.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a6.jpg" alt="" />
									<div>
										<h5>Multan</h5>
									</div>
								</a>
							</li>
							<li>
								<a href="images/a7.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a7.jpg" alt="" />
									<div>
										<h5>Karachi</h5>
									</div>
								</a>
							</li>
							<li>
								<a href="images/a8.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a8.jpg" alt="" />
									<div>
										<h5>Abbotabad</h5>
									</div>
								</a>
							</li>
							<li>
								<a href="images/a9.jpg" class="b-link-stripe b-animate-go thickbox">
									<img src="${pageContext.request.contextPath}/resources/images/a9.jpg" alt="" />
									<div>
										<h5>Hyderabad</h5>
									</div>
								</a>
							</li>
						</ul>
						<div class="clearfix"></div>
					</section>
				</div>
				<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.hoverdir.js"></script>	
				<script type="text/javascript">
					$(function() {
						$('#da-thumbs > li').each( function() { $(this).hoverdir(); } );
					});
				</script>
			</div>
		</div>

			<!--gallery-->
			<!-- team -->
			<div class="team" id="guides">
				<div class="container">
					<h3 class="tittle">Our Team</h3>
					<div class="team_gds">
						<div class="col-md-3 team_gd1 wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
							<div class="team_pos">
								<div class="team_back"></div>
								<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/t1.jpg"  alt=" ">
								<div class="team_info">
									<a href="#"  class="face_one"><i class="fc1"></i></a>
									<a href="#"  class="face_one"><i class="fc2"></i></a>
									<a href="#"  class="face_one"><i class="fc3"></i></a>
								</div>
							</div>
							<h4>M. Usman Abbasi</h4>
							<p>CEO</p>
						</div>
					
						<div class="col-md-3 team_gd1 wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
							<div class="team_pos">
								<div class="team_back"></div>
								<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/t3.jpg"  alt=" ">
								<div class="team_info">
									<a href="#"  class="face_one"><i class="fc1"></i></a>
									<a href="#"  class="face_one"><i class="fc2"></i></a>
									<a href="#"  class="face_one"><i class="fc3"></i></a>
								</div>
							</div>
							<h4>Megan Fox</h4>
							<p>Marketing Manager</p>
						</div>
						<div class="col-md-3 team_gd1 wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
							<div class="team_pos">
								<div class="team_back"></div>
								<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/t4.jpg"  alt=" ">
								<div class="team_info">
									<a href="#"  class="face_one"><i class="fc1"></i></a>
									<a href="#"  class="face_one"><i class="fc2"></i></a>
									<a href="#"  class="face_one"><i class="fc3"></i></a>
								</div>
							</div>
							<h4>Syed Saadat Hussain</h4>
							<p>CTO and Co-Founder</p>
						</div>
						<div class="col-md-3 team_gd1 wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
							<div class="team_pos">
								<div class="team_back"></div>
								<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/t2.jpg"  alt=" ">
								<div class="team_info">
									<a href="#"  class="face_one"><i class="fc1"></i></a>
									<a href="#"  class="face_one"><i class="fc2"></i></a>
									<a href="#"  class="face_one"><i class="fc3"></i></a>
								</div>
							</div>
							<h4>Raheel Jameel</h4>
							<p>Liaison Head</p>
						</div>
						<div class="clearfix"></div>		
					</div>
				</div>
			</div>
			<!--team-->
			<!--news-->
				
			<!--news-->
		</div>
			<div class="contact"  id="contact">
				<div class="container">
					<h3 class="tittle">Contact us</h3>
					<div class="contact-grids">
						<form action="#" method="post">
							<div class="col-md-6 grid-contact">
								<div class="your-top">
									<i class="glyphicon glyphicon-user"> </i>
									<input type="text" name="Name" placeholder="Name"  required >								
									<div class="clearfix"> </div>
								</div>
								<div class="your-top">
									<i class="glyphicon glyphicon-envelope"> </i>
									<input type="text" name="E-mail" placeholder="E-mail"  required>								
									<div class="clearfix"> </div>
								</div>
								<div class="your-top">
									<i class="glyphicon glyphicon-link"> </i>
									<input type="text" name="Website" placeholder="Website"  required>								
									<div class="clearfix"> </div>
								</div>
								
							</div>
							<div class="col-md-6 grid-contact-in">
								<textarea name="Message"  placeholder=" Message"  required></textarea>
								<input type="submit" value="Send">
							</div>
							<div class="clearfix"> </div>
						</form>
					</div>
					<div class="google-map">
					    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d105757.60309110026!2d72.57612097529294!3d34.0714343338739!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x95445985be9ab625!2sGhulam+Ishaq+Khan+Institute+of+Engineering+Sciences+and+Technology!5e0!3m2!1sen!2s!4v1475363909608" width="400" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>	
                    </div>
				</div>
			</div>
		<!--footer-->
			<div class="copy-section">
				<div class="container">
					<div class="footer-top">
						<p>&copy; 2016 Trip Guide. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
					</div>
				</div>
			</div>
			<script type="text/javascript">
						$(document).ready(function() {
							/*
							var defaults = {
					  			containerID: 'home', // fading element id
								containerHoverID: 'toTopHover', // fading element hover id
								scrollSpeed: 1200,
								easingType: 'linear' 
					 		};
							*/
							
							$().UItoTop({ easingType: 'easeOutQuart' });
							
						});
					</script>
				<a href="#" id="home" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body">
							<div class="news-gr">
							<img src="${pageContext.request.contextPath}/resources/images/p6.jpg" class="img-responsive" />
							<h3 class="tittle1">Trip Guide</h3>
								<p>Nam aliquam pretium feugiat. Duis sem est, viverra eu interdum ac, suscipit nec mauris. Suspendisse commodo tempor sagittis! In justo est, sollicitudin eu scelerisque pretium, placerat eget elit. Praesent faucibus rutrum odio at rhoncus. Pel ermentum pretium. Maecenas ac lacus ut neque rhoncus laoreet sed id tellus. Donec justo tellus.</p>

							</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>
