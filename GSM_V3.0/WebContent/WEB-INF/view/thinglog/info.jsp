<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script src="/GSM_V3.0/resource/js/user-definedjs/thinglog-calculatetime.js"></script>
<script type="text/javascript">
$(function(){
	 if('${vdata.thingLog.interviewOneTimeStart }'==""){
		$("#interview_one_timestart").val("00:00");
	}
	if('${vdata.thingLog.interviewOneTimeEnd }'==""){
		$("#interview_one_timeend").val("00:00");
	}
	if('${vdata.thingLog.interviewTwoTimeStart1 }'==""){
		$("#interview_two_timestart1").val("00:00");
	}
	if('${vdata.thingLog.interviewTwoTimeEnd1 }'==""){
		$("#interview_two_timeend1").val("00:00");
	}
	$("[name=codeVisitsDuty]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_VISITS_DUTY',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone1=new Dropzone("#dropzoneDiv1",{
			 url: function(){
	         	return "${base}/sys/sysupload/upload";
	         },
		 	existedFiles:$('#url_pic1').val().split(";").length-1,
		 	uploadBtnId:'uploadBtn1',
           imgName:'showImg1',
           maxFilesize: 10,//最大文件大小，MB
	});
	//dropzone代表dropzone对象
	//urlPicI表示model中存放上传文件id的那个字段使用的input的id，type 是hidden的
	//showOldImgName表示在组装已经存在的的图片的时候用的img标签的name
	//showOldImgDivId表示用来展示已经存在的图片的div的id
	getOldPics(dropzone1,"url_pic1","showImg1_old","picDisplay_old1");
	$("#form").validate({
		submitHandler: function (form) {
			$('#url_pic1').val('');
		 	//获取上传文件的值
		 	var ids1='';
		 	$('[name^=showImg1]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids1+=this.id+";";
		 		}
		 	});
		 	$('#url_pic1').val(ids1);
			var data = $("#form").serialize();
			$.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	parent.successFun();
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
	$('.clockpicker').clockpicker();
	
	$("#gridName").val('${vdata.thingLog.gridName}')
	$("#gridPhone").val('${vdata.thingLog.gridPhone}')
	
	if($("#interview_one_timestart").val() == "00:00"&&$("#interview_one_timeend").val() == "00:00"&&$("#interview_two_timestart1").val() == "00:00"&& $("#interview_two_timeend1").val() == "00:00"){
		initTimeTotal();
	}
	
});
function initTimeTotal(){
	$("#totalHour").val(0);
	$("#totalMinute").val(0);
}
</script>
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
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="Code" value="${vdata.thingLog.code }" />
			<input type="hidden" name="logType" value="1"/>
			<div align="center"><h2>民情日志</h2></div>
			<div align="center" style="height: 10px;"></div>
			 <table border="1" cellpadding="0" cellspacing="0" width="80%" align="center">
			    <tr>
			      <td id="log_table_tr_td_title" colspan="3"><b>网格管理员(自动获取)</b></td>
			      <td id="log_table_tr_td_titles2" colspan="7"><input type="text" readonly="readonly" id="gridName" name="gridName" /></td>
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_title" colspan="3"><b>网格管理员联系电话(自动获取)</b></td>
			      <td id="log_table_tr_td_titles2" colspan="7"><input type="text" readonly="readonly" id="gridPhone" name="gridPhone" /></td>
			    </tr>
			    <tr height="30px;">
			      <td id="log_table_tr_td_title" colspan="3" rowspan="2"><b><span class="red">*</span>巡查走访陪同人员</b></td>
			      <td id="log_table_tr_td_titles2" colspan="7" rowspan="2" style="padding: 2px;">
			        <div class="col-xs-12">
						<textarea id="inspectionVisits" name="inspectionVisits" cols="30" class="col-xs-12 col-sm-12 tooltip-error required">${vdata.thingLog.inspectionVisits }</textarea>
					</div>
			      </td>
			    </tr>
			    <tr height="30px;">
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_title" colspan="3"><b><span class="red">*</span>陪同人员职务</b></td>
			      <td id="log_table_tr_td_titles2" colspan="7" style="padding: 2px;">
			        <div class="col-xs-12">
						<input type="text" id="codeVisitsDuty" name="codeVisitsDuty" value="${vdata.thingLog.codeVisitsDuty }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
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
			                 <div class="input-group col-xs-12">
							    <input type="text" id="interview_one_timestart" name="interviewOneTimeStart" value="${vdata.thingLog.interviewOneTimeStart }" onchange="interviewOneTimeStarts(this.value)" class="form-control clockpicker tooltip-error clock">
							    <span class="input-group-addon">
							        <span class="glyphicon glyphicon-time"></span>
							    </span>
							 </div>
			               </td>
			               <td width="5%" style="text-align: center;">至</td>
			               <td width="15%">
			                 <div class="input-group col-xs-12">
							    <input type="text" id="interview_one_timeend" name="interviewOneTimeEnd" value="${vdata.thingLog.interviewOneTimeEnd }" onchange="interviewOneTimeEnds(this.value)"  class="form-control clockpicker tooltip-error clock">
							    <span class="input-group-addon">
							        <span class="glyphicon glyphicon-time"></span>
							    </span>
							 </div>
			               </td>
			                <td width="9%">(第二次)</td>
			               <td width="15%">
			                 <div class="input-group col-xs-12">
							    <input type="text" id="interview_two_timestart1" name="interviewTwoTimeStart1"  class="form-control clockpicker tooltip-error clock" value="${vdata.thingLog.interviewTwoTimeStart1 }"  onchange="interviewTwoTimestart1s(this.value)">
							    <span class="input-group-addon">
							        <span class="glyphicon glyphicon-time"></span>
							    </span>
							 </div>
			               </td>
			               <td width="5%" style="text-align: center;">至</td>
			               <td width="15%">
			                 <div class="input-group col-xs-12">
							    <input type="text"  class="form-control clockpicker tooltip-error clock" id="interview_two_timeend1" name="interviewTwoTimeEnd1" value="${vdata.thingLog.interviewTwoTimeEnd1 }" onchange="interviewTwoTimeend1s(this.value)">
							    <span class="input-group-addon">
							        <span class="glyphicon glyphicon-time"></span>
							    </span>
							 </div>
			               </td>
			             </tr>
			             
			          </table>
			        </b>
			      </td>
			    </tr>
			    <tr height="30px;">
			      <td id="log_table_tr_td_titles" colspan="2" style="text-align: right;"><b>总计走访时间(自动计算)</b></td>
			      <td id="log_table_tr_td_titles2" colspan="7"><b>
			         <input type="text" id="totalHour" readonly="readonly" name="totalHour" value="${vdata.thingLog.totalHour }" />小时
			         <input type="text" id="totalMinute" readonly="readonly" name="totalMinute" value="${vdata.thingLog.totalMinute }" />分钟</b>
			      </td>
			    </tr>
			    <tr height="30px;">
			      <td id="log_table_tr_td_title" rowspan="6" width="7%" style="text-align: right;"><b>入户</br>走访</br>情况</b></td>
			      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b><span class="red">*</span>走访户数</b></td>
			      <td id="log_table_tr_td_titles1" rowspan="2" style="padding: 2px;">
			        <div class="col-xs-12">
						<input type="text" id="falimyCount" name="falimyCount" value="${vdata.thingLog.falimyCount }" class="col-xs-12 col-sm-12 tooltip-error required digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles2" rowspan="2" style="text-align: right;"><b><span class="red">*</span>具体门牌和户主</b></td>
			      <td id="log_table_tr_td_titles3" rowspan="2" colspan="6" style="padding: 2px;">
			        <div class="col-xs-12">
						<textarea id="falimyDetails" name="falimyDetails" cols="30" class="col-xs-12 col-sm-12 tooltip-error required">${vdata.thingLog.falimyDetails }</textarea>
					</div>
			      </td>
			    </tr>
			    <tr height="30px;">
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles" rowspan="4" style="text-align: right;"><b>问题总件数</br>(自动计算)</b></td>
			      <td id="log_table_tr_td_titles1" rowspan="4" style="text-align: center;">
			         <input type="text" id="questionCount" name="questionCount" readonly="readonly" value="${vdata.thingLog.questionCount }" />
			      </td>
			      <td id="log_table_tr_td_titles2" rowspan="4" style="text-align: center;"><b>其中</b></td>
			      <td id="log_table_tr_td_titles3" colspan="2" style="text-align: right;"><b>矛盾纠纷</b></td>
			      <td id="log_table_tr_td_titles5" colspan="2" style="text-align: center;padding: 2px;">
			        <div class="col-xs-12">
						<input type="text" id="questionConflict" name="questionConflict" value="${vdata.thingLog.questionConflict }"  onchange="calculateAddQuestionCount(this.value)" class="col-xs-12 col-sm-12 digits"  />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles7" colspan="2" style="text-align: left;"><b>件 </b></td>
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles3" colspan="2" style="text-align: right;"><b>群众诉求</b></td>
			      <td id="log_table_tr_td_titles5" colspan="2" style="text-align: center;padding: 2px;">
			         <div class="col-xs-12">
						<input type="text" id="questionAppeal" name="questionAppeal" value="${vdata.thingLog.questionAppeal }" onchange="calculateAddQuestionCount(this.value)" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles7" colspan="2" style="text-align: left;"><b>件 </b></td>
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles3" colspan="2" style="text-align: right;"><b>群众意见建议</b></td>
			      <td id="log_table_tr_td_titles5" colspan="2" style="text-align: center;padding: 2px;">
			        <div class="col-xs-12">
						<input type="text" id="questionIdea" name="questionIdea" value="${vdata.thingLog.questionIdea }" onchange="calculateAddQuestionCount(this.value)" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles7" colspan="2" style="text-align: left;"><b>件</b> </td>
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles3" colspan="2" style="text-align: right;"><b>其他</b></td>
			      <td id="log_table_tr_td_titles5" colspan="2" style="text-align: center;padding: 2px;">
			        <div class="col-xs-12">
						<input type="text" id="questionOther" name="questionOther" value="${vdata.thingLog.questionOther }" onchange="calculateAddQuestionCount(this.value)" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles7" colspan="2" style="text-align: left;"><b>件 </b></td>
			    </tr>
			    <tr height="30px;">
			      <td id="log_table_tr_td_title" rowspan="15"><b>网格<br>巡查<br>情况</b></td>
			      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b>治安隐患</b></td>
			      <td id="log_table_tr_td_titles1" rowspan="2" style="text-align: right;"><b>件数</b></td>
			      <td id="log_table_tr_td_titles2" rowspan="2" style="text-align: center;padding: 2px;">
			        <div class="col-xs-12">
						<input type="text" id="securityCount" name="securityCount" value="${vdata.thingLog.securityCount }" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles3" rowspan="2" style="text-align: right;"><b>具体问题</b></td>
			      <td id="log_table_tr_td_titles4" rowspan="2" colspan="5" style="padding: 2px;">
			         <div class="col-xs-12">
						<textarea id="securityQuestion" name="securityQuestion" cols="30" class="col-xs-12 col-sm-12">${vdata.thingLog.securityQuestion }</textarea>
					</div>
			      </td>
			    </tr>
			     <tr height="30px;">
			    </tr>
			    <tr height="30px;">
			      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b>消防隐患</b></td>
			       <td id="log_table_tr_td_titles1" rowspan="2" style="text-align: right;"><b>件数</b></td>
			      <td id="log_table_tr_td_titles2" rowspan="2" style="text-align: center;padding: 2px;">
			        <div class="col-xs-12">
						<input type="text" id="fireCoun" name="fireCoun" value="${vdata.thingLog.fireCoun }" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles3" rowspan="2" style="text-align: right;"><b>具体问题</b></td>
			      <td id="log_table_tr_td_titles4" rowspan="2" colspan="5" style="padding: 2px;">
			        <div class="col-xs-12">
						<textarea id="fireQuestion" name="fireQuestion" cols="30" class="col-xs-12 col-sm-12">${vdata.thingLog.fireQuestion }</textarea>
					</div>
			      </td>
			    </tr>
			    <tr height="30px;">
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles" rowspan="5" style="text-align: right;"><b>环境卫生</b></td>
			      <td id="log_table_tr_td_titles1" rowspan="5" style="text-align: right;"><b>件数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>(自动计算)</b></td>
			      <td id="log_table_tr_td_titles2" rowspan="5" style="text-align: center;">
			         <input type="text" id="envCount"  readonly="readonly" name="envCount" value="${vdata.thingLog.envCount }" />
			      </td>
			      <td id="log_table_tr_td_titles3" rowspan="5" style="text-align: right;"><b>具体问题</b></td>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>反宣品</b></td>
			      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
			         <div class="col-xs-12">
						<input type="text" id="sanitationReaction" name="sanitationReaction" value="${vdata.thingLog.sanitationReaction }" onchange="calculateAddEnvCount(this.value)" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
			    </tr>
			   <tr>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>小广告</b></td>
			      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
			         <div class="col-xs-12">
						<input type="text" id="sanitationAd" name="sanitationAd" value="${vdata.thingLog.sanitationAd }" onchange="calculateAddEnvCount(this.value)" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>乱堆乱放</b></td>
			      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
			         <div class="col-xs-12">
						<input type="text" id="sanitationChaos" name="sanitationChaos" value="${vdata.thingLog.sanitationChaos }" onchange="calculateAddEnvCount(this.value)" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>新的私搭乱建</b></td>
			      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
			         <div class="col-xs-12">
						<input type="text" id="sanitationBuild" name="sanitationBuild" value="${vdata.thingLog.sanitationBuild }" onchange="calculateAddEnvCount(this.value)" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: right;"><b>其他</b></td>
			      <td id="log_table_tr_td_titles6" style="text-align: center;padding: 2px;">
			         <div class="col-xs-12">
						<input type="text" id="sanitationOther" name="sanitationOther" value="${vdata.thingLog.sanitationOther }" onchange="calculateAddEnvCount(this.value)" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles4" colspan="2" style="text-align: left;"><b>件</b></td>
			    </tr>
			    <tr height="30px;">
			      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b>其他问题</b></td>
			      <td id="log_table_tr_td_titles1" rowspan="2" style="text-align: right;"><b>件数</b></td>
			      <td id="log_table_tr_td_titles2" rowspan="2" style="padding: 2px;">
			          <div class="col-xs-12">
						<input type="text" id="otherCount" name="otherCount" value="${vdata.thingLog.otherCount }" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles3" rowspan="2" style="text-align: right;"><b>具体问题</b></td>
			      <td id="log_table_tr_td_titles4" colspan="5" rowspan="2" style="padding: 2px;">
			        <div class="col-xs-12">
						<textarea id="otherQuestion" name="otherQuestion" cols="30" class="col-xs-12 col-sm-12">${vdata.thingLog.otherQuestion }</textarea>
					</div>
			      </td>
			    </tr>
			    <tr height="30px;">
			    </tr>
			    <tr>
			      <td id="log_table_tr_td_titles" style="text-align: right;"><b>问题处理情况</b></td>
			      <td id="log_table_tr_td_titles1" colspan="2" style="text-align: right;"><b>当天自行解决件数</b></td>
			      <td id="log_table_tr_td_titles3" style="padding: 2px;">
			         <div class="col-xs-12">
						<input type="text" id="interviewAuto" name="interviewAuto" value="${vdata.thingLog.interviewAuto }" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles4" colspan="2"><b>上报区指挥中心件数</b></td>
			      <td id="log_table_tr_td_titles6" style="padding: 2px;">
			         <div class="col-xs-12">
						<input type="text" id="interviewUp" name="interviewUp" value="${vdata.thingLog.interviewUp }" class="col-xs-12 col-sm-12 digits" />
					</div>
			      </td>
			      <td id="log_table_tr_td_titles7" colspan="2"><b>件</b></td>
			    </tr>
			    <tr height="30px;">
			      <td id="log_table_tr_td_titles" rowspan="2" style="text-align: right;"><b>巡查走访情况</b></td>
			      <td id="log_table_tr_td_titles1" rowspan="2" colspan="8" style="padding: 2px;">
			         <div class="col-xs-12">
						<textarea id="interviewContent" name="interviewContent" cols="30" class="col-xs-12 col-sm-12">${vdata.thingLog.interviewContent }</textarea>
					</div>
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
			</form>
		</div>
	</div>
</body>
</html>


