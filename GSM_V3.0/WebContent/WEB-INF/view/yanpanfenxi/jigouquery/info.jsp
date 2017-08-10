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
			<input type="hidden" name="code" value="${vdata.bjigou.code }" />
			<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">机构名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="jigouName" name="jigouName" value="${vdata.bjigou.jigouName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName">机构负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="jigouManager" name="jigouManager" value="${vdata.bjigou.jigouManager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				 
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">机构地址</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="address" name="address" value="${vdata.bjigou.address }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName"><span class="red">*</span>所属辖区</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="gridCode" name="gridCode" value="${vdata.bjigou.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleName">可提供服务类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="serviceType" name="serviceType" value="${vdata.bjigou.serviceType }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleRange">服务描述</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="serviceDescriptione" name="serviceDescriptione" value="${vdata.bjigou.serviceDescriptione }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">网格联系人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridDuty" name="gridDuty" value="${vdata.bjigou.gridDuty }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>网格联系人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridPhone" name="gridPhone" value="${vdata.bjigou.gridPhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">机构描述</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="description" name="description" value="${vdata.bjigou.description }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>网格联系人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridName" name="gridName" value="${vdata.bjigou.gridName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">地图定位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="position" name="position" value="${vdata.bjigou.position }" class="col-xs-12 col-sm-12 " />
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
