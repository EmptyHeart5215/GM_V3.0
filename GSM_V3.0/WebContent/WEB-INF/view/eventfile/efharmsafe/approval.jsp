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
					<h2><center>社区网格矛盾纠纷信息采集表</center></h2>
					<h5>${vdata.efharmsafe.gridTotalName} 网格编码 ${vdata.efharmsafe.gridNum}</h5>
						<table class="print-table" >
							<tr><td class="col-xs-2">编号</td><td class="print-normal col-xs-4">${vdata.efharmsafe.numbers}</td><td class="col-xs-2">名称</td><td class="print-normal col-xs-4">${vdata.efharmsafe.eventName}</td></tr>
							<tr><td class="col-xs-2">类型</td><td class="print-normal col-xs-4">${vdata.efharmsafe.codeHarmType}</td><td class="col-xs-2">隐患排查时间</td><td class="print-normal col-xs-4">${vdata.efharmsafe.harmDate}</td></tr>
							<tr><td class="col-xs-2">事件发生时间</td><td class="print-normal col-xs-4">${vdata.efharmsafe.time}</td><td class="col-xs-2">地点或部位</td><td class="print-normal col-xs-4">${vdata.efharmsafe.place}</td></tr>
							<tr><td class="col-xs-2">所属单位</td><td class="print-normal col-xs-4">${vdata.efharmsafe.belongUnit}</td><td class="col-xs-2">负责人</td><td class="print-normal col-xs-4">${vdata.efharmsafe.unitName}</td></tr>
							<tr><td class="col-xs-2">负责人职务</td><td class="print-normal col-xs-4">${vdata.efharmsafe.unitJob}</td><td class="col-xs-2">负责人联系电话</td><td class="print-normal col-xs-4">${vdata.efharmsafe.unitPhone}</td></tr>
							<tr><td class="col-xs-2">隐患或事件详情</td><td colspan="3" class="print-normal col-xs-10">${vdata.efharmsafe.contents}</td></tr>
							<tr><td class="col-xs-2">安全责任人</td><td class="print-normal col-xs-4">${vdata.efharmsafe.safetyName}</td><td class="col-xs-2">安全责任人职务</td><td class="print-normal col-xs-4">${vdata.efharmsafe.safetyJob}</td></tr>
							<tr><td class="col-xs-2">安全责任人联系电话</td><td class="print-normal col-xs-4">${vdata.efharmsafe.safetyPhone}</td><td class="col-xs-2">隐患整改时限</td><td class="print-normal col-xs-4">${vdata.efharmsafe.harmRectDate}</td></tr>
							<tr><td class="col-xs-2">隐患整改措施</td><td colspan="3" class="print-normal col-xs-10">${vdata.efharmsafe.rectMeasure}</td></tr>
							<tr><td class="col-xs-2">隐患整改情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.efharmsafe.rectSituation}</td></tr>
							<tr><td class="col-xs-2">事件处置情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.efharmsafe.withSituation}</td></tr>
							<tr><td class="col-xs-2">图片</td><td colspan="3"class="print-normal col-xs-10" style="height:auto">
							<img class="print-td-img" src="/sdsd/"><img class="print-td-img" src="/sdsd/">
							<img class="print-td-img" src="/sdsd/"></td></tr>
							<tr><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4"></td><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4"></td></tr>
							<tr><td class="col-xs-2">备注</td><td colspan="3" class="print-normal col-xs-10">${vdata.efharmsafe.rmark}</td></tr>
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


