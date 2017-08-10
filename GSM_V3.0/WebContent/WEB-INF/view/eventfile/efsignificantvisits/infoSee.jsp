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
					<h2><center>社区网格上访事件信息采集表</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.efsignificantvisits.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.efsignificantvisits.createDate }</td>
					  </tr>
					</table>
						<table class="print-table" >
							<tr><td class="col-xs-2">所属辖区</td><td colspan="3" class="print-normal col-xs-4">${vdata.efsignificantvisits.seatGrid.gridTotalName }</td></tr>
							<tr><td class="col-xs-2">编号</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.numbers}</td><td class="col-xs-2">主要上访人</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.visitsName}</td></tr>
							<tr><td class="col-xs-2">上访人户籍地</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.visitsRegister}</td><td class="col-xs-2">涉及人数</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.visitsPsersons}</td></tr>
							<tr><td class="col-xs-2">上访时间</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.visitsDate}</td><td class="col-xs-2">上访次数</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.visitsFrequency}</td></tr>
							<tr><td class="col-xs-2">上访地点</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.codeVisitsLocation}</td><td class="col-xs-2">是否非正常上访</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.codeNormalvisitYesno}</td></tr>
							<tr><td class="col-xs-2">上访性质</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.codeVisitsType}</td><td class="col-xs-2">上级交办情况</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.codeSuperiors}</td></tr>
							<tr><td class="col-xs-2">是否挂账督办</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.codeHandleYesno}</td><td class="col-xs-2">要求办结时间</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.requireHandleDate}</td></tr>
							<tr><td class="col-xs-2">问题类别</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.codeProblemType}</td><td class="col-xs-2">稳控责任人</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.stabilityName}</td></tr>
							<tr><td class="col-xs-2">问题处理责任部门</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.dutyDivision}</td><td class="col-xs-2">问题处理责任人</td><td class="print-normal col-xs-4">${vdata.efsignificantvisits.dutyName}</td></tr>
							<tr><td class="col-xs-2">稳控措施</td><td colspan="3" class="print-normal col-xs-10">${vdata.efsignificantvisits.stabilityMeasure}</td></tr>
							<tr><td class="col-xs-2">图片</td><td colspan="3"class="print-normal col-xs-10" style="height:auto">
							<img class="print-td-img" src="/sdsd/"><img class="print-td-img" src="/sdsd/">
							<img class="print-td-img" src="/sdsd/"></td></tr>
							<tr><td class="col-xs-2">上访反映问题</td><td colspan="3" class="print-normal col-xs-10">${vdata.efsignificantvisits.visitsManage}</td></tr>
							<tr><td class="col-xs-2">问题处理情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.efsignificantvisits.proceed}</td></tr>
							<tr><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4"></td><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4"></td></tr>
							<tr><td class="col-xs-2">备注</td><td colspan="3" class="print-normal col-xs-10">${vdata.efsignificantvisits.rmark}</td></tr>
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


