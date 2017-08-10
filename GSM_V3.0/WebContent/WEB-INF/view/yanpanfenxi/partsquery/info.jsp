	
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
			<input type="hidden" name="code" value="${vdata.bpart.code }" />
			<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">部件名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="name" name="name" value="${vdata.bpart.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName">部件编码</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="partsCode" name="partsCode" value="${vdata.bpart.partsCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				 
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">部件地址</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="address" name="address" value="${vdata.bpart.address }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName"><span class="red">*</span>所属辖区</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="gridCode" name="gridCode" value="${vdata.bpart.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleName">大类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="bPartsBigType" name="bPartsBigType" value="${vdata.bpart.bPartsBigType }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleRange">小类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="bPartsSmallType" name="bPartsSmallType" value="${vdata.bpart.bPartsSmallType }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">权属单位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belong" name="belong" value="${vdata.bpart.belong }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>权属单位负责人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongDuty" name="belongDuty" value="${vdata.bpart.belongDuty }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">权属单位负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongMan" name="belongMan" value="${vdata.bpart.belongMan }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>权属单位负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongPhone" name="belongPhone" value="${vdata.bpart.belongPhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">养护单位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="care" name="care" value="${vdata.bpart.care }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>养护单位负责人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="careDuty" name="careDuty" value="${vdata.bpart.careDuty }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">养护单位负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="careMan" name="careMan" value="${vdata.bpart.careMan }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>养护单位负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="carePhone" name="carePhone" value="${vdata.bpart.carePhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">管理单位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="enterpriseManage" name="enterpriseManage" value="${vdata.bpart.enterpriseManage }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>管理单位负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="enterprisePhone" name="enterprisePhone" value="${vdata.bpart.enterprisePhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">管理单位负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="enterpriseMan" name="enterpriseMan" value="${vdata.bpart.enterpriseMan }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>管理单位负责人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="enterpriseDuty" name="enterpriseDuty" value="${vdata.bpart.enterpriseDuty }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">部件状态</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="partsStatus" name="partsStatus" value="${vdata.bpart.partsStatus }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">联系人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="contact" name="contact" value="${vdata.bpart.contact }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">联系人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="contactPhone" name="contactPhone" value="${vdata.bpart.contactPhone }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">所属部门</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="departmentCode" name="departmentCode" value="${vdata.bpart.departmentCode }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">网格联系人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridDuty" name="gridDuty" value="${vdata.bpart.gridDuty }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>网格联系人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridPhone" name="gridPhone" value="${vdata.bpart.gridPhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">部件图片</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="picture" name="picture" value="${vdata.bpart.picture }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>网格联系人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridName" name="gridName" value="${vdata.bpart.gridName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">地图定位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="position" name="position" value="${vdata.bpart.position }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">描述</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="description" name="description" value="${vdata.bpart.description }" class="col-xs-12 col-sm-12 " />
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
