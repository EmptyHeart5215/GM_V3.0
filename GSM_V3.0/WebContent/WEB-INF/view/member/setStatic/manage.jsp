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
	iFrameHeight(parent.document.getElementById("mainFrame"));
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
	//dropzone代表dropzone对象
	//urlPicI表示model中存放上传文件id的那个字段使用的input的id，type 是hidden的
	//showOldImgName表示在组装已经存在的的图片的时候用的img标签的name
	//showOldImgDivId表示用来展示已经存在的图片的div的id
	 getOldPics(dropzone1,"url_pic","showImg_old","picDisplay_old");
	var url="";
	
		$("#form").validate({
			submitHandler: function (form) {
			 	$('#url_pic').val('');
			 	//获取上传的图片的值
			 	var ids1='';
			 	$('[name^=showImg]').each(function(i){
			 		if(this.id&&$.trim(this.id)!=''){
			 			ids1+=this.id+";";
			 		}
			 	});
				var data = $("#form").serialize();
				 $.ajax({
					type : "post",
					url : "${base}/"+url+"?t="+Math.random(),
					data : data,
					dataType : 'json',
					async : false,
					success : function(data) {
			            if(data.status){
			            	scroll(0,0);
			            	document.getElementById("form").reset();
			            	bootbox.slideAlert('body',true,data.info);
			            }else{ 
			            	bootbox.slideAlert('body',false,data.info);
			             } 
					}
				});
	        }
		});
	
	//父窗口中的提交按钮
	$("#acceptBtn").bind("click",function(){
		top.document.documentElement.scrollTop = top.document.body.scrollTop =0;
		 url="/event/eevent/eventaccept";
		$("#form").submit(); 
	});
	//父窗口中的提交按钮
	$("#draftBtn").bind("click",function(){
		top.document.documentElement.scrollTop = top.document.body.scrollTop =0;
		url="/event/eevent/adddraft";
		$("#form").submit();
	});
});

</script>
</head>
<body>
<div class="row">

		<div class="col-xs-12" id="body">
		
			<form class="form-horizontal" role="form" id="form">
				<input type="hidden" name="code" value="${vdata.event.code }" />
				
				
				<nav class="navbar navbar-default" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">民情日记</a>
   </div>
   <div>
      <p class="navbar-text">分数设置</p>
   </div>
</nav>
			<br>	
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>初始分数</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="gridCode=""" value="${vdata.event.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>最高分数</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="codeEventType" value="${vdata.event.codeEventType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>少一篇扣分</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="eventTitle" value="${vdata.event.eventTitle }" class="col-xs-12 col-sm-12 tooltip-error required"  />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>多一篇加分</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="eventTitle" value="${vdata.event.eventTitle }" class="col-xs-12 col-sm-12 tooltip-error required"  />
					</div>
				</div>
				<br>
				<nav class="navbar navbar-default" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">巡查走访</a>
   </div>
   <div>
      <p class="navbar-text">分数设置</p>
   </div>
</nav> 
				<br>	
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>初始分数</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="gridCode=""" value="${vdata.event.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>最高分数</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="codeEventType" value="${vdata.event.codeEventType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>完成走访加分</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="eventTitle" value="${vdata.event.eventTitle }" class="col-xs-12 col-sm-12 tooltip-error required"  />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>未完成走访扣分</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="eventTitle" value="${vdata.event.eventTitle }" class="col-xs-12 col-sm-12 tooltip-error required"  />
					</div>
				</div>
				
				
				<br>
								<nav class="navbar navbar-default" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">矛盾联动化解</a>
   </div>
   <div>
      <p class="navbar-text">分数设置</p>
   </div>
</nav>
			<br>	
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>初始分数</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="gridCode=""" value="${vdata.event.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>最高分数</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="codeEventType" value="${vdata.event.codeEventType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>完成一件事加分</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="eventTitle" value="${vdata.event.eventTitle }" class="col-xs-12 col-sm-12 tooltip-error required"  />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>少完成一件事扣分</label>
					<div class="col-xs-3">
						<input type="text" max-length="50"name="eventTitle" value="${vdata.event.eventTitle }" class="col-xs-12 col-sm-12 tooltip-error required"  />
					</div>
				</div>
				<br>
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
			</form>
		
		<div class="col-xs-10" style="text-align:right;padding-right:4px;">
			<button  id="acceptBtn" type="button" class="btn btn-success">保存</button>
		</div>
		</div>
	</div>
</body>
</html>


