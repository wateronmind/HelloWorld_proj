<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->  

<!-- Pre Loader
============================================ -->
<div class="preloader">
	<div class="loading-center">
		<div class="loading-center-absolute">
			<div class="object object_one"></div>
			<div class="object object_two"></div>
			<div class="object object_three"></div>
		</div>
	</div>
</div>
<!-- header-section 시작 -->
<div class="header-section">
	<div class="bg-opacity"></div>
	<div class="top-header sticky-header">
	    <div class="top-header-inner">
	        <div class="container">
	            <div class="mgea-full-width">
	                <div class="row">
	                    <div class="col-md-2 col-sm-2 col-xs-12">
	                        <div class="logo mt-15">
	                            <a href="${pageContext.request.contextPath}/main/main.do">
	                                <span>Hello</span>
	                                <span>World</span>
	                            </a>
	                        </div>
	                    </div>
	                    <div class="col-md-10 col-sm-10 hidden-xs">
	                        <div class="menu">
	                            <div class="menu-list hidden-sm hidden-xs">
	                                <nav>
	                                    <ul>
	                                        <li><a href="index.html">항공권/호텔</a></li>
	                                        <li><a href="${pageContext.request.contextPath}/packTour/list.do">패키지/투어</a></li>
	                                        <li><a href="gallery.html">여행후기</a></li>
	                                        <li><a href="#">여행물품 대여<i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="booking-information.html">카메라</a></li>
				<li><a href="personal-information.html">등산용품</a></li>
				<li><a href="payment-information.html">물놀이용품</a></li>
				<li><a href="booking-done.html">휴대폰용품</a></li>
				<li><a href="room-booking.html">놀거리</a></li>
				<li><a href="gallery.html">기타</a></li>
				<li><a href="${pageContext.request.contextPath}/item/itemWrite.do">관리자등록메뉴</a></li>
				<li><a href="${pageContext.request.contextPath}/item/categoryWrite.do">관리자카테고리등록메뉴</a></li>
				 <li><a href="404.html">관리자목록관리</a></li>
	                                            </ul>
	                                        </li>
	                                        <li><a href="#">가이드<i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="booking-information.html">투어 등록</a></li>
				<li><a href="personal-information.html">투어 내역</a></li>
	                                            </ul>
	                                        </li>
	                                        <li><a href="#">관리자<i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/admin/flightWrite.do">항공권 등록</a></li>
				<li><a href="personal-information.html">투어 내역</a></li>
	                                            </ul>
	                                        </li>
	                                    </ul>
	                                </nav>
	                            </div>
	                            <div class="menu-right">
	                                <a href="index.html">HOME</a>
	                                <a href="${pageContext.request.contextPath}/main/login.do">로그인</a>
	                                <a href="mypage.html">마이페이지</a>
	                                <a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>    
	    </div>
	     <!-- Mobile menu start -->
	    <div class="mobile-menu-area hidden-lg hidden-md">
	        <div class="container">
	            <div class="col-md-12">
	                <nav id="dropdown">
	                <ul>
	                    <li><a href="#">항공권/호텔</a></li>
	                    <li><a href="#">패키지/투어</a></li>
	                    <li><a href="#">여행후기</a></li>
	                    <li><a href="#">여행물품 대여<i class="fa fa-angle-down"></i></a>
	                        <ul class="dropdown_menu">
	                            <li><a href="#">카메라</a></li>
	                            <li><a href="#">등산용품</a></li>
	                            <li><a href="#">물놀이용품</a></li>
	                            <li><a href="#">휴대폰용품</a></li>
	                            <li><a href="#">놀거리</a></li>
	                            <li><a href="#">기타</a></li>
	                        </ul>
	                    </li>
	                    <li><a href="#">가이드<i class="fa fa-angle-down"></i></a>
	                        <ul class="dropdown_menu">
	                            <li><a href="#">투어 등록</a></li>
	                            <li><a href="#">투어 내역</a></li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="index.html">HOME</a>
	                    </li>
	                    <li>
	                        <a href="#">로그인</a>
	                    </li>
	                    <li>
	                        <a href="#">마이페이지</a>
	                    </li>
	                    <li>
	                        <a href="#">장바구니</a>
	                    </li>
	                </ul>
	            </nav>
	            </div>
	        </div>
	    </div>
	    <!-- Mobile menu end -->
</div>
<!-- Header-section end -->
