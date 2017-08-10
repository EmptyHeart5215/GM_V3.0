<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	submitForm('bfDiBao',"${vdata.bfDiBaoUrl}");
	deleteForm('bfDiBao',"${vdata.bfDiBaoDelUrl}");
});

</script>
<form class="form-horizontal" role="form" id="bfDiBaoForm">
<input type="hidden" id="bfDiBaoCode" value="${vdata.bfDiBaoPerson.code}" name="code">

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>低保证号码</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="lowProtectNum" value="${vdata.bfDiBaoPerson.lowProtectNum }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>发证时间</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker required"name="sendDate" value="${vdata.bfDiBaoPerson.sendDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否五保户</label>
	<div class="col-xs-4">
		<select name="isFiveProtect" value="${vdata.bfDiBaoPerson.isFiveProtect }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">--请选择--</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >保障人口</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="guarantee" value="${vdata.bfDiBaoPerson.guarantee }" class="col-xs-12 col-sm-12 tooltip-error digits" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>户月保障金额</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="monthGuarantee" value="${vdata.bfDiBaoPerson.monthGuarantee }" class="col-xs-12 col-sm-12 tooltip-error required number" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.bfDiBaoPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="bfDiBaoCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="bfDiBaoCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
