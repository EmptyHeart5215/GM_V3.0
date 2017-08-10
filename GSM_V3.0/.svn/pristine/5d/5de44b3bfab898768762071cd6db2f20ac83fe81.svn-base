<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//-----------------------------------------------留守-----------------------
	//健康状况
	$("[name='codeHealth']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HEALTH',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//留守人员类型
	$("[name='codeLiuShouType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_LIU_SHOU_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//与留守人员关系
	$("[name='codeLiuShouRelation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_OWNER_RELATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//家庭主要成员健康状况
	$("[name='codeMemberHealth']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HEALTH',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//留守人员
	submitForm('liuShou',"${vdata.liuShouUrl}");
	deleteForm('liuShou',"${vdata.liuShouDelUrl}");
	
});

</script>
<form class="form-horizontal" role="form" id="liuShouForm">
					<input type="hidden" id="liuShouCode" value="${vdata.liuShouPerson.code}" name="code">
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否人户一致</label>
							<div class="col-xs-4 " >
								<select name="isRenHuYiZhi" value="${vdata.liuShouPerson.isRenHuYiZhi }" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
									<option value="1" checked="checked">是</option>
									<option value="0">否</option>
								</select>
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" >健康状况</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"name="codeHealth" value="${vdata.liuShouPerson.codeHealth }" class="col-xs-12 col-sm-12 tooltip-error" />
							</div>
						</div>
						<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >个人年收入</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"id="geRenIncome" name="geRenIncome" value="${vdata.liuShouPerson.geRenIncome }" class="col-xs-12 col-sm-12 tooltip-error digital" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>留守人员类型</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"id="codeLiuShouType" name="codeLiuShouType" value="${vdata.liuShouPerson.codeLiuShouType }" class="col-xs-12 col-sm-12 tooltip-error required" />
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>家庭主要成员</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"id="zhuYaoMember" name="zhuYaoMember" value="${vdata.liuShouPerson.zhuYaoMember }" class="col-xs-12 col-sm-12 tooltip-error required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>与留守人员关系</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"name="codeLiuShouRelation" value="${vdata.liuShouPerson.codeLiuShouRelation }" class="col-xs-12 col-sm-12 tooltip-error required" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>家庭主要成员<br>身份证号</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"name="memberCid" value="${vdata.liuShouPerson.memberCid }" class="col-xs-12 col-sm-12 tooltip-error required personcid" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" >家庭主要成员<br>健康状况</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"name="codeMemberHealth" value="${vdata.liuShouPerson.codeMemberHealth }" class="col-xs-12 col-sm-12 tooltip-error" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>家庭主要成员<br>联系电话</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"name="memberPhone" value="${vdata.liuShouPerson.memberPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" >家庭年收入</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"name="homeIncome" value="${vdata.liuShouPerson.homeIncome }" class="col-xs-12 col-sm-12 tooltip-error digital" />
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" >家庭主要成员<br>工作详细地址</label>
							<div class="col-xs-10">
								<textarea max-length="100"name="memberWorkAddress" class="col-xs-12 col-sm-12 tooltip-error" >${vdata.liuShouPerson.memberWorkAddress } </textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" >困难及诉求</label>
							<div class="col-xs-10">
								<textarea name="kuNanRemark" max-length="5000" class="col-xs-12 col-sm-12 tooltip-error" >${vdata.liuShouPerson.kuNanRemark }</textarea>
							</div>
						</div>
						<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >帮扶情况</label>
						<div class="col-xs-10">
							<textarea name="bangFuRemark" max-length="5000" class="col-xs-12 col-sm-12 tooltip-error" >${vdata.liuShouPerson.bangFuRemark }</textarea>
						</div>
						</div>
						
						<div class="space-20"></div>
					
						<div class="control-group">
			                <label class="control-label">
			                </label>
			            </div>
			           <div style="position: absolute;bottom: 20px;right: 10px;">
				           <button data-bb-handler="success" id="liuShouCommitBtn" type="button" class="btn btn-success">提交</button>
				           <button data-bb-handler="close" id="liuShouCloseBtn" type="button" class="btn btn-cancel">删除</button>
			           </div>
					</form>