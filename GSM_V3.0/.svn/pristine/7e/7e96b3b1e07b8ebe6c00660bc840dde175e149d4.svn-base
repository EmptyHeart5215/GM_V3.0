<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//就业状况
	$("[name='codeJiuYeType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JIU_YE_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});


	//提交户籍人口
	submitForm('laoDong',"${vdata.laoDongUrl}");
	deleteForm('laoDong',"${vdata.laoDongDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="laoDongForm">
					<input type="hidden" id="laoDongCode" value="${vdata.laoDongPerson.code}" name="code">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >最高学历院校</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="xueXiao" value="${vdata.laoDongPerson.xueXiao }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >专业</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="zhuanYe" value="${vdata.laoDongPerson.zhuanYe }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >毕业时间</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker"name="biYeDate" value="${vdata.laoDongPerson.biYeDate }" type="text"/>
			<span class="input-group-addon">
			<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >毕业证号</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="biYeCode" value="${vdata.laoDongPerson.biYeCode }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >是否有资格证</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isZiGe }" name="isZiGe" class="form-control myselect col-xs-12 col-sm-12 tooltip-error ">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >资格证书类型</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="ziGeZhengType" value="${vdata.laoDongPerson.ziGeZhengType }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否持有就业失业登记证</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isHasJiuYeZheng }" name="isHasJiuYeZheng" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >就业失业登记证编号</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="jiuYeCode" value="${vdata.laoDongPerson.jiuYeCode }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >就业失业登记证发证地</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="faZhengDi" value="${vdata.laoDongPerson.faZhengDi }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >发证时间</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker"name="faZhengDate" value="${vdata.laoDongPerson.faZhengDate }" type="text"/>
			<span class="input-group-addon">
			<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >就业状况类型</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeJiuYeType" value="${vdata.laoDongPerson.codeJiuYeType }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >是否签订劳动合同</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isHeTong }" name="isHeTong" class="form-control myselect col-xs-12 col-sm-12 tooltip-error ">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>
</div>
<div class="form-group">
	
	<label class="col-xs-2 control-label no-padding-right text-right" >是否有养老保险</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isYangLao }" name="isYangLao" class="form-control myselect col-xs-12 col-sm-12 tooltip-error ">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>

	<label class="col-xs-2 control-label no-padding-right text-right" >是否有失业保险</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isShiYeBaoXian }" name="isShiYeBaoXian" class="form-control myselect col-xs-12 col-sm-12 tooltip-error ">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>
	</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >是否有医疗保险</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isYiLiao }" name="isYiLiao" class="form-control myselect col-xs-12 col-sm-12 tooltip-error ">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>

	<label class="col-xs-2 control-label no-padding-right text-right" >是否有工伤保险</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isGongShang }" name="isGongShang" class="form-control myselect col-xs-12 col-sm-12 tooltip-error ">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>
	</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >是否有生育保险</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isShengYu }" name="isShengYu" class="form-control myselect col-xs-12 col-sm-12 tooltip-error ">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >是否有住房公积金</label>
	<div class="col-xs-4">
		<select value="${vdata.laoDongPerson.isGongJiJin }" name="isGongJiJin" class="form-control myselect col-xs-12 col-sm-12 tooltip-error ">
			<option value="" >请选择</option>
			<option value="1" >是</option>
			<option value="0">否</option>
		</select>
	</div>
	</div>
								<div class="space-30"></div>
					<div class="space-30"></div>
					<div class="space-30"></div>
					
						<div class="control-group">
			                <label class="control-label">
			                </label>
			            </div>
			           <div style="position: absolute;bottom: 20px;right: 10px;">
				           <button data-bb-handler="success" id="laoDongCommitBtn" type="button" class="btn btn-success">提交</button>
				           <button data-bb-handler="close" id="laoDongCloseBtn" type="button" class="btn btn-cancel">删除</button>
			           </div>
					</form>
