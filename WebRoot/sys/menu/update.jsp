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
<script type="text/javascript" src="js/menu/update.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>系统管理</li>
    <li>角色管理</li>
    <li>添加角色</li>
    </ul>
    </div>
    
    <form action="updateMenu.action" method="post" onsubmit="return CheckMyForm();">
    <input type="hidden" value="${menu.m_id }" name="m_id" id="mid"/>
     <div class="formbody">
    <div class="formtitle"><span>增加菜单</span></div>
   
    <ul class="forminfo">
    
    
    <li><label>菜单名称</label><input name="m_name" id="mname" type="text" class="dfinput" value="${menu.m_name }" onblur="CheckMname()"/><i id="imname"> 名称不能超过20个字符</i></li>
    <li><label>父级菜单</label><div >
    <select  class="dfinput" name="m_father">
    	<option value="0">无</option>
    <c:forEach items="${mfather }" var="mf"> 
        <c:if test="${mf.m_id==menu.m_father }">
        <option selected="selected" value="${mf.m_id}">${mf.m_name}</option>
        </c:if>  	
	    <c:if test="${mf.m_id!=menu.m_id }">
        <option value="${mf.m_id}">${mf.m_name}</option>
        </c:if> 	    
    </c:forEach>	    
    </select>
     </div></li>
    	<li><label>菜单路径</label><input name="m_url" id="m_url" type="text" class="dfinput" value="${menu.m_url }" onblur="CheckUrl()"/><i id="imurl"></i></li>
		<li><label>菜单状态</label><cite>
		<c:if test="${menu.m_state==0 }">
		<input name="m_state" type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;
		<input name="m_state" type="radio" value="1" />禁用    
		</c:if>
		<c:if test="${menu.m_state==1 }">
		<input name="m_state" type="radio" value="0" />启用&nbsp;&nbsp;&nbsp;&nbsp;
		<input name="m_state" type="radio" value="1"  checked="checked" />禁用    
		</c:if>
		</cite>
		</li>
		<li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
   
    </ul>
    
    
    </div>

 </form>
</body>

</html>
