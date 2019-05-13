    /**
     * 修改商品模态框
     */
    $("#test").click(function () {
        // ajax获取并填充
        $("#GoodsModifyModal").modal({
            backdrop: "static"
        });
    });

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

$(function () {
    // 初始化时间选择器控件
    datetimepickerInit();
    
});   


