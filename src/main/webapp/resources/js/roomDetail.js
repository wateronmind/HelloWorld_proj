$(function(){
	$('#mdi_more').on('click', function() {
		$('.mdi').css("display", "");
		$('#mdi_more').css("display", "none");
	});

	$('.hotel-srch', $('.booking-box')).show();
});