<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored ="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include  page="/resource/res.html"/>

 <style type="text/css">
 table
 {
     border-collapse: collapse;
     border: none;
     font-size:12px
 }
     table td div
     {
         font-weight:bold;
         text-align:center;
     }

 td
 {
     border-collapse: collapse;
     border: solid #000 1px;
     height: 30px;
 }
 .grid_message
 {
     margin-bottom:5px
 }
 .from_h1 {
	font-size: 22px;
	font-family: "微软雅黑";
    font-weight:900;
	text-align: center;
	color: #000;
	
	margin-bottom: 5px;
	padding: 5px;
}  
</style>


</head>
<body>
 <object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width="0" height="0"> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width="0" height="0" pluginspage="install_lodop32.exe"></embed>
</object> 

  <div id="List_Main2" style="overflow-x: hidden; overflow-y: auto;">
            <a href="javascript:prn_preview()">打印</a>
            <div class="List_from">
                <h3 class="from_h1">社区网格人口信息采集表（一）</h3>
                <div class="grid_message">${vdata.map.GRID_NAME}&nbsp;${vdata.map.BUILD_NAME }&nbsp;${vdata.map.UNITNAME}单元&nbsp;${vdata.map.HOUSE_NUM }室<strong>网格编码</strong></div>
                <table width="100%">                  
                   <tr>
                        <td rowSpan="8"><div>基本信息</div></td>
                        <td><div>姓名</div></td>
                        <td>${vdata.map.Name }</td>
                        <td width="13%"><div>身份证号</div></td>
                        <td colSpan="3">${vdata.map.CID }</td>
                        <td rowSpan="5">
                        <c:choose>
	                        <c:when test="${vdata.imgPath eq null}">
	                        	<img style="width: 150px; height: 150px; text-align: center;" src="${base }/resource/images/nopic.jpg">
	                        </c:when>
	                        <c:otherwise>
	                        	<img style="width: 150px; height: 150px; text-align: center;" src="${base}/upload/${vdata.imgPath}">
	                        </c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <td><div>出生日期</div></td>
                        <td>${vdata.map.BIRTHDAY }</td>
                        <td style="width: 120px;"><div>性别</div></td>
                        <td  style="width: 180px;">${vdata.map.CODE_SEX_NAME}</td>
                        <td width="13%"><div>民族</div></td>
                        <td style="width: 180px;">${vdata.map.CODE_NATION_NAME }</td>
                    </tr>
                      <tr>
                        <td><div>血型</div></td>
                        <td>${vdata.map.CODE_BLOOD_NAME }</td>
                       <td><div>联系电话</div></td>
                          <td>${vdata.map.TEL }</td>
                          <td><div>文化程度</div></td>
                        <td>${vdata.map.CODE_EDUCATION_NAME }</td>
                    </tr>
                      <tr>
                        
                        <td><div>宗教信仰</div></td>
                        <td >${vdata.map.CODE_RELIGIOUS_NAME }</td>
                        <td><div>健康状况</div></td>
                        <td colSpan="3">${vdata.map.CODE_HEALTH_NAME }</td>
                    </tr>
                      <tr>
                        <td><div>政治面貌</div></td>                       
                        <td colSpan="5">${vdata.map.CODE_POLITICAL_NAME }</td>
                    </tr>
                      <tr>
                        <td><div>户籍地</div></td>                        
                        <td colSpan="6">${vdata.map.RESIDENCE_ADDRESS }</td>
                        
                      <tr>
                        <td><div>人户状态</div></td>
                          <td >${vdata.map.CODE_HOUSE_HOLD_TYPE_NAME }</td>
                        <td><div>与户主关系</div></td>
                        <td>${vdata.map.CODE_HOUSEHOLD_RELATION_NAME }</td>
                        <td><div>参加工作时间</div></td>
                        <td colSpan="2">${vdata.map.WORK_BEGIN }</td>
                    </tr>
                      <tr>
                          <td><div>退休时间</div></td>
                        <td>${vdata.map.work_end }</td>
                        <td><div>管理类型</div></td>
                        <td>${vdata.map.CODE_MANAGETYPE_NAME }</td>
                        <td><div>社会职务</div></td>
                        <td colSpan="2">${vdata.map.CODE_SOCIAL_DUTY_NAME }</td>                       
                    </tr>

                    <tr>
                        <td rowSpan="2"><div>家庭信息</div></td>
                        <td><div>婚姻状况</div></td>
                         <td colSpan="2">${vdata.map.CODE_MARRIAGE_NAME }</td>
                         <td><div>结婚时间</div></td>
                         <td colSpan="3">${vdata.map.MARRIAGE_DATE }</td>
                    </tr>
                 
                    <tr>
                        <td rowSpan="2" width="5%">
                            <div>人口服务管理类别信息</div>
                        </td>
                       <td rowSpan="2" width="13%"><div>流动人口</div></td>
                        <td><div>流入事由</div></td>
                        <td colSpan="5">${vdata.map.INFLOW_REASON }</td>
                    </tr>
                     <tr>                        
                         <td width="12%"><div>发证时间</div></td>
                         <td colspan="2">${vdata.map.RESIDENCY_DATE }</td>
                         <td width="12%"><div>流出去向</div></td>
                         <td colspan="2">${vdata.map.OUTFLOW_DIRECTION }</td>
                    </tr>  
                   </table>
                   <br>
                <div class="grid_message"><strong>矫正人员</strong></div><br>
                        <table width="100%">
                            <tr>
                                <td  style="width: 120px;">
                                    <div>矫正开始时间：</div>
                                </td>
                                <td  style="width: 160px;">
                                   
                                       ${vdata.redress.REDRESS_STAT_DATE }
                                    
                                </td>
                                <td  style="width: 120px;">
                                    <div>矫正结束时间：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                        ${vdata.redress.REDRESS_END_DATE }
                                   
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>罪名：</div>
                                </td>
                                <td>
                                  
                                        ${vdata.redress.CHARGES }
                                    
                                </td>
                                <td >
                                    <div>刑种：</div>
                                </td>
                                <td>
                                  
                                        ${vdata.redress.PUNISH_TYPE }
                                   
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>刑期：</div>
                                </td>
                                <td>
                                   
                                        ${vdata.redress.PRISION_TERM }
                                   
                                </td>
                                <td >
                                    <div>附加刑：</div>
                                </td>
                                <td>
                                   
                                        ${vdata.redress.APPEND }
                                   
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>刑期开始日期：</div>
                                </td>
                                <td>
                                   
                                        ${vdata.redress.START_DATE }
                                  
                                </td>
                                <td >
                                    <div>刑期结束日期：</div>
                                </td>
                                <td>
                                    
                                        ${vdata.redress.END_DATE }
                                   
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>处理机关：</div>
                                </td>
                                <td>
                                    
                                        ${vdata.redress.HANDLE_ORGAN }
                                   
                                </td>
                                <td >
                                    <div>处理法律文书号：</div>
                                </td>
                                <td>
                                   
                                        ${vdata.redress.HANDLELEGAL_CODE }
                                   
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>处理时间：</div>
                                </td>
                                <td>
                                   
                                        ${vdata.redress.HANDLE_DATE }
                                   
                                </td>
                                <td >
                                    <div>刑期变动时间：</div>
                                </td>
                                <td>
                                  
                                        ${vdata.redress.PRISON_CHANGE_DATE }
                                 
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>社区矫正类别：</div>
                                </td>
                                <td>
							${vdata.redress.CODE_PER_REDRESS }
                                </td>
                                <td >
                                    <div>接收时间：</div>
                                </td>
                                <td>
                                   
                                        ${vdata.redress.RECIEVE_DATE }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>帮教成员：</div>
                                </td>
                                <td>
                                    
                                        ${vdata.redress.HELPTEACH_MEMBER }
                                    
                                </td>
                                <td >
                                    <div>现实表现：</div>
                                </td>
                                <td>
                                    
                                       ${vdata.redress.CODE_PERFORMANCE }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>备注：</div>
                                </td>
                                <td colspan="3">
                                    
                                        ${vdata.redress.REDRESS_REMARK }
                                    
                                </td>
                            </tr>
                        </table>
                    
                <br>
                 
                    <div class="grid_message"><strong>吸毒人员</strong></div><br>
                        <input type="hidden" name="Code"  value="${vdata.drug.CODE }" />
                        <table width="100%">
                            <tr>
                                <td style="width: 120px;">
                                    <div>吸食毒品类型：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                        ${vdata.drug.DRUG_TYPE }
                                   
                                </td>
                                <td style="width: 120px;">
                                    <div>处罚类别：</div>
                                </td>
                                <td style="width: 160px;">
                                   
                                        ${vdata.drug.PUNISH_TYPE }
                                   
                                </td>
                            </tr>
                          
                            <tr>

                                <td >
                                    <div>备注：</div>
                                </td>
                                <td colspan="3">
                                    
                                        ${vdata.drug.DRUG_REMARK }
                                    
                                </td>
                            </tr>

                        </table><br>
                    <div class="grid_message"><strong>邪教人员</strong></div><br>
                        <table width="100%">
                            <tr>
                                <td style="width: 120px;">
                                    <div>练功时间：</div>
                                </td>
                                <td style="width: 160px;">
                                   
                                        ${vdata.falun.BEGIN_DATE }
                                   
                                </td>
                                <td style="width: 120px;">
                                    <div>练功原因：</div>
                                </td>
                                <td style="width: 160px;">
                                   
                                        ${vdata.falun.REASON }
                                   
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>受打击处理情况：</div>
                                </td>
                                <td colspan="3">
                                    
                                        ${vdata.falun.HANDLE }
                                    
                                </td>

                            </tr>
                            <tr>

                                <td >
                                    <div>现实表现：</div>
                                </td>
                                <td colspan="3">
                                  
                                        ${vdata.falun.PERFORMANCE }
                                  
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>描述：</div>
                                </td>
                                <td colspan="3">
                                   
                                        ${vdata.falun.DECRIPTION }
                                    
                                </td>

                            </tr>

                        </table>
                        <br>
               
                        <div class="grid_message"><strong>重点上访人员</strong></div>
                        <br><table width="100%">
                            <tr>
                                <td style="width: 120px;">
                                    <div>开始上访时间：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                        ${vdata.petition.PETITION_DATE }
                                    
                                </td>
                                <td style="width: 120px;">
                                    <div>问题管辖部门：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                        ${vdata.petition.PROBLEM_SCOPE }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>上访事由：</div>
                                </td>
                                <td colspan="3">
                                    
                                        ${vdata.petition.PETITION_REASON }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>处理结论：</div>
                                </td>
                                <td colspan="3">
                                   
                                        ${vdata.petition.HANDLE_CONCLUSION }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>受处理情况：</div>
                                </td>
                                <td>
                                    
                                       ${vdata.petition.HANDLE_SITUATION }
                                    
                                </td>
                                <td >
                                    <div>稳控措施：</div>
                                </td>
                                <td>
                                    ${vdata.petition.CONTROL_MEASURES }
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>管控人员：</div>
                                </td>
                                <td>
                                    ${vdata.petition.CONTROL_PERSON }
                                </td>
                                <td >
                                    <div>管控人员电话：</div>
                                </td>
                                <td>
                                    ${vdata.petition.CONTROL_PHONE }
                                </td>
                            </tr>

                            <tr>
                                <td >
                                    <div>备注：</div>
                                </td>
                                <td colspan="3">
                                   
                                        ${vdata.petition.PETITION_REMARK }
                                    
                                </td>

                            </tr>

                        </table><br>
                        <div class="grid_message"><strong>精神疾病人员</strong></div>
                        <br><table width="100%">
                            <tr>
                                <td style="width: 120px;">
                                    <div>姓名：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                      ${vdata.jingshen.NAME }
                                    
                                </td>
                                <td style="width: 120px;">
                                    <div>身份证号：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                        ${vdata.jingshen.CID }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>家庭住址：</div>
                                </td>
                                <td colspan="3">
                                    
                                       ${vdata.jingshen.RESIDENCE_ADDRESS }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>工作单位：</div>
                                </td>
                                <td colspan="3">
                                   
                                        ${vdata.jingshen.WORK_ADDRESS }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>监护人姓名：</div>
                                </td>
                                <td>
                                    
                                     ${vdata.jingshen.GUARDIAN_NAME }
                                    
                                </td>
                                <td >
                                    <div>监护人电话：</div>
                                </td>
                                <td>
                                    ${vdata.fajingshenlun.GUARDIAN_NUMBER }
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>与监护人关系：</div>
                                </td>
                                <td>
                                    ${vdata.jingshen.GUARDIAN_RELATIONSHIP }
                                </td>
                                <td >
                                    <div>符合第几条：</div>
                                </td>
                                <td>
                                    ${vdata.jingshen.SYMPTOM }
                                </td>
                            </tr>
                        </table><br>
                        
                        <div class="grid_message"><strong>刑满释放人员</strong></div>
                        <br><table width="100%">
                            <tr>
                                <td  style="width: 18%;">
                                    <div>处罚类型</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.emancipist.CODE_PUNISHMENT }
                                    </div>
                                </td>
                                <td  style="width: 18%;">
                                    <div>罪名或违法行为</div>
                                </td>
                                <td>
                                    <div>
                                      ${vdata.emancipist.ILLEGAL_ACT }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>刑种</div>
                                </td>
                                <td>
                                    <div>
                                       ${vdata.emancipist.PUNISHMENT_KINDS }
                                    </div>
                                </td>
                                <td >
                                    <div>期限</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.emancipist.CRIMINAL_LIMIT }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>进入时间</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.emancipist.EMANCIPIST_IN_DATE }
                                    </div>
                                </td>
                                <td >
                                    <div>释放时间</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.emancipist.RELEASE_DATE }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>家庭住址</div>
                                </td>
                                <td>
                                    <div>
                                       ${vdata.emancipist.EMANCIPIST_ADDRESS }
                                    </div>
                                </td>
                                <td >
                                    <div>人数</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.emancipist.NUMBERS }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>职业</div>
                                </td>
                                <td>
                                    <div>
                                       ${vdata.emancipist.PROFESSION }
                                    </div>
                                </td>
                                <td >
                                    <div>处理机关</div>
                                </td>
                                <td>
                                    <div>
               ${vdata.emancipist.TREATMENT_ORGEN }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>监管场所</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.emancipist.RAGULATORY_SITES }
                                    </div>
                                </td>
                                <td >
                                    <div>是否已衔接</div>
                                </td>
                                <td>
                                    <div>
                                        
                                       ${vdata.emancipist.ISLINKUP }
                                  
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>安置帮教情况</div>
                                </td>
                                <td>
                                    <div>
										${vdata.emancipist.CODE_PLACE_SITUATION }
                                    </div>
                                </td>
                                <td >
                                    <div>现实表现</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.emancipist.CODE_PERFORMANCE }
                                    </div>
                                </td>
                            </tr>
                        
                            <tr>

                                <td >
                                    <div>备注</div>
                                </td>
                                <td colSpan="3">
                                    <div>
                                        ${vdata.emancipist.EMANCIPIST_REMARK }
                                    </div>
                                </td>
                            </tr>
                        </table><br>
                       
                        <div class="grid_message"><strong>低保户</strong></div>
                        <br><table width="100%">
                            <tr>
                                <td style="width: 120px;">
                                    <div>低保证号码：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                      ${vdata.lowprotect.LOW_PROTECT_NUM }
                                    
                                </td>
                                <td style="width: 120px;">
                                    <div>发证时间：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                        ${vdata.lowprotect.SEND_DATE }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>帮扶人员：</div>
                                </td>
                                <td colspan="3">
                                    
                                       ${vdata.lowprotect.ASSIST_NAME }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>帮扶情况：</div>
                                </td>
                                <td colspan="3">
                                   
                                        ${vdata.lowprotect.ASSIST_SITUATION }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>是否五保户：</div>
                                </td>
                                <td>
                                    
                                     ${vdata.lowprotect.IS_FIVE_PROTECT }
                                    
                                </td>
                                <td >
                                    <div>保障人口：</div>
                                </td>
                                <td>
                                    ${vdata.lowprotect.GUARANTEE }
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>户月保障金额：</div>
                                </td>
                                <td>
                                   ${vdata.lowprotect.MONTH_GUARANTEE }
                                </td>
                                <td >
                                    <div>家庭住址：</div>
                                </td>
                                <td>
                                    ${vdata.lowprotect.ADDRESS }
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>描述：</div>
                                </td>
                                <td colspan="3">
                                    ${vdata.lowprotect.DESCRIPTION }
                                </td>
                            </tr>
                        </table><br>
                        
                          <div class="grid_message"><strong>空巢老人</strong></div>
                        <br><table width="100%">
                            <tr>
                                <td style="width: 120px;">
                                    <div>年龄：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                     ${vdata.emptynest.AGE }
                                    
                                </td>
                                <td style="width: 120px;">
                                    <div>电话：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                        ${vdata.emptynest.PHONE }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>子女去向：</div>
                                </td>
                                <td colspan="3">
                                    
                                      ${vdata.emptynest.CHILDREN_WHEREABOUTS }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>描述：</div>
                                </td>
                                <td colspan="3">
                                   
                                        ${vdata.emptynest.REMARK }
                                    
                                </td>
                            </tr>
                        </table><br>
                        
                        
                        
						<div class="grid_message"><strong>残疾人</strong></div>
                        <br><table width="100%">
                            <tr>
                                <td style="width: 120px;">
                                    <div>证号：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                     ${vdata.disability.NUM }
                                    
                                </td>
                                <td style="width: 120px;">
                                    <div>发证时间：</div>
                                </td>
                                <td style="width: 160px;">
                                    
                                       ${vdata.disability.SEND_DATE }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>类别：</div>
                                </td>
                                <td colspan="3">
                                    
                                       ${vdata.disability.CODE_DISABLE_TYPE }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>残疾等级：</div>
                                </td>
                                <td colspan="3">
                                   
                                       ${vdata.disability.CODE_DISABLE_LEVEL }
                                    
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>帮扶人员：</div>
                                </td>
                                <td>
                                    
                                   ${vdata.disability.ASSIST_NAME }
                                    
                                </td>
                                <td >
                                    <div>帮扶人员电话：</div>
                                </td>
                                <td>
                                    ${vdata.disability.ASSIST_PHONE }
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>帮扶情况：</div>
                                </td>
                                <td colspan="3">
                                  ${vdata.disability.ASSIST_SITUATION }
                                </td>
                            </tr>
                            <tr>
                                <td >
                                    <div>描述：</div>
                                </td>
                                <td colspan="3">
                                    ${vdata.disability.REMARK }
                                </td>
                            </tr>
                        </table><br>
                        
                        <div class="grid_message"><strong>拥军优抚</strong></div>
                        <br><table width="100%">
                            <tr>
                            <td  style="width: 18%;">
                                <div>类别：</div>
                            </td>
                            <td>
                                <div>
                                    ${vdata.samc.CODE_SAMC }
                                </div>
                            </td>
                            <td  style="width: 18%;">
                                <div>是否置业：</div>
                            </td>
                            <td>
                                <div>
                                    ${vdata.samc.IS_HOUSE_PURCHASING }
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <div>入伍时间：</div>
                            </td>
                            <td>
                                <div>
                                    ${vdata.samc.ENLIST_DATE }
                                </div>
                            </td>
                            <td >
                                <div>退伍时间：</div>
                            </td>
                            <td>
                                <div>
                                    ${vdata.samc.VETERANS_DATE }
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <div>优抚证号码：</div>
                            </td>
                            <td>
                                <div>
                                    ${vdata.samc.SPECIAL_PERMIT_NUM }
                                </div>
                            </td>
                            <td >
                                <div>发证日期：</div>
                            </td>
                            <td>
                                <div>
                                     ${vdata.samc.SEND_DATE }
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <div>帮扶人员：</div>
                            </td>
                            <td>
                                <div>
                                   ${vdata.samc.HELPER }
                                </div>
                            </td>
                            <td >
                                <div>登记人员：</div>
                            </td>
                            <td>
                                <div>
                                    ${vdata.samc.REGISTER_PERSON }
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td >
                                <div>优抚情况：</div>
                            </td>
                            <td colSpan="3">
                                <div>
                                    ${vdata.samc.SPECIAL_SITUATION }
                                </div>
                            </td>

                        </tr>
                        </table><br>
                        
                         <div class="grid_message"><strong>有严重刑事犯罪的前科人员</strong></div>
                        <br><table width="100%">
                            <tr>
                                <td  style="width: 18%">
                                    <div>姓名：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.NAME }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>性别：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.SEX }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>民族：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.NATION }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>出生日期：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.BIRTH }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>身份证号：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.CID }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>户籍所在地：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.ADDRESS }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>虚拟信息：</div>
                                </td>
                                <td>
                                    <div>
                                       ${vdata.seriouscrime.INFORMATION }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>联系方式：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.TEL }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>现职业：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.JOB }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>年收入：</div>
                                </td>
                                <td>
                                    <div>
                                       ${vdata.seriouscrime.ANNUAL }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>结交人员：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.MAKEPEOPLE }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>现实表现：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.seriouscrime.PERFORMANCE }
                                    </div>
                                </td>
                            </tr>
                            
                            <tr>

                                <td >
                                    <div>违法犯罪经历</div>
                                </td>
                                <td colspan="3">
                                    <div>
                                        ${vdata.seriouscrime.EXPILLCR }
                                    </div>
                                </td>
                            </tr>
                        </table><br>
                        
                        <div class="grid_message"><strong>因矛盾激化可能铤而走险人员</strong></div>
                        <br><table width="100%">
                            <tr>
                                <td  style="width: 18%">
                                    <div>姓名：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.NAME }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>性别：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.SEX }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>民族：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.NATION }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>出生日期：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.BIRTH }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>身份证号：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.CID }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>户籍所在地：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.ADDRESS }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>虚拟信息：</div>
                                </td>
                                <td>
                                    <div>
                                       ${vdata.rushdanger.INFORMATION }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>联系方式：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.TEL }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>现职业：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.JOB }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>年收入：</div>
                                </td>
                                <td>
                                    <div>
                                       ${vdata.rushdanger.ANNUAL }
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td  style="width: 18%">
                                    <div>结交人员：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.MAKEPEOPLE }
                                    </div>
                                </td>
                                <td  style="width: 18%">
                                    <div>现实表现：</div>
                                </td>
                                <td>
                                    <div>
                                        ${vdata.rushdanger.PERFORMANCE }
                                    </div>
                                </td>
                            </tr>
                            
                            <tr>

                                <td >
                                    <div>矛盾纠纷成因</div>
                                </td>
                                <td colspan="3">
                                    <div>
                                        ${vdata.rushdanger.CONTRA }
                                    </div>
                                </td>
                            </tr>
                        </table><br>
                        </div>
                       
                       
                        </div>
                        
                        
              
               
<script type="text/javascript">
         var LODOP; //声明为全局变量 

         function CreateOneFormPage() {
               LODOP = getLodop(document.getElementById('LODOP_OB'), document.getElementById('LODOP_EM'));
               LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_表单一");
               LODOP.SET_PRINT_STYLE("FontSize", 18);
               LODOP.SET_PRINT_STYLE("Bold", 1);
               LODOP.ADD_PRINT_HTM(20, 20, 780, 1200, $(".List_from")[0].innerHTML);
         };
         function prn_preview() {
              CreateOneFormPage();
              LODOP.PREVIEW();
        };
        function prn_print() {
            CreateOneFormPage();
            LODOP.PRINT();
        };

</script>
</body>
</html>

