<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//类别
	$("[name='codeSamc']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SAMC',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	submitForm('yongJun',"${vdata.yongJunUrl}");
	deleteForm('yongJun',"${vdata.yongJunDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="yongJunForm">
	<input type="hidden" id="yongJunCode" value="${vdata.yongJunPerson.code}" name="code">
<div class="form-group">			
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>类别</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeSamc" value="${vdata.yongJunPerson.codeSamc }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否置业</label>
	<div class="col-xs-4">
		<select value="${vdata.yongJunPerson.isHousePurchasing }" name="isHousePurchasing"class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >入伍时间</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker"name="enlistDate" value="${vdata.yongJunPerson.enlistDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >退伍时间</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker"name="veteransDate" value="${vdata.yongJunPerson.veteransDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >优抚证号码</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="specialPermitNum" value="${vdata.yongJunPerson.specialPermitNum }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >发证日期</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker"name="sendDate" value="${vdata.yongJunPerson.sendDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶人员</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuName" value="${vdata.yongJunPerson.bangFuName }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >帮扶人联系方式</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="bangFuPhone" value="${vdata.yongJunPerson.bangFuPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone" />
	</div>
</div>				
					
						<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
						<div class="col-xs-10">
							<textarea name="bangFuRemark" max-length="5000" class="col-xs-12 col-sm-12 tooltip-error" >${vdata.yongJunPerson.bangFuRemark }</textarea>
						</div>
						</div>
						
							<div class="space-30"></div>
					<div class="space-30"></div>
					<div class="space-30"></div>
					<div class="space-30"></div>
					<div class="space-30"></div>
					<div class="space-30"></div>
					
						<div class="control-group">
			                <label class="control-label">
			                </label>
			            </div>
			           <div style="position: absolute;bottom: 20px;right: 10px;">
				           <button data-bb-handler="success" id="yongJunCommitBtn" type="button" class="btn btn-success">提交</button>
				           <button data-bb-handler="close" id="yongJunCloseBtn" type="button" class="btn btn-cancel">删除</button>
			           </div>
					</form>