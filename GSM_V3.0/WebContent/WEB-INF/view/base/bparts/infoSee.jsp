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
					<h2><center>城市部件信息详情</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.bpart.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.bpart.createDate }</td>
					  </tr>
					</table>
						<table class="print-table" >
							<tr><td class="col-xs-2">所属辖区</td><td colspan="3" class="print-normal col-xs-4">${vdata.bpart.seatGrid.gridTotalName }</td></tr>
							<tr><td class="col-xs-2">部件名称</td><td class="print-normal col-xs-4">${vdata.bpart.name}</td><td class="col-xs-2">权属单位</td><td class="print-normal col-xs-4">${vdata.bpart.belong}</td></tr>
							<tr><td class="col-xs-2">部件地点</td><td class="print-normal col-xs-4">${vdata.bpart.address}</td><td class="col-xs-2">护养单位</td><td class="print-normal col-xs-4">${vdata.bpart.care}</td></tr>
							<tr><td class="col-xs-2">所属分类</td><td class="print-normal col-xs-4">${vdata.bpart.dicValueMap.codeSmallType}</td><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4">${vdata.bpart.gridContacts}</td></tr>
							<tr><td class="col-xs-2">管理单位</td><td class="print-normal col-xs-4">${vdata.bpart.enterpriseManage }</td><td class="col-xs-2">部件状态</td><td class="print-normal col-xs-4">${vdata.bpart.codePartsStatus}</td></tr>
							<tr height="350px;"><td class="col-xs-2">图片</td><td colspan="3"class="print-normal col-xs-10" style="height:auto">
<!-- 							<img class="print-td-img" src="/sdsd/"><img class="print-td-img" src="/sdsd/"> -->
							<c:if test="${vdata.bpart.picture != null || ''!=vdata.bpart.picture}">
							<c:forEach var="item" items="${vdata.sys}" varStatus="status">
								<c:if test="${item != null}">
								<img class="print-td-img" src="${base}/upload/<c:out value="${item}"/>">
								</c:if>
							</c:forEach>
							</c:if>
							</td></tr>
							<tr height="28px;">
					    		 <td class="col-xs-2" rowspan="2" ><b>描述</b></td>
					     		 <td colspan="3" rowspan="2" class="print-normal col-xs-10" style="word-break:break-all; word-wrap:break-word;" >${vdata.bpart.remark }</td>
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


