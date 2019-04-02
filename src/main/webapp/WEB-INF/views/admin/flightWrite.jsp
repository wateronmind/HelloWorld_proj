<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 항공권 등록 폼 시작 -->
<div class="container write-form w_600">
	<div class="row">
		<h2 class="col-xs-12">항공권 등록</h2>
		<!-- form 시작 -->
		<form:form commandName="fCommand" 
				id="flightForm" 
				action="flightWrite.do" 
				enctype="multipart/form-data">
			<div class="row">
				<ul class="col-xs-12">
					<li>
						<div>
							<label for="upload_fi_logo">파일 선택(항공사 썸네일)</label>
							<input type="file" id="upload_fi_logo" name="upload_fi_logo">
							<%-- form:input path="upload_fi_logo" type="file" />
							<form:errors element="div" path="upload_fi_logo" cssClass="error-color" /> --%>
						</div>
						<div class="thumb-box">
							<img alt src="" class="thumb-img">
						</div>
					</li>
					<li class="search-sth">   
						<label for="fi_nm">항공사 입력</label>
						<form:input path="fi_nm" placeholder="항공사를 입력 하세요" />
						<button type="button" class="btn btn-success btn-search">추가</button>
						<div class="loading">
							<img alt="로딩중" src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
						</div>
						<form:errors element="div" path="fi_nm" cssClass="error-color" />
					</li>
					<li>
						<label for="fsi_start_place">출발지</label>
						<form:input path="fsi_start_place" placeholder="출발지를 입력해 주세요" />
						<form:errors path="fsi_start_place" cssClass="error-color" />
					</li>
					<li>
						<label for="fsi_arrive_place">도착지</label>
						<form:input path="fsi_arrive_place" placeholder="도착지를 입력해 주세요" />
						<form:errors path="fsi_arrive_place" cssClass="error-color" />
					</li>
					<li>
						<label for="fsi_pass1_place">경유지1</label>
						<form:input path="fsi_pass1_place" placeholder="경유지1을 입력해 주세요" />
					</li>
					<li>
						<label for="fsi_pass2_place">경유지2</label>
						<form:input path="fsi_pass2_place" placeholder="경유지2를 입력해 주세요" />
					</li>
					<li>
						<label for="fsi_start_dt">출발 시간</label>
						<form:input path="fsi_start_dt" placeholder="출발 시간을 입력해 주세요" />
						<form:errors path="fsi_start_dt" cssClass="error-color" />
					</li>
					<li>
						<label for="fsi_arrive_dt">도착 시간</label>
						<form:input path="fsi_arrive_dt" placeholder="도착 예정 시간을 입력해 주세요" />
						<form:errors path="fsi_arrive_dt" cssClass="error-color" />
					</li>
					<li>
						<label for="fsi_pass1_dt">경유지1 출발 시간</label>
						<form:input path="fsi_pass1_dt" placeholder="경유지1 출발 시간을 입력해 주세요" />
					</li>
					<li>
						<label for="fsi_pass2_dt">경유지2 출발 시간</label>
						<form:input path="fsi_pass2_dt" placeholder="경유지2 출발 시간을 입력해 주세요" />
					</li>
				</ul>
				<section class="col-xs-12">
					<h4>전체 탑승객 인원 및 초기 가격을 설정해 주세요.</h4>
					<div class="divn_3">
						<h5>First Class</h5>
						<ul>
							<li>
								<p>인원</p>
								<form:select path="fsi_fir_seat">
									<c:forEach var="i" begin="1" end="20">
									<option value="${i}">${i}명</option>
									</c:forEach>
								</form:select>
								<form:errors path="fsi_fir_seat" cssClass="error-color" />
							</li>
							<li>
								<p>가격</p>
								<form:input path="fsi_fir_pc" class="price" value="3000000" />
								<form:errors path="fsi_fir_pc" cssClass="error-color" />
							</li>
							<li>
								<p>마일리지</p>
								<form:input path="fsi_fir_mil" class="price" value="30000" />
								<form:errors path="fsi_fir_mil" cssClass="error-color" />
							</li>
						</ul>
					</div>
					
					<div class="divn_3">
						<h5>Business</h5>
						<ul>
							<li>
								<p>인원</p>
								<form:select path="fsi_bus_seat">
									<c:forEach var="i" begin="1" end="100">
									<option value="${i}">${i}명</option>
									</c:forEach>
								</form:select>
								<form:errors path="fsi_bus_seat" cssClass="error-color" />
							</li>
							<li>
								<p>가격</p>
								<form:input path="fsi_bus_pc" class="price" value="1000000" />
								<form:errors path="fsi_bus_pc" cssClass="error-color" />
							</li>
							<li>
								<p>마일리지</p>
								<form:input path="fsi_bus_mil" class="price" value="10000" />
								<form:errors path="fsi_bus_mil" cssClass="error-color" />
							</li>
						</ul>
					</div>
					
					<div class="divn_3">
						<h5>Economy</h5>
						<ul>
							<li>
								<p>인원</p>
								<form:select path="fsi_eco_seat">
									<c:forEach var="i" begin="1" end="100">
									<option value="${i}">${i}명</option>
									</c:forEach>
								</form:select>
								<form:errors path="fsi_eco_seat" cssClass="error-color" />
							</li>
							<li>
								<p>가격</p>
								<form:input path="fsi_eco_pc" class="price" value="100000" />
								<form:errors path="fsi_eco_pc" cssClass="error-color" />
							</li>
							<li>
								<p>마일리지</p>
								<form:input path="fsi_eco_mil" class="price" value="1000" />
								<form:errors path="fsi_eco_mil" cssClass="error-color" />
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
		</form:form>
		<!-- form 끝 -->
	</div>
</div>
<!-- 항공권 등록 폼 끝 -->


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/flight/searchFlight.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax/flight/flightWrite.js"></script>




