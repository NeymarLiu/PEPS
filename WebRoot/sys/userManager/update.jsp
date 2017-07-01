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
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/user/update.js"></script>
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
	<div class="formbody">

		<h1 class="formtitle">
			<span>修改用户</span>
		</h1>
	<form action="updateUser.action" method="post" onsubmit="return CheckMyForm();">	
		<input type="hidden" value="${up.u_id }" id="u_id" name="u_id" >
		<ul class="forminfo">
			<li>登录账号:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_loginname" id="u_loginname" onblur="loginNameTest()" type="text" value="${up.u_loginname }" class="dfinput" />
			<i id="losp"></i>
			</li>
			<li>用户名称:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_realname" id="u_realname" onblur="CheckRealName()" type="text" value="${up.u_realname }" class="dfinput" />
			<i id="nasp"></i>
			</li>
			<li>用户密码:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_password" type="password" value="${up.u_password }" onblur="CheckPas()" class="dfinput" />
			<i id="spps"></i>
			</li>
			<li style="margin-left:2.5%">性别:&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${up.u_sex==0 }">
			<input type="radio" value="0" name="u_sex" checked>男 &nbsp;&nbsp;
			<input type="radio" value="1" name="u_sex">女
			</c:if>
			<c:if test="${up.u_sex==1 }">
			<input type="radio" value="0" name="u_sex">男 &nbsp;&nbsp;
			<input type="radio" value="1" name="u_sex" checked>女
			</c:if>
			</li>
			<li style="margin-left:2.5%">年龄:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_age" type="text" id="u_age" onblur="CheckAge()" value="${up.u_age }" class="dfinput" />
			<i id="iage"></i>
			</li>
			<li>用户角色:&nbsp;&nbsp;&nbsp;&nbsp;
			<select name="r_id" id="r_id" class="dfinput" onchange="CheckRid()">
		    	<option value="-1">--请选择角色--</option>
		    	<c:forEach items="${rList}" var="r">
		    		<c:if test="${r.r_id == up.r_id }">
		    			<option  value="${r.r_id }" selected="selected">${r.r_name }</option>
		    		</c:if>
		    		<c:if test="${r.r_id != up.r_id }">
		    			<option  value="${r.r_id }">${r.r_name }</option>
		    		</c:if>
		    	</c:forEach>
		   	</select>
			<i id="irid"></i>
			</li>
			<li style="margin-left:2.5%">邮箱:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_email" id="u_email" value="${up.u_email }" onblur="CheckEmail()" type="text" class="dfinput" />
			<i id="spem"></i>
			</li>
			<li>联系电话:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_phone" id="u_phone" value="${up.u_phone }" type="text" class="dfinput" onblur="CheckPhone()" />
			<i id="spph"></i>
			</li>
			
			<li> 离职时间:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_outtime" id=u_outtime value="${up.p_u_outtime }" type="text" class="dfinput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'u_intime\')}',maxDate:'%y-%M-%d'})"/>
			
			</li>
			<li>入职时间:&nbsp;&nbsp;&nbsp;&nbsp;
			<input name="u_intime" id="u_intime" value="${up.p_u_intime }" onblur="CheckIntime()" type="text" class="dfinput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'u_outtime\')||\'%y-%M-%d\'}'})"/>
			<i id="iintime"></i>
			</li>
			<li>
  			使用状态：&nbsp;&nbsp;&nbsp;&nbsp;	
  			<c:if test="${up.u_state==0 }"><input type="radio" checked="checked" value="0" name="u_state">正常<input type="radio"value="1" name="u_state"  >冻结</c:if>
   			<c:if test="${up.u_state==1 }"><input type="radio" value="0" name="u_state">正常<input type="radio" value="1" name="u_state" checked="checked"   >冻结</c:if>
    		</li>
			<!-- <label> &nbsp; -->
			<li><input type="submit" class="btn" value="确认保存">
			<input type="button" class="btn" onclick="fanhui()"  value="返回"></li>
		</ul>
</form>
</div>
</body>
</html>