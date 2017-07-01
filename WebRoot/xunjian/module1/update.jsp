<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script type="text/javascript" src="js/xunjian/module1/update.js"></script>
</head>
<body onload="checkState('${mark}')">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>巡检任务管理</li>
    <li>巡检任务制定与分配</li>
    <li>修改巡检任务</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <form action="updatePTask.action" method="post" onsubmit="return reCheck()">
   	<input name="p_id" value="${pTask.p_id}" type="hidden">
    <li><label>任务编号</label><input  type="text" readonly="readonly" class="dfinput" value="${pTask.p_num}"/></li>
    <li><label>任务名称</label><input name="p_name" id="p_name" type="text" class="dfinput" value="${pTask.p_name}" onkeyup="checkPname()"/><span id="spna" style="display: inline-block;"></span></li>
    <li><label>巡检线路</label><div>
      <select class="dfinput" name="p_lid" id="selectLine" onclick="checkLine()">
	<c:forEach items="${lineList}" var="line">
      	 <c:if test="${line.li_id==pTask.p_lid}">
      	 <option value="${line.li_id}" selected="selected">${line.li_name}</option>
      	 </c:if>
      	 <c:if test="${line.li_id!=pTask.p_lid }">
      	 <option value="${line.li_id}">${line.li_name}</option>
      	 </c:if>
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
     	</c:forEach><span id="sppp" style="display: inline-block;">
    <li><label>起始杆号</label>
  	  <select class="dfinput" id="p_strnum" name="p_strnum" onclick="checkStrpole()">
    	<c:forEach items="${poles}" var="pole">
      	 <c:if test="${pole.pole_id==pTask.strPojo.pole_id}">
      	 <option value="${pole.pole_id}" selected="selected">${pole.pole_code}</option>
      	 </c:if>
      	 <c:if test="${pole.pole_id!=pTask.strPojo.pole_id}">
     	<option value="${pole.pole_id}" >${pole.pole_code}</option>
      	 </c:if>
      </c:forEach>
      </select><span id="spsp" style="display: inline-block;"></span>
    
    </li>
    <li><label>终止杆号</label>
   <select class="dfinput" id="p_endnum" name="p_endnum" onclick="checkEndpole()">
    	<c:forEach items="${poles}" var="pole">
      	 <c:if test="${pole.pole_id==pTask.endPojo.pole_id}">
      	 <option value="${pole.pole_id}" selected="selected">${pole.pole_code}</option>
      	 </c:if>
      	 <c:if test="${pole.pole_id > pTask.strPojo.pole_id}">
     	<option value="${pole.pole_id}" >${pole.pole_code}</option>
      	 </c:if>
      </c:forEach>
      </select><span id="spep" style="display: inline-block;"></span>
    </li>
    <li><label>下发人</label><input   type="text" onlyread="onlyread" value="${pTask.p_issued_name }" /></li>
    <li><label>下发日期</label><input  type="text" onlyread="onlyread" value="${pTask.issued_time }" /></li>
    <li><label>备注</label><textarea name="p_remark" class="dfinput">${pTask.p_remark}</textarea>
    <li><label>&nbsp;</label><input  type="submit" class="btn" value="保存"/>
      <input id="backbtn" type="button" class="btn" value="返回"/></li>
    </form>
    </ul>
    
    
    </div>


</body>

</html>
