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
			<input type="hidden" name="code" value="${vdata.efsignificantvisits.code}" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.efsignificantvisits.gridCode}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				
					
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="visitsName"><span class="red">*</span>主要上访人</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="visitsName" name="visitsName" value="${vdata.efsignificantvisits.visitsName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
					<label class="col-xs-2 control-label no-padding-right text-right" for="visitsRegister"><span class="red">*</span>上访人户籍地 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="visitsRegister" name="visitsRegister" value="${vdata.efsignificantvisits.visitsRegister}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="visitsPsersons"><span class="red">*</span>人数</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="visitsPsersons" name="visitsPsersons" value="${vdata.efsignificantvisits.visitsPsersons}" class="col-xs-12 col-sm-12 tooltip-error required number"  />
						</div>
					</div>
	
					<label class="col-xs-2 control-label no-padding-right text-right" for="visitsFrequency"><span class="red">*</span>上访次数 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="visitsFrequency" name="visitsFrequency" value="${vdata.efsignificantvisits.visitsFrequency}" class="col-xs-12 col-sm-12 tooltip-error required number" />
						</div>
					</div>
				
				</div>

				<div class="form-group">	
					<label class="col-xs-2 control-label no-padding-right text-right" for="visitsDate"><span class="red">*</span>上访时间 </label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="visitsDate" value="${vdata.efsignificantvisits.visitsDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeVisitsLocation"><span class="red">*</span>上访地点 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeVisitsLocation" name="codeVisitsLocation" value="${vdata.efsignificantvisits.codeVisitsLocation}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
											
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeNormalvisitYesno"><span class="red">*</span>是否非正常上访</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeNormalvisitYesno" name="codeNormalvisitYesno" value="${vdata.efsignificantvisits.codeNormalvisitYesno}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeVisitsType"><span class="red">*</span>上访性质 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeVisitsType" name="codeVisitsType" value="${vdata.efsignificantvisits.codeVisitsType}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeSuperiors"><span class="red">*</span>上级交办情况</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeSuperiors" name="codeSuperiors" value="${vdata.efsignificantvisits.codeSuperiors}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeHandleYesno"><span class="red">*</span>是否挂账督办</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeHandleYesno" name="codeHandleYesno" value="${vdata.efsignificantvisits.codeHandleYesno}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="requireHandleDate"><span class="red">*</span>要求办结时间 </label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="requireHandleDate" value="${vdata.efsignificantvisits.requireHandleDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="significantVisits"><span class="red">*</span>是否重大上访事件</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="significantVisits" name="significantVisits" value="${vdata.efsignificantvisits.significantVisits}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="visitsManage"><span class="red">*</span>上访反映问题</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="visitsManage" name="visitsManage" class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efsignificantvisits.visitsManage}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeProblemType"><span class="red">*</span>问题类别</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeProblemType" name="codeProblemType" value="${vdata.efsignificantvisits.codeProblemType}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="stabilityName"><span class="red">*</span>稳控责任人 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="stabilityName" name="stabilityName" value="${vdata.efsignificantvisits.stabilityName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="stabilityMeasure"><span class="red">*</span>稳控措施</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="stabilityMeasure" name="stabilityMeasure" value="${vdata.efsignificantvisits.stabilityMeasure}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="dutyDivision"><span class="red">*</span>问题处理责任部门</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="dutyDivision" name="dutyDivision" value="${vdata.efsignificantvisits.dutyDivision}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="dutyName"><span class="red">*</span>问题处理责任人</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="dutyName" name="dutyName" value="${vdata.efsignificantvisits.dutyName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					
		
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="proceed"><span class="red">*</span>问题处理情况</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="proceed" name="proceed"  class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efsignificantvisits.proceed}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
				
				<label class="col-xs-2 control-label no-padding-right text-right" for="endEventDate"><span class="red">*</span>问题解决时间 </label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="endEventDate" value="${vdata.efsignificantvisits.endEventDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					

					<label class="col-xs-2 control-label no-padding-right text-right" for="endEvent"><span class="red">*</span>事件终结情况</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="endEvent" name="endEvent" value="${vdata.efsignificantvisits.endEvent}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
				<div class="col-xs-4 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.efsignificantvisits.position}" type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="registerDate"><span class="red">*</span>登记时间 </label>
			
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="registerDate" value="${vdata.efsignificantvisits.registerDate}"  type="text">
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
							<input type="HIDDEN" id="url_pic" name="seatPicture" value="${map.seat.seatPicture }" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="rmark">备注</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="rmark" name="rmark"  class="col-xs-12 col-sm-12">${vdata.efsignificantvisits.rmark }</textarea>
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


