/**
 * 
 */
$(document).ready(function(e) {
if($('#pstate').val()!=0&&$('#pstate').val()!=null){
	$('#p_state').val($('#pstate').val());
	}
	$(".select3").uedSelect({
		width : 100
	});
	$('#export').click(function(){
		if($('#pcount').val()!=0){
		window.location.href="exportPatrolExcel.action?p_num="
			+$('#p_num').val()+"&p_state="+$('#p_state').val()+"&nowPage="+$('#nowPage').val();
		}else{
			alert("没有可导出的数据!");
		}
	});
});