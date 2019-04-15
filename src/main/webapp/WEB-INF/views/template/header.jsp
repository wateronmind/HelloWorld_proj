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
	                                        <li><a href="${pageContext.request.contextPath}/tour_info/list.do">패키지/투어</a></li>
	                                        <li><a href="${pageContext.request.contextPath}/review/list.do">여행후기</a></li>
	                                       
	                                        <li><a href="${pageContext.request.contextPath}/item/itemMain.do">여행물품 대여<i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/item/camera.do">카메라</a></li>
				<li><a href="${pageContext.request.contextPath}/item/mountain.do">등산용품</a></li>
				<li><a href="${pageContext.request.contextPath}/item/water.do">물놀이용품</a></li>
				<li><a href="${pageContext.request.contextPath}/item/phone.do">휴대폰용품</a></li>
				<li><a href="${pageContext.request.contextPath}/item/play.do">놀거리</a></li>
				<li><a href="${pageContext.request.contextPath}/item/etc.do">기타</a></li>
	                                            </ul>
	                                        </li>
	                                        <!-- 가이드 로그인 -->
	                                        <c:if test="${!empty user_id&& user_auth==2}">
	                                        <li><a href="#">가이드<i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/tour_info/write.do">투어 등록</a></li>
				<li><a href="${pageContext.request.contextPath}/tour_info/applyList.do">투어 내역</a></li>
	                                            </ul>
	                                        </li>
	                                        </c:if>
	                                        
	                                        <!-- 관리자 로그인 -->
	                                        <c:if test="${!empty user_id && user_auth==3}">
	                                        <li>
	                                        	<label class="sr-only">관리자</label>
	                                        	<a href="#"><i class="fas fa-cog"></i> <i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/admin/flightWrite.do">항공권 등록</a></li>
				<li><a href="personal-information.html">투어 내역</a></li>
				<li><a href="${pageContext.request.contextPath}/item/admin_itemList.do">관리자여행물품메뉴</a></li>
				<li><a href="${pageContext.request.contextPath}/item/categorylist.do">관리자카테고리메뉴</a></li>
				<li><a href="${pageContext.request.contextPath}/member/guideList.do">가이드 관리</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberList.do">회원 목록</a></li>
	                                            </ul>
	                                        </li>
	                                        </c:if>
	                                    </ul>
	                                </nav>
	                            </div>
	                            <div class="menu-right">
	                            	<!-- 회원 메뉴 --> 
	                            	<c:if test="${!empty user_id}">
	                            	 <nav>
	                                    <ul>
	                                        <li><a href="#">${user_id}님 
	                                    <!-- 로그인 상태 관리자 -->
										<c:if test="${!empty user_id && user_auth==3 }"><i class="fas fa-user-cog"></i></c:if>
										<!-- 로그인 상태 일반 -->
										<c:if test="${!empty user_id && user_auth==1 }"><i class="fas fa-user"></i></c:if>
										<!-- 로그인 상태 가이드 -->
										<c:if test="${!empty user_id && user_auth==2 }"><i class="fas fa-user-check"></i></c:if>
											<i class="fa fa-angle-down"></i></a>
	                                            
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a></li>
				<li><a href="${pageContext.request.contextPath}/member/detail.do">회원상세정보</a></li>
				<li><a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
	                                            </ul>
	                                        </li>
	                                    </ul>
	                                </nav>
	                            	</c:if>
	                            	
	                                <!-- 로그인 상태 -->
	                              <%--   <c:if test="${!empty user_id}">
	                                <a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a>
=======
>>>>>>> e2f55a40c4d00bb83be1cf12455ef782a49067ca
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
                                           <li><a href="${pageContext.request.contextPath}/tour_info/list.do">패키지/투어</a></li>
                                           <li><a href="gallery.html">여행후기</a></li>
                                           <li><a href="${pageContext.request.contextPath}/item/itemMain.do">여행물품 대여<i class="fa fa-angle-down"></i></a>
                                               <ul class="dropdown_menu">
            <li><a href="${pageContext.request.contextPath}/item/camera.do">카메라</a></li>
            <li><a href="${pageContext.request.contextPath}/item/mountain.do">등산용품</a></li>
            <li><a href="${pageContext.request.contextPath}/item/water.do">물놀이용품</a></li>
            <li><a href="${pageContext.request.contextPath}/item/phone.do">휴대폰용품</a></li>
            <li><a href="${pageContext.request.contextPath}/item/play.do">놀거리</a></li>
            <li><a href="${pageContext.request.contextPath}/item/etc.do">기타</a></li>
            <li><a href="${pageContext.request.contextPath}/item/itemDetail.do">(테스트)상세페이지</a></li>
                   </ul>
                                           </li>
                                           <!-- 가이드 로그인 -->
                                           <c:if test="${!empty user_id&& user_auth==2}">
                                           <li><a href="#">가이드<i class="fa fa-angle-down"></i></a>
                                               <ul class="dropdown_menu">
            <li><a href="${pageContext.request.contextPath}/tour_info/write.do">투어 등록</a></li>
            <li><a href="personal-information.html">투어 내역</a></li>
                                               </ul>
                                           </li>
                                           </c:if>
                                           
                                           <!-- 관리자 로그인 -->
                                           <c:if test="${!empty user_id && user_auth==3}">
                                           <li>
                                              <label class="sr-only">관리자</label>
                                              <a href="#"><i class="fas fa-cog"></i> <i class="fa fa-angle-down"></i></a>
                                               <ul class="dropdown_menu">
            <li><a href="${pageContext.request.contextPath}/admin/flightWrite.do">항공권 등록</a></li>
            <li><a href="personal-information.html">투어 내역</a></li>
            <li><a href="${pageContext.request.contextPath}/item/admin_itemList.do">관리자여행물품메뉴</a></li>
            <li><a href="${pageContext.request.contextPath}/item/categorylist.do">관리자카테고리메뉴</a></li>
            <li><a href="${pageContext.request.contextPath}/member/guideList.do">가이드 관리</a></li>
            <li><a href="${pageContext.request.contextPath}/member/memberList.do">회원 목록</a></li>
                                               </ul>
                                           </li>
                                           </c:if>
                                       </ul>
                                   </nav>
                               </div>
                               <div class="menu-right">
                                  <!-- 회원 메뉴 --> 
                                  <c:if test="${!empty user_id}">
                                   <nav>
                                       <ul>
                                           <li><a href="#">${user_id}님 
                                       <!-- 로그인 상태 관리자 -->
                              <c:if test="${!empty user_id && user_auth==3 }"><i class="fas fa-user-cog"></i></c:if>
                              <!-- 로그인 상태 일반 -->
                              <c:if test="${!empty user_id && user_auth==1 }"><i class="fas fa-user"></i></c:if>
                              <!-- 로그인 상태 가이드 -->
                              <c:if test="${!empty user_id && user_auth==2 }"><i class="fas fa-user-check"></i></c:if>
                                 <i class="fa fa-angle-down"></i></a>
                                               
                                               <ul class="dropdown_menu">
            <li><a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a></li>
            <li><a href="${pageContext.request.contextPath}/member/detail.do">회원상세정보</a></li>
            <li><a href="${pageContext.request.contextPath}/member/detail.do">회원상세정보</a></li>
            <li><a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
                                               </ul>
                                           </li>
                                       </ul>
                                   </nav>
                                  </c:if>
                                  
                                   <!-- 로그인 상태 -->
                                 <%--   <c:if test="${!empty user_id}">
                                   <a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a>
<<<<<<< HEAD
=======
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
	                                        <li><a href="${pageContext.request.contextPath}/item/itemMain.do">여행물품 대여<i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/item/camera.do">카메라</a></li>
				<li><a href="${pageContext.request.contextPath}/item/mountain.do">등산용품</a></li>
				<li><a href="${pageContext.request.contextPath}/item/water.do">물놀이용품</a></li>
				<li><a href="${pageContext.request.contextPath}/item/phone.do">휴대폰용품</a></li>
				<li><a href="${pageContext.request.contextPath}/item/play.do">놀거리</a></li>
				<li><a href="${pageContext.request.contextPath}/item/etc.do">기타</a></li>
				<li><a href="${pageContext.request.contextPath}/item/itemDetail.do">(테스트)상세페이지</a></li>
						 </ul>
	                                        </li>
	                                        <!-- 가이드 로그인 -->
	                                        <c:if test="${!empty user_id&& user_auth==2}">
	                                        <li><a href="#">가이드<i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/tour_info/write.do">투어 등록</a></li>
				<li><a href="personal-information.html">투어 내역</a></li>
	                                            </ul>
	                                        </li>
	                                        </c:if>
	                                        
	                                        <!-- 관리자 로그인 -->
	                                        <c:if test="${!empty user_id && user_auth==3}">
	                                        <li>
	                                        	<label class="sr-only">관리자</label>
	                                        	<a href="#"><i class="fas fa-cog"></i> <i class="fa fa-angle-down"></i></a>
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/admin/flightWrite.do">항공권 등록</a></li>
				<li><a href="personal-information.html">투어 내역</a></li>
				<li><a href="${pageContext.request.contextPath}/item/admin_itemList.do">관리자여행물품메뉴</a></li>
				<li><a href="${pageContext.request.contextPath}/item/categorylist.do">관리자카테고리메뉴</a></li>
				<li><a href="${pageContext.request.contextPath}/member/guideList.do">가이드 관리</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberList.do">회원 목록</a></li>
	                                            </ul>
	                                        </li>
	                                        </c:if>
	                                    </ul>
	                                </nav>
	                            </div>
	                            <div class="menu-right">
	                            	<!-- 회원 메뉴 --> 
	                            	<c:if test="${!empty user_id}">
	                            	 <nav>
	                                    <ul>
	                                        <li><a href="#">${user_id}님 
	                                    <!-- 로그인 상태 관리자 -->
										<c:if test="${!empty user_id && user_auth==3 }"><i class="fas fa-user-cog"></i></c:if>
										<!-- 로그인 상태 일반 -->
										<c:if test="${!empty user_id && user_auth==1 }"><i class="fas fa-user"></i></c:if>
										<!-- 로그인 상태 가이드 -->
										<c:if test="${!empty user_id && user_auth==2 }"><i class="fas fa-user-check"></i></c:if>
											<i class="fa fa-angle-down"></i></a>
	                                            
	                                            <ul class="dropdown_menu">
				<li><a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a></li>
				<li><a href="${pageContext.request.contextPath}/member/detail.do">회원상세정보</a></li>
				<li><a href="${pageContext.request.contextPath}/member/detail.do">회원상세정보</a></li>
				<li><a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
	                                            </ul>
	                                        </li>
	                                    </ul>
	                                </nav>
	                            	</c:if>
	                            	
	                                <!-- 로그인 상태 -->
	                              <%--   <c:if test="${!empty user_id}">
	                                <a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a>
>>>>>>> aceb85f0921b8cb23e73d59112985f0102acbcf4
=======
>>>>>>> 7f8442bbc93aee0197a578eadc06029e3d34ceee
>>>>>>> e2f55a40c4d00bb83be1cf12455ef782a49067ca

                                    <a href="${pageContext.request.contextPath}/itemcart/orderForm.do">(테스트용)결제</a> 

                           <a href="${pageContext.request.contextPath}/member/detail.do">마이페이지</a>
                                   <a href="${pageContext.request.contextPath}/member/logout.do">${user_id}님 
                              <!-- 로그인 상태 관리자 -->
                              <c:if test="${!empty user_id && user_auth==3 }"><i class="fas fa-user-cog"></i></c:if>
                              <!-- 로그인 상태 일반 -->
                              <c:if test="${!empty user_id && user_auth==1 }"><i class="fas fa-user"></i></c:if>
                              <!-- 로그인 상태 가이드 -->
                              <c:if test="${!empty user_id && user_auth==2 }"><i class="fas fa-user-check"></i></c:if>
                              로그아웃</a>

                           </c:if> --%>
                     
                           
                                   <!-- 로그아웃 상태 -->
                                   <c:if test="${empty user_id}">
                                   <a href="${pageContext.request.contextPath}/member/login.do">로그인</a>
                                   <a href="${pageContext.request.contextPath}/member/write.do">회원가입</a>
                                   </c:if>
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
                       <li><a href="${pageContext.request.contextPath}/tour_info/list.do">패키지/투어</a></li>
                       <li><a href="#">여행후기</a></li>
                       <li><a href="${pageContext.request.contextPath}/item/itemDetail.do">여행물품 대여<i class="fa fa-angle-down"></i></a>
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
                               <li><a href="${pageContext.request.contextPath}/tour_info/write.do">투어 등록</a></li>
                               <li><a href="${pageContext.request.contextPath}/tour_info/applyList.do">투어 내역</a></li>
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
                           <a href="${pageContext.request.contextPath}/itemcart/cartList.do">장바구니</a>
                       </li>
                   </ul>
               </nav>
               </div>
           </div>
       </div>
       <!-- Mobile menu end -->
</div>
<!-- Header-section end -->