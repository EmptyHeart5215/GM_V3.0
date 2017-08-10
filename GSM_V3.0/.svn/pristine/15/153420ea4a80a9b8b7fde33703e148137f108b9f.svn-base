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
				url:"${base}/base/bjigoupeople/addLoad?personCode="+ '${personCode}',
				 title: "添加",
// 				 iframeStyle:"height:300px;",
				  style:'width:600px;height:300px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
					url:"${base}/base/bjigoupeople/modifyLoad?code="+code,
					  title: "修改",
// 					  iframeStyle:"height:300px;",
				  style:'width:600px;height:300px;'
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
							url : "${base}/base/bjigoupeople/delete?codes="+code,		
							dataType : 'json',
							async : false,
							success : function(data) {
								bootbox.slideAlert('body',data.status,data.info);
								if(data.status){
									$("#grid-table").trigger("reloadGrid"); 	  								}
							}
						}); 
				}
			});
		};
	$(function(){
		 $("#grid-table").jqGrid({
			 	url : "${base }/base/bjigoupeople/queryManage?personCode="+'${personCode}',
			 	colNames:[ '字典主键','姓名','性别','电话','现住址'],
			 	colModel:[
						{name:'code',index:'code',sortable:false, hidden:true},
						{name:'name',index:'name',sortable:true, width:'8%', align:"center"},
						 {name:'sex',index:'sex',sortable:true, width:'8%', align:"center"},
			            /* {name:'sex',index:'sex',sortable:true, width:'8%', align:"center",formatter:
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
						}, */
			            {name:'phone',index:'phone',sortable:true, width:'8%', align:"center"},
			            {name:'address',index:'address',sortable:true, width:'30%', align:"left"},
			            ],
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
		        caption: "成员列表"
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
				<div class="widget-body">
					<div class="widget-body-inner" style="display: none;">
							<div id="sales-charts" style="padding: 0px; width: 100%; height: auto; position: relative;">
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


