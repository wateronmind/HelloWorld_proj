<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/hotelList.js"></script>
<!--Welcome secton-->
	<div class="welcome-section text-center ptb-110">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="breadcurbs-inner">
						<div class="breadcrubs">
							<h2>Hotel List</h2>
							<div class="breadcrubs-menu">
								<ul>
									<li><a href="${pageContext.request.contextPath}/main/main.do">Home<i class="mdi mdi-chevron-right"></i></a></li>
									<li>hotel</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
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
						<span>Hotel</span> List
					</h2>
					<p>There are many variations of passages of Lorem Ipsum
						available, but the majority have suffered by injected humour.</p>
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
									<img src="../resources/images/hotel/main/${hotel.st_id}.jpg" alt="">
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
										<a href="${pageContext.request.contextPath}/hotel/detail.do?id=${hotel.st_id}">${hotel.st_nm}</a>
									</h3>
									<p class="news_desc">${hotel.st_content}</p>
									<div class="news-action">
										<div class="read-more">
											<a href="${pageContext.request.contextPath}/hotel/detail.do?id=${hotel.st_id}">상세 보기</a>
										</div>
										<div class="news-share" id="cvntl${hotel.st_id}" data-id="${hotel.st_cvntl}">
											<p>편의시설</p>
											<i class="mdi mdi-wifi"></i>
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
