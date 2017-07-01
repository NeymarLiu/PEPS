

 		KE.show({
	        id : 'content7',
	        cssPath : './index.css'
	    });
	    
	    $(function () {
			$('#newNav').click(function(){
					window.location.href="AddTaskController/add.do";
			 });
	     });
	    
	    
	    $(document).ready(function(e) {
			$(".select3").uedSelect({
				width : 200
			});
		});
	    
	    
	    $(document).ready(function(){
			  $(".click").click(function(){
			  $(".tip").fadeIn(200);
			  });
			  
			  $(".tiptop a").click(function(){
			  $(".tip").fadeOut(200);
			});
			
			  $(".sure").click(function(){
			  $(".tip").fadeOut(100);
			});
			
			  $(".cancel").click(function(){
			  $(".tip").fadeOut(100);
			});
			
			});
			
			
			
			$(document).ready(function(){
				$(".scbtn1").click(function(){
					$(".seachform2").fadeIn(200);
				});
			});
			
			
			
	    
	    
	    