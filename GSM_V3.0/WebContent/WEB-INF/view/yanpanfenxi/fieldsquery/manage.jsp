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
				 url:"${base}/yanpanfenxi/fieldsquery/addLoad",
				  title: "新增场所",
				  style:'width:800px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/yanpanfenxi/fieldsquery/modifyLoad?code="+code,
				  title: "场所修改",
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
							url : "${base}/yanpanfenxi/fieldsquery/delete?codes="+code,			
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
					 url:"${base}/yanpanfenxi/fieldsquery/manageLoad?sysDicCode=" + code,
					  title: "编辑 "+nameDic+" 场所值",
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
			 	url : "${base }/yanpanfenxi/fieldsquery/zongheManage",
			 	ondblClickRow:function(rowid,iRow,iCol,e){
				    bootbox.dialog({
						url:"${base}/base/fields/infoSee?code="+rowid,
						title: "信息采集表",
						style:'width:800px;height:500px;',
						showFunctionBtn:false,
						});
			      },
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:false,
		        colNames:[ '主键', '所属辖区','地名','所属分类','地点','面积','范围界限','主管部门','其他附属设施'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'seatGrid.gridTotalName',index:'seatGrid.gridTotalName',sortable:false, width:'20%'},
		            {name:'name',index:'name',sortable:false, width:'15%'},
		            {name:'dicValueMap.codeBelongType',index:'dicValueMap.codeBelongType',sortable:false, width:'10%'},
		            {name:'address',index:'address',sortable:false, width:'15%'},
		            {name:'area',index:'area',sortable:false, width:'10%'},
		            {name:'range',index:'range',sortable:false, width:'15%'},
		            {name:'belong',index:'belong',sortable:false, width:'20%'},
		            {name:'otherBelong',index:'otherBelong',sortable:false, width:'15%'}
		            
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
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "场所管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name=gridCode]").ztreeGrid({
				url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
			});
		 $("[name=codeBelongType]").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_FIELDS_CLASS',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				checkBox:true,
				resetId:'redo'
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
						场所查询
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
															<label class="col-xs-2 col-myxs-1 control-label text-right">所属辖区 </label>
															<input name="gridCode" type="text" class="text col-xs-2" searchType="like" >
															<label class="col-xs-2 col-myxs-1 control-label text-right">地名称 </label>
															<input name="name" type="text" class="text col-xs-2" searchType="like" >
															<label class="col-xs-2 col-myxs-1 control-label text-right">管理负责人</label>
															<input name="manageMan" type="text" class="text col-xs-2" searchType="like" >
															
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
															<label class="col-xs-2 col-myxs-1 control-label text-right">网格联系人</label>
															<input name="gridName" type="text" class="text col-xs-2" searchType="like" >
															<label class="col-xs-2 col-myxs-1 control-label text-right">单位负责人 </label>
															<input name="belongMan" type="text" class="text col-xs-2" searchType="like" >
															<label class="col-xs-2 col-myxs-1 control-label text-right">所属分类</label>
															<input name="codeBelongType" type="text" class="text col-xs-2" searchType="like" >
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2 col-myxs-1 control-label text-right">主管或所属单位 </label>
															<input name="belong" type="text" class="text col-xs-2" searchType="like" >
															<label class="col-xs-2 col-myxs-1 control-label text-right">地编号 </label>
															<input name="fieldsCode" type="text" class="text col-xs-2" searchType="like" >
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


