<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">

var setting = {
			check: {
				enable: true
			},			
			data: {
				key: {
					name: "menuName"
				},
				simpleData: {
	 				enable: true,
	 				idKey: "code",
	 				pIdKey:"parentCode"
				}
			}
		};
		
$(function(){
	$.ajax({
		type : "post",
		url : "${base}/sys/rolemenu/queryAllByRole?roleCode=${roleCode}&t="+Math.random(),		
		dataType : 'json',
		async : false,
		success : function(data) {
			$.fn.zTree.init($("#treeDemo"), setting, data).expandAll(true);
		}
	});
	//父窗口中的提交按钮
	$("#commitBtn",parent.document).bind("click",function(){
		save();
	});
});

function save(){
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var checkedNodes=zTree.getCheckedNodes(true);
	var menuIDs=[];
	for(var i=0;i<checkedNodes.length;i++){
		menuIDs.push(checkedNodes[i].code);
	}	
	var data={"roleCode":"${roleCode}","menuCodes":menuIDs+""};
	$.ajax({
		type : "post",
		url : "${base}/sys/rolemenu/grant?t="+Math.random(),
		data :data,
		dataType : 'json',
		async : false,
		success : function(data) {
			if(data.status){
            	parent.successFun();
            }else{ 
            	bootbox.slideAlert('body',false,data.info);
             } 
		}
	});
}

</script>


</head>
<body>
<div class="row">
		<form id="form">
		<div class="col-xs-12">
			<ul id="treeDemo" class="ztree" style="margin-top: 0; width: 100%; height:450px; overflow:auto;">
			</ul>
		</div>
		</form>
	</div>
</body>
</html>


