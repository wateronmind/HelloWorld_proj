<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 중앙 컨텐츠 시작 -->
</div>
<div class="container table-list">
	<div class="row">
		<br><br>
		<h3 class="text-center">투어 신청 목록</h3>
		<br>
		
		<div class="col-xs-12">
			<c:if test="${count == 0}">
			<div class="align-center">신청한 회원이 없습니다.</div>
			</c:if>
			
			<c:if test="${count > 0}">
			<div class="table-responsive">
				<table class="table table-striped">
					<tr>
						<th>번호</th>
						<th>회원 ID</th>
						<th>투어 ID</th>
						<th>신청일자</th>
						<th>인원</th>
					</tr>
					<c:forEach var="tour_info" items="${list}">
					<tr>
						<td>
						   ${tour_info.ta_idx}
						</td>
						<td>
							${tour_info.user_id}
						</td>
						<td>${tour_info.ti_id}</td>
						<td>${tour_info.ti_reg_dt}</td>
						<td>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-xs-offset-4">
			<form action="applyList.do" id="search_form" method="get">
				<select name="keyfield" class="col-xs-2" >
       				<option value="ti_id">투어 ID</option>
					<option value="user_id">회원 ID</option>
					<option value="ti_reg_dt">신청일자</option>
					<option value="all">전체</option>
				</select>
				<input type="text" name="keyword" id="keyword" class="col-xs-2" >
				<input type="submit" value="찾기" class="col-xs-1" >
				<input type="button" value="목록" class="col-xs-1"
				onclick="location.href='applyList.do'">
			</form>
			</div>
			
			<div class="text-center col-xs-12 paging">${pagingHtml}</div>
			</c:if>
		</div>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->