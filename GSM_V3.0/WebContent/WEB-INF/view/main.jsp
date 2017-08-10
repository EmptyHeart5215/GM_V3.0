<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>社会管理网格化系统V3.0</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <jsp:include page="/resource/base_import.jsp"/>
    <jsp:include page="/resource/js/highcharts/myHighChartsOperator.jsp"/>
</head>
<body>
<script type="text/javascript">
function successFun(){
	bootbox.hideAll();
	bootbox.slideAlert('body');
	jQuery("#grid-table-econtradict").trigger("reloadGrid"); 
	jQuery("#grid-table-eevent").trigger("reloadGrid"); 
 }
function banLiFun(code,stepId,entryId,title,url){
	bootbox.dialog({
		 url:"${base}/event/"+url+"/approvalLoad?eventCode="+code+"&stepId="+stepId+"&entryId="+entryId,
		  title: title+"处理表",
		  iframeStyle:'height:1500px;',
		  showFunctionBtn:false,
		  style:'width:1000px;height:600px;'
		});
}
$(function(){
	//矛盾待办
 $("#grid-table-econtradict").jqGrid({
	 	url : "${base }/event/econtradict/daibanManage",
      defaultCaozuo:false,
      multiselect:false,
      ondblClickRow:function(rowid,iRow,iCol,e){
    	  var code=$('#grid-table-econtradict').jqGrid('getGridParam', "selrow");
    	  var rowData = $('#grid-table-econtradict').jqGrid("getRowData",code);
    	  banLiFun(code,rowData['step.stepId'],rowData['step.entryId'],'矛盾','econtradict');
      },
        colNames:['序号', '','','受理编号', '事件预警','事件状态','所属辖区','矛盾主题'],
        colModel:[
			{name:'code',index:'code',sortable:false, hidden:true},
			{name:'step.stepId',sortable:false,hidden:true},
			{name:'step.entryId',sortable:false,hidden:true},
			{name:'eventNum',index:'eventNum', width:100,fixed:true},
            {name:'alertLight',index:'alertLight',width:80,fixed:true,formatter:function(cellvalue, options, rowObject){
            	 if(cellvalue){
            		var img="<img src='/GSM_V3.0/resource/images/"+cellvalue+"light.gif'/>";
					return img;
            	}else{
            		return '无';
            	}
            }},
            {name:'stepName',index:'stepName', width:80,fixed:true},
            {name:'gridTotalName',index:'gridTotalName', width:'30%'},
            {name:'eventTitle',index:'eventTitle', width:'15%'}
       
        ],
        jsonReader:{
            id: "code",//设置返回参数中，表格ID的名字为CODE
            repeatitems : false
        },
        sortname:'createDate',
        sortorder:'desc'
    });
	//事件
	$("#grid-table-eevent").jqGrid({
	 	url : "${base }/event/eevent/daibanManage",
      defaultCaozuo:false,
      multiselect:false,
      rowNum:10,//每页显示记录数
      rownumbers:false,
      ondblClickRow:function(rowid,iRow,iCol,e){
    	  var code=$('#grid-table-eevent').jqGrid('getGridParam', "selrow");
    	  var rowData = $('#grid-table-eevent').jqGrid("getRowData",code);
    	  banLiFun(code,rowData['step.stepId'],rowData['step.entryId'],'事件','eevent');
      },
        colNames:['序号', '','','受理编号', '事件预警','事件状态','所属辖区或部门','矛盾主题'],
        colModel:[
			{name:'code',index:'code',sortable:false, hidden:true},
			{name:'step.stepId',sortable:false,hidden:true},
			{name:'step.entryId',sortable:false,hidden:true},
			{name:'eventNum',index:'eventNum', width:100,fixed:true},
            {name:'alertLight',index:'alertLight',width:80,fixed:true,formatter:function(cellvalue, options, rowObject){
            	if(cellvalue){
            		var img="<img src='/GSM_V3.0/resource/images/"+cellvalue+"light.gif'/>";
					return img;
	            }else{
	        		return '无';
	        	}
            }},
            {name:'stepName',index:'stepName', width:80,fixed:true},
            {name:'gridTotalName',index:'gridTotalName', width:'70%'},
            {name:'eventTitle',index:'eventTitle', width:'30%'}
           
        ],
        jsonReader:{
            id: "code",//设置返回参数中，表格ID的名字为CODE
            repeatitems : false
        },
        sortname:'createDate',
        sortorder:'desc'
    });
 $("#eeventDiv").removeClass("active");
 
 //公告
 
 $("#grid-table-gongGao").jqGrid({
	 defaultCaozuo:false,
	  rowNum:5,//每页显示记录数
      rownumbers:false,
	 	url : "${base }/sys/rnotice/queryManage",
     ondblClickRow:function(rowid,iRow,iCol,e){
		    bootbox.dialog({
				url:"${base}/sys/rnotice/infoSee?code="+rowid,
				title: "公告信息",
				style:'width:800px;height:500px;',
				showFunctionBtn:false,
				});
	      },
     colNames:[ '字典主键','内容','发布时间'],
     colModel:[
			{name:'code',index:'code',sortable:false, hidden:true},
         {name:'content',index:'content',sortable:false, width:'25%'},
         {name:'createDate',index:'createDate',sortable:false, width:'10%'}
     ],
     sortname:'createDate',
     sortorder:'desc',
     multiselect: false,
     jsonReader:{
         id: "code",//设置返回参数中，表格ID的名字为CODE
         repeatitems : false
     }
    
 });
 
 //上月考核统计
chartTitle="考核统计";
		$.ajax({
					type : "post",
					url : "${base}/sys/main/staticForIndex",
					dataType : 'text',
					async : true,
					success : function(data) {
						data = eval("(" + data + ")");
						var total = data.total;
						if (data.categories) {
							var name = data.categories.split(',');
							var count = data.seriesdata.split(',');
							// var percentage=data.percentage.split(",");
							cartegories = [];
							seriesdata = [];
							for (var i = 0; i < count.length; i++) {
								seriesdata.push([ name[i] + "," + count[i],
										parseInt(count[i]) ]);
								cartegories.push(name[i]);
								var percen = ((count[i] / total) * 100)
										.toFixed(2)
										+ "%";
							}
						}
						showChartZhe(seriesdata, cartegories, "line");
					}
				});
		//人口统计
		$.ajax({
			type : "post",
			url : "${base}/sys/main/queryPersonTypeStatistics",
			dataType : 'text',
			async : true,
			success : function(data) {
				data = eval("(" + data + ")");
				$('#xiaQuRen').html('<div >实有人口：'+data.SHI+'人</div> <div >境外人口：'+data.WAI+'人</div> <div>常住人口：'+data.CHANG+'人</div> <div>流动人口：'+data.LIU+'人</div> <div>户籍人口：'+data.HU+'人</div> <div><i style="color:red;" class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;男性：'+data.NAN+'人&nbsp;&nbsp;&nbsp;&nbsp;<i style="color:green;" class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;女性：'+data.NV+'人</div>');
				$('#xiaQuDanWei').html('<div> <i style="color:purple"class="glyphicon glyphicon-shopping-cart"></i>&nbsp;&nbsp;单位门店：'+data.MEN+'个</div>');
				$('#xiaQuFang').html(' <div>自住房：<b>'+data.ZI+'</b>&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出租房：<b>'+data.CHU+'</b>&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空置房：<b>'+data.KONG+'</b>&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民宿：<b>'+data.MIN+'</b>&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他：<b>'+data.QI+'</b>&nbsp;间</div>');
				var cartegories = [];
				cartegories.push("境外");
				cartegories.push("常住");
				cartegories.push("流动");
				var seriesdata = [];
				seriesdata.push(["境外," +data.WAI,parseInt(data.WAI)]);
				seriesdata.push(["常住," +data.CHANG,parseInt(data.CHANG)]);
				seriesdata.push(["流动," +data.LIU,parseInt(data.LIU)]);
				$('#containerPie').highcharts(
						{
							chart : {
								type : "pie",
								borderColor : '#99BCE8',
								borderWidth : 1,
								marginTop:15
							},
							title : {
								text : '<div style="width:56px;font-size:11px;"><div style="text-align:center">实有人口</div><div style="text-align:center">'+data.SHI+'</div></div>',
								verticalAlign:'middle',
								y:-5,
								useHTML:true
							},
							tooltip : {
								formatter : function() {
										return Highcharts.numberFormat(
												this.percentage, 2)
												+ '%';
								}
							},
							plotOptions : {
								pie : {
									size:200,
									innerSize:'11',
									allowPointSelect : true, //选中某块区域是否允许分离
									cursor : 'pointer',
									dataLabels : {
										distance:18,
										enabled : true
									//是否直接呈现数据 也就是外围显示数据与否
									},
									colors:['#b74635','#e59729','#629b58'],
									showInLegend : false
								}
							},
							series : [ {
								size : '100%',
								data : seriesdata
							} ]
						});
			}
		});
});

</script>

<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="col-xs-6 col-sm-6" style="padding-left: 1px;padding-right: 1px;">
			<div class="tabbable tabs-top">
			<ul class="nav nav-tabs" id="myTab3">
				<li class="active">
						<a data-toggle="tab" href="#econtradictDiv">
							<i style="color:#ffb752"class=" icon-bell-alt bigger-110"></i>
							矛盾待办
						</a>
				</li>
				<li>
						<a data-toggle="tab" id="eventId" href="#eeventDiv">
							<i style="color:#ffb752"class=" icon-bell bigger-110"></i>
							事件待办
						</a>
				</li>
			</ul>
			<div class="tab-content" style="overflow:auto;max-height:460px;min-height:200px;padding:0px;" >
				<div id="econtradictDiv" class="tab-pane in active">
					<table id="grid-table-econtradict">
					
					</table>
					<div id="grid-pager-econtradict"></div>
				</div>
				<div id="eeventDiv" class="tab-pane in active">
					<table id="grid-table-eevent">
					
					</table>
					<div id="grid-pager-eevent"></div>
				</div>
			</div>
				
			</div>
		</div>
		<div class="col-xs-6 col-sm-6"style="padding-left: 1px;padding-right: 1px;">
		<div class="tabbable tabs-top">
			<ul class="nav nav-tabs" id="myTab3">
				<li class="active">
						<a data-toggle="tab" href="#gongGaoDiv">
							<i style="color: #e59729"class=" icon-bullhorn bigger-110"></i>
							公告
						</a>
				</li>
				
			</ul>
			<div class="tab-content" style="overflow:auto;max-height:460px;min-height:200px;padding:0px;" >
				<div id="gongGaoDiv" class="tab-pane in active">
					<table id="grid-table-gongGao">
					
					</table>
					<div id="grid-pager-gongGao"></div>
				</div>
				
			</div>
		</div>
		</div>
		<div class="space-30" style="width: 100%;"></div>
		<div class="col-xs-6 col-sm-6"style="padding-left: 1px;padding-right: 1px;">
			<div class="tabbable tabs-top">
				<ul class="nav nav-tabs" id="myTab3">
					<li class="active">
							<a data-toggle="tab" href="#gongGaoDiv">
								<i class="pink icon-bar-chart bigger-110"></i>
								上月考核统计
							</a>
					</li>
					
				</ul>
				<div class="tab-content" style="overflow:auto;height:200px;padding:0px;" >
					<div id="gongGaoDiv" style="height:100%"class="tab-pane in active">
						<div id="containerLine" style="width: 100%;height: 100%;float: left;"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-6 col-sm-6"style="padding-left: 1px;padding-right: 1px;">
			<div class="tabbable tabs-top">
				<ul class="nav nav-tabs" id="myTab3">
					<li class="active">
							<a data-toggle="tab" href="#xiaQuDiv">
								<i style="color:#1b6aaa" class=" icon-align-justify bigger-110"></i>
								辖区信息
							</a>
					</li>
					
				</ul>
				<div class="tab-content" style="overflow:auto;height:200px;padding:0px;" >
					<div id="xiaQuDiv" style="height:100%;padding:2px;"class="tab-pane in active">
					    <div id="containerPie" style="width: 50%;height: 60%;float: left;"></div>
					    <div id="xiaQuRen"style="font-size:12px;padding-left:10px;padding-top:5px;"class="col-xs-6">
					    
					    </div>
					    <div id="xiaQuDanWei"style="background-color:#e0e0e0 !important;font-size:12px;padding-left:10px;padding-bottom:5px;padding-top:5px;margin-top:5px;"class="col-xs-12">
					   
					     </div>
					    <div id="xiaQuFang" style="font-size:12px;padding-left:10px;padding-top:15px;"class="col-xs-12">
					    
					    </div>
					 </div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>