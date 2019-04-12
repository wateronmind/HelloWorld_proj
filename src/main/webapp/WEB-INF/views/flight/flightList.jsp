<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/flightList.js"></script>
<!--Welcome secton-->
	<div class="welcome-section text-center ptb-110">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="breadcurbs-inner">
						<div class="breadcrubs">
							<h2>항공권 목록</h2>
							<div class="breadcrubs-menu">
								<ul>
									<li><a href="${pageContext.request.contextPath}/main/main.do">Home<i class="mdi mdi-chevron-right"></i></a></li>
									<li>flight</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- </div> -->
<!--Header section end-->
<!-- search bar Start -->
<div class="search-bar animated slideOutUp">
	<div class="table">
		<div class="table-cell">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2">
						<div class="search-form-wrap">
							<button class="close-search">
								<i class="mdi mdi-close"></i>
							</button>
							<form action="#">
								<input type="text" placeholder="Search here..."
									value="Search here..." />
								<button class="search-button" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- search bar End -->
<div class="our-news text-center ptb-80 white_bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-80">
					<h2>
						<span>Flight</span> List
					</h2>
					<form action="list.do" id="search_form" method="get">
						<ul class="search">
							<li><select name="keyfield">
									<option value="fi_nm">항공사</option>
									<option value="fsi_start_city">출발</option>
									<option value="fsi_arrive_city">도착</option>
									<option value="all">전체</option>
							</select></li>
							<li><input type="text" name="keyword" id="keyword">
							</li>
							<li><input type="submit" value="찾기"> <input
								type="button" value="목록" onclick="location.href='list.do'">
							</li>
						</ul>
					</form>
					<c:if test="${fCount == 0}">
					<div class="align-center">등록된 게시물이 없습니다.</div>
					</c:if>
					<c:if test="${fCount > 0}">
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<th>로고</th>
								<th>항공사</th>
								<th>출발지</th>
								<th>도착지</th>
								<th>경유지1</th>
								<th>경유지2</th>
								<th>출발시간</th>
								<th>도착시간</th>
								<th>경유1시간</th>
								<th>경유2시간</th>
							</tr>
							<c:forEach var="flight" items="${fList}">
							<tr>
								<c:if test="${fn:endsWith(flight.fi_logo,'.jpg') ||
								              fn:endsWith(flight.fi_logo,'.JPG') ||
								              fn:endsWith(flight.fi_logo,'.gif') ||
								              fn:endsWith(flight.fi_logo,'.GIF') ||
								              fn:endsWith(flight.fi_logo,'.png') ||
								              fn:endsWith(flight.fi_logo,'.PNG')}">
								<td><img src="${pageContext.request.contextPath}/resources/images/logo/${flight.fi_logo}" style="max-width:40px;"></td>
								</c:if>
								<td>${flight.fi_nm}</td>
								<td>${flight.fsi_start_city}</td>
								<td>${flight.fsi_arrive_city}</td>
								<td>${flight.fsi_pass1_city}</td>
								<td>${flight.fsi_pass2_city}</td>
								<td>${flight.fsi_start_dt}</td>
								<td>${flight.fsi_arrive_dt}</td>
								<td>${flight.fsi_pass1_dt}</td>
								<td>${flight.fsi_pass2_dt}</td>
								<td><input type="button" value="예약"
				    										onclick="location.href='rsrvWrite.do?fsi_idx=${flight.fsi_idx}'"></td>
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
</div>




















