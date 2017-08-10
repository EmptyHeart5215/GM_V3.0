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
				url:"${base}/base/bjigou/addLoad",
				title: "机构队伍添加",
				  iframeStyle:"height:450px;",
				  style:'width:800px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
					 url:"${base}/base/bjigou/modifyLoad?code="+code,
					  title: "机构队伍修改",
				  style:'width:800px;height:600px;'
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
							url : "${base}/base/bjigou/delete?codes="+code,			
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
			 	url : "${base }/base/bjigou/queryManage",
			      ondblClickRow:function(rowid,iRow,iCol,e){
					    bootbox.dialog({
							url:"${base}/base/bjigou/infoSee?code="+rowid,
							title: "机构队伍信息详情",
							style:'width:950px;height:600px;',
							showFunctionBtn:false,
							});
				      },
				defaultCaozuo:false,  
				colNames:[ '字典主键', '所属辖区','机构队伍名称','机构队伍负责人',
		                   '负责人联系电话','成立时间','队伍状态'
		                   ],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'seatGrid.gridTotalName',index:'gridCode',sortable:true, width:'25%',align:'center'},
		            {name:'jigouName',index:'jigouName',sortable:true, width:'15%', align:"center"},
		            {name:'jigouManager',index:'jigouManager',sortable:true, width:'15%', align:"center"},
		            {name:'managerPhone',index:'managerPhone',sortable:true, width:'15%',align:'center'},
		            {name:'beginTime',index:'beginTime',sortable:true, width:'15%', align:"center"},
		            {name:'dicValueMap.codeJigouState',index:'codeJigouState',sortable:true, width:'15%', align:"center",formatter:
			            	function(cellvalue, options, rowObject){
		            		var State =rowObject['codeJigouState'];
		            		if(State == '4FA6C6A6E3014DD49D2098B2D25F11A9'){
		            			return '<font color="red">已注销</font>';
		            		}else if(State == '1E39B8CAAF48415B8124A8B64C93FF3F'){
		            			return '<font color="black">服务中</font>';
		            		}
	    	    	     }
		            }
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
		        caption: "机构队伍管理列表"
		    });
		//搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
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
						机构队伍管理
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
															<label class="col-xs-2  control-label text-right">负责人电话</label>
															<input name="managerPhone" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">所属网格员电话</label>
															<input name="gridContactsPhone" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">机构地址</label>
															<input name="address" type="text" class="text col-xs-2"  >
															
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
	
</body>
</html>


