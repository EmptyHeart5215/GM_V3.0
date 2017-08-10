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
	
	var hidinput = $("#hidinput").val();
	if(hidinput == ""){
		$("#pl").attr("class","glyphicon glyphicon-play");
	}else{
	}
	$.ajax({
	    type: "POST",
	    url: "${base}/sys/user/queryUserByName?username=1",
	    dataType: "json",
	    success: function(data){
	    var	availableTags=data;
	    $( "#gpsUsercode" ).autocomplete({
	        source: availableTags,
	        select: function(event, ui){
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
function actualTrack(code,gpsImei){
	var deviceImei = gpsImei;
	var code = code;
	$.ajax({
		type : "POST",
		url : "${base}/emergencyscheduling/gpsmaprealtimemonitoring/actualGps?t=" + Math.random(),
		data:{deviceImei: deviceImei,code:code},
		dataType : "json",
		success : function(data) {
			//alert(data)
			var Track = "[";
			for(var i=0;i<data.length;i++){
				 Track += "{\"POSITION\":\""+data[i].position+"\", \"HTML\":\""+data[i].html+"\",\"NAME\":\""+data[i].name+"\" },";
				 
		     }
			if(Track.length == 1){
				
			}else{
			Track = Track.substring(0,Track.length-1)+"]";
			/*alert(Track[i].position)
			 stTrack(Track);*/
			 Track = eval("(" + Track + ")");
			 stTrack(Track);
			}
                            
		}
	});
}
var timeID;
function start(){
	var rowid = $("#grid-table").getGridParam("selrow");
	var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
	if(rowid != null){
		var oldCode= $("#hidinput").val();
	    if(oldCode == ""){
		    var code = rowData.code;
		    var gpsImei = rowData.gpsImei;
		    $("#hidinput").val(code);
			 $("#code").val(code);
			 $("#userOfdeviceList").hide();
			 $("#loaddata").show();
			 $("#pl").removeClass('glyphicon glyphicon-play');
			 $("#pl").addClass('glyphicon glyphicon-pause');
			 timeID = window.setInterval("actualTrack(\""+code+"\",\""+gpsImei+"\")", 10 * 1000);
	    }else{
	    	if(oldCode != rowData.code){
	    		bootbox.alert('同时只能监控一个设备！');
	    	}
	    }
	}else{
		bootbox.alert('请至少选择一条信息！');
	}
	
}
function stop(){
	var rowid = $("#grid-table").getGridParam("selrow");
	if(rowid != null){
		var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
		var code = rowData.code;
		$("#hidinput").val("");
		startCode = $("#code").val();
		$("#pl").removeClass('glyphicon glyphicon-pause');
		$("#pl").attr("class","glyphicon glyphicon-play");
		if(code == startCode){
			$("#userOfdeviceList").hide();
			$("#loaddata").hide();
			window.clearInterval(timeID)
		}else{
			bootbox.alert('用户不符，请选择与之对应的用户或设备');
		}
	}else{
		bootbox.alert('请至少选择一条信息！');
	}
	
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
            {name:'loginName',index:'loginName',sortable:true, width:'18%'},
            {name:'gridName',index:'gridName',sortable:true, width:'30%'},
            {name:'departmentName',index:'departmentName', width:'25%', sortable:false},
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
            /* {name:'caozuo',width:100,fixed:true, sortable:false, resize:false,formatter:
            	function(cellvalue, options, rowObject){
            	   var code=rowObject['code'];
            	   var gpsImei=rowObject['gpsImei'];
            	   var div='<div style="margin-left:6px;">';
	            	div+="<div title='开始' style='float:left;cursor:pointer;' onclick='start(\""+code+"\",\""+gpsImei+"\")'>";
		            div+='<a href="#"><span id="icon_play" class="glyphicon glyphicon-play"></span> 开始</a>';
       				div+="</div> <div  class='ui-pg-div ui-inline-del'title='停止' style='float:left;margin-left:5px;'onclick='stop(\""+code+"\")'>";
       				div+='<a href="#"><span class="glyphicon glyphicon-stop"></span>停止</a>';
      				div+='</div>';
      				div+='</div>';
	            	return div;
            	 }
             }  */
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
        pager:$('#grid-pager'),
        caption: "实时轨迹人员设备列表"
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
</script>
<style type="text/css">
#userOfdeviceList{
  border:1px solid #D4DDE5;
}
</style>
</head>

<body>
<input name="code" id = "code" type="hidden">
<div style="width: 100%;height: 600px;">
		<div style="width: 100%; height: 30px;margin-top:5px;z-index: 10; position: absolute;">
			<div id="accordion" class="accordion-style1 panel-group" style="margin-top: 1px;filter: Alpha(Opacity=50);-moz-opacity:0.8;opacity: 0.8;height: 20px;">
				<div class="panel panel-default" style="height:30px;">
					<div class="panel-heading" >
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#collapseOne" style="margin-top: -7px;">
								&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-minier btn-yellow" onclick="userOfdeviceList();">实时轨迹人员设备列表
								  <i class="icon-angle-down icon-on-right"></i>
								</button>
							</a>
						</h4>
					</div>
				</div>
			</div>
		</div>
		<div id="map" style="width: 100%;height: 600px; "></div>
		<div id="userOfdeviceList" class="" style="width: 600px; height: 352px; position: absolute; top: 40px; left: 50px;background-color: #FFFFFF;z-index: 10;filter: Alpha(Opacity=50);-moz-opacity:0.8;opacity: 0.8;" hidden="hidden">
		  <div style="width: 444px; height: 30px;background-color: #F8F8F8">
		    <div style="margin-top: 5px;margin-left: 10px;"><b>实时轨迹人员设备列表</b></div>
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
		         <input style="height: 32px;"id = "gpsUsercode" type="text" class="text col-xs-12">
		         <input name="gpsUsercode" id = "gpsUsercodes" type="hidden">
		       </td>
		       <td width="10%" style="text-align:right">登录状态</td>
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
		   </table>
		   </form>
		   <div  id="table" class="widget-box transparent collapsed" style="margin:0px;z-index: 10;height: 230px;">
         </div> 
          <table width="30%" border="0" align="center" style="text-align: center;margin-top: 22px;">
		     <tr height="25px;">
		       <td>
		         <a href="javascript:void(0);" onclick=start()>
		           <span id="pl"></span> 开始
		         </a>
		         <input id="hidinput" type="hidden" value="">
		       </td>
		       <td>
		         <a href="javascript:void(0);" onclick=stop(code)>
		           <span class="glyphicon glyphicon-stop"></span>停止
		         </a>
		       </td>
		     </tr>
		   </table>
		</div>
</div>
<div id="loaddata"
		style="position: absolute; left: 50%; top: 40px; background: #0096bb; color: white; width: 100px; height: 20px; text-align: center; line-height: 20px; display: none;z-index:6;">正在监控中...</div>
</body>
</html>
