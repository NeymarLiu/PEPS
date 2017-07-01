<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
int i=0;
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>制定消缺任务</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="js/select-ui.min.js"></script>
	<script type="text/javascript" src="editor/kindeditor.js"></script>
	<script type="text/javascript" src="js/xiaoque/module2/look.js"></script>

	
	
	
	<style>
	.content { width:1050px;
			   height:500px;
	}
	.div_td { width:100px;
			  height:36px;
			  float:left;
			  text-align:center;
			  line-height:36px;
			  background:url(images/itabbg.png) repeat-x;
	}
	.div_td2 { width:940px;
			  height:36px;
			  padding-left:10px;
			  float:left;
			  line-height:36px;
			  border-bottom:1px #eac998 solid;
	}
	</style>
	</head>
	
	<body class="sarchbody" >
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>消缺任务管理</li>
				<li>消缺任务执行与回执</li>
				<li>查看消缺任务</li>
			</ul>
		</div>
		
		<div class="content">
			
		    <div class="div_td">任务编号：</div>
			<div class="div_td2">${edp.e_task_id }</div>
		    <div class="div_td">任务名称：</div>
			<div class="div_td2">${edp.e_name }</div>
			<div class="div_td">任务状态</div>
		    <c:if test="${edp.e_task_state==2 }"><div class="div_td2">已分配</div></c:if>
		    <c:if test="${edp.e_task_state==3 }"><div class="div_td2">执行中</div></c:if>
		    <c:if test="${edp.e_task_state==4 }"><div class="div_td2">已完成</div></c:if>
			<div class="div_td">工作单据：</div>
			<c:if test="${edp.e_security_id==1 }"><div class="div_td2">第一种单据</div></c:if>
			<c:if test="${edp.e_security_id==2 }"><div class="div_td2">第二种单据</div></c:if>
			<div class="div_td">任务下发人：</div>
			<div class="div_td2">${edp.e_issued_name }</div>
			<div class="div_td">任务下发时间：</div>
			<div class="div_td2">${edp.issued_time }</div>
			<div class="div_td">任务负责人：</div>
			<div class="div_td2">${edp.e_task_principal }</div>
			<div class="div_td">任务描述：</div>
			<div class="div_td2">${edp.e_task_described }</div>
			<div class="div_td">消缺员：</div>
			
			<div class="div_td2">
				<c:forEach items="${upList }" var="up">
		          	${up.u_realname}&nbsp;
		        </c:forEach>
	    	</div>
	    	
			<div class="div_td">任务完成时间：</div>
			<div class="div_td2">${edp.task_finish_time }</div>
			<div class="div_td">完成情况描述：</div>
			<div class="div_td2">${edp.e_final_described }</div>
			
		 </div>	
		
		 <br/>
		 <div class="place">
     缺陷列表:
   
    </div>
<table class="tablelist" >
    	<thead>
	    	<tr>
		        <th>线路编号</th>
		        <th>塔杆编号</th>
		        <th>缺陷类型</th>
		        <th>缺陷描述</th>
		        <th>发现时间</th>
		        <th>发现人员</th>
		        <th>缺陷级别</th>
	        </tr>
        </thead>
        <tbody>
	        <c:forEach items="${etpList }" var="etp">
	     		<tr> 
				 <td>${etp.li_code }</td>
		         <td>${etp.pole_code }</td>
		         <td>${etp.f_name }</td>
		         <td>${etp.pf_remark }</td>
		         <td>${etp.find_time }</td>
		         <td>${etp.pf_find_people }</td>
		         <c:if test="${etp.pf_sure_grade==1 }"><td>一般</td></c:if>
				 <c:if test="${etp.pf_sure_grade==2 }"><td>严重</td></c:if>
				 <c:if test="${etp.pf_sure_grade==3 }"><td>紧急</td></c:if>
	        	</tr> 
	     	</c:forEach>
        </tbody>
    </table>
		 <center>
		      <input id="backid" class="scbtn1" type="button" value="返回">
		 </center>
	</body>
</html>
