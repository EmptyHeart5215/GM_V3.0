	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<jsp:include page="/resource/js/highcharts/partyhighchartsoperator.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看资料内容</title>
<script type="text/javascript">
 $(function(){
		 var gridCode = '01001001'
		 $.ajax({
				type : "post",
				url : "${base}/partybuilding/partyorganizationmanager/queryPartyOrganizationManagerByGridCode?gridCode="+gridCode+"&code=9D456F0E0E39434991C16549EA9B151C",
				dataType : 'json',
				async : false,
				success : function(data) {
					var birthday = (data.cid).substr(6,8);
					var year = birthday.substr(0,4);
					var month = birthday.substr(4,2);
					var day = birthday.substr(6,2);
					birthday = year+"年"+month+"月"+day+"日"
					$(".organizaName").text(data.organizaName);
					$(".secretaryName").text(data.secretaryName);
					$(".birthday").text(birthday);
					$(".sex").text(data.sex);
					$(".phone").text(data.phone);
					if(data.dicValueMap !=null){
						
					$(".codePartyOrganizationType").text(data.dicValueMap.codePartyOrganizationType);
					}else{
						$(".codePartyOrganizationType").text("");
					}
					if((data.address)!=null){
						$(".address").text(data.address);
					}else{
						$(".address").text("");
					}
					$(".gridTotalName").text(data.gridTotalName);
					$(".guanlian").text(data.gridTotalName);
					$(".numparty").text(data.numParty);
					$(".sexMale").text(data.sexMale);
					$(".sexFeMale").text(data.sexFeMale);
					$(".partyTypeTuiXiu").text(data.partyTypeTuiXiu);
					$(".partyTypeZhiGuan").text(data.partyTypeZhiGuan);
					$(".partyTypeKunNan").text(data.partyTypeKunNan);
					$(".partyTypeZaiZhi").text(data.partyTypeZaiZhi);
					$(".age35").text(data.age35);
					$(".age36In45").text(data.age36In45);
					$(".age46In54").text(data.age46In54);
					$(".age55In59").text(data.age55In59);
					$(".age60").text(data.age60);
					chartsex(gridCode);
					chartpartytype(gridCode);
					chartage(gridCode);
				}
			}); 
	 var setting = {
				callback:{
					onClick: zTreeOnClicks
				},
				data: {
					key: {
						name: "name"
					},
					simpleData: {
						enable: true,
						//open:true,
						idKey: "code",
						pIdKey:"parentCode",
						
					}
				}
			};
		$.ajax({
		      type: "get", 
		      url: '${base}/partybuilding/partyorganizationmanager/queryPartyBuildingTree',
		      //url: '${base}/temp/queryPartyBuildingTree',
		      dataType: 'json',
		      async: true,
		      success: function (data) {
		    	  var zNodes = data;
		    	  $.fn.zTree.init($("#xqTree"), setting, zNodes);
		    	  var treeObj = $.fn.zTree.getZTreeObj("xqTree"); 
		    	  treeObj.expandAll(true); 
		      }
		 });
 });
 function zTreeOnClicks(event, treeId, treeNode){
	   
		var xqCode = treeNode.code;
		var pomcode = treeNode.pomcode;
		$.ajax({
			type : "post",
			url : "${base}/partybuilding/partyorganizationmanager/queryPartyOrganizationManagerByGridCode?gridCode="+xqCode+"&code="+pomcode+"",
			dataType : 'json',
			async : false,
			success : function(data) {
				var birthday = (data.cid).substr(6,8);
				var year = birthday.substr(0,4);
				var month = birthday.substr(4,2);
				var day = birthday.substr(6,2);
				birthday = year+"年"+month+"月"+day+"日"
				$(".organizaName").text(data.organizaName);
				$(".secretaryName").text(data.secretaryName);
				$(".birthday").text(birthday);
				$(".sex").text(data.sex);
				$(".phone").text(data.phone);
				$(".codePartyOrganizationType").text(data.dicValueMap.codePartyOrganizationType);
				if((data.address)!=null){
					$(".address").text(data.address);
				}else{
					$(".address").text("");
				}
				$(".gridTotalName").text(data.gridTotalName);
				$(".guanlian").text(data.gridTotalName);
				$(".numparty").text(data.numParty);
				$(".sexMale").text(data.sexMale);
				$(".sexFeMale").text(data.sexFeMale);
				$(".partyTypeTuiXiu").text(data.partyTypeTuiXiu);
				$(".partyTypeZhiGuan").text(data.partyTypeZhiGuan);
				$(".partyTypeKunNan").text(data.partyTypeKunNan);
				$(".partyTypeZaiZhi").text(data.partyTypeZaiZhi);
				$(".age35").text(data.age35);
				$(".age36In45").text(data.age36In45);
				$(".age46In54").text(data.age46In54);
				$(".age55In59").text(data.age55In59);
				$(".age60").text(data.age60);
				chartsex(xqCode);
				chartpartytype(xqCode);
				chartage(xqCode);
			}
		});
		
	}
 function chartsex(gridCode){
	  var title="男女比例";
	  var postData=$("#search_form").serializeJson();
	  var url="${base }/partybuilding/partyorganizationmanager/chartsPartyMemberSexByGridCode?gridCode="+gridCode;
	  chartInitsex(title,null,url);
 }
 function chartpartytype(gridCode){
	  var title="党员类型比例";
	  var postData=$("#search_form").serializeJson();
	  var url="${base }/partybuilding/partyorganizationmanager/chartsPartyMemberPartyTypeByGridCode?gridCode="+gridCode;
	  chartInitpartytype(title,null,url);
}
 function chartage(gridCode){
	  var title="年龄分布";
	  var postData=$("#search_form").serializeJson();
	  var url="${base }/partybuilding/partyorganizationmanager/chartsPartyMemberAgeByGridCode?gridCode="+gridCode;
	  chartInitage(title,null,url);
}
</script>
<style type="text/css">
 #tbid{
   border-color: #DCE7E9;
}
 #table_tr_height{
 	height: 28px;
 	border-color: #DCE7E9;
 }
 #table_tr_td{
    width: 10%;
    text-align: center;
    border-color: #DCE7E9;
    background-color: #EBF8FF
 }
 #table_tr_td1{
    width: 18%;
    text-align: left;
    border-color: #DCE7E9;
 }
 #table_tr_td2{
    width: 25%;
    text-align: left;
    border-color: #DCE7E9;
 }
  #table_tr_td3{
    width: 10%;
    text-align: center;
    border-color: #DCE7E9;
    background-color: #EBF8FF
 }
 #table_tr_td4{
    width: 14%;
    text-align: left;
    border-color: #DCE7E9;
 }
</style>
</head>
<body>
<div class="row">
  <div class="col-xs-2 col-sm-2 divBorder" style="overflow:auto;height:583px;">
	       <div class="widget-header widget-header-flat">
				<h4 class="lighter green"></h4>
			</div>
			<div class="widget-header header-color-blue2 ui-helper-clearfix" style="height: 30px;">
				<h5 class="lighter smaller">党组织树形菜单</h5>
			</div>

			<div class="widget-body" style="height: 500px;overflow: auto;">
				<div class="widget-main padding-8">
					<ul id="xqTree" class="ztree"></ul>
				</div>
			</div>
	</div>
  <div class="col-xs-10 col-sm-10" id="body">
   <div id="contentmain" style="width: 100%;height: 100%">
      <div id="ss" style="width: 100%;height:30px;"></div>
      <div id="tablediv" style="width: 100%;height:40%;">
         <input id="xq" type="text" style="display: none;" value ="" name="xq"/>
         <input id="pomcode" type="text" style="display: none;" value ="" name="pomcode"/>
         <table id="tbid" width="100%" border="1" cellpadding="0" cellspacing="0">
			<tr id="table_tr_height">
				<td colspan="8" style="text-align: center;border-color: #DCE7E9;"><font color="#CC5630"><b>基本信息</b></font></td>
			</tr>
			<tr id="table_tr_height">
				<td id="table_tr_td">党委名称</td>
				<td id="table_tr_td1" class="organizaName"></td>
				<td id="table_tr_td">所属辖区</td>
				<td id="table_tr_td2" colspan="2" class="gridTotalName"></td>
				<td id="table_tr_td3">地址</td>
				<td id="table_tr_td2" colspan="2" class="address"></td>
		   </tr>
		   <tr id="table_tr_height">
			  <td id="table_tr_td">书记姓名</td>
			  <td id="table_tr_td1" class="secretaryName"></td>
			  <td id="table_tr_td">出生日期</td>
			  <td id="table_tr_td2" class="birthday" colspan="2"></td>
		      <td id="table_tr_td3">性别</td>
			  <td id="table_tr_td2" colspan="2" class="sex"></td>
		   </tr>
		   <tr id="table_tr_height">
			  <td id="table_tr_td">联系电话</td>
			  <td id="table_tr_td1" class="phone"></td>
			  <td id="table_tr_td">组织类型</td>
			  <td id="table_tr_td2" colspan="2" class="codePartyOrganizationType" />
			  <td id="table_tr_td3">关联单位</td>
			  <td id="table_tr_td2" colspan="2" class="guanlian"></td>
		  </tr>
		  <tr id="table_tr_height">
			 <td colspan="8" style="text-align: center;border-color: #DCE7E9;"><font color="#CC5630"><b>党员概况</b></font></td>
		  </tr>
			 <tr id="table_tr_height">
			 <td id="table_tr_td">党员人数</td>
			 <td id="table_tr_td1" class="numparty"></td>
			 <td id="table_tr_td">男党员数</td>
			 <td id="table_tr_td4" class="sexMale"></td>
			 <td id="table_tr_td">女党员数</td>
			 <td id="table_tr_td4" class="sexFeMale"></td>
			 <td width="8%" style="text-align: center;border-color: #DCE7E9;background-color: #EBF8FF">退休党员</td>
			 <td style="border-color: #DCE7E9;" class="partyTypeTuiXiu"></td>
		  </tr>
		  <tr id="table_tr_height">
			 <td id="table_tr_td">直管党员数</td>
			 <td id="table_tr_td1" class="partyTypeZhiGuan"></td>
			 <td id="table_tr_td" >困难党员</td>
		     <td id="table_tr_td4" class="partyTypeKunNan"></td>
			 <td width="10%" style="text-align: center;border-color: #DCE7E9;background-color: #EBF8FF">在职党员</td>
			 <td style="border-color: #DCE7E9;" class="partyTypeZaiZhi"></td>
			 <td id="table_tr_td">35岁以下</td>
			<td id="table_tr_td1" class="age35"></td>
		 </tr>
		 <tr id="table_tr_height">
			
			<td id="table_tr_td">36到45岁</td>
			<td id="table_tr_td4" class="age36In45"></td>
			<td id="table_tr_td">46到54岁</td>
			<td id="table_tr_td4" class="age46In54"></td>
			<td width="10%" style="text-align: center;border-color: #DCE7E9;background-color: #EBF8FF">55到59岁</td>
			<td style="border-color: #DCE7E9;" class="age55In59"></td>
			 <td id="table_tr_td">60岁以上</td>
		   <td id="table_tr_td1" class="age60"></td>
		</tr>
	    </table>		   
      </div>
      <div id="chartsdiv" style="width: 100%;height:40%;">
        <jsp:include page="/resource/js/highcharts/partyhighcharts.jsp"/>
      </div>
      <%-- <jsp:include page="/resource/js/highcharts/myHighChartsJSP.jsp"/> --%>
   </div>
  </div>
</div>
</body>
</html>