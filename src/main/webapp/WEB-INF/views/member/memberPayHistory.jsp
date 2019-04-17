<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/member.js"></script>
<!-- 중앙 컨텐츠 시작 -->
</div>
<div class="container table-list">
	<div class="row">
		<br><br>
		<h3 class="text-center">결제내역</h3>
		<br>
		
		<div class="col-xs-12">
			<c:if test="${count == 0}">
			<div class="align-center">결제내역이 없습니다.</div>
			</c:if>
			
			<c:if test="${count > 0}">
			<div class="table-responsive">
				<table class="table table-striped">
					<tr>
						<th>날짜</th>
						<th>결제 금액</th>
						<th>결제 방식</th>
					</tr>
					<c:forEach var="pay" items="${memberPayHistory}">
					<tr>
						<td>${pay.ph_reg_dt}</td>
						<td>${pay.ph_pay}</td>
						<td>${pay.ph_pat_type}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-xs-offset-4">
			<form action="memberList.do" id="search_form" method="get">
				<select name="keyfield" class="col-xs-2" >
					<option value="user_id">ID</option>
					<option value="user_nm">이름</option>
					<option value="user_email">이메일</option>
					<option value="all">전체</option>
				</select>
				<input type="text" name="keyword" id="keyword" class="col-xs-2" >
				<input type="submit" value="찾기" class="col-xs-1" >
				<input type="button" value="목록" class="col-xs-1"
				onclick="location.href='memberList.do'">
			</form>
			</div>
			
			<div class="text-center col-xs-12 paging">${pagingHtml}</div>
			</c:if>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->