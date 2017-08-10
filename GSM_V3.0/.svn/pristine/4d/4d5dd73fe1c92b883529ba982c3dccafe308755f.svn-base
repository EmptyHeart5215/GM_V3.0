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
			var dialog=bootbox.dialog({
				 url:"${base}/base/bparts/addLoad",
				  title: "部件添加",
				  style:'width:1000px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/base/bparts/modifyLoad?code="+code,
				  title: "部件修改",
				  style:'width:1000px;height:520px;'
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
							url : "${base}/base/bparts/delete?codes="+code,			
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
			 	url : "${base }/yanpanfenxi/partsquery/zongheManage",
			 	ondblClickRow:function(rowid,iRow,iCol,e){
				    bootbox.dialog({
						url:"${base}/base/bparts/infoSee?code="+rowid,
						title: "信息采集表",
						style:'width:800px;height:500px;',
						showFunctionBtn:false,
						});
			      },
			 	defaultCaozuo:false,
		        colNames:[ '字典主键', '部件名称','所属类别','所属辖区部门','管理单位',
		                   '部件状态','网格联系人','网格联系人电话'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'name',index:'name',sortable:true, width:'15%'},
		            {name:'dicValueMap.codeSmallType',index:'partsTypeStr',sortable:true, width:'10%'},
		            {name:'seatGrid.gridTotalName',index:'gridCode',sortable:false, width:'20%',align:'left'},
		            {name:'enterpriseManage',index:'enterpriseManage',sortable:false, width:'20%'},
		            {name:'codePartsStatus',index:'partsStatusStr',sortable:false, width:'10%'},
		            {name:'gridContacts',index:'gridName',sortable:true, width:'10%'},
		            {name:'gridContactsPhone',index:'gridPhone',sortable:true, width:'20%'}
		        ],
		        sortable:true,
		        sortname:'name',
		        pager:$('#grid-pager'),
		        caption: "城市部件管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name=gridCode]").ztreeGrid({
				url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
			});
		 $("[name=codeSmallType]").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SMALL_TYPE',
				name:"dicValue",
				pIdKey:"parentCode",
					reset:true,
					checkBox:true,
					resetId:'redo'
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
</style>
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						城市部件管理
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
								<table style="width:100%;">
										<tr>
											<td>
												<div class="search-group">
													<label class="col-xs-2 control-label text-right">所属辖区 </label>
													<input name="gridCode" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">部件名称</label>
													<input name="name" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">部件编号</label>
													<input name="partsCode" type="text" class="text col-xs-2"  >
													
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
															<label class="col-xs-2  control-label text-right">所属类型</label>
															<input name="codeSmallType" type="text" class="text col-xs-2"  >	
															<label class="col-xs-2  control-label text-right">管理单位</label>
															<input name="enterpriseManage" type="text" class="text col-xs-2"  >			
														</div>
											</td>
										</tr>
									</table>
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


