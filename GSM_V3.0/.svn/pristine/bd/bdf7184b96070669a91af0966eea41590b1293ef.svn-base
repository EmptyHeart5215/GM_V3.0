	
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
			<input type="hidden" name="code" value="${vdata.bfeigong.code }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">组织名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="name" name="name" value="${vdata.bfeigong.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName"><span class="red">*</span>负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="jingJiManager" name="jingJiManager" value="${vdata.bfeigong.jingJiManager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleName">所属辖区</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.bfeigong.gridCode }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleRange">注册时间</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="registerDate" name="registerDate" value="${vdata.bfeigong.registerDate }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">地图坐标</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="position" name="position" value="${vdata.bfeigong.position }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>团组织负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="unionManager" name="groupManager" value="${vdata.bfeigong.groupManager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">团组织负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="groupManagerPhone" name="groupManagerPhone" value="${vdata.bfeigong.groupManagerPhone }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>团组织负责人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="groupManagerDuty" name="groupManagerDuty" value="${vdata.bfeigong.groupManagerDuty }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">主管部门</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="directDepartment" name="directDepartment" value="${vdata.bfeigong.directDepartment }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>网格联系人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridName" name="gridName" value="${vdata.bfeigong.gridName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">网格联系人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridDuty" name="gridDuty" value="${vdata.bfeigong.gridDuty }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>网格联系人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridPhone" name="gridPhone" value="${vdata.bfeigong.gridPhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">组织地址</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="address" name="address" value="${vdata.bfeigong.address }" class="col-xs-12 col-sm-12 " />
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
