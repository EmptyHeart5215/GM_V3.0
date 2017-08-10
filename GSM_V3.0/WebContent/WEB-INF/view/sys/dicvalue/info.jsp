<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<style>
.combo {
float:left;
}
</style>
<script type="text/javascript">
//字典名称code
var sysDicCode='${vdata.sysDicCode}';
$(function() {
	$("#form").validate({
		submitHandler: function (form) {
			$('#code').val("${vdata.sysDicValue.code }");
			var data = $("#form").serialize()+"&dicCode="+sysDicCode;
			
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
	
/* 	var dicValues='';
	$.ajax({
        url: '${base}/sys/sysdic/queryManage?page=1&rows=100&sort=code&order=DESC&t='+ Math.random(),
        type: 'POST',
        dataType: 'JSON',
        async:false,
        success: function(data) {
        	dicValues=data.rows;
        	 $.each(dicValues, function (i,d) {
                 if(d.CODE == sysDicCode){
                	 $('#sysDicName').val(d.NAME_DIC);
                	 return false;
                 }
            });
        }
    });
	$('#sysDicName').typeahead({
        source: function (query, process) {
        	return  $.map(dicValues, function (dicValue) {
                return dicValue.NAME_DIC + "";
            });
        },
        updater: function (name) {
            $.each(dicValues, function (i,d) {
                 if(d.NAME_DIC == name){
                	 sysDicCode=d.CODE;
                	 return false;
                 }
            });
            return name;
        }
    });  */
	});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" id="code" name="code" value="${vdata.sysDicValue.code }" /> 
				<c:if test="${vdata.parentName!=null}">
					<div class="form-group">
					<input type="hidden" value="${vdata.parentCode}" name="parentCode"/>
						<label id="sss" class="col-xs-2 control-label no-padding-right text-right">父字典值</label>
						<div class="col-xs-10">
							
							<input type="text"  data-placement="bottom" id="parentName" value="${vdata.parentName}" disabled="disabled" class="col-xs-10 col-sm-5e" />
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>字典值名称</label>
					<div class="col-xs-10">
						<input type="text"  data-placement="bottom" id="dicValue" name="dicValue" value="${vdata.sysDicValue.dicValue }" class="col-xs-10 col-sm-5 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" >排序</label>
					<div class="col-xs-10">
						<input type="text"  data-placement="bottom" id="sort" name="sort" value="${vdata.sysDicValue.sort }" class="col-xs-10 col-sm-5 tooltip-error digits min[0]" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="form-field-1">备注 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea name="remark" class="col-xs-10 col-sm-5">${vdata.sysDicValue.remark }</textarea>
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


