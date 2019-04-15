$(function(){
	
	var sr_adult_pc = $('#sr_adult_pc').val();
	var sr_kid_pc = $('#sr_kid_pc').val();
	var sr_submit = false;
	
	$('#mdi_more').on('click', function() {
		$('.mdi-ul').css("display", "");
		$('#mdi_more').css("display", "none");
	});

	$('.hotel-srch', $('.booking-box')).show();
	
	function total_pc_str() {
		var total_pc;
		var adult = $('#srl_adult_pp').val();
		var kid = $('#srl_kid_pp').val();
		var totalPp = parseInt(adult) + parseInt(kid);
		var maxPp = $('#sr_max_pp').val();
		sr_submit = false;
		
		if(maxPp < totalPp){
			$('#total_pc_str').val('최대 인원(' + maxPp + '명)보다 많습니다.');
			return false;
		}
		
		var start_arr = $('#srl_check_in_dt').val().split('-');
		var end_arr = $('#srl_check_out_dt').val().split('-');
		var start = new Date(start_arr[0], start_arr[1], start_arr[2]);
		var end = new Date(end_arr[0], end_arr[1], end_arr[2]);
		var diff = end - start;
		var currDay = 24 * 60 * 60 * 1000;
		var check_day = parseInt(diff/currDay);
		
		if(start_arr == '' || end_arr == '' || totalPp == 0){
			return false;
		}
		
		if(check_day < 1){
			$('#total_pc_str').val('제대로 된 날짜를 선택해 주세요.');
		} else {
			total_pc = (adult * sr_adult_pc + kid * sr_kid_pc) * check_day;
			$('#total_pc_str').val(total_pc + ' 원');
			$('#srl_total_pc').val(total_pc);
			sr_submit = true;
		}
	}
	
	$('.cal').on('change', function(){
		$('#total_pc_str').val('0 원');
		$('#srl_total_pc').val(0);
		total_pc_str();
	});
	
	$('#hotel_reg_form').on('submit', function(){
		if(!sr_submit) {
			alert('예약 정보를 다시 입력해주세요.');
			return false;
		}
	});
});
