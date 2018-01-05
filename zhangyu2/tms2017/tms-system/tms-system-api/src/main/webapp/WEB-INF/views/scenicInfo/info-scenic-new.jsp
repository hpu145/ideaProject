<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>景区信息-添加景区</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../include/css.jsp" %>

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <!-- 顶部导航栏部分 -->
    <%@include file="../include/header.jsp" %>
    <!-- 左侧菜单栏 -->
    <jsp:include page="../include/sidebar.jsp">
        <jsp:param name="menu" value="info-scenic"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">添加景区</h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-primary btn-sm" id="returnScenicBtn"><i class="fa fa-arrow-left"></i> 返回</button>
                    </div>
                </div>
                <div class="box-body">
                    <form action="" method="post" id="editScenicForm" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${scenic.id}">
                        <div class="form-group">
                            <label>景区名称</label>
                            <input type="text" class="form-control" name="scenicName" value="${scenic.scenicName}">
                        </div>
                        <div class="form-group">
                            <label>星级</label>
                            <input type="text" class="form-control" name="scenicLevel" value="${scenic.scenicLevel}">
                        </div>

                        <div class="form-group">
                            <label>负责人</label>
                            <input type="text" class="form-control" name="scenicManager" value="${scenic.scenicManager}">
                        </div>
                        <div class="form-group">
                            <label>联系电话</label>
                            <input type="text" class="form-control" name="scenicTel" value="${scenic.scenicTel}">
                        </div>
                        <div class="form-group">
                            <label>营业执照</label>
                            <input type="file" class="form-control" name="pic" value="${scenic.scenicAttachment}">
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input type="text" class="form-control" name="scenicAddress" value="${scenic.scenicAddress}">
                        </div>
                        <div class="form-group">
                            <label>经度</label>
                            <input type="text" class="form-control" name="scenicGeoLongitude" value="${scenic.scenicGeoLongitude}">
                        </div>
                        <div class="form-group">
                            <label>纬度</label>
                            <input type="text" class="form-control" name="scenicGeoLatitude" value="${scenic.scenicGeoLatitude}">
                        </div>
                        <div class="form-group">
                            <label>景区介绍</label>
                            <textarea class="from-control" name="scenicIntro" id="editor" value="${scenic.scenicIntro}" placeholder="正文从这里开始..."></textarea>
                            <%--<input type="text" class="form-control" name="scenicIntro" value="${scenic.scenicIntro}">--%>
                        </div>
                    </form>
                </div>
                <div class="box-footer">
                    <a href="/scenic/info" class="btn btn-default"> 取消</a>
                    <button class="btn btn-primary" id="editScenicBtn">保存</button>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!-- 底部 -->
    <%@include file="../include/footer.jsp" %>
</div>
<!-- ./wrapper -->
<%@include file="../include/js.jsp" %>
<script src="/static/dist/js/jquery.validate.min.js"></script>
<!-- 富文本编辑器 -->
<script src="/static/plugins/editor/scripts/module.min.js"></script>
<script src="/static/plugins/editor/scripts/hotkeys.min.js"></script>
<script src="/static/plugins/editor/scripts/uploader.min.js"></script>
<script src="/static/plugins/editor/scripts/simditor.min.js"></script>

<script>
    $(function () {
        var editor = new Simditor({
            textarea: $('#editor'),
            toolbarHidden : true,
            upload : {
                url : '',
                fileKey : 'file_key'
            }
        });
        //返回
        $("#returnScenicBtn").click(function () {
            window.location.href = "/scenic/info";
        });
        //提交
        $("#editScenicBtn").click(function () {
            $("#editScenicForm").submit();
        });

        $("#editScenicForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules : {
                scenicName : {
                    required : true
                },
                scenicLevel : {
                    required : true
                },
                scenicManager : {
                    required : true
                },
                scenicTel : {
                    required : true
                },
                pic : {
                    required : true
                },
                scenicAddress : {
                    required : true
                },
                scenicGeoLongitude : {
                    required : true
                },
                scenicGeoLatitude : {
                    required : true
                }
            },
            messages : {
                scenicName : {
                    required : "请输入景区名称"
                },
                scenicLevel : {
                    required : "请输入景区星级"
                },
                scenicManager : {
                    required : "请输入景区负责人"
                },
                scenicTel : {
                    required : "请输入景区联系电话"
                },
                scenicAddress : {
                    required : "请输入景区地址"
                },
                pic : {
                    required : "请上传景区营业执照"
                },
                scenicGeoLongitude : {
                    required : "请输入景区经度坐标"
                },
                scenicGeoLatitude : {
                    required : "请输入景区纬度坐标"
                }
            }
        });

    });

</script>

</body>
</html>

