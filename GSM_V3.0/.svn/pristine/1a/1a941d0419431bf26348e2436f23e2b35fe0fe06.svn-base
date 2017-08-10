<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	
	submitForm('bfWuBao',"${vdata.bfWuBaoUrl}");
	deleteForm('bfWuBao',"${vdata.bfWuBaoDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="bfWuBaoForm">
<input type="hidden" id="bfWuBaoCode" value="${vdata.bfWuBaoPerson.code}" name="code">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>五保证号码</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="numberFive" value="${vdata.bfWuBaoPerson.numberFive }" class="col-xs-12 col-sm-12 tooltip-error required number" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>保证人口</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="guarantee" value="${vdata.bfWuBaoPerson.guarantee }" class="col-xs-12 col-sm-12 tooltip-error required digital number" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>户月保障金额</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="monthGuarantee" value="${vdata.bfWuBaoPerson.monthGuarantee }" class="col-xs-12 col-sm-12 tooltip-error required number" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.bfWuBaoPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="bfWuBaoCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="bfWuBaoCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
