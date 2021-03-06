<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>分类统计信息-售票点信息统计</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../include/css.jsp" %>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .name-avatar {
            display: inline-block;
            width: 50px;
            height: 50px;
            background-color: #ccc;
            border-radius: 50%;
            text-align: center;
            line-height: 50px;
            font-size: 24px;
            color: #FFF;
        }
        .table>tbody>tr:hover {
            cursor: pointer;
        }
        .table>tbody>tr>td {
            vertical-align: middle;
        }
        .star {
            font-size: 20px;
            color: #ff7400;
        }
    </style>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <!-- 顶部导航栏部分 -->
    <%@include file="../include/header.jsp" %>
    <!-- 左侧菜单栏 -->
    <jsp:include page="../include/sidebar.jsp">
        <jsp:param name="menu" value="info-sort"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">售票点信息统计</h3>
                    <%--<div class="box-tools pull-right">
                        <a href="/sort/info" class="btn btn-success btn-sm"><i class="fa fa-arrow-left"></i>返回</a>
                    </div>--%>
                </div>
                <div class="box-header with-border">
                    <form action="/sort/store" class="form-inline pull-left" >
                        <input type="text" name="storeName" placeholder="售票点名称" class="form-control" value="${param.storeName}">
                        <%--<input type="text" name="storeAddress" placeholder="地址" class="form-control" value="${param.storeAddress}">--%>
                        <%--<input type="text" name="storeManager" placeholder="负责人" class="form-control" value="${param.storeManager}">--%>
                        <button class="btn btn-primary"><i class="fa fa-search"></i></button>
                    </form>
                </div>

                <c:if test="${not empty message}">
                    <div class="alert alert-info">
                        <h5>${message}</h5>
                    </div>
                </c:if>
                <div class="box-body no-padding">
                    <table class="table table-hover">
                        <tbody>
                        <tr>
                            <th width="80"></th>
                            <th>售票点名称</th>
                            <th>地址</th>
                            <th>负责人</th>
                            <th>联系电话</th>
                        </tr>
                        <c:if test="${empty page.list}">
                            <tr>
                                <td colspan="6" style="color:blue;text-align: center">暂无数据</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${page.list}" var="store">
                            <tr class="dataRow" rel="${store.id}">
                                <td><span class="name-avatar">${fn:substring(store.storeName,0,1)}</span></td>
                                <td>${store.storeName}</td>
                                <td>${store.storeAddress}</td>
                                <td>${store.storeManager}</td>
                                <td><i class="fa fa-phone"></i>${store.storeTel}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    <%--分页--%>
                    <span style="font-size:14px;"><div class="text-center">
                        <ul id="pagination-demo" class="pagination-sm"></ul>
                    </div></span>

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
<script src="/static/dist/js/jquery.twbsPagination.min.js"></script>
<script>
    $(function () {
        //分页
        $('#pagination-demo').twbsPagination({
            totalPages: ${page.pages}, //total总记录数，就是多少条数据  pages总页数
            visiblePages: 5,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"?p={{number}}" // 控制器部分加别名 name="p"   /customer/customer-my
        });

    });

</script>
</body>
</html>
