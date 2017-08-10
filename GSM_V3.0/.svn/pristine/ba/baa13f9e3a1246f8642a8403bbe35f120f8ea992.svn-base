	
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
					<h2><center>社会组织信息采集表</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.comm.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.comm.createDate }</td>
					  </tr>
					</table>
					<table class="print-table" >
							<tr><td class="col-xs-2">所属部门或辖区</td><td class="print-normal col-xs-4" colspan="3">${vdata.comm.seatGrid.gridTotalName }</td>
							<tr><td class="col-xs-2">组织名称</td><td class="print-normal col-xs-4">${vdata.comm.name }</td><td class="col-xs-2">负责人</td><td class="print-normal col-xs-4">${vdata.comm.manager }</td></tr>
							<tr><td class="col-xs-2">房屋来源</td><td class="print-normal col-xs-4">${vdata.comm.dicValueMap.codeHouseSource }</td><td class="col-xs-2">居住人数</td><td class="print-normal col-xs-4">${vdata.comm.liveNum }</td></tr>
							<tr><td class="col-xs-2">注册时间</td><td class="print-normal col-xs-4">${vdata.comm.registerDate }</td><td class="col-xs-2">团组织负责人</td><td class="print-normal col-xs-4">${vdata.comm.groupManager }</td></tr>
							<tr><td class="col-xs-2">团组织负责人电话</td><td class="print-normal col-xs-4">${vdata.comm.groupManagerPhone }</td><td class="col-xs-2">团组织负责人职务</td><td class="print-normal col-xs-4">${vdata.comm.groupManagerDuty }</td></tr>
							<tr><td class="col-xs-2">主管部门</td><td class="print-normal col-xs-4">${vdata.comm.directDepartment }</td><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4">${vdata.comm.gridName }</td></tr>
							<tr><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4">${vdata.comm.gridPhone }</td><td class="col-xs-2">证照编号</td><td class="print-normal col-xs-4">${vdata.comm.cardNumber }</td></tr>
							<tr><td class="col-xs-2">组织地址</td><td class="print-normal col-xs-4" colspan="3">${vdata.comm.address }</td></tr>
							<tr><td class="col-xs-2">地图坐标</td><td class="print-normal col-xs-4" colspan="3">${vdata.comm.position }</td></tr>
							
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