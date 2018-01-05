<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>基本信息管理-售票点信息详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../include/css.jsp"%>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .td_title {
            font-weight: bold;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <%@include file="../include/header.jsp"%>
    <!-- 左侧菜单栏 -->
    <jsp:include page="../include/sidebar.jsp">
        <jsp:param name="menu" value="info-store"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">售票点信息详情</h3>
                    <div class="box-tools">
                        <a href="/store/info" class="btn btn-primary btn-sm"><i class="fa fa-arrow-left"></i> 返回列表</a>
                        <button id="editScenicBtn" rel="${store.id}" class="btn bg-purple btn-sm"><i class="fa fa-pencil"></i> 编辑</button>
                        <button id="delScenicBtn" rel="${store.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i> 删除</button>
                    </div>
                </div>
                <c:if test="${not empty message}">
                    <div class="alert alert-info">
                        <h5>${message}</h5>
                    </div>
                </c:if>
                <div class="box-body no-padding">
                    <table class="table">
                        <tr>
                            <td class="td_title">售票点名称</td>
                            <td>${store.storeName}</td>
                            <td class="td_title">负责人</td>
                            <td>${store.storeManager}</td>
                            <td class="td_title">地址</td>
                            <td>${store.storeAddress}</td>
                        </tr>
                        <tr>
                            <td class="td_title">联系电话</td>
                            <td>${store.storeTel}</td>
                            <td class="td_title">经度</td>
                            <td>${store.storeGeoLongitude}</td>
                            <td class="td_title">纬度</td>
                            <td>${store.storeLatitude}</td>
                        </tr>
                        <tr>
                            <c:if test="${not empty store.createTime}">
                                <td class="td_title">创建时间</td>
                                <td><fmt:formatDate value="${store.createTime}" type="both"/></td>
                            </c:if>
                            <c:if test="${not empty store.updateTime}">
                                <td class="td_title">修改时间</td>
                                <td><fmt:formatDate value="${store.updateTime}" type="both"/></td>
                            </c:if>
                        </tr>
                    </table>
                    <table class="table">
                        <td class="td_title">售票点营业执照</td><br>
                    </table>
                    <table class="table">
                        <img src="http://p0iv04fjn.bkt.clouddn.com/${store.storeAttachment}?imageView2/1/w/300/h/250" >
                    </table>
                    <table class="table">
                        <td class="td_title">负责人身份证照片</td><br>
                    </table>
                    <table class="table">
                        <img src="http://p0iv04fjn.bkt.clouddn.com/${store.storeManagerAttachment}?imageView2/1/w/300/h/250" >
                    </table>
                </div>
                <div class="box-footer">
                    <span style="color: #ccc" class="pull-right">创建日期：<span title="<fmt:formatDate value="${store.createTime}"/>"><fmt:formatDate value="${store.createTime}" pattern="MM月dd日"/></span> &nbsp;&nbsp;&nbsp;&nbsp;
                        最后修改日期：<span title="<fmt:formatDate value="${store.updateTime}"/>"><fmt:formatDate value="${store.updateTime}" pattern="MM月dd日"/></span></span>
                </div>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!-- 底部 -->
    <%@include file="../include/footer.jsp"%>
</div>
<!-- ./wrapper -->
<%@include file="../include/js.jsp"%>
<script>
    $(function () {
        //删除售票点
        //var scenicId = ${scenic.id};
        $("#delScenicBtn").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("您确定要删除该售票点吗?",function (index) {
                layer.close(index);
                window.location.href = "/store/delete/"+id;
            });
        });
        //编辑售票点
        $("#editScenicBtn").click(function () {
            var id = $(this).attr("rel");
            window.location.href = "/store/edit/"+id;
        });

    });

</script>
</body>
</html>
