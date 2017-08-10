<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
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
});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.efinformation.code}" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.efinformation.gridCode}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="alarmNo"><span class="red">*</span>案件编号</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="alarmNo" name="alarmNo" value="${vdata.efinformation.alarmNo}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
					<label class="col-xs-2 control-label no-padding-right text-right" for="eventName"><span class="red">*</span>案件名称 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="eventName" name="eventName" value="${vdata.efinformation.eventName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
				</div>
				<div class="form-group">	
					<label class="col-xs-2 control-label no-padding-right text-right" for="time"><span class="red">*</span>案发时间 </label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="time" value="${vdata.efinformation.time}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="theSite"><span class="red">*</span>案发地点及部位 </label>
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="theSite" name="theSite" value="${vdata.efinformation.theSite}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="caseParty"><span class="red">*</span>涉案当事人</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="caseParty" name="caseParty" class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efinformation.caseParty}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>定位</label>
					<div class="col-xs-4 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.efinformation.position}" type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="partyAddress"><span class="red">*</span>当事人住址 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="partyAddress" name="partyAddress" value="${vdata.efinformation.partyAddress}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="briefCase"><span class="red">*</span>简要案情</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="briefCase" name="briefCase"  class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efinformation.briefCase}</textarea>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="policeTime"><span class="red">*</span>报警时间 </label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="policeTime" value="${vdata.efinformation.policeTime}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="policePerson"><span class="red">*</span>出警人员</label>
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="policePerson" name="policePerson" value="${vdata.efinformation.policePerson}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="dealWith"><span class="red">*</span>处置情况及结果</label>
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="dealWith" name="dealWith" value="${vdata.efinformation.dealWith}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="closedDate"><span class="red">*</span>报警时间 </label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="closedDate" value="${vdata.efinformation.closedDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
			 	<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="registerDate"><span class="red">*</span>登记时间 </label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="registerDate" value="${vdata.efinformation.registerDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="form-group">
				<label class="col-xs-2 control-label no-padding-left text-right">附件</label>
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic" name="seatPicture" value="${map.seat.seatPicture}" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="rmark">备注</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="rmark" name="rmark" class="col-xs-12 col-sm-12">${vdata.efinformation.rmark}</textarea>
						</div>
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
<script type="text/javascript">
	
	$(document).ready(function () {
	
	//如果子页面需要进行图片浏览，必须加上这句-------------
	layer.use('extend/layer.ext.js', function(){
		   layer.ext =function(){};
	}); 
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone=new Dropzone("#dropzoneDiv",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic').val().split(";").length-1
	});
	 getOldPics(dropzone);
	$("#form").validate({
		submitHandler: function (form) {
		 	$('#url_pic').val('');
		 	//获取上传的图片的值
		 	var ids='';
		 	$('[name^=showImg]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids+=this.id+";";
		 		}
		 	});
		 	$('#url_pic').val(ids);
		 	var data = $("#form").serialize();
		 	 $.ajax({
				type : "post",
				url : "${base}/${map.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	if('${map.url}'.indexOf('modify')>0){
		    				parent.editNodeCallBack();
		    			}else{
		    				parent.addNodeCallBack();
		    			}
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			});  
        }
	});
	
});
  
</script>
</body>
</html>


