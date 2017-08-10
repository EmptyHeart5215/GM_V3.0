<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<link rel="stylesheet"  href="${base}/resource/css/timeline.css" />
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">
$(function(){
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
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
		            	parent.successFun("unit");
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
});
function  print(printid){
    $("#"+printid).jqprint({debug:true});
}
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
		<div class="tabbable tabs-left">
			

			<div class="tab-content" >
			<!-- 基本信息 --> 
				<div id="detailDiv" class="tab-pane in active">
				<div class="col-xs-12" style='text-align:right;'>
				<div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
			         <span class="ui-icon icon-print pull-right"></span>
	            </div>
	            </div>
					<div id="print">
					<h2><center>信息详情</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.fields.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.fields.createDate }</td>
					  </tr>
					</table>
						<table class="print-table" >
							<tr><td class="col-xs-2">所属部门或辖区</td><td class="print-normal col-xs-4" colspan="3">${vdata.fields.seatGrid.gridTotalName }</td>
							<tr><td class="col-xs-2">名称</td><td class="print-normal col-xs-4">${vdata.fields.name}</td><td class="col-xs-2">所属分类</td><td class="print-normal col-xs-4">${vdata.fields.dicValueMap.codeBelongType}</td></tr>
							<tr><td class="col-xs-2">编号</td><td class="print-normal col-xs-4">${vdata.fields.fieldsCode}</td><td class="col-xs-2">地址</td><td class="print-normal col-xs-4">${vdata.fields.address}</td></tr>
							<tr><td class="col-xs-2">面积</td><td class="print-normal col-xs-4">${vdata.fields.area}</td><td class="col-xs-2">范围界限</td><td class="print-normal col-xs-4">${vdata.fields.range}</td></tr>
							<tr><td class="col-xs-2">主管或所属单位</td><td class="print-normal col-xs-4">${vdata.fields.belong}</td><td class="col-xs-2">单位负责人姓名</td><td class="print-normal col-xs-4">${vdata.fields.belongMan}</td></tr>
							<tr><td class="col-xs-2">管理责任人姓名</td><td class="print-normal col-xs-4">${vdata.fields.manageMan}</td><td class="col-xs-2">管理责任人职务</td><td class="print-normal col-xs-4">${vdata.fields.manageDuty}</td></tr>
							<tr><td class="col-xs-2">管理责任人电话</td><td class="print-normal col-xs-4">${vdata.fields.managePhone}</td><td class="col-xs-2">管理人员人数</td><td class="print-normal col-xs-4">${vdata.fields.manageManNum}</td></tr>
							<tr><td class="col-xs-2">其他附属设施</td><td class="print-normal col-xs-4">${vdata.fields.otherBelong}</td><td class="col-xs-2">网格联系人 </td><td class="print-normal col-xs-4">${vdata.fields.gridName}</td></tr>
							<tr><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4">${vdata.fields.gridPhone}</td><td class="col-xs-2">网格联系人职务</td><td class="print-normal col-xs-4">${vdata.fields.gridDuty}</td></tr>
							<tr><td class="col-xs-2">地图定位</td><td colspan="3" class="print-normal col-xs-4" style="word-break:break-all; word-wrap:break-word;">${vdata.fields.position }</td>
							<tr height="350px;"><td class="col-xs-2">图片</td><td colspan="3"class="print-normal col-xs-10" style="height:auto">
<!-- 							<img class="print-td-img" src="/sdsd/"><img class="print-td-img" src="/sdsd/"> -->
<%-- 							<c:if test="${vdata.bpart.picture != null || ''!=vdata.bpart.picture}"> --%>
<%-- 							<c:forEach var="item" items="${vdata.sys}" varStatus="status"> --%>
<%-- 								<c:if test="${item != null}"> --%>
<%-- 								<img class="print-td-img" src="${base}/upload/<c:out value="${item}"/>"> --%>
<%-- 								</c:if> --%>
<%-- 							</c:forEach> --%>
<%-- 							</c:if> --%>
							</td></tr>
							<tr height="28px;">
					    		 <td class="col-xs-2" rowspan="2" ><b>备注</b></td>
					     		 <td colspan="3" rowspan="2" class="print-normal col-xs-10" style="word-break:break-all; word-wrap:break-word;" >${vdata.fields.description }</td>
					   		</tr>
					   		<tr height="28px;">
					   		</tr>
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


