/*
 * 나라 도시 코드 조회
 */
;(function($){
	
	var nc_map
	
	$.ajax({
		type : 'post',
		url : '../common/ncList.do',
		dataType : 'json',
		cache : false,
		success : function(data){
			nc_map = data.ncList;
			/*alert(item.nc_cd + item.nc_nation + item.nc_city);*/
		},
		error : function(){
			alert('도시 목록 호출시 네트워크 오류');
		}
	});
	
	
})(jQuery);