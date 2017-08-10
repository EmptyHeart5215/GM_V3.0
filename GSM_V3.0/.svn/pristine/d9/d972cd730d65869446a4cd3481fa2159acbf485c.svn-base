<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){

	submitForm('tSXieJiao',"${vdata.tSXieJiaoUrl}");
	deleteForm('tSXieJiao',"${vdata.tSXieJiaoDelUrl}");
});

</script>
<form class="form-horizontal" role="form" id="tSXieJiaoForm">
<input type="hidden" id="tSXieJiaoCode" value="${vdata.tSXieJiaoPerson.code}" name="code">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>邪教名称</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="xieJiaoName" value="${vdata.tSXieJiaoPerson.xieJiaoName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>入教时间</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker  tooltip-error required"name="beginDate" value="${vdata.tSXieJiaoPerson.beginDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>入教原因</label>
	<div class="col-xs-10">
		<input type="text" max-length="50"name="reason" value="${vdata.tSXieJiaoPerson.reason }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶人姓名</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuName" value="${vdata.tSXieJiaoPerson.bangFuName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶人联系方式</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuPhone" value="${vdata.tSXieJiaoPerson.bangFuPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSXieJiaoPerson.bangFuRemark  }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >现实表现</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="performance" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSXieJiaoPerson.performance }</textarea>
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="tSXieJiaoCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="tSXieJiaoCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
