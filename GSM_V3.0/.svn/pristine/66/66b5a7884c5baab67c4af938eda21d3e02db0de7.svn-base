	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看资料内容</title>
<link rel="stylesheet"  href="${base}/resource/css/timeline.css" />
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<style type="text/css">
 #log_table_tr_td_title{
   width: 7%;
   height: 30px;
   text-align: right;
 }
 #log_table_tr_td_titles{
   width: 12%;
    height: 30px;
 }
 #log_table_tr_td_titles1{
   width: 8%;
    height: 30px;
 }
 #log_table_tr_td_titles2{
   width: 15%;
    height: 30px;
 }
 #log_table_tr_td_titles3{
   width: 10%;
    height: 30px;
 }
 #log_table_tr_td_titles4{
   width: 8.5%;
    height: 30px;
 }
 #log_table_tr_td_titles5{
   width: 7.5%;
    height: 30px;
 }
 #log_table_tr_td_titles6{
   width: 7.5%;
    height: 30px;
 }
 #log_table_tr_td_titles7{
   width: 7.5%;
    height: 30px;
 }
 #log_table_tr_td_titles8{
   width: 7.5%;
    height: 30px;
 }
 #totalHour,#totalMinute{
    border-left: 0;
 	border-right: 0;
 	border-top: 0;
 	border-bottom: 0;
 	width: 25px;
 }
 #questionCount,#envCount{
 border-left: 0;
 	border-right: 0;
 	border-top: 0;
 	border-bottom: 0;
 	width: 55px;
 }
</style>
</head>
<body>
<div class="row">
   <div class="col-xs-12" id="body">
     <div class="tabbable tabs-left">
       <div class="tab-content" >
            <div id="detailDiv" class="tab-pane in active">
               <div class="col-xs-12" style='text-align:right;'>
					<div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
				         <span class="ui-icon icon-print pull-right"></span>
		            </div>
	            </div>
	            <div id="print">
					<h2><center></center></h2>
					<table border="1" cellpadding="0" cellspacing="0" width="80%" align="center">
					    <tr>
					      <td id="log_table_tr_td_title" colspan="3"><b>网格管理员(自动获取)</b></td>
					      <td id="log_table_tr_td_titles2" colspan="7">${vdata.thinglog.gridName }</td>
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_title" colspan="3"><b>网格管理员联系电话(自动获取)</b></td>
					      <td id="log_table_tr_td_titles2" colspan="7">${vdata.thinglog.gridPhone }</td>
					    </tr>
					    <tr height="30px;">
					      <td id="log_table_tr_td_title" colspan="3" rowspan="2"><b><span class="red">*</span>巡查走访陪同人员</b></td>
					      <td id="log_table_tr_td_titles2" colspan="7" rowspan="2" style="padding: 2px;">
					        ${vdata.thingLog.inspectionVisits }
					      </td>
					    </tr>
					    <tr height="30px;">
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_title" colspan="3"><b><span class="red">*</span>陪同人员职务</b></td>
					      <td id="log_table_tr_td_titles2" colspan="7" style="padding: 2px;">
					         ${vdata.thingLog.codeVisitsDuty }
					      </td>
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_title" rowspan="2"><b><span class="red">*</span>巡查</br>走访</br>时间</b></td>
					      <td id="log_table_tr_td_titles" colspan="9">
					        <b>
					          <table border="1" width="100%">
					             <tr>
					               <td width="9%">(第一次)</td>
					               <td width="15%">
					                 ${vdata.thingLog.interviewOneTimeStart }
					               </td>
					               <td width="5%" style="text-align: center;">至</td>
					               <td width="15%">
					                 ${vdata.thingLog.interviewOneTimeEnd }
					               </td>
					                <td width="9%">(第二次)</td>
					               <td width="15%">
					                 ${vdata.thingLog.interviewTwoTimeStart1 }
					               </td>
					               <td width="5%" style="text-align: center;">至</td>
					               <td width="15%">
					                 ${vdata.thingLog.interviewTwoTimeEnd1 }
					               </td>
					             </tr>
					             
					          </table>
					        </b>
					      </td>
					    </tr>
					    <tr height="30px;">
					      <td id="log_table_tr_td_titles" colspan="2" style="text-align: right;"><b>总计走访时间(自动计算)</b></td>
					      <td id="log_table_tr_td_titles2" colspan="7"><b>
					         ${vdata.thingLog.totalHour }小时
					         ${vdata.thingLog.totalMinute }分钟</b>
					      </td>
					    </tr>
					    <tr height="30px;">
					      <td id="log_table_tr_td_title" rowspan="6" width="7%" style="text-align: right;"><b>入户</br>走访</br>情况</b></td>
					      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b><span class="red">*</span>走访户数</b></td>
					      <td id="log_table_tr_td_titles1" rowspan="2" style="padding: 2px;">
					        ${vdata.thingLog.falimyCount }
					      </td>
					      <td id="log_table_tr_td_titles2" rowspan="2" style="text-align: right;"><b><span class="red">*</span>具体门牌和户主</b></td>
					      <td id="log_table_tr_td_titles3" rowspan="2" colspan="6" style="padding: 2px;">
					        ${vdata.thingLog.falimyDetails }
					      </td>
					    </tr>
					    <tr height="30px;">
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles" rowspan="4" style="text-align: right;"><b>问题总件数</br>(自动计算)</b></td>
					      <td id="log_table_tr_td_titles1" rowspan="4" style="text-align: center;">
					         ${vdata.thingLog.questionCount }
					      </td>
					      <td id="log_table_tr_td_titles2" rowspan="4" style="text-align: center;"><b>其中</b></td>
					      <td id="log_table_tr_td_titles3" colspan="2" style="text-align: right;"><b>矛盾纠纷</b></td>
					      <td id="log_table_tr_td_titles5" colspan="2" style="text-align: center;padding: 2px;">
					        ${vdata.thingLog.questionConflict }
					      </td>
					      <td id="log_table_tr_td_titles7" colspan="2" style="text-align: left;"><b>件 </b></td>
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles3" colspan="2" style="text-align: right;"><b>群众诉求</b></td>
					      <td id="log_table_tr_td_titles5" colspan="2" style="text-align: center;padding: 2px;">
					         ${vdata.thingLog.questionAppeal }
					      </td>
					      <td id="log_table_tr_td_titles7" colspan="2" style="text-align: left;"><b>件 </b></td>
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles3" colspan="2" style="text-align: right;"><b>群众意见建议</b></td>
					      <td id="log_table_tr_td_titles5" colspan="2" style="text-align: center;padding: 2px;">
					        ${vdata.thingLog.questionIdea }
					      </td>
					      <td id="log_table_tr_td_titles7" colspan="2" style="text-align: left;"><b>件</b> </td>
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles3" colspan="2" style="text-align: right;"><b>其他</b></td>
					      <td id="log_table_tr_td_titles5" colspan="2" style="text-align: center;padding: 2px;">
					        ${vdata.thingLog.questionOther }
					      </td>
					      <td id="log_table_tr_td_titles7" colspan="2" style="text-align: left;"><b>件 </b></td>
					    </tr>
					    <tr height="30px;">
					      <td id="log_table_tr_td_title" rowspan="15"><b>网格<br>巡查<br>情况</b></td>
					      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b>治安隐患</b></td>
					      <td id="log_table_tr_td_titles1" rowspan="2" style="text-align: right;"><b>件数</b></td>
					      <td id="log_table_tr_td_titles2" rowspan="2" style="text-align: center;padding: 2px;">
					        ${vdata.thingLog.securityCount }
					      </td>
					      <td id="log_table_tr_td_titles3" rowspan="2" style="text-align: right;"><b>具体问题</b></td>
					      <td id="log_table_tr_td_titles4" rowspan="2" colspan="5" style="padding: 2px;">
					         ${vdata.thingLog.securityQuestion }
					      </td>
					    </tr>
					     <tr height="30px;">
					    </tr>
					    <tr height="30px;">
					      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b>消防隐患</b></td>
					       <td id="log_table_tr_td_titles1" rowspan="2" style="text-align: right;"><b>件数</b></td>
					      <td id="log_table_tr_td_titles2" rowspan="2" style="text-align: center;padding: 2px;">
					        ${vdata.thingLog.fireCoun }
					      </td>
					      <td id="log_table_tr_td_titles3" rowspan="2" style="text-align: right;"><b>具体问题</b></td>
					      <td id="log_table_tr_td_titles4" rowspan="2" colspan="5" style="padding: 2px;">
					        ${vdata.thingLog.fireQuestion }
					      </td>
					    </tr>
					    <tr height="30px;">
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles" rowspan="5" style="text-align: right;"><b>环境卫生</b></td>
					      <td id="log_table_tr_td_titles1" rowspan="5" style="text-align: right;"><b>件数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>(自动计算)</b></td>
					      <td id="log_table_tr_td_titles2" rowspan="5" style="text-align: center;">
					         ${vdata.thingLog.envCount }
					      </td>
					      <td id="log_table_tr_td_titles3" rowspan="5" style="text-align: right;"><b>具体问题</b></td>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>反宣品</b></td>
					      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
					         ${vdata.thingLog.sanitationReaction }
					      </td>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
					    </tr>
					   <tr>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>小广告</b></td>
					      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
					        ${vdata.thingLog.sanitationAd }
					      </td>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>乱堆乱放</b></td>
					      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
					         ${vdata.thingLog.sanitationChaos }
					      </td>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>新的私搭乱建</b></td>
					      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
					         ${vdata.thingLog.sanitationBuild }
					      </td>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>其他</b></td>
					      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
					         ${vdata.thingLog.sanitationOther }
					      </td>
					      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
					    </tr>
					    <tr height="30px;">
					      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b>其他问题</b></td>
					      <td id="log_table_tr_td_titles1" rowspan="2" style="text-align: right;"><b>件数</b></td>
					      <td id="log_table_tr_td_titles2" rowspan="2" style="padding: 2px;">
					          ${vdata.thingLog.otherCount }
					      </td>
					      <td id="log_table_tr_td_titles3" rowspan="2" style="text-align: right;"><b>具体问题</b></td>
					      <td id="log_table_tr_td_titles4" colspan="5" rowspan="2" style="padding: 2px;">
					        ${vdata.thingLog.otherQuestion }
					      </td>
					    </tr>
					    <tr height="30px;">
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles" style="text-align: right;"><b>问题处理情况</b></td>
					      <td id="log_table_tr_td_titles1" colspan="2" style="text-align: right;"><b>当天自行解决件数</b></td>
					      <td id="log_table_tr_td_titles3" style="padding: 2px;">
					         ${vdata.thingLog.interviewAuto }
					      </td>
					      <td id="log_table_tr_td_titles4" colspan="2"><b>上报区指挥中心件数</b></td>
					      <td id="log_table_tr_td_titles6" style="padding: 2px;">
					         ${vdata.thingLog.interviewUp }
					      </td>
					      <td id="log_table_tr_td_titles7" colspan="2"><b>件</b></td>
					    </tr>
					    <tr height="30px;">
					      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b>巡查走访情况</b></td>
					      <td id="log_table_tr_td_titles1" rowspan="2" colspan="8" style="padding: 2px;">
					         ${vdata.thingLog.interviewContent }
					      </td>
					    </tr>
					    <tr height="30px;">
					    </tr>
					    <tr>
					      <td id="log_table_tr_td_titles" style="text-align: right;"><b>资料照片</b></td>
					      <td id="log_table_tr_td_titles1" colspan="8">
					          <div class="col-xs-10">
								<div class="clearfix">
								<div id='dropzoneDiv1' class="dropzone">
									<button class="btn btn-purple btn-xs white" id="uploadBtn1" type="button">
														<i class="icon-cloud-upload bigger-100"></i>
														上传
									</button>
									 <!-- <span><font color="#FF0000">(多资料上传时，请注意须同时上传，以免使资料大小存在数据差异)</font></span> -->
									<br>
									</div>
										<input type="HIDDEN" id="url_pic1" name="interviewFile" value="${vdata.thingLog.interviewFile }" />
									</div>
								</div>
							</div>
							<c:if test="${vdata.thingLog.interviewFile != null}">
								<div class="form-group">
									<label class="col-xs-2 control-label no-padding-right text-right">已保存文件 </label>
							
									<div class="col-xs-10">
										<div class="clearfix">
											<div id="picDisplay_old1" class="dropzone">
										    </div>
										</div>
									</div>
								</div>
							</c:if>
					      </td>
					    </tr>
					 </table>
					<hr/>
				</div>
		    </div>
		    <div>
		      ${vdata.zongzhiMaterial.materialContent}
		    </div>
       </div>
     </div>
   </div>
</div><!-- row -->
</body>
</html>