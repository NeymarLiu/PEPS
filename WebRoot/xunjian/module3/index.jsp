<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="p" uri="http://testTag/lxc"%>
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
  
<script type="text/javascript" src="js/xunjian/module3/index.js"></script>
</head>
<body class="sarchbody" >
<input id="pstate" type="hidden" value="${fptp.p_state}">
<input id="purl" type="hidden" value="getAllCompletePatrol.action?p_num=${fptp.p_num}&p_state=${fptp.p_state}"> 	
<input id="nowPage" value="${page.nowPage}" type="hidden">
<input id="pcount" value="${page.count}" type="hidden">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>巡检任务管理</li>
    <li>缺陷查询</li>
    
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    <ul class="seachform1">
    <form action="getAllCompletePatrol.action" method="post">
    <li><label>任务编号</label><input id="p_num" name="p_num" type="text" class="scinput1" value="${fptp.p_num}"/></li>
    <li><label>缺陷类型</label>  
    <div class="vocation">
   <select class="select3" id="p_state" name="p_state">
        <option value="-1">--请选择--</option>
         <c:forEach items="${flawList }" var="flaw">
         <option value="${flaw.f_id}">${flaw.f_name }
         </c:forEach>
    </select>
    </div>
    </li>
  <li><input  type="submit" class="scbtn" value="查询"/>&nbsp;
      
  </form>
  <input  type="submit" class="scbtn" id="export" value="导出EXCEL"/>&nbsp;
    
    </ul>

    <table class="tablelist" >
    	<thead>
    	<tr>
        
        <th>任务编号</th>
        <th>线路编号</th>
        <th>杆塔编号</th>
        <th>缺陷级别</th>
        <th>缺陷类型</th>
        <th>发现人</th>
         <th>发现时间</th>
         <th>下发人</th>
          <th>下发时间</th>
          <th>完好率</th>
           <th>缺陷描述</th>
        </tr>
        </thead>
        <tbody>
     <c:forEach items="${pList}" var="p">
      <tr>
        <td>${p.p_num}</td>
        <td>${p.li_code}</td>
        <td>${p.pole_code}</td>
        <td>${pf_flaw_grade}${p.pf_flaw_grade==1?"一般":p.pf_flaw_grade==2?"严重":p.pf_flaw_grade==3?"紧急":""}</td>
        <td>
        <c:forEach items="${flawList }" var="flaw">
			<c:if test="${flaw.f_id==p.pf_flaw}">${flaw.f_name }</c:if>
         </c:forEach>
        </td>
        <td>${p.pf_find_people }</td>
        <td>${p.find_time }</td>
        <td>${p.p_issued_name }</td>
        <td>${p.issued_time }</td>
        <td>${p.pf_flaw_rate}%</td>
        <td>${p.pf_remark}
         </td>
        </tr> 
     
     </c:forEach>

        </tbody>
    </table>
    <table class="tablelist2">
       <tr>
         <th><p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllCompletePatrol.action?p_num=${fptp.p_num}&p_state=${fptp.p_state}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
      
	</div> 
    </div>
</body>

</html>
