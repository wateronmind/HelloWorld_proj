
$(document).ready(function(){
	var checkId=0;
	//아이디 중복 체크
	$('#confirmId').click(function(){
		if ($('#user_id').val()=='') {
			$('#message_id').css('color','red').text('아이디를 입력하세요');
			//click 함수만 빠져나가야 하기 때문에 return만 한다.
			return;
		}
		//메세지 초기화
		$('#message_id').text('');
		$.ajax({
			url:'confirmId.do',
			type:'post',
			data:{user_id:$('#user_id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if (data.result=='idNotFound') {
					$('#message_id').css('color','white').text('등록가능 ID');
					checkId=1;
				}else if(data.result=='idDuplicated'){
					$('#message_id').css('color','red').text('ID 중복');
					checkId=0;
				}else{
					alert('ID 중복 체크 오류');
				}
			},
			error:function(){
				alert('아이디 중복 확인 중 네트워크 오류 발생');
			}
		});
	});
	//아이디 중복 안내 메세지 초기화 및 아이디 중복값 초기화
	$('#register_form #user_id').keydown(function(){
		checkId=0;
		$('#message_id').text('');
	});
	//submit 이벤트 발생시 아이디 중복 체크 여부 확인
	$('#register_form').submit(function(){
		if (checkId==0) {
			$('#message_id').css('color','red').text('ID 중복체크 필수');
			if ($('#user_id').val()=='') {
				$('#user_id').focus();
			}
			return false;
		}
	});
});
