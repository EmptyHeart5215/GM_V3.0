<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	if('${vdata.jiGouServicePeople.sex }' == '男'){
		 $("#sex option[value='男']").attr("selected", "selected"); 
	 }else if('${vdata.jiGouServicePeople.sex }' == '女'){
		 $("#sex option[value='女']").attr("selected", "selected"); 
	 }
	$("#form").validate({
		submitHandler: function (form) {
			
			var data = $("#form").serialize();
			var a=[{code:$('#code').val(),name:$('#name').val(),sex:$('#sex').val(),phone:$('#phone').val(),address:$('#address').val()}];
			parent.successFun(a);
			/* $.ajax({
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
			}); */
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
			<input type="hidden" id="code" name="code" value="${vdata.jiGouServicePeople.code }" />
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>姓名</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="name" name="name" value="${vdata.jiGouServicePeople.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>性别</label>
					<div class="col-xs-4">
						<select value="${vdata.jiGouServicePeople.sex }"id="sex" name="sex" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
							<option value="">请选择</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="personAddress">联系电话</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="phone" name="phone" value="${vdata.jiGouServicePeople.phone }" class="col-xs-12 col-sm-12 allPhone" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="address">联系地址</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="address" name="address" value="${vdata.jiGouServicePeople.address }" class="col-xs-12 col-sm-12 " />
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
