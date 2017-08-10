var map, layer, layer_point, layershow, selectControl, selectedFeature, markersTrack, popup, lonlat, ShowFeature, guijitimer,timer;
var speed = 1000;
var zanting = false;
var x = 0;
var c = 0;
var point_left = 0;
var point_right = 0;
var point_top = 0;
var point_bottom = 0;
var min_point_left = 0;
var min_point_right = 0;
var min_point_top = 0;
var min_point_bottom = 0;
var Bounds = "";
var strokeColor = ["#a00002", "#91bb28", "#ff6600", "#5a7087", "#183462"];
var fillColor = ["#e3542e", "#a5c758", "#ff9d00", "#bbc7cf", "#4ea1e3"];
var style_green = {
    strokeColor: "#ff0000",
    strokeWidth: 3,
    pointRadius: 6,
    pointerEvents: "visiblePainted"
};
var readerCoo = new Array();
function NMaps(para) {
    para = $.extend({
        id: "map", //对象ID
        points: "",//数据集合
        getResult: function (p) { },//具体事件
        Navigation: true,//拖动
        Point: true,//画点
        Path: true,//画线
        Polygon: true,//画面
        Modify: true,//修改
        Remove: true,//删除
        Clear: true,//清除
        Save: true,//保存
        Close: true//关闭
    }, para);
    initialGMaps(para);
}
function NMapsShow(para) {
    para = $.extend({
        id: "map", //对象ID
        showPopup: false,//显示泡泡
        points: ""//数据集合
    }, para);
    GMapsShow(para);
}

//地图缩放、比例尺、类型转换、鹰眼
function setPos(div, left, top, width, height, zIndex) { if (left) { div.style.left = left + "px"; } if (top) { div.style.top = top + "px"; } if (width) { div.style.width = width + "px"; } if (height) { div.style.height = height + "px"; } div.style.position = "absolute"; div.style.overflow = "visible"; div.style.cursor = "pointer"; if (zIndex) { div.style.zIndex = zIndex; } } function toggleControl(element) { if (element.value === "polygon" && element.checked) { draw.activate(); } else { draw.deactivate(); } } function setBG(div, backgroundImage, backgroundPosition, backgroundRepeat, backgroundSize, backgroundOrigin, backgroundClip, backgroundColor, backgroundAttachment) { if (backgroundImage) { div.style.backgroundImage = backgroundImage; } if (backgroundPosition) { div.style.backgroundPosition = backgroundPosition; } if (backgroundSize) { div.style.backgroundSize = backgroundSize; } if (backgroundOrigin) { div.style.backgroundOrigin = backgroundOrigin; } if (backgroundClip) { div.style.backgroundClip = backgroundClip; } if (backgroundColor) { div.style.backgroundColor = backgroundColor; } if (backgroundAttachment) { div.style.backgroundAttachment = backgroundAttachment; } } function toint(d) { return parseInt(d.replace("px", "")); } function stopEvent(e) { try { if (typeof (e) == "undefined") { e = window.event; } OpenLayers.Event.stop(e); } catch (ee) { } }
OpenLayers.Control.NLibNavigation = OpenLayers.Class(OpenLayers.Control, {
    slideFactor: 50, inited: false, slideRatio: null, initialize: function (options) { this.position = new OpenLayers.Pixel(5, 10); OpenLayers.Control.prototype.initialize.apply(this, arguments); }, destroy: function () { if (this.map) { this.map.events.unregister("zoomend", this, this.zoomend); } OpenLayers.Control.prototype.destroy.apply(this, arguments); }, setMap: function (map) { OpenLayers.Control.prototype.setMap.apply(this, arguments); this.map.events.register("zoomend", this, this.zoomend); }, draw: function (px) {
        var img = "url(" + OpenLayers.Util.getImageLocation("mapcontrols3.png") + ")"; var bimg = "url(" + OpenLayers.Util.getImageLocation("blank.gif") + ")"; OpenLayers.Control.prototype.draw.apply(this, arguments); px = this.position || px; setPos(this.div, px.x, px.y, 64.5, 190, 1100, this); var self = this; var zoomin = document.createElement("div"); zoomin.id = "zoomin"; zoomin.title = "放大"; setPos(zoomin, 14, 46, 20, 18, 10, this); setBG(zoomin, img, "0px -221px", "initial initial", null, null, null, null, null); this.div.appendChild(zoomin); zoomin.onclick = function (e) { return self.onclick(e); }; zoomin.ondblclick = function (e) { stopEvent(e); return true; }; zoomin.onmouseover = function (e) { zoomin.style.backgroundPosition = "0px -243px"; }; zoomin.onmouseout = function (e) { zoomin.style.backgroundPosition = "0px -221px"; }; var zoomout = document.createElement("div"); zoomout.id = "zoomout"; zoomout.title = "缩小"; setPos(zoomout, 14, 176, 20, 18, 10, this); setBG(zoomout, img, "0px -265px", "initial initial", null, null, null, null, null); this.div.appendChild(zoomout); zoomout.onclick = function (e) { return self.onclick(e); }; zoomout.ondblclick = function (e) { stopEvent(e); return true; }; zoomout.onmouseover = function (e) { zoomout.style.backgroundPosition = "0px -287px"; }; zoomout.onmouseout = function (e) { zoomout.style.backgroundPosition = "0px -265px"; }; var pan = document.createElement("div"); pan.title = ""; setPos(pan, 2, 0, 42, 43, 10, this); setBG(pan, img, "0px 0px", "initial initial", null, null, null, null, null); this.div.appendChild(pan); pan.onmouseout = function (e) { pan.style.backgroundPosition = "0px 0px"; }; var panleft = document.createElement("div"); panleft.id = "panleft"; panleft.title = "左移"; setPos(panleft, 0, 12, 12, 12, 10, this); pan.appendChild(panleft); panleft.onclick = function (e) { return self.onclick(e); }; panleft.ondblclick = function (e) { stopEvent(e); return true; }; panleft.onmouseover = function (e) { pan.style.backgroundPosition = "0px -176px"; }; var panright = document.createElement("div"); panright.id = "panright"; panright.title = "右移"; setPos(panright, 27, 11, 12, 12, 10, this); pan.appendChild(panright); panright.onclick = function (e) { return self.onclick(e);}; panright.ondblclick = function (e) { stopEvent(e); return true; }; panright.onmouseover = function (e) { pan.style.backgroundPosition = "0px -88px"; }; var panup = document.createElement("div"); panup.id = "panup"; panup.title = "上移"; setPos(panup, 13, 0, 12, 12, 10, this); pan.appendChild(panup); panup.onclick = function (e) { return self.onclick(e); }; panup.ondblclick = function (e) { stopEvent(e); return true; }; panup.onmouseover = function (e) { pan.style.backgroundPosition = "0px -44px"; }; var pandown = document.createElement("div"); pandown.id = "pandown"; pandown.title = "下移"; setPos(pandown, 13, 25, 12, 12, 10, this); pan.appendChild(pandown); pandown.onclick = function (e) { return self.onclick(e); }; pandown.ondblclick = function (e) { stopEvent(e); return true; }; pandown.onmouseover = function (e) { pan.style.backgroundPosition = "0px -132px"; }; var bar = document.createElement("div"); setPos(bar, 21, 64, 6, 111, 3, this); setBG(bar, img, "-24px -225px", "no-repeat no-repeat", null, null, null, null, null); this.div.appendChild(bar); var bar2 = document.createElement("div"); setPos(bar2, -6, 37, 18, 10, 5, this); setBG(bar2, img, "0px -309px", "initial initial", null, null, null, null, null); bar2.style.cursor = "pointer"; bar.appendChild(bar2); var bar2down = false; var mouseY = 0; bar2.onmousedown = function (e) { e = e || window.event; stopEvent(e); bar2down = true; mouseY = e.screenY; }; bar2.onmouseup = function (e) { stopEvent(e); bar2down = false; }; bar2.onmouseover = function (e) { bar2.style.backgroundPosition = "0px -320px"; }; bar.onmouseout = function (e) { bar2down = false; bar2.style.backgroundPosition = "0px -309px"; }; var bar3 = document.createElement("div"); bar.onmousemove = function (e) { e = e || window.event; stopEvent(e); var o = e.screenY - mouseY; if (bar2down) { var len = toint(bar.style.height); var newpos = toint(bar2.style.top) + o; var d = len - newpos; var level = Math.round(d * 18 / len); bar2.style.top = newpos + "px"; bar3.style.top = newpos + "px"; bar3.style.height = (toint(bar.style.height) - newpos + toint(bar2.style.height)) + "px"; self.nozoomed = true; self.map.zoomTo(level); self.nozoomed = false; } mouseY = e.screenY; }; setPos(bar3, 0, 37, 6, 111 - 37, 4, this); setBG(bar3, img, "-33px 100%", "no-repeat no-repeat", "auto", "padding-box", "border-box", "transparent", "scroll"); bar.appendChild(bar3); this.bar = bar; this.bar2 = bar2; this.bar3 = bar3; this.zoomin = zoomin; this.zoomout = zoomout; var btns = document.createElement("div"); setPos(btns, 18, 50, 45, 152, 2, this); setBG(btns, bimg, "0px -400px", "no-repeat no-repeat", "auto", "padding-box", "border-box", "transparent", "scroll"); this.div.appendChild(btns); if (!this.inited) { this.zoomend(); this.inited = true; } return this.div;
    }, zoomend: function () { if (this.nozoomed) { return; } var bar = this.bar; var bar2 = this.bar2; var bar3 = this.bar3; var zoomin = this.zoomin; var zoomout = this.zoomout; var level = this.map.getZoom(); var len = toint(bar.style.height); var pos = len - len * level / 6; bar2.style.top = (pos) + "px"; pos += toint(bar2.style.height); bar3.style.top = (pos) + "px"; bar3.style.height = (toint(bar.style.height) - pos + toint(bar2.style.height)) + "px"; }, onclick: function (e) { e = e || window.event; stopEvent(e); var obj = e.srcElement ? e.srcElement : e.target; switch (obj.id) { case "panup": this.map.pan(0, -this.getSlideFactor("h")); break; case "pandown": this.map.pan(0, this.getSlideFactor("h")); break; case "panleft": this.map.pan(-this.getSlideFactor("w"), 0); break; case "panright": this.map.pan(this.getSlideFactor("w"), 0); break; case "zoomin": this.map.zoomIn(); break; case "zoomout": this.map.zoomOut(); break; } return true; }, getSlideFactor: function (dim) { return this.slideRatio ? this.map.getSize()[dim] * this.slideRatio : this.slideFactor; }, CLASS_NAME: "OpenLayers.Control.NLibNavigation"
});
OpenLayers.Control.NLibLayerSwitch = OpenLayers.Class(OpenLayers.Control, {
    baseLayers: "", initialize: function (options) { OpenLayers.Control.prototype.initialize.apply(this, arguments); this.baseLayers = ""; }, draw: function () { if (this.div == null) { this.div = OpenLayers.Util.createDiv(this.id); this.div.className = "map_maptype"; var ul = document.createElement("ul"); this.div.appendChild(ul); var li0 = document.createElement("li"); li0.className = "t_sep"; ul.appendChild(li0); var li1 = document.createElement("li"); li1.className = ""; li1.innerHTML = "<p>地图</p>"; ul.appendChild(li1); var li2 = document.createElement("li"); li2.className = "t_sep"; ul.appendChild(li2); var li3 = document.createElement("li"); li3.className = ""; li3.innerHTML = "<p>卫星</p>"; ul.appendChild(li3); var li4 = document.createElement("li"); li4.className = "t_sep"; ul.appendChild(li4); var self = this; li1.onmousedown = function () { self.setCurrent(0); }; li3.onmousedown = function () {self.setCurrent(1); }; this.li0 = li0; this.li1 = li1; this.li2 = li2; this.li3 = li3; this.li4 = li4; this.setCurrent(0); } return this.div; }, setCurrent: function (t) {
        this.li0.className = "t_sep"; this.li1.className = (t == 0) ? "now_li" : ""; this.li2.className = "t_sep";
        this.li3.className = (t == 1) ? "now_li" : ""; this.li4.className = "t_sep"; if (this.map) { if (t == 0) { this.map.setBaseLayer(this.map.getLayer("OpenLayers_Layer_TMS_15")); } else if (t == 1) { this.map.setBaseLayer(this.map.getLayer("OpenLayers_Layer_TMS_17")); } }
    }, CLASS_NAME: "OpenLayers.Control.NLibLayerSwitch"
});
OpenLayers.Control.NLibOverviewMap = OpenLayers.Class(OpenLayers.Control.OverviewMap, { initialize: function (options) { this.minRatio = 10; this.maxRatio = 10; this.minRectSize = 10; this.size = new OpenLayers.Size(180, 120); this.maximized = false; options = OpenLayers.Util.extend({ mapOptions: { projection: map.getProjection(), displayProjection: new OpenLayers.Projection("EPSG:4326"), units: "m", maxResolution: map.getMaxResolution(), maxExtent: map.getExtent() } }, options); OpenLayers.Control.OverviewMap.prototype.initialize.apply(this, [options]); }, setOvMapCenter: function () { this.ovmap.setCenter(this.map.getExtent().getCenterLonLat()); }, updateMapToRect: function () { OpenLayers.Control.OverviewMap.prototype.updateMapToRect.apply(this, arguments); this.ovmap.setCenter(this.map.getExtent().getCenterLonLat()); }, createMap: function () { OpenLayers.Control.OverviewMap.prototype.createMap.apply(this, arguments); this.ovmap.events.register("moveend", this, this.updateRectToMap); this.ovmap.events.register("zoomend", this, this.updateRectToMap); }, draw: function () { OpenLayers.Control.prototype.draw.apply(this, arguments); if (!(this.layers.length > 0)) { if (this.map.baseLayer) { var layer = this.map.baseLayer.clone(); this.layers = [layer]; } else { this.map.events.register("changebaselayer", this, this.baseLayerDraw); return this.div; } } this.element = document.createElement("div"); this.element.className = this.displayClass + "Element"; this.element.style.display = "none"; this.mapDiv = document.createElement("div"); this.mapDiv.style.width = this.size.w + "px"; this.mapDiv.style.height = this.size.h + "px"; this.mapDiv.style.position = "relative"; this.mapDiv.style.overflow = "hidden"; this.mapDiv.id = OpenLayers.Util.createUniqueID("overviewMap"); this.extentRectangle = document.createElement("div"); this.extentRectangle.style.position = "absolute"; this.extentRectangle.style.zIndex = 1000; this.extentRectangle.className = this.displayClass + "ExtentRectangle"; this.mapDiv.appendChild(this.extentRectangle); this.element.appendChild(this.mapDiv); this.div.appendChild(this.element); if (!this.outsideViewport) { this.div.className += " " + this.displayClass + "Container"; var imgLocation = OpenLayers.Util.getImagesLocation(); var img = imgLocation + "overexpand.gif"; this.maximizeDiv = OpenLayers.Util.createAlphaImageDiv(this.displayClass + "MaximizeButton", null, new OpenLayers.Size(18, 18), img, "absolute"); this.maximizeDiv.style.display = "none"; this.maximizeDiv.className = this.displayClass + "MaximizeButton"; OpenLayers.Event.observe(this.maximizeDiv, "click", OpenLayers.Function.bindAsEventListener(this.maximizeControl, this)); this.div.appendChild(this.maximizeDiv); var img = imgLocation + "overcontract.gif"; this.minimizeDiv = OpenLayers.Util.createAlphaImageDiv("OpenLayers_Control_minimizeDiv", null, new OpenLayers.Size(18, 18), img, "absolute"); this.minimizeDiv.style.display = "none"; this.minimizeDiv.className = this.displayClass + "MinimizeButton"; OpenLayers.Event.observe(this.minimizeDiv, "click", OpenLayers.Function.bindAsEventListener(this.minimizeControl, this)); this.div.appendChild(this.minimizeDiv); var eventsToStop = ["dblclick", "mousedown"]; for (var i = 0, len = eventsToStop.length; i < len; i++) { OpenLayers.Event.observe(this.maximizeDiv, eventsToStop[i], OpenLayers.Event.stop); OpenLayers.Event.observe(this.minimizeDiv, eventsToStop[i], OpenLayers.Event.stop); } this.minimizeControl(); } else { this.element.style.display = ""; } if (this.map.getExtent()) { this.update(); } this.map.events.register("moveend", this, this.update); this.map.events.register("zoomend", this, this.update); this.map.events.register("dragend", this, this.update); this.map.events.register("moveend", this, this.setOvMapCenter); this.map.events.register("zoomend", this, this.setOvMapCenter); this.map.events.register("dragend", this, this.setOvMapCenter); if (this.maximized) { this.maximizeControl(); } return this.div; }, CLASS_NAME: "OpenLayers.Control.NLibOverviewMap" });
OpenLayers.Control.NLibScaleLine = OpenLayers.Class(OpenLayers.Control.ScaleLine, {
    initialize: function (options) { this.bottomOutUnits = ""; this.bottomInUnits = ""; this.maxWidth = 150; OpenLayers.Control.prototype.initialize.apply(this, arguments); }, update: function () {
        var res = this.map.getResolution(); if (!res) { return; } var curMapUnits = this.map.getUnits(); var inches = OpenLayers.INCHES_PER_UNIT; var maxSizeData = this.maxWidth * res * inches[curMapUnits]; var geodesicRatio = 1; if (this.geodesic === true) { var maxSizeGeodesic = (this.map.getGeodesicPixelSize().w || 0.000001) * this.maxWidth; var maxSizeKilometers = maxSizeData / inches["km"]; geodesicRatio = maxSizeGeodesic / maxSizeKilometers; maxSizeData *= geodesicRatio; } var topUnits; var bottomUnits; if (maxSizeData > 100000) { topUnits = this.topOutUnits; bottomUnits = this.bottomOutUnits; } else { topUnits = this.topInUnits; bottomUnits = this.bottomInUnits; } var topMax = maxSizeData / inches[topUnits]; var bottomMax = maxSizeData / inches[bottomUnits];
        var topRounded = this.getBarLen(topMax); var bottomRounded = this.getBarLen(bottomMax); topMax = topRounded / inches[curMapUnits] * inches[topUnits]; bottomMax = bottomRounded / inches[curMapUnits] * inches[bottomUnits]; var topPx = topMax / res / geodesicRatio; var bottomPx = bottomMax / res / geodesicRatio; if (this.eBottom.style.visibility == "visible") { this.eBottom.style.width = Math.round(bottomPx) + "px"; this.eBottom.innerHTML = bottomRounded + " " + OpenLayers.i18n(bottomUnits); } if (this.eTop.style.visibility == "visible") { this.eTop.style.width = Math.round(topPx) + "px"; this.eTop.innerHTML = topRounded + " " + OpenLayers.i18n(topUnits); }
    }
});
OpenLayers.Control.NLibPopup = OpenLayers.Class({
    autosize: true, initialize: function (id, lonlat, title, content, size, closecallback) { this.id = id; this.lonlat = lonlat; this.title = title; this.content = content; this.closecallback = closecallback; this.map = null; this.div = null; this.imgdiv = null; this.div2 = null; this.titlediv = null; this.contentdiv = null; this.closediv = null; this.size = size; if (!this.size) { if (this.content) { this.autoSize(); } else { this.size = new OpenLayers.Size(140, 100); } } else { this.autosize = false; } }, draw: function () { if (!this.div) { this.div = OpenLayers.Util.createDiv(null, { x: 0, y: 0 }, { w: 100, h: 100 }, null, "absolute"); this.imageSrcTail = OpenLayers.Util.getImageLocation("iw_tail.png"); this.imageSrcClose = OpenLayers.Util.getImageLocation("iw_close.gif"); this.div.style.zIndex = 1000; this.div.innerHTML = "" + "<img width='51' height='31' src='" + this.imageSrcTail + "'" + " style='z-index: 1; position: absolute; top: 72px; right: 48.70000000000001px;'/>" + "<div style='position: absolute; cursor: default; border: 1px solid rgb(153, 153, 153); background-color: rgb(255, 255, 255); width: 169px; height: 71px;'>" + "<div style='overflow-x: hidden; visibility: inherit;'>" + "<div style='border-bottom: 1px solid #ccc; height: 25px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis'>" + "<div style='line-height: 24px; height: 24px; background-color: rgb(249, 249, 249); white-space:nowrap;overflow:hidden;text-overflow:ellipsis'>" + "<p style='margin: 0px; padding: 0px;'>" + "<div class='se_infowin_tit' style='position: absolute; margin: -2px 0px 0px; padding: 0px 0px 0px 10px; font-size: 14px; font-weight: bold; text-overflow: ellipsis; white-space: nowrap; overflow: hidden;'>" + "<div>" + "</div>" + "</div>" + "</p>" + "</div>" + "</div>" + "</div>" + "<div style='position: absolute; left: 0px; padding: 5px 7px 0px 10px; color: rgb(51, 51, 51); font-size: 12px; margin-top: 0px; min-width: 150px; word-wrap: break-word; top: 27px;'>" + "</div>" + "</div>" + "<div style='float: right; position: absolute; top: 1px; right: 0px; height: 24px; background-color: rgb(249, 249, 249);'>" + "<div style='width: 32px; height: 24px'>" + "<img width='10' height='10' src='" + this.imageSrcClose + "' class='se_infowin_close' style='position: absolute; top: 7px; right: 8px; width: 10px; height: 10px; cursor: pointer;'>" + "</div>" + "</div>"; this.imgdiv = this.div.childNodes[0]; this.div2 = this.div.childNodes[1]; this.titlediv = this.div2.childNodes[0].childNodes[0].childNodes[0].childNodes[1].childNodes[0]; this.contentdiv = this.div2.childNodes[1]; this.closediv = this.div.childNodes[2]; var self = this; this.closediv.onclick = function () { if (self.closecallback) { self.closecallback.apply(self, []); } self.hide(); }; this.registerEvents(); } this.setSize(this.size); this.updatePosition(); this.setTitle(this.title); this.setContent(this.content); return this.div; }, updatePosition: function () { if ((this.lonlat) && (this.map)) { var px = this.map.getLayerPxFromLonLat(this.lonlat); if (px) { this.moveTo(px); } } }, moveTo: function (px) { if ((px != null) && (this.div != null)) { px.x -= this.size.w / 2; px.y -= this.size.h; this.div.style.left = px.x + "px"; this.div.style.top = px.y + "px"; } }, setLonLat: function (lon, lat) { this.lonlat = new EV.LngLat(lon, lat); this.updatePosition(); }, setLngLat: function (lonlat) { this.lonlat = lonlat; this.updatePosition(); }, visible: function () { return OpenLayers.Element.visible(this.div); }, setVisible: function (v) { if (this.div) { this.div.style.display = v ? "" : "none"; } }, toggle: function () { if (this.visible()) { this.hide(); } else { this.show(); } }, show: function () { if (this.autosize) { this.autoSize(); } this.div.style.display = ""; if (this.panMapIfOutOfView) { this.panIntoView(); } }, hide: function () { if (this.div) { this.div.style.display = "none"; } }, setSize: function (contentSize) { this.size = contentSize.clone(); if (!this.div) { return; } this.div.style.width = this.size.w + "px"; this.div.style.height = this.size.h + "px"; this.div2.style.width = this.size.w + "px"; this.div2.style.height = (this.size.h - 31) + "px"; this.imgdiv.style.top = (this.size.h - 31 + 1) + "px"; this.imgdiv.style.left = this.size.w / 2 + "px"; }, setTitle: function (title) { this.title = title; if (this.titlediv) { this.titlediv.innerHTML = this.title; } }, setContent: function (content) { this.content = content; if (this.contentdiv) { this.contentdiv.innerHTML = this.content; } }, destroy: function () {
        if (this.map != null) { this.map.removePopup(this); } this.id = null; this.lonlat = null; this.title = null; this.content = null; this.size = null; this.closecallback = null; this.map = null; this.div = null; this.imgdiv = null; this.div2 = null; this.titlediv = null; this.contentdiv = null; this.closediv = null;
    }, autoSize: function () { var size = OpenLayers.Util.getRenderedDimensions(this.content, { displayClass: "evpopupcontent" }); this.size = new OpenLayers.Size(Math.max(size.w + 40, 140), Math.max(size.h + 31 + 40, 100)); this.setSize(this.size); }, registerEvents: function () { this.events = new OpenLayers.Events(this, this.div, null, true); function onTouchstart(evt) { OpenLayers.Event.stop(evt, true); } this.events.on({ "mousedown": this.onmousedown, "mousemove": this.onmousemove, "mouseup": this.onmouseup, "click": this.onclick, "mouseout": this.onmouseout, "dblclick": this.ondblclick, "touchstart": onTouchstart, scope: this }); }, onmousedown: function (evt) { this.mousedown = true; OpenLayers.Event.stop(evt, true); }, onmousemove: function (evt) { if (this.mousedown) { OpenLayers.Event.stop(evt, true); } }, onmouseup: function (evt) { if (this.mousedown) { this.mousedown = false; OpenLayers.Event.stop(evt, true); } }, onclick: function (evt) { OpenLayers.Event.stop(evt, true); }, onmouseout: function (evt) { this.mousedown = false; }, ondblclick: function (evt) { OpenLayers.Event.stop(evt, true); }, CLASS_NAME: "OpenLayers.Control.NLibPopup"
});
OpenLayers.Control.NLibMap = OpenLayers.Class(OpenLayers.Map, { initialize: function (div, option) { var ops = option || {}; if (!ops.controls) { ops.controls = [new OpenLayers.Control.Navigation({ handleRightClicks: true })]; } OpenLayers.Map.prototype.initialize.apply(this, [div, ops]); } });
//去掉某个点
OpenLayers.Control.RemoveFeature = OpenLayers.Class(OpenLayers.Control, { initialize: function (layer, options) { OpenLayers.Control.prototype.initialize.apply(this, [options]); this.layer = layer; this.handler = new OpenLayers.Handler.Feature(this, layer, { click: this.clickFeature }); }, clickFeature: function (feature) { if (feature.fid == undefined) { this.layer.destroyFeatures([feature]); } else { feature.state = OpenLayers.State.DELETE; this.layer.events.triggerEvent("afterfeaturemodified", { feature: feature }); feature.renderIntent = "select"; this.layer.drawFeature(feature); } }, setMap: function (map) { this.handler.setMap(map); OpenLayers.Control.prototype.setMap.apply(this, arguments); }, CLASS_NAME: "OpenLayers.Control.RemoveFeature" });
OpenLayers.Lang["zh-CN"] = { "ft": "英寸", "mi": "英里", "m": "米", "km": "公里" };

//地图瓦片方法
function get_3d_url(a) {
	  var bounds = this.adjustBounds(a);
	    var z = this.map.getZoom()-4;
	    var res = this.map.getResolution();
	    var x = parseInt((bounds.getCenterLonLat().lon - this.tileOrigin.lon) / (256 * res));
	    var y = parseInt((this.tileOrigin.lat - bounds.getCenterLonLat().lat) / (256 * res));
	    x = '/C' + OpenLayers.Number.zeroPad(x, 8, 16);
	    y = '/R' + OpenLayers.Number.zeroPad(y, 8, 16);
	    z = '/L' + OpenLayers.Number.zeroPad(z, 2, 10);
	    return this.url + z + y + x + '.png';
}
//画图形
function drawmap(points, destroylayer) {
    point_left = 0;
    point_right = 0;
    point_top = 0;
    point_bottom = 0;
    if (destroylayer) {
        layer.destroyFeatures();
    }
    var zu = points.split("#");
    for (var i = 0; i < zu.length; i++) {
        var dian = zu[i].split(";");
        if (dian.length == 1) {
            var x = parseFloat(dian[0].split(",")[0]);
            var y = parseFloat(dian[0].split(",")[1]);
            Bounds = getboud(x, y);
            var lonlat = { x: x, y: y };
            var ft = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(lonlat.x, lonlat.y), { type: 5 });
            layer.addFeatures([ft]);
        } else {
            var pointList = [];
            for (var j = 0; j < dian.length; j++) {
                var x = parseFloat(dian[j].split(",")[0]);
                var y = parseFloat(dian[j].split(",")[1]);
                Bounds = getboud(x, y);
                var lonlat = { x: x, y: y };
                var newPoint = new OpenLayers.Geometry.Point(lonlat.x, lonlat.y);
                pointList.push(newPoint);
            }
            var linearRing = new OpenLayers.Geometry.LinearRing(pointList);
            var ft = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Polygon([linearRing]), { type: 5 });
            layer.addFeatures([ft]);
        }
    }
    map.zoomToMaxExtent(new NMap.Bounds(Bounds.minx, Bounds.miny, Bounds.maxx, Bounds.maxy));
}
//show画图形
function drawmapshow(points, destroylayer, shouPopup, isLouDong) {
    try {
        map.removePopup(popup);
    } catch (e) { }
    try {
        lineFeature.destroy();
    } catch (e) { }
    try {
        markersTrack.clearMarkers();
    } catch (e) { }
    if (destroylayer) {
    	try{
            layershow.destroyFeatures();
        }catch(e){}
    	try{
            markers.clearMarkers();
        }catch(e){}
    }
    points = eval("(" + points + ")");
    for (var p = 0; p < points.length; p++) {
        var zu = points[p].POSITION.split("#");
        for (var i = 0; i < zu.length; i++) {
            var dian = zu[i].split(";");
            if (dian.length == 1) {
                selectControl.deactivate();
                var x = parseFloat(dian[0].split(",")[0]);
                var y = parseFloat(dian[0].split(",")[1]);
                Bounds = getboud(x, y);
                var lonlat = new OpenLayers.LonLat(x, y);

                var imgUrl = points[p].IMG == null ? "/gsm/resource/js/map_bdh/img/marker_red.png" : points[p].IMG;
                var icon = new OpenLayers.Icon(imgUrl);
                var feature = new OpenLayers.Feature(markers, lonlat, { 'icon': icon });
                feature.popupClass = OpenLayers.Popup.FramedCloud;
                feature.data.popupContentHTML = points[p].NAME;
                feature.data.HTML = points[p].HTML;
                var marker = feature.createMarker(lonlat);
                //泡泡鼠标事件
                var flag1 = false;
                var flag2 = false;
                var markerOver = function (evt) {
                    if (!flag2) {
                        flag1 = true;
                        popup1 = new OpenLayers.Popup("popup1",
                        this.lonlat,
                        null,
                        this.data.popupContentHTML,
                        false);
                        popup1.setBackgroundColor("#ffffff");
                        popup1.setOpacity(12);
                        popup1.setBorder("1px solid #d91f12");
                        popup1.autoSize = true;
                        popup1.padding = 5;
                        popup1.maxSize = new OpenLayers.Size(300, 200);
                        map.addPopup(popup1);
                    }
                };
                var markerOut = function (evt) {
                    if (flag1 && !flag2) {
                        popup1.hide();
                    }
                };
                var close = function () {
                    flag2 = false;
                    map.removePopup(feature.popup);
                    feature.popup.destroy();
                    feature.popup = null;
                };
                var markerDown = function () {
                    if (flag1) {
                        popup1.hide();
                    }
                    try {
                        map.removePopup(popup);
                    } catch (e) { }
                    flag1 = false;
                    flag2 = true;
                    popup = new OpenLayers.Popup.FramedCloud("chicken",
                                                this.lonlat,
                                                null,
                                                this.data.HTML,
                                                null, true, close);
                    feature.popup = popup;
                    map.addPopup(popup);
                };
                marker.events.register("mouseover", feature, markerOver);
                marker.events.register("mouseout", feature, markerOut);
                marker.events.register("mousedown", feature, markerDown);
                markers.addMarker(marker);
                map.addLayer(markers);
                //显示泡泡
                map.zoomToMaxExtent(new NMap.Bounds(Bounds.minx, Bounds.miny, Bounds.maxx, Bounds.maxy));
                if (shouPopup) {
                    popup = new OpenLayers.Popup.FramedCloud("dian",
                                                lonlat,
                                                null,
                                                feature.data.HTML,
                                                null, true, close);
                    feature.popup = popup;
                    map.addPopup(popup);
                }
            } else {
                selectControl.activate();
                var pointList = [];
                for (var j = 0; j < dian.length; j++) {
                    var x1 = parseFloat(dian[j].split(",")[0]);
                    var y1 = parseFloat(dian[j].split(",")[1]);
                    Bounds = getboud(x1, y1);
                    var newPoint = new OpenLayers.Geometry.Point(x1, y1);
                    pointList.push(newPoint);
                }
                var linearRing = new OpenLayers.Geometry.LinearRing(pointList);
                ShowFeature = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Polygon([linearRing]));
                getclnum();
                if (isLouDong) {
                    ShowFeature.attributes = {
                        topic: "polygon_only",
                        name: points[p].NAME,
                        html: points[p].HTML,
                        strokeColor: strokeColor[c],
                        fillColor: fillColor[c]
                    };
                } else {
                    ShowFeature.attributes = {
                        topic: "polygon",
                        name: points[p].NAME,
                        html: points[p].HTML,
                        strokeColor: strokeColor[c],
                        fillColor: fillColor[c]
                    };
                }
                layershow.addFeatures([ShowFeature]);
                //显示泡泡
                map.zoomToMaxExtent(new NMap.Bounds(Bounds.minx, Bounds.miny, Bounds.maxx, Bounds.maxy));
                if (shouPopup) {
                    onFeatureSelect(ShowFeature);
                }
            }
        }
    }
}
//show画图形--人
function drawmapshowperson(points, shouPopup) {
    point_left = 0;
    point_bottom = 0;
    point_right = 0;
    point_top = 0;
    try {
        map.removePopup(popup);
    } catch (e) { }
    try {
        lineFeature.destroy();
    } catch (e) { }
    try {
        markersTrack.clearMarkers();
    } catch (e) { }
    points = eval("(" + points + ")");
    selectControl.deactivate();
    var sop = points.POSITION;
    for (var i = 0; i < sop.split(";").length; i++) {
        Bounds = getboud(parseFloat(sop.split(";")[i].split(",")[0]), parseFloat(sop.split(";")[i].split(",")[1]));
    }
    var x = Bounds.minx + (Bounds.maxx - Bounds.minx) * Math.random();
    var y = Bounds.miny + (Bounds.maxy - Bounds.miny) * Math.random();
    var lonlat = new OpenLayers.LonLat(x, y);
    var imgUrl = points.IMG == null ? "/gsm/resource/js/map_bdh/img/marker_red.png" : points.IMG;
    var icon = new OpenLayers.Icon(imgUrl);
    var feature = new OpenLayers.Feature(markers, lonlat, { 'icon': icon });
    feature.popupClass = OpenLayers.Popup.FramedCloud;
    feature.data.popupContentHTML = points.NAME;
    feature.data.HTML = points.HTML;
    var marker = feature.createMarker(lonlat);
    //泡泡鼠标事件
    var flag1 = false;
    var flag2 = false;
    var markerOver = function (evt) {
        if (!flag2) {
            flag1 = true;
            popup1 = new OpenLayers.Popup("popup1",
            this.lonlat,
            null,
            this.data.popupContentHTML,
            false);
            popup1.setBackgroundColor("#ffffff");
            popup1.setOpacity(12);
            popup1.setBorder("1px solid #d91f12");
            popup1.autoSize = true;
            popup1.padding = 5;
            popup1.maxSize = new OpenLayers.Size(300, 200);
            map.addPopup(popup1);
        }
    };
    var markerOut = function (evt) {
        if (flag1 && !flag2) {
            popup1.hide();
        }
    };
    var close = function () {
        flag2 = false;
        map.removePopup(feature.popup);
        feature.popup.destroy();
        feature.popup = null;
    };
    var markerDown = function () {
        if (flag1) {
            popup1.hide();
        }
        try {
            map.removePopup(popup);
        } catch (e) { }
        flag1 = false;
        flag2 = true;
        popup = new OpenLayers.Popup.FramedCloud("chicken",
                                    this.lonlat,
                                    null,
                                    this.data.HTML,
                                    null, true, close);
        feature.popup = popup;
        map.addPopup(popup);
    };
    marker.events.register("mouseover", feature, markerOver);
    marker.events.register("mouseout", feature, markerOut);
    marker.events.register("mousedown", feature, markerDown);
    markers.addMarker(marker);
    map.addLayer(markers);
    //显示泡泡
    map.zoomToMaxExtent(new NMap.Bounds(Bounds.minx, Bounds.miny, Bounds.maxx, Bounds.maxy));
    if (shouPopup) {
        popup = new OpenLayers.Popup.FramedCloud("dian",
                                    lonlat,
                                    null,
                                    feature.data.HTML,
                                    null, true, close);
        feature.popup = popup;
        map.addPopup(popup);
    }
}
//画轨迹
function startTrack(readerCoo) {
    if (readerCoo == null || readerCoo.length <= 1) {
        alert('没有轨迹');
    } else {
        var lonlat = new OpenLayers.LonLat(readerCoo[0][0], readerCoo[0][1]);
        lonlat.transform(new OpenLayers.Projection("EPSG:4326"), map.getProjectionObject());
        map.setCenter(lonlat);
        var vectorLayer = new OpenLayers.Layer.Vector("轨迹线");
        map.addLayer(vectorLayer);
        var markers = new OpenLayers.Layer.Markers("车");
        map.addLayer(markers);
        var size_ren = new OpenLayers.Size(27, 42);
        var imgUrl = "/gsm/resource/js/map_bdh/img/guiji_ren.gif";
        var icon = new OpenLayers.Icon(imgUrl, size_ren);
        var marker = new OpenLayers.Marker(lonlat, icon);
        markers.addMarker(marker);
        var lineFeature = new OpenLayers.Feature.Vector(
                new OpenLayers.Geometry.LineString(lonlat.lon, lonlat.lat), null, style_green);
        vectorLayer.addFeatures([lineFeature]);
        fn(readerCoo, vectorLayer, markers, lineFeature, 0);
    }
}
function fn(readerCoo, vectorLayer, markers, lineFeature, x) {
    if (x < readerCoo.length) {
        $("#trackPersont").val(parseInt((x + 1) / readerCoo.length * 100));
        var lonlat = new OpenLayers.LonLat(readerCoo[x][0], readerCoo[x][1]);
        lonlat.transform(new OpenLayers.Projection("EPSG:4326"), map.getProjectionObject());
        var newPoint = new OpenLayers.Geometry.Point(lonlat.lon, lonlat.lat);
        lineFeature.geometry.addPoint(newPoint);
        vectorLayer.drawFeature(lineFeature);
        markers.clearMarkers();
        var size_ren = new OpenLayers.Size(27, 42);
        var imgUrlren = "/gsm/resource/js/map_bdh/img/guiji_ren.gif";
        var iconren = new OpenLayers.Icon(imgUrlren, size_ren);
        var featureren = new OpenLayers.Feature(markersTrack, lonlat, { 'icon': iconren });
        featureren.popupClass = OpenLayers.Popup.FramedCloud;
        featureren.data.popupContentHTML = readerCoo[x][2];
        marker_ren = featureren.createMarker(lonlat);
        //泡泡鼠标事件
        var markerOver = function (evt) {
            popupguiji = new OpenLayers.Popup("popup1",
                        this.lonlat,
                        null,
                        this.data.popupContentHTML,
                        false);
            popupguiji.setBackgroundColor("#ffffff");
            popupguiji.setOpacity(12);
            popupguiji.setBorder("1px solid #d91f12");
            popupguiji.autoSize = true;
            popupguiji.padding = 5;
            popupguiji.maxSize = new OpenLayers.Size(300, 200);
            map.addPopup(popupguiji);
        };
        var markerOut = function (evt) {
            popupguiji.hide();
        };
        try {
            popupguiji.hide();
        } catch (e) { }
        marker_ren.events.register("mouseover", featureren, markerOver);
        marker_ren.events.register("mouseout", featureren, markerOut);
        markers.addMarker(marker_ren);
        x++;
        //draw again
        guijitimer = setTimeout(function () {
            if (!zanting) {
                fn(readerCoo, vectorLayer, markers, lineFeature, x);
            } else {
                timer = setInterval(function () {
                    if (!zanting) {
                        clearInterval(timer);
                        fn(readerCoo, vectorLayer, markers, lineFeature, x);
                    }
                }, speed);
            }
        }, speed);
    }
}
function pointdata(Track) {
	var readerCoo = new Array();
    for (var i = 0; i < Track.length; i++) {
        readerCoo[i] = new Array();
        readerCoo[i][0] = Track[i].POSITION.split(",")[0];
        readerCoo[i][1] = Track[i].POSITION.split(",")[1];
        readerCoo[i][2] = Track[i].HTML;
    }
    startTrack(readerCoo);
}
function guijistart() {
    zanting = false;
}
function guijistop() {
    zanting = true;
}
function guijifast() {
    if (speed > 100) {
        speed = speed - 100;
    }
}
function guijislow() {
    if (speed < 1000) {
        speed = speed + 100;
    }
}
//实时轨迹
function drawMapTrack(Track) {
    var lonlat = new OpenLayers.LonLat(Track.POSITION.split(",")[0], Track.POSITION.split(",")[1]);
    lonlat.transform(new OpenLayers.Projection("EPSG:4326"), map.getProjectionObject());
    var vectorLayer = null;
    for (var i = 0; i < map.layers.length; i++) {
        if (map.layers[i].name == "xian_" + Track.NAME) {
            vectorLayer = map.layers[i];
            var newPoint = new OpenLayers.Geometry.Point(lonlat.lon, lonlat.lat);
            vectorLayer.features[0].geometry.addPoint(newPoint);
            vectorLayer.drawFeature(vectorLayer.features[0]);
        }
    }
    if (vectorLayer == null) {
        vectorLayer = new OpenLayers.Layer.Vector("xian_" + Track.NAME);
        var lineFeature = new OpenLayers.Feature.Vector(
            new OpenLayers.Geometry.LineString(lonlat.lon, lonlat.lat), null, style_green);
        vectorLayer.addFeatures([lineFeature]);
        vectorLayer.features[0].geometry.addPoint(new OpenLayers.Geometry.Point(lonlat.lon, lonlat.lat));
        vectorLayer.drawFeature(vectorLayer.features[0]);
    }
    map.addLayer(vectorLayer);
    var markers = null;
    for (var j = 0; j < map.layers.length; j++) {
        if (map.layers[j].name == "dian_" + Track.NAME) {
            markers = map.layers[j];
        }
    }
    if (markers == null) {
        markers = new OpenLayers.Layer.Markers("dian_" + Track.NAME);
        var size_ren = new OpenLayers.Size(27, 42);
        var imgUrl = "/gsm/resource/js/map_bdh/img/guiji_ren.gif";
        var icon = new OpenLayers.Icon(imgUrl, size_ren);
        var marker = new OpenLayers.Marker(lonlat, icon);
        markers.addMarker(marker);
    }
    map.addLayer(markers);
    markers.clearMarkers();

    var imgUrlren = "/gsm/resource/js/map_bdh/img/guiji_ren.gif";
    var iconren = new OpenLayers.Icon(imgUrlren, new OpenLayers.Size(27, 42));
    var featureren = new OpenLayers.Feature(markersTrack, lonlat, { 'icon': iconren });
    featureren.popupClass = OpenLayers.Popup.FramedCloud;
    featureren.data.popupContentHTML = Track.HTML;
    marker_ren = featureren.createMarker(lonlat);
    //泡泡鼠标事件
    var markerOver = function (evt) {
        popupguiji = new OpenLayers.Popup("popup1",
                    this.lonlat,
                    null,
                    this.data.popupContentHTML,
                    false);
        popupguiji.setBackgroundColor("#ffffff");
        popupguiji.setOpacity(12);
        popupguiji.setBorder("1px solid #d91f12");
        popupguiji.autoSize = true;
        popupguiji.padding = 5;
        popupguiji.maxSize = new OpenLayers.Size(300, 200);
        map.addPopup(popupguiji);
    };
    var markerOut = function (evt) {
        popupguiji.hide();
    };
    try {
        popupguiji.hide();
    } catch (e) { }
    marker_ren.events.register("mouseover", featureren, markerOver);
    marker_ren.events.register("mouseout", featureren, markerOut);
    markers.addMarker(marker_ren);
}
//清除轨迹
function clearMapTrack() {
	$("polyline").hide();
    var layers = $(".olLayerDiv");
    for (var i = 0; i < layers.length; i++) {
        if (layers[i].id.indexOf("OpenLayers_Layer_Markers") >= 0) {
            layers[i].parentNode.removeChild(layers[i]);
        }
    }
    clearTimeout(guijitimer);
}
//清空
function clearMap() {
    try {
        map.removePopup(popup);
    } catch (e) { }
    try{
        layershow.destroyFeatures();
    }catch(e){}
	try{
        markers.clearMarkers();
    }catch(e){}
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
//关闭窗口
function onPopupClose(evt) {
    selectControl.unselect(selectedFeature);
}
//图形选择
function onFeatureSelect(feature) {
    selectedFeature = feature;
    popup = new OpenLayers.Popup.FramedCloud("chicken",
                             feature.geometry.getBounds().getCenterLonLat(),
                             null,
                             feature.attributes.html,
                             null, true, onPopupClose);
    feature.popup = popup;
    map.addPopup(popup);
}
//取消图形选择
function onFeatureUnselect(feature) {
    map.removePopup(feature.popup);
    feature.popup.destroy();
    feature.popup = null;
}

//初始变量赋值
var NMap = NMap || {};
NMap.Bounds = OpenLayers.Bounds;
NMap.Size = OpenLayers.Size;
NMap.Pixel = OpenLayers.Pixel;
NMap.Icon = OpenLayers.Icon;
NMap.LonLat = OpenLayers.LonLat;
NMap.Projection = OpenLayers.Projection;
NMap.Map = OpenLayers.Control.NLibMap;
NMap.Navigation = OpenLayers.Control.NLibNavigation;
NMap.LayerSwitch = OpenLayers.Control.NLibLayerSwitch;
NMap.ScaleLine = OpenLayers.Control.NLibScaleLine;
NMap.OverviewMap = OpenLayers.Control.NLibOverviewMap;
NMap.InfoWindow = OpenLayers.Control.NLibPopup;
NMap.EditingToolbar = OpenLayers.Control.EditingToolbar;
NMap.Remove = OpenLayers.Control.RemoveFeature;
NMap.Markers = OpenLayers.Layer.Marker;
NMap.Marker = OpenLayers.Marker;

//格式
var proj4326 = new NMap.Projection("EPSG:4326");
var proj900913 = new NMap.Projection("EPSG:900913");
function initialGMaps(para) {
    var options = {
        numZoomLevels: 7,
        maxResolution: 0.00475892201166056,
        projection: proj4326,
        displayProjection: proj4326
    };

    map = new NMap.Map(para.id, options);

    var layerbase = new OpenLayers.Layer.DYCache("layerbase", 'http://192.168.2.20:3795/map/layerBase',
    {
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
            ],
        tileOrigin: new OpenLayers.LonLat(-400, 400)
    });
    var layerYX = new OpenLayers.Layer.DYCache("layerYX", 'http://192.168.2.20:3795/map/layerYX',
    {
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
    	        ],
        tileOrigin: new OpenLayers.LonLat(-400, 400)
    });
    var layer3d = new OpenLayers.Layer.DYCache("layer3d", 'http://192.168.2.20:3795/map/layer3d',
    {
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
    	        ],
        tileOrigin: new OpenLayers.LonLat(-400, 400),
        isBaseLayer: false,
        getURL: get_3d_url
    });
    map.addLayer(layer3d);
    map.addLayer(layerYX);
    map.addLayer(layerbase);

    map.zoomToMaxExtent(new NMap.Bounds(118.102085949958, 39.5525218141426, 118.249610941362, 39.638948743336));
    map.addControl(new NMap.Navigation());
    map.addControl(new NMap.LayerSwitch());
    map.addControl(new NMap.ScaleLine());
    map.addControl(new NMap.OverviewMap());

    var styles = new OpenLayers.StyleMap({
        "default": new OpenLayers.Style(null, {
            rules: [
                new OpenLayers.Rule({
                    symbolizer: {
                        "Point": {
                            externalGraphic: "/gsm/resource/js/map_bdh/img/marker_red.png",
                            graphicXOffset: -5,
                            graphicYOffset: -16,
                            graphicWidth: 15,
                            graphicHeight: 17
                        },
                        "Line": {
                            strokeWidth: 3,
                            strokeOpacity: 1,
                            strokeColor: "#ff0000"
                        },
                        "Polygon": {
                            fillColor: "#ff0000",
                            fillOpacity: 0.4,
                            strokeWidth: 1,
                            strokeOpacity: 0.6,
                            strokeColor: "#ff0000"
                        }
                    }
                })
            ]
        }),
        "select": new OpenLayers.Style(null, {
            rules: [
                new OpenLayers.Rule({
                    symbolizer: {
                        "Point": {
                            externalGraphic: "/gsm/resource/js/map_bdh/img/marker_red.png",
                            graphicXOffset: -5,
                            graphicYOffset: -16,
                            graphicWidth: 15,
                            graphicHeight: 17
                        },
                        "Line": {
                            strokeWidth: 3,
                            strokeOpacity: 1,
                            strokeColor: "#ff0000"
                        },
                        "Polygon": {
                            fillColor: "#ee9900",
                            fillOpacity: 0.4,
                            strokeWidth: 1,
                            strokeOpacity: 0.6,
                            strokeColor: "#ee9900"
                        }
                    }
                })
            ]
        }),
        "temporary": new OpenLayers.Style(null, {
            rules: [
                new OpenLayers.Rule({
                    symbolizer: {
                        "Point": {
                            externalGraphic: "/gsm/resource/js/map_bdh/img/marker_red.png",
                            graphicXOffset: -5,
                            graphicYOffset: -16,
                            graphicWidth: 15,
                            graphicHeight: 17
                        },
                        "Line": {
                            strokeWidth: 3,
                            strokeOpacity: 1,
                            strokeColor: "#ff0000"
                        },
                        "Polygon": {
                            fillColor: "#ff0000",
                            fillOpacity: 0.4,
                            strokeWidth: 1,
                            strokeOpacity: 0.6,
                            strokeColor: "#ff0000"
                        }
                    },
                    tile: {
                        "Image": { externalGraphic: "/gsm/resource/js/map_bdh/img/marker.png" }
                    }
                })
            ]
        })
    });
    layer = new OpenLayers.Layer.Vector("Scratchpad", { styleMap: styles });

    var panel = new OpenLayers.Control.Panel({
        displayClass: "olControlEditingToolbar"
    });
    if (para.Save) {
        panel.addControls(new OpenLayers.Control.Button({
            title: "保存",
            trigger: function () {
                var features = layer.features;
                var pointsstring = "";
                for (var i = 0 ; i < features.length; i++) {
                    var geom = features[i].geometry;
                    var lonlats = geom.getVertices();
                    for (var j = 0; j < lonlats.length; j++) {
                        var x = parseFloat(lonlats[j].x);
                        var y = parseFloat(lonlats[j].y);
                        pointsstring += x + "," + y + ";";
                    }
                    pointsstring = pointsstring.substring(0, pointsstring.length - 1) + "#";
                }
                para.getResult(pointsstring.substring(0, pointsstring.length - 1));
            },
            displayClass: "olControlSaveFeatures"
        }));
    }
    if (para.Close) {
        panel.addControls(new OpenLayers.Control.Button({
            title: "关闭",
            trigger: function () {
                $("#" + para.id).remove();
            },
            displayClass: "olControlCloseFeatures"
        }));
    }
    if (para.Navigation) {
        panel.addControls(new OpenLayers.Control.Navigation({ title: "拖动" }));
    }
    if (para.Point) {
        panel.addControls(new OpenLayers.Control.DrawFeature(
                    layer, OpenLayers.Handler.Point,
                    { displayClass: "olControlDrawFeaturePoint", title: "画点" }
                ));
    }
    if (para.Path) {
        panel.addControls(new OpenLayers.Control.DrawFeature(
                    layer, OpenLayers.Handler.Path,
                    { displayClass: "olControlDrawFeaturePath", title: "画线" }
                ));
    }
    if (para.Polygon) {
        panel.addControls(new OpenLayers.Control.DrawFeature(
                    layer, OpenLayers.Handler.Polygon,
                    { displayClass: "olControlDrawFeaturePolygon", title: "画面" }
                ));
    }
    if (para.Modify) {
        panel.addControls(new OpenLayers.Control.ModifyFeature(
            layer, { displayClass: "olControlModifyFeature", title: "修改" }
        ));
    }
    if (para.Remove) {
        panel.addControls(new NMap.Remove(
            layer, { displayClass: "olControlRemoveFeature", title: "删除" }));
    }
    if (para.Clear) {
        panel.addControls(new OpenLayers.Control.Button({
            title: "清空",
            trigger: function () {
                layer.destroyFeatures();
            },
            displayClass: "olControlClearFeatures"
        }));
    }
    map.addControl(panel);
    map.addLayer(layer);

    //有传值时传值并缩放，没有是设置中心点及缩放级别
    if (para.points.length > 0) {
        drawmap(para.points, false);
    } else {
        //中心点
    	var centerpoint = new NMap.LonLat(118.17, 39.60);
        map.setCenter(centerpoint.transform(proj4326, map.getProjectionObject()), 5);
    }
}
function GMapsShow(para) {
    var options = {
        numZoomLevels: 7,
        maxResolution: 0.00475892201166056,
        projection: proj4326,
        displayProjection: proj4326
    };

    map = new NMap.Map(para.id, options);
    //http://192.168.2.20:8061/map/layerBase
    var layerbase = new OpenLayers.Layer.DYCache("layerbase", 'http://192.168.2.20:3795/map/layerBase',
    {
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
    	        ],
        tileOrigin: new OpenLayers.LonLat(-400, 400)
    });
    var layerYX = new OpenLayers.Layer.DYCache("layerYX", 'http://192.168.2.20:3795/map/layerYX',
    {
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
    	        ],
        tileOrigin: new OpenLayers.LonLat(-400, 400)
    });
    var layer3d = new OpenLayers.Layer.DYCache("layer3d", 'http://192.168.2.20:3795/map/layer3d',
    {
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
    	        ],
        tileOrigin: new OpenLayers.LonLat(-400, 400),
        isBaseLayer: false,
        getURL: get_3d_url
    });
    map.addLayer(layer3d);
    map.addLayer(layerYX);
    map.addLayer(layerbase);

    map.zoomToMaxExtent(new NMap.Bounds(118.102085949958, 39.5525218141426, 118.249610941362, 39.638948743336));
    map.addControl(new NMap.Navigation());
    map.addControl(new NMap.LayerSwitch());
    map.addControl(new NMap.ScaleLine());
    map.addControl(new NMap.OverviewMap());
    var style = new OpenLayers.StyleMap({
        'default': new OpenLayers.Style(null, {
            rules: [
                new OpenLayers.Rule({
                    symbolizer: {
                        externalGraphic: "${img}",
                        fillOpacity: 1,
                        graphicWidth: 30,
                        graphicHeight: 35
                    },
                    filter: new OpenLayers.Filter.Comparison({
                        type: "==",
                        property: "topic",
                        value: "point"
                    })
                }),
                new OpenLayers.Rule({
                    symbolizer: {
                        strokeWidth: 1,
                        strokeColor: "${strokeColor}",
                        strokeOpacity: 0.5,
                        fillColor: "${fillColor}",
                        fillOpacity: 0.3,
                        stroke: true,
                        cursor: "pointer",
                        label: "${name}",
                        fontColor: "${strokeColor}",
                        labelAlign: "cm",
                        labelOutlineColor: "white",
                        labelOutlineWidth: 3,
                        labelBorderWidth: 23,
                        labelOutlineOpacity: 0.7,
                        labelSelect: true
                    },
                    filter: new OpenLayers.Filter.Comparison({
                        type: "==",
                        property: "topic",
                        value: "polygon"
                    })
                }),
                new OpenLayers.Rule({
                    symbolizer: {
                        strokeOpacity: 0,
                        fillOpacity: 0,
                        stroke: true,
                        cursor: "pointer",
                        label: "${name}",
                        fontColor: "${strokeColor}",
                        labelAlign: "cm",
                        labelOutlineColor: "white",
                        labelOutlineWidth: 3,
                        labelBorderWidth: 23,
                        labelOutlineOpacity: 0.7,
                        labelSelect: true
                    },
                    filter: new OpenLayers.Filter.Comparison({
                        type: "==",
                        property: "topic",
                        value: "polygon_only"
                    })
                })
            ]
        }),
        'select': {
            strokeWidth: 1,
            strokeColor: "${strokeColor}",
            strokeOpacity: 0.5,
            fillColor: "${fillColor}",
            fillOpacity: 0.3
        }
    });
    layershow = new OpenLayers.Layer.Vector("Simple Geometry", {
        styleMap: style,
        eventListeners: {
            featureover: function (e) {
                e.feature.renderIntent = "select";
                e.feature.layer.drawFeature(e.feature);
            },
            featureout: function (e) {
                e.feature.renderIntent = "default";
                e.feature.layer.drawFeature(e.feature);
            }
        }
    });
    map.addLayer(layershow);
    selectControl = new OpenLayers.Control.SelectFeature(layershow,
                { onSelect: onFeatureSelect, onUnselect: onFeatureUnselect });
    map.addControl(selectControl);
    //将轨迹图层填入地图
    vectorLayer = new OpenLayers.Layer.Vector("track");
    map.addLayer(vectorLayer);
    //将点图层填入地图
    markers = new OpenLayers.Layer.Markers("persion");
    //轨迹
    markersTrack = new OpenLayers.Layer.Markers("Track");
    //有传值时传值并缩放，没有是设置中心点及缩放级别
    if (para.points.length > 0) {
        drawmapshow(para.points, false, para.showPopup);
    } else {
        //中心点
    	   var centerpoint = new NMap.LonLat(118.17, 39.59);
        map.setCenter(centerpoint.transform(proj4326, map.getProjectionObject()), 5);
    }
}