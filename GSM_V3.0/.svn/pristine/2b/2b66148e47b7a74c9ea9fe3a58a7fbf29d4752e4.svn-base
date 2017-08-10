<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include page="/resource/base_import.jsp" />
<script type="text/javascript">
$(function() {
	$('#beSmall').bind('click',function(){
		if($('#table').css('width')=='0px'){
			$('#table').animate({ width:"100%",height:"230px" },1000);
			$(this).attr("class"," icon-double-angle-left bigger-140");
		}else{
			$('#table').animate({ width:"0px",height:"0px" },1000);
			$(this).attr("class"," icon-double-angle-right bigger-140");
		}
	});
	$("#stepId").ztreeGrid({
		url:"${base}/event/econtradict/queryAllTreeSteps",			
		name:"name",
		pIdKey:"parentCode",
		checkBox:true,
		reset:true,
	    resetId:'reset'
	});
 $("[name='codeEventFrom']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_FROM',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo',
		checkBox:true
		});
 $("[name='codeEventType']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_TYPE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo',
		checkBox:true
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
	$("#imgCloses").click(function(){
	    $("#partymemberDiv").hide();
	});
	NMapsShow({
		id : "map"
	});
	$("#reSearch").click(function(){
		clearMap();
		
		$.ajax({ url: "${base }/event/econtradict/mapwanJieManage", success: function(data){
			
			var show = "[";
			$.each(data,function(n,value) {
			 		  show += "{\"POSITION\":\""+value.position+"\",\"count\":\""+value.counts+"\"},";
		           });  
			show = show.substring(0,show.length-1)+"]";

			 heatmapshow(jQuery.parseJSON(show));
	      }});
	});
	$("#mapSearchSearch").click(function(){
		var postData={"args":JSON.stringify($("#search_form").serializeJson())};
		$("#mapSearchDiv").hide();
		if($('#table').css('width')=='0px'){
			$('#table').animate({ width:"100%",height:"230px" },0);
			$('#beSmall').attr("class"," icon-double-angle-left bigger-140");
		}
		$("#table").html("<table id=\"grid-table\"></table><div id=\"grid-pager\"></div>");
		$("#grid-table").jqGrid({
			url : "${base }/yanpanfenxi/contradictquery/zongheManage",
			defaultCaozuo:false,
		      multiselect:false,
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
		 		 var Name = rowData.eventTitle;
		 		 var position = rowData.position;
		 		 var code = rowData.code;
		 		 var stepId = rowData['step.stepId'];
		 		 var entryId = rowData['step.entryId'];
		 		  var show = "[";
		 		  show += "{\"NAME\":\""+Name+"\",\"POSITION\":\""+position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:450px;width:800px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/event/econtradict/detailLoad?eventCode="+code+"&stepId="+stepId+"&entryId="+entryId+"'></iframe></div>\"},";
		 		 show = show.substring(0,show.length-1)+"]";
		 		 drawmapshow(show, true, true, true);
		    },
		 	datatype:"json", //数据来源，本地数据
		 	postData:postData,
		 	mtype:"POST",//提交方式
		 	 colNames:['序号', '','','受理编号', /* '事件预警', */'事件状态','所属辖区','当事人','矛盾类型','矛盾主题','受理时间',''],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'step.stepId',sortable:false, hidden:true},
					{name:'step.entryId',sortable:false, hidden:true},
		            {name:'eventNum',index:'eventNum',sortable:true, width:100,fixed:true},
		            /* {name:'alertLight',index:'alertLight',sortable:true, width:80,fixed:true}, */
		            {name:'stepName',index:'stepName', width:80,fixed:true},
		            {name:'gridTotalName',index:'gridTotalName', width:'30%'},
		            {name:'dangShiRenName',index:'dangShiRenName', width:'10%'},
		            {name:'dicValueMap.codeEventType', width:'15%'},
		            {name:'eventTitle',index:'eventTitle', width:'15%'},
		            {name:'banLiDate',index:'shouLiDate', width:'15%'},
	            {name:'position',index:'position',hidden:true}
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
	        caption: "矛盾查询列表",
	        loadComplete:mapSearchLoad
	    });
		//$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
	});
	$("#mapSearchSearch").click();
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
		show += "{\"NAME\":\""+row.eventTitle+"\",\"POSITION\":\""+row.position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:450px;width:500px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/event/econtradict/detailLoad?eventCode="+row.code+"&stepId="+row['step.stepId']+"&entryId="+row['step.entryId']+"'></iframe></div>\"},";
	}
	show = show.substring(0,show.length-1)+"]";
	drawmapshow(show, true, false,false);
	}
}
</script>
<style type="text/css">

#codeEducation_div{
	width: 120px;
}
#partymemberDiv{
  border:1px solid #D4DDE5;
}
#close:hover {
  background-color:#EBEEF0
}
#grid-table tr{
background-image: none;
background-color: #f9f9f9;
opacity: 0.8;}
</style>
</head>

<body>

<div style="width: 100%;height: 580px;">
		<div style="width: 100%; height: 30px;text-align:center;z-index: 10; position: absolute;">
								<button style="margin-top:-3px;" class="btn btn-minier btn-yellow" onclick="showmapSearch();">矛盾纠纷查询
								  <i class="icon-angle-down icon-on-right"></i>
								</button>
		</div>
		<div id="beSmall" class="icon-double-angle-left bigger-140"style="background: #478fca !important;cursor: pointer;width:20px;margin:0px;z-index: 11;margin:380px 0px 0px;height: 21px; position:absolute;display: inline;text-indent: 0px;color: white;">
		</div>
		<div  id="table" class="widget-box transparent collapsed" style="overflow:hidden;width: 100%;margin:400px 0px 0px;z-index: 10;height: 230px; position:absolute">
			 <table id="grid-table"></table>
			 <div id="grid-pager"></div> 
		</div> 
		<div id="map" style="width: 100%;height:100%; "></div>
		
		<div id="mapSearchDiv" class=""  hidden="hidden">
		  <div style="width:100%; height: 30px;background-color: #F8F8F8">
		    <div style="margin-top: 5px;margin-left: 10px;"><b>矛盾 查询条件</b></div>
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
		        <td width="10%">矛盾主题</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="eventTitle" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		         <td width="10%">矛盾类型</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text" name="codeEventType" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		        
		      </tr>
		      <tr height="28px;">
		       <td width="10%">当事人</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text" name="dangShiRenName" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		         <td width="10%">事件状态</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text"name="stepId"id="stepId" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		      </tr>
		      <tr height="28px;">
		        <td width="10%">受理时间</td>
		        <td  colspan="3">
		         <div class="col-xs-12 input-group" >
					<input class="col-xs-12 col-sm-12 form-control date-range-picker"name="shouLiDate" type="text"/>
					<span class="input-group-addon">
						<i class="icon-calendar bigger-110"></i>
					</span>
				</div>
		        </td>
		      </tr>
		       <tr height="5px;">
		        <td colspan="6"></td>
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
		                 <button type="button" class="btn btn-info" id="reSearch">热点查询
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
