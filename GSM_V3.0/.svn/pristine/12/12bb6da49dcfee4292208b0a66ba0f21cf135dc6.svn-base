<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include  page="/resource/base_import.jsp"/>
</head>
<body>
<script>
function cleanInput(){
	$("#txtSearchNode").val('');
}

</script>
	<div class="row" id="body">
		<div id="tb" class="col-xs-6 col-sm-4">
		<div class="input-group">
			<div class="col-xs-12 col-sm-12 like-input">
			<input type="text" id="txtSearchNode"  placeholder="请输入名称">
			<a class="input-delete-btn" onclick="cleanInput()"href="javaScript:void(0)"><span aria-hidden="true" class="glyphicon glyphicon-remove form-control-feedback"></span></a>
			</div>
			<span class="input-group-btn">
				<button type="button" id="btnSearchNode" class="btn btn-primary">
					<i class="icon-search bigger-110"></i>
				</button>
			</span>
		</div>
		</div>
		<div class="col-xs-12" >
			<ul id="treeDemo" class="ztree" style="margin: 0; padding: 25px; color: #333;"></ul>
		</div>
	</div>
</body>
<script>
var uploadImgIds;
var ztree;
var nodeList = [];
var editTreeNode;
var addNodeCallBack=function(){};
var editNodeCallBack=function(){};
function addDiyDom(treeId, treeNode) {
    var aObj = $("#" + treeNode.tId + "_a");
    aObj.css("margin-right","20px");
   var add_a=$('<a href="#" class="green action-buttons" title="新增"> <i class="icon-plus-sign bigger-110"></i> </a>');
   var edit_a=$('<a href="#" class="blue action-buttons"title="修改"> <i class="icon-pencil bigger-110"></i> </a>');
   var delete_a=$('<a href="#" class="red action-buttons"title="删除"> <i class="icon-trash bigger-110"></i> </a>');
   add_a.bind("click",function addTreeNode(){
	 
		var parentCode=treeNode.code;
		var lev=treeNode.level;
		if (parentCode.length == 2||parentCode.length == 5||parentCode.length == 8||parentCode.length == 12){
			var url="";
			var title="";
			var style='width:80%;height:600px;';
			
			if (parentCode.length == 2) {
				url = "${base}/sys/seatsecond/addLoad?parentCode=" + parentCode;
		        title = "二级座落 - 区/县信息";
		    }else if (parentCode.length == 5) {
		        url = "${base}/sys/seatthird/addLoad?parentCode=" + parentCode;
		        title = "三级座落 - 街道/乡信息"; 
		    }
		    else if (parentCode.length == 8) {
		    	
		    	 style='width:90%;height:600px;';
		        url = "${base}/sys/seatfour/addLoad?parentCode=" + parentCode;
		        title = "四级座落 - 社区/村信息"; 
		    }
		    else if (parentCode.length == 12) {
		        url = "${base}/sys/seatgird/addLoad?parentCode=" + parentCode;
		        title = "网格信息"; 
		    }
			bootbox.dialog({
				 url:url,
				  title:title,
				  style:style
				});
		}
	    else {
	        return;
	    }
		 addNodeCallBack=function(){
			bootbox.hideAll();
			bootbox.slideAlert("body");
		   	loadTree();
		   	 var node=ztree.getNodeByParam("code",treeNode.code,null);
		   	 var children=node.children;
		   	 if(children&&children.length>0){
		   		 expands(ztree,children[0]);
		   	 }
		}
	});
   
   delete_a.bind("click",function deleteTreeNode(){
	   bootbox.confirm('确定删除吗？',function(result){
			if(result){
				 $.ajax({
						type : "post",
						url : "${base}/sys/seatgird/deleteGrid?gridCode="+treeNode.code,
						success : function(data) {
							bootbox.slideAlert('body',data.status,data.info);
							if(data.status){
								loadTree();
								 var node=ztree.getNodeByParam("code",treeNode.parentCode,null);
						    	 var children=node.children;
						    	 if(children&&children.length>0){
						    		 expands(ztree,children[0]);
						    	 }    
							}
						}
					}); 
			}
		});
	});
   edit_a.bind("click",function modifyTreeNode() {
		var code=treeNode.code;
		var lev=treeNode.level;
		if (code.length == 5||code.length == 8||code.length == 12||code.length == 20){
			var url="";
			var title="";
			var style='width:80%;height:600px;';
			if (code.length == 2) {
		        url = "${base}/sys/seatfirst/modifyLoad?code=" + code;
		        title = "一级座落 - 市级信息";
		    }
			else if (code.length == 5) {
				alert(code)
		        url = "${base}/sys/seatsecond/modifyLoad?code=" + code;
		        title = "二级座落 - 区/县信息";
		    }
		    else if (code.length == 8) {
		        url = "${base}/sys/seatthird/modifyLoad?code=" + code;
		        title = "三级座落 - 街道/乡信息"; 
		        style='width:90%;height:600px;';
		    }
		    else if (code.length == 12) {
		    	style='width:90%;height:600px;';
		        url = "${base}/sys/seatfour/modifyLoad?code=" + code;
		        title = "四级座落 - 社区/村信息"; 
		    }
		    else if (code.length == 20) {
		        url = "${base}/sys/seatgird/modifyLoad?code=" + code;
		        title = "网格信息"; 
		    }
		    bootbox.dialog({
				 url:url,
				  title:title,
				  style:style
				});
		}
	    else {
	       return;
	   }
	    editNodeCallBack= function () {
	    	bootbox.hideAll();
			bootbox.slideAlert("body");
	    	loadTree();
	    	var node=ztree.getNodeByParam("code",treeNode.code,null);
	    	var children=node.children;
		   	 if(children&&children.length>0){
		   		 expands(ztree,children[0]);
		   	 }
	    }; 
	});
    if (treeNode.code.length == 20) {
    	aObj.after(delete_a);
    	 aObj.after(edit_a);
    }else if (treeNode.code.length == 2) {
    	aObj.after(edit_a);
    	 aObj.after(add_a);
    }
    else{
    	aObj.after(delete_a);
    	aObj.after(edit_a);
    	
    	aObj.after(add_a);
    }
   
}


function doSearch() {
	   updateNodes(false);
	    var txtVal = $("#txtSearchNode").val();
	    // zTree.expandAll(false);
	     nodeList = ztree.getNodesByParamFuzzy("name", txtVal);
	   updateNodes(true);

	}



function updateNodes(l) {
    for (var i = 0; i < nodeList.length; i++) {
        expands(ztree, nodeList[i]);
        nodeList[i].highlight = l;
        ztree.updateNode(nodeList[i]);
    }
}

function expands(t, n) {
    if (n.getParentNode()) {
        expands(t, n.getParentNode());
    }

    t.expandNode(n, true, null, null, null);

}
function loadTree(){
    $.ajax({
        type: "post",
        url: '${base}/sys/seatgird/queryAllGridTree?t=' + Math.random(),
        dataType: "json",
        async: false,
        success: function (data) {
            var zNodes = data;
            var setting = {
            		aClick:false,
                data: {
                	key: {
        				name: "name"
        			},
                    simpleData: {
                        enable: true,
                        idKey: "code",
        				pIdKey:"parentCode"
                    }
                },
                view: {
                    addDiyDom: addDiyDom,
                    fontCss: function (treeId, treeNode) {
                        return (!!treeNode.highlight) ? { color: "#A60000", "font-weight": "bold" } : { color: "#333", "font-weight": "normal" };
                    }
                }

            };

           ztree= $.fn.zTree.init($("#treeDemo"), setting, zNodes);
           ztree.expandAll(true); 
        }
    });
}

$(document).ready(function () {
	
	layer.use('extend/layer.ext.js', function(){
		   layer.ext =function(){};
	}); 
	 
    $("#btnSearchNode").click(
        function () { doSearch(); }
        );
    $("#reset").click(
            function () { 
            	updateNodes(false);
            	$("#txtSearchNode").val('');
            }
            );

    $("#txtSearchNode").keydown(function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) { doSearch(); }
    });
	loadTree();
});
</script>
</html>