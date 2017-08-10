<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<link href="/GSM_V3.0/resource/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/GSM_V3.0/resource/css/font-awesome.min.css">
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
		<br>
		<br>
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.retiredparty.code}" />
				
				
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
				<br>
					<button type="button" class="btn btn-primary">发送</button>
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


