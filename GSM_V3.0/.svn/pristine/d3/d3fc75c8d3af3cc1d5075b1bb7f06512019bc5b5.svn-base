	
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
	  var title="矛盾";
	  var ytitle="矛盾个数（矛盾）";
	  getTitle(ytitle);
		var url="${base }/charts/econtradictcharts/econtradictCharts?t="+ Math.random();
		chartInit(title,{'args':JSON.stringify($("#search_form").serializeJson())},url);
		//重置
		$("#reset").click(function(){
			$('#search_form')[0].reset();
		});
		$("#search").click(
			function() {
				chartInit(title,{'args':JSON.stringify($("#search_form").serializeJson())},url);
		});
		//矛盾类型
		$("[name='codeEventType']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_TYPE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
		
		//
		$("[name='codeEventGuimo']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_GUIMO',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
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
								<table style="width: 100%;">
									<tr>
										<td>
											<div class="search-group">
												<label class="col-xs-2 control-label text-right">所属辖区
												</label> <input name="gridCode" type="text" class="text col-xs-2"> 
												<label class="col-xs-2 control-label text-right">矛盾类型
												</label> <input name="codeEventType" type="text" class="text col-xs-2"> 
												<label class="col-xs-2  control-label text-right">发生规模</label>
												<input name="codeEventGuimo" type="text" class="text col-xs-2">
											</div>
										</td>
										<td style="width: 100px;" rowspan="3">
											<ul class="pull-right list-unstyled" style="margin: 0px">
												<li style="padding-top: 1px;">
													<button type="button" class="btn btn-info" id="search">
														查询 <i class="icon-search bigger-110 "></i>
													</button>
												</li>
												<li style="padding-top: 5px;">
													<button type="reset" class="btn btn-info" id="reset">
														重置 <i class="glyphicon glyphicon-arrow-left bigger-110 "></i>
													</button>
												</li>
											</ul>
										</td>
									</tr>
									<tr>
										<td>
											<div class="search-group">
											<label class="col-xs-2  control-label text-right">登记人</label> 
												<input name="createName" type="text" class="text col-xs-2">
												<label class="col-xs-2  control-label text-right">受理时间</label> 
												<div class="input-group" style="width:50%;float: left;" >
													<input class="col-xs-12 col-sm-12 form-control date-range-picker"name="shouLiDate" type="text"/>
													<span class="input-group-addon">
														<i class="icon-calendar bigger-110"></i>
													</span>
												</div>
												<!-- <label class="col-xs-2  control-label text-right">事件状态</label> 
												<input name="stepId" type="text" class="text col-xs-2"> -->
											</div>
										</td>
									</tr>
									<tr> 
 										<td> 
											<div class="search-group"> 
 												<label class="col-xs-2  control-label text-right">统计类型</label>
											<input type="radio" value="gridCode"  checked name="type"> 辖区  
											<input type="radio" value="stepId" name="type"> 事件状态  
											<input type="radio" value="codeEventGuimo" name="type">发生规模 
											<input type="radio" value="codeAppraise"  name="type"> 评价结果 
 											 <input type="radio" value="codeEventType" name="type">事件类型  
											 <input type="radio" value="actionId" name="type"> 督办			 
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
