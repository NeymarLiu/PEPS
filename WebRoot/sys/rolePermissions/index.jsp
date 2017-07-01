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
 
 <style type="text/css">
    .f1{
    font-size:16px;
    padding-left:15px
    
    }
    
    .h1{
       font-size:18px;
       padding-left:0px
      
    }
 </style>
 
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 120

	});
});

   
</script>
<script type="text/javascript">
	$(function(){
		$('#rid').change(function(){
			var id=$('#rid').val();
			if(id!=-1){
				id="id="+$('#rid').val();
				$.getJSON('roleToMenu.action',id,function(data){
					var resultList = data;
					//alert(resultList);
						$(':checkbox[type="checkbox"]').attr("checked",false);
							for(var i=0;i<resultList.length;i++){
									//alert(resultList[i]);
								$(':checkbox[value="'+resultList[i]+'"]').attr("checked",true);
							};
					
					
				});
			}
			
		});
	});
</script>
<script type="text/javascript">
$(function(){
	$(':checkbox[type="checkbox"]').change(function(){
		var b=this.id;
		var j=b.charAt(0);	
		if(j=="f"){
			b="s"+b.substring(1);
			if(this.checked){
				$(':checkbox[id^="'+b+'"]').attr("checked",true);
			}else{
				$(':checkbox[id^="'+b+'"]').attr("checked",false);
			}
		}else if(j=="s"){
			b="f_"+b.split("_")[1];
			if(this.checked){
				$(':checkbox[id^="'+b+'"]').attr("checked",true);
			}else{
				var c= "s_"+b.split("_")[1];
				var cc=$(':checkbox[id^="'+c+'"]');
				var flag=1;
				for(var i=0; i< cc.length;i++){
					var ff=cc[i].checked;
					if(ff==true){
						flag=0;
					}				
				}
				if(flag==1){
					$(':checkbox[id^="'+b+'"]').attr("checked",false);
				}
				
			}
		}
	});
	
});

</script>
<script type="text/javascript">
function tt(){
	var rid=document.getElementById("rid").value;
	var name=document.getElementsByName("mid");
	var v=0;
	var d=false;
	for(var i=0;i<name.length;i++){
		if(name[i].checked){
			v=v+1;
		}
	}
	if(rid==-1){
 		alert("请选择对应角色操作项");
 	}else{
 		if(v>0){
 			d=true;
 		}else{
 			alert("请为角色添加权限！");
 		}
 	}
	return d;
}

</script>
</head>

<body class="sarchbody" onload="test()">
<input type="hidden" value="${isok }" id="isok" />
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">系统管理</a></li>
    <li><a href="#">角色权限配置</a></li>
    </ul>
    </div>   
    <form class="f1" name="form2" onsubmit="return tt()" action="toRoleSomePermissions.action" method="post">
    <table class="tablelist3">
     
     <tr>
     <td> 
     <div id="usual1" class="usual"> 
     <div class="formbody">  
    <ul class="seachform1">
 
    <li>
    <div class="vocation">
    <select name="rid" id="rid" class="select3">
    	<option value="-1">--请选择角色--</option>
    	<c:forEach items="${rList}" var="r">
    	<option  value="${r.r_id }">${r.r_name }</option>
    	</c:forEach>
    </select>
    </div>
    </li>   
   <li> <input name="" type="submit" class="scbtn1" value="保存配置"/> </li>
    </ul>
	</div> 
	
    </div>
</td>
</tr>

<tr><td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
	<p class="h1">赋角色权限:</p>
	<c:forEach items="${mList }" var="m">
		<c:if test="${m.m_father==0 }">
			&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="mid" id="f_${m.m_id }" value="${m.m_id }"/>${m.m_name }<br/>
			<c:forEach items="${mList }" var="me">
				<c:if test="${m.m_id==me.m_father }">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="mid" id="s_${m.m_id }_${me.m_id }" value="${me.m_id }"/>${me.m_name }<br/>
				</c:if>
			</c:forEach>
		</c:if>
	</c:forEach>
	</td>
    </tr>
  </table>  
  </form>
    
</body>

</html>