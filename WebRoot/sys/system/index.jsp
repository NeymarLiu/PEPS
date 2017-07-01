<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<link href="../../css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../../js/select-ui.min.js"></script>
<script type="text/javascript" src="../../editor/kindeditor.js"></script>

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
    <li>系统管理</li>
    <li>配置类型</li>
    
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
    
   
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 
  
  $('#addcanshu').click(function(){
	  location.href="addcanshu.html";
  });
  $('#addtype').click(function(){
	  location.href="addtype.html";
  });
 
});

 function del(){
   confirm("确认删除");
 }
</script>
    <table class="tablelist" >
    	<thead>
    	<tr>
        
        <th>配置类型编码</th>
        <th>配置类型名称</th>
        <th>描述</th>
         <th>状态</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
     
        <tr>
       
        <td>IS_START</td>
        <td>是否启用</td>
        <td>是否启用</td>
         <td>启用</td>
        <td>
           <a href="#" class="tablelink">禁用|</a>
           <a href="updatetype.html" class="tablelink">修改|</a>
            <a href="javascript:void(0)" onclick="del()" class="tablelink">删除</a>
        </td>
       
        </tr> 
      
        <tr>
       
        <td>TASK_STATUS</td>
        <td>巡检任务状态</td>
        <td>任务状态</td>
        <td>禁用</td>
         <td>
           <a href="#" class="tablelink">禁用|</a>
           <a href="updatetype.html" class="tablelink">修改|</a>
            <a href="javascript:void(0)" onclick="del()" class="tablelink">删除</a>
        </td>
          </tr>
        </tbody>
    </table>
    
    <table class="tablelist2">
       <tr>
         <th><input name="" id="addtype"  type="button" class="scbtn1" value="添加类型"/>共2条记录
        	 当前：1/2页&nbsp;&nbsp;
          <a href="#">首页</a><a href="#">上一页</a><a href="#">下一页</a><a href="#">尾页</a>
         
         &nbsp;&nbsp;跳到:<input type="text" value="" onkeyup="value=value.replace(/[^\d]/g,'')" id="go" class="scinput5" />页 &nbsp;&nbsp;<input type="button" id="sure" class="scbtn5" value="确定"/> &nbsp;&nbsp; &nbsp;&nbsp;
         </th>
       </tr>
    </table>
      <br/> <br/> <br/> <br/> <br/> <br/>
<table class="tablelist" >
    	<thead>
    	<tr>
        
        <th>配置参数ID</th>
        <th>配置参数名称</th>
        
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
     
        <tr>
       
        <td>1</td>
        <td>启用</td>
       
        <td>
           
           <a href="updatecanshu.html" class="tablelink">修改|</a>
            <a href="javascript:void(0)" onclick="del()" class="tablelink">删除</a>
        </td>
       
        </tr> 
      
        <tr>
       
        <td>2</td>
        <td>禁用</td>
        
         <td>
           
           <a href="updatecanshu.html" class="tablelink">修改|</a>
            <a href="javascript:void(0)" onclick="del()" class="tablelink">删除</a>
        </td>
          </tr>
        </tbody>
    </table>
    
    <table class="tablelist2">
       <tr>
         <th><input name="" id="addcanshu"  type="button" class="scbtn1" value="添加参数"/>
              共2条记录
        	 当前：1/2页&nbsp;&nbsp;
          <a href="#">首页</a><a href="#">上一页</a><a href="#">下一页</a><a href="#">尾页</a>
         
         &nbsp;&nbsp;跳到:<input type="text" value="" onkeyup="value=value.replace(/[^\d]/g,'')" id="go" class="scinput5" />页 &nbsp;&nbsp;<input type="button" id="sure" class="scbtn5" value="确定"/> &nbsp;&nbsp; &nbsp;&nbsp;
         </th>
       </tr>
    </table>
	</div> 
    </div>
</body>

</html>
