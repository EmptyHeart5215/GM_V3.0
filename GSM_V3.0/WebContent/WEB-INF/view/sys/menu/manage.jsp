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
<script type="text/javascript">
var ztree;
var nodeList = [];
var setting = {
// 		view: {
// 			addDiyDom: addDiyDom
// 		},
		data: {
			key: {
				name: "menuName"
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
	
function init(){
	$.ajax({
		url : "${base}/sys/menu/queryManage?t=" + Math.random(),
		type : "post",
		async : true,
		dataType : "json",
		success : function(data) {	
			var root={"code":"--","menuName":"根目录"};
			data.push(root);
// 			$.fn.zTree.init($("#treeDemo"), setting, data).expandAll(true);
			 ztree= $.fn.zTree.init($("#treeDemo"), setting, data);
	         //ztree.expandAll(true); 
			
		}
	});
}
	
function successFun() {
	bootbox.hideAll();
	bootbox.slideAlert("body");
	init();
}
	$(function() {
		init();
	});
	
    function addDiyDom(treeId, treeNode) {
        var aObj = $("#" + treeNode.tId + "_a");
        aObj.css("margin-right","20px");
        var editStr = "<a class='green action-buttons'title='新增' onclick='addTreeNode(\"" + treeNode.code + "\",\"" + treeNode.name + "\")'><i class='icon-plus-sign bigger-110'></i></a>\
<a class='blue action-buttons'title='修改' onclick='modifyTreeNode(\"" + treeNode.code + "\")'><i class='icon-pencil bigger-110'></i></a>\
<a class='red action-buttons'title='删除' onclick='delTreeNode(\"" + treeNode.code + "\")'><i class='icon-trash bigger-110'></i></a>";

        aObj.after(editStr);
        // alert(treeNode.id);
    }
    var style='width:80%;height:500px;';
    function addTreeNode(pid,parentName){
    	bootbox.dialog({
			 url:"${base}/sys/menu/addLoad?parentCode="+pid+"&parentName="+parentName,
			  title:"增加菜单功能",
			  style:style
			});
    }
    
 function modifyTreeNode(code){
	 bootbox.dialog({
		 url:"${base}/sys/menu/modifyLoad?code="+code,
		  title:"编辑菜单功能",
		  style:style
		});
    }
 
 function delTreeNode(id){
	 bootbox.confirm('确定删除吗？',function(result){
			if(result){
				 $.ajax({
						type : "post",
						url : "${base}/sys/menu/delete?code="+id,
						success : function(data) {
							bootbox.slideAlert('body',data.status,data.info);
							if(data.status){
								init(); 
							}
						}
					}); 
			}
		});
 }
 $(document).ready(function () {
	 $("#btnSearchNode").click(
				function () { doSearch(); }
			);
			 
			 

			 function doSearch() {
				    updateNodes(false);
				    var txtVal = $("#txtSearchNode").val();
				    // zTree.expandAll(false);
				    nodeList = ztree.getNodesByParamFuzzy("menuName", txtVal);
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

	});

</script>
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
			<ul id="treeDemo" class="ztree" style="margin: 0; padding: 25px; color: #333; height:500px;overflow:auto"></ul>
		</div>
	</div>
</body>
</html>