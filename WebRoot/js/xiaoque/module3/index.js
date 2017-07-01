 KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
 
 
 $(document).ready(function(e) {

		$(".select3").uedSelect({
			width : 100
		});
		
	});
	$(document).ready(function(){
	  $(".scbtn1").click(function(){
	  $(".seachform2").fadeIn(200);
	  }); 

	  $('#sure').click(function(){
		  var nowPage=$('#go').val();
		  if(nowPage!=""){
		  location.href="RoleManagerController/index.do?nowPage="+nowPage;
		  }
	  });
	  
	  $('#add').click(function(){
		  location.href="add.html";
	  });
	  
	 
	$('#export').click(function(){
			if($('#count').val()!=0){
			window.location.href="exportExcel.action?stBid="+$('#stBid').val()+"&f_id="+$('#f_id').val()+"&nowPage="+$('#nowPage').val();
			}else{
				alert("没有数据无法导出！");
			}
		});
	});

		
	 function del(){
	   confirm("确认删除");
	 }
	 
	 
	 
	 