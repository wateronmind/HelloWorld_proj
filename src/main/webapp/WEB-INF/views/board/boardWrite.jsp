<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="container">
	<div class="row">
		<h1>글쓰기</h1>
		<form:form commandName="command" action="write.do" 
			enctype="multipart/form-data" 
			id="register_form">
			<form:hidden path="id" />
			<form:errors element="div" cssClass="error-color" />
			<ul>
				<li>
					<label for="title">제목</label>
					<form:input path="title"/>
					<form:errors path="title" cssClass="error-color" />
				</li>
				<li>
					<label for="content">내용</label>
					<form:textarea path="content"/>
					<form:errors path="content" cssClass="error-color" />
				</li>
				<li>
					<label for="upload">파일업로드</label>
					<input type="file" name="upload" id="upload" />
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="전송">
				<input type="button" value="목록" 
					onclick="location.href='list.do'">
			</div>
		</form:form>
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->