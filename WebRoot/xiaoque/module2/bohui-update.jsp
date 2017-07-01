<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
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
	
	<link href="../../css/style.css" rel="stylesheet" type="text/css" />
	<link href="../../css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../../js/jquery.js"></script>
	<script type="text/javascript" src="../../js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="../../js/select-ui.min.js"></script>
	<script type="text/javascript" src="../../editor/kindeditor.js"></script>

	
	
	<script type="text/javascript">
	    KE.show({
	        id : 'content7',
	        cssPath : './index.css'
	    });
	</script>
  
	<script type="text/javascript">
	$(document).ready(function(e) {
	    $(".select1").uedSelect({
			width : 120		  
		});
	});
	</script>
	
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
				<li><a href="OrgTaskController/task.do">消缺任务管理</a></li>
				<li><a href="OrgTaskController/task.do">消缺任务执行与回执</a></li>
				<li><a href="#">回执录入</a></li>
			</ul>
		</div>
	
		<div class="content">
			
		    <div class="div_td">任务编号：</div>
			<div class="div_td2">RW0248</div> 
		    <div class="div_td">任务名称：</div>
			<div class="div_td2">西渭线消缺任务</div>
			<div class="div_td">任务状态</div>
			<div class="div_td2">
				
					已完成
				
			</div>
			<div class="div_td">工作单据：</div>
			<div class="div_td2">任务单</div>
			<div class="div_td">任务下发人：</div>
			<div class="div_td2">admin</div>
			<div class="div_td">任务下发时间：</div>
			<div class="div_td2">2013-12-12</div>
			<div class="div_td">任务负责人：</div>
			<div class="div_td2">管理员1</div>
			<div class="div_td">任务描述：</div>
			<div class="div_td2">完成西渭线消缺任务</div>
			<div class="div_td">消缺员：</div>
			<div class="div_td2">adasamin</div>
			<div class="div_td">任务完成时间：</div>
			<div class="div_td2">2013-12-23</div>
			<div class="div_td">完成情况描述：</div>
			<div class="div_td2"><textarea class="dfinput">已完成</textarea></div>
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
     
        <tr> 
		
         
         <td>XW0010</td>
         <td>XW0001</td>
         <td>拦河线断裂</td>
        
         <td>断裂严重</td>
         <td>2015-2-10</td>
         <td>检测人员1</td>
         <td>紧急  </td>
        </tr> 
      
	   
	   <tr> 
		
         
         <td>XW0010</td>
         <td>XW0001</td>
         <td>拦河线断裂</td>
        
         <td>断裂严重</td>
         <td>2015-2-10</td>
         <td>检测人员1</td>
         <td>紧急  </td>
        </tr> 
       

         <tr> 
		
         <td>XW0010</td>
         <td>XW0001</td>
         <td>拦河线断裂</td>
        
         <td>断裂严重</td>
         <td>2015-2-10</td>
         <td>检测人员1</td>
         <td>紧急  </td>
        </tr> 
        </tbody>
    </table>
		 <center>
		      <input id="backid" class="scbtn1" type="button" value="返回">
		 </center>
		<script type="text/javascript"> 
			$(function () {       
				$('#backid').click(function(){
					window.history.back();
				});
		    });
		</script>
	</body>
</html>
