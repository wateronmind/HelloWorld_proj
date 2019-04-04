/**
 * 여행물품 수정 ajax
 */
;(function($){
	$('#upload').on('change', function(e){
		var fileSrc = URL.createObjectURL(e.target.files[0]);
		$('.thumb-box').show();
		$('.thumb-img').attr('src', fileSrc);
	})
})(jQuery);