/**
 * 항공사 검색
 */
$('#fCompany').on('keyup', function(){
	// searchCompany($(this).val());
});

function searchCompany(text) {
	var $loading = $('#loading');
	$loading.show();
	$.ajax({
		url: 'searchCompany.do',
		data: text,
		type: 'post',
		dataType: 'json',
		cache: false,
		timeout: 30000,
		success: function(data){
			$loading.hide();
			console.log(data);
		},
		error: function(){
			$loading.hide();
			console.log('항공사 검색 중 네트워크 오류 발생');
		}
	})
}