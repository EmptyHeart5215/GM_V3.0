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
	 $("[name='gridCode']").ztreeGrid({
		 	url: '${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),
			name:"name",
			pIdKey:"parentCode",
			reset:true,
			resetId:'redo'
			});
	$("#imgClose").click(function(){
	    $("#mapSearchDiv").hide();
	});
	
	NMapsShow({
		id : "map"
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
		 	url : "${base }/eventfile/efharmsafe/queryManage",
		 	defaultCaozuo:false,
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
		 		 var Name = rowData.eventName;
		 		 var position = rowData.position;
		 		 var code = rowData.code;
		 		  var show = "[";
		 		  show += "{\"NAME\":\""+Name+"\",\"POSITION\":\""+position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:525px;width:800px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='yes' frameborder='0' src='${base}/eventfile/efharmsafe/detailLoad?eventCode="+code+"'></iframe></div>\"},";
		 		 show = show.substring(0,show.length-1)+"]";
		 		 drawmapshow(show, true, true, true);
		    },
		 	datatype:"json", //数据来源，本地数据
		 	postData:postData,
		 	mtype:"POST",//提交方式
		 	colNames:['序号', '所属辖区', '名称','事件发生时间','所属单位','隐患排查时间','负责人','ditu'],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
				{name:'seatGrid.gridTotalName',sortable:false, width:'15%'},
	            {name:'eventName',index:'eventName',sortable:true, width:'5%', align:"center"},
	            {name:'time',index:'time',sortable:true, width:'5%', align:"center"},
	            {name:'belongUnit',index:'belongUnit',sortable:true, width:'10%', align:"center"},
	            {name:'harmDate',index:'harmDate',sortable:true, width:'10%', align:"center"},
	            {name:'unitName',index:'unitName',sortable:true, width:'10%', align:"center"},
	            {name:'position',index:'position',sortable:true, width:'10%', align:"center",hidden:true}
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
	        caption: "公共安全隐患及事件查询列表",
	        loadComplete:mapSearchLoad
	    });
	});
	$("#mapSearchSearch").click();
	$('#table').animate({ width:"0px",height:"0px" },0);
}); 
function showmapSearch(){
	$("#mapSearchDiv").toggle();
}
var mapSearchLoad = function (data){
	var rows = $('#grid-table').jqGrid('getRowData');
	if(rows.length>0){
	var show = "[";
	for(var i  = 0;i<rows.length;i++){
		var row = rows[i];
		show += "{\"NAME\":\""+row.Name+"\",\"POSITION\":\""+row.position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:525px;width:800px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='yes' frameborder='0' src='${base}/eventfile/efharmsafe/detailLoad?eventCode="+row.code+"'></iframe></div>\"},";
	}
	show = show.substring(0,show.length-1)+"]";
	drawmapshow(show, true, false, true);
	}
}

</script>
</head>

<body>
<div style="width: 100%;height: 780px;">
		<div style="width: 100%; height: 30px;text-align:center;z-index: 10; position: absolute;">
								<button style="margin-top:-3px;" class="btn btn-minier btn-yellow" onclick="showmapSearch();">公共安全隐患及事件查询
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
		<div id="mapSearchDiv" class=""  hidden="hidden">
		  <div style="width:100%; height: 30px;background-color: #F8F8F8">
		    <div style="margin-top: 5px;margin-left: 10px;"><b>公共安全隐患及事件查询条件</b></div>
		    <div style="margin-left: -13px;float: right;margin-top: -22px;height: 20px;width:30px;">
		      <div id="close" style="text-align: center; line-height: 30px; z-index: 100; position: absolute; font-weight: bold; top: 0px; right: 0px; width: 34px; height: 30px; cursor: pointer; background-color: rgb(248, 248, 248);">
				<div style="position: absolute; overflow: hidden; width: 10px; height: 10px; left: 12px; top: 10px;">
				  <img width="93" id="imgClose" height="75" src="${base }/resource/user-definedimages/close.png" style="width: 93px; height: 75px; position: absolute; left: -46px; top: -64px; z-index: 0; -moz-user-select: none; border: 0px none;">
				</div>
			  </div>
		    </div>
		    <div style="slideToggle("slow");;height: 6px;">
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
		        <td width="10%">名称 </td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="eventName" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		        <td width="10%">类型</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text"  name="codeHarmType" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		      </tr>
		      <tr height="28px;">
				<td width="10%">地点或部位</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="place" type="text" class="text col-xs-12" >
				  </div>
		        </td>											
		        <td width="10%">负责人 </td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="unitName" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		        <td width="10%">事件发生时间</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text"  name="time" class="col-xs-12 col-sm-12 date-picker" />
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
