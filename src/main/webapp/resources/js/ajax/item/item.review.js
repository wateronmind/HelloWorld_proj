$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	//댓글 목록
	function selectData(pageNum,num){
		currentPage = pageNum;
		
		if(pageNum == 1){
			//처음 호출시는 해당 ID의 div의 내부 내용물을 제거
			$('#output').empty();
		}
		
		//로딩 이미지 노출
		$('#loading').show();
		
		$.ajax({
			type:'post',
			data:{pageNum:pageNum,num:num},
			url:'listReview.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//로딩 이미지 감추기
				$('#loading').hide();
				count = data.count;//페이징 처리하기위해 보관
				rowcount = data.rowCount;//페이징 처리하기위해 보관
				
				var list = data.list;
				
				if(count < 0 || list == null){
					alert('목록 호출 오류 발생!');
				}else{
					$(list).each(function(index,item){
						var output = '<div class="item">';
							output += '  <h4>' + item.id + '</h4>';
							output += '  <div class="sub-item">';
							output += '   <p>' + item.re_content.replace(/\r\n/g,'<br>') + '</p>';
							output += item.re_date;
							if($('#user_id').val()==item.id){//작성자 id와 동일할 경우 보여짐
								output += '  <input type="button" data-num="'+item.re_num+'" data-id="'+item.id+'" value="삭제" class="delete-btn">';
							}
							output += '  <hr size="1" nashade>';
							output += ' </div>';
							output += '</div>';
							
							//문서 객체에 추가
							$('#output').append(output);
					});
					
					//paging button 처리
					if(currentPage>=Math.ceil(count/rowCount)){
						//다음 페이지가 없음
						$('.paging-button').hide();
					}else{
						//다음 페이지가 존재
						$('.paging-button').show();
					}
					
				}
				
			},
			error:function(){
				//로딩 이미지 감추기
				$('#loading').hide();
				alert('댓글 목록 호출시 네트워크 오류');
			}
		});
	}
	
	//다음 댓글 보기 버튼 클릭시 데이터 추가(페이징 처리)
	$('.paging-button input').click(function(){
		var pageNum = currentPage + 1;
		selectData(pageNum,$('#num').val());
	});
	
	/*//후기 등록
	$('#re_form').submit(function(event){
		if($('#ir_content').val()==''){
			alert('내용을 입력하세요');
			$('#ir_content').focus();
			return false;
		}
		
		var data = $(this).serialize();
		
		//등록
		$.ajax({
			type:'post',
			data:data,
			url:'itemReviewWrite.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(data.result == 'success'){
					//폼초기화
					initForm();
					//댓글 작성이 성공하면 새로 삽입한 글을
					//포함해서 첫번째 페이지의 게시글을 다시 호출함
					selectData(1,$('#ir_num').val());
				}else{
					alert('등록시 오류 발생');
				}
			},
			error:function(){
				alert('댓글 등록시 네트워크 오류');	
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#re_first .letter-count').text('300/300');
	}
	
	//textarea 내용 입력시 글자수 체크
	$(document).on('keyup','textarea',function(){
		//남은 글자수를 구함
		var inputLength = $(this).val().length;
		
		if(inputLength>300){//300자를 넘어선 경우
			$(this).val($(this).val().substring(0,300)); //300자를 넘어서면 잘라버림
		}else{//300자 이하인 경우(정상)
			var remain = 300 - inputLength;
			remain += '/300';
			if($(this).attr('id')=='ir_content'){
				//등록폼 글자수
				$('#re_first .letter-count').text(remain);
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').text(remain);
			}
		}
	});
	*/
	//댓글 삭제
	$(document).on('click','.delete-btn',function(){
		//댓글 번호
		var re_num = $(this).attr('data-num');
		//작성자 아이디
		var id = $(this).attr('data-id');
		
		$.ajax({
			type:'post',
			data:{re_num:re_num,id:id},
			url:'deleteReply.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 삭제할 수 있습니다.');
				}else if(data.result == 'success'){
					alert('삭제 완료!');
					//새로 목록 호출
					selectData(1,$('#ir_num').val());
				}else if(data.result == 'wrongAccess'){
					alert('타인의 글을 삭제할 수 없습니다.');
				}else{
					alert('댓글 삭제시 오류 발생');
				}
			},
			error:function(){
				alert('댓글 삭제시 네트워크 오류');
			}
		});
	});
	
	//초기 데이터(목록) 호출
	selectData(1,$('#ir_num').val());
	
});