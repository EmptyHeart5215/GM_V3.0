	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/gsm/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">
$(function(){
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
	 $("[name=gridCode]").ztreeGrid({
			url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
		});
	 $("[name=codeEventNature]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_NATURE',
			name:"dicValue",
			pIdKey:"parentCode"
		});
	 if('${vdata.BRouteEvents.isSolveCrimes }' == '是'){
		 $("#isSolveCrimes option[value='是']").attr("selected", "selected"); 
	 }else if('${vdata.BRouteEvents.isSolveCrimes }' == '否'){
		 $("#isSolveCrimes option[value='否']").attr("selected", "selected"); 
	 }else if('${vdata.BRouteEvents.isSolveCrimes }' == 0){
		 $("#isSolveCrimes option[value='0']").attr("selected", "selected"); 
	 }
});
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
<!-- 			<h2 class="text-center">组织生活</h2> -->
			<input type="hidden" name="code" value="${vdata.BRouteEvents.code }" />
			<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="gridCode" name="gridCode" value="${vdata.BRouteEvents.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="eventNumber"><span class="red">*</span>案（事）件编号</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="eventNumber" name="eventNumber" value="${vdata.BRouteEvents.eventNumber }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				 <div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="eventName"><span class="red">*</span>案（事）件名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="eventName" name="eventName" value="${vdata.BRouteEvents.eventName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="happenDate"><span class="red">*</span>发生日期</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="happenDate" value="${vdata.BRouteEvents.happenDate }"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="happenAddress">发生地点</label>
					<div class="col-xs-10">
							<input type="text"id="happenAddress" name="happenAddress" value="${vdata.BRouteEvents.happenAddress }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>案（事）件性质</label>
					<div class="col-xs-4">
							<input type="text"id="codeEventNature" name="codeEventNature" value="${vdata.BRouteEvents.codeEventNature }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="eventCondition">案（事）件情况</label>
					<div class="col-xs-4">
						<input type="text"id="eventCondition" name="eventCondition" value="${vdata.BRouteEvents.eventCondition }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="principalNumber">主犯/嫌疑人证件代码</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="principalNumber" name="principalNumber" value="${vdata.BRouteEvents.principalNumber }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="principalCid">主犯/嫌疑人证件号码</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="principalCid" name="principalCid" value="${vdata.BRouteEvents.principalCid }" class="col-xs-12 col-sm-12 tooltip-error personcid" />
					</div>
				</div>
				
				<div class="form-group">	
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="principalName"><span class="red">*</span>主犯/嫌疑人姓名</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="principalName" name="principalName" value="${vdata.BRouteEvents.principalName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="isSolveCrimes"><span class="red">*</span>是否破案</label>
					<div class="col-xs-4">
						 <select   name = "isSolveCrimes"  class="form-control myselect tooltip-error required"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="是">是</option>
                           <option  value="否">否</option>
                        </select>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="crimeNumber"><span class="red">*</span>作案人数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="crimeNumber" name="crimeNumber" value="${vdata.BRouteEvents.crimeNumber }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="runNumber"><span class="red">*</span>在逃人数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="runNumber" name="runNumber" value="${vdata.BRouteEvents.runNumber }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="captureNumber"><span class="red">*</span>抓捕人数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="captureNumber" name="captureNumber" value="${vdata.BRouteEvents.captureNumber }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="eventDetectCondition">案件侦破情况</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="eventDetectCondition" name="eventDetectCondition" value="${vdata.BRouteEvents.eventDetectCondition }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="space-4"></div>
				<div class="control-group">
                	 <label class="control-label">
                	 </label>
            	</div> 
		</form>
	</div>
</div>
</body>
</html>
