<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.opensymphony.workflow.loader.ActionDescriptor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.dykj.GSM.service.event.impl.EContradictServiceImpl" %>
<%@page import="com.dykj.GSM.model.event.EContradict" %>
<%@page import="com.dykj.GSM.model.sys.SysUpload" %>
<%@page import="com.opensymphony.workflow.loader.StepDescriptor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<link rel="stylesheet" type="text/css" href="${base}/resource/js/GooFlow/codebase/GooFlow.css"/>
<script type="text/javascript" src="${base}/resource/js/GooFlow/GooFunc.js"></script>
<script type="text/javascript" src="${base}/resource/js/GooFlow/json2.js"></script>
<script type="text/javascript" src="${base}/resource/js/GooFlow/codebase/GooFlow.js"></script>
<link rel="stylesheet"  href="${base}/resource/css/timeline.css" />
<script type="text/javascript" src="${base}/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base}/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">
function setSrollHeight(){
	var iframe=parent.document.getElementById("dialog_iframe");
	var subWeb = document.frames ? iframe.document : iframe.contentDocument;  
 	iframe.style.height = subWeb.body.scrollHeight+"px";
}

	var property = {
			width : 800,
			height : 600,
			toolBtns : [ "start round", "end", "task", "node", "chat", "state",
					"plug", "join", "fork", "complex mix" ],
			haveHead : false,
			headBtns : [ "new", "open", "save", "undo", "redo", "reload" ],//如果haveHead=true，则定义HEAD区的按钮
			haveTool : false,
			haveGroup : false,
			useOperStack : true,
			tuli : true
		};
$(function(){
	$("input[name=actionRadio]").on("change",function(){
		$("div[id$=_div]").hide();
		$("#"+$(this).attr("id").substr(7)+"_div").show();
	});
	$("[name='codeAppraise']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_APPRAISE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	$("[name=gridCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryOrgnizationTreeForSelect?t=' + Math.random()
	});
	//图片浏览
	 layer.use('extend/layer.ext.js', function(){
		   layer.ext =function(){};
	});  
	 $("[name='showImg_old']").each(function(i) {
  		 //如果绑定过事件，再次绑定必须得解绑定
  		 $(this).off("click");
          $(this).on("click",function() {
             layer.photos({
              html: '',
              page: {
                  title: '',
                  id: 'imgId',
                  start: i,
                  name: 'showImg_old'
              }
          });
          });
      });
	 
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize();
			 $.ajax({
				type : "post",
				url : "${base}/event/econtradict/approval?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	try{
		            		parent.successFun();
		            	}catch(e){
		            		parent.bootbox.hideAll();
		            		parent.bootbox.slideAlert('body');
		            	}
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			}); 
        }
	});
	//父窗口中的提交按钮
	$("#commitBtn").bind("click",function(){
		var selectRadio=$("[name=actionRadio]input:checked");
		if(selectRadio){
			var stepRight=selectRadio.attr("stepRight");
			if(stepRight!=null&&stepRight!=''){
				if(stepRight.endWith("#2")){
					$("[name=owner]").val($("[name=gridCode]").val()+"#2");
				}else{
					$("[name=owner]").val(stepRight);
				}
			}
			$("[name=actionId]").val(selectRadio.val());
		}
	
		$("#form").submit();
	});

	 
	 //-----------------------流程图
	 
  var demo = $.createGooFlow($("#demo"), property);
   var jsonPara={
			type:"post",
			url:"${base}/event/econtradict/queryFlowSteps",
			//data:{entryId:241}
			data:{entryId:"${vdata.wfid}"}
	};
  demo.loadDataAjax(jsonPara);
  
  
  
	setSrollHeight();
});
function  print(printid){
    $("#"+printid).jqprint({debug:true});
}
</script>
</head>
<body>
<%
Map<String,Object> vdata=(Map<String,Object>)request.getAttribute("vdata");
EContradict event=(EContradict)vdata.get("event");
List<Map<String,Object>> opinions=(List<Map<String,Object>>)vdata.get("opinions");
List<Map<String,Object>> actions=(List<Map<String,Object>>)vdata.get("actions");
Object duration=vdata.get("duration");
Map<String,Object> metas=(Map<String,Object>)vdata.get("metaAttributes");
List<SysUpload> eventImgList=(List<SysUpload>)vdata.get("eeventImg");
Object isHistoryDetail=vdata.get("history");
Map<String,Object> allActionMap=(Map<String,Object>)vdata.get("allActionMap");
%>
<div class="row">
		<div class="col-xs-12" id="body">
		<div class="tabbable tabs-left">
			<ul class="nav nav-tabs" id="myTab3">
			<li class="active">
					<a data-toggle="tab" href="#detailDiv">
						<!-- <i class="pink icon-dashboard bigger-110"></i> -->
						详细信息
					</a>
				</li>
				<li>
					<a data-toggle="tab" href="#processDiv">
						<!-- <i class="blue icon-user bigger-110"></i> -->
						处理过程
					</a>
				</li>
				<li>
					<a data-toggle="tab" href="#workflowDiv">
						<!-- <i class="blue icon-user bigger-110"></i> -->
						流程图
					</a>
				</li>
				<c:if test="${vdata.approval}">
					<li >
						<a data-toggle="tab" href="#approvalDiv">
							<!-- <i class="pink icon-dashboard bigger-110"></i> -->
							处理
						</a>
					</li>
				</c:if>
			</ul>

			<div class="tab-content" style="overflow:auto;max-height:460px;" >
			<!-- 基本信息 --> 
				<div id="detailDiv" class="tab-pane in active">
				<div class="col-xs-12" style='text-align:right;'>
				<div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
			         <span class="ui-icon icon-print pull-right"></span>
	            </div>
	            </div>
					<div id="print">
					<h2><center>矛盾受理表</center></h2>
					<h5>事件编号：${vdata.event.eventNum }</h5>
						<table class="print-table" >
							<tr>
								<td class="col-xs-2">所属网格</td><td class="print-normal col-xs-4">${vdata.event.gridTotalName}</td>
								<td class="col-xs-2">矛盾类型</td><td class="print-normal col-xs-4">${vdata.event.dicValueMap.codeEventType}</td>
							</tr>
							<tr>
								<td class="col-xs-2">矛盾主题</td><td colspan="3" class="print-normal col-xs-10">${vdata.event.eventTitle}</td>
							</tr>
							<tr>
								<td class="col-xs-2">上报来源</td><td class="print-normal col-xs-4">${vdata.event.dicValueMap.codeEventFrom}</td>
								<td class="col-xs-2">发生地点</td><td class="print-normal col-xs-4">${vdata.event.eventAddress}</td>
							</tr>
							<tr>
								<td class="col-xs-2">发生规模</td><td class="print-normal col-xs-4">${vdata.event.dicValueMap.codeEventGuimo}</td>
								<td class="col-xs-2">涉及人数</td><td class="print-normal col-xs-4">${vdata.event.personCount}</td>
							</tr>
							<tr>
								<td class="col-xs-2">地图位置</td><td colspan="3" class="print-normal col-xs-10">${vdata.event.position}</td></tr>
							<tr>
								<td class="col-xs-2">登记人</td><td class="print-normal col-xs-4">${vdata.event.createName}</td>
								<td class="col-xs-2">登记人电话</td><td class="print-normal col-xs-4">${vdata.event.createUserPhone}</td>
							</tr>
							<tr>
								<td class="col-xs-2">当事人</td><td class="print-normal col-xs-4">${vdata.event.dangShiRenName }</td>
								<td class="col-xs-2">当事人性别</td><td class="print-normal col-xs-4">${vdata.event.dangShiRenSex}</td>
							</tr>
							<tr>
								<td class="col-xs-2">当事人电话</td><td class="print-normal col-xs-4">${vdata.event.dangShiRenPhone}</td>
								<td class="col-xs-2">当事人身份证号</td><td colspan="3" class="print-normal col-xs-10">${vdata.event.dangShiRenId}</td>
							</tr>
							<tr>
								<td class="col-xs-2">当事人地址</td><td colspan="3" class="print-normal col-xs-10">${vdata.event.dangShiRenAddress}</td>
							</tr>
							<tr>
								<td class="col-xs-2">矛盾详情</td><td colspan="3" class="print-normal col-xs-10">${vdata.event.description}</td>
							</tr>
							<tr>
								<td class="col-xs-2">图片</td>
								<td colspan="3"class="print-normal col-xs-10" style="height:auto">
								<%if(eventImgList!=null){ //如果存在img
	                            	 String allLi="";
	                            	 String base="/GSM_V3.0";
	                             	for(int i=0;i<eventImgList.size();i++){
	                             		SysUpload imgMap=eventImgList.get(i);
	                             		String td="<img class='print-td-img' name='showImg_old' src='"+base+"/upload/"+imgMap.getPath()+"' title='"+imgMap.getName()+"'/></td>";
	                             		allLi+=td;
	                             	}
	                             %>
	                             <%=allLi %>
	                             <%} %>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div id="processDiv" class="tab-pane">
				<div class="main">
				<ul class="timeline">
					<c:forEach var="o" items="${vdata.opinions}" varStatus="status">
					<c:set value="${o.actionId}" var="actionId" scope="request"/>
						<li>
							<div class="time">${o.createDate}</div>
							<div class="number"></div>
							<div class="arrow"></div>
				            <div class="content">
	               				<h5>【${o.callerName}】<%=allActionMap.get(request.getAttribute("actionId"))%>
	               				<c:if test="${!status.last}"> 
	               					<span style="color:gray">转发给</span>  【${o.toPersonName}】
	               				</c:if>
	               				</h5>
								<p><b>留言：</b>
								${o.opinion}
								</p>
								<c:if test="${o.codeAppraise!=null}"> 
	               					<p><b>评价：</b>${o.appraiseStr}</p>
	               				</c:if>
	            			</div>
						</li>
					</c:forEach>
				</ul>
			</div>
				</div>
				<div id="workflowDiv" class="tab-pane">
					<div id="demo" class="GooFlow" style="width: 698px; height: 378px;">
					</div>
				</div>
				<c:if test="${vdata.approval}">
					<div id="approvalDiv" class="tab-pane">
					<div class="row">
					<div class="col-xs-12">
					<form name="" id="form" class="form-horizontal">
							<input type="hidden" name="wfid" value="${vdata.wfid}" /> 
							<input type="hidden"name="userCode" value="${vdata.userCode }#1" />
							<input type="hidden" name="stepId" value="${vdata.stepId}" /> 
							<input type="hidden"name="eventCode" value="${vdata.event.code }" />
							<input type="hidden" name="owner"  /> 
							<input type="hidden" name="actionId"  />
							<c:forEach items="${vdata.actions}" var="a" varStatus="status">
								<c:if test="${a.delayApply!=null&&showFlag==null}">
									<c:set var="showFlag" value="1"></c:set>
									<div class="row">
										<label class="col-xs-2 control-label no-padding-right text-right" >说明：</label>
										<div class="col-xs-10">
											<div class="form-group">
												<label class="col-xs-2" style="width:auto;">原办理时限为</label>
												<label class="col-xs-2" style="padding-left: 0px;"><b>${vdata.durationHistory}&nbsp;&nbsp;&nbsp;</b>个工作日</label>
											</div>
											<div class="form-group">
												<label class="col-xs-2" style="width:auto;">本次申请延长</label>
												<label class="col-xs-2" style="padding-left: 0px;"><b>${vdata.duration}&nbsp;&nbsp;&nbsp;</b>个工作日</label>
											</div>
										</div>
									</div>
									<div class="hr hr-22"></div>
								</c:if>
							</c:forEach> 
							<div class=" row">
								<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>操作：</label>
								<div class="col-xs-10">
								<c:forEach items="${vdata.actions}" var="b" varStatus="status">
									<div class="radio col-xs-3">
										<label>
											<input id="action_${b.id}" name="actionRadio" stepRight="${b.stepRight}" value="${b.id}" class="ace" type="radio">
											<span class="lbl">${b.name}</span>
										</label>
									</div>
								</c:forEach>
								</div>
							</div>
							<div class="hr hr-24"></div>
							<div class=" row">
							<div class="col-xs-12">
								<c:forEach items="${vdata.actions}" var="a" varStatus="status">
								<div id="${a.id }_div" class="row" style="display:none;">
									<div class=" col-xs-12">
									<c:if test="${a.depart!=null}">
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>指派给</label>
											<div class="col-xs-4">
												<input type="text" max-length="50"name="gridCode"  class="col-xs-12 col-sm-12 tooltip-error required" />
											</div>
										</div>
										</c:if>
										<c:if test="${a.duration!=null}">
									<div class="form-group">
										<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>设置办理时限</label>
										<div class="col-xs-4">
											<input type="text" max-length="2"name="duration"  class="col-xs-6 col-sm-6 tooltip-error required" /><label class="col-xs-6 no-padding-left">个工作日</label>
										</div>
									</div>
									</c:if>
									<c:if test="${a.delay!=null}">
									<div class="form-group">
										<label class="col-xs-2 control-label no-padding-right text-right" >原办理时限为</label>
										<label class="col-xs-2 no-padding-right "><b>${vdata.durationHistory}&nbsp;&nbsp;&nbsp;</b>个工作日</label>
									</div>
									<div class="form-group">
										<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>本次申请延时</label>
										<div class="col-xs-4">
											<input type="text" max-length="50"name="duration"  class="col-xs-6 col-sm-6 tooltip-error required" />
											<label class="col-xs-6 no-padding-left" style="margin-top: 4px;">个工作日</label>
										</div>
										
									</div>
									</c:if>
									<c:if test="${a.appraise!=null}">
										<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>评价</label>
											<div class="col-xs-4">
												<input type="text" max-length="50"name="codeAppraise"  class="col-xs-12 col-sm-12 tooltip-error required" />
											</div>
										</div>
									</c:if>
									</div>
								</div>
								</c:forEach>
								<div class="form-group">
											<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>意见：</label>
											<div class="col-xs-10">
												<textarea name="opinion" class="col-xs-12 col-sm-12 tooltip-error required"></textarea>
											</div>
									</div>
									</div>
							</div>
							</form>
							</div>
							</div>
							<div class="pull-right">
		           				<button data-bb-handler="success" id="commitBtn" type="button" class="btn btn-success">提交</button>
	          				 </div>
						
					</div>
				</c:if>
			</div><!-- tab-content -->
		</div>
	</div>
</div><!-- row -->
</body>
</html>


