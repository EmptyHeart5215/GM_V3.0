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
				 url:"${base}/sys/sysdic/addLoad",
				  title: "设备添加",
				  style:'width:600px;height:400px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/sys/sysdic/modifyLoad?code="+code,
				  title: "设备修改",
				  style:'width:600px;height:400px;'
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
							url : "${base}/sys/sysdic/delete?codes="+code,			
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
		var addValue=function(code,nameDic) {
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
					 url:"${base}/sys/sysdicvalue/manageLoad?code=" + code,
					  title: "编辑 "+nameDic+" 字典值",
					  style:'width:80%;height:600px',
					  iframeStyle:'height:500px;',
					  showFunctionBtn:false
					});
				}else{
					bootbox.alert("请刷新重试！");
			}
			
		}
	$(function(){
		 $("#grid-table").jqGrid({
			 	url : "${base }/mem/streestatic/queryManage",
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:false,
		        colNames:[ '字典主键', '统计对象','社区平均分','矛盾联动化解','责任倒查扣分（手动）','信息采集录入扣分（手动）','民情日志扣分（手动）','按时办结率','返工率','群众满意率','总分'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'nameDepartment',index:'gridName',sortable:true, width:'15%',align:'left'},
		            {name:'communityScore',index:'nameUser',sortable:true, width:'20%', align:"left"},
		            {name:'serviceScore',index:'logScore',sortable:true, width:'20%', align:"left"},
		            {name:'dutyScore',index:'trackScore', width:'35%', align:"left", sortable:false},
		            {name:'infoerrorreduceScore',index:'serviceScore',sortable:true, width:'20%', align:"left"},
		            {name:'logreduceScore',index:'logScore',sortable:true, width:'20%', align:"left"},
		            {name:'delayreduceScore',index:'nameUser',sortable:true, width:'20%', align:"left"},
		            {name:'havenontreduceScore',index:'logScore',sortable:true, width:'20%', align:"left"},
		            {name:'pleasereduceScore',index:'nameUser',sortable:true, width:'20%', align:"left"},

		            {name:'sumScore',index:'sumScore',sortable:true, width:'20%', align:"left"}
		            
		            
		             
		           
		        ],
		        sortable:true,
		        rownumbers:true,//添加左侧行号
		        altRows:true,//班玛线
		        sortname:'CODE',
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
		        caption: "街道统计列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var postData={
						page:1,
						args:$("#search_form").serialize()
				};
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
						街道统计
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
													<label class="col-xs-2 col-myxs-15 control-label text-right" >辖区</label>
													<input name="dicName" type="text" class="text col-xs-2" searchType="like" >
													<label class="col-xs-2 col-myxs-15 control-label text-right">按月 </label>
													<input name="remark" type="text" class="text col-xs-2" searchType="like" >
													
												</div>
											</td>
											</tr>
										<tr>
										<tr>
											<td >
												<div class="search-group">
													
													<label class="col-xs-2 col-myxs-15 control-label text-right" >按季度 </label>
													<input name="dicName" type="text" class="text col-xs-2" searchType="like" >
													<label class="col-xs-2 col-myxs-15 control-label text-right">按年 </label>
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
										<tr>
											
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


