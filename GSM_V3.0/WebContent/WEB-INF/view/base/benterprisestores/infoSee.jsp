	
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
					<h2><center>单位门店信息采集表</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.benter.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.benter.createDate }</td>
					  </tr>
					</table>
					<table class="print-table" >
							<tr><td class="col-xs-2">所属部门或辖区</td><td class="print-normal col-xs-4" colspan="3">${vdata.benter.gridCode }</td>
							<tr><td class="col-xs-2">单位门店名称</td><td class="print-normal col-xs-4">${vdata.benter.name }</td><td class="col-xs-2">登记注册时间</td><td class="print-normal col-xs-4">${vdata.benter.registerDate }</td></tr>
							<tr><td class="col-xs-2">经营范围</td><td class="print-normal col-xs-4">${vdata.benter.authority }</td><td class="col-xs-2">业务主管部门</td><td class="print-normal col-xs-4">${vdata.benter.businessSector }</td></tr>
							<tr><td class="col-xs-2">地址</td><td class="print-normal col-xs-4" colspan="3">${vdata.benter.address }</td></tr>
							<tr><td class="col-xs-2">部门</td><td class="print-normal col-xs-4">${vdata.benter.departmentCode }</td><td class="col-xs-2">证件编号</td><td class="print-normal col-xs-4">${vdata.benter.documentNum }</td></tr>
							<tr><td class="col-xs-2">房屋来源</td><td class="print-normal col-xs-4">${vdata.benter.codeHouseSource }</td><td class="col-xs-2">有无安保设施</td><td class="print-normal col-xs-4">${vdata.benter.idSecurity }</td></tr>
							<tr><td class="col-xs-2">有无团组织</td><td class="print-normal col-xs-4">${vdata.benter.isManagement }</td><td class="col-xs-2">有无党组织</td><td class="print-normal col-xs-4">${vdata.benter.isParty }</td></tr>
							<tr><td class="col-xs-2">有无综治组织</td><td class="print-normal col-xs-4">${vdata.benter.isUnion }</td><td class="col-xs-2">修改人</td><td class="print-normal col-xs-4">${vdata.benter.lastModifiedBy }</td></tr>
							<tr><td class="col-xs-2">法人代表</td><td class="print-normal col-xs-4">${vdata.benter.legalCode }</td><td class="col-xs-2">法人代表电话</td><td class="print-normal col-xs-4">${vdata.benter.legalPhone }</td></tr>
							<tr><td class="col-xs-2">团组织编号</td><td class="print-normal col-xs-4">${vdata.benter.managementCode }</td><td class="col-xs-2">团组织负责人</td><td class="print-normal col-xs-4">${vdata.benter.managementDuty }</td></tr>
							<tr><td class="col-xs-2">公会编号</td><td class="print-normal col-xs-4">${vdata.benter.organationCode }</td><td class="col-xs-2">工会织负责人</td><td class="print-normal col-xs-4">${vdata.benter.organationDuty }</td></tr>
							<tr><td class="col-xs-2">在职人数</td><td class="print-normal col-xs-4">${vdata.benter.peopleWorkNum }</td><td class="col-xs-2">综治组织编号</td><td class="print-normal col-xs-4">${vdata.benter.unionCode }</td></tr>
							<tr><td class="col-xs-2">类型</td><td class="print-normal col-xs-4">${vdata.benter.type }</td><td class="col-xs-2">开始使用年份</td><td class="print-normal col-xs-4">${vdata.benter.useStartDate }</td></tr>
							<tr><td class="col-xs-2">综治负责人</td><td class="print-normal col-xs-4">${vdata.benter.unionDuty }</td><td class="col-xs-2">网格联系人电话</td><td class="print-normal col-xs-4">${vdata.benter.gridPhone }</td></tr>
							<tr><td class="col-xs-2">网格联系人</td><td class="print-normal col-xs-4">${vdata.benter.gridName }</td><td class="col-xs-2">网格联系人职务</td><td class="print-normal col-xs-4">${vdata.benter.gridDuty }</td></tr>
							<tr><td class="col-xs-2">地图定位</td><td class="print-normal col-xs-4" colspan="3">${vdata.benter.position }</td></tr>
							
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