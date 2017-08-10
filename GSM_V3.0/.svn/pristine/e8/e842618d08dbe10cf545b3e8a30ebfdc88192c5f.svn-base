<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
var subPage_muti=false;
$(document).ready(function () {  
	var parentCode = '${map.parentCode}';
	
	$("#parentCode").attr("value",parentCode);

	$("#form").validate({
		submitHandler: function (form) {
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
	//父窗口中的提交按钮
	$("#commitBtn",parent.document).bind("click",function(){
		$("#form").submit();
	});
	
});

    </script>
<body>
    <div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			             <input type="hidden" id="code" name="code" value="${map.seat.code }" />
			              <input type="hidden" name="flagDepartment" value="0" />
               			 <input type="hidden" id="parentCode" name="parentCode"  value="${map.seat.parentCode }${map.parentCode}" />
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>区/县名称</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="name" name="name" value="${map.seat.name}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>行政区划代码</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="cityCode" name="cityCode" value="${map.seat.cityCode}" class="col-xs-12 col-sm-12 tooltip-error digits" />
					</div>
				</div>
			<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>指挥中心主任姓名</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managerName" name="managerName" value="${map.seat.managerName}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>指挥中心主任电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managerPhone" name="managerPhone" value="${map.seat.managerPhone}" class="col-xs-12 col-sm-12 tooltip-error digits" />
					</div>
				</div>
			
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="sort"><span class="red">*</span>排序</label>
			
					<div class="col-xs-10">
						<input type="text"id="sort" name="sort" min="0" value="${map.seat.sort}" class="col-xs-6 col-sm-6 tooltip-error required digits" />
					</div>
				</div>
				
					<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
			
					<div class="col-xs-10">
						<input type="text"id="position" readonly="readonly" name="position" value="${map.seat.position}" onclick="getPointXY(this)" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >概况 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea max-length="5000" class="col-xs-12 col-sm-12"id="description" name="description" rows="8">${map.seat.description}</textarea>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="remark">备注 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="remark" name="remark" sytle="height:100px;" max-length="5000" class="col-xs-12 col-sm-12">${map.seat.remark }</textarea>
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
</body>
</html>