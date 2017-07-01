/**
 * 巡检添加界面
 */
$(function(){
var date=new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-" +new Date().getDate();
$('#p_issued_time').val(date);
$('#selectLine').change(function(){
	var obj="lid="+$('#selectLine').val();
	$.getJSON('getPoleByLine.action',obj,function(data){
		//起始塔杆初始化
		var p_strnum=document.getElementById("p_strnum");//如果这个id没有查到  值  
		p_strnum.innerHTML="";
		if(data == ""){
			var option = new Option("此线路下没有塔杆",-1);
			p_strnum.options.add(option);
		}
		for(var i=0;i<data.length;i++){
			var option = new Option(data[i].pole_code,data[i].pole_id);
			p_strnum.options.add(option);
		}
		//终止塔杆初始化
		var p_endnum=document.getElementById("p_endnum");
		p_endnum.innerHTML="";
		if(data == ""){
			var option = new Option("此线路下没有塔杆",-1);
			p_endnum.options.add(option);
		}
		for(var i=0;i<data.length;i++){
			var option = new Option(data[i].pole_code,data[i].pole_id);
			p_endnum.options.add(option);
		}
	});
	
});

$('#backbtn').click(function(){
	window.location.href="getAllPatrol.action";
});

$('#p_strnum').change(function(){
	var obj="lid="+$('#selectLine').val();
	$.getJSON('getPoleByLine.action',obj,function(data){
	var p_endnum=document.getElementById("p_endnum");
		p_endnum.innerHTML="";
		if(data == ""){
			var option = new Option("此线路下没有塔杆",-1);
			p_endnum.options.add(option);
		}
		for(var i=0;i<data.length;i++){
			var str=$('#p_strnum').val();
			var code;
			for(var i2=0;i2<data.length;i2++){
				if(data[i].pole_id==str){
					code=data[i].pole_code;
					break;
				}
			}
			
				if(data[i].pole_code>=code){
					var option = new Option(data[i].pole_code,data[i].pole_id);
					p_endnum.options.add(option);
				}
			}
		});
	});

});
function checkState(mark){
	if(mark==1){
		alert("提示:添加成功!");
	}
}
//任务名称
function checkPname(){
	var state=false;
	var pname=$('#p_name').val();
	var regex=/\s*$/g;
	var regex2=/^[\u4e00-\u9fa5_\!]{6,20}$/;
	if(!regex.test(pname)||pname.length==0){
		$('#spna').html("<font color='red'>&nbsp;任务名称不能为空</font>");
		state=false;
	}else if(!regex2.test(pname)){
		$('#spna').html("<font color='red'>&nbsp;请输入6-20位中文字符!</font>");
		state=false;
	}else{
		$('#spna').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
	state=true;
	}
	return state;
}
 function checkLine(){
 	var state=false;
	if($('#selectLine').val()!=-1 && $('#selectLine').val()!=null){
		$('#spli').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
		state=true;
	}else{
		$('#spli').html("<font color='red'>&nbsp;请选择线路!</font>");
		state=false;
	}
	return state;
} 
 function checkStrpole(){
 	var state=false;
	if($('#p_strnum').val()!=-1 && $('#p_strnum').val()!=null){
		$('#spsp').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
		state=true;
	}else{
		$('#spsp').html("<font color='red'>&nbsp;请选择起始塔杆!</font>");
		state=false;
	}
	return state;
} 
 function checkEndpole(){
 	var state=false;
	if($('#p_endnum').val()!=-1 &&$('#p_endnum').val()!=null ){
		$('#spep').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
		state=true;
	}else{
		$('#spep').html("<font color='red'>&nbsp;请选择终止塔杆!</font>");
		state=false;
	}
	return state;
} 
function reCheck(){
	var state=false;
	if(checkEndpole()&checkStrpole()&checkPname()&checkLine()){
		state=true;
	}else{
		alert("提示:请根据提示更改数据!");
		state=false;
	}
	return state;
}