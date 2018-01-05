<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!-- 左侧菜单栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- 菜单 -->
        <ul class="sidebar-menu">
            <li class="${param.menu == 'home' ? 'active' : ''}"><a href="/home">
                <i class="fa fa-home"></i> <span>首页</span></a></li>
            <li class="header">系统功能</li>
            <!-- 基本信息管理 -->
            <li class="treeview ${fn:startsWith(param.menu,"info-") ? "active" : ""}">
                <a href="#">
                    <i class="fa  fa-info-circle"></i> <span>基本信息管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class="${param.menu == 'info-scenic' ? 'active' : ''}"><a href="/scenic/info"><i class="fa fa-circle-o"></i><span>景区信息</span></a></li>
                    <li class="${param.menu == 'info-store' ? 'active' : ''}"><a href="/store/info"><i class="fa fa-circle-o"></i><span>售票点信息</span></a></li>
                    <li class="${param.menu == 'info-sort' ? 'active' : ''}"><a href="/sort/store"><i class="fa fa-circle-o"></i><span>分类统计信息</span></a></li>
                </ul>
            </li>
            <!-- 综合办公管理 -->
            <li class="treeview ${fn:startsWith(param.menu,"chance-") ? "active" : ""}">
                <a href="#">
                    <i class="fa fa-bars"></i> <span>综合办公系统</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href="/sale/chance-my"><i class="fa fa-circle-o"></i> <span>电子公告</span></a></li>
                    <li class=""><a href="/sale/chance-my"><i class="fa fa-circle-o"></i> <span>消息中心</span></a></li>
                    <li class=""><a href="/sale/chance-my"><i class="fa fa-circle-o"></i> <span>规章制度</span></a></li>
                    <li class=""><a href="/sale/chance-my"><i class="fa fa-circle-o"></i> <span>待办工作</span></a></li>
                </ul>
            </li>
            <!-- 领导管理驾驶舱-->
            <li class="treeview ${fn:startsWith(param.menu,"task-" )?'active':''}">
                <a href="#">
                    <i class="fa  fa-user"></i> <span>领导管理系统</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href=""><i class="fa fa-circle-o"></i> 年票信息查询</a></li>
                    <li class=""><a href=""><i class="fa fa-circle-o"></i> 售票点业务查询</a></li>
                    <li class=""><a href=""><i class="fa fa-circle-o"></i> 景区验票查询</a></li>
                    <li class=""><a href=""><i class="fa fa-circle-o"></i> 分类统计查询</a></li>
                </ul>
            </li>

            <%--年票库存管理--%>
            <li class="treeview ${fn:startsWith(param.menu,"ticket-" )?'active':''}">
                <a href="#">
                    <i class="fa  fa-pie-chart"></i> <span>年票库存管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class="${param.menu == 'ticket-in'?'active':''}"><a href="/ticket/in"><i class="fa fa-circle-o"></i> 年票入库</a></li>
                    <li class="${param.menu == 'ticket-out'?'active':''}"><a href="/ticket/out"><i class="fa fa-circle-o"></i> 年票下发</a></li>
                    <li class="${param.menu == 'ticket-invalid'?'active':''}"><a href="/ticket/invalid"><i class="fa fa-circle-o"></i> 年票作废</a></li>
                    <%--<li class="${param.menu == 'ticket-total'?'active':''}"><a href="/ticket/total"><i class="fa fa-circle-o"></i> 盘点统计</a></li>--%>
                </ul>
            </li>

            <%--年票结算系统--%>
           <%-- <li class="">
                <a href="#">
                    <i class="fa fa-money"></i> <span>年票结算系统</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href=""><i class="fa fa-circle-o"></i> 售票点缴费</a></li>
                    <li class=""><a href=""><i class="fa fa-circle-o"></i> 景区验票统计</a></li>
                    <li class=""><a href=""><i class="fa fa-circle-o"></i> 景区验票结算</a></li>
                </ul>
            </li>--%>
            <%--<shiro:hasRole name="管理员">
                <li class="header">系统管理</li>
                <!-- 系统管理 -->
                <li class="${param.menu == 'employee' ? 'active' : ''}"><a href="/employee"><i class="fa fa-users"></i>
                    <span>员工管理</span></a>
                </li>
            </shiro:hasRole>--%>


        </ul>
    </section>
    <!-- /.sidebar -->
</aside>