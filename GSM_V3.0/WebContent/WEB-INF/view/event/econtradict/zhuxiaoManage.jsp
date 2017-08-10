<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
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
							url : "${base}/event/econtradict/delete?codes="+code,			
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
			 	url : "${base }/event/econtradict/wanJieManage",
		      defaultCaozuo:false,
		      multiselect:false,
		      ondblClickRow:function(rowid,iRow,iCol,e){
		    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
		    	  var rowData = $('#grid-table').jqGrid("getRowData",code);
		    	   bootbox.dialog({
						 url:"${base}/event/econtradict/detailLoad?eventCode="+code+"&stepId="+rowData['step.stepId']+"&entryId="+ rowData['step.entryId'],
						  title: "事件处理表",
						  iframeStyle:'height:1500px;',
						  style:'width:1000px;height:600px;',
						  showFunctionBtn:false
						}); 
		    	   
		      },
		        colNames:['序号', '','','受理编号','所属辖区','矛盾主题','当事人','事件登记人','事件登记时间','完结时间','办理类型','事件详情'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'step.stepId',sortable:false, hidden:true},
					{name:'step.entryId',sortable:false, hidden:true},
					{name:'eventNum',index:'eventNum',sortable:true, width:100,fixed:true},
		            {name:'gridTotalName',index:'gridTotalName',sortable:true, width:'20%'},
		            {name:'eventTitle',index:'eventTitle',sortable:false, width:'15%'},
		            {name:'dangShiRenName',index:'dangShiRenName',sortable:false, width:'5%'},
		            {name:'createName',index:'createName',sortable:false, width:'10%'},
		            {name:'createDate',index:'createDateStr',sortable:false, width:'10%'},
		            {name:'banLiDate',sortable:false, width:'10%'},
		            {name:'banLiTypeStr',sortable:false, width:'10%'},
		            {name:'description',index:'description',sortable:true, width:'15%'}
		           /* ,
		            {name:'caozuo',width:50,fixed:true, sortable:false, resize:false,formatter:
		            	function(cellvalue, options, rowObject){
		            	var code=rowObject['code'];
		            	var div='<div style="margin-left:8px;">';
		            	div+="<div class='ui-pg-div ui-inline-edit'title='删除' style='float:left;cursor:pointer;' onclick='deleteFun(\""+code+"\")'>";
			            	div+='<span class="ui-icon ui-icon-trash   "></span>';
	            			div+="</div>";
           					div+='</div>';
		            		return div;
		            	}
		            }  */
		        ],
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "矛盾已完结列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name='codeEventType']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_TYPE',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo',
				checkBox:true
				});

		 $("[name='gridCode']").ztreeGrid({
			 	url: '${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),
				name:"name",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo'
				});

	 });
	
</script>
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
													<label class="col-xs-2 control-label text-right">所属辖区 </label>
													<input name="gridCode" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">矛盾主题</label>
													<input name="eventTitle" type="text" class="text col-xs-2"  >
													<label class="col-xs-2  control-label text-right">矛盾类型</label>
													<input name="codeEventType" type="text" class="text col-xs-2"  >
												</div>
											</td>
											
											<td style="width:100px;" rowspan="3">
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
															<label class="col-xs-2  control-label text-right">当事人</label>
															<input name="dangShiRenName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">登记时间</label>
															<div class="input-group" style="width:50%;float: left;" >
																<input class="col-xs-12 col-sm-12 form-control date-range-picker"name="createDate" type="text"/>
																<span class="input-group-addon">
																	<i class="icon-calendar bigger-110"></i>
																</span>
															</div>
															
															
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">登记人</label>
															<input name="createName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">完结时间</label>
															<div class="input-group" style="width:50%;float: left;" >
																<input class="col-xs-12 col-sm-12 form-control date-range-picker"name="finishDate" type="text"/>
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
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridOnlyFreshImport.js"></script>
</body>
</html>


