<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>社会管理网格化系统V3.0</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include  page="/resource/base_import.jsp"/>
<link rel="stylesheet" href="${base}/resource/js/tip/jquery.toast.css" />
<script src="/GSM_V3.0/resource/js/tip/jquery.toast.js"></script>
<script type='text/javascript' src='${base}/dwr/engine.js'></script>
<script type='text/javascript' src='${base}/dwr/util.js'></script>
 <script type='text/javascript' src='${base}/dwr/interface/SendPush.js'></script>
<style>
 /* 推送信息框及字体样式 */
        .message_push{
          cursor:pointer;width:220px;height:55px;/* text-overflow:ellipsis; overflow:hidden; white-space:nowrap;-o-text-overflow:ellipsis;  */    
        }
        /*连接css样式*/
        .message_push a {
         text-decoration: none;
        }
        /*连接css样式*/
       .message_push a {
        color: #000000; font-size: 13px;
       }
       /*连接css样式*/
	   .message_push a:HOVER {
		text-decoration: underline;
	   }
       /*连接css样式*/
       .message_push a:HOVER {
	     color: red;
       }
       #menuTable1 td,#menuTable1 td{
	       overflow:hidden;
	       text-overflow:ellipsis;
	       white-space:nowrap;
       }
.rootMenuClass{
margin-top: 4px;
min-height:52px;
line-height:12pt;
background:#5EA0C3;
border:1px solid #8EC2DA;
}
.rootMenuClass:hover{
border:1px solid #F99008;
}
.ace-nav .listyle {
    /* border-left: 1px solid #ddd; */
    float: left !important;
    height: 60px;
    line-height: 26px;
    padding: 0;
    position: relative;
    text-align: center;
    cursor: pointer;
    margin-left: 3px;
    margin-right: 3px;
}
.row
{
	margin-right: -12px;
	margin-left: -12px;
	margin-top: -8px;
}

.spinner-preview {
				width:100px;
				height:100px;
				text-align:center;
				margin-top:60px;
			}
			
			.dropdown-preview {
				margin:0 5px;
				display:inline-block;
			}
			.dropdown-preview  > .dropdown-menu {
				display: block;
				position: static;
				margin-bottom: 5px;
			}
</style>


<script>
function cutstr(str, count) {
    if (str != null) {
        if (str.length <= count) {
            return str;
        } else {
            return str.substring(0, count - 2) + "...";
        }
    }
}
</script>
</head>
<body>
<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<img src="${base}/resource/images/qianlogo.png"/>
				</div><!-- /.navbar-header -->
			</div>
			<div class="navbar-header pull-right" role="navigation">
					<ul id="prent"class="nav ace-nav">
					</ul>
			</div>
</div>
<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
	<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large" style="z-index: 999;margin-left: -6px;">
						<!-- <b><center>功能菜单</center></b> -->
							<!-- <button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>
							 -->
							<button class="btn btn-info nav ace-nav dropdown-toggle" data-toggle="dropdown" onclick="viewInformation()" style="width: 176px;">
							    <font size="2px;">通讯箱/(快捷入口)</font>
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success" id="numberSum" title="sdss"></span>
							</button>
							<ul id="mesgtotal" class="pull-left dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close" style="width:190px;margin-top: -20px;height: 200px;overflow: auto;">
								<!-- <li class="dropdown-header">
									<i class="icon-comment"></i>
									8条通知
								</li> -->
								<%-- 
								<li>
									<a href="${base}/im/imessaging/manageLoad" target="mainFrame">
										查看所有消息
										<i class="icon-arrow-right"></i>
									</a>
								</li> --%>
							</ul>
							
						</div>
						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->
                    
					<ul class="nav nav-list" id="menu_nav">
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div><!-- sidebar end -->

			<div class="main-content">
				<div id="breadcrumbs" class="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
	
						<ul id="breadcrumb" class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="/GSM_V3.0/sys/main/index">首页</a>
							</li>
							<li id="a">
<!-- 								<a href="#">综合</a> -->
							</li>
							<li id="b" >
							</li>
						</ul><!-- .breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<iframe src="${base}/sys/main/mainLoad" id="mainFrame" name="mainFrame" scrolling="no" frameborder="0" marginheight="0" marginwidth="0" style=" top: 0px; bottom: 0px; width: 100%; min-height:650px;"></iframe>
						</div><!-- "col-xs-12" -->
					</div><!--row -->
				</div><!-- page-content -->
			</div><!-- main-content-->
				</div><!-- main-container-inner-->
</div><!--main-container -->
				<!-- basic scripts -->


		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="${base}/resource/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${base}/resource/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${base}/resource/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${base}/resource/js/jquery.slimscroll.min.js"></script>
		<script src="${base}/resource/js/jquery.easy-pie-chart.min.js"></script>
		<script src="${base}/resource/js/jquery.sparkline.min.js"></script>
		<script src="${base}/resource/js/flot/jquery.flot.min.js"></script>
		<script src="${base}/resource/js/flot/jquery.flot.pie.min.js"></script>
		<script src="${base}/resource/js/flot/jquery.flot.resize.min.js"></script>

		
		
		<!-- inline scripts related to this page -->
<script type="text/javascript">
var ifToggle=true;
function toggleDiv(code){
	if(ifToggle){
		$(".rootMenuClass").css("border","1px solid #8EC2DA");
		if($("#" + code+"div")[0].style.display=="none"){ 
			$('.top-popup-box').hide();
			$("#" + code).attr("style", "border:1px solid #F99008;");
			$("#" + code+"div").show();
		}else{
			$("#" + code+"div").hide();
		}
	}
	ifToggle=true;
}

function toggleDiv1(code){
	if(ifToggle){
		$(".rootMenuClass").css("border","1px solid #8EC2DA");
		if($("#" + code+"div")[0].style.display!="none"){ 
			$('.top-popup-box').hide();
			$("#" + code).attr("style", "border:1px solid #F99008;");
			$("#" + code+"div").show();
		}else{
			$("#" + code+"div").hide();
		}
	}
	ifToggle=true;
}
var gongGaoDiv='';
jQuery(function($) {
	 $.ajax({
             type: "get", url: '${base}/sys/menu/queryRoot?t=' + +Math.random(), dataType: 'json',
             async: true,
             success: function (data) { 
                 var li = "";
                 for (var i = 0; i < data.length; i++) { 
               	  li += "<li class=\"listyle\" ";
               	   if(data[i].hasHideMenu=="1"){
               		  li+=" onclick=\"toggleDiv('" + data[i].code  + "')\" title=\"" + data[i].menuName + "\">   <div class=\"rootMenuClass\" id=\"" + data[i].code + "\" ><img width=\"51\" height=\"34\" src=\"${base}/upload/" + data[i].picUrl + "\" /><br />  <span  style=\"color: white\">" + cutstr(data[i].menuName, 8) + "</span> </div>";
               		  var showDiv="<div id=\"" + data[i].code  + "div\" class=\"top-popup-box popbg moreMenuList\"> <i></i> <ul class=\"top-classify\">";
               		  $.ajax({
               	            type: "get",
               	            dataType: "json",
               	            async: false,
               	            url: "${base}/sys/menu/queryMenuByParent?parentCode=" + data[i].code  + "&t=" + Math.random(),
               	            success: function (data2) {
               	            	  for (var j = 0; j < data2.length; j++) { 
               	            		  showDiv=showDiv+'<li onclick="menuclick3(\''+ data2[j].code+'\',\''+ data2[j].actionUrl+'\',\''+ data2[j].HEIGHT+'\',\''+ data2[j].LEFTMENU+'\')"><a href="javascript:;"><img src="${base}/upload/' + data2[j].picUrl+'">'+ cutstr(data2[j].menuName, 8)+'</a></li>';
               	            	  }
               	           }
               		  });
               		  showDiv=showDiv+'</ul></div>';
               		  li+=showDiv;
               	  }else{ 
               		  li+=" onclick=\"menuclick('" + data[i].code + "','" + data[i].actionUrl + "','" + data[i].HEIGHT + "','" + data[i].LEFTMENU + "')\"  title='" + data[i].menuName + "'>   <div class=\"rootMenuClass\" id=" + data[i].code + "><img width=\"51\" height=\"34\" src=\"${base}/upload/" + data[i].picUrl + "\" /><br />  <span  style=\"color: white\">" + cutstr(data[i].menuName, 8) + "</span> </div>";
               	   } 
               	li+="</li>";
                 }
                li += "<li class=\" listyle\"  onclick=\"home('/sys/main/home')\" title=\"返回首页\"><div class=\"rootMenuClass\" ><img width=\"51\" height=\"34\" src=\"${base}/upload/fanhui.png\" /><br /><span style=\"color: white\">返回首页</span></li></div>";
               
                $("#prent").append(li);
                
                if ('${vdata.hasHideMenu}'=='true') {
                	
                	toggleDiv1('${vdata.prentcode}');
               
               	 /* 
                    $("#" + '${vata.prentcode}').attr("style", "background:#407CB4;margin-left:2px;  margin-right:2px;");
                
               	   $("#MenuTabpent1").hide();
               	   $("[name=mapFrame]").css({"width":"100%","height":"100%"});
               	   $("[name=mapFrame]").attr("src","${base}/mapLoad" );
                      $("[name=mainFrame]").hide();
                      $("#frame").css({ "top": "0px", "height": "91%" }); */
                 
                } else {
                    menuclick('${vdata.prentcode}', '','','${vata.left}');
               	 
                } 
             }
         });
});
var caChe="";
function getRightContent(liEle,url, code,parent,pparent) {
	if(!code){
		$("#breadcrumb").empty();
		$("#breadcrumb").prepend("<li><i class='icon-home home-icon'></i><a href='/GSM_V3.0/sys/main/index'>首页</a></li>"); 
		$(".active").removeClass("active");
		$(liEle).addClass("active");
		$(liEle).parent().parent().addClass("active");
	    $("[name=mainFrame]").show();
	    $("[name=mainFrame]").attr("src", "${base}/"+url);
		return;
	}
	$.ajax({ 
		type: "get", 
		url: '${base}/sys/menu/queryAllParentMenuByChild?code=' + code,
	     async: true,
	     success: function (data) { 
	    	 $("#breadcrumb").empty();
	    	 if(data.length<5){
	    	 for(var i=0;i<data.length;i++){
		    
		    	 $("#breadcrumb").prepend("<li><a >"+data[i].menuName+"</a></li>"); 
	    	 }
	     }
	    	 $("#breadcrumb").prepend("<li><i class='icon-home home-icon'></i><a href='/GSM_V3.0/sys/main/index'>首页</a></li>"); 
		    	
	     	}
	     });
	if(parent == "0113"||pparent == "0113"){
		$(".active").removeClass("active");
		$(liEle).addClass("active");
		$(liEle).parent().parent().addClass("active");
		$("#mainFrame").contents().find("#partymainFrame").show();
	    $("#mainFrame").contents().find("#partymainFrame").attr("src", "${base}/"+url);
	}else{
		$(".active").removeClass("active");
		$(liEle).addClass("active");
		$(liEle).parent().parent().addClass("active");
	    $("[name=mainFrame]").show();
	    $("[name=mainFrame]").attr("src", "${base}/"+url);
	}
	
}
function home(url) {  
	 window.location.href = "${base}"+url; 
}
function menuclick(code, url_menu, height, hasMore) {  
	 menuclick_common(code, url_menu, height, hasMore,false);
}
function menuclick3(code, url_menu, height, leftmenu){
	ifToggle=false;
	menuclick_common(code, url_menu, height, leftmenu,true);
}
function showBread(menu){
	li1=caChe;
	 li1+="<li><a >"+menu+"</a></li>";
	 $("#breadcrumb").empty();
	 $("#breadcrumb").append(li1); 
}
function menuclick_common(code, url_menu, height, hasMore,ifBackground) {
	var li1="";
	//导航栏
	$.ajax({ 
		type: "get", 
		url: '${base}/sys/menu/queryAllParentMenuByChild?code=' + code,
	     async: true,
	     success: function (data) { 
	    	 $("#breadcrumb").empty();
	    	 var a=1;
		     var b="";
		     var c="";
		     if(data.length<5){
	    	 for(var i=0;i<data.length;i++){
		    
		    	 $("#breadcrumb").prepend("<li><a >"+data[i].menuName+"</a></li>"); 
				 if(a==1){b="<li><a >"+data[i].menuName+"</a></li>";a--;
				 }else{c="<li><a >"+data[i].menuName+"</a></li>";}
	    	 }
		     }
	    	 $("#breadcrumb").prepend("<li><i class='icon-home home-icon'></i><a href='/GSM_V3.0/sys/main/index'>首页</a></li>"); 
	    	 caChe="<li><i class='icon-home home-icon'></i><a href='/GSM_V3.0/sys/main/index'>首页</a></li>"+c+b; 	
	     	}
	     });
    //***
	if(!ifBackground){
		$(".rootMenuClass").css("border","1px solid #8EC2DA");
	}
		$(".top-popup-box").hide();  
		$("#" + code).attr("style", "border:1px solid #F99008;");
    $.ajax({
        type: "get",
        dataType: "json",
        async: true,
        url: "${base}/sys/menu/queryAllChildMenuByParent?parentCode=" + code + "&t=" + Math.random(),
        success: function (data) {
        	/* if(data[0].PARENT == "0113"){	//当为基础党建时，加载以基础党建为主的main界面/
        		$("[name=mainFrame]").attr("src","${base}/sys/menu/partybuildingmainLoad" );
        	  } */
        	var zonghe_li=$('<li class="active" onclick="getRightContent(this,\'/sys/main/mainLoad\')"> <a href="#"> <i class="icon-dashboard"></i> <span class="menu-text"> 总览 </span> </a> </li>');
        	if (data.length!=0) {
            	var menu_nav_ul=$('#menu_nav');
            	menu_nav_ul.empty();
            	menu_nav_ul.append(zonghe_li);
            	var ul_2;
            	var ul_3;
            	var li_2;
            	var li_1;
            	var pre_level=1;
               for(var i=0;i<data.length;i++){
            		   if(data[i].level==1){
            			   if(pre_level==3){
            				   li_2.append(ul_3);
            				   ul_2.append(li_2);
            				   li_1.append(ul_2);
            				   menu_nav_ul.append(li_1);
            			   }else  if(pre_level==2){
            				   li_1.append(ul_2);
            				   menu_nav_ul.append(li_1);
            			   }
            			   //如果url_menu的值是空的证明它还有下级菜单，此时应该有class和向下的箭头
            			   if(data[i].isleaf=='0'){
            				   li_1=$('<li><a href="#" class="dropdown-toggle" onclick="showBread(\''+data[i].menuName+'\')"><span class="menu-text"> '+data[i].menuName+'</span><b class="arrow icon-angle-down"></b></a></li>');
            				   ul_2=$('<ul class="submenu"></ul>');
            			   }else{
            				   
            					  
            					   li_1=$('<li onclick="getRightContent(this,\''+data[i].actionUrl+'\',\''+data[i].code+'\',\''+data[i].PARENT+'\',\''+data[i].PPARENT+'\')"><a href="#"><span class="menu-text"> '+data[i].menuName+'</span></a></li>');
                				   menu_nav_ul.append(li_1);
            				   
            				   
            			   }
            			   pre_level=1;
            		   }else if(data[i].level==2){
            			   if(pre_level==3){
            				   li_2.append(ul_3);
            				   ul_2.append(li_2);
            			   }
            			   if(data[i].isleaf=='0'){
            				   li_2=$('<li> <a href="#" class="dropdown-toggle"> <i class="icon-double-angle-right"></i> '+data[i].menuName+' <b class="arrow icon-angle-down"></b></a> </li>');
            				   ul_3=$('<ul class="submenu"></ul>');
            			   }else{
            				   if('81DB52CC2FEE4A3DA24243EFABFC70BB'!=data[i].code)
            					   //机构成员管理中因权限问题所以隐藏菜单没啥卵用
            				   {
            				   li_2=$('<li onclick="getRightContent(this,\''+data[i].actionUrl+'\',\''+data[i].code+'\',\''+data[i].PARENT+'\',\''+data[i].PPARENT+'\')"> <a href="#"> <i class="icon-double-angle-right"></i> '+data[i].menuName+' </a> </li>');
            				   ul_2.append(li_2);
            				   }
            			   }
            			   pre_level=2;
            			   if(i==data.length-1){//如果是最后一条数据
            				   li_1.append(ul_2);
            				   menu_nav_ul.append(li_1);
            			   }
            		   }else if(data[i].level==3){//暂且只写到三层
            			   ul_3.append('<li onclick="getRightContent(this,\''+data[i].actionUrl+'\',\''+data[i].code+'\',\''+data[i].PARENT+'\',\''+data[i].PPARENT+'\')"> <a href="#"> '+data[i].menuName+'</a> </li>');
            			   pre_level=3;
            			   if(i==data.length-1){//如果是最后一条数据
            				   li_2.append(ul_3);
            				   ul_2.append(li_2);
            				   
            				   li_1.append(ul_2);
            				   menu_nav_ul.append(li_1);
            			   }
            		   }
            	   }
            	}
            else {
                $("#frame").css({  "height": "" + height + "%" });
                if (code == "0012") {
                	   $("#MenuTabpent1").hide();
                	   $("#MenuTabpent").hide();
                	   $("[name=mapFrame]").show();
                	   //如果已经加载过了，就不让它加载了
                	   if(!$("[name=mapFrame]").attr("src")){
                		   $("[name=mapFrame]").css({"width":"100%","height":"100%"});
                    	   $("[name=mapFrame]").attr("src","${base}/mapLoad" );
                	   }
                    $("[name=mainFrame]").hide();
                    $("#frame").css({ "height": "91%" });
                }else { //menuTabclick(url_menu); 
                }
            }
        }
    });
    }
    
	<%
	  com.dykj.GSM.model.SessionModel model = com.dykj.GSM.utils.MySession.getInfo();
	%>
	function onPageLoad(){
	    SendPush.onPageLoad("<%=model.getCode()%>","<%=model.getDepartmentCode()%>","<%=model.getRoleCode()%>");
	}
	$(document).ready(function () {
		 dwr.engine.setActiveReverseAjax(true);  
		 dwr.engine.setNotifyServerOnPageUnload(true);
		 dwr.engine.setErrorHandler(function() {
		 }); 
		 onPageLoad(); 
	});
	//推送信息
	var i = 1
	 function showMessage(autoMessage){
		 var data = eval("(" + autoMessage + ")");
		var ii = mainFrame.window.windowIsOpen(data.sendUserCode);
		if(ii == 404){
			if($("#numberSum").text()==""){
				$("#numberSum").text("新消息") 
			}		   
			i+=1;
			$.toast({ 
				  heading:"<font size=\"1.5\" color=\"green\">"+data.userName+"：向你发送了一条信息</font>",
				  text : data.text, 
				  showHideTransition : 'slide',
				  bgColor : '#438EB9',
				  textColor : '#eee',
				  allowToastClose : true,
				  hideAfter : 10000,
				  stack : 10,
				  textAlign : 'center',
				  position : 'bottom-right',
				  icon: 'info'
			})
			$.ajax({
			      type: "post", 
			      url: '${base}/im/imessaging/MessageStackNum',
			      data : {"sendMsgUserName":data.userName,"sendMsgUserCode":data.sendUserCode},
			      dataType: 'json',
			      async: true,
			      success: function (data) {
			    	 
			      }
			 });
		}else if(ii == 200){
			mainFrame.window.mychildFun(autoMessage);
		} 
	 }
	function viewInformation(){
		$('ul[id="mesgtotal"] li').remove();
		$.ajax({
		      type: "post", 
		      url: '${base}/im/imessaging/queryStatisticalTotal',
		      dataType: 'json',
		      async: true,
		      success: function (data) {
		    	  if(data.length!=0){
		    		  for(var i=0 ;i<data.length;i++){
		    			  var value = data[i].sendMsgUserCode;
		    			  $("#mesgtotal").append("<li id="+data[i].sendMsgUserCode+" onclick=\"openChatWindow(this.id,'"+data[i].sendMsgUserName+"')\"><a href=\"#\"><div class=\"clearfix\"><span class=\"pull-left\"><i class=\"btn btn-xs no-hover btn-pink icon-comment\"></i>"+data[i].sendMsgUserName+"</span><span class=\"pull-right badge badge-info\">+"+data[i].sendMsgNum+"</span></div></a></li>")
		    		  }
		    	  }else{
		    		  $("#numberSum").text("") 
		    	  }
		      }
		 });
	}
	function openChatWindow(value,value1){
		mainFrame.window.windowSomeoneIsOpen(value,value1);
	}
	//显示公告提示框
	 function showGongGaoMessage(autoMessage){
		var data=eval("(" + autoMessage + ")");
		$.toast({ 
				  heading:"<h2>公告通知</h2>",
				  text :"<a href='javascript:void(0)' onclick='openGongGaoDetail(\""+data.code+"\",this)'>"+data.title+"</a></div>", 
				  showHideTransition : 'slide',
				  bgColor : '#438EB9',
				  textColor : '#eee',
				  allowToastClose : false,
				  hideAfter : 100000,
				  stack : 10,
				  textAlign : 'left',
				  position : 'bottom-right',
				  icon: 'info'
			});
	 }
	function openGongGaoDetail(code,a){
		$(a).parent().slideUp();
		 bootbox.dialog({
				url:"${base}/sys/rnotice/infoSee?code="+code,
				title: "公告信息",
				style:'width:800px;height:500px;',
				showFunctionBtn:false,
				});
	}
	
	//显示事件/矛盾信息
	 function showEventMes(autoMessage){
		var data=eval("(" + autoMessage + ")");
		$.toast({ 
				  heading:"<h2>"+data.type+"待办提醒</h2>",
				  text :"<a href='javascript:void(0)' onclick='openEventDetail(\""+data.type+"\",\""+data.code+"\",\""+data.stepId+"\",\""+data.entryId+"\",\""+data.eventTitle+"\",this)'>"+data.eventTitle+"</a></div>", 
				  showHideTransition : 'slide',
				  bgColor : '#438EB9',
				  textColor : '#eee',
				  allowToastClose : false,
				  hideAfter : 100000,
				  stack : 10,
				  textAlign : 'left',
				  position : 'bottom-right',
				  icon: 'info'
			});
	 }
	function openEventDetail(type,code,stepId,entryId,title,a){
		$(a).parent().slideUp();
		var url="econtradict";
		if(type!='矛盾'){
			url="eevent";
		}
		bootbox.dialog({
			 url:"${base}/event/"+url+"/approvalLoad?eventCode="+code+"&stepId="+stepId+"&entryId="+entryId,
			  title: title+"处理表",
			  iframeStyle:'height:1500px;',
			  showFunctionBtn:false,
			  style:'width:1000px;height:600px;'
			});
	}
</script>
</body>
</html>

