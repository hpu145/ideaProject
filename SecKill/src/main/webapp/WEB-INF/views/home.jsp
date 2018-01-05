<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h3>抢购列表</h3>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <a href="/product/new" class="btn btn-primary">添加商品</a>
            </div>
            <div class="panel-body">
                <c:forEach items="${productList}" var="product">
                    <div class="row">
                        <div class="col-md-3">
                            <img src="http://ozp5bpxi8.bkt.clouddn.com/${product.productImg}?imageView2/1/w/200/h/200">
                        </div>
                        <div class="col-md-9">
                            <h4><a href="/product/${product.id}">${product.productName}</a> </h4>
                            <p>抢购价: ￥${product.productPrice}</p>
                            <h4>开始时间：${product.startTime}</h4>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>