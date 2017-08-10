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
			 	url : "${base }/sys/log/queryManage",
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:false,
		        ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var rowData = $('#grid-table').jqGrid('getRowData',rowid);
			    	  var codes = rowData['code'];
			    	   bootbox.dialog({
							 url:"${base}/sys/log/infoSee?code="+codes+"&stepId=1&entryId=1",
							  title: "用户操作表详细信息表",
							  iframeStyle:'height:1500px;',
							  style:'width:1000px;height:600px;',
							}); 
			      },
		        colNames:[ '日志主键', '操作人','操作时间','操作数据code','用户IP','用户地区','操作数据类型','操作类型'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'createBy',index:'createBy',sortable:true, width:'20%',align:'left'},
		            {name:'createDate',index:'createDate',sortable:true, width:'10%',align:'left'},
		            {name:'shuJu',index:'shuJu',sortable:true, width:'35%',align:'left'},
		            {name:'userIp',index:'userIp',sortable:true, width:'10%',align:'left'},
		            {name:'userAddress',index:'userAddress',sortable:true, width:'10%',align:'left'},
		            {name:'shuJuType',index:'shuJuType', width:'10%', align:"left", sortable:false},
		            {name:'operation',index:'operation', width:'5%', align:"left", sortable:false}
		        ],
		        sortable:true,
		        rownumbers:true,//添加左侧行号
		        altRows:true,//班玛线
		        sortname:'code',
		        sortorder:'desc',
		        viewrecords: true,//是否在浏览导航栏显示记录总数
		        rowNum:10,//每页显示记录数
		        rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
		        multiselect: true,
		        jsonReader:{
		            id: "CODE",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "日志管理列表"
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
											<td >
												<div class="search-group">
								
													<label class="col-xs-2 col-myxs-15 control-label text-right">日志描述 </label>
													<input name="remark" type="text" class="text col-xs-2" searchType="like" >
												</div>
											</td>
											
											<td style="width:100px;">
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
	
</body>
</html>


