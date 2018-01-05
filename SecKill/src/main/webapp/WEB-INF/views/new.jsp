<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link rel="stylesheet" href="/static/js/datetimepicker/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" type="text/css" href="/static/js/editor/styles/simditor.css" />
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <form method="post" enctype="multipart/form-data">
            <legend><h3>添加抢购商品</h3></legend>
            <div class="form-group">
                <label>商品名称</label>
                <input type="text" class="form-control" name="productName">
            </div>
            <div class="form-group">
                <label>副标题</label>
                <input type="text" class="form-control" name="productSubtitle">
            </div>
            <div class="form-group">
                <label>秒杀价</label>
                <input type="text" class="form-control" name="productPrice">
            </div>
            <div class="form-group">
                <label>市场价</label>
                <input type="text" class="form-control" name="productMarketPrice">
            </div>
            <div class="form-group">
                <label>库存数量</label>
                <input type="text" class="form-control" name="productInventory">
            </div>
            <div class="form-group">
                <label>商品图片</label>
                <input type="file" class="form-control" name="image">
            </div>
            <div class="form-group">
                <label>开始时间</label>
                <input type="text" class="form-control timePicker" name="startTime">
            </div>
            <div class="form-group">
                <label>结束时间</label>
                <input type="text" class="form-control timePicker" name="endTime">
            </div>
            <div class="form-group">
                <label>商品描述</label>
                <textarea name="productDesc" id="editor" class="form-control"></textarea>
            </div>
            <div class="form-group">
                <button class="btn btn-lg btn-success">保存</button>
            </div>
        </form>
    </div>
    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/static/js/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="/static/js/editor/scripts/module.js"></script>
    <script src="/static/js/editor/scripts/hotkeys.js"></script>
    <script src="/static/js/editor/scripts/uploader.js"></script>
    <script src="/static/js/editor/scripts/simditor.js"></script>
    <script>
        $(function () {
            var timepicker = $('.timePicker').datetimepicker({
                format: "yyyy-mm-dd hh:ii",
                language: "zh-CN",
                autoclose: true,
                todayHighlight: true
            });
            var editor = new Simditor({
                textarea: $('#editor')
                //optional options
            });
        });
    </script>
</body>
</html>