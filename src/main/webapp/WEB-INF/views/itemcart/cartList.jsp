<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



 

<!-- 중앙 컨텐츠 시작 -->

<div class="container">
	<div class="row">
		<h1>장바구니</h1>
			
			
			<c:if test="${empty list}">
				<div class="align-center">장바구니에 담긴 물품이 없습니다.</div>
			</c:if>
			<c:if test="${!empty list}">
				<div class="table-responsive">
					<table class="table table-striped">
						<tr>
							<th>상품명</th>
							<th>수량</th>
							<th>대여금액</th>
							<th>할인금액</th>
							<th>대여신청</th>
						</tr>
						<c:forEach var="cart" items="${list}">
							<tr>
								<td>
								<a href="#">
								<img src="#" width="100" class="thumb-image">
								${cart.i_nm}
								</td>
								<td>${cart.ic_quan}</td>
								<td>${cart.i_pc}</td>
								<td>${cart.i_dispc}</td>
								<td><input type="button" value="대여하기" onclick="#">
									<br>
									<input type="button" class="btn btn-danger" value="삭제" onclick="#"></td>
							</tr>
						</c:forEach>
						<c:if test="${!empty list}">
							<div class="align-center cart-submit">
								<input type="submit" value="구매하기">
							</div>
							</c:if>
					</table>
				</div>
				<div class="align-center">${pagingHtml}</div>
			</c:if>
		 
			                            
		                                       
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
		