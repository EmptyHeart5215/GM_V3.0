<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//感染途径
	$("[name='codeGanRanRoute']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_GAN_RAN_ROUTE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//案件类别
	$("#aiZiCodeAnJianType").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ZUI_MING',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			resetId:'redo'
			});
	//关注类型
	$("[name='codeGuanZhuType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_GUAN_ZHU_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//收治情况
	$("[name='codeShouZhiSituation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SHOU_ZHI_SITUATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});

	submitForm('tSAiZi',"${vdata.tSAiZiUrl}");
	deleteForm('tSAiZi',"${vdata.tSAiZiDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="tSAiZiForm">
<input type="hidden" id="tSAiZiCode" value="${vdata.tSAiZiPerson.code}" name="code">

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>感染途径</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeGanRanRoute" value="${vdata.tSAiZiPerson.codeGanRanRoute }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否有违法犯罪史</label>
	<div class="col-xs-4">
	<select name="isFanZui" value="${vdata.tSAiZiPerson.isFanZui }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">请选择</option>
			<option value="1">有</option>
			<option value="0">无</option>
		</select>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >违法犯罪情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="fanZuiRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSAiZiPerson.fanZuiRemark}</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >案件类别</label>
	<div class="col-xs-4">
		<input type="text" max-length="50" id="aiZiCodeAnJianType"name="codeAnJianType" value="${vdata.tSAiZiPerson.codeAnJianType }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>关注类型</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeGuanZhuType" value="${vdata.tSAiZiPerson.codeGuanZhuType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSAiZiPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶人姓名</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuName" value="${vdata.tSAiZiPerson.bangFuName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶人联系方式</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuPhone" value="${vdata.tSAiZiPerson.bangFuPhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >收治情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeShouZhiSituation" value="${vdata.tSAiZiPerson.codeShouZhiSituation }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >牧治机构名称</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="shouZhiJiGou" value="${vdata.tSAiZiPerson.shouZhiJiGou }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
</div>

<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="tSAiZiCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="tSAiZiCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
