//检查角色的唯一性
function CheckName(){
	var name=$('#rname').val();
	b=false;
	if(name!=null && name != ''){
		if(kong(name)==0){
			name="rname= "+$('#rname').val()+"&rid="+$('#r_id').val();
			$.getJSON('roleNameOnly2.action',name,function(data){
				var result = data;
				if(result == "ok" ){
					b=true;
					$('#irname').html('<font color="green">√</font>');
				}else{
					$('#irname').html('<font color="red">角色名称已存在</font>');
				}
			});
		}else{
			$('#irname').html('<font color="red">角色名称不能存在空格</font>');
		}
		
	}else{
		$('#irname').html('<font color="red">角色名称为空</font>');
	}
	return b;
}
//表单验证
function testone(){
	//var b=CheckName();
	//alert(b);
	return b;
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
