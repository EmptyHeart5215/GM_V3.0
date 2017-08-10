<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//原罪名
	$("[name='codeZuiMing']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ZUI_MING',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//帮教类型
	$("[name='codeBangJiaoType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_BANG_JIAO_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//衔接情况
	$("[name='codeXianJieRemark']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_XIAN_JIE_REMARK',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//安置情况
	$("[name='codeAnZhiRemark']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_AN_ZHI_REMARK',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	
	submitForm('tSXingShi',"${vdata.tSXingShiUrl}");
	deleteForm('tSXingShi',"${vdata.tSXingShiDelUrl}");
	
	if($("[name='isLeiFan']").attr('value')=='true'){
		$("[name='isLeiFan']").val('1');
	}else if($("[name='isLeiFan']").attr('value')=='false'){
		$("[name='isLeiFan']").val('0');
	}
	defaultSelect('isLeiFan');
	defaultSelect('isAgainFanZui');
});

</script>
<form class="form-horizontal" role="form" id="tSXingShiForm">
<input type="hidden" id="tSXingShiCode" value="${vdata.tSXingShiPerson.code}" name="code">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否累犯</label>
	<div class="col-xs-4">
		<select name="isLeiFan" value="${vdata.tSXingShiPerson.isLeiFan }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="1" checked="checked">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>原罪名</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeZuiMing" value="${vdata.tSXingShiPerson.codeZuiMing }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>原判刑期</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="xingQi" value="${vdata.tSXingShiPerson.xingQi }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>服刑场所</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="fuXingPlace" value="${vdata.tSXingShiPerson.fuXingPlace }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>释放日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker required"name="shiFangDate" value="${vdata.tSXingShiPerson.shiFangDate}" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>危险性评估类型</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeBangJiaoType" value="${vdata.tSXingShiPerson.codeBangJiaoType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>衔接日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker required"name="xianJieDate" value="${vdata.tSXingShiPerson.xianJieDate}" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>衔接情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeXianJieRemark" value="${vdata.tSXingShiPerson.codeXianJieRemark }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>安置日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker required"name="anZhiDate" value="${vdata.tSXingShiPerson.anZhiDate}" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>安置情况</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeAnZhiRemark" value="${vdata.tSXingShiPerson.codeAnZhiRemark }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >未安置原因</label>
	<div class="col-xs-10">
		<textarea  class="col-xs-12 col-sm-12 tooltip-error "  max-length="500"name="weiAnZhiReason">${vdata.tSXingShiPerson.weiAnZhiReason }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >帮教情况</label>
	<div class="col-xs-10">
		<textarea  class="col-xs-12 col-sm-12 tooltip-error "  max-length="500" name="helpRemark">${vdata.tSXingShiPerson.helpRemark }</textarea>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否重新犯罪</label>
	<div class="col-xs-4">
		<select name="isAgainFanZui" value="${vdata.tSXingShiPerson.isAgainFanZui }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="1" checked="checked">是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >重新犯罪罪名</label>
	<div class="col-xs-4">
		<input type="text" max-length="100"name="againZuiMing" value="${vdata.tSXingShiPerson.againZuiMing }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="space-4"></div>
						<div class="control-group">
			                <label class="control-label">
			                </label>
			            </div>
			           <div >
			               <button  data-bb-handler="close" id="tSXingShiCloseBtn" type="button" class="btn btn-cancel pull-right">删除</button>
				           <button style="margin-right:5px;" data-bb-handler="success" id="tSXingShiCommitBtn" type="button" class="btn btn-success pull-right">提交</button>
				          </div>
					</form>
	
