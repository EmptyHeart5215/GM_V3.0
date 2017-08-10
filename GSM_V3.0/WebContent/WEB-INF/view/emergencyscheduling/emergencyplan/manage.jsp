	
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
				 url:"${base }/emergencyscheduling/emergencyplan/addLoad",
				  title: "添加预案",
				  style:'width:800px;height:600px;',
				  iframeStyle:'height:1000px;',
			});
	};   
	
	function editFun(code){
		if(code&&""!=$.trim(code)){
			var dialog=bootbox.dialog({
			 url:"${base }/emergencyscheduling/emergencyplan/modifyLoad?code="+code,
			  title: "修改预案",
			  style:'width:1100px;height:650px;'
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
						url : "${base}/emergencyscheduling/emergencyplan/delete?codes="+code,			
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

	
	var downloadfile = function(filecode,downloadCount,code,girdCode){
		var filecode = filecode.substring(0,(filecode.length)-1);
   	    window.location.href ='/GSM_V3.0/sys/sysupload/downLoad?code='+filecode;
        };
   /*  var seeFile = function(downloadCount,code,materialName,filecode,girdCode){
    	var filecode = filecode.substring(0,(filecode.length)-1);
        bootbox.dialog({
			  url:"${base}/sys/sysupload/infosee?code="+filecode,
			  title: "查看"+materialName+"内容",
			  style:'width:1000px;height:650px;',
			  iframeStyle:'height:550px;',
			  showFunctionBtn:false,
	});
};  */
 var seeFile = function(downloadCount,code,materialName,filecode,girdCode){
	var filecode = filecode.substring(0,(filecode.length)-1);
    bootbox.dialog({
		  url:"${base}/emergencyscheduling/emergencyplan/pdfSee?code="+filecode,
		  title: "查看"+materialName+"内容",
		  style:'width:1000px;height:650px;',
		  iframeStyle:'height:550px;',
		  showFunctionBtn:false,
}); 
};
	
	
	$(function(){
		 $("#grid-table").jqGrid({
			 	url : "${base }/emergencyscheduling/emergencyplan/queryManage",
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:false,
		        ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
			    	  bootbox.dialog({
							 url:"${base}/emergencyscheduling/emergencyplan/infoSee?code="+rowid+"&stepId=1&entryId=1",
							  title: "应急预案详细信息表",
							  iframeStyle:'height:1500px;',
							  style:'width:1000px;height:600px;',
								  buttons: {
									    
									  success: {
									      id:"commitBtn",
									      label: "下载",
									      className: "btn-success",
									      callback: function(){
									    	  $("#dialog_iframe")[0].contentWindow.downLoad(); 
									    	  // return false 则dialog就不会关闭
									    	  return true;
									      }
									   }
									  }
							});
			      },
		        colNames:[ '主键','','','所属辖区或部门','预案名称','事件类型','创建时间','操作'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'materialFile',index:'materialFile',sortable:false, hidden:true},
                    {name:'girdCode',index:'girdCode',sortable:false,hidden:true},
					{name:'gridTotalName',sortable:false,width:'20%'},
					{name:'emergencyName',index:'emergencyName',sortable:false, width:'10%',align:'center'},
		            {name:'dicValueMap.codePlanType',index:'dicValueMap.codePlanType',sortable:false, width:'10%',align:'center'},
		            {name:'createDate',index:'createDate',sortable:false, width:'10%', align:"center"},
		            {name:'caozuo',width:132,fixed:true, sortable:false, resize:false,formatter:
		            	function(cellvalue, options, rowObject){
		            	    var code=rowObject['code'];
		            	    var fCode = rowObject['materialFile'];
		            	    var downloadCount = rowObject['downloadCount'];
		            	    var codeMaterialType = rowObject['codeMaterialType'];
		            	    var materialName = rowObject['emergencyName'];
		            	    var  girdCode = rowObject['girdCode'];
		            	    var div='<div style="margin-left:8px;">';
			            	div+="<div class='ui-pg-div ui-inline-edit'title='编辑' style='float:left;cursor:pointer;' onclick='editFun(\""+code+"\")'>";
				            	div+='<span class="ui-icon ui-icon-pencil"></span>';
				            		div+="</div> <div id class='ui-pg-div ui-inline-del'title='查看' style='float:left;margin-left:5px;'onclick='seeFile(\""+downloadCount+"\",\""+code+"\",\""+materialName+"\",\""+fCode+"\",\""+girdCode+"\")'>";
		            				div+='<span id class="ui-icon icon-zoom-in  "></span>';
				            		div+="</div> <div id class='ui-pg-div ui-inline-del'title='下载' style='float:left;margin-left:5px;'onclick='downloadfile(\""+fCode+"\",\""+downloadCount+"\",\""+code+"\",\""+girdCode+"\")'>";
		            				div+='<span id class="ui-icon icon-cloud-download  "></span>';
				            	
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
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
			if($("[name=codePlanType]").val()=="AAD6D66D5E8A4A12B1F3CC467108F4A8"){
				$("[name=codePlanType]").val("");
			}
			 var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		//预案类型
			$("[name='codePlanType']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_PLAN_TYPE',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo'
				});
			$("[name=gridCode]").ztreeGrid({
				url:'${base}/sys/seatgird/queryOrgnizationTree?t=' + Math.random()	
			});
	 });
	
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
									<table style="width:100%;" >
										<tr>
											<td>
												<div class="search-group">
														<label class="col-xs-2 control-label text-right">所属辖区或部门 </label>
														<input name="gridCode" type="text" class="text col-xs-2"  >									
														<label class="col-xs-2 col-myxs-2 control-label text-right" >预案名称</label>
														<input name="emergencyName"  type="text" class="text col-xs-2" >
														<label class="col-xs-2 col-myxs-2 control-label text-right">预案类型</label>
														<input name="codePlanType" type="text" class="text col-xs-2"  >
														
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


