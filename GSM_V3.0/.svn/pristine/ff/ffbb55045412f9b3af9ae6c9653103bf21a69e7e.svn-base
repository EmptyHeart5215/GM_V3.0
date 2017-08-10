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
	$("[name=gridCode]").ztreeGrid({
		 url:'${base}/sys/seatgird/queryAllGridTree?t=' + Math.random()			
	});
		 $("#roleCode").ztreeGrid({
			 url:'${base}/sys/role/queryAllRoleTreeForSelect?t=' + Math.random()
		});
		
		 $("#departmentCode").ztreeGrid({
			 url:'${base}/sys/seatgird/queryAllOrgTreeForSelect?t=' + Math.random()
		});
	
	});	
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.user.code}" />
			    <div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="loginName"><span class="red">*</span>登录名称</label>
			
					<div class="col-xs-4">
						<input type="text" id="loginName" name="loginName" value="${vdata.user.loginName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="realName"><span class="red">*</span>真实姓名</label>
			
					<div class="col-xs-4">
						<input type="text"id="realName" name="realName" value="${vdata.user.realName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="phone">手机号码</label>
			
					<div class="col-xs-4">
						<input type="text" id="phone" name="phone" value="${vdata.user.phone }" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-4">
						 <input id="gridCode" name="gridCode" value="${vdata.user.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
						
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="roleCode"><span class="red">*</span>角色</label>
			
					<div class="col-xs-4">
					 <input  id="roleCode" name="roleCode" value="${vdata.user.roleCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="departmentCode">部门</label>
			
					<div class="col-xs-4">
						 <input id="departmentCode" name="departmentCode" value="${vdata.user.departmentCode }" class="col-xs-12 col-sm-12" /> 
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="messageId"><span class="red">*</span>短信账号</label>
			
					<div class="col-xs-4">
						<input type="text" id="messageId" name="messageId" value="${vdata.user.messageId }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="messagePwd"><span class="red">*</span>短信密码</label>
			
					<div class="col-xs-4">
						<input type="password"id="messagePwd" name="messagePwd" value="${vdata.user.messagePwd }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
			</form>
		</div>
</div>
</body>
</html>

