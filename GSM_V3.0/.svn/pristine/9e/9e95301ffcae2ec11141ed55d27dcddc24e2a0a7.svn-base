(function ($) {
    //参数扩充
    $.lpb = function (c, p) {
        p = $.extend({
            fang: [],//房屋的json集合
            fang_width: 80,//房屋的宽度
            fang_height: 60,//房屋的高度
            img_width: 20,//图片的宽度
            img_height: 20,//图片的高度
            jian_width: 1,//房屋间的横向间距
            jian_height: 1,//房屋间的纵向间距
            dy_name_height: 30,//单元名的高度
            louc_width: 40,//楼层的宽度
            fang_bgcolor: [{ code: "0001", color: "#cccccc", name: "颜色" }],
            fang_img: []
        }, p);
        //整栋楼的容器
        var container = c[0];
        //获得房屋集合
        var fang = p.fang.JUMIN;
        //获取底商集合
        var dishang = p.fang.DISHANG;
        //获取地下室集合
        var dixiashi = p.fang.DIXIASHI;
        //单元的高度初始化
        var dyDiv_height = 0;
        //通过class获取元素
        var getClass = function (tagName, className) //获得标签名为tagName,类名className的元素
        {
            if (document.getElementsByClassName) //支持这个函数
            {
                return document.getElementsByClassName(className);
            }
            else {
                var tags = document.getElementsByTagName(tagName);//获取标签
                var tagArr = [];//用于返回类名为className的元素
                for (var i = 0; i < tags.length; i++) {
                    if (tags[i].className == className) {
                        tagArr[tagArr.length] = tags[i];//保存满足条件的元素
                    }
                }
                return tagArr;
            }
        };
        //循环添加房屋
        var louc = null;
        if (fang.length > 0) {
            //楼层容器
            louc = document.createElement("div");
            container.appendChild(louc);
            for (var i = 0; i < fang.length; i++) {
            	var dyDiv = null;
                if (!document.getElementById("dy_" + fang[i].DYPX)) {
                    //没有单元的情况下新建单元
                    dyDiv = document.createElement("div");
                    dyDiv.id = "dy_" + fang[i].DYPX;
                    dyDiv.className = "lpb_dyDiv";
                    var dywidth = ((p.jian_width + p.fang_width) * fang[i].PX + p.jian_width) == 1 ? p.fang_width : ((p.jian_width + p.fang_width) * fang[i].PX + p.jian_width);
                    dyDiv.style.width = dywidth + "px";//初始单元的宽度为一个房屋宽度+两个间隔宽度
                    //新建单元名称的div
                    var dyNameDiv = document.createElement("div");
                    dyNameDiv.innerHTML = fang[i].DY;
                    dyNameDiv.id = "dyName_" + fang[i].DYPX;
                    dyNameDiv.className = "lpb_dyNameDiv";
                    dyNameDiv.style.height = p.dy_name_height + "px";
                    dyNameDiv.style.lineHeight = p.dy_name_height + "px";
                    dyNameDiv.style.width = dyDiv.style.width;
                    dyDiv.appendChild(dyNameDiv);

                    //添加进容器
                    var dy = getClass("div", "lpb_dyDiv");
                    if (dy.length == 0) {
                        container.appendChild(dyDiv);
                    } else {
                        for (var j = 0; j < dy.length; j++) {
                            if (dy[j].id.substring(dy[j].id.length - 1, dy[j].id.length) > fang[i].DYPX) {
                                dy[j].parentNode.insertBefore(dyDiv, dy[j]);
                            } else {
                                container.appendChild(dyDiv);
                            }
                        }
                    }
                } else {
                    //已存在单元的情况下，设置单元和单元名称的宽度
                    dyDiv = $("#dy_" + fang[i].DYPX)[0];
                    var dyNameDiv = $("#dyName_" + fang[i].DYPX)[0];
                    if (dyDiv.style.width.substring(0, dyDiv.style.width.length - 2) < (p.jian_width + p.fang_width) * fang[i].PX + p.jian_width) {
                        dyDiv.style.width = (p.jian_width + p.fang_width) * fang[i].PX + p.jian_width + "px";
                        dyNameDiv.style.width = (p.jian_width + p.fang_width) * fang[i].PX + p.jian_width + "px";
                    }
                }
                //单元的高度，得到最大高度，最后再一起设置
                if (dyDiv_height < (p.jian_height + p.fang_height) * (parseInt(fang[i].LC) + parseInt(fang[i].YC)) + p.jian_height + p.dy_name_height) {
                    dyDiv_height = (p.jian_height + p.fang_height) * (parseInt(fang[i].LC) + parseInt(fang[i].YC)) + p.jian_height + p.dy_name_height;
                }
                //新建房屋
                var fangDiv = document.createElement("div");
                fangDiv.id = "fj_" + fang[i].LC + "_" + fang[i].PX;
                fangDiv.className = "lpb_fangDiv";
                if (fang[i].IMG) {
                    fangDiv.innerHTML = "<table width='100%' height='100%'><tr><td style='vertical-align:middle;'><span style='cursor:pointer;' onclick=\"a ('" + fang[i].HOUSECODE + "')\">" + fang[i].NAME + "</span>" +
                    "<br><img height='" + p.img_height + "' width='" + p.img_width + "' src='" + fang[i].IMG + "'><br>" + fang[i].REN + "</td></tr></table>";
                } else {
                    fangDiv.innerHTML = "<table width='100%' height='100%'><tr><td style='vertical-align:middle;'><span style='cursor:pointer;' onclick=\"a ('" + fang[i].HOUSECODE + "')\">" + fang[i].NAME + "</span><br>" + fang[i].REN + "</td></tr></table>";
                }
                var fangleft = (fang[i].PX * p.jian_width + (fang[i].PX - 1) * p.fang_width) < 0 ? "0" : (fang[i].PX * p.jian_width + (fang[i].PX - 1) * p.fang_width);
                fangDiv.style.left = fangleft + "px";//房间左距为排序个间隔+排序减一个房宽
                var fangbottom = (fang[i].LC * p.jian_height + (fang[i].LC - 1) * p.fang_height) < 0 ? "0" : (fang[i].LC * p.jian_height + (fang[i].LC - 1) * p.fang_height);
                fangDiv.style.bottom = fangbottom + "px";//房间底距为排序个间隔+排序减一个房高
                fangDiv.style.width = fang[i].YF == "0" ? p.fang_width + "px" : p.fang_width + fang[i].YF * (p.jian_width + p.fang_width) + "px";//跃房宽度处理
                fangDiv.style.height = fang[i].YC == "0" ? p.fang_height + "px" : p.fang_height + fang[i].YC * (p.jian_height + p.fang_height) + "px";//跃层高速度处理
                for (var j = 0; j < p.fang_bgcolor.length; j++) {
                    if (p.fang_bgcolor[j].code == fang[i].CODE_COLOR) {
                        fangDiv.style.backgroundColor = p.fang_bgcolor[j].color;
                    }
                }
                //添加进单元
                dyDiv.appendChild(fangDiv);
            }
        }
        //设置单元名称距离底部距离
        var dy = getClass("div", "lpb_dyNameDiv");
        for (var i = 0; i < dy.length; i++) {
            dy[i].style.bottom = dyDiv_height - p.dy_name_height + "px";
        }
        //楼层设置
        louc.style.width = p.louc_width + "px";
        louc.style.height = dyDiv_height + "px";
        louc.style.lineHeight = p.fang_height + p.jian_height + "px";
        louc.className = "lpb_louc";
        louc.innerHTML = "<div style='height:" + p.dy_name_height + "px;line-height:" + p.dy_name_height + "px;'>单元</div>";
        var n = (dyDiv_height - p.dy_name_height - p.jian_height) / (p.fang_height + p.jian_height);
        for (var i = n; i > 0; i--) {
            louc.innerHTML += "楼层" + i + "<br>";
        }
        //初始化所有单元的宽度
        var dywidth = 0;
        //把所有单元统一设置高速
        $("#lpb").find(".lpb_dyDiv").each(function (i) {
            $(this).height(dyDiv_height);//设置单元高度
            dywidth += $(this).width() + 2;//获取单元宽度
        });
        //设置总框架的宽度
        var all_width = dywidth + p.louc_width + 1;
        $(c).width(all_width);
        //图例-放在房屋容器的上面
        var tlDiv = document.createElement("div");
        var tlHtml = "<table style='border:1px solid #cccccc; margin-bottom:1px;' ><tr><td style='width:50px;'>图例：</td>";
        for (var i = 0; i < p.fang_img.length; i++) {
            tlHtml += "<td style='width:20px;'><img height='18' width='18' src='" + p.fang_img[i].url + "' /></td><td style='width:60px;'>" + p.fang_img[i].name + "</td>";
        }
        for (var i = 0; i < p.fang_bgcolor.length; i++) {
            tlHtml += "<td style='width:20px;'><div style='width:20px; height:10px; background-color:" + p.fang_bgcolor[i].color + "'></div></td><td style='width:60px;'>" + p.fang_bgcolor[i].name + "</td>";
        }
        tlHtml += "<td style='width:auto;'></td></tr></table>";
        tlDiv.innerHTML = tlHtml;
        $(c).before(tlDiv);
        //地下室
        if (dixiashi.length > 0) {
            //新建地下室
            var dixiashiDiv = document.createElement("div");
            dixiashiDiv.style.width = all_width + "px";
            var dxsHtml = "<table width='100%' style='border:1px solid #cccccc; margin-top:1px;'><tr>";
            for (var i = 0; i < dixiashi.length; i++) {
                dxsHtml += "<td style='background-color:#ff00ff;text-align:center;'><span style='cursor:pointer;' onclick='alert(\"" + dixiashi[i].NAME + "\")'>" + dixiashi[i].NAME + "</span></td>";
            }
            dxsHtml += "</tr></table>";
            dixiashiDiv.innerHTML = dxsHtml;
            $(c).after(dixiashiDiv);
        }
        //底商
        if (dishang.length > 0) {
            //新建底商
            var dishangDiv = document.createElement("div");
            dishangDiv.style.width = all_width + "px";
            var dsHtml = "<table width='100%' style='border:1px solid #cccccc; margin-top:1px;'><tr>";
            for (var i = 0; i < dishang.length; i++) {
                dsHtml += "<td style='background-color:#ffff00;text-align:center;'><span style='cursor:pointer;' onclick='alert(\"" + dishang[i].NAME + "\")'>" + dishang[i].NAME + "</span></td>";
            }
            dsHtml += "</tr></table>";
            dishangDiv.innerHTML = dsHtml;
            $(c).after(dishangDiv);
        }
        return c;
    };
    //初始化方法
    $.fn.lpb = function (p) {
        $.lpb(this, p);
    };
})(jQuery);