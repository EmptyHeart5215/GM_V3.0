<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.Calendar"%>
<%@page import="com.opensymphony.workflow.loader.ActionDescriptor"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.workflow.loader.WorkflowDescriptor"%>
<%@page import="java.util.Map"%>
<%@page import="com.dykj.GSM.model.event.EEvent" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include  page="/resource/base_import.jsp"/>
	<head>
	<%
	Map<String,Object> vdata=(Map<String,Object>)request.getAttribute("vdata");
	WorkflowDescriptor Wfd=(WorkflowDescriptor)vdata.get("WorkflowDescriptor");	
	List actions= Wfd.getInitialActions();
	 ActionDescriptor ad = (ActionDescriptor)actions.get(0);   
    %>
		<meta charset="utf-8" />
<script type="text/javascript">
var url="";
$(function(){
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
			$('#url_pic').val(ids1);
			$('#actionID').val('<%=ad.getId()%>');
			var data = $("#form").serialize();
			 $.ajax({
				type : "post",
				url : "${base}/"+url+"?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	parent.successFun();
		            }else{ 
		            	$('.modal-body',parent.document)[0].scrollTop =0;
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
		<jsp:include page="infoinclude.jsp"></jsp:include>
		<div class="col-xs-12" style="text-align:right;padding-right:4px;">
			<button owner="${vdata.userCode}#1" ActionName="<%=ad.getName() %>"  id="acceptBtn" actionID=<%=ad.getId() %> type="button" class="btn btn-success">受理</button>
			<button  id="draftBtn" type="button" class="btn btn-info">暂存</button>
		</div>
		</div>
	</div>
</body>
</html>


