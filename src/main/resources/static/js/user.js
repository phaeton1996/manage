function toPage(page) {
    page = page==null?1:page;
    var url = '/manage/userlist?pageNum='+page;
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