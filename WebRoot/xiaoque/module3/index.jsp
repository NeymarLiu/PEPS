<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript" src="js/xiaoque/module3/index.js"></script>




</head>
<body class="sarchbody" >
<input type="hidden" id="nowPage" value="${page.nowPage }">
<input type="hidden" id="count" value="${page.count }">
<input id="purl" type="hidden" value="selectAllEdTaskDetail.action?stBid=${mht.stBid}&f_id=${mht.f_id}">
	<div class="place">
    	<span>位置：</span>
	    <ul class="placeul">
	    	<li>消缺任务管理</li>
	    	<li>消缺查询</li>
	    </ul>
    </div>
    <div class="formbody">
    <div id="usual1" class="usual"> 
    	<ul class="seachform1">
    	<form action="selectAllEdTaskDetail.action" method="post">
	    	<li><label>任务编号</label><input id="stBid" name="stBid" id="stBid" type="text" class="scinput1" value=""/></li>
	    	<li><label>缺陷类型</label>  
	    		<div class="vocation">
	    			<select class="select3" name="f_id"  id="f_id">
	                	<option  value="0" selected="selected" >-请选择-</option>
		       			<c:forEach items="${fpList }" var="fp">
							<option value="${fp.f_id}">${fp.f_name }</option>		       			
		       			</c:forEach>
	    			</select>
	    		</div>
	    	</li>
	  		<li><input  type="submit" class="scbtn" value="查询"/>&nbsp;
 		</form>
  			<input  type="button" class="scbtn" value="导出EXCEL" id="export"/>&nbsp;
    	</ul>
    <table class="tablelist" >
    	<thead>
	    	<tr>
		        <th>任务编号</th>
		        <th>任务状态</th>
				<th>工作单据</th>
				<th>线路编号</th>
		        <th>杆塔编号</th>
		        <th>缺陷级别</th>
		        <th>缺陷类型</th>
		        <th>发现人</th>
		        <th>发现时间</th>
		        <th>下发人</th>
		        <th>下发时间</th>
		        <th>完好率</th>
		        <th>缺陷描述</th>
	        </tr>
        </thead>
     	<tbody>
	        <c:forEach items="${etpList }" var="etp">
				<tr>
			        <td>${etp.e_task_id }</td>
			        <c:if test="${etp.e_task_state==2 }"><td>已分配</td></c:if>
					<c:if test="${etp.e_task_state==3 }"><td>执行中</td></c:if>
					<c:if test="${etp.e_task_state==4 }"><td>已完成</td></c:if>
			        <c:if test="${etp.e_security_id==1 }"><td>第一种单据</td></c:if>
			        <c:if test="${etp.e_security_id==2 }"><td>第二种单据</td></c:if>
					<td>${etp.li_code }</td>
					<td>${etp.pole_code }</td>
					<c:if test="${etp.pf_sure_grade==1 }"><td>一般</td></c:if>
					<c:if test="${etp.pf_sure_grade==2 }"><td>严重</td></c:if>
					<c:if test="${etp.pf_sure_grade==3 }"><td>紧急</td></c:if>
			        <td>${etp.f_name }</td>
			        <td>${etp.pf_find_people }</td>
			        <td>${etp.find_time }</td>
			        <td>${etp.e_issued_name }</td>
			        <td>${etp.issued_time }</td>
			        <td>${etp.pf_flaw_rate }%</td>
			        <td>${etp.pf_remark }</td>
	        	</tr> 	        
	        </c:forEach>
        </tbody>
    </table>
    <table class="tablelist2">
       <tr>
         <th><p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="selectAllEdTaskDetail.action?stBid=${mht.stBid}&f_id=${mht.f_id }" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
      
	</div> 
    </div>
</body>

</html>
