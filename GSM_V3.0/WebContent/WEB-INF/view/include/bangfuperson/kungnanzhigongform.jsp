<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	submitForm('bfKunNanZhiGong',"${vdata.bfKunNanZhiGongUrl}");
	deleteForm('bfKunNanZhiGong',"${vdata.bfKunNanZhiGongDelUrl}");
});

</script>
<form class="form-horizontal" role="form" id="bfKunNanZhiGongForm">
<input type="hidden" id="bfKunNanZhiGongCode" value="${vdata.bfKunNanZhiGongPerson.code}" name="code">

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>情况说明</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="description" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.bfKunNanZhiGongPerson.description }</textarea>
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.bfKunNanZhiGongPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="bfKunNanZhiGongCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="bfKunNanZhiGongCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
