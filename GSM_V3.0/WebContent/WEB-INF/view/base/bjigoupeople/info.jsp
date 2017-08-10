	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
	if('${vdata.bjigoupeople.sex }' == '男'){
		 $("#sex option[value='男']").attr("selected", "selected"); 
	 }else if('${vdata.bjigoupeople.sex }' == '女'){
		 $("#sex option[value='女']").attr("selected", "selected"); 
	 }else if('${vdata.bjigoupeople.sex }' == 0){
		 $("#sex option[value='0']").attr("selected", "selected"); 
	 }
});

</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.bjigoupeople.code }" />
			<input type="hidden" name="personCode" value="${vdata.bjigoupeoplecode }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="name"><span class="red">*</span>姓名</label>
					<div class="col-xs-10">
						<input type="text" max-length="100"id="name" name="name" value="${vdata.bjigoupeople.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="sex"><span class="red">*</span>性别</label>
					<div class="col-xs-10">
						 <select  id="sex" name = "sex"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="男">男</option>
                           <option  value="女">女</option>
                        </select>
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="phone"><span class="red">*</span>电话</label>
					<div class="col-xs-10">
						<input type="text" max-length="100"id="phone" name="phone" value="${vdata.bjigoupeople.phone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="address"><span class="red">*</span>现住址</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="address" name="address" value="${vdata.bjigoupeople.address }" class="col-xs-12 col-sm-12 tooltip-error required" />
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
