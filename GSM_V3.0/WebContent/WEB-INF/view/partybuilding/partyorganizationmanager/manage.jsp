	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<style>
		/* .ui-icon-seek-prev { background-position: -48px -160px; } */
		/* .modal-title{
			display: inline;
			line-height: 36px;
			margin: 0;
			padding: 0;
		} */
		</style>
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
//添加按钮方法，方法名固定，不可改变
var addFun=function(){
	bootbox.dialog({
		 url:"${base}/partybuilding/partyorganizationmanager/addLoad",
		  title: "党组织管理",
		  style:'width:800px;height:400px;'
		});
};

//编辑按钮方法，方法名固定，不可改变
function editFun(code){
	if(code&&""!=$.trim(code)){
		var dialog=bootbox.dialog({
			 url:"${base}/partybuilding/partyorganizationmanager/modifyLoad?code="+code,
			  title: "党组织管理",
			  style:'width:800px;height:400px;'
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
					url : "${base}/partybuilding/partyorganizationmanager/delete?codes="+code,			
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
		$("[name=codePartyOrganizationType]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_PARTY_ORGANIZATION_TYPE',
			name:"dicValue",
			pIdKey:"parentCode"
		});
		 $("#grid-table").jqGrid({
			 	url:"${base }/partybuilding/partyorganizationmanager/queryManage",
			 	datatype:"json", //数据来源，本地数据
			 	mtype:"POST",//提交方式
		        colNames:['','书记姓名', '组织名称  ','性别 ','身份证号','党组织类型','工作电话 ','手机号码 ','创建时间'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'secretaryName',index:'secretaryName',sortable:false, width:'25%'},
		            {name:'organizaName',index:'organizaName',sortable:false, width:'35%'},
		            {name:'sex',index:'sex', width:'40%', sortable:false, width:'15%',formatter:
		            	function(cellvalue, options, rowObject){
		            		var sex =rowObject['sex'];
		            		if(sex == '男'){
		            			return '<font color="red">男</font>';
		            		}else if(sex == '女'){
		            			return '<font color="green">女</font>';
		            		}else if(sex == 0){
		            			return '<font color="#694d9f">未填写</font>';
		            		}
            	    	}
		            },
		            {name:'cid',index:'cid',sortable:false, width:'38%'},
		            {name:'dicValueMap.codePartyOrganizationType',sortable:false, width:'38%'},
		            {name:'phone', index:'phone',sortable:false, width:40},
		            {name:'mobile', index:'mobile',sortable:true, width:40},
		            {name:'createDate', index:'createDate', width:40}
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
		        multiselect: true,
		        rownumbers:true,//添加左侧行号
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "党组织管理列表"
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
		refreshTree();
	 }
	function refreshTree(){
		var a = $(parent.partymainFrame.document).contents().find('.row').html();
		//alert(a);
		 /* var zTreeaa = $.fn.zTree.getZTreeObj("xqTree"); 
		 zTreeaa.reAsyncChildNodes(null, "refresh"); */
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
													<label class="col-xs-2 control-label no-padding-right text-right">书记姓名 </label>
													<div class="col-xs-4">
													    <input name="secretaryName" type="text" class="col-xs-12 col-sm-12"">
													</div>
													<label id="sss" class="col-xs-2 control-label no-padding-right text-right">党组织类型</label>
													<div class="col-xs-4">
														<input type="text" id="codePartyOrganizationType" name="codePartyOrganizationType" class="col-xs-12 col-sm-12" />
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
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridImport.js"></script>
</body>
</html>
