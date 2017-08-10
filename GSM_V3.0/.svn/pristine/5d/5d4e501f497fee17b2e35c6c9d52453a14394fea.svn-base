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

</head>
<body>
<div class="row" id="row">
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
					<h2><center>${vdata.emergencyTeam.teamName}信息</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.emergencyTeam.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.emergencyTeam.createDate }</td>
					  </tr>
					</table>
						<table class="print-table" align="center">
							<tr><td class="col-xs-2">所属辖区或部门</td><td colspan="3" class="print-normal col-xs-4">${vdata.emergencyTeam.gridTotalName }</td></tr>
							<tr><td class="col-xs-2">队伍名称</td><td class="print-normal col-xs-4">${vdata.emergencyTeam.teamName}</td><td class="col-xs-2">队伍类型</td><td class="print-normal col-xs-4">${vdata.emergencyTeam.dicValueMap.codeTeamType}</td></tr>
							<tr><td class="col-xs-2">队伍负责人</td><td class="print-normal col-xs-4">${vdata.emergencyTeam.teamPrincipal}</td><td class="col-xs-2">负责人联系电话</td><td class="print-normal col-xs-4">${vdata.emergencyTeam.principalPhone}</td></tr>
							<tr><td class="col-xs-2">队伍成员</td><td colspan="3" class="print-normal col-xs-10">${vdata.emergencyTeam.teamMember}</td></tr>
							<tr><td class="col-xs-2">队伍描述</td><td colspan="3" class="print-normal col-xs-10">${vdata.emergencyTeam.teamMiaoShu}</td></tr>
						</table>
					</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


