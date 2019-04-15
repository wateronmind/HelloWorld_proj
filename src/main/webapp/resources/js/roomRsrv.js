$(function(){
	$('.next_1').on('click', function() {
		$('#move_2').click();
	});
	
	$('.before_2').on('click', function() {
		$('#move_1').click();
	});
	
	$('#rsrv_form').on('submit', function() {
		
		var cp_ym = $('#cp_year_month');
		
		if($('#srl_nm').val() == ''){
			alert('예약자명을 입력해주세요.');
			return false;
		}
		
		if($('#srl_email').val() == ''){
			alert('예약자 이메일을 입력해주세요.');
			return false;
		}
		
		if($('#srl_phone').val() == ''){
			alert('예약자 연락처를 입력해주세요.');
			return false;
		}
		
		if($('#cp_num').val() == ''){
			alert('카드 번호를 입력해주세요.');
			return false;
		}
		
		if($('#cp_pin_num').val() == ''){
			alert('카드 핀 넘버를 입력해주세요.');
			return false;
		}
		
		if(cp_ym.val() == ''){
			alert('카드 연월(MM/YY)을 입력해주세요.');
			return false;
		}
		
		if(cp_ym.val().length != 5 || cp_ym.val().substr(2,1) != '/'){
			alert('카드 연월을 MM/YY 형태로 입력해주세요.');
			return false;
		}
	});
});