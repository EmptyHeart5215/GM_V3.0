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
				data+="&parentCode=${map.seat.parentCode}&flagDepartment=1";
	        	if("${map.codeField}"!=""){
	        		data+="&code=${map.seat.code}";
	        	}
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
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${map.seat.code}" />
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>名称 </label>
			
					<div class="col-xs-10">
						<input  type="text" id="name" name="name" value="${map.seat.name}"maxLength="50" class="col-xs-6 col-sm-6 required" />
					</div>
				</div>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >排序 </label>
					<div class="col-xs-10">
						<input  type="text" id="sort" name="sort" value="${map.seat.sort}" maxLength="3" class="col-xs-6 col-sm-6 digits" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >备注 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="Remark" name="remark" sytle="height:100px;" max-length="5000" class="col-xs-12 col-sm-12">${map.seat.remark }</textarea>
						</div>
					</div>
				</div>
	</form>
	</div>
	</div>
</body>
</html>