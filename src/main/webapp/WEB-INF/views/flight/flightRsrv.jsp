<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<<script type="text/javascript">
$(function(){
	$('#next_2').on('click', function(){
		$('#page_2').click();
	});
	$('#next_3').on('click', function(){
		$('#page_3').click();
	});
});
</script>
	<!--Welcome secton-->
	<div class="welcome-section text-center ptb-110">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="breadcurbs-inner">
						<div class="breadcrubs">
							<h2>항공권 예약</h2>
							<div class="breadcrubs-menu">
								<ul>
									<li><a
										href="${pageContext.request.contextPath}/main/main.do">Home<i class="mdi mdi-chevron-right"></i></a></li>
									<li>Booking</li>
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
<!--항공권 booking start-->
<div class="room-booking ptb-80 white_bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-80 text-center">
					<h2>
						Booking <span>flight</span>
					</h2>
				</div>
			</div>
		</div>
		<!-- 전체 form start -->
		<form action="rsrvWrite.do">
			<div class="row">
				<!-- 수정예정 -->
				<input type="hidden" name="user_id" value="suywook91" />
				<input type="hidden" name="fsi_idx" value="${param.fsi_idx}" />
				<div class="col-md-12">
					<div class="booking-rooms-tab" align="center">
						<ul class="nav" role="tablist">
							<li class="active">
								<a href="#booking" data-toggle="tab">
								<span class="tab-border">1</span>
								<span>예약 정보</span>
								</a>
							</li>
							<li>
								<a href="#personal" data-toggle="tab" id="page_2">
								<span class="tab-border">2</span>
								<span>예약자 정보</span>
								</a>
							</li>
							<li>
								<a href="#payment" data-toggle="tab" id="page_3">
								<span class="tab-border">3</span>
								<span>결제 정보</span>
								</a>
							</li>
							<li>
								<a href="#done" data-toggle="tab">
								<span class="tab-border">4</span>
								<span>예약 완료</span>
								</a>
							</li>
						</ul>
					</div>
					<div class="service-tab-desc text-left mt-60">
						<div class="tab-content">
							<!-- 예약 정보 -->
							<div role="tabpanel" class="tab-pane active" id="booking">
								<div class="booking-info-deatils">
									<div class="single-room-details fix">
										<div class="room-img">
											<img src="${pageContext.request.contextPath}/resources/images/logo/${flightCommand.fi_logo}" alt="">
										</div>
										<div class="single-room-details pl-50">
											<h3 class="s_room_title">
											${flightCommand.fsi_start_city}(${flightCommand.fsi_start_nation})
											->
											${flightCommand.fsi_arrive_city}(${flightCommand.fsi_arrive_nation})
											</h3>
											<div class="room_price">
												<h4>FIRST CLASS</h4>
												<h5>총 가격</h5>
												<h5>
													? <span>/?</span>
												</h5>
												<p>가격 시세는 일별로 변동이 있을 수 있으며 결제를 완료한 고객에게 먼저 예약이 완료 됩니다.</p>
											</div>
										</div>
									</div>
									<div class="single-room-booking-form mt-60">
										<div class="booking_form_inner">
											<!-- 1열 시작 -->
											<div class="single-form-part">
												<div class="date-to mb-20">
													<input class="date-picker" type="text"
														placeholder="arrive date"
														value="${flightCommand.fsi_start_dt}"> 
														<i class="mdi mdi-calendar-text"></i>
												</div>
												<div class="date-to mb-20">
													<input type="text" value="${flightCommand.fsi_start_city}">
												</div>
												<div class="name mb-15">
													<input id="fr_adult_pp" placeholder="성인인원" />
												</div>
											</div>
											<!-- 1열 끝 -->
											<!-- 2열 시작 -->
											<div class="single-form-part">
												<div class="date-to mb-20">
													<input class="date-picker" type="text"
														placeholder="Departure Date"
														value="${flightCommand.fsi_arrive_dt}"> 
														<i class="mdi mdi-calendar-text"></i>
												</div>
												<div class="date-to mb-20">
													<input type="text" value="${flightCommand.fsi_pass1_city}">
												</div>
												<div class="name mb-15">
													<input id="fr_kid_pp" placeholder="유아인원" />
												</div>
											</div>
											<!-- 2열 끝 -->
											<!-- 3열 시작 -->
											<div class="single-form-part">
												<div class="date-to mb-20">
													<input type="text" value="${flightCommand.fsi_arrive_city}">
												</div>
												<div class="select-option mb-20"> 
													<select id="fr_rsrv_seat_type">
														<option value="FIR">First</option>
														<option value="BUS">Business</option>
														<option value="ECO" selected>economy</option>
													</select>
												</div>
											</div>
											<!-- 3열 끝 -->
										</div>
									</div>
									<div class="prve-next-box mt-20">
										<div class="back-link">
											<a href="#">Back</a>
										</div>
										<button type="button" id="next_2">다음</button>
									</div> 
								</div>
							</div>
							<!-- 예약자 정보 -->
							<div role="tabpanel" class="tab-pane" id="personal">
								<div class="personal-info-details">
									<div class="booking-info-inner">			
										<div class="booking-form-list">
											<h6>이름은 여권에 기재된 이름과 같아야 합니다.</h6>
											<!-- 1열 -->
											<div class="single-form-part">
												<div class="name mb-15">
													<input type="text" id="fr_fnm" placeholder="First Name(성)" />
												</div>
												<div class="name mb-15">
													<input type="text" id="fr_phone" placeholder="휴대폰 번호" />
												</div>
											</div>
											<!-- 2열 -->
											<div class="single-form-part">
												<div class="name mb-15">
													<input type="text" id="fr_nm" placeholder="Last Name(이름)" />
												</div>
												<div class="name mb-15">
													<input type="text" id="fr_passport" placeholder="여권 번호" />
												</div>
											</div>
											<!-- 3열 -->
											<div class="single-form-part">
												<div class="mail mb-15">
													<input type="text" id="fr_email" placeholder="Your Email"
														value="Your Email" />
													<i class="mdi mdi-calendar-text"></i>
												</div>
												<div class="select-option mb-20"> 
													<select id="fr_age">
														<option>연령대</option>
														<option value="10">10대</option>
														<option value="20">20대</option>
														<option value="30">30대</option>
														<option value="40">40대</option>
														<option value="50">50대</option>
														<option value="60">60대</option>
														<option value="70">70대</option>
														<option value="80">80대</option>
														<option value="90">90대</option>
													</select>
												</div>
											</div>
										</div>
										<div class="prve-next-box mt-20">
											<div class="back-link">
												<a href="#">Back</a>
											</div>
											<button type="button" id="next_3">다음</button>
										</div>
									</div>
								</div>
							</div>
							<!-- 결제 정보 -->
							<div role="tabpanel" class="tab-pane" id="payment">
								<div class="payment-info">
									<div class="payment-form">
										<div class="payment-form-list">
											<div class="single_form">
												<input type="text" placeholder="Card Holder Name">
											</div>
											<div class="single_form">
												<input type="text" placeholder="Enter Creadit Card Number">
											</div>
											<div class="single_form">
												<div class="select-date">
													<select>
														<option value="1" selected>Enter Month</option>
														<option value="1">January</option>
														<option value="1">February</option>
														<option value="1">March</option>
														<option value="1">April</option>
														<option value="1">May</option>
														<option value="1">June</option>
														<option value="1">July</option>
														<option value="1">August</option>
														<option value="1">September</option>
														<option value="1">October</option>
														<option value="1">NOvember</option>
														<option value="1">December</option>
													</select>
												</div>
											</div>
											<div class="single_form">
												<div class="select-date">
													<select>
														<option value="1" selected>Enter Year</option>
														<option value="1">2017</option>
														<option value="1">2018</option>
														<option value="1">2019</option>
														<option value="1">2020</option>
														<option value="1">2021</option>
													</select>
												</div>
											</div>
										</div>
										<div class="pay-money-form mt-40">
											<div class="payment-card">
												<a><img src="${pageContext.request.contextPath}/resources/images/logo/pay-card.png" alt=""></a>
											</div>
											<div class="pay-order">
												<button type="submit">결제하기</button>
											</div> 
										</div>
									</div>
								</div>
							</div>
								
						</div>
					</div>
				</div>
			</div>
		</form>
		<!--form end -->
	</div>
</div>
<!--Room booking end-->
