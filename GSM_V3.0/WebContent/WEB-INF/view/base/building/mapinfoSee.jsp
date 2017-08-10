<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include  page="/resource/base_import.jsp"/>
<link href="${base}/resource/js/LouPanBiao/lpb.css" rel="stylesheet" />
<script type="text/javascript" src="${base }/resource/js/LouPanBiao/lpb.js"></script>
<style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
            font-size:12px;
        }
#bd_css{border-collapse: collapse;
             border: none;
             font-size:12px}
   #bd_css td
   {
   border-collapse: collapse;
        border: solid #000 0px;
        border-bottom:#CCCCCC solid 1px;
        height: 25px;
   }
.list_from td {
        border-collapse: collapse;
        border: solid #000 1px;
        border-bottom:#000 solid 1px;
        height: 20px;
        
     }
.left_from td {
        border-collapse: collapse;
        border: solid #000 1px;
        border-bottom:#000 solid 1px;
        height: 25px;
     }
#pagination td{
        border-left-style:none;
        border-right-style:none;
        border-top-style:none;
        border-bottom-style:none;
        
     }
     #dg td{
        border-left-style:none;
        border-right-style:none;
        border-top-style:none;
        border-bottom-style:none;
        
     }
#trcss {
       background-color:#F6FAFD;
       color:#6699FF;
     }
</style>
<script type="text/javascript">
var args =new Array();
args[0]="buildcode=${vdata.building.code }";
//传参url
var url ;
//加载table
var table ;
//当前页
var page ;
//最大页
var pagemax;
//总条数
var rows=5;
//下一页
function nextpage()
{
	if(page<pagemax)
	{
		page=page+1;
	}else
	{
		page=pagemax;
	}
	sel(page);
	}
//首页
function indexpage()
{
	page=1;
	sel(page);
	}
//最后一页
function lastpage()
{
	page=pagemax;
	sel(page);
	}
//上一页
function uppage()
{
	
	if(page!=1)
	{
		page=page-1;
	}else
	{
		page=1;
	}
	sel(page);
	}
//详细页面跳转
function info(code)
{
$('#chicken', parent.document).css({"width": "602px" });
	location.href="${base}/base/bperson/personMap?code="+code;
	}
//返回页面跳转
function callback()
{
	
	location.href="${base}/base/bhouse/houseMap?code=${vdata.housecode }";
}
//alert("${vdata.housecode }");
//查询人员分页
function sel(page)
{
	var test="${vdata.housecode }";
	if(0!=test.length)
	{
		$(".tabs").append("<li align='right' onclick='callback()'>&nbsp;&nbsp;&nbsp;<a href='#' class='easyui-linkbutton l-btn l-btn-small' iconcls='icon-redo' id='PersonReset' group=''><span class='l-btn-left l-btn-icon-left'><span class='l-btn-text'>返回</span><span class='l-btn-icon icon-redo'>&nbsp;</span></span></a></li>");
	}
	$.ajax({
		type : "post",
		url :"${base }/base/person/queryManage?page="+page+"&rows="+rows+"&sidx=code&sord=asc&args="+args,
		dataType : 'json',
		async : true,
		success : function(data) {
			table_html="<tr id = 'trcss'><td  width='20%'>姓名</td><td width='20%'>性别</td><td width='20%'>身份证号</td><td width='20%'>关系</td><td width='20%'>详细</td></tr>";
			for(var i=0;i<data.rows.length;i++)
			{
				if(""==data.rows[i].CODE_HOUSEHOLD_RELATION_NAME||null==data.rows[i].CODE_HOUSEHOLD_RELATION_NAME)
				{
					data.rows[i].CODE_HOUSEHOLD_RELATION_NAME="空";
				}
				table_html+="<tr id='tr_hover'><td style='text-align: center;'>"+data.rows[i].NAME+"</td><td style='text-align: center;'>"+data.rows[i].CODE_SEX_NAME+"</td><td style='text-align: center;'>"+data.rows[i].CID+"</td><td style='text-align: center;'>"+data.rows[i].CODE_HOUSEHOLD_RELATION_NAME+"</td><td><a id='buila' href='javascript:void(0)' onclick=\"info('"+data.rows[i].CODE+"');\">详细</a></td></tr>";
				
			}
			pagemax= Math.ceil(data.total % rows == 0 ? data.total / rows : data.total / rows );
			
			$("#pagination").html("<tr><td colspan='6'><table border = '0' align='center'><tr><td style='width: 80px;'><a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-search' onclick='indexpage();'>首页</a></td><td style='width: 80px;'><a href='javascript:void(0)' class='easyui-linkbutton' onclick='uppage();' iconCls='icon-search'>上一页</a></td><td >"+page+"</td><td style='width: 80px;'><a href='javascript:void(0)' class='easyui-linkbutton' onclick='nextpage();' iconCls='icon-search' >下一页</a></td><td  style='width: 80px;'><a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-search' onclick='lastpage();'>尾页</a></td><td  style='width: 80px;'>共"+pagemax+"页</td><td  style='width: 80px;'>共"+data.total+"条</td><td  style='width: 80px;'>每页"+rows+"条</td></tr></table></td></tr>");
			$('#dg').html(table_html);
			}
		});
	}
$(function()
		{
			page=1;
			sel(page);
			
			$.ajax({
				type : "post",
				url :"${base }/base/building/personCharts?code=${vdata.building.code}",
				dataType : 'json',
				async : true,
				success : function(data) {
					
					for(var i=0;i<data.length;i++)
					{
						if(data[i].man==null)
						{
							data[i].man="0";
						}if(data[i].women==null)
						{
							data[i].women="0";
						}
						if(data[i].max==null)
						{
							data[i].max="0";
						}
						if(i==0)
						{
							$("#cm").html(data[i].man);
							$("#cw").html(data[i].women);
							$("#cmax").html(data[i].max);
						}else if(i==1)
						{
							$("#lm").html(data[i].man);
							$("#lw").html(data[i].women);
							$("#lmax").html(data[i].max);
						}
						
					}
					}
				});
			$.ajax({
				type : "post",
				url :"${base }/charts/bhousecharts/Charts?buildCode=${vdata.build.code}",
				dataType : 'json',
				async : true,
				success : function(data) {
					/* $("#zi").html(data.house.ZI);
					$("#chu").html(data.house.CHU);
					$("#kong").html(data.house.KONG);
					$("#qi").html(data.house.QI);
					$("#max").html(data.house.MAX); */
					var html_tab="";
					var num=0;
					html_tab="<tr><td style='width: 110px;'></td><td style='width: 110px;'>套数</td></tr>";
					for(var i=0;i<data.length;i++)
					{
						html_tab+="<tr><td>"+data[i].NAME_C+"</td><td >"+data[i].COUNTS+"</td></tr>";
					num+=data[i].COUNTS;
					}
					html_tab+="<tr><td>全部</td><td id='max'>"+num+"</td></tr>";
					$(".num_list").html(html_tab);
					}
				});
		});
$(document).ready(function () {
	 var FANG1 = {
             "JUMIN":
                 [
                     { "DY": "2", "DYPX": 2, "PX": 1, "LC": 1, "YC": "0", "YF": "0", "NAME": "101", "CODE_COLOR": "0034", "HOUSECODE": "00000027", "REN": null },
                     { "DY": "2", "DYPX": 2, "PX": 2, "LC": 1, "YC": "0", "YF": "0", "NAME": "102", "CODE_COLOR": "0033", "HOUSECODE": "00000032", "REN": null },
                     { "DY": "1", "DYPX": 1, "PX": 1, "LC": 1, "YC": "0", "YF": "0", "NAME": "101", "CODE_COLOR": "0034", "HOUSECODE": "00000033", "REN": null },
                     { "DY": "1", "DYPX": 1, "PX": 2, "LC": 1, "YC": "0", "YF": "0", "NAME": "102", "CODE_COLOR": "0034", "HOUSECODE": "00000034", "REN": null },
                     { "DY": "2", "DYPX": 2, "PX": 3, "LC": 1, "YC": "0", "YF": "0", "NAME": "103", "CODE_COLOR": "0033", "HOUSECODE": "00000040", "REN": null },
                     { "DY": "1", "DYPX": 1, "PX": 1, "LC": 2, "YC": "0", "YF": "0", "NAME": "201", "CODE_COLOR": "0033", "HOUSECODE": "00000041", "REN": null },
                     { "DY": "1", "DYPX": 1, "PX": 2, "LC": 2, "YC": "0", "YF": "0", "NAME": "202", "CODE_COLOR": "0033", "HOUSECODE": "00000042", "REN": null },
                     { "DY": "3", "DYPX": 3, "PX": null, "LC": null, "YC": null, "YF": "0", "NAME": null, "CODE_COLOR": "0033", "HOUSECODE": null, "REN": null }
                 ],
             "DISHANG": "",
             "DIXIASHI": ""
         };
	
	$.ajax({
		type : "post",
		url :"${base }/base/building/queryLpb?"+args[0],
		dataType : 'json',
		async : true,
		success : function(data) {
    $("#lpb").lpb({
        fang:data,
        fang_bgcolor:                  
        	 [{ code: "0033", color: "#00ff00", name: "自住" },
              { code: "0034", color: "#ff0000", name: "出租" },
              { code: "0003", color: "#ffff00", name: "空置" },
              { code: "0004", color: "#0000ff", name: "其他" }]

//             fang_img: [
//                        { url: "../1.jpg", name: "标志一" },
//                        { url: "../2.jpg", name: "标志二" }]
            
    });
		}
	});
});
function a ( v){
	$('#chicken', parent.document).css({"width": "602px" });
	location.href="${base}/base/bhouse/houseMap?code="+v;
}
</script>
</head>
<body>
<div class="row">
<div class="col-xs-12" id="body">
	<div class="tabbable tabs-top" >
			<ul class="nav nav-tabs" id="myTab3">
				<li class="active">
					<a data-toggle="tab" href="#xinxiDiv">
						<i class="pink icon-dashboard bigger-110"></i>
						信息
					</a>
				</li>
				<li>
					<a data-toggle="tab" href="#loupanDiv">
						<i class="blue icon-user bigger-110"></i>
						楼盘表
					</a>
				</li>
					<li>
					<a data-toggle="tab" href="#renyuanDiv">
						<i class="blue icon-user bigger-110"></i>
						人员
					</a>
				</li>
			</ul>
		
		<div class="tab-content" style="min-height:300px;">
			<!-- 基本信息 --> 
			<div id="xinxiDiv" class="tab-pane in active">
				<div style="width: 530px;height: 400px;float: left;">
               <div class="left_from">
                   <table class="map_detial_table" id="bd_css" width="100%" frame=below>
                     <tr>
                       <td colspan="4"><h1><font style="color: #6699FF;size: 8px">${vdata.building.buildName}</font></h1></td>
                       <td colspan="2" rowspan="3">
                         <c:choose>
	                        <c:when test="${vdata.BUILD_imgPath eq null}">
	                        	<img style="width: 100px; height: 90px; text-align: center;" src="${base }/resource/images/nopic.jpg">
	                        </c:when>
	                        <c:otherwise>
	                        	<img style="width: 100px; height: 90px; text-align: center;" src="${base}/upload/${vdata.BUILD_imgPath}">
	                        </c:otherwise>
                        </c:choose>
                       </td>
                     </tr> 
                     <tr>
                       <td class="map_detial_font_right" style="width: 55px;">类型：</td>
                       <td colspan="3">${vdata.building.codeBuildType}</td>
                     </tr>    
                     <tr>
                       <td class="map_detial_font_right"  style="width: 55px;">地址：</td>
                       <td colspan="3">${vdata.building.gridCode}</td>
                     </tr>    
                     <tr>
                       <td class="map_detial_font_right"  style="width: 55px;">网格员：</td>
                       <td style="width: 120px;">${vdata.grid.Manager}</td>
                       <td class="map_detial_font_right"  style="width: 90px;">网格助理员：</td>
                       <td style="width: 120px;">${vdata.grid.Assistant}</td>
                       <td class="map_detial_font_right"  style="width: 80px;">楼栋长：</td>
                       <td style="width: 120px;">${vdata.building.buildManager}</td>
                     </tr>    
                     <tr>
                       <td class="map_detial_font_right"  style="width: 55px;">电话：</td>
                       <td style="width: 120px;">${vdata.grid.Manager_Phone}</td>
                       <td class="map_detial_font_right"  style="width: 90px;">电话：</td>
                       <td style="width: 120px;">${vdata.grid.Assistant_Phone}</td>
                       <td class="map_detial_font_right"  style="width: 80px;">电话：</td>
                       <td style="width: 120px;">${vdata.building.buildManagerPhone }</td>
                     </tr>
                     <tr>
                       <td colspan="2" rowspan="5">
                         <c:choose>
	                        <c:when test="${vdata.MANAGER_imgPath eq null}">
	                        	<img style="width: 100px; height: 150px; text-align: center;" src="${base }/resource/images/nopic.jpg">
	                        </c:when>
	                        <c:otherwise>
	                        	<img style="width: 100px; height: 150px; text-align: center;" src="${base}/upload/${vdata.MANAGER_imgPath}">
	                        </c:otherwise>
                        </c:choose>
                       </td>
                       <td colspan="2" rowspan="5">
                         <c:choose>
	                        <c:when test="${vdata.ASSISTANT_imgPath eq null}">
	                        	<img style="width: 100px; height: 150px; text-align: center;" src="${base }/resource/images/nopic.jpg">
	                        </c:when>
	                        <c:otherwise>
	                        	<img style="width: 100px; height: 150px; text-align: center;" src="${base}/upload/${vdata.ASSISTANT_imgPath}">
	                        </c:otherwise>
                        </c:choose>
                       </td>
                       <td colspan="2" rowspan="5">
                         <c:choose>
	                        <c:when test="${vdata.BUILD_MANAGER_PHOTO eq null}">
	                        	<img style="width: 100px; height: 150px; text-align: center;" src="${base }/resource/images/nopic.jpg">
	                        </c:when>
	                        <c:otherwise>
	                        	<img style="width: 100px; height: 150px; text-align: center;" src="${base}/upload/${vdata.BUILD_MANAGER_PHOTO}">
	                        </c:otherwise>
                        </c:choose>
                       </td>
                     </tr>
                     <tr></tr>
                     <tr></tr>
                     <tr></tr>
                     <tr></tr>          
                   </table>
               </div> 
           </div>
           <div style="width: 230px;height: 15px;float: left;margin-top: -400px;margin-left: 530px;">
              <div class="List_from">
                 <h2><font style="color: #6699FF;">人口信息：</font></h2>
                 <table id="bd_css" width="100%" frame=below>
                    <tr>
                      <td style="width: 100px;"></td>
                      <td style="width: 40px;">男</td>
                      <td style="width: 40px;">女</td>
                      <td style="width: 40px;">总</td>
                    </tr>
                    <tr>
                      <td>常住人口</td>
                      <td id='cm'></td>
                      <td id='cw'></td>
                      <td id='cmax'></td>
                    </tr>
                    <tr>
                      <td>流动人口</td>
                      <td id='lm'></td>
                      <td id='lw'></td>
                      <td id='lmax'></td>
                    </tr>
                 </table>
              </div>
              <div class="List_from">
                 <h2><font style="color: #6699FF;">房屋信息：</font></h2>
                 <table id="bd_css" class="num_list" width="100%" frame=below>

                 </table>
              </div>
            
           	</div>
			</div>
			<div id="loupanDiv" class="tab-pane ">
				<div id="lpb"></div>
			</div>
			<div id="renyuanDiv" class="tab-pane ">
				<div style="height:175px;">
			      <div style="width: 100px;height: 30px;margin-left: 12px;"><b><font color="#6699FF">现居人口</font></b></div>
			      <table class="map_detial_table" width="100%" frame=below style="text-align: center;" id="dg"></table>
			    </div>
			    
			    <div style="width: 100%;height: 30px;margin-top:120px;">
			        <table class="map_detial_table" width="100%" frame=below style="text-align: center;" id="pagination"></table>
			    </div>
			</div>
		</div>
	</div>
</div>
</div>

<!-- <div class="easyui-tabs" data-options="tabWidth:112" style="width:1000px;height:450px;">
		<div title="信息" style="padding:10px;">
           
		</div>
		<div  title="楼盘表" style="height:175px;padding:10px">
              <div id="lpb"></div>
		</div>
		<div  title="单位" style="height:175px;padding:10px">
		
		</div>
		
		<div  title="人员" style="height:175px;padding:10px">
			<div style="height:175px;">
		      <div style="width: 100px;height: 30px;margin-left: 12px;"><b><font color="#6699FF">现居人口</font></b></div>
		      <table class="map_detial_table" width="100%" frame=below style="text-align: center;" id="dg"></table>
		    </div>
		    
		    <div style="width: 100%;height: 30px;margin-top:120px;">
		        <table class="map_detial_table" width="100%" frame=below style="text-align: center;" id="pagination"></table>
		    </div> 
            
		</div>
</div> -->
</body>
</html>