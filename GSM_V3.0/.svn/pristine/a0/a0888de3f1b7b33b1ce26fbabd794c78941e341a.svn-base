<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<link rel="stylesheet"  href="${base}/resource/css/timeline.css" />
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
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
<div class="row">
		<div class="col-xs-12" id="body">
		<div class="tabbable tabs-left">
			

			<div class="tab-content" >
			<!-- 基本信息 --> 
				<div id="detailDiv" class="tab-pane in active">
				<div class="col-xs-12" style='text-align:right;'>
				<div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
			         <span class="ui-icon icon-print pull-right"></span>
	            </div>
	            </div>
					<div id="print">
					<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">房屋信息</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.house.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.house.createDate }</td>
					  </tr>
					</table>
				<table class="print-table" >
					<tr><td class="col-xs-2">所属辖区</td><td class="print-normal col-xs-4">${vdata.house.gridTotalName}</td><td class="col-xs-2">所属楼栋</td><td class="print-normal col-xs-4">${vdata.house.buildName}</td></tr>
					<tr><td class="col-xs-2">所属单元</td><td class="print-normal col-xs-4">${vdata.house.unitName}</td><td class="col-xs-2">房间号</td><td class="print-normal col-xs-4">${vdata.house.houseNum}</td></tr>
					<tr><td class="col-xs-2">本户建筑面积</td><td class="print-normal col-xs-4">${vdata.house.houseArea}</td><td class="col-xs-2">本户户型</td><td class="print-normal col-xs-4">${vdata.house.codeHouseLayout}</td></tr>
					<tr><td class="col-xs-2">建成年份</td><td class="print-normal col-xs-4">${vdata.house.buildYear}</td><td class="col-xs-2">房屋产权证号</td><td class="print-normal col-xs-4">${vdata.house.housePropertyNum}</td></tr>
					<tr><td class="col-xs-2">房屋产权证发证日期</td><td class="print-normal col-xs-4">${vdata.house.housePropertyDate}</td><td class="col-xs-2">房屋土地证发证日期</td><td class="print-normal col-xs-4">${vdata.house.houseLandDate}</td></tr>
					<tr><td class="col-xs-2">房屋土地证号</td><td class="print-normal col-xs-4">${vdata.house.houseLandNum}</td><td class="col-xs-2">房屋来源</td><td class="print-normal col-xs-4">${vdata.house.dicValueMap.codeHouseSource}</td></tr>
					<tr><td class="col-xs-2">房屋性质</td><td class="print-normal col-xs-4">${vdata.house.dicValueMap.codeHouseNature}</td><td class="col-xs-2">房屋用途</td><td class="print-normal col-xs-4">${vdata.house.dicValueMap.codeHouseUse}</td></tr>
					<tr><td class="col-xs-2">当前层</td><td class="print-normal col-xs-4">${vdata.house.currentLayer}</td><td class="col-xs-2">所在层</td><td class="print-normal col-xs-4">${vdata.house.ubietyLayer}</td></tr>
				</table>
					
				
			</div>
			</div>
			</div>

			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">产权信息</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
					
				<table class="print-table" >
					<tr><td class="col-xs-2">产权人姓名</td><td class="print-normal col-xs-4">${vdata.house.houseOwnerName}</td><td class="col-xs-2">性别</td><td class="print-normal col-xs-4">${vdata.house.sex}</td></tr>
					<tr><td class="col-xs-2">证件类型</td><td class="print-normal col-xs-4">${vdata.house.dicValueMap.codeHouseOwnerCard}</td><td class="col-xs-2">证件号</td><td class="print-normal col-xs-4">${vdata.house.houseOwnerCardNum}</td></tr>
					<tr><td class="col-xs-2">产权人户籍地</td><td class="print-normal col-xs-4">${vdata.house.houseOwnerAddress}</td><td class="col-xs-2">产权人现地址</td><td class="print-normal col-xs-4">${vdata.house.houseOwnerNowAddress}</td></tr>
					<tr><td class="col-xs-2">工作单位</td><td class="print-normal col-xs-4">${vdata.house.houseOwnerCompany}</td><td class="col-xs-2">产权人电话</td><td class="print-normal col-xs-4">${vdata.house.houseOwnerPhone}</td></tr>
					<tr><td class="col-xs-2">共有人姓名</td><td class="print-normal col-xs-4">${vdata.house.houseCommonName}</td><td class="col-xs-2">与产权人关系</td><td class="print-normal col-xs-4">${vdata.house.commonOwnerRelation}</td></tr>
					
				</table>
					
				
			</div>
			</div>
			</div>

			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">使用人信息</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
					
				<table class="print-table" >
					<tr><td class="col-xs-2">使用人\单位</td><td class="print-normal col-xs-4">${vdata.house.useName}</td><td class="col-xs-2">与产权人关系</td><td class="print-normal col-xs-4">${vdata.house.useOwnerRelation}</td></tr>
					<tr><td class="col-xs-2">性别</td><td class="print-normal col-xs-4">${vdata.house.useSex}</td><td class="col-xs-2">法定代表人</td><td class="print-normal col-xs-4">${vdata.house.legalPerson}</td></tr>
					<tr><td class="col-xs-2">使用人性质</td><td class="print-normal col-xs-4">${vdata.house.dicValueMap.codeUseProperty}</td><td class="col-xs-2">证件类型</td><td class="print-normal col-xs-4">${vdata.house.dicValueMap.codeUseCard}</td></tr>
					<tr><td class="col-xs-2">证件号码</td><td class="print-normal col-xs-4">${vdata.house.useCardNumber}</td><td class="col-xs-2">联系方式</td><td class="print-normal col-xs-4">${vdata.house.usePhone}</td></tr>
					<tr><td class="col-xs-2">户籍地址</td><td class="print-normal col-xs-4">${vdata.house.useAddress}</td><td class="col-xs-2">现住址</td><td class="print-normal col-xs-4">${vdata.house.useCurrentAddress}</td></tr>
					<tr><td class="col-xs-2">使用人是否流动人口</td><td class="print-normal col-xs-4">${vdata.house.isUserFlow}</td><td class="col-xs-2">工作单位</td><td class="print-normal col-xs-4">${vdata.house.useWork}</td></tr>
					<tr><td class="col-xs-2">使用人居住证号</td><td class="print-normal col-xs-4">${vdata.house.useLiveNumber}</td><td class="col-xs-2">共同使用人姓名</td><td class="print-normal col-xs-4">${vdata.house.useTogetherName}</td></tr>
					<tr><td class="col-xs-2">与使用人关系</td><td class="print-normal col-xs-4">${vdata.house.useTogetherRelation}</td><td class="col-xs-2">租赁时间</td><td class="print-normal col-xs-4">${vdata.house.rentDate}</td></tr>
					<tr><td class="col-xs-2">租赁期限</td><td class="print-normal col-xs-4">${vdata.house.rentTerm}</td><td class="col-xs-2">是否租赁整体</td><td class="print-normal col-xs-4">${vdata.house.isRentWhole}</td></tr>
					<tr><td class="col-xs-2">租金</td><td class="print-normal col-xs-4">${vdata.house.rentFund}</td><td class="col-xs-2">租赁间数</td><td class="print-normal col-xs-4">${vdata.house.rentRoomCount}</td></tr>
					<tr><td class="col-xs-2">租赁面积</td><td class="print-normal col-xs-4">${vdata.house.rentArea}</td><td class="col-xs-2">租赁合同</td><td class="print-normal col-xs-4">${vdata.house.haveRentContract}</td></tr>
					<tr><td class="col-xs-2">登记备案</td><td class="print-normal col-xs-4">${vdata.house.isRegistration}</td><td class="col-xs-2">到期时间</td><td class="print-normal col-xs-4">${vdata.house.expiryDate}</td></tr>
					<tr><td class="col-xs-2">租赁公房</td><td class="print-normal col-xs-4">${vdata.house.dicValueMap.codeHouseHousing}</td><td class="col-xs-2">双方签订计划生育保证书</td><td class="print-normal col-xs-4">${vdata.house.isSignBirth}</td></tr>
					<tr><td class="col-xs-2">双方签订治安责任保证书</td><td colspan="3" class="print-normal col-xs-10">${vdata.house.isSignOrder}</td>
				</table>
					
				
			</div>
			</div>
			</div>
			</div>
				</div>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


