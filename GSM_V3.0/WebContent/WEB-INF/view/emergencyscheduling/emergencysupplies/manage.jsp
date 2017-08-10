	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">	


	var addFun=function(){
			var dialog=bootbox.dialog({
				 url:"${base }/emergencyscheduling/emergencysupplies/addLoad",
				  title: "添加",
				  iframeStyle:"height:370px;",
				  style:'width:800px;height:500px;'
			});
	};   
	
	function editFun(code){
		if(code&&""!=$.trim(code)){
			var dialog=bootbox.dialog({
			 url:"${base }/emergencyscheduling/emergencysupplies/modifyLoad?code="+code,
			  title: "修改",
			  iframeStyle:"height:370px;",
			  style:'width:800px;height:500px;'
			});
		}else{
			bootbox.alert("请刷新重试！");
		}
	}
	
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
						url : "${base}/emergencyscheduling/emergencysupplies/delete?codes="+code,			
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
			 	url : "${base }/emergencyscheduling/emergencysupplies/queryManage",
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:true,
		        ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
			    	  bootbox.dialog({
							 url:"${base}/emergencyscheduling/emergencysupplies/detailLoad?code="+rowid+"&stepId=1&entryId=1",
							  title: "应急物资详细信息表",
							  iframeStyle:'height:1500px;',
							  style:'width:1000px;height:600px;',
							  showFunctionBtn:false,
							});
			      },
		        colNames:[ '主键','所属辖区','物资存放地址','物资负责人','物资负责人电话','物资数量','物资类型','物资状态'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'gridTotalName',sortable:false,width:'20%'},
					{name:'suppliesStoreAddress',index:'suppliesStoreAddress',sortable:false, width:'10%',align:'center'},
		            {name:'suppliesprincipal',index:'suppliesprincipal',sortable:false, width:'10%',align:'center'},
		            {name:'suppliesPhone',index:'suppliesPhone',sortable:false, width:'10%', align:"center"},
		            {name:'suppliesNum',index:'suppliesNum',sortable:false, width:'10%', align:"center"},
		            {name:'dicValueMap.codeSuppliesType',index:'dicValueMap.codeSuppliesType',sortable:false, width:'10%', align:"center"},
		            {name:'dicValueMap.codeSuppliesState',index:'dicValueMap.codeSuppliesState',sortable:false, width:'10%', align:"center"},
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
		        caption: "管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
			 var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name=gridCode]").ztreeGrid({
				url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
			});
		//应急物资
			$("[name='codeSuppliesType']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SUPPLIES_TYPE',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo',
				checkBox:true
				});
			//物资状态
			$("[name='codeSuppliesState']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SUPPLIES_STATE',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo',
				checkBox:true
				});
	 });
	
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
									<table style="width:100%;" >
										<tr>
											<td>
												<div class="search-group">	
														<label class="col-xs-2 control-label text-right">所属辖区 </label>
														<input name="gridCode" type="text" class="text col-xs-2"  >								
														<label class="col-xs-2 col-myxs-2 control-label text-right" >物资负责人</label>
														<input name="suppliesprincipal"  type="text" class="text col-xs-2" >
														<label class="col-xs-2 col-myxs-2 control-label text-right">物资类型</label>
														<input name="codeSuppliesType" type="text" class="text col-xs-2"  >
														
												</div>	
											</td>	
											<td >
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
						</div>
					</div>
				</div>
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
		</div>
	    
	</div>
	<!-- 列表右下角按钮组代码 -->
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridImport.js"></script>
	</body>
</html>


