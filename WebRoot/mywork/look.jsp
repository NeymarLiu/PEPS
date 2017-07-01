<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

  <head>
	<title>无标题文档</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link href="css/style.css" rel="stylesheet" type="text/css" />
	  <style>
	     td{
		   font-size:20px;
		   
		 }
	  </style>
</head>

<body>


	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>我的工作平台</li>
    <li>代办列表</li>
    <li>查看</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo"></ul>
      <form action="patcolTask.action" method="post" >
      	 <table width="60%" height="80%">
		    <tr><td align="center">任务编号:</td><td>${mt.p_num }</td></tr>
		    <tr><td align="center">任务名称:</td><td>${mt.p_name}</td></tr>
		    <tr><td align="center">巡检线路:</td><td>${mt.li_name}</td></tr>
		    <tr><td align="center">起始杆号:</td><td>${mt.p_strcode}</td></tr>
		    <tr><td align="center">终止杆号:</td><td>${mt.p_endcode}</td></tr>
		    <tr><td align="center">下发人:</td><td>${mt.p_issued_name}</td></tr>
		    <tr><td align="center">下发时间:</td><td>${mt.issude_time}</td></tr>
		    <tr><td align="center">备注信息:</td><td>${mt.p_remark}</td></tr>
			<td colspan="2"align="right"> <input type="submit" value="返回"  class="scbtn" id="backid"></td>
		</table>
      </form>
  
   
    </div>

   
</body>

</html>
