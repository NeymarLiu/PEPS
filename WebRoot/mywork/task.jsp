<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://testTag/lxc" prefix="p" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>无标题文档</title>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body class="sarchbody" >
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>我的工作平台</li>
    <li>代办列表</li>
    
    </ul>
    </div>
    
    <div class="formbody">
    <div id="usual1" class="usual"> 
    <ul class="seachform1">
    <form action="patcolTask.action" method="post">
    <li><label>任务名称</label><input name="p_name" type="text" class="scinput1" value="${fmp.p_name }"/></li>

  <li><input  type="submit" class="scbtn" value="查询"/>&nbsp;
  </form>
    
    </ul>
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 

  
  $('#add').click(function(){
	  location.href="add.html";
  });
  
 
});

 function del(){
   confirm("确认删除");
 }
</script>

<input type="hidden" id="r_id" value="${loginUser.rolePojo.r_id }">
<input id="purl" type="hidden" value="patcolTask.action?p_name=${fmp.p_name}">
<form action="patcolTask.action">
    <table class="tablelist" >
    	<thead>
	    	<tr>
		        <th>代办任务类型</th>
		        <th>代办任务名称</th>
		        <th>到达时间</th>
		        <th>操作</th>
	        </tr>
        </thead>
       <c:forEach items="${mytks}" var="mytk">
       	<tr> 
       		<c:catch>
	       	<td>
			${mytk.taskName}
		       	</td>
		        <td>${mytk.p_name}</td>
		        <td>${mytk.issude_time}</td>
	        </c:catch>
	        <td>
		        <a href="${mytk.getOne }"   class="tablelink">查看</a>  
		        |
		        <a href="${mytk.toOne }"  class="tablelink"> 处理</a>
		       
	        </td>
	    </tr>
	    </c:forEach>
	    </table>
           </form>
      <!-- 
        <tr>
        <td>消缺任务</td>
        <td>西林1线消缺任务执行</td>
          <td>20016-03-15 22:10:10</td>
        <td><a href="getAllXj"method="post" class="tablelink">查看</a>   
            <a href="getAllPTask.action" method="post"  class="tablelink"> 处理</a></td>
        </tr>  -->
  
    
   
   <table class="tablelist2">
       <tr>
       	<th>
       	<p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="patcolTask.action?p_name=${fmp.p_name}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table> 
   
	</div> 
    </div>
</body>
  <font color="red">点击处理会跳到相应的任务类型页面</font>
</html>
