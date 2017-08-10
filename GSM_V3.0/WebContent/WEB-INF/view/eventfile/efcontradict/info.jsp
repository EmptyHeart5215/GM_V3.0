	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/gsm/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<%--  <jsp:include page="/resource/js/uploadify/imgOperator.jsp"/> --%>
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	$("[name=gridCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
	});
	$("[name=codeDocumnetType]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_DOCUMNET_TYPE',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone1=new Dropzone("#dropzoneDiv1",{
		   url: function(){
	           return "${base}/sys/sysupload/upload";
	       },
		   existedFiles:$('#url_pic1').val().split(";").length-1,
		   uploadBtnId:'uploadBtn1',
           imgName:'showImg1',
           acceptedFiles: "image/*,application/pdf,.psd,.obj,.txt,.xls,.html,.doc,.ppt,.docx,.zip",
           maxFilesize: 100,//最大文件大小，MB
           maxFiles:1
	});
	//dropzone代表dropzone对象
	//urlPicI表示model中存放上传文件id的那个字段使用的input的id，type 是hidden的
	//showOldImgName表示在组装已经存在的的图片的时候用的img标签的name
	//showOldImgDivId表示用来展示已经存在的图片的div的id
	getOldPics(dropzone1,"url_pic1","showImg1_old","picDisplay_old1");
	$("#form").validate({
		submitHandler: function (form) {
			$('#url_pic1').val('');
		 	//获取上传文件的值
		 	var ids1='';
		 	$('[name^=showImg1]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids1+=this.id+";";
		 		}
		 	});
		 	var array = new Array();
			array = returnValue();
		 	$('#url_pic1').val(ids1);
		 	
			if(typeof(array[2]) == "undefined"){
				array[2] = 0;
				$("#documentSize").attr("value",array[2]);
			}else{
				$("#documentSize").attr("value",array[2]);
			}
			if(array[1] != null){
				$("#documentName").val(array[1]);
			}
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
			<input type="hidden" name="code" value="${vdata.efcontradict.code }" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.efcontradict.gridCode}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					
				</div>
				
					
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="id"><span class="red">*</span>编号</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="id" name="id" value="${vdata.efcontradict.id}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
					<label class="col-xs-2 control-label no-padding-right text-right" for="gridNum"><span class="red">*</span>网格编码</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="gridNum" name="gridNum" value="${vdata.efcontradict.gridNum}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeEventType"><span class="red">*</span>矛盾纠纷级别</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeEventType" name="codeEventType" value="${vdata.efcontradict.codeEventType}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
					<label class="col-xs-2 control-label no-padding-right text-right" for="contradictions">是否重大矛盾纠纷 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="2"id="contradictions" name="contradictions" value="${vdata.efcontradict.contradictions}" class="col-xs-12 col-sm-12 " />
						</div>
					</div>
				
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="contradictionsSituation"><span class="red">*</span>主要问题</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="contradictionsSituation" name="contradictionsSituation"  class="col-xs-12 col-sm-12 tooltip-error required">${vdata.efcontradict.contradictionsSituation}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="contradictionsParty">纠纷当事人情况</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="contradictionsParty" name="contradictionsParty"  class="col-xs-12 col-sm-12 ">${vdata.efcontradict.contradictionsParty}</textarea>
						</div>
					</div>
				</div>
								
				<div class="form-group">	
					<label class="col-xs-2 control-label no-padding-right text-right" for="contradictionsDate"><span class="red">*</span>矛盾排查时间 </label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="contradictionsDate" value="${vdata.efcontradict.contradictionsDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="resolveDate"><span class="red">*</span>完成时限</label>
			
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required " name="resolveDate" value="${vdata.efcontradict.resolveDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
											
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="takeName"><span class="red">*</span>收集人</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="takeName" name="takeName" value="${vdata.efcontradict.takeName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					
				    <label class="col-xs-2 control-label no-padding-right text-right" for="problemName"><span class="red">*</span>责任人 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="problemName" name="problemName" value="${vdata.efcontradict.problemName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					
				</div>
				
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="problemUnit"><span class="red">*</span>责任部门</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="problemUnit" name="problemUnit" value="${vdata.efcontradict.problemUnit}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="stabilityName"><span class="red">*</span>稳控责任人 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="stabilityName" name="stabilityName" value="${vdata.efcontradict.stabilityName}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="stabilityMeasure">采取措施</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="stabilityMeasure" name="stabilityMeasure" class="col-xs-12 col-sm-12">${vdata.efcontradict.stabilityMeasure}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="supervisionDuty"><span class="red">*</span>督办单位</label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="supervisionDuty" name="supervisionDuty" value="${vdata.efcontradict.supervisionDuty}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="supervisionPerson"><span class="red">*</span>督办人 </label>
			
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50"id="supervisionPerson" name="supervisionPerson" value="${vdata.efcontradict.supervisionPerson}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
				</div>
								
			 	<div class="form-group">
					   <label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
			
					   <div class="col-xs-4 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.efcontradict.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					</div>
				
				<label class="col-xs-2 control-label no-padding-right text-right" for="registerDate"><span class="red">*</span>登记时间 </label>
						<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="registerDate" value="${vdata.efcontradict.registerDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					   </div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="problemResolution">问题化解情况</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="problemResolution" name="problemResolution"  class="col-xs-12 col-sm-12 ">${vdata.efcontradict.problemResolution}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="feedBake">群众反馈意见</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="feedBake" name="feedBake"  class="col-xs-12 col-sm-12 ">${vdata.efcontradict.feedBake}</textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">上传矛盾照片 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv1' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn1" type="button">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic1" name="contradictPhoto" value="${vdata.efcontradict.contradictPhoto }" />
						</div>
					</div>
				</div>
				<c:if test="${vdata.efcontradict.contradictPhoto != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存矛盾照片 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old1" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>
			
				
	
				
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="mrmark">备注</label>
					<div class="col-xs-10">
					<div class="clearfix">
						<textarea max-length="50"id="mrmark" name="mrmark"  class="col-xs-12 col-sm-12 ">${vdata.efcontradict.mrmark}</textarea>
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

