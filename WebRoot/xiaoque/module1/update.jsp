<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="js/select-ui.min.js"></script>
	<script type="text/javascript" src="editor/kindeditor.js"></script>
	<script type="text/javascript" src="js/xiaoque/module1/update.js"></script>
	
	
	<script  type="text/javascript">
		a=false;
	     $(function(){
		    $('#submit').click(function(){
		    	var count=0;
				var u_id = $('.chkbox');
				for(var i=0;i<u_id.length;i++){
					if(u_id[i].checked == true){
						count++;
					};
				};
				if(count ==0){//没有选择项
					a= false;
				}else{
				a= true;
				}
		    });
		});
		function test(){
				if(a){
					return true;
				}else
				alert("你添加的信息不全！");
				return false;
				}
	</script>
	</head>
	<body>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>消缺任务管理</li>
				<li>消缺任务制定与分配</li>
				<li>制定消缺任务</li>
			</ul>
		</div>
		
		<form action="updateEdTaskTwo.action?e_id=${edp.e_id }" method="post" class="formbody" onsubmit="return test()" >
	    	<div id="usual1" class="usual">
	    		<div class="itab">
				  	<ul> 
				    <li><a href="#tab" class="selected">修改消缺任务</a></li>
				  	</ul>
			    </div> 
	    
			  	<div id="tab" class="tabson">
			    <ul class="forminfo">
			    <li><label>任务编号<b>*</b></label>
			    	<input name="e_task_id" readonly="readonly" id="e_task_id" type="text" class="dfinput" value="${edp.e_task_id }"  style="width:200px;"  /> &nbsp; &nbsp; &nbsp;
			    	任务名称<b>*</b>
			    	<input name="e_name"  id="e_name" type="text" class="dfinput" value="${edp.e_name }"  style="width:200px;" />
			    	
			    </li>
			    
			    <li><label>工作单据<b>*</b></label>
					<div class="vocation">
					    <select class="select1" name="stBdid"   onClick="addBillName()">
						    <c:if test="${edp.e_security_id==1 }">
						    <option selected="selected" value="1" >第一种单据</option>
							</c:if>
							<c:if test="${edp.e_security_id==2 }">
						    <option selected="selected" value="2">第二种单据</option>
							</c:if>
							 
					    </select>
					    
					</div>
				</li>
				<li><label>任务负责人<b>*</b></label>
					<div class="vocation">
					    <select class="select1" name="u_realid" id="u_realid" >
						    		<option selected="selected" value="">${edp.e_task_principal }</option>
			    		</select>
					</div>
				</li>
				<li><label>下发人：</label>
					<input  type="text" class="dfinput" value="${edp.e_issued_name }" readonly  style="width:200px;"/>
					&nbsp; &nbsp; &nbsp;
				下发时间：
					<input  type="text" class="dfinput" value="${edp.issued_time }" readonly  style="width:200px;"/>
     				
     			</li>
				<li><label>任务描述：</label>
					<textarea name="e_task_described" class="dfinput">${edp.e_task_described }</textarea>
				&nbsp; &nbsp; &nbsp;
				备注：
					<textarea name="e_remark" class="dfinput">${edp.e_remark }</textarea>
				</li>
				<li>消缺员：
				<c:forEach items="${upList }" var="up" >
     				<input type="checkbox" readonly="readonly" name="u_id" class="chkbox"  value="${up.u_id}">${up.u_realname}
     			</c:forEach>
			</div>
		</div> 
		
    

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
<input type="submit" id="submit"  class="scbtn" type="button" value="提交">
		<input class="scbtn1" type="button" onclick="back()" value="返回">
	</form>
</body>

</html>
