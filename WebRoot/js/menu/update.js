//菜单名唯一性验证
function CheckMname(){
	b=false;
	var mname=document.getElementById("mymname").value;
	var mid=document.getElementById("mid").value;
	var sp=document.getElementById("imname");
	if(mname != null && mname !=''){		
		if(kong(mname)==0){
			var xmlhttp=getXhr();
			xmlhttp.open("get","menuNameOnly2.action?mymname="+mname+"&mymid="+mid+"&time="+new Date().getTime(),false);
			xmlhttp.onreadystatechange = function (){
				if(xmlhttp.readyState == 4 && xmlhttp.status==200){
					var result = xmlhttp.responseText;
					if(result == 1 ){
						b=true;
						sp.innerHTML="<font color='green'>√</font>";
						
					}else{
						sp.innerHTML="<font color='red'>菜单名称已存在</font>";
					}
				}
			};
			xmlhttp.send(null);
		}else{
			sp.innerHTML="<font color='red'>菜单名称不能存在空格</font>";
		}
				
	}else{
		sp.innerHTML='<font color="red">菜单名不能为空</font>';
	}
}
function  getXhr(){
	var xhr;
	try{
		xhr = new XMLHttpRequest();//没有    报错   就会产生异常  异常就可以  try catch 处理
	}catch(e){
		//IE  6  或者   6 之上的
		try{
			xhr=new ActiveXObject("Microsoft.XMLHTTP"); 
		}catch(e){
			try{
				xhr= new new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				alert("你的浏览器不支持ajax，请跟换浏览器，建议换火狐");
			}
		}
	}
	return xhr;
}
//路径验证
function CheckUrl(){
	var b1=false;
	var murl=document.getElementById("m_url").value;
	var sp=document.getElementById("imurl");
	if(murl == null || murl ==''){
		sp.innerHTML="<font color='red'>菜单路径不能为空</font>";
	}else{
		if(kong(murl)==0){
			b1=true;
			sp.innerHTML="<font color='green'>√</font>";
		}else{
			sp.innerHTML="<font color='red'>菜单路径不能存在空格</font>";
		}
	}
	return b1;
}

//表单验证
function CheckMyForm(){
	var b1=CheckUrl();
	if(b && b1){
		return true;
	}else{
		return false;
	}
}

//判断是否包含空格
function kong(str){
	 var arr=new Array();
	 arr=str.split(' ');
	 if(arr.length != 1){
		 return 1;
	 }else{
		 return 0;
	 }
  } 