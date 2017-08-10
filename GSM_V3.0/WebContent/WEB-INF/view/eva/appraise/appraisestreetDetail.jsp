<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
</script>

</head>
<body>
<div class="row">
	<div class="col-xs-12" style='text-align:right;'>
		<div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
	         <span class="ui-icon icon-print pull-right"></span>
	    </div>
	</div>
	<div class="col-xs-12">
	<div id="print">
	<h4><center>${data.appraise.gridTotalName} ${data.appraise.year}年${data.appraise.month}月 考核详情</center></h4>
		<table class="print-table" >
			<tr>
				<td colspan="2"class="col-xs-3">社区平均分</td><td colspan="3" class="print-normal col-xs-8">${data.appraise.averageScore}</td>
			</tr>
			<tr>
				<td class="col-xs-1" rowspan="4">矛盾</td>
				<td class="col-xs-2">未按时办结扣分</td><td class="print-normal col-xs-3">${data.appraise.lateKoufenContradict}</td>
				<td class="col-xs-2">返工扣分</td><td class="print-normal col-xs-3">${data.appraise.dubanKoufenContradict}</td>
			</tr>
			<tr>
				<td class="col-xs-2">满意度扣分</td><td class="print-normal col-xs-3">${data.appraise.manyiKoufenContradict}</td>
				<td class="col-xs-2">得分</td><td class="print-normal col-xs-3">${data.appraise.contradictScore}</td>
			</tr>
			<tr>
				<td class="col-xs-2">计算公式</td><td colspan="3" class="print-normal col-xs-8">${data.contradictGongShi}</td>
			</tr>
			<tr>
				<td class="col-xs-2">公式意义</td><td colspan="3" class="print-normal col-xs-8">${data.contradictJieShi}</td>
			</tr>
			<tr>
				<td class="col-xs-1" rowspan="4">事件</td>
				<td class="col-xs-2">未按时办结扣分</td><td class="print-normal col-xs-3">${data.appraise.lateKoufenEvent}</td>
				<td class="col-xs-2">返工扣分</td><td class="print-normal col-xs-3">${data.appraise.dubanKoufenEvent}</td>
			</tr>
			<tr>
				<td class="col-xs-2">满意度扣分</td><td class="print-normal col-xs-3">${data.appraise.manyiKoufenEvent}</td>
				<td class="col-xs-2">得分</td><td class="print-normal col-xs-3">${data.appraise.eventScore}</td>
			</tr>
			<tr>
				<td class="col-xs-2">计算公式</td><td  colspan="3"class="print-normal col-xs-8">${data.eventGongShi}</td>
			</tr>
			<tr>
				<td class="col-xs-2">公式意义</td><td colspan="3" class="print-normal col-xs-8">${data.eventJieShi}</td>
			</tr>
			
		</table>
	</div>
	</div>
</div>
</body>
</html>