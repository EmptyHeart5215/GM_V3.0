	
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
<script type="text/javascript">
  $(function(){
	  if('${vdata.allparty.codePartyType }' == 'zaizhiparty'){
		  $("#partytype").text("在职党员");
	  }else if('${vdata.allparty.codePartyType }' == 'zhiguanparty'){
		  $("#partytype").text("直管党员");
	  }else if('${vdata.allparty.codePartyType }' == 'tuixiuparty'){
		  $("#partytype").text("退休党员");
	  }else if('${vdata.allparty.codePartyType }' == 'kunnanparty'){
		  $("#partytype").text("困难党员");
	  }else if('${vdata.allparty.codePartyType }' == 'zyzparty'){
		  $("#partytype").text("志愿者党员");
	  }
  });
</script>
<style type="text/css">
  #tbcontent tr:{
     height: 28px;
  }
</style>
</head>
<body>
  <div id="print" style="width: 100%;height: 100%;">
     <div style="width:100%;height: 20px;"></div>
     <div style="width:100%;height: 40px;margin-top: 8px;">
          <div style="text-align: center;width: 70%;margin-left: 70px;">
             <h4>（${vdata.allparty.name }）党员详细信息</h4>
          </div>
          <div style="margin-left: 280px;margin-top: -28px;width: 30%">
            <div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
				<span class="ui-icon icon-print pull-right"></span>
		     </div>
          </div>
     </div>
     <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1);height: 3px;margin-top: -1px;" width="90%" color=#987cb9 SIZE=3>
     <div style="width:100%;height: 58%;">
        <table width="100%" align="center">
			<tr>
			  <td width="18%">网格编码：</td>
			  <td width="35%">${vdata.allparty.gridCode }</td>
			  <td width="18%">创建日期：</td>
			  <td width="35%">${vdata.allparty.createDate }</td>
			</tr>
		</table>
        <table width="100%" border="1" frame=hsides>
           <tr height="26px;">
             <td width="18%">所属辖区</td>
             <td colspan="3">${vdata.allparty.seatGrid.gridTotalName }</td>
           </tr>
           <tr height="26px;">
             <td width="15%" align="center">姓名</td>
             <td width="20%">${vdata.allparty.name }</td>
             <td width="15%" align="center">身份证号</td>
             <td width="20%">${vdata.allparty.cid }</td>
           </tr>
           <tr height="26px;">
             <td align="center">性别</td>
             <td>${vdata.allparty.sex }</td>
             <td align="center">民族</td>
             <td>${vdata.allparty.dicValueMap.codeNation}</td>
           </tr>
           <tr height="26px;">
             <td align="center">文化程度</td>
             <td>${vdata.allparty.dicValueMap.codeEducation }</td>
             <td align="center">政治面貌</td>
             <td>${vdata.allparty.dicValueMap.codePolitical }</td>
           </tr>
           <tr height="26px;">
             <td align="center">党员类型</td>
             <td id="partytype"></td>
             <td align="center">入党时间</td>
             <td>${vdata.allparty.inPartyDate }</td>
           </tr>
           <tr height="26px;">
             <td align="center">备注</td>
             <td colspan="3">2</td>
           </tr>
        </table>
     </div>
  </div>
</body>
</html>