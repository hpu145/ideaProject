<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>基本信息管理-景区信息详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../include/css.jsp" %>
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
    <%@include file="../include/header.jsp" %>
    <!-- 左侧菜单栏 -->
    <jsp:include page="../include/sidebar.jsp">
        <jsp:param name="menu" value="info-scenic"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">景区信息详情</h3>
                    <div class="box-tools">
                        <a href="/scenic/info" class="btn btn-primary btn-sm"><i class="fa fa-arrow-left"></i> 返回列表</a>
                        <button id="editScenicBtn" rel="${scenic.id}" class="btn bg-purple btn-sm"><i
                                class="fa fa-pencil"></i> 编辑
                        </button>
                        <button id="delScenicBtn" rel="${scenic.id}" class="btn btn-danger btn-sm"><i
                                class="fa fa-trash-o"></i> 删除
                        </button>
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
                            <td class="td_title">景区名称</td>
                            <td>${scenic.scenicName}</td>
                            <td class="td_title">星级</td>
                            <td>${scenic.scenicLevel}</td>
                            <td class="td_title">地址</td>
                            <td>${scenic.scenicAddress}</td>
                        </tr>
                        <tr>
                            <td class="td_title">联系电话</td>
                            <td>${scenic.scenicTel}</td>
                            <td class="td_title">经度</td>
                            <td>${scenic.scenicGeoLongitude}</td>
                            <td class="td_title">纬度</td>
                            <td>${scenic.scenicGeoLatitude}</td>
                        </tr>
                        <tr>
                            <td class="td_title">负责人</td>
                            <td>${scenic.scenicManager}</td>
                            <c:if test="${not empty scenic.createTime}">
                                <td class="td_title">创建时间</td>
                                <td><fmt:formatDate value="${scenic.createTime}" type="both"/></td>
                            </c:if>
                            <c:if test="${not empty scenic.updateTime}">
                                <td class="td_title">修改时间</td>
                                <td><fmt:formatDate value="${scenic.updateTime}" type="both"/></td>
                            </c:if>
                        </tr>
                    </table>
                    <table class="table">
                        <td class="td_title">景区介绍</td>
                        <br>
                        <tr>
                            <td>${scenic.scenicIntro}</td>
                        </tr>
                    </table>
                    <table class="table">
                        <td class="td_title">景区营业执照</td>
                        <br>
                    </table>
                    <table class="table">
                        <img src="http://p0iv04fjn.bkt.clouddn.com/${scenic.scenicAttachment}?imageView2/1/w/300/h/250">
                    </table>
                </div>

                <div>
                    <div class="box-header with-border">
                        <h3 class="box-title">景区账号</h3>
                        <div class="box-tools">
                            <c:if test="${empty scenicAccount}">
                                <a href="/scenic/account/new/${scenic.id}" class="btn bg-purple btn-sm"><i class="fa fa-plus"></i> 添加账号</a>
                            </c:if>
                        </div>
                        <div class="box-body no-padding">
                            <table class="table">
                                <c:if test="${empty scenicAccount}">
                                    <tr>
                                        <td colspan="6" style="color:blue;text-align: center">暂无数据</td>
                                    </tr>
                                </c:if>
                                <c:if test="${not empty scenicAccount}">
                                    <tr>
                                        <td class="td_title">账户名</td>
                                        <td>${scenicAccount.scenicAccount}</td>
                                        <td class="td_title">账户密码</td>
                                        <td>${scenicAccount.scenicPassword}</td>
                                        <td class="td_title">账户状态</td>
                                        <c:if test="${scenicAccount.scenicState == '冻结'}">
                                            <td class="btn btn-danger">${scenicAccount.scenicState}</td>
                                        </c:if>
                                        <c:if test="${scenicAccount.scenicState == '正常'}">
                                            <td class="btn btn-primary">${scenicAccount.scenicState}</td>
                                        </c:if>
                                    </tr>
                                </c:if>

                            </table>
                        </div>
                    </div>


                </div>
                <div class="box-footer">
                    <span style="color: #ccc" class="pull-right">创建日期：<span title="<fmt:formatDate value="${scenic.createTime}"/>"><fmt:formatDate value="${scenic.createTime}" pattern="MM月dd日"/></span> &nbsp;&nbsp;&nbsp;&nbsp;
                        最后修改日期：<span title="<fmt:formatDate value="${scenic.updateTime}"/>"><fmt:formatDate value="${scenic.updateTime}" pattern="MM月dd日"/></span></span>
                </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!-- 底部 -->
    <%@include file="../include/footer.jsp" %>
</div>
<!-- ./wrapper -->
<%@include file="../include/js.jsp" %>
<script>
    $(function () {
        //删除景区
        //var scenicId = ${scenic.id};
        $("#delScenicBtn").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("您确定要删除该景区吗?", function (index) {
                layer.close(index);
                window.location.href = "/scenic/delete/" + id;
            });
        });
        //编辑景区
        $("#editScenicBtn").click(function () {
            var id = $(this).attr("rel");
            window.location.href = "/scenic/edit/" + id;
        });

    });

</script>
</body>
</html>
