<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/roomRsrv.js"></script>
	<!--Welcome secton-->
	<div class="welcome-section text-center ptb-110">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="breadcurbs-inner">
						<div class="breadcrubs">
							<h2>Booking</h2>
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
<!--Room booking start-->
<div class="room-booking ptb-80 white_bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-80 text-center">
					<h2>
						<span>호텔</span> 예약
					</h2>
					<p></p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="booking-rooms-tab" style="width: 100%;">
					<ul class="nav" role="tablist" style="width: 100%;">
						<li class="active col-md-4">
							<a href="#booking" data-toggle="tab" id="move_1">
								<span class="tab-border">1</span>
								<span>호텔  예약 정보 확인</span>
							</a>
						</li>
						<li class="col-md-4">
							<a href="#personal" data-toggle="tab" id="move_2">
								<span class="tab-border">2</span>
								<span>결제 정보</span>
							</a>
						</li>
						<li class="col-md-3">
							<a>
								<span class="tab-border">3</span>
								<span>예약 완료</span>
							</a>
						</li>
					</ul>
				</div>
				<div class="service-tab-desc text-left mt-60">
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="booking">
							<div class="booking-info-deatils">
								<div class="single-room-details fix">
									<div class="room-img">
										<img src="${hotel.sr_img1}" alt="" width="182" height="182">
									</div>
									<div class="single-room-details pl-50">
										<h3 class="s_room_title">${hotel.st_nm}</h3>
										<div class="room_price">
											<h4>결제 금액</h4>
											<h5>
												￦ <fmt:formatNumber value="${rsrv.srl_total_pc}" pattern="#,###"/>
											</h5>
											<h6>
												성인 ${rsrv.srl_adult_pp}명 / 어린이 ${rsrv.srl_kid_pp}명 / 
												체크인 ${hotel.st_check_in} / 체크아웃 ${hotel.st_check_out}
											</h6>
											<c:if test="${!empty hotel.st_cvntl}">
											<p>편의시설</p>
												<c:forEach var="cvntl" items="${hotel.st_cvntl_list}">
													<i class="mdi mdi-24px mdi-${cvntl.cvntl_icon}" title="${cvntl.cvntl_nm}"></i>
												</c:forEach>
											</c:if>
										</div>
									</div>
								</div>
								<div class="single-room-booking-form mt-60">
									<div class="booking_form_inner">
										<div class="single-form-part">
											<div class="date-to">
												<input class="date-picker" type="text" value="${rsrv.srl_check_in_dt}" disabled>
												<i class="mdi mdi-calendar-text"></i>
											</div>
										</div>
										<div class="single-form-part">
											<div class="date-to">
												<input type="text" class="date-picker" value="${rsrv.srl_check_out_dt}" disabled>
												<i class="mdi mdi-calendar-text"></i>
											</div>
										</div>

										<div class="single-form-part">
											<div class="submit-form">
												<button type="submit" class="next_1">확인 완료</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="personal">
							<div class="personal-info-details">
								<form action="hotelResult.do" method="post" id="rsrv_form">
									<input type="hidden" name="sr_id" value="${rsrv.sr_id}">
									<input type="hidden" name="user_id" value="${rsrv.user_id}">
									<input type="hidden" name="srl_total_pc" value="${rsrv.srl_total_pc}">
									<input type="hidden" name="srl_check_in_dt" value="${rsrv.srl_check_in_dt}">
									<input type="hidden" name="srl_check_out_dt" value="${rsrv.srl_check_out_dt}">
									<input type="hidden" name="srl_adult_pp" value="${rsrv.srl_adult_pp}">
									<input type="hidden" name="srl_kid_pp" value="${rsrv.srl_kid_pp}">
									<div class="booking-info-inner">
										<div class="booking-form-list">
											<div class="single-form-part">
												<div class="name mb-15">
													<input type="text" name="srl_nm" id="srl_nm" placeholder="예약자명">
												</div>
												<div class="name mb-15">
													<input type="text" name="cp_num" id="cp_num" placeholder="카드 번호">
												</div>
											</div>
											<div class="single-form-part">
												<div class="mail mb-15">
													<input type="email" name="srl_email" id="srl_email" placeholder="예약자 이메일">
													<i class="mdi mdi-email"></i>
												</div>
												<div class="name mb-15">
													<input type="text" name="cp_pin_num" id="cp_pin_num" placeholder="카드 핀 넘버">
												</div>
											</div>
											<div class="single-form-part">
												<div class="mail mb-15">
													<input type="text" name="srl_phone" id="srl_phone" placeholder="예약자 연락처">
													<i class="mdi mdi-phone"></i>
												</div>
												<div class="name mb-15">
													<input type="text" name="cp_year_month" id="cp_year_month" placeholder="MM/YY">
													
												</div>
											</div>
										</div>
										<div class="prve-next-box" align="right">
											<div class="back-link">
												<a class="before_2">이전</a>
											</div>
											<button type="submit">결제</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--Room booking end-->
