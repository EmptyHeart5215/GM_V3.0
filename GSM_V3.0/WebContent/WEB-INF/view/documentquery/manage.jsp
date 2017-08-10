	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include  page="/resource/base_import.jsp"/>
<%-- <jsp:include  page="/resource/res.html"/> --%>
<script type="text/javascript">	


	var addFun=function(){
			var dialog=bootbox.dialog({
				 url:"${base }/documentquery/document/addLoad",
				  title: "添加文件",
				  style:'width:800px;height:520px;'
			});
	};   
	
	function editFun(code){
		if(code&&""!=$.trim(code)){
			var dialog=bootbox.dialog({
			 url:"${base }/documentquery/document/modifyLoad?code="+code,
			  title: "修改文件",
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
			 var codes=$('#grid-table').jqGrid('getGridParam', "selarrrow");
			 var flag=0;
			 var alertStr="对不起您没有删除文件";
			 for(var i=0;i<codes.length;i++){
				 var rowData = $("#grid-table").jqGrid("getRowData", codes[i]);
				 if(rowData['createBy']!="${loginCode}"){
					 alertStr+='“'+rowData['documentName']+'”,';
					flag=1;
				 }
			 }
			if(flag==1){
				bootbox.alert(alertStr.substr(0,alertStr.length-1)+"的权限！");
				 return;
			}
	 	bootbox.confirm('确定删除吗？',function(result){
			if(result){
				 $.ajax({
						type : "post",
						url : "${base}/documentquery/document/delete?codes="+code,			
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
		$("[name=codeDocumnetType]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_DOCUMNET_TYPE',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			resetId:'reset'
		});
		//如果子页面需要进行图片浏览，必须加上这句-------------
		layer.use('extend/layer.ext.js', function(){
			   layer.ext =function(){};
		}); 
		 $("#grid-table").jqGrid({
			 	url : "${base }/documentquery/document/queryManage",
			 	ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
			    	  bootbox.dialog({
							 url:"${base}/documentquery/document/infoSee?code="+rowid,
							  title: "详细信息表",
							  style:'width:1000px;height:600px;'
							});
			      },
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:false,
		        colNames:[ '主键','所属辖区或部门', '文件名','文件类型','文件大小','上传时间','','操作'/* ,'上传人' */],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					 {name:'gridTotalName',index:'gridTotalName',sortable:true, width:'10%',align:'center'},
					 {name:'documentName',index:'documentName',sortable:true, width:'10%',align:'center'},
		            {name:'dicValueMap.codeDocumnetType',index:'codeDocumnetType',sortable:true, width:'10%',align:'center'},
		            {name:'documentSize',index:'documentSize',sortable:true, width:'10%', align:"center"},
		            {name:'createDate',index:'createDate',sortable:true, width:'10%', align:"center"} ,
		            {name:'createBy',index:'createBy',sortable:true, width:'10%', align:"center",hidden:true},
		            {name:'caozuo',width:80,fixed:true, sortable:false,resize:false,formatter:
		            	function(cellvalue, options, rowObject){
		            	var code=rowObject['code'];
		            	var createBy=rowObject['createBy'];
		            	var loginCode="${loginCode}";
		            	if(createBy==loginCode){
		            		var div='<div style="margin-left:8px;">';
			            	div+="<div class='ui-pg-div ui-inline-edit'title='编辑' style='float:left;cursor:pointer;' onclick='editFun(\""+code+"\")'>";
				            	div+='<span class="ui-icon ui-icon-pencil"></span>';
		            			div+="</div>";
	            				div+="<div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\")'>";
	            				div+='<span class="ui-icon ui-icon-trash"></span>';
	           					div+='</div>';
	           					div+='</div>';
			            		return div;
		            	}
		            	else{
		            		return '';
		            	}
		            }
		          } 
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
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "文件管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("#reset").click(function() {
				$('#search_form')[0].reset();
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
									<table style="width:100%;" >
										<tr>
											<td>
												<div class="search-group">					
														<label class="col-xs-2 col-myxs-2 control-label text-right" >文件名称</label>
														<input name="documentName"  type="text" class="text col-xs-2" >
														<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeDocumnetType"><span class="red">*</span>文件类型</label>
														<div class="col-xs-3">
															<input type="text"id="codeDocumnetType" name="codeDocumnetType" value="${vdata.DocumentQuery.codeDocumnetType }" class="col-xs-5 col-sm-5 tooltip-error required" />
														</div>
												</div>	
											</td>	
											<td >
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


