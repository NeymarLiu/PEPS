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
	<script type="text/javascript" src="js/xiaoque/module1/add.js"></script>
	
	
	<script type="text/javascript" >
	 a=false; 
    $(function(){
    	$('#e_name').blur(function(){
    		
	    	var e_name= $('#e_name').val();
	    	if(e_name !=""&&e_name !=null&&e_name !="null"){
	    		if(e_name.length<6||e_name.length>20){
	    			$('#noneName').html("<font color='red'>任务名称不能小于6大于20</font>");
	    			//alert("任务名称不能小于6大于20");
	    			a=false;
	    		}else{
	    		$('#noneName').html("<font color='green'>ok</font>");
	    			a=true;
	    		}
	    	}else{
	    		$('#noneName').html("<font color='red'>任务名称不能为空</font>");
	    		//alert("任务名称不能为空");
	    		a=false;
	    	}
    	});
    }); 
    //全选反选
    $(function(){
	    $('#checkid').click(function(){
	    	if(($('#checkid').attr('checked'))){
	    		$('.chkbox').attr('checked',true);
	    	}else{
	    		$('.chkbox').attr('checked',false);
	    	}
	    });
    });
    b=false;
    $(function(){
	    $('#e_task_described').blur(function(){
	  	 	
	    	var e_task_described=  $('#e_task_described').val();
	    	if(e_task_described==""||e_task_described==null||e_task_described=="null"){
	    		alert("不能为空！");
	    		b=false;
	    	}else{
				b=true;	    	
	    	}
	    });
    });
    c=false;
     $(function(){
	    $('#e_remark').blur(function(){
	    	
	    	var e_remark=  $('#e_remark').val();
	    	if(e_remark==""||e_remark==null||e_remark=="null"){
	    		alert("不能为空！");
	    		c=false;
	    	}else{
				c=true;	    	
	    	}
	    });
	});
	d=false;
     $(function(){
	    $('#u_realid').blur(function(){
	    	var u_realid=  $('#u_realid').val();
	    	if(u_realid==0){
	    		alert("请选择负责人！");
	    		d=false;
	    	}else{
				d=true;	    	
	    	}
	    });
	});
	e=false;
     $(function(){
	    $('#e_security_id').blur(function(){
	    	var e_security_id=  $('#e_security_id').val();
	    	if(e_security_id==0){
	    		alert("请选择单据！");
	    		e=false;
	    	}else{
				e=true;	    	
	    	}
	    });
	});
	f=false;
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
				f= false;
			}else{
			f= true;
			}
	    });
	});
	function test(){
			if(a&&b&&c&&d&&e&&f){
				return true;
			}else{
			alert("你添加的信息不全！");
			return false;
			}
		}
	</script>
	</head>
	<body onload="checkState('${ceshi}')">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>消缺任务管理</li>
				<li>消缺任务制定与分配</li>
				<li>制定消缺任务</li>
			</ul>
		</div>
		
		<form action="insertEdTask.action" method="post" class="formbody"   onsubmit="return test()">
	    	<div id="usual1" class="usual">
	    		<div class="itab">
				  	<ul> 
				    	<li><a href="#tab" class="selected">制定消缺任务</a></li>
				  	</ul>
			    </div> 
	    
	  	<div id="tab" class="tabson">
	    <ul class="forminfo">
	    <li>
	    	<label>任务编号<b>*</b></label>
	    		<input name="e_task_id" id="e_task_id" type="text" class="dfinput" value="${rwid}"  style="width:200px;"  onblur="addId()"/> &nbsp; &nbsp; &nbsp;
	    	任务名称<b>*</b>
	    <input name="e_name" id="e_name" type="text" class="dfinput" value=""  style="width:200px;" /><span id="noneName" style="display:inline-block;"></span>
	    </li>
	    
	    <li><label>工作单据<b>*</b></label>
			<div class="vocation">
			    <select class="select1" name="e_security_id" id="e_security_id"  onClick="addBillName()">
				    <option value="0">--请选择--</option>
					<option value="1">第一种单据</option>
					<option value="2">第二组单据</option> 
			    </select>
			    <span id="noneBillName"></span>
			</div>
		</li>
		<li><label>任务负责人<b>*</b></label>
			<div class="vocation">
			    <select class="select1" name="u_realid" id="u_realid">
				    	<option value="0">--请选择--</option>
				    <c:forEach items="${issuedList }" var="issued">
				    	<option value="${issued.u_id }">${issued.u_realname }</option>
				    </c:forEach>
			    </select>
			</div>
		</li>
		<li><label>下发人：</label>
			<input id="e_issued_name"  name="e_issued_name" type="text" class="dfinput" readonly="readonly" value="${sessionScope.loginUser.u_realname}" readonly="readonly" style="width:200px;"/>
			&nbsp; &nbsp; &nbsp;
		下发时间：
			<input id="e_issued_time" name="e_issued_time" type="text" class="dfinput" value="" readonly="readonly"  style="width:200px;"/>
   				
   			</li>
		<li><label>任务描述：</label>
			<textarea name="e_task_described" id="e_task_described" class="dfinput"></textarea>
		&nbsp; &nbsp; &nbsp;
		备注：
			<textarea name="e_remark" id="e_remark" class="dfinput"></textarea>
		</li>
		<li>消缺员：<c:forEach items="${edplList }" var="edpl" >
     		<input type="checkbox" name="u_id" value="${edpl.u_id}">${edpl.u_realname}
     		<%i++; 
     			if(i%3==0){%>
     			<br/>
     			<%}
     		%>
     	</c:forEach>
	</div>
</div> 
		
    

	<div class="place">
     缺陷列表:
   
    </div>
<table class="tablelist" >
    	<thead>
    	<tr>
        
        <th><input type="checkbox"  id="checkid" ></th>
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
     	<c:forEach items="${pqpList }" var="pqp">
     		<tr> 
			 <td><input type="checkbox" name="check" class="chkbox" value="${pqp.pf_id }"></td>
			 <td>${pqp.li_code }</td>
	         <td>${pqp.pole_code }</td>
	         <td>${pqp.f_name }</td>
	         <td>${pqp.pf_remark }</td>
	         <td>${pqp.find_time }</td>
	         <td>${pqp.pf_find_people }</td>
	         <c:if test="${pqp.pf_sure_grade==1 }"><td>一般</td></c:if>
			 <c:if test="${pqp.pf_sure_grade==2 }"><td>严重</td></c:if>
			 <c:if test="${pqp.pf_sure_grade==3 }"><td>紧急</td></c:if>
        	</tr> 
     	</c:forEach>
       
        </tbody>
    </table> 
<input type="submit"  class="scbtn" type="button" id="submit" value="提交">
		<input class="scbtn1" type="button" onclick="back()" value="返回">
	</form>
</body>

</html>
