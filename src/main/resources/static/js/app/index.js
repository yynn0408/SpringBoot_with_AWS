var main = {//index.js의 scope 임. 이후 다른 파일에서 동일 명칭의 함수를 추가해도 스코프가 달라 괜춘.
    init : function (){
        var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        });
    },
    save : function(){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        $.ajax({
            type:'POST',
            url: '/api/v1/posts',
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        }
        )
    }
};
main.init();