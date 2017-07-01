<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<title>无标题文档</title>
	<meta http-equiv="pragma" content="no-cache">
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
 
 <style type="text/css">
    .f1{
    font-size:16px;
    padding-left:15px
    
    }
    
    .h1{
       font-size:18px;
       padding-left:0px
      
    }
 </style>
 <script type="text/javascript" src="js/xunjian/module1/share.js"></script>
</head>

<body class="sarchbody" onload="getMark(${mark})">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">巡检任务管理</a></li>
    <li><a href="#">分配巡检任务</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    <div id="usual1" class="usual"> 
    <form class="f1" name="form2" action="updataAssignTask.action?p_id=${p_id}" method="post" onsubmit="return getCount()">
     <table class="tablelist3"><tr><td>
    <ul class="seachform1">
    <li>
    <div class="vocation">
    </div>
    </li>   
   <li> <input  type="submit" class="scbtn1" value="保存"/> </li>
    </ul>
	</div> 
    </div>
</td></tr>

<tr><td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
	<p class="h1">分配人员:</p>
	<c:forEach items="${puList }" var="pUser">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="u_id"  value="${pUser.u_id}"/>${pUser.u_realname }<br/>
	</c:forEach>
	</td>
    </tr>
  </table>  
  </form>
    
</body>

</html>