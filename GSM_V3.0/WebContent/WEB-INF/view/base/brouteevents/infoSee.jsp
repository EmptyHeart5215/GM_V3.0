	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看资料内容</title>
<link rel="stylesheet"  href="${base}/resource/css/timeline.css" />
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<style type="text/css">
  #tbcontent tr:{
     height: 28px;
  }
</style>
</head>
<body>
<div class="row">
   <div class="col-xs-12" id="body">
     <div class="tabbable tabs-left">
       <div class="tab-content" >
            <div id="detailDiv" class="tab-pane in active">
               <div class="col-xs-12" style='text-align:right;'>
					<div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
				         <span class="ui-icon icon-print pull-right"></span>
		            </div>
	            </div>
	            <div id="print">
					<h2><center>线、路案件信息采集表</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.BRouteEvents.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.BRouteEvents.createDate }</td>
					  </tr>
					</table>
					<table class="print-table" >
							<tr><td class="col-xs-2">所属部门或辖区</td><td class="print-normal col-xs-4" colspan="3">${vdata.BRouteEvents.seatGrid.gridTotalName }</td>
							<tr><td class="col-xs-2">案（事）件编号</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.eventNumber }</td><td class="col-xs-2">案（事）件名称</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.eventName }</td></tr>
							<tr><td class="col-xs-2">发生日期</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.happenDate }</td><td class="col-xs-2">发生地点</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.happenAddress }</td></tr>
							<tr><td class="col-xs-2">案（事）件性质</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.dicValueMap.codeEventNature }</td><td class="col-xs-2">案（事）件情况</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.eventCondition }</td></tr>
							<tr><td class="col-xs-2">主犯/嫌疑人证件代码</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.principalNumber }</td><td class="col-xs-2">主犯/嫌疑人证件号码</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.principalCid }</td></tr>
							<tr><td class="col-xs-2">主犯/嫌疑人姓名</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.principalName }</td><td class="col-xs-2">是否破案</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.isSolveCrimes }</td></tr>
							<tr><td class="col-xs-2">作案人数</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.crimeNumber }</td><td class="col-xs-2">在逃人数</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.runNumber }</td></tr>
							<tr><td class="col-xs-2">抓捕人数</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.captureNumber }</td><td class="col-xs-2">案件侦破情况</td><td class="print-normal col-xs-4">${vdata.BRouteEvents.eventDetectCondition }</td></tr>
							
						</table>

				</div>
		    </div>
		    <div>
<%-- 		      ${vdata.zongzhiMaterial.materialContent} --%>
		    </div>
       </div>
     </div>
   </div>
</div><!-- row -->
</body>
</html>