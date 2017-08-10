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
				 url:"${base}/eventfile/efactivities/addLoad",
				  title: "大型活动",
				  iframeStyle:"height:650px;",
				  style:'width:900px;height:600px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/eventfile/efactivities/modifyLoad?code="+code,
				  title: "大型活动",
				  iframeStyle:"height:900px;",
				  style:'width:900px;height:600px;'
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
							url : "${base}/eventfile/efactivities/delete?codes="+code,			
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
			 	url : "${base }/eventfile/efactivities/queryManage",
			 	ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
			    	  bootbox.dialog({
							 url:"${base}/eventfile/efactivities/detailLoad?eventCode="+rowid+"&stepId=1&entryId=1",
							  title: "大型活动详细信息表",
							  iframeStyle:'height:1200px;',
							  style:'width:1000px;height:600px;',
							  showFunctionBtn:false,
							});
			      },
		        colNames:['序号', '所属辖区', '活动主题','活动地点','组织方参与人数','活动开始时间','活动结束时间'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'gridCode',index:'gridCode',sortable:true, width:'10%',align:'center',
		            	formatter:
							function(cellvalue, options, rowObject){
		            		var gridCode =rowObject['seatGrid'];
		            		gridCode = gridCode.gridTotalName;
		            		return gridCode;
	            	    }},
		            {name:'titleName',index:'titleName',sortable:true, width:'5%', align:"center"},
		            {name:'responsibleLocation',index:'responsibleLocation',sortable:true, width:'5%', align:"center"},
		            {name:'orgPersons',index:'orgPersons',sortable:true, width:'10%', align:"center"},
		            {name:'beginTime',index:'beginTime',sortable:true, width:'10%', align:"center"},
		            {name:'endTime',index:'endTime',sortable:true, width:'10%', align:"center"},
		          
		          
		           
		           ],
		       
		        sortable:false,
			    rownumbers:true,//添加左侧行号
			    altRows:true,//班玛线
			    sortname:'createDate',
			    sortorder:'desc',
			    viewrecords: true,//是否在浏览导航栏显示记录总数
			    rowNum:10,//每页显示记录数
			    rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
			    multiselect: true,
		        pager:$('#grid-pager'),
		        caption: "大型活动管理列表"
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
						查询条件
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
													<label class="col-xs-2 control-label text-right">所属辖区</label>
													<input name="gridCode" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">活动主题</label>
													<input name="titleName" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">参加活动的人员范围</label>
													<input name="responsibleRange" type="text" class="text col-xs-2"  >
													
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
															<label class="col-xs-2  control-label text-right">活动负责人或召集人</label>
															<input name="responsibleName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">活动开始时间</label>
															<div class="col-xs-2 input-group" style="padding-right: 0;padding-left: 0;">
													       <input  name="beginTime" type="text" class="form-control date-picker tooltip-error required" searchType="like" >
													       <span class="input-group-addon">
							                               <i class="icon-calendar bigger-110"></i>
						                                   </span>
						                                   </div>
															<label class="col-xs-2  control-label text-right">群众参与人数</label>
															<input name="massesPersons" type="text" class="text col-xs-2" searchType="like" >
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


