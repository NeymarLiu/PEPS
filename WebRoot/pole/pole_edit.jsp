<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pole.jsp' starting page</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<script type="text/javascript" src="js/jquery.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css" />

  </head>
  <script type="text/javascript">
  function getFlag(flag){
  	if(parseInt(flag)==1){
  		alert("修改成功!");
  	}
  }
  function checkPCode(){
	var state=false;
		var pcode=$('#pole_code').val();
		var regex=/^[A-Z]{2}[0-9]{4}_[0-9]{6}$/;
		//校验格式是否正确
		if(regex.test(pcode)){
		//校验编号是否可用
			$.ajax({
				async:false,
				type:"GET",
				url:"checkPCode.action?pole_code="+pcode+"&pole_id="+$('#pole_id').val(),
				success:function(data){
					if(1==data){
						$('#spco').html("<font color='green'>塔杆编号可用!</font>");
						state=true;
					}else{
						$('#spco').html("<font color='red'>"+data+"</font>");
						state=false;
					}
				}
			});
		}else{
			$('#spco').html("<font color='red'>格式不正确!&nbsp; 例:XX00001_000001!</font>");
			state=false;
		}
		return state;
	}
  </script>
  <body onload="getFlag('${flag}')">
   <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="line.html">首页</a></li>
    
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改信息</span></div>
     <form action="UpdatePoleInfo.action" method="post" onsubmit="return checkPCode()">
     <input type="hidden" id="pole_id" name="pole_id" value="${pole.pole_id}" >
       <ul class="forminfo">
          <li><label>杆塔编号：</label><input id="pole_code" onkeyup="checkPCode()" name="pole_code" value="${pole.pole_code}" type="text" class="dfinput" /><span id="spco" style="display: inline-block;"></span></li>
          <li><label>杆塔状态：</label><cite>
          <c:if test="${pole.pole_state==1}">
           	 <input name="pole_state" type="radio" value="0"  />启用&nbsp;&nbsp;&nbsp;&nbsp;
         	 <input name="pole_state" type="radio" value="1" checked="checked" />停用
          </c:if>
          <c:if test="${pole.pole_state==0}">
          	 <input name="pole_state" type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;
         	 <input name="pole_state" type="radio" value="1"  />停用
          </c:if>
          
          </cite></li>
          <li><label>备注</label><textarea name="pole_descript" cols="" rows="" class="textinput">${pole.pole_descript }</textarea></li>
          <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
        </ul>
       </form>
    </div>
  </body>
</html>


