<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
      <link href="../../css/style.css" rel="stylesheet" type="text/css" />
	  <style>
	     label{
              color:red;
              
             }
   td{
      font-size:15px  
        }
		 div{
      font-size:15px  
        }
	  </style>
</head>
<script type="text/javascript" src="js/xunjian/module2/look.js"></script>
<body onload="initFlaw('${pTask.pfpList[0].pf_id}')">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>巡检任务管理</li>
    <li>巡检任务执行与回执</li>
    <li>查看巡检任务</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <form action="index.html" method="post" >
  <table class="tablelist">
        <tr>
         <td colspan="3" align="left">
     <label>任务编号:</label>&nbsp;&nbsp;${pTask.p_num} &nbsp;&nbsp; <label>任务名称:&nbsp;&nbsp;</label>${pTask.p_name} &nbsp;&nbsp; <label>巡检线路:&nbsp;&nbsp;</label>${pTask.line.li_name} &nbsp;&nbsp;  <label>起始杆号:&nbsp;&nbsp;</label>${pTask.strPojo.pole_code}&nbsp;&nbsp;<br/>
           &nbsp; <label>终止杆号:&nbsp;&nbsp;</label>${pTask.endPojo.pole_code} &nbsp;&nbsp;<label>下发时间:&nbsp;&nbsp;</label>${pTask.issued_time } &nbsp;&nbsp; <label>任务状态:&nbsp;&nbsp;</label>${pTask.p_state==1?"待分配":pTask.p_state==2?"已分配":pTask.p_state==3?"执行中":"已完成"} &nbsp;&nbsp;<label>任务完成时间:&nbsp;&nbsp;</label>${pTask.finish_time} &nbsp;&nbsp;<br/>
          &nbsp;  <label>备注:&nbsp;&nbsp;</label>${pTask.p_remark}<br/>
          &nbsp;  <label>巡检员:&nbsp;&nbsp;</label>
          <c:forEach items="${pTask.pupList}" var="pup">
          	${pup.u_realname}&nbsp;
          </c:forEach>
         </td>
        </tr>
        <tr><td colspan="3"></td></tr>
        <tr>
             <td> ${pTask.line.li_name}
                <ol class="forminfo">
                <c:forEach items="${pTask.pfpList }" var="pfp">
               		 <li><a href="javascript:void(0)" onclick="selectPole('${pfp.pf_id}')" class="tablelink">${pfp.pole_code}</a></li>
                </c:forEach>
                 </ol>
             </td>
             
             <td colspan="2" align="left">
               <div id="div">
                 <div> <label>线路编码:</label>${pTask.line.li_code }  &nbsp;&nbsp;&nbsp;&nbsp;  <label>塔杆编码:</label><span id="sppc" style="display: inline-block;">${pTask.pfpList[0].pole_code }</span> </div>     
                 <div>  <label>完好率:</label><span id="spfr" style="display: inline-block;"><c:if test="${pTask.pfpList[0].pf_flaw_rate==0}"></c:if>
                 							<c:if test="${pTask.pfpList[0].pf_flaw_rate!=0}">${pTask.pfpList[0].pf_flaw_rate}%</c:if></span> </div>
                 <div> <label>缺陷类型:</label><span id="flaw" style="display: inline-block;"></span>&nbsp;&nbsp;&nbsp;&nbsp;   <label>缺陷级别:</label><span id="spit" style="display: inline-block;">${pTask.pfpList[0].pf_flaw_grade==1?"一般":pTask.pfpList[0].pf_flaw_grade==2?"严重":pTask.pfpList[0].pf_flaw_grade==3?"紧急":""}</span>  </div>
                 <div> <label>缺陷描述:</label><span id="remark" style="display: inline-block;">${pTask.pfpList[0].pf_remark} </span>    </div>
                 <div> <label>巡检时间:</label>${pTask.start_time==null?"尚未开始巡检":pTask.start_time}                                </div>
                 <div> <label>巡检员:</label>
                 <c:forEach items="${pTask.pupList}" var="pup">
          			${pup.u_realname}&nbsp;
         		 </c:forEach></div>
                 <div> <label>缺陷发现人:</label><span id="spfp" style="display: inline-block;">${pTask.pfpList[0].pf_find_people}</span>  &nbsp;&nbsp;&nbsp;&nbsp; <label>发现时间:</label><span id="spft" style="display: inline-block;">${pTask.pfpList[0].find_time}</span> </div>
                 <div> <label>下发人员:</label>${pTask.p_issued_name } &nbsp;&nbsp;&nbsp;&nbsp; <label>下发时间:</label>${pTask.issued_time }</div>
                </div>
              </td>
        </tr>  
   <tr><td colspan="3"><input type="button" value="返回" id="bckbt" class="scbtn"></td></tr>
	
<table>
   
    </form>
    </ul>
    
    
    </div>


</body>
       <font style="color:red" >*巡检时间:若未开始执行巡检任务,则显示尚未巡检</font><br/>
       <font style="color:red">*点击左边的杆塔好,右侧显示对应的详细信息</font>
</html>
