<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--Welcome secton-->
	<div class="welcome-section text-center ptb-110">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="breadcurbs-inner">
						<div class="breadcrubs">
							<h2>Our news</h2>
							<div class="breadcrubs-menu">
								<ul>
									<li><a href="${pageContext.request.contextPath}/main/main.do">Home<i class="mdi mdi-chevron-right"></i></a></li>
									<li>hotel</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--Header section end-->
<!--Room Section Title start-->
<div class="room-section text-center ptb-80 white_bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-75">
					<h2>
						Hotel <span>Room</span>
					</h2>
					<p>표기된 가격은 성인 1박 기준입니다.</p>
				</div>
			</div>
		</div>
		<div class="our-room-show">
			<div class="row">
				<div class="our-room-list owl-pagination">
					<div class="single-room-sapce">
						<c:forEach var="room" items="${roomList}" varStatus="status">
						<div class="col-md-4 col-sm-6 col-xs-12 col-sm-6 col-xs-12">
							<div class="single-room mb-80">
								<div class="room-img">
									<a href="#"><img src="${room.sr_img1}" width="370" height="256"></a>
								</div>
								<div class="room-desc">
									<div class="room-name">
										<h3>
											<a href="#">${room.sr_nm}</a>
										</h3>
									</div>
									<div class="room-rent">
										<h5>
											￦ <fmt:formatNumber value="${room.sr_adult_pc}" pattern="#,###"/>
										</h5>
									</div>
									<div class="room-book">
										<a href="#">상세보기</a>
									</div>
								</div>
							</div>
						</div>
					<c:if test="${status.index%6 == 5}">
					</div>
					<div class="single-view_post">
					</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--Room Section end-->
<div class="google-map-area">
     <!--  Map Section -->
     <div id="contacts" class="map-area">
         <div id="googleMap" style="width:100%;height:418px;filter: grayscale(100%);-webkit-filter: grayscale(100%);"></div>
     </div>
 </div>
<!-- Google Map js
============================================ --> 		
      
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_9xLM-T_NwJ7mafKmGMPSWMFBtmOuz5E"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	function initialize() {
	  var mapOptions = {
		zoom: 15,
		scrollwheel: false,
		center: new google.maps.LatLng(23.752831, 90.362238)
	  };

	  var map = new google.maps.Map(document.getElementById('googleMap'),
		  mapOptions);


	  var marker = new google.maps.Marker({
		position: map.getCenter(),
		animation:google.maps.Animation.BOUNCE,
		icon: 'images/map-marker.png',
		map: map
	  });
              
	}
              
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
  
  

<!-- Placed js at the end of the document so the pages load faster -->

  <!-- jquery latest version -->
  <script src="js/vendor/jquery-1.12.0.min.js"></script>
  <!-- Bootstrap framework js -->
  <script src="js/bootstrap.min.js"></script>
  <!--counter up js-->
  <script src="js/waypoints.min.js"></script>
  <script src="js/jquery.counterup.min.js"></script>
  <!-- Video player js -->
  <script src="js/video-player.js"></script>
  <!-- headlines js -->
  <script src="js/animated-headlines.js"></script>
  
  
  
  
  <!-- parallax js -->
  <script src="js/parallax.js"></script>
  <!-- textilate js -->
  <script src="js/textilate.js"></script>
  <script src="js/lettering.js"></script>
  <!--isotope js-->
  <script src="js/isotope.pkgd.min.js"></script>
  <script src="js/packery-mode.pkgd.min.js"></script>
  <!-- Style Customizer Js  -->
  <script src="js/style-customizer.js"></script>
  <!-- Owl carousel Js -->
  <script src="js/owl.carousel.min.js"></script>
  <!--Magnificant js-->
  <script src="js/jquery.magnific-popup.js"></script>
  <!-- All js plugins included in this file. -->
  <script src="js/plugins.js"></script>
  <!-- Main js file that contents all jQuery plugins activation. -->
  <script src="js/main.js"></script>