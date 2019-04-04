<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<style>
.allCheck {
	float: left;
	width: 200px;
}

.allCheck input {
	width: 16px;
	height: 16px;
}

.allCheck label {
	margin-left: 10px;
}

.delBtn {
	float: right;
	width: 300px;
	text-align: right;
}

.delBtn button {
	font-size: 18px;
	padding: 5px 10px;
	border: 1px solid #eee;
	background: #eee;
}

.checkBox {
	float: left;
	width: 30px;
}

.checkBox input {
	width: 16px;
	height: 16px;
}
</style>


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
				<li>
					<div class="allCheck">
						<input type="checkbox" name="allCheck" id="allCheck" /><label
							for="allCheck">모두 선택</label>

						<script>
							$("#allCheck").click(function(){
 							var chk = $("#allCheck").prop("checked");
 							if(chk) {
							  $(".chBox").prop("checked", true);
 							} else {
							  $(".chBox").prop("checked", false);
 							 }
							});
						</script>
					</div>
					<!-- 모두선택 체크박스에 체크를 하게되면 개별 체크박스(chBox)들도 모두 체크가 됨 -->

					<div class="delBtn">
						<button type="button" class="selectDelete_btn">선택 삭제</button>

						<script>
 						$(".selectDelete_btn").click(function(){
  						var confirm_val = confirm("정말 삭제하시겠습니까?");
  
  						if(confirm_val) {
  						 var checkArr = new Array();
   
  						 $("input[class='chBox']:checked").each(function(){
   						 checkArr.push($(this).attr("data-cartNum"));
   							});
    
  						 $.ajax({
  						  url : "/itemcart/deleteCart",
   						 type : "post",
   						 data : { chbox : checkArr },
   						 success : function(){
   						  location.href = "/itemcart/cartList";
   						 }
  						 });
  						} 
						 });
						</script>
					</div>

				</li>

				<!-- 장바구니 표 -->
				<br>

				<table class="table">
					<thead>
						<tr>
							<div class="checkBox">
								<input type="checkbox" name="chBox" class="chBox"
									data-cartNum="${cartList.ic_num}" />
							<script>
 							$(".chBox").click(function(){
							  $("#allCheck").prop("checked", false);
							 });
							</script>
							</div>
					<!-- 개별 체크박스가 선택되거나 선택해제되면 모두선택 체크박스가 해제됨 -->	
							</div>
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
						<td colspan="5" align="right">총 주문 금액 :<fmt:formatNumber
								pattern="###,###,###" value="${getTotalById}" /><br>

						</td>
					</tr>
					</tbody>
				</table>
				<div class="prve-next-box mt-20">
					<div class="back-link">
						<a href="${pageContext.request.contextPath}/itemcart/orderForm.do">목록으로</a>
					</div>
					<c:if test="${count > 0}">
						<button type="submit">주문하기</button>
					</c:if>
				</div>
			</c:if>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
