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
					<h2><center>机构队伍信息详情</center></h2>
					
				<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">机构队伍信息详情</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<%-- 	<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.jigou.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.jigou.createDate }</td>
					  </tr>
					</table> --%>					
						<table class="print-table" >
							<tr><td class="col-xs-2">所属辖区</td><td colspan="3" class="print-normal col-xs-4">${vdata.jigou.seatGrid.gridTotalName }</td></tr>
							<tr><td class="col-xs-2">机构队伍名称</td><td class="print-normal col-xs-4">${vdata.jigou.jigouName}</td><td class="col-xs-2">机构队伍负责人电话</td><td class="print-normal col-xs-4">${vdata.jigou.managerPhone}</td></tr>
							<tr><td class="col-xs-2">机构队伍负责人</td><td class="print-normal col-xs-4">${vdata.jigou.jigouManager}</td><td class="col-xs-2">队伍类型</td><td class="print-normal col-xs-4">${vdata.jigou.dicValueMap.codeJigouFunction}</td></tr>
							<tr><td class="col-xs-2">机构负责人性别</td><td class="print-normal col-xs-4">${vdata.jigou.jigouManagerSex}</td><td class="col-xs-2">成立时间</td><td class="print-normal col-xs-4">${vdata.jigou.beginTime}</td></tr>
							<tr><td class="col-xs-2">团队职务</td><td class="print-normal col-xs-4">${vdata.jigou.managerPost}</td><td class="col-xs-2">队伍状态</td><td class="print-normal col-xs-4">${vdata.jigou.dicValueMap.codeJigouState}</td></tr>
							<tr><td class="col-xs-2">机构地址</td><td colspan="3" class="print-normal col-xs-4">${vdata.jigou.address }</td></tr>
							<tr><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4">${vdata.jigou.gridContacts}</td><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4">${vdata.jigou.gridContactsPhone}</td></tr>
							<tr><td class="col-xs-2">地图定位</td><td colspan="3" style="word-break:break-all; word-wrap:break-word;" class="print-normal col-xs-10">${vdata.jigou.position}</td></tr>
							<tr><td class="col-xs-2">队伍描述</td><td colspan="3" style="word-break:break-all; word-wrap:break-word;" class="print-normal col-xs-10">${vdata.jigou.serviceDescriptione}</td></tr>					
						</table>
			</div>
			</div>
			</div>
				<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">机构队伍成员详情</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
<%-- 					<h2><center>机构队伍成员详情</center></h2> --%>
					    <table class="print-table">
					    	<tr>
					    		<td class="col-xs-1">姓名</td>
					    		<td class="col-xs-1">性别</td>
					    		<td class="col-xs-1">电话</td>
					    		<td class="col-xs-5">现住址</td>	
					    	</tr>
					    	<c:forEach items="${vdata.list}" varStatus="k" var="e1">
					    	<tr>
					    		<td class="print-normal col-xs-1">${e1.name}</td>
					    		<td class="print-normal col-xs-1">${e1.sex}</td>
					    		<td class="print-normal col-xs-1">${e1.phone}</td>
					    		<td class="print-normal col-xs-5">${e1.address}</td>
					    	</tr>
					    	</c:forEach>					    	
    					</table>
    		</div>
			</div>
			</div>
				<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">服务的历史记录</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
<%--     					<h2><center>服务的历史记录</center></h2> --%>
					    <table class="print-table">
					    	<tr>
					    		<td style="width: 20%;">服务事件</td>
					    		<td style="width: 15%;">服务对象</td>
					    		<td style="width: 9%;">服务时间</td>
					    		<td style="width: 9%;">服务人数</td>
					    		<td style="width: 20%;">服务地点</td>
					    		<td style="width: 27%;">具体服务信息</td>	
					    	</tr>
					    	<c:forEach items="${vdata.lists}" varStatus="k" var="e2">
					    	<tr>
					    		<td class="print-normal" style="padding: 0px 12px;">${e2.serviceEvent}</td>
					    		<td class="print-normal "style="padding: 0px 12px;">${e2.serviceDuiXiang}</td>
					    		<td class="print-normal"style="padding: 0px 12px;">${e2.serviceTime}</td>
					    		<td class="print-normal"style="padding: 0px 12px;">${e2.serviceNum}</td>
					    		<td class="print-normal"style="padding: 0px 12px;">${e2.sevieceAddress}</td>
					    		<td class="print-normal"style="padding: 0px 12px;">${e2.serviceDescription}</td>
					    	</tr>
					    	</c:forEach>
    					</table>
    					
    		</div>
			</div>
			</div>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


