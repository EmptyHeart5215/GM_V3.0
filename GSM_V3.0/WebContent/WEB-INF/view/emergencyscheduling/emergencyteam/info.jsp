<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize();
			$.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	parent.successFun();
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			});
        }
	});
	//父窗口中的提交按钮
	$("#commitBtn",parent.document).bind("click",function(){
		$("#form").submit();
	});
	//队伍类型
	$("[name='codeTeamType']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_TEAM_TYPE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	$("[name=gridCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryOrgnizationTree?t=' + Math.random()	
	});
});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.EmergencyTeam.code }" />
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属辖区</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.EmergencyTeam.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="teamName"><span class="red">*</span>队伍名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="teamName" name="teamName" value="${vdata.EmergencyTeam.teamName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="teamPrincipal"><span class="red">*</span>队伍负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="teamPrincipal" name="teamPrincipal" value="${vdata.EmergencyTeam.teamPrincipal }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="principalPhone"><span class="red">*</span>负责人联系电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="principalPhone" name="principalPhone" value="${vdata.EmergencyTeam.principalPhone }" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeTeamType"><span class="red">*</span>队伍类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeTeamType" name="codeTeamType" value="${vdata.EmergencyTeam.codeTeamType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="teamMember"><span class="red">*</span>队伍成员</label>
					<div class="col-xs-10">
						<textarea id="teamMember" name="teamMember" class="col-xs-12 col-sm-12">${vdata.EmergencyTeam.teamMember }</textarea>
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="teamMember"><span class="red">*</span>队伍描述</label>
					<div class="col-xs-10">
						<textarea id="teamMiaoShu" name="teamMiaoShu" class="col-xs-12 col-sm-12">${vdata.EmergencyTeam.teamMiaoShu }</textarea>
					</div>
				</div>
				<div class="space-4"></div>
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
			</form>
		</div>
	</div>
</body>
</html>


