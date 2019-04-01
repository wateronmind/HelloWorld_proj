<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 항공권 등록 폼 시작 -->
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">항공권 등록</h2>
		<!-- form 시작 -->
		<form id="flightForm">
			<div class="row">
				<ul class="col-xs-12">
					<li>
						<label for="f_company">항공사 입력</label>
						<input type="text" id="f_company" required="required" placeholder="항공사를 입력 하세요">
					</li>
					<li>
						<div>
							<label for="f_thumb">파일 선택</label>
							<input type="file" id="f_thumb">
						</div>
						<div>
							<img alt src="">
						</div>
					</li>
					<li>
						<label for="depart_pl">출발지</label>
						<input type="text" id="depart_pl" required="required" placeholder="출발지를 입력해 주세요">
					</li>
					<li>
						<label for="arrive_pl">도착지</label>
						<input type="text" id="arrive_pl" required="required" placeholder="도착지를 입력해 주세요">
					</li>
					<li>
						<label for="trans1_pl">경유지1</label>
						<input type="text" id="trans1_pl" placeholder="경유지1을 입력해 주세요">
					</li>
					<li>
						<label for="trans2_pl">경유지2</label>
						<input type="text" id="trans2_pl" placeholder="경유지2를 입력해 주세요">
					</li>
					<li>
						<label for="depart_time">출발 시간</label>
						<input type="text" id="depart_time" required="required" placeholder="출발 시간을 입력해 주세요">
					</li>
					<li>
						<label for="depart_time">도착 시간</label>
						<input type="text" id="depart_time" required="required" placeholder="도착 예정 시간을 입력해 주세요">
					</li>
					<li>
						<label for="depart_time">경유지1 출발 시간</label>
						<input type="text" id="depart_time" placeholder="경유지1 출발 시간을 입력해 주세요">
					</li>
					<li>
						<label for="depart_time">경유지2 출발 시간</label>
						<input type="text" id="depart_time" placeholder="경유지2 출발 시간을 입력해 주세요">
					</li>
				</ul>
				<section class="col-xs-12">
					<h4>전체 탑승객 인원 및 초기 가격을 설정해 주세요.</h4>
					<div class="divn_3">
						<h5>First Class</h5>
						<ul>
							<li>
								<p>인원</p>
								<select required="required">
									<c:forEach var="i" begin="1" end="20">
									<option value="i">${i}명</option>
									</c:forEach>
								</select>
							</li>
							<li>
								<p>가격</p>
								<input type="text" class="price" required="required" value="3000000">
							</li>
							<li>
								<p>마일리지</p>
								<input type="text" class="price" required="required" value="30000">
							</li>
						</ul>
					</div>
					
					<div class="divn_3">
						<h5>Business</h5>
						<ul>
							<li>
								<p>인원</p>
								<select>
									<c:forEach var="i" begin="1" end="100">
									<option value="i">${i}명</option>
									</c:forEach>
								</select>
							</li>
							<li>
								<p>가격</p>
								<input type="text" class="price" required="required" value="1000000">
							</li>
							<li>
								<p>마일리지</p>
								<input type="text" class="price" required="required" value="10000">
							</li>
						</ul>
					</div>
					
					<div class="divn_3">
						<h5>Economy</h5>
						<ul>
							<li>
								<p>인원</p>
								<select>
									<c:forEach var="i" begin="1" end="100">
									<option value="i">${i}명</option>
									</c:forEach>
								</select>
							</li>
							<li>
								<p>가격</p>
								<input type="text" class="price" required="required" value="100000">
							</li>
							<li>
								<p>마일리지</p>
								<input type="text" class="price" required="required" value="1000">
							</li>
						</ul>
					</div>
				</section>
				    
				<!-- btn-submit 시작 -->
				<div class="btn-submit col-xs-12">
					<input type="button" value="뒤로" class="btn btn-default">
					<input type="submit" value="전송" class="btn btn-ok">
				</div>
				<!-- btn-submit 끝 -->
			</div>
		</form>
		<!-- form 끝 -->
	</div>
</div>
<!-- 항공권 등록 폼 끝 -->


<script>
$('.price').mask('000,000,000,000,000', {reverse: true});
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/flight/flightWrite.js"></script>




