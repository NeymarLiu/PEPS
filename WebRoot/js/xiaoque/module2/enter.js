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
 
 $(function(){
		var date=new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-" +new Date().getDate();
		$('#e_task_finish_time').val(date);
});
 
 //提交
 $(function () {       
		$('#buttonOne').click(function(){
			var e_id = $('#eid').val();
			var e_task_finish_time=$('#e_task_finish_time').val();
			var e_final_described =$('#e_final_described').val();
			if(e_task_finish_time != ""&&e_final_described !=""&&e_final_described != null&&e_final_described !="null"){
				location.href="edReceiptEnter.action?e_id="+e_id+"&e_final_described="+e_final_described+"&e_task_finish_time="+e_task_finish_time;
			}else{
			alert("请去修改页面添加完成请况数据！");
			}
		});
 });
 
 //保存
 $(function () {       
		$('#buttonThree').click(function(){
			var e_id = $('#eid').val();
			var e_task_finish_time=$('#e_task_finish_time').val();
			var e_final_described = $('#e_final_described').val();
			if(e_final_described !=""&&e_final_described !=null&& e_final_described !="null"){
				location.href="updateReceiptTwo.action?e_id="+e_id+"&e_final_described="+e_final_described+"&e_task_finish_time="+e_task_finish_time;
			}else{
				alert("请添加任务的具体完成情况！");
			}
		});
 });
 
 function checkState(ceshi){
		if(ceshi==1){
			alert("提示:保存成功!");
		}
	} 