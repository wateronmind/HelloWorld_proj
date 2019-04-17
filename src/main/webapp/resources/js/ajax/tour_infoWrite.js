$(document).ready(function(){
	$("#register_form").submit(function(){
		var ti_start_day = $('#ti_start_day').val();
		var ti_end_day = $('#ti_end_day').val();
		//-을 구분자로 연,월,일로 잘라서 배열로 반환
		var startArray = ti_start_day.split('-');
		var endArray = ti_end_day.split('-');
		//배열에 담겨있는 데이터를 이용하여 Date 객체 생성
		var ti_start_day = new Date(startArray[0], startArray[1], startArray[2]);
		var ti_end_day = new Date(startArray[0], startArray[1], startArray[2]);
		    //날짜를 숫자형태의 날짜 정보로 변환, 비교
		if(ti_start_day.getTime() > ti_end_day.getTime()){
			alert("종료날짜보다 시작날짜가 작아야 합니다.");
			return false;
		}
	});
});


/*$(document).ready(function(){
   //날짜 체크
   var form = document.getElementById('register_form');
   form.onsubmit=function(){
      
      var today = new Date();
      var start = new Date(ti_start_day.value);
      var end = new Date(ti_end_day.value);
      
      if(today>start){
         alert("오늘 이전의 날짜는 선택할 수 없습니다.");
         return false;
      }

      if(start>end){
         alert("종료일자는 시작일자보다 이전일 수 없습니다.");
         return false;
      }
   };
});*/