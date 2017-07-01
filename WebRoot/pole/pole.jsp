<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://testTag/lxc"  prefix="p"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的工作平台</title>
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

   <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 

  $('#sure').click(function(){
	  var nowPage=$('#go').val();
	  if(nowPage!=""){
	  location.href="PoleController/index.do?nowPage="+nowPage;
	  }
  });
   });
   
   function updatePole(pole_id){
	   //禁用
	   if(confirm("确定停用？")){
	   window.location.href="updatePole.action?pole_id="+pole_id+"&pole_state=1";
	   }
   }
   function deletePole(pole_id){
	   //删除
	   if(confirm("确定删除？")){
	   window.location.href="updatePole.action?pole_id="+pole_id+"&pole_state=2";
	   }
   }
   function startPole(pole_id){
	   //删除
	  if(confirm("确定启用？")){
		  window.location.href="updatePole.action?pole_id="+pole_id+"&pole_state=0";
	  }
   }
   
   function getState(state){
	   if(state==1){
		alert("操作成功!");		   
	   }
   }
</script>

</head>
<body class="sarchbody" onload="getState('${state}')">
	<input type="hidden" id="purl" value="getAllPole.action?line_name=${fpp.line_name}">
    <div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li>首页</a></li>
		<li>基本内容</a></li>
	</ul>
    </div>
    
    <div class="formbody">
    <div id="usual1" class="usual"> 
	 <ul class="seachform1">
	<form action="getAllPole.action" method="post">
				<li><label>线路名称：</label><input name="line_name" type="text" class="scinput1" value="${fpp.line_name }"/></li>

				<!-- <li><input type="submit" class="scbtn1" value="清空" /> -->
					<li><input type="submit" class="scbtn" value="查询" /> 
	           </form>
	               <input name="" type="button" class="scbtn1" value="添加杆塔" onclick="location.href='toAddPole.action'" /></li><br/>
	         </ul><br>

	<table class="tablelist">
		<thead>
			<tr>
				
				<th>编号</th>
				<th>杆塔编号</th>
				<th>所属线路</th>
				<th>状态（停用/启用）</th>
				<th>修改</th>
				<th>停用</th>
				<th>删除</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
			<c:forEach var="p" items="${ppList}">
			<tr>
			
						<td>${p.pole_id }</td>
						<td>${p.pole_code }</td>
						<td>${p.linePojo.li_name }</td>
						<c:if test="${p.pole_state ==0}">
							<td>启 用</td>
						</c:if>
						<c:if test="${p.pole_state ==1}">
							<td>停 用</td>
						</c:if>
						
						<td><input type="button" onclick="location.href='toUpdatePoleInfo.action?pole_id=${p.pole_id}'" class="tablelink" value="修改" /></td>
						<c:if test="${p.pole_state==0}">
							<td><input type="button" class="tablelink" onclick="updatePole('${p.pole_id}')" value="停用" /></td>
						</c:if>
						<c:if test="${p.pole_state==1}">
							<td><input type="button" class="tablelink" onclick="startPole('${p.pole_id}')" value="启用" /></td>
						</c:if>
						<td><input type="button" class="tablelink" onclick="deletePole('${p.pole_id}')" value="删除" /></td>
						
						<!-- <a href="pole_edit.html">修改</a> -->
					</tr>
				</c:forEach>
	</tbody>

              </table>
				
	<table class="tablelist2">
       <tr>
         <th>
         <p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllPole.action?line_name=${fpp.line_name}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
    </div>
    </div>
    </body>
	</html>