<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://testTag/lxc" prefix="p" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>无标题文档</title>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
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

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body class="sarchbody" >
<input id="purl" type="hidden" value="getAllRoles.action?r_name=${rpp.r_name}&r_state=${rpp.r_state }">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>系统管理</li>
    <li>角色管理</li>
    
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual">  
    <ul class="seachform1">
    <li>
    <form action="getAllRoles.action" method="post">
    <li><label>角色名称</label><input name="r_name" type="text" class="scinput1" value="${rpp.r_name }"/></li>
    <li><label>启用状态</label>  
    <div class="vocation">
    <select class="select3" id="r_state"  name="r_state"  >
    		<c:if test="${rpp.r_state==-1}">
    			<option value="-1" selected="selected">请选择</option>	       
				<option value="0" >启用</option>
				<option value="1">未启用</option>
			</c:if>
    		<c:if test="${rpp.r_state==0}">
    			<option value="-1">请选择</option>	       
				<option value="0" selected="selected">启用</option>
				<option value="1">未启用</option>
			</c:if>
			<c:if test="${rpp.r_state==1}">
				<option value="-1">请选择</option>
				<option value="0" >启用</option>
				<option value="1" selected="selected">未启用</option>
			</c:if>
		</select>
    	
	  
    </select>
    </div>
    </li>
  <li><input  type="submit" class="scbtn" value="查询"/>&nbsp;
  </form>
  </li>
  <li><input name="" id="add"  type="button" class="scbtn1" value="添加角色"/></li>
    
    </ul>
    
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 

  $('#add').click(function(){
	  location.href="toAddRole.action";
  });
  });  
</script>
    <table class="tablelist" >
    	<thead>
    	<tr>
        
        <th>角色编号</th>
        <th>角色名称</th>
        <th>创建人</th>
        <th>更新时间</th>
        <th>创建时间</th>
        <th>状态(启用/未启用)</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${rList != null}">
        <c:forEach var="r" items="${rList}" varStatus="s">
     	<tr>
       
        <td>${r.r_number }</td>
        <td>${r.r_name }</td>
        <td>${r.r_createname }</td>
        <td>${r.p_r_uptime }</td>
        <td>${r.p_r_createtime }</td>
       
        <td><c:if test="${r.r_state==0 }">启用</c:if>
        <c:if test="${r.r_state==1 }">禁用</c:if></td>
       
        <td><a href="toUpdateRole.action?rid=${r.r_id }" class="tablelink">修改</a>  |   
            <a href="javascript:void(0)" onclick="del(${r.r_id })" class="tablelink"> 删除</a></td>
        </tr>
     
     </c:forEach>
        
        </c:if>
     
         
        </tbody>
    </table>
    <script type="text/javascript">
    function del(id){
    
  	  if(confirm("确认删除？")){
  		  location.href="deleteRole.action?rid="+id;
  	  }
    }
    </script>
    <table class="tablelist2">
       <tr>
         <th>
         
         <p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllRoles.action?r_name=${rpp.r_name}&r_state=${rpp.r_state }" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
      
	</div> 
    </div>
</body>

</html>
