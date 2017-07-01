/**
 * 获取异步对象
 */
    function  getXhr(){
			var xhr;
			try{
				xhr = new XMLHttpRequest();//没有    报错   就会产生异常  异常就可以  try catch 处理
			}catch(e){
				//IE  6  或者   6 之上的
				try{
					xhr=new ActiveXObject("Microsoft.XMLHTTP"); 
				}catch(e){
					try{
						xhr= new new ActiveXObject("Msxml2.XMLHTTP");
					}catch(e){
						alert("你的浏览器不支持ajax，请跟换浏览器，建议换火狐");
					}
				}
			}
			return xhr;
	}
    