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
    
	<title>巡检记录统计</title>
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
	<scrtpt type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></scrtpt>
	
	
	<script src="js/ace-extra.min.js"></script>

	<script type="text/javascript">
	    KE.show({
	        id : 'content7',
	        cssPath : './index.css'
	    });
	    
	    $(function () {
			$('#newNav').click(function(){
					window.location.href="add.html";
			 });
	     });
	     
	     function checkall(){
			var alls=document.getElementsByName("check");
			var ch=document.getElementById("checkall");
			if(ch.checked){
				for(var i=0;i<alls.length;i++){
					alls[i].checked=true;	
				}	
			}else{
				for(var i=0;i<alls.length;i++){
					alls[i].checked=false;	
				}	
			}
		}
	</script>
	  
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".select3").uedSelect({
				width : 200
			});
			
		});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
		  $(".click").click(function(){
		  $(".tip").fadeIn(200);
		  });
		  
		  $(".tiptop a").click(function(){
		  $(".tip").fadeOut(200);
		});
		
		  $(".sure").click(function(){
		  $(".tip").fadeOut(100);
		});
		
		  $(".cancel").click(function(){
		  $(".tip").fadeOut(100);
		});
		  $(".scbtn1").click(function(){
				$(".seachform2").fadeIn(200);
			});
		  
		  $("#exportExcel").click(function(){
			  if($('#pcount').val()!=0){
				window.location.href="exportISPExcel.action?p_num="+$('#p_num').val()+"&end_time="+$('#end_time').val()
				+"&start_time="+$('#start_time').val()+"&nowPage="+$('#nowPage').val();
			  }else{
				  alert("没有可导出的数据!");
			  }
			  });
		});  
	</script>
	</script>
	
	</head>
	
	<body class="sarchbody" style="background-color:#ffffff" >
	<input id="purl" type="hidden" value="getPatrolInformation.action?p_num=${isp.p_num}&end_time=${isp.end_time}&start_time=${isp.start_time}"> 	
	<input id="nowPage" type="hidden" value="${page.nowPage }"> 	
	<input id="pcount" type="hidden" value="${page.count }"> 	
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="OrgTaskController/task.do">信息统计</a></li>
				<li><a href="OrgTaskController/task.do">巡检记录统计</a></li>
			</ul>
		</div>
	    <div class="hr"></div>
	    
			<div id="usual1">
			<form action="getPatrolInformation.action" method="get" class="formbody">
			<table class="tablelist">
				<ul class="seachform1">
		    		<li><label>任务编号：</label>
		    			<input name="p_num" id="p_num" type="text" value="${isp.p_num }" class="scinput1" />
		    		</li>
					<li><label>巡检时间：</label><input name="" id="start_time" type="text" class="scinput1" onclick="WdatePicker()" value="${isp.stime }"/> 
     										
     										  - 
											  <input name="end_time" id="end_time" type="text" class="scinput1" onclick="WdatePicker()" value="${isp.etime }"/> 
     										 
					</li>
					<li>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" type="button" class="scbtn" value="查询"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="exportExcel" type="button" class="scbtn1" value="导出EXCEL"/>
					</li>
				</ul>
				</table>
				</form>
			</div>
			
			<!-- <div class="hr hr-18 dotted hr-double"></div> -->
			
			<div class="formbody">
				<center>
			    <table class="tablelist">
			    	<thead>
				    	<tr>
					       
					        <th style="text-align:center;">任务编号</th>
					        <th style="text-align:center;">任务名称</th>
					        <th style="text-align:center;">线路编号(起始杆号-终止杆号)</th>
					        <th style="text-align:center;">杆塔编号</th>
					        <th style="text-align:center;">缺陷级别</th>
					        <th style="text-align:center;">缺陷类型</th>
					        <th style="text-align:center;">发现时间</th>
					        <th style="text-align:center;">缺陷描述</th>
				        </tr>
			        </thead>
			        <tbody>
					   <c:forEach items="${pList }" var="p">
					    <tr>
						   <td>${p.p_num }</td>
						   <td>${p.p_name }</td>
						   <td>${p.li_code}(${p.p_strcode}-${p.p_endcode})</td>
						   <td>${p.pole_code}</td>
						   <td>${p.pf_sure_grade==1?"一般":p.pf_sure_grade==2?"严重":"紧急"}</td>
						   <td>
						   <c:forEach items="${flawList }" var="flaw">
								<c:if test="${flaw.f_id==p.pf_flaw}">${flaw.f_name }</c:if>
		         			</c:forEach>
						   </td>
						   <td>${p.find_time }</td>
						   <td>${p.pf_remark}</td>
						</tr>
					   </c:forEach>

			        </tbody>
			    </table>
			    </center>
			   
			   <table class="tablelist2">
       <tr>
         <th>
         <p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getPatrolInformation.action?p_num=${isp.p_num}&end_time=${isp.end_time}&start_time=${isp.start_time}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
	</body>
</html>
