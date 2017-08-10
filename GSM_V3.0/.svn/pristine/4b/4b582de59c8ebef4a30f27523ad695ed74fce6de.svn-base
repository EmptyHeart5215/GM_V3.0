	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include  page="/resource/base_import.jsp"/>
<script src="/gsm/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<%-- <jsp:include  page="/resource/res.html"/> --%>
<script type="text/javascript">	


	var addFun=function(){
			var dialog=bootbox.dialog({
				 url:"${base }/partybuilding/borganizationallife/addLoad",
				  title: "添加活动",
				  iframeStyle:"height:520px;",
				  style:'width:800px;height:520px;'
			});
	};   
	
	function editFun(code){
		if(code&&""!=$.trim(code)){
			var dialog=bootbox.dialog({
			 url:"${base }/partybuilding/borganizationallife/modifyLoad?code="+code,
			  title: "修改活动",
			  iframeStyle:"height:520px;",
			  style:'width:800px;height:520px;'
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
						url : "${base}/partybuilding/borganizationallife/delete?codes="+code,			
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
			 	url : "${base }/partybuilding/borganizationallife/queryManage",
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:true,
		        ondblClickRow:function(rowid,iRow,iCol,e){
				    bootbox.dialog({
						url:"${base}/partybuilding/borganizationallife/infoSee?code="+rowid,
						title: "党组织生活信息采集表",
						iframeStyle:"height:520px;",
						style:'width:800px;height:500px;',
						showFunctionBtn:false,
						});
			      },
		        colNames:[ '主键', '所属辖区','活动主题','活动地点','活动开始时间','活动结束时间'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
		            {name:'seatGrid.gridTotalName',index:'gridCode',sortable:true, width:'10%'},
		            {name:'titleName',index:'titleName',sortable:true, width:'10%'},
		            {name:'responsibleLocation',index:'responsibleLocation',sortable:true, width:'10%'},
		            {name:'beginTime',index:'beginTime',sortable:true, width:'10%'},
		            {name:'endTime',index:'endTime', width:'10%', sortable:false},
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
		        multiselect: true,
		        rownumbers:true,//添加左侧行号
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "活动管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
				if(postData.startDate){
					var time  = postData.startDate;
					var strs = time.split("~");
					$("#beginTime").val(strs[0]);
					$("#endTime").val(strs[1]);
				}
				var postData=$("#search_form").serializeJson();
				$("#grid-table").jqGrid('setGridParam',{loadComplete:null,postData:postData}).trigger("reloadGrid"); 
			});
		 
		 $("#reset").click(function(){
			 $("#beginTime").val("");
				$("#endTime").val("");
			});
		 
	 });
	
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
								  <input name="beginTime" id="beginTime" type="hidden"  class="text col-xs-12">
								  <input name="endTime" id="endTime" type="hidden"  class="text col-xs-12">
									<table style="width:100%;">
									  
										<tr height="28px;">
										  <td width="10%" style="text-align: center;">活动主题</td>
										  <td width="18%">
										    <div class="col-xs-12">
												<input name="titleName" id="titleName" type="text" class="text col-xs-12">
											</div>	
										  </td>
										  <td width="9%" style="text-align: center;">负责人/召集人</td>
										  <td width="22%">
										     <div class="col-xs-12">
												<input type="text" id="responsibleName" name="responsibleName" class="col-xs-12 col-sm-12" />
											</div>
										  </td>
										  <td rowspan="2">
										     <table style="width: 80%;float: right;">
										        <tr height="30px;">
										        	<td>
													   <button type="button" class="btn btn-info" id="search">查询
														  <i class="icon-search bigger-110 "></i>
													   </button>
										        	</td>
										        </tr>
										        <tr height="26px;">
										        	<td>
										        		<button type="reset" class="btn btn-info" id="reset">重置
															  <i class="glyphicon glyphicon-arrow-left bigger-110 "></i>
														</button>
										        	</td>
										        </tr>
										     </table>
										  </td>
										</tr>
										<tr height="28px;">
										  <td style="text-align: center;">党员参与人数</td>
										  <td>
										     <div class="col-xs-12">
												<input name="massesPersons" type="text" class="text col-xs-12"  >
							                 </div>
										  </td>
										  <td style="text-align: center;">活动开始结束时间</td>
										  <td>
										  	<div class="input-group" style="width:90%;float: right;" >
												<input class="col-xs-12 col-sm-12 form-control date-range-picker"name="startDate" type="text"/>
												<span class="input-group-addon">
													<i class="icon-calendar bigger-110"></i>
												</span>
											</div>
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


