/**
 * 항공권 등록 ajax
 */
;(function($){
	var $flForm = $('#flightForm');
	var data = $flForm.serialize();
	
	$flForm.submit(function(e){
		e.preventDefault();
		
		$.ajax({
			url: '',
			type: 'post',
			data: data,
			dataType: 'json',
			cache: false,
			timeout: 30000,
			success: function(data){
				console.log(data);
			},
			error: function(){
				console.log('항공권 등록 중 네트워크 오류 발생');
			}
		})
	})
})(jQuery);