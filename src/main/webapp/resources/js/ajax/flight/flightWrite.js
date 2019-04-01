/**
 * 항공권 등록 ajax
 */
;(function($){
	var $flForm = $('#flightForm');
	var data = $flForm.serialize();
	
	$flForm.submit(function(e){
		e.preventDefault();
		
		$.ajax({
			url: 'flightWrite.do',
			type: 'post',
			data: data,
			dataType: 'json',
			cache: false,
			timeout: 30000,
			contentType: false,
			enctype: 'multipart/form-data',
			processData: false,
			success: function(data){
				console.log(data);
			},
			error: function(){
				console.log('항공권 등록 중 네트워크 오류 발생');
			}
		})
	})
	
	$('#fi_logo').on('change', function(e){
		var fileSrc = URL.createObjectURL(e.target.files[0]);
		$('.thumb-box').show();
		$('.thumb-img').attr('src', fileSrc);
	})
})(jQuery);