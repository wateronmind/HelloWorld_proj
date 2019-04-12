<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/roomDetail.js"></script>
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
<input type="hidden" id="addr" value="${hotel.st_addr}">
<div class="room-section text-center ptb-80 white_bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-50">
					<h2>
						<span>${room.sr_nm}</span>
					</h2>
				</div>
				<!--About Section Title start-->
				<div class="about-section text-center ptb-80 white_bg clearfix container">
				    <div class="row">
				        <ul class="package-carousel">
				            <li class="item">
				                <div>
				                    <img src="${room.sr_img1}" width="854" height="480" style="padding-bottom: 50px;">
				                </div>
				            </li>
				            <c:if test="${!empty room.sr_img2}">
				            <li class="item">
				                <div>
				                    <img src="${room.sr_img2}" width="854" height="480" style="padding-bottom: 50px;">
				                </div>
				            </li>
				            </c:if>
				            <c:if test="${!empty room.sr_img3}">
				            <li class="item">
				                <div>
				                    <img src="${room.sr_img3}" width="854" height="480" style="padding-bottom: 50px;">
				                </div>
				            </li>
				            </c:if>
				            <c:if test="${!empty room.sr_img4}">
				            <li class="item">
				                <div>
				                    <img src="${room.sr_img4}" width="854" height="480" style="padding-bottom: 50px;">
				                </div>
				            </li>
				            </c:if>
				            <c:if test="${!empty room.sr_img5}">
				            <li class="item">
				                <div>
				                    <img src="${room.sr_img5}" width="854" height="480" style="padding-bottom: 50px;">
				                </div>
				            </li>
				            </c:if>
				        </ul>
				    </div>
				</div>
				<!--About Section end-->
			</div>
			<div class="col-md-8">
				<div class="col-md-10 col-md-offset-2">
					<div class="mb-50">
						<textarea disabled>${room.sr_context}</textarea>
					</div>
					<div align="left">
						<c:if test="${!empty hotel.st_cvntl}">
							<p>편의시설</p>
							<c:forEach var="cvntl" items="${hotel.st_cvntl_list}"
								varStatus="cvntl_status">
								<div style="display: inline;">
								    <ul style="width:100px;float:left">
								    	<li>${cvntl.cvntl_nm}</li>
								    	<li><i class="mdi mdi-48px mdi-${cvntl.cvntl_icon}"
										<c:if test="${cvntl_status.index > 4}">
										style="display: none;"
										</c:if>></i></li>
								    </ul>
								</div>
								<c:if test="${cvntl_status.index == 4}">
									<div style="display: inline;">
										<i class="mdi mdi-48px mdi-plus" id="mdi_more" title="더 보기"></i>
									</div>
								</c:if>
								<c:if test="${cvntl_status.index % 5 == 4}">
									<br>
								</c:if>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
			<div class="col-md-4">
                <div class="booking-box">
                    <!-- S: hotel-srch -->
                    <div class="hotel-srch">
					    <div class="booking-title">
					        <h3>호텔 예약</h3>
					        <p>얼마없는 호텔을 검색해 보세요!<br>나오면 사고 없음 딴데 가보고</p>
					    </div>
					    <div class="booking-form">
					        <form action="${pageContext.request.contextPath}/hotel/hotelList.do" id="hotel_reg_form">
					        	<div class="row">
					             <div class="b-date arrive mb-15 col-md-6">
					                 <input name="hotel_check_in" class="date-picker" type="text" placeholder="체크인">
					                 <i class="mdi mdi-calendar-text"></i>
					             </div>
					             <div class="b-date departure mb-15 col-md-6">
					                 <input name="hotel_check_out" class="date-picker" type="text" placeholder="체크아웃">
					                 <i class="mdi mdi-calendar-text"></i>
					             </div>
					            </div>
					            <div class="row">
					                <div class="select-book mb-15 col-md-6">
					                    <select name="hotel_adult" class="select-booking">
					                        <option value="0" selected>성인</option>
					                        <option value="1">1</option>
					                        <option value="2">2</option>
					                        <option value="3">3</option>
					                        <option value="4">4</option>
					                        <option value="5">5</option>
					                        <option value="6">6</option>
					                        <option value="7">7</option>
					                        <option value="8">8</option>
					                    </select>
					                </div>
					                <div class="select-book mb-15 col-md-6">
					                    <select name="book_kid" class="select-booking">
					                        <option value="0" selected>어린이</option>
					                        <option value="1">1</option>
					                        <option value="2">2</option>
					                        <option value="3">3</option>
					                        <option value="4">4</option>
					                        <option value="5">5</option>
					                        <option value="6">6</option>
					                        <option value="7">7</option>
					                        <option value="8">8</option>
					                    </select>
					                </div>
					            </div>
					         <div class="submit-form">
					             <button type="submit">예약하기</button>
					         </div>
					        </form>
					    </div>
					</div>
					<!-- E: hotel-srch -->
                </div>
            </div>
		</div>
	</div>
</div>
<div class="google-map-area">
	<!--  Map Section -->
	<div id="contacts" class="map-area">
		<div id="map" style="width: 100%; height: 418px;"></div>
	</div>
</div>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_9xLM-T_NwJ7mafKmGMPSWMFBtmOuz5E&libraries=places&callback=initMap" async defer></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/roomMap.js"></script>
