<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<script type="text/javascript" src="js/role/update.js"></script>
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
    <li>修改角色</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <ul class="forminfo">
    <li>
    <form action="updateRole.action" method="post" id="fromone" onsubmit="return testone();">
    <input name="r_id" id="r_id" type="hidden" value="${role.r_id}"/>
    <input name="r_number" type="hidden" value="${role.r_number}"/>
   <ul>
   <li><label>角色编号</label><input  value="${role.r_number }" type="text" class="dfinput" disabled="disabled" /><i>编号不能超过20个字符</i></li>
    <li><label>角色名称</label><input name="r_name" id="rname" value="${role.r_name }" type="text" class="dfinput" onblur="CheckName()"/><i id="irname">名称不能超过20个字符</i></li>
    
       <li><label>启用状态</label><cite>
       <c:if test="${role.r_state==0 }"> 
       <input name="r_state" type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;
       <input name="r_state" type="radio" value="1" />禁用
       </c:if>
       <c:if test="${role.r_state==1 }"> 
       <input name="r_state" type="radio" value="0"  />启用&nbsp;&nbsp;&nbsp;&nbsp;
       <input name="r_state" type="radio" value="1" checked="checked"/>禁用
       </c:if>
       </cite></li>     
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/>
    <input type="button" class="btn" onclick="fanhui()" value="返回"/></li>   
   </ul>
     </form>
    </li>    
    </ul>
    </div>
</body>

</html>
