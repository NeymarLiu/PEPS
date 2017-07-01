

 KE.show({
	        id : 'content7',
	        cssPath : './index.css'
	    });
 
 
 $(document).ready(function(e) {
	    $(".select1").uedSelect({
			width : 120		  
		});
	});
	
	
	
	
	$(function () {       
		$('#backid').click(function(){
			window.history.back();
		});
    });
	
	
	 function checkState(ceshi){
			if(ceshi==1){
				alert("提示:修改成功!");
			}
		} 
	
	$(function () {       
		$('#buttonTwo').click(function(){
			var e_id = $('#eid').val();
			var e_task_finish_time=$('#e_task_finish_time').val();
			var e_final_described = $('#e_final_described').val();
			if(e_final_described !=""&&e_final_described !=null&& e_final_described !="null"){
				location.href="updateReceipt.action?e_id="+e_id+"&e_final_described="+e_final_described+"&e_task_finish_time="+e_task_finish_time;
			}else{
				alert("请添加任务的具体完成情况！");
			}
		});
    });