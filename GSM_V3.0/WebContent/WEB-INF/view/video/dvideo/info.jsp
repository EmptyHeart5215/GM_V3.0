	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/gsm/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
<jsp:include  page="/resource/base_import.jsp"/>

<script type="text/javascript">
$(function(){
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
});
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
<!-- 			<h2 class="text-center">组织生活</h2> -->
			<input type="hidden" name="code" value="${vdata.vid.code }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">视频名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="videoName" name="videoName" value="${vdata.vid.videoName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName"><span class="red">*</span>视频地址</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="videoAddress" name="videoAddress" value="${vdata.vid.videoAddress }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleName">所属辖区</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridName" name="gridName" value="${vdata.vid.gridName }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleRange">编码</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeVideonet" name="codeVideonet" value="${vdata.vid.codeVideonet }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleLocation">类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="typeVideoname" name="typeVideoname" value="${vdata.vid.typeVideoname }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>通道名</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeChannel" name="codeChannel" value="${vdata.vid.codeChannel }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">地图坐标</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="position" name="position" value="${vdata.vid.position }" class="col-xs-12 col-sm-12 " />
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
</html>
