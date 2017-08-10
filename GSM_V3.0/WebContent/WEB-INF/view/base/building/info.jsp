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
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone1=new Dropzone("#dropzoneDiv1",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic1').val().split(";").length-1,
		 	uploadBtnId:'uploadBtn1',
            imgName:'showImg1',
	});
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone2=new Dropzone("#dropzoneDiv2",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic2').val().split(";").length-1,
		 	uploadBtnId:'uploadBtn2',
            imgName:'showImg2',
	});
	//dropzone代表dropzone对象
	//urlPicI表示model中存放上传文件id的那个字段使用的input的id，type 是hidden的
	//showOldImgName表示在组装已经存在的的图片的时候用的img标签的name
	//showOldImgDivId表示用来展示已经存在的图片的div的id
	 getOldPics(dropzone1,"url_pic1","showImg1_old","picDisplay_old1");
	 getOldPics(dropzone2,"url_pic2","showImg2_old","picDisplay_old2");
	$("#form").validate({
		submitHandler: function (form) {
		 	$('#url_pic1').val('');
		 	$('#url_pic2').val('');
		 	//获取上传的图片的值
		 	var ids1='';
		 	var ids2='';
		 	$('[name^=showImg1]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids1+=this.id+";";
		 		}
		 	});
		 	$('[name^=showImg2]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids2+=this.id+";";
		 		}
		 	});
		 	$('#url_pic1').val(ids1);
		 	$('#url_pic2').val(ids2);
			var data = $("#form").serialize();
			var code="${vdata.building.code}";
			data=data+"&code="+code;
			 $.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	parent.successFun("building");
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
						<input type="hidden" max-length="50"id="gridCode" name="gridCode" value="${vdata.building.gridCode}" class="col-xs-12 col-sm-12 tooltip-error required" />
						<input type="text" readonly="readonly" value="${vdata.building.gridTotalName}" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>楼栋名称</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="buildName" name="buildName" value="${vdata.building.buildName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>楼号</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="buildNum" name="buildNum" value="${vdata.building.buildNum }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>楼栋长</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="buildManager" name="buildManager" value="${vdata.building.buildManager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >楼栋长电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="buildManagerPhone" name="buildManagerPhone" value="${vdata.building.buildManagerPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >楼栋性质</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeBuildNature" name="codeBuildNature" value="${vdata.building.codeBuildNature }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >楼栋类型</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeBuildType" name="codeBuildType" value="${vdata.building.codeBuildType }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >排序</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="sort" name="sort" value="${vdata.building.sort }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>地图描边</label>
					<div class="col-xs-10 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.building.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">上传楼栋长照片 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv1' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn1" type="button">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic1" name="buildManagerPhoto" value="${vdata.building.buildManagerPhoto }" />
						</div>
					</div>
				</div>
				<c:if test="${vdata.building.buildManagerPhoto != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存楼栋长照片 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old1" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">上传建筑照片 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv2' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn2" type="button">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic2" name="buildPicture" value="${vdata.building.buildPicture }" />
						</div>
					</div>
				</div>
				<c:if test="${vdata.building.buildPicture != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存建筑照片 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old2" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >描述 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="description" name="description" class="col-xs-12 col-sm-12">${vdata.building.description }</textarea>
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


