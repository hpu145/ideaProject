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
</head>
<body>
    <div class="container">
        <h3>${kaola.productName}</h3>
        <ul>
            <li>商品价格：${kaola.price}</li>
            <li>市场价格：${kaola.marketPrice}</li>
            <li>产地：${kaola.place}</li>
            <li>评论数量：${kaola.commentNum}</li>
            <li>所属分类：${kaola.kaolaType.typeName}</li>
        </ul>
        <a class="btn btn-primary" href="/product/${kaola.id}/edit">修改</a>
        <a class="btn btn-danger" href="/product/${kaola.id}/delete">删除</a>
    </div>
</body>
</html>