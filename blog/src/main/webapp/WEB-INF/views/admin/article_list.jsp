<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- forEach内部格式化时间 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>文章管理</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
 
  <%@ include file="include/css.jsp"%>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

  <%@ include file="include/header.jsp"%>
    
  <%@ include file="include/siderbar.jsp"%>     

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
    <!-- Main content -->
    <section class="content">
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
        <!-- 搜索框 get请求  根据文章标题关键字进行搜索-->
          <form action="/admin/article/list" class="form-inline pull-left" >
            <input type="text" class="form-control" name="keys" id="keys" placeholder="关键字"/>
            <button class="btn btn-primary"><i class="fa fa-search"></i></button>
          </form>
        <!-- 搜索框 -->
          <a href="/admin/article/add" class="btn btn-success pull-right">写文章</a>
        </div>

        <div class="box-body">
          
          <table class="table" id="cust_table">
            <thead>
              <tr >
                <th>文章标题</th>
                <th>分类</th>
                <th>标签</th>
                <th>发表时间</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${page.items}" var="article">
              <tr>
                <td>${article.title }</td>
                <td>${article.node.name}</td>
                <td>
                	<c:forEach items="${article.labelList}" var="label" varStatus="vs">
                		${label.name}
                		<c:if test="${not vs.last}">
                			,
                		</c:if>
                	</c:forEach>
                
                </td>
                <td><fmt:formatDate value="${article.createTime}" type="both" /></td>
                
                <td>
                  <a href="javascript:;" class="del" rel="${article.id}">删除</a> 
	              <a href="/admin/article/edit?id=${article.id}">修改</a>
                </td>
              </tr>
              </c:forEach>    
            </tbody>
          </table>
          <br> 
          <ul id="pagination" class="pagination pull-right"></ul>
        </div>
        <!-- /.box-body -->
        
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.8
    </div>
    <strong>Copyright &copy; 2014-2016 <a href="http://www.kaishengit.com/" target="_blank">凯盛软件</a>.</strong> All rights
    reserved.
  </footer>

</div>
<!-- ./wrapper -->

 <%@ include file="include/js.jsp"%>

<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<!-- page -->
<script src="/static/dist/js/jquery.twbsPagination.min.js"></script>
<script>
$(function(){
    $("#pagination").twbsPagination({
     totalPages:"${page.pageTotal}",
     visiblePages:3,
     href:"/admin/article/list?p={{number}}&keys=${requestScope.keys}",
     first: "首页",
     prev: "上一页",
     next:"下一页",
     last:"末页"
   });  
  
    
    //$("#article").text(moment(createtime).format('YYYY-MM-DD HH:mm:ss')); 
    
    $(".del").click(function(){
		var id = $(this).attr("rel");
    	layer.confirm("确定要删除吗？",function(){
       		$.get("/admin/article/del",{"id":id}).done(function(json){
       			if(json.state == "success") {
       				layer.alert("删除成功",function(){
       					history.go(0);
       				})
       			}
       		}).error(function(){
       			alert("系统异常")
       		});
    	})
    });
    
});
</script>
</body>
</html>
  