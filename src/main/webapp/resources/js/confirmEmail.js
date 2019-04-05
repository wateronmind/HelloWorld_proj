
$(document).ready(function(){
	var checkId=0;
	//아이디 중복 체크
	$('#confirmEmail').click(function(){
		if ($('#user_email').val()=='') {
			$('#message_email').css('color','red').text('이메일을 입력하세요');
			//click 함수만 빠져나가야 하기 때문에 return만 한다.
			return;
		}
		//메세지 초기화
		$('#message_email').text('');
		$.ajax({
			url:'confirmEmail.do',
			type:'post',
			data:{user_email:$('#user_email').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if (data.result=='emailNotFound') {
					$('#message_email').css('color','white').text('등록가능 Email');
					checkId=1;
				}else if(data.result=='emailDuplicated'){
					$('#message_email').css('color','red').text('Email 중복');
					checkId=0;
				}else{
					alert('Email 중복 체크 오류');
				}
			},
			error:function(){
				alert('Email 중복 확인 중 네트워크 오류 발생');
			}
		});
	});
	//아이디 중복 안내 메세지 초기화 및 아이디 중복값 초기화
	$('#register_form #user_email').keydown(function(){
		checkId=0;
		$('#message_email').text('');
	});
	//submit 이벤트 발생시 아이디 중복 체크 여부 확인
	$('#register_form').submit(function(){
		if (checkId==0) {
			$('#message_email').css('color','red').text('Email 중복체크 필수');
			if ($('#user_email').val()=='') {
				$('#user_email').focus();
			}
			return false;
		}
	});
});
