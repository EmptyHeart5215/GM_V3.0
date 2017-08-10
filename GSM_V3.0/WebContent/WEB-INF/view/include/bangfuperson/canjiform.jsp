<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//残疾类别
	$("[name='codeDisableType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_DISABLE_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//残疾等级
	$("[name='codeDisableLevel']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_DISABLE_LEVEL',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	submitForm('bfCanJi',"${vdata.bfCanJiUrl}");
	deleteForm('bfCanJi',"${vdata.bfCanJiDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="bfCanJiForm">
<input type="hidden" id="bfCanJiCode" value="${vdata.bfCanJiPerson.code}" name="code">

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>残疾证号</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="num" value="${vdata.bfCanJiPerson.num }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >发证时间</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker"name="sendDate" value="${vdata.bfCanJiPerson.sendDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>残疾类别</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeDisableType" value="${vdata.bfCanJiPerson.codeDisableType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>残疾等级</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeDisableLevel" value="${vdata.bfCanJiPerson.codeDisableLevel }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.bfCanJiPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="bfCanJiCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="bfCanJiCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
