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
				 url:"${base}/eventfile/efcontradict/addLoad",
				  title: "矛盾纠纷",
				  iframeStyle:"height:800px;",
				  style:'width:800px;height:520px;'
				});
		};
		
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/eventfile/efcontradict/modifyLoad?code="+code,
				  title: "矛盾纠纷",
				  iframeStyle:"height:800px;",
				  style:'width:800px;height:600px;'
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
							url : "${base}/eventfile/efcontradict/delete?codes="+code,			
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
			 	url : "${base }/eventfile/efcontradict/queryManage",
			 	ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
			    	  
			    	  bootbox.dialog({
							 url:"${base}/eventfile/efcontradict/detailLoad?eventCode="+rowid+"&stepId=1&entryId=1",
							  title: "矛盾纠纷详细信息表",
							  iframeStyle:'height:1200px;',
							  style:'width:1000px;height:600px;',
							  showFunctionBtn:false,
							});
			      },
			      colNames:['序号', '所属辖区', '矛盾纠纷级别','矛盾排查时间','督办单位','督办人','收集人','负责人','问题化解情况','dutt'],
			        colModel:[
								{name:'code',index:'code',sortable:false, hidden:true},
								{name:'gridCode',index:'gridCode',sortable:true, width:'15%',align:'left',
									formatter:
									function(cellvalue, options, rowObject){
				            		var gridCode =rowObject['seatGrid'];
				            		gridCode = gridCode.gridTotalName;
				            		return gridCode;
				        	    }},
					            {name:'codeEventType',index:'codeEventType',sortable:true, width:'5%', align:"center"},
					            {name:'contradictionsDate',index:'contradictionsDate',sortable:true, width:'5%', align:"center"},
					            {name:'supervisionDuty',index:'supervisionDuty',sortable:true, width:'10%', align:"center"},
					            {name:'supervisionPerson',index:'supervisionPerson',sortable:true, width:'10%', align:"center"},
					            {name:'takeName',index:'takeName',sortable:true, width:'10%', align:"center"},
					            {name:'problemName',index:'problemName',sortable:true, width:'10%', align:"center"},
					            {name:'problemResolution',index:'problemResolution',sortable:true, width:'10%', align:"center"},
					            {name:'position',index:'position',sortable:true, width:'10%', align:"center",hidden:true},
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
		       
		        caption: "矛盾纠纷管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name=gridCode]").ztreeGrid({
				url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
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
						查询条件
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
													<label class="col-xs-2 control-label text-right">所属辖区</label>
													<input name="gridCode" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">矛盾纠纷类别</label>
													<input name="codeEventType" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">收集人</label>
													<input name="takeName" type="text" class="text col-xs-2"  >
													
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
															<label class="col-xs-2  control-label text-right">稳控负责人</label>
															<input name="stabilityName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">问题处理责任人</label>
															<input name="problemName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">矛盾排查时间</label>
															<div class="col-xs-2 input-group" style="padding-right: 0;padding-left: 0;">
													<input  name="contradictionsDate" type="text" class="form-control date-picker tooltip-error required" searchType="like" >
													   <span class="input-group-addon">
							                             <i class="icon-calendar bigger-110"></i>
						                               </span>
															
														</div>
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
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridImport.js"></script>
</body>
</html>


