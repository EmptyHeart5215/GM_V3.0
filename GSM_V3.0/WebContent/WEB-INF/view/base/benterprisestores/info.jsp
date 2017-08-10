	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/gsm/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
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
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
	});
	$("[name=codeHouseSource]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HOUSE_SOURCE',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	$(".date-picker-year").
	datepicker({
	language: 'zh-CN',
	format: 'yyyy',
	autoclose: true,
	todayBtn: false,
	minViewMode:'years'
	});
	
	if('${vdata.benter.idSecurity }' == '有'){
		 $("#idSecurity option[value='有']").attr("selected", "selected"); 
	 }else if('${vdata.benter.idSecurity }' == '无'){
		 $("#idSecurity option[value='无']").attr("selected", "selected"); 
	 }else if('${vdata.benter.idSecurity }' == 0){
		 $("#idSecurity option[value='0']").attr("selected", "selected"); 
	 }
	
	if('${vdata.benter.isManagement }' == '有'){
		 $("#isManagement option[value='有']").attr("selected", "selected"); 
	 }else if('${vdata.benter.isManagement }' == '无'){
		 $("#isManagement option[value='无']").attr("selected", "selected"); 
	 }else if('${vdata.benter.isManagement }' == 0){
		 $("#isManagement option[value='0']").attr("selected", "selected"); 
	 }
	
	if('${vdata.benter.isParty }' == '有'){
		 $("#isParty option[value='有']").attr("selected", "selected"); 
	 }else if('${vdata.benter.isParty }' == '无'){
		 $("#isParty option[value='无']").attr("selected", "selected"); 
	 }else if('${vdata.benter.isParty }' == 0){
		 $("#isParty option[value='0']").attr("selected", "selected"); 
	 }
	
	if('${vdata.benter.isUnion }' == '有'){
		 $("#isUnion option[value='有']").attr("selected", "selected"); 
	 }else if('${vdata.benter.isUnion }' == '无'){
		 $("#isUnion option[value='无']").attr("selected", "selected"); 
	 }else if('${vdata.benter.isUnion }' == 0){
		 $("#isUnion option[value='0']").attr("selected", "selected"); 
	 }
});

var showBuildName=function showBuildName(del){  

	if(!del){
		alert($("#buildName_div"));
		$("#buildName_div").remove();
	}
	
	$("[name=buildName]").prev().remove();
	$("[name=buildName]").ztreeGrid({
		url:'${base}/base/building/queryNameTreeBy?gridCode='+ document.getElementById('gridCode').value+"&t="+new Date() , 
		name:"buildName"
	});
	//$($("[name=buildName]").prev().children()[0]).trigger("click");
	$($("[name=buildName]").prev().children()[0]).bind("click",showBuildName);
} 
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
<!-- 			<h2 class="text-center">组织生活</h2> -->
			<input type="hidden" name="code" value="${vdata.benter.code }" />
			<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属辖区</label>
					<div class="col-xs-4">
						<input type="text" id="gridCode" name="gridCode" value="${vdata.benter.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>单位门店名称</label>
					<div class="col-xs-4">
						<input type="text" id="name" name="name" value="${vdata.benter.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<%-- <label  class="col-xs-2 control-label no-padding-right text-right" >楼栋</label>
					<div class="col-xs-4">
					<div id="buildNameShow" class="input-group">
						<input placeholder="--请选择--" readonly="readonly" onclick="showBuildName('true')"class="form-control position-picker col-xs-12 col-sm-12"  type="text">
						<span class="input-group-addon"> <i class="icon-list bigger-110"></i></span>
					</div>
						<input type="text" id="buildName"style="height: 0px; border: medium none; padding: 0px; box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.075) inset; color: rgb(255, 255, 255);" name="buildName" value="${vdata.benter.buildName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div> --%>
				 </div>
				 <%-- <div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >单元</label>
					<div class="col-xs-4">
						<input type="text" id="unitName" name="unitName" value="${vdata.benter.unitName }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >房间</label>
					<div class="col-xs-4">
						<input type="text" id="houseNum" name="houseNum" value="${vdata.benter.houseNum }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div> --%>
			
			<div class="form-group">
					
					<label  class="col-xs-2 control-label no-padding-right text-right" >地址</label>
					<div class="col-xs-10">
						<input type="text" id="address" name="address" value="${vdata.benter.address }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				 </div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >经营范围</label>
					<div class="col-xs-4">
						<input type="text" id="authority" name="authority" value="${vdata.benter.authority }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >业务主管部门</label>
					<div class="col-xs-4">
						<input type="text" id="businessSector" name="businessSector" value="${vdata.benter.businessSector }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				 </div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >部门</label>
					<div class="col-xs-4">
						<input type="text" id="departmentCode" name="departmentCode" value="${vdata.benter.departmentCode }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >证件编号</label>
					<div class="col-xs-4">
						<input type="text" id="documentNum" name="documentNum" value="${vdata.benter.documentNum }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >房屋来源</label>
					<div class="col-xs-4">
						<input type="text" id="codeHouseSource" name="codeHouseSource" value="${vdata.benter.codeHouseSource }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >有无安保设施</label>
					<div class="col-xs-4">
						 <select  id="idSecurity" name = "idSecurity"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="有">有</option>
                           <option  value="无">无</option>
                        </select>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >有无团组织</label>
					<div class="col-xs-4">
						 <select  id="isManagement" name = "isManagement"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="有">有</option>
                           <option  value="无">无</option>
                        </select>
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >有无党组织</label>
					<div class="col-xs-4">
						 <select  id="isParty" name = "isParty"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="有">有</option>
                           <option  value="无">无</option>
                        </select>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >有无综治组织</label>
					<div class="col-xs-4">
						 <select  id="isUnion" name = "isUnion"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="有">有</option>
                           <option  value="无">无</option>
                        </select>
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >修改人</label>
					<div class="col-xs-4">
						<input type="text" id="lastModifiedBy" name="lastModifiedBy" value="${vdata.benter.lastModifiedBy }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >法人代表</label>
					<div class="col-xs-4">
						<input type="text" id="legalCode" name="legalCode" value="${vdata.benter.legalCode }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >法人代表电话</label>
					<div class="col-xs-4">
						<input type="text" id="legalPhone" name="legalPhone" value="${vdata.benter.legalPhone }" class="col-xs-12 col-sm-12 allPhone tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >团组织编号</label>
					<div class="col-xs-4">
						<input type="text" id="managementCode" name="managementCode" value="${vdata.benter.managementCode }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >团组织负责人</label>
					<div class="col-xs-4">
						<input type="text" id="managementDuty" name="managementDuty" value="${vdata.benter.managementDuty }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >公会编号</label>
					<div class="col-xs-4">
						<input type="text" id="organationCode" name="organationCode" value="${vdata.benter.organationCode }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >工会织负责人</label>
					<div class="col-xs-4">
						<input type="text" id="organationDuty" name="organationDuty" value="${vdata.benter.organationDuty }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >在职人数</label>
					<div class="col-xs-4">
						<input type="text" id="peopleWorkNum" name="peopleWorkNum" value="${vdata.benter.peopleWorkNum }" class="col-xs-12 col-sm-12 tooltip-error digits" />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >登记注册时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error " name="registerDate" value="${vdata.benter.registerDate }"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >类型</label>
					<div class="col-xs-4">
						<input type="text" id="type" name="type" value="${vdata.benter.type }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >综治组织编号</label>
					<div class="col-xs-4">
						<input type="text" id="unionCode" name="unionCode" value="${vdata.benter.unionCode }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >综治负责人</label>
					<div class="col-xs-4">
						<input type="text" id="unionDuty" name="unionDuty" value="${vdata.benter.unionDuty }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >开始使用年份</label>
					<div class="col-xs-4 input-group">
						<input style="height: auto !important;" max-height="4"class="form-control date-picker-year tooltip-error digits" value="${vdata.benter.useStartDate }" name="useStartDate" type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >网格联系人</label>
						<div class="col-xs-10">
						<input type="text" id="gridName" name="gridName" value="${vdata.benter.gridName }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >网格联系人职务</label>
					<div class="col-xs-4">
						<input type="text" id="gridDuty" name="gridDuty" value="${vdata.benter.gridDuty }" class="col-xs-12 col-sm-12 " />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" >网格联系人电话</label>
					<div class="col-xs-4">
						<input type="text" id="gridPhone" name="gridPhone" value="${vdata.benter.gridPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone " />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>地图定位</label>
					<div class="col-xs-10 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.benter.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
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
