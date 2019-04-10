<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/hotelList.js"></script>
<!--Welcome secton-->
	<jsp:include page="../main/main_header.jsp" />
</div>
<!--Header section end-->
<div class="our-news text-center ptb-80 white_bg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-80">
					<h2>
						Hotel <span>List</span>
					</h2>
				</div>
			</div>
		</div>
		<div class="news-list">
			<div class="row">
				<div class="our-news-list owl-pagination">
					<div class="single-view_post">
						<c:forEach var="hotel" items="${hotelList}" varStatus="status">
						<div class="col-md-12 pb-80">
							<div class="news-inner">
								<div class="news-img">
									<img src="../resources/images/hotel/main/${hotel.st_id}.jpg" width="400" height="360">
									<div class="news-post">
										<div class="n-date">${hotel.st_nm}</div>
										<div class="comment">${hotel.st_type}</div>
										<!-- <a href="#" class="comment">
											<span><i class="mdi mdi-comment-processing-outline"></i></span> 20
										</a>
										<div class="news-views">
											<a href="#"><span><i class="mdi mdi-heart"></i></span>40</a>
										</div> -->
									</div>
								</div>
								<div class="news-desc">
									<h3 class="news-title">
										<a href="${pageContext.request.contextPath}/hotel/roomList.do?id=${hotel.st_id}" target="_blank">${hotel.st_nm}</a>
										<i class="mdi bus-clock"></i>
									</h3>
									<p class="news_desc">${hotel.st_content}</p>
									<div class="news-action">
										<div class="read-more">
											<a href="${pageContext.request.contextPath}/hotel/roomList.do?id=${hotel.st_id}" target="_blank">상세 보기</a>
										</div>
										<div class="news-share" id="cvntl_${hotel.st_id}" data-id="${hotel.st_cvntl}">
											<c:if test="${!empty hotel.st_cvntl}">
											<p>편의시설</p>
											<c:forEach var="cvntl" items="${hotel.st_cvntl_list}" varStatus="cvntl_status">
												<c:if test="${cvntl_status.index < 5}">
													<i class="mdi mdi-${cvntl.cvntl_icon}" title="${cvntl.cvntl_nm}"></i>
												</c:if>
												<c:if test="${cvntl_status.index == 5}">
													<i class="mdi mdi-dots-horizontal" title="more"></i>
												</c:if>
											</c:forEach>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					<c:if test="${status.index%5 == 4}">
					</div>
					<div class="single-view_post">
					</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
