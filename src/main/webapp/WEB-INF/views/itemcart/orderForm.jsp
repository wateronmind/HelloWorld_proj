<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 대여</title>
</head>
<body>
	<!--Room booking start-->
	<div class="container main-board-list mb-100">
		<div class="row">
			<div class="section-title mb-80" style="text-align: center;">
				<h2>
					<span>대여/결제</span>
				</h2>
				<p>대여상품 및 결제금액 확인</p>
			</div>
		</div>
	</div>
	</div>



	<!-- 개인정보입력 -->
	<div role="tabpanel" class="tab-pane active" id="personal">
		<div class="personal-info-details">
			<div class="booking-info-inner">
				<div class="row">
					<ul class="col-xs-12">
						<div class="booking-form-list">


							<table class="table">
								<thead>
									<tr style="align: center">
										<th>상품명</th>
										<th>수량</th>
										<th>대여금액</th>

									</tr>
								</thead>


								<c:forEach var="itemCart" items="${list}">
									<tr>
										<td><a
											href="${pageContext.request.contextPath}/itemDetail.do?${itemCart.i_num}">
												<img src="#" width="100" class="thumb-image">
												${itemCart.i_nm}
										</a></td>
										<td>${itemCart.ic_quan}</td>
										<td>${itemCart.i_pc}</td>


									</tr>
								</c:forEach>


							</table>



							<c:forEach var="itemOrder" items="${list}">
								<input type="hidden" name="ibh_idx" id="ibh_idx">
								<input type="hidden" name="i_num" id="i_num">
								<input type="hidden" name="ph_idx" id="ph_idx">
								<input type="hidden" name="user_id" id="user_id">

								<div class="single-form-part">
									<br> <br>
									<div class="name mb-15">

										<input type="text" name="ibh_nm" id="ibh_nm"
											required="required" placeholder="수령자 이름">
									</div>
									<div class="select-option">
										<select>
											<option value="0" selected>결제방식</option>
											<option id="ibh_pay" value="1">카드결제</option>
											<option id="ibh_pay" value="2">계좌이체</option>
											<option id="ibh_pay" value="3">현금결제</option>
										</select>

									</div>
								</div>
								<div class="single-form-part">
									<div class="name mb-15">
										<input type="number" name="ibh_phone" id="ibh_phone"
											placeholder="연락 가능한 번호">
									</div>
									<div class="mail mb-15">
										<input type="email" name="ibh_email" id="ibh_email"
											placeholder="이메일 주소">

									</div>

									<!-- <div class="select-option">
                                                            <select>
                                                                <option value="1" selected>parking</option>
                                                                <option value="2">Rest house</option>
                                                                <option value="3">Gym room</option>
                                                            </select>
                                                        </div> -->
								</div>
								<div class="single-form-part">
									<div class="name mb-15">
										<input type="text"
											placeholder="대여일자:${itemOrder.ibh_rent_day}<br>반납일자:${itemOrder.ibh_rent_day}"
											disabled>
									</div>

									<div class="name mb-15">
										<input type="text"
											placeholder="수령공항:${itemOrder.ibh_rent_nc}<br>반납공항:수령공항:${itemOrder.ibh_return_nc}"
											disabled>
									</div>
								</div>
								<!-- <div class="single-form-part">
                                                        <div class="mail mb-15">
                                                            <input type="text" placeholder="Your Email" value="Your Email">
                                                            <i class="mdi mdi-calendar-text"></i>
                                                        </div>
                                                        <div class="select-option">
                                                            <select>
                                                                <option value="1" selected>With pet</option>
                                                                <option value="2">with favourit</option>
                                                                <option value="3">pet</option>
                                                            </select>
                                                        </div>
                                                    </div> -->
						</div>
						<div class="request-box mt-15">
							<textarea placeholder="요청사항이 있으신가요?"></textarea>
						</div>

					</ul>
					</c:forEach>



					<div class="prve-next-box mt-20">
						<div class="back-link">
							<a href="#">뒤로가기</a>
						</div>
						<button type="button" data-toggle="modal" data-target="#myModal">주문하기</button>
					</div>
					</form>
				</div>
			</div>
		</div>



		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">주문하시겠습니까?</h4>
					</div>
					<form:form commandName="Command" id="itemOrder"
						action="itemOrder.do" enctype="multipart/form-data">
						<c:forEach var="itemOrder" items="${list}">
							<div class="modal-body">
								수령자 이름 : ${itemOrder.ibh_rent_nc}<br> 전화번호 :
								${itemOrder.ibh_phone}<br> 결제방식 : ${itemOrder.ibh_pay}<br>
								이메일 주소 : ${itemOrder.ibh_email}<br> 대여공항 / 반납공항 :
								${itemOrder.ibh_rent_nc}/${itemOrder.ibh_return_nc}<br> 대여일
								/ 반납일 : ${itemOrder.ibh_rent_day}/${itemOrder.ibh_return_day}<br>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">돌아가기</button>
								<button type="submit" class="btn btn-primary"
									data-dismiss="modal">주문하기</button>
							</div>
						</c:forEach>
					</form:form>
				</div>
			</div>
		</div>



		<div class="booking-done-description">
			<p>There are many variations of passages of Lorem Ipsum
				available, but the majority have suffered alteration in some form,
				by injected humour</p>
			<div class="succesfully">
				<strong>Your reservation was succefully submited!!</strong><br>
				<br> <br>
			</div>
		</div>


		<!--Room booking end-->
</body>
</html>