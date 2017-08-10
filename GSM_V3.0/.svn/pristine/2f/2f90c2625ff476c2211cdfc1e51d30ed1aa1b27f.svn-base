<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize()+"&code=${vdata.unit.code}";
			$.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	parent.successFun("unit");
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
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-4">
						<input type="hidden" max-length="50"id="gridCode" name="gridCode" value="${vdata.unit.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
						<input type="text"value="${vdata.unit.gridTotalName }"readonly="readonly" class="col-xs-12 col-sm-12" />
					
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属楼栋</label>
			
					<div class="col-xs-4">
						<input type="hidden" max-length="50"id="buildCode" name="buildCode" value="${vdata.unit.buildCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
						<input type="text"value="${vdata.unit.buildName }"readonly="readonly" class="col-xs-12 col-sm-12" />
					
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>单元名称</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="name" name="name" value="${vdata.unit.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >登记时间</label>
			
					<div class="col-xs-4">
					<div class="input-group">
						<input class="col-xs-12 col-sm-12 form-control date-picker"name="registerDate" value="${vdata.unit.registerDate }"  id="registerDate" data-date-format="yyyy-mm-dd" type="text"/>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >排序</label>
			
					<div class="col-xs-10">
						<input type="text" id="sort" name="sort" value="${vdata.unit.sort }" class="col-xs-12 col-sm-12 tooltip-error digits" />
					</div>
					
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >描述 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="description" name="description" class="col-xs-12 col-sm-12">${vdata.unit.description }</textarea>
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


