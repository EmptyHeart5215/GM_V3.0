<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
		<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
		<script type="text/javascript">
		//添加按钮方法，方法名固定，不可改变
		var addFun=function(){
			var dialog=bootbox.dialog({
				 url:"${base}/base/broadconvenient/addLoad",
				  title: "护路护线添加",
				  iframeStyle:"height:500px;",
				  style:'width:900px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/base/broadconvenient/modifyLoad?code="+code,
				  title: "护路护线修改",
				  iframeStyle:"height:500px;",
				  style:'width:900px;height:520px;'
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
							url : "${base}/base/broadconvenient/delete?codes="+code,			
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
		 	url : "${base }/base/broadconvenient/queryManage",
		      ondblClickRow:function(rowid,iRow,iCol,e){
				    bootbox.dialog({
						url:"${base}/base/broadconvenient/infoSee?code="+rowid,
						title: "护路护线信息详情",
						iframeStyle:"height:580px;",
						style:'width:950px;height:500px;',
						showFunctionBtn:false,
						});
			      },
		      
	        colNames:[ '主键', '所属辖区','名称','线路类型',
	                   '隶属单位','隶属单位负责人','管辖单位','安全隐患等级'
	                   ],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
	            {name:'seatGrid.gridTotalName',index:'gridCode',sortable:true, width:'25%',align:'center'},
	            {name:'name',index:'name',sortable:true, width:'15%', align:"center"},
	            {name:'dicValueMap.codeLineType',index:'codeLineType',sortable:true, width:'15%', align:"center"},
	            {name:'unitName',index:'unitName',sortable:true, width:'15%',align:'center'},
	            {name:'unitManager',index:'unitManager',sortable:true, width:'15%', align:"center"},
	            {name:'controlUnitName',index:'controlUnitName',sortable:true, width:'15%', align:"center"},
	            {name:'dicValueMap.codeSecurityLevel',index:'codeSecurityLevel',sortable:true, width:'15%', align:"center",formatter:
	            	function(cellvalue, options, rowObject){
            		var codeSecurityLevel =rowObject['codeSecurityLevel'];
            		if(codeSecurityLevel == '40569DE6DB0945C8A04CA4787ADCEE72'){
            			return '<font color="red">高</font>';
            		}else if(codeSecurityLevel == '60096A49CD014759A249420A3822A63D'){
            			return '<font color="orange">中</font>';
            		}else if(codeSecurityLevel == '2DF66EAE63FF4A94ACA841551C23B048'){
            			return '<font color="blue">低</font>';
            		}else if(codeSecurityLevel == null){
        				return '<font color="pink">未填写</font>';
        			}
	    	     }
            }
// 	            seatGrid.gridTotalName
   
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
	        caption: "护路护线管理列表"
	    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name=gridCode]").ztreeGrid({
				url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
			});
		 $("[name=codeLineType]").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_LINE_TYPE',
				name:"dicValue",
				pIdKey:"parentCode"
			});
		 $("[name=codeSecurityLevel]").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SECURITY_LEVEL',
				name:"dicValue",
				pIdKey:"parentCode"
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
.div-height{width:197px; height:29px}
</style>
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						护路护线管理
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
													<input type="text"id="gridCode" name="gridCode"  class="text col-xs-2" />
													<label class="col-xs-2 control-label text-right">线路类型</label>
													<input name="codeLineType" type="text" class="text col-xs-2"  >
													<label class="col-xs-2 control-label text-right">治安安全等级</label>
													<input name="codeSecurityLevel" type="text" class="text col-xs-2"  >
													
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


