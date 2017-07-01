/**
 * 
 */
   KE.show({
        id : 'content7',
        cssPath : './index.css'
    });

$(document).ready(function(e) {
	if($('#pstate').val()!=0&&$('#pstate').val()!=null){
		$('#p_state').val($('#pstate').val());
	}
	$(".select3").uedSelect({
		width : 100
	});
	 $('#add').click(function(){
	  location.href="toPatrolTask.action";
 	 });
 	 
 	/*  $('#sure').click(function(){
		var page=$('#goPage').val();
		if(page==''){
			alert("提示:请填写正确的页数!");
		}else{
		window.location.href=$('#purl').val()+"&nowPage="+page;		
		}	 
 	 }); */
});
function cancle(pid){
	if(confirm("提示:确定取消任务?")){
		window.location.href="cancleTask.action?pid="+pid;
	}
}
