$(document).ready(function(){
	
	//주문수량 변경
	$('#order_quantity').on('keyup mouseup',function(){
		if($('#order_quantity').val()==''){
			$('#item_total_txt').text('총주문 금액 : 0원');
			return;
		}
		if(isNaN($('#order_quantity').val()) || $('#order_quantity').val() <= 0){
			$('#order_quantity').val('');
			return;
		}
		/*if(Number($('#item_quantity').text()) < $('#order_quantity').val()){
			alert('수량이 부족합니다.');
			$('#order_quantity').val('');
			$('#item_total_txt').text('총주문 금액 : 0원');
			return;
		}*/
		
		//구매수량에 대한 총 주문 금액 연산
		var total = $('#item_price').val() * $('#order_quantity').val();
		$('#item_total_txt').text('총주문 금액 : ' + $.number(total) + '원');
	});
	
	/*//장바구니 상품 담기 유효성 체크
	$('#item_cart').submit(function(event){
		if($('#order_quantity').val()==''){
			alert('수량을 입력하세요');
			$('#order_quantity').focus();
			return false;
		}
	});
	//=====장바구니에서 back 버튼 클릭시 시작=====
	if($('#order_quantity').val()!=undefined){
		$('#order_quantity').val('');
	}*/
	//=====장바구니에서 back 버튼 클릭시 끝=====
});