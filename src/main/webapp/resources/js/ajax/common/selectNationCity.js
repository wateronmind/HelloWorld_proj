/*
 * 나라 도시 코드 조회
 */
;(function($){
	
	$.ajax({
		type : 'post',
		url : '../common/ncList.do',
		dataType : 'json',
		cache : false,
		timeout:30000,
		success : function(data){
			var nc_map = data.ncList;
			var hotel_nc = '';
			
			$(nc_map).each(function(index, item){
				hotel_nc += '<option value="' + item.nc_cd + '">' + item.nc_city + ' / ' + item.nc_nation + '</option>';
			});
			
			$('#hotel_nc').append(hotel_nc);
		},
		error : function(){
			alert('도시 목록 호출시 네트워크 오류');
		}
	});
	
	
})(jQuery);