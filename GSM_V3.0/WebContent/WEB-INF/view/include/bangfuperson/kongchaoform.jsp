<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	submitForm('bfKongChao',"${vdata.bfKongChaoUrl}");
	deleteForm('bfKongChao',"${vdata.bfKongChaoDelUrl}");
});

jQuery.extend(jQuery.validator.messages, {
	age: "只能输入整数",
});
jQuery.validator.addMethod("age",function(value, element) {
	if($.trim(value)!=""){
		if((/^(1([0|1]\d|20)|[6-9]\d)$/).test(value)){
		
			return true;
		}
		return false;
		}
	return true;
	},"请输入60-120的整数！");
</script>
<form class="form-horizontal" role="form" id="bfKongChaoForm">
<input type="hidden" id="bfKongChaoCode" value="${vdata.bfKongChaoPerson.code}" name="code">

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>年龄</label>
	<div class="col-xs-4">
		<input type="text" max-length="3"name="age" value="${vdata.bfKongChaoPerson.age }" class="col-xs-12 col-sm-12 tooltip-error age required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >子女去向</label>
	<div class="col-xs-10">
		<input type="text" max-length="50"name="childGo" value="${vdata.bfKongChaoPerson.childGo }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>

<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.bfKongChaoPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="bfKongChaoCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="bfKongChaoCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
