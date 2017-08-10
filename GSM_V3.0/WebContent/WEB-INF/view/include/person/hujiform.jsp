<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//与户主关系
	$("[name='codeOwnerRelation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_OWNER_RELATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});


	//提交户籍人口
	submitForm('huJi',"${vdata.huJiUrl}");
	deleteForm('huJi',"${vdata.huJiDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="huJiForm">
					<input type="hidden" id="huJiCode" value="${vdata.huJiPerson.code}" name="code">
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否人户一致</label>
							<div class="col-xs-4 " >
								<select name="isRenHuYiZhi" value="${vdata.huJiPerson.isRenHuYiZhi }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
									<option value="1" checked="checked">是</option>
									<option value="0">否</option>
								</select>
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>户口编号</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"id="huCode" name="huCode" value="${vdata.huJiPerson.huCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" >户主公民身份证号</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"id="huZhuCid" name="huZhuCid" value="${vdata.huJiPerson.huZhuCid }" class="col-xs-12 col-sm-12 tooltip-error personcid" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" >户主姓名</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"id="huZhuName" name="huZhuName" value="${vdata.huJiPerson.huZhuName }" class="col-xs-12 col-sm-12 tooltip-error " />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>与户主关系</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"id="codeOwnerRelation" name="codeOwnerRelation" value="${vdata.huJiPerson.codeOwnerRelation }" class="col-xs-12 col-sm-12 tooltip-error required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" >户主电话</label>
							<div class="col-xs-4">
								<input type="text" max-length="50" id="huZhuContact" name="huZhuContact" value="${vdata.huJiPerson.huZhuContact }" class="col-xs-12 col-sm-12 tooltip-error allPhone" />
							</div>
						</div>
						<div class="space-4"></div>
						<div class="control-group">
			                <label class="control-label">
			                </label>
			            </div>
			           <div style="position: absolute;bottom: 20px;right: 10px;">
				           <button data-bb-handler="success" id="huJiCommitBtn" type="button" class="btn btn-success">提交</button>
				           <button data-bb-handler="close" id="huJiCloseBtn" type="button" class="btn btn-cancel">删除</button>
			           </div>
					</form>
