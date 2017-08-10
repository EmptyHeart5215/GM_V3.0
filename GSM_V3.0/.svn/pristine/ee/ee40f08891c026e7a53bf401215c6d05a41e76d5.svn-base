<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<script src="${base}/resource/js/ckeditor/ckeditor.js"></script>
<link href="${base}/resource/js/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" />
<script src="${base}/resource/js/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${base}/resource/js/bootstrap-wysihtml5/jquery.base64.js"></script>
<script type="text/javascript">
$(function(){
		$("[name=girdCode]").ztreeGrid({
			url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
		});
		$("[name=codeUploadMaterialType]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_UPLOAD_MATERIAL_TYPE',
			name:"dicValue",
			pIdKey:"parentCode"
		});
		var editor = null;
		editor = CKEDITOR.replace('materialContent');
		 //bootstrap WYSIHTML5 - text editor
		$(".textarea").wysihtml5();
		 if('${vdata.zongzhiMaterial.codeMaterialType }'!=''){
			 changeSelect('${vdata.zongzhiMaterial.codeMaterialType }');
		 }else{
			 changeSelect(0);
		 }
		 if('${vdata.zongzhiMaterial.codeMaterialType }' == 0){
			 $("#selectId option[value='0']").attr("selected", "selected"); 
		 }else if('${vdata.zongzhiMaterial.codeMaterialType }' == 1){
			 $("#selectId option[value='1']").attr("selected", "selected"); 
		 }
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone1=new Dropzone("#dropzoneDiv1",{
		 	 urlBase:"${base}",
			 url: function(){
	         	return "${base}/sys/sysupload/uploadFile";
	         },
	         existedFiles:$('#url_pic1').val().split(";").length-1,
		 	uploadBtnId:'uploadBtn1',
            imgName:'showImg1',
            acceptedFiles:'.txt,.doc,.docx',
            maxFilesize: 10,//最大文件大小，MB
            maxFiles:1
	});
	//dropzone代表dropzone对象
	//urlPicI表示model中存放上传文件id的那个字段使用的input的id，type 是hidden的
	//showOldImgName表示在组装已经存在的的图片的时候用的img标签的name
	//showOldImgDivId表示用来展示已经存在的图片的div的id
	getOldPics(dropzone1,"url_pic1","showImg1_old","picDisplay_old1");
	$("#form").validate({
		submitHandler: function (form) {
		$('#url_pic1').val('');
		 	//获取上传文件的值
		 	var ids1='';
		 	$('[name^=showImg1]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids1+=this.id+";";
		 		}
		 	});
		 	var array = new Array();
			array = returnValue();
		 	$('#url_pic1').val(ids1);
		 	//var text= editor.document.getBody().getText();
		 	var text = editor.getData();
		 	$("#materialContent").val(text);
			
			if(typeof(array[2]) == "undefined"){
				array[2] = 0;
				$("#materialSize").attr("value",array[2]);
			}else{
				$("#materialSize").attr("value",array[2]);
			}
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
	
	
});

function changeSelect(value){
	if(value ==0){
		$("#fileUp").hide();
		$("#content").show();
	}else if(value == 1){
		$("#fileUp").show();
		$("#content").hide();
	}
}
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="Code" value="${vdata.zongzhiMaterial.code }" />
			<input type="hidden" name="remark" value="0" />
			<input type="hidden" id="materialSize" name="materialSize" value="${vdata.zongzhiMaterial.materialSize }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="girdCode"><span class="red">*</span>所属辖区/部门</label>
			
					<div class="col-xs-4">
						<input type="text" id="girdCode" name="girdCode" value="${vdata.zongzhiMaterial.girdCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="materialName"><span class="red">*</span>资料名称</label>
			
					<div class="col-xs-4">
						<input type="text"id="materialName" name="materialName" value="${vdata.zongzhiMaterial.materialName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeMaterialType"><span class="red">*</span>资料传入类型</label>
			
					<div class="col-xs-4">
						<%-- <input type="text" id="codeMaterialType" name="codeMaterialType" value="${vdata.material.codeMaterialType }" class="col-xs-12 col-sm-12 tooltip-error required" /> --%>
						<select id="selectId" class="form-control myselect" name="codeMaterialType" style="width: 100%;" onchange="changeSelect(this.value)">
						 <option id="codeUploadMaterialType"  value="学习" selected="selected">--请选择--</option>
                           <option id="shoudong"  value="0">手动编写</option>
                           <option id="upfile" value="1">文件上传</option>
                        </select>
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeUploadMaterialType">上传资料类型</label>
			
					<div class="col-xs-4">
						<input id="codeUploadMaterialType" type="text" name="codeUploadMaterialType" value="${vdata.zongzhiMaterial.codeUploadMaterialType }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group" id="content">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for=materialContent>学习资料内容 </label>
			
					<div class="col-xs-10">
						<textarea id="materialContent" name="materialContent" rows="15" cols="50" class="ckeditor">${vdata.zongzhiMaterial.materialContent }</textarea>
					</div>
				</div>
				<div class="form-group" id="fileUp">
					<label class="col-xs-2 control-label no-padding-right text-right">上传文件资料 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv1' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn1" type="button">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							 <!-- <span><font color="#FF0000">(多资料上传时，请注意须同时上传，以免使资料大小存在数据差异)</font></span> -->
							<br>
						</div>
							<input type="HIDDEN" id="url_pic1" name="materialFile" value="${vdata.zongzhiMaterial.materialFile }" />
						</div>
					</div>
				</div>
				<c:if test="${vdata.zongzhiMaterial.materialFile != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存文件 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old1" class="dropzone">
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


