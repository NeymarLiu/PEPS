<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://testTag/lxc" prefix="p" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title>消缺任务制定与分配</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	 <script type="text/javascript">
	 	$(function(){
	 		if($('#st').val()!=null){
	 			$('#stStatus').val($('#st').val());
	 		}
	 	
	 	});
	 
	 </script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="js/select-ui.min.js"></script>
	<script type="text/javascript" src="editor/kindeditor.js"></script>
	<script src="js/ace-extra.min.js"></script>
	<script src="js/xiaoque/module1/index.js"></script>  
	
	</head>
	<body class="sarchbody" style="background-color:#ffffff" >
	<input value="${mht.stStatus }" id="st" type="hidden">
	<input id="purl" type="hidden" value="moHuEdTask.action?stBid=${mht.stBid}&stStatus=${mht.stStatus}&stUser=${mht.stUser}&d1=${mht.d1}&d2=${mht.d2}">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>消缺任务管理</li>
				<li>消缺任务制定与分配</li>
			</ul>
		</div>
	    <div class="hr"></div>
			<div id="usual1">
			<form action="moHuEdTask.action" method="get" class="formbody">
			<table class="tablelist">
				<ul class="seachform1">
		    		<li><label>任务编号：</label>
		    			<input name="stBid" id="stBid" type="text" class="scinput1" value="${mht.stBid }"/>
		    		</li>
		    		<!-- <li><label>线路编号：</label><input name="lineId" id="taskId" type="text" class="scinput2" /></li> -->
					<li><label>任务状态：</label>  
						<div class="vocation">
							<select name="stStatus" id="stStatus" class="select3"  >
								<option value="0">--请选择--</option>
							    <option value="1">待分配</option>
							    <option value="2">已分配</option>
							    <option value="3">执行中</option>
							    <option value="4">已完成</option>
							</select>
						</div>
					</li>
					<li><label>下发人：</label>
						<input name="stUser" id="stUser" type="text" class="scinput1" value="${mht.stUser }"/>
					</li>
					<li><label>下发时间：</label><input readonly="readonly" name="d1" id="d1" type="text" class="scinput1" onclick="WdatePicker()"/> 
     										
     										  - 
											  <input readonly="readonly" name="d2" id="d2" type="text" class="scinput1" onclick="WdatePicker()"/> 
     										 
					</li>
					<li>
					<input type="submit" type="button" class="scbtn" value="查询"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="newNav" type="button" class="scbtn1" value="制定消缺任务"/>
					</li>
				</ul>
				</table>
				</form>
			</div>
			<div class="formbody">
				<center>
			    <table class="tablelist">
			    	<thead>
				    	<tr>
					      
					        <th style="text-align:center;">任务编号</th>
					        <th style="text-align:center;">任务名称</th>
					        <th style="text-align:center;">工作单据</th>
					        <th style="text-align:center;">下发人</th>
					        <th style="text-align:center;">下发时间</th>
					        <th style="text-align:center;">任务状态</th>
					        <th style="text-align:center;">任务完成时间</th>
					        <th style="text-align:center;">任务是否取消</th>
					        <th style="text-align:center;">操作</th>
				        </tr>
			        </thead>
			        <tbody>
						<c:forEach items="${edpList }" var="edp">
							<tr>
						   <td>${edp.e_task_id }</td>
						   <td>${edp.e_name }</td>
						   <c:if test="${edp.e_security_id==1 }"><td>第一种单据</td></c:if>
						   <c:if test="${edp.e_security_id==2 }"><td>第二种单据</td></c:if>
						   <td>${edp.e_issued_name }</td>
						   <td>${edp.issued_time }</td>
						   <c:if test="${edp.e_task_state==1 }"><td>待分配</td></c:if>
						   <c:if test="${edp.e_task_state==2 }"><td>已分配</td></c:if>
						   <c:if test="${edp.e_task_state==3 }"><td>执行中</td></c:if>
						   <c:if test="${edp.e_task_state==4 }"><td>已完成</td></c:if>
						   <td>${edp.task_finish_time }</td>
						   <c:if test="${edp.e_task_cancel_state==1 }"><td>是</td></c:if>
						   <c:if test="${edp.e_task_cancel_state==2 }"><td>否</td></c:if>
					   	   <c:if test="${edp.e_task_state==1 and edp.e_task_cancel_state==2 }">
						     	<td>
						       		<a href="toLookEdTask.action?id=${edp.e_id }" class="tablelink">查看</a>  |
							   		<a href="shareTask.action?id=${edp.e_id }"  class="tablelink">分配任务</a>  |
							   		<a href="toUpdateEdTask.action?id=${edp.e_id }" class="tablelink">修改</a>  |
							   		<a href="deleteTask.action" class="tablelink">取消</a>  |
						     	</td>
						   </c:if>
							<c:if test="${edp.e_task_state==2||edp.e_task_state==3||edp.e_task_state==4 || edp.e_task_cancel_state==1}">
							   <td>
							    <a href="toLookEdTask.action?id=${edp.e_id }" class="tablelink">查看</a>  |
								分配任务  |
								修改  |
								 取消  |
							   </td>
							</c:if>
						</tr>
						</c:forEach>

			        </tbody>
			    </table>
			    </center>
			  </div> 
			   <table class="tablelist2">
       <tr>
         <th><p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="moHuEdTask.action?stBid=${mht.stBid}&stStatus=${mht.stStatus}&stUser=${mht.stUser}&d1=${mht.d1}&d2=${mht.d2}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>

	</body>
</html>
