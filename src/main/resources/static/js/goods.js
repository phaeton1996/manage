    /**
     * 修改商品模态框
     */
    function modify(num) {
        // ajax获取并填充
        $.ajax({
            url:"/manage/goods/id/"+num,
            type:'GET',
            success:function (res) {
                renderModal(res);
            }
        });

        $("#GoodsModifyModal").modal({
            backdrop: "static"
        });

    }
    function renderModal(res) {
        $('#name').val(res.name);
        $('#id').val(res.id);
        $('#seckillPrice').val(res.seckillPrice);
        $('#stocks').val(res.stocks);
        $('#imgUrl').attr("src",res.imgUrl);
        $('#descr').val(res.descr);
        $('#startTimeInput').val(res.startTime);
        $('#endTimeInput').val(res.endTime);
    }
    $('#submit').click(function () {
        var form = $('#GoodsModifyModal form').serialize();
        $.ajax({
            url:'/manage/goods/modify',
            data:form,
            type:'POST',
            success:function (res) {
                alert(res?'success':'false')
            }
        });
    });

    function del(id) {
        $.ajax({
            url:'/manage/goods/delete',
            data:{
                id:id
            },
            type:'GET',
            success:function (res) {
                alert(res?'success':'false')
            }
        });
    }

    function sellout(id) {
        $.ajax({
            url:'/manage/goods/sellout',
            data:{
                id:id
            },
            type:'GET',
            success:function (res) {
                alert(res?'success':'false')
            }
        });
    }


    /**
     * 添加商品模态框
     */
    $("#addGoods").click(function () {
        clearForm("#GoodsAddModal form");
        $("#GoodsAddModal").modal({
            backdrop: "static"
        });
    });

    /**
     * 清空表单
     */
    function clearForm(ele) {
        $(ele)[0].reset();
    }


    /**
     * 初始化时间选择器控件
     */
    function datetimepickerInit() {
        // 初始化控件 - 修改商品
        $('#startTime').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });

        $('#endTime').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });

        // 初始化控件 - 添加商品
        $('#startTime2').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });

        $('#endTime2').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });

        // 初始化input的时间为数据库保存的时间 - 修改商品
        $('#startTimeInput').val("YYYY-MM-DD hh:mm");

        $('#endTimeInput').val("YYYY-MM-DD hh:mm");
    }

    var keywords = '';

    $('#search').click(function () {
        keywords = $('#keywords').val();
        toPage(1);
    });

    function toPage(page) {
        page = page==null?1:page;
        var url;
        if (keywords == ''){
            url = '/manage/goodslist?pageNum='+page;
        }else{
            url = '/manage/goodslist?pageNum='+page +'&keywords='+keywords;
        }
        $.ajax({
            url:url ,
            type:'get',
            success:function (res) {
                $('#placeholder').html(res);
            }
        });
    }




