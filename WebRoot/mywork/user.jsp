<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
   
	<title>无标题文档</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link href="css/style.css" rel="stylesheet" type="text/css" />
	  <style>
	     td{
		   font-size:20px;
		 }
	  </style>
	<!--   js的引用 -->
	 <script src="js/jquery-1.9.1.min.js"></script>
	 <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<input type="hidden" id="u_id" value="${loginUser.u_id }">
<script type="text/javascript">
 $(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected");
		$(this).addClass("selected");
	});	
});

function loginOut(){
	$.get("updateMyUser.action",function(data){
		window.parent.location.href="login.jsp";
	
	});
		
};
var state=true;

//验证登录名是否唯一
function checkLoginName(){
	var name = $('#loginname').val();
	var obj="u_loginname="+name+"&u_id="+$('#u_id').val();
	var regex=/^\w{1,20}$/;
	if(regex.test(name)){
		$.get('checkLoginName.action',obj,function(data){
		var flag=parseInt(data);
		if(flag==0){
			$('#spname').html("<span style='color:green'>OK</span>");
			state= true;
		}else{
			$('#spname').html("<span style='color:red'>用户名已存在!</span>");
			state= false;
		}
		return state;
	});
	}else{
		$('#spname').html("<span style='color:red'>用户名格式不正确!</span>");
		state= false;
	}
	return state;
}
//验证用户名

function onuname(){
       var un = $('#uname').val();
    if(un!=null && un!=''){
		   	   if(kong(un)==0){
			   			if(un.length>10){
					      $('#spuname').html("<span style='color:red'>用户名过长！</span>");
					      state=false;
					    }else{
					         $('#spuname').html("<span style='color:green'>OK</span>");
					         state=true;
			   			}
		       }else{
		         $('#spuname').html("<span style='color:red'>请正确输入字符</span>");
		         state=false;
		       }
    }else{ 
    	$('#spuname').html("<span style='color:red'>不能为空</span>");
       state=false;
  };
 return state;
}


function checkPs(){
	var ps = document.getElementById("newpass").value;	
	var regex=/^\w{6,20}$/g;
	if(regex.test(ps)){
		$('#spnew').html("<span style='color:green'>OK</span>");
		state=true;
	}else{
		$('#spnew').html("<span style='color:red'>请重新输入6-20位密码!</span>");
				state=false;
		
	}
	return state;
		
}
//新密码确认验证
function ps2(){
			var ps = document.getElementById("newpass").value;	
			var ps2 = document.getElementById("newpass2").value;
			var spps2= document.getElementById("spnew2");
			
			if((ps2 ==null ||ps2 =="") && (ps ==null || ps =="")){
				
			    state=true;
			}else{
				if(ps==ps2){
					spps2.innerHTML="<span style='color:green'>OK</span>";
				 	state=true;
				}else{
					spps2.innerHTML="<span style='color:red'>你输入用户密码不一致,请重新输入</span>";
				   state=false;
				}
			}
	return state;	
}
//年龄验证
function onage(){
 		var vage = $('#age').val();
 		var regex =/^([1-9]|[0-9]{2}|120)$/;
 		if(vage!=null&&vage!=''){
 		 if(regex.test(vage)){
 		   $('#spage').html("<span style='color:green'>OK</span>");
 		 state=true;
 		 }else{
 		  $('#spage').html("<span style='color:red'>请输入1-100之间的数字</span>");
 		state=false;
 		 }
 		}else{
 		 $('#spage').html("<span style='color:red'>年龄不能为空</span>");
 		 state=false;
 		}
 	return state;
}

//验证电话
function onphone(){
	var vph=$('#phone').val();
	var regex=/^1[34578]\d{9}$/;
	//alert(vph);
 		if(vph!=null&&vph!=""){
 		  if(regex.test(vph)){
 		  	$('#spphone').html("<span style='color:green'>OK</span>");
 		  	state=true;
 		  }else{
 		    $('#spphone').html("<span style='color:red'>请输入正确的格式</span>");
 		    state=false;
 		  }
 		}else{
 		$('#spphone').html("<span style='color:red'>请输入电话号码</span>");
 		state=false;
 		}
 	return state;
}

//验证邮箱
function onemail(){
 	var vemail =$('#email').val();
 	//alert(vemail);
 	var regex=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
 	if(vemail != null && vemail !=''){
 	          if(regex.test(vemail)){
 	          	$('#spemail').html("<span style='color:green'>OK</span>");
 	            state=true;
 	          }else{
 	          	$('#spemail').html("<span style='color:red'>邮箱格式错误</span>");
 	          state=false;
 	          }
 	}else{
 	  $('#spemail').html("<span style='color:red'>不能为空</span>");
 	  state=false;
 	}
return state;
}

//验证入职日期
function oninttime(){
    var time = $('#inttime').val();
    if(time!=null &&time !=''){
    $('#spinttime').html("<span style= color:green>OK</span>");
    state=true;
    }else{
    $('#spinttime').html("<span style =color:red>日期不能为空！</span>");
    state=false;
    }
 return state;
}


//验证入职日期
function onouttime(){
    var time = $('#outtime').val();
    if(time==null){
    	$('#spouttime').html("<span style= color:green>OK</span>");
    	state=true;
    }else{
   	 	$('#spouttime').html("<span style =color:red>请输入合法的日期</span>");
    	state=false;
    }
 return state;
}

	


 //判断是否包含空格
  function kong(str){
		 var arr=new Array();
		 arr=str.split(' ');
		 if(arr.length != 1){
			 return 1;
		 }else{
			 return 0;
		 }
	  } 
//去掉字符串头尾空格   
  function trim(str) {   
      return str.replace(/(^\s*)|(\s*$)/g, "");   
  }
  
  //总验证&&ps2()login()&&
 function reCheck(){
 	//不修改密码的时候
 	var allstate=false;
 	var newpass=$('#newpass').val();
 	var newpass2=$('#newpass2').val();
 	if((newpass==null||newpass=="")&&(newpass2==null||newpass2=="")){
	 	if(checkLoginName()&&oninttime()&&onage()&&onphone()&&onemail()&&onuname){
			allstate=true;
		}else{
			alert("请根据提示更改数据！");
			allstate=false;
		}
 	}else{
	//修改了密码
		if(ps2()&&checkPs()&&checkLoginName()&&oninttime()&&onage()&&onphone()&&onemail()&&onuname){
			allstate=true;
			alert("修改成功!");
		}else{
			alert("请根据提示更改数据！");
			allstate=false;
		}
	}
	return allstate;

 }


</script>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>我的工作平台</li>
    <li>个人资料修改</li>
    
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
 
    <form action=" updateMyUser.action" method="post"  onsubmit="return reCheck();">
    <input type="hidden" name="u_id" value="${user.u_id }">
   <table width="60%" height="80%">
  
    <tr><td align="center">登录名:</td>  <td><input autocomplete="off" type="text" id="loginname" name="u_loginname" class="dfinput" value="${user.u_loginname}"  onkeyup="checkLoginName()"><span id="spname" style="display: inline-block;" ></span></td></tr>
    <tr><td align="center">用户名称: </td>  
    <td>
	    <input type="text" class="dfinput" id="uname" name="u_realname" value="${user.u_realname}" 
	    onblur="onuname()"><span id="spuname" style="display: inline-block;" ></span>
    </td></tr>
    <tr><td align="center">原密码:</td>  <td><input type="password" id="u_ps"  class="dfinput" onblur="ps()" readonly="readonly" name="u_password" value="${user.u_password}"><span id="spu_ps" style="display: inline-block;" ></span></td></tr>
    <tr><td align="center">新密码:</td>  <td><input type="password" id="newpass" onkeyup="checkPs()" name="u_repassword" class="dfinput" ><span style="display: inline-block;" id="spnew"></span></td></tr>
    <tr><td align="center">确认新密码:</td>  <td><input type="password" id="newpass2" onkeyup="ps2()" class="dfinput" > <span id="spnew2" style="display: inline-block;" ></span></td></tr>
    	<tr><td align="center">性别:</td>
    	    <td>
    	    <c:if test="${user.u_sex==0 }">
    	    	<input type="radio" value="0" name="u_sex" checked>男<input type="radio"  name="u_sex" value="1">女
    	    </c:if>
    	    <c:if test="${user.u_sex==1 }">
    	    	<input type="radio" value="0" name="u_sex" >男<input type="radio" value="1" name="u_sex" checked>女
    	    </c:if>
    	    </td></tr>
    <tr><td align="center">年龄:</td>  
	    <td>
	    <input type="text" id="age" name="u_age" class="dfinput" value="${user.u_age}" 
	   	 onblur="onage()"> <span id="spage" style="display: inline-block;" ></span>
	    </td>
    </tr>
    <tr><td align="center">入职日期:</td>  
	    <td>
		    <input type="text" onclick="WdatePicker()" id="inttime" name="u_intime" class="dfinput" value="${user.p_u_intime}" 
		    onblur="oninttime()">
		     <span id="spinttime" style="display: inline-block;" ></span>
	     </td>
     </tr>
	<tr><td align="center">离职日期:</td>  
		<td><input type="text"  onclick="WdatePicker()" name="u_outtime" class="dfinput" 
		value="${user.p_u_outtime}" onblur="onouttime()">
		<span id="spouttime" style="display: inline-block;" ></span>
		</td>
	</tr>
	<tr><td align="center">联系电话:</td>  
		<td><input type="text" id="phone" name="u_phone" class="dfinput" value="${user.u_phone}" 
			onblur="onphone()"><span id="spphone" style="display: inline-block;" ></span>
		</td>
	</tr>
	<tr><td align="center">邮箱:</td> 
		 <td><input type="text" id="email" name="u_email" class="dfinput" value="${user.u_email}" onblur="onemail()">
		 <span id="spemail" style="display: inline-block;" ></span>
		 </td>
	 </tr>
	<tr>
		<td 
			colspan="2" align="center"><input type="submit" value="保存修改"  class="scbtn">
	 	</td>
	 </tr>
</table>
   
    </form>
    </ul>
    </div>


</body>