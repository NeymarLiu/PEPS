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
    
	<title>消缺记录统计</title>
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
		
		});
	</script>
	
	</head>
	
	<body class="sarchbody" style="background-color:#ffffff" >
	<input id="purl" type="hidden" value="selectAllEdTaskDetailTwo.action?stBid=${mht.stBid}&d1=${mht.d1}&d2=${mht.d2}"> 	
	<input id="nowPage" type="hidden" value="${page.nowPage }"> 	
	<input id="count" type="hidden" value="${page.count }"> 	
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>信息统计</li>
				<li>消缺记录统计</li>
			</ul>
		</div>
	    <div class="hr"></div>
	    
			<div id="usual1">
			<form method="post" action="selectAllEdTaskDetailTwo.action" class="formbody">
			<table class="tablelist">
				<ul class="seachform1">
		    		<li><label>任务编号：</label>
		    			<input name="stBid" id="stBid" type="text" class="scinput1" />
		    		</li>
					<li><label>消缺时间：</label><input name="d1" id="d1" type="text" class="scinput1" onclick="WdatePicker()" value=""/> 
     										
     										  - 
											  <input name="d2" id="d2" type="text" class="scinput1" onclick="WdatePicker()" value=""/> 
     										 
					</li>
					<li>
					<input type="submit" type="button" class="scbtn" value="查询"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="daochu" type="button" class="scbtn1" value="导出EXCEL"/>
					</li>
				</ul>
			    <script type="text/javascript">
					$(document).ready(function(){
						$(".scbtn1").click(function(){
							$(".seachform2").fadeIn(200);
						});
					});
					
					$(function(){
						$('#daochu').click(function(){
							if($('#count').val()!=0){
								window.location.href="exportISPExcelTwo.action?stBid="+$('#stBid').val()+"&d1="+$('#d1').val()+"&d2="+$('#d2');
								}else{
									alert("没有数据无法导出！");
									}
							});
						
						});
				</script>
			
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
					        <th style="text-align:center;">线路编号</th>
					        <th style="text-align:center;">杆塔编号</th>
					        <th style="text-align:center;">缺陷级别</th>
					        <th style="text-align:center;">缺陷类型</th>
					        <th style="text-align:center;">消缺时间</th>
					        <th style="text-align:center;">发现时间</th>
					        <th style="text-align:center;">缺陷描述</th>
				        </tr>
			        </thead>
			        <tbody>
					   <c:forEach items="${etpList }" var="etp">
						   <tr>
							   <td>${etp.e_task_id }</td>
							   <td>${etp.e_name }</td>
							   <td>${etp.li_code }</td>
							   <td>${etp.pole_code }</td>
							   <c:if test="${etp.pf_sure_grade==1 }"><td>一般</td></c:if>
							   <c:if test="${etp.pf_sure_grade==2 }"><td>严重</td></c:if>
							   <c:if test="${etp.pf_sure_grade==3 }"><td>紧急</td></c:if>
							   <td>${etp.f_name }</td>
							   <td>${etp.task_finish_time }</td>
							   <td>${etp.find_time }</td>
							   <td>${etp.pf_remark }</td>
							</tr>
					   </c:forEach>
			        </tbody>
			    </table>
			    </center>
			   
			   <table class="tablelist2">
       <tr>
         <th><p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="selectAllEdTaskDetailTwo.action?stBid=${mht.stBid}&d1=${mht.d1}&d2=${mht.d2}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>



	</body>
</html>
