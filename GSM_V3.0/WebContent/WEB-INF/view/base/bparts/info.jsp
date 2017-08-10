	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<script src="/gsm/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
<jsp:include  page="/resource/base_import.jsp"/>

<script type="text/javascript">
$(function(){
	//如果子页面需要进行图片浏览，必须加上这句-------------
	layer.use('extend/layer.ext.js', function(){
		   layer.ext =function(){};
	}); 
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone1=new Dropzone("#dropzoneDiv",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic').val().split(";").length-1,
		 	uploadBtnId:'uploadBtn',
            imgName:'showImg',
	});
	 getOldPics(dropzone1,"url_pic","showImg_old","picDisplay_old");
	$("#form").validate({
		submitHandler: function (form) {
			$('#url_pic1').val('');
			var ids='';
		 	$('[name^=showImg]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids+=this.id+";";
		 		}
		 	});
		 	$('#url_pic').val(ids);
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
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
	});
	$("[name=codeSmallType]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SMALL_TYPE',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	if('${vdata.bpart.codePartsStatus }' == '完好'){
		 $("#codePartsStatus option[value='完好']").attr("selected", "selected"); 
	 }else if('${vdata.bpart.codePartsStatus }' == '缺失'){
		 $("#codePartsStatus option[value='缺失']").attr("selected", "selected"); 
	 }else if('${vdata.bpart.codePartsStatus }' == '破损'){
		 $("#codePartsStatus option[value='破损']").attr("selected", "selected"); 
	 }else if('${vdata.bpart.codePartsStatus }' == 0){
		 $("#codePartsStatus option[value='0']").attr("selected", "selected"); 
	 }
	
});
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
<!-- 			<h2 class="text-center">组织生活</h2> -->
			<input type="hidden" name="code" value="${vdata.bpart.code }" />
			<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>所属辖区</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="gridCode" name="gridCode" value="${vdata.bpart.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>部件名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="name" name="name" value="${vdata.bpart.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				<div class="form-group">
				<label class="col-xs-2 control-label no-padding-right text-right" >部件编码</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="partsCode" name="partsCode" value="${vdata.bpart.partsCode }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属分类</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeSmallType" name="codeSmallType" value="${vdata.bpart.codeSmallType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				
					
				 </div>
				<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >部件地点</label>
					<div class="col-xs-10">
						<input type="text" max-length="100"id="address" name="address" value="${vdata.bpart.address }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >管理单位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="enterpriseManage" name="enterpriseManage" value="${vdata.bpart.enterpriseManage }" class="col-xs-12 col-sm-12 " />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >管理单位负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="enterpriseMan" name="enterpriseMan" value="${vdata.bpart.enterpriseMan }" class="col-xs-12 col-sm-12 " />
					</div>
					
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >管理单位负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="enterprisePhone" name="enterprisePhone" value="${vdata.bpart.enterprisePhone }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >管理单位负责人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="enterpriseDuty" name="enterpriseDuty" value="${vdata.bpart.enterpriseDuty }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >权属单位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belong" name="belong" value="${vdata.bpart.belong }" class="col-xs-12 col-sm-12 " />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >权属单位负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongMan" name="belongMan" value="${vdata.bpart.belongMan }" class="col-xs-12 col-sm-12 " />
					</div>
					
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">权属单位负责人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongDuty" name="belongDuty" value="${vdata.bpart.belongDuty }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >权属单位负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongPhone" name="belongPhone" value="${vdata.bpart.belongPhone }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >养护单位</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="care" name="care" value="${vdata.bpart.care }" class="col-xs-12 col-sm-12 " />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >养护单位负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="careMan" name="careMan" value="${vdata.bpart.careMan }" class="col-xs-12 col-sm-12 " />
					</div>
					
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >养护单位负责人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="careDuty" name="careDuty" value="${vdata.bpart.careDuty }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >养护单位负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="carePhone" name="carePhone" value="${vdata.bpart.carePhone }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >部件状态</label>
					<div class="col-xs-4">
						 <select  id="codePartsStatus" name = "codePartsStatus"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="完好">完好</option>
                           <option  value="缺失">缺失</option>
                           <option  value="破损">破损</option>
                        </select>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >网格联系人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridContacts" name="gridContacts" value="${vdata.bpart.gridContacts }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >网格联系人职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridContactsDuty" name="gridContactsDuty" value="${vdata.bpart.gridContactsDuty }" class="col-xs-12 col-sm-12 " />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >网格联系人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridContactsPhone" name="gridContactsPhone" value="${vdata.bpart.gridContactsPhone }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>地图定位</label>
					<div class="col-xs-10 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.bpart.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					   </div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >描述</label>
					<div class="col-xs-10">
						<textarea type="text" max-length="1000"id="remark" name="remark" class="col-xs-12 col-sm-12 " >${vdata.bpart.remark }</textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">部件图片 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn" type="button">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic" name="picture" value="${vdata.bpart.picture}" />
						</div>
					</div>
				</div>
				<c:if test="${vdata.bpart.picture != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存部件图片 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>
				
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
