	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看资料内容</title>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">
  $(function(){
	  $("[name=gridCode]").ztreeGrid({
			url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
		});
	//搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
				$.ajax({
					type : "post",
					url : "${base}/thing/thinglog/statisticLogQuestion",
					data : postData,
					dataType : 'json',
					async : false,
					success : function(data) {
						if(data != null){
							if(data.falimyCount == null){
								$("#falimyCount").text(0); // 走访户数
							}else{
								$("#falimyCount").text(data.falimyCount); // 走访户数
							}
							$("#questionConflict").text(data.questionConflict); // 矛盾纠纷
							$("#sanitationReaction").text(data.sanitationReaction); // 反宣品
							$("#interviewAuto").text(data.interviewAuto); // 当天自行解决件数
							$("#securityCount").text(data.securityCount); // 治安隐患
							$("#questionAppeal").text(data.questionAppeal); // 群众诉求
							$("#sanitationAd").text(data.sanitationAd); // 小广告
							$("#interviewUp").text(data.interviewUp); // 上报区指挥中心件数
							$("#fireCoun").text(data.fireCoun); // 消防隐患
							$("#questionIdea").text(data.questionIdea); // 群众意见建议
							$("#sanitationChaos").text(data.sanitationChaos); // 乱堆乱放
							$("#otherCount").text(data.otherCount); // 其他问题
							$("#questionOther").text(data.questionOther); // 其他
							$("#sanitationBuild").text(data.sanitationBuild); // 新的私搭乱建
							$("#sanitationOther").text(data.sanitationOther); // 其他
						}else{
							$("#falimyCount").text(0); 
							$("#questionConflict").text(0); // 矛盾纠纷
							$("#sanitationReaction").text(0); // 反宣品
							$("#interviewAuto").text(0); // 当天自行解决件数
							$("#securityCount").text(0); // 治安隐患
							$("#questionAppeal").text(0); // 群众诉求
							$("#sanitationAd").text(0); // 小广告
							$("#interviewUp").text(0); // 上报区指挥中心件数
							$("#fireCoun").text(0); // 消防隐患
							$("#questionIdea").text(0); // 群众意见建议
							$("#sanitationChaos").text(0); // 乱堆乱放
							$("#otherCount").text(0); // 其他问题
							$("#questionOther").text(0); // 其他
							$("#sanitationBuild").text(0); // 新的私搭乱建
							$("#sanitationOther").text(0); // 
							alert("该网格暂无查询数据")
						}						
					}
				}); 
			});
  });
  
  
</script>
<style type="text/css">

</style>
</head>
<body>
<div class="row">
     <div class="tabbable tabs-left">
       <div class="tab-content" >
         <form id="search_form">
            <table width="100%" border="0">
               <tr height="30px;">
                 <td width="8%" style="text-align: right;"> 所属辖区/部门</td>
                 <td width="19%">
					<div class="col-xs-12">
						<input type="text"id="gridCode" name="gridCode"  class="col-xs-12 col-sm-12" />
					</div>
                 </td>
                 <td width="7%" style="text-align: right;">上报时间：</td>
                 <td width="18%">
                    <div class="col-xs-12 input-group">
						<input class="form-control date-picker" id="searchStartTime" name="searchStartTime"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
                 </td>
                 <td width="2%">---</td>
                 <td width="18%">
                    <div class="col-xs-12 input-group">
						<input class="form-control date-picker" id="searchEndTime" name="searchEndTime" type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
                 </td>
                 <td width="6%"></td>
                 <td width="8%">
                    <button type="button" class="btn btn-info" id="search">统计
						<i class="icon-search bigger-110 "></i>
					</button>
                 </td>
               </tr>
            </table>
           </form>
           <table id="grid-table"></table>
			<div id="grid-pager"></div>
            <div id="detailDiv" class="tab-pane in active">
               <div class="col-xs-12" style='text-align:right;'>
					<div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('detailDiv')">
				         <span class="ui-icon icon-print pull-right"></span>
		            </div>
	            </div>
	            <div id="print">
					<h2><center></center></h2>
					<table border="1" cellpadding="0" cellspacing="0" width="80%" align="center">
					   <tr height="30px;">
					     <td width="8%">走访户数</td>
					     <td width="8%" id="falimyCount"></td>
					     <td width="12%">矛盾纠纷</td>
					     <td width="8%" id="questionConflict"></td>
					     <td width="12%">反宣品</td>
					     <td width="8%" id="sanitationReaction"></td>
					     <td width="15%">当天自行解决件数</td>
					     <td width="8%" id="interviewAuto"></td>
					   </tr>
					   <tr height="30px;">
					     <td>治安隐患</td>
					     <td id="securityCount"></td>
					     <td>群众诉求</td>
					     <td id="questionAppeal"></td>
					     <td>小广告</td>
					     <td id="sanitationAd"></td>
					     <td>上报区指挥中心件数</td>
					     <td id="interviewUp"></td>
					   </tr>
					   <tr height="30px;">
					     <td>消防隐患</td>
					     <td id="fireCoun"></td>
					     <td>群众意见建议</td>
					     <td id="questionIdea"></td>
					     <td>乱堆乱放</td>
					     <td id="sanitationChaos"></td>
					     <td></td>
					     <td></td>
					   </tr>
					   <tr height="30px;">
					     <td>其他问题</td>
					     <td id="otherCount"></td>
					     <td>其他</td>
					     <td id="questionOther"></td>
					     <td>新的私搭乱建</td>
					     <td id="sanitationBuild"></td>
					     <td></td>
					     <td></td>
					   </tr>
					   <tr height="30px;">
					     <td></td>
					     <td></td>
					     <td></td>
					     <td></td>
					     <td>其他</td>
					     <td id="sanitationOther"></td>
					     <td></td>
					     <td></td>
					   </tr>
					 </table>
					<hr/>
				</div>
		    </div>
       </div>
     </div>
   </div>
</body>
</html>