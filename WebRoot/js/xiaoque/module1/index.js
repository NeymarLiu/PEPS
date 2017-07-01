  KE.show({
	        id : 'content7',
	        cssPath : './index.css'
	    });
	    
	    $(function () {
			$('#newNav').click(function(){
					window.location.href="goToEdTask.action";
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
		
		$(function(){
		a=false;
		$(function(){
			$('#stBid').blur(function(){
				var d=$('#stBid').val();
				if(d==""&&d==null&&d=="null"){
					alert("请输入任务编号！");
				}else{
					a=true;
				}
			});
			
			$('#stUser').blur(function(){
				var c=$('#stUser').val();
				if(c==""&&c==null&&c=="null"){
					alert("请输入下发人的姓名！");
				}
			});
			
		});
		
		$(function(){
			$('#d1').blur(function(){
				var d=new Date();
				var year=d.getFullYear();
				var moth=d.getMonth()+1;
				var day=d.getDate();
				var nowTime=year+"-"+moth+"-"+day;
				var mintime=$('#d1').val();
				var maxtime=$('#d2').val();
				if (mintime!=null&&mintime!=""&&mintime!="null") {//最小时间不为空
					if (maxtime!=null&&maxtime!=""&&maxtime!="null") {//最大时间不为空
						if (mintime>maxtime||nowTime<mintime) {
							alert("最小时间不能大于当前时间或大于最大时间");
							$('#d1').val(null);
						} else {
							//var mintime=$('#d1').val();
							a=true;
						}
					}else{//最大时间为空
						if (mintime>nowTime){
							alert("最小时间不能大于当前时间");
							$('#d1').val(null);
							}
						}
					}
			});
			
			$('#d2').blur(function(){
				var d=new Date();
				var year=d.getFullYear();
				var moth=d.getMonth()+1;
				var day=d.getDate();
				var nowTime=year+"-"+moth+"-"+day;
				var mintime=$('#d1').val();
				var maxtime=$('#d2').val();
				if (maxtime!=null&&maxtime!=""&&maxtime!="null") {//最大时间不为空
					if (mintime!=null&&mintime!=""&&mintime!="null") {//最小时间不为空
						if (maxtime<mintime||maxtime>nowTime) {
							alert("最大时间不能小于最小时间或大于当前时间");
							$('#d2').val(null);
						} else {
							a=true;
						}
					} else {//最小时间为空
							if (maxtime>nowTime) {
								alert("最大时间不能大于当前时间");
								$('#d2').val(null);
							} 
					}
					
					}
			});
	});
});


		
		$(document).ready(function(){
						$(".scbtn1").click(function(){
							$(".seachform2").fadeIn(200);
						});
					});