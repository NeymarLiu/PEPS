<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
int i=0;
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
    <script type="text/javascript" src="js/xunjian/module1/add.js"></script>
    
</head>
<body onload="checkState('${mark}')">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>巡检任务管理</li>
    <li>巡检任务制定与分配 </li>
    <li>制定巡检任务</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <form action="addPatrolTask.action" method="post" onsubmit="return reCheck()">
    <li><label>任务编号</label><input id="p_num" name="p_num" type="text" class="dfinput" value="${rwid}" readonly="readonly"/></li>
    <li><label>任务名称</label><input name="p_name" id="p_name" type="text" class="dfinput"  onkeyup="checkPname()"/><span id="spna" style="display: inline-block;"></span></li>
    <li><label>巡检线路</label><div >
      <select class="dfinput" name="p_lid" id="selectLine" onclick="checkLine()">
      <option value="-1">-请选择线路-</option>
      <c:forEach items="${lineList}" var="line">
      	 <option value="${line.li_id}">${line.li_name}</option>
      </c:forEach>
     </select><span id="spli" style="display: inline-block;"></span>
     </div></li>
     <li><label>巡检员</label>
     	<c:forEach items="${patrolList}" var="patrol" >
     		<input type="checkbox" name="u_id" value="${patrol.u_id}">${patrol.u_realname}
     		<%i++; 
     			if(i%3==0){%>
     			<br/>
     			<%}
     		%>
     	</c:forEach>
     </li>
    <li><label>起始杆号</label>
    <select class="dfinput" id="p_strnum" name="p_strnum" onclick="checkStrpole()">
    </select><span id="spsp" style="display: inline-block;"></span>
    	</li>
    <li><label>终止杆号</label> <select class="dfinput" id="p_endnum" name="p_endnum" onclick="checkEndpole()">
    </select><span id="spep" style="display: inline-block;"></span></li>
    <li><label>下发人</label><input  name="p_issued_name" type="text" onlyread="onlyread" value="${sessionScope.loginUser.u_realname}" readonly="readonly" /></li>
    <li><label>下发日期</label><input id="p_issued_time" name="p_issued_time" type="text" onlyread="onlyread" value="" /></li>
    <li><label>备注</label><textarea class="dfinput" name="p_remark"></textarea>
    <li><label>&nbsp;</label>
      <input  type="submit" class="btn" value="保存"/>
      <input id="backbtn" type="button" class="btn" value="返回"/></li>
    </form>
    </ul>
    
    </div>


</body>

</html>