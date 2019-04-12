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
						<span>Flight</span> List
					</h2>
					<p>There are many variations of passages of Lorem Ipsum
						available, but the majority have suffered by injected humour.</p>
				</div>
			</div>
		</div>
	</div>
</div>
