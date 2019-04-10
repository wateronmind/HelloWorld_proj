$('#ir_content').keyup(function (e){
    var ir_content = $(this).val();
    $('#counter').html("("+ir_content.length+" / 최대 50자)");    //글자수 실시간 카운팅

    if (ir_content.length > 50){
        alert("최대 50자까지 입력 가능합니다.");
        $(this).val(ir_content.substring(0, 50));
        $('#counter').html("(50 / 최대 50자)");
    }
});
