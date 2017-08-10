	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<style>
		/* .ui-icon-seek-prev { background-position: -48px -160px; } */
		/* .modal-title{
			display: inline;
			line-height: 36px;
			margin: 0;
			padding: 0;
		} */
		</style>
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
//添加按钮方法，方法名固定，不可改变
var addFun=function(){
	bootbox.dialog({
		 url:"${base}/thing/thinglog/addLoad",
		  title: "民情日志",
		  style:'width:1000px;height:600px;'
		});
};

//编辑按钮方法，方法名固定，不可改变
function editFun(code){
	if(code&&""!=$.trim(code)){
		var dialog=bootbox.dialog({
			 url:"${base}/thing/thinglog/modifyLoad?code="+code,
			  title: "民情日志",
			  style:'width:1000px;height:600px;'
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
					url : "${base}/thing/thinglog/delete?codes="+code,			
					dataType : 'json',
					async : false,
					success : function(data) {
						bootbox.slideAlert('body',data.status,data.info);
						if(data.status){
							jQuery("#grid-table").trigger("reloadGrid"); 	    
						}
					}
				}); 
		}
	}); 
};
	$(function(){
		$("[name=gridCode]").ztreeGrid({
			url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
		});
		 $("#grid-table").jqGrid({
			 	url:"${base }/thing/thinglog/queryManage",
			 	datatype:"json", //数据来源，本地数据
			 	mtype:"POST",//提交方式
			 	ondblClickRow:function(rowid,iRow,iCol,e){
				    bootbox.dialog({
						url:"${base}/thing/thinglog/infoSee?code="+rowid,
						title: "日志信息采集表",
						style:'width:1000px;height:600px;',
						showFunctionBtn:false,
						});
			      },
		        colNames:['','','','所属辖区', '网格员姓名  ','走访日期 ','走访户数 ','问题总数 ','自行解决件数','上报指挥中心件数','走访时间','门牌和户主','填报设备'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'totalHour',index:'totalHour',sortable:false, hidden:true},
					{name:'totalMinute',index:'totalMinute',sortable:false, hidden:true},
					{name:'gridCode',index:'gridCode',sortable:false, width:'45%',formatter:
						function(cellvalue, options, rowObject){
		            		var gridCode =rowObject['seatGrid'];
		            		gridCode = gridCode.gridTotalName;
		            		return gridCode;
	            	    }
					},
		            {name:'gridName',index:'gridName',sortable:false, width:'18%'},
		            {name:'createDate',index:'createDate',sortable:false, width:'20%',formatter:
		            	function(cellvalue, options, rowObject){
		            		var createDate =rowObject['createDate'];
		            		createDate = createDate.substr(0,10);
		            		return createDate;
		            	}
		            },
		            {name:'falimyCount',index:'falimyCount', width:'16%', sortable:false},
		            {name:'questionCount', index:'questionCount',sortable:false, width:'18%'},
		            {name:'interviewAuto', index:'interviewAuto',sortable:true, width:'18%'},
		            {name:'interviewUp', index:'interviewUp',sortable:true, width:'24%'},
		            {name:'totalTime', index:'totalTime',sortable:true, width:18,formatter:
		            	function(cellvalue, options, rowObject){
		            		var totalHour =rowObject['totalHour'];
		            		var totalMinute =rowObject['totalMinute'];
		            		var totalTime = totalHour+"小时"+totalMinute+"分钟"
		            		return totalTime;
		                }
		            },
		            {name:'falimyDetails', index:'falimyDetails',sortable:true, width:40},
		            {name:'logType', index:'logType',sortable:false, width:'12%',formatter:
		            	function(cellvalue, options, rowObject){
		            		var logType =rowObject['logType'];
		            		if(logType == '0'){
		            			return '手机设备填报'
		            		}else if(logType == '1'){
		            			return 'PC设备填报'
		            		}
		            	}
		            },
		        ],
		        sortable:false,
		        altRows:true,//班玛线
		        sortname:'createDate',
		        sortorder:'desc',
		        viewrecords: true,//是否在浏览导航栏显示记录总数
		        rowNum:10,//每页显示记录数
		        rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
		        multiselect: true,
		        rownumbers:true,//添加左侧行号
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "民情日志管理列表"
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
	function getValue(value){
		var searchStartTime = $("#searchStartTime").val();
		//var createDateEndTime = $("#createDateEndTime").val();
		if(value<searchStartTime){
			bootbox.alert("结束时间不能小于开始时间");
		}
		
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
								  <input type="hidden" id="createDate" name="createDate" />
									<table style="width:100%;">
										<tr>
											<td width="9%" style="text-align: center;">
											   所属辖区
											</td>
											 <td width="16%">
											   <input name="gridCode" type="text" class="text col-xs-12"/>
											 </td>
											 <td width="9%" style="text-align: center;">
											  查巡走访时间
											 </td>
											 <td width="16%">
												<div class="col-xs-12 input-group">
													<input class="form-control date-picker" id="searchStartTime" name="searchStartTime"  type="text">
													<span class="input-group-addon">
														<i class="icon-calendar bigger-110"></i>
													</span>
												</div>
											 </td>
											 <td width="16%">
												<div class="col-xs-12 input-group">
													<input class="form-control date-picker" id="searchEndTime" name="searchEndTime" type="text" onchange="getValue(this.value)">
													<span class="input-group-addon">
														<i class="icon-calendar bigger-110"></i>
													</span>
												</div>
											 </td>
											<td>
												
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
