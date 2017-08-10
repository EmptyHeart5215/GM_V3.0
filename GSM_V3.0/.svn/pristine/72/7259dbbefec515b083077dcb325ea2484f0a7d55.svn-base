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
		url:'${base}/sys/seatgird/queryOrgnizationTree?t=' + Math.random()
	});
});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.emergencyPlace.code }" />
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属辖区</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.emergencyPlace.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>	
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="placeName"><span class="red">*</span>场所名称</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="placeName" name="placeName" value="${vdata.emergencyPlace.placeName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>	
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="address"><span class="red">*</span>场所地址</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="address" name="address" value="${vdata.emergencyPlace.address }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="placeArea"><span class="red">*</span>场所面积</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="placeArea" name="placeArea" value="${vdata.emergencyPlace.placeArea }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="accommodateNum"><span class="red">*</span>容纳人数</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="accommodateNum" name="accommodateNum" value="${vdata.emergencyPlace.accommodateNum }" class="col-xs-12 col-sm-12 tooltip-error required number" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
					<div class="col-xs-10 input-group">
					     <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.emergencyPlace.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
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


