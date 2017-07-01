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
    
    <title>My JSP 'ok.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link href="css/style.css" rel="stylesheet" type="text/css" />
 
<!-- <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>--> 
<script type="text/javascript" src="js/menu/add.js"></script> 
<script type="text/javascript">
function fanhui(){
	window.location.href="getAllMenus.action";
}

</script>
  </head>
  
  <body>
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>系统管理</li>
    <li>菜单管理</li>
    <li>增加菜单</li>
    </ul>
    </div>
    
<div class="formbody">
 <form action="addMenu.action" method="post" onsubmit="return CheckMyForm();">
    <div class="formtitle"><span>增加菜单</span></div>
    <ul class="forminfo">
    <table>
    	<tr><th>菜单名称</th><td><input class="dfinput" name="m_name"  type="text" id="mymname" onblur="CheckMname()" /></td><td><span id="imname">名称不能超过20个字符</span></td></tr>
    	<tr><th>父级菜单</th><td>
    	<select  class="dfinput" name="m_father" id="m_father">
    	<option value="0">无</option>
    	<c:forEach items="${mfather }" var="mf"> 
	        <option value="${mf.m_id}">${mf.m_name}</option>   
	    </c:forEach>
    	</select></td><td><span>  </span></td></tr>
    	<tr><th width="80px" height="30px">菜单路径</th><td><input class="dfinput" name="m_url" id="m_url"  onblur="CheckUrl()" type="text" /></td><td><span id="imurl"></span></td></tr>
    	<tr>
    	<th>菜单状态</th><td><input name="m_state" type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;
	<input name="m_state" type="radio" value="1" />禁用</td><td><span>  </span></td></tr>
	<tr><td colspan="3">
	<input type="submit" class="btn" value="确认保存"/>
	<input type="button" class="btn" onclick="fanhui()" value="返回"/>
	</td></tr>
    </table>
    </ul>
 </form> 
 </div>
 
  </body>
</html>
