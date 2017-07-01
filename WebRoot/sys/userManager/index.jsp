<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://testTag/lxc" prefix="p" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript">
	function del(obj) {
		if(confirm("确认删除？")){
			window.location.href="deleteUser.action?uid="+obj;
		}
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
<input id="purl" type="hidden" value="getAllUsers.action?u_realname=${upp.u_realname}&u_state=${upp.u_state}"/>
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
	
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">系统设置</a></li>
		</ul>
	</div>
	<div class="formbody">
		<form action="getAllUsers.action">
			<div id="usual1" class="usual">
				<ul class="seachform1">
					<li><label>用户名称</label> 
					<input type="hidden" value="${upp.u_state}" id="state"/>
					<input name="u_realname" type="text" value="${upp.u_realname}" class="scinput1" /></li>
					<li><label>用户状态</label>
						<div class="vocation">
							<select class="select3" name="u_state">
							<c:if test="${upp.u_state==-1}">
								<option value="-1" id="m" selected="selected">-请选择-</option>
								<option value="0" id="m0" >启用</option>
								<option value="1" id="m1">未启用</option>
								
							</c:if>
								<c:if test="${upp.u_state==0}">
								<option value="-1">-请选择-</option>
									<option value="0" selected="selected">启用</option>
									<option value="1" >未启用</option>
								</c:if>
								<c:if test="${upp.u_state==1}">
								<option value="-1" >-请选择-</option>
									<option value="0" >启用</option>
									<option value="1" selected="selected">未启用</option>
								</c:if>
							</select>
						</div></li>
					<li><input type="submit" class="scbtn" value="查询" /> <input
						type="button" class="scbtn" value="添加"
						onclick="javascript:location.href='toAddUser.action'" /></li>
				</ul>
			</div>
		</form>
		<div class="formtitle">
			<span>用户信息</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th>用户账号</th>
					<th>用户名称</th>
					<th>角色</th>
					<th>邮箱</th>
					<th>最后登录时间</th>
					<th>状态（正常/冻结）</th>
					<th>操作</th>
				</tr>
			</thead>

			<tbody>
			<c:if test="${uList != null }">
			<c:forEach var="u" items="${uList }">
	<tr>
					<td>${u.u_loginname }</td>
					<td>${u.u_realname }</td>
					<td>${u.rolePojo.r_name }</td>
					<td>${u.u_email }</td>
					<td>${u.p_u_logintime }</td>
					<c:if test="${u.u_id == loginUser.u_id}">
					<td>启用</td>
					<td>冻结|修改|删除|
						<a href="getAllLogById.action?uid=${u.u_id }" class="tablelink"> LOG日志</a></td>
					</c:if>
					<c:if test="${u.u_id != loginUser.u_id}">
					<c:if test="${u.u_state==0 }"><td>启用</td>
					<td><a href="updateUserState.action?u_state=1&u_id=${u.u_id }" class="tablelink" >冻结|</a> <a
						href="toUpdateUser.action?uid=${u.u_id }" class="tablelink"> 修改|</a> <a
						href="javascript:void(0)" onclick="del(${u.u_id })" class="tablelink">删除|</a>
						<a href="getAllLogById.action?uid=${u.u_id }" class="tablelink"> LOG日志</a></td></c:if>
					<c:if test="${u.u_state==1 }">
					
					<td>冻结</td>
					<td><a href="updateUserState.action?u_state=0&u_id=${u.u_id }" class="tablelink">启用|</a> <a
						href="toUpdateUser.action?uid=${u.u_id }" class="tablelink"> 修改|</a> <a
						href="javascript:void(0)" onclick="del(${u.u_id })" class="tablelink">删除|</a>
						<a href="getAllLogById.action?uid=${u.u_id }" class="tablelink"> LOG日志</a></td>
					</c:if>
					</c:if>
				</tr>
	</c:forEach>
			
			</c:if>
				
			</tbody>
		</table>
		
		<table class="tablelist2">
			<tr>
				<th>
					<p:page pageSize="${page.pageSize==null?3:page.pageSize}" url="getAllUsers.action?u_realname=${upp.u_realname}&u_state=${upp.u_state}" 
  	totalPage="${page.totalPage}" count="${page.count}" nowPage="${page.nowPage}"/>
				</th>
			</tr>
		</table>

	</div>
</body>
</html>
