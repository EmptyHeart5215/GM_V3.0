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
	
	var contradictPhoto="${vdata.efcontradict.contradictPhoto }";
	
	var data=data+"&codes="+contradictPhoto;
	
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
					<h2><center>社区网格矛盾纠纷信息采集表</center></h2>
					<h5>${vdata.efcontradict.gridTotalName} 网格编码 ${vdata.efcontradict.gridNum}</h5>
						<table class="print-table" >
							<tr><td class="col-xs-2">编号</td><td class="print-normal col-xs-4">${vdata.efcontradict.id}</td><td class="col-xs-2">矛盾纠纷类别</td><td class="print-normal col-xs-4">${vdata.efcontradict.codeEventType}</td></tr>
							<tr><td class="col-xs-2">是否重大矛盾纠纷</td><td class="print-normal col-xs-4">${vdata.efcontradict.contradictions}</td><td class="col-xs-2">纠纷当事人情况</td><td class="print-normal col-xs-4">${vdata.efcontradict.contradictionsParty}</td></tr>
							<tr><td class="col-xs-2">涉及人数</td><td class="print-normal col-xs-4">${vdata.efcontradict.contradictionsPersons}</td><td class="col-xs-2">主要问题</td><td class="print-normal col-xs-4">${vdata.efcontradict.contradictionsSituation}</td></tr>
							<tr><td class="col-xs-2">矛盾排查时间</td><td class="print-normal col-xs-4">${vdata.efcontradict.contradictionsDate}</td><td class="col-xs-2">收集人</td><td class="print-normal col-xs-4">${vdata.efcontradict.takeName}</td></tr>
							<tr><td class="col-xs-2">稳控责任人</td><td class="print-normal col-xs-4">${vdata.efcontradict.stabilityName}</td><td class="col-xs-2">采取措施</td><td class="print-normal col-xs-4">${vdata.efcontradict.stabilityMeasure}</td></tr>
							<tr><td class="col-xs-2">责任部门</td><td class="print-normal col-xs-4">${vdata.efcontradict.problemUnit}</td><td class="col-xs-2">责任人</td><td class="print-normal col-xs-4">${vdata.efcontradict.problemName}</td></tr>
							<tr><td class="col-xs-2">问题化解情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.efcontradict.problemResolution}</td></tr>
							<tr><td class="col-xs-2">完成时限</td><td class="print-normal col-xs-4">${vdata.efcontradict.resolveDate}</td><td class="col-xs-2">群众反馈意见</td><td class="print-normal col-xs-4">${vdata.efcontradict.feedBake}</td></tr>
							<tr><td class="col-xs-2">督办单位</td><td class="print-normal col-xs-4">${vdata.efcontradict.supervisionDuty }</td><td class="col-xs-2">督办人</td><td class="print-normal col-xs-4">${vdata.efcontradict.supervisionPerson}</td></tr>
							<tr><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4"></td><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4"></td></tr>
							<tr><td class="col-xs-2">图片</td><td id="img_show" colspan="3"class="print-normal col-xs-10" style="height:auto">
							</td></tr>
							<tr><td class="col-xs-2">备注</td><td colspan="3" class="print-normal col-xs-10">${vdata.efcontradict.mrmark}</td></tr>
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


