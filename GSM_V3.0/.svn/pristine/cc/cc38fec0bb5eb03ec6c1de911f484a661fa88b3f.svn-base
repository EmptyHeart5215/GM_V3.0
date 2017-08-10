<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<link rel="stylesheet" href="${base}/resource/css/jquery-ui.css">
<jsp:include  page="/resource/base_import.jsp"/>
  
<script type="text/javascript">
$(function(){
	$.ajax({
	    type: "POST",
	    url: "${base}/sys/user/queryUserByName?username=1",
	    dataType: "json",
	    success: function(data){
	    var	availableTags=data;
	    $( "#gpsUsercode" ).autocomplete({
	        source: availableTags,
	        select: function(event, ui){
	    		// 这里的this指向当前输入框的DOM元素
	    		// event参数是事件对象
	    		// ui对象只有一个item属性，对应数据源中被选中的对象
	    		$("#gpsUsercode").val(ui.item.label)
	    		$("#gpsUsercodes").val(ui.item.value);
	    		// 必须阻止默认行为，因为autocomplete默认会把ui.item.value设为输入框的value值
	    		event.preventDefault();		
	    	}
	     });
	    }
		
	});                
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
<style type="text/css">

</style>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="Code" value="${vdata.sysDevice.code }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>设备名称</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gpsName" name="gpsName" value="${vdata.sysDevice.gpsName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>设备电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gpsSimno" name="gpsSimno" value="${vdata.sysDevice.gpsSimno }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
					
					<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>设备编码IMEI</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gpsImei" name="gpsImei" value="${vdata.sysDevice.gpsImei }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>绑定用户</label>
			        <div class="col-xs-4">
						<input type="text" max-length="50" id="gpsUsercode" value="${vdata.sysDevice.user.loginName }" class="col-xs-12 col-sm-12 tooltip-error required" />
						<input type="hidden" max-length="50" id="gpsUsercodes" name="gpsUsercode" value="${vdata.sysDevice.gpsUsercode }" />
					</div>
					
				</div>
					
					<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>排序</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="sort" name="sort" value="${vdata.sysDevice.sort }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>真实姓名</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="realName" name="realName" value="${vdata.sysDevice.realName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="remark">备注 </label>
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="remark" name="remark" class="col-xs-12 col-sm-5">${vdata.sysDevice.remark }</textarea>
						</div>
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


