<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- <script type="text/javascript">
	var result = '${result}';
	if(result == 'success'){
		alert('처리가 완료되었습니다.');
	}
</script> -->
<!-- 목록 시작 -->
</div>
<div class="container table-list">
	<div class="row">
		<div class="col-md-6 col-sm-6">
			<div class="booking-box">
				<div class="btn-list row">
					<h3>투어 검색</h3>
					<p>원하는 조건으로 투어를 검색하세요</p>
				</div>
				<div class="booking-form">
					<form action="list.do" id="search_form" method="get">
						<div class="travel-city mb-15">
						  <select name="keyfield"></select>
							<input type="text" value="all" placeholder="투어 키워드"> <input
								class="date-picker" value="ti_start_day" type="text" placeholder="출발 일자"> <input
								type="text" value="user_id" placeholder="작성자">
						</div>
						<div class="submit-form">
							<button type="submit">검색하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<%-- <div class="row">
		<br>
		<br>
		<h3 class="text-center">투어 목록</h3>
		<form action="list.do" id="search_form" method="get">
			<!-- <div class="col-md-3 col-sm-3"> -->
			<div class="col-xs-offset-2">
				<ul>
					<li><select name="keyfield">
							<option value="ti_nm">투어명</option>
							<option value="ti_start_day">출발 일자</option>
							<option value="all">키워드</option>
							<!-- 투어명하고 상세설명 두개를 포함해서? -->
					</select></li>
					<li><input type="text" name="keyword" id="keyword"></li>
					<li><input type="submit" value="찾기"> <input
						type="button" value="목록" onclick="location.href='list.do'">
					</li>
				</ul>
			</div>
		</form>
	</div> --%>

		<div class="row">
			<div class="col-xs-12">
				<!-- <div class=welcome-text> -->
				<c:if test="${count == 0}">
					<div class="align-center">등록된 투어 게시물이 없습니다.</div>
				</c:if>
				<c:if test="${count > 0}">
					<div class="table">
						<table class="table" style="width: 600px">
							<tr>
								<th>투어 ID</th>
								<th width="250">투어 명</th>
								<th>작성자</th>
								<th>시작 일자</th>
								<!-- <th>조회수</th> -->
							</tr>
							<c:forEach var="tour_info" items="${list}">
								<tr>
									<td>${tour_info.ti_id}</td>
									<td><a href="detail.do?ti_id=${tour_info.ti_id}">${tour_info.ti_nm}
											(${tour_info.re_cnt})</a></td>
									<td>${tour_info.user_id}</td>
									<td>${tour_info.ti_start_day}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="align-center">${pagingHtml}</div>
				</c:if>
			</div>
		</div>
	</div>
</div>
	<!-- 중앙 컨텐츠 끝 -->