<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pole.jsp' starting page</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/select.css" rel="stylesheet" type="text/css" />
	 <link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="js/select-ui.min.js"></script>
	<script type="text/javascript" src="editor/kindeditor.js"></script>
	<script type="text/javascript" src="js/line/add.js"></script>
	<script src="js/ace-extra.min.js"></script>
	
<script type="text/javascript">
	   
   </script>

  </head>
  
  <body>
   <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="right.jsp">首页</a></li>
    
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加信息</span></div>
    	
<form action="addLine.action" method="post" onsubmit="return tijiao()">
    <ul class="forminfo">
    <li><label>线路编码</label><input id="li_code" name="li_code" onkeyup="checkCode()"  type="text" class="dfinput" />
    <font id="tex0"  size="3px" face="宋体"><i>线路编码在6到30个字符之间</i></font></li>
    <li><label>线路名称</label><input id="li_name"  name="li_name" type="text" class="dfinput" onblur="testK()" />
    <font id="tex1"  size="3px" face="宋体"><i>请输入3-20个字符</i></li>
    <li><label>回路长度</label><input id="li_backlength" name="li_backlength" type="text" class="dfinput" onblur="testH()" />
  <font id="tex2"  size="3px" face="宋体"><i>请输入整数</i></font></li>
    <li><label>投运时间</label><input name="li_totime"  id="d1" type="text" onblur="time()" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d1\')||\'%y-%M-%d %H:%m:%s\'}'})"  class="dfinput"  /><img onclick="WdatePicker({el:'d1'})" src="My97DatePicker/skin/datePicker.gif" width="16" height="22" />
        <font id="tex8"  size="3px" face="宋体"><i>请输入正确格式</i></font>  </li>
    <li><label>电压等级</label><input id="li_presslevel"  name="li_presslevel" type="text" class="dfinput" onblur="testP()"/>
    <font id="tex4"  size="3px" face="宋体"><i>单位为V（请输入整数）</i></font></li>
    <li><label>起始杆号</label><input  id="li_beginpole" id="li_beginpole"  name="li_beginpole" type="text" class="dfinput" onblur="test01()"/>
   <font id="tex5"  size="3px" face="宋体"><i>多个关键字用,隔开</i></font></li>
    <li><label>终止杆号</label><input id="li_endpole" name="li_endpole" type="text" class="dfinput" onblur="test02()"/>
   <font id="tex6"  size="3px" face="宋体"><i>多个关键字用,隔开</i></font></li>
    <li><label>塔基数</label><input readonly="readonly" id="li_count" name="li_count" type="text" class="dfinput" /><i>输入数字</i></li>
    <li><label>启用状态</label>
	<cite><input  name="li_state" type="radio" value="0" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;
	<input id="li_state" name="li_state" type="radio" value="1" />不可用</cite></li> 
    <li><label>备注</label><textarea id="li_dess" name="li_dess" cols="" rows="" class="textinput"></textarea>
    </li>
   
    <li><label>&nbsp;</label><input id="baocun" type="submit" class="btn" value="确认保存"/>&nbsp;&nbsp;&nbsp;<input id="backtn"  type="button" class="btn" value="返回"/>
    </li>
   
    </ul>
</form>
    </div>
   <script type="text/javascript">
 	$(function (){
	$('#backtn').click(function (){
	     	window.location.href="getAllLine.action";
	     });
	});
 </script>
 <script type="text/javascript">
 	
 </script>
 <script type="text/javascript">
 
 		
 </script>
  <script type="text/javascript">
    
    </script>
    
    
    
    
  </body>
</html>
