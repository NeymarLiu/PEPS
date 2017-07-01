<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://testTag/lxc" prefix="p" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>无标题文档</title>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
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
<script type="text/javascript" src="js/xunjian/module1/index.js"></script>
</head>

<body class="sarchbody" >
	<input id="pstate" type="hidden" value="${fptp.p_state}">
 	<input id="purl" type="hidden" value="getAllPatrol.action?p_num=${fptp.p_num}&p_state=${fptp.p_state}">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>巡检任务管理</li>
    <li>巡检任务制定与分配</li>
    </ul>
    </div>
    <div class="formbody">
    <div id="usual1" class="usual"> 
    
    <ul class="seachform1">
    <form action="getAllPatrol.action" method="post">
    <li><label>任务编号</label><input name="p_num" type="text" class="scinput1" value="${fptp.p_num}"/></li>
    <li><label>任务状态</label>  
    <div class="vocation">
    <select class="select3" id="p_state" name="p_state">
           <option  value="-1" >-请选择-</option>
	       <option  value="1"  >未分配</option>
	       <option  value="2"  >已分配</option>
	       <option  value="3"  >执行中</option>
	       <option  value="4"  >已完成</option>
    </select>
    </div>
    </li>
  <li><input  type="submit" class="scbtn" value="查询"/>&nbsp;
  </form>
  <input id="add"  type="button" class="scbtn1" value="制定巡检任务"></li>
    </ul>
  
    <table class="tablelist" >
    	<thead>
    	<tr>
        <th>任务编号</th>
        <th>任务名称</th>
        <th>巡检线路</th>
        <th>起始杆号</th>
        <th>终止杆号</th>
        <th>下发人</th>
         <th>下发时间</th>
         <th>任务状态</th>
          <th>任务完成时间</th>
          <th>任务是否取消</th>
           <th>操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="ptask" items="${ptaskList}">
    
         <tr>
        <td>${ptask.p_num}</td>
        <td>${ptask.p_name}</td>
        <td>${ptask.line.li_name}</td>
        <td>${ptask.strPojo.pole_code}</td>
        <td>${ptask.endPojo.pole_code}</td>
        <td>${ptask.p_issued_name }</td>
        <td>${ptask.issued_time }</td>
        <td>${ptask.p_state==1?"待分配":ptask.p_state==2?"已分配":ptask.p_state==3?"执行中":ptask.p_state==4?"已完成":"已确认"}</td>
        <td>${ptask.finish_time}</td>
        <td>${ptask.p_state==0?"是":"否"}</td>
       <c:if test="${ptask.p_state==1}">
        <td><a href="lookPTask.action?pid=${ptask.p_id}" class="tablelink">查看</a>  |   
            <a href="toAssignTask.action?p_id=${ptask.p_id}" class="tablelink" > 分配任务</a> |
            <a href="toUpdatePTask.action?pid=${ptask.p_id }" class="tablelink" > 修改</a>  |
            <a href="javascript:void(0)" onclick="cancle('${ptask.p_id}')" class="tablelink" > 取消</a>
         </td>
       </c:if>
        <c:if test="${ptask.p_state==2}">
        <td><a href="lookPTask.action?pid=${ptask.p_id}" class="tablelink">查看</a>  |   
          	  分配任务 |
           	  修改 |
            <a href="javascript:void(0)" onclick="cancle('${ptask.p_id}')" class="tablelink" > 取消</a>
         </td>
       </c:if>
       <c:if test="${ptask.p_state==3 || ptask.p_state==4 || ptask.p_state==5}">
        <td><a href="lookPTask.action?pid=${ptask.p_id}" class="tablelink">查看</a>  |   
          	  分配任务 |
           	  修改 |
           	  取消
         </td>
       </c:if>
        </tr>
         
    </c:forEach>
     
        </tbody>
    </table>
    <table class="tablelist2">
       <tr>
         <th><p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllPatrol.action?p_num=${fptp.p_num}&p_state=${fptp.p_state}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
      
	</div> 
    </div>
</body>

</html>
