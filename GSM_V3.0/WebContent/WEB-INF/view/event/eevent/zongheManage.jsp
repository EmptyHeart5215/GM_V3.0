<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
	$(function(){
		 $("#grid-table").jqGrid({
			 	url : "${base }/event/eevent/zongheManage",
		      defaultCaozuo:false,
		      multiselect:false,
		      ondblClickRow:function(rowid,iRow,iCol,e){
		    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
		    	  bootbox.dialog({
						 url:"${base}/event/eevent/detailLoad?eventCode="+code+"&stepId=1&entryId=1",
						  title: "事件处理表",
						  iframeStyle:'height:1500px;',
						  style:'width:1000px;height:600px;'
						});
		      },
		        colNames:['序号', '受理编号', '事件预警','事件状态','所属辖区','诉求人姓名','事件类型','诉求主题','紧急程度','严重程度','办理部门','受理时间','办理时限','结案时间','满意度'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'eventNum',index:'eventNum',sortable:true, width:100,fixed:true},
		            {name:'alertLight',index:'alertLight',width:80,fixed:true,formatter:function(cellvalue, options, rowObject){
		            	if(cellvalue){
		            		var img="<img src='/GSM_V3.0/resource/images/"+cellvalue+"light.gif'/>";
							return img;
		            	}
		            }},
		            {name:'stepName',index:'stepName',sortable:true, width:80,fixed:true},
		            {name:'gridTotalName',index:'gridTotalName',sortable:true, width:'30%'},
		            {name:'petitionersName',index:'petitionersName',sortable:true, width:'10%'},
		            {name:'eventTypeStr',index:'eventTypeStr',sortable:true, width:'15%'},
		            {name:'eventTitle',index:'eventTitle',sortable:true, width:'15%'},
		            {name:'eventJinJiStr',index:'eventJinJiStr',sortable:true, width:'15%'},
		            {name:'eventYanZhongStr',index:'eventYanZhongStr',sortable:true, width:'15%'},
		            {name:'banLiDepartment',index:'banLiDepartment',sortable:true, width:'15%'},
		            {name:'shouLiDate',index:'shouLiDate',sortable:true, width:'15%'},
		            {name:'timeLimit',index:'timeLimit',sortable:true, width:'15%'},
		            {name:'banJieDate',index:'banJieDate',sortable:true, width:'15%'},
		            {name:'manYiStateStr',index:'manYiStateStr',sortable:true, width:'15%'}
		        ],
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "上报市级平台查询列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
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
													<label class="col-xs-2 control-label text-right">所属辖区 </label>
													<input name="belongDepartment" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">诉求主题</label>
													<input name="name" type="text" class="text col-xs-6"  >
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
															<label class="col-xs-2  control-label text-right">诉求人</label>
															<input name="manageMan" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">事件类型</label>
															<input name="gridName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">事件来源</label>
															<input name="gridName" type="text" class="text col-xs-2"  >
															
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">受理时间 </label>
															<input name="belongMan" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">事件状态</label>
															<input name="fieldsCode" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">办理部门</label>
															<input name="fieldsCode" type="text" class="text col-xs-2"  >
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">督办状态 </label>
															<input name="isDuBan" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">事件预警</label>
															<input name="alertLight" type="text" class="text col-xs-2"  >
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
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridOnlyFreshImport.js"></script>
</body>
</html>


