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
			 	url : "${base }/emergencyscheduling/emergencysupplies/queryManage",
			 	defaultCaozuo:false,
			 	
			      colNames:[ '主键','物资名称','物资存放地址','物资负责人','物资负责人电话','物资数量','物资类型','物资状态','所属辖区'],
			        colModel:[
						{name:'code',index:'code',sortable:false, hidden:true},
						{name:'suppliesName',index:'suppliesName',sortable:false,width:'20%'},
						{name:'suppliesStoreAddress',index:'suppliesStoreAddress',sortable:false, width:'10%',align:'center'},
			            {name:'suppliesprincipal',index:'suppliesprincipal',sortable:false, width:'10%',align:'center'},
			            {name:'suppliesPhone',index:'suppliesPhone',sortable:false, width:'10%', align:"center"},
			            {name:'suppliesNum',index:'suppliesNum',sortable:false, width:'10%', align:"center"},
			            {name:'dicValueMap.codeSuppliesType',index:'dicValueMap.codeSuppliesType',sortable:false, width:'10%', align:"center"},
			            {name:'dicValueMap.codeSuppliesState',index:'dicValueMap.codeSuppliesState',sortable:false, width:'10%', align:"center"},
			            {name:'gridTotalName',sortable:false,width:'20%'},
			        ],
			        sortable:true, 
			        rownumbers:true,//添加左侧行号
			        altRows:true,//班玛线
			        sortname:'createDate',
			        sortorder:'desc',
			        viewrecords: true,//是否在浏览导航栏显示记录总数
			        rowNum:5,//每页显示记录数
			        showRowList:false,
			        multiselect: true, 
			        rownumbers:true,//添加左侧行号
			        jsonReader:{
			            id: "code",//设置返回参数中，表格ID的名字为CODE
			            repeatitems : false
			        },
			        pager:$('#grid-pager'),
		            caption: "应急物资信息",
		            multiboxonly: true,
		            gridComplete: function() {
		            	var select=jQuery("[name='select']").val();
		            	var rowIds=select.split(",");
		                for(var k=0; k<rowIds.length; k++) {
		                   jQuery("#grid-table").setSelection(rowIds[k], false); 
		                   
		                }
		            }
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
	 function ids(){
			var code=$('#grid-table').jqGrid('getGridParam', "selarrrow");
			console.log(code);
			parent.getValue(code,$("[name='types']").val());
				 return;
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
		<input type="hidden" name="types" value="${vdata.supplies}" />
		<input type="hidden" name="select" value="${vdata.select}" />
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
		</div>
	</div>
</div>
</body>
</html>


