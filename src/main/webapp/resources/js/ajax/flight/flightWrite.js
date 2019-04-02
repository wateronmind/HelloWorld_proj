/**
 * 항공권 등록 ajax
 */
;(function($){
	var $flForm = $('#flightForm');
	
	$flForm.submit(function(e){
		
		var formData = new FormData($(this)[0]);
		console.log(formData);
		e.preventDefault();
		
		$.ajax({
			url: 'flightWrite.do',
			type: 'post',
			data: formData,
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
	
	$('#upload_fi_logo').on('change', function(e){
		var fileSrc = URL.createObjectURL(e.target.files[0]);
		$('.thumb-box').show();
		$('.thumb-img').attr('src', fileSrc);
	})
})(jQuery);