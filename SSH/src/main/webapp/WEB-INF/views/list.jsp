<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="/static/favicon.ico"/>
    <link rel="bookmark" href="/static/favicon.ico"/>

</head>
<body>
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-body">
                <form action="" class="form-inline">
                    <input type="text" placeholder="商品名称" name="q_productName_like_s" class="form-control">
                    <input type="text" placeholder="价格" name="q_price_eq_bd">
                    <input type="text" placeholder="市场价格" name="q_marketPrice_eq_bd">
                    <button class="btn btn-default">搜索</button>
                </form>
            </div>
        </div>



        <a href="/kaola/new" class="btn btn-success">添加</a>
        <table class="table">
            <thead>
            <tr>
                <th>商品名称</th>
                <th>价格</th>
                <th>市场价</th>
                <th>产地</th>
                <th>评论数量</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${page.items}" var="kaola">
                    <tr>
                        <td><a href="/kaola/${kaola.id}">${kaola.productName}</a></td>
                        <td>${kaola.price}</td>
                        <td>${kaola.marketPrice}</td>
                        <td>${kaola.place}</td>
                        <td>${kaola.commentNum}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%--分页--%>
        <span style="font-size:14px;">
            <div class="text-center">
                <ul id="pagination-demo" class="pagination-sm"></ul>
            </div>
        </span>
    </div>

<script src="/static/js/jquery-2.2.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>
    $(function () {
        //分页
        $('#pagination-demo').twbsPagination({
            //total总记录数，就是多少条数据  pages总页数
            totalPages: ${page.total},
            visiblePages: 5,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"?p={{number}}"
        });
    });

</script>
</body>
</html>