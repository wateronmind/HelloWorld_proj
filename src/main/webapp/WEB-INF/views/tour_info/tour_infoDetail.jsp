<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/tour_infoReply.js"></script>
<div class="container">
	<div class="row align-center">
		<h1>${tour_info.ti_nm}</h1>
		
		<hr size="1" width="100%">
		<c:if test="${fn:endsWith(tour_info.ti_img,'.jpg') ||
		            fn:endsWith(tour_info.ti_img,'.JPG') ||
		            fn:endsWith(tour_info.ti_img,'.gif') ||
		            fn:endsWith(tour_info.ti_img,'.GIF') ||
		            fn:endsWith(tour_info.ti_img,'.png') ||
		            fn:endsWith(tour_info.ti_img,'.PNG')}">
    	   <div class="align-center">
		      <img src="imageView.do?ti_id=${tour_info.ti_id}" style="max-width:600px;">        
          </div>		
		</c:if>
		<ul>
			<li>1.작성자 : ${tour_info.user_id}</li>
			<li>2.작성일자 : ${tour_info.reg_date}</li>
			<li>3.투어 경비 : ${tour_info.ti_pc}</li>
			<li>4.최소인원 : ${tour_info.ti_min_pp}</li>
			<li>5.최대인원 : ${tour_info.ti_max_pp}</li>
			<li>6.픽업 장소 : ${tour_info.ti_pickup_place}</li>
			<li>7.픽업 시간 : ${tour_info.ti_pickup_time}</li>
		
		</ul><br>
		<p>
		8.상세 내용<br>
			${tour_info.ti_content}
		</p>
		<hr size="1" width="100%">
		<div class="btn-submit col-xs-12 align-right">       <!-- 작성자 일 경우만 보여짐 -->
			<c:if test="${!empty user_id && user_id == tour_info.user_id}">
				<input type="button" value="삭제"  onclick="location.href='delete.do?ti_id=${tour_info.ti_id}'">
				<input type="button" value="수정" onclick="location.href='update.do?ti_id=${tour_info.ti_id}'">
			</c:if>
			<input type="button" value="목록" onclick="location.href='list.do'">
		</div>
		<div class="btn-submit col-xs-12 align-right">       <!-- 일반 회원일 경우 -->
			<%-- <c:if test="${!empty user_id && user_id != tour_info.user_id}">
				 <input type="button" value="신청하기"  onclick="location.href='apply.do?ti_id=${tour_info.ti_id}'"> 
			</c:if> --%>
		</div>
		
		<div id="reply_div">
			<!-- <span class="reply-title">댓글 달기</span> -->
			<span class="btn-submit col-xs-12">댓글 달기</span>
			<form id="re_form">
				<input type="hidden" name="ti_id" value="${tour_info.ti_id}" id="ti_id">
				<input type="hidden" name="user_id" value="${user_id}" id="user_id">
				<textarea rows="3" cols="50" name="tr_content" id="tr_content" class="rep-content"
				<c:if test="${empty user_id}">disabled="disabled"</c:if>
				><c:if test="${empty user_id}">로그인해야 작성할 수 있습니다.</c:if></textarea>
				<c:if test="${!empty user_id}">
				<div id="re_first">
					<span class="letter-count">200/200</span>
				</div>
				<div id="re_second" class="align-right">
					<input type="submit" value="전송">
				</div>
				</c:if>
			</form>
		</div>
		
		<!-- 댓글 목록 출력 -->
		<div id="output"></div>
		<div class="paging-button" style="display:none;">
			<input type="button" value="다음글 보기">
		</div>
		<div id="loading" style="display:none;">
			<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
		</div>
	</div>
</div>