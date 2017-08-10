<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include  page="/resource/base_import.jsp"/>
</head>
<body>
<div id="print"style="width:100%;height:400px;padding:20px;">
					<h2><center>街道/乡概况</center></h2>
						<table class="print-table" >
							<tr>
								<td class="col-xs-3">街道/乡名</td><td class="print-normal col-xs-3">${map.seat.name}</td>
								<td class="col-xs-3">行政区划(网格)代码</td><td class="print-normal col-xs-3">${map.seat.cityCode}</td>
							</tr>
							<tr>
								<td class="col-xs-3">街道管理责任人</td><td class="print-normal col-xs-3">${map.seat.managerName}</td>
								<td class="col-xs-3">街道管理责任人电话</td><td class="print-normal col-xs-3">${map.seat.managerPhone}</td>
							</tr>
							<tr>
								<td class="col-xs-3">党(工)委负责人</td><td class="print-normal col-xs-3">${map.seat.partyManagerName}</td>
								<td class="col-xs-3">党(工)委负责人电话</td><td class="print-normal col-xs-3">${map.seat.partyManagerPhone}</td>
							</tr>
							<tr>
								<td class="col-xs-3">乡政府(办事处)负责人</td><td class="print-normal col-xs-3">${map.seat.governmentName}</td>
								<td class="col-xs-3">政府(办事处)电话</td><td class="print-normal col-xs-3">${map.seat.governmentPhone}</td>
							</tr>
							<tr>
								<td class="col-xs-3">综治办主任</td><td class="print-normal col-xs-3">${map.seat.managementName}</td>
								<td class="col-xs-3">综治办主任电话</td><td class="print-normal col-xs-3">${map.seat.managementPhone}</td>
							</tr>
							<tr>
								<td class="col-xs-3">街道概况</td>
								<td colspan="3" class="print-normal col-xs-10">${map.seat.description}</td>
							</tr>
							<tr>
								<td class="col-xs-12"colspan="4"><center>街道统计</center></td>
							</tr>
								<tr>
								<td class="col-xs-3">街道人口统计</td>
								<td colspan="3"class="print-normal col-xs-9"><div>实有人口：${map.chartMap.SHI}人&nbsp;&nbsp;&nbsp;&nbsp;境外人口：${map.chartMap.WAI}人&nbsp;&nbsp;&nbsp;&nbsp;常住人口：${map.chartMap.CHANG}人&nbsp;&nbsp;&nbsp;&nbsp;流动人口：${map.chartMap.LIU}人&nbsp;&nbsp;&nbsp;&nbsp;户籍人口：${map.chartMap.HU}人</div>
								 <div><i style="color:red;" class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;男性：${map.chartMap.NAN}人&nbsp;&nbsp;&nbsp;&nbsp;<i style="color:green;" class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;女性：${map.chartMap.NV}人</div></td>
							</tr>
							<tr>
								<td class="col-xs-3">街道房屋统计</td>
								<td colspan="3"class="print-normal col-xs-9">
								<div>自住房：${map.chartMap.ZI}&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出租房：${map.chartMap.CHU}&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空置房：${map.chartMap.KONG}&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民宿：${map.chartMap.MIN}&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他：${map.chartMap.QI}&nbsp;间</div>
								</td>
							</tr>
							<tr>
								<td class="col-xs-3">街道单位统计</td>
								<td colspan="3"class="print-normal col-xs-9">
								<div> <i style="color:purple"class="glyphicon glyphicon-shopping-cart"></i>&nbsp;&nbsp;单位门店：${map.chartMap.MEN}个</div>
								</td>
							</tr>
						</table>
					</div>
</body>

</html>