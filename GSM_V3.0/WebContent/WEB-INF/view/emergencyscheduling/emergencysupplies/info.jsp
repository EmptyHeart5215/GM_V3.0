<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
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
	//应急物资
	$("[name='codeSuppliesType']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SUPPLIES_TYPE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	//物资状态
	$("[name='codeSuppliesState']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SUPPLIES_STATE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	$("[name=gridCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
	});
});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.EmergencySupplies.code }" />
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属辖区</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.EmergencySupplies.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					
				</div>	
				<div class="form-group">
				<label  class="col-xs-2 control-label no-padding-right text-right" for="suppliesName"><span class="red">*</span>物资名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="suppliesName" name="suppliesName" value="${vdata.EmergencySupplies.suppliesName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				<label  class="col-xs-2 control-label no-padding-right text-right" for="suppliesprincipal"><span class="red">*</span>物资负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="suppliesprincipal" name="suppliesprincipal" value="${vdata.EmergencySupplies.suppliesprincipal }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="suppliesPhone"><span class="red">*</span>物资负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="suppliesPhone" name="suppliesPhone" value="${vdata.EmergencySupplies.suppliesPhone }" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
					</div>
				
					<label  class="col-xs-2 control-label no-padding-right text-right" for="codeSuppliesType"><span class="red">*</span>物资类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeSuppliesType" name="codeSuppliesType" value="${vdata.EmergencySupplies.codeSuppliesType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="codeSuppliesState"><span class="red">*</span>物资状态</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeSuppliesState" name="codeSuppliesState" value="${vdata.EmergencySupplies.codeSuppliesState }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" for="suppliesNum"><span class="red">*</span>物资数量</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="suppliesNum" name="suppliesNum" value="${vdata.EmergencySupplies.suppliesNum }" class="col-xs-12 col-sm-12 tooltip-error required number" />
					</div>
				</div>

				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="suppliesStoreAddress"><span class="red">*</span>物资存放地址</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="suppliesStoreAddress" name="suppliesStoreAddress" value="${vdata.EmergencySupplies.suppliesStoreAddress }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="suppliesStoreAddress"><span class="red">*</span>地图定位</label>
					<div class="col-xs-10 input-group">
					     <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.EmergencySupplies.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
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


