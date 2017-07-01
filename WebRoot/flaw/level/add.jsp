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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link href="../../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>缺陷管理</li>
    <li>缺陷类型设置</li>
    <li>增加缺陷类型</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <form action="index.html" method="post" >
    <input type="hidden" name="creatPerson" value="${sessionScope.user }"/>
    <li><label>缺陷类型名称</label><input name="code" type="text" class="dfinput" /></li>
    
    <li><label>启用状态</label><cite><input name="state" type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;<input name="state" type="radio" value="1" />禁用</cite></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </form>
    </ul>
    
    </div>


</body>

</html>
