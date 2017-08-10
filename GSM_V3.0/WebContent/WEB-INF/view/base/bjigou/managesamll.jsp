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
			 	url : "${base }/base/bjigou/queryManageSamll",
			 	defaultCaozuo:false,
			 	ondblClickRow:function(rowid,iRow,iCol,e){
			 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
			 		var jigouName = rowData.jigouName;
			 		var jigouManager =rowData.jigouManager;
			 		var managerPhone =rowData.managerPhone;
			 		var gridName =rowData["seatGrid.gridTotalName"];
			 		var gridCode=rowData.gridCode;
				    parent.getValue(rowData.code,jigouName,jigouManager,managerPhone,gridCode,gridName);
			      },
			    colNames:['', '字典主键','机构队伍名称','机构队伍负责人','联系电话','所属辖区'],
		        colModel:[
						{name:'gridCode',index:'gridCode',sortable:false, hidden:true},
						{name:'code',index:'code',sortable:false, hidden:true},
					{name:'jigouName',index:'jigouName',sortable:true, width:'20%', align:"left"},
		            {name:'jigouManager',index:'jigouManager',sortable:true, width:'20%', align:"left"},
		            {name:'managerPhone',index:'managerPhone',sortable:true, width:'20%', align:"left"},
		            {name:'seatGrid.gridTotalName',sortable:true, width:'20%', align:"left"},
		            ],
		            sortable:true, 
			        rownumbers:true,//添加左侧行号
			        altRows:true,//班玛线
			        sortname:'createDate',
			        sortorder:'desc',
			        viewrecords: true,//是否在浏览导航栏显示记录总数
			        rowNum:5,//每页显示记录数
			        showRowList:false,
 			        multiselect: false,  
			        rownumbers:true,//添加左侧行号
			        jsonReader:{
			            id: "code",//设置返回参数中，表格ID的名字为CODE
			            repeatitems : false
			        },
			        pager:$('#grid-pager'),
		            caption: "机构信息"
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
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
		</div>
	</div>
</div>
</body>
</html>


