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
	 		if($('#sid').val()!=null){
	 			$('#e_security_id').val($('#sid').val());
	 		}
	 	
	 	});
	 
	 </script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="js/select-ui.min.js"></script>
	<script type="text/javascript" src="editor/kindeditor.js"></script>
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="jedate/jedate.js"></script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="js/select-ui.min.js"></script>
	<script type="text/javascript" src="editor/kindeditor.js"></script>
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script src="js/ace-extra.min.js"></script>
	<script src="js/xiaoque/module2/index.js"></script>
	
	<script type="text/javascript">
	a=false;
			$(function(){
				$('#stBid').blur(function(){
					var d=$('#stBid').val();
					if(d==""&&d==null&&d=="null"){
						alert("请输入任务编号！");
						a=false;
					}else{
						a=true;
					}
				});
				
				$('#stUser').blur(function(){
					var c=$('#stUser').val();
					if(c==""&&c==null&&c=="null"){
						alert("请输入下发人的姓名！");
					}
				});
				
			});
			
			$(function(){
				$('#d1').blur(function(){
					var d=new Date();
					var year=d.getFullYear();
					var moth=d.getMonth()+1;
					var day=d.getDate();
					var nowTime=year+"-"+moth+"-"+day;
					var mintime=$('#d1').val();
					var maxtime=$('#d2').val();
					if (mintime!=null&&mintime!=""&&mintime!="null") {//最小时间不为空
						if (maxtime!=null&&maxtime!=""&&maxtime!="null") {//最大时间不为空
							if (mintime>maxtime||nowTime<mintime) {
								alert("最小时间不能大于当前时间或大于最大时间");
								$('#d1').val(null);
							} else {
								//var mintime=$('#d1').val();
								a=true;
							}
						}else{//最大时间为空
							if (mintime>nowTime){
								alert("最小时间不能大于当前时间");
								$('#d1').val(null);
								}
							}
						}
				});
				
				$('#d2').blur(function(){
					var d=new Date();
					var year=d.getFullYear();
					var moth=d.getMonth()+1;
					var day=d.getDate();
					var nowTime=year+"-"+moth+"-"+day;
					var mintime=$('#d1').val();
					var maxtime=$('#d2').val();
					if (maxtime!=null&&maxtime!=""&&maxtime!="null") {//最大时间不为空
						if (mintime!=null&&mintime!=""&&mintime!="null") {//最小时间不为空
							if (maxtime<mintime||maxtime>nowTime) {
								alert("最大时间不能小于最小时间或大于当前时间");
								$('#d2').val(null);
							} else {
								a=true;
							}
						} else {//最小时间为空
								if (maxtime>nowTime) {
									alert("最大时间不能大于当前时间");
									$('#d2').val(null);
								} 
						}
						
						}
				});
			});
	</script>
	
	
	</head>
	<body style="background-color:#ffffff" >
	<input id="purl" type="hidden" value="moHuEdTask.action?stBid=${mht.stBid}&stUser=${mht.stUser}&d1=${mht.d1}&d2=${mht.d2}&e_security_id=${mht.e_security_id}">
	<input type="hidden" id="sid" value="${mht.e_security_id }"/>	
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>消缺任务管理</li>
				<li>消缺任务执行与回执</li>
			</ul>
		</div>
	    <div class="hr"></div>
	    
			<div id="usual1">
			<form action="moHuEdTaskUser.action" method="get" class="formbody">
			<table class="tablelist">
				<ul class="seachform1">
		    		<li><label>任务编号：</label>
		    			<input name="stBid" id="stBid" type="text" class="scinput1" value="${mht.stBid }"/>
		    		</li>
		    		
					<li><label>工作单据：</label>  
						<div class="vocation">
							<select name="e_security_id" class="select3" id="e_security_id">
								<option value="0">--请选择--</option>
						        <option value="1">第一种单据</option>
							  	<option value="2">第二种单据</option>
						    	
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
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;
					<input type="submit" type="button" class="scbtn" value="查询"/>
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
						   <c:if test="${edp.e_task_state==2 }"><td>已分配</td></c:if>
						   <c:if test="${edp.e_task_state==3 }"><td>执行中</td></c:if>
						   <c:if test="${edp.e_task_state==4 }"><td>已完成</td></c:if>
						   <td>${edp.task_finish_time }</td>
							<c:if test="${edp.e_task_state==2}">
							   <td>
							    <a href="edReceiptLook.action?id=${edp.e_id }" class="tablelink">查看</a>  |
								执行录入  |
								<a href="edReceiptDo.action?id=${edp.e_id }" class="tablelink">执行</a>  |
								 修改  |
							   </td>
							</c:if>
							<c:if test="${edp.e_task_state==3 }">
							   <td>
							    <a href="edReceiptLook.action?id=${edp.e_id }" class="tablelink">查看</a>  |
								<a href="edToReceiptEnter.action?id=${edp.e_id }" class="tablelink">执行录入</a>  |
								 执行  |
								<a href="toUpdateReceipt.action?id=${edp.e_id }" class="tablelink" class="tablelink">修改</a>  |
							   </td>
							</c:if>
							<c:if test="${edp.e_task_state==4 }">
							   <td>
							    <a href="edReceiptLook.action?id=${edp.e_id }" class="tablelink">查看</a>  |
								 执行录入  |
								 执行  |
								修改  |
							   </td>
							</c:if>
						</tr>
						</c:forEach>
			        	
			        </tbody>
			    </table>
			    </center>
			   
			   <table class="tablelist2">
       <tr>
         <th><p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="moHuEdTaskUser.action?stBid=${mht.stBid}&stUser=${mht.stUser}&d1=${mht.d1}&d2=${mht.d2}&${mht.e_security_id }" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
		
	</body>
</html>
