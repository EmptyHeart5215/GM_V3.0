<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<script src="${base}/resource/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<link href="${base}/resource/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${base}/resource/css/ace.min.css" />
<script src="${base}/resource/js/bootstrap.min.js"></script>
<script src="${base}/resource/js/ace-extra.min.js"></script>
<script src="${base}/resource/js/calendar/calendar-widget.js" type="text/javascript"></script>
<link href="${base}/resource/js/calendar/calendar-widget.css" rel="stylesheet" type="text/css" />
<script src="${base}/resource/js/bootbox.js"></script>
<%
Calendar now = Calendar.getInstance();
Integer currentYear=now.get(Calendar.YEAR);
Integer currentMonth=now.get(Calendar.MONTH)+1;
Integer currentDay=now.get(Calendar.DAY_OF_MONTH);
%>
<script type="text/javascript">
var legalcalendar;
var code='';
$(document).ready(function () {
    showLegalDate("<%=currentYear%>","<%=currentMonth%>");
});
var changeFun=function(){
	var year=$("#year").val();
	var month=$("#month").val();
	if(year/1<"<%=currentYear%>"/1||year/1=="<%=currentYear%>"/1&&month/1<"<%=currentMonth%>"/1){
		$("#calendarBtn a").each(function(){
			$(this).addClass("disabled");
		});
	}else{
		$("#calendarBtn a").each(function(){
			$(this).removeClass("disabled");
		});
	}
	showLegalDate(year,month);
};
function showLegalDate(year,month){
	$.ajax({
        type: "post", 
        url: '${base}/sys/legaldate/queryManage',
        data:{'year':year,'month':month},
        dataType:'json',
        async: false,
        success: function (data) {
        	 var legalDay='';
        	code='';
        	 if(data!=null){
        		legalDay=data.legalDay;
        		code=data.code;
        	}
            legalcalendar = $("#calendar").calendarWidget({ 'month': month,'year':year,'workdate':legalDay,'changeYearFun':changeFun,'changeMonthFun':changeFun});
         }
    });
}
function save() {
    var year = GetYear();
    var month = GetMonth();
    var day = GetLegalDates();
    var work_day = GetWorkDates();
    var legal_count = GetLegalCount();
    var work_count = GetWorkCount();
    //用jquery的post提交表单
    $.ajax({
        type: "post",
        url: '${base}/sys/legaldate/update',
        data: "code="+code+"&year=" + year + "&month=" + month + "&legalDay=" + day + "&legalCount=" + legal_count + "&workCount=" + work_count + "&workDay=" + work_day,
        dataType: 'json',
        async: false,
        success: function (data) {
        	if(data.status){
        		bootbox.slideAlert("body");
            }else{ 
            	bootbox.slideAlert('body',false,data.info);
             } 
        	
        }
    });
}
function reset(){
	showLegalDate($("#year").val(),$("#month").val());
}
</script>

</head>
<body>
<div class="row" id="body">
<div class="col-xs-12">
<div id="calendar"></div>
<div id="calendarBtn" class="tab-main" style="margin-top:5px;">
    <div style="background-color:#5a92c7;padding:5px; text-align: right;">
    <a href="#" class="btn btn-yellow btn-sm"onclick="selectAllWeekend()" >选中星期天</a>
    <a href="#" class="btn btn-yellow btn-sm"onclick="clearAll()" >清除选择</a>
     <a href="#" class="btn btn-yellow btn-xs"onclick="reset()" >重置</a>
     <a href="#" class="btn btn-yellow btn-xs"onclick="save()" >保存</a>
   </div>
</div>
</div>
</div>

</body>
</html>