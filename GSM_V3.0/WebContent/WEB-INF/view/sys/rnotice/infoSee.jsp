	
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
					<h2><center>公告信息采集表</center></h2>
					<table width="60%" align="center">

					</table>
					<table id="tbcontent" align="center" width="100%" border="1">
					   <tr height="28px;">
					     <td width="15%" align="center"><b>标题</b></td>
					     <td width="30%" colspan="3">&nbsp;${vdata.sysRnotice.title }</td>
					   </tr>
					   <tr height="28px;">
					     <td width="15%" align="center"><b>发布时间</b></td>
					     <td width="30%">&nbsp;${vdata.sysRnotice.createDate }</td>
					     <td width="15%" align="center"><b>发布人</b></td>
					     <td width="30%">&nbsp;${vdata.sysRnotice.sysUser.realName }</td>
					   </tr>
					    <tr height="28px;">
					     <td width="15%" align="center"><b>内容</b></td>
					     <td width="30%" height="120px;" colspan="3" style="word-break:break-all; word-wrap:break-word;">&nbsp;${vdata.sysRnotice.content }</td>
					   </tr>
					</table>
					<hr/>
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