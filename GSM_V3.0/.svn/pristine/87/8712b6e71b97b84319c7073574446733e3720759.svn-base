<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	$('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize();
			$.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	parent.successFun("unit");
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			});
        }
	});
	//父窗口中的提交按钮
	$("#commitBtn",parent.document).bind("click",function(){
		$("#form").submit();
	});
});
function  print(printid){
    $("#"+printid).jqprint({debug:true});
}
</script>
</head>
<body>
<div >
	<div class="col-xs-12" id="body">
		<div class="tabbable">
			<ul class="nav nav-tabs" id="myTab">
			<li class="active">
					<a data-toggle="tab" href="#detailDiv">
						<i class="blue icon-home bigger-110"></i> 
						房屋信息
					</a>
				</li>
				<li>
					<a data-toggle="tab" href="#chanquanDiv">
						<i class="blue fa fa-file-text "></i> 
						产权信息
					</a>
				</li>
				<li>
					<a data-toggle="tab" href="#userDiv">
						 <i class="blue icon-user bigger-110"></i> 
						使用人信息
					</a>
				</li>
			</ul>

			<div class="tab-content" >
			<!-- 基本信息 --> 
				<div id="detailDiv" class="tab-pane id active">
						<table class="mapinfo-table" >
							<tr><td class="col-xs-12"colspan="2">所属辖区：<label class="mapinfo-normal">${vdata.house.gridTotalName}</label></td></tr>
							<tr><td class="col-xs-12"colspan="2">房屋位置：<label class="mapinfo-normal">${vdata.house.buildName}——${vdata.house.unitName}——${vdata.house.houseNum}</label></td></tr>
							<tr><td class="col-xs-6">本户建筑面积：<label class="mapinfo-normal">${vdata.house.houseArea}</label></td><td class="col-xs-6">本户户型：<label class="mapinfo-normal">${vdata.house.codeHouseLayout}</label></td></tr>
							<tr><td class="col-xs-6">建成年份：<label class="mapinfo-normal">${vdata.house.buildYear}</label></td><td class="col-xs-6">房屋产权证号：<label class="mapinfo-normal">${vdata.house.housePropertyNum}</label></td></tr>
							<tr><td class="col-xs-6">房屋产权证发证日期：<label class="mapinfo-normal">${vdata.house.housePropertyDate}</label></td><td class="col-xs-6">房屋土地证发证日期：<label class="mapinfo-normal">${vdata.house.houseLandDate}</label></td></tr>
							<tr><td class="col-xs-6">房屋土地证号：<label class="mapinfo-normal">${vdata.house.houseLandNum}</label></td><td class="col-xs-6">房屋来源：<label class="mapinfo-normal">${vdata.house.dicValueMap.codeHouseSource}</label></td></tr>
							<tr><td class="col-xs-6">房屋性质：<label class="mapinfo-normal">${vdata.house.dicValueMap.codeHouseNature}</label></td><td class="col-xs-6">房屋用途：<label class="mapinfo-normal">${vdata.house.dicValueMap.codeHouseUse}</label></td></tr>
							<tr><td class="col-xs-6">当前层：<label class="mapinfo-normal">${vdata.house.currentLayer}</label></td><td class="col-xs-6">所在层：<label class="mapinfo-normal">${vdata.house.ubietyLayer}</label></td></tr>
						</table>
				</div>
			<div id="chanquanDiv" class="tab-pane">
				<table class="mapinfo-table" >
					<tr><td class="col-xs-6">产权人姓名：<label class="mapinfo-normal">${vdata.house.houseOwnerName}</label></td><td class="col-xs-6">性别：<label class="mapinfo-normal">${vdata.house.sex}</label></td></tr>
					<tr><td class="col-xs-6">证件类型：<label class="mapinfo-normal">${vdata.house.dicValueMap.codeHouseOwnerCard}</label></td><td class="col-xs-6">证件号：<label class="mapinfo-normal">${vdata.house.houseOwnerCardNum}</label></td></tr>
					<tr><td class="col-xs-6">产权人户籍地：<label class="mapinfo-normal">${vdata.house.houseOwnerAddress}</label></td><td class="col-xs-6">产权人现地址：<label class="mapinfo-normal">${vdata.house.houseOwnerNowAddress}</label></td></tr>
					<tr><td class="col-xs-6">工作单位：<label class="mapinfo-normal">${vdata.house.houseOwnerCompany}</label></td><td class="col-xs-6">产权人电话：<label class="mapinfo-normal">${vdata.house.houseOwnerPhone}</label></td></tr>
					<tr><td class="col-xs-6">共有人姓名：<label class="mapinfo-normal">${vdata.house.houseCommonName}</label></td><td class="col-xs-6">与产权人关系：<label class="mapinfo-normal">${vdata.house.commonOwnerRelation}</label></td></tr>
					
				</table>
			</div>

		<div id="userDiv" class="tab-pane">
				<table class="mapinfo-table" >
					<tr><td class="col-xs-6">使用人\单位：<label class="mapinfo-normal">${vdata.house.useName}</label></td><td class="col-xs-6">与产权人关系：<label class="mapinfo-normal">${vdata.house.useOwnerRelation}</label></td></tr>
					<tr><td class="col-xs-6">性别：<label class="mapinfo-normal">${vdata.house.useSex}</label></td><td class="col-xs-6">法定代表人：<label class="mapinfo-normal">${vdata.house.legalPerson}</label></td></tr>
					<tr><td class="col-xs-6">使用人性质：<label class="mapinfo-normal">${vdata.house.dicValueMap.codeUseProperty}</label></td><td class="col-xs-6">证件类型：<label class="mapinfo-normal">${vdata.house.dicValueMap.codeUseCard}</label></td></tr>
					<tr><td class="col-xs-6">证件号码：<label class="mapinfo-normal">${vdata.house.useCardNumber}</label></td><td class="col-xs-6">联系方式：<label class="mapinfo-normal">${vdata.house.usePhone}</label></td></tr>
					<tr><td class="col-xs-6">户籍地址：<label class="mapinfo-normal">${vdata.house.useAddress}</label></td><td class="col-xs-6">现住址：<label class="mapinfo-normal">${vdata.house.useCurrentAddress}</label></td></tr>
					<tr><td class="col-xs-6">使用人是否流动人口：<label class="mapinfo-normal">${vdata.house.isUserFlow}</label></td><td class="col-xs-6">工作单位：<label class="mapinfo-normal">${vdata.house.useWork}</label></td></tr>
					<tr><td class="col-xs-6">使用人居住证号：<label class="mapinfo-normal">${vdata.house.useLiveNumber}</label></td><td class="col-xs-6">共同使用人姓名：<label class="mapinfo-normal">${vdata.house.useTogetherName}</label></td></tr>
					<tr><td class="col-xs-6">与使用人关系：<label class="mapinfo-normal">${vdata.house.useTogetherRelation}</label></td><td class="col-xs-6">租赁时间：<label class="mapinfo-normal">${vdata.house.rentDate}</label></td></tr>
					<tr><td class="col-xs-6">租赁期限：<label class="mapinfo-normal">${vdata.house.rentTerm}</label></td><td class="col-xs-6">是否租赁整体：<label class="mapinfo-normal">${vdata.house.isRentWhole}</label></td></tr>
					<tr><td class="col-xs-6">租金：<label class="mapinfo-normal">${vdata.house.rentFund}</label></td><td class="col-xs-6">租赁间数：<label class="mapinfo-normal">${vdata.house.rentRoomCount}</label></td></tr>
					<tr><td class="col-xs-6">租赁面积：<label class="mapinfo-normal">${vdata.house.rentArea}</label></td><td class="col-xs-6">租赁合同：<label class="mapinfo-normal">${vdata.house.haveRentContract}</label></td></tr>
					<tr><td class="col-xs-6">登记备案：<label class="mapinfo-normal">${vdata.house.isRegistration}</label></td><td class="col-xs-6">到期时间：<label class="mapinfo-normal">${vdata.house.expiryDate}</label></td></tr>
					<tr><td class="col-xs-6">租赁公房：<label class="mapinfo-normal">${vdata.house.dicValueMap.codeHouseHousing}</label></td><td class="col-xs-6">双方签订计划生育保证书：<label class="mapinfo-normal">${vdata.house.isSignBirth}</label></td></tr>
					<tr><td colspan="2">双方签订治安责任保证书：<label class="mapinfo-normal">${vdata.house.isSignOrder}</label></td></tr>
				</table>
			</div>
		</div><!-- tab-content -->
	</div>
</div>
</div><!-- row -->
</body>
</html>


