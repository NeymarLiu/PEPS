/**
 * 
 */
$(function(){
  		$('#bckbt').click(function(){
  			window.history.go(-1);
  			//window.history.back();
  		});
  	
  	});
  	
  function selectPole(pf_id){
		var obj="pf_id="+pf_id;
		$.getJSON('getOnePFP.action',obj,function(data){
			if(data!=null){
				$('#sppc').html(data.pole_code);
				if(data.pf_flaw_rate==0){
					$('#spfr').html();
				}else{
					$('#spfr').html(data.pf_flaw_rate+"%");
				}
				$('#remark').html(data.pf_remark);
				$('#spit').html(data.pf_flaw_grade==1?"一般":data.pf_flaw_grade==2?"严重":data.pf_flaw_grade==3?"紧急":"");
				$('#spfp').html(data.pf_find_people);
				$('#spft').html(data.find_time);
				$('#flaw').html(data.f_name);
			}else{
				$.getJSON('getOnePFP2.action',obj,function(data){
				$('#remark').html('');
				$('#spit').html('');
				$('#spft').html('');
				$('#flaw').html('');
				$('#remark').html('');
				$('#spfr').html('');
				$('#sppc').html(data.pole_code);
				});
			}
		});
		
}
function initFlaw(flaw){
var obj="pf_id="+flaw;
  	$.getJSON('getOnePFP.action',obj,function(data){
  	$('#flaw').html(data.f_name);
  	});

}