<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>社会管理网格化系统V3.0</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="${base}/resource/css/loginBase.css" rel="stylesheet" type="text/css" />
        <link href="${base}/resource/css/login.css" rel="stylesheet" type="text/css" /> 
		<jsp:include page="/resource/base_import.jsp"/>
<script type="text/javascript">

document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
                
     if(e && e.keyCode==13){ // enter 键
    	 login();
    }
}; 

function login(){
	if(($("#yz").attr("class") == "login-success")){ 
	var data = $("#loginForm").serialize();
	$.ajax({
		type: "post", 
		url: "/GSM_V3.0/sys/user/userlogin", 
		data: data,
		dataType: "json",
	    async: false,
	    success: function (data) {
	        	if(data.status){
                    $("#show_user_msg").html("<span style='color:green'>验证成功！</span>");
                    
                   // window.open("/gsm/home", "", "fullscreen=0,menubar=0,toolbar=0,directories=0,location=0,status=0,scrollbars=0");
                    window.location.href = "/GSM_V3.0/sys/main/home"; 
                    /* window.location.href = "/GSM_V3.0/home"; */
                   
                 // CloseWebPage();
	        	}else{
	        		//alert(data.info);
	        		  $("#show_user_msg").html("<span style='color:red'>用户名或密码错误！</span>");
	        		  $("#yz").css("display","inline");
	        		  $("#yz").attr("class","login-fail");
	        		  changeImg();
	        		  return false;
	        		//$("#checkCodeImg").attr("src","${base }/checkCode?r="+Math.random());
	        	}
	      
	    }
	});
  }else{
	  $("#show_user_msg").html("<span style='color:red'>验证码错误！</span>");
	 
  } 
}
//验证码触发事件
$(function(){
	$('#validateCode').keyup(function(){
			yanzheng();
		
		});
});
//验证验证码
function yanzheng(){
	 var data = $("#loginForm").serialize();    
	$.ajax({
		type: "post", 
		url: "/GSM_V3.0/resultServlet/validateCode", 
		data: data,
		dataType: "json",
	    async: false,
	    success: function (data) {
	    	
	        	if(data.status){
	        		$("#yz").css("display","inline");
                     $("#yz").attr("class","login-success"); 
                     $("#show_user_msg").html("<span style='color:green'>验证成功！</span>");
	        	} else{
	        		$("#yz").css("display","inline");
	        		$("#yz").attr("class","login-fail");
	        		
	        		 $("#show_user_msg").html("<span style='color:red'>验证码错误！</span>");
	        	} 
	      
	    }
	});
}
//点击图片更改验证码
function changeImg(){
	
    var imgSrc = $('#imgObj');    
    var src = imgSrc.attr("src"); 
    var url = chgUrl(src);
    imgSrc.attr("src",url);  
    
}    
//更新URL
function chgUrl(url){     
    urlurl = url.substring(0,25);    
        urlurl = urlurl +"?t="+Math.random();    
    return urlurl;
}
/* $(function () {
	 $('#formbackground').height($(window).height());
	 $('#formbackground').width($(window).width());
	
    
    $(document).keydown(function(event){
		 if(event.keyCode==13){
			$("#login").focus();
		 	$("#login").click();
		 }
		 }); 
    });
function windowclose() {
    
    var browserName = navigator.appName;
    if (browserName == "Netscape") {
        window.open('', '_self', '');
        window.close();
    }
    else {
        if (browserName == "Microsoft Internet Explorer") {
            window.opener = "whocares";
            window.opener = null;
            window.open('', '_top');
            window.close();
        }
    }
}



function CloseWebPage() {

    if (navigator.userAgent.indexOf("MSIE") > 0) {
        if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
            window.opener = null; window.close();
        }
        else {
            //  window.open('', '_top'); window.top.close();
           
            window.opener = null;
            window.open('about:blank', '_self', '');
            window.close();
        }
    }
    else if (navigator.userAgent.indexOf("Firefox") > 0) {
        window.location.href = 'about:blank '; //火狐默认状态非window.open的页面window.close是无效的  
        window.history.go(-2);   
    }
    else {
      
        window.opener = null;
        window.open('about:blank', '_self', '');
        window.close();
    }
}
 */
</script>
</head>
<body >

<div class="login-hengtiao">
  <div class="Main">
    <div class="logo"><img src="${base}/resource/images/login/login_03.png"></div>
    <div class="login-from">
     <form id="loginForm" name="loginForm" method="post" action="${base}/sys/user/userlogin" style="text-align:center;">
      <label id="show_user_msg" style="height:21px;display:block;margin-top: 5px;"></label>
        <label for="textfield"></label>
        <table width="290" border="0" align="right" cellpadding="0" cellspacing="16">
          <tr>
            <td><input type="text" name="username" id="login_name" style='padding-left:35px;' class="login-int login-user" />
               <input type="password" name="password" id="login_pwd" style='padding-left:35px;margin-top:5px;'class="login-int login-pa" />
               <div style="margin-top: 5px;" ><a href="#" onclick="changeImg()">
               <img id="imgObj"style="height:28.8px;width:102px;display: inline;vertical-align: bottom;border-radius: 4px 0px 0px 4px !important;border: 1px solid;"  alt="" src="/GSM_V3.0/captcha-image"/></a> 
               <input id="validateCode" name="validateCode" type="text" style="width:55px; border-radius:0px 4px 4px 0px !important;" /> <img id="yz"  src="${base}/upload/yanzheng.png" style="display:none; vertical-align: bottom;" class='login-fail'/>
               </div>
              </td>
            <td><a type="submit"  class="login-btn" onclick="login()" /><button type="reset" class="login-btn" value="Reset">登录</button></a></td>
          </tr>
          <!-- <tr>
            <td>
               <input type="checkbox" onclick="saveCookie()" id="checkboxID"/><span class="login-rembtext">记住账号</span>
            </td>
          </tr> -->
        </table>
        <div class="login-text" style="color:#0097bb;text-align:left;">  技术支持：<a href="http://www.tsdykj.com" target="_blank">唐山市达意科技有限公司</a> <br />
      温馨提示：<a target="_Blank"  href="http://www.firefox.com.cn/">为显示最好效果，请使用火狐浏览器进行访问</a> 
  </div>
      </form>
    </div>
    <div style="position: absolute; left: 70px; top: 25px;"><img src="${base}/resource/images/login/login_07.png"></div>
   <!-- <div class="login-text"><img src="images/login/login_07.gif" width="322" height="13" /></div>-->
  
  </div>
</div>
</body>
</html>