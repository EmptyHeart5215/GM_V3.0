<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
	$(function(){
		$(".date-picker-year-month").
		datepicker({
		language: 'zh-CN',
		format: 'yyyy-mm',
		autoclose: true,
		todayBtn: false,
		minViewMode:'months'
		});
		 $("[name='gridCode']").ztreeGrid({
			 	url: '${base}/sys/seatgird/queryDepartmentTreeByUserGridCode?t=' + Math.random(),
				name:"name",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo'
				});
		 $("#grid-table").jqGrid({
			 	url : "${base}/eva/appraisedepartment/queryAppraisedDepartment?date=${data.nowDate}&gridCode=${data.gridCode}",
		        defaultCaozuo:false,
		        multiselect:false,
		        ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
			    	  bootbox.dialog({
							 url:"${base}/eva/appraisedepartment/queryAppraisedDepartmentDetail?code="+code,
							  title: "详细列表",
							  //iframeStyle:'height:1500px;',
							  showFunctionBtn:false,
							  style:'width:800px;height:500px;'
							});
			      },
		        colNames:[ '字典主键', '考核对象','年','月','操作时间','矛盾未按时办结扣分','矛盾返工扣分','矛盾满意度扣分','矛盾得分','事件未按时办结扣分','事件返工扣分','事件满意度扣分','事件得分'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'gridTotalName',index:'gridTotalName', width:'25%'},
		            {name:'year', width:'5%'},
		            {name:'month',width:'5%'},
		            {name:'createDate',index:'createDate', width:'12%'},
		            {name:'lateKoufenContradict',index:'lateKoufenContradict', width:'10%'},
		            {name:'dubanKoufenContradict',index:'dubanKoufenContradict', width:'10%', sortable:false},
		            {name:'manyiKoufenContradict',index:'manyiKoufenContradict', width:'10%'},
		            {name:'contradictScore',index:'contradictScore', width:'10%'},
		            {name:'lateKoufenEvent',index:'lateKoufenEvent', width:'10%'},
		            {name:'dubanKoufenEvent',index:'dubanKoufenEvent', width:'10%', sortable:false},
		            {name:'manyiKoufenEvent',index:'manyiKoufenEvent', width:'10%'},
		            {name:'eventScore',index:'eventScore', width:'10%'}
		        ],
		        sortable:true,
		        sortname:'gridTotalName',
		        sortorder:'asc',
		        pager:$('#grid-pager'),
		        caption: "部门考核列表"
		    });
		
		 //搜索按钮方法
		 $("#search").click(function(){
			 var gridCode=$('#gridCode').val();
			 var date=$('#date').val();
			 if(gridCode==''){
				 bootbox.alert('请选择辖区！');
				 return;
			 }
			 if(date==''){
				 bootbox.alert('请选择时间！');
				 return;
			 }
			 bootbox.confirm('考核数据将被覆盖，确定要进行操作？',function(result){
					if(result){
						 $.ajax({
								type : "post",
								url : "${base}/eva/appraisedepartment/appraiseDepartment?date="+date+"&gridCode="+gridCode,			
								dataType : 'json',
								async : false,
								success : function(data) {
									bootbox.slideAlert('body',data.status,data.info);
									if(data.status){
										$('#grid-table').jqGrid('clearGridData');
										$('#grid-table').jqGrid('setGridParam', {url:"${base}/eva/appraisedepartment/queryAppraisedDepartment?date="+date+"&gridCode="+gridCode}).trigger('reloadGrid');
									}
								}
							}); 
					}
				});
			});
	 });
</script>
<style type="text/css">
fieldset {
  border: 1px solid #DDDDDD;
  padding: 10px;
}
</style>
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						部门考核
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
													<label class="col-xs-2 col-myxs-15 control-label text-right" >辖区或部门</label>
													<input name="gridCode" type="text" class="text col-xs-2" id="gridCode">
													<label class="col-xs-2 col-myxs-15 control-label text-right">年月 </label>
													<div class="col-xs-4 input-group">
														<input style="height: auto !important;" class="form-control date-picker-year-month tooltip-error required" id="date"name="date"type="text" data-date-format="yyyy-mm">
														<span class="input-group-addon">
															<i class="icon-calendar bigger-110"></i>
														</span>
													</div>
												</div>
											</td>
											<td style="width:100px;">
												<ul  class="pull-right list-unstyled" style="margin:0px" >
													<li style="padding-top:1px;">
													   <button type="button" class="btn btn-info" id="search">考核
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


