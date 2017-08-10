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
	
	$("[name=codeBelongType]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_FIELDS_CLASS',
		name:"dicValue",
		pIdKey:"parentCode"
	});
});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.fields.code}" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="gridCode">所属部门或辖区</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.fields.gridCode}" class="col-xs-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="name">名称</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="name" name="name" value="${vdata.fields.name}" class="col-xs-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="codeBelongType">所属分类</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeBelongType" name="codeBelongType" value="${vdata.fields.codeBelongType}" class="col-xs-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="fieldsCode">编号</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="fieldsCode" name="fieldsCode" value="${vdata.fields.fieldsCode}" class="col-xs-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="address">地址</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="address" name="address" value="${vdata.fields.address}" class="col-xs-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="area">面积</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="area" name="area" value="${vdata.fields.area}" class="col-xs-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="range">范围界限</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="range" name="range" value="${vdata.fields.range}" class="col-xs-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="belong">主管或所属单位</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belong" name="belong" value="${vdata.fields.belong}" class="col-xs-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="belongMan">单位负责人姓名</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongMan" name="belongMan" value="${vdata.fields.belongMan}" class="col-xs-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="belongDuty">主管或所属单位</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongDuty" name="belongDuty" value="${vdata.fields.belongDuty}" class="col-xs-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="belongPhone">单位负责人电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="belongPhone" name="belongPhone" value="${vdata.fields.belongPhone}" class="col-xs-12 tooltip-error allPhone required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="manageMan">管理责任人姓名</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="manageMan" name="manageMan" value="${vdata.fields.manageMan}" class="col-xs-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="manageDuty">管理责任人职务</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="manageDuty" name="manageDuty" value="${vdata.fields.manageDuty}" class="col-xs-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="managePhone">管理责任人电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managePhone" name="managePhone" value="${vdata.fields.managePhone}" class="col-xs-12 tooltip-error allPhone required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="manageManNum">管理人员人数</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="manageManNum" name="manageManNum" value="${vdata.fields.manageManNum}" class="col-xs-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="otherBelong">其他附属设施</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="otherBelong" name="otherBelong" value="${vdata.fields.otherBelong}" class="col-xs-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" >地图定位</label>
					<div class="col-xs-4 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.fields.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					   </div>
				
					<label id="sss" class="col-xs-2 control-label text-left" for="gridName">网格联系人</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridName" name="gridName" value="${vdata.fields.gridName}" class="col-xs-12 tooltip-error required" />
					</div>
					
						
					
				</div>
				<div class="form-group">
					
					<label id="sss" class="col-xs-2 control-label text-left" for="gridDuty">网格联系人职务</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridDuty" name="gridDuty" value="${vdata.fields.gridDuty}" class="col-xs-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label text-left" for="gridPhone">网格联系人电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridPhone" name="gridPhone" value="${vdata.fields.gridPhone}" class="col-xs-12 tooltip-error required" />
					</div>
					
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-left" for="description">描述</label>
			
					<div class="col-xs-10">
						<textarea type="text" max-length="50"id="description" name="description" class="col-xs-12 tooltip-error required" >${vdata.fields.description }</textarea>
					</div>
					
				</div>
				<div class="form-group">
				<label class="col-xs-2 control-label no-padding-left text-right">附件</label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic" name="seatPicture" value="${map.seat.seatPicture }" />
						</div>
					</div>
				</div>
				</form>
				</div>
				
				
				
			
				<div class="space-4"></div>
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
			
		</div>

	<script type="text/javascript">
	
	$(document).ready(function () {
	
	//如果子页面需要进行图片浏览，必须加上这句-------------
	layer.use('extend/layer.ext.js', function(){
		   layer.ext =function(){};
	}); 
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone=new Dropzone("#dropzoneDiv",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic').val().split(";").length-1
	});
	 getOldPics(dropzone);
	$("#form").validate({
		submitHandler: function (form) {
		 	$('#url_pic').val('');
		 	//获取上传的图片的值
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
	
});
  
</script>
</body>
</html>


