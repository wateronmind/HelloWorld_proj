<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<!-- 중앙 컨텐츠 시작 -->





<div class="container write-form w_600">
	<div class="section-title mb-80" style="text-align: center;">
		<h1>
			<span style="color: #44b272">장바구니</span>
			
		</h1>
	</div>
</div>

</div>

<div class="container main-board-list mb-100">
	<div class="row">
		<div class="section-title mb-80">


			<c:if test="${count == 0}">
				<h3>
					<span style="color:#44b272"> <br> <br> <br>장바구니에 담긴 물품이 없습니다.<br>
						<br> <br></span>
				</h3>
				<br>
				<br>
				<div class="explore">
					<a href="${pageContext.request.contextPath}/main/main.do">메인으로</a>
				</div>
			</c:if>

			<c:if test="${count > 0}">



				<!-- 장바구니 표 -->
				<br>
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
								href="${pageContext.request.contextPath}/itemDetail.do?${itemCart.i_num}">
									<img src="#" width="100" class="thumb-image">
									${itemCart.i_nm}
							</a></td>
							<td>${itemCart.ic_quan}</td>
							<td>${itemCart.i_pc}</td>

							<td><input type="button" value="대여하기" onclick="#"></td>

						</tr>
					</c:forEach>


					<tr>

						<td align="right">

							<div class="prve-next-box mt-20">
								<div class="back-link">


									<a
										href="${pageContext.request.contextPath}/itemcart/orderForm.do">선택상품삭제</a><br>
									<a
										href="${pageContext.request.contextPath}/itemcart/orderForm.do">전체상품삭제</a><br>
									<br>

								</div>
							</div>

						</td>


					</tr>



					<tr>
						<td colspan="5" align="right">총 주문 금액 : <fmt:formatNumber
								pattern="###,###,###" value="${map.getTotalById}" /><br>

						</td>
					</tr>
					</tbody>
				</table>
			</c:if>



			<div class="prve-next-box mt-20">
				<div class="back-link">
					<a href="${pageContext.request.contextPath}/itemcart/orderForm.do">목록으로</a>
				</div>
				<c:if test="${count > 0}">
				<button type="submit">주문하기</button>
				</c:if>
			</div>
		</div>
	</div>
</div>



<!-- 중앙 컨텐츠 끝 -->
