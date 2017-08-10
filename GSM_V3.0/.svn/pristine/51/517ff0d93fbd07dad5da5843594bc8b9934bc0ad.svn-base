<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<%-- <jsp:include  page="/resource/base_import.jsp"/> --%>
<link href="${base}/resource/js/tab/bootstrap.min.css?v=4.3.0" rel="stylesheet">
<link href="${base}/resource/js/tab/font-awesome.min.css?v=4.3.0" rel="stylesheet">
<link href="${base}/resource/js/tab/animate.min.css" rel="stylesheet">
<link href="${base}/resource/js/tab/style.min.css?v=3.2.0" rel="stylesheet">
<link rel="stylesheet" href="${base}/resource/css/font-awesome.min.css" />
<link rel="stylesheet" href="${base}/resource/css/font-awesome.min.css" />
<link rel="stylesheet" href="${base}/resource/js/tab/gritter/jquery.gritter.css" />
<script type="text/javascript">
function mychildFun(msg){
	var data = eval("(" + msg + ")");
	var sendUserCode = data.sendUserCode;
	window.frames["iframe"+sendUserCode+""].chchildFun(msg);
}
//检测聊天窗口是否打开
function windowIsOpen(sendUserCode){
	var winNum = $("#content-main iframe").length;
	if(winNum!=1){
		var ifnames = new Array();
		for(var i=0;i<winNum;i++){
			var iframe = $("#content-main iframe")[i];
			var ifname = iframe.name;
			ifnames[i] = ifname.substring(6);
		}
		var result= $.inArray(sendUserCode, ifnames);
		if(result == -1){
			return '404'
		}else{
			return '200'
		}
	}else{
		return '404';
	}
}
//检测某一聊天窗口是否打开
function windowSomeoneIsOpen(sendUserCode,sendUserName){
	var winNum = $("#content-main iframe").length;
	
	if(winNum!=0){
		var ifnames = new Array();
		for(var i=0;i<winNum;i++){
			var iframe = $("#content-main iframe")[i];
			var ifname = iframe.name;
			ifnames[i] = ifname.substring(6);
		}
		var result= $.inArray(sendUserCode, ifnames);
		if(result == -1){
			var winNum = $("#tabspage a").length;
			var iframeNum = $("#content-main iframe").length;
			var anames = new Array();
			var iframenames = new Array();
			if(winNum!=0){
				for(var i=0;i<winNum;i++){
					var as = $("#tabspage a")[i];
					$(as).removeClass("active J_menuTab").addClass("J_menuTab");
				}
			}
			if(iframeNum!=0){
				for(var i=0;i<iframeNum;i++){
					var iframe = $("#content-main iframe")[i];
					$(iframe).css("display","none")
				}
			}
			$("#tabspage").append("<a class=\"active J_menuTab\" data-id=\"/GSM_V3.0/im/imessaging/turnToIMSee?userCode="+sendUserCode+"&nameText="+sendUserName+"\" href=\"javascript:;\">"+sendUserName+"<i class=\"fa fa-times-circle\"></i></a>");
			$("#content-main").append("<iframe class=\"J_iframe\" style=\"display: inline;\" name=\"iframe"+sendUserCode+"\" width=\"100%\" height=\"100%\" src=\"${base}/im/imessaging/turnToIMSee?userCode="+sendUserCode+"&nameText="+sendUserName+"\" data-id=\"/GSM_V3.0/im/imessaging/turnToIMSee?userCode="+sendUserCode+"&nameText="+sendUserName+"\" frameborder=\"0\"  seamless></iframe>");
		}
	}
}

function tip(){
	$.gritter.add({
		title: '提示',
		text: '不能发送空消息',
		sticky: false,
		time: '',
		class_name: 'gritter-error gritter-center',
	});
}
</script>
</head>
<body class="fixed-sidebar full-height-layout">
    <div id="wrapper" class="row" style="width: 100%;height: 100%">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                  <li style="margin-left:15px;margin-top: 10px;height: 32px;border-bottom: 2px solid rgb(79, 153, 198);border-right: 1px solid rgb(238, 238, 238);">
                     <span class="nav-label" style="margin-left: 8px;"><i class="fa fa-users"></i>&nbsp;&nbsp;通讯菜单</span>
                  </li>
                    <%-- <li id="li01">
                        <a href="javascript:void(0)">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">唐山市</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul id="li01ul" class="nav nav-second-level">
                            <li id="">
								
							</li>
                            <li>
                                <a class="J_menuItem" id="3F633C8BCE26435F97490499C5EF1ABE" href="${base}/im/imessaging/turnToIMSee?userCode=3F633C8BCE26435F97490499C5EF1ABE&nameText=testwg(redarmychen)" data-index="3F633C8BCE26435F97490499C5EF1ABE">testwg(redarmychen)</a>
                            </li>
                            <li>
                                <a class="J_menuItem" id="EFCEC852527C4EF9AE0D8B316B8758D9" href="${base}/im/imessaging/turnToIMSee?userCode=EFCEC852527C4EF9AE0D8B316B8758D9&nameText=wodewg1(二狗子)" data-index="EFCEC852527C4EF9AE0D8B316B8758D9">wodewg1(二狗子)</a>
                            </li>
                        </ul>
                    </li> --%>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content"  id="tabspage">
                        <a href="javascript:void(0);" class="active J_menuTab" data-id="${base}/im/imessaging/indexLoad">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭 其他选项卡</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row J_mainContent" id="content-main" style="width: 100%;height: 90%">
                <iframe class="J_iframe" name="iframe00000000" width="100%" height="100%" src="${base}/im/imessaging/indexLoad" frameborder="0"  seamless></iframe>
            </div>
        </div>
    </div>
    <script src="${base}/resource/js/tab/jquery-2.1.1.min.js"></script>
    <script src="${base}/resource/js/tab/bootstrap.min.js?v=3.4.0"></script>
    <%-- <script src="${base}/resource/js/tab/jquery.metisMenu.js"></script> --%>
    <script src="${base}/resource/js/tab/jquery.slimscroll.min.js"></script>
    <script src="${base}/resource/js/tab/layer.min.js"></script>
    <script src="${base}/resource/js/tab/gritter/jquery.gritter.min.js"></script>
    <!-- 自定义js -->
    <script src="${base}/resource/js/tab/hplus.min.js?v=3.2.0"></script>
   <script src="${base}/resource/js/tab/contabs.min.js"></script>

    <!-- 第三方插件 -->
    <script src="${base}/resource/js/tab/pace/pace.min.js"></script>
<script type="text/javascript">
/* function closeOrOpen(vals){
	alert(vals)
	if($("#"+vals).hasClass('active')){
		$("#"+vals).removeClass("active");
		var id = $('#'+vals+' ul').attr("id")
		$("#"+id).removeClass("nav nav-third-level collapse in")
		$("#"+id).addClass("nav nav-third-level collapse")
		("#"+id).attr("aria-expanded",false);
	}else{
		$("#"+vals).addClass("active");
		var id = $('#'+vals+' ul').attr("id")
		$("#"+id).addClass("nav nav-third-level collapse in")
		$("#"+id).attr("aria-expanded",true);
	}
} */
;(function($, window, document, undefined) {
	$.ajax({
	      type: "post", 
	      url: '${base}/im/imessaging/queryImUserByGridCode',
	      dataType: 'json',
	      async: false,
	      success: function (data) {
	    	  var secondLevelLis = new Array();
	    	  var thirdLevelLis = new Array();
	    	  var fourLevelLis = new Array();
	    	  var fiveLevelLis = new Array();
	    	  var si = 0;
	    	  var ti = 0;
	    	  var fi = 0;
	    	  var fii = 0;
	    	for(var i =0;i<data.length;i++){
	    		  if(data[i].code == '01'){
	    			  $("#side-menu").append("<li id=\"li"+data[i].code+"\"><a style=\"background: rgb(165, 200, 224) none repeat scroll 0% 0%;\" href=\"${base}/im/imessaging/indexLoad\"><i class=\"fa fa-home\"></i><span class=\"nav-label\">"+data[i].name+"</span><span class=\"fa arrow\"></span></a></li>");
	    			  $("#li"+data[i].code).append("<ul style=\"background: rgb(152, 193, 219) none repeat scroll 0% 0%;\" id=\"li01ul\" class=\"nav nav-second-level\"></ul>")
	    		  }else{
	    			  if((data[i].code).length == 5){
	    				 $("#li01ul").append("<li id=\"li01ul"+data[i].code+"li\"><a href=\"javascript:void(0)\">"+data[i].name+"<span class=\"fa arrow\"></span></a></li>");
	    				 secondLevelLis[si ] = "li01ul"+data[i].code+"li";
	    				 si+=1;
	    			  }else if((data[i].code).length == 8){
	    				  var result = $.inArray("li01ul"+data[i].parentCode+"li", secondLevelLis); 
	    				  if(result!=-1){
	    					  if($("#li01ul"+data[i].parentCode+"li").find('ul').length == 0){
	    					  	  $("#li01ul"+data[i].parentCode+"li").append("<ul style=\"background: rgb(129, 181, 215) none repeat scroll 0% 0%;\"  id=\"thirdul"+data[i].parentCode+"\"  class=\"nav nav-third-level collapse\"></ul>");
	    					  }
	    				  }
	    				  $("#thirdul"+data[i].parentCode).append("<li id=\"thirdul"+data[i].code+"li\"><a href=\"javascript:void(0)\">"+data[i].name+"<span class=\"fa arrow\"></span></a></li>");
	    				  thirdLevelLis[ti] = "thirdul"+data[i].code+"li";
	    				  ti+=1;
	    			  }else if((data[i].code).length == 12){
	    				  var result = $.inArray("thirdul"+data[i].parentCode+"li", thirdLevelLis); 
	    				  if(result!=-1){
	    					  if($("#thirdul"+data[i].parentCode+"li").find('ul').length == 0){
	    					  	  $("#thirdul"+data[i].parentCode+"li").append("<ul style=\"background: rgb(119, 171, 204) none repeat scroll 0% 0%;\" id=\"fourul"+data[i].parentCode+"\"  class=\"nav nav-four-level collapse\"></ul>");
	    					  }
	    				  }
	    				  $("#fourul"+data[i].parentCode).append("<li id=\"fourul"+data[i].code+"li\" style=\"margin-left:2px;\"><a href=\"javascript:void(0)\">"+data[i].name+"<span class=\"fa arrow\"></span></a</a></li>");
	    				  fourLevelLis[fi] = "fourul"+data[i].code+"li";
	    				  fi+=1;
	    			  }else if((data[i].code).length == 20){
	    				  var result = $.inArray("fourul"+data[i].parentCode+"li", fourLevelLis); 
	    				  if(result!=-1){
	    					  if($("#fourul"+data[i].parentCode+"li").find('ul').length == 0){
	    					  	  $("#fourul"+data[i].parentCode+"li").append("<ul style=\"background: rgb(110, 159, 191) none repeat scroll 0% 0%;\" id=\"fiveul"+data[i].parentCode+"\" class=\"nav nav-five-level collapse\"></ul>");
	    					  }
	    				  }
	    				  $("#fiveul"+data[i].parentCode).append("<li id=\"fiveul"+data[i].code+"li\" style=\"margin-left:2px;\"><a href=\"javascript:void(0)\">"+data[i].name+"<span class=\"fa arrow\"></span></a</a></li>");
	    				  fiveLevelLis[fii] = "fiveul"+data[i].code+"li";
	    				  fii+=1;
	    			  }else if((data[i].code).length == 32){
	    				  var result = $.inArray("fiveul"+data[i].parentCode+"li", fiveLevelLis); 
	    				  if(result!=-1){
	    					  if($("#fiveul"+data[i].parentCode+"li").find('ul').length == 0){
	    					  	  $("#fiveul"+data[i].parentCode+"li").append("<ul style=\"background: rgb(170, 208, 233) none repeat scroll 0% 0%;\" id=\"sixul"+data[i].parentCode+"\" class=\"nav nav-six-level collapse\"></ul>");
	    					  }
	    				  }
	    				  $("#sixul"+data[i].parentCode).append("<li><a class=\"J_menuItem\" id=\""+data[i].code+"\" href=\"${base}/im/imessaging/turnToIMSee?userCode="+data[i].code+"&nameText="+data[i].name+"\" data-index=\""+data[i].code+"\">"+data[i].name+"</a></li>");
	    				  
	    			  }
	    		  }
	    	  }
	      }
	 });
	
    var pluginName = "metisMenu",
        defaults = {
            toggle: true,
            doubleTapToGo: false
        };

    function Plugin(element, options) {
        this.element = $(element);
        this.settings = $.extend({}, defaults, options);
        this._defaults = defaults;
        this._name = pluginName;
        this.init();
    }

    Plugin.prototype = {
        init: function() {
            var $this = this.element,
                $toggle = this.settings.toggle,
                obj = this;

           if (this.isIE() <= 9) {
                $this.find("li.active").has("ul").children("ul").collapse("show");
                $this.find("li").not(".active").has("ul").children("ul").collapse("hide");
            } else {
                $this.find("li.active").has("ul").children("ul").addClass("collapse in");
                $this.find("li").not(".active").has("ul").children("ul").addClass("collapse");
            }

            //add the "doubleTapToGo" class to active items if needed
            if (obj.settings.doubleTapToGo) {
                $this.find("li.active").has("ul").children("a").addClass("doubleTapToGo");
            }

            $this.find("li").has("ul").children("a").on("click" + "." + pluginName, function(e) {
                e.preventDefault();

                //Do we need to enable the double tap
                if (obj.settings.doubleTapToGo) {

                    //if we hit a second time on the link and the href is valid, navigate to that url
                    if (obj.doubleTapToGo($(this)) && $(this).attr("href") !== "#" && $(this).attr("href") !== "") {
                        e.stopPropagation();
                        document.location = $(this).attr("href");
                        return;
                    }
                }

                $(this).parent("li").toggleClass("active").children("ul").collapse("toggle");

                if ($toggle) {
                    $(this).parent("li").siblings().removeClass("active").children("ul.in").collapse("hide");
                }

            });
        },

        isIE: function() { //https://gist.github.com/padolsey/527683
            var undef,
                v = 3,
                div = document.createElement("div"),
                all = div.getElementsByTagName("i");

            while (
                div.innerHTML = "<!--[if gt IE " + (++v) + "]><i></i><![endif]-->",
                    all[0]
                ) {
                return v > 4 ? v : undef;
            }
        },

        //Enable the link on the second click.
        doubleTapToGo: function(elem) {
            var $this = this.element;

            //if the class "doubleTapToGo" exists, remove it and return
            if (elem.hasClass("doubleTapToGo")) {
                elem.removeClass("doubleTapToGo");
                return true;
            }

            //does not exists, add a new class and return false
            if (elem.parent().children("ul").length) {
                //first remove all other class
                $this.find(".doubleTapToGo").removeClass("doubleTapToGo");
                //add the class on the current element
                elem.addClass("doubleTapToGo");
                return false;
            }
        },

        remove: function() {
            this.element.off("." + pluginName);
            this.element.removeData(pluginName);
        }

    };

    $.fn[pluginName] = function(options) {
        this.each(function () {
            var el = $(this);
            if (el.data(pluginName)) {
                el.data(pluginName).remove();
            }
            el.data(pluginName, new Plugin(this, options));
        });
        return this;
    };

})(jQuery, window, document);

$(".J_tabCloseAll").on("click",
	    function() {
	        $(".page-tabs-content").children("[data-id]").not(":first").each(function() {
	            $('.J_iframe[data-id="' + $(this).data("id") + '"]').remove(),
	            $(this).remove()
	        }),
	        $(".page-tabs-content").children("[data-id]:first").each(function() {
	            $('.J_iframe[data-id="' + $(this).data("id") + '"]').show(),
	            $(this).addClass("active")
	        }),
	        $(".page-tabs-content").css("margin-left", "0")
	        var iframeNum = $("#content-main iframe").length;var iframenames = new Array();
			if(iframeNum!=0){
				for(var i=0;i<iframeNum;i++){
					var iframe = $("#content-main iframe")[i];$(iframe).css("display","inline")}
			}
})

</script>
</body>
</html>


