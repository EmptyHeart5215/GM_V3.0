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
<script>
$(function(){
	//与户主关系
	$("[name='codeOwnerRelation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_OWNER_RELATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});

});

</script>
</head>
<body>
<div class="row">
	<div class="col-xs-12" id="body">
		<div id="print">
			<h2><center>人口信息采集表</center></h2>
			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">人口基本信息</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">姓名</td><td class="print-normal col-xs-4">${vdata.person.name}</td><td class="col-xs-2">曾用名</td><td class="print-normal col-xs-4">${vdata.person.otherName}</td></tr>
					<tr><td class="col-xs-2">身份证号</td><td class="print-normal col-xs-4">${vdata.person.cid}</td><td class="col-xs-2">性别</td><td class="print-normal col-xs-4">${vdata.person.sex}</td></tr>
					<tr><td class="col-xs-2">联系电话</td><td class="print-normal col-xs-4">${vdata.person.phone}</td><td class="col-xs-2">民族</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeNation}</td></tr>
					<tr><td class="col-xs-2">学历</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeEducation}</td><td class="col-xs-2">籍贯</td><td class="print-normal col-xs-4">${vdata.person.nativePlaceStr}</td></tr>
					<tr><td class="col-xs-2">婚姻状况</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeMarriage}</td><td class="col-xs-2">宗教信仰</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeReligious}</td></tr>
					<tr><td class="col-xs-2">政治面貌</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codePolitical}</td><td class="col-xs-2">服务处所</td><td class="print-normal col-xs-4">${vdata.person.serverAddress}</td></tr>
					<tr><td class="col-xs-2">职业类别</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeJobType}</td><td class="col-xs-2">职业</td><td class="print-normal col-xs-4">${vdata.person.job}</td></tr>
					<tr><td class="col-xs-2">户籍地</td><td class="print-normal col-xs-4">${vdata.person.residenceAddressStr}</td><td class="col-xs-2">户籍地详址</td><td class="print-normal col-xs-4">${vdata.person.residenceDetail}</td></tr>
					<tr><td class="col-xs-2">现住地</td><td class="print-normal col-xs-4">${vdata.person.nowAddressStr}</td><td class="col-xs-2">现住地详址</td><td class="print-normal col-xs-4">${vdata.person.nowAddressDetail}</td></tr>
					<tr><td class="col-xs-2">人户状态</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeHouseholdStatus}</td><td class="col-xs-2">管理类型</td><td class="print-normal col-xs-4">${vdata.person.dicValueMap.codeManageType}</td></tr>
					<tr><td class="col-xs-2">备注</td><td class="print-normal col-xs-4"  colspan="3" >${vdata.person.remark}</td>
				</table>
					
				
			</div>
			</div>
			</div>
		<c:if test="${vdata.huJiPerson.huCode != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">户籍人口</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">是否人户一致</td><td class="print-normal col-xs-4"><c:choose> <c:when test="${vdata.huJiPerson.isRenHuYiZhi}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose> </td><td class="col-xs-2">户口编号</td><td class="print-normal col-xs-4">${vdata.huJiPerson.huCode }</td></tr>
					<tr><td class="col-xs-2">户主公民身份证号</td><td class="print-normal col-xs-4">${vdata.huJiPerson.huZhuCid }</td><td class="col-xs-2">户主姓名</td><td class="print-normal col-xs-4">${vdata.huJiPerson.huZhuName }</td></tr>
					<tr><td class="col-xs-2">与户主关系</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.huJiPerson.dicValueMap.codeOwnerRelation }</td><td class="col-xs-2">户主电话</td><td class="print-normal col-xs-4">${vdata.huJiPerson.huZhuContact }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
		<c:if test="${vdata.liuDongPerson.dicValueMap.codeInflowReason != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">流动人口</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">流入原因</td><td class="print-normal col-xs-4">${vdata.liuDongPerson.dicValueMap.codeInflowReason }</td><td class="col-xs-2">证件类型</td><td class="print-normal col-xs-4">${vdata.liuDongPerson.dicValueMap.codeIdType }</td></tr>
					<tr><td class="col-xs-2">证件号</td><td class="print-normal col-xs-4" colspan="3">${vdata.liuDongPerson.cid }</td></tr>
					<tr><td class="col-xs-2">登记日期</td><td class="print-normal col-xs-4">${vdata.liuDongPerson.registDate }</td><td class="col-xs-2">证件到期日期</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.liuDongPerson.endDate }</td></tr>
				    <tr><td class="col-xs-2">住所类型</td><td class="print-normal col-xs-4">${vdata.liuDongPerson.dicValueMap.codeZhuSuoType }</td><td class="col-xs-2">是否重点关注人员</td><td class="print-normal col-xs-4"><c:choose> <c:when test="${vdata.liuDongPerson.isGuanZhu}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
		
		<c:if test="${vdata.ziYuanPerson.dicValueMap.codePerResources != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">资源人群</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">资源类型</td><td class="print-normal col-xs-4">${vdata.ziYuanPerson.dicValueMap.codePerResources }</td><td class="col-xs-2">职称</td><td class="print-normal col-xs-4">${vdata.ziYuanPerson.titles }</td></tr>
					<tr><td class="col-xs-2">参加社会组织名称</td><td class="print-normal col-xs-4">${vdata.ziYuanPerson.workcompany }</td><td class="col-xs-2">加入时间</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.ziYuanPerson.inDate }</td></tr>
				    <tr><td class="col-xs-2">资格证号</td><td class="print-normal col-xs-4">${vdata.ziYuanPerson.certificate }</td><td class="col-xs-2">职务</td><td class="print-normal col-xs-4">${vdata.ziYuanPerson.duty }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
				
		<c:if test="${vdata.tSXingShiPerson.fuXingPlace != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">刑释解教人员</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">是否累犯</td><td class="print-normal col-xs-4"><c:choose> <c:when test="${data.tSXingShiPerson.isLeiFan}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">原罪名</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.dicValueMap.codeZuiMing }</td></tr>
					<tr><td class="col-xs-2">原判刑期</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.xingQi }</td><td class="col-xs-2">服刑场所</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.tSXingShiPerson.fuXingPlace }</td></tr>
				    <tr><td class="col-xs-2">释放日期</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.shiFangDate}</td><td class="col-xs-2">危险性评估类型</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.dicValueMap.codeBangJiaoType }</td></tr>
				    <tr><td class="col-xs-2">衔接日期</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.xianJieDate}</td><td class="col-xs-2">衔接情况</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.dicValueMap.codeXianJieRemark }</td></tr>
				    <tr><td class="col-xs-2">安置日期</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.anZhiDate}</td><td class="col-xs-2">安置情况</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.dicValueMap.codeAnZhiRemark }</td></tr>
				    <tr><td class="col-xs-2">未安置原因</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.weiAnZhiReason }</td><td class="col-xs-2">帮教情况</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.helpRemark }</td></tr>
				    <tr><td class="col-xs-2">是否重新犯罪</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.tSXingShiPerson.isAgainFanZui}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">重新犯罪罪名</td><td class="print-normal col-xs-4">${vdata.tSXingShiPerson.againZuiMing }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
		
				
		<c:if test="${vdata.tSJiaoZhengPerson.rectifyNum != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">社区矫正人员</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">社区矫正人员编号</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.rectifyNum }</td><td class="col-xs-2">矫正类别</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.dicValueMap.codeRectifyType }</td></tr>
					<tr><td class="col-xs-2">原羁押场所</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.jiYaPlace }</td><td class="col-xs-2">具体罪名</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.zuiMing }</td></tr>
				    <tr><td class="col-xs-2">案件类别</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.dicValueMap.codeAnJianType }</td><td class="col-xs-2">原判刑期</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.xingQi }</td></tr>
				    <tr><td class="col-xs-2">原判刑开始日期</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.xingQiBeginDate }</td><td class="col-xs-2">原判刑结束日期</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.xingQiEndDate }</td></tr>
				    <tr><td class="col-xs-2">矫正开始日期</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.rectifyBeginDate }</td><td class="col-xs-2">矫正结束日期</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.rectifyEndDate }</td></tr>
				    <tr><td class="col-xs-2">接收方式</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.dicValueMap.codeJieShouType }</td><td class="col-xs-2">“四史”情况</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.dicValueMap.codeSiShi }</td></tr>
				    <tr><td class="col-xs-2">是否累惯犯</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.tSJiaoZhengPerson.isGuanFan}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">“三涉”情况</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.dicValueMap.codeSanShe }</td></tr>
				    <tr><td class="col-xs-2">是否建立矫正小组</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.tSJiaoZhengPerson.isBuildGroup}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">矫正小组人员组成情况</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.dicValueMap.codeGroupSituation }</td></tr>
					<tr><td class="col-xs-2">矫正解除类型</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.dicValueMap.codeJieChuType }</td><td class="col-xs-2">是否有脱管</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.tSJiaoZhengPerson.isTuoGuan}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">脱管原因</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.tuoGuanReason }</td><td class="col-xs-2">检察监脱管管情况</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.jianTuoRemark }</td></tr>
				    <tr><td class="col-xs-2">脱管纠正情况</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.tuoJiaoRemark }</td><td class="col-xs-2">是否有漏管</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.tSJiaoZhengPerson.isLouGuan}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">漏管原因</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.louGuanReason }</td><td class="col-xs-2">检察监督漏管情况</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.jianLouRemark }</td></tr>
				    <tr><td class="col-xs-2">漏管纠正情况</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.louJiuRemark }</td><td class="col-xs-2">奖惩情况</td><td class="print-normal col-xs-4">$${vdata.tSJiaoZhengPerson.jiangChengRemark }}</td></tr>
				    <tr><td class="col-xs-2">刑罚变更执行情况</td><td class="print-normal col-xs-4">${vdata.tSJiaoZhengPerson.xingBianZhiRemark }</td><td class="col-xs-2">是否重新犯罪</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.tSJiaoZhengPerson.isChongFan}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">重新犯罪名称</td><td colspan="3" class="print-normal col-xs-10">${vdata.tSJiaoZhengPerson.chongFanName }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
	    <c:if test="${vdata.tSXiDuPerson.firstDate != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">吸毒人员</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">初次发现日期</td><td class="print-normal col-xs-4">${vdata.tSXiDuPerson.firstDate }</td><td class="col-xs-2">管控情况</td><td class="print-normal col-xs-4">${vdata.tSXiDuPerson.dicValueMap.codeGuanKong }</td></tr>
					<tr><td class="col-xs-2">管控人姓名</td><td class="print-normal col-xs-4">${vdata.tSXiDuPerson.guanKongName }</td><td class="col-xs-2">管控人联系方式</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.tSXiDuPerson.guanKongPhone }</td></tr>
				    <tr><td class="col-xs-2">帮扶情况</td><td class="print-normal col-xs-4">${vdata.tSXiDuPerson.bangFuRemark }</td><td class="col-xs-2">帮扶人姓名</td><td class="print-normal col-xs-4">${vdata.tSXiDuPerson.bangFuName }</td></tr>
				    <tr><td class="col-xs-2">帮扶人联系方式</td><td class="print-normal col-xs-4">${vdata.tSXiDuPerson.bangFuPhone }</td><td class="col-xs-2">有无犯罪史</td><td class="print-normal col-xs-4"><c:choose> <c:when test="${vdata.tSXiDuPerson.isFanZui}">有</c:when> <c:otherwise>无</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">犯罪情况</td><td class="print-normal col-xs-4">${vdata.tSXiDuPerson.fanZuiRemark}</td><td class="col-xs-2">吸毒原因</td><td class="print-normal col-xs-4">${vdata.tSXiDuPerson.dicValueMap.codeXiDuReason }</td></tr>
				    <tr><td class="col-xs-2">吸毒后果</td><td colspan="3"class="print-normal col-xs-10">${vdata.tSXiDuPerson.dicValueMap.codeXiDuEffect }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
		
		<c:if test="${vdata.tSJingShenPerson.jianHuName != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">精神病人员</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">家庭经济状况</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.dicValueMap.codeJingJiSituation }</td><td class="col-xs-2">是否纳入低保</td><td class="print-normal col-xs-4"><c:choose> <c:when test="${vdata.tSJingShenPerson.isDiBao}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
					<tr><td class="col-xs-2">监护人身份号码</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.jianHuCid }</td><td class="col-xs-2">监护人姓名</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.jianHuName }</td></tr>
					<tr><td class="col-xs-2">监护人联系方式</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.jianHuPhone }</td><td class="col-xs-2">初次发病日期</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.tSJingShenPerson.firstIllDate }</td></tr>
				    <tr><td class="col-xs-2">诊断类型</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.dicValueMap.codeZhenDuanType }</td><td class="col-xs-2">有无肇事肇祸史</td><td class="print-normal col-xs-4"><c:choose> <c:when test="${vdata.tSJingShenPerson.isZhaoShi}">有</c:when> <c:otherwise>无</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">肇事肇祸次数</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.zhaoShiCount }</td><td class="col-xs-2">上次肇事肇祸日期</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.lastZhaoShiDate }</td></tr>
                    <tr><td class="col-xs-2">危险性评估等级</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.dicValueMap.codeWeiXianClasses }</td><td class="col-xs-2">治疗情况</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.dicValueMap.codeZhiLiaoSituation }</td></tr>
				    <tr><td class="col-xs-2">治疗医院名称</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.yiYuanName }</td><td class="col-xs-2">实施住院治疗原因</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.dicValueMap.codeZhuYuanReason }</td></tr>
				    <tr><td class="col-xs-2">接收康复训练机构</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.jiGouName }</td><td class="col-xs-2">参与管理人员</td><td class="print-normal col-xs-4">${vdata.tSJingShenPerson.dicValueMap.codeManagePeople }</td></tr>
				    <tr><td class="col-xs-2">帮扶情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.tSJingShenPerson.dicValueMap.codeBangFuSituation }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
		
		<c:if test="${vdata.tSAiZiPerson.bangFuName != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">艾滋病人员</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">感染途径</td><td class="print-normal col-xs-4">${vdata.tSAiZiPerson.dicValueMap.codeGanRanRoute }</td><td class="col-xs-2">是否有违法犯罪史</td><td class="print-normal col-xs-4"><c:choose> <c:when test="${vdata.tSAiZiPerson.isFanZui}">有</c:when> <c:otherwise>无</c:otherwise> </c:choose></td></tr>
					<tr><td class="col-xs-2">违法犯罪情况</td><td class="print-normal col-xs-4">${vdata.tSAiZiPerson.fanZuiRemark}</td><td class="col-xs-2">案件类别</td><td class="print-normal col-xs-4">${vdata.tSAiZiPerson.dicValueMap.codeAnJianType }</td></tr>
					<tr><td class="col-xs-2">关注类型</td><td class="print-normal col-xs-4">${vdata.tSAiZiPerson.dicValueMap.codeGuanZhuType }</td><td class="col-xs-2">帮扶情况</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.tSAiZiPerson.bangFuRemark }</td></tr>
				    <tr><td class="col-xs-2">帮扶人姓名</td><td class="print-normal col-xs-4">${vdata.tSAiZiPerson.bangFuName }</td><td class="col-xs-2">帮扶人联系方式</td><td class="print-normal col-xs-4">${vdata.tSAiZiPerson.bangFuPhone }</td></tr>
				    <tr><td class="col-xs-2">收治情况</td><td class="print-normal col-xs-4">${vdata.tSAiZiPerson.dicValueMap.codeShouZhiSituation }</td><td class="col-xs-2">牧治机构名称</td><td class="print-normal col-xs-4">${vdata.tSAiZiPerson.shouZhiJiGou }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
	    <c:if test="${vdata.tSXieJiaoPerson.xieJiaoName != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">邪教人员</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">邪教名称</td><td class="print-normal col-xs-4">${vdata.tSXieJiaoPerson.xieJiaoName }</td><td class="col-xs-2">入教时间</td><td class="print-normal col-xs-4">${vdata.tSXieJiaoPerson.beginDate }</td></tr>
					<tr><td class="col-xs-2">入教原因</td><td class="print-normal col-xs-4">${vdata.tSXieJiaoPerson.reason }</td><td class="col-xs-2">帮扶人姓名</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.tSXieJiaoPerson.bangFuName }</td></tr>
				    <tr><td class="col-xs-2">帮扶人联系方式</td><td class="print-normal col-xs-4">${vdata.tSXieJiaoPerson.bangFuPhone }</td><td class="col-xs-2">帮扶情况</td><td class="print-normal col-xs-4">${vdata.tSXieJiaoPerson.bangFuRemark  }</td></tr>
				    <tr><td class="col-xs-2">现实表现</td><td colspan="3" class="print-normal col-xs-10">${vdata.tSXieJiaoPerson.performance }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		<c:if test="${vdata.liuShouPerson.zhuYaoMember != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">留守人员</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">是否人户一致</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.liuShouPerson.isRenHuYiZhi}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">健康状况</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.dicValueMap.codeHealth }</td></tr>
					<tr><td class="col-xs-2">个人年收入</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.geRenIncome }</td><td class="col-xs-2">留守人员类型</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.dicValueMap.codeLiuShouType }</td></tr>
					<tr><td class="col-xs-2">家庭主要成员</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.zhuYaoMember }</td><td class="col-xs-2">与留守人员关系</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.liuShouPerson.dicValueMap.codeLiuShouRelation }</td></tr>
				    <tr><td class="col-xs-2">家庭主要成员<br>身份证号</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.memberCid }</td><td class="col-xs-2">家庭主要成员<br>健康状况</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.dicValueMap.codeMemberHealth }</td></tr>
				    <tr><td class="col-xs-2">家庭主要成员<br>联系电话</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.memberPhone }</td><td class="col-xs-2">家庭年收入</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.homeIncome }</td></tr>
				    <tr><td class="col-xs-2">家庭主要成员<br>工作详细地址</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.memberWorkAddress }</td><td class="col-xs-2">困难及诉求</td><td class="print-normal col-xs-4">${vdata.liuShouPerson.kuNanRemark }</td></tr>
				    <tr><td class="col-xs-2">帮扶情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.liuShouPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
	    <c:if test="${vdata.bfCanJiPerson.num != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">残疾人</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">残疾证号</td><td class="print-normal col-xs-4">${vdata.bfCanJiPerson.num }</td><td class="col-xs-2">发证时间</td><td class="print-normal col-xs-4">${vdata.bfCanJiPerson.sendDate }</td></tr>
					<tr><td class="col-xs-2">残疾类别</td><td class="print-normal col-xs-4">${vdata.bfCanJiPerson.dicValueMap.codeDisableType }</td><td class="col-xs-2">残疾等级</td><td id="codeOwnerRelation" class="print-normal col-xs-4">${vdata.bfCanJiPerson.dicValueMap.codeDisableLevel }</td></tr>
				    <tr><td class="col-xs-2">帮扶情况</td><td colspan="3"class="print-normal col-xs-10">${vdata.bfCanJiPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		<c:if test="${vdata.bfDiBaoPerson.lowProtectNum != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">低保户</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">低保证号码</td><td class="print-normal col-xs-4">${vdata.bfDiBaoPerson.lowProtectNum }</td><td class="col-xs-2">发证时间</td><td class="print-normal col-xs-4">${vdata.bfDiBaoPerson.sendDate }</td></tr>
					<tr><td class="col-xs-2">是否五保户</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.bfDiBaoPerson.isFiveProtect}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">保障人口</td><td class="print-normal col-xs-4">${vdata.bfDiBaoPerson.guarantee }</td></tr>
				    <tr><td class="col-xs-2">户月保障金额</td><td class="print-normal col-xs-4">${vdata.bfDiBaoPerson.monthGuarantee }</td><td class="col-xs-2">帮扶情况</td><td class="print-normal col-xs-4">${vdata.bfDiBaoPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		<c:if test="${vdata.bfWuBaoPerson.numberFive != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">五保户</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">五保证号码</td><td class="print-normal col-xs-4">${vdata.bfWuBaoPerson.numberFive }</td><td class="col-xs-2">保证人口</td><td class="print-normal col-xs-4">${vdata.bfWuBaoPerson.guarantee }</td></tr>
				    <tr><td class="col-xs-2">户月保障金额</td><td class="print-normal col-xs-4">${vdata.bfWuBaoPerson.monthGuarantee }</td><td class="col-xs-2">帮扶情况</td><td class="print-normal col-xs-4">${vdata.bfWuBaoPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
	    <c:if test="${vdata.bfJiuZhuPerson.disease != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">社区救助人员</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">是否重大疾病</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.bfJiuZhuPerson.isMajorDiseases}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">疾病名称</td><td class="print-normal col-xs-4">${vdata.bfJiuZhuPerson.disease }</td></tr>
				    <tr><td class="col-xs-2">救助时间</td><td class="print-normal col-xs-4">${vdata.bfJiuZhuPerson.assistDate }</td><td class="col-xs-2">救助金额</td><td class="print-normal col-xs-4">${vdata.bfJiuZhuPerson.assistAmount }</td></tr>
				    <tr><td class="col-xs-2">帮扶情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.bfJiuZhuPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		<c:if test="${vdata.bfKongChaoPerson.age != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">空巢老人</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">年龄</td><td class="print-normal col-xs-4">${vdata.bfKongChaoPerson.age }</td><td class="col-xs-2">子女去向</td><td class="print-normal col-xs-4">${vdata.bfKongChaoPerson.childGo }</td></tr>
				    <tr><td class="col-xs-2">帮扶情况</td><td colspan="3"class="print-normal col-xs-10">${vdata.bfKongChaoPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		<c:if test="${vdata.bfKunNanZhiGongPerson.description != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">困难职工</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">情况说明</td><td class="print-normal col-xs-4">${vdata.bfKunNanZhiGongPerson.description }</td><td class="col-xs-2">帮扶情况</td><td class="print-normal col-xs-4">${vdata.bfKunNanZhiGongPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		<c:if test="${vdata.bfTeKunShengPerson.schoolName != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">特困学生</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">年级</td><td class="print-normal col-xs-4">${vdata.bfTeKunShengPerson.dicValueMap.codeGrade }</td><td class="col-xs-2">就读学校</td><td class="print-normal col-xs-4">${vdata.bfTeKunShengPerson.schoolName }</td></tr>
				    <tr><td class="col-xs-2">是否低保户</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.bfTeKunShengPerson.isDiBao}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">帮扶情况</td><td class="print-normal col-xs-4">${vdata.bfTeKunShengPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		<c:if test="${vdata.qingShaoNian.jianHuName != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">重点青少年</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">人员类型</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.dicValueMap.codeQsnType }</td><td class="col-xs-2">家庭情况</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.dicValueMap.codeJiaTingSituation }</td></tr>
				    <tr><td class="col-xs-2">监护人姓名</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.jianHuName }</td><td class="col-xs-2">监护人身份号码</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.jianHuCid }</td></tr>
				    <tr><td class="col-xs-2">与监护人关系</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.dicValueMap.codeJianHuRelation }</td><td class="col-xs-2">监护人联系方式</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.jianHuPhone }</td></tr>
				    <tr><td class="col-xs-2">监护人居住详址</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.jianHuAddress }</td><td class="col-xs-2">是否违法犯罪</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.qingShaoNian.isFanZui}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">违法犯罪情况</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.fanZuiRemark}</td><td class="col-xs-2">帮扶人姓名</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.bangFuName }</td></tr>
				    <tr><td class="col-xs-2">帮扶人联系方式</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.bangFuPhone }</td><td class="col-xs-2">帮扶手段</td><td class="print-normal col-xs-4">${vdata.qingShaoNian.dicValueMap.codeBangFuType }</td></tr>
				    <tr><td class="col-xs-2">帮扶情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.qingShaoNian.bangFuRemark}</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
	    <c:if test="${vdata.yongJunPerson.codeSamc != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">拥军扶优</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
					<tr><td class="col-xs-2">类别</td><td class="print-normal col-xs-4">${vdata.yongJunPerson.dicValueMap.codeSamc }</td><td class="col-xs-2">是否置业</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.yongJunPerson.isHousePurchasing}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">入伍时间</td><td class="print-normal col-xs-4">${vdata.yongJunPerson.enlistDate }</td><td class="col-xs-2">退伍时间</td><td class="print-normal col-xs-4">${vdata.yongJunPerson.veteransDate }</td></tr>
				    <tr><td class="col-xs-2">优抚证号码</td><td class="print-normal col-xs-4">${vdata.yongJunPerson.specialPermitNum }</td><td class="col-xs-2">发证日期</td><td class="print-normal col-xs-4">${vdata.yongJunPerson.sendDate }</td></tr>
				    <tr><td class="col-xs-2">帮扶人员</td><td class="print-normal col-xs-4">${vdata.yongJunPerson.bangFuName }</td><td class="col-xs-2">帮扶人联系方式</td><td class="print-normal col-xs-4">${vdata.yongJunPerson.bangFuPhone }</td></tr>
				    <tr><td class="col-xs-2">帮扶情况</td><td colspan="3" class="print-normal col-xs-10">${vdata.yongJunPerson.bangFuRemark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		<c:if test="${vdata.zhiYuanPerson.codeVolunteerType != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">志愿者</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">类别</td><td class="print-normal col-xs-4">${vdata.zhiYuanPerson.dicValueMap.codeVolunteerType }</td><td class="col-xs-2">备注</td><td class="print-normal col-xs-4">${vdata.zhiYuanPerson.remark }</td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
	    <c:if test="${vdata.laoDongPerson.isHasJiuYeZheng != null}">
		<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:5px;">
					<h4 class="green">劳动保障</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<table class="print-table" >
				    <tr><td class="col-xs-2">最高学历院校</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.xueXiao }</td><td class="col-xs-2">专业</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.zhuanYe }</td></tr>
				    <tr><td class="col-xs-2">毕业时间</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.biYeDate }</td><td class="col-xs-2">毕业证号</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.biYeCode }</td></tr>
				    <tr><td class="col-xs-2">是否有资格证</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.laoDongPerson.isZiGe}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">资格证书类型</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.ziGeZhengType }</td></tr>
				    <tr><td class="col-xs-2">是否持有就业失业登记证</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.laoDongPerson.isHasJiuYeZheng}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">就业失业登记证编号</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.jiuYeCode }</td></tr>
				    <tr><td class="col-xs-2">就业失业登记证发证地</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.faZhengDi }</td><td class="col-xs-2">发证时间</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.faZhengDate }</td></tr>
				    <tr><td class="col-xs-2">就业状况类型</td><td class="print-normal col-xs-4">${vdata.laoDongPerson.dicValueMap.codeJiuYeType }</td><td class="col-xs-2">是否签订劳动合同</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.laoDongPerson.isHeTong}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">是否有养老保险</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.laoDongPerson.isYangLao}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">是否有失业保险</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.laoDongPerson.isShiYeBaoXian}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">是否有医疗保险</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vvdata.laoDongPerson.isYiLiao}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">是否有工伤保险</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.laoDongPerson.isGongShang}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				    <tr><td class="col-xs-2">是否有生育保险</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.laoDongPerson.isShengYu}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td><td class="col-xs-2">是否有住房公积金</td><td class="print-normal col-xs-4"><c:choose><c:when test="${vdata.laoDongPerson.isGongJiJin}">是</c:when> <c:otherwise>否</c:otherwise> </c:choose></td></tr>
				</table>
	
			</div>
			</div>
			</div>
		</c:if>
			
		</div>		
		</div>
</div>
</body>