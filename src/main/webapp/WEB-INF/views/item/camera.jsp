<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.category-right{
	text-align:right;
	color: white;
	font-size: 11pt;
}

</style>
<div class="welcome-section text-center ptb-110">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title mb-50">
                            <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fas fa-camera"></i>&nbsp;&nbsp;&nbsp;<span>카메라</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2>
                        </div>
                    </div>
                </div>
            </div>
           
            <!--Room elements start-->
            <div class="our-room-show room-section">
                <div class="container">
                    <div class="row">
                       <div class="category-right">
                      <a href="#">
               			 낮은가격순
            		</a>
           			 <a href="#">
                		높은가격순
           			 </a>
                       </div>
                        <div class="our-room-list owl-pagination owl-carousel owl-theme" style="opacity: 1; display: block;">
                            <div class="owl-wrapper-outer">
                            <div class="owl-wrapper" style="width: 7020px; left: 0px; display: block;">
                            <div class="owl-item" style="width: 1170px;">
                            <div class="single-room-sapce">
                            <c:forEach var="list" items="${list}">
                                   <div class="col-md-4 col-sm-6 col-xs-12 col-sm-6 col-xs-12">
                                    <c:if test="${list.ict_num==1}">
                                    
                                    <div class="single-room mb-80">
                                        <div class="room-img">
                                            <a href="#"><img src="imageView.do?i_num=${list.i_num}" width="500px" height="300px"></a>
                                        </div>
                                        <div class="room-desc">
                                            <div class="room-name">
                                                <h3><a href="#">${list.i_nm}</a></h3>
                                            </div>
                                            <div class="room-rent">
                                                <h5>${list.i_pc}<span>원</span></h5>
                                            </div>
                                            <div class="room-book">
                                                <a href="itemDetail.do?i_num=${list.i_num}">구매하기</a>
                                            </div>
                                        </div>
                                    </div>
                                 </c:if>
                                </div> 
                                 </c:forEach>
                            </div>
                            </div>
                            </div>
                            </div>
                            
                            
                        <div class="owl-controls clickable"><div class="owl-pagination"><div class="owl-page active"><span class=""></span></div><div class="owl-page"><span class=""></span></div><div class="owl-page"><span class=""></span></div></div></div>
                        </div>
                    
                    </div>
                </div>
            </div>
            
            <!--Room elements end-->
            </div>	