<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>景区信息-添加景区账号</title>
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
                    <h3 class="box-title">添加景区账号</h3>
                </div>
                <c:if test="${not empty message}">
                    <div class="alert alert-info">
                        <h5>${message}</h5>
                    </div>
                </c:if>
                <c:if test="${empty message}">
                    <div class="alert alert-info">
                        <h5>您已成功添加景区账号</h5>
                    </div>
                </c:if>

                <div class="box-body">
                    <form action="" method="post" id="editScenicForm" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>账户名</label>
                            <input type="text" class="form-control" name="scenicAccount" value="${scenicAccount.scenicAccount}">
                        </div>
                        <div class="form-group">
                            <label>账户密码</label>
                            <input type="text" class="form-control" name="scenicPassword" value="${scenicAccount.scenicPassword}">
                        </div>
                        <div class="form-group">
                            <label>账户状态</label>
                            <select name="scenicState" class="form-control">
                                <option value="${scenicAccount.scenicState}">
                                    <c:if test="${empty scenicAccount.scenicState}">
                                        --请选择--
                                    </c:if>
                                    <c:if test="${not empty scenicAccount.scenicState}">
                                        ${scenicAccount.scenicState}
                                    </c:if>
                                </option>
                                <option  value="正常">正常</option>
                                <option  value="冻结">冻结</option>
                            </select>
                        </div>

                    </form>
                </div>
                <div class="box-footer">
                    <a href="/scenic/${scenicId}" class="btn btn-default"> 取消</a>
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

        //提交
        $("#editScenicBtn").click(function () {
            $("#editScenicForm").submit();
        });

        $("#editScenicForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules : {
                scenicAccount : {
                    required : true
                },
                scenicPassword : {
                    required : true
                },
                scenicState : {
                    required : true
                }
            },
            messages : {
                scenicAccount : {
                    required : "请输入账户名"
                },
                scenicPassword : {
                    required : "请输入密码"
                },
                scenicState : {
                    required : "请选择账户状态"
                }
            }
        });

    });

</script>

</body>
</html>

