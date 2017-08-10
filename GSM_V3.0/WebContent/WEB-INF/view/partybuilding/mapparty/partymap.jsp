<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include page="/resource/base_import.jsp" />
<script type="text/javascript">
$(function() {
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
	$("[name=codePartyOrganizationType]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_PARTY_ORGANIZATION_TYPE',
		name:"dicValue",
		pIdKey:"parentCode"
	});
		 
	$("#imgClose").click(function(){
	    $("#partyOrganDiv").hide();
	});
	$("#imgCloses").click(function(){
	    $("#partymemberDiv").hide();
	});
	NMapsShow({
		id : "map"
	});
	$('#beSmall').bind('click',function(){
		if($('#table').css('width')=='0px'){
			$('#table').animate({ width:"100%",height:"230px" },1000);
			$(this).attr("class"," icon-double-angle-left bigger-140");
		}else{
			$('#table').animate({ width:"0px",height:"0px" },1000);
			$(this).attr("class"," icon-double-angle-right bigger-140");
		}
	});
	$("#partyOrganSearch").click(function(){
		var postData=$("#search_form").serializeJson();
		$("#partyOrganDiv").hide();
		if($('#table').css('width')=='0px'){
			$('#table').animate({ width:"100%",height:"230px" },0);
			$('#beSmall').attr("class"," icon-double-angle-left bigger-140");
		}
		$("#table").html("<table id=\"grid-table\"></table><div id=\"grid-pager\"></div>");
		$("#grid-table").jqGrid({
		 	url:"${base }/partybuilding/partyorganizationmanager/queryManage",
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
		 		 var organizaName = rowData.organizaName;
		 		 var position = rowData.position;
		 		 var code = rowData.code;
		 		  var show = "[";
		 		  show += "{\"NAME\":\""+organizaName+"\",\"POSITION\":\""+position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:280px;width:500px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/partybuilding/partyorganizationmanager/infoSee?code="+code+"'></iframe></div>\"},";
		 		 show = show.substring(0,show.length-1)+"]";
		 		 drawmapshow(show, true, true, true);
		    },
		 	datatype:"json", //数据来源，本地数据
		 	postData:postData,
		 	mtype:"POST",//提交方式
	        colNames:['','书记姓名', '组织名称  ','性别 ','身份证号','党组织类型','工作电话 ','手机号码 ','创建时间',''],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
	            {name:'secretaryName',index:'secretaryName',sortable:false, width:'25%'},
	            {name:'organizaName',index:'organizaName',sortable:false, width:'35%'},
	            {name:'sex',index:'sex', width:'40%', sortable:false, width:'15%',formatter:
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
	            {name:'cid',index:'cid',sortable:false, width:'38%'},
	            {name:'dicValueMap.codePartyOrganizationType',sortable:false, width:'38%'},
	            {name:'phone', index:'phone',sortable:false, width:40},
	            {name:'mobile', index:'mobile',sortable:true, width:40},
	            {name:'createDate', index:'createDate', width:40},
	            {name:'position', index:'position', hidden:true}
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
	        caption: "党组织管理列表",
	        loadComplete:partyOrganLoad
	    });
		//$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
	});
	$("#partyOrganSearch").click();
	//党员查询
	$("#partyMemberSearch").click(function(){
		var postData=$("#search_partymember_form").serializeJson();
		 $("#partymemberDiv").hide();
			if($('#table').css('width')=='0px'){
				$('#table').animate({ width:"100%",height:"230px" },0);
				$('#beSmall').attr("class"," icon-double-angle-left bigger-140");
			}
		 $("#table").html("<table id=\"grid-table\"></table><div id=\"grid-pager\"></div>");
		 $("#grid-table").jqGrid({
			 	url : "${base }/partybuilding/allparty/queryManage",
			 	ondblClickRow:function(rowid,iRow,iCol,e){
			 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
			 		 var name = rowData.name;
			 		 var position = rowData.position;
			 		 var code = rowData.code;
			 		  var show = "[";
			 		  show += "{\"NAME\":\""+name+"\",\"POSITION\":\""+position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:280px;width:500px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/partybuilding/allparty/infoSeeforMap?code="+code+"'></iframe></div>\"},";
			 		 show = show.substring(0,show.length-1)+"]";
			 		 drawmapshow(show, true, true, true);
			    },
			 	datatype:"json", //数据来源，本地数据
			 	postData:postData,
		        colNames:['主键', '所属辖区', '姓名','性别','身份证','民族','文化程度','党员类型','政治面貌','入党时间',''],
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
	            			if(strs[i] == 'zaizhiparty'){
	            				saveValue = "在职党员";
	            			}else if(strs[i] == 'tuixiuparty'){
	            				if(saveValue!=""){
	            					saveValue = saveValue+";退休党员";
	            				}else{
	            					saveValue = "退休党员"
	            				}
	            			}else if(strs[i] == 'zhiguanparty'){
	            				if(saveValue!=""){
	            					saveValue = saveValue+";直管党员";
	            				}else{
	            					saveValue = "直管党员";
	            				}
	            			}else if(strs[i] == 'kunnanparty'){
	            				if(saveValue!=""){
	            					saveValue = saveValue+";困难党员";
	            				}else{
	            					saveValue = "困难党员";
	            				}
		            		}else if(strs[i] == 'zyzparty'){
		            			if(saveValue!=""){
	            					saveValue = saveValue+";志愿者党员";
	            				}else{
	            					saveValue = "志愿者党员";
	            				}
		            		}else if(strs[i] == 0){
		            			saveValue = '<font color="#694d9f">未填写</font>';
		            		}
	            			
	            		}
	            		return saveValue;
    	    	     }},
		            {name:'dicValueMap.codePolitical',sortable:true, width:'8%', align:"center"},
		            {name:'inPartyDate',index:'inPartyDate',sortable:true, width:'7%', align:"center"},
		            {name:'position',index:'position',sortable:true,hidden:true },
		           
		           ],
		           sortable:true,
			        rownumbers:true,//添加左侧行号
			        altRows:true,//班玛线
			        sortname:'createDate',
			        sortorder:'desc',
			        hidegrid:false,
			        viewrecords: true,//是否在浏览导航栏显示记录总数
			        rowNum:5,//每页显示记录数
			        showRowList:false,
			        multiselect: false,
			        jsonReader:{
			            id: "code",//设置返回参数中，表格ID的名字为CODE
			            repeatitems : false
			        },
		        pager:$('#grid-pager'),
		        caption: "所有党员管理列表",
		        loadComplete:partyMemberLoad
		    });
	});
}); 

function showDiv(){
	if($("#partymemberDiv").css("display")=='block'){
		 $("#partymemberDiv").slideUp("slow");
	}else{
		$("#partymemberDiv").slideDown("slow");
	}
	 $("#partyOrganDiv").hide();
}
function showPartyOrgan(){
	if($("#partyOrganDiv").css("display")=='block'){
		 $("#partyOrganDiv").slideUp("slow");
	}else{
		$("#partyOrganDiv").slideDown("slow");
	}
	$("#partymemberDiv").hide();
}
var partyOrganLoad = function (data){
	var rows = $('#grid-table').jqGrid('getRowData');
	var show = "[";
	for(var i  = 0;i<rows.length;i++){
		var row = rows[i];
		show += "{\"NAME\":\""+row.organizaName+"\",\"POSITION\":\""+row.position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:280px;width:500px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='no' frameborder='0' src='${base}/partybuilding/partyorganizationmanager/infoSee?code="+row.code+"'></iframe></div>\"},";
	}
	show = show.substring(0,show.length-1)+"]";
	drawmapshow(show, true, true,false);
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
#grid-table tr{
background-image: none;
background-color: #f9f9f9;
opacity: 0.8;}
</style>
</head>

<body>
<div style="width: 100%;height: 580px;">
		<div style="width: 50%; height: 30px;text-align:right;z-index: 12; position: absolute;">
				<button style="margin-top:-2px;"  class="btn btn-minier btn-yellow" onclick="showPartyOrgan();">党组织查询
				  <i class="icon-angle-down icon-on-right"></i>
				</button>
		</div>
		<div style="width: 50%; left: 50%;height: 30px;text-align:left;z-index: 12; position: absolute;">
				&nbsp;&nbsp; &nbsp;&nbsp;
				<button  style="margin-top:-5px;" class="btn btn-minier btn-yellow" onclick="showDiv();">党员查询
				  <i class="icon-angle-down icon-on-right"></i>
				</button>
		</div>
		<div id="beSmall" class="icon-double-angle-left bigger-140"style="background: #478fca !important;cursor: pointer;width:20px;margin:0px;z-index: 11;margin:380px 0px 0px;height: 21px; position:absolute;display: inline;text-indent: 0px;color: white;">
		</div>
		<div  id="table" class="widget-box transparent collapsed" style="overflow:hidden;width: 100%;margin:400px 0px 0px;z-index: 10;height: 230px; position:absolute">
			<table id="grid-table"></table>
			 <div id="grid-pager"></div>
			 <!-- <div style="margin-left: 280px;color: red"><h3><b>暂无查询列表，请选择查询选项进行查询。谢谢！</b></h3></div> -->
         </div> 
		<div id="map" style="width: 100%;height: 100%; "></div>
		
		<div id="partyOrganDiv" class="" style="width:90%; height: 200px; position: absolute; top: 0px; left: 50px;background-color: #FFFFFF;z-index: 10;filter: Alpha(Opacity=50);-moz-opacity:0.9;opacity: 0.9;" hidden="hidden">
		  <div style="width: 100%; height: 30px;background-color: #F8F8F8">
		    <div style="margin-top: 5px;margin-left: 10px;"><b>党组织查询条件</b></div>
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
		        <td width="10%"style="text-align:right">书记姓名</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="secretaryName" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		        <td width="11%"style="text-align:right">党组织类型</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text" id="codePartyOrganizationType" name="codePartyOrganizationType" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		      </tr>
		       <tr height="5px;">
		        <td colspan="4"></td>
		      </tr>
		        <tr height="30px;">
		       <td colspan="4">
		          <table style="width: 50%;text-align: center;" align="center">
		             <tr height="28px;">
		               <td>
		                 <button type="button" class="btn btn-info" id="partyOrganSearch">查询
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
		<div id="partymemberDiv" class="" style="width: 90%; height: 200px; position: absolute; top: 0px; left: 50px;background-color: #FFFFFF;z-index: 9;filter: Alpha(Opacity=50);-moz-opacity:0.9;opacity: 0.9;" hidden="hidden">
		  <div style="width: 100%; height: 30px;background-color: #F8F8F8">
		    <div style="margin-top: 5px;margin-left: 10px;"><b>党员查询条件</b></div>
		    <div style="margin-left: -13px;float: right;margin-top: -22px;height: 20px;width:30px;">
		      <div style="text-align: center; line-height: 30px; z-index: 100; position: absolute; font-weight: bold; top: 0px; right: 0px; width: 34px; height: 30px; cursor: pointer; background-color: rgb(248, 248, 248);">
				<div style="position: absolute; overflow: hidden; width: 10px; height: 10px; left: 12px; top: 10px;">
				  <img width="93" id="imgCloses" height="75" src="${base }/resource/user-definedimages/close.png" style="width: 93px; height: 75px; position: absolute; left: -46px; top: -64px; z-index: 0; -moz-user-select: none; border: 0px none;">
				</div>
			  </div>
		    </div>
		    <div style="width: 444px;;height: 6px;">
		      <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1);height: 3px;margin-top: -1px;" width="80%" color=#987cb9 SIZE=3>
		    </div>
		  </div>
		   <form id="search_partymember_form"style="padding-top:20px">
		   <table style="width: 100%;text-align: center;">
		      <tr height="28px;">
		        <td width="10%" style="text-align:right">姓名</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="name" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		        <td width="10%"style="text-align:right">性别</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <select  id="sex" name = "sex"  class="form-control"  style="width: 100%;padding: 0px;border-radius: 4px !important;border: 1px solid rgb(138, 187, 210);	color: rgb(57, 57, 57);" onchange="changeSelect(this.value)">
						 <option  value="">--请选择--</option>
						 <option  value="男">男</option>
						 <option  value="女">女</option>
					  </select>
					</div>
		        </td>
		        <td  width="10%"style="text-align:right">民族</td>
		        <td>
		          <div class="col-xs-12">
					  <input type="text" id="codeNation" name="codeNation" class="col-xs-12 col-sm-12" />
				   </div>
		        </td>
		      </tr>
		       <tr height="5px;">
		        <td colspan="4"></td>
		      </tr>
		       <tr height="5px;">
		        <td colspan="4"></td>
		      </tr>
		       <tr height="28px;">
		       <td style="text-align:right">党员类型</td>
		        <td>
		          <div class="col-xs-12">
					<select  id="codePartyType" name = "codePartyType"  class="form-control "  style="width: 100%;padding: 0px;border-radius: 4px !important;border: 1px solid rgb(138, 187, 210);	color: rgb(57, 57, 57);" onchange="changeSelect(this.value)">
						<option value="">--请选择--</option>
						<option value="zhiguanparty">直管党员</option>
						<option value="zaizhiparty">在职党员</option>
						<option value="tuixiuparty">退休党员</option>
						<option value="kunnanparty">困难党员</option>
						<option value="zyzparty">志愿者党员</option>
					</select>
				  </div>
		        </td>
		        <td style="text-align:right">文化程度</td>
		        <td>
		          <div class="col-xs-12">
					<input type="text" id="codeEducation" name="codeEducation" class="col-xs-12 col-sm-12" />
				  </div>
		        </td>
		        <td style="text-align:right">政治面貌</td>
		        <td>
		          <div class="col-xs-12">
					  <input type="text" id="codePolitical" name="codePolitical" class="col-xs-12 col-sm-12" />
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
		                 <button type="button" class="btn btn-info" id="partyMemberSearch">查询
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
