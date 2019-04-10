$(document).ready(function(){
   //동행등록 유효성 체크
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
});