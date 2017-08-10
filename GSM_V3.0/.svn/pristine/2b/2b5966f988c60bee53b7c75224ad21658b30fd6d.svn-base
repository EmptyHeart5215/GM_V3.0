<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
		$(function(){
			$("[name=codeEducation]").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EDUCATION',
				name:"dicValue",
				pIdKey:"parentCode"
			});
			$("[name=codePolitical]").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_POLITICAL',
				name:"dicValue",
				pIdKey:"parentCode"
			});
			$("[name=codeNation]").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_NATION',
				name:"dicValue",
				pIdKey:"parentCode",
			});
			var setting = {
					callback:{
						onClick: zTreeOnClicks
					},
					data: {
						key: {
							name: "name"
						},
						simpleData: {
							enable: true,
							//open:true,
							idKey: "code",
							pIdKey:"parentCode",
							
						}
					}
				};
			$.ajax({
			      type: "get", 
			      url: '${base}/partybuilding/partyorganizationmanager/queryPartyBuildingTree',
			      //url: '${base}/temp/queryPartyBuildingTree',
			      dataType: 'json',
			      async: true,
			      success: function (data) {
			    	  var zNodes = data;
			    	  $.fn.zTree.init($("#xqTree"), setting, zNodes);
			    	  var treeObj = $.fn.zTree.getZTreeObj("xqTree"); 
			    	  treeObj.expandAll(true); 
			      }
			 });
		});
		function zTreeOnClicks(event, treeId, treeNode){
			   
			var xqCode = treeNode.code;
			var pomcode = treeNode.pomcode;
			var postData={
					gridCode:treeNode.code,
					//pomcode = treeNode.pomcode,
					realQuery:true
			}
			$("#grid-table").jqGrid('setGridParam',{loadComplete:null,postData:postData}).trigger("reloadGrid"); 
			
		}
		//添加按钮方法，方法名固定，不可改变
		var addFun=function(){
			var dialog=bootbox.dialog({
				 url:"${base}/partybuilding/retiredparty/addLoad",
				  title: "退休党员信息",
				  iframeStyle:"height:400px;width:730px;",
				  style:'width:800px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/partybuilding/retiredparty/modifyLoad?code="+code,
				  title: "退休党员信息",
				  iframeStyle:"height:400px;width:730px;",
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
							url : "${base}/partybuilding/retiredparty/delete?codes="+code,			
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
			 	url : "${base }/partybuilding/retiredparty/queryManage",
			 	ondblClickRow:function(code){
				    bootbox.dialog({
						url:"${base }/partybuilding/retiredparty/infoSee?code="+code,
						title: "详细信息表",
						showFunctionBtn:false,
						style:'width:800px;height:520px;'
						});
			      },
			      colNames:['主键', '所属辖区', '姓名','性别','身份证','民族','文化程度','党员类型','政治面貌','入党时间'],
			        colModel:[
						{name:'code',index:'code',sortable:false, hidden:true},
			            {name:'gridCode',index:'gridCode',sortable:true, width:'24%',align:'center',formatter:
							function(cellvalue, options, rowObject){
		            		var gridCode =rowObject['seatGrid'];
		            		gridCode = gridCode.gridTotalName;
		            		return gridCode;
	            	    }},
			            {name:'name',index:'name',sortable:true, width:'6%', align:"center"},
			            {name:'sex',index:'sex',sortable:true, width:'4%', align:"center",formatter:
			            	function(cellvalue, options, rowObject){
			            		var sex =rowObject['sex'];
			            		if(sex == '男'){
			            			return '<font color="red">男</font>';
			            		}else if(sex == '女'){
			            			return '<font color="green">女</font>';
			            		}else if(sex == 0){
			            			return '<font color="#694d9f">未填写</font>';
			            		}
	        	    	     }
			            },
			            {name:'cid',index:'cid',sortable:true, width:'12%', align:"center"},
			            {name:'dicValueMap.codeNation',index:'codeNation',sortable:true, width:'5%', align:"center"},
			            {name:'dicValueMap.codeEducation',sortable:true, width:'6%', align:"center"},
			            {name:'codePartyType',index:'codePartyType',sortable:true, width:'7%', align:"center",formatter:
			            	function(cellvalue, options, rowObject){
		            		var codePartyType =rowObject['codePartyType'];
		            		var strs = codePartyType.split(";");
		            		var saveValue = "";
		            		for(var i=0;i<strs.length;i++){
		            			if(strs[i] == 'tuixiuparty'){
		            				saveValue = "退休党员"
		            			}else if(strs[i] == 0){
			            			saveValue = '<font color="#694d9f">未填写</font>';
			            		}
		            			
		            		}
		            		return saveValue;
	    	    	     }},
			            {name:'dicValueMap.codePolitical',sortable:true, width:'8%', align:"center"},
			            {name:'inPartyDate',index:'inPartyDate',sortable:true, width:'7%', align:"center"},
			           
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
		        caption: "退休党员管理列表"
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
	<div class="col-xs-2 col-sm-2 divBorder" style="overflow:auto;height:583px;">
	       <div class="widget-header widget-header-flat">
				<h4 class="lighter green">党组织树</h4>
			</div>
			<div class="widget-header header-color-blue2 ui-helper-clearfix" style="height: 30px;">
				<h5 class="lighter smaller">党组织树形菜单</h5>
			</div>

			<div class="widget-body" style="height: 500px;overflow: auto;">
				<div class="widget-main padding-8">
					<ul id="xqTree" class="ztree"></ul>
				</div>
			</div>
	</div>
	<div class="col-xs-10 col-sm-10" id="body">
		<div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						退休党员查询
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
									
										<tr height="28px;">
										  <td width="6%" style="text-align: center;">姓名</td>
										  <td width="18%">
										    <div class="col-xs-12">
												<input name="name" type="text" class="text col-xs-12" >
											</div>	
										  </td>
										  <td width="7%" style="text-align: center;">民族</td>
										  <td width="20%">
										     <div class="col-xs-12">
												<input type="text" id="codeNation" name="codeNation" class="col-xs-12 col-sm-12" />
											</div>	
										  </td>
										  <td width="7%" style="text-align: center;">党员类型</td>
										  <td width="22%">
										      <div class="col-xs-12">
												<select  id="codePartyType" name = "codePartyType"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
												   <option value="">--请选择--</option>
						                           <option value="zhiguanparty">直管党员</option>
						                           <option value="zaizhiparty">在职党员</option>
						                           <option value="tuixiuparty">退休党员</option>
						                           <option value="kunnanparty">困难党员</option>
						                           <option value="zyzparty">志愿者党员</option>
						                        </select>
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
										  <td style="text-align: center;">性别</td>
										  <td>
										     <div class="col-xs-12">
												<select  id="sex" name = "sex"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
													<option  value="">--请选择--</option>
								                    <option  value="男">男</option>
								                    <option  value="女">女</option>
								                </select>
							                 </div>
										  </td>
										  <td style="text-align: center;">文化程度</td>
										  <td>
										  	<div class="col-xs-12">
												<input type="text" id="codeEducation" name="codeEducation" class="col-xs-12 col-sm-12" />
											</div>
										  </td>
										  <td width="7%" style="text-align: center;">政治面貌</td>
										  <td>
										  	<div class="col-xs-12">
												<input type="text" id="codePolitical" name="codePolitical" class="col-xs-12 col-sm-12" />
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
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridImport.js"></script>
</body>
</html>


