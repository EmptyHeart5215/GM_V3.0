<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include page="/resource/base_import.jsp" />
<link href="${base}/resource/css/map.css" rel="stylesheet" />
<script type="text/javascript">
$(function() {
	$('#beSmall').bind('click',function(){
		if($('#table').css('width')=='0px'){
			$('#table').animate({ width:"100%",height:"230px" },1000);
			$(this).attr("class"," icon-double-angle-left bigger-140 mapBeSmall");
		}else{
			$('#table').animate({ width:"0px",height:"0px" },1000);
			$(this).attr("class"," icon-double-angle-right bigger-140 mapBeSmall");
		}
	});
	$("#imgClose").click(function(){
	    $("#mapSearchDiv").hide();
	});
	$("#imgCloses").click(function(){
	    $("#partymemberDiv").hide();
	});
	NMapsShow({
		id : "map"
	});
	 $("[name=gridCode]").ztreeGrid({
			url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
		});
	 $("[name=codeBelongType]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_FIELDS_CLASS',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			checkBox:true,
			resetId:'redo'
		});
	$("#mapSearchSearch").click(function(){
		var postData=$("#search_form").serializeJson();
		$("#mapSearchDiv").hide();
		if($('#table').css('width')=='0px'){
			$('#table').animate({ width:"100%",height:"230px" },0);
			$('#beSmall').attr("class"," icon-double-angle-left bigger-140 mapBeSmall");
		}
		$("#table").html("<table id=\"grid-table\"></table><div id=\"grid-pager\"></div>");
		$("#grid-table").jqGrid({
			url : "${base }/yanpanfenxi/fieldsquery/queryManage",
			defaultCaozuo:false,
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
		 		 var Name = rowData.buildName;
		 		 var position = rowData.position;
		 		 var code = rowData.code;
		 		  var show = "[";
		 		  show += "{\"NAME\":\""+Name+"\",\"POSITION\":\""+position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:500px;width:800px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='yes' frameborder='0' src='${base}/base/fields/infoSee?code="+code+"'></iframe></div>\"},";
		 		 show = show.substring(0,show.length-1)+"]";
		 		 drawmapshow(show, true, true, true);
		    },
		 	datatype:"json", //数据来源，本地数据
		 	postData:postData,
		 	mtype:"POST",//提交方式
		 	colNames:[ '主键', '所属辖区','地名','所属分类','地点','面积','范围界限','主管部门','其他附属设施',''],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
				{name:'seatGrid.gridTotalName',index:'gridCode',sortable:false, width:'25%'},
	            {name:'name',index:'name',sortable:false, width:'15%'},
	            {name:'dicValueMap.codeBelongType',index:'dicValueMap.codeBelongType',sortable:false, width:'10%'},
	            {name:'address',index:'address',sortable:false, width:'15%'},
	            {name:'area',index:'area',sortable:false, width:'10%', align:"left"},
	            {name:'range',index:'range',sortable:false, width:'15%'},
	            {name:'belong',index:'belong',sortable:false, width:'20%', align:"left"},
	            {name:'otherBelong',index:'otherBelong',sortable:false, width:'10%'},
	            {name:'position',index:'position',sortable:false, width:'15%',hidden:true}
	            
	        ],
	        sortable:false,
	        rownumbers:true,//添加左侧行号
	        altRows:true,//班玛线
	        sortname:'createDate',
	        sortorder:'desc',
	        viewrecords: true,//是否在浏览导航栏显示记录总数
	        rowNum:5,//每页显示记录数
	        showRowList:false,
	        multiselect: false,
	        hidegrid:false,
	        rownumbers:true,//添加左侧行号
	        jsonReader:{
	            id: "code",//设置返回参数中，表格ID的名字为CODE
	            repeatitems : false
	        },
	        pager:$('#grid-pager'),
	        caption: "地查询列表",
	        loadComplete:mapSearchLoad
	    });
	});
	$("#mapSearchSearch").click();
	$('#table').animate({ width:"0px",height:"0px" },0);
}); 

function showDiv(){
	 $("#mapSearchDiv").hide();
}
function showmapSearch(){
	$("#mapSearchDiv").slideToggle("slow");
}
var mapSearchLoad = function (data){
	var rows = $('#grid-table').jqGrid('getRowData');
	if(rows.length>0){
	var show = "[";
	for(var i  = 0;i<rows.length;i++){
		var row = rows[i];
		show += "{\"NAME\":\""+row.Name+"\",\"POSITION\":\""+row.position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:500px;width:800px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/base/fields/infoSee?code="+row.code+"'></iframe></div>\"},";
	}
	show = show.substring(0,show.length-1)+"]";
	drawmapshow(show, true, false, true);
	}
}
var partyMemberLoad = function(data){
	var rows = $('#grid-table').jqGrid('getRowData');
	//var show = "[";
	clearMap();
	for(var i  = 0;i<rows.length;i++){
		var row = rows[i];
		var show = "{\"NAME\":\""+row.name+"\",\"POSITION\":\""+row.position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:280px;width:500px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/base/fields/infoSee?code="+row.code+"'></iframe></div>\"}";
		drawmapshow(show, true, false, true);
	}
}
</script>
</head>

<body>
<div style="width: 100%;height: 780px;">
		<div style="width: 100%; height: 30px;text-align:center;z-index: 10; position: absolute;">
								<button style="margin-top:-3px;" class="btn btn-minier btn-yellow" onclick="showmapSearch();">地查询
								  <i class="icon-angle-down icon-on-right"></i>
								</button>
		</div>
		<div id="beSmall" class="icon-double-angle-right bigger-140 mapBeSmall">
		</div>
		<div  id="table" class="widget-box transparent collapsed mapListTable" >
			 <table id="grid-table"></table>
			 <div id="grid-pager"></div> 
		</div> 
		<div id="map" style="width: 100%;height:100%; "></div>
		
		<div id="mapSearchDiv"  hidden="hidden">
		  <div style="width:100%; height: 30px;background-color: #F8F8F8">
		    <div style="margin-top: 5px;margin-left: 10px;"><b>地查询条件</b></div>
		    <div style="margin-left: -13px;float: right;margin-top: -22px;height: 20px;width:30px;">
		      <div id="close" style="text-align: center; line-height: 30px; z-index: 100; position: absolute; font-weight: bold; top: 0px; right: 0px; width: 34px; height: 30px; cursor: pointer; background-color: rgb(248, 248, 248);">
				<div style="position: absolute; overflow: hidden; width: 10px; height: 10px; left: 12px; top: 10px;">
				  <img width="93" id="imgClose" height="75" src="${base }/resource/user-definedimages/close.png" style="width: 93px; height: 75px; position: absolute; left: -46px; top: -64px; z-index: 0; -moz-user-select: none; border: 0px none;">
				</div>
			  </div>
		    </div>
		    <div style="width: 444px;;height: 6px;">
		      <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1);height: 3px;margin-top: -1px;" width="90%" color=#987cb9 SIZE=3>
		    </div>
		  </div>
		  <form id="search_form" style="padding-top:20px">
		   <table style="width: 100%;text-align: center;">
		      <tr height="28px;">
				<td width="10%">所属辖区</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="gridCode" type="text" class="text col-xs-12" >
				  </div>
		        </td>											
		        <td width="10%">地名称 </td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="name" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		        <td width="10%">管理负责人</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text"  name="manageMan" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		      </tr>
		       <tr height="28px;">
				<td width="10%">网格联系人</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="gridName" type="text" class="text col-xs-12" >
				  </div>
		        </td>											
		        <td width="10%">单位负责人  </td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="belongMan" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		        <td width="10%">所属分类</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text" id="codeBelongType" name="codeBelongType" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		      </tr>
		      <tr height="28px;">
				<td width="10%">主管或所属单位</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="belong" type="text" class="text col-xs-12" >
				  </div>
		        </td>											
		        <td width="10%">地编号 </td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="fieldsCode" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		      </tr>
		       <tr height="5px;">
		        <td colspan="4"></td>
		      </tr>
		        <tr height="30px;">
		       <td colspan="6">
		          <table style="width: 50%;text-align: center;" align="center">
		             <tr height="28px;">
		               <td>
		                 <button type="button" class="btn btn-info" id="mapSearchSearch">查询
							<i class="icon-search bigger-110 "></i>
						 </button>
		               </td>
		               <td>
		                 <button type="reset" class="btn btn-info" id="reset">重置
							<i class="glyphicon glyphicon-arrow-left bigger-110 "></i>
						 </button>
		               </td>
		             </tr>
		          </table>
		       </td>
		      </tr>
		   </table>
		   </form>
		</div>
</div>
</body>
</html>
