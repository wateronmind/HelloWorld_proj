$(document).ready(function(){
	//검색 유효성 체크(관리자)
	$('#search_form').submit(function(){
		if ($('#keyword').val()=='') {
			alert('검색어를 입력하세요.');
			$('#keyword').focus();
			return false;
		}
	});
	
	//비밀번호 변경 체크
	$('#user_pw').keyup(function(){
		if ($('#confirm_pw').val()!='' && $('#confirm_pw').val()!=$(this).val()) {
			$('#message_id').text('비밀번호 불일치').css('color','red');
		}else if($('#confirm_pw').val()!=''&& $('#confirm_pw').val()==$(this).val()){
			$('#message_id').text('비밀번호 일치').css('color','#fff');
		}else if($('#old_pw').val()==$('#user_pw').val()){
			$('#message_id_2').text('새로운 비밀번호를 입력하세요').css('color','#fff');
		}else if($('#old_pw').val()!=$('#user_pw').val()){
			$('#message_id_2').text('');
		}
	});
	$('#confirm_pw').keyup(function(){
		if ($('#confirm_pw').val()!='' && $('#confirm_pw').val()!=$(this).val()) {
			$('#message_id').text('비밀번호 불일치').css('color','red');
		}else if($('#confirm_pw').val()!=''&& $('#confirm_pw').val()==$(this).val()){
			$('#message_id').text('비밀번호 일치').css('color','#fff');
		}
	});
	
	$('#change_form').submit(function(){
		if ($('#old_pw').val()=='') {
			alert('현재 비밀번호를 입력하세요');
			$('#old_pw').focus();
			return false;
		}
		if ($('#user_pw').val()=='') {
			alert('새 비밀번호를 입력하세요');
			$('#user_pw').focus();
			return false;
		}
		if ($('#user_pw').val()!=$('#confirm_pw').val()) {
			$('#message_id').html('<b>비밀번호 불일치</b>').css('color','red');
			return false;
		}
		if ($('#user_pw').val()==$('#old_pw').val()) {
			$('#message_id').html('<b>기존과 다른 비밀번호를 입력하세요</b>').css('color','red');
			return false;
		}
	});
});