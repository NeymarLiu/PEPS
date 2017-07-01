/**
 * 
 */
$(function(){
	$('#backbtn').click(function(){
		window.location.href="getAllPatrol.action";
	});
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
				if(data[i].pole_id>=str){
					var option = new Option(data[i].pole_code,data[i].pole_id);
					p_endnum.options.add(option);
				}
			}
		});
 		});
     	
});
function checkState(mark){
	if(mark==1){
		alert("提示:修改成功!");
		window.location.href="getAllPatrol.action";
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
function getCount(){
	var d =document.getElementsByName("u_id");
	var b=false;
	for (var i = 0; i < d.length; i++) {
		if(d[i].checked){
			b=true;
			break;
		}
	}
	if(b){
		$('#sppp').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
	}else{
		$('#sppp').html("<font color='red'>&nbsp;请选择巡检员!</font>");
	}
	return b;
}