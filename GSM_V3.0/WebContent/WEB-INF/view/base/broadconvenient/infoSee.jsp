	
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
					<h2><center>护路护线信息采集表</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.BRoadConvenient.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.BRoadConvenient.createDate }</td>
					  </tr>
					</table>
					
					<table class="print-table" >
							<tr><td class="col-xs-2">所属部门或辖区</td><td class="print-normal col-xs-4" colspan="3">${vdata.BRoadConvenient.seatGrid.gridTotalName }</td>
							<tr><td class="col-xs-2">名称</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.name }</td><td class="col-xs-2">线路类型</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.dicValueMap.codeLineType }</td></tr>
							<tr><td class="col-xs-2">隶属单位名称</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.unitName }</td><td class="col-xs-2">隶属单位详址</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.unitAddress }</td></tr>
							<tr><td class="col-xs-2">隶属单位电话</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.unitPhone }</td><td class="col-xs-2">隶属单位负责人</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.unitManager }</td></tr>
							<tr><td class="col-xs-2">隶属单位负责人电话</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.unitManagerPhone }</td><td class="col-xs-2">管辖单位名称</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.controlUnitName }</td></tr>
							<tr><td class="col-xs-2">管辖单位详址</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.controlUnitAddress }</td><td class="col-xs-2">管辖单位电话</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.controlUnitPhone }</td></tr>
							<tr><td class="col-xs-2">分管治保负责人</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.chargeManager }</td><td class="col-xs-2">分管治保负责人电话</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.chargeManagerPhone }</td></tr>
							<tr><td class="col-xs-2">治安隐患情况</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.securityDanger }</td><td class="col-xs-2">治安隐患等级</td><td class="print-normal col-xs-4">${vdata.BRoadConvenient.dicValueMap.codeSecurityLevel }</td></tr>
							
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