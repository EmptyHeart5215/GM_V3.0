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
				 url:"${base}/zhihuizhongxin/message/addLoad",
				  title: "短信记录添加",
				  style:'width:800px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/zhihuizhongxin/message/modifyLoad?code="+code,
				  title: "短信记录修改",
				  style:'width:800px;height:520px;'
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
							url : "${base}/zhihuizhongxin/message/delete?codes="+code,			
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
			 	url : "${base }/zhihuizhongxin/message/queryManage",
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:false,
		        colNames:[ '字典主键', '姓名','手机号','短信内容','发送时间','操作'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'userName',index:'userName',sortable:true, width:'15%',align:'left'},
		            {name:'userPhone',index:'userPhone',sortable:true, width:'10%', align:"left"},
		            {name:'message',index:'message',sortable:true, width:'20%', align:"left"},
		            {name:'sendTime',index:'sendTime',sortable:true, width:'15%',align:'left'},
		           
		            {name:'caozuo',width:120,fixed:true, sortable:false, resize:false,formatter:
		            	function(cellvalue, options, rowObject){
		            	var code=rowObject['code'];
		            	var name=rowObject['dicName'];
		            	var div ="<div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\")'>";
            				div+='<span class="ui-icon ui-icon-trash"></span>';
           					div+='</div>';
           					div+='</div>';
		            		return div;
		            	}
		            } 
		            
		            
		             
		           
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
		        caption: "短信记录管理列表"
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
						短信记录管理
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
													<label class="col-xs-2 control-label text-right">发送短信手机号</label>
													<input name="name" type="text" class="text col-xs-2"  >
													
													
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


