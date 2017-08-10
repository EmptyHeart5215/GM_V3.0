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
//现住地
	$("[name='nowAddressCode']").ztreeGrid({
		url:'${base}/sys/seatgird/queryRegionTree',
		name:"NAME",
		pIdKey:"PARENTCODE",
		reset:true,
		idKey:"CODE",
		resetId:'redo'
	});
</script>
</head>
<body>
<div class="row">
	<div class="col-xs-12" id="body">
		<div id="print">
			<h2><center>人口信息采集表</center></h2>
			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">人口基本信息</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">外文姓</td><td class="print-normal col-xs-4">${vdata.person.lastName}</td><td class="col-xs-2">外文名</td><td class="print-normal col-xs-4">${vdata.person.firstName}</td></tr>
					<tr><td class="col-xs-2">中文名</td><td class="print-normal col-xs-4">${vdata.person.name}</td><td class="col-xs-2">性别</td><td class="print-normal col-xs-4">${vdata.person.sex}</td></tr>
					<tr><td class="col-xs-2">出生日期</td><td class="print-normal col-xs-4">${vdata.person.birthday}</td><td class="col-xs-2">国籍</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeNationality}</td></tr>
					<tr><td class="col-xs-2">宗教信仰</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeReligious}</td><td class="col-xs-2">联系电话</td><td class="print-normal col-xs-4">${vdata.person.phone}</td></tr>
					<tr><td class="col-xs-2">证件类型</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeIdType}</td><td class="col-xs-2">证件号</td><td class="print-normal col-xs-4">${vdata.person.cid}</td></tr>
					<tr><td class="col-xs-2">证件有效期</td><td class="print-normal col-xs-4">${vdata.person.idEndDate}</td><td class="col-xs-2">来华目的</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeComeChinaReason}</td></tr>
					<tr><td class="col-xs-2">职业类别</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeJobType}</td><td class="col-xs-2">职业</td><td class="print-normal col-xs-4">${vdata.person.job}</td></tr>
					<tr><td class="col-xs-2">服务处所</td><td class="print-normal col-xs-4">${vdata.person.serverAddress}</td><td class="col-xs-2">是否重点关注人员</td><td class="print-normal col-xs-4"><c:choose> <c:when test="${vdata.person.isGuanZhu}">是</c:when> <c:otherwise>否</c:otherwise></c:choose></td></tr>
					<tr><td class="col-xs-2">现住地</td><td class="print-normal col-xs-4" >${vdata.person.nowAddressCode}</td><td class="col-xs-2">现住地门（楼）详址</td><td class="print-normal col-xs-4">${vdata.person.nowAddressDetail}</td></tr>
					<tr><td class="col-xs-2">抵达日期</td><td class="print-normal col-xs-4">${vdata.person.comeDate}</td><td class="col-xs-2">预计离开日期</td><td class="print-normal col-xs-4">${vdata.person.goDate}</td></tr>
					<tr><td class="col-xs-2">备注</td><td class="print-normal col-xs-4"  colspan="3" >${vdata.person.remark}</td>
				</table>
					
				
			</div>
			</div>
			</div>
		</div>		
		</div>
</div>
</body>