<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//年级
	$("[name='codeGrade']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_GRADE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	submitForm('bfTeKunSheng',"${vdata.bfTeKunShengUrl}");
	deleteForm('bfTeKunSheng',"${vdata.bfTeKunShengDelUrl}");
});

</script>
<form class="form-horizontal" role="form" id="bfTeKunShengForm">
<input type="hidden" id="bfTeKunShengCode" value="${vdata.bfTeKunShengPerson.code}" name="code">

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>年级</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeGrade" value="${vdata.bfTeKunShengPerson.codeGrade }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>就读学校</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="schoolName" value="${vdata.bfTeKunShengPerson.schoolName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否低保户</label>
	<div class="col-xs-4">
		<select name="isDiBao" value="${vdata.bfTeKunShengPerson.isDiBao }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error">
			<option value="">--请选择--</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
</div>

<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.bfTeKunShengPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="bfTeKunShengCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="bfTeKunShengCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
