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
					<h2><center>服务信息详情</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格：</td>
					     <td width="35%">${vdata.jigouserv.jiGou.gridTotalName }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.jigouserv.createDate }</td>
					  </tr>
					</table>
						<table class="print-table" >
							<tr><td class="col-xs-2">所属辖区</td><td class="print-normal col-xs-4">${vdata.jigouserv.jiGou.gridTotalName }</td>
							<td class="col-xs-2">机构队伍名称</td><td class="print-normal col-xs-4">${vdata.jigouserv.jiGou.jigouName}</td>
							</tr>
							<tr>
							<td class="col-xs-2">机构队伍负责人</td><td class="print-normal col-xs-4">${vdata.jigouserv.jiGou.jigouManager}</td>
							<td class="col-xs-2">机构队伍负责人电话</td><td class="print-normal col-xs-4">${vdata.jigouserv.jiGou.managerPhone}</td>
							</tr>
							
							<tr>
							<td class="col-xs-2">服务事件</td><td colspan="3" class="print-normal col-xs-4">${vdata.jigouserv.serviceEvent}</td>
							</tr>
							<tr>
							<td class="col-xs-2">服务对象</td><td class="print-normal col-xs-4">${vdata.jigouserv.serviceDuiXiang}</td>
							<td class="col-xs-2">服务对象类型</td><td class="print-normal col-xs-4">${vdata.jigouserv.dicValueMap.codeServiceType}</td>
							</tr>
							<tr>
							<td class="col-xs-2">服务时间</td><td class="print-normal col-xs-4">${vdata.jigouserv.serviceTime}</td>
							<td class="col-xs-2">服务人数</td><td class="print-normal col-xs-4">${vdata.jigouserv.serviceNum}</td>
							</tr>
							<tr><td class="col-xs-2">服务地点</td><td class="print-normal col-xs-4" colspan="3">${vdata.jigouserv.sevieceAddress}</td></tr>
							
							<tr><td class="col-xs-2">地图定位</td><td colspan="3" style="word-break:break-all; word-wrap:break-word;" class="print-normal col-xs-10">${vdata.jigouserv.position}</td></tr>
							<tr><td class="col-xs-2">具体服务信息</td><td class="print-normal col-xs-4" colspan="3">${vdata.jigouserv.serviceDescription}</td></tr>
							
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


