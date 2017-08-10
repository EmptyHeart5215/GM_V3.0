<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	submitForm('bfJiuZhu',"${vdata.bfJiuZhuUrl}");
	deleteForm('bfJiuZhu',"${vdata.bfJiuZhuDelUrl}");
	
});
</script>
<form class="form-horizontal" role="form" id="bfJiuZhuForm">
<input type="hidden" id="bfJiuZhuCode" value="${vdata.bfJiuZhuPerson.code}" name="code">

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否重大疾病</label>
	<div class="col-xs-4">
		<select name="isMajorDiseases" value="${vdata.bfJiuZhuPerson.isMajorDiseases }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">--请选择--</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>疾病名称</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="disease" value="${vdata.bfJiuZhuPerson.disease }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >救助时间</label>
	<div class="col-xs-4">
	<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker"name="assistDate" value="${vdata.bfJiuZhuPerson.assistDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>救助金额</label>
	<div class="col-xs-4">
		<input type="text" max-length="10"name="assistAmount" value="${vdata.bfJiuZhuPerson.assistAmount }" class="col-xs-12 col-sm-12 tooltip-error number required" />
	</div>
	
</div>

<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.bfJiuZhuPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="bfJiuZhuCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="bfJiuZhuCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
