var keywords = '';

function toPage(page) {
    page = page == null ? 1 : page;
    var condition = $('#select').val();
    var url;
    if (keywords == '') {
        url = '/manage/orderlist?pageNum=' + page + '&condition=' + condition;
    } else {
        url = '/manage/orderlist?pageNum=' + page + '&keywords=' + keywords + '&condition=' + condition;
    }
    $.ajax({
        url: url,
        type: 'get',
        success: function (res) {
            $('#placeholder').html(res);
        }
    });
}

function del(id) {
    $.ajax({
        url: '/manage/order/delete',
        data: {
            id: id
        },
        type: 'GET',
        success: function (res) {
            alert(res ? 'success' : 'false')
        }
    });
}

function cstatus(id) {
    $.ajax({
        url: '/manage/order/cstatus',
        data: {
            id: id
        },
        type: 'GET',
        success: function (res) {
            alert(res ? 'success' : 'false')
        }
    });
}

$('#search').click(function () {
    keywords = $('#keywords').val();
    toPage(1);
});