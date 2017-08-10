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
	
	$("#form").validate({
		submitHandler: function (form) {
			
        }
	});
	
	$("#acceptBtn").click(function(){
	var data = $("#form").serialize();
	$.ajax({
		type : "post",
		url : "${base}/${vdata.url}?t="+Math.random(),
		data : data,
		dataType : 'json',
		async : false,
		success : function(data) {
            if(data.status){
            	bootbox.slideAlert('body',true,data.info);
            	window.setTimeout(function(){
            		location.reload();
            	}, 1000);
            }else{ 
            	bootbox.slideAlert('body',false,data.info);
             } 
		}
	});
		
	});
	
	});

</script>
<style type="text/css">
  #hideShow {z-index:2;width: 100%	;height:25px;background:#478fca !important;}
</style>
</head>
<body>
<div class="row">
<div class="col-xs-12" id="body">
<center><h1>提醒设置</h1></center>
<form class="form-horizontal" role="form" id="form">
	<fieldset>
    	<legend class="lighter green">事件办理设置</legend>
				<div class="form-group">
				<label class="col-xs-1 control-label no-padding-right text-right" ></label>
					<div class="col-xs-5">
						<span class="red">*</span>默认办理时限为<input type="text" max-length="3" name="defaultBanLiDateEvent" value="${vdata.WarSet.defaultBanLiDateEvent }" class="col-xs-1col-sm-1 tooltip-error required" />个工作日
					</div>
					<label class="col-xs-1 control-label no-padding-right text-right" ></label>
					<div class="col-xs-5">
						<span class="red">*</span>办理时限剩余时限<=<input type="text" max-length="3" name="eventToYellow" value="${vdata.WarSet.eventToYellow }" class="col-xs-1col-sm-1 tooltip-error required" />个工作日出现黄灯提醒
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-12">
					说明：事件办理设置默认办理时限为${vdata.WarSet.defaultBanLiDateEvent }个工作日，${vdata.WarSet.defaultBanLiDateEvent }>当办理时限剩余工作日>=${vdata.WarSet.eventToYellow }时，系统显示绿灯；当办理时限剩余工作日<${vdata.WarSet.eventToYellow }天时，系统显示黄灯；当超过办理时限仍未办理时，系统显示红灯。
					</label>
				</div>
	</fieldset>
	<fieldset>
    	<legend class="lighter green">矛盾设置</legend>
				<div class="form-group">
					<label class="col-xs-1 control-label no-padding-right text-right" ></label>
					<div class="col-xs-5">
						<span class="red">*</span>默认办理时限为<input type="text" max-length="3" name="defaultBanLiDateContradict" value="${vdata.WarSet.defaultBanLiDateContradict}" class="col-xs-1col-sm-1 tooltip-error required" />个工作日
					</div>
					<label class="col-xs-1 control-label no-padding-right text-right" ></label>
					<div class="col-xs-5">
						<span class="red">*</span>办理时限剩余时限<=<input type="text" max-length="3" name="contradictToYellow" value="${vdata.WarSet.contradictToYellow }" class="col-xs-1col-sm-1 tooltip-error required" />个工作日出现黄灯提醒
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-12">
					说明：矛盾联动化解办理设置默认办理时限为${vdata.WarSet.defaultBanLiDateContradict }个工作日，${vdata.WarSet.defaultBanLiDateContradict }>当办理时限剩余工作日>=${vdata.WarSet.contradictToYellow }时，系统显示绿灯；当办理时限剩余工作日<${vdata.WarSet.contradictToYellow }天时，系统显示黄灯；当超过办理时限仍未办理时，系统显示红灯。
					</label>
				</div>
		</fieldset>
				
			</form>
		<div class="space-30"></div>
		<div class="col-xs-12" style="text-align:right;padding-right:4px;">
			<button  id="acceptBtn" type="button" class="btn btn-success">保存</button>
		</div>
		</div>
	</div>
	</body>
</html>


