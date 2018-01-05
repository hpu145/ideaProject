<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>景区信息-编辑信息</title>
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
                    <h3 class="box-title">编辑信息</h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-primary btn-sm" id="returnScenicBtn" rel="${scenic.id}"><i class="fa fa-arrow-left"></i> 返回详情</button>
                    </div>
                </div>
                <div class="box-body">
                    <form action="" method="post" id="editScenicForm">
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
                    </form>
                </div>
                <div class="box-footer">
                    <a href="/scenic/${scenic.id}" class="btn btn-default"> 取消</a>
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


<script>
    $(function () {
        //返回详情
        $("#returnScenicBtn").click(function () {
            var id = $(this).attr("rel");
            window.location.href = "/scenic/" + id;
        });
        //提交修改信息
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

