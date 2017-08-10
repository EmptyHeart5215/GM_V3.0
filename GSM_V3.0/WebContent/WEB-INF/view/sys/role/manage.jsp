	
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
		 url:"${base}/sys/role/addLoad",
		  title: "角色表",
		  style:'width:600px;height:400px;'
		});
};

//编辑按钮方法，方法名固定，不可改变
function editFun(code){
	if(code&&""!=$.trim(code)){
		var dialog=bootbox.dialog({
			 url:"${base}/sys/role/modifyLoad?code="+code,
			  title: "角色表",
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
		 code=code+"";
	}
	 bootbox.confirm('确定删除吗？',function(result){
		if(result){
			 $.ajax({
					type : "post",
					url : "${base}/sys/role/delete",	
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
var grantFun=function(code){
	if(code&&""!=$.trim(code)){
		var dialog=bootbox.dialog({
			 url:"${base}/sys/rolemenu/grantLoad?code="+code,
			  title: "角色授权",
			  style:'width:600px;height:600px;'
			});
	}else{
		bootbox.alert("请刷新重试！");
		}
}
$(function(){
	 $("#grid-table").jqGrid({
		 				url:"${base }/sys/role/queryManage",
				 	 defaultCaozuo:false,
			        colNames:['', '角色名称','描述','操作'],
			        colModel:[
						{name:'code',index:'code',sortable:false, hidden:true},
			            {name:'roleName',index:'roleName',sortable:true, width:'20%'},
			            {name:'remark',index:'remark', width:'25%',  sortable:false},
			        	{name:'caozuo',width:120,fixed:true, sortable:false, resize:false,formatter:
		            	function(cellvalue, options, rowObject){
		            	var code=rowObject['code'];
		            	var div='<div style="margin-left:8px;">';
		            	div+="<div class='ui-pg-div ui-inline-edit'title='编辑' style='float:left;cursor:pointer;' onclick='editFun(\""+code+"\")'>";
			            	div+='<span class="ui-icon ui-icon-pencil"></span>';
	            			div+="</div> <div  class='ui-pg-div ui-inline-del'title='授权' style='float:left;margin-left:5px;'onclick='grantFun(\""+code+"\")'>";
           				div+='<span class="ui-icon icon-key"></span>';
           				div+="</div> <div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\")'>";
           				div+='<span class="ui-icon ui-icon-trash"></span>';
          					div+='</div>';
          					div+='</div>';
		            		return div;
		            	}
		            }], 
		            sortable:false,
			        rownumbers:true,//添加左侧行号
			        altRows:true,//班玛线
			        sortname:'createDate',
			        sortorder:'desc',
			        viewrecords: true,//是否在浏览导航栏显示记录总数
			        rowNum:10,//每页显示记录数
			        rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
			        multiselect: true,
			        jsonReader:{
			            id: "code",//设置返回参数中，表格ID的名字为CODE
			            repeatitems : false
			        },
			        pager:$('#grid-pager'),
			        caption: "角色管理列表"
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
function initPage(){
	var table_h = $(document).height() -50 ;
	$('#dg').datagrid({
		singleSelect:true,
		url:"${base }/sys/role/queryManage",
		columns:[[				
			{field:'code',title:'主键', width:160,hidden:true},
			{field:'roleName',title:'角色名', width:160}
		]],
		pagination:true,
		sortName:"code",
		toolbar:"#tb",
		height:table_h
	});
	
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
													<label class="col-xs-2 col-myxs-15 control-label text-right">角色名 </label>
													<input name="roleName" type="text" class="text col-xs-2" >
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
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridImport.js"></script>
	</body>
</html>


