<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include page="/resource/base_import.jsp" />
<script type="text/javascript">
$(function() {
	$("#imgClose").click(function(){
	    $("#partyOrganDiv").hide();
	});
	$("#imgCloses").click(function(){
	    $("#partymemberDiv").hide();
	});
	NMapsShow({
		id : "map"
	});
	
	$("#partyOrganSearch").click(function(){
		var postData=$("#search_form").serializeJson();
		$("#partyOrganDiv").hide();
		$("#table").html("<table id=\"grid-table\"></table><div id=\"grid-pager\"></div>");
		$("#grid-table").jqGrid({
			url : "${base }/yanpanfenxi/housechaxun/queryManage",
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
		 		 var Name = rowData.name;
		 		 var position = rowData.position;
		 		 var code = rowData.code;
		 		  var show = "[";
		 		  show += "{\"NAME\":\""+Name+"\",\"POSITION\":\""+position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:280px;width:500px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/partybuilding/partyorganizationmanager/infoSee?code="+code+"'></iframe></div>\"},";
		 		 show = show.substring(0,show.length-1)+"]";
		 		 drawmapshow(show, true, true, true);
		    },
		 	datatype:"json", //数据来源，本地数据
		 	postData:postData,
		 	mtype:"POST",//提交方式
		 	colNames:[ '主键', '建筑面积','户型','建成年份','产权人姓名','产权人身份证号','产权人住址','产权人电话','工作单位'],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
	            {name:'houseArea',index:'houseArea',sortable:true, width:'15%',align:'left'},
	            {name:'codeHouseLayout',index:'codeHouseLayout',sortable:true, width:'20%', align:"left"},
	            {name:'buildYear',index:'buildYear',sortable:true, width:'15%',align:'left'},
	            {name:'houseOwnerName',index:'houseOwnerName',sortable:true, width:'20%', align:"left"},
	            {name:'useCardNumber',index:'useCardNumber',sortable:true, width:'15%',align:'left'},
	            {name:'houseOwnerNowAddress',index:'houseOwnerNowAddress',sortable:true, width:'20%', align:"left"},
	            {name:'houseOwnerPhone',index:'houseOwnerPhone',sortable:true, width:'15%',align:'left'},
	            {name:'useWork',index:'useWork',sortable:true, width:'15%',align:'left'}
	             
	        ],
	        sortable:false,
	        rownumbers:true,//添加左侧行号
	        altRows:true,//班玛线
	        sortname:'createDate',
	        sortorder:'desc',
	        viewrecords: true,//是否在浏览导航栏显示记录总数
	        rowNum:5,//每页显示记录数
	        showRowList:false,
	        multiselect: true,
	        hidegrid:false,
	        rownumbers:true,//添加左侧行号
	        jsonReader:{
	            id: "code",//设置返回参数中，表格ID的名字为CODE
	            repeatitems : false
	        },
	        pager:$('#grid-pager'),
	        caption: "房屋查询列表",
	        loadComplete:partyOrganLoad
	    });
		//$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
	});
	$("#partyOrganSearch").click();
}); 

function showDiv(){
	 $("#partymemberDiv").show()
	 $("#partyOrganDiv").hide();
}
function showPartyOrgan(){
	$("#partyOrganDiv").show();
	$("#partymemberDiv").hide();
}
var partyOrganLoad = function (data){
	var rows = $('#grid-table').jqGrid('getRowData');
	var show = "[";
	for(var i  = 0;i<rows.length;i++){
		var row = rows[i];
		show += "{\"NAME\":\""+row.Name+"\",\"POSITION\":\""+row.position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:280px;width:500px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/partybuilding/partyorganizationmanager/infoSee?code="+row.code+"'></iframe></div>\"},";
	}
	show = show.substring(0,show.length-1)+"]";
	drawmapshow(show, true, false,false);
}
var partyMemberLoad = function(data){
	var rows = $('#grid-table').jqGrid('getRowData');
	//var show = "[";
	clearMap();
	for(var i  = 0;i<rows.length;i++){
		var row = rows[i];
		var show = "{\"NAME\":\""+row.name+"\",\"POSITION\":\""+row.position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:280px;width:500px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/partybuilding/allparty/infoSeeforMap?code="+row.code+"'></iframe></div>\"}";
		drawmapshowperson(show, false);
	}
}
var showGrid=function(){
	$.ajax({
		type:'post',
		url:'${base}/map/mapshow/getSeatGridData',
		dataType : 'json',
		async : false,
		success : function(rows) {
			var show = "[";
			for(var i  = 0;i<rows.length;i++){
				var row = rows[i];
				show += "{\"NAME\":\""+row.name+"\",\"POSITION\":\""+row.position+"\",\"HTML\":\"<div style='height:280px;width:500px;overflow:auto;'><iframe width='100%' height='400px' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/map/mapshow/showGridDetail?code="+row.code+"'></iframe></div>\"},";
			}
			show = show.substring(0,show.length-1)+"]";
			drawmapshow(show, true, true,true);
		}
	});
};
var showCommunity=function(){
	$.ajax({
		type:'post',
		url:'${base}/map/mapshow/getCommunityData',
		dataType : 'json',
		async : false,
		success : function(rows) {
			var show = "[";
			for(var i  = 0;i<rows.length;i++){
				var row = rows[i];
				show += "{\"NAME\":\""+row.name+"\",\"POSITION\":\""+row.position+"\",\"HTML\":\"<div style='height:280px;width:500px;overflow:auto;'><iframe width='100%' height='350px' marginheight='0' marginwidth='0' scrolling='no' frameborder='0'  src='${base}/map/mapshow/showCommunityDetail?code="+row.code+"'></iframe></div>\"},";
			}
			show = show.substring(0,show.length-1)+"]";
			drawmapshow(show, true, true,true);
		}
	});
};
var showStreet=function(){
	$.ajax({
		type:'post',
		url:'${base}/map/mapshow/getStreetData',
		dataType : 'json',
		async : false,
		success : function(rows) {
			var show = "[";
			for(var i  = 0;i<rows.length;i++){
				var row = rows[i];
				show += "{\"NAME\":\""+row.name+"\",\"POSITION\":\""+row.position+"\",\"HTML\":\"<div style='height:280px;width:500px;overflow:auto;'><iframe width='100%' height='500px' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/map/mapshow/showStreetDetail?code="+row.code+"'></iframe></div>\"},";
			}
			show = show.substring(0,show.length-1)+"]";
			drawmapshow(show, true, true,true);
		}
	});
};
var showStore=function(){
	$.ajax({
		type:'post',
		url:'${base}/map/mapshow/getStoreData',
		dataType : 'json',
		async : false,
		success : function(rows) {
			var show = "[";
			for(var i  = 0;i<rows.length;i++){
				var row = rows[i];
				show += "{\"NAME\":\""+row.name+"\",\"POSITION\":\""+row.position+"\",\"HTML\":\"<div style='height:280px;width:500px;overflow:auto;'><iframe width='100%' height='500px' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/map/mapshow/showStoreDetail?code="+row.code+"'></iframe></div>\"},";
			}
			show = show.substring(0,show.length-1)+"]";
			drawmapshow(show, true, true,true);
		}
	});
};
</script>

</head>

<body>
<div style="width: 100%;height: 580px;">
		<div style="width: 100%; height: 30px;margin-top:5px;z-index: 10; position: absolute;">
			<div id="accordion" class="accordion-style1 panel-group" style="margin-top: 1px;filter: Alpha(Opacity=50);-moz-opacity:0.8;opacity: 0.8;height: 20px;">
				<div class="panel panel-default" style="height:30px;">
					<div class="panel-heading" >
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseOne" style="margin-top: -7px;">
								&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-minier btn-yellow" onclick="showGrid()">网格概况
								</button>
								<button class="btn btn-minier btn-yellow" onclick="showCommunity()">社区概况
								</button>
								<button class="btn btn-minier btn-yellow" onclick="showStreet()">街道概况
								</button>
								<button class="btn btn-minier btn-yellow" onclick="showStore()">单位门店概况
								</button>
							</a>
						</h4>
					</div>
				</div>
			</div>
		</div>
		<div id="map" style="width: 100%;height: 100%; "></div>
</div>
</body>
</html>
