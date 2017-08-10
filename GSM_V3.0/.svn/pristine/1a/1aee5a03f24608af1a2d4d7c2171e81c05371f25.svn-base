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
			<input type="hidden" name="code" value="${vdata.efharmsafe.code}" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.efharmsafe.gridCode}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				
					
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="eventName"><span class="red">*</span>名称</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="eventName" name="eventName" value="${vdata.efharmsafe.eventName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeHarmType"><span class="red">*</span>类型 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeHarmType" name="codeHarmType" value="${vdata.efharmsafe.codeHarmType}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
				</div>
				

				<div class="form-group">	
					<label class="col-xs-2 control-label no-padding-right text-right" for="harmDate"><span class="red">*</span>隐患排查时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="harmDate" value="${vdata.efharmsafe.harmDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="time"><span class="red">*</span>事件发生时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="time" value="${vdata.efharmsafe.time}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
											
				</div>
				
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="place"><span class="red">*</span>地点或部位</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="place" name="place" value="${vdata.efharmsafe.place}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
					<div class="col-xs-4 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.efharmsafe.position}"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					</div>
	
				</div>
				
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="belongUnit"><span class="red">*</span>所属单位</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="belongUnit" name="belongUnit" value="${vdata.efharmsafe.belongUnit}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="unitName"><span class="red">*</span>负责人</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="unitName" name="unitName" value="${vdata.efharmsafe.unitName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
			
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="unitJob"><span class="red">*</span>负责人职务</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="unitJob" name="unitJob" value="${vdata.efharmsafe.unitJob}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="unitPhone"><span class="red">*</span>负责人联系电话</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="unitPhone" name="unitPhone" value="${vdata.efharmsafe.unitPhone}" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
						</div>
					</div>
	
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="contents"><span class="red">*</span>隐患或事件详情</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="contents" name="contents"  class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efharmsafe.contents}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="safetyName"><span class="red">*</span>安全责任人</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="safetyName" name="safetyName" value="${vdata.efharmsafe.safetyName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="safetyJob"><span class="red">*</span>安全责任人职务</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="safetyJob" name="safetyJob" value="${vdata.efharmsafe.safetyJob}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="safetyPhone"><span class="red">*</span>安全责任人联系电话</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="safetyPhone" name="safetyPhone" value="${vdata.efharmsafe.safetyPhone}" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="harmRectDate"><span class="red">*</span>隐患整改时限</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="harmRectDate" name="harmRectDate" value="${vdata.efharmsafe.harmRectDate}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="rectMeasure"><span class="red">*</span>隐患整改措施</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="rectMeasure" name="rectMeasure"  class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efharmsafe.rectMeasure}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="rectSituation"><span class="red">*</span>隐患整改情况</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="rectSituation" name="rectSituation"  class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efharmsafe.rectSituation}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="withSituation"><span class="red">*</span>事件处置情况</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="withSituation" name="withSituation" class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efharmsafe.withSituation}</textarea>
						</div>
					</div>
				</div>
				
			 	<div class="form-group">
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="registerDate"><span class="red">*</span>登记时间 </label>
			
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="registerDate" value="${vdata.efharmsafe.registerDate}"  type="text">
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
						<textarea max-length="50"id="rmark" name="rmark"  class="col-xs-12 col-sm-12">${vdata.efharmsafe.rmark}</textarea>
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


