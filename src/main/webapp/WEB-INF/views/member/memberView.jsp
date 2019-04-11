<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container write-form">
	<div class="row ">
		<h2 class="text-center margin-top">회원상세정보</h2>
		<br><br>
		<div class="table-responsive col-xs-4 col-xs-offset-4">
		<table class="table table-striped pull-right">
		<tr>
			<th>아이디</th>
			<td>${member.user_id} 
				<c:if test="${member.user_auth==1}"> <i class="fas fa-user"></i></c:if>
				<c:if test="${member.user_auth==2}"> [가이드]<i class="fas fa-user-check"></i></c:if>
				<c:if test="${member.user_auth==3}"> [관리자]<i class="fas fa-user-cog"></i></c:if>
			</td>
		</tr>
		<c:if test="${user_auth==member.user_auth }">
		<tr>
			<th>비밀번호</th>
			<td>
				<button class="btn btn-small" onclick="location.href='changePassword.do'">비밀번호 변경</button>
			</td>
		</tr>
		</c:if>
		<tr>
			<th>이름</th>
			<td>${member.user_nm}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${member.user_phone}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${member.user_email}</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>${member.user_mil}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${member.user_phone} </td>
		</tr>
		<c:if test="${user_auth!=3}">		
		<tr>
			<th>회원 상태</th>
			<td>
			<!-- 가이드 신청 안함 -->
			<c:if test="${member.user_guide_apply=='N'}">	
				<c:if test="${empty member.user_apply_dt}">
					일반 회원
					<c:if test="${user_auth==member.user_auth }">
					<button type="button" class="btn btn-small"
					onclick="location.href='${pageContext.request.contextPath}/member/applyGuide.do'">가이드 신청하기</button>
					</c:if>
				</c:if>
				<c:if test="${!empty member.user_apply_dt}">가이드 승인 대기 중
					<c:if test="${user_auth==member.user_auth }">
					<button type="button" class="btn btn-small"
					onclick="location.href='${pageContext.request.contextPath}/member/cancelGuide.do'"> 신청 취소하기</button>
					</c:if>
				</c:if>
			</c:if><!-- end of member.user_guide_apply = N -->

			<!-- 가이드 신청 함 -->
			<c:if test="${member.user_guide_apply=='Y'}">
				[가이드]<i class="fas fa-user-check"></i>
						<c:if test="${user_auth==member.user_auth }">
						<button type="button" class="btn btn-small"
						onclick="location.href='${pageContext.request.contextPath}/member/cancelGuide.do'">가이드 취소하기</button>
						</c:if>
			</c:if><!-- end of member.user_guide_apply = Y -->
			</td>
		</tr>
		</c:if>
		</table>
		
			<%-- <ul>
				<li>아이디 : ${member.user_id} 
				<c:if test="${member.user_auth==1}"> <i class="fas fa-user"></i></c:if>
				<c:if test="${member.user_auth==2}"> [가이드]<i class="fas fa-user-check"></i></c:if>
				<c:if test="${member.user_auth==3}"> [관리자]<i class="fas fa-user-cog"></i></c:if>
				<button class="btn btn-default btn-xs" onclick="location.href='changePassword.do'">비밀번호 변경</button>
				</li>
				<li>이름 : ${member.user_nm}</li>
				<li>전화번호 : ${member.user_phone}</li>
				<li>이메일 : ${member.user_email}</li>
				<li>마일리지 : ${member.user_mil}
				<c:if test="${member.user_mil!=0 }"><a href="">${member.user_mil}</a></c:if> 
				</li>
				<!-- 일반, 가이드 등급만 가이드 신청,취소 가능 -->
				<c:if test="${member.user_auth!=3}">
					<!-- 가이드 신청 안했으면 가이드 신청 여부 보여주기 (신청 후 -->
					<c:if test="${member.user_guide_apply=='N'}">
					<li>가이드 신청 현황 : 
						<c:if test="${empty member.user_apply_dt}">
							<button type="button" class="btn btn-primary btn-xs"
							onclick="location.href='${pageContext.request.contextPath}/member/applyGuide.do'">가이드 신청</button>
						</c:if>
						<c:if test="${!empty member.user_apply_dt}">
						가이드 승인 대기 중
							<button type="button" class="btn btn-primary btn-xs"
							onclick="location.href='${pageContext.request.contextPath}/member/cancelGuide.do'">신청 취소</button>
						</c:if>
					</li>
					</c:if>
					
					<c:if test="${member.user_guide_apply=='Y'}">
					<li>가이드 신청 현황 : [가이드]<i class="fas fa-user-check"></i>
					<button type="button" class="btn btn-default btn-xs"
					onclick="location.href='${pageContext.request.contextPath}/member/cancelGuide.do'">가이드 취소</button></li>
					</c:if>
				</c:if>
			</ul> --%>
		</div>
		<div class="col-xs-12 btn-submit">
			<c:if test="${user_auth==member.user_auth }">
			<input type="button" value="수정" class="btn btn-ok" onclick="location.href='update.do'"/>
			<input type="button" value="탈퇴" class="btn btn-default" onclick="location.href='delete.do'"/>
			</c:if>
		</div>
		<section><br><br><br><br></section>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->