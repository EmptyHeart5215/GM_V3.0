<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){

	//管控情况
	$("[name='codeGuanKong']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_GUAN_KONG',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//吸毒原因
	$("[name='codeXiDuReason']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_XI_DU_REASON',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//吸毒后果
	$("[name='codeXiDuEffect']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_XI_DU_EFFECT',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});

	submitForm('tSXiDu',"${vdata.tSXiDuUrl}");
	deleteForm('tSXiDu',"${vdata.tSXiDuDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="tSXiDuForm">
<input type="hidden" id="tSXiDuCode" value="${vdata.tSXiDuPerson.code}" name="code">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>初次发现日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker  tooltip-error required"name="firstDate" value="${vdata.tSXiDuPerson.firstDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>管控情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeGuanKong" value="${vdata.tSXiDuPerson.codeGuanKong }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>管控人姓名</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="guanKongName" value="${vdata.tSXiDuPerson.guanKongName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>管控人联系方式</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="guanKongPhone" value="${vdata.tSXiDuPerson.guanKongPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="bangFuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSXiDuPerson.bangFuRemark }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶人姓名</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuName" value="${vdata.tSXiDuPerson.bangFuName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>帮扶人联系方式</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuPhone" value="${vdata.tSXiDuPerson.bangFuPhone }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>有无犯罪史</label>
	<div class="col-xs-4">
		<select name="isFanZui" value="${vdata.tSXiDuPerson.isFanZui }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">请选择</option>
			<option value="1">有</option>
			<option value="0">无</option>
		</select>
	</div>
</div>
<div class="form-group">
<label class="col-xs-2 control-label no-padding-right text-right" >犯罪情况</label>
	<div class="col-xs-10">
	<textarea  max-length="1000"name="fanZuiRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSXiDuPerson.fanZuiRemark}</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >吸毒原因</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeXiDuReason" value="${vdata.tSXiDuPerson.codeXiDuReason }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >吸毒后果</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeXiDuEffect" value="${vdata.tSXiDuPerson.codeXiDuEffect }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="tSXiDuCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="tSXiDuCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
