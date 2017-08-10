	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<jsp:include page="/resource/js/highcharts/myHighChartsOperator.jsp"/>
<!-- 引入外部自定义css -->
<link rel="stylesheet" href="${base}/resource/user-definedcss/charts.css" />
<script type="text/javascript">
  $(function(){
	  var title="案发信息";
	  var ytitle="案发信息个数（个）";
	  getTitle(ytitle);
		var url="${base }/charts/einformationcharts/Charts?t="+ Math.random();
		chartInit(title,{'search':$("#search_form").serializeJson()},url);
		//重置
		$("#reset").click(function(){
			$('#search_form')[0].reset();
		});
		$("#search").click(
				function() {
					var postData=$("#search_form").serializeJson();
					chartInit(title,postData,url);
					
			});
		$("[name=gridCode]").ztreeGrid({
			url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
		});


	});
</script>
</head>
<body>
<div class="row" id="tb">
	<div class="col-xs-12 col-sm-12" id="body">
		 <div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						列表查询
					</h4>

					<div class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-down"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-body-inner" style="display: none;">
							<div id="sales-charts" style="padding: 0px; width: 100%; height: auto; position: relative;">
							<form id="search_form">
								<table style="width:100%;">
										<tr>
											<td>
												<div class="search-group">
													<label class="col-xs-2 control-label text-right">所属辖区 </label>
													<input name="gridCode" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">案件编号</label>
													<input name="alarmNo" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">案件名称</label>
													<input name="eventName" type="text" class="text col-xs-2"  >
													
												</div>
											</td>
											
											<td style="width:100px;" rowspan="2">
												<ul  class="pull-right list-unstyled" style="margin:0px" >
													<li style="padding-top:1px;">
													   <button type="button" class="btn btn-info" id="search">查询
														  <i class="icon-search bigger-110 "></i>
													   </button>
													</li>
													<li style="padding-top:5px;">
														<button type="reset" class="btn btn-info" id="reset">重置
															  <i class="glyphicon glyphicon-arrow-left bigger-110 "></i>
														</button>
													</li>
												</ul>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">涉案当事人</label>
															<input name="caseParty" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">出警人员</label>
															<input name="policePerson" type="text" class="text col-xs-2" searchType="like" >
															<label class="col-xs-2  control-label text-right">案发时间</label>
															<div class="col-xs-2 input-group" style="padding-right: 0;padding-left: 0;">
													       <input  name="time" type="text" class="form-control date-picker tooltip-error required" searchType="like" >
													       <span class="input-group-addon">
							                               <i class="icon-calendar bigger-110"></i>
						                                   </span>
						                                   </div>
															</div>
															
											</td>
										</tr>
										
										
									</table>

							</form>
						</div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div>
			<div id="grid-pager"></div>
	     <jsp:include page="/resource/js/highcharts/myHighChartsJSP.jsp"/>
		</div>
	</div>
</body>
</html>
