	
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
			<input type="hidden" name="code" value="${vdata.bjigouser.code }" />
			<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">机构名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="jigouName" name="jigouName" value="${vdata.bjigouser.jigouName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName">机构负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="jigouManager" name="jigouManager" value="${vdata.bjigouser.jigouManager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				 
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="managerPhone">机构负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="managerPhone" name="managerPhone" value="${vdata.bjigouser.managerPhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="personName"><span class="red">*</span>服务对象姓名</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="personName" name="personName" value="${vdata.bjigouser.personName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="personCid">服务对象身份证号</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="personCid" name="personCid" value="${vdata.bjigouser.personCid }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="personPhone">服务对象手机号</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="personPhone" name="personPhone" value="${vdata.bjigouser.personPhone }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="personAddress">服务对象地址</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="personAddress" name="personAddress" value="${vdata.bjigouser.personAddress }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="serviceTime">服务时间</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="serviceTime" name="serviceTime" value="${vdata.bjigouser.serviceTime }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="position">地图定位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="position" name="position" value="${vdata.bjigouser.position }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleName">具体服务信息</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="serviceDescription" name="serviceDescription" value="${vdata.bjigouser.serviceDescription }" class="col-xs-12 col-sm-12 " />
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
