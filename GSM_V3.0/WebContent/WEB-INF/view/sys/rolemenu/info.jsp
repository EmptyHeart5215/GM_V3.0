<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>GPS监控平台v2.0</title>
<style type="text/css">
iframe{width:100%;height:100%}
</style>
<link href="${base}/resource/js/jquery-easyui-1.3.6/themes/metro/easyui.css" rel="stylesheet" />
<link href="${base}/resource/js/jquery-easyui-1.3.6/themes/icon.css" rel="stylesheet" />
<link href="${base}/resource/js/zTree/css/zTreeStyle.css" rel="stylesheet" />
<script src="${base}/resource/js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="${base}/resource/js/jquery-easyui-1.3.6/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${base}/resource/js/zDialog/zDrag.js" type="text/javascript"></script>
<script src="${base}/resource/js/zDialog/zDialog.js" type="text/javascript"></script>
<script src="${base}/resource/js/zTree/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>

<script type="text/javascript">

function save(){
	var data = $("#form").serialize();
	$.ajax({
		type : "post",
		url : "${base}/menu/add?t="+Math.random(),
		data : data,
		dataType : 'json',
		async : false,
		success : function(data) {
			if (data.status == "y") {
				parent.Dialog.alert(data.info, function() {
					parent.getMainFrame().waitHandleReload();
					parent.diag.close();
				});
			}else{
				parent.Dialog.alert(data.info);
			}
		}
	});
}

var setting = {
		view: {
			dblClickExpand: false
		},
		data: {
			key: {
				name: "NAME"
			},
			simpleData: {
				enable: true,
				idKey: "ID",
				pIdKey:"PARENT_ID"

			}
		},
		callback: {			
			onClick: onClick
		}
	};
	

	$(function() {
		$.ajax({
			url : "${base}/menu/all?t=" + Math.random(),
			type : "post",
			async : true,
			dataType : "json",
			success : function(data) {

				$.fn.zTree.init($("#treeDemo"), setting, data);
			}
		});
	});
	
	function onClick(e, treeId, treeNode) {

		
		var cityObj = $("[name=parentID]");
		cityObj.attr("value",treeNode.ID);
		
		$("[name=parentNAME]").val(treeNode.NAME);
		
		hideMenu();
	}

	function showMenu() {
		var cityObj = $("[name=parentNAME]");
		var cityOffset = cityObj.offset();
		$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		//alert(event);
		if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}

</script>
</head>
<body>
<form id="form">
		<table>
				<tr>
					<td>父级</td>
					<td>
					 
						<div id="menuContent" class="menuContent" style="display:none; position: absolute; background:white;">
							<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
						</div>
					<input name="parentNAME" type="text" onclick="showMenu()"/>
						   <input name="parentID" type="hidden" />
					</td>
					<td>菜单名</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>				
					<td >地址</td>
					<td colspan=3><input type="text" name="url"  style="width:90%"/></td>
				</tr>
		</table>
		</form>
		<a id="btn" href="#" class="easyui-linkbutton"
			onclick="save()">保存</a>
</body>
</html>