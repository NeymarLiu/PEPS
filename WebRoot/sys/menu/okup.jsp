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
 <!--
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script> -->
<script type="text/javascript" src="js/menu/update.js"></script>
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
    <li>修改菜单</li>
    </ul>
    </div>
    
<div class="formbody">
<div class="formtitle"><span>修改菜单</span></div>
   
 <form action="updateMenu.action" method="post" onsubmit="return CheckMyForm();">
     <input type="hidden" value="${menu.m_id }" name="m_id" id="mid"/>
    <table>
    	<tr><th>菜单名称</th><td><input name="m_name" value="${menu.m_name }" class="dfinput" type="text" id="mymname" onblur="CheckMname()" /></td><td><span id="imname">名称不能超过20个字符</span></td></tr>
    	<tr><th>父级菜单</th><td>
    	<select class="dfinput" name="m_father" id="m_father">
    	<option value="0">无</option>
    	<c:forEach items="${mfather }" var="mf"> 
        <c:if test="${mf.m_id==menu.m_father }">
        <option selected="selected" value="${mf.m_id}">${mf.m_name}</option>
        </c:if>  	
	    <c:if test="${mf.m_id!=menu.m_id }">
        <option value="${mf.m_id}">${mf.m_name}</option>
        </c:if> 	    
    </c:forEach>
    	</select></td><td><span>  </span></td></tr>
    	<tr><th width="80px" height="30px">菜单路径</th><td><input value="${menu.m_url }"  name="m_url" class="dfinput" id="m_url"  onblur="CheckUrl()" type="text" /></td><td><span id="imurl"></span></td></tr>
    	<tr>
    	<th>菜单状态</th><td><c:if test="${menu.m_state==0 }">
		<input name="m_state" type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;
		<input name="m_state" type="radio" value="1" />禁用    
		</c:if>
		<c:if test="${menu.m_state==1 }">
		<input name="m_state" type="radio" value="0" />启用&nbsp;&nbsp;&nbsp;&nbsp;
		<input name="m_state" type="radio" value="1"  checked="checked" />禁用    
		</c:if></td><td><span>  </span></td></tr>
	<tr><td colspan="3">
	<input type="submit" class="btn" value="确认保存"/>
	<input type="button" class="btn" onclick="fanhui()" value="返回"/>
	</td></tr>
    </table>
   
 </form> 
 </div>
 
  </body>
</html>
