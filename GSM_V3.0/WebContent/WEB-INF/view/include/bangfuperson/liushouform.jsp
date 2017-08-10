<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<form class="form-horizontal" role="form" id="liuShouForm">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>父母去向</label>
	<div class="col-xs-10">
		<textarea rows=""class="col-xs-12 col-sm-12 tooltip-error required" cols="" name="parentsGo">${vdata.house.parentsGo }</textarea>
	</div>
	</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >情况说明</label>
	<div class="col-xs-10">
		<textarea rows=""class="col-xs-12 col-sm-12 " cols="" name="remark">${vdata.house.remark }</textarea>
	</div>
</div>
</form>
