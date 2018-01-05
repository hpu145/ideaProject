<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>年票库存管理-盘点统计</title>
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
                <%--<div class="box-header with-border">
                    <h3 class="box-title">年票盘点统计</h3>
                    <div class="box-tools pull-right">
                        <a href="/ticket/total/shore" class="btn btn-primary btn-sm"><i class="fa"></i>售票点年票统计</a>
                    </div>
                </div>--%>

                <div class="box-header with-border">
                    <h3 class="box-title">年票盘点统计</h3>
                </div>
                <div class="box-body">
                    <div id="bar" style="height: 300px;width: 100%"></div>
                </div>

                <%--<div class="box-body no-padding">
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <th width="80"></th>
                                <th>入库数量</th>
                                <th>下发数量</th>
                                <th>作废数量</th>
                                <th>库存量</th>
                            </tr>
                            <tr class="dataRow" rel="">
                                <td width="80"></td>
                                <td>${ticketIn}</td>
                                <td>${ticketOut}</td>
                                <td>${ticketInvalid}</td>
                                <th>${ticketStorage}</th>
                            </tr>
                        </tbody>
                    </table>

                </div>--%>
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
<script src="/static/plugins/echarts/echarts.min.js"></script>
<script>
    $(function () {
        //客户级别统计
        var bar = echarts.init(document.getElementById("bar"));
        var option = {
            title: {
                text: "年票盘点统计",
                left: 'center'
            },
            tooltip: {},
            legend: {
                data: ['年票数量'],
                left: 'right'
            },
            xAxis: {
                type: 'category',
                data: []
            },
            yAxis: {},
            series: {
                name: "年票数量",
                type: 'bar',
                data:[]
            }
        }
        bar.setOption(option);

        $.get("/ticket/total/chart").done(function (resp) {
            if(resp.state == "success") {
                var nameArray = [];
                var valueArray = [];
                var dataArray = resp.data;

                for(var i = 0;i < dataArray.length;i++) {

                    var obj = dataArray[i];
                    nameArray.push(obj.level);
                    valueArray.push(obj.count);
                }

                bar.setOption({
                    xAxis:{
                        data:nameArray,
                    },
                    series:{
                        data:valueArray,
                        itemStyle: {
                            normal : {
                                color: '#172edd'
                            }
                        },
                        barWidth: 60,
                    }
                });
            } else {
                layer.msg(resp.message);
            }
        }).error(function () {
            layer.msg("加载数据异常");
        });




    });

</script>

</body>
</html>

