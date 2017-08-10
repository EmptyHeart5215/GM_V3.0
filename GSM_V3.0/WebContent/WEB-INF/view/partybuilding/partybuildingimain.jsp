<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>社会管理网格化系统V3.0</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include  page="/resource/base_import.jsp"/>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
.ace-nav .listyle {
    border-left: 1px solid #ddd;
    float: left !important;
    height: 60px;
    line-height: 26px;
    padding: 0;
    position: relative;
    text-align: center;
    cursor: pointer;
}
</style>
<link href="${base}/resource/js/zTree/css/zTreeStyle.css" rel="stylesheet" />
<script src="${base}/resource/js/zTree/jquery.ztree.core-3.5.js" type="text/javascript"></script>
<script src="${base}/resource/js/zTree/jquery.ztree.excheck-3.5.js" type="text/javascript"></script>
<script type="text/javascript">
   $(function(){
	   var setting = {
				callback:{
					onClick: zTreeOnClicks
				},
				data: {
					key: {
						name: "name"
					},
					simpleData: {
						enable: true,
						//open:true,
						idKey: "code",
						pIdKey:"parentCode",
						
					}
				}
			};
		$.ajax({
		      type: "get", 
		      url: '${base}/partybuilding/partyorganizationmanager/queryPartyBuildingTree',
		      //url: '${base}/temp/queryPartyBuildingTree',
		      dataType: 'json',
		      async: true,
		      success: function (data) {
		    	  var zNodes = data;
		    	  $.fn.zTree.init($("#xqTree"), setting, zNodes);
		    	  var treeObj = $.fn.zTree.getZTreeObj("xqTree"); 
		    	  treeObj.expandAll(true); 
		      }
		 });
   });
   
   function zTreeOnClicks(event, treeId, treeNode){
	   
		var xqCode = treeNode.code;
		var pomcode = treeNode.pomcode;
		/* var url = 'partybuilding/partyorganizationmanager/queryPartyOrganizationManagerByGridCode?gridCode='+xqCode
		$("#partymainFrame").attr("src", "${base}/"+url); */
		$(partymainFrame.document).contents().find('input[id=pomcode]').attr("value",pomcode);
		$(partymainFrame.document).contents().find('input[id=xq]').attr("value",xqCode);
		
	}
</script>
</head>
 <body>
<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
	<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar"  style="overflow: auto">
					<ul id="xqTree" class="ztree"></ul>
				</div><!-- sidebar end -->

			<div class="main-content">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<iframe src="${base}/partybuilding/organizationprofile/manageLoad" id="partymainFrame" name="partymainFrame" scrolling="no" frameborder="0" marginheight="0" marginwidth="0" style=" top: 0px; bottom: 0px; width: 100%; min-height:600px;"></iframe>
						</div><!-- "col-xs-12" -->
					</div><!--row -->
				</div><!-- page-content -->
			</div><!-- main-content-->
				</div><!-- main-container-inner-->
</div><!--main-container -->
				<!-- basic scripts -->


		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="${base}/resource/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${base}/resource/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${base}/resource/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${base}/resource/js/jquery.slimscroll.min.js"></script>
		<script src="${base}/resource/js/jquery.easy-pie-chart.min.js"></script>
		<script src="${base}/resource/js/jquery.sparkline.min.js"></script>
		<script src="${base}/resource/js/flot/jquery.flot.min.js"></script>
		<script src="${base}/resource/js/flot/jquery.flot.pie.min.js"></script>
		<script src="${base}/resource/js/flot/jquery.flot.resize.min.js"></script>
 </body>
</html>