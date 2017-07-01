<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://testTag/lxc" prefix="p"%>
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

function getMark(mark){
	if(parseInt(mark)==1){
	alert("操作成功!");
	}
}
</script>
</head>

<body class="sarchbody" onload="getMark(${mark})">
<input id="purl" type="hidden" value="getAllSureFlawPojo.action?p_num=${fsp.p_num}&li_code=${fsp.li_code}">
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
    <form action="getAllSureFlawPojo.action" method="post">
    <li><label>任务编号</label><input name="p_num" type="text" class="scinput1" value="${fsp.p_num }"/></li>
     <li><label>线路编号</label><input name="li_code" type="text" class="scinput1" value="${fsp.li_code}"/></li>
    
  <li><input  type="submit" class="scbtn" value="查询"/>&nbsp;
  </form>
  <input  type="button" id="sureFlaw" class="scbtn1" value="保存"/></li>
    
    </ul>
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 
  });
 $('#sureFlaw').click(function(){
 	 var d=document.getElementsByName("state");
 	 var flag=false;
 	 var arr=new Array();
 	 var j=0;
 	 for (var i = 0; i < d.length; i++) {
		if(d[i].value.split("_")[1]!=-1){
 	 	arr[j]=d[i].value;
 	 	j++;
		 flag=true;
		}
	}
	if(flag){
		window.location.href="sureFlaw.action?arr="+arr;
	}else{
		alert("请至少确认一条数据后提交!");
	}
	
 
 });
</script>
    <table class="tablelist" >
    
    	<thead>
    	<tr>
        
        <th>任务编号</th>
        <th>线路编号</th>
        <th>塔杆编号</th>
        <th>缺陷类型</th> 
        <th>完好率</th>
        <th>缺陷描述</th>
        <th>发现时间</th>
        <th>发现人员</th>
        <th>缺陷级别</th>
        </tr>
        </thead>
        <tbody>
     	<c:forEach var="p" items="${ptaskList}">
        <tr>       
         <td>${p.p_num}</td>
         <td>${p.li_code}</td>
         <td>${p.pole_code }</td>
         <td>
         <c:forEach var="flaw" items="${fList }">
         	<c:if test="${p.pf_flaw==flaw.f_id }">
         	${flaw.f_name }
         	</c:if>
         	
         </c:forEach>
         
         </td>
         <td>${p.pf_flaw_rate}%</td>
         <td>${p.pf_remark}</td>
         <td>${p.find_time }</td>
         <td>${p.pf_find_people }</td>
         <td>  <div class="vocation">      
              <select class="select3"  name="state"  ><option value="${p.pf_id }_-1">--请选择--</option>
                		<option value="${p.p_id }_${p.pf_id }_1">一般</option>
                        <option value="${p.p_id }_${p.pf_id }_2">严重</option>
                        <option value="${p.p_id }_${p.pf_id }_3">紧急</option>
              </select> </div>   
         </td>
        </tr> 
       </c:forEach>
        </tr> 
        
       
        </tbody>
    </table>
    <table class="tablelist2">
       <tr>
         <th>
         <p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllSureFlawPojo.action?p_num=${fsp.p_num}&li_code=${fsp.li_code}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
      
	</div> 
    </div>

<font color="red"><h1>说明:确认级别后的数据在列表中不再显示<h1></font>
</body>

</html>
