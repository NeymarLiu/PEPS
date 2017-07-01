<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://testTag/lxc" prefix="p" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script src="js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
              function back(){
               location.href="getAllUsers.action";
               }
 
		KE.show({
			id : 'content7',
			cssPath : './index.css'
		});
	</script>

	<script type="text/javascript">
		$(document).ready(function(e) {

			$(".select3").uedSelect({
				width : 152
			});
		});
	</script>
	
</head>
<body class="sarchbody">
<input id="purl" type="hidden" value="getAllLogById.action?uid=${lpp.uid}&qtime=${lpp.qtime}&htime=${lpp.htime}"/>
	<script language="javascript">
			$(document).ready(function() {
				$(".scbtn1").click(function() {
					if ($(".seachform2").hasClass("hideclass")) {
						$(".seachform2").removeClass("hideClass");
					} else {
						$(".seachform2").addClass("hideClass");
					}
				});
			});
		</script>

		<script type="text/javascript">
			$(document).ready(function() {
				$(".scbtn1").click(function() {
					$(".seachform2").fadeIn(200);
				});
			});
		</script>
	<script type="text/javascript">
	 $('#sure').click(function(){
		var page=$('#goPage').val();
		if(page==''){
			alert("提示:请填写正确的页数!");
		}else{
		window.location.href=$('#purl').val()+"&nowPage="+page;		
		}	 
 	 });
</script>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">系统设置</a></li>
		</ul>
	</div>

	<div class="formbody">
	<div id="usual1" class="usual">
	<form action="getAllLogById.action">		
		<ul class="seachform1">			
			<li>
				<label>操作时间</label>
				<input type="hidden" name="uid" value="${lpp.uid }"/>
				<input name="qtime" id="qtime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'htime\')||\'%y-%M-%d\'}'})"  value="${lpp.p_qtime }" class="scinput1" />-
                <input name="htime" id="htime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'qtime\')}',maxDate:'%y-%M-%d'})" value="${lpp.p_htime }" class="scinput1" />
			
			<%--  <input name="qtime" id="qtime" type="text" onfocus="WdatePicker()"  value="${lpp.p_qtime }" class="scinput1" />-
                <input name="htime" id="htime" type="text" onfocus="WdatePicker()" value="${lpp.p_htime }" class="scinput1" />
			 --%>
			</li>
			<li >
				<input type="submit" class="scbtn" value="查询"  />
			</li>
		</ul>
	</form>
		<div class="formtitle">	
			<span>log日志</span>
		</div>	
			<table class="tablelist">
				<thead>
					<tr>
						<th>序号</th>
						<th>用户名称</th>
						<th>操作信息</th>
						<th>操作时间</th>
                	</tr>
				</thead>
				<tbody>
				<c:forEach items="${logList}" var="log" varStatus="s">
				<tr>
					<td>${s.count}</td>
					<td>${log.up.u_realname}</td>
					<td>${log.log_info}</td>
					<td>${log.p_log_time}</td>
                 </tr>
				</c:forEach>					
				</tbody>
			</table>
		
		<table class="tablelist2">
       <tr>
         <th > <p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllLogById.action?uid=${lpp.uid}&qtime=${lpp.qtime}&htime=${lpp.htime}" 
  				totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
         <input type="button" class="scbtn5" value="返回" onclick="back()"/>
         </th>
         </tr>
         </table>
	</div>
	</div>
</body>
</html>