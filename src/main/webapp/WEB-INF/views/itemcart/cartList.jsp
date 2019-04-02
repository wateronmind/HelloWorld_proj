<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<!-- 중앙 컨텐츠 시작 -->


                 

   
<div class="container">
		<div class="section-title mb-80"
				style="text-align: center;">
			<h1>
			<br><br><br>
				<span style="color:#44b272">장바구니</span>
			<br><br><br>
			</h1>
		</div>
</div>
		
</div>

	
<div class="container main-board-list mb-100">
    <div class="row">
        <div class="section-title mb-20">
			<h3><span>
			<br><br><br>장바구니에 담긴 물품이 없습니다.<br><br><br></span></h3>
			<br><br>
		<div class="explore">
			<a href="${pageContext.request.contextPath}/main/main.do">메인으로</a>
		</div>
		</div>
		</div>
		</div>



		<!--<c:if test="${count>0}">
			<form action="#"
				method="get" id="cart_order"> -->
<div class="container main-board-list mb-100">
	<div class="row">
	<table class="table table-striped table-responsive table-hover">
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
		<!--<c:forEach var="cart" items="${list}">-->
			<tr>
				<td><a href="#"> <img src="#" width="100"
						class="thumb-image"> ${cart.i_nm} </td>
				<td>${cart.ic_quan}</td>
				<td>${cart.i_pc}</td>
				<td>${cart.i_dispc}</td>
				<td><input type="button" value="대여하기" onclick="#"> <br>
					<input type="button" class="btn btn-danger" value="삭제" onclick="#"></td>
			</tr>
		</c:forEach>
		</tbody>



		<c:if test="${!empty list}">
			<tr>
				<td colspan="3" class="align-right"><b>총구매금액</b></td>
				<td><fmt:formatNumber value="${total}" />원</td>
			</tr>
		</c:if>
		<c:if test="${!empty list}">
			<div class="align-center cart-submit">
				<input type="submit" value="구매하기">
			</div>
		</c:if>


		</table>
	</div>
	</form>
	</c:if>

	-->



</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
