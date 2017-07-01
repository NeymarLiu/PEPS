	function back(){
	  history.back();
	 }
	    KE.show({
	        id : 'content7',
	        cssPath : './index.css'
	    });
	    
	 $(document).ready(function(e) {
	    $(".select1").uedSelect({
			width : 120		  
		});
	});  
	
	
	//验证
	$(function(){
     		var date=new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-" +new Date().getDate();
     		$('#e_issued_time').val(date);
     });
  
    function checkState(ceshi){
     		if(ceshi==1){
     			alert("提示:添加成功!");
     		}
     	} 