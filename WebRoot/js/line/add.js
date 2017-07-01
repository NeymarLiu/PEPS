/**
 * 添加线路界面
 */
 KE.show({
	        id : 'content7',
	        cssPath : './index.css'
	    });

function testK(){
    	var li_names = false;
    	var val = document.getElementById("li_name").value;
    	var tes1= document.getElementById("tex1");
    	var regex=/[^u4e00-u9fa5]{3,20}$/g;
    	if(regex.test(val)){
    			li_names = true;
    			tes1.innerHTML="<font color=green>OK!</font>";
    		}else{
    			tes1.innerHTML="<font color=red>线路名称为3到20个汉字</font>";
    		}
   		
    	return li_names;
    }
var li_codes = false;
	function checkCode(){
			var li_code = $('#li_code').val();
			var regex = /^[A-Z]{2}[0-9]{4}$/;
			var tes = document.getElementById("tex0");
			if(regex.test(li_code)){
				$.ajax({
	 			type:"GET",
				url:"selectlicode.action?li_code="+li_code,
				success:function(data){
					if(data>0){
						tes.innerHTML="<font color=red>任务编号已存在，请修改</font>";
						li_codes = false;
					}else if(data==0){
						li_codes = true;
						tes.innerHTML="<font color=green>OK!</font>";
					}
				}
	 		});
			}else{
				tes.innerHTML="<font color=red>任务编号格式不对，请重新输入!如:XX0001</font>";
			li_codes = false;
			}	
			return li_codes;
		}; 
		/* 投运时间 */
	    function time(){
	    	var li_totimes = false;
	    	var val = document.getElementById("d1").value;
	    	var tes8 = document.getElementById("tex8");
	    	var regex=/[0-9]$/;
	    	if(regex.test(val)){
	    		if(val != 0){
	    			tes8.innerHTML="<font color=green>OK!</font>";
	    			li_totimes = true;
	    		}else{
	    			tes8.innerHTML="<font color=red>请输正确格式</font>";
	    		}
	    	}else{
	    		tes8.innerHTML="<font color=red>请输正确格式</font>";
	    	}
	    	return li_totimes;
	    }  
		 /* 电压等级 */
		 function testP(){
			var li_presslevels = false;
		 	var val = document.getElementById("li_presslevel").value;
	 		var tes4 = document.getElementById("tex4");
	 		var regex=/[0-9]$/;
	 		if(val != 0){
	 			if(regex.test(val)){
	 				li_presslevels = true;
	 				tes4.innerHTML="<font color=green>OK!</font>";
	 			}else{
	 				li_presslevels = false;
	 				tes4.innerHTML="<font color=red>请输入正整数</font>";
	 			}
	 		}else{
	 			li_presslevels = false;
	 			tes4.innerHTML="<font color=red>请输入正整数</font>";
	 		}
	 		return li_presslevels;
		 }
		 /* 回路长度 */
		 function testH(){
		 	var li_backlengths = false;
		 	var val = document.getElementById("li_backlength").value;
	 		var tes2 = document.getElementById("tex2");
	 		var regex=/[0-9]$/;
	 		if(val != 0){
		 		if(regex.test(val)){
		 			li_backlengths = true;
		 			tes2.innerHTML="<font color=green>OK!</font>";
		 		}else{
		 			tes2.innerHTML="<font color=red>请输入正整数</font>";
		 		}
	 		}else{
	 			tes2.innerHTML="<font color=red>请输入正整数</font>";
	 		}
	 		return li_backlengths;
		 }
	 	/* 起始塔杆 */
	 	function test01(){
	 		var li_beginpoles = false;
	 		var val = document.getElementById("li_beginpole").value;
	 		var tes5 = document.getElementById("tex5");
	 		var regex=/^[A-Z]{2}[0-9]{4}[_][0-9]{6}$/;
	 		if(regex.test(val)){
	 			var li_code = $('#li_code').val();
	 			if(val.split("_")[0]==li_code){
	 				li_beginpoles = true;
	 				tes5.innerHTML="<font color=green>OK!</font>";
	 			}else{
	 				li_beginpoles = false;
	 				tes5.innerHTML="<font color=red>塔杆编号与线路编号不一致!</font>";
	 			}
	 			
	 		}else{
	 			tes5.innerHTML="<font color=red>请输入正确的塔杆编号与格式！如XX0001_000001</font>";
	 		}	
	 		return li_beginpoles;
	 	}
	 	
	 	/* 最终塔杆 */
	 	function test02(){
	 		var li_endpoles = false;
	 		var val = document.getElementById("li_endpole").value;
	 		var val2 = document.getElementById("li_beginpole").value;
	 		var tes6 = document.getElementById("tex6");
	 		var regex=/^[A-Z]{2}[0-9]{4}[_][0-9]{6}$/;
	 		if(regex.test(val)){
	 			//判断两个塔杆是否为一个线上的
	 			if(val.split("_")[0] == val2.split("_")[0]){
	 				var b1 = val.split("_")[1];
	 				var b2 = val2.split("_")[1];
	 				if(parseInt(b1) - parseInt(b2)>=0){
		 				$('#li_count').val(parseInt(b1)+1-parseInt(b2));
		 				tes6.innerHTML="<font color=green>OK!</font>";
		 				li_endpoles = true;
	 				}else{
	 				$('#li_count').val('');
	 				}
	 			}else{
	 				tes6.innerHTML="<font color=red>请输入正确的塔杆编号</font>";
	 			}
	 		}else{
	 			tes6.innerHTML="<font color=red>请输入正确的塔杆编号</font>";
	 		}
	 		return li_endpoles;	
	 	}
		function tijiao(){
    		var tj = false;
    		var li_names = testK();
    		var li_codes = checkCode();
    		var li_totimes = time();
    		var li_presslevels = testP();
    	
    		var li_backlengths = testH();
    		var li_beginpoles = test01();
    		var li_endpoles = test02();
    		if(li_presslevels && li_backlengths && li_beginpoles && li_endpoles && li_codes && li_names && li_totimes  ){
    			tj = true;
    		alert("添加成功！")
    		
    		}
    		
    		return tj;
    		
    	}