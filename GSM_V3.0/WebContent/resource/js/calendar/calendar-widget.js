var calendar;


(function ($) {
    //参数扩充
    $.calendarWidget = function (c, p) {
    	var nowDate=new Date();
        p = $.extend({
            month: nowDate.getMonth()+1,
            year: nowDate.getFullYear(),
            workdate:'',
            monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
            currentYear: nowDate.getFullYear(),
            currentMonth: nowDate.getMonth()+1,
            currentDay:nowDate.getDate(),
            changeYearFun:function(){},
            changeMonthFun:function(){}
        }, p);

        //公共的一些变量
        //获取当前月的天数
        var days = getDaysInMonth(p.month - 1, p.year);
        //获取此月开始于星期几
         var firstDayDate = new Date(p.year, p.month - 1, 1);
        var firstDay = firstDayDate.getDay();
        //获取前一个月的天数
         var prev_m = p.month == 1 ? 12 : p.month - 1;
        var prev_y = prev_m == 12 ? p.year - 1 : p.year;
        var prev_days = getDaysInMonth(prev_m - 1, prev_y);

        firstDay = (firstDay == 0 && firstDayDate) ? 7 : firstDay;

        var i = 0;
        var legals = getlegaldata();

        //方法
          var o = {
            getMonthYear: function () {
                days = getDaysInMonth(p.month - 1, p.year);
                firstDayDate = new Date(p.year, p.month - 1, 1);
                firstDay = firstDayDate.getDay();
                //获取前一个月的天数
                prev_m = p.month == 1 ? 12 : p.month - 1;
                prev_y = prev_m == 12 ? p.year - 1 : p.year;
                prev_days = getDaysInMonth(prev_m - 1, prev_y);

                firstDay = (firstDay == 0 && firstDayDate) ? 7 : firstDay;

                i = 0;
                legals = getlegaldata();
            },
            addData: function () {
                $("tr", o.contentTalbe).remove();
                drawTable();
                $(".current-month", o.contentTalbe).click(function () {
                    if ($(this).hasClass("legaldate")) {
                        $(this).removeClass("legaldate");
                    }
                    else {
                        $(this).addClass("legaldate");
                    }
                });
            }
        };
        //整个div，将所有的内容都填充进去
        o.gDiv = document.createElement('div');
        //头部，年月
        o.topDiv = document.createElement('div');
        //星期头
        o.titleTable = document.createElement('table');
        //日期内容
        o.contentTalbe = document.createElement('table');
        $(o.gDiv).addClass('tab-main');
        //拼接头部
        var yearselect = '<select id="year" class="form-control">';
        for (var i = 0; i < 10; i++) {
            if (p.currentYear - 5 + i == p.year) {
                yearselect += '<option value=' + (p.currentYear - 5 + i) + ' selected>' + (p.currentYear - 5 + i) + '</option>';
            }
            else {
                yearselect += '<option value=' + (p.currentYear - 5 + i) + '>' + (p.currentYear - 5 + i) + '</option>';
            }
        }
        yearselect += '</select>';
        var monthselect = '<select id="month"class="form-control">';
        for (var i = 0; i < 12; i++) {
            if ((i + 1) == p.month) {
                monthselect += '<option value=' + (i + 1) + ' selected>' + p.monthNames[i] + '</option>';
            }
            else {
                monthselect += '<option value=' + (i + 1) + '>' + p.monthNames[i] + '</option>';
            }
        }
        monthselect += '</select>';

        o.topDiv.innerHTML = yearselect + monthselect;
        o.gDiv.appendChild(o.topDiv);
       /* $('#year', o.topDiv).change(function () { p.year = $("#year").val(); o.getMonthYear(); o.addData(); });
        $('#month', o.topDiv).change(function () {
            p.month = $("#month").val();
            o.getMonthYear(); o.addData();
        });*/
        $('#year', o.topDiv).change(p.changeYearFun);
        $('#month', o.topDiv).change(p.changeMonthFun);
        $(c).append(o.gDiv);
      
        //拼接星期头
        var titlehtml = '<tr>';
        for (var i = 0; i < 7; i++) {
            titlehtml += '<th class="weekday">' + p.dayNames[i] + '</th>';
        }
        titlehtml += '</tr>';
        o.titleTable.cellPadding = 0;
        o.titleTable.cellSpacing = 0;
        $(o.titleTable).append(titlehtml);
        o.gDiv.appendChild(o.titleTable);
        drawTable();
        o.gDiv.appendChild(o.contentTalbe);
        $(".current-month", p.contentTalbe).click(function () {
            if ($(this).hasClass("legaldate")) {
                $(this).removeClass("legaldate");
            }
            else {
                $(this).addClass("legaldate");
            }
        });
      //拼接日期内容
        function drawTable(){
            var contentday = '';
            var i=0;
//            alert(p.month+''+p.currentMonth+''+p.year+''+p.currentYear);
            for (var j = 0; j < 42; j++) {
            	
                var tdContent="";
                var showDay=j - firstDay + 1;
                if (j % 7 == 0){
                	contentday += '<tr>';
                }
                if ((j < firstDay)) {
                	tdContent= ('<td class="other-month"><span>' + (prev_days - firstDay + j + 1) + '</span></td>');
                } else if ((j >= firstDay + days)) {
                    i = i + 1;
                    tdContent= ('<td class="other-month"><span>' + i + '</span></td>');
                }else{
                	tdContent= '<td  id="day_' + p.month + '_' + (showDay) + '" class="current-month day ';
                	if(isInLegal(legals, (j - firstDay + 1)) == true) {
                		tdContent += 'legaldate';
                	}
                	tdContent += '"><span';
                	if(showDay==p.currentDay&&p.month==p.currentMonth&&p.year==p.currentYear){
                		tdContent += ' style="color:#ff0000"';
                    } if(j % 7 == 0||j % 7 == 6){
                    	tdContent += ' class="weekend"';
                    	tdContent=tdContent.replace("<td", "<td name='weekendTD'");
                    }
                	tdContent += '>' + (showDay) + '</span></td>';
                }
                contentday+=tdContent;
                if (j % 7 == 6) {
                	contentday += ('</tr>');
                }
            }
            $(o.contentTalbe).append(contentday);
        }
        //取指定月的工作日
        function getlegaldata() {
        	var legals=[];
        	if(p.workdate&&p.workdate!=''){
        		 legals=p.workdate.split(",");
        		return legals;
                /*if (p.workdate.year == p.year && p.workdate.month == p.month) {
                	alert(p.workdate.day);
                    return p.workdate.day;
                }*/
        	}
        }
        //判断是否在数组中
        function isInLegal(legals, date) {
            var result = false;
            if (legals) {
                for (var i = 0; i < legals.length; i++) {
                    if (legals[i] == date) {
                        result = true;
                        break;
                    }
                }
            }
            return result;
        }

        c.p = p;
        c.calendar = o;
        return c;
    };
    
    //取某个月的天数
    function getDaysInMonth(month, year) {
        var daysInMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        if ((month == 1) && (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
            return 29;
        } else {
            return daysInMonth[month];
        }
    }
    //初始化方法
    $.fn.calendarWidget = function (p) {
    	this.html('');
        $.calendarWidget(this, p);
    };
  
   $.fn.calendarOptions = function (p) {
        return this.each(function () {
            if (this.calendar) $.extend(this.p, p);
        });
    };
})(jQuery);



function GetLegalDates() {
    var result = "";
    var items = $(".legaldate", calendar);
    for (var i = 0; i < items.length; i++) {
        if ($(items[i]).find("span").html().length == 1)
        {
            result += "0";
        }
        result += $(items[i]).find("span").html()+",";
    }
    if (result != "")
    {
        result = result.substring(0, result.length - 1);
    }
    return result;
}

function GetYear() {
    return $("#year", calendar).val();
}

function GetMonth() {
    return $("#month", calendar).val();
}

function GetLegalCount() {
    var items = $(".legaldate", calendar);
    return items.length;
}

function GetWorkCount() {
    return $(".current-month", calendar).length - $(".legaldate", calendar).length;
}

function GetWorkDates() {
    var result = "";
    var items = $("td.current-month", calendar);
    var legaldates = GetLegalDates();
    for (var i = 0; i < items.length; i++) {
        var str = "";
        if ($(items[i]).find("span").html().length == 1) {
            str += "0" + $(items[i]).find("span").html();
        } else {
            str = $(items[i]).find("span").html();
        }
        if (legaldates.indexOf(str)==-1) {
            result += str + ",";
        }
    }
    return result;
}
function selectAllWeekend(){
	$("[name=weekendTD]").addClass("legaldate");
}
function clearAll(){
	$("td").removeClass("legaldate");
}