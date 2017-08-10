	
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
		 url:"${base}/zongzhitraining/materialmanagements/addLoad",
		  title: "材料管理",
		  style:'width:800px;height:550px;'
		});
};

//编辑按钮方法，方法名固定，不可改变
function editFun(code){
	if(code&&""!=$.trim(code)){
		var dialog=bootbox.dialog({
			 url:"${base}/zongzhitraining/materialmanagements/modifyLoad?code="+code,
			  title: "材料管理",
			  style:'width:800px;height:550px;'
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
		 code=code+"";
	  }
	 bootbox.confirm('确定删除吗？',function(result){
		if(result){
			 $.ajax({
					type : "post",
					url : "${base}/zongzhitraining/materialmanagements/delete",
					data:{"codes":code},
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

function downloadCountAdd(code,downloadCount){
	
	downloadCount++;
	var data = "code="+code+"&downloadCount="+downloadCount;
	 $.ajax({
			type : "post",
			url : "${base}/zongzhitraining/materialmanagements/modify?t="+Math.random(),
			data : data,
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

var downloadfile = function(filecode,downloadCount,code,girdCode){
		var filecode = filecode.substring(0,(filecode.length)-1);
   	    window.location.href ='${base}/sys/sysupload/downLoad?code='+filecode;
   	    downloadCountAdd(code,downloadCount);
   	 	var data = "zongZhiMaterialCode="+code+"&gridCode="+girdCode;
   	 	$.ajax({
				type : "post",
				url : "${base}/zongzhitraining/effectmanagement/add?t="+Math.random(),
				data : data,
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

var seeFile = function(downloadCount,code,materialName,girdCode){
    	bootbox.dialog({
				 url:"${base}/zongzhitraining/materialmanagements/infoSee?code="+code,
				  title: "查看"+materialName+"内容",
				  style:'width:850px;height:550px;',
				  showFunctionBtn:false,
		});
    	downloadCountAdd(code,downloadCount);
    	 var data = "zongZhiMaterialCode="+code+"&gridCode="+girdCode;
    	 $.ajax({
 			type : "post",
 			url : "${base}/zongzhitraining/effectmanagement/add?t="+Math.random(),
 			data : data,
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
	$(function(){
		$("[name=codeUploadMaterialType]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_UPLOAD_MATERIAL_TYPE',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
		});
		//如果子页面需要进行图片浏览，必须加上这句-------------
		layer.use('extend/layer.ext.js', function(){
			   layer.ext =function(){};
		}); 
		 $("#grid-table").jqGrid({
			 	url:"${base }/zongzhitraining/materialmanagements/queryManage?remark=1",
			 	datatype:"json", //数据来源，本地数据
			 	mtype:"POST",//提交方式
			 	defaultCaozuo:false,
		        colNames:['','','','资料名称', '资料类型  ','上传资料类型 ','资料大小(MB)','（下载/查看）次数','文件上传时间','操作'],
		        colModel:[
                    {name:'code',index:'code',sortable:false, hidden:true},
                    {name:'materialFile',index:'materialFile',sortable:false, hidden:true},
                    {name:'girdCode',index:'girdCode',sortable:false,hidden:true},
					{name:'materialName',index:'materialName',sortable:false, width:'36%'},
		            {name:'codeMaterialType',index:'codeMaterialType',sortable:false, width:'25%',formatter:
		            	function(cellvalue, options, rowObject){
		            	    var codeMaterialType =rowObject['codeMaterialType'];
		            	    if(codeMaterialType == 0){
		            	    	return "手动编写";
		            	    }else if(codeMaterialType == 1){
		            	    	return "上传文件";
		            	    }
		                }
		            },
		            {name:'dicValueMap.codeUploadMaterialType',index:'codeUploadMaterialType',sortable:false, width:'35%'},
		            {name:'materialSize',index:'materialSize', width:'20%', sortable:false},
		            {name:'downloadCount', index:'downloadCount',sortable:false, width:20},
		            {name:'createDate', index:'createDate',sortable:true, width:40},
		            {name:'caozuo',width:95,fixed:true, sortable:false, resize:false,formatter:
		            	function(cellvalue, options, rowObject){
		            	    var code=rowObject['code'];
		            	    var fCode = rowObject['materialFile'];
		            	    var downloadCount = rowObject['downloadCount'];
		            	    var codeMaterialType = rowObject['codeMaterialType'];
		            	    var materialName = rowObject['materialName'];
		            	    var  girdCode = rowObject['girdCode'];
		            	    var div='<div style="margin-left:8px;">';
			            	div+="<div class='ui-pg-div ui-inline-edit'title='编辑' style='float:left;cursor:pointer;' onclick='editFun(\""+code+"\")'>";
				            	div+='<span class="ui-icon ui-icon-pencil"></span>';
				            	if(codeMaterialType == 0){
				            		div+="</div> <div id class='ui-pg-div ui-inline-del'title='查看' style='float:left;margin-left:5px;'onclick='seeFile(\""+downloadCount+"\",\""+code+"\",\""+materialName+"\",\""+girdCode+"\")'>";
		            				div+='<span id class="ui-icon icon-zoom-in  "></span>';
				            	}else if(codeMaterialType == 1){
				            		div+="</div> <div id class='ui-pg-div ui-inline-del'title='下载' style='float:left;margin-left:5px;'onclick='downloadfile(\""+fCode+"\",\""+downloadCount+"\",\""+code+"\",\""+girdCode+"\")'>";
		            				div+='<span id class="ui-icon icon-cloud-download  "></span>';
				            	}
	            				div+="</div> <div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\")'>";
	            				div+='<span class="ui-icon ui-icon-trash"></span>';
	           					div+='</div>';
	           					div+='</div>';
			            		return div;
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
		        rownumbers:true,//添加左侧行号
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "材料管理列表"
		    });
		//搜索按钮方法
		 $("#search").click(function(){
				var postData=$("#search_form").serializeJson();
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
		});
		 $("#reset").click(function(){
				$('#search_form')[0].reset();
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
									<table style="width:100%;">
										<tr>
											<td >
												<div class="form-group">
													<label class="col-xs-2 col-myxs-15 control-label text-right">资料名称 </label>
													  <input name="materialName" type="text" class="text col-xs-2" >
												</div>
												<div class="form-group">
													<label class="col-xs-2 col-myxs-15 control-label text-right">上传类型</label>
													<div class="col-xs-3">
													<input id="codeUploadMaterialType" type="text" name="codeUploadMaterialType" value="${vdata.zongzhiMaterial.codeUploadMaterialType }" class="col-xs-3" />
													</div>
												</div>
											</td>
											
											<td style="width:100px;">
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
