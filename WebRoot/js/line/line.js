/**
 * 展示页面
 */
  $(function(){
 $('#addLine').click(function(){
	   location.href="toaddLine.action";
 	 });

});
 function ls(li_id,state,run){
   if(confirm("您是否确定该操作？")) {
  //var li_id=document.getElementById("olineId").value;
             location.href="lineState.action?li_id="+li_id+"&li_state="+state+"&li_run="+run;
    
           alert("操作成功！")
    }else{
           alert("取消成功")     
    
    }
  }
  
  function del(li_id,state){
 	//alert(obj);
   if(confirm("确认删除吗？")){
   		location.href="deleteLine.action?li_id="+li_id+"&li_state="+state;
   }
 }
  $('.tablelist tbody tr:odd').addClass('odd');