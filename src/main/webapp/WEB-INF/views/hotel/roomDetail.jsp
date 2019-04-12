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
<input type="hidden" id="sr_max_pp" value="${room.sr_max_pp}">
<input type="hidden" id="sr_adult_pc" value="${room.sr_adult_pc}">
<input type="hidden" id="sr_kid_pc" value="${room.sr_kid_pc}">
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
					<div class="mb-100" align="left">
						<h2>상세내용</h2><br>
						<textarea disabled>${room.sr_context}</textarea>
					</div>
					<div class="mb-100" align="left">
						<h2>기본시설</h2>
						<div align="center" style="display: inline;">
							<ul style="width: 100px;float: left;">
								<li>방 개수</li>
								<li><i class="mdi mdi-48px mdi-numeric-${room.sr_room_cnt}-box" title="방 개수"></i></li>
							</ul>
						</div>
					</div>
					<div align="left" style="float: inherit;">
						<c:if test="${!empty hotel.st_cvntl}">
							<h2>편의시설</h2><br>
							<c:forEach var="cvntl" items="${hotel.st_cvntl_list}"
								varStatus="cvntl_status">
								<div align="center" style="display: inline;">
								    <ul class="mdi-ul" style="width: 90px;float: left;
										<c:if test="${cvntl_status.index > 4}">
										display: none;
										</c:if>">
								    	<li>${cvntl.cvntl_nm}</li>
								    	<li><i class="mdi mdi-48px mdi-${cvntl.cvntl_icon}"></i></li>
								    	<li><br></li>
								    </ul>
								</div>
								<c:if test="${cvntl_status.index == 4}">
									<div id="mdi_more" style="display: inline;">
										<ul style="width: 90px;float: left;">
											<li>더 보기</li>
											<li><i class="mdi mdi-48px mdi-plus" title="더 보기"></i></li>
										</ul>
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
					        <form action="${pageContext.request.contextPath}/hotel/hotelRsrv.do" id="hotel_reg_form">
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
