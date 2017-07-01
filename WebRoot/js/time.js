window.onload = tick;
function tick()
{
var weekDayLabels = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
var now = new Date();
var year=now.getFullYear();
var month=now.getMonth()+1;
var day=now.getDate()
var Hours=now.getHours().toString(); 
var Minutes=now.getMinutes().toString(); 
var Second=now.getSeconds().toString();
var h1="0",m1="0",s1="0";
var h2,m2,s2;
if (Hours > 9)
{
	h1=Hours.substring(0,1); 
	h2=Hours.substring(1,2); 
}
else
{
	h1="0";
	h2=Hours;
}
if (Minutes>9)
{
	m1=Minutes.substring(0,1); 
	m2=Minutes.substring(1,2);
}
else
{
	m1="0";
	m2=Minutes;
}
if (Second>9)
{
	s1=Second.substring(0,1); 
	s2=Second.substring(1,2);
}
else
{ 
	s1="0";
	s2=Second;
}
var currentime = year+"年"+month+"月"+day+"日 "+weekDayLabels[now.getDay()];

$("#h1").html(h1);
$("#h2").html(h2);
$("#m1").html(m1);
$("#m2").html(m2);
$("#s1").html(s1);
$("#s2").html(s2);
$("#currentime").html(currentime);
//每隔0.1秒钟执行一次tick函数
window.setTimeout("tick()",1000);
}