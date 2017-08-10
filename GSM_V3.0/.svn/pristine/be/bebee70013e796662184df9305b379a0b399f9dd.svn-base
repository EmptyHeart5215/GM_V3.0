	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	$("[name=gridCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
	});
	$("[name=codeDocumnetType]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_DOCUMNET_TYPE',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone1=new Dropzone("#dropzoneDiv1",{
		 	urlBase:"${base}",
		   existedFiles:$('#url_pic1').val().split(";").length-1,
		   uploadBtnId:'uploadBtn1',
           imgName:'showImg1',
           acceptedFiles: "image/*,application/pdf,.psd,.obj,.txt,.xls,.html,.doc,.ppt,.docx,.zip",
           maxFilesize: 100,//最大文件大小，MB
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
		 	
			if(typeof(array[2]) == "undefined"){
				array[2] = 0;
				$("#documentSize").attr("value",array[2]);
			}else{
				$("#documentSize").attr("value",array[2]);
			}
			if(array[1] != null){
				$("#documentName").val(array[1]);
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
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">

			<input type="hidden" id="code" name="code" value="${vdata.DocumentQuery.code }" />
			<input type="hidden" id="documentSize" name="documentSize" value="${vdata.DocumentQuery.documentSize }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">文件名称</label>
					<div class="col-xs-10">
						<input type="text" max-length="100"id="documentName" placeholder="文件名称可不用填写，当上传成功后，点击提交时会自动填写" name="documentName" value="${vdata.DocumentQuery.documentName }" class="col-xs-12 col-sm-12" />
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区/部门</label>
			
					<div class="col-xs-4">
						<input type="text" id="gridCode" name="gridCode" value="${vdata.DocumentQuery.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeDocumnetType"><span class="red">*</span>文件类型</label>
			
					<div class="col-xs-4">
						<input type="text"id="codeDocumnetType" name="codeDocumnetType" value="${vdata.DocumentQuery.codeDocumnetType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="remark">备注 </label>
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="remark" name="remark" class="col-xs-12 col-sm-12">${vdata.DocumentQuery.remark }</textarea>
						</div>
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
							<input type="HIDDEN" id="url_pic1" name="fileCode" value="${vdata.DocumentQuery.fileCode }" />
						</div>
					</div>
				</div>
				<c:if test="${vdata.DocumentQuery.fileCode != null}">
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
                <label class="control-label"></label></div> 
		</form>
	</div>
</div>
</body>
</html>
