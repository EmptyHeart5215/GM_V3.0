<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include  page="/resource/base_import.jsp"/>
<title>Insert title here</title>
<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${base}/resource/js/typeahead-bs2.min.js"></script>

<script src="${base}/resource/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${base}/resource/js/jquery.ui.touch-punch.min.js"></script>
<script src="${base}/resource/js/markdown.min.js"></script>
<script src="${base}/resource/js/bootstrap-markdown.min.js"></script>
<script src="${base}/resource/js/jquery.hotkeys.min.js"></script>
<script src="${base}/resource/js/bootstrap-wysiwyg.min.js"></script>


<script src="/GSM_V3.0/resource/js/bootstrap-wysihtml5/jquery.base64.js"></script>
<link rel="stylesheet" href="${base}/resource/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${base}/resource/css/ace-skins.min.css" />
<script type="text/javascript">
jQuery(function($){
	
	function showErrorAlert (reason, detail) {
		var msg='';
		if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
		else {
			console.log("error uploading file", reason, detail);
		}
		$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
		 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
	}
	$('#editor1').ace_wysiwyg({
		toolbar:
		[
			{name:'font', className:'btn-info',title:'字体'},
			null,
			{name:'fontSize', className:'btn-info',title:'字体大小'},
			null,
			{name:'bold', className:'btn-info',title:'加粗'},
			{name:'italic', className:'btn-info',title:'斜体'},
			{name:'strikethrough', className:'btn-info',title:'中划线'},
			{name:'underline', className:'btn-info',title:'中划线'},
			null,
			{name:'foreColor', className:'btn-success',title:'字体颜色'},
			null,
			{name:'undo', className:'btn-grey',title:'撤销'},
			{name:'redo', className:'btn-grey',title:'重置'},
			null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,
			null,
			null,
			null,
			/* {name:'insertunorderedlist', className:'btn-success',title:'无序列表'},
			{name:'insertorderedlist', className:'btn-success',title:'有序列表'},
			{name:'outdent', className:'btn-purple',title:'凸出'},
			{name:'indent', className:'btn-purple',title:'缩进'}, */
			null,
			/* {name:'justifyleft', className:'btn-primary',title:'左对齐'},
			{name:'justifycenter', className:'btn-primary',title:'居中对齐'},
			{name:'justifyright', className:'btn-primary',title:'右对齐'},
			{name:'justifyfull', className:'btn-inverse',title:'两端对齐'}, */
			null,
			/* {name:'createLink', className:'btn-pink',title:'插入链接'},
			{name:'unlink', className:'btn-pink',title:'拆开'}, */
			null,
			//{name:'insertImage', className:'btn-success',title:'插入图片'},
			
		],
		'wysiwyg': {
			fileUploadError: showErrorAlert
		}
	}).prev().addClass('wysiwyg-style2');


	

	//Add Image Resize Functionality to Chrome and Safari
	//webkit browsers don't have image resize functionality when content is editable
	//so let's add something using jQuery UI resizable
	//another option would be opening a dialog for user to enter dimensions.
	if ( typeof jQuery.ui !== 'undefined' && /applewebkit/.test(navigator.userAgent.toLowerCase()) ) {
		
		var lastResizableImg = null;
		function destroyResizable() {
			if(lastResizableImg == null) return;
			lastResizableImg.resizable( "destroy" );
			lastResizableImg.removeData('resizable');
			lastResizableImg = null;
		}

		var enableImageResize = function() {
			$('.wysiwyg-editor')
			.on('mousedown', function(e) {
				var target = $(e.target);
				if( e.target instanceof HTMLImageElement ) {
					if( !target.data('resizable') ) {
						target.resizable({
							aspectRatio: e.target.width / e.target.height,
						});
						target.data('resizable', true);
						
						if( lastResizableImg != null ) {//disable previous resizable image
							lastResizableImg.resizable( "destroy" );
							lastResizableImg.removeData('resizable');
						}
						lastResizableImg = target;
					}
				}
			})
			.on('click', function(e) {
				if( lastResizableImg != null && !(e.target instanceof HTMLImageElement) ) {
					destroyResizable();
				}
			})
			.on('keydown', function() {
				destroyResizable();
			});
	    }
		
		enableImageResize();
	}
	$(".msg").attr("id","msg"+'${vdata.userCode}')
	$.ajax({
	      type: "post", 
	      url: '${base}/im/imessaging/queryMessageTenMini',
	      data : {"userCode":'${vdata.userCode}',"sendUserCode":'${vdata.sendUserCode}'},
	      dataType: 'json',
	      async: true,
	      success: function (data) {
	    	if(data.length!=0){
	    		for(var i=0 ;i<data.length;i++){
		    		if(data[i].originalText!=null){
		    			$("#msg${vdata.userCode}").append("<div class=\"dialogs\"><div class=\"itemdiv dialogdiv\"><div class=\"body\" style=\"margin-left:0px;\"><div class=\"time\" style=\"margin-top:5px;\"><i class=\"icon-time\"></i><span class=\"green\">"+data[i].createDate+"</span></div><div class=\"name green\">"+data[i].userName+"</div><div class=\"text\">"+data[i].text+"</div></div></div></div>");
		    		}else{
		    			$("#msg${vdata.userCode}").append("<div class=\"dialogs\"><div class=\"itemdiv dialogdiv\"><div class=\"body\" style=\"margin-left:0px;\"><div class=\"time\" style=\"margin-top:5px;\"><i class=\"icon-time\"></i><span class=\"blue\">"+data[i].createDate+"</span></div><div class=\"name blue\">"+data[i].userName+"</div><div class=\"text\">"+data[i].text+"</div></div></div></div>");
		    		}
		    	}
	    		$("#msg${vdata.userCode}").append("<li style=\"list-style-type:none;\"><font color=\"#987cb9\"><span style=\"margin-left:40%;\">以上是历史记录&nbsp;&nbsp;&nbsp;<i class=\"glyphicon glyphicon-hand-up blue\"></i></span></li></br>")
	    	}
	    	  
	      }
	 });
	
	$("body").keydown(function(event) {
        if (event.keyCode == "13" && event.ctrlKey) {//keyCode=13是回车键
        	
        }else if(event.keyCode == "13"){
        	event.preventDefault();
        	Send();
        }
    });
  
});
Date.prototype.Format = function(fmt){ //author: meizz   
		var o = {   
				"M+" : this.getMonth()+1,                 //月份   
				"d+" : this.getDate(),                    //日   
				"h+" : this.getHours(),                   //小时   
				"m+" : this.getMinutes(),                 //分   
				"s+" : this.getSeconds(),                 //秒   
				"q+" : Math.floor((this.getMonth()+3)/3), //季度   
				"S"  : this.getMilliseconds()             //毫秒   
				};   
				if(/(y+)/.test(fmt))   
					fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
				for(var k in o)   
				if(new RegExp("("+ k +")").test(fmt))   
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
			return fmt;   
}
function Close(){
	parent.removeTab("#7F8B407ABDA246F89E7109BF5755E5AD");
}
var iii = 0;
function Send(){
	var text = $("#editor1").wysiwyg();
	originalText = text[0].innerText
	text = text[0].innerHTML
	if(originalText != ""){
		if(originalText!='\n'){
			var nameText = '${vdata.logName}';
			var	userCode = '${vdata.userCode}';
			var sendUserCode = '${vdata.sendUserCode}';
			$.ajax({
			      type: "post", 
			      url: '${base}/im/imessaging/iMessagePush',
			      data : {"text":text,"userName":nameText,"originalText":originalText,"userCode":userCode,"sendUserCode":sendUserCode},
			      dataType: 'json',
			      async: true,
			      success: function (data) {
			    	  iii++;
			    	 if(data.status){
			    		 $("#editor1").text("");
			    		    var dd = new Date();
			    		    var n = dd.getTime();
			    		    var datetime = new Date(n).Format("yyyy-MM-dd hh:mm:ss");
			    		    var html = $("#msg${vdata.userCode}").html();
			    		   /*  var msg = "{\"code\":\"\",\"createBy\":\"\",\"createDate\":\"\",\"date1\":\"\",\"departmentCode\":\"\",\"dicValueMap\":null,\"flagDel\":\"0\",\"flagDisplay\":\"0\",\"gridTotalName\":\"\",\"originalText\":\"\",\"remark\":\"\",\"roleCode\":\"\",\"searchEndTime\":\"\",\"searchStartTime\":\"\",\"seatGrid\":null,\"sendUserCode\":\"3F633C8BCE26435F97490499C5EF1ABE\",\"sort\":0,\"text\":\23456789\",\"userCode\":\"D154F40A3C4E4E79B8F02D09411923A1\",\"userName\":\"testwg(redarmychen)\"}";
			    		    chchildFun(msg) */
			    		$("#msg${vdata.userCode}").append("<div class=\"dialogs\"><div class=\"itemdiv dialogdiv\"><div class=\"body\" style=\"margin-left:0px;\"><div class=\"time\" style=\"margin-top:5px;\"><i class=\"icon-time\"></i><span class=\"green\">"+datetime+"</span></div><div class=\"name green\">"+nameText+"</div><div class=\"text\">"+text+"</div></div></div></div>");
			    		 $("#msg${vdata.userCode}").scrollTop( $("#msg${vdata.userCode}")[0].scrollHeight );
			    	 }
			      }
			 });
		}else{
			parent.tip();
		}
	}else{
		parent.tip();
	}
}

function chchildFun(msgs){
	var data = eval("(" + msgs + ")");
	var dd = new Date();
	var n = dd.getTime();
	var datetime = new Date(n).Format("yyyy-MM-dd hh:mm:ss");
	$("#msg"+data.sendUserCode).append("<div class=\"dialogs\"><div class=\"itemdiv dialogdiv\"><div class=\"body\" style=\"margin-left:0px;\"><div class=\"time\" style=\"margin-top:5px;\"><i class=\"icon-time\"></i><span class=\"blue\">"+datetime+"</span></div><div class=\"name blue\">"+data.userName+"</div><div class=\"text\">"+data.text+"</div></div></div></div>");
	$("#msg"+data.sendUserCode).scrollTop( $("#msg"+data.sendUserCode)[0].scrollHeight );
	
}

//是否显示历史记录窗口
var messageRecord=function(){
	var temp = $("#msgRecordBody").is(":hidden");
	if(temp){
		$.ajax({
		      type: "post", 
		      url: '${base}/im/imessaging/queryMessageRecord',
		      data : {"userCode":'${vdata.userCode}',"sendUserCode":'${vdata.sendUserCode}'},
		      dataType: 'json',
		      async: true,
		      success: function (data) {
		    	
		    	if(data.length!=0){
		    		for(var i=0 ;i<data.length;i++){
			    		if(data[i].originalText!=null){
			    			$("#msgRecord").append("<li style=\"list-style-type:none;\"><font color=\"green\">"+data[i].userName+" "+data[i].createDate+"</font><br/>"+data[i].text+"</li></br>")
			    		}else{
			    			$("#msgRecord").append("<li style=\"list-style-type:none;\"><font color=\"blue\">"+data[i].userName+" "+data[i].createDate+"</font><br/>"+data[i].text+"</li></br>")
			    		}
			    	}
		    		$("#msgRecord").append("<li style=\"list-style-type:none;\"><font color=\"#987cb9\">-------以上是历史记录-------</li></br>")
		    		 $('#msgss').scrollTop( $('#msgss')[0].scrollHeight );
		    	}
		    	  
		      }
		 });
		$(".col-sm-12").removeClass("col-sm-12").addClass("col-sm-8");
		$("#msgRecordBody").show();
	}else{
		$(".col-sm-8").removeClass("col-sm-8").addClass("col-sm-12");
		$("#msgRecordBody").hide();
		$('ul[id="msgRecord"] li').remove();
		$('ul[id="msgRecord"] br').remove();
	}
};
</script>
</head>
<body>
   <div class="col-sm-12">
	<div class="widget-box ">
		<div class="widget-header">
			<h4 class="lighter smaller">
				<i class="icon-comment blue"></i>
				会话
			</h4>
		</div>
		<div class="widget-body">
			<div id="" class="widget-main no-padding msg" style="height: 290px;width:100%;overflow-y:auto;">
			 </div><!-- /widget-main -->
		   </div><!-- /widget-body -->
	     </div><!-- /widget-box -->
	     <div class="widget-box">
				<!-- <div class="widget-header"></div> -->
				    <div class="widget-body">
						<div class="widget-main wysiwyg-editor" id="editor1" style="height: 70px;"></div>
					</div>
					<div class="widget-header widget-header-flat">
						<div class="widget-toolbar">
							<button class="btn btn-xs btn-info" style="margin-top: 4px;margin-right: 20px;" onclick="Send()">
							发送<i class="icon-arrow-right icon-on-right"></i>
							</button>
							<button class="btn btn-xs btn-info" data-rel="tooltip" title="Default" style="margin-top: 4px;margin-right: 20px;" onclick="messageRecord()">
								<i class="glyphicon glyphicon-search"></i>消息记录
							</button>
							<button class="btn btn-xs btn-info" style="margin-top: 4px;margin-right: 20px;" onclick="Close()">
								<i class="icon-bolt bigger-110"></i>关闭
							</button>
					   </div>
				  </div>
		     </div>
      </div><!-- /span -->
		<div class="col-sm-4" style="display: none;" id="msgRecordBody"> 
			<div class="widget-box">
				<div class="widget-header">
					<h5 id="titlename">历史记录</h5><font size="1" color="orange">（当前系统支持查询当前一周内的聊天记录）</font>
				</div>
				<div id="msgss" class="widget-body" style="height:477px;overflow-y:auto;">
					<div class="widget-main no-padding">
						<ul id="msgRecord"></ul>
					</div>
				</div>
			</div>
		</div>
</body>
</html>