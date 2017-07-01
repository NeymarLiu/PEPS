<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <link href="css/style.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript" src="js/jquery.js"></script>
</head>
<script type="text/javascript">
function checkFName(){
	var state=false;
	var f_name=$('#f_name').val();
	if(f_name!=null){
		$.ajax({
				async:false,
				type:"GET",
				url:"checkFName.action?f_name="+f_name+"&f_id="+$('#f_id').val(),
				success:function(data){
					if(0==data){
						$('#spfn').html("<font color='green'>缺陷名称可用!</font>");
						state=true;
					}else if(1==data){
						$('#spfn').html("<font color='red'>缺陷名称已存在!</font>");
						state=false;
					}
				}
			});
	}else{
		$('#spfn').html("<font color='red'>缺陷名称不能为空!</font>");
		state=false;
	}
	return state;
}
function getFlag(flag){
	if(parseInt(flag)==1){
		alert("修改成功!");
	}
}
</script>
<body onload="getFlag('${flag}')">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>缺陷管理</li>
    <li>缺陷类型设置</li>
    <li>增加缺陷类型</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <form action="UpdateFlawPojo.action" method="post" onsubmit="checkFName()">
    <input name="f_id" id="f_id" value="${fp.f_id }" type="hidden">
    <input type="hidden" name="creatPerson" value="${sessionScope.user }"/>
    <li><label>缺陷类型名称</label><input id="f_name" onkeyup="checkFName()" name="f_name" type="text" class="dfinput" value="${fp.f_name }"/><span id="spfn" style="display: inline-block;"></span></li>
    
    <li><label>启用状态</label><cite>
    <c:if test="${fp.f_state==0}">
    <input name="f_state" type="radio" value="0" checked="checked" />启用&nbsp;&nbsp;&nbsp;&nbsp;<input name="f_state" type="radio" value="1" />禁用
    </c:if>
    <c:if test="${fp.f_state==1}">
    <input name="f_state" type="radio" value="0"  />启用&nbsp;&nbsp;&nbsp;&nbsp;<input name="f_state" type="radio" value="1" checked="checked"/>禁用
    </c:if>
    </cite></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </form>
    </ul>
    
    </div>

</body>

</html>
