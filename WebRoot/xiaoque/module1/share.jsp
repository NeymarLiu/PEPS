<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript" src="js/xiaoque/module1/share.jsp"></script>


<script type="text/javascript">
a=false;
$(function() {
	$('#submit1').click(function() {
		var count=0;
		var u_id = $('.chk');
		for(var i=0;i<u_id.length;i++){
			if(u_id[i].checked == true){
				count++;
			};
		};
		if(count ==0){//没有选择项
		a=false;
		}else{
		a=true;
		}
	});
});
function test2(){
	 if(a){
	 	return true;
	 }else{
	 	alert("你还没有选择！");
	 	return false;
	 }
}


$(function () {       
				$('#backid').click(function(){
					window.history.back();
				});
		    });

</script>
<style type="text/css">
.f1 {
	font-size: 16px;
	padding-left: 15px
}

.h1 {
	font-size: 18px;
	padding-left: 0px
}
</style>

</head>

<body class="sarchbody" onload="checkState('${ceshi}')">

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>消缺任务管理</li>
			<li>分配消缺任务</li>
		</ul>
	</div>

	<div class="formbody">


		<div id="usual1" class="usual">
			<form class="f1" name="form2" action="addEdUser.action?e_id=${e_id }" method="post" onsubmit="return test2()">
				
				<table class="tablelist3">
					<tr>
						<td>
							<ul class="seachform1">
								<li>
									<div class="vocation"></div>
								</li>
								<li><input id="submit1" name="submit" type="submit" class="scbtn1" value="保存" /></li>
									
								<li><input id="backid" class="scbtn1" type="button" value="返回"></li>
							</ul>

						</td>
					</tr>
					<tr>
						<td align='left' bgcolor="#FFFFFF"
							onMouseMove="javascript:this.bgColor='#FCFDEE';"
							onMouseOut="javascript:this.bgColor='#FFFFFF';">
							<p class="h1">分配人员:</p> <c:forEach items="${upList }" var="up">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="chk"
								name="check"	type="checkbox" value="${up.u_id }" />${up.u_realname }<br />
							</c:forEach>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>

</html>