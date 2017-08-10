<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/base/person/modifyLoad?personCode="+code,
				  title: "人信息修改",
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
							url : "${base}/base/teshuperson/delete?personCode="+code,			
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
				 url : "${base }/base/teshuperson/queryManage",
						 	  multiselect: false,
						 	 defaultCaozuo:false,
						 	 colNames:[ '', '所属网格','姓名','性别','证件号码','民族','联系电话','婚姻状况','特殊类型','操作'],
						        colModel:[
									{name:'code',index:'code',sortable:false, hidden:true},
									{name:'gridTotalName',index:'gridTotalName',sortable:false, width:'30%'},
						            {name:'name',index:'name',sortable:false, width:'10%'},
						            {name:'sex',index:'sex',sortable:false, width:'10%'},
						            {name:'cid',index:'cid',sortable:false, width:'10%'},
						            {name:'codeNation',index:'codeNation',sortable:false, width:'10%'},
						            {name:'phone',index:'phone',sortable:false, width:'10%'},
						            {name:'marrigeStr',index:'marrigeStr',sortable:false, width:'10%'},
						            {name:'teShuTypeStr',index:'teShuTypeStr',sortable:false, width:'10%'}
						            ,
						            {name:'caozuo',width:40,fixed:true, sortable:false, resize:false,formatter:
						            	function(cellvalue, options, rowObject){
						            	var code=rowObject['code'];
						            	var div='<div style="margin-left:8px;">';
						            	div+="<div class='ui-pg-div ui-inline-edit'title='编辑' style='float:left;cursor:pointer;' onclick='editFun(\""+code+"\")'>";
							            	div+='<span class="ui-icon ui-icon-pencil"></span>';
				           					div+='</div>';
						            		return div;
						            	}
						            }
						        ],
					        pager:$('#grid-pager'),
					        caption: "字典管理列表"
			    }); 
			 //搜索按钮方法
			 $("#search").click(function(){
					var postData={
							page:1,
							args:$("#search_form").searchPara()
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
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						特殊人群管理
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
													<label class="col-xs-2 col-myxs-15 control-label text-right" >所属辖区</label>
													<input name="dicName" type="text" class="text col-xs-2" >
													<label class="col-xs-2 col-myxs-15 control-label text-right">特殊类型 </label>
													<input name="remark" type="text" class="text col-xs-2" >
													
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
											<td >
												<div class="search-group">
													
													<label class="col-xs-2 col-myxs-15 control-label text-right" >姓名 </label>
													<input name="dicName" type="text" class="text col-xs-2" >
													<label class="col-xs-2 col-myxs-15 control-label text-right">身份证号 </label>
													<input name="remark" type="text" class="text col-xs-2" >
												</div>
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


