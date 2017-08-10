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
			 	url : "${base }/base/person/queryByParamPage?gridCode="+'${vdata.gridCode}',
			 	defaultCaozuo:false,
			 	ondblClickRow:function(rowid,iRow,iCol,e){
			 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
			 		var personCode = rowData.code;
			 		var name = rowData.name;
			 		var sex =rowData.sex;
			 		var cid =rowData.cid;
			 		var codeNation =rowData.codeNation;
			 		var codeEducation =rowData.codeEducation;
			 		var codePolitical =rowData.codePolitical;
			 		 if(sex == '<font color="red">男</font>'){
			 			 sex = '男';
			 		 }else if(sex == '<font color="green">女</font>'){
			 			sex = '女';
			 		 }
			 		 var position = rowData.position;
			 		$.ajax({
						type : "post",
						url : "${base}/partybuilding/allparty/compareSameUser?personCode="+personCode+"&t="+Math.random(),
						dataType : 'json',
						async : false,
						success : function(data) {
				            if(data.status){
				            	parent.getValue(personCode,name,sex,cid,codeNation,codeEducation,codePolitical,position);
				            }else{ 
				            	bootbox.slideAlert('body',false,data.info);
				             } 
						}
					});
			      },
		        colNames:['主键', '姓名','性别','身份证号','民族','文化程度','政治面貌',''],
		        colModel:[
						{name:'code',index:'code',sortable:false, hidden:true},
						{name:'name',index:'name',sortable:false,width:'10%'},
						{name:'sex',index:'sex',sortable:true, width:'10%', align:"center",formatter:
			            	function(cellvalue, options, rowObject){
			            		var sex =rowObject['sex'];
			            		if(sex == '男'){
			            			return '<font color="red">男</font>';
			            		}else if(sex == '女'){
			            			return '<font color="green">女</font>';
			            		}
	        	    	     }
			            },
			            {name:'cid',index:'cid',sortable:false,width:'20%'},
			            {name:'codeNation',index:'codeNation',sortable:false, hidden:true},
			            {name:'codeEducation',index:'codeEducation',sortable:false, hidden:true},
			            {name:'codePolitical',index:'codePolitical',sortable:false, hidden:true},
			            {name:'position',index:'position',sortable:false, hidden:true,formatter:
			            	function(cellvalue, options, rowObject){
			            		var building =rowObject['building'];
			            		building = building.position;
			            		return building;
			            	}
			            }
		           ],
		           sortable:true,
			        rownumbers:true,//添加左侧行号
			        altRows:true,//班玛线
			        sortname:'createDate',
			        sortorder:'desc',
			        viewrecords: true,//是否在浏览导航栏显示记录总数
			        rowNum:5,//每页显示记录数
			        rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
			        multiselect: true,
			        rownumbers:true,//添加左侧行号
			        jsonReader:{
			            id: "code",//设置返回参数中，表格ID的名字为CODE
			            repeatitems : false
			        },
			        pager:$('#grid-pager'),
		            caption: "人员信息"
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


