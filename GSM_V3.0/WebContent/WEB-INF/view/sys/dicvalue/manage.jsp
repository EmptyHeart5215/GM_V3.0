<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include  page="/resource/base_import.jsp"/>
</head>
<body>
<script type="text/javascript">

	var setting = {
			aClick:false,
		view : {
			addDiyDom : addDiyDom
		},
		data : {
			key : {
				name : "dicValue"
			},
			simpleData : {
				enable : true,
				idKey : "code",
				pIdKey : "parentCode"

			}
		}

	};
	function initZtree(){
		$.ajax({
			url : "${base}/sys/dicvalue/queryDicValueTree?sysDicCode="
					+ '${sysDicCode}',
			type : "post",
			async : true,
			dataType : "json",
			success : function(data) {
				$.fn.zTree.init($("#treeDemo"), setting, data);
			}
		});
	}
	$(function() {
		initZtree();
	});
	function addDiyDom(treeId, treeNode) {
		treeNode.open = true;
		var li = $("#" + treeNode.tId );
		var add_a='<a href="#" class="green action-buttons" title="新增" onclick="addTreeNode(\''+ treeNode.dicCode+'\',\''+ treeNode.code+ '\')"> <i class="icon-plus-sign bigger-110"></i> </a>';
		var edit_a='<a href="#" class="blue action-buttons" title="修改" onclick="modifyTreeNode(\''+ treeNode.dicCode+'\',\''+ treeNode.code+ '\')"> <i class="icon-pencil bigger-110"></i> </a>';
		var delete_a='<a href="#" class="red action-buttons"title="删除" onclick="delTreeNode(\''+ treeNode.code+ '\')"> <i class="icon-trash bigger-110"></i> </a>';
		li.append(add_a).append(edit_a).append(delete_a);
	}

	function addTreeNode(sysDicCode, code) {
		bootbox.dialog({
			 url:"${base}/sys/dicvalue/addLoad?sysDicCode="
					+ sysDicCode + "&code=" + code,
			  title: "添加字典值",
			  style:'width:600px;height:500px;'
			});
	}
	
	function addTreeNodeFirst(code) {
		bootbox.dialog({
			 url:"${base}/sys/dicvalue/addLoad?code=" + code + "&sysDicCode="+'${sysDicCode}',
			  title: "添加字典值",
			  style:'width:600px;;height:500px;'
			});
	}

	function modifyTreeNode(sysDicCode, code) {
		bootbox.dialog({
			 url:"${base}/sys/dicvalue/modifyLoad?sysDicCode="
					+ sysDicCode + "&code=" + code ,
			  title: "修改字典值",
			  style:'width:600px;;height:500px;'
			});
	}

	function delTreeNode(id) {
		bootbox.confirm('确定删除吗？',function(result){
			if(result){
				 $.ajax({
						type : "post",
						url : "${base}/sys/dicvalue/delete?codes=" + id,
						success : function(data) {
							bootbox.slideAlert('body',data.status,data.info);
							if(data.status){
								initZtree(); 	    
							}
						}
					}); 
			}
		});
	}
	function successFun(){
		bootbox.hideAll();
		bootbox.slideAlert('body');
		initZtree();
	}
</script>
</head>
<body>
	<div class="row">
		<div class="col-xs-12" id="body">
			<button class="btn btn-primary" onclick="addTreeNodeFirst('0000')"><i class="icon-plus align-middle bigger-125"></i>新增字典值</button>
		</div>
		<hr/>
		<div class="col-xs-12">
			<ul id="treeDemo" class="ztree" style="margin-top: 0; width: 200px;">
			
			</ul>
		</div>
	</div>
</body>
</html>