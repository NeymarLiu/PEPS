<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			alert("添加成功");
		}
	}
	function checkPCode(){
	var state=false;
		var pcode=$('#pcode').val();
		var regex=/^[0-9]{6}$/;
		//校验格式是否正确
		if(regex.test(pcode)){
		pcode=$('#selectLine').val()+"_"+pcode;
		//校验编号是否可用
			$.ajax({
				async:false,
				type:"GET",
				url:"checkPCode.action?pole_code="+pcode,
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
			$('#spco').html("<font color='red'>格式不正确!&nbsp; 例:000001!</font>");
			state=false;
		}
		return state;
	}
	function fanhui(){
		location.href="getAllPole.action";
	}
</script>
<body onload="getFlag('${flag}')">
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="right.jsp">首页</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>添加信息</span>
		</div>
		<form action ="addPole.action" method="post" onsubmit="return checkPCode()">
			<ul class="forminfo">
				<li><label>线路选择</label>
				 <select class="dfinput" name="licode" id="selectLine" onclick="checkLine()">
			      <option value="-1">-请选择线路-</option>
			      <c:forEach items="${lineList}" var="line">
			      	 <option value="${line.li_code}">${line.li_name}</option>
			      </c:forEach>
    				 </select>__
				</li>
				<li><label>杆塔编码</label><input id="pcode" onkeyup="checkPCode()"  name="pole_code" type="text" class="dfinput" /><span id="spco" style="display: inline-block;"></span></li>
				<li><label>启用状态</label><cite><input name="pole_state"
						type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="pole_state" type="radio" value="1" />禁用</cite></li>
				<li><label>&nbsp;</label><input type="submit" class="btn"
					value="确认保存"/>&nbsp;&nbsp;<input type="button" class="btn"
				value="返回首页"   onclick="fanhui()"></li>
			</ul>
		
		</form>
	</div>
</body>
</html>
