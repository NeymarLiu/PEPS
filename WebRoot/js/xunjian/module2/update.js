$(function(){
	if($('#flaw_grade').val()!=0 && $('#flaw_grade').val()!=null){
		$('#pf_flaw_grade').val($('#flaw_grade').val());
	}
	if($('#pfflaw').val()!=0 && $('#pfflaw').val()!=null){
		$('#pf_flaw').val($('#pfflaw').val());
	}
	if($('#find_time').val()=="" || $('#find_time').val()==null){
	var date=new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-" +new Date().getDate();
	$('#pf_find_time').val(date);
	}else{
	$('#pf_find_time').val($('#find_time').val());
	}
	
	$('#backbtn').click(function(){
		window.location.href="getAllPTask.action";
	});
	$('#saveInfo').click(function(){
		if(checkRemark()&checkRate()&checkFlawGrade()&checkFlaw()){
		var rate=$('#pf_flaw_rate').val();
		var people=$('#pf_find_people').val();
		var flaw=$('#pf_flaw').val();
		var pole=$('#pf_id').val();
		var grade=$('#pf_flaw_grade').val();
		var time=$('#pf_find_time').val();
		var remark=$('#pf_remark').val();
		//alert(remark=="")
		var obj="pf_flaw_rate="+rate+"&pf_find_people="+people+"&pf_flaw="+flaw+"&pf_id="+pole+"&pf_flaw_grade="+grade+"&pf_find_time="+time+"&pf_remark="+remark;
		$.get('receiptPTask.action',obj,function(data){
				if(data==1){
					alert("保存成功!");
				}	
		});
	}else{
		alert("提示:请根据提示更改数据!");
	}
	});
});
function selectPole(pf_id){
		var obj="pf_id="+pf_id;
		$.getJSON('getOnePFP.action',obj,function(data){
			if(data!=null){
			//塔杆巡检id
			$('#pf_id').val(data.pf_id);
			$('#pf_pole_code').val(data.pole_code);
			if(data.pf_flaw!=0){
				$('#pf_flaw').val(data.pf_flaw);
			}else{
				$('#pf_flaw').val(-1);
			}
			if(data.pf_flaw_rate!=0){
				$('#pf_flaw_rate').val(data.pf_flaw_rate);
			}else{
				$('#pf_flaw_rate').val('');
			}
			if(data.pf_flaw_grade!=0 ){
				$('#pf_flaw_grade').val(data.pf_flaw_grade);
			}else{
				$('#pf_flaw_grade').val(-1);
			}
			if(data.find_time!="" && data.find_time!=null &&typeof(data.find_time)!="undefined"){
				$('#pf_find_time').val(data.find_time);
			}else{
				var date=new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-" +new Date().getDate();
				$('#pf_find_time').val(date);
			}
			if(data.pf_find_people!="" && data.pf_find_people!=null){
				$('#pf_find_people').val(data.pf_find_people);
			}else{
				$('#pf_find_people').val($('#find_lpeople').val());
			}
			if(data.pf_remark!="" && data.pf_remark!=null){
				$('#pf_remark').val(data.pf_remark);
			}else{
				$('#pf_remark').val('');
			}
			
			}else{
				$.getJSON('getOnePFP2.action',obj,function(data){
					$('#pf_id').val(data.pf_id);
					$('#pf_pole_code').val(data.pole_code);
					$('#pf_remark').val('');
					$('#pf_flaw_rate').val('');
					$('#pf_flaw_grade').val(-1);
					$('#pf_flaw').val(-1);
					$('#pf_find_time').val(new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-" +new Date().getDate());
					$('#pf_find_people').val($('#find_lpeople').val());
					});
				}
		});
	};
	function checkFlaw(){
		var state=false;
		if($('#pf_flaw').val()!=-1 &&$('#pf_flaw').val()!=null ){
			$('#spfl').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
			state=true;
		}else{
			$('#spfl').html("<font color='red'>&nbsp;请选择终止塔杆!</font>");
			state=false;
		}
		return state;
	}
	function checkFlawGrade(){
		var state=false;
		if($('#pf_flaw_grade').val()!=-1 &&$('#pf_flaw_grade').val()!=null ){
			$('#spfg').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
			state=true;
		}else{
			$('#spfg').html("<font color='red'>&nbsp;请选择终止塔杆!</font>");
			state=false;
		}
		return state;
	}
	function checkRate(){
		var state=false;
		var regex=/^[1-9][0-9]{0,1}$/;
		var rate=$('#pf_flaw_rate').val();
		if(regex.test(rate)){
			$('#spra').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
			state=true;
		}else{
			$('#spra').html("<font color='red'>&nbsp;请输入正确的两位整数!</font>");
			state=false;
		}
		return state;
	}
	function checkRemark(){
		var state=false;
		var remark=$('#pf_remark').val();
		var regex=/\s*$/g;
		if(!regex.test(remark) || remark==""){
			$('#spre').html("<font color='red'>&nbsp;缺陷描述不能为空!</font>");
			state=false;
		}else{
			$('#spre').html("<font color='green' size='+2'>&nbsp;&nbsp;&nbsp;√</font>");
			state=true;
		}
		return state;
	}
