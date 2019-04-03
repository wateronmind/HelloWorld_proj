<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/manageGuide.js"></script>
<!-- 중앙 컨텐츠 시작 -->
</div>
<div class="container">
	<div class="row">
		<h1>가이드 목록(관리자용)</h1>
		<form action="guideList.do" id="search_form" method="get">
			<ul class="search">
				<li>
					<select name="keyfield">
						<option value="user_id">ID</option>
						<option value="user_nm">이름</option>
						<option value="user_email">이메일</option>
						<option value="all">전체</option>
					</select>
					
				</li>
				<li>
					<input type="text" name="keyword" id="keyword">
				</li>
				<li>
					<input type="submit" value="찾기">
					<input type="button" value="목록" onclick="location.href='guideList.do'">
				</li>
			</ul>
		</form>
		<c:if test="${count == 0}">
		<div class="align-center">가이드 신청 회원이 없습니다.</div>
		</c:if>
		<c:if test="${count > 0}">
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>신청일</th>
					<th> </th>
				</tr>
				<c:forEach var="member" items="${guideList}">
				<tr>
					<td>
						<c:if test="${member.user_auth!=0}"><a href="adminMemberDetail.do?user_id=${member.user_id}">${member.user_id}</a></c:if>
					</td>
					<td>${member.user_nm}</td>
					<td>${member.user_email}</td>
					<td>${member.user_apply_dt}</td>
					<td>
						<c:if test="${member.user_auth == 2 }">
						<button class="btn btn-default"
						onclick="location.href='${pageContext.request.contextPath}/member/refuseGuide.do?user_id=${member.user_id}'">가이드 취소</button>
						</c:if>
						<c:if test="${member.user_auth == 1 }">
						<div class="btn-group">
							<button class="btn btn-info"
							onclick="location.href='${pageContext.request.contextPath}/member/confirmGuide.do?user_id=${member.user_id}'">승인</button>
							<button class="btn btn-default"
							onclick="location.href='${pageContext.request.contextPath}/member/refuseGuide.do?user_id=${member.user_id}'">거부</button>
						</div>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="align-center">${pagingHtml}</div>
		</c:if>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->