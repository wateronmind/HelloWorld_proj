
$(document).ready(function(){
	//email 제출 되었을 때
	$('#findPasswordForm').submit(function(event){
		//입력 안했을 때 
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
		
		//이메일 입력 한 경우
		$.ajax({
			type:'post',
			data:data,
			url:'findId.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){

				$.each(data,function(){
					//해당 이메일로 회원정보가 없는 경우
					if (data.result=='emailNull') {
						alert('가입된 회원이 아닙니다');
					//이메일로 회원 정보를 가져오는 경우
					}else if(data.result=='emailNotNull'){
						
						var output ='<div class="item">';
						output +='<h4>'+this["user_id"]+'</h4>';
						output+='</div>';
					
					//문서 객체에 추가
					$('#output').append(output);
					}else{
						alert('Email 체크 오류');
					}
				});
			},
			error:function(){
				alert('Email 확인 중 네트워크 오류 발생');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
});
