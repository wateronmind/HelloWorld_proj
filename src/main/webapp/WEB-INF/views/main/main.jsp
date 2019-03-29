<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!--Welcome secton-->
<div class="welcome-section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-6">
                <div class="booking-box">
                    <div class="btn-list row">
                        <a href="#" class="button border_radius little button-black col-md-6 on">항공권 검색</a>
                        <a href="#" class="button border_radius little button-black col-md-6">호텔 검색</a>
                    </div>
                    <!-- S: flight-srch -->
                    <div class="flight-srch">
                        <div class="booking-title">
                            <h3>항공권 검색</h3>
                            <p>얼마없는 항공권을 검색해 보세요! 나오면 사고 없음 딴데 가보고</p>
                        </div>
                        <div class="booking-form">
                            <form action="#">
                                <div class="travel-city mb-15">
                                    <input type="text" placeholder="여행 도시">
                                </div>
                                <div class="row">
                                    <div class="travel-city mb-15 col-md-6">
                                        <input type="text" placeholder="출발 도시">
                                    </div>
                                    <div class="select-book mb-15 col-md-6">
                                        <select name="book" class="select-booking">
                                            <option value="0" selected>인원</option>
                                            <option value="1">1명</option>
                                            <option value="2">2명</option>
                                            <option value="3">3명</option>
                                            <option value="4">4명</option>
                                            <option value="5">5명</option>
                                            <option value="6">6명</option>
                                            <option value="7">7명이상</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="b-date arrive mb-15 col-md-6">
                                        <input class="date-picker" type="text" placeholder="출발일">
                                        <i class="mdi mdi-calendar-text"></i>
                                    </div>
                                    <div class="b-date departure mb-15 col-md-6">
                                        <input class="date-picker" type="text" placeholder="귀국일">
                                        <i class="mdi mdi-calendar-text"></i>
                                    </div>
                                </div>   
                                <div class="submit-form">
                                    <button type="submit">검색하기</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- E: flight-srch -->

                    <!-- S: hotel-srch -->
                    <div class="hotel-srch">
                            <div class="booking-title">
                                <h3>호텔 검색</h3>
                                <p>얼마없는 호텔을 검색해 보세요! 나오면 사고 없음 딴데 가보고</p>
                            </div>
                            <div class="booking-form">
                                <form action="#">
                                    <div class="b-date arrive mb-15">
                                        <input class="date-picker" type="text" placeholder="체크인 날짜">
                                        <i class="mdi mdi-calendar-text"></i>
                                    </div>
                                    <div class="b-date departure mb-15">
                                        <input class="date-picker" type="text" placeholder="체크아웃 날짜">
                                        <i class="mdi mdi-calendar-text"></i>
                                    </div>
                                    <div class="row">
                                        <div class="select-book mb-15 col-md-6">
                                            <select name="book" class="select-booking">
                                                <option value="0" selected>인원</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                            </select>
                                        </div>
                                        <div class="select-book mb-15 col-md-6">
                                            <select name="book" class="select-booking">
                                                <option value="" selected>Room</option>
                                                <option value="1">Roome 101</option>
                                                <option value="1">Roome 102</option>
                                            </select>
                                        </div>
                                    </div>  
                                    <div class="submit-form">
                                        <button type="submit">검색하기</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- E: hotel-srch -->
                </div>
            </div>
            <div class="col-md-6 col-sm-6">
                <div class="welcome-text">
                    <h2>
                    <span>WELCOEM TO</span> <span class="coloring">Hello World</span>
                    </h2>
                    <h1 class="cd-headline clip">
                        <span>완벽한</span>
                        <span class="cd-words-wrapper coloring">
                            <b class="is-visible">항공권</b>
                            <b>호텔</b>
                            <b>패키지</b>
                            <b>투어</b>
                            <b>아이템</b>
                        </span>
                    </h1>
                    <!-- <p class="welcome-desc">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</p> -->
                        <p class="welcome-desc">많은 여행자들에게 부담없는 가격으로 인기를 얻고 있는 패키지! <br> 현지인에게 안내받는 효율만점 투어! <br> Hello World 만의 특별한 여행을 즐겨 보세요!</p>
                        <div class="explore">
                            <a href="${pageContext.request.contextPath}/packTour/packTour.jsp">패키지/투어 떠나기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Header section end -->

<!--About Section Title start-->
<div class="about-section text-center ptb-80 white_bg clearfix container">
    <div class="row">
        <ul class="package-carousel">
            <li class="item">
                <div class="section-title mb-80">
                    <h2>사생결단 패키지 타이틀 <span>니가가라 하와이</span></h2>
                    <p>그래도 여행은 여행이니깐! 여행을 여행답게! take it!</p>
                </div>
                <div class="about-chondo">
                    <img src="${pageContext.request.contextPath}/resources/images/main/img1.jpg" alt="1번 패키지">
                </div>
            </li>

            <li class="item">
                <div class="section-title mb-80">
                    <h2>봄에는 마! 떠나라 아이가! <span>취준생을 위한 동남아 취업 박람회</span></h2>
                    <p>그래도 여행은 여행이니깐! 여행을 여행답게! take it!</p>
                </div>
                <div class="about-chondo">
                    <img src="${pageContext.request.contextPath}/resources/images/main/img2.jpg" alt="2번 패키지">
                </div>
            </li>

            <li class="item">
                <div class="section-title mb-80">
                    <h2>LALA랜드의 감동을 그대로<span>LA갈비 패키지</span></h2>
                    <p>그래도 여행은 여행이니깐! 여행을 여행답게! take it!</p>
                </div>
                <div class="about-chondo">
                    <img src="${pageContext.request.contextPath}/resources/images/main/img3.jpg" alt="3번 패키지">
                </div>
            </li> 
        </ul>
    </div>
</div>
<!--About Section end-->

<!--Our services start-->
<div class="our-sevices text-center ptb-80 white_bg">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-title mb-80">
                    <h2>투어 상품 <span>TOUR</span></h2>
                    <p>현지 가이드의 추천을 받아 특별한 장소로 투어를 떠납니다! 무슨 일이 생길지 아무도 모르지요... <span>Good Luck!</span></p>
                </div>
            </div>
        </div>
    </div>
    <div class="our-services-list">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="single-services">
                        <div class="services-img">
                            <img src="${pageContext.request.contextPath}/resources/images/services/services1.jpg" alt="">
                            <div class="services-title">
                                <h2>Breakfast & Buffet</h2>
                            </div>
                            <div class="services-hover-desc">
                                <div class="services-hover-inner">
                                    <div class="services-hover-table">
                                        <div class="services-hover-table-cell">
                                            <h2>Breakfast & Buffet</h2>
                                            <p>There are many variations of passages Loem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="single-services">
                        <div class="services-img">
                            <img src="${pageContext.request.contextPath}/resources/images/services/services2.jpg" alt="">
                            <div class="services-title">
                                <h2>Towels and bedding</h2>
                            </div>
                            <div class="services-hover-desc">
                                <div class="services-hover-inner">
                                    <div class="services-hover-table">
                                        <div class="services-hover-table-cell">
                                            <h2>Breakfast & Buffet</h2>
                                            <p>There are many variations of passages Loem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="single-services">
                        <div class="services-img">
                            <img src="${pageContext.request.contextPath}/resources/images/services/services3.jpg" alt="">
                            <div class="services-title">
                                <h2>24/7 Reception</h2>
                            </div>
                            <div class="services-hover-desc">
                                <div class="services-hover-inner">
                                    <div class="services-hover-table">
                                        <div class="services-hover-table-cell">
                                            <h2>24/7 Reception</h2>
                                            <p>There are many variations of passages Loem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="single-services">
                        <div class="services-img">
                            <img src="${pageContext.request.contextPath}/resources/images/services/services4.jpg" alt="">
                            <div class="services-title">
                                <h2>City Tours</h2>
                            </div>
                            <div class="services-hover-desc">
                                <div class="services-hover-inner">
                                    <div class="services-hover-table">
                                        <div class="services-hover-table-cell">
                                            <h2>City Tourst</h2>
                                            <p>There are many variations of passages Loem Ipsum available, but the majority have suffered alteration in some form, by injected humour.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Our services end-->
<!--Our staff start-->
<div class="our-staff text-center pb-80 white_bg">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-title mb-80">
                    <h2>여행 물품 <span>ITEM</span></h2>
                    <p>뭐라도 하나 더 있음 좋지 않을까요? 나중에 울며 불며 떼써도 못 알아 들을 겁니다. 영어로 울어보시든지...</p>
                </div>
            </div>
        </div>
        <div class="staff-list">
            <div class="row">
                <div class="carousel-list">
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="${pageContext.request.contextPath}/resources/images/staff/staff1.jpg" alt="">
                                <div class="staff-title">
                                    <span class="plus"></span>
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>
                                </div>
                                <div class="staff-hover-desc">
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>
                                    <p>There are many variaons of passa of Lorem Ipsuable, amrn in sofby injected humour, amr.</p>
                                    <div class="scoial_icons">
                                        <a href="#"><i class="mdi mdi-facebook"></i></a>
                                        <a href="#"><i class="mdi mdi-rss"></i></a>
                                        <a href="#"><i class="mdi mdi-google-plus"></i></a>
                                        <a href="#"><i class="mdi mdi-instagram"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="${pageContext.request.contextPath}/resources/images/staff/staff2.jpg" alt="">
                                <div class="staff-title">
                                    <span class="plus"></span>
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>

                                </div>
                                <div class="staff-hover-desc">
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>
                                    <p>There are many variaons of passa of Lorem Ipsuable, amrn in sofby injected humour, amr.</p>
                                    <div class="scoial_icons">
                                        <a href="#"><i class="mdi mdi-facebook"></i></a>
                                        <a href="#"><i class="mdi mdi-rss"></i></a>
                                        <a href="#"><i class="mdi mdi-google-plus"></i></a>
                                        <a href="#"><i class="mdi mdi-instagram"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="${pageContext.request.contextPath}/resources/images/staff/staff1.jpg" alt="">
                                <div class="staff-title">
                                    <span class="plus"></span>
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>

                                </div>
                                <div class="staff-hover-desc">
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>
                                    <p>There are many variaons of passa of Lorem Ipsuable, amrn in sofby injected humour, amr.</p>
                                    <div class="scoial_icons">
                                        <a href="#"><i class="mdi mdi-facebook"></i></a>
                                        <a href="#"><i class="mdi mdi-rss"></i></a>
                                        <a href="#"><i class="mdi mdi-google-plus"></i></a>
                                        <a href="#"><i class="mdi mdi-instagram"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="${pageContext.request.contextPath}/resources/images/staff/staff2.jpg" alt="">
                                <div class="staff-title">
                                    <span class="plus"></span>
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>

                                </div>
                                <div class="staff-hover-desc">
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>
                                    <p>There are many variaons of passa of Lorem Ipsuable, amrn in sofby injected humour, amr.</p>
                                    <div class="scoial_icons">
                                        <a href="#"><i class="mdi mdi-facebook"></i></a>
                                        <a href="#"><i class="mdi mdi-rss"></i></a>
                                        <a href="#"><i class="mdi mdi-google-plus"></i></a>
                                        <a href="#"><i class="mdi mdi-instagram"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="${pageContext.request.contextPath}/resources/images/staff/staff1.jpg" alt="">
                                <div class="staff-title">
                                    <span class="plus"></span>
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>

                                </div>
                                <div class="staff-hover-desc">
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>
                                    <p>There are many variaons of passa of Lorem Ipsuable, amrn in sofby injected humour, amr.</p>
                                    <div class="scoial_icons">
                                        <a href="#"><i class="mdi mdi-facebook"></i></a>
                                        <a href="#"><i class="mdi mdi-rss"></i></a>
                                        <a href="#"><i class="mdi mdi-google-plus"></i></a>
                                        <a href="#"><i class="mdi mdi-instagram"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="${pageContext.request.contextPath}/resources/images/staff/staff2.jpg" alt="">
                                <div class="staff-title">
                                    <span class="plus"></span>
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>

                                </div>
                                <div class="staff-hover-desc">
                                    <h2>Soleman</h2>
                                    <h5>hotel staff</h5>
                                    <p>There are many variaons of passa of Lorem Ipsuable, amrn in sofby injected humour, amr.</p>
                                    <div class="scoial_icons">
                                        <a href="#"><i class="mdi mdi-facebook"></i></a>
                                        <a href="#"><i class="mdi mdi-rss"></i></a>
                                        <a href="#"><i class="mdi mdi-google-plus"></i></a>
                                        <a href="#"><i class="mdi mdi-instagram"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Our staff end-->

<!-- 여행후기 list -->
<div class="container main-board-list mb-100">
    <div class="row">
        <div class="section-title mb-20">
            <h2><span>여행 후기</span></h2>
        </div>
        <table class="table table-striped table-responsive table-hover">
            <thead>
                <tr>
                    <th>등록일</th>
                    <th>제목</th>
                    <th>작성자</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>2019.01.01</td>
                    <td>즐거웠던 바르셀로나</td>
                    <td>메시</td>
                </tr>
                <tr>
                    <td>2019.01.01</td>
                    <td>즐거웠던 바르셀로나</td>
                    <td>메시</td>
                </tr>
                <tr>
                    <td>2019.01.01</td>
                    <td>즐거웠던 바르셀로나</td>
                    <td>메시</td>
                </tr>
                <tr>
                    <td>2019.01.01</td>
                    <td>즐거웠던 바르셀로나</td>
                    <td>메시</td>
                </tr>
                <tr>
                    <td>2019.01.01</td>
                    <td>즐거웠던 바르셀로나</td>
                    <td>메시</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<!-- 여행후기 list -->



