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
    
    
	<title>欢迎登录后台管理系统</title>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8"> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    });  
	
	$('#login').click(function(){
		
		if($('username').val()==null||$('username')==""){
			
		}
	});
	//取Cookie值
	if($.cookie('name')){
		$('#loginname').val($.cookie('name'));
	}
	if($.cookie('ps')){
	$('#password').val($.cookie('ps'));
	}
	$('#loginname').click(function(){
		$('#password').val('');
	});
	$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected");
		$(this).addClass("selected");
	});	
});
  }); 
function goToParent(flag){
	if(flag==1){
		window.parent.location.href="login.jsp";
	}
}

</script> 

<script type="text/javascript">
			//验证用户
			
		function user(){
			var state=false;
		 	 var login =document.getElementById("loginname").value;
		 	 var pu = document.getElementById("spuser");
			 	if(login == null || login ==""){
					pu.innerHTML="<span style='color:red'>账号不能为空</span>";
			 	    state= false;
			 	 }else{
			 	 pu.innerHTML="<span style='color:green'>ok</span>";
					state= true;
				 } 
				 return state;
		}	  
		//密码验证
		
		function ps(){
			var state=false;
			 var pass = document.getElementById("password").value;
			 var sp = document.getElementById("spps");
				 if(pass == null || pass == ""){
					 sp.innerHTML="<span Style=color:red>密码不能为空</span>";
					 state= false;
			 }else{
			 	 sp.innerHTML="<span style='color:green'>ok</span>";
				 state= true;
			 }
			 return state;
		   
		}
		
		function  checkAll(){
		var state=false;
		if(ps()&user()){
		 	state= true;
		}else{
			state= false;
		}
		return state;
		}
		
</script>
</head>

<body onload="goToParent('${flag}')" style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  

    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form action="login.action" method="post" onsubmit="return checkAll()">
    <ul>
    <li>
	    <input name="u_loginname" id="loginname"  type="text" class="loginuser" value="" 
	    onblur="user()" onclick="JavaScript:this.value=''"/>
	      <span id="spuser" style="display: "inline-block";></span><br>
     </li>
   
    <li>
	    <input name="u_password" id="password"  type="password" class="loginpwd" value="" 
	    onblur="ps()" onclick="JavaScript:this.value=''"/> <span id ="spps" style="display: "inline-block";></span>
	    	<span style='color:red'>${error}</span><br>
    </li>
    <li>
    <input id="login" type="submit" class="loginbtn" value="登录" /><label>
    
    <input name="remenber" type="checkbox" value="1" checked="checked" />记住密码
    
    </label>
    </li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
</body>

</html>
