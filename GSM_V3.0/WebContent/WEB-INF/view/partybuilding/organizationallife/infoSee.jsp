	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看资料内容</title>
<link rel="stylesheet"  href="${base}/resource/css/timeline.css" />
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<style type="text/css">
  #tbcontent tr:{
     height: 28px;
  }
</style>
</head>
<body>
<div class="row">
   <div class="col-xs-12" id="body">
     <div class="tabbable tabs-left">
       <div class="tab-content" >
            <div id="detailDiv" class="tab-pane in active">
               <div class="col-xs-12" style='text-align:right;'>
					<div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
				         <span class="ui-icon icon-print pull-right"></span>
		            </div>
	            </div>
	            <div id="print">
					<h2><center>党组织生活信息采集表</center></h2>
					<table width="60%" align="center">
					  <tr>
					     <td width="18%">网格编码：</td>
					     <td width="35%">${vdata.partyOrganizationalife.gridCode }</td>
					      <td width="18%">创建日期：</td>
					     <td width="35%">${vdata.partyOrganizationalife.createDate }</td>
					  </tr>
					</table>
					<table id="tbcontent" align="center" width="100%" border="1">
					   <tr height="28px;">
					     <td width="15%">活动主题</td>
					     <td width="30%">${vdata.partyOrganizationalife.titleName }</td>
					     <td width="15%">负责人/召集人</td>
					     <td width="30%">${vdata.partyOrganizationalife.responsibleName }</td>
					   </tr>
					   <tr height="28px;">
					     <td width="15%">活动的人员范围</td>
					     <td width="30%">${vdata.partyOrganizationalife.responsibleRange }</td>
					     <td width="15%">活动地点</td>
					     <td width="30%">${vdata.partyOrganizationalife.responsibleLocation }</td>
					   </tr>
					   <tr height="28px;">
					     <td width="15%">活动开始时间</td>
					     <td width="30%">${vdata.partyOrganizationalife.beginTime }</td>
					     <td width="15%">活动结束时间</td>
					     <td width="30%">${vdata.partyOrganizationalife.endTime }</td>
					   </tr>
					   <tr height="28px;">
					     <td width="15%">参加活动人数</td>
					     <td width="30%">${vdata.partyOrganizationalife.orgPersons }</td>
					     <td width="15%">党员参与人数</td>
					     <td width="30%">${vdata.partyOrganizationalife.massesPersons }</td>
					   </tr>
					   <tr height="28px;">
					     <td width="15%" rowspan="2">活动内容</td>
					     <td width="30%" colspan="3" rowspan="2">${vdata.partyOrganizationalife.contents }</td>
					   </tr>
					   <tr height="28px;">
					   </tr>
					</table>
					<hr/>
				</div>
		    </div>
		    <div>
		      ${vdata.zongzhiMaterial.materialContent}
		    </div>
       </div>
     </div>
   </div>
</div><!-- row -->
<script type="text/javascript">
	
	$(document).ready(function () {
	
	//如果子页面需要进行图片浏览，必须加上这句-------------
	layer.use('extend/layer.ext.js', function(){
		   layer.ext =function(){};
	}); 
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone=new Dropzone("#dropzoneDiv",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic').val().split(";").length-1
	});
	 getOldPics(dropzone);
	$("#form").validate({
		submitHandler: function (form) {
		 	$('#url_pic').val('');
		 	//获取上传的图片的值
		 	var ids='';
		 	$('[name^=showImg]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids+=this.id+";";
		 		}
		 	});
		 	$('#url_pic').val(ids);
		 	var data = $("#form").serialize();
		 	 $.ajax({
				type : "post",
				url : "${base}/${map.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	if('${map.url}'.indexOf('modify')>0){
		    				parent.editNodeCallBack();
		    			}else{
		    				parent.addNodeCallBack();
		    			}
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			});  
        }
	});
	
});
  
</script>
</body>
</html>