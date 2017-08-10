<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<link href="/GSM_V3.0/resource/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/GSM_V3.0/resource/css/font-awesome.min.css">
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
});
</script>
</head>
<body>
<div class="row">
<div class="widget-header widget-header-flat">
				<div class="col-sm-11">
										<div class="widget-box ">
											<div class="widget-header">
												<h4 class="lighter smaller">
													<i class="icon-comment blue"></i>
													会话												</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<div class="dialogs">
														<div class="itemdiv dialogdiv">
															<div class="user">
																<img alt="Alexa's Avatar" src="${base}/resource/images/avatars/avatar1.png" />															</div>

															<div class="body">
																<div class="time">
																	<i class="icon-time"></i>
																	<span class="green">4秒钟前</span>																</div>

																<div class="name">
																	<a href="#">Alexa</a>																</div>
																<div class="text">大家好啊</div>

																<div class="tools">
																	<a href="#" class="btn btn-minier btn-info">
																		<i class="icon-only icon-share-alt"></i>																	</a>																</div>
															</div>
														</div>

														<div class="itemdiv dialogdiv">
															<div class="user">
																<img alt="John's Avatar" src="${base}/resource/images/avatars/avatar.png" />															</div>

															<div class="body">
																<div class="time">
																	<i class="icon-time"></i>
																	<span class="blue">38秒以前</span>																</div>

																<div class="name">
																	<a href="#">John</a>																</div>
																<div class="text">框架很好用嘛</div>

																<div class="tools">
																	<a href="#" class="btn btn-minier btn-info">
																		<i class="icon-only icon-share-alt"></i>																	</a>																</div>
															</div>
														</div>

														<div class="itemdiv dialogdiv">
															<div class="user">
																<img alt="Bob's Avatar" src="${base}/resource/images/avatars/user.jpg" />															</div>

															<div class="body">
																<div class="time">
																	<i class="icon-time"></i>
																	<span class="orange">2分钟以前</span>																</div>

																<div class="name">
																	<a href="#">Bob</a>
																	<span class="label label-info arrowed arrowed-in-right">admin</span>																</div>
																<div class="text">欢迎大家使用ACE后台管理系统.</div>

																<div class="tools">
																	<a href="#" class="btn btn-minier btn-info">
																		<i class="icon-only icon-share-alt"></i>																	</a>																</div>
															</div>
														</div>

														<div class="itemdiv dialogdiv">
															<div class="user">
																<img alt="Jim's Avatar" src="${base}/resource/images/avatars/avatar4.png" />															</div>

															<div class="body">
																<div class="time">
																	<i class="icon-time"></i>
																	<span class="grey">3分钟以前</span>																</div>

																<div class="name">
																	<a href="#">Jim</a>																</div>
																<div class="text">大家多提提BUG</div>

																<div class="tools">
																	<a href="#" class="btn btn-minier btn-info">
																		<i class="icon-only icon-share-alt"></i>																	</a>																</div>
															</div>
														</div>

														<div class="itemdiv dialogdiv">
															<div class="user">
																<img alt="Alexa's Avatar" src="${base}/resource/images/avatars/avatar1.png" />															</div>

															<div class="body">
																<div class="time">
																	<i class="icon-time"></i>
																	<span class="green">4分钟以前</span>																</div>

																<div class="name">
																	<a href="#">Alexa</a>																</div>
																<div class="text">继续支持ACE后台系统</div>

																<div class="tools">
																	<a href="#" class="btn btn-minier btn-info">
																		<i class="icon-only icon-share-alt"></i>																	</a>																</div>
															</div>
														</div>
													</div>

													<form>
														<div class="form-actions">
															<div class="input-group">
																<input placeholder="Type your message here ..." type="text" class="form-control" name="message" />
																<span class="input-group-btn">
																	<button class="btn btn-sm btn-info no-radius" type="button">
																		<i class="icon-share-alt"></i>
																		发送																	</button>
																</span>															</div>
														</div>
													</form>
												</div><!-- /widget-main -->
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div>
		</div>
	</div>

</body>
</html>


