<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://testTag/lxc" prefix="p" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
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
<input id="purl" type="hidden" value="getAllMenus.action?m_name=${mpp.m_name}">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>系统管理</li>
    <li>菜单管理</li>
    
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
    <ul class="seachform1">
    <li>
    <form action="getAllMenus.action" method="post">
    <label>菜单名称</label>
    <input name="m_name" type="text" class="scinput1" value="${mpp.m_name}"/>
    
  <input  type="submit" class="scbtn" value="查询"/>&nbsp;
  </form></li>
  <li><input name="" id="add"  type="button" class="scbtn1" value="添加菜单"/></li>
    
    </ul>
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 

  $('#add').click(function(){
	  location.href="toAddMenu.action";
  });
  
 
});

 function del(obj){
 	//alert(obj);
   if(confirm("确认删除吗？")){
   		location.href="deleteMenu.action?mid="+obj;
   }
 }
</script>
    <table class="tablelist" >
    	<thead>
    	<tr>
        
        <th>序号</th>
        <th>菜单名称</th>
        <th>菜单路径</th>
        <th>创建时间</th>
        <th>状态(启用/未启用)</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${mList != null }">
        <c:forEach items="${mList }" var="m">
     	<tr>
       
        <td>${m.m_id}</td>
        <td>${m.m_name}</td>
        <td>${m.m_url}</td>
        <td>${m.p_m_createtime}</td>
       
       
        <td><c:if test="${m.m_state==0}">启用</c:if>
        <c:if test="${m.m_state==1}">禁用</c:if></td>
       
        <td><a href="toUpdateMenu.action?mid=${m.m_id}" class="tablelink">修改</a>  |   
            <a href="javascript:void(0)" onclick="del(${m.m_id})" class="tablelink"> 删除</a></td>
        </tr> 
     </c:forEach>
        
        </c:if>
     
        </tbody>
    </table>
    <table class="tablelist2">
       <tr>
         <th><!-- 共2条记录
        	 当前：1/2页&nbsp;&nbsp;
          <a href="#">首页</a><a href="#">上一页</a><a href="#">下一页</a><a href="#">尾页</a>
         
         &nbsp;&nbsp;跳到:<input type="text" value="" onkeyup="value=value.replace(/[^\d]/g,'')" id="go" class="scinput5" />页 &nbsp;&nbsp;<input type="button" id="sure" class="scbtn5" value="确定"/> &nbsp;&nbsp; &nbsp;&nbsp; -->
        		<p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllMenus.action?m_name=${mpp.m_name}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
      
	</div> 
    </div>
</body>

</html>
