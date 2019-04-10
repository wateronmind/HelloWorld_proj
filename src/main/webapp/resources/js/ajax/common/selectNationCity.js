/*
 * 나라 도시 코드 조회
 */
;(function($){
	
	$.ajax({
		type : 'post',
		url : '../common/ncList.do',
		dataType : 'json',
		cache : false,
		success : function(data){
			var nc_map = data.ncList;
			var output = '';
			
			$(nc_map).each(function(index, item){
				output += '<option value="' + item.nc_cd + '">' + item.nc_city + ' / ' + item.nc_nation + '</option>';
			});
			
			$('#hotel_nc').append(output);
		},
		error : function(){
			alert('도시 목록 호출시 네트워크 오류');
		}
	});
	
	
})(jQuery);