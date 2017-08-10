<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//人员类型
	$("[name='codeQsnType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_QSN_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//家庭情况
	$("[name='codeJiaTingSituation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JIA_TING_SITUATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//与监护人关系
	$("[name='codeJianHuRelation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_OWNER_RELATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	// 帮扶手段
	$("[name='codeBangFuType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_BANG_FU_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});


	submitForm('qingShaoNian',"${vdata.qingShaoNianUrl}");
	deleteForm('qingShaoNian',"${vdata.qingShaoNianDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="qingShaoNianForm">
<input type="hidden" id="qingShaoNianCode" value="${vdata.qingShaoNianPerson.code}" name="code">

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>人员类型</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeQsnType" value="${vdata.qingShaoNian.codeQsnType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>家庭情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeJiaTingSituation" value="${vdata.qingShaoNian.codeJiaTingSituation }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>监护人姓名</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="jianHuName" value="${vdata.qingShaoNian.jianHuName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>监护人身份号码</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="jianHuCid" value="${vdata.qingShaoNian.jianHuCid }" class="col-xs-12 col-sm-12 tooltip-error required personcid" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>与监护人关系</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeJianHuRelation" value="${vdata.qingShaoNian.codeJianHuRelation }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>监护人联系方式</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="jianHuPhone" value="${vdata.qingShaoNian.jianHuPhone }" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>监护人居住详址</label>
	<div class="col-xs-10">
		<input type="text" max-length="50"name="jianHuAddress" value="${vdata.qingShaoNian.jianHuAddress }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否违法犯罪</label>
	<div class="col-xs-4">
	<select name="isFanZui" value="${vdata.qingShaoNian.isFanZui }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error">
			<option value="">请选择</option>
			<option value="1">有</option>
			<option value="0">无</option>
		</select>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >违法犯罪情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="fanZuiRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.qingShaoNian.fanZuiRemark}</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶人姓名</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuName" value="${vdata.qingShaoNian.bangFuName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶人联系方式</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuPhone" value="${vdata.qingShaoNian.bangFuPhone }" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶手段</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeBangFuType" value="${vdata.qingShaoNian.codeBangFuType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.qingShaoNian.bangFuRemark}</textarea>
	</div>
</div>


<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="qingShaoNianCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="qingShaoNianCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
