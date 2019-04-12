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
	$('#passwd').keyup(function(){
		if ($('#confirm_passwd').val()!='' && $('#confirm_passwd').val()!=$(this).val()) {
			$('#message_id').text('비밀번호 불일치').css('color','red');
		}else if($('#confirm_passwd').val()!=''&& $('#confirm_passwd').val()==$(this).val()){
			$('#message_id').text('비밀번호 일치').css('color','#000');
		}
	});
	$('#passwd').keyup(function(){
		if ($('#passwd').val()!='' && $('#passwd').val()!=$(this).val()) {
			$('#message_id').text('비밀번호 불일치').css('color','red');
		}else if($('#passwd').val()!=''&& $('#passwd').val()==$(this).val()){
			$('#message_id').text('비밀번호 일치').css('color','#000');
		}
	});
	
	$('#change_form').submit(function(){
		if ($('#old_passwd').val()=='') {
			alert('현재 비밀번호를 입력하세요');
			$('#old_passwd').focus();
			return false;
		}
		if ($('#passwd').val()=='') {
			alert('새 비밀번호를 입력하세요');
			$('#passwd').focus();
			return false;
		}
		if ($('#passwd').val()!=$('#confirm_passwd').val()) {
			$('#message_id').html('<b>비밀번호 불일치</b>').css('color','red');
			return false;
		}
	});
});