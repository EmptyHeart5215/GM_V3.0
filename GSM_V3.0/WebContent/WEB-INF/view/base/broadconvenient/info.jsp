	
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
			url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
		});
	 $("[name=codeLineType]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_LINE_TYPE',
			name:"dicValue",
			pIdKey:"parentCode"
		});
	 $("[name=codeSecurityLevel]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SECURITY_LEVEL',
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
			<input type="hidden" name="code" value="${vdata.BRoadConvenient.code }" />
			<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="gridCode" name="gridCode" value="${vdata.BRoadConvenient.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="name"><span class="red">*</span>名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="name" name="name" value="${vdata.BRoadConvenient.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				 <div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeLineType"><span class="red">*</span>线路类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeLineType" name="codeLineType" value="${vdata.BRoadConvenient.codeLineType }" class="col-xs-12 col-sm-12 tooltip-error  required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="unitName"><span class="red">*</span>隶属单位名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="unitName" name="unitName" value="${vdata.BRoadConvenient.unitName }" class="col-xs-12 col-sm-12 tooltip-error  required" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="unitManager"><span class="red">*</span>隶属单位负责人</label>
					<div class="col-xs-4">
						<input type="text"id="unitManager" name="unitManager" value="${vdata.BRoadConvenient.unitManager }" class="col-xs-12 col-sm-12 tooltip-error  required" />
					</div>	
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>隶属单位电话</label>
					<div class="col-xs-4">
							<input type="text"id="unitPhone" name="unitPhone" value="${vdata.BRoadConvenient.unitPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="unitAddress">隶属单位详址</label>
					<div class="col-xs-10">
							<input type="text"id="unitAddress" name="unitAddress" value="${vdata.BRoadConvenient.unitAddress }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
						
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="unitManagerPhone">隶属单位负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="unitManagerPhone" name="unitManagerPhone" value="${vdata.BRoadConvenient.unitManagerPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="controlUnitName"><span class="red">*</span>管辖单位名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="controlUnitName" name="controlUnitName" value="${vdata.BRoadConvenient.controlUnitName }" class="col-xs-12 col-sm-12 tooltip-error  required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="controlUnitAddress">管辖单位详址</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="controlUnitAddress" name="controlUnitAddress" value="${vdata.BRoadConvenient.controlUnitAddress }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons">管辖单位电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="controlUnitPhone" name="controlUnitPhone" value="${vdata.BRoadConvenient.controlUnitPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="chargeManager"><span class="red">*</span>分管治保负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="chargeManager" name="chargeManager" value="${vdata.BRoadConvenient.chargeManager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="chargeManagerPhone">分管治保负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="chargeManagerPhone" name="chargeManagerPhone" value="${vdata.BRoadConvenient.chargeManagerPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="securityDanger"><span class="red">*</span>治安隐患情况</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="securityDanger" name="securityDanger" value="${vdata.BRoadConvenient.securityDanger }" class="col-xs-12 col-sm-12 tooltip-error  required" />
					</div>
				</div>
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeSecurityLevel">治安隐患等级</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeSecurityLevel" name="codeSecurityLevel" value="${vdata.BRoadConvenient.codeSecurityLevel }" class="col-xs-12 col-sm-12 " />
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
