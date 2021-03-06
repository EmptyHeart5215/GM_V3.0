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
			 	url : "${base }/base/pertsjiaozheng/queryManage",
		        defaultCaozuo:false,
		        ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
			    	  var rowData = $('#grid-table').jqGrid("getRowData",code);
			    	  bootbox.dialog({
							 url:"${base}/base/person/infoSee?personCode="+rowData.personCode+"&personType=jingNei",
							  title: "人口信息采集表",
							  style:'width:1000px;height:600px;',
							  showFunctionBtn:false
							});
			      },
		        colNames:[ '', '','所属辖区','楼栋','单元','房屋','身份证号','姓名','性别','矫正人员编号','矫正类别','案件类别','具体罪名'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'personCode',index:'personCode',sortable:false, hidden:true},
					{name:'gridTotalName',index:'gridTotalName',sortable:false, width:'18%'},
					{name:'person.buildName',sortable:false, width:'10%'},
					{name:'person.unitName',sortable:false, width:'5%'},
					{name:'person.houseNum',sortable:false, width:'5%'},
					{name:'person.cid',index:'code',sortable:false, width:'10%'},
					{name:'person.name',index:'code',sortable:false, width:'7%'},
					{name:'person.sex',index:'code',sortable:false, width:'5%'},
					{name:'rectifyNum',index:'rectifyNum',sortable:true, width:'5%'},
					{name:'dicValueMap.codeRectifyType',sortable:false, width:'15%'},
		            {name:'dicValueMap.codeAnJianType',sortable:false, width:'15%'},
		            {name:'zuiMing',sortable:false, width:'15%'}
		        ],
		        sortname:'gridTotalName',
		        sortorder:'asc',
		        multiselect: false,
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "社区矫正人群管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
			var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
			$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
			$("[name='codeRectifyType']").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_RECTIFY_TYPE',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			resetId:'redo',
				checkBox:true
			});
			$("[name='codeAnJianType']").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_AN_JIAN_TYPE',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			resetId:'redo',
			checkBox:true
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
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						社区矫正人群管理
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
												<div class="search-group">
													<label class="col-xs-2 col-myxs-15 control-label text-right" >辖区</label>
													<input name="gridCode" type="text" class="text col-xs-2" >
													<label class="col-xs-2 col-myxs-15 control-label text-right">楼栋 </label>
													<input name="buildName" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 col-myxs-15 control-label text-right">单元</label>
													<input name="unitName" type="text" class="text col-xs-2"  >
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
											<td >
												<div class="search-group">
													<label class="col-xs-2 col-myxs-15 control-label text-right" >房屋号</label>
													<input name="houseNum" type="text" class="text col-xs-2" >
													<label class="col-xs-2 col-myxs-15 control-label text-right" >姓名</label>
													<input name="name" type="text" class="text col-xs-2" >
													<label class="col-xs-2 col-myxs-15 control-label text-right">性别 </label>
													<select name="sex" class=" myselect col-xs-2 ">
														<option value="">请选择</option>
														<option value="男">男</option>
														<option value="女">女</option>
													</select>
												</div>
											</td>
										</tr>
										<tr>
											<td >
												<div class="search-group">
												<label class="col-xs-2 col-myxs-15 control-label text-right" >矫正人员编号</label>
													<input name="rectifyNum" type="text" class="text col-xs-2" >
													<label class="col-xs-2 col-myxs-15 control-label text-right" >矫正类别</label>
													<input name="codeRectifyType" type="text" class="text col-xs-2" >
													<label class="col-xs-2 col-myxs-15 control-label text-right" >案件类别</label>
													<input type="text"  name="codeAnJianType" class="col-xs-2 " />
													
												</div>
											</td>
										</tr>
										<tr>
											<td >
												<div class="search-group">
												<label class="col-xs-2 col-myxs-15 control-label text-right">具体罪名 </label>
													<input type="text" max-length="50"id="zuiMing" name="zuiMing" class="col-xs-2 " />
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


