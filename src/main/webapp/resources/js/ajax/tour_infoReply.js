$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	
	//댓글 목록
	function selectData(pageNum,ti_id){
		currentPage = pageNum;
		
		if(pageNum == 1){
			//처음 호출시는 해당 ID의 div의 내부 내용물을 제거
			$('#output').empty();
		}
		//로딩 이미지 노출
		$('#loading').show();
		$.ajax({
		 type:'post',
		 data:{pageNum:pageNum,ti_id:ti_id},
		 url:'listReply.do',
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
							output += '  <h4>' + item.user_id + '</h4>';
							output += '  <div class="sub-item">';
							output += '   <p>' + item.tr_content.replace(/\r\n/g,'<br>') + '</p>';
							output += item.tr_date;
							if($('#user_id').val()==item.user_id){//작성자 id와 동일할 경우 보임
								output += '  <input type="button" data-num="'+item.tr_idx+'" data-id="'+item.user_id+'" value="수정" class="modify-btn">';
								output += '  <input type="button" data-num="'+item.tr_idx+'" data-id="'+item.user_id+'" value="삭제" class="delete-btn">';
							}
							output += '  <hr size="1" noshade>';
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
		selectData(pageNum,$('#ti_id').val());
	});
	//댓글 등록
	$('#re_form').submit(function(event){
		if($('#tr_content').val()==''){
			alert('내용을 입력하세요');
			$('#tr_content').focus();
			return false;
		}
		
		var data = $(this).serialize();
		//등록
		$.ajax({
			type:'post',
			data:data,
			url:'writeReply.do',
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
					selectData(1,$('#ti_id').val());
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
		$('#re_first .letter-count').text('200/200');
	}
	
	//textarea 내용 입력시 글자수 체크
	$(document).on('keyup','textarea',function(){
		//남은 글자수를 구함
		var inputLength = $(this).val().length;
		
		if(inputLength>200){//300자를 넘어선 경우
			$(this).val($(this).val().substring(0,200)); //300자를 넘어서면 잘라버림
		}else{//300자 이하인 경우(정상)
			var remain = 200 - inputLength;
			remain += '/200';
			if($(this).attr('id')=='tr_content'){
				//등록폼 글자수
				$('#re_first .letter-count').text(remain);
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').text(remain);
			}
		}
	});
	
	//댓글 수정 버튼 클릭시 수정폼 노출 (미래의 태그 처리시 on사용)
	$(document).on('click','.modify-btn',function(){
		//댓글 글 번호
		var tr_idx = $(this).attr('data-num');
		//작성자 아이디
		var user_id = $(this).attr('data-id');
		//댓글 내용                                           //g:지정한 문자열 전체, i:대소문자 무시
		var content = $(this).parent().find('p').html().replace(/<br>/gi,'\n');//내용이 들어있는 p태그를 부모태그로부터 찾음
		//댓글 수정폼 UI만듬
		var modifyUI = '<form id="mre_form">'; //id는 중복이 되면 안되기때문에 앞에 m을 붙힘, 전송되는건 name이 전송
		   modifyUI += '  <input type="hidden" name="tr_idx" id="mtr_idx" value="'+tr_idx+'">';
		   modifyUI += '  <input type="hidden" name="user_id" id="muser_id" value="'+user_id+'">';
		   modifyUI += '  <textarea rows="3" cols="50" name="tr_content" id="mtr_content" class="rep-content">'+content+'</textarea>';
		   modifyUI += '  <div id="mre_first"><span class="letter-count">200/200</span></div>';
		   modifyUI += '  <div id="mre_second" class="align-right">';
		   modifyUI += '    <input type="submit" value="수정">';
		   modifyUI += '    <input type="button" value="취소" class="re-reset">';
		   modifyUI += '  </div>';
		   modifyUI += '  <hr size="1" noshade width="96%">';
		   modifyUI += '</form>';
		   
		//이전에 이미 수정하는 댓글이 있을 경우 수정버튼을 클릭하면
		//숨김 sub-item를 환원시키고 수정폼을 초기화함
		initModifyForm();
		
		//지금 클릭해서 수정하고자 하는 데이터는 감추기
		//수정버튼을 감싸고 있는 div 감춤
		$(this).parent().hide();
		
		//수정폼을 수정하고자하는 데이터가 있는 div에 노출
		$(this).parents('.item').append(modifyUI);
		
		//입력한 글자수 셋팅
		var inputLength = $('#mtr_content').val().length;
		var remain = 200 - inputLength;
		remain += '/200';
		
		//문서 객체에 반영
		$('#mre_first .letter-count').text(remain);
	});
	//수정폼에서 취소 버튼 클릭시 수정폼 초기화
	$(document).on('click','.re-reset',function(){
		initModifyForm();
	});
	//댓글 수정 폼 초기화
	function initModifyForm(){
		$('.sub-item').show();
		$('#mre_form').remove();
	}
	
	//댓글 수정
	$(document).on('submit','#mre_form',function(event){
		if($('#mtr_content').val()==''){
			alert('내용을 입력하세요');
			$('#mre_content').focus();
			return false;
		}
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
		
		//수정
		$.ajax({
			url:'updateReply.do',
			type:'post',
			data:data,//키:변수
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 수정할 수 있습니다.');
				}else if(data.result == 'success'){
					//부모로 올라가서 폼안에 p태그를 찾아서 뽑아냄
					$('#mre_form').parent().find('p').html($('#mtr_content').val().replace(/\n/g,'<br>'));
					//수정폼 초기화
					initModifyForm();
				}else if(data.result == 'wrongAccess'){
					alert('타인의 글은 수정할 수 없습니다.');
				}else{
					alert('댓글 수정시 오류 발생');
				}
			},
			error:function(){
				alert('댓글 수정시 네트워크 오류');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	
	//댓글 삭제
	$(document).on('click','.delete-btn',function(){
		//댓글 번호
		var tr_idx = $(this).attr('data-num');
		//작성자 아이디
		var user_id = $(this).attr('data-id');
		
		$.ajax({
			type:'post',
			data:{tr_idx:tr_idx,user_id:user_id},
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
					selectData(1,$('#ti_id').val());
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
	selectData(1,$('#ti_id').val());
	
});