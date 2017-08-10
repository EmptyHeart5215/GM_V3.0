<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//资源类型
	$("[name='codePerResources']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_PER_RESOURCES',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	submitForm('ziYuan',"${vdata.ziYuanUrl}");
	deleteForm('ziYuan',"${vdata.ziYuanDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="ziYuanForm">
<div class="form-group">
	<input type="hidden" id="ziYuanCode" value="${vdata.ziYuanPerson.code}" name="code">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>资源类型</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codePerResources" value="${vdata.ziYuanPerson.codePerResources }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >职称</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="titles" value="${vdata.ziYuanPerson.titles }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >参加社会组织名称</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="workcompany" value="${vdata.ziYuanPerson.workcompany }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >加入时间</label>
	<div class="col-xs-4">
		<div class="input-group">
			<input class="col-xs-12 col-sm-12 form-control date-picker"name="inDate" value="${vdata.ziYuanPerson.inDate }" type="text"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	</div>
<div class="form-group">
<label class="col-xs-2 control-label no-padding-right text-right" >资格证号</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="certificate" value="${vdata.ziYuanPerson.certificate }" class="col-xs-12 col-sm-12 tooltip-error" />
	</div>
	<label class="col-xs-2 control-label no-padding-right text-right" >职务</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="duty" value="${vdata.ziYuanPerson.duty }" class="col-xs-12 col-sm-12 tooltip-error" />
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
				           <button data-bb-handler="success" id="ziYuanCommitBtn" type="button" class="btn btn-success">提交</button>
				           <button data-bb-handler="close" id="ziYuanCloseBtn" type="button" class="btn btn-cancel">删除</button>
			           </div>
					</form>