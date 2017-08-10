<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	$("[name=gridCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
	});
	if('${vdata.partyOrganizationManager.sex }' == '男'){
		 $("#sex option[value='男']").attr("selected", "selected"); 
	 }else if('${vdata.partyOrganizationManager.sex }' == '女'){
		 $("#sex option[value='女']").attr("selected", "selected"); 
	 }else if('${vdata.partyOrganizationManager.sex }' == 0){
		 $("#sex option[value='0']").attr("selected", "selected"); 
	 }
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize();
			$.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	parent.successFun();
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
	$("[name=codePartyOrganizationType]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_PARTY_ORGANIZATION_TYPE',
		name:"dicValue",
		pIdKey:"parentCode"
	});
});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
		
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="Code" value="${vdata.partyOrganizationManager.code }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for=organizaName><span class="red">*</span>所属辖区/部门</label>
			
					<div class="col-xs-4">
						<input type="text" id="gridCode" name="gridCode" value="${vdata.partyOrganizationManager.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="organizaName"><span class="red">*</span>组织名称</label>
			
					<div class="col-xs-4">
						<input type="text"id="organizaName" name="organizaName" value="${vdata.partyOrganizationManager.organizaName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="secretaryName"><span class="red">*</span>书记姓名</label>
			
					<div class="col-xs-4">
						<input type="text" id="secretaryName" name="secretaryName" value="${vdata.partyOrganizationManager.secretaryName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right tooltip-error required" for="sex"><span class="red">*</span>性别</label>
			
					<div class="col-xs-4">
					    <select  id="sex" name = "sex"  class="form-control myselect tooltip-error required"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="">--请选择--</option>
                           <option  value="男">男</option>
                           <option  value="女">女</option>
                        </select>
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="phone"><span class="red">*</span>身份证号</label>
			
					<div class="col-xs-4">
						<input type="text" id="cid" name="cid" value="${vdata.partyOrganizationManager.cid }" class="col-xs-12 col-sm-12 tooltip-error required personcid" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="phone"><span class="red">*</span>党组织类型</label>
			
					<div class="col-xs-4">
						<input type="text" id="codePartyOrganizationType" name="codePartyOrganizationType" value="${vdata.partyOrganizationManager.codePartyOrganizationType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="phone"><span class="red">*</span>工作电话</label>
			
					<div class="col-xs-4">
						<input type="text" id="phone" name="phone" value="${vdata.partyOrganizationManager.phone }" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="mobile">手机号码</label>
			
					<div class="col-xs-4">
						<input type="text" id="mobile" name="mobile" value="${vdata.partyOrganizationManager.mobile }" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>地图定位</label>
					<div class="col-xs-10 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.partyOrganizationManager.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					   </div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="remark">备注</label>
			
					<div class="col-xs-10">
						<textarea id="remark" name="remark" class="col-xs-12 col-sm-qw tooltip-error required">${vdata.partyOrganizationManager.remark }</textarea>
					</div>
				</div>
				<div class="space-4"></div>
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
function getImgPath(imgName,path){
	var imgPath="${base}/upload/"+path;
	alert(imgPath);
	var ext=imgName.substr(imgName.lastIndexOf(".")+1);
    //如果不是图片，输出相应的图标
	if(!(ext=="jpg"||ext=="jpeg"||ext=="gif"||ext=="png"||ext=='bmp')){
		var iconVal=getIcon(ext);
		imgPath= "${base}/resource/assets/js/layer-v1.8.5/layer/images/"+iconVal+".png";
		
	}
	return imgPath;
}
function getOldPics(dropzone){
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
					alert(getImgPath(data[i].NAME,data[i].PATH));
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
</html>


