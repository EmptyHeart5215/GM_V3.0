<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/event/econtradict/editDraftLoad?code="+code,
				  title: "事件处理表",
				  style:'width:1000px;height:600px;',
				  showFunctionBtn:false
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
							url : "${base}/base/fields/delete?codes="+code,			
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
	/*	var addValue=function(code,nameParty) {
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
					 url:"${base}/party/partyallvalue/manageLoad?code=" + code,
					  title: "编辑 "+nameParty+" 资料",
					  style:'width:80%;height:600px',
					  iframeStyle:'height:500px;',
					  showFunctionBtn:false
					});
				}else{
					bootbox.alert("请刷新重试！");
			}
			
		}*/
	$(function(){
		 $("#grid-table").jqGrid({
			 	url : "${base }/event/econtradict/draftManage",
		      defaultCaozuo:false,
		      multiselect:true,
		      ondblClickRow:function(rowid,iRow,iCol,e){
		    	  var row=$('#grid-table').jqGrid('getGridParam', "selrow");
		    	  var rowData = $('#grid-table').jqGrid("getRowData",row);
		    	  editFun(rowData);
		      },
		        colNames:['序号',  '所属辖区','当事人','矛盾主题','矛盾类型','上报来源','创建时间','操作'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'gridTotalName',index:'gridTotalName', width:'30%'},
		            {name:'dangShiRenName',index:'dangShiRenName', width:'8%'},
		            {name:'eventTitle',index:'eventTitle', width:'15%'},
		            {name:'dicValueMap.codeEventType',index:'eventTypeStr', width:'12%'},
		            {name:'dicValueMap.codeEventFrom',index:'eventFromStr', width:'12%'},
		          
		            {name:'createDate', width:'12%'},
		            {name:'caozuo',width:70,fixed:true, sortable:false, resize:false,formatter:
		            	function(cellvalue, options, rowObject){
		            	var code=rowObject['code'];
		            	var div='<div style="margin-left:8px;">';
		            	div+="<div class='ui-pg-div ui-inline-edit'title='编辑' style='float:left;cursor:pointer;' onclick='editFun(\""+code+"\")'>";
			            	div+='<span class="ui-icon ui-icon-pencil"></span>';
	            			div+="</div> <div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\")'>";
            				div+='<span class="ui-icon ui-icon-trash"></span>';
           					div+='</div>';
           					div+='</div>';
		            		return div;
		            	}
		            } 
		        ],
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "矛盾草稿列表",
		        sortname:'createDate',
		        sortorder:'desc'
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
			 var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name='codeEventFrom']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_FROM',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo',
				checkBox:true
				});
		 $("[name='codeEventType']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_TYPE',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo',
				checkBox:true
				});

	/* 	 $("[name='gridCode']").ztreeGrid({
			 	url: '${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),
				name:"name",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo'
				}); */

	 });
	//在提交或者修改单条信息成功后的调用方法，用于子页面调用
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
												<label class="col-xs-2 control-label text-right">矛盾主题</label>
															<input name="eventTitle" type="text" class="text col-xs-2"  >
												<!-- 	<label class="col-xs-2 control-label text-right">所属辖区 </label>
													<input name="gridCode" type="text" class="text col-xs-2"  > -->
													<label class="col-xs-2  control-label text-right">当事人</label>
													<input name="dangShiRenName" type="text" class="text col-xs-2"  >
													<label class="col-xs-2  control-label text-right">矛盾类型</label>
													<input name="codeEventType" type="text" class="text col-xs-2"  >
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
															
															<label class="col-xs-2  control-label text-right">上报来源</label>
															<input name="codeEventFrom" type="text" class="text col-xs-2"  >
															<label class="col-xs-2 control-label text-right">创建时间</label>
															<div class="input-group" style="width:50%;float: left;" >
																<input class="col-xs-12 col-sm-12 form-control date-range-picker"name="createDate" type="text"/>
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
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridFreshAndDeleteImport.js"></script>
</body>
</html>


