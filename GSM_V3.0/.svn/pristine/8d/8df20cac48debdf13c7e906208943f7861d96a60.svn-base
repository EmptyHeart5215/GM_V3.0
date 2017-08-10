 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored ="false"%>
<script type="text/javascript">
 var getImgPath=function(imgName,path){
	var imgPath="${base}/upload/"+path;
	var ext=imgName.substr(imgName.lastIndexOf(".")+1);
    //如果不是图片，输出相应的图标
	if(!(ext=="jpg"||ext=="jpeg"||ext=="gif"||ext=="png"||ext=='bmp')){
		var iconVal=getIcon(ext);
		imgPath= "${base}/resource/js/layer-v1.8.5/layer/images/"+iconVal+".png";
	}
	return imgPath;
}
 var getOldPics=function(dropzone){
	var oldPictureCodes=$('#url_pic').val();
	if(oldPictureCodes!=""){
	  $.ajax({
		type : "post",
		url : "${base}/sys/sysupload/queryByCodes?t="+Math.random(),
		dataType : 'json',
		data:{codes:oldPictureCodes},
		async : false,
		success : function(data) {
			var allLi="<tr>";
			if(data.length>0){
				for(var i=0;i<data.length;i++){
					var preview=$('<div class="dz-preview dz-image-preview" id="'+data[i].CODE+'_div">  \
									<div class="dz-details">   \
										 <div class="dz-filename"> \
											 <span>'+data[i].NAME+'</span> \
										 </div> \
					   					 <img src="'+getImgPath(data[i].NAME,data[i].PATH)+'" id="'+data[i].CODE+'" alt="'+data[i].NAME+'" name="showImg_old" > \
									</div> \
					   			</div>');
					 var downloadBtn=$('<button type="button" class="btn btn-xxs btn-primary" style="margin-right: 4px;" >\
											<i class="icon-cloud-download  bigger-100"></i>下载\
										</button>');
					 var deleteBtn=$('<button type="button" class="btn btn-xxs btn-danger">\
								<i class="icon-trash  bigger-110"></i>删除\
								</button>');
					 downloadBtn.bind('click',function(){
						 window.location.href ='${base}/sys/sysupload/downLoad?code='+data[i].CODE;
					 });
					 deleteBtn.bind('click',data[i].CODE,function(event){
						 window.top.bootbox.confirm('你确定删除吗？',function(result){
								if(result){
									$('#'+event.data+'_div').remove();
									dropzone.options.existedFiles=$('[name=showImg_old]').length;
									}
								});
					 });
					 preview.append(downloadBtn).append(deleteBtn);
					 $("#picDisplay_old").append(preview);
				}
				layerGallery('showImg_old');
			}
		}
	}); 
	  
	}
}
$(document).ready(function () {
	
	//如果子页面需要进行图片浏览，必须加上这句-------------
	layer.use('extend/layer.ext.js', function(){
		   layer.ext =function(){};
	}); 
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone=new Dropzone("#dropzoneDiv",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic').val().split(";").length-1
	});
	 getOldPics(dropzone);
	$("#form").validate({
		submitHandler: function (form) {
		 	$('#url_pic').val('');
		 	//获取上传的图片的值
		 	var ids='';
		 	$('[name^=showImg]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids+=this.id+";";
		 		}
		 	});
		 	$('#url_pic').val(ids);
		 	var data = $("#form").serialize();
		 	 $.ajax({
				type : "post",
				url : "${base}/${map.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	if('${map.url}'.indexOf('modify')>0){
		    				parent.editNodeCallBack();
		    			}else{
		    				parent.addNodeCallBack();
		    			}
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			});  
        }
	});
	//父窗口中的提交按钮
	 $("#commitBtn",parent.document).bind("click",function(){
		$("#form").submit();
	}); 
});
  
</script>
