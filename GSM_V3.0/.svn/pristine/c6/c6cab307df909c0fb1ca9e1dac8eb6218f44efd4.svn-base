<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
</head>
<body>
<div class="row">
	<div class="col-xs-12" id="body">
		<div id="print">
			<h2><center>用户操作表</center></h2>
			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">${vdata.log.operation}信息</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table width="60%" align="center">
					  <tr>
					     <td width="18%">操作人：</td>
					     <td width="35%">${vdata.log.createBy }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.log.createDate }</td>
					  </tr>
					</table>
				<table class="print-table" align="center">
					<tr><td class="col-xs-2">操作数据code</td><td class="print-normal col-xs-4">${vdata.log.shuJu}</td><td class="col-xs-2">操作数据类型</td><td class="print-normal col-xs-4">${vdata.log.shuJuType}</td></tr>
					<tr><td class="col-xs-2">用户IP</td><td class="print-normal col-xs-4">${vdata.log.userIp}</td><td class="col-xs-2">用户地区</td><td class="print-normal col-xs-4">${vdata.log.userAddress}</td></tr>
					<c:if test="${vdata.log.operation == '修改'}">
					<tr><td class="col-xs-2">修改前</td><td class="print-normal col-xs-4"  colspan="3" >${vdata.log.beforLog}</td></tr>
					<tr><td class="col-xs-2">修改后</td><td class="print-normal col-xs-4"  colspan="3" >${vdata.log.afterLog}</td></tr>
					</c:if>
					<c:if test="${vdata.log.operation == '添加'}">
					<tr><td class="col-xs-2">添加数据</td><td class="print-normal col-xs-4"  colspan="3" >${vdata.log.afterLog}</td></tr>
					</c:if>
					<c:if test="${vdata.log.operation == '删除'}">
					<tr><td class="col-xs-2">删除数据code</td><td class="print-normal col-xs-4"  colspan="3" >${vdata.log.shuJu}</td></tr>
					</c:if>
				</table>
			</div>
			</div>
			</div>
		
</div>
</body>
</html>