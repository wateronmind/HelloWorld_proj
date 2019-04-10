<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_9xLM-T_NwJ7mafKmGMPSWMFBtmOuz5E&libraries=places&callback=initMap" async defer></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/roomList.js"></script>
<!--Welcome secton-->
	<div class="welcome-section text-center ptb-110">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="breadcurbs-inner">
						<div class="breadcrubs">
							<h2>Room</h2>
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
test
<div class="google-map-area">
	<!--  Map Section -->
	<div id="contacts" class="map-area">
		<div id="map" style="width:100%;height:418px;"></div>
	</div>
</div> 		
