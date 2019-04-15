<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




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
				<table style="align: center;">
					<h3>
						<span style="color: #44b272"> <br> <br> <br>장바구니에
							담긴 물품이 없습니다.<br> <br> <br></span>
					</h3>
				</table>
				<br>
				<br>
				<div class="explore">
					<a href="${pageContext.request.contextPath}/main/main.do">메인으로</a>
				</div>
			</c:if>

			<!-- 장바구니에 상품이 들어있을 때 -->
			<c:if test="${count > 0}">

				<%-- <tr>
						<td align="right">
							<div class="prve-next-box mt-20">
								<div class="back-link">

									<a
										href="${pageContext.request.contextPath}/itemcart/deleteCart.do">전체상품삭제</a><br>
									<br>

								</div>
							</div>
						</td>
					</tr>
					<li>
						<div class="allCheck">
							<input type="checkbox" name="allCheck" id="allCheck" /><label
								for="allCheck">모두 선택</label>

							<script>
								$("#allCheck").click(function() {
									var chk = $("#allCheck").prop("checked");
									if (chk) {
										$(".chBox").prop("checked", true);
									} else {
										$(".chBox").prop("checked", false);
									}
								});
							</script>
						</div> <!-- 모두선택 체크박스에 체크를 하게되면 개별 체크박스(chBox)들도 모두 체크가 됨 -->

						<div class="delBtn">
							<button type="button" class="selectDelete_btn">선택 삭제</button>

							<script>
								$(".selectDelete_btn")
										.click(
												function() {
													var confirm_val = confirm("정말 삭제하시겠습니까?");

													if (confirm_val) {
														var checkArr = new Array();

														$(
																"input[class='chBox']:checked")
																.each(
																		function() {
																			checkArr
																					.push($(
																							this)
																							.attr(
																									"data-cartNum"));
																		});

														$
																.ajax({
																	url : "/itemcart/deleteCart",
																	type : "post",
																	data : {
																		chbox : checkArr
																	},
																	success : function() {
																		location.href = "/itemcart/cartList";
																	}
																});
													}
												});
							</script>
						</div>

					</li>
 --%>
				<!-- 장바구니 표 -->
				<br>
				<form:form commandName="command" id="orderForm" action="orderForm.do" enctype="multipart/form-data">
				
					<table class="table">
						<thead>
							<tr>
								<th width="30"><input type="checkbox" id="check-all"></th>
								<th>상품명</th>
								<th>수량</th>
								<th>대여금액</th>
								<th>대여신청</th>
							</tr>
						</thead>


						<c:forEach var="itemCart" items="${list}">

							<tr>
								<td><input type="checkbox" name="checkbox" id="checkbox" value="1" style="width:20px; height:20px;"></td>
								<td>
								<a href="${pageContext.request.contextPath}/itemDetail.do?i_num=${itemCart.i_num}">
										<img src="imageView.do?i_num=${itemCart.i_num}" width="100"
										class="thumb-image"> ${itemCart.i_nm}
								</a></td>
								<td>${itemCart.ic_quan}</td>
								<td>${itemCart.sub_total}</td>

								<td>
									<div class="btn-list row">
										<a href=""
											class="button border_radius little button-black col-sm-4 on">대여</a>
										<a href="cartDelete.do?ic_num=${itemCart.ic_num}"
											class="button border_radius little button-black col-sm-4">삭제</a>

									</div>
								</td>

							</tr>
						</c:forEach>
						<tr>
							<td colspan="5" align="right">총 주문 금액 :<fmt:formatNumber
									pattern="###,###,###" value="${getTotalById}" /><br>

							</td>
						</tr>
						</tbody>
					</table>
				
				<div class="prve-next-box mt-20">

					<div class="back-link">
					<input type="button" value="전체상품 주문하기" onclick="location.href='${pageContext.request.contextPath}/itemcart/orderForm.do'"> 
					<input type="submit" value="선택상품 주문하기" name="button" id="checkBtn">
					
					</div>
				</div>
			</form:form>
			</c:if>
			
			
			
			
			
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
