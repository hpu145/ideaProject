<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年票库存管理-年票下发</title>
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
        <jsp:param name="menu" value="ticket-out"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">年票下发</h3>
                </div>
                <c:if test="${not empty message}">
                    <div class="alert alert-info">
                        <h5>${message}</h5>
                    </div>
                </c:if>
                <div class="box-body">
                    <form action="/ticket/out" method="post" id="editScenicForm">
                        <input type="hidden" name="id" value="">
                        <div class="form-group">
                            <label>下发起始编号</label>
                            <input type="text" placeholder="当前可下发年票的最小起始编号: ${ticketOutWithIdMin.ticketNum}" class="form-control" name="ticketNumStart">
                        </div>
                        <div class="form-group">
                            <label>年票下发数量</label>
                            <input type="text" class="form-control" name="ticketOutTotal">
                            <input type="hidden" class="form-control" name="ticketNumEnd">
                        </div>
                        <div class="form-group">
                            <label>下发至售票点</label>
                            <select name="storeAccountId" class="form-control">
                                <option value="">--请选择--</option>
                                <c:forEach items="${page.list}" var="ticketStore">
                                    <option  value="${ticketStore.storeAccountId}">${ticketStore.storeName}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </form>
                </div>
                <div class="box-footer">
                    <a href="/ticket/out" class="btn btn-default"> 取消</a>
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

        $.validator.addMethod("labelValidate", function(value, element) {
            return this.optional(element) || /^[a-zA-Z0-9\u4e00-\u9fa5]+(,[a-zA-Z0-9\u4e00-\u9fa5]+)*$/.test(value);
        }, "please notice your doc");


        $("#editScenicForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules : {
                ticketNumStart : {
                    required : true
                },
                ticketOutTotal : {
                    required : true
                },
                storeAccountId : {
                    required : true
                }
            },
            messages : {
                ticketNumStart : {
                    required : "请输入年票起始编号"
                },
                ticketOutTotal : {
                    required : "请输入年票下发数量"
                },
                storeAccountId : {
                    required : "请输入选择下发售票点"
                }
            }
        });

    });

</script>

</body>
</html>

