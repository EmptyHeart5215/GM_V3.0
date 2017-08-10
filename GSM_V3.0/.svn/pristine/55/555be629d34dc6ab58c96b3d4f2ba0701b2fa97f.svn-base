    <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//家庭经济状况
	$("[name='codeJingJiSituation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JING_JI_SITUATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//目前诊断类型
	$("[name='codeZhenDuanType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ZHEN_DUAN_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//目前危险性评估等级
	$("[name='codeWeiXianClasses']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_WEI_XIAN_CLASSES',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	// 治疗情况
	$("[name='codeZhiLiaoSituation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ZHI_LIAO_SITUATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//实施住院治疗原因 可多选
	$("[name='codeZhuYuanReason']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ZHU_YUAN_REASON',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo',
	checkBox:true
	});
	//参与管理人员 可多选
	$("[name='codeManagePeople']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_MANAGE_PEOPLE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo',
	checkBox:true
	});
	//帮扶情况 可多选
	$("[name='codeBangFuSituation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_BANG_FU_SITUATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo',
	checkBox:true
	});


	
	submitForm('tSJingShen',"${vdata.tSJingShenUrl}");
	deleteForm('tSJingShen',"${vdata.tSJingShenDelUrl}");
	
	defaultSelect('isDiBao');
	defaultSelect('isZhaoShi');
});

</script>
    <form class="form-horizontal" role="form" id="tSJingShenForm">
    <input type="hidden" id="tSJingShenCode" value="${vdata.tSJingShenPerson.code}" name="code">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >家庭经济状况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeJingJiSituation" value="${vdata.tSJingShenPerson.codeJingJiSituation }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否纳入低保</label>
	<div class="col-xs-4">
	<select name="isDiBao" value="${vdata.tSJingShenPerson.isDiBao }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">请选择</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >监护人身份号码</label>
	<div class="col-xs-10">
		<input type="text" max-length="18"name="jianHuCid" value="${vdata.tSJingShenPerson.jianHuCid }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>监护人姓名</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="jianHuName" value="${vdata.tSJingShenPerson.jianHuName }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>监护人联系方式</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="jianHuPhone" value="${vdata.tSJingShenPerson.jianHuPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >初次发病日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker "name="firstIllDate" value="${vdata.tSJingShenPerson.firstIllDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>诊断类型</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeZhenDuanType" value="${vdata.tSJingShenPerson.codeZhenDuanType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>有无肇事肇祸史</label>
	<div class="col-xs-4">
		<select name="isZhaoShi" value="${vdata.tSJingShenPerson.isZhaoShi }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="">请选择</option>
			<option value="1">有</option>
			<option value="0">无</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >肇事肇祸次数</label>
	<div class="col-xs-4">
		<input type="text" max-length="1"name="zhaoShiCount" value="${vdata.tSJingShenPerson.zhaoShiCount }" class="col-xs-12 col-sm-12 tooltip-error digital" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >上次肇事肇祸日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker "name="lastZhaoShiDate" value="${vdata.tSJingShenPerson.lastZhaoShiDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>危险性评估等级</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeWeiXianClasses" value="${vdata.tSJingShenPerson.codeWeiXianClasses }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>治疗情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeZhiLiaoSituation" value="${vdata.tSJingShenPerson.codeZhiLiaoSituation }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >治疗医院名称</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="yiYuanName" value="${vdata.tSJingShenPerson.yiYuanName }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >实施住院治疗原因</label>
	<div class="col-xs-10">
		<input type="text" max-length="50"name="codeZhuYuanReason" value="${vdata.tSJingShenPerson.codeZhuYuanReason }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >接收康复训练机构</label>
	<div class="col-xs-10">
		<input type="text" max-length="50"name="jiGouName" value="${vdata.tSJingShenPerson.jiGouName }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >参与管理人员</label>
	<div class="col-xs-10">
		<input type="text" max-length="50"name="codeManagePeople" value="${vdata.tSJingShenPerson.codeManagePeople }" class="col-xs-12 col-sm-12 tooltip-error " />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
	<div class="col-xs-10">
		<input type="text" max-length="50"name="codeBangFuSituation" value="${vdata.tSJingShenPerson.codeBangFuSituation }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="space-4"></div>
<div class="control-group">
     <label class="control-label">
     </label>
</div>
<div >
	<button  data-bb-handler="close" id="tSJingShenCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
	<button style="margin-right:5px;" data-bb-handler="success" id="tSJingShenCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
</div>
</form>
