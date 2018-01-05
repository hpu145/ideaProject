<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年票库存管理-售票点年票统计</title>
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
        <jsp:param name="menu" value="ticket-total"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">售票点年票统计</h3>
                    <div class="box-tools pull-right">
                        <a href="/ticket/total" class="btn btn-primary btn-sm"><i class="fa fa-arrow-left"></i>返回</a>
                    </div>
                </div>

                <div class="box-body no-padding">
                    <table class="table table-hover">
                        <tbody>
                        <tr>
                            <th width="80"></th>
                            <th>售票点名称</th>
                            <th>下发数量</th>
                            <th>已售数量</th>
                            <th>待售数量</th>
                        </tr>
                        <tr class="dataRow">
                            <td><span class="name-avatar"></span></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>

                        </tbody>
                    </table>

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

        $.validator.addMethod("labelValidate", function (value, element) {
            return this.optional(element) || /^[a-zA-Z0-9\u4e00-\u9fa5]+(,[a-zA-Z0-9\u4e00-\u9fa5]+)*$/.test(value);
        }, "please notice your doc");

        $("#editScenicForm").validate({
            errorClass: "text-danger",
            errorElement: "span",
            rules: {
                ticketNumStart: {
                    required: true,
                    labelValidate: true
                },
                ticketNumEnd: {
                    required: true,
                    labelValidate: true
                },
                storeAccountId: {
                    required: true
                },
                invalidNum: {
                    labelValidate: true
                }
            },
            messages: {
                ticketNumStart: {
                    required: "请输入年票起始编号",
                    labelValidate: "格式不正确,请用英文,隔开"
                },
                ticketNumEnd: {
                    required: "请输入年票结束编号",
                    labelValidate: "格式不正确,请用英文,隔开"
                },
                storeAccountId: {
                    required: "请输入选择下发售票点"
                },
                invalidNum: {
                    labelValidate: "格式不正确,请用英文,隔开"
                }
            }
        });

    });

</script>

</body>
</html>

