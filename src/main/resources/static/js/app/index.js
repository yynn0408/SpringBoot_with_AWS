var main = {//index.js의 scope 임. 이후 다른 파일에서 동일 명칭의 함수를 추가해도 스코프가 달라 괜춘.
    init : function (){
        var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        });
        $('#btn-update').on('click',function(){
            _this.update();
        })
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
    update : function(){
        var data ={
            title :$('#title').val()
            content:$('#content').val()
        }
        var id =$('#id').val();
        $.ajax({
            type:'PUT'
            url: '/api/v1/posts/'+id,
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.')
            window.location.href='/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        })
    }
};
main.init();