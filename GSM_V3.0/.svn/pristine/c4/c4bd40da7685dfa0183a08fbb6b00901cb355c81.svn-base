	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
<jsp:include  page="/resource/base_import.jsp"/>

<script type="text/javascript">
$(function(){
	
	$("[name=girdCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
	});
	
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
	
});
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
<!-- 			<h2 class="text-center">组织生活</h2> -->
			<input type="hidden" name="code" value="${vdata.partyOrganizationalife.code }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区/部门</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="gridCode" name="gridCode" value="${vdata.partyOrganizationalife.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName"><span class="red">*</span>活动主题</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="titleName" name="titleName" value="${vdata.partyOrganizationalife.titleName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleName">负责人/召集人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="responsibleName" name="responsibleName" value="${vdata.partyOrganizationalife.responsibleName }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleRange">活动的人员范围</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="responsibleRange" name="responsibleRange" value="${vdata.partyOrganizationalife.responsibleRange }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleLocation">活动地点</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="responsibleLocation" name="responsibleLocation" value="${vdata.partyOrganizationalife.responsibleLocation }" class="col-xs-12 col-sm-12 " />
					</div>
					
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>活动开始时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="beginTime" value="${vdata.partyOrganizationalife.beginTime }"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="orgPersons"><span class="red">*</span>参加活动人数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="orgPersons" name="orgPersons" value="${vdata.partyOrganizationalife.orgPersons }" class="col-xs-12 col-sm-12 tooltip-error required number" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="massesPersons"><span class="red">*</span>党员参与人数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="massesPersons" name="massesPersons" value="${vdata.partyOrganizationalife.massesPersons }" class="col-xs-12 col-sm-12 tooltip-error required number" />
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="responsibleSituation">活动开展情况</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="responsibleSituation" name="responsibleSituation" value="${vdata.partyOrganizationalife.responsibleSituation }" class="col-xs-12 col-sm-12 " />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>活动结束时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="endTime" value="${vdata.partyOrganizationalife.endTime }"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				
				<div class="form-group">
				<label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
					   <div class="col-xs-10 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.partyOrganizationalife.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					   </div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="contents">活动内容</label>
					<div class="col-xs-10">
						<div class="clearfix">
							<textarea id="contents" name="contents" class="col-xs-12 col-sm-12">${vdata.partyOrganizationalife.contents }</textarea>
						</div>
					</div>
				</div>
					
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="description">备注 </label>
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="description" name="description" class="col-xs-12 col-sm-12">${vdata.partyOrganizationalife.description }</textarea>
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
