<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//资源类型
	$("[name='codeVolunteerType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_VOLUNTEER_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	submitForm('zhiYuan',"${vdata.zhiYuanUrl}");
	deleteForm('zhiYuan',"${vdata.zhiYuanDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="zhiYuanForm">
<input type="hidden" id="zhiYuanCode" value="${vdata.zhiYuanPerson.code}" name="code">
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>类别</label>
	<div class="col-xs-4">
		<input type="text" max-length="50"name="codeVolunteerType" value="${vdata.zhiYuanPerson.codeVolunteerType }" class="col-xs-12 col-sm-12 tooltip-error required" />
	</div>
</div>
<div class="form-group">
	<label class="col-xs-2 control-label no-padding-right text-right" >备注</label>
	<div class="col-xs-10">
		<textarea name="remark" max-length="4000" class="col-xs-12 col-sm-12 tooltip-error" >${vdata.zhiYuanPerson.remark }</textarea>
	</div>
</div>

						
						<div class="space-20"></div>
					
						<div class="control-group">
			                <label class="control-label">
			                </label>
			            </div>
			           <div style="position: absolute;bottom: 20px;right: 10px;">
				           <button data-bb-handler="success" id="zhiYuanCommitBtn" type="button" class="btn btn-success">提交</button>
				           <button data-bb-handler="close" id="zhiYuanCloseBtn" type="button" class="btn btn-cancel">删除</button>
			           </div>
					</form>