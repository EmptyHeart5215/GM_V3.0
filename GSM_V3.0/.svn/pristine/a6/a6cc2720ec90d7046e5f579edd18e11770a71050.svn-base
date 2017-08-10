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
			var dialog=bootbox.dialog({
				 url:"${base}/base/house/addLoad",
				  title: "新增房屋",
				  style:'width:800px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/yanpanfenxi/housechaxun/modifyLoad?code="+code,
				  title: "房屋修改",
				  style:'width:800px;height:520px;'
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
							url : "${base}/yanpanfenxi/housechaxun/delete?codes="+code,			
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
		var addValue=function(code,nameDic) {
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
					 url:"${base}/yanpanfenxi/housechaxun/manageLoad?sysDicCode=" + code,
					  title: "编辑 "+nameDic+" 房屋值",
					  style:'width:80%;height:600px',
					  iframeStyle:'height:500px;',
					  showFunctionBtn:false
					});
				}else{
					bootbox.alert("请刷新重试！");
			}
			
		}
	$(function(){
		 $("#grid-table").jqGrid({
			 	url : "${base }/yanpanfenxi/housechaxun/zongheManage",
			 	ondblClickRow:function(rowid,iRow,iCol,e){
				    bootbox.dialog({
						url:"${base}/base/house/infoSee?code="+rowid,
						title: "信息采集表",
						style:'width:900px;height:500px;',
						showFunctionBtn:false,
						});
			      },
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:false,
		        colNames:[ '主键', '所属辖区','楼栋','单元','房间号','建筑面积','户型','建成年份','产权人姓名','产权人身份证号'/* '产权人住址', '产权人电话','工作单位'*/],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					 {name:'gridTotalName',index:'gridTotalName', width:'20%'},
			         {name:'buildName',index:'buildName', width:'10%'},
			          {name:'unitName',index:'unitName', width:'10%'},
			          {name:'houseNum',index:'houseNum', width:'10%'},
		            {name:'houseArea',index:'houseArea', width:'10%'},
		            {name:'codeHouseLayout',index:'codeHouseLayout', width:'5%'},
		            {name:'buildYear',index:'buildYear', width:'5%'},
		            {name:'houseOwnerName',index:'houseOwnerName', width:'5%'},
		            {name:'useCardNumber',index:'useCardNumber', width:'10%'}
		           /*  {name:'houseOwnerNowAddress',index:'houseOwnerNowAddress', width:'20%'},
		            {name:'houseOwnerPhone',index:'houseOwnerPhone', width:'5%'},
		            {name:'useWork',index:'useWork', width:'5%'} */
		             
		        ],
		        sortable:false,
		        rownumbers:true,//添加左侧行号
		        altRows:true,//班玛线
		        sortname:'code',
		        sortorder:'desc',
		        viewrecords: true,//是否在浏览导航栏显示记录总数
		        rowNum:10,//每页显示记录数
		        rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
		        multiselect: false,
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "房屋管理列表"
		    });
		//搜索按钮方法
		 $("#search").click(function(){
// 				var postData=$("#search_form").serializeJson();
// 				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
				var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
		});
		 $("#reset").click(function(){
				$('#search_form')[0].reset();
			});
		 $("[name='gridCode']").ztreeGrid({
			 	url: '${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),
				name:"name",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo'
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
						房屋查询
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
													<label class="col-xs-2 control-label text-right">楼栋</label>
													<input name="buildCode" type="text" class="text col-xs-2"  >
													<label class="col-xs-2  control-label text-right">单元</label>
													<input name="unitCode" type="text" class="text col-xs-2"  >
													
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
															<label class="col-xs-2  control-label text-right">房间号</label>
															<input name="houseNum" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">产权人</label>
															<input name="houseOwnerName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2 control-label text-right">使用人</label>
															<input name="useName" type="text" class="text col-xs-2"  >
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">房产证号 </label>
															<input name="housePropertyNum" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">土地证号</label>
															<input name="houseLandNum" type="text" class="text col-xs-2"  >
															
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


