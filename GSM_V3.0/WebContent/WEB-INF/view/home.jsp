<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html">
<html>
<head>
       <%-- <jsp:include page="/resource/base_import.jsp"/>  --%>
       <link href="${base}/resource/css/home/index.css" rel="stylesheet" type="text/css" />
       <link href="${base}/resource/css/home/base.css" rel="stylesheet" />
       <link href="${base}/resource/css/home/home.css" rel="stylesheet" />
      <!--  <script src="/gsm/resource/js/jquery-1.8.2.js" type="text/javascript"></script> -->
       <script src=${base}/resource/js/jquery-2.0.3.min.js></script>

<style>
    
        a:link {
            text-decoration: none;
            color: #ffffff;
        }

        a:visited {
            text-decoration: none;
            color: #ffffff;
        }

        a:hover {
            text-decoration: none;
            color: #ffffff;
        }

        a:active {
            text-decoration: none;
            color: #ffffff;
        }

        .pwddiv {
            width: 400px;
            height: 362px;
            background: #ffffff;
            border: 1px solid #AEC9EA;
            margin: 0 auto;
            position: absolute;
            top: 200px;
            left: 33%;
            text-align: center;
           -webkit-border-radius: 8px;

-moz-border-radius: 8px;

border-radius: 8px;

-webkit-box-shadow: #666 0px 0px 10px;

-moz-box-shadow: #666 0px 0px 10px;

box-shadow: #666 0px 0px 10px;
        }

        .h2style {
            color: #32497c;
            font-size: 14px;
            text-align: center;
            background: #5A92C7;
            height: 50px;
            line-height: 50px;
            position: relative;
        }

            .h2style img {
                position: absolute;
                top: 5px;
                right: 15px;
            }

        .ulstyle {
            width: 280px;
            padding: 25px 0 0 70px;
        }

        .listyle {
            width: 262px;
            border: 1px solid #AEC9EA;
            margin-bottom: 10px;
            border-top-left-radius:0.5em;
		    border-top-right-radius:0.5em;
		    border-bottom-left-radius:0.5em;
		    border-bottom-right-radius:0.5em;
        }

        .last {
            margin-top: -5px;
            width: 262px;
        }

        .inputstyle {
            width: 190px;
            height: 40px;
            text-indent: 10px;
            line-height: 40px;
            
        }
        .labelstyle {
            color: #3b3b3b;
            font-size: 12px;
/*             margin-right: 10px; */
            border-right: 1px solid #666666;
            padding-right: 10px;
            text-indent: 3px;
        }

        #sub {
		    width:180px;
		    text-align:center;
		    line-height:100%;
		    padding-top:0.5em;
		    padding-right:2em;
		    padding-bottom:0.55em;
		    padding-left:2em;
		    font-family:Arial;
		    font-size:14px;
		    font-style:normal;
		    font-variant:normal;
		    font-weight:normal;
		    text-decoration:none;
		    cursor:pointer;
		    border-top-left-radius:0.5em;
		    border-top-right-radius:0.5em;
		    border-bottom-left-radius:0.5em;
		    border-bottom-right-radius:0.5em;
		    box-shadow:0px 1px 2px rgba(0,0,0,0.2);
		    text-shadow:0px 1px 1px rgba(0,0,0,0.3);
		    color:#fefee9;
		    border-top-color:#1E90FF;
		    border-right-color:#1E90FF;
		    border-bottom-color:#1E90FF;
		    border-left-color:#1E90FF;
		    border-top-width:1px;
		    border-right-width:1px;
		    border-bottom-width:1px;
		    border-left-width:1px;
		    border-top-style:solid;
		    border-right-style:solid;
		    border-bottom-style:solid;
		    border-left-style:solid;
		    background-color:#6495ED;
        }
		#sub:hover {
		    background: #00BFFF;
		}

       .descriptiondiv {
            position: relative;
            width: 25%;
            height: 410px;
            border: 8px solid #5C96D5;
            float: left;
            top:115px;
            left:15%;
            /*margin: 0 auto;*/
            /*top:30px;*/
        }

        .descriptionh2 {
            position: absolute;
            /*left:147px;*/
            top: 12px;
            color: #003445;
            font-size: 20px !important;
            font-weight: bold;
            z-index: 10;
        }

        .descriptionimg {
            width: 60px;
            height: 60px;
            position: absolute;
            top: 50px;
            left: 14px;
            z-index: 1;
        }

        .descriptionp {
            position: absolute;
            /* left: 90px; */
            top: 48px;
            text-indent: 28px;
            font-size: 14px;
            z-index: 2;
            line-height: 35px;
            display: block;
            /* width: 295px; */
            color: #c9dcf4;
        }
        .weakest{background: url("${base}/resource/images/weakest.jpg") no-repeat;width:20px;height:15px;}
        .weak{background: url("${base}/resource/images/weak.jpg") no-repeat;width:20px;height:15px;}
        .middle{background: url("${base}/resource/images/middle.jpg") no-repeat;width:20px;height:15px;}
        .strong{background: url("${base}/resource/images/strong.jpg") no-repeat;width:20px;height:15px;}
        .imgdiv {
             width:120px; 
             height:120px; 
              

             text-align:center; 
             padding-top:15px;
          }
    
    
    
    </style>

 <script>
    
 $(document).ready(function () {

             $.ajax({
                url: '${base}/sys/menu/queryRoot?t=' + +Math.random(), dataType: 'json',
                async: false,
                success: function (data) {
                	var left = 0;
                    var li = "<li>";
                    for (var i = 0; i < data.length; i++) {
                        //if (data[i].code != "0428" && data[i].code != "0154") {
                        	
                   if(data.length%3==0){     
                         if((i+1)%3==0){
                        	           if(i==(data.length-1)){
                        		                           li += "<a class=\"main_a\" href=\"#\"  onmousemove=\"showdescription('" + data[i].menuName + "','" + data[i].picUrl + "','" + data[i].remark + "')\" onclick=\"OpenHref('" + data[i].code + "','" + left + "','"+data[i].hasHideMenu+"')\"><div class=\"imgdiv\" id=\"imgdiv_"+i+"\"><img  src=\"${base}/upload/"+data[i].picUrl+"\"  /></div><span>" + data[i].menuName + "</span></a></li>";
                        	                        }else{
                        	                               li += "<a class=\"main_a\" href=\"#\" onmousemove=\"showdescription('" + data[i].menuName + "','" + data[i].picUrl + "','" + data[i].remark + "')\" onclick=\"OpenHref('" + data[i].code + "','" + left + "','"+data[i].hasHideMenu+"')\"><div class=\"imgdiv\" id=\"imgdiv_"+i+"\"><img  src=\"${base}/upload/"+data[i].picUrl+"\"  /></div><span>" + data[i].menuName + "</span></a></li><li>";
                        	                             }
                                       }else{
                                       li += "<a class=\"main_a\" href=\"#\" onmousemove=\"showdescription('" + data[i].menuName + "','" + data[i].picUrl + "','" + data[i].remark + "')\" onclick=\"OpenHref('" + data[i].code + "','" + left + "','"+data[i].hasHideMenu+"')\"><div class=\"imgdiv\" id=\"imgdiv_"+i+"\"><img  src=\"${base}/upload/"+data[i].picUrl+"\"  /></div><span>" + data[i].menuName + "</span></a>";
                                       }
                  }else{
                    	  if((i+1)%3==0){
                         	             li += "<a class=\"main_a\" href=\"#\"  onmousemove=\"showdescription('" + data[i].menuName + "','" + data[i].picUrl + "','" + data[i].remark + "')\" onclick=\"OpenHref('" + data[i].code + "','" + left +"','"+data[i].hasHideMenu+"')\"><div class=\"imgdiv\" id=\"imgdiv_"+i+"\"><img  src=\"${base}/upload/"+data[i].picUrl+"\"  /></div><span>" + data[i].menuName + "</span></a></li><li>";
                                   }else{
                                         li += "<a class=\"main_a\" href=\"#\" onmousemove=\"showdescription('" + data[i].menuName + "','" + data[i].picUrl + "','" + data[i].remark + "')\" onclick=\"OpenHref('" + data[i].code + "','" + left + "','"+data[i].hasHideMenu+"')\"><div class=\"imgdiv\" id=\"imgdiv_"+i+"\"><img  src=\"${base}/upload/"+data[i].picUrl+"\"  /></div><span>" + data[i].menuName + "</span></a>";
                                        }
                    	  if(i==(data.length-1)){
                         	                 li += "</li>";
                    	                    }
                      }
                        
                                           
                        //    }  
                    }
                    //   li+="<li class=\"w120\"><a class=\"home_btn\"  href=\"/login.aspx\">	<div class=\"color_hui home_system_back\"><img style=\"margin: 30px 0 0 37px;\" src=\"/App_Themes/NewStyle/Images/home/home_12.png\" width=\"45\" height=\"46\" />  </div> <h2>退出系统</h2> <img class=\"home_biankuang\" src=\"/App_Themes/NewStyle/Images/home/biankuang_2.png\" /> </a></li>";
                    $("#menu").append(li);
                   /*  $("img").attr('style',' padding-top:22px;'); */
                    for(var i = 0; i<data.length;i++){
                    	$("#imgdiv_"+i).find('img').attr('style',' padding-top:22px;');
                        $("#imgdiv_"+i).attr('style','background:url(/GSM_V3.0/upload/home_0'+(i+1)+'.png) top center no-repeat; background-size:cover;');
                    }
                }
            });

            $.ajax({
                type: "post", url: '${base}/sys/user/userManage', dataType: 'text',
                async:false,
                success: function (data) {
                    if (data == "") {
                        window.location.href = "${base}/sys/user/login";
                    }
                    else {              
                        data = eval("(" + data + ")");
                        $("#uername").html(data.realName);
                        $("#user_code").val(data.code);
                        name = data.name;
                        picurl = data.USER_PIC;
                        $("#userpic").attr("src", "/uploads/picture/" + data.user_pic);
                    }
                } 
            });
            });

        function showdescription(name, img, remark) {
            $("#descriptiondiv").html("	<h2 class=\"descriptionh2\">" + name + "</h2><p class=\"descriptionp\">" + remark + "</p>");
        }
        function ssetpwd() {
            $("#pwddiv").toggle(500);
            //diagopen("/PlatForm/RUserSetPwdInfo.aspx", "修改密码");
            divhide();
        }
        function divshow() {
            $("#gongju").toggle(500);
        }
        function divhide() {
            $("#gongju").hide(500);
        }
        
        
        
        function OpenHref(SysId, left, hasHideMenu) {
            
            var usercode = $("#user_code").val();
            document.write("<form action=index method=post name=formx1 style='display:none'>");
            document.write("<input type=hidden name=prentcode value='" + SysId + "'/>");
            document.write("<input type=hidden name=user_code value='" + usercode + "'/>");
            document.write("<input type=hidden name=user_name value='" + name + "'/>");
            document.write("<input type=hidden name=imgurl value='" + picurl + "'/>");
            document.write("<input type=hidden name=left value='" + left + "'/>");
            document.write("<input type=hidden name=hasHideMenu value='" + hasHideMenu + "'/>");
            document.write("</form>");
            document.formx1.submit();

//     		 location.href="index?prentcode="+SysId+"&left="+left;
        }
        
        
        
    </script>
    
    <script type="text/javascript">
        function save() {
        	var pwd_old = $("#pwd_old").val();//当前密码
        	var pwd_new = $("#pwd_new").val();//新密码
        	var pwd_new_again = $("#pwd_new_again").val();//确认密码
        	if(pwd_old==""||pwd_new==""||pwd_new_again==""){
        		$("#validate_msg").html("<span style='color:red'>输入框有空值，请填写完整！</span>");
        	}else{
        		if(pwd_new!=pwd_new_again){
        			$("#validate_msg").html("<span style='color:red'>两次密码输入不一致，请重新输入！</span>");
        			$("#pwd_new").val("");//两次输入不一致清除输入框
            		$("#pwd_new_again").val("");//两次输入不一致清除输入框
            		$("#pwd_new").focus();//默认到id为 pwd_new 的输入框位置
            	}else{
            		//用jquery的post提交表单
                    var data = $("#SetPwd").serialize();
                    $.ajax({
                        type: "post", 
                        url: "${base}/sys/user/setPwd",
                        data: data, 
                        dataType: 'json', 
                        async: false,
                        success: function (data) {
            	        	if(data.status==true){
            	        		$("#validate_msg").html("<span style='color:green'>密码修改成功，请关闭修改页面！</span>");
            	        		$("#pwd_old").val("");
            	        		$("#pwd_new").val("");    //当密码修改成功以后则清除输入框中的值。
            	        		$("#pwd_new_again").val("");
            	        		$("#pwd_old").focus();//密码修改成功后默认到id为 pwd_old 的输入框位置，即：当前密码处。
            	        		$("#pwStrength").removeClass('weakest');
                    			$("#pwStrength").removeClass('middle');
                    			$("#pwStrength").removeClass('strong');
                    			$("#pwStrength").removeClass('weak');
            	        	}else{
            	        		//当“当前密码”为空或者填写的与当前密码有误时，则出现此提示。
            	        		$("#validate_msg") .html("<span style='color:red'>当前密码输入不存在，请重新输入</span>");
            	        	}
            	      
            	         }
                    });
            	}
        	}
        	
        }
    </script>
    
  
</head>

<body>  
       <div class="pwddiv" id="pwddiv" style="position: absolute; z-index: 20; display: none;">
        <form id="SetPwd">
            <h2 class="h2style">修改密码
                <img src="/GSM_V3.0/resource/images/home/close.png" style="cursor: pointer" alt="" onclick="ssetpwd()" /></h2>
            <ul class="ulstyle" style="list-style-type: none;">
                <li class="listyle">
                    <label for="so" class="labelstyle">当前密码</label><input style="border: none; border: 1px solid none;" class="inputstyle" type="password" id="pwd_old" name="pwd_old" />
                </li>
                <li class="listyle">
                    <label class="labelstyle" for="new-possword">新 密 码 </label>
                    <input style="border: none; border: 1px solid none;" class="inputstyle" type="password" id="pwd_new" name="pwd_new" value=""  onKeyUp=keyup(this.value) onBlur=k(this.value)/> 
                </li>
                <li class="listyle">
                    <label class="labelstyle" for="again-possword">再次输入</label>
                    <input style="border: none; border: 1px solid none; height: 40px; text-indent: 10px; line-height: 40px; width: 185px;" type="password" id="pwd_new_again" name="pwd_new_again" value="" />
                </li>
                <li id = "msg">
                   <div id="validate_msg" style="width: 265px;height: 35px;align="center">
                   </div>
                </li>
                <li class="last">

                    <input id="sub" name="提交" type="button" value="保存" onclick="save()" />
                </li>
            </ul>
        </form>
    </div>

   <div class="subject">
     <div class="header"> <img src="${base}/resource/images/home/home_01.png"> 
       <div class="user">
            <input type="text" style="display: none" id="user_code" />
            <table border="0" cellspacing="0" cellpadding="0" style="font-size: 12px;color: white;">
                <tr>
<!--                    <td style="cursor: pointer; width: 30px" onclick="diagopen('/PagesOperate/EventManage/EEventApprovalHomeManage.aspx', '事件待办')">
                        <div style="width: 18px; height: 18px; background: #f00; color: #FFF; position: absolute; margin-left: 18px; margin-top: -5px; line-height: 18px; text-align: center ;-webkit-border-radius:8px; -moz-border-radius: 8px; border-radius: 8px; -webkit-box-shadow: #447CB5 0px 0px 10px; -moz-box-shadow: #447CB5 0px 0px 10px; box-shadow: #447CB5 0px 0px 10px;display:none"
                            id="eventcont">
                        </div>
                        <img src="../App_Themes/NewStyle/Images/home/newmanage.png" style="height:22px" />

                    </td>-->
                    <td style="cursor: pointer; width: 30px" onclick="divshow()">
                        <img src="${base}/resource/images/home/shezhi.png" /></td>
                    <td bgcolor="#0542a0" style="padding: 0 10px;" id="uername"></td>
                    <td bgcolor="#0542a0" style="padding: 0 8px 0 0;">
<!--                         <img id="userpic" -->
<!--                             width="27" height="27" /> -->
                    </td>

                </tr>
                
                  <tr style="display: none" id="gongju">
                    <td>
                        <div style="position: absolute; width: 100%; background: #0026ff">
                            <ul style="text-align: center">
                                <li style="cursor: pointer; list-style-type:none;" onclick="ssetpwd()"><span class="span">修改密码</span></li>
                                <li style="list-style-type:none;"><a href="\gsm\upload\android\MaxGSM.apk" style='text-decoration:none;' target="mainFrame"><span class="span">下载APP</a></li>
                                <li style="list-style-type:none;"><a target="_parent" href="${base}/logout" style='text-decoration:none;'><span class="span">退出系统</span></a></li>
                            </ul>
                        </div>
                    </td>
                </tr>

            </table>
        </div> 
      </div>
                
                
                
  <div class="main">
  <div class="descriptiondiv" id="descriptiondiv">


                <h2 class="descriptionh2">网格化社会管理系统</h2>
               <!--  <img src="/GSM_V3.0/resource/images/home/gsm.png" alt="" class="descriptionimg" /> -->
                <p class="descriptionp">
                    将抽象的空间信息可视化、直观化，通过合理的地理编码、网格规划，分层叠加分类信息，构建系统基础信息系统。
                </p>

            </div>
  <ul class="menu" id="menu">
            </ul>
    <!-- <ul>
      <li><a href="" class="main_a"><span>基础信息系统</span></a>
          <a href="" class="main_b"><span>部门及地方系统</span></a> 
          <a href="" class="main_c"><span>地理信息系统</span></a></li>
      <li><a href="" class="main_d"><span>视联网系统</span></a> 
          <a href="" class="main_e"><span>综治考核系统</span></a> 
          <a href="" class="main_f"><span>综治培训系统</span></a></li>
      <li><a href="" class="main_g"><span>文件查询系统</span></a> 
          <a href="" class="main_h"><span>办公自动化系统</span></a> 
          <a href="" class="main_i"><span>基运维管理科系统</span></a></li>
    </ul> -->
  </div>
  <div class="footer">
    <p>温馨提示：为显示最好效果，请使用火狐浏览器进行访问</p>
  </div>
</div>
</body>
</html>