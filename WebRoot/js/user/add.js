/**
 * 密码长度
 * 
 */
 function CheckPas(){
	 var str=$('#u_password').val();
	 var b=false;
    var ops=document.getElementsByName("u_password")[0].value;
	if(ops==""){
		$('#spps').html('<font color="red">密码不能为空</font>');
   	 	b=false;
	}else{
		if(ops.length > 5 && ops.length < 21){
			$('#spps').html('<font color="green">√</font>');
	    	b=true;
	    }else{
	    	$('#spps').html('<font color="red">密码长度必须在6-20之间!</font>');
	    	 b=false;
	    }
	}	
    return b;
}
/**
 * 邮箱验证
 * 
 */
 function CheckEmail(){
	 var b=false;
    var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    var str=$('#u_email').val();
    if(re.test(str)){
    	$('#spem').html('<font color="green">√</font>');
    	b=true;
    }else{
    	$('#spem').html('<font color="red">请正确填写邮箱!</font>');
    	 b=false;
    }
    return b;
}
 
 /**
  * 手机号码
  * 
  */
  function CheckPhone(){
 	 var b=false;
     var re = /^1[3|4|5|7|8][0-9]{9}$/;
     var str=$('#u_phone').val();
     if(re.test(str)){
    	 $('#spph').html('<font color="green">√</font>');
     	b=true;
     }else{
    	 $('#spph').html('<font color="red">手机号码无效!</font>');
     	 b=false;
     }
     return b;
 }

  //登录名的唯一性
  function loginNameTest(){
		b5=false;
		var obj=$('#u_loginname').val();
		var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
		if(obj != null && obj != ''){			
			if(reg.test(obj)){
				$('#losp').html('<font color="red">登录名不能包含汉字请输入数字，字符或字母</font>');
				} else{					
				if(kong(obj)==0){
					id="name="+obj;
					//alert(id);
					$.getJSON('loginName.action',id,function(data){
						var result = data;
						//alert(result);
						if(result=="ok"){
							b5=true;
							$('#losp').html('<font color="green">√</font>');
						}else{
							$('#losp').html('<font color="red">登录名已存在</font>');
						}													
					 });
					}else{
						$('#losp').html('<font color="red">登录名不能包含空格</font>');
					}
			}
			
		}else{
			$('#losp').html('<font color="red">登录名不能为空</font>');
		}
}
	//真实姓名的验证
function  CheckRealName(){
	var b=false;
	var obj=$('#u_realname').val();
	//obj=trim(obj);
	var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
	if(obj != null && obj != ''){
		if(reg.test(obj)){
			if(kong(obj)==0){
				b=true;
				$('#nasp').html('<font color="green">√</font>');
			}else{
				$('#nasp').html('<font color="red">用户名不能为存在空格</font>');
			}
		} else{
			$('#nasp').html('<font color="red">请输入汉字</font>');
		}
		
	}else{
		$('#nasp').html('<font color="red">用户名不能为空</font>');
	}		
	return b;
}
//角色验证
function CheckRid(){
	var rid=$('#r_id').val();
	if(rid == -1){
		$('#irid').html('<font color="red">请选择有效的角色</font>');
		return false;		
	}else{
		return true;
	}
}
//入职时间验证
function CheckIntime(){
	var time =$('#u_intime').val();
	//alert(time);
	var b=true;
	if(time == null || time ==''){
		$('#iintime').html('<font color="red">请添加入职时间</font>');
		b=false;		
	}else{
		$('#iintime').html('<font color="green">√</font>');
	}
	return b;
}

//年龄验证
function CheckAge(){
	var age=$('#u_age').val();
	//alert();
	var b=true;
	if(age == null || age ==''){
		$('#iage').html('<font color="red">请添加年龄</font>');
		b=false;		
	}else{
		if(kong(age)==0){
			if(age>=0 && age<=120){
				$('#iage').html('<font color="green">√</font>');
			}else{
				$('#iage').html('<font color="red">年龄范围不合法超出范围</font>');
				b=false;
			}
			
		}else{
			$('#iage').html('<font color="red">年龄不能存在空格</font>');
			b=false;
		}
	}
	return b;
}
  //表单验证
  function CheckMyForm(){
	  var b1=CheckPas();
	  var b2=CheckEmail();
	  var b3=CheckPhone();
	  var b4=CheckRealName();
	  var b6=CheckRid();
	  var b7=CheckIntime();
	  var b8=CheckAge();
	  if(b1 && b2 && b3 && b4 && b5 && b6 && b7 && b8){
		  return true;
	  }else{
		  return false;
	  }	  
	  
  }
  
/*//去掉字符串头尾空格   
  function trim(str) {   
      return str.replace(/(^\s*)|(\s*$)/g, "");
  }*/
  
  function kong(str){
	 var arr=new Array();
	 arr=str.split(' ');
	 if(arr.length != 1){
		 return 1;
	 }else{
		 return 0;
	 }
  }
  
  function trim(str) {   
      return str.replace(/\s+/g, "");
  }