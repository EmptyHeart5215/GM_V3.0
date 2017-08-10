<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
		var gridCode="";
		var buildCode="";
		var unitCode="";
		var houseCode="";
		var map={
		"building":["unit","house","person"],
		"unit":["house","person"],
		"house":["person"],
		};
		;(function($){
			/**
			 * jqGrid English Translation
			 * Tony Tomov tony@trirand.com
			 * http://trirand.com/blog/ 
			 * Dual licensed under the MIT and GPL licenses:
			 * http://www.opensource.org/licenses/mit-license.php
			 * http://www.gnu.org/licenses/gpl.html
			**/
			$.jgrid = $.jgrid || {};
			$.extend($.jgrid,{
				defaults : {
					recordtext: "<div style=\"float: left; margin-top: -2px;\" class=\"ui-separator\"></div>&nbsp;&nbsp;{0}至{1}，共 {2}条",
					emptyrecords: "<span class='red'>暂无数据</span>",
					loadtext: "正在加载...",
					pgtext : "第 {0}页， 共{1}页"
				},
			})
		})(jQuery);
		var height="450px";
		function loadTree(){
		    $.ajax({
		        type: "post",
		        url: '${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),
		        dataType: "json",
		        async: false,
		        success: function (data) {
		            var zNodes = data;
		            var setting = {
		            		callback: {
		            			onClick: function(event, treeId, treeNode) {
		            				 buildCode="";
		            				 unitCode="";
		            				 houseCode="";
		            				gridCode=treeNode.code;
		            				var postData={
		            						gridCode:treeNode.code,
		            						realQuery:true
		            				}
		            				$("#grid-table-building").jqGrid('setGridParam',{loadComplete:null,postData:postData}).trigger("reloadGrid"); 
		            				for(var i=0;i<map["building"].length;i++){
										$("#grid-table-"+map["building"][i]).jqGrid('setGridParam',{loadComplete:null,postData:{realQuery:false}}).trigger("reloadGrid"); 
									}	
		            			}
		            		},
		                data: {
		                	key: {
		        				name: "name"
		        			},
		                    simpleData: {
		                        enable: true,
		                        idKey: "code",
		        				pIdKey:"parentCode"
		                    }
		                },
		                view: {
		                    fontCss: function (treeId, treeNode) {
		                        return (!!treeNode.highlight) ? { color: "#A60000", "font-weight": "bold" } : { color: "#333", "font-weight": "normal" };
		                    }
		                }
		            };
		           ztree= $.fn.zTree.init($("#treeDemo"), setting, zNodes);
		        }
		    });
		}
		function showFunctionDialog(funStr,typeStr,alertStr,url,arg,iframeStyle,showFunctionBtn){
			if(arg&&""!=$.trim(arg)){
				var dialog=bootbox.dialog({
					  url:url + arg,
					  title: funStr+typeStr,
					  style:'width:1000px;height:600px',
					  iframeStyle:iframeStyle,
					  showFunctionBtn:showFunctionBtn
					});
				}else{
					bootbox.alert("请选择"+alertStr+"！");
					return;
			}
		}
		function addFunction(id){
			if(id=="building"){
				if(gridCode.length!=20){
					bootbox.alert("请选择网格！");
				return;
				}
				showFunctionDialog("添加","楼栋","辖区","${base}/base/building/addLoad?gridCode=",gridCode,"height:700px;",true);
			}else if(id=="unit"){
				showFunctionDialog("添加","单元","楼栋","${base}/base/unit/addLoad?buildCode=",buildCode,"height:400px;",true);
			}else if(id=="house"){
				showFunctionDialog("添加","房屋","单元","${base}/base/house/addLoad?unitCode=",unitCode,"height:1300px;",true);
			}else if(id=="person"){
				showFunctionDialog("添加","境内人员","房屋","${base}/base/person/addLoad?houseCode=",houseCode,"height:1000px;",false);
			}
		}
		function addJingWaiFunction(){
			showFunctionDialog("添加","境外人员","房屋","${base}/base/person/addJingWaiLoad?houseCode=",houseCode,"height:600px;",true);
		}
		function editFunction(id){
			var code=$('#grid-table-'+id).jqGrid('getGridParam', "selrow");
			
			if(id=="building"){
				showFunctionDialog("编辑","楼栋","楼栋","${base}/base/building/modifyLoad?code=",code,"height:700px;",true);
			}else if(id=="unit"){
				showFunctionDialog("编辑","单元","单元","${base}/base/unit/modifyLoad?code=",code,"height:400px;",true);
			}else if(id=="house"){
				showFunctionDialog("编辑","房屋","房屋","${base}/base/house/modifyLoad?code=",code,"height:1300px;",true);
			}else if(id=="person"){
				var rowData = $('#grid-table-'+id).jqGrid("getRowData",code);
				var showBtn=false;
				var personType="jingNei";
				var height="height:1000px;";
				if(rowData.PERSONTYPE=='境外'){
					showBtn=true;
					 personType="jingWai";
					 height="height:600px;";
				}
				showFunctionDialog("编辑","人","人","${base}/base/person/modifyLoad?personType="+personType+"&personCode=",rowData.CODE,height,showBtn);
			}
		}
		function showDeleteDialog(id,url){
			var code=$('#grid-table-'+id).jqGrid('getGridParam', "selrow");
			var rowData = $('#grid-table-'+id).jqGrid("getRowData",code);
			 if(!code){
				 bootbox.alert('请至少一条信息！');
				 return;
			 }
			bootbox.confirm('确定删除吗？',function(result){
				if(result){
					 $.ajax({
							type : "post",
							url : url+rowData.code,			
							dataType : 'json',
							async : false,
							success : function(data) {
								bootbox.slideAlert('body',data.status,data.info);
								if(data.status){
									$("#grid-table-"+id).trigger("reloadGrid"); 
									for(var i=0;i<map[id].length;i++){
										$("#grid-table-"+map[id][i]).jqGrid('setGridParam',{loadComplete:null,postData:{realQuery:false}}).trigger("reloadGrid"); 
									}
								}
							}
						}); 
				}
			});
		}
		function deleteFunction(id){
			if(id=="building"){
				showDeleteDialog(id,"${base}/base/building/delete?code=");
			}else if(id=="unit"){
				showDeleteDialog(id,"${base}/base/unit/delete?code=");
			}else if(id=="house"){
				showDeleteDialog(id,"${base}/base/house/delete?code=");
			}else if(id=="person"){
				var code=$('#grid-table-'+id).jqGrid('getGridParam', "selrow");
				var rowData = $('#grid-table-'+id).jqGrid("getRowData",code);
				if(rowData.PERSONTYPE=='境外'){
					showDeleteDialog(id,"${base}/base/person/deleteJingWai?code=");
				}else{
				showDeleteDialog(id,"${base}/base/person/delete?code=");
				}
			}
		}
		function refreshFunction(id){
			var postData={};
			if(id=="building"&&gridCode!=""){
				postData={
						gridCode:gridCode,
						realQuery:true
				}
			}else if(id=="unit"&&buildCode!=""){
				postData={
						buildCode:buildCode,
						realQuery:true
				}
			}else if(id=="house"&&unitCode!=""){
				postData={
						unitCode:unitCode,
						realQuery:true
				}
			}else if(id=="person"&&houseCode!=""){
				postData={
						houseCode:houseCode,
						realQuery:true
				}
			}else{
				return;
			}
			$("#grid-table-"+id).jqGrid('setGridParam',{loadComplete:null,postData:postData}).trigger("reloadGrid"); 
			for(var i=0;i<map[id].length;i++){
				$("#grid-table-"+map[id][i]).jqGrid('setGridParam',{loadComplete:null,postData:{realQuery:false}}).trigger("reloadGrid"); 
			}	
		}
		function addBtn(id){
			var a='<table class="ui-pg-table navtable" style="float:right;table-layout:auto;" border="0" cellpadding="0" cellspacing="0"><tbody><tr>';
			if(id=='person'){
				a+='<td title="新增境内人员" id="addBtn_'+id+'"onclick="addFunction(\''+id+'\')" class="ui-pg-button ui-corner-all"><div class="ui-pg-div"><span class="ui-icon icon-plus-sign purple"></span></div></td>';
				a+='<td title="新增境外人员" id="addBtn_'+id+'"onclick="addJingWaiFunction()" class="ui-pg-button ui-corner-all"><div class="ui-pg-div"><span class="ui-icon icon-plus-sign green"></span></div></td>';
			}else{
				a+='<td title="新增" id="addBtn_'+id+'"onclick="addFunction(\''+id+'\')" class="ui-pg-button ui-corner-all"><div class="ui-pg-div"><span class="ui-icon icon-plus-sign purple"></span></div></td>';
			}
			a+='<td title="编辑" id="editBtn_'+id+'"onclick="editFunction(\''+id+'\')" class="ui-pg-button ui-corner-all"><div class="ui-pg-div"><span class="ui-icon ui-icon-pencil"></span></div></td>\
            	<td title="删除"id="deleteBtn_'+id+'" onclick="deleteFunction(\''+id+'\')" class="ui-pg-button ui-corner-all"><div class="ui-pg-div"><span class="ui-icon  icon-trash red"></span></div></td>\
            	<td title="刷新"id="refreshBtn_'+id+'" onclick="refreshFunction(\''+id+'\')" class="ui-pg-button ui-corner-all"><div class="ui-pg-div"><span class="ui-icon ui-icon icon-refresh"></span></div></td>\
            	</tr></tbody></table>';
            	$("#gview_grid-table-"+id).find(".ui-jqgrid-titlebar").append(a);
		}
		
		function getBuilding(realQuery){
			 $("#grid-table-building").jqGrid({
				 url:"${base }/base/building/queryManage",
						 postData:{
							 realQuery:false
						 },
				 height:height,
			        defaultCaozuo:false,
			        colNames:['', '楼栋名'],
			        colModel:[
			   			{name:'code',index:'code',sortable:false, hidden:true},
			            	{name:'buildName',index:'buildName',sortable:true}
			            	
			   			],
			        pager:$('#grid-pager-building'),
			        pginput:false,
			        showRowList:false,
			        caption: "楼栋",
			        multiselect:false,
			        onSelectRow: function (rowId, status) {
			        	var rowObject=$(this).jqGrid('getRowData',rowId);
			        	var postData={
        						buildCode:rowObject['code'],
        						realQuery:true
        				}
			        	buildCode=rowObject.code;
       				 unitCode="";
       				 houseCode="";
        				$("#grid-table-unit").jqGrid('setGridParam',{loadComplete:null,postData:postData}).trigger("reloadGrid");
        				$("#grid-table-house").jqGrid('setGridParam',{loadComplete:null,postData:{realQuery:false}}).trigger("reloadGrid"); 
        				$("#grid-table-person").jqGrid('setGridParam',{loadComplete:null,postData:{realQuery:false}}).trigger("reloadGrid"); 
        			
	                },loadComplete:function(){
	                	addBtn("building");
	                },sortable:true,
			        sortname:'buildName',
	               
			    });
		}
		function getUnit(realQuery){
			 $("#grid-table-unit").jqGrid({
				 url:"${base }/base/unit/queryManage",
						 postData:{
							 realQuery:realQuery
						 },
						 height:height,
			        defaultCaozuo:false,
			        sortable:true,
			        sortname:"sort",
			        colNames:['', '单元号'],
			        colModel:[
			   			{name:'code',index:'code',sortable:false, hidden:true},
			            	{name:'name',index:'name',sortable:false}
			   			],
			        pager:$('#grid-pager-unit'),
			        pginput:false,
			        showRowList:false,
			        caption: "单元",
			        multiselect:false,
			        onSelectRow: function (rowId, status) {
			        	var rowObject=$(this).jqGrid('getRowData',rowId);
			        	var postData={
        						unitCode:rowObject.code,
        						realQuery:true
        				}
			        	 unitCode=rowObject.code;
	       				 houseCode="";
        				$("#grid-table-house").jqGrid('setGridParam',{loadComplete:null,postData:postData}).trigger("reloadGrid"); 
			        	$("#grid-table-person").jqGrid('setGridParam',{loadComplete:null,postData:{realQuery:false}}).trigger("reloadGrid"); 
			        },loadComplete:function(){
	                	addBtn("unit");
	                }
			    });
		}
		function getHouse(realQuery){
			 $("#grid-table-house").jqGrid({
				 url:"${base }/base/house/queryManage",
				 postData:{
					 realQuery:false
				 },
				 height:height,
			        defaultCaozuo:false,
			       
			        colNames:['', '房屋号','房屋用途'],
			        colModel:[
			   			{name:'code',index:'code',sortable:false, hidden:true},
			            	{name:'houseNum',index:'houseNum',sortable:false},
			            	{name:'dicValueMap.codeHouseUse',index:'dicValueMap.codeHouseUse',sortable:false}
			   			],
			        pager:$('#grid-pager-house'),
			        pginput:false,
			        showRowList:false,
			        caption: "房屋",
			        sortable:true,
			        sortname:"sort",
			        multiselect:false,
			        onSelectRow: function (rowId, status) {
			        	var rowObject=$(this).jqGrid('getRowData',rowId);
			        	var postData={
        						houseCode:rowObject.code,
        						realQuery:true
        				}
			        	houseCode=rowObject.code;
        				$("#grid-table-person").jqGrid('setGridParam',{loadComplete:null,postData:postData}).trigger("reloadGrid"); 
	                },loadComplete:function(){
	                	addBtn("house");
	                }
			    });
		}
		function getPerson(realQuery){
			 $("#grid-table-person").jqGrid({
				 url:"${base }/base/person/queryManage",
				 postData:{
					 realQuery:false
				 },
				 height:height,
				 ondblClickRow:function(rowid,iRow,iCol,e){
			    	  var code=$('#grid-table-person').jqGrid('getGridParam', "selrow");
			    	  var rowData = $('#grid-table-person').jqGrid("getRowData",code);
						var personType="jingNei";
						if(rowData.PERSONTYPE=='境外'){
							 personType="jingWai";
						}
			    	  bootbox.dialog({
							 url:"${base}/base/person/infoSee?personCode="+rowData.CODE+"&personType="+personType,
							  title: "人口信息采集表",
							  iframeStyle:'height:1500px;',
							  style:'width:1000px;height:600px;'
							});
			      },
			        defaultCaozuo:false,
			        sortable:false,
			        colNames:['', '姓名','类别'],
			        colModel:[
			   			{name:'CODE',index:'code',sortable:false, hidden:true},
			            	{name:'NAME',index:'name',sortable:false},
			            	{name:'PERSONTYPE',index:'personType',sortable:false,formatter:function(cellValue){
			            		if(cellValue=='jingNei'){
			            			return '境内';
			            		}else{return '境外';}
			            	}}
			   			],
			        pager:$('#grid-pager-person'),
			        pginput:false,
			        showRowList:false,
			        caption: "人",
			        multiselect:false,
			        loadComplete:function(){
	                	addBtn("person");
	                }
			    });
		}
	$(function(){
		//如果子页面需要进行图片浏览，必须加上这句-------------
		layer.use('extend/layer.ext.js', function(){
			   layer.ext =function(){};
		}); 
		loadTree();
		getBuilding(false);
		getUnit(false);
		getHouse(false);
		getPerson(false);
	 });
	//在提交或者修改单条信息成功后的调用方法，用于子页面调用
	 function successFun(id){
		bootbox.hideAll();
		bootbox.slideAlert('body');
		refreshFunction(id);
	 }
</script>
<style>
.divBorder{
border-top:3px solid #e5e5e5;
border-bottom:3px solid #e5e5e5 ;
border-left:3px solid #e5e5e5;
padding:0px;
}
.btnseparator{
float: left;
height: 22px;
border-left: 1px solid #ccc;
border-right: 1px solid #fff;
margin: 1px;
}
</style>
</head>
<body>
	<div  id="body">
	    <div class="col-xs-2 col-sm-2 divBorder" style="overflow:auto;height:583px;">
			<ul id="treeDemo" class="ztree" style="margin: 0; color: #e5e5e5;"></ul>
		</div>
		<div class="col-xs-2 col-sm-2 col-myxs-25 divBorder">
			<table id="grid-table-building"></table>
			<div id="grid-pager-building"></div>
		</div>
		<div class="col-xs-2 col-sm-2 col-myxs-25 divBorder">
		<table id="grid-table-unit"></table>
		<div id="grid-pager-unit"></div>
	</div>
	<div class="col-xs-3 col-sm-3 col-myxs-25  divBorder">
		<table id="grid-table-house"></table>
		<div id="grid-pager-house"></div>
	</div>
	<div class="col-xs-3 col-sm-3 col-myxs-25  divBorder" style="border-right:3px solid #e5e5e5 ;">
		<table id="grid-table-person"></table>
		<div id="grid-pager-person"></div>
	</div>
	</div>
</body>
</html>


