	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/gsm/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
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
});
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.video.code }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="rmark">手机号</label>
					<div class="col-xs-9">
					<div class="clearfix">
						<textarea max-length="50"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required"></textarea>
						</div>
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="rmark">发送信息</label>
					<div class="col-xs-9">
					<div class="clearfix">
						<textarea style="height: 250px;" max-length="500"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required"></textarea>
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
