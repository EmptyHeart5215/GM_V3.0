<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//矫正类别
	$("[name='codeRectifyType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_RECTIFY_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//案件类别
	$("#jZCodeAnJianType").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ZUI_MING',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//接收方武
	$("[name='codeJieShouType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JIE_SHOU_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//“四史”情况,可多选
	$("[name='codeSiShi']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SI_SHI',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo',
	checkBox:true
	});
	//“三涉”情况,可多选
	$("[name='codeSanShe']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SAN_SHE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo',
	checkBox:true
	});
	//矫正小组人员组成情况,可多选
	$("[name='codeGroupSituation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_GROUP_SITUATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo',
	checkBox:true
	});
	//矫正解除（终止）类型
	$("[name='codeJieChuType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JIE_CHU_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});

	
	submitForm('tSJiaoZheng',"${vdata.tSJiaoZhengUrl}");
	deleteForm('tSJiaoZheng',"${vdata.tSJiaoZhengDelUrl}");
	
	defaultSelect('isGuanFan');
	defaultSelect('isBuildGroup');
	defaultSelect('isTuoGuan');
	defaultSelect('isLouGuan');
	defaultSelect('isChongFan');
});

</script>
<form class="form-horizontal" role="form" id="tSJiaoZhengForm">
<input type="hidden" id="tSJiaoZhengCode" value="${vdata.tSJiaoZhengPerson.code}" name="code">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>社区矫正人员编号</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="rectifyNum" value="${vdata.tSJiaoZhengPerson.rectifyNum }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矫正类别</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeRectifyType" value="${vdata.tSJiaoZhengPerson.codeRectifyType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >原羁押场所</label>
	<div class="col-xs-10">
		<input type="text" max-length="100"name="jiYaPlace" value="${vdata.tSJiaoZhengPerson.jiYaPlace }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>具体罪名</label>
	<div class="col-xs-10">
		<input type="text" max-length="50"name="zuiMing" value="${vdata.tSJiaoZhengPerson.zuiMing }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>	
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>案件类别</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"id="jZCodeAnJianType"name="codeAnJianType" value="${vdata.tSJiaoZhengPerson.codeAnJianType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >原判刑期</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="xingQi" value="${vdata.tSJiaoZhengPerson.xingQi }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >原判刑开始日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker "name="xingQiBeginDate" value="${vdata.tSJiaoZhengPerson.xingQiBeginDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >原判刑结束日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker "name="xingQiEndDate" value="${vdata.tSJiaoZhengPerson.xingQiEndDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矫正开始日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker "name="rectifyBeginDate" value="${vdata.tSJiaoZhengPerson.rectifyBeginDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矫正结束日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker "name="rectifyEndDate" value="${vdata.tSJiaoZhengPerson.rectifyEndDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>接收方武</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeJieShouType" value="${vdata.tSJiaoZhengPerson.codeJieShouType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >“四史”情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeSiShi" value="${vdata.tSJiaoZhengPerson.codeSiShi }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
	
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >是否累惯犯</label>
	<div class="col-xs-4">
		<select name="isGuanFan" value="${vdata.tSJiaoZhengPerson.isGuanFan }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error">
			<option value="">请选择</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >“三涉”情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeSanShe" value="${vdata.tSJiaoZhengPerson.codeSanShe }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否建立矫正小组</label>
	<div class="col-xs-4">
		<select name="isBuildGroup" value="${vdata.tSJiaoZhengPerson.isBuildGroup }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">请选择</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矫正小组人员组成情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="100"name="codeGroupSituation" value="${vdata.tSJiaoZhengPerson.codeGroupSituation }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
<label class="col-xs-2 control-label no-padding-right text-right" >矫正解除类型</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeJieChuType" value="${vdata.tSJiaoZhengPerson.codeJieChuType }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否有脱管</label>
	<div class="col-xs-4">
		<select name="isTuoGuan" value="${vdata.tSJiaoZhengPerson.isTuoGuan }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">请选择</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
</div>
<div class="form-group">	
	<label class="col-xs-2 control-label no-padding-right text-right" >脱管原因</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="tuoGuanReason" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSJiaoZhengPerson.tuoGuanReason }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >检察监脱管管情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="jianTuoRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSJiaoZhengPerson.jianTuoRemark }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >脱管纠正情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="tuoJiaoRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSJiaoZhengPerson.tuoJiaoRemark }</textarea>
	</div>
</div>

<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否有漏管</label>
	<div class="col-xs-4">
		<select name="isLouGuan" value="${vdata.tSJiaoZhengPerson.isLouGuan }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">请选择</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >漏管原因</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="louGuanReason" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSJiaoZhengPerson.louGuanReason }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >检察监督漏管情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="jianLouRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSJiaoZhengPerson.jianLouRemark }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >漏管纠正情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="louJiuRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSJiaoZhengPerson.louJiuRemark }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>奖惩情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="jiangChengRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSJiaoZhengPerson.jiangChengRemark }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>刑罚变更执行情况</label>
	<div class="col-xs-10">
		<textarea  max-length="1000"name="xingBianZhiRemark" class="col-xs-12 col-sm-12 tooltip-error ">${vdata.tSJiaoZhengPerson.xingBianZhiRemark }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否重新犯罪</label>
	<div class="col-xs-4">
		<select name="isChongFan" value="${vdata.tSJiaoZhengPerson.isChongFan }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">请选择</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >重新犯罪名称</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="chongFanName" value="${vdata.tSJiaoZhengPerson.chongFanName }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="tSJiaoZhengCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;"id="tSJiaoZhengCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
