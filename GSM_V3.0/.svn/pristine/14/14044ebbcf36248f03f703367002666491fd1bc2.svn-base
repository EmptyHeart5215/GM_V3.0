<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include page="/resource/base_import.jsp" />


<script type="text/javascript">
$(function() {
		 
	$("#imgClose").click(function(){
	    $("#userOfdeviceList").hide();
	});
	NMapsShow({
		id : "map"
	});
	
	//$("#datetimepicker").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
	 $('.form_datetime').datetimepicker({
	        //language:  'fr',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
	        showMeridian: 1
	    });
	 
	 $.ajax({
		    type: "POST",
		    url: "${base}/sys/user/queryUserByName?username=1",
		    dataType: "json",
		    success: function(data){
		    var	availableTags=data;
		    $( "#gpsUsercode" ).autocomplete({
		        source: availableTags,
		        select: function(event, ui){
		        	event.preventDefault();
		    		// 这里的this指向当前输入框的DOM元素
		    		// event参数是事件对象
		    		// ui对象只有一个item属性，对应数据源中被选中的对象
		    		$("#gpsUsercode").val(ui.item.label)
		    		$("#gpsUsercodes").val(ui.item.value);
		    		// 必须阻止默认行为，因为autocomplete默认会把ui.item.value设为输入框的value值
		    		event.preventDefault();		
		    	}
		     });
		    }
			
		});
	
}); 
Date.prototype.Format = function(fmt){ //author: meizz   
	  var o = {   
			    "M+" : this.getMonth()+1,                 //月份   
			    "d+" : this.getDate(),                    //日   
			    "h+" : this.getHours(),                   //小时   
			    "m+" : this.getMinutes(),                 //分   
			    "s+" : this.getSeconds(),                 //秒   
			    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
			    "S"  : this.getMilliseconds()             //毫秒   
			  };   
			  if(/(y+)/.test(fmt))   
			    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
			  for(var k in o)   
			    if(new RegExp("("+ k +")").test(fmt))   
			  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
			  return fmt;   
}
function userOfdeviceList(){
	$("#userOfdeviceList").show();
	$("#table").html("<table id=\"grid-table\"></table><div id=\"grid-pager\"></div>");
	$("#grid-table").jqGrid({
	 	url : "${base }/sys/gpsdevice/queryDeviceForUserParamPage",
	 	defaultCaozuo:false,
	 	colNames:[ '字典主键','设备IMEI','登录名称','所属辖区','部门','状态'],
        colModel:[
			{name:'code',index:'code',sortable:false, hidden:true},
            {name:'gpsImei',index:'gpsImei',sortable:false, hidden:true},
            {name:'loginName',index:'loginName',sortable:true, width:'16%'},
            {name:'gridName',index:'gridName',sortable:true, width:'23%'},
            {name:'departmentName',index:'departmentName', width:'23%', sortable:false},
            {name:'maxDate',index:'maxDate',sortable:true, width:'9%',formatter:
            	function(cellvalue, options, rowObject){
            		var maxDate=rowObject['maxDate'];
            		var nowDate = new Date();
            		maxDate = new Date(maxDate);
            		if(maxDate == ""){
            			return "暂无记录";
            		}else{
        				if((nowDate.getTime()-maxDate.getTime())<5*60*1000){
        					return "<a href='javascript:void(0)'><span class='glyphicon glyphicon-phone'></span></a>在线";
        				}else{
        					return "<span class='glyphicon glyphicon-phone'></span>离线"
        				}
            		}
            	}
            },
        ],
        sortable:false,
        rownumbers:true,//添加左侧行号
        altRows:true,//班玛线
        sortname:'createDate',
        sortorder:'desc',
        viewrecords: true,//是否在浏览导航栏显示记录总数
        rowNum:3,//每页显示记录数
        rowList:[6,9,12],//用于改变显示行数的下拉列表框的元素数组。
        multiselect: false,
        hidegrid:false,
        pager:$('#grid-pager'),
        caption: "历史轨迹人员设备列表"
    });
	
	//搜索按钮方法
	 $("#search").click(function(){
			var postData=$("#search_form").serializeJson();
			$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
	});
	//重置
	$("#reset").click(function() {
		$("#gpsUsercodes").val("");
	});
}
 
/**
 * 前一天
 */
function theDayBefore(){
	var dateTime1 = $("#dateTime1").val();
	if(dateTime1 != ""){
		var dtStr = $("#dateTime1").val().substring(0, 10);
	    var dtArr = dtStr.split("-");
	    var dd = new Date(dtArr[0], dtArr[1]-1, dtArr[2]);
	    var n = dd.getTime() - 1 * 24 * 60 * 60 * 1000;
	    var result = new Date(n).Format("yyyy-MM-dd hh:mm:ss");
	    //alert(result.getFullYear())
	    result = result.substring(0,10)
	    $("#dateTime1").val(result+ " 00:00:01");
	    $("#dateTime2").val(result+ " 23:59:59");
	}else{
		bootbox.alert('请填写开始时间以及结束时间！');
	}
	
}
/**
 * 后一天
 */
function theDayAfter(){
	var dateTime1 = $("#dateTime1").val();
	if(dateTime1 != ""){
		var dtStr = $("#dateTime1").val().substring(0, 10);
	    var dtArr = dtStr.split("-");
	    var dd = new Date(dtArr[0], dtArr[1]-1, dtArr[2]);
	    var n = dd.getTime() + 1 * 24 * 60 * 60 * 1000;
	    var result = new Date(n).Format("yyyy-MM-dd hh:mm:ss");
	    //alert(result.getFullYear())
	    result = result.substring(0,10)
	    $("#dateTime1").val(result+ " 00:00:01");
	    $("#dateTime2").val(result+ " 23:59:59");
	}else{
		bootbox.alert('请填写开始时间以及结束时间！');
	}
	
}
/**
 * 开始
 */
function playStart(){
	clearMap();
	$("#userOfdeviceList").hide();
	$("#loaddata").show();
	var rowid = $("#grid-table").getGridParam("selrow");
	var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
	var name = rowData.loginName;
	$("#n").text(name);
	var code = rowData.code
	var deviceImei = rowData.gpsImei;
	var dateTime1 = $("#dateTime1").val();
	var dateTime2 = $("#dateTime2").val();
	if(dateTime1 !=""){
		$.ajax({
			type : "POST",
			url : "${base}/emergencyscheduling/gpsmaphistorypath/historyGps?t=" + Math.random(),
			data:{deviceImei:deviceImei,dateTime1: dateTime1, dateTime2: dateTime2 },
			dataType : "json",
			success : function(data) {
				var Track = "[";
				for(var i=0;i<data.length;i++){
					 Track += "{\"POSITION\":\""+data[i].position+"\", \"HTML\":\""+data[i].html+"\",\"NAME\":\""+data[i].name+"\" },";
					 
			     }
				if(Track.length == 1){
					
				}else{
				Track = Track.substring(0,Track.length-1)+"]";
				 Track = eval("(" + Track + ")");
				 pointdata(Track);
				}
			}
		});
	}else{
		bootbox.alert('请填写开始时间以及结束时间！');
	}
	
	
}
/**
 * 继续
 */
function playContinue(){
	guijistart();
}
/**
 * 加速
 */
function fastForward(){
	guijifast();
}
/**
 * 暂停
 */
function playPause(){
	guijistop();
}
/**
 * 停止
 */
function playStop(){
	clearMapTrack();
	$("#loaddata").hide();
}
/**
 * 减速
 */
function slowDown(){
	guijislow();
}
</script>
<style type="text/css">

#codeEducation_div{
	width: 120px;
}
#partymemberDiv{
  border:1px solid #D4DDE5;
}
#partyOrganDiv{
  border:1px solid #D4DDE5;
}
#close:hover {
  background-color:#EBEEF0
}
</style>
</head>

<body>
<div style="width: 100%;height: 600px;">
		<div style="width: 100%; height: 30px;margin-top:5px;z-index: 10; position: absolute;">
			<div id="accordion" class="accordion-style1 panel-group" style="margin-top: 1px;filter: Alpha(Opacity=50);-moz-opacity:0.8;opacity: 0.8;height: 20px;">
				<div class="panel panel-default" style="height:30px;">
					<div class="panel-heading" >
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseOne" style="margin-top: -7px;">
								&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-minier btn-yellow" onclick="userOfdeviceList();">历史轨迹人员设备列表
								  <i class="icon-angle-down icon-on-right"></i>
								</button>
							</a>
						</h4>
					</div>
				</div>
			</div>
		</div>
		<div id="map" style="width: 100%;height: 600px; "></div>
		<div id="userOfdeviceList" class="" style="width: 600px; height: 350px; position: absolute; top: 40px; left: 50px;background-color: #FFFFFF;z-index: 10;filter: Alpha(Opacity=50);-moz-opacity:0.8;opacity: 0.8;" hidden="hidden">
		  <div style="width: 444px; height: 30px;background-color: #F8F8F8">
		    <div style="margin-top: 5px;margin-left: 10px;"><b>历史轨迹人员设备列表</b></div>
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
		  <form id="search_form">
		   <table width="100%" border="0">
		     <tr height="32px;"> 
		       <td width="10%" style="text-align:right">登录名称</td>
		       <td width="25%">
		         <input style="height: 32px;" id = "gpsUsercode" type="text" class="text col-xs-12">
		         <input name="gpsUsercode" id = "gpsUsercodes" type="hidden">
		       </td>
		       <td width="10%"style="text-align:right">登录状态</td>
		       <td width="25%">
					<select  id="gpsStateString" name = "gpsStateString"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						<option  value="2">--请选择--</option>
						<option  value="1">在线</option>
						<option  value="0">离线</option>
				  </select>
		       </td>
		       <td width="10%">
		          <button type="button" class="btn btn-info" id="search">
		                        查询
					<i class="icon-search bigger-110 "></i>
				  </button>
		       </td>
		       <td width="10%">
		         <button type="reset" class="btn btn-info" id="reset">重置
					<i class="glyphicon glyphicon-arrow-left bigger-110 "></i>
				</button>
		       </td>
		     </tr>
		     </tr>
		   </table>
		   </form>
		   <div  id="table" class="widget-box transparent collapsed" style="margin:0px;z-index: 10;height: 230px;"></div>
		    <table width="100%" border="0" style="margin-top: -23px;text-align: center;">
		      <tr height="30px;">
		        <td width="10%">开始时间</td>
		        <td width="25%">
		          <div  id="datetimepicker" data-date-format="ss dd MM yyyy - HH:ii p" class="col-xs-12 input-group">
				  <input size="16" type="text" id="dateTime1" name="dateTime1" class="form_datetime">
					 <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				   </div>
		        </td>
		        <td><a href="javascript:void(0)" onclick="theDayBefore()"><span class="glyphicon glyphicon-step-forward"></span>前一天</a></td>
		        <td><a href="javascript:void(0)" onclick="playStart()"><span class="glyphicon glyphicon-play"></span>开始</a></td>
		        <td><a href="javascript:void(0)" onclick="playContinue()"><span class="glyphicon glyphicon-expand"></span>继续</a></td>
		        <td><a href="javascript:void(0)" onclick="fastForward()"><span class="glyphicon glyphicon-fast-forward"></span>加速</a></td>
		      </tr>
		       <tr height="30px;">
		        <td width="10%">结束时间</td>
		        <td width="25%">
		           <div  id="datetimepicker" data-date-format="dd MM yyyy - HH:ii p" class="col-xs-12 input-group">
				  <input size="16" type="text" id="dateTime2" name="dateTime2" class="form_datetime">
					 <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				   </div>
		        </td>
		        <td><a href="javascript:void(0)" onclick="theDayAfter()"><span class="glyphicon glyphicon-step-backward"></span>后一天</a></td>
		        <td><a href="javascript:void(0)" onclick="playPause()"><span class="glyphicon glyphicon-pause"></span>暂停</a></td>
		        <td><a href="javascript:void(0)" onclick="playStop()"><span class="glyphicon glyphicon-stop"></span>停止</a></td>
		        <td><a href="javascript:void(0)" onclick="slowDown()"><span class="glyphicon glyphicon-fast-backward"></span>减速</a></td>
		      </tr>
		    </table>
		</div>
</div>
<div id="loaddata"
		style="position: absolute; left: 40%; top: 40px; background: #0096bb; color: white; width: 250px; height: 20px; text-align: center; line-height: 20px; display: none;z-index:9;">正在调取登录名为：<span id="n"></span>&nbsp;&nbsp;历史轨迹数据</div>
</body>
</html>
