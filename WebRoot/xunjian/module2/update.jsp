<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <script type="text/javascript" src="js/jquery.js"></script>
      <link href="css/style.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript" src="js/xunjian/module2/update.js"></script>
</head>
<body>
<input value="${pTask.pfpList[0].pf_id}" type="hidden" name="pf_id" id="pf_id">
	<input value="${pTask.p_id}" type="hidden" name="p_id" id="p_id">
	<input type="hidden" id="flaw_grade" value="${pTask.pfpList[0].pf_flaw_grade}">
	<input type="hidden" id="pfflaw" value="${pTask.pfpList[0].pf_flaw}">
	<input type="hidden" id="find_time" value="${pTask.pfpList[0].find_time}">
	<input type="hidden" id="find_lpeople" value="${sessionScope.loginUser.u_realname}">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>巡检任务管理</li>
    <li>巡检任务制定与分配</li>
    <li>修改巡检任务</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>回执录入</span></div>

	   <ul class="forminfo">
    <form action="index.html" method="post" >
   <table class="tablelist">
   
        <tr>
             <td> ${pTask.line.li_name} 
                <ol class="forminfo">
                <c:forEach items="${pTask.pfpList }" var="pfp">
               		 <li><a href="javascript:void(0)" onclick="selectPole('${pfp.pf_id}')" class="tablelink">${pfp.pole_code}</a></li>
                </c:forEach>
                 </ol>
             </td>
            <td colspan="2" align="left">
              <ul class="forminfo">
					
	
					<li><label>线路编号</label>${pTask.line.li_code }</li>
					<li><label>杆塔编号</label><input name="pf_pole" id="pf_pole_code" class="dfinput" value="${pTask.pfpList[0].pole_code }" readonly="readonly"> </li>
					<li><label>缺陷类型</label><div >
                        <select  class="dfinput" name="pf_flaw" id="pf_flaw" onclick="checkFlaw()">
                        <option value="-1">--请选择--</option>
                        <c:forEach items="${flawList }" var="flaw">
                        <option value="${flaw.f_id }">${flaw.f_name }
                        </c:forEach>
                        </select><span id="spfl" style="display: inline-block;"></span>
                        </div></li>
                    <li><label>缺陷级别</label><div >
                        <select  class="dfinput" name="pf_flaw_grade" id="pf_flaw_grade" onclick="checkFlawGrade()"><option value="-1">--请选择--</option>
                        <option value="1">一般</option>
                        <option value="2">严重</option>
                        <option value="3">紧急</option>
                        </select><span id="spfg" style="display: inline-block;"></span>
                        </div></li>
					<li><label>完好率</label><c:if test="${pTask.pfpList[0].pf_flaw_rate==0}"><input class="dfinput" type="text" name="pf_flaw_rate" id="pf_flaw_rate" onkeyup="checkRate()"> </c:if>
                 							<c:if test="${pTask.pfpList[0].pf_flaw_rate!=0}"><input class="dfinput" type="text" name="pf_flaw_rate" id="pf_flaw_rate" value="${pTask.pfpList[0].pf_flaw_rate}" onkeyup="checkRate()"> %</c:if><span id="spra" style="display: inline-block;"></span></li>
					<li><label>发现时间</label><input id="pf_find_time" class="dfinput" readonly="readonly" name="pf_find_time" type="text" onlyread="onlyread" value="" /></li>
					<li><label>发现人员</label><input name="pf_find_people" id="pf_find_people" class="dfinput" readonly="readonly"  value="${pTask.pfpList[0].pf_find_people==null?sessionScope.loginUser.u_realname:pTask.pfpList[0].pf_find_people}"></li>
                    <li><label>缺陷描述</label><textarea onblur="checkRemark()" class="dfinput" id="pf_remark"  name="pf_remark" >${pTask.pfpList[0].pf_remark}</textarea><span id="spre" style="display: inline-block;"></span></li>
					
			   </ul>
              </td>
        </tr>  
		   <tr><td colspan="2">
		   <input type="button" value="保存"  id="saveInfo" class="scbtn">
		   <input id="backbtn" type="button" class="btn" value="返回"/></td></tr>
<table>
   
    </form>
    </ul>
    
    
    </div>


</body>
       <font style="color:red" >上传回执:<br/>1.点击左边的杆塔号,右侧显示对应信息表单<br/>
       2.如杆塔录入后点击保存,左侧杆塔号变成红色(其他颜色)<br/>
	   3.所有杆塔信息录入完成后,点击上传回执,保存该线路回执录
