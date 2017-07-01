/**
 * 
 */
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
$(function() {
if($('#pstate').val()!=0&&$('#pstate').val()!=null){
		$('#p_state').val($('#pstate').val());
	}
	$(".select3").uedSelect({
		width : 100
	});
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 

 
});

function startTask(p_id){
	if(confirm("提示:确定开始执行巡检任务!")){
		window.location.href="startPTask.action?p_id="+p_id;
	}
	
	}
function getMark(mark){
	if(mark==1){
	alert("提示:已经开始执行项目!");
	}
}