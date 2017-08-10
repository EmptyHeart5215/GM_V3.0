	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/gsm/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
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
			url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),	
			goToClick:function(e, treeId, treeNode){
				var datas=treeNode[this.idKey];
				if(treeNode[this.idKey].length<20){
					bootbox.alert('请选择网格！');
					return false;
				}else{
					//自动获取网格员及电话
					$.ajax({
						type : "post",
						url : "${base}/sys/user/userWangGeYuan?gridCode="+datas,
						dataType : 'json',
						async : false,
						success : function(data) {
							if(data != null){
						
								$("#gridName").val(data.realName); // 
								$("#gridPhone").val(data.phone); // 
							
							}						
						}
					});
					//
				return true;
				}
			}
		});
	 $("[name=codeHouseSource]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HOUSE_SOURCE',
			name:"dicValue",
			pIdKey:"parentCode"
		});
});
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
<!-- 			<h2 class="text-center">组织生活</h2> -->
			<input type="hidden" name="code" value="${vdata.comm.code }" />
			<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleName">所属辖区</label>
					<div class="col-xs-4">
							<input type="text"id="gridCode" name="gridCode" value="${vdata.comm.gridCode }" class="col-xs-12 col-sm-12" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>组织名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="name" name="name" value="${vdata.comm.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>				
				 </div>
				 <div class="form-group">
				 <label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="manager"><span class="red">*</span>负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="manager" name="manager" value="${vdata.comm.manager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeHouseSource">房屋来源</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeHouseSource" name="codeHouseSource" value="${vdata.comm.codeHouseSource }" class="col-xs-12 col-sm-12 " />
					</div>			
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="liveNum"><span class="red">*</span>居住人数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="liveNum" name="liveNum" value="${vdata.comm.liveNum }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>注册时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="registerDate" value="${vdata.comm.registerDate }"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
								
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
					   <div class="col-xs-4 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.comm.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					   </div>			
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>团组织负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="unionManager" name="groupManager" value="${vdata.comm.groupManager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons"><span class="red">*</span>团组织负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="groupManagerPhone" name="groupManagerPhone" value="${vdata.comm.groupManagerPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>团组织负责人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="groupManagerDuty" name="groupManagerDuty" value="${vdata.comm.groupManagerDuty }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">主管部门</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="directDepartment" name="directDepartment" value="${vdata.comm.directDepartment }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>网格联系人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridName" name="gridName" value="${vdata.comm.gridName }" placeholder="选择辖区后自动获取" readonly="readonly" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
<!-- 					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">网格联系人职务</label> -->
<!-- 					<div class="col-xs-4"> -->
<%-- 						<input type="text" max-length="50"id="gridDuty" name="gridDuty" value="${vdata.comm.gridDuty }" class="col-xs-12 col-sm-12 " /> --%>
<!-- 					</div> -->
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>网格联系人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridPhone" name="gridPhone" value="${vdata.comm.gridPhone }" placeholder="选择辖区后自动获取" readonly="readonly" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="cardNumber">证照编号</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="cardNumber" name="cardNumber" value="${vdata.comm.cardNumber }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">组织地址</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="address" name="address" value="${vdata.comm.address }" class="col-xs-12 col-sm-12 " />
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
