var map, layer, PolygonLayer, pointLayer, ppLayer, heatMapLayer, element, content, tipsment, closer, custompplayerStyleFunction;
var selectPointMove, selectPoint, selectPoiMove, lishiguiji, guijitimer, array, selectPtMove;
var point_left = 0;
var point_right = 0;
var point_top = 0;
var point_bottom = 0;
var min_point_left = 0;
var min_point_right = 0;
var min_point_top = 0;
var min_point_bottom = 0;
var Bounds = "";
var pointSource = new ol.source.Vector();
var speed = 1000;
var zanting = false;
var c = 0;
var strokeColor = ["#a00002", "#91bb28", "#ff6600", "#5a7087", "#183462"];
var fillColor = ["#e3542e", "#a5c758", "#ff9d00", "#bbc7cf", "#4ea1e3"];
//自定义缩放平移控件
ol.control.zoomsld = function (opt_options) {
    var options = opt_options || {};

    var slideFactor = 50;
    var inited = false;
    var slideRatio = null;
    var img = "url(/GSM_V3.0/resource/js/map_ol3/img/mapcontrols3.png)";
    var bimg = "url(/GSM_V3.0/resource/js/map_ol3/img/blank.gif)";
    this.position = [5, 10];
    var element = document.createElement('div');
    element.className = 'zoombar';
    this.div = element;
    px = this.position || px;
    setPos(this.div, px[0], px[1], 64.5, 190, 1100, this);
    var self = this;
    var zoomin = document.createElement("div");
    zoomin.id = "zoomin";
    zoomin.title = "放大";
    setPos(zoomin, 14, 46, 20, 18, 10, this);
    setBG(zoomin, img, "0px -221px", "initial initial", null, null, null, null, null);
    this.div.appendChild(zoomin);
    zoomin.onclick = function (e) {
        return self.onclick(e)
    };
    zoomin.ondblclick = function (e) {
        stopEvent(e);
        return true
    };
    zoomin.onmouseover = function (e) {
        zoomin.style.backgroundPosition = "0px -243px"
    };
    zoomin.onmouseout = function (e) {
        zoomin.style.backgroundPosition = "0px -221px"
    };
    var zoomout = document.createElement("div");
    zoomout.id = "zoomout";
    zoomout.title = "缩小";
    setPos(zoomout, 14, 176, 20, 18, 10, this);
    setBG(zoomout, img, "0px -265px", "initial initial", null, null, null, null, null);
    this.div.appendChild(zoomout);
    zoomout.onclick = function (e) {
        return self.onclick(e)
    };
    zoomout.ondblclick = function (e) {
        stopEvent(e);
        return true
    };
    zoomout.onmouseover = function (e) {
        zoomout.style.backgroundPosition = "0px -287px"
    };
    zoomout.onmouseout = function (e) {
        zoomout.style.backgroundPosition = "0px -265px"
    };

    var pan = document.createElement("div");
    pan.title = "";
    setPos(pan, 2, 0, 42, 43, 10, this);
    setBG(pan, img, "0px 0px", "initial initial", null, null, null, null, null);
    this.div.appendChild(pan);
    pan.onmouseout = function (e) {
        pan.style.backgroundPosition = "0px 0px"
    };
    var panleft = document.createElement("div");
    panleft.id = "panleft";
    panleft.title = "左移";
    setPos(panleft, 0, 12, 12, 12, 10, this);
    pan.appendChild(panleft);
    panleft.onclick = function (e) {
        return self.onclick(e)
    };
    panleft.ondblclick = function (e) {
        stopEvent(e);
        return true
    };
    panleft.onmouseover = function (e) {
        pan.style.backgroundPosition = "0px -176px"
    };
    var panright = document.createElement("div");
    panright.id = "panright";
    panright.title = "右移";
    setPos(panright, 27, 11, 12, 12, 10, this);
    pan.appendChild(panright);
    panright.onclick = function (e) {
        return self.onclick(e)
    };
    panright.ondblclick = function (e) {
        stopEvent(e);
        return true
    };
    panright.onmouseover = function (e) {
        pan.style.backgroundPosition = "0px -88px"
    };
    var panup = document.createElement("div");
    panup.id = "panup";
    panup.title = "上移";
    setPos(panup, 13, 0, 12, 12, 10, this);
    pan.appendChild(panup);
    panup.onclick = function (e) {
        return self.onclick(e)
    };
    panup.ondblclick = function (e) {
        stopEvent(e);
        return true
    };
    panup.onmouseover = function (e) {
        pan.style.backgroundPosition = "0px -44px"
    };
    var pandown = document.createElement("div");
    pandown.id = "pandown";
    pandown.title = "下移";
    setPos(pandown, 13, 25, 12, 12, 10, this);
    pan.appendChild(pandown);
    pandown.onclick = function (e) {
        return self.onclick(e)
    };
    pandown.ondblclick = function (e) {
        stopEvent(e);
        return true
    };
    pandown.onmouseover = function (e) {
        pan.style.backgroundPosition = "0px -132px"
    };

    var bar = document.createElement("div");
    setPos(bar, 21, 64, 6, 111, 3, this);
    setBG(bar, img, "-24px -225px", "no-repeat no-repeat", null, null, null, null, null);
    this.div.appendChild(bar);
    var bar2 = document.createElement("div");
    setPos(bar2, -6, 37, 18, 10, 5, this);
    setBG(bar2, img, "0px -309px", "initial initial", null, null, null, null, null);
    bar2.style.cursor = "pointer";
    bar.appendChild(bar2);
    var bar2down = false;
    var mouseY = 0;
    bar2.onmousedown = function (e) {
        e = e || window.event;
        stopEvent(e);
        bar2down = true;
        mouseY = e.screenY
    };
    bar2.onmouseup = function (e) {
        stopEvent(e);
        bar2down = false
    };
    bar2.onmouseover = function (e) {
        bar2.style.backgroundPosition = "0px -320px"
    };
    bar.onmouseout = function (e) {
        bar2down = false;
        bar2.style.backgroundPosition = "0px -309px"
    };
    var bar3 = document.createElement("div");
    bar.onmousemove = function (e) {
        e = e || window.event;
        stopEvent(e);
        var o = e.screenY - mouseY;
        if (bar2down) {
            var len = toint(bar.style.height);
            var newpos = toint(bar2.style.top) + o;
            var d = len - newpos;
            var level = Math.round(d * 18 / len);
            bar2.style.top = newpos + "px";
            bar3.style.top = newpos + "px";
            bar3.style.height = (toint(bar.style.height) - newpos + toint(bar2.style.height)) + "px";
            self.nozoomed = true;
            self.getMap().getView().setZoom(level);
            self.nozoomed = false
        }
        mouseY = e.screenY
    };
    setPos(bar3, 0, 37, 6, 111 - 37, 4, this);
    setBG(bar3, img, "-33px 100%", "no-repeat no-repeat", "auto", "padding-box", "border-box", "transparent", "scroll");
    bar.appendChild(bar3);
    this.bar = bar;
    this.bar2 = bar2;
    this.bar3 = bar3;
    this.zoomin = zoomin;
    this.zoomout = zoomout;
    var btns = document.createElement("div");
    setPos(btns, 18, 50, 45, 152, 2, this);
    setBG(btns, bimg, "0px -400px", "no-repeat no-repeat", "auto", "padding-box", "border-box", "transparent", "scroll");
    this.div.appendChild(btns);

    if (!inited) {
        var level = map.getView().getZoom();
        if (this.nozoomed) {
            return
        }
        var barr = this.bar;
        var barr2 = this.bar2;
        var barr3 = this.bar3;
        var zoominr = this.zoomin;
        var zoomoutr = this.zoomout;
        var len = toint(barr.style.height);
        var pos = len - len * level / 10;
        barr2.style.top = (pos) + "px";
        pos += toint(barr2.style.height);
        barr3.style.top = (pos) + "px";
        barr3.style.height = (toint(barr.style.height) - pos + toint(barr2.style.height)) + "px";
        inited = true;
    }
    map.on('moveend', function (e) {
        self.zoomend();
    });

    ol.control.Control.call(this, {
        element: element,
        target: options.target
    });
}
ol.inherits(ol.control.zoomsld, ol.control.Control);
//控制滑动条和滑块的位置
ol.control.zoomsld.prototype.zoomend = function () {
    var level = this.getMap().getView().getZoom();
    if (this.nozoomed) {
        return
    }
    var barr = this.bar;
    var barr2 = this.bar2;
    var barr3 = this.bar3;
    var zoominr = this.zoomin;
    var zoomoutr = this.zoomout;
    var len = toint(barr.style.height);
    var pos = len - len * level / 10;
    barr2.style.top = (pos) + "px";
    pos += toint(barr2.style.height);
    barr3.style.top = (pos) + "px";
    barr3.style.height = (toint(barr.style.height) - pos + toint(barr2.style.height)) + "px";
}
//工具条的所有点击事件
ol.control.zoomsld.prototype.onclick = function (e) {
    e = e || window.event;
    stopEvent(e);
    var obj = e.srcElement ? e.srcElement : e.target;
    switch (obj.id) {
        case "panup":
            var view = this.getMap().getView();
            var center = view.getCenter();
            var pan = ol.animation.pan({            //应用内置的动画，实现平移动画
                duration: 300,
                source: center
            });
            this.getMap().beforeRender(pan);        //使用beforeRender来添加
            view.setCenter([center[0], center[1] + 0.02]);          //重新设置地图中心点到原来的位置
            break;
        case "pandown":
            var view = this.getMap().getView();
            var center = view.getCenter();
            var pan = ol.animation.pan({
                duration: 300,
                source: center
            });
            this.getMap().beforeRender(pan);
            view.setCenter([center[0], center[1] - 0.02]);
            break;
        case "panleft":
            var view = this.getMap().getView();
            var center = view.getCenter();
            var pan = ol.animation.pan({
                duration: 300,
                source: center
            });
            this.getMap().beforeRender(pan);
            view.setCenter([center[0] - 0.02, center[1]]);
            break;
        case "panright":
            var view = this.getMap().getView();
            var center = view.getCenter();
            var pan = ol.animation.pan({
                duration: 300,
                source: center
            });
            this.getMap().beforeRender(pan);
            view.setCenter([center[0] + 0.02, center[1]]);
            break;
        case "zoomin":
            var view = this.getMap().getView();
            var resolution = view.getResolution();
            var currentzoom = view.getZoom();
            if (currentzoom < 11) {
                var center = view.getCenter();
                var zoom = ol.animation.zoom({
                    duration: 300,
                    resolution: resolution
                });
                this.getMap().beforeRender(zoom);
                view.setResolution(resolution / 2);
                this.zoomend();
            }
            break;
        case "zoomout":
            var view = this.getMap().getView();
            var resolution = view.getResolution();
            var currentzoom = view.getZoom();
            if (currentzoom > 0) {
                var center = view.getCenter();
                var zoom = ol.animation.zoom({
                    duration: 300,
                    resolution: resolution
                });
                this.getMap().beforeRender(zoom);
                view.setResolution(resolution * 2);
                this.zoomend();
            }
            break
    }
    return true
}
//自定义控件绘图工具条
ol.control.panel = function (opt_options) {

    var options = opt_options || {};
    var para = options.para ? options.para : '';
    var source = options.source ? options.source : '';
    var features = options.features ? options.features : '';
    var element = document.createElement('div');
    element.className = 'panelbar';
    element.style.height = "225px";
    element.style.width = "25px";

    var styles = new ol.style.Style({
        fill: new ol.style.Fill({
            color: ' rgba(255, 0, 0, 0.3)'
        }),
        stroke: new ol.style.Stroke({
            color: '#ff0000',
            width: 2
        }),
        image: new ol.style.Icon({
            anchor: [0.38, 1],
            anchorXUnits: 'fraction',
            anchorYUnits: 'fraction',
            opacity: 0.75,
            scale: 0.75,           //缩放比例
            src: '/GSM_V3.0/resource/js/map_ol3/img/marker_red.png'
        })
    });

    var draw, select, featuremodify;
    var point = document.createElement("img");
    point.title = "画点";
    point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
    element.appendChild(point);
    point.onclick = function () {
        if (para.Point) {
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_on.png";
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
            clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
            draw = new ol.interaction.Draw({
                features: features,
                type: 'Point',
                style:styles
            });
            map.addInteraction(draw);
        }
    };
    var linestring = document.createElement("img");
    linestring.title = "画线";
    linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
    element.appendChild(linestring);
    linestring.onclick = function () {
        if (para.Path) {
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_on.png";
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
            clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
            draw = new ol.interaction.Draw({
                features: features,
                type: 'LineString',
                style: styles
            })
            map.addInteraction(draw);
        }
    };
    var polgon = document.createElement("img");
    polgon.title = "画面";
    polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
    element.appendChild(polgon);
    polgon.onclick = function () {
        if (para.Polygon) {
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_on.png";
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
            clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
            draw = new ol.interaction.Draw({
                features: features,
                type: 'Polygon',
                style: styles
            })
            map.addInteraction(draw);
        }
    };
    var pan = document.createElement("img");
    pan.title = "拖动";
    pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
    element.appendChild(pan);
    pan.onclick = function () {
        if (para.Navigation) {
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_on.png";
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
            clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
        }
    };
    var modify = document.createElement("img");
    modify.title = "修改";
    modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
    element.appendChild(modify);
    modify.onclick = function () {
        if (para.Modify) {
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_on.png";
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
            clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
            select = new ol.interaction.Select({
                style: styles
                //condition: ol.events.condition.pointerMove
            });
            map.addInteraction(select);
            featuremodify = new ol.interaction.Modify({
                features: select.getFeatures(),
                style: styles
            });
            map.addInteraction(featuremodify);
            featuremodify.on('modifyend', function (evt) {
                var collection = evt.features;
                collection.forEach(function (feature) {
                    feature.setStyle(styles);
                });
            });
        }
    };
    var remove = document.createElement("img");
    remove.title = "删除";
    remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
    element.appendChild(remove);
    remove.onclick = function () {
        if (para.Remove) {
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_on.png";
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
            clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
            select = new ol.interaction.Select({
                style: function(){
                    return null;
                }
            });
            map.addInteraction(select);
            var selectedFeatures = select.getFeatures();
            selectedFeatures.on('add', function (event) {
                var feature = event.element;
                features.remove(feature);
            });
        }
    };
    var save = document.createElement("img");
    save.title = "保存";
    save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
    element.appendChild(save);
    save.onclick = function () {
        if (para.Save) {
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_on.png";
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
            clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
            var pointsstring = "";
            for (var i = 0 ; i < features.getLength(); i++) {
                var geom = source.getFeatures()[i].getGeometry();
                if(geom instanceof ol.geom.LineString)
                {
                    var geomcoor=geom.getCoordinates(true);
                    for (var t = 0; t < geomcoor.length; t++)
                    {
                        pointsstring+=geomcoor[t][0]+","+geomcoor[t][1]+";";
                    }
                } 
                else if (geom instanceof ol.geom.Point)
                {
                    var geomcoor=geom.getCoordinates(true);
                    pointsstring += geomcoor[0] + "," + geomcoor[1] + ";";
                }
                else if(geom instanceof ol.geom.Polygon)
                {
                    var geomcoor = geom.getCoordinates(true);
                    var geomcoor0=geomcoor[0];
                    for (var t = 0; t < geomcoor0.length; t++)
                    {
                        pointsstring += geomcoor0[t][0] + "," + geomcoor0[t][1] + ";";
                    }
                }
                pointsstring = pointsstring.substring(0, pointsstring.length - 1) + "#";
            }
                para.getResult(pointsstring.substring(0, pointsstring.length - 1));
        };
    };
    var close = document.createElement("img");
    close.title = "关闭";
    close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
    element.appendChild(close);
    close.onclick = function () {
        if (para.Close) {
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_on.png";
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
            clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
            $("#" + para.id).remove();
        }
    };
    var clear = document.createElement("img");
    clear.title = "清空";
    clear.src = "/GSM_V3.0/resource/js/map_ol3/img/clear_off.png";
    element.appendChild(clear);
    clear.onclick = function () {
        if (para.Clear) {
            point.src = "/GSM_V3.0/resource/js/map_ol3/img/add_point_off.png";
            linestring.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_line_off.png";
            polgon.src = "/GSM_V3.0/resource/js/map_ol3/img/draw_polygon_off.png";
            pan.src = "/GSM_V3.0/resource/js/map_ol3/img/pan_off.png";
            modify.src = "/GSM_V3.0/resource/js/map_ol3/img/move_feature_off.png";
            remove.src = "/GSM_V3.0/resource/js/map_ol3/img/remove_point_off.png";
            save.src = "/GSM_V3.0/resource/js/map_ol3/img/save_off.png";
            close.src = "/GSM_V3.0/resource/js/map_ol3/img/close_off.png";
            if (draw != null && draw != undefined) {
                map.removeInteraction(draw);
            }
            if (select != null && select != undefined) {
                map.removeInteraction(select);
            }
            if (featuremodify != null && featuremodify != undefined) {
                map.removeInteraction(featuremodify);
            }
            features.clear();
        }
    };
    ol.control.Control.call(this, {
        element: element,
        target: options.target
    });
}
ol.inherits(ol.control.panel, ol.control.Control);
//自定义控件图层切换按钮
ol.control.LayerSwitcher = function (opt_options) {
    var options = opt_options || {};
    var this_ = this;
    var element = document.createElement('div');
    element.className = 'map_maptype';

    var ul = document.createElement("ul");
    element.appendChild(ul);
    this.div = ul;
    var li0 = document.createElement("li");
    li0.className = "t_sep";
    ul.appendChild(li0);

    var li1 = document.createElement("li");
    li1.className = "";
    li1.innerHTML = "<p>地图</p>";
    ul.appendChild(li1);

    var li2 = document.createElement("li");
    li2.className = "t_sep";
    ul.appendChild(li2);

    var li3 = document.createElement("li");
    li3.className = "";
    li3.innerHTML = "<p>卫星</p>";
    ul.appendChild(li3);

    var li4 = document.createElement("li");
    li4.className = "t_sep";
    ul.appendChild(li4);

    li1.onmousedown = function (e) {
        this_.setCurrent(0);
    };
    li3.onmousedown = function (e) {
        li2.className = "t_sep t_sep_c";
        li3.className = "now_li";
        li4.className = "t_sep t_sep_c";
        this_.setCurrent(1);
    };

    this_.setCurrent(0);

    ol.control.Control.call(this, {
        element: element,
        target: options.target
    });
}
ol.inherits(ol.control.LayerSwitcher, ol.control.Control);
ol.control.LayerSwitcher.prototype.setCurrent = function (t) {
    this.div.children[0].className = (t == 0) ? "t_sep t_sep_c" : "t_sep";
    this.div.children[1].className = (t == 0) ? "now_li" : "";
    this.div.children[2].className = (t == 0 || t == 1) ? "t_sep t_sep_c" : "t_sep";
    this.div.children[3].className = (t == 1) ? "now_li" : "";
    this.div.children[4].className = (t == 2 || t == 1) ? "t_sep t_sep_c" : "t_sep";
    if (this.getMap()) {
        var aa = this.getMap().getLayers();
        if (t == 0) {
            for (i = 0; i < aa.values_.length; i++) {
                if (aa.array_[i].values_.title == "影像") {
                    aa.array_[i].values_.visible = false;
                }
                if (aa.array_[i].values_.title == "矢量") {
                    aa.array_[i].values_.visible = true;
                }
            }
        } else {
            if (t == 1) {
                for (i = 0; i < aa.values_.length; i++) {
                    if (aa.array_[i].values_.title == "矢量") {
                        aa.array_[i].values_.visible = false;
                    }
                    if (aa.array_[i].values_.title == "影像") {
                        aa.array_[i].values_.visible = true;
                    }
                }
            }
        }
        this.getMap().updateSize();
    }
};
//缩放平移控件中各div在地图上的位置
function setPos(div, left, top, width, height, zIndex) {
    if (left) {
        div.style.left = left + "px";
    }
    if (top) {
        div.style.top = top + "px";
    }
    if (width) {
        div.style.width = width + "px";
    }
    if (height) {
        div.style.height = height + "px";
    }
    div.style.position = "absolute";
    div.style.overflow = "visible";
    div.style.cursor = "pointer";
    if (zIndex) {
        div.style.zIndex = zIndex;
    }
}
//缩放平移控件中各div的属性信息
function setBG(div, backgroundImage, backgroundPosition, backgroundRepeat, backgroundSize, backgroundOrigin, backgroundClip, backgroundColor, backgroundAttachment) {
    if (backgroundImage) {
        div.style.backgroundImage = backgroundImage;
    }
    if (backgroundPosition) {
        div.style.backgroundPosition = backgroundPosition;
    }
    if (backgroundSize) {
        div.style.backgroundSize = backgroundSize;
    }
    if (backgroundOrigin) {
        div.style.backgroundOrigin = backgroundOrigin;
    }
    if (backgroundClip) {
        div.style.backgroundClip = backgroundClip;
    }
    if (backgroundColor) {
        div.style.backgroundColor = backgroundColor;
    }
    if (backgroundAttachment) {
        div.style.backgroundAttachment = backgroundAttachment;
    }
}
function toint(d) {
    return parseInt(d.replace("px", ""));
}
function stopEvent(e) {
    try {
        if (typeof (e) == "undefined") {
            e = window.event;
        }
        ol.MapBrowserEvent.prototype.stopPropagation;
    } catch (ee) { }
}
//热力图
function heatmapshow(points)
{
    if (heatMapLayer !== null && heatMapLayer !== undefined)
    {
        map.removeLayer(heatMapLayer);
        heatMapLayer.getSource().clear();
    }
    try {
        map.removeAllListeners();
    } catch (e) { }
    var datasource = new ol.source.Vector();
    heatMapLayer = new ol.layer.Heatmap({            //创建heatmap图层
        title: "热力图",
        opacity: 0.9,
        radius: 15,          //圆点半径
        blur: 10               //圆点边缘模糊
    });
    map.addLayer(heatMapLayer);
    var i = j = t = 0;                                //按照points的count值从小到大排序
    var ppp;
    for (i = 0; i < points.length; i++) {
        for (j = 0; j < points.length; j++) {
            if (parseFloat(points[i].count) < parseFloat(points[j].count)) {
                t = points[i].count;
                ppp = points[i].POSITION;
                points[i].count = points[j].count;
                points[i].POSITION = points[j].POSITION;
                points[j].count = t;
                points[j].POSITION = ppp;
            }
        }
    }
    for (var p = 0; p < points.length; p++) {
        var zu = points[p].POSITION.split("#");         //每个POSITION中以#进行面的划分
        var ee = new Array();
        var cc = new Array();
        var Xmin, Ymin, Xmax, Ymax;
        for (var i = 0; i < zu.length; i++) {
            var dian = zu[i].split(";");
            var pointList = [];
            for (var j = 0; j < dian.length; j++) {
                var x1 = parseFloat(dian[j].split(",")[0]);
                var y1 = parseFloat(dian[j].split(",")[1]);
                var newPoint = new ol.geom.Circle([x1, y1]);
                pointList.push(newPoint.getCenter());
            }
            var poly = new ol.geom.Polygon([pointList]);
            var aa = poly.getExtent();                     //有多个面构成一个网格的情况，所以先找到每一个面的范围（两个点），然后做比较，得到两个点，两个点的中心点即为此网格的中心点
            for (k = 0; k < aa.length; ) {                 //将精度和纬度各自放到一个数组里
                ee.push(aa[k]);
                cc.push(aa[k+1]);
                k = k + 2;
            }
        }
        ee.sort(function (a, b) { return a - b });          //精度从小到大排序
        cc.sort(function (a, b) { return a - b });          //纬度从小到大排序
        Xmin = ee[0];
        Xmax = ee[ee.length - 1];
        Ymin = cc[0];
        Ymax = cc[ee.length - 1];
        var pos1 = [Xmin, Ymax];
        var pos2 = [Xmax, Ymin];
        var center = [(Xmin + Xmax) / 2, (Ymin + Ymax) / 2];             //两点的中心点作为网格的中心点 
        var cout = points[p].count;
        var heatfeature = new ol.Feature({
            geometry: new ol.geom.Point(center),
            weight: cout / points[points.length - 1].count           //当前点的count除以最大的count获取的结果作为weight值
        });
        datasource.addFeature(heatfeature);
        heatMapLayer.setSource(datasource);
    }
    map.getView().fit(datasource.getExtent(), map.getSize());
}

//清除热力图
function clearrelimap()
{
    heatMapLayer.getSource().clear();
}

function NMapsShow(para) {
    para = $.extend({
        id: "map", //对象ID
        showPopup: false,//显示泡泡
        points: ""//数据集合
    }, para);
    GMapsShow(para);
}
function GMapsShow(para)
{
	var div999=$('<div id="popup" class="ol-popup">    	<div class="modal-header" style="border: 0px none;border-bottom: 1px solid #DDD;"></div>       <a href="#" id="popup-closer" class="ol-popup-closer"></a>      <div id="popup-content" class="popup-content"></div> </div>');
	$("body").prepend(div999);
    closer = document.getElementById('popup-closer');
    element = document.getElementById('popup');
    content = document.getElementById('popup-content');
    tipsment = document.getElementById('tooltip');

    var proj = ol.proj.get("EPSG:4326");
    var coor = [118.17, 39.59];
    var view = new ol.View({
        center: coor,      //视图的初始中心
        zoom: 4,            //用于缩放视图的初始分辨率
        maxZoom: 11,
        projection: proj,
        maxResolution: 0.00475892201166056
    });
    map = new ol.Map({
        controls: ol.control.defaults({    //默认有zoom、rotate、attribution三个选项，且默认都为true
            attribution: false,
            zoom:false
        }),
        target: para.id,
        view: view,
        loadTilesWhileAnimating: true
    });
    
    function zeroPad(num, len, radix)
    {
        var str = num.toString(radix || 10);          //将num转换为16进制或10进制
        while (str.length < len)                      //str长度小于leg时，在str前面填0
        {
            str = "0" + str;
        }
        return str;
    }
    var tilegrid = new ol.tilegrid.TileGrid({
        origin: [-400, 400],
        resolutions: [
                   0.00475892201166056,
                   0.00237946100583028,
                   0.00118973050291514,
                   0.00059486525145757,
                   0.000297432625728785,
                   0.000152285504373138,
                   0.0000761427521865689,
                   0.0000380713760932845,
                   0.0000190356880466422,
                   0.00000951784402332112,
                   0.00000475892201166056
        ]
    });
    var urlBase = "http://192.168.2.215:8602/map/layerbase/{z}/{y}/{x}.png";
    var layerbase = new ol.layer.Tile({                                    //加载矢量图层
        title: "矢量",
        type: "base",
        visible:true,
        source: new ol.source.XYZ({            
            projection: 'EPSG:4326',
            tileGrid: tilegrid,
            tileUrlFunction: function (tileCoord, pixelRatio, proj) {
                var x = 'C' + zeroPad(tileCoord[1],8,16);
                var y = 'R' + zeroPad(-tileCoord[2] -1,8,16);
                var z = 'L' + zeroPad(tileCoord[0],2,10);
                var url = urlBase.replace('{z}', z.toString())
                                   .replace('{x}', x.toString())
                                   .replace('{y}', y.toString());
                return url;
            }
        })
    });

    var urlYX = "http://192.168.2.215:8602/map/layeryx/{z}/{y}/{x}.png";
    var layerYX = new ol.layer.Tile({
        title: "影像",                                       //加载影像图层
        type: "base",
        visible: true,
        source: new ol.source.XYZ({
            projection: 'EPSG:4326',
            tileGrid: tilegrid,
            tileUrlFunction: function (tileCoord, pixelRatio, proj) {
                var x = 'C' + zeroPad(tileCoord[1], 8, 16);
                var y = 'R' + zeroPad(-tileCoord[2] - 1, 8, 16);
                var z = 'L' + zeroPad(tileCoord[0], 2, 10);
                var url = urlYX.replace('{z}', z.toString())
                                   .replace('{x}', x.toString())
                                   .replace('{y}', y.toString());
                return url;
            }
        })
    });

    var url3d = "http://192.168.2.215:8602/map/layer3d/{z}/{y}/{x}.png";
    var layer3d = new ol.layer.Tile({
        title: "路南3D",                                        //加载3D图层
        visible: true,
        source: new ol.source.XYZ({
            projection: 'EPSG:4326',
            tileGrid: tilegrid,
            tileUrlFunction: function (tileCoord, pixelRatio, proj) {
                var x = 'C' + zeroPad(tileCoord[1], 8, 16);
                var y = 'R' + zeroPad(-tileCoord[2] - 1, 8, 16);
                var z = 'L' + zeroPad(tileCoord[0] - 4, 2, 10);
                var url = url3d.replace('{z}', z.toString())
                                   .replace('{x}', x.toString())
                                   .replace('{y}', y.toString());
                return url;
            }
        })
    });
    map.addLayer(layerYX);
    map.addLayer(layerbase);
    map.addLayer(layer3d);
    
    var customStyleFunction = function (feature, resolution) {            //面图层的stylefunction，根据当前feature获取feature的name，显示在面要素上
        return [new ol.style.Style({
            fill: new ol.style.Fill({
                color: torbga(feature.get('fillColor'), 0.3)
            }),
            stroke: new ol.style.Stroke({
                color: feature.get('strokeColor'),
                width: 1                  
            }),
            text: new ol.style.Text({
                font: '12px Calibri,sans-serif',
                textBaseline: 'middle',
                textAlign: 'center',
                text: feature.get('name'),
                fill: new ol.style.Fill({
                    color: feature.get('fillColor')
                }),
                stroke: new ol.style.Stroke({
                    color: '#fff',
                    width: 3
                })
            })
        })];
    };
    PolygonLayer = new ol.layer.Vector({
        title: "面图层",
        style: customStyleFunction
    })
    map.addLayer(PolygonLayer);
    pointLayer = new ol.layer.Vector({
        title: "点图层"
    })
    map.addLayer(pointLayer);
    
    custompplayerStyleFunction = function (feature, resolution) {            //面图层的stylefunction，根据当前feature获取feature的name，显示在面要素上
        return [new ol.style.Style({
        	image: new ol.style.Icon({
                anchor: [0.5, 0.5],
                anchorXUnits: 'fraction',
                anchorYUnits: 'pixels',
                opacity: 0.75,
                src: '/GSM_V3.0/resource/js/map_ol3/img/marker-green.png'
            }),
            text: new ol.style.Text({
                font: '12px Calibri,sans-serif',
                textBaseline: 'middle',
                textAlign: 'center',
                text: feature.get('name'),
                fill: new ol.style.Fill({
                    color: '#000'
                }),
                stroke: new ol.style.Stroke({
                    color: '#fff',
                    width: 3
                })
            })
        })];
    };    
    ppLayer = new ol.layer.Vector({
        title: "person图层",
        style: custompplayerStyleFunction
    })
    map.addLayer(ppLayer);

    var scaleLineControl = new ol.control.ScaleLine();                    //添加比例尺，单位m
    scaleLineControl.setUnits(ol.control.ScaleLineUnits.METRIC);  
    map.addControl(scaleLineControl);
    
    map.addControl(new ol.control.OverviewMap);             //添加鹰眼控件
      
    var zoomSilder = new ol.control.zoomsld();           //添加扩展的缩放工具条控件
    map.addControl(zoomSilder);
    
    var layerSwitcher = new ol.control.LayerSwitcher();             //添加扩展的图层切换控件
    map.addControl(layerSwitcher);
}
//计算墨卡托范围
function getboud(x, y) {
    if (point_left == 0) {
        point_left = x;
    } else if (point_left > x) {
        point_left = x;
    }
    if (point_right == 0) {
        point_right = x;
    } else if (point_right < x) {
        point_right = x;
    }
    if (point_top == 0) {
        point_top = y;
    } else if (point_top < y) {
        point_top = y;
    }
    if (point_bottom == 0) {
        point_bottom = y;
    } else if (point_bottom > y) {
        point_bottom = y;
    }
    var lonlatmin = { x: point_left, y: point_bottom };
    var lonlatmax = { x: point_right, y: point_top };
    var b = { minx: 0, miny: 0, maxx: 0, maxy: 0 };
    b.minx = lonlatmin.x;
    b.miny = lonlatmin.y;
    b.maxx = lonlatmax.x;
    b.maxy = lonlatmax.y;
    return b;
}
//颜色随机数
function getclnum() {
    var num = Math.floor(Math.random() * 5);
    if (num != c) {
        c = num;
    } else {
        getclnum();
    }
}
//转换成rgb颜色值同时将透明度添加到rgba中
function torbga(colorValue, alp)
{
    var red = parseInt('0x' + colorValue.substr(1, 2));
    var green = parseInt('0x' + colorValue.substr(3, 2));
    var blue = parseInt('0x' + colorValue.substr(5, 2));
    var alf = alp;
    return "rgba(" + red + "," + green + "," + blue + "," + alf + ")";
}
//双击坐标框画图形
function drawmap(points, destroylayer) {
    point_left = 0;
    point_right = 0;
    point_top = 0;
    point_bottom = 0;
    if (destroylayer) {
        layer.getSource().clear();
    }
    var zu = points.split("#");
    for (var i = 0; i < zu.length; i++) {
        var dian = zu[i].split(";");
        if (dian.length == 1) {                               //点要素情况
            var x = parseFloat(dian[0].split(",")[0]);
            var y = parseFloat(dian[0].split(",")[1]);
            var pos = [x, y];
            var feat = new ol.Feature({
                geometry: new ol.geom.Point(pos)
            })
            layer.getSource().addFeature(feat);
            map.getView().setCenter(pos);
        } else {                                               //面要素情况
            var pointList = [];
            for (var j = 0; j < dian.length; j++) {
                var x = parseFloat(dian[j].split(",")[0]);
                var y = parseFloat(dian[j].split(",")[1]);
                var lonlat = [x, y];
                var newPoint = new ol.geom.Circle([x, y]);
                pointList.push(newPoint.getCenter());
            }
            var vectorFea = new ol.Feature({
                geometry: new ol.geom.Polygon([pointList])
            });
            layer.getSource().addFeature(vectorFea);
            map.getView().fit(layer.getSource().getExtent(), map.getSize());         //当前窗口显示范围
        }
    }
}
//画图形单个、多个点、面
function drawmapshow(points, destroylayer, shouPopup, isLouDong)
{
    if (pointLayer.getSource() != null) {
        pointLayer.getSource().clear();
    }
    if (PolygonLayer.getSource() != null) {
        PolygonLayer.getSource().clear();
    }
    if (pointSource != null && pointSource != undefined) {
        pointSource.clear();
    }
    try {
        heatMapLayer.getSource().clear();
    } catch (e) { } 
    try {
        map.getOverlays().clear();
    } catch (e) { }
    try {
        map.removeInteraction(selectPointMove);
    } catch (e) { }
    try {
        map.removeInteraction(selectPoint);
    } catch (e) { }
    try {
        map.removeInteraction(selectPoiMove);
    } catch (e) { }
    try {
        map.removeInteraction(selectPtMove);
    } catch (e) { }
    var vectorSource = new ol.source.Vector();
    var vectorSrc = new ol.source.Vector();

    closer.onclick = function () {                 //关闭弹出框
        element.style.display = 'none';
        closer.blur();
        return false;
    };
    var iconStyle = new ol.style.Style({             //点要素的样式
        image: new ol.style.Icon({
            anchor: [0.5, 0.5],
            anchorXUnits: 'fraction',
            anchorYUnits: 'pixels',
            opacity: 0.75,
            src: '/GSM_V3.0/resource/js/map_ol3/img/marker-green.png'
        }),
        text: new ol.style.Text({
            font: '12px Calibri,sans-serif',
            textBaseline: 'middle',
            textAlign: 'center',
            fill: new ol.style.Fill({
                color: '#000'
            }),
            stroke: new ol.style.Stroke({
                color: '#fff',
                width: 3
            })
        })
    });
    selectPointMove = new ol.interaction.Select({
        condition: ol.events.condition.pointerMove,
        layers: [pointLayer],
        style: iconStyle
    });
    map.addInteraction(selectPointMove);
    selectPointMove.on('select', function (e) {
        if (e.selected.length > 0)                         //鼠标移入，选择了一个，大致是mouseover事件
        {
            var tips = new ol.Overlay({
                element: tipsment,
            })
            map.addOverlay(tips);
            tipsment.innerHTML = e.selected[0].values_.name;
            tipsment.style.display = 'block';
            var geometry = e.selected[0].getGeometry();
            var coord = geometry.getCoordinates();
            tips.setPosition(coord);

        }
        else if (e.deselected.length > 0)                   //鼠标移出，放弃选择，大致是mouseout事件功能
        {
            //map.removeOverlay(tips);
            tipsment.style.display = 'none';
        }
    });
    map.on('click', function (evt) {                             //单击弹出详细信息的click函数
        var feature = map.forEachFeatureAtPixel(evt.pixel,
            function (feature) {
                return feature;
            });
        if (feature) {
            var popup = new ol.Overlay({
                element: element,
                positioning: 'bottom-center'
                //stopEvent: false
            });
            map.addOverlay(popup);
            var geometry = feature.getGeometry();
            var coord = geometry.getCoordinates();
            if (coord.length === 2) {
                popup.setPosition(coord);
                content.innerHTML = feature.values_.html;
                element.style.display = 'block';
                feature.setStyle(iconStyle);
            }
            else {
                if (shouPopup) {
                    popup.setPosition(evt.coordinate);
                    content.innerHTML = feature.values_.html;
                    element.style.display = 'block';
                }
            }
        }
    });
    points = eval("(" + points + ")");
    for (var p = 0; p < points.length; p++)
    {
        var zu = points[p].POSITION.split("#");
        for (var i = 0; i < zu.length; i++)
        {
            var dian = zu[i].split(";");           
            if (dian.length == 1) {                          //点要素情况
                var x = parseFloat(dian[0].split(",")[0]);
                var y = parseFloat(dian[0].split(",")[1]);               
                var pos = [x, y];     
                var currenthtml = points[p].HTML;
                var currentname = points[p].NAME;
                var iconFeature = new ol.Feature({
                    geometry: new ol.geom.Point(pos),
                    name: currentname,
                    html: currenthtml
                })
                vectorSource.addFeature(iconFeature);                              
                pointLayer.setSource(vectorSource);
                pointLayer.setStyle(iconStyle);
                //map.getView().fit(iconFeature.getGeometry().getExtent(), map.getSize());               
                var popup = new ol.Overlay({
                    element: element,
                    positioning: 'bottom-center'
                    //stopEvent: false
                });
                map.addOverlay(popup);
                if (shouPopup) {
                    popup.setPosition(pos);
                    element.style.display = 'block';
                    content.innerHTML = currenthtml;
                    map.getView().setCenter(pos);
                }
            }
            else                                                 //面要素情况
            {
            	getclnum();
                var pointList = [];               
                for (var j = 0; j < dian.length; j++) {
                    var x1 = parseFloat(dian[j].split(",")[0]);
                    var y1 = parseFloat(dian[j].split(",")[1]);
                    var newPoint = new ol.geom.Circle([x1, y1]);
                    pointList.push(newPoint.getCenter());                   
                }
                var vectorFeature = new ol.Feature({
                    geometry: new ol.geom.Polygon([pointList]),
                    name: points[p].NAME,
                    html: points[p].HTML,
                    strokeColor: strokeColor[c],
                    fillColor: fillColor[c]
                });
                vectorSrc.addFeature(vectorFeature);
                PolygonLayer.setSource(vectorSrc);
                map.getView().fit(vectorSrc.getExtent(), map.getSize());                              
            }            
        }
    }
}
//画楼栋人
function drawmapshowperson(points, shouPopup)
{
    if (pointLayer.getSource() != null) {
        pointLayer.getSource().clear();
    }
    if (PolygonLayer.getSource() != null) {
        PolygonLayer.getSource().clear();
    }
    try {
        heatMapLayer.getSource().clear();
    } catch (e) { } 
    try {
        map.removeInteraction(selectPointMove);
    } catch (e) { }
    try {
        map.removeInteraction(selectPoint);
    } catch (e) { }
    try {
        map.removeInteraction(selectPoiMove);
    } catch (e) { }
    try {
        map.removeInteraction(selectPtMove);
    } catch (e) { }
    point_left = 0;
    point_bottom = 0;
    point_right = 0;
    point_top = 0;

    points = eval("(" + points + ")");
    var sop = points.POSITION;
    for (var i = 0; i < sop.split(";").length; i++) {
        Bounds = getboud(parseFloat(sop.split(";")[i].split(",")[0]), parseFloat(sop.split(";")[i].split(",")[1]));
    }
    var x = Bounds.minx + (Bounds.maxx - Bounds.minx) * Math.random();
    var y = Bounds.miny + (Bounds.maxy - Bounds.miny) * Math.random();

    //var mapExtent = [Bounds.minx, Bounds.miny, Bounds.maxx, Bounds.maxy];
    var pos = [x, y];
    var currenthtml = points.HTML;    
    var pointFeature = new ol.Feature({
        geometry: new ol.geom.Point(pos),
        html: points.HTML,
        name: points.NAME
    })
    pointSource.addFeature(pointFeature);

    var pointStyle = new ol.style.Style({                 //点要素样式
        image: new ol.style.Icon({
            anchor: [0.5, 0.5],
            anchorXUnits: 'fraction',
            anchorYUnits: 'pixels',
            opacity: 0.75,
            src: '/GSM_V3.0/resource/js/map_ol3/img/marker-green.png'
        })
    });
    ppLayer.setSource(pointSource);
    //ppLayer.setStyle(pointStyle);

    var popup = new ol.Overlay({
        element: element,
        positioning: 'bottom-center'
        //stopEvent: false
    });
    closer.onclick = function () {            //关闭弹出框事件
        element.style.display = 'none';
        closer.blur();
        return false;
    };
    map.addOverlay(popup);
    if (shouPopup) {
        popup.setPosition(pos);
        element.style.display = 'block';
        content.innerHTML = points.HTML;
        map.getView().setCenter(pos);
    }

    selectPoint = new ol.interaction.Select({
        condition: ol.events.condition.pointerMove,
        layers: [ppLayer],
        //style: pointStyle
        style: custompplayerStyleFunction
    });
    map.addInteraction(selectPoint);
    selectPoint.on('select', function (e) {
        if (e.selected.length > 0)                //mousemove事件
        {
            var tips = new ol.Overlay({
                element: tipsment,
            })
            map.addOverlay(tips);
            tipsment.innerHTML = e.selected[0].values_.name;
            tipsment.style.display = 'block';
            var geometry = e.selected[0].getGeometry();
            var coord = geometry.getCoordinates();
            tips.setPosition(coord);

        }
        else if (e.deselected.length > 0)            //mouseout事件
        {
            tipsment.style.display = 'none';
        }
    });

    map.on('click', function (evt) {                           //要素的单击函数
        var feature = map.forEachFeatureAtPixel(evt.pixel,
            function (feature) {
                return feature;
            });
        if (feature) {
            if (feature.getGeometry().getCoordinates().length === 2) {
                var popup = new ol.Overlay({
                    element: element,
                    positioning: 'bottom-center'
                    //stopEvent: false
                });
                map.addOverlay(popup);
                var geometry = feature.getGeometry();
                var coord = geometry.getCoordinates();
                popup.setPosition(coord);
                content.innerHTML = feature.values_.html;
                element.style.display = 'block';
                //feature.setStyle(iconStyle);
            }
        }                     
    });
}
//清除地图上的所有要素以及轨迹
function clearMap()
{
    if (pointLayer.getSource() != null) {
        pointLayer.getSource().clear();
    }
    if (PolygonLayer.getSource() != null) {
        PolygonLayer.getSource().clear();
    }
    if (pointSource != null && pointSource != undefined) {
        pointSource.clear();
    }
    if (ppLayer.getSource() != null) {
        ppLayer.getSource().clear();
    }
    try {
        map.getOverlays().clear();
    } catch (e) { }
    try {
    	heatMapLayer.getSource().clear();
    } catch (e) { }    
    array = null;
    clearTimeout(guijitimer);              //清除timeout事件
    clearTimeout(lishiguiji);
    for (var i = 0; i < map.getLayers().getLength() ; i++) {
        if (map.getLayers().getArray()[i].get('title').indexOf("xian") >= 0 || map.getLayers().getArray()[i].get('title').indexOf("dian") >= 0 || map.getLayers().getArray()[i].get('title').indexOf("历史轨迹") >= 0) {
            map.removeLayer(map.getLayers().getArray()[i]);
            i = i - 1;
        }
    }
}
//历史轨迹
function pointdata(Track) {
    var readerCoo = new Array();
    for (var i = 0; i < Track.length; i++) {      
        readerCoox1 = Track[i].POSITION.split(",")[0]/1;
        readerCooy1 = Track[i].POSITION.split(",")[1] / 1;
        readerCoohtml = Track[i].HTML;
        readerCoo.push([readerCoox1, readerCooy1, readerCoohtml]);
    }
    startTrack(readerCoo);
}
function startTrack(readerCoo) {
    try {
        map.removeInteraction(selectPointMove);
    } catch (e) { }
    try {
        map.removeInteraction(selectPoint);
    } catch (e) { }
    try {
        map.removeInteraction(selectPoiMove);
    } catch (e) { }
    try {
        map.removeInteraction(selectPtMove);
    } catch (e) { }
    try {
        map.removeAllListeners();
    } catch (e) { }
    if (readerCoo == null || readerCoo.length <= 1) {
        alert('没有轨迹');
    } else {
        var vectorLayer = new ol.layer.Vector({
            title: "历史轨迹"
        })
        map.addLayer(vectorLayer);
        var center = [readerCoo[parseInt(readerCoo.length / 2)][0], readerCoo[parseInt(readerCoo.length / 2)][1]];
        map.getView().setCenter(center);
        var listline = new Array();
        fn(readerCoo, vectorLayer, listline,0);
    }
}
//通过延时函数循环，画历史轨迹
function fn(readerCoo, vectorLayer,listline, x) {  
    if (x < readerCoo.length) {
        var styles = {
            'LineString': new ol.style.Style({
                stroke: new ol.style.Stroke({
                    width: 2,
                    color: [255, 0, 0, 0.8]
                })
            }),
            'Point': new ol.style.Style({
                image: new ol.style.Icon({
                    anchor: [0.5, 0.5],
                    anchorXUnits: 'fraction',
                    anchorYUnits: 'pixels',
                    opacity: 0.75,
                    src: '/GSM_V3.0/resource/js/map_ol3/img/guiji_ren.gif'
                })
            })
        };
        var source = new ol.source.Vector();
        var currentPoint = new ol.geom.Point([readerCoo[x][0], readerCoo[x][1]]);
        var feature = new ol.Feature({
            html: readerCoo[x][2]
        });
        feature.setGeometry(currentPoint);
        feature.setStyle(styles.Point);
        listline.push([readerCoo[x][0], readerCoo[x][1]]);
        var currentlist = new ol.geom.LineString(listline);
        var linfeature = new ol.Feature();
        linfeature.setGeometry(currentlist);
        linfeature.setStyle(styles.LineString);
        source.addFeatures([feature, linfeature]);
        vectorLayer.setSource(source);
        selectPoiMove = new ol.interaction.Select({
            condition: ol.events.condition.pointerMove,
            layers: [vectorLayer],
            style: styles.Point
        });
        map.addInteraction(selectPoiMove);
        selectPoiMove.on('select', function (e) {
            if (e.selected.length > 0)              //mousemove事件
            {
                var tips = new ol.Overlay({
                    element: tipsment,
                })
                map.addOverlay(tips);
                tipsment.innerHTML = e.selected[0].values_.html;
                tipsment.style.display = 'block';
                var geometry = e.selected[0].getGeometry();
                var coord = geometry.getCoordinates();
                tips.setPosition(coord);
            }
            else if (e.deselected.length > 0)               //mouseout事件
            {
                tipsment.style.display = 'none';
            }
        });
        x++;
        lishiguiji = setTimeout(function () {              //添加一个timeout函数，循环
            if (!zanting) {
                fn(readerCoo, vectorLayer, listline, x);
            } else {
                timer = setInterval(function () {
                    if (!zanting) {
                        clearInterval(timer);
                        fn(readerCoo, vectorLayer, listline, x);
                    }
                }, speed);
            }
        }, speed);
    }
}
//轨迹运动速度增加
function guijifast(){
    speed = speed - 100;
}
//轨迹运动速度减慢
function guijislow() {
    speed = speed + 100;
}
//轨迹开始
function guijistart()
{
    zanting = false;
}
//轨迹暂停
function guijistop()
{
    zanting = true;
}
//实时轨迹
function stTrack(Track)
{
    var readerCoo = new Array();
    for (var i = 0; i < Track.length; i++) {
        readerCoox1 = Track[i].POSITION.split(",")[0] / 1;
        readerCooy1 = Track[i].POSITION.split(",")[1] / 1;
        readerCoohtml = Track[i].HTML;
        readerCooname = Track[i].NAME;
        readerCoo.push([readerCoox1, readerCooy1, readerCoohtml, readerCooname]);
    }
    drawMapTrack(readerCoo,0)
}
//通过延时函数循环从而实时显示轨迹
function drawMapTrack(readerCoo,x)
{  
    if (x < readerCoo.length) {
        try {
            map.removeInteraction(selectPointMove);
        } catch (e) { }
        try {
            map.removeInteraction(selectPoint);
        } catch (e) { }
        try {
            map.removeInteraction(selectPoiMove);
        } catch (e) { }
        try {
            map.removeInteraction(selectPtMove);
        } catch (e) { }
        try {
            map.removeAllListeners();
        } catch (e) { }
        var lonlat = [readerCoo[x][0], readerCoo[x][1]];
        var veclineLayer = null;
        var layers = map.getLayers();
        //判断是否存在线图层
        for (var i = 0; i < layers.values_.length; i++) {
            if (layers.array_[i].values_.title === "xian_" + readerCoo[x][3]) {
                veclineLayer = layers.array_[i];
                var source = veclineLayer.getSource();
                //source.featuresRtree_.rbush_.data.children[0][4].values_.geometry.appendCoordinate(lonlat);
                source.getFeatures()[0].getGeometry().appendCoordinate(lonlat);
            }
        }
        //新建线图层
        if (veclineLayer == null) {
            veclineLayer = new ol.layer.Vector({
                title: "xian_" + readerCoo[x][3],
                style: new ol.style.Style({
                    stroke: new ol.style.Stroke({
                        width: 3,
                        color: [255, 0, 0, 0.8]
                    })
                })
            });
            array = new Array();
            array.push(lonlat);
            var line = new ol.geom.LineString(array);
            var lineFeature = new ol.Feature();
            lineFeature.setGeometry(line);
            var source = new ol.source.Vector();
            source.addFeature(lineFeature);
            veclineLayer.setSource(source);
            map.addLayer(veclineLayer);
        }
        var markers = null;
        //判断是否存在点图层
        for (var i = 0; i < layers.values_.length; i++) {
            if (layers.array_[i].values_.title === "dian_" + readerCoo[x][3]) {
                markers = layers.array_[i];
            }
        }
        //新建点图层
        if (markers == null) {
            markers = new ol.layer.Vector({
                title: "dian_" + readerCoo[x][3],
                style: new ol.style.Style({
                    image: new ol.style.Icon({
                        anchor: [0.5, 0.5],
                        anchorXUnits: 'fraction',
                        anchorYUnits: 'pixels',
                        opacity: 0.75,
                        src: '/GSM_V3.0/resource/js/map_ol3/img/guiji_ren.gif'
                    })
                })
            });
            var point = new ol.geom.Point(lonlat);
            var pointfeature = new ol.Feature({
                html: readerCoo[x][2]
            });
            pointfeature.setGeometry(point);
            var source = new ol.source.Vector();
            source.addFeature(pointfeature);
            markers.setSource(source);
            map.addLayer(markers);
        }
        markers.getSource().clear();

        var point = new ol.geom.Point(lonlat);
        var pointfeature = new ol.Feature({
            html: readerCoo[x][2]
        });
        pointfeature.setGeometry(point);
        var source = new ol.source.Vector();
        source.addFeature(pointfeature);
        markers.setSource(source);
        //alert(readerCoo[x][3]);
        selectPtMove = new ol.interaction.Select({
            condition: ol.events.condition.pointerMove,
            layers: [markers],
            style: new ol.style.Style({
                image: new ol.style.Icon({
                    anchor: [0.5, 0.5],
                    anchorXUnits: 'fraction',
                    anchorYUnits: 'pixels',
                    opacity: 0.75,
                    src: '/GSM_V3.0/resource/js/map_ol3/img/guiji_ren.gif'
                })
            })
        });
        map.addInteraction(selectPtMove);
        selectPtMove.on('select', function (e) {
            if (e.selected.length > 0) {
                var tips = new ol.Overlay({              //mousemove事件
                    element: tipsment,
                })
                map.addOverlay(tips);
                tipsment.innerHTML = e.selected[0].values_.html;
                tipsment.style.display = 'block';
                var geometry = e.selected[0].getGeometry();
                var coord = geometry.getCoordinates();
                tips.setPosition(coord);

            }
            else if (e.deselected.length > 0) {            //mouseout事件
                tipsment.style.display = 'none';
            }
        });
        x++;       
        guijitimer = setTimeout(function () {             //添加timeout事件，实现循环，实时加载点、线
            timer = setInterval(function () {
                clearInterval(timer);
                drawMapTrack(readerCoo, x);
            }, 100);
        }, 100);        
    }
}
//清除所有轨迹
function clearMapTrack()
{
    array = null;
    clearTimeout(guijitimer);         //清除实时轨迹延迟函数
    clearTimeout(lishiguiji);         //清除历史轨迹延迟函数
    for (var i = 0; i < map.getLayers().getLength() ; i++) {
        if (map.getLayers().getArray()[i].get('title').indexOf("xian") >= 0 || map.getLayers().getArray()[i].get('title').indexOf("dian") >= 0 || map.getLayers().getArray()[i].get('title').indexOf("历史轨迹") >= 0) {
            map.removeLayer(map.getLayers().getArray()[i]);
            i = i - 1;
        }
    }
}
//传参，添加小地图
function NMaps(para) {
    para = $.extend({
        id: "map",              //对象ID
        points: "",             //数据集合
        extent: "",             //网格范围
        getResult: function (p) { },             //具体事件
        Navigation: true,             //拖动
        Point: true,            //画点
        Path: true,             //画线
        Polygon: true,          //画面
        Modify: true,           //修改
        Remove: true,           //删除
        Clear: true,            //清除
        Save: true,             //保存
        Close: true,            //关闭
        drawfeature:true        //是否加载绘图工具条
    }, para);
    initialGMaps(para);      //初始化小地图
}
//初始化小地图
function initialGMaps(para) {
    var proj = ol.proj.get("EPSG:4326");
    var coor = [118.17, 39.59];
    var view = new ol.View({
        center: coor,              //视图的初始中心
        zoom: 4,                   //用于缩放视图的初始分辨率
        maxZoom: 11,
        projection: proj,
        maxResolution: 0.00475892201166056
    });
    map = new ol.Map({
        controls: ol.control.defaults({            //默认有zoom、rotate、attribution三个选项，且默认都为true
            attribution: false,
            zoom:false
        }),
        target: para.id,
        view: view
    });

    function zeroPad(num, len, radix) {
        var str = num.toString(radix || 10);          //将num转换为16进制或10进制
        while (str.length < len)                      //str长度小于leg时，在str前面填0
        {
            str = "0" + str;
        }
        return str;
    }
    var tilegrid = new ol.tilegrid.TileGrid({
        origin: [-400, 400],
        resolutions: [
                   0.00475892201166056,
                   0.00237946100583028,
                   0.00118973050291514,
                   0.00059486525145757,
                   0.000297432625728785,
                   0.000152285504373138,
                   0.0000761427521865689,
                   0.0000380713760932845,
                   0.0000190356880466422,
                   0.00000951784402332112,
                   0.00000475892201166056
        ]
    });
    var urlBase = "http://192.168.2.215:8602/map/layerbase/{z}/{y}/{x}.png";              //20:3795
    var layerbase = new ol.layer.Tile({                                      //加载矢量图层
        title: "矢量",
        type: "base",
        source: new ol.source.XYZ({
            projection: 'EPSG:4326',
            tileGrid: tilegrid,
            tileUrlFunction: function (tileCoord, pixelRatio, proj) {
                var x = 'C' + zeroPad(tileCoord[1], 8, 16);
                var y = 'R' + zeroPad(-tileCoord[2] - 1, 8, 16);
                var z = 'L' + zeroPad(tileCoord[0], 2, 10);
                var url = urlBase.replace('{z}', z.toString())
                                   .replace('{x}', x.toString())
                                   .replace('{y}', y.toString());
                return url;
            }
        })
    });

    var urlYX = "http://192.168.2.215:8602/map/layeryx/{z}/{y}/{x}.png";
    var layerYX = new ol.layer.Tile({                                       //加载影像图层
        title: "影像",
        type: "base",
        source: new ol.source.XYZ({
            projection: 'EPSG:4326',
            tileGrid: tilegrid,
            tileUrlFunction: function (tileCoord, pixelRatio, proj) {
                var x = 'C' + zeroPad(tileCoord[1], 8, 16);
                var y = 'R' + zeroPad(-tileCoord[2] - 1, 8, 16);
                var z = 'L' + zeroPad(tileCoord[0], 2, 10);
                var url = urlYX.replace('{z}', z.toString())
                                   .replace('{x}', x.toString())
                                   .replace('{y}', y.toString());
                return url;
            }
        })
    });

    var url3d = "http://192.168.2.215:8602/map/layer3d/{z}/{y}/{x}.png";
    var layer3d = new ol.layer.Tile({                                         //加载3D图层
        title: "路南3D",
        source: new ol.source.XYZ({
            projection: 'EPSG:4326',
            tileGrid: tilegrid,
            tileUrlFunction: function (tileCoord, pixelRatio, proj) {
                var x = 'C' + zeroPad(tileCoord[1], 8, 16);
                var y = 'R' + zeroPad(-tileCoord[2] - 1, 8, 16);
                var z = 'L' + zeroPad(tileCoord[0] - 4, 2, 10);
                var url = url3d.replace('{z}', z.toString())
                                   .replace('{x}', x.toString())
                                   .replace('{y}', y.toString());
                return url;
            }
        })
    });
    map.addLayer(layerYX);
    map.addLayer(layerbase);
    map.addLayer(layer3d);

    //添加比例尺，单位m  
    var scaleLineControl = new ol.control.ScaleLine();
    scaleLineControl.setUnits(ol.control.ScaleLineUnits.METRIC);
    map.addControl(scaleLineControl);

    //添加缩放工具条  
    var zoomSilder = new ol.control.zoomsld();
    map.addControl(zoomSilder);
  //加载绘图工具条控件
    var drawfeatures = new ol.Collection();
    var drawfeaturesource = new ol.source.Vector({
        wrapX: false,
        features: drawfeatures
    });
    if (para.drawfeature) {
        var panel = new ol.control.panel({
            id: para.id,
            source: drawfeaturesource,
            features: drawfeatures,
            para: para
        });
        map.addControl(panel);
    }
    var styles = new ol.style.Style({
        fill: new ol.style.Fill({
            color: ' rgba(255, 0, 0, 0.3)'
        }),
        stroke: new ol.style.Stroke({
            color: '#ff0000',
            width: 2
        }),
        image: new ol.style.Icon({
            anchor: [0.38, 1],
            anchorXUnits: 'fraction',
            anchorYUnits: 'fraction',
            opacity: 0.75,
            scale: 0.75,           //缩放比例
            src: '/GSM_V3.0/resource/js/map_ol3/img/marker_red.png'
        })
    });
    layer = new ol.layer.Vector({
        title: "绘图",
        source: drawfeaturesource,
        style: styles
    });
    map.addLayer(layer);
    //加载鹰眼控件
    map.addControl(new ol.control.OverviewMap);
    //加载图层切换控件
    var layerSwitcher = new ol.control.LayerSwitcher();
    map.addControl(layerSwitcher);
    
  //length大于0时，定位到具体的网格
    if (para.extent.length > 0)
    {
        var zu = para.extent.split("#");
        var dsource = new ol.source.Vector();
        var dlayer = new ol.layer.Vector({
            style: new ol.style.Style({
                fill: new ol.style.Fill({
                    color: ' rgba(100, 149, 237, 0.3)'
                }),
                stroke: new ol.style.Stroke({
                    color: '#7EC0EE',
                    width: 2
                })
            })
        });
        map.addLayer(dlayer);
        for (var i = 0; i < zu.length; i++) {
            var dian = zu[i].split(";");                                                           //面要素情况
            var pointList = [];
            for (var j = 0; j < dian.length; j++) {
                var x = parseFloat(dian[j].split(",")[0]);
                var y = parseFloat(dian[j].split(",")[1]);
                var lonlat = [x, y];
                var newPoint = new ol.geom.Circle([x, y]);
                pointList.push(newPoint.getCenter());
            }
            var vectorFea = new ol.Feature({
                geometry: new ol.geom.Polygon([pointList])
            });
            
            dsource.addFeature(vectorFea);
            dlayer.setSource(dsource);
            map.getView().fit(dsource.getExtent(), map.getSize());         //当前窗口显示范围
        }
    }
    
    //length大于0 在小地图根据坐标画要素
    if (para.points.length > 0)
    {
        drawmap(para.points, false);
    }
}
//wgs-84转GCJ-02(高德)
function transform(lonlat)
{
    var point = lonlat.split(",");
    var lon = point[0];
    var lat = point[1];
    var pi = 3.1415926535897932384626;
    var a = 6378245.0;
    var ee = 0.00669342162296594323;
    function transformLat(x, y) {
        var ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
        return ret;
    }
    function transformLon(x, y) {
        var ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
        return ret;
    }
    var dLat = transformLat(lon - 105.0, lat - 35.0);
    var dLon = transformLon(lon - 105.0, lat - 35.0);
    var radLat = lat / 180.0 * pi;
    var magic = Math.sin(radLat);
    magic = 1 - ee * magic * magic;
    var sqrtMagic = Math.sqrt(magic);
    dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
    dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
    var mgLat = parseFloat(lat) + parseFloat(dLat);
    var mgLon = parseFloat(lon) + parseFloat(dLon);
    var gps = mgLon + "," + mgLat;
    return gps;
}
//坐标点转为地址
function poiToaddress(poi,obj)
{
    if (poi !== "") {
        var zu = poi.split("#");
        for (var j = 0; j < zu.length; j++) {
            var point = zu[j].split(";");
            var pointList = [];
            var ee = new Array();
            var cc = new Array();
            var Xmin, Ymin, Xmax, Ymax;
            for (var i = 0; i < point.length; i++) {
                var x1 = parseFloat(point[i].split(",")[0]);
                var y1 = parseFloat(point[i].split(",")[1]);
                ee.push(x1);
                cc.push(y1);
            }
            ee.sort(function (a, b) { return a - b });      //精度从小到大排序
            cc.sort(function (a, b) { return a - b });      //纬度从小到大排序
            Xmin = ee[0];
            Xmax = ee[ee.length - 1];
            Ymin = cc[0];
            Ymax = cc[ee.length - 1];
            var pos1 = [Xmin, Ymax];
            var pos2 = [Xmax, Ymin];
            var center = (Xmin + Xmax) / 2 + "," + (Ymin + Ymax) / 2;
            var geocoder = new AMap.Geocoder({
                city: "0315", //城市，默认：“全国”
                radius: 500 //范围，默认：500,以已知坐标为中心点，radius为半径，返回范围内兴趣点和道路信息 
            });
            geocoder.getAddress(transform(center), function (status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    geocoder_CallBack(result);
                }
            });
            function geocoder_CallBack(data) {
                var address = data.regeocode.formattedAddress; //返回地址描述
                $("#" + obj.id).val(address);
            }
        }
    }
    else {
        $("#" + obj.id).val(poi);
    }
}
