	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<style type="text/css">
#dialog_iframe {top: 0px; bottom: 0px; width: 750px; min-height: 200px; height: 300px !important; }
</style>
<script type="text/javascript">
//添加按钮方法，方法名固定，不可改变
var addFun=function(){
	bootbox.dialog({
		 url:"${base}/sys/user/addLoad",
		  title: "用户表",
		  iframeStyle:"height:650px;",
		  style:'width:800px;height:520px;'
		});
};

//编辑按钮方法，方法名固定，不可改变
function editFun(code){
	if(code&&""!=$.trim(code)){
		var dialog=bootbox.dialog({
			 url:"${base}/sys/user/modifyLoad?code="+code,
			  title: "用户表",
			  style:'width:800px;height:520px;',
			  iframeStyle:"height:650px;"
			});
	}else{
		bootbox.alert("请刷新重试！");
		}
}
function lockFun(){
	lockOrUnlock(true,"禁用",true);
}
function unlockFun(){
	lockOrUnlock(true,"启用",false);
}
//启用或禁用按钮代码，nowState表示目前的启用或禁用状态，true/false
function lockOrUnlock(code,flagIsEnable_title,nowState){
	 if(code&&"string"!=typeof code){
			var code=$('#grid-table').jqGrid('getGridParam', "selarrrow");
			 if(code.length==0){
				 bootbox.alert('请至少选择一条信息！');
				 return;
			 }
			 code=code+"";
		}
		 bootbox.confirm('确定'+flagIsEnable_title+'吗？',function(result){
			if(result){
				 $.ajax({
						type : "POST",
						url : "${base}/sys/user/lockOrUnlock",
					    data:{
					    	codes:code,
					    	nowState:nowState
					    },
						dataType : 'json',
						async : false,
						success : function(data) {
							bootbox.slideAlert('body',data.status,data.info);
							if(data.status){
								jQuery("#grid-table").trigger("reloadGrid"); 	    
							}
						}
					}); 
			}
		}); 
}
//删除按钮方法，方法名固定，不可改变
var deleteFun=function(code){
	 if(code&&"string"!=typeof code){
		var code=$('#grid-table').jqGrid('getGridParam', "selarrrow");
		 if(code.length==0){
			 bootbox.alert('请至少选择一条信息！');
			 return;
		 }
		 code=code+"";
	}
	 bootbox.confirm('确定删除吗？',function(result){
		if(result){
			 $.ajax({
					type : "post",
					url : "${base}/sys/user/delete",	
					 data:{"codes":code},
					dataType : 'json',
					async : false,
					success : function(data) {
						bootbox.slideAlert('body',data.status,data.info);
						if(data.status){
							jQuery("#grid-table").trigger("reloadGrid"); 	    
						}
					}
				}); 
		}
	}); 
};
	$(function(){
		 $("#grid-table").jqGrid({
			            method: 'post',
					 	url : "${base }/sys/user/queryManage",
					 	defaultCaozuo:false,
				        colNames:['', '用户名','真实姓名','联系电话','创建时间','状态','操作'],
				        colModel:[
							{name:'code',index:'code',sortable:false, hidden:true},
				            {name:'loginName',index:'loginName',sortable:false, width:'15%',sortable:true},
				            {name:'realName',index:'realName',sortable:false, width:'15%'},
				            {name:'phone',index:'phone',sortable:false, width:'15%'},
				            //{name:'roleName',index:'roleName',sortable:true, width:'20%'},
				            //{name:'gridTotalName',index:'gridTotalName', width:'25%',  sortable:false},
				            {name:'createDate', index:'createDate',width:'10%',sortable:false},
				            {name:'flagIsEnable', index:'flagIsEnable', width:'10%',sortable:false},
				        	{name:'caozuo',width:120,fixed:true, sortable:false, resize:false,formatter:
			            	function(cellvalue, options, rowObject){
			            	var code=rowObject['code'];
			            	var flagIsEnable_title="启用他";
			            	var icon="ui-icon-unlock";
			            	if(rowObject['flagIsEnable']==true){
			            		flagIsEnable_title="禁用他";
			            		icon="ui-icon-lock";
			            	}
			            	var div='<div style="margin-left:8px;">';
			            	div+="<div class='ui-pg-div ui-inline-edit'title='编辑' style='float:left;cursor:pointer;' onclick='editFun(\""+code+"\")'>";
				            	div+='<span class="ui-icon ui-icon-pencil"></span>';
		            			div+="</div> <div  class='ui-pg-div ui-inline-del'title='"+flagIsEnable_title+"' style='float:left;margin-left:5px;'onclick='lockOrUnlock(\""+code+"\",\""+flagIsEnable_title+"\",\""+rowObject['flagIsEnable']+"\")'>";
	            				div+='<span class="ui-icon '+icon+'"></span>';
	            				div+="</div> <div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\")'>";
	            				div+='<span class="ui-icon ui-icon-trash"></span>';
	           					div+='</div>';
	           					div+='</div>';
			            		return div;
			            	}
			            }], 
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
				        caption: "用户管理列表"
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
												<div class="form-group">
													<label class="col-xs-2 col-myxs-15 control-label text-right">用户名 </label>
													<input name="loginName" id = "loginName" type="text" class="text col-xs-2" searchType="like" >
													<label class="col-xs-2 col-myxs-15 control-label text-right">创建时间 </label>
													<div class="col-xs-2 input-group">
														<input class="form-control date-picker tooltip-error required" name="createDate" type="text">
														<span class="input-group-addon">
															<i class="icon-calendar bigger-110"></i>
														</span>
													</div>
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
	<!-- 列表右下角按钮组代码 -->
		<script type="text/javascript">
		var freshFun=function(){
			$("#grid-table").trigger("reloadGrid");
		};
		$(function(){
		//navButtons
		jQuery("#grid-table").navGrid('#grid-pager',{edit:false,add:false,del:false,search:false,refresh:false})
		.navButtonAdd('#grid-pager',{  
		 caption:"",
		 buttonicon:"icon-plus-sign purple",
		 onClickButton:addFun,
		 position:"last"  ,
		 title:"新增"
		 })
		 .navButtonAdd('#grid-pager',{  
			 caption:"",
			 buttonicon:"ui-icon-lock warning",
			 onClickButton:lockFun,
			 position:"last"  ,
			 title:"禁用他"
			 })
			 .navButtonAdd('#grid-pager',{  
			 caption:"",
			 buttonicon:"icon-unlock green",
			 onClickButton:unlockFun,
			 position:"last"  ,
			 title:"启用他"
			 })
		 .navButtonAdd('#grid-pager',{  
			 caption:"",
			 buttonicon:" icon-trash red",
			 onClickButton:deleteFun,
			 position:"last"  ,
			 title:"删除"
			 })
		 .navButtonAdd('#grid-pager',{  
			 caption:"",
			 buttonicon:"ui-icon icon-refresh",
			 onClickButton: freshFun,
			 position:"last"  ,
			 title:"刷新"
			 })  ;
		});
		</script>
</body>
</html>
