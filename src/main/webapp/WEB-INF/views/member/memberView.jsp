<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 중앙 컨텐츠 시작 -->
</div>
<div class="container">
	<div class="row">
		<div class="col-md-8 col-xs-8 col-md-offset-2">
			<h2 class="text-center">회원<span class="text-success">상세정보</span></h2>
			<div class="welcome-desc">
				<ul>
					<li>아이디 : ${member.user_id} 
					<c:if test="${member.user_auth==1}"> <i class="fas fa-user"></i></c:if>
					<c:if test="${member.user_auth==2}"> [가이드]<i class="fas fa-user-check"></i></c:if>
					<c:if test="${member.user_auth==3}"> [관리자]<i class="fas fa-user-cog"></i></c:if>
					<button class="btn btn-default btn-xs" onclick="location.href='changePassword'">비밀번호 변경</button>
					</li>
					<li>이름 : ${member.user_nm}</li>
					<li>전화번호 : ${member.user_phone}</li>
					<li>이메일 : ${member.user_email}</li>
					<li>마일리지 : ${member.user_mil}</li>
					<!-- 가이드 신청 안했으면 가이드 신청 여부 보여주기 (신청 후 -->
					<c:if test="${member.user_guide_apply=='N'}">
					<li>가이드 신청 현황 : <button type="button" class="btn btn-primary btn-xs">가이드 신청</button></li>
					</c:if>
					
					<c:if test="${member.user_guide_apply=='Y'}">
					<li>가이드 신청 현황 : <button type="button" class="btn btn-primary btn-xs">가이드 취소</button></li>
					</c:if>
				</ul>
			</div>
			<hr size="1" width="100%">
			<div class="text-center">
				<button type="button" class="btn btn-default" onclick="location.href='update.do'">수정</button>
				<button type="button" class="btn btn-default" onclick="location.href='delete.do'">탈퇴</button>
			</div>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->