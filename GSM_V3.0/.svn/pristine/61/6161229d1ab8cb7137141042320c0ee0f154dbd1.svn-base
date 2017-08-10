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
					<h2><center>社区/村概况</center></h2>
						<table class="print-table" >
							<tr>
								<td class="col-xs-3">社区/村名</td><td class="print-normal col-xs-3">${map.seat.name}</td>
								<td class="col-xs-3">行政区划(网格)代码</td><td class="print-normal col-xs-3">${map.seat.cityCode}</td>
							</tr>
							<tr>
								<td class="col-xs-3">社区负责人姓名</td><td class="print-normal col-xs-3">${map.seat.managerName}</td>
								<td class="col-xs-3">社区负责人电话</td><td class="print-normal col-xs-3">${map.seat.managerPhone}</td>
							</tr>
							<tr>
								<td class="col-xs-3">社区负责人职务</td><td class="print-normal col-xs-3">${map.seat.managerDuty}</td>
								<td class="col-xs-3">社区负责人地址</td><td class="print-normal col-xs-3">${map.seat.managerAddress}</td>
							</tr>
							<tr>
								<td class="col-xs-3">网格信息管理员姓名</td><td class="print-normal col-xs-3">${map.seat.gridManagerName}</td>
								<td class="col-xs-3">民情联络员姓名</td><td class="print-normal col-xs-3">${map.seat.minQingName}</td>
							</tr>
							<tr>
								<td class="col-xs-3">社区概况</td>
								<td colspan="3" class="print-normal col-xs-10">${map.seat.description}</td>
							</tr>
							<tr>
								<td class="col-xs-12"colspan="4"><center>社区统计</center></td>
							</tr>
								<tr>
								<td class="col-xs-3">社区人口统计</td>
								<td colspan="3"class="print-normal col-xs-9"><div>实有人口：${map.chartMap.SHI}人&nbsp;&nbsp;&nbsp;&nbsp;境外人口：${map.chartMap.WAI}人&nbsp;&nbsp;&nbsp;&nbsp;常住人口：${map.chartMap.CHANG}人&nbsp;&nbsp;&nbsp;&nbsp;流动人口：${map.chartMap.LIU}人&nbsp;&nbsp;&nbsp;&nbsp;户籍人口：${map.chartMap.HU}人</div>
								 <div><i style="color:red;" class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;男性：${map.chartMap.NAN}人&nbsp;&nbsp;&nbsp;&nbsp;<i style="color:green;" class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;女性：${map.chartMap.NV}人</div></td>
							</tr>
							<tr>
								<td class="col-xs-3">社区房屋统计</td>
								<td colspan="3"class="print-normal col-xs-9">
								<div>自住房：${map.chartMap.ZI}&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出租房：${map.chartMap.CHU}&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空置房：${map.chartMap.KONG}&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民宿：${map.chartMap.MIN}&nbsp;间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他：${map.chartMap.QI}&nbsp;间</div>
								</td>
							</tr>
							<tr>
								<td class="col-xs-3">社区单位统计</td>
								<td colspan="3"class="print-normal col-xs-9">
								<div> <i style="color:purple"class="glyphicon glyphicon-shopping-cart"></i>&nbsp;&nbsp;单位门店：${map.chartMap.MEN}个</div>
								</td>
							</tr>
						</table>
					</div>
</body>

</html>