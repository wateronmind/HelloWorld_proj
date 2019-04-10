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
<!--Room Section Title start-->
<input type="hidden" id="addr" value="${hotel.st_addr}">
<div class="room-section text-center ptb-80 white_bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-75">
					<h2>
						<span>${hotel.st_nm}</span>
					</h2>
					<p>표기된 가격은 성인 1박 기준입니다.<br>지도는 최하단에 있습니다.</p>
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
         <div id="map" style="width:100%;height:418px;"></div>
     </div>
 </div> 		