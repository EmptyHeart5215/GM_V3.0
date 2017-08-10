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
			<input type="hidden" name="code" value="${vdata.efkeyplace.code}" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.efkeyplace.gridCode}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				
					
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="troubleName"><span class="red">*</span>治安重点地区名称</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="troubleName" name="troubleName" value="${vdata.efkeyplace.troubleName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
					<label class="col-xs-2 control-label no-padding-right text-right" for="placeRange"><span class="red">*</span>区域范围 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="placeRange" name="placeRange" value="${vdata.efkeyplace.placeRange}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
				</div>
				

				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="securityPro"><span class="red">*</span>存在的治安问题 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="securityPro" name="securityPro" value="${vdata.efkeyplace.securityPro}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="belongUnit"><span class="red">*</span>主管或所属单位</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="belongUnit" name="belongUnit" value="${vdata.efkeyplace.belongUnit}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
			
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="unitName"><span class="red">*</span>单位负责人 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="unitName" name="unitName" value="${vdata.efkeyplace.unitName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="unitJob"><span class="red">*</span>单位负责人职务</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="unitJob" name="unitJob" value="${vdata.efkeyplace.unitJob}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="unitPhone"><span class="red">*</span>单位负责人电话</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="unitPhone" name="unitPhone" value="${vdata.efkeyplace.unitPhone}" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="adminName"><span class="red">*</span>管理责任人</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="adminName" name="adminName" value="${vdata.efkeyplace.adminName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="adminJob"><span class="red">*</span>管理责任人职务</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="adminJob" name="adminJob" value="${vdata.efkeyplace.adminJob}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="adminPhone"><span class="red">*</span>管理责任人电话</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="adminPhone" name="adminPhone" value="${vdata.efkeyplace.adminPhone}" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
						</div>
					</div>
	
				</div>
			
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="police"><span class="red">*</span>所属派出所</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="police" name="police" value="${vdata.efkeyplace.police}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="directorPhone"><span class="red">*</span>所长及联系电话</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="directorPhone" name="directorPhone" value="${vdata.efkeyplace.directorPhone}" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
						</div>
					</div>
	
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeSuperiorsListing"><span class="red">*</span>是否上级挂牌</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeSuperiorsListing" name="codeSuperiorsListing" value="${vdata.efkeyplace.codeSuperiorsListing}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="remediationDate"><span class="red">*</span>整治时限</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="remediationDate" name="remediationDate" value="${vdata.efkeyplace.remediationDate}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
			 	<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="remediationMeasure"><span class="red">*</span>整治措施</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="remediationMeasure" name="remediationMeasure" class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efkeyplace.remediationMeasure}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="remediationSituation"><span class="red">*</span>整治情况</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="remediationSituation" name="remediationSituation" class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efkeyplace.remediationSituation}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="superiorsAccep"><span class="red">*</span>上级验收情况</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="superiorsAccep" name="superiorsAccep" value="${vdata.efkeyplace.superiorsAccep}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>定位</label>
					<div class="col-xs-4 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.efkeyplace.position}" type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					</div>
				</div>
				
				<div class="form-group">
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="registerDate"><span class="red">*</span>登记时间 </label>
			
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="registerDate" value="${vdata.efkeyplace.registerDate}"  type="text">
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
						<textarea max-length="50"id="rmark" name="rmark" class="col-xs-12 col-sm-12">${vdata.efkeyplace.rmark}</textarea>
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


