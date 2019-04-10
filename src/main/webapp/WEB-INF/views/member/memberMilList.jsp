<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/member.js"></script>
<!-- 중앙 컨텐츠 시작 -->
</div>
<div class="container table-list">
	<div class="row">
		<br><br>
		<h3 class="text-center">회원목록(관리자용)</h3>
		<br>
		
		<div class="col-xs-12">
			<c:if test="${count == 0}">
			<div class="align-center">등록된 회원이 없습니다.</div>
			</c:if>
			
			<c:if test="${count > 0}">
			<div class="table-responsive">
				<table class="table table-striped">
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>이메일</th>
						<th>상태</th>
						<th> </th>
					</tr>
					<c:forEach var="member" items="${memberList}">
					<tr>
						<td>
							<c:if test="${member.user_auth == 0}">${member.user_id}</c:if>
							<c:if test="${member.user_auth > 0}">
								<a href="adminMemberDetail.do?user_id=${member.user_id}">${member.user_id}</a>
							</c:if>
						</td>
						<td>${member.user_nm}</td>
						<td>${member.user_phone}</td>
						<td>${member.user_email}</td>
						<td>
							<c:if test="${member.user_auth == 0 }">탈퇴</c:if>
							<c:if test="${member.user_auth == 1 }">일반</c:if>
							<c:if test="${member.user_auth == 2 }">가이드</c:if>
							<c:if test="${member.user_auth == 3 }">관리자</c:if>
						</td>
						<td>
							<c:if test="${member.user_auth == 0 }"></c:if>
							<c:if test="${member.user_auth == 1 }"><i class="fas fa-user"></i></c:if>
							<c:if test="${member.user_auth == 2 }"><i class="fas fa-user-check"></i></c:if>
							<c:if test="${member.user_auth == 3 }"><i class="fas fa-user-cog"></i></c:if>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-xs-offset-4">
			<form action="memberList.do" id="search_form" method="get">
				<select name="keyfield" class="col-xs-2 search">
					<option value="user_id">ID</option>
					<option value="user_nm">이름</option>
					<option value="user_email">이메일</option>
					<option value="all">전체</option>
				</select>
				<input type="text" name="keyword" id="keyword" class="col-xs-2 search" >
				<input type="submit" value="찾기" class="col-xs-1 search" >
				<input type="button" value="목록" class="col-xs-1 search"
				onclick="location.href='memberList.do'">
			</form>
			</div>
			
			<div class="text-center col-xs-12 paging">${pagingHtml}</div>
			</c:if>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->