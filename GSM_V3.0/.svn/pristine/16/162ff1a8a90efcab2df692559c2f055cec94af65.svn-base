<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
		//添加按钮方法，方法名固定，不可改变
		var addFun=function(){
			bootbox.dialog({
				url:"${base}/base/bjigouservice/addLoad",
				 title: "服务添加",
				 iframeStyle:"height:480px;",
				  style:'width:1000px;height:600px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
					url:"${base}/base/bjigouservice/modifyLoad?code="+code,
					  title: "服务修改",
					  iframeStyle:"height:480px;",
				  style:'width:1000px;height:600px;'
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
							url : "${base}/base/bjigouservice/delete?codes="+code,		
							dataType : 'json',
							async : false,
							success : function(data) {
								bootbox.slideAlert('body',data.status,data.info);
								if(data.status){
									$("#grid-table").trigger("reloadGrid"); 	  								}
							}
						}); 
				}
			});
		};
	$(function(){
		 $("#grid-table").jqGrid({
			 	url : "${base }/base/bjigouservice/queryManage",
			 
			      ondblClickRow:function(rowid,iRow,iCol,e){
					    bootbox.dialog({
							url:"${base}/base/bjigouservice/infoSee?code="+rowid,
							title: "服务信息详情",
							iframeStyle:"height:450px;",
							style:'width:1000px;height:600px;',
							showFunctionBtn:false,
							});
				      },
			      
		        colNames:[ '主键', '所属辖区','机构队伍名称','机构队伍负责人','机构队伍负责人电话','服务事件','服务对象','服务地点','服务时间'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'jiGou.gridTotalName',index:'gridCode',sortable:false, width:'25%',align:'center'},
		            {name:'jiGou.jigouName',index:'jigouName',sortable:false, width:'15%',align:'center'},
		            {name:'jiGou.jigouManager',index:'jigouManager',sortable:false, width:'15%', align:"center"},
		            {name:'jiGou.managerPhone',index:'managerPhone',sortable:false, width:'15%', align:"center"},
		            {name:'serviceEvent',sortable:false, width:'15%', align:"center"},
		            {name:'serviceDuiXiang',sortable:false, width:'15%', align:"center"},
		            {name:'sevieceAddress',sortable:false, width:'15%', align:"center"},
		            {name:'serviceTime',index:'serviceTime',sortable:false, width:'20%',align:'center'}
		        ],
		        sortable:true,
		        rownumbers:true,//添加左侧行号
		        altRows:true,//班玛线
		        sortname:'serviceTime',
		        sortorder:'desc',
		        viewrecords: true,//是否在浏览导航栏显示记录总数
		        rowNum:10,//每页显示记录数
		        rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
		        multiselect: true,
		        pager:$('#grid-pager'),
		        caption: "服务管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name=gridCode]").ztreeGrid({
				url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
			});
	 });
	//在提交或者修改单条信息成功后的调用方法，用于子页面调用
	 function successFun(){
		bootbox.hideAll();
		bootbox.slideAlert('body');
		jQuery("#grid-table").trigger("reloadGrid"); 	    
	 }
	
</script>
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						服务管理
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
													<label class="col-xs-2 control-label text-right">机构队伍名称</label>
													<input name="jigouName" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">机构队伍负责人</label>
													<input name="jigouManager" type="text" class="text col-xs-2"  >
													
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
															<label class="col-xs-2  control-label text-right">服务事件</label>
															<input name="serviceEvent" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">服务对象</label>
															<input name="serviceDuiXiang" type="text" class="text col-xs-2"  >
															
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


