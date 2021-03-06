<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
input[type="text"],textarea{
	background-color:#FFFFFF;
	border:1px solid gray;
}
input[type="file"]{
	color:#000000;
	background-color:#FFFFFF;
	border:none;
}
label,h2{
	color:#000000 !important;
}
h2{
	margin-top:50px;
	margin-bottom:50px;
}
</style>
</div>
<!-- 중앙 컨텐츠 시작 -->
<div class="tour_infoWrite write-form w_600">
	<!-- 컨텐츠 시작 -->
	<div class="container">
		<div class="row">
			<h2>여행후기 수정</h2>
		<form:form commandName="command" action="update.do" 
			enctype="multipart/form-data" accept="image/*"
			id="register_form" cssClass="form-horizontal">
			<form:hidden path="user_id" />
			<form:hidden path="tr_idx" />
					<form:errors element="div" cssClass="error-color" />
					<div class="form-group">
					    <label for="tr_title" class="col-md-2" id="tr_title">제목</label> 
				        <div class="col-lg-6">
				    		<form:input path="tr_title" cssClass="form-control"/>
							<form:errors path="tr_title" cssClass="error-color" />
					    </div>
					 </div>	
					<div class="form-group">
					     <label for="tr_content" class="col-md-2">내용</label>
					     <div class="col-lg-6">
				               <form:textarea path="tr_content"/>
				               <form:errors path="tr_content" cssClass="error-color"/>
				        </div>
		            </div>
		             <div class="form-group">		
							<label for="tr_upload" class="col-md-2">파일업로드 </label> 
							<div class="col-lg-6">
					          <input id="tr_upload" name="tr_upload" type="file" class="form-control" style="height:50px;"/>
							<c:if test="${!empty command.tr_img}">
							<br>
							<span style="color:#000;">파일이 등록되어 있습니다. 
							다시 업로드하면 기존 파일은 삭제됩니다.</span>
							</c:if>
							</div>
		            </div>	
					 <div class="form-group">
					     <div class="btn-submit">
						   <input type="submit" value="전송" class="btn btn-ok" id="tour_register">
						   <input type="button" value="목록" class="btn btn-ok" onclick="location.href='list.do'"> 
					     </div>
					</div>
			</form:form>
		</div>
	</div>
</div>
<script type="text/javascript">
$('.price').mask('000,000,000,000,000', {reverse: true});
</script>
<!-- 중앙 컨텐츠 끝 -->

