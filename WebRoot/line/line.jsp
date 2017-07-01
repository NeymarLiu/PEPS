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
<script type="text/javascript" src="js/line/line.js"></script>
<script type="text/javascript">


</script>


  </head>
  <body class="sarchbody" >
  <input type="hidden" id="purl" value="getAllLine.action?li_name=${lc.li_name}">
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a>首页</a><li><a>基本内容</a></li></li>
    
    </ul>
    </div>
     <div class="formbody">
    <div id="usual1" class="usual"> 
    <ul class="seachform1">
    <form action="getAllLine.action">
    <li><label>线路名称：</label>
       
    	<input name="li_name" type="text" class="scinput1" value="${lc.li_name}"/></li>
		<input  type="submit" class="scbtn" value="查询"/> &nbsp;&nbsp;
   <input name="" id="addLine" type="button" class="scbtn1" value="添加线路"/> </li>
   </form>
    </ul>
    <br><br>
    <table class="tablelist">
    	<thead>
    	<tr>
       
        <th>线路编号<i class="sort"></i></th>
        <th>线路名称</th>
        <th>起始杆号</th>
        <th>终止杆号 </th>
        <th>塔基数 </th>
        <th>运行状态 </th>
        <th>状态（启用/停用） </th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        
          
          <c:forEach var="lp" items="${lpList}">
       			<tr>
			        
			        <td>${lp.li_code}</td>
			        <td>${lp.li_name}</td>
			        <td>${lp.li_beginpole}</td>
			        <td>${lp.li_endpole}</td>
			        <td>${lp.li_count }</td>
			        <td>${lp.li_run==0?"正常":"检测"}</td>
			        <td>${lp.li_state==0?"启用":"停用"}</td>
                		<%-- <c:if test="${lp.li_run ==0 }" >正常</c:if>
		        		<c:if test="${lp.li_run ==1 }" >检修</c:if>
		        	</td> --%>
		        	<td>
						<c:if test="${lp.li_state ==1 }">
							<a href="javascript:void(0)"  class="tablelink(1)" onclick="ls('${lp.li_id}','0','0')" >启用
						</a></c:if>
		        		<c:if test="${lp.li_state ==0 }">
		        			<a href="javascript:void(0)"  class="tablelink(1)" onclick="ls('${lp.li_id}','1','1')" >停用</a>
		        		</c:if>&nbsp;
		        		<a href="javascript:void(0)"  onclick="ls('${lp.li_id}','2','1')" class="tablelink">删除</a> &nbsp; 
		        		<a href="toUpdateLine.action?liid=${lp.li_id }" class="tablelink" > 修改</a>
				</td>
		        </tr>
       
       
       
       </c:forEach>


        



        </tbody>
        </table>
       
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
    </div>
    
    <script type="text/javascript">
	
	</script>

 <table class="tablelist2">
       <tr>
         <th><p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllLine.action?li_name=${lc.li_name}"
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         </th>
       </tr>
    </table>
     </div>
     </div>
    </body>
</html>


