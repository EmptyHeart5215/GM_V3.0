<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
		<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
		<script type="text/javascript">
		//添加按钮方法，方法名固定，不可改变
		var addFun=function(){
			var dialog=bootbox.dialog({
				 url:"${base}/base/brouteevents/addLoad",
				  title: "线、路案件添加",
				  iframeStyle:"height:500px;",
				  style:'width:950px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/base/brouteevents/modifyLoad?code="+code,
				  title: "线、路案件修改",
				  iframeStyle:"height:500px;",
				  style:'width:950px;height:520px;'
				});
			}else{
				bootbox.alert("请刷新重试！");
			}
		}
		//删除按钮方法，方法名固定，不可改变
		var deleteFun=function(code){
			 if(code&&"string"!=typeof code){
					var code=$('#grid-table').jqGrid('getGridParam', "selarrrow");
					 if(code.length==0){
						 bootbox.alert('请至少选择一条信息！');
						 return;
					 }
				}
			bootbox.confirm('确定删除吗？',function(result){
				if(result){
					 $.ajax({
							type : "post",
							url : "${base}/base/brouteevents/delete?codes="+code,			
							dataType : 'json',
							async : false,
							success : function(data) {
								bootbox.slideAlert('body',data.status,data.info);
								if(data.status){
									$("#grid-table").trigger("reloadGrid"); 	    
								}
							}
						}); 
				}
			});
		};
	
	$(function(){
		$("#grid-table").jqGrid({
		 	url : "${base }/base/brouteevents/queryManage",
		      ondblClickRow:function(rowid,iRow,iCol,e){
				    bootbox.dialog({
						url:"${base}/base/brouteevents/infoSee?code="+rowid,
						title: "线、路案件信息详情",
						iframeStyle:"height:580px;",
						style:'width:950px;height:500px;',
						showFunctionBtn:false,
						});
			      },
		      
	        colNames:[ '主键', '所属辖区','案（事）件编号','案（事）件名称',
	                   '发生日期','案（事）件性质','主犯（嫌疑人）姓名','主犯（嫌疑人）证件代码'
	                   ],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
	            {name:'seatGrid.gridTotalName',index:'gridCode',sortable:true, width:'25%',align:'center'},
	            {name:'eventNumber',index:'eventNumber',sortable:true, width:'15%', align:"center"},
	            {name:'eventName',index:'eventName',sortable:true, width:'15%', align:"center"},
	            {name:'happenDate',index:'happenDate',sortable:true, width:'15%',align:'center'},
	            {name:'dicValueMap.codeEventNature',index:'codeEventNature',sortable:true, width:'15%', align:"center"},
	            {name:'principalName',index:'principalName',sortable:true, width:'15%', align:"center"},
	            {name:'principalCid',index:'principalCid',sortable:true, width:'15%', align:"center"}
// 	            seatGrid.gridTotalName
   
	        ],
	        sortable:true,
	        rownumbers:true,//添加左侧行号
	        altRows:true,//班玛线
	        sortname:'createDate',
	        sortorder:'desc',
	        viewrecords: true,//是否在浏览导航栏显示记录总数
	        rowNum:10,//每页显示记录数
	        rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
	        multiselect: true,
	        pager:$('#grid-pager'),
	        caption: "线、路案件管理列表"
	    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name=gridCode]").ztreeGrid({
				url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
			});
		 $("[name=codeEventNature]").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_NATURE',
				name:"dicValue",
				pIdKey:"parentCode"
			});

	 });
	//在提交或者修改单条信息成功后的调用方法，用于子页面调用
	 function successFun(){
		bootbox.hideAll();
		bootbox.slideAlert('body');
		jQuery("#grid-table").trigger("reloadGrid"); 	    
	 }
	
</script>
<style type="text/css">
fieldset {
  border: 1px solid #DDDDDD;
  padding: 10px;
}
.div-height{width:197px; height:29px}
</style>
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						线、路案件管理
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
													<label class="col-xs-2 control-label text-right">案（事）件编号</label>
													<input type="text"id="eventNumber" name="eventNumber"  class="text col-xs-2" />
													<label class="col-xs-2 control-label text-right">案（事）件性质</label>
													<input name="codeEventNature" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">主犯/嫌疑人证件号</label>
													<input name="principalCid" type="text" class="text col-xs-2"  >
													
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
															<label class="col-xs-2 control-label text-right">主犯/嫌疑人姓名 </label>
															<input type="text"id="principalName" name="principalName"  class="text col-xs-2" />
															<label class="col-xs-2 control-label text-right">发生日期</label>
															<div class="col-xs-2 input-group" style="padding-right: 0;padding-left: 0;">
																<input class="form-control date-picker tooltip-error required" name="happenDate"   type="text">
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
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
		</div>
	    
	</div>
	<!-- 列表右下角按钮组代码 -->
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridImport.js"></script>
</body>
</html>


