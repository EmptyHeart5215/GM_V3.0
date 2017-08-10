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
				url : "${base}/sys/evaset/evaSetDepartment?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	bootbox.slideAlert('body',true,data.info);
		            	$("input[type='checkbox']").each(function(){
		            		if($(this).prop("checked")==false){
		            			$('input',$("#"+$(this).attr("id")+"_Div")).val('');
		            		}
		            	});
		            	
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			}); 
	    }
	});
	$('#acceptBtn').bind("click",function(){
		$("#form").submit();
	});
});
</script>
</head>
<body>
<div class="row">
	<div class="col-xs-12" id="body">
		<form name="" id="form" class="form-horizontal">
			<input type="hidden" name="code" value="${vdata.code}" />
			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">部门考核设置 </h4>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矛盾基础分</label>
							<div class="col-xs-4">
								<input type="text" name="basescoreContradict" value="${vdata.basescoreContradict }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>事件基础分</label>
							<div class="col-xs-4">
								<input type="text" name="basescoreEvent" value="${vdata.basescoreEvent}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矛盾未按时办结扣分</label>
							<div class="col-xs-4">
								<input type="text" name="lateKoufenContradict" value="${vdata.lateKoufenContradict }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>事件未按时办结扣分</label>
							<div class="col-xs-4">
								<input type="text" name="lateKoufenEvent" value="${vdata.lateKoufenEvent }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矛盾返工一次扣分</label>
							<div class="col-xs-4">
								<input type="text" name="dubanKoufenContradict" value="${vdata.dubanKoufenContradict}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>事件返工一次扣分</label>
							<div class="col-xs-4">
								<input type="text" name="dubanKoufenEvent" value="${vdata.dubanKoufenEvent}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矛盾群众不满意一次扣分</label>
							<div class="col-xs-4">
								<input type="text" name="manyiKoufenContradict" value="${vdata.manyiKoufenContradict }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>事件群众不满意一次扣分</label>
							<div class="col-xs-4">
								<input type="text" name="manyiKoufenEvent" value="${vdata.manyiKoufenEvent }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
		<div class="col-xs-12" style="text-align:right;">
				<button  id="acceptBtn" type="button" class="btn btn-success">提交</button>
		</div>
</div>
</body>
</html>