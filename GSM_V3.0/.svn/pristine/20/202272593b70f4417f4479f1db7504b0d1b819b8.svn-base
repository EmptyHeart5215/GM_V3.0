<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>

<script type="text/javascript">
</script>
<title>网格管理</title>
</head>
<script type="text/javascript">
var dropzone;
function getImgPath(imgName,path){
	var imgPath="${base}/upload/"+path;
	var ext=imgName.substr(imgName.lastIndexOf(".")+1);
    //如果不是图片，输出相应的图标
	if(!(ext=="jpg"||ext=="jpeg"||ext=="gif"||ext=="png"||ext=='bmp')){
		var iconVal=getIcon(ext);
		imgPath= "${base}/resource/js/layer-v1.8.5/layer/images/"+iconVal+".png";
	}
	return imgPath;
}
function getOldPics(hiddenUrlPicId,imgNameFlag,dropzone){
	var oldPictureCodes=$('#'+hiddenUrlPicId).val();
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
					   					 <img src="'+getImgPath(data[i].NAME,data[i].PATH)+'" id="'+data[i].CODE+'" alt="'+data[i].NAME+'" name="showImg'+imgNameFlag+'old" > \
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
									dropzone.options.existedFiles=$('[name=showImg'+imgNameFlag+'old]').length;
									}
								});
					 });
					 preview.append(downloadBtn).append(deleteBtn);
					 $("#"+imgNameFlag+"picDisplay_old").append(preview);
				}
				layerGallery('showImg'+imgNameFlag+'old');
			}
		}
	}); 
	  
	}
}
function initDropzone(flag){
	var dropzone=new Dropzone("#"+flag+"dropzoneDiv",{
	 	urlBase:"${base}",
	 	existedFiles:$('#'+flag+'url_pic').val().split(";").length-1,
	 	imgName:'showImg'+flag,
	 	uploadBtnId:flag+'uploadBtn'
	 	
});
 getOldPics(flag+'url_pic',flag,dropzone);
}
function getAllImgId(flag){
	$('#'+flag+'url_pic').val('');
 	//获取上传的图片的值
 	var ids='';
 	$('[name^=showImg'+flag+']').each(function(i){
 		if(this.id&&$.trim(this.id)!=''){
 			ids+=this.id+";";
 		}
 	});
 	$('#'+flag+'url_pic').val(ids);
}
 $(document).ready(function () {  
		//grid的图片
		initDropzone("_grid_");
		//manager的图片
		initDropzone("_manager_");
		//assistant的图片
		initDropzone("_assistant_");
		
	$("#form").validate({
		submitHandler: function (form) {
			getAllImgId("_grid_");
			getAllImgId("_manager_");
			getAllImgId("_assistant_");
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
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			         <input class="required" type="hidden" id="parentCode" name="parentCode" value="${map.seat.parentCode}${map.parentCode}" />
  							<input type="hidden" name="flagDepartment" value="0" />
                            <input type="hidden" name="code" value="${map.seat.code}" />
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>网格名称</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="name" name="name" value="${map.seat.name}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>行政区划(网格)代码</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="10"id="cityCode" name="cityCode" value="${map.seat.cityCode}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>网格管理员</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managerName" name="managerName" value="${map.seat.managerName}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>网格管理员电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managerPhone" name="managerPhone" value="${map.seat.managerPhone}" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
					</div>
				</div>
                    <div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >网格助理员</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="assistant" name="assistant" value="${map.seat.assistant}" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right">网格助理员电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="assistantPhone" name="assistantPhone" value="${map.seat.assistantPhone}" class="col-xs-12 col-sm-12 tooltip-error allPhone" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>地图描边</label>
			
					<div class="col-xs-10">
						<input type="text"id="Position" readonly="readonly" name="position" value="${map.seat.position}" onclick="getPointXY(this)" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>排序</label>
			
					<div class="col-xs-4">
						<input type="text"id="sort" name="sort" min="0" value="${map.seat.sort}" class="col-xs-12 col-sm-12 tooltip-error required digits" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >网格概况</label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea max-length="5000" class="col-xs-12 col-sm-12"id="description" name="description" rows="8">${map.seat.description}</textarea>
						</div>
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">备注 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="remark" name="remark" sytle="height:100px;" max-length="5000" class="col-xs-12 col-sm-12">${map.seat.remark }</textarea>
						</div>
					</div>
				</div>
                <div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">上传辖区图片/文件 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='_grid_dropzoneDiv' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="_grid_uploadBtn">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="_grid_url_pic" name="seatPicture" value="${map.seat.seatPicture }" />
						</div>
					</div>
				</div>
				<c:if test="${map.seat.seatPicture != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >已保存辖区图片/文件 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="_grid_picDisplay_old" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>
               <div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">上传管理员图片 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='_manager_dropzoneDiv' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="_manager_uploadBtn">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="_manager_url_pic" name="managerPhoto" value="${map.seat.managerPhoto }" />
						</div>
					</div>
				</div>
				<c:if test="${map.seat.managerPhoto != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >已保存管理员图片 </label>
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="_manager_picDisplay_old" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">上传助理图片 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='_assistant_dropzoneDiv' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="_assistant_uploadBtn">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="_assistant_url_pic" name="assistantPhoto" value="${map.seat.assistantPhoto}" />
						</div>
					</div>
				</div>
				<c:if test="${map.seat.assistantPhoto != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存助理图片 </label>
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="_assistant_picDisplay_old" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>
				<div class="space-4"></div>
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
			</form>
		</div>
	</div>
</body>
</html>