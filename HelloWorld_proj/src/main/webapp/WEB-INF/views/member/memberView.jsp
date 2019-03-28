<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container">
	<div class="row">
		<h1>회원상세정보</h1>
		<ul>
			<li>아이디 : ${member.id}</li>
			<li>이름 : ${member.name}</li>
			<li>전화번호 : ${member.phone}</li>
			<li>이메일 : ${member.email}</li>
			<li>우편번호 : ${member.zipcode}</li>
			<li>주소 : ${member.address1}</li>
			<li>상세주소 : ${member.address2}</li>
			<li>가입일 : ${member.reg_date}</li>
		</ul>
		<hr size="1" width="100%">
		<p class="align-right">
			<input type="button" value="수정" onclick="location.href='update.do'">
			<input type="button" value="회원탈퇴" onclick="location.href='delete.do'">
		</p>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->