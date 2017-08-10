<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">

$(function(){
	$("input[type='checkbox']").on("click",function(){
		iFrameHeight(top.document.getElementById("mainFrame"));
		if($(this).prop("checked")==true){
			$("#"+$(this).attr("id")+"_Div").css("display","block");
		}else{
			$("#"+$(this).attr("id")+"_Div").css("display","none");
		}
	});
	
	$("#form").validate({
		submitHandler: function (form) {
			$("input[type='checkbox']").each(function(){
				if($(this).prop("checked")==true){
					$("[name="+$(this).attr("id")+"]").val("1");
				}else{
					$("[name="+$(this).attr("id")+"]").val("0");
				}
			});
			var data = $("#form").serialize();
			 $.ajax({
				type : "post",
				url : "${base}/sys/evaset/evaSet?t="+Math.random(),
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
			<input type="hidden" name="isContradict" value="${vdata.isContradict}" />
			<input type="hidden" name="isEvent"  value="${vdata.isEvent}"/>
			<input type="hidden" name="isLog"  value="${vdata.isLog}"/>
			<input type="hidden" name="isXunCha"   value="${vdata.isXunCha}"/>
			
			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">选择考核项 </h4>
				</div>
				<div class="widget-body">
					<div class="widget-main">
				<div class="form-horizontal">
					<div class="checkbox col-xs-3">
						<label>
							<input id="isContradict"class="ace" type="checkbox" >
							<span class="lbl">矛盾排查化解</span>
						</label>
					</div>
					<div class="checkbox col-xs-3">
						<label>
							<input id="isEvent" class="ace"type="checkbox" >
							<span class="lbl">事件办理</span>
						</label>
					</div>
					<div class="checkbox col-xs-3">
						<label>
							<input id="isLog" class="ace"type="checkbox" >
							<span class="lbl">民情日志</span>
						</label>
					</div>
					<div class="checkbox col-xs-3">
						<label>
							<input id="isXunCha" class="ace" value="1" type="checkbox" >
							<span class="lbl">巡查走访</span>
						</label>
					</div>
				</div>	
					</div>
				</div>
			</div>
				<div id="isContradict_Div" style="display:none;">
							<div class="widget-box transparent">
								<div class="widget-header  widget-header-flat" style="min-height:30px;">
									<h4 class="green">矛盾排查化解</h4>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>基础分</label>
											<div class="col-xs-4">
												<input type="text" name="contradictBaseScore" value="${vdata.contradictBaseScore }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>每月最少上报</label>
											<div class="col-xs-4">
												<input type="text" name="leastContradict" value="${vdata.leastContradict}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>每少上报一篇扣分</label>
											<div class="col-xs-4">
												<input type="text" name="lessKouFenContradict" value="${vdata.lessKouFenContradict }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>逾期办理一次扣分</label>
											<div class="col-xs-4">
												<input type="text" name="lateKouFenContradict" value="${vdata.lateKouFenContradict}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
										</div>
									</div>
								</div>
							</div>
				</div>
				<div id="isEvent_Div" style="display:none;">
							<div class="widget-box transparent">
								<div class="widget-header  widget-header-flat" style="min-height:30px;">
									<h4 class="green">事件办理 </h4>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>基础分</label>
											<div class="col-xs-4">
												<input type="text" name="eventBaseScore" value="${vdata.eventBaseScore }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>每月最少上报</label>
											<div class="col-xs-4">
												<input type="text" name="leastEvent" value="${vdata.leastEvent}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>每少上报一篇扣分</label>
											<div class="col-xs-4">
												<input type="text" name="lessKouFenEvent" value="${vdata.lessKouFenEvent }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>逾期办理一次扣分</label>
											<div class="col-xs-4">
												<input type="text" name="lateKouFenEvent" value="${vdata.lateKouFenEvent}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
										</div>
									</div>
								</div>
						</div>
				</div>
				<div id="isLog_Div" style="display:none;">
							<div class="widget-box transparent">
								<div class="widget-header  widget-header-flat" style="min-height:30px;">
									<h4 class="green">民情日志 </h4>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>日志基础分</label>
											<div class="col-xs-4">
												<input type="text" name="logBaseScore" value="${vdata.logBaseScore }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>每少一篇日志扣分</label>
											<div class="col-xs-4">
												<input type="text" name="lessKouFenLog" value="${vdata.lessKouFenLog }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
											<%-- <label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>每月最少日志</label>
											<div class="col-xs-4">
												<input type="text" name="leastLog" value="${vdata.leastLog}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div> --%>
										</div>
										<div class="form-group">
											
										</div>
									</div>
								</div>
							</div>
				</div>
				
				<div id="isXunCha_Div" style="display:none;">
						<div class="col-xs-12">
							<div class="widget-box transparent">
								<div class="widget-header  widget-header-flat" style="min-height:30px;">
									<h4 class="green">巡查走访 </h4>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>基础分</label>
											<div class="col-xs-4">
												<input type="text" name="zouFangBaseScore" value="${vdata.zouFangBaseScore }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>每天最少走访</label>
											<div class="col-xs-4">
												<input type="text" name="leastZouFangHu" value="${vdata.leastZouFangHu}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>每少一走访一户扣分</label>
											<div class="col-xs-4">
												<input type="text" name="lessKouFenZouFangHu" value="${vdata.lessKouFenZouFangHu }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
											</div>
										</div>
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
<script>
$(function(){
	$('[name^=is]').each(function(){
		if($(this).val()=='true'){
			$('#'+$(this).attr('name')).click();
		}
	});
	
});
</script>
</body>
</html>