<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS综合管理系统-首页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="include/css.jsp"%>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <!-- 顶部导航栏部分 -->
    <%@include file="include/header.jsp"%>
    <!-- 左侧菜单栏 -->
    <jsp:include page="include/sidebar.jsp">
        <jsp:param name="menu" value="home"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                综合管理系统
                <small>首页</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">焦作旅游年票--综合管理系统</h3>
                </div>
                <%--<div class="box-body">
                    &lt;%&ndash;权限控制&ndash;%&gt;
                    <shiro:hasRole name="系统管理部">
                        <h4><span style="color: blue">你好，系统管理部员工!</span></h4>
                    </shiro:hasRole>
                    Start creating your amazing application!
                </div>--%>
                <!-- /.box-body -->
                <%--<img src="/static/img/place.jpg" width="1085px" height="360px">--%>
                <div class="box-footer">
                    凯盛软件
                </div>
                <!-- /.box-footer-->
            </div>
            <!-- /.box -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!-- 底部 -->
    <%@include file="include/footer.jsp"%>
</div>
<!-- ./wrapper -->
<%@include file="include/js.jsp"%>

</body>
</html>
