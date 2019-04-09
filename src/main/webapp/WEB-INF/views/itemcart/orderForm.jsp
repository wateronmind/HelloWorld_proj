<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<div class="container main-board-list mb-100">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>상품명</th>
						<th>수량</th>
						<th>대여금액</th>
						<th>대여신청</th>
					</tr>
				</thead>
				<c:forEach var="itemCart" items="${list}">
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/itemDetail.do?i_num=${itemCart.i_num}">
								<img src="imageView.do?i_num=${item.i_num}" width="100"
								class="thumb-image"> ${itemCart.i_nm}
						</a></td>
						<td>${itemCart.ic_quan}</td>
						<td>${itemCart.i_pc}</td>

					</tr>
				</c:forEach>
				<tr>

					<td colspan="5" align="right">총 주문 금액 :<fmt:formatNumber
							pattern="###,###,###" value="${getTotalById}" /><br>

					</td>
				</tr>
				</tbody>
			</table>


			<input type="hidden" name="ibh_idx" id="ibh_idx"> 
			<input type="hidden" name="i_num" id="i_num"> 
			<input type="hidden" name="ph_idx" id="ph_idx"> 
			<input type="hidden" name="user_id" id="user_id">
			<input type="hidden" name="reg_date" id="reg_date">
			<input type="hidden" name="ibh_rent_num" id="ibh_rent_num">
			<input type="hidden" name="ibh_rent_day" id="ibh_rent_day">
			<input type="hidden" name="ibh_rent_nc" id="ibh_rent_nc">
			<input type="hidden" name="ibh_return_day" id="ibh_return_day">
			<input type="hidden" name="ibh_return_nc" id="ibh_return_nc">

			<form:form commandName="command" id="orderForm" action="orderForm.do" enctype="multipart/form-data">


				<div class="single-form-part">
					<br> <br>
					<div class="name mb-15">

						<input type="text" name="ibh_nm" id="ibh_nm" required="required"
							placeholder="수령자 이름">
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



				<%-- <div class="single-form-part">
					<div class="name mb-15">
						<input type="text"
							placeholder="대여일자:${orderList.ibh_rent_day}<br>반납일자:${orderList.ibh_rent_day}"
							disabled>
					</div>

					<div class="name mb-15">
						<input type="text"
							placeholder="수령공항:${orderList.ibh_rent_nc}<br>반납공항:수령공항:${orderList.ibh_return_nc}"
							disabled>
					</div>
				</div> --%>
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

				<div class="request-box mt-15">
					<textarea placeholder="요청사항이 있으신가요?"></textarea>
				</div>



				<div class="prve-next-box mt-20">
					<input type="button" value="뒤로가기">
					<input type="submit" value="주문하기">
				</div>

			</form:form>
		</div>
	</div>


	<%-- <!-- Modal -->
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
				<form:form commandName="command" id="insertOrder"
					action="insertOrder.do" enctype="multipart/form-data">
					<c:forEach var="orderList" items="${list}">
						<div class="modal-body">
							수령자 이름 : ${orderList.ibh_rent_nc}<br> 전화번호 :
							${orderList.ibh_phone}<br> 결제방식 : ${orderList.ibh_pay}<br>
							이메일 주소 : ${orderList.ibh_email}<br> 대여공항 / 반납공항 :
							${orderList.ibh_rent_nc}/${orderList.ibh_return_nc}<br> 대여일
							/ 반납일 : ${orderList.ibh_rent_day}/${orderList.ibh_return_day}<br>
						</div>
					</c:forEach>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">돌아가기</button>
							<button type="submit" class="btn btn-primary"
								data-dismiss="modal">주문하기</button>
						</div>
				</form:form>
			</div>
		</div>
	</div> --%>




	<!--Room booking end-->
</body>
</html>