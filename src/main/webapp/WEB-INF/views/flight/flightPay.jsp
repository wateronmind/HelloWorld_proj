<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
									href="${pageContext.request.contextPath}/main/main.do">Home<i
										class="mdi mdi-chevron-right"></i></a></li>
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
		<div class="row">
			<!-- form start -->
			<form:form commandName="command" id="flightForm"
				action="rsrvWrite.do">
				<!-- 수정예정 -->
				<input type="hidden" name="user_id" value="suywook91"/>
				<input type="hidden" name="fsi_idx" value="${param.fsi_idx}"/>
				<div class="col-md-12">
					<div class="booking-rooms-tab">
						<ul class="nav" role="tablist">
							<li><a href="#booking" data-toggle="tab"><span
									class="tab-border">1</span><span>예약 정보</span></a></li>
							<li class="active"><a href="#payment" data-toggle="tab"><span
									class="tab-border">2</span><span>결제 정보</span></a></li>
							<li><a href="#done" data-toggle="tab"><span
									class="tab-border">3</span><span>예약 완료</span></a></li>
						</ul>
					</div>
					<div class="service-tab-desc text-left mt-60">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="payment">
								<div class="payment-info">
									<form action="flightPay.do">
									   <input type="hidden" name="fr_id" value="${fr_id}">
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
													<a href="#"><img src="images/logo/pay-card.png" alt=""></a>
												</div>
												<div class="pay-order">
													<button type="submit">Pay now</button>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane" id="done">
								<div class="booking-done">
									<div class="booking-done-table table-responsive text-center">
										<table class="table">
											<tr>
												<td><p>
														1 Room <span>Five Adult & 1 child</span>
													</p></td>
												<td><p>
														$120 <span>Rate</span>
													</p></td>
												<td><p>
														5 <span>night</span>
													</p></td>
												<td><p>$550</p></td>
											</tr>
											<tr class="row2">
												<td><p>
														tax <span>20% tax</span>
													</p></td>
												<td></td>
												<td></td>
												<td><p>$90</p></td>
											</tr>
											<tr class="row3">
												<td><p>Total</p></td>
												<td></td>
												<td></td>
												<td><p>$640</p></td>
											</tr>
										</table>
									</div>
									<div class="booking-done-description">
										<p>There are many variations of passages of Lorem Ipsum
											available, but the majority have suffered alteration in some
											form, by injected humour</p>
										<div class="succesfully">
											<strong>Your reservation was succefully submited!!</strong>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
			<!--form end -->
		</div>
	</div>
</div>
<!--Room booking end-->
