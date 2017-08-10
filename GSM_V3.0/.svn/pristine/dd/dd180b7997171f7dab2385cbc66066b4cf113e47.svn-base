<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script>
$(function(){
	//办证的类型
	$("[name='codeIdType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ID_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//流入原因
	$("[name='codeInflowReason']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_INFLOW_REASON',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//住所类型
	$("[name='codeZhuSuoType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ZHUSUO_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});

	//提交流动人口
	submitForm('liuDong',"${vdata.liuDongUrl}");
	deleteForm('liuDong',"${vdata.liuDongDelUrl}");
	//是否关注人群
	defaultSelect('isGuanZhu');
});

</script>
<form class="form-horizontal" role="form" id="liuDongForm">
					<input type="hidden" id="liuDongCode" value="${vdata.liuDongPerson.code}" name="code">
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>流入原因</label>
							<div class="col-xs-4 " >
								<input type="text" max-length="50"id="codeInflowReason" name="codeInflowReason" value="${vdata.liuDongPerson.codeInflowReason }" class="col-xs-12 col-sm-12 tooltip-error required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" >证件类型</label>
							<div class="col-xs-4">
								<input type="text" max-length="50"id="codeIdType" name="codeIdType" value="${vdata.liuDongPerson.codeIdType }" class="col-xs-12 col-sm-12 tooltip-error" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" >证件号</label>
							<div class="col-xs-10">
								<input type="text" max-length="50"id="cid" name="cid" value="${vdata.liuDongPerson.cid }" class="col-xs-12 col-sm-12 tooltip-error" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" >登记日期</label>
							<div class="col-xs-4">
								<div class="input-group">
									<input class="col-xs-12 col-sm-12 form-control date-picker"name="registDate" value="${vdata.liuDongPerson.registDate }" type="text"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" >证件到期日期</label>
							<div class="col-xs-4">
								<div class="input-group">
									<input class="col-xs-12 col-sm-12 form-control date-picker"name="endDate" value="${vdata.liuDongPerson.endDate }" type="text"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>住所类型</label>
							<div class="col-xs-4 " >
								<input type="text" max-length="50"id="codeZhuSuoType" name="codeZhuSuoType" value="${vdata.liuDongPerson.codeZhuSuoType }" class="col-xs-12 col-sm-12 tooltip-error required" />
							</div>
							<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否重点关注人员</label>
							<div class="col-xs-4 " >
								<select value="${vdata.liuDongPerson.isGuanZhu }" name="isGuanZhu"class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
									<option value="" >请选择</option>
									<option value="1" >是</option>
									<option value="0">否</option>
								</select>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="control-group">
			                <label class="control-label">
			                </label>
			            </div>
			           <div style="position: absolute;bottom: 20px;right: 10px;">
				           <button data-bb-handler="success" id="liuDongCommitBtn" type="button" class="btn btn-success">提交</button>
				           <button data-bb-handler="close" id="liuDongCloseBtn" type="button" class="btn btn-cancel">删除</button>
			           </div>
					</form>