<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include  page="/resource/base_import.jsp"/>
</head>
<body>
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
var zTree;
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
			if (parentCode.length == 2||parentCode.length == 5||parentCode.length == 8||parentCode.length == 12){
				var style='width:60%;height:450px;';
				if (parentCode.length == 2) {
					url = "${base}/sys/seatsecond/addOrgLoad?parentCode=" + parentCode;
			    }else if (parentCode.length == 5) {
			        url = "${base}/sys/seatthird/addOrgLoad?parentCode=" + parentCode;
			    }
			    else if (parentCode.length == 8) {
			        url = "${base}/sys/seatfour/addOrgLoad?parentCode=" + parentCode;
			    }
			    else if (parentCode.length == 12) {
			        url = "${base}/sys/seatgird/addOrgLoad?parentCode=" + parentCode;
			    }
				 bootbox.dialog({
					 url:url,
					  title:"组织机构",
					  style:style
					});
			}
		    else {
		        return;
		    }
			 addNodeCallBack=function(){
					bootbox.hideAll();
					bootbox.slideAlert("body");
				   	loadFun();
				   	 var node=zTree.getNodeByParam("code",treeNode.code,null);
				   	 var children=node.children;
				   	 if(children&&children.length>0){
				   		 expands(zTree,children[0]);
				   	 }
				};
		});
	   delete_a.bind("click",function deleteTreeNode(){
		   bootbox.confirm("确定要删除吗?",function(result){
			   if(result){
				 $.ajax({
						type : "post",
						url : "${base}/sys/seatgird/deleteGrid?gridCode="+treeNode.code,
						dataType : 'json',
						async : false,
						success : function(data) {
							bootbox.slideAlert('body',data.status,data.info);
							if(data.status){
								loadFun();
								 var node=zTree.getNodeByParam("code",treeNode.parentCode,null);
						    	 var children=node.children;
						    	 if(children&&children.length>0){
						    		 expands(zTree,children[0]);
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
				var style='width:50%;height:450px;';
			    if (code.length == 5) {
			        url = "${base}/sys/seatsecond/modifyOrgLoad?code=" + code;
			    }
			    else if (code.length == 8) {
			        url = "${base}/sys/seatthird/modifyOrgLoad?code=" + code;
			    	
			    }
			    else if (code.length == 12) {
			        url = "${base}/sys/seatfour/modifyOrgLoad?code=" + code;
			    }
			    else if (code.length == 20) {
			        url = "${base}/sys/seatgird/modifyOrgLoad?code=" + code;
			    }
			    bootbox.dialog({
					 url:url,
					  title:"组织机构",
					  style:style
					});
			}
		    else {
		        return;
		    }
			editNodeCallBack= function () {
		    	bootbox.hideAll();
				bootbox.slideAlert("body");
		    	loadFun();
		    	var node=zTree.getNodeByParam("code",treeNode.code,null);
		    	expands(zTree,node);
		    }; 
		});
	//如果是组织机构
     if (treeNode.flagDepartment ===true) {
    	 aObj.after(delete_a);
    	 aObj.after(edit_a);
    	 if(treeNode.code.length!=20){
    		 aObj.after(add_a);
    	 }
     }else if(treeNode.code.length!=20) {
    	aObj.after(add_a);
     }
}


var nodeList = [];

function doSearch() {
   updateNodes(false);
    var txtVal = $("#txtSearchNode").val();
    // zTree.expandAll(false);
     nodeList = zTree.getNodesByParamFuzzy("name", txtVal);
   updateNodes(true);

}



function updateNodes(l) {
    for (var i = 0; i < nodeList.length; i++) {
        expands(zTree, nodeList[i]);
        nodeList[i].highlight = l;
        zTree.updateNode(nodeList[i],false);

    }
}

function expands(t, n) {
    if (n.getParentNode()) {
        expands(t, n.getParentNode());
    }

    t.expandNode(n, true, null, null, null);

}
function loadFun(){
	  $.ajax({
	        type: "post",
	        url: '${base}/sys/seatgird/queryOrgnizationTree?t=' + Math.random(),
	        dataType: "json",
	        async: false,
	        success: function (data) {
	        	var root = {
						"code" : "01",
						"name" : "唐山市"
					};
			    data.push(root);
	            var zNodes = data;
	            var setting = {
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

	            zTree=$.fn.zTree.init($("#treeDemo"), setting, zNodes);
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
    loadFun();

});
</script>
</html>