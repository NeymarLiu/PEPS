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
<input type="hidden" value="getAllFlaw.action?_name=${ffp.f_name}" id="purl">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>缺陷管理</li>
    <li>缺陷类型设置</li>
    
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
    <ul class="seachform1">
    <form action="getAllFlaw.action" method="post">
    <li><label>类型名称</label><input name="f_name" type="text" class="scinput1" value="${ffp.f_name }"/></li>
  <li><input  type="submit" class="scbtn" value="查询"/>&nbsp;
  </form>
  <input  id="add"  type="button" class="scbtn1" value="添加缺陷类型"/></li>
    
    </ul>
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 

  
  $('#add').click(function(){
	  location.href="flaw/type/add.jsp";
  });
  
 
});

 function deleteFlaw(f_id){
  	  if(confirm("确认删除？")){
  		  window.location.href="UpdateFlawPojo2.action?f_id="+f_id+"&f_state=2";
  	  }
    }
</script>
    <table class="tablelist" >
    	<thead>
    	<tr>
        
        <th>缺陷类型名称</th>
        <th>状态(启用/未启用)</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
     	<c:forEach var="f" items="${fpList}">
        <tr>
       
        <td>${f.f_name}</td>
        <c:if test="${f.f_state ==0}"> 
        <td>启用</td>
        </c:if>
        <c:if test="${f.f_state ==1}"> 
        <td>停用</td>
        </c:if>
        <td><a href="toUpdateFlawPojo.action?f_id=${f.f_id}" class="tablelink">修改</a>  |   
            <a href="javascript:void(0)" onclick="deleteFlaw('${f.f_id}')" class="tablelink"> 删除</a></td>
        </tr> 
     	 </c:forEach>
       
       
        </tbody>
    </table>
    <table class="tablelist2">
       <tr>
         <th>
         <p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllFlaw.action?_name=${ffp.f_name}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
      
	</div> 
    </div>
</body>

</html>
