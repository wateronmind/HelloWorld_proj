<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
<!-- 중앙 컨텐츠 시작 -->
<div class="container">
	<div class="row">
		<h1>회원상세정보</h1>
		<ul>
			<li>아이디 : ${member.user_id} 
			<c:if test="${member.user_auth==2}"> <i class="fas fa-user-check"></i></c:if>
			<c:if test="${member.user_auth==3}"> <i class="fas fa-user-check"></i></c:if>
			</li>
			<li>이름 : ${member.user_nm}</li>
			<li>전화번호 : ${member.user_phone}</li>
			<li>이메일 : ${member.user_email}</li>
			<li>마일리지 : ${member.user_mil}</li>
			<c:if test="${!empty member.user_apply_dt}">
				<li>가이드 신청일 : ${member.user_apply_dt}</li>
			</c:if>
		</ul>
		<hr size="1" width="100%">
		<p class="align-right">
			<input type="button" value="수정" onclick="location.href='update.do'">
			<input type="button" value="회원탈퇴" onclick="location.href='delete.do'">
		</p>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->