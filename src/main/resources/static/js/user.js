var keywords = '';

function toPage(page) {
    page = page==null?1:page;
    var url;
    if (keywords == ''){
        url = '/manage/userlist?pageNum='+page;
    }else{
        url = '/manage/userlist?pageNum='+page +'&keywords='+keywords;
    }

    $.ajax({
        url:url ,
        type:'get',
        success:function (res) {
            $('#placeholder').html(res);
        }
    });
}

function del(id) {
    $.ajax({
        url:'/manage/user/delete',
        data:{
            id:id
        },
        type:'GET',
        success:function (res) {
            alert(res?'success':'false')
        }
    });
}


$('#search').click(function () {
    keywords = $('#keywords').val();
    toPage(1);
});

function cstatus(id) {
    $.ajax({
        url:'/manage/user/cstatus',
        data:{
            id:id
        },
        type:'GET',
        success:function (res) {
            alert(res?'success':'false')
        }
    });
}