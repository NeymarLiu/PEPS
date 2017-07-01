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
     	 <link href="css/style.css" rel="stylesheet" type="text/css" />
      	<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript" src="js/role/add.js"></script>
</head>
<script type="text/javascript">
function fanhui(){
	window.location.href="getAllRoles.action";
}

</script>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>系统管理</li>
    <li>角色管理</li>
    <li>添加角色</li>
    </ul>
    </div>    
    <div class="formbody">    
    <div class="formtitle"><span>基本信息</span></div>   
    <ul class="forminfo">
    <li>
    <form action="addRole.action" method="post" onsubmit="return CheckTest();">
    <input type="hidden" name="r_creatname" value="${loginUser.u_realname }"/>
     <input type="hidden" name="r_number" value="${rolenumber }"/>
    <ul>
    <li><label>角色编号</label><input type="text" class="dfinput" value="${rolenumber }" disabled="disabled"/><i>编号不能超过20个字符</i></li>
    <li><label>角色名称</label><input name="r_name" id="name" type="text" class="dfinput" onblur="CheckName()"/><i id="irname">名称不能超过20个字符</i></li>
    <li><label>启用状态</label><cite><input name="r_state" type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;<input name="r_state" type="radio" value="1" />禁用</cite></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/>
    <input type="button" class="btn" onclick="fanhui()" value="返回"/></li>
    </ul></form>
    </li>    
    </ul>
   </div>
</body>

</html>
