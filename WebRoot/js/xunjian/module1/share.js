/**
 * 
 */
 KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 120

	});
});
function getCount(){
	var d =document.getElementsByName("u_id");
	var b=false;
	for (var i = 0; i < d.length; i++) {
		if(d[i].checked){
			b=true;
			break;
		}
	}
	if(b==false){
		alert("提示:没有选择一个选项!");
	}
	return b;
}
   function getMark(mark){
   	if(mark==1){
   		alert("提示:操作成功!");
   		window.location.href="getAllPatrol.action";
   	}
   }