
$(document).ready(function(){
	//아이디와 email 제출 되었을 때
	$('#findPasswordForm').submit(function(event){
		//아이디 이메일 유효성 체크
		if ($('#user_id').val()=='') {
			alert('아이디를 입력하세요');
			$('#user_id').focus();
			return false;
		}
		if ($('#user_email').val()=='') {
			alert('이메일을 입력하세요');
			$('#user_email').focus();
			return false;
		}
		
		//입력 한 경우
		$.ajax({
			type:'post',
			data:{
				user_id:$('#user_id').val(),
				user_email:$('#user_email').val()
				},
			url:'findPassword.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//해당 이메일로 회원정보가 없는 경우
				if (data.result=='wrong') {
					alert('아이디 혹은 이메일이 다릅니다');
				//회원 정보를 가져오는 경우
				}else if(data.result=='success'){
					alert('비밀번호를 이메일로 발송했습니다.');
				}else{
					alert('비밀번호 체크 오류');
				}
			},
			error:function(){
				alert('비밀번호 확인 중 네트워크 오류 발생');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
});
