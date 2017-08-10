<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	if("${vdata.menu.hasHideMenu}"=="true"){
		$("#hasHideMenu_yes").prop("checked",true);
	}else{
		$("#hasHideMenu_no").prop("checked",true);
	}
	
	//alert("${vdata.menu.hasHideMenu}");
	
	if("${vdata.menu.isMenu}"=="true"){
		$("#isMenu_yes").prop("checked",true);
	}else{
		$("#isMenu_no").prop("checked",true);
	}
	
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize()+"&parentCode="+'${vdata.menu.parentCode}';
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
			<input type="hidden" name="code" value="${vdata.menu.code }" />
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="menuName" name="menuName" value="${vdata.menu.menuName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right">父菜单</label>
					<div class="col-xs-4">
						<input type="text"id="parentName"readonly="readonly" name="parentName" value="${vdata.menu.parentName }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">URL地址</label>
					<div class="col-xs-10">
						<input type="text" max-length="100"id="actionUrl" name="actionUrl" value="${vdata.menu.actionUrl }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>拥有隐藏菜单</label>
					<div class="col-xs-4">
						<label><input type="radio" id="hasHideMenu_yes"  name="hasHideMenu" value="1"/>是</label>
						<label><input type="radio" id="hasHideMenu_no" name="hasHideMenu" value="0" checked="checked"/>否</label>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right">是否是菜单</label>
					<div class="col-xs-4">
						<label><input type="radio" id="isMenu_yes"  name="isMenu" value="1"/>是</label>
						<label><input type="radio" id="isMenu_no" name="isMenu" value="0" checked="checked"/>否</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>排序</label>
					<div class="col-xs-4">
						<input type="text"id="sort" name="sort" value="${vdata.menu.sort }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">备注 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id=""remark"" name="remark" class="col-xs-12 col-sm-12">${vdata.menu.remark }</textarea>
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
