<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/styless.css" rel="stylesheet" type="text/css" />
<script src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/user/add.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript" src="js/user/add.js"></script>
</head>
<script type="text/javascript">
function fanhui(){
	window.location.href="getAllUsers.action";
}

</script>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">表单</a></li>
		</ul>
	</div>

	<div class="formbody" align="left">
		<h1 class="formtitle">
			<span>添加用户</span>
		</h1>
<form action="addOneUser.action" autocomplete="off" method="post" onsubmit="return CheckMyForm();">
	
		<ul class="forminfo">
			<li>登录账号:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_loginname" id="u_loginname" onblur="loginNameTest()" type="text" class="dfinput" />
			<i id="losp"></i>
			</li>
			
			 <li>用户名称:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_realname" autocomplete="off" id="u_realname" type="text" value="" class="dfinput" onblur="CheckRealName()" />
				<i id="nasp"></i>
			</li>
			
			 <li >用户密码:&nbsp;&nbsp;&nbsp;&nbsp;
			<!--  <input type="password" style="display: none"/> -->
			<input name="u_password" autocomplete="new-password" id="u_password" value="" onblur="CheckPas()" type="password" class="dfinput" />
			<i id="spps"></i>
			</li>
			
			<li  style="margin-left:2.5%">性别:&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="u_sex" value="0" checked>男 &nbsp;&nbsp;
			<input type="radio" name="u_sex" value="1">女
			</li>
			<li style="margin-left:2.5%">年龄:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_age" type="text" id="u_age" class="dfinput" onblur="CheckAge()"/>
			<i id="iage"></i>
			</li>
			
			<li>用户角色:&nbsp;&nbsp;&nbsp;&nbsp;
			<select name="r_id" id="r_id" class="dfinput" onchange="CheckRid()">
		    	<option value="-1">--请选择角色--</option>
		    	<c:forEach items="${rList}" var="r">
		    	<option  value="${r.r_id }">${r.r_name }</option>
		    	</c:forEach>
		   		</select>
		   		<i id="irid"></i>
			</li>
			
			<li style="margin-left:2.5%">邮箱:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_email" id="u_email" type="text" class="dfinput" onblur="CheckEmail()"/>
			<i id="spem"></i>
			</li>
			
			<li>联系电话:&nbsp;&nbsp;&nbsp;
			<input name="u_phone" id="u_phone" type="text" class="dfinput" onblur="CheckPhone()"/>
			<i id="spph"></i>
			</li>
			
			<li>离职时间:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_outtime" id="u_outtime" type="text" class="dfinput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'u_intime\')}',maxDate:'%y-%M-%d'})"/>
			
			<li>入职时间:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_intime" id="u_intime" type="text" class="dfinput" onblur="CheckIntime()" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'u_outtime\')||\'%y-%M-%d\'}'})" />
			<i id="iintime"></i>
			</li>
			
			<li>
  			使用状态：&nbsp;&nbsp;&nbsp;&nbsp;	
  			<input type="radio" value="0" checked="checked" name="u_state">正常<input type="radio" value="1" name="u_state" >冻结
    		</li>  
			
			<li  style="margin-left:15%; height: 50px">
			<input type="submit" class="btn" value="确认保存">
			<input type="button" class="btn" onclick="fanhui()" value="返回">
			</li>
		</ul>
	
</form>
</div>
</body>
</html>