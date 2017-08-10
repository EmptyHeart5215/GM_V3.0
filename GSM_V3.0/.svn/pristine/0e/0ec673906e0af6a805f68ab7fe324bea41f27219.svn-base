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
	$("#retest").click(function(){
		clearMap();
		points = [{ "POSITION": "118.17968594146069,39.59794904483746;118.17648854073411,39.59501189765839;118.17849621095777,39.59345037637331;118.18347820743874,39.59281833204364;118.18503972872381,39.59672213525633", "count": "2" },
                  { "POSITION": "118.1852070345758,39.59679649341277;118.18375705052537,39.592632436652565;118.19013326243943,39.59142411661055;118.19143453017699,39.595346509362344", "count": "3" },
                  { "POSITION": "118.18167502214523,39.60174131081551;118.18007632178194,39.59826506700231;118.18580189982721,39.596777903873665;118.18725188387764,39.598525320549825", "count": "6" },
                  { "POSITION": "118.18184232799723,39.6019272062066;118.18701021986926,39.59869262640179;118.19002172520477,39.60162977358087;118.18254873048333,39.602522071458054", "count": "5" },
                  { "POSITION": "118.1825115514051,39.60244771330162;118.18994736704832,39.60129516187692;118.19046787414334,39.60438102536886;118.18492819148915,39.60508742785496", "count": "6" },
                  { "POSITION": "118.18518844503666,39.60501306969853;118.18859033069343,39.608712387981036;118.1903749264478,39.60854508212906;118.19017044151762,39.607559836556334;118.19069094861264,39.6060912629668;118.19031915783049,39.6044739730644", "count": "6" },
                  { "POSITION": "118.18725188387768,39.598525320549825;118.18574613120992,39.59687085156921;118.19136017202055,39.594826002267325;118.19178773142004,39.595867016457376", "count": "1", },
                  { "POSITION": "118.18881340516276,39.601165035103165;118.1868800930955,39.598804163636444;118.19189926865467,39.5957183001445;118.19202939542842,39.59793045529835;118.19370245394815,39.60038427446063", "count": "8" },
                  { "POSITION": "118.1903377473696,39.604455383525284;118.18972429257903,39.60099772925118;118.19364668533083,39.5998823569047;118.19623063126686,39.6021874597541;118.19688126513563,39.60367462288274", "count": "7" },
                  { "POSITION": "118.1903563369087,39.61021814064878;118.1975318990044,39.60464127891637;118.19983700185381,39.60873097752014;118.1915088883334,39.61196555732494", "count": "6" },
                  { "POSITION": "118.19392552841744,39.61408476478326;118.19005890428298,39.610478394196285;118.19466910998177,39.60861944028548;118.19742036176977,39.6139732275486", "count": "7"},
                  { "POSITION": "118.19775497347369,39.61389886939217;118.19492936352927,39.60947455908446;118.19913059936769,39.60809893319046;118.2021421047032,39.612002736403156;118.20035750894883,39.61386169031396", "count": "9" },
                  { "POSITION": "118.19143453017698,39.610255319727;118.1900960833612,39.60746688886079;118.1908024858473,39.60601690481037;118.19043069506515,39.60367462288275;118.19399988657389,39.603154115787724;118.19459475182535,39.60720663531328;118.19292169330562,39.61021814064878", "count": "10" },
                  { "POSITION": "118.17225012581747,39.601443878189784;118.17221294673925,39.59787468668104;118.17819877833205,39.59988235690471;118.18143335813684,39.60244771330162", "count": "5" },
                  { "POSITION": "118.17247320028675,39.60475281615101;118.17232448397388,39.601778489893725;118.18143335813683,39.60233617606697;118.18150771629327,39.604157950899555;118.17526163115296,39.60393487643026;118.17451804958864,39.60575665126285", "count": "6" },
                  { "POSITION": "118.17537316838761,39.60597972573215;118.1751129148401,39.60404641366491;118.18124746274574,39.604157950899555;118.18143335813683,39.60623997927966", "count": "7" },
                  { "POSITION": "118.18117310458932,39.605124606933174;118.18150771629327,39.60307975763129;118.18574613120991,39.607541247017224;118.18477947517628,39.608173291346894", "count": "4" },
                  { "POSITION": "118.18016926947749,39.610255319727;118.17946286699137,39.6091027683023;118.17567060101334,39.60642587467074;118.181805148919,39.60575665126285;118.18489101241093,39.608619440285494", "count": "8"},
                  { "POSITION": "118.18121028366754,39.61244888534175;118.17998337408642,39.6104783941963;118.18143335813684,39.61040403603987;118.18463075886342,39.60854508212906;118.18842302484147,39.61215145271602", "count": "7" },
                  { "POSITION": "118.1825115514051,39.614270660174334;118.18124746274574,39.61322964598429;118.18686150355639,39.6114078711517;118.18998454612654,39.614010406626825", "count": "6", },
                  { "POSITION": "118.18753072696428,39.611036080369544;118.18407307269018,39.60780150056475;118.18403589361196,39.60709509807864;118.18496537056737,39.60650023282718;118.18994736704833,39.61081300590025", "count": "2" },
                  { "POSITION": "118.19015185197853,39.61401040662682;118.18771662235537,39.61163094562099;118.18950121810974,39.61057134189183;118.19340502132243,39.61406617524414", "count": "5" },
                  { "POSITION": "118.17213858858283,39.606574590983605;118.17225012581747,39.60505024877675;118.1745924077451,39.60560793494999;118.17764109215881,39.60783867964295;118.1750757357619,39.60917712645873", "count": "6" },
                  { "POSITION": "118.17637700349947,39.610478394196306;118.1745924077451,39.608730977520146;118.17674879428162,39.607355351626154;118.17834749464491,39.60832200765977;118.18002055316464,39.60995788710128", "count": "2" },
                  { "POSITION": "118.17884941220085,39.61166812469921;118.17823595741028,39.6102739092661;118.17977888915625,39.609827760327505;118.18055964979878,39.61151940838634", "count": "4" },
                  { "POSITION": "118.1804945864119,39.61466104049561;118.17959299376516,39.611668124699214;118.18042952302501,39.61153799792546;118.18147053721506,39.61354566814913;118.18240930894002,39.61439149217854", "count": "3" },
                  { "POSITION": "118.17193410365262,39.61086877451757;118.172343073513,39.60676048637469;118.17635841396034,39.61053416281363;118.1780872410974,39.61040403603987;118.17890518081816,39.61177966193386;118.17574495916979,39.61189119916851;118.17518727299655,39.61111043852597", "count": "2" },
                  { "POSITION": "118.17169243964422,39.61352707861002;118.17158090240956,39.610961722213105;118.17548470562225,39.6111847966824;118.17648854073408,39.61322964598429", "count": "6" },
                  { "POSITION": "118.17184115595708,39.61586936053763;118.17169243964422,39.613712974001096;118.17678597335983,39.61322964598428;118.17674879428161,39.615311674364385", "count": "4" },
                  { "POSITION": "118.1758564964044,39.615274495286165;118.17522445207474,39.61341554137536;118.18080131380715,39.61200273640315;118.1825115514051,39.614568092800056", "count": "2"},
                  { "POSITION": "118.17673020474251,39.61332259367983;118.1753173997703,39.61133351299527;118.17819877833205,39.61068287912649;118.1799461950082,39.613025161054104", "count": "1" }];           
			 heatmapshow(points);
	});
	$("#reSearch").click(function(){
		clearMap();
		var postData=$("#search_form").serializeJson();
		$.ajax({ url: "${base }/map/mapshow/personmapqueryByParamPage", data: postData ,success: function(data){
			
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
		 	url : "${base }/yanpanfenxi/renchaxun/zongheManage",
		 	defaultCaozuo:false,
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		 		 var rowData = $("#grid-table").jqGrid("getRowData", rowid); 
		 		 var Name = rowData.name;
		 		 var position = rowData.position;
		 		 var code = rowData.code;
		 		  var show = "[";
		 		  show += "{\"NAME\":\""+Name+"\",\"POSITION\":\""+position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:525px;width:800px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='yes' frameborder='0' src='${base}/base/person/infoSee?personCode="+code+"&personType=jingNei'></iframe></div>\"},";
		 		 show = show.substring(0,show.length-1)+"]";
		 		 drawmapshow(show, false, true, false);
		    },
		 	datatype:"json", //数据来源，本地数据
		 	postData:postData,
		 	mtype:"POST",//提交方式
		 	 colNames:[ '主键', '所属辖区','楼栋','单元','姓名','性别','民族','电话','人户状态','管理类型','婚姻状况',''],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'seatGrid.gridTotalName',index:'gridCode', width:'38%',align:'center'},
		            {name:'buildName',index:'buildName', width:'15%',align:'center'},
		            {name:'unitName',index:'unitName', width:'15%',align:'center'},
		            {name:'name',index:'name', width:'15%',align:'center'},
		            {name:'sex',index:'sex', width:'15%', align:"center"},
		            {name:'dicValueMap.codeNation',index:'codeNation', width:'15%',align:'center'},
		            {name:'phone',index:'phone', width:'20%', align:"center"},
		            {name:'dicValueMap.codeHouseholdStatus',index:'codeHouseholdStatus', width:'15%',align:'center'},
		            {name:'dicValueMap.codeManageType',index:'codeManageType', width:'20%', align:"center"},
		            {name:'dicValueMap.codeMarriage',index:'codeMarriage', width:'15%',align:'center'},
		            {name:'position',index:'position',sortable:false, width:'15%',hidden:true,formatter:
						function(cellvalue, options, rowObject){
	            		var building =rowObject['building'];
	            		position = building.position;
	            		return position;
	        	    }}
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
	        caption: "人查询列表",
	        loadComplete:mapSearchLoad
	    });
		//$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
	});
	$("#mapSearchSearch").click();
}); 

function showDiv(){
	 $("#mapSearchDiv").hide();
}
function showPartyOrgan(){
	$("#mapSearchDiv").slideToggle("slow");
}
var mapSearchLoad = function (data){
	var rows = $('#grid-table').jqGrid('getRowData');
	 if(rows.length>0){
		var show = "[";
		for(var i  = 0;i<rows.length;i++){
			var row = rows[i];
			show += "{\"NAME\":\""+row.name+"\",\"POSITION\":\""+row.position+"\",\"IMG\":\"${base}/resource/js/map/img/2015062904.png\",\"HTML\":\"<div style='height:525px;width:800px;'><iframe width='100%' height='100%' marginheight='0' marginwidth='0' scrolling='yes' frameborder='0' src='${base}/base/person/infoSee?personCode="+row.code+"&personType=jingNei'></iframe></div>\"},";
		}
		show = show.substring(0,show.length-1)+"]";
		drawmapshow(show, true, true,true);
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
<div style="width: 100%;height: 780px;">
		<div style="width: 100%; height: 30px;text-align:center;z-index: 10; position: absolute;">
			<button style="margin-top:-3px;"class="btn btn-minier btn-yellow" onclick="showPartyOrgan();">人查询
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
		<div id="mapSearchDiv" class="" hidden="hidden">
		  <div style="width:100%; height: 30px;background-color: #F8F8F8">
		    <div style="margin-top: 5px;margin-left: 10px;"><b>人查询条件</b></div>
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
		  <form id="search_form"style="padding-top: 20px;">
		   <table style="width: 100%;text-align: center;">
		      <tr height="28px;">
		        <td width="10%" style="text-align:right;">所属辖区</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text"  name="gridCode" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		        <td width="10%"style="text-align:right;">姓名</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="name" type="text" class="text col-xs-12" >
				  </div>
		        </td>
		        <td width="10%"style="text-align:right;">性别</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <select  id="sex" name = "sex"  class="form-control myselect col-xs-12"  style="width: 100%;" onchange="changeSelect(this.value)">
						<option value="">--请选择--</option>
		                <option value="男">男</option>
		                <option value="女">女</option>
		            </select>
				  </div>
		        </td>
		      </tr>
		      
		      <tr height="30px;">
		        <td width="10%"style="text-align:right;">楼栋</td>
		        <td width="25%">
		           <div class="col-xs-12">
					  <input type="text"  name="build" class="col-xs-12 col-sm-12" />
					</div>
		        </td>
		        <td width="10%"style="text-align:right;">单元</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="unit" type="text" class="col-xs-12 col-sm-12" >
				  </div>
		        </td>
		        <td width="10%"style="text-align:right;">房间</td>
		        <td width="25%">
		          <div class="col-xs-12">
					 <input name="house" type="text" class="col-xs-12 col-sm-12">
				  </div>
		        </td>
		      </tr>
		       <tr height="5px;">
		        <td colspan="4"></td>
		      </tr>
		        <tr height="30px;">
		       <td colspan="6" style="text-align:right">
		          <table style="width: 50%;text-align: right;" align="center">
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
		                 <button type="button" class="btn btn-info" id="retest">热点test
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
