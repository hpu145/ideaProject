<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>凯盛软件CRM-首页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/static/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="/static/plugins/tree/css/metroStyle/metroStyle.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <!-- 顶部导航栏部分 -->
    <header class="main-header">
        <!-- Logo -->
        <a href="index2.html" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>CRM</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>凯盛</b>CRM</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="/static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">李美苏</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>
                                    李美苏
                                    <small>海外事业部</small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="/profile" class="btn btn-default btn-flat">个人设置</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/logout" class="btn btn-default btn-flat">安全退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- =============================================== -->

    <!-- 左侧菜单栏 -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- 搜索表单，不需要删除即可 -->
            <!--<form action="#" method="get" class="sidebar-form">
              <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                      <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                      </button>
                    </span>
              </div>
            </form>-->
            <!-- /.search form -->
            <!-- 菜单 -->
            <ul class="sidebar-menu">
                <li class="header">系统功能</li>
                <!-- 客户管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-address-book-o"></i> <span>客户管理</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/customer/my"><i class="fa fa-circle-o"></i> 我的客户</a></li>
                        <li><a href="/customer/public"><i class="fa fa-circle-o"></i> 公海客户</a></li>
                    </ul>
                </li>
                <!-- 工作记录 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-bars"></i> <span>工作记录</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/recode/my"><i class="fa fa-circle-o"></i> 我的记录</a></li>
                        <li><a href="/recode/public"><i class="fa fa-circle-o"></i> 公共记录</a></li>
                    </ul>
                </li>
                <!-- 待办事项 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-calendar"></i> <span>待办事项</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/task"><i class="fa fa-circle-o"></i> 待办列表</a></li>
                        <li><a href=""><i class="fa fa-circle-o"></i> 逾期事项</a></li>
                    </ul>
                </li>
                <!-- 统计报表 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-pie-chart"></i> <span>统计报表</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../../index.html"><i class="fa fa-circle-o"></i> 待办列表</a></li>
                        <li><a href="../../index2.html"><i class="fa fa-circle-o"></i> 逾期事项</a></li>
                    </ul>
                </li>


                <li><a href="../../documentation/index.html"><i class="fa fa-share-alt"></i> <span>公司网盘</span></a></li>
                <li class="header">系统管理</li>
                <!-- 部门员工管理 -->
                <li class="treeview active">
                    <a href="#">
                        <i class="fa fa-users"></i> <span>组织架构</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:;"><i class="fa fa-circle-o"></i> 部门管理</a></li>
                        <li><a href="javascript:;"><i class="fa fa-circle-o"></i> 员工管理</a></li>
                    </ul>
                </li>
                <!--<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
                <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>-->
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-2">
                    <div class="box">
                        <div class="box-body">
                            <button id="addDept" class="btn btn-default">添加部门</button>
                            <ul id="ztree" class="ztree"></ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-10">
                    <!-- Default box -->
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">员工管理</h3>
                            <div class="box-tools pull-right">
                                <a href="javascript:;" id="addEmployee">添加员工</a>
                            </div>
                        </div>

                        <c:if test="${not empty message}">
                            <div class="alert alert-info">
                                <h5>${message}</h5>
                            </div>
                        </c:if>

                        <div class="box-body">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>部门</th>
                                    <th>手机</th>
                                    <th>管理</th>
                                </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${employeeList}" var="employee">
                                        <tr>
                                            <td>${employee.employeeName}</td>
                                            <td></td>
                                            <td>${employee.mobile}</td>
                                            <td>
                                                <a href="">禁用</a>
                                                <a href="">删除</a>
                                                <a href="">编辑</a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- 底部 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0
        </div>
        <strong>Copyright &copy; 2010 -2017 <a href="http://almsaeedstudio.com">凯盛软件</a>.</strong> All rights
        reserved.
    </footer>

</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/tree/js/jquery.ztree.all.min.js"></script>
<script src="/static/dist/js/layer/layer.js"></script>
<script>
    $(function(){
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback:{
                onClick:function(event,treeId,treeNode,clickFlag){
                    alert(treeNode.id + treeNode.name + treeNode.pId);
                }
            }
        };

        var zNodes =[
            { id:1, pId:0, name:"凯盛软件", open:true},
            { id:11, pId:1, name:"开发部"},
//            { id:111111, pId:11, name:"华北开发部"},
            { id:111, pId:1, name:"销售部"},
            { id:112, pId:1, name:"经理办公室"}
        ];
        $.fn.zTree.init($("#ztree"), setting, zNodes);

        $("#addDept").click(function () {

            layer.prompt({title: '请确认管理员登录密码', formType: 1}, function(pass, index){
                layer.close(index);
                layer.prompt({title: '请输入新添加部门名称，并确认', formType: 2}, function(text, index){
                    layer.close(index);
                    layer.msg('添加成功！您添加的部门：'+text);
                });
            });
        });


        $("#addEmployee").click(function () {
                window.location.href = "/employee_new";
            }
        );












    });
</script>
</body>
</html>
