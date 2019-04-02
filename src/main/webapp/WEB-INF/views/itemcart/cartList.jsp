<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<!-- 중앙 컨텐츠 시작 -->





<div class="container">
	<div class="section-title mb-80" style="text-align: center;">
		<h1>
			<br> <br> <br> <span style="color: #44b272">장바구니</span>
			<br> <br> <br>
		</h1>
	</div>
</div>

</div>


<div class="container main-board-list mb-100">
	<div class="row">
		<div class="section-title mb-20">
			<c:choose>
				<c:when test="${map.count}==0">
					<h3>
						<span> <br> <br> <br>장바구니에 담긴 물품이 없습니다.<br>
							<br> <br></span>
					</h3>
					<br>
					<br>
					<div class="explore">
						<a href="${pageContext.request.contextPath}/main/main.do">메인으로</a>
					</div>
				</c:when>

				<c:otherwise>
					<form name="form1" id="form1" method="post" action="#">


						<!-- 장바구니 표 -->
						<table class="table">
							<thead>
								<tr>
									<th>상품명</th>
									<th>수량</th>
									<th>대여금액</th>
									<th>할인금액</th>
									<th>대여신청</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="row" items="${map.list}" varStatus="i">
									<tr>
										<td><a href="#"> <img src="#" width="100"
												class="thumb-image"> ${cart.i_nm} </td>
										<td>${cart.ic_quan}</td>
										<td>${cart.i_pc}</td>
										<td>${cart.i_dispc}</td>
										<td><input type="button" value="대여하기" onclick="#"></td>
									</tr>
								</c:forEach>



								<tr>
									<td colspan="1" class="aa-cart-view-bottom">
										<div class="aa-cart-coupon">
											<input class="aa-cart-view-btn" type="submit" value="선택삭제"
												onclick="#">
										</div> <input class="aa-cart-view-btn" type="submit" value="전체삭제"
										onclick="#">
									</td>
									
									
								</tr>
								
								
								<tr>
									<td colspan="5" align="right">
										총 주문 금액 : <fmt:formatNumber pattern="###,###,###" value="${map.getTotalById}"/><br>
										
									</td>
								</tr>
							</tbody>
						</table>
						<input type="hidden" name="count" value="${map.count}">
						
				</form>
				</c:otherwise>
				</c:choose>
				<div class="prve-next-box mt-20">
                                                    <div class="back-link">
                                                        <a href="#">목록으로</a>
                                                    </div>
                                                    <button type="submit">주문하기</button>
                                                </div>
		</div>
		</div>
		</div>


		
<!-- 중앙 컨텐츠 끝 -->
