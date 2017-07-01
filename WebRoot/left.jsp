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
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8"> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active");
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
});	
</script>


</head>

<body style="background:#fff3e1;">
	
    
    <dl class="leftmenu">
    
        <c:forEach items="${menuList}" var="m" >
	    <dd>
	    <c:if test="${m.m_father==0 }" >
		    <div class="title">
		    <c:if test="${m.m_id%4==0 }"><span><img src="images/leftico01.png" /></span>${m.m_name }</c:if>
		    <c:if test="${m.m_id%4==1 }"><span><img src="images/leftico02.png" /></span>${m.m_name }</c:if>
		    <c:if test="${m.m_id%4==2 }"><span><img src="images/leftico03.png" /></span>${m.m_name }</c:if>
		    <c:if test="${m.m_id%4==3 }"><span><img src="images/leftico04.png" /></span>${m.m_name }</c:if>
		    </div>
		    <ul class="menuson">
	        <c:forEach var="me" items="${menuList}">
	        	<c:if test="${me.m_father  ==  m.m_id }">
	        	<li>
	            <div class="header">
	            <cite></cite>
	            <a href="${me.m_url}" target="rightFrame">${me.m_name }</a>
	            </div>
	        </li>
	        	</c:if>
	        </c:forEach>
	        
	        </ul> 
	    </c:if>
	     
	    
	    	  
	    </dd>
        </c:forEach> 
        
    <%-- <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>我的工作平台
    </div>
    	<ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="mywork/task.jsp" target="rightFrame">待办列表</a>
            </div>
           
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="" target="rightFrame">个人资料修改</a>
            
            </div>                
           
        </li>
        
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>系统管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="sys/roleManager/index.jsp" target="rightFrame">角色管理</a></li>
        <li><cite></cite><a href="sys/userManager/index.jsp" target="rightFrame">用户管理</a></li>
         <li><cite></cite><a href="sys/menu/index.jsp" target="rightFrame">菜单管理</a></li>
        <li><cite></cite><a href="sys/rolePermissions/index.jsp" target="rightFrame">角色权限配置</a></li>
        <li><cite></cite><a href="sys/system/index.html" target="rightFrame">系统配置</a></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" />
    </span>塔杆管理</div>
         <ul class="menuson">
        <li><cite></cite><a href="pole/pole.jsp" target="rightFrame">塔杆管理</a></li>
       
        </ul>    
     </dd> 
         
     <dd><div class="title"><span><img src="images/leftico03.png" />
     </span><a href="line/line.html" target="rightFrame">线路管理</a></div>
       <ul class="menuson">
        <li><cite></cite><a href="line/line.jsp" target="rightFrame">线路管理</a></li>
        
       
        </ul>    
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>缺陷管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="quexian/type/index.jsp" target="rightFrame">缺陷类型设置</a></li>
        <li><cite></cite><a href="quexian/level/index.jsp" target="rightFrame">缺陷等级确认</a></li>
        
    </ul>
    </dd>   
    
     <dd><div class="title"><span><img src="images/leftico04.png" /></span>巡检任务管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="getAllPatrol.action" target="rightFrame">巡检任务制定与分配</a></li>
        <li><cite></cite><a href="xunjian/module2/index.html" target="rightFrame">巡检任务执行与回执</a></li>
        <li><cite></cite><a href="xunjian/module3/index.html" target="rightFrame">缺陷查询</a></li>
    </ul>
    </dd>
    
     <dd><div class="title"><span><img src="images/leftico04.png" /></span>消缺任务管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="getAllPatrol.action" target="rightFrame">消缺任务制定与分配</a></li>
        <li><cite></cite><a href="xiaoque/module2/index.html" target="rightFrame">消缺任务执行与回执</a></li>
        <li><cite></cite><a href="xiaoque/module3/index.html" target="rightFrame">消缺查询</a></li>
    </ul>
    </dd>
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>信息统计</div>
    <ul class="menuson">
        <li><cite></cite> <a href="xinxi/EliminatingEcord.jsp" target="rightFrame">巡检记录统计</a></li>
         <li><cite></cite> <a href="xinxi/InspectionEcord.jsp" target="rightFrame">消缺记录统计</a></li>
    </ul>
    </dd> --%>
    
    </dl>
    
</body>
</html>
