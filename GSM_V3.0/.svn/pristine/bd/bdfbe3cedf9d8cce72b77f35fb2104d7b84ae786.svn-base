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
					<h2><center>案发信息采集表</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.efinformation.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.efinformation.createDate }</td>
					  </tr>
					</table>
						<table class="print-table" >
						    <tr><td class="col-xs-2">所属辖区</td><td colspan="3" class="print-normal col-xs-4">${vdata.efinformation.seatGrid.gridTotalName }</td></tr>
							<tr><td class="col-xs-2">编号</td><td class="print-normal col-xs-4">${vdata.efinformation.numbers}</td><td class="col-xs-2">案件名称</td><td class="print-normal col-xs-4">${vdata.efinformation.eventName}</td></tr>
							<tr><td class="col-xs-2">案件编号</td><td class="print-normal col-xs-4">${vdata.efinformation.alarmNo}</td><td class="col-xs-2">案发时间</td><td class="print-normal col-xs-4">${vdata.efinformation.time}</td></tr>
							<tr><td class="col-xs-2">案发地点及部位</td><td class="print-normal col-xs-4">${vdata.efinformation.theSite}</td><td class="col-xs-2">涉案当事人</td><td class="print-normal col-xs-4">${vdata.efinformation.caseParty}</td></tr>
							<tr><td class="col-xs-2">当事人住址</td><td class="print-normal col-xs-4">${vdata.efinformation.partyAddress}</td><td class="col-xs-2">简要案情</td><td class="print-normal col-xs-4">${vdata.efinformation.briefCase}</td></tr>
							<tr><td class="col-xs-2">报警时间</td><td class="print-normal col-xs-4">${vdata.efinformation.policeTime}</td><td class="col-xs-2">出警人员</td><td class="print-normal col-xs-4">${vdata.efinformation.policePerson}</td></tr>
							<tr><td class="col-xs-2">图片</td><td colspan="3"class="print-normal col-xs-10" style="height:auto">
							<img class="print-td-img" src="/sdsd/"><img class="print-td-img" src="/sdsd/">
							<img class="print-td-img" src="/sdsd/"></td></tr>
							<tr><td class="col-xs-2">处置情况及结果</td><td colspan="3" class="print-normal col-xs-10">${vdata.efinformation.dealWith}</td></tr>
							<tr><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4"></td><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4"></td></tr>
							<tr><td class="col-xs-2">备注</td><td colspan="3" class="print-normal col-xs-10">${vdata.efinformation.rmark}</td></tr>
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


