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
	
	var activitiesPhoto="${vdata.efactivities.activitiesPhoto}";
	
	var data=data+"&codes="+activitiesPhoto;
	
	$.ajax({
		type : "post",
		url : "${base}/sys/sysupload/queryByCodes?t="+Math.random(),
		data : data,
		dataType : 'json',
		async : false,
		success : function(data) {
			var imgscr="";
			 for(var i=0;i<data.length;i++){
				 imgscr="${base}/upload/"+data[i].path;
				 $("#img_show").append("<img class='print-td-img' src="+imgscr+">");
				
			 }
		}
	}); 
});
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
					<h2><center>社区网格大型活动采集表</center></h2>
					<h5>${vdata.efactivities.gridTotalName} 网格编码 ${vdata.efactivities.gridNum}</h5>
						<table class="print-table" >
							<tr><td class="col-xs-2">编号</td><td class="print-normal col-xs-4">${vdata.efactivities.id}</td><td class="col-xs-2">活动主题</td><td class="print-normal col-xs-4">${vdata.efactivities.titleName}</td></tr>
							<tr><td class="col-xs-2">活动负责人或召集人</td><td class="print-normal col-xs-4">${vdata.efactivities.responsibleName}</td><td class="col-xs-2">参加活动的人员范围</td><td class="print-normal col-xs-4">${vdata.efactivities.responsibleRange}</td></tr>
							<tr><td class="col-xs-2">活动地点</td><td class="print-normal col-xs-4">${vdata.efactivities.responsibleLocation}</td><td class="col-xs-2">活动开始时间</td><td class="print-normal col-xs-4">${vdata.efactivities.beginTime}</td></tr>
							<tr><td class="col-xs-2">组织方参加活动人数</td><td class="print-normal col-xs-4">${vdata.efactivities.orgPersons}</td><td class="col-xs-2">群众参与人数</td><td class="print-normal col-xs-4">${vdata.efactivities.massesPersons}</td></tr>
							<tr><td class="col-xs-2">活动开展情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.efactivities.responsibleSituation}</td></tr>
							<tr><td class="col-xs-2">活动结束时间</td><td colspan="3" class="print-normal col-xs-10">${vdata.efactivities.endTime}</td></tr>
							<tr><td class="col-xs-2">图片</td><td id="img_show" colspan="3"class="print-normal col-xs-10" style="height:auto">
							</td></tr>
							<tr><td class="col-xs-2">活动内容</td><td colspan="3" class="print-normal col-xs-10">${vdata.efactivities.contents}</td></tr>
							<tr><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4">${vdata.efactivities.managerName}</td><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4">${vdata.efactivities.managerPhone}</td></tr>
							<tr><td class="col-xs-2">备注</td><td colspan="3" class="print-normal col-xs-10">${vdata.efactivities.mrmark}</td></tr>
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


