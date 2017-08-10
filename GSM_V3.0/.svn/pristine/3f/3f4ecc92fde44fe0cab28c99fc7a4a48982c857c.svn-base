$.fn.ztreeGrid = function (p) {
	   p = $.extend({
	        url: "/PagesOperate/BSeatGrid.dy?method=ExecuteQueryTree&t=" + Math.random(),
	        name: "name",
	        idKey: "code",
			pIdKey:"parentCode",
			checkBox:false,
			split:";",
	        level: -1,
	        width:240,        
	        defaultValue:false,
	        callback: function (event, treeId, treeNode, clickFlag) { },
	        databack: function (data) { },
	        reset:false,
	        resetId:'reset',
	        divStyle:'width:16.6666%;float: left;',
	        goToClick:function(event, treeId, treeNode){
	        	return true;
	        }
	    }, p);
	var thisOBJ=$(this);
	//thisOBJ.css({width:"1px",height:"1px","min-width":"1px",border:"none"});
	var textDiv=$('<div style="" class="input-group" ><span class="input-group-addon"> \
			<i class="icon-list bigger-110" ></i> \
			</span></div>');
	
	try{
if(thisOBJ.parent().attr("class").indexOf("search-group")>-1){
	textDiv.attr('style',p.divStyle);
}
	}catch(e){
		
	}
	var textOBJ=$('<input class="form-control position-picker" type="text">');
	$(textOBJ).addClass(thisOBJ.attr("class"));
	$(textOBJ).removeClass("required");
	$(textOBJ).attr("type","text");
	thisOBJ.attr("type","text");
	var s = thisOBJ.parent().attr("class");
	if(s == "search-group"){
		thisOBJ.attr("style","display:none");
	}
    thisOBJ.css({"height":"0px","border":"none","padding":"0px 0px","box-shadow":"inset 0 0px 0px rgba(0,0,0,0.075)","-webkit-box-shadow":"inset 0 0px 0px rgba(0,0,0,0.075)","color":"#FFFFFF"});
	/*thisOBJ.attr("style","display:none");*/
	$(textOBJ).attr("readonly","true");
	$(textOBJ).attr("placeholder","--请选择--");
	var div=document.createElement("div");
	$(div).css({display:"none",overflow:"auto"});
	textDiv.prepend(textOBJ);
	thisOBJ.before(textDiv);	
	var thisKey=thisOBJ.attr("id")||thisOBJ.attr("name");
	
	var onBodyDown=function (event) {
		if (!(event.target.id == "menuBtn" ||event.target.id == thisKey+"_div" || event.target.id == "menuContent" || $(event.target).parents("#"+thisKey+"_div").length>0)) {
			hideMenu();
		}
	};
	
	var showMenu=function () {
		textOBJOffset=textOBJ.offset();
		$(div).css({"z-index":"100000","box-shadow":"0 2px 4px rgba(0,0,0,0.2)",border:"1px solid rgba(0,0,0,0.15)",background:"white",height:"200px",position:"absolute", width:"220px",left:textOBJOffset.left+"px",top:textOBJOffset.top+textOBJ.outerHeight()+"px"})
		
		$("#"+thisKey+"_div").slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	};
	textOBJ.bind("click",showMenu);
	
	var hideMenu=function () {
		$("#"+thisKey+"_div").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	};
	
 
    if(p.reset){
    	$('#'+p.resetId).bind('click',function(){
    		$.fn.zTree.getZTreeObj(thisOBJ.attr('name')+"_tree").checkAllNodes(false);
    	});
    }
    
    var setting={
    	check: {
			enable: p.checkBox,
			chkboxType: { "Y" : "s", "N" : "ps" }
		},	
		view: {
			dblClickExpand: false
		},
		data: {
			key: {
				name: p.name
			},
			simpleData: {
				enable: true,
				idKey: p.idKey,
				pIdKey:p.pIdKey
			}
		},
		callback: {			
			onClick: function(e, treeId, treeNode){ 
				if(p.checkBox&&p.goToClick(e, treeId, treeNode)){
					var treeObj = $.fn.zTree.getZTreeObj(treeId);
					treeObj.checkNode(treeNode, treeNode.checked, true,true);
					
					return;
				}
				if(p.goToClick(e, treeId, treeNode)){
					thisOBJ.val(treeNode[p.idKey]);				
					textOBJ.val(treeNode[p.name]);	
					if(treeNode["POSITION"]!=''){
						thisOBJ.attr("position",treeNode["POSITION"]);
					}
					hideMenu();
				}
			},
			onCheck: function zTreeOnCheck(event, treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj(treeId);
				var Nodes=zTree.getCheckedNodes(true);				
				var IDs="";
				var Names="";
				for(var i=0;i<Nodes.length;i++){
					if(!IDs&&!Names){
						IDs=Nodes[i][p.idKey];
						Names=Nodes[i][p.name];
					}
					else{
						IDs+=p.split+Nodes[i][p.idKey];
						Names+=p.split+Nodes[i][p.name];
					}
				}	
				
				thisOBJ.val(IDs);
				
				textOBJ.val(Names);
			}
		}
	};
    
    $.ajax({
		url : p.url,
		type : "post",		
		dataType : "json",
		success : function(data) {
			var _v="";
			var _t="";
			if(thisOBJ.val()){
				var _vs=thisOBJ.val().split(p.split);

				for(var i=0;i<data.length;i++){
					if(p.defaultValue&&i==0){
						textOBJ.val(data[i][p.name]);
						thisOBJ.val(data[i][p.idKey]);
					}
					
					for(var j=0;j<_vs.length;j++){
						if(_vs[j]==data[i][p.idKey]){
							data[i].checked=true;
							if(!_v){
								_v=data[i][p.idKey];
								_t=data[i][p.name];
							}
							else{
								_v+=p.split+data[i][p.idKey];
								_t+=p.split+data[i][p.name];
							}
						}
					}
				}
			
				if(_v){
					textOBJ.val(_t);
					thisOBJ.val(_v);
				}
			}
			var ul=document.createElement("ul");
			var treeObj=$.fn.zTree.init($(ul).addClass("ztree").attr("id",thisKey+"_tree"), setting, data);
			$(div).attr("id",thisKey+"_div").append(ul);			 
			$("body").append(div);
			if(_v){
				var node = treeObj.getNodeByParam("code", thisOBJ.val());
				treeObj.selectNode(node,true);
			}
		}
	});    
    
};
    
