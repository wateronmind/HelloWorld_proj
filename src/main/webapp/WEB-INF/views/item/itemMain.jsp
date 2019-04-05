<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="about-section text-center ptb-80">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="section-title mb-50">
					<h2>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
							class="fas fa-suitcase-rolling"></i>&nbsp;&nbsp;&nbsp;<span>여행물품
							대여</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</h2>
					<br>
					<br>
					<br>
					<h6 style="color: white;">
						<span>여행시 필요한 물품들 사고 한번밖에 쓰지 않는다면?</span><br><br> <span>이젠
							사지말고 대여하세요, Hello World에는 여행에 필요한 모든 물품들이 다양하게 준비되어 있습니다.</span>
					</h6>
				</div>
			</div>
			<!-- 메인 이미지슬라이드 시작 -->
			<ul class="package-carousel">
				<li class="item">
					<div class="about-chondo">
						<img
							src="${pageContext.request.contextPath}/resources/images/item/itemmain1.jpg"
							alt="1번 패키지">
					</div>
				</li>
				<li class="item">
					<div class="about-chondo">
						<img
							src="${pageContext.request.contextPath}/resources/images/item/itemmain2.jpg"
							alt="2번 패키지">
					</div>
				</li>
				<li class="item">
					<div class="about-chondo">
						<img
							src="${pageContext.request.contextPath}/resources/images/item/itemmain3.jpg"
							alt="3번 패키지">
					</div>
				</li>
			</ul>
			<!-- 메인 이미지슬라이드 끝 -->
			<br><br>
			
			<div class="section-title mb-50">
					<h2>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
							class="fas fa-suitcase-rolling"></i>&nbsp;&nbsp;&nbsp;<span>MD 추천 상품</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</h2>
			</div>
			
			<!-- 추천상품 시작 -->
			<div class="carousel-list owl-carousel owl-theme" style="opacity: 1; display: block;">
                    <div class="owl-item" style="width: 390px;">
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="/HelloWorld_proj/resources/images/item/camera1.jpg" alt="">
                                <div class="staff-title">
                                    <span class="fas fa-plus"></span>
                                    <h2>카메라</h2>
                                    <h5>[Nikon]D5300</h5>
                                </div>
                                <div class="staff-hover-desc">
                                    <p>여행의 추억을 남기세요, 가까운 공항에서 픽업 가능합니다. <br>사지말고 대여하세요</p>
                                    <div>
                                        <a href="location.href='itemDetail.do?i_num=${i_num=92}'"><button type="button" class="btn btn-warning">상세보기</button></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                     <div class="owl-item" style="width: 390px;">
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="/HelloWorld_proj/resources/images/item/m1.png" alt="">
                                <div class="staff-title">
                                    <span class="fas fa-plus"></span>
                                    <h2>등산용품</h2>
                                    <h5>등산용품세트</h5>
                                </div>
                                <div class="staff-hover-desc">
                                    <p>준비안된 초보 등산객들 위한 등산세트, 가까운 공항에서 픽업 가능합니다. <br>사지말고 대여하세요</p>
                                    <div>
                                        <a href=""><button type="button" class="btn btn-warning">상세보기</button></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                     <div class="owl-item" style="width: 390px;">
                    <div class="col-md-4">
                        <div class="single-staff">
                            <div class="sraff-inner">
                                <img src="/HelloWorld_proj/resources/images/item/w1.jpg" alt="">
                                <div class="staff-title">
                                    <span class="fas fa-plus"></span>
                                    <h2>물놀이용품</h2>
                                    <h5>스노쿨링세트</h5>
                                </div>
                                <div class="staff-hover-desc">
                                    <p>즐거운 물놀이의 필수품, 가까운 공항에서 픽업 가능합니다. <br>사지말고 대여하세요</p>
                                    <div>
                                        <a href=""><button type="button" class="btn btn-warning">상세보기</button></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                  
                    
                <div class="owl-controls clickable"><div class="owl-pagination"><div class="owl-page active"><span class=""></span></div><div class="owl-page"><span class=""></span></div></div></div></div>
			<!-- 추천상품 끝 -->
		</div>
	</div>
</div>

<!--About Section end-->
