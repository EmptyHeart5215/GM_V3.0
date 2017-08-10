<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title></title>
	<!-- basic styles -->
		<link href="${base}/resource/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${base}/resource/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="${base}/resource/css/font-awesome-ie7.min.css" />
		<![endif]-->

		


		
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${base}/resource/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
<script type="text/javascript">
Array.prototype.indexOf = function (val) {  
    for (var i = 0; i < this.length; i++) {  
        if (this[i] == val) {  
            return i;  
        }  
    }  
    return -1;  
};  
Array.prototype.removeValue = function (val) {  
    var index = this.indexOf(val);  
    if (index > -1) {  
        this.splice(index, 1);  
    }  
}; 
String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	  return false;
	if(this.substring(this.length-str.length)==str)
	  return true;
	else
	  return false;
	return true;
	}
</script>
      
		<script src="${base}/resource/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${base}/resource/js/html5shiv.js"></script>
		<script src="${base}/resource/js/respond.min.js"></script>
		<![endif]-->
		
		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${base}/resource/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${base}/resource/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${base}/resource/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="${base}/resource/js/jquery-ui.js"></script>  
		<script src="${base}/resource/js/bootstrap.min.js"></script>
		<script src="${base}/resource/js/typeahead-bs2.min.js"></script>
		
		<script src="${base}/resource/js/jquery.validate.min.js"></script>
		
		<!-- ztree -->
		<link href="${base}/resource/js/zTree/css/zTreeStyle.css" rel="stylesheet" />
		<script src="${base}/resource/js/zTree/jquery.ztree.core-3.5.js" type="text/javascript"></script>
		<script src="${base}/resource/js/zTree/jquery.ztree.excheck-3.5.js" type="text/javascript"></script>
		<script src="${base}/resource/js/zTree/ztreeGrid2.js" type="text/javascript"> </script>
		<!-- jqgrid -->
		<link rel="stylesheet" href="${base}/resource/css/jquery-ui-1.10.3.full.min.css" />
		<link rel="stylesheet" href="${base}/resource/css/datepicker.css" />
		<link rel="stylesheet" href="${base}/resource/css/daterangepicker.css" />
		<link rel="stylesheet" href="${base}/resource/css/ui.jqgrid.css" />
		<script src="${base}/resource/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="${base}/resource/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="${base}/resource/js/jqGrid/i18n/grid.locale-en.js"></script>
		<!-- bootbox -->
		<script src="${base}/resource/js/bootbox.js"></script>
		<!-- layer 必须放在dropzone前边，因为dropzone调用了layer中的方法 -->
		 <script src="${base}/resource/js/layer-v1.8.5/layer/layer.min.js"></script>
		 <link rel="stylesheet" href="${base}/resource/js/layer-v1.8.5/layer/skin/layer.css" />
		 <link rel="stylesheet" href="${base}/resource/js/layer-v1.8.5/layer/skin/layer.ext.css" />
		<!-- dropzone 必须放在bootbox和layer的后边，因为代码中使用了bootbox控件 -->
		<link rel="stylesheet" href="${base}/resource/css/dropzone.css" />
		<script src="${base}/resource/js/dropzone.min.js"></script>
		<!-- map -->
		<link rel="stylesheet" href="${base}/resource/js/map_ol3/css/ol.css" type="text/css"/>
		<link rel="stylesheet" href="${base}/resource/js/map_ol3/css/nmap.css" type="text/css"/>
		<script type="text/javascript" src="${base}/resource/js/map_ol3/ol-debug.js"></script> 
		<script type="text/javascript" src="${base}/resource/js/map_ol3/nmap.js"></script>
		<!-- datetimepicker -->
		<link rel="stylesheet" href="${base}/resource/js/datetimepicker/bootstrap-datetimepicker.min.css" />
		<script src="${base}/resource/js/datetimepicker/bootstrap-datetimepicker.js"></script>
		<script src="${base}/resource/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
		<!-- datepicker -->
		<script src="${base}/resource/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="${base}/resource/js/date-time/bootstrap-timepicker.min.js"></script>
		<script src="${base}/resource/js/date-time/moment.min.js"></script>
		<script src="${base}/resource/js/date-time/daterangepicker.min.js"></script>
		<!-- clockpicker -->
		<link rel="stylesheet" href="${base}/resource/js/clockpicker/dist/bootstrap-clockpicker.css" type="text/css"/>
		<script src="${base}/resource/js/clockpicker/dist/bootstrap-clockpicker.js"></script>
		<link rel="stylesheet" href="${base}/resource/js/clockpicker/dist/bootstrap-clockpicker.min.css" type="text/css"/>
		<script src="${base}/resource/js/clockpicker/dist/bootstrap-clockpicker.min.js"></script>
		<link rel="stylesheet" href="${base}/resource/js/clockpicker/dist/jquery-clockpicker.css" type="text/css"/>
		<script src="${base}/resource/js/clockpicker/dist/jquery-clockpicker.js"></script>
		<link rel="stylesheet" href="${base}/resource/js/clockpicker/dist/jquery-clockpicker.min.css" type="text/css"/>
		<script src="${base}/resource/js/clockpicker/dist/jquery-clockpicker.min.js"></script>
		<link rel="stylesheet" href="${base}/resource/js/clockpicker/src/clockpicker.css" type="text/css"/>
		<script src="${base}/resource/js/clockpicker/src/clockpicker.js"></script>
		<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=df6a546c9bf6dd812b783ee736c961b2&plugin=AMap.Geocoder"></script>
		<link rel="stylesheet" href="${base}/resource/js/clockpicker/src/standalone.css" type="text/css"/>
		<style>
		.positiondivshow{
			float: left;
			 border: 1px solid #8abbd2;
			 background-color:#8abbd2 !important;
			 color:#ffffff;
			 cursor:pointer;
			 text-align:center;
			 border-radius: 4px;
		}
		</style>
			 <script>
			 function getWenZiWeiZhi (graphicJSON,htmlobj) {
                 //$("#" + htmlobj.id).val(graphicJSON);
            	 var point = graphicJSON.split(";");
                    if (point.length == 1) {
                        var geocoder = new AMap.Geocoder({
                            //city: "0315", //城市，默认：“全国”
                            radius: 1000 //范围，默认：500,以已知坐标为中心点，radius为半径，返回范围内兴趣点和道路信息 
                        });
                        geocoder.getAddress(transform(graphicJSON), function (status, result) {
                            if (status === 'complete' && result.info === 'OK') {
                                geocoder_CallBack(result);
                            }
                        });
                        function geocoder_CallBack(data) {
                            var address = data.regeocode.formattedAddress; //返回地址描述
                            $("#" + htmlobj.id).val(address);
                        }
                    }
                    else
                    {
                        $("#" + htmlobj.id).val(graphicJSON);
                    }
                    $("#mapadd").hide();
                }
		// 	 添加地图及图形
		var getPointXY = function (htmlobj) {
            $("#mapadd").remove();
            $("body").append("<div id='mapadd' style='background-color:#ffffff;position:absolute;top:0px;bottom:0px; left:0px; right:0px;z-index:999999'></div>");
            NMaps({
                id: "mapadd",
                points: $("[name = position]").val(),
               // extent: "118.18086187171613, 39.61128141222516; 118.19266204261203, 39.606505078789324; 118.190187171613, 39.6205078789324",
                getResult: function (graphicJSON) {
                	$("[name = position]").val(graphicJSON);
                	poiToaddress(graphicJSON, htmlobj);
                    $("#mapadd").hide();
                }
            });
        }
		    /*  function getPointXY(htmlobj) {
		         $("#mapadd").remove();
		         $("body").append("<div id='mapadd' style='background-color:#ffffff;position:absolute;top:0px;bottom:0px; left:0px; right:0px;z-index:999999'></div>");
		         NMaps({
		             id: "mapadd",
		             points: $("#" + htmlobj.id).val(),
		             getResult:function(graphicJSON){
		            	 getWenZiWeiZhi(graphicJSON,htmlobj);
		             }
		         });
		     }  */
					function thishide() {
						$("#positiondivshow").hide();
						$("#position").show();
						$("#position").click();
					}
					  $(function() {
						  if($("#position")){
							  $("#position").attr("name","");
							  var v= $("#position").val();
							  var hidden=$("<input type='hidden' name='position' value='"+v+"'/>");
							  $("#position").after(hidden);
						  }
						if ($("#position").length > 0) {
							if ($("#position").val() != '' && $("#position").attr("class") !='noshow') {
								poiToaddress($("#position").val(),$("#position")[0]);
							}
						}
						
					});  
					/*  window.onresize = function(){  
						 var width = $(window).width();
						
							$('#dg').datagrid('resize', {
								'width' : width
							});
					  }   */
				</script>
		
		
		
		
		
		
		
		
		
		<!-- ace styles -->

		<link rel="stylesheet" href="${base}/resource/css/ace.min.css" />
		<link rel="stylesheet" href="${base}/resource/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${base}/resource/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${base}/resource/css/menuCss.css" />
		<link rel="stylesheet" href="${base}/resource/css/gsm-common.css" />
		<!-- ace scripts -->

		<script src="${base}/resource/js/ace-elements.min.js"></script>
		<script src="${base}/resource/js/ace.min.js"></script>
		<script src="${base}/resource/js/my.js"></script>
		<%-- <script src="${base}/resource/js/showname.js"></script> --%>
	<script>
	$(function(){
	$('.date-picker').datepicker({});
	 $('.date-range-picker').daterangepicker(); 
	});
	String.prototype.replaceAll = function(s1,s2){ 
		return this.replace(new RegExp(s1,"gm"),s2); 
		}
	</script>