<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
	$(function(){
		$(".date-picker-year").
		datepicker({
		language: 'zh-CN',
		format: 'yyyy',
		autoclose: true,
		todayBtn: false,
		minViewMode:'years'
		});
		 $("[name='gridCode']").ztreeGrid({
			 	url: '${base}/sys/seatgird/queryGridTreeByUserGridCode?leastLength=8&t=' + Math.random(),
				name:"name",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo'
				});
		 $("#grid-table").jqGrid({
		        defaultCaozuo:false,
		        colNames:[ '字典主键', '考核对象','矛盾排查化解','事件得分'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'gridTotalName',index:'gridTotalName', width:'25%'},
		            {name:'contradictScore',index:'contradictScore', width:'10%'},
		            {name:'eventScore',index:'eventScore', width:'10%'}
		        ],
		        sortable:true,
		        sortname:'gridTotalName',
		        sortorder:'asc',
		        pager:$('#grid-pager'),
		        caption: "街道统计列表"
		    });
		
		 //搜索按钮方法
		 $("#search").click(function(){
			 var year=$('#year').val();
			 if(year==''){
				 bootbox.alert('请选择年份！');
				 return;
			 }
			 if($('[name=type]:checked').val()=='month'){
				 if($('[name=month]').val()=='0'){
					 bootbox.alert("请选择月份！");
					 return;
				 }
			 }else if($('[name=type]:checked').val()=='jiDu'){
				 if($('[name=jiDu]').val()=='0'){
					 bootbox.alert("请选择季度！");
					 return;
				 }
			 }
			 var data=$('#search_form').serializeJson();
			 $('#grid-table').jqGrid('setGridParam', {url:"${base}/eva/statisticsstreet/queryStatisticsStreet",mtype:"POST",
			postData:data 
			 }).trigger('reloadGrid');
			});
	 });
</script>
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						街道统计
					</h4>
				</div>
				<div class="widget-body">
					<div class="widget-body-inner">
							<div id="sales-charts" style="padding: 0px; width: 100%; height: auto; position: relative;">
								<form id="search_form">
									<table style="width:100%;">
										<tr>
											<td >
												<div class="search-group">
											<table class="col-xs-4">
											<tr><td>
												<label class="col-xs-6  control-label text-right" >辖区</label>
												<input name="gridCode" type="text" class="text col-xs-6" id="gridCode">
												</td></tr>
												<tr><td>
												<label class="col-xs-6  control-label text-right"><span class="red">*</span>年度 </label>
												<div class="input-group ">
													<input style="height: auto !important;" class="form-control date-picker-year  tooltip-error required" id="year"name="year"type="text">
													<span class="input-group-addon">
														<i class="icon-calendar bigger-110"></i>
													</span>
												</div>
												</td></tr>
												</table>
												<label class="col-xs-2 control-label text-right" >计算类型</label>
												<ul  class="list-unstyled  col-xs-2" style="margin:0px" >
													<li style="padding-top:1px;">
													   <div class="">
														<label>
															<input name="type" value="year" checked="checked" class="ace" type="radio" >
															<span style="margin-top: 4px;" class="lbl">按年</span>
														</label>
													</div>
													</li>
													<li style="padding-top:5px;float:left;">
														<div class="form-group">
														<label style="float:left">
															<input name="type" value="jiDu"class="ace" type="radio" >
															<span class="lbl"style="margin-top: 4px;">按季度</span>
														</label>
															<select name="jiDu" class="myselect" style="float:left">
															<option value='0'> 请选择季度</option>
																<option value="1">第一季度</option>
																<option value="2" >第二季度</option>
																<option value="3">第三季度</option>
																<option value="4">第四季度</option>
															</select>
													</div>
													</li>
													<li style="padding-top:5px;float:left;">
													<div class="form-group ">
														<label style="float:left">
															<input name="type" value="month"class="ace" type="radio" >
															<span class="lbl"style="margin-top: 4px;">按月&nbsp;&nbsp;&nbsp;&nbsp;</span>
														</label>
															<select name="month" class="myselect" style="float:left">
																<option value="0">请选择月份</option>
																<option value="1">1</option>
																<option value="2" >2</option>
																<option value="3">3</option>
																<option value="4">4</option>
																<option value="5">5</option>
																<option value="6">6</option>
																<option value="7">7</option>
																<option value="8">8</option>
																<option value="9">9</option>
																<option value="10">10</option>
																<option value="11">11</option>
																<option value="12">12</option>
															</select>
													</div>
													</li>
												</ul>
												</div>
											</td>
											<td style="width:100px;" rowspan="2">
												<ul  class="pull-right list-unstyled" style="margin:0px" >
													<li style="padding-top:1px;">
													   <button type="button" class="btn btn-info" id="search">统计
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
									</table>
								</form>
							</div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div>
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
		</div>
	    
	</div>
	<!-- 列表右下角按钮组代码 -->
		
</body>
</html>


