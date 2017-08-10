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
					
						<table class="print-table" >
							<tr><td class="col-xs-2">机构名称</td><td class="print-normal col-xs-4">${vdata.jigouserv.jigouName}</td><td class="col-xs-2">服务对象姓名</td><td class="print-normal col-xs-4">${vdata.jigouserv.personName}</td></tr>
							<tr><td class="col-xs-2">机构负责人</td><td class="print-normal col-xs-4">${vdata.jigouserv.jigouManager}</td><td class="col-xs-2">服务对象身份证号</td><td class="print-normal col-xs-4">${vdata.jigouserv.personCid}</td></tr>
							<tr><td class="col-xs-2">机构负责人手机号</td><td class="print-normal col-xs-4">${vdata.jigouserv.managerPhone}</td><td class="col-xs-2">服务对象手机号</td><td class="print-normal col-xs-4">${vdata.jigouserv.personPhone}</td></tr>
							<tr><td class="col-xs-2">服务时间</td><td class="print-normal col-xs-4">${vdata.jigouserv.serviceTime}</td><td class="col-xs-2">服务对象地址</td><td class="print-normal col-xs-4">${vdata.jigouserv.personAddress}</td></tr>
							<tr><td class="col-xs-2">图片</td><td colspan="3"class="print-normal col-xs-10" style="height:auto">
							<img class="print-td-img" src="/sdsd/"><img class="print-td-img" src="/sdsd/">
							<img class="print-td-img" src="/sdsd/"></td></tr>
							<tr><td class="col-xs-2">具体服务信息</td><td colspan="3" class="print-normal col-xs-10">${vdata.jigouserv.serviceDescription}</td></tr>
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


