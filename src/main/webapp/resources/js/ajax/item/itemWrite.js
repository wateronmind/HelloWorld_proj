/**
 * 여행물품 등록 ajax
 */
;(function($){
	var $itForm = $('#itemForm');
	
	$itForm.submit(function(e){
		
		var formData = new FormData($(this)[0]);
		console.log(formData);
		e.preventDefault();
		
		$.ajax({
			url: 'itemWrite.do',
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
				if(data.result=='success'){
					alert('정상적으로 등록이 완료되었습니다.');
					location.href="admin_itemList.do";
				}else{
					alert('등록시 오류 발생');
				}
			},
			error: function(){
				console.log('상품 등록 중 네트워크 오류 발생');
			}
		})
	})
	
	$('#upload').on('change', function(e){
		var fileSrc = URL.createObjectURL(e.target.files[0]);
		$('.thumb-box').show();
		$('.thumb-img').attr('src', fileSrc);
	})
})(jQuery);