	
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
<script type="text/javascript">
  $(function(){
	  if('${vdata.partyOrganizationManager.sex }' )
  });
</script>
<style type="text/css">
  #tbcontent tr:{
     height: 28px;
  }
</style>
</head>
<body>
  <div id="print" style="width: 100%;height: 100%;">
     <div style="width:100%;height: 20px;"></div>
     <div style="width:100%;height: 40px;margin-top: 8px;">
          <div style="text-align: center;width: 70%;margin-left: 70px;">
             <h4>（${vdata.partyOrganizationManager.organizaName }）党组织详细信息</h4>
          </div>
          <div style="margin-left: 280px;margin-top: -28px;width: 30%">
            <div class='ui-pg-div ui-inline-edit'title='打印' style='cursor:pointer;' onclick="print('print')">
				<span class="ui-icon icon-print pull-right"></span>
		     </div>
          </div>
     </div>
     <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=1);height: 3px;margin-top: -1px;" width="90%" color=#987cb9 SIZE=3>
     <div style="width:100%;height: 58%;">
       <table width="100%" border="1" frame=hsides>
         <tr height="29px;">
           <td width="15%" style="text-align: center;">书记姓名</td>
           <td width="20%">${vdata.partyOrganizationManager.secretaryName }</td>
           <td width="15%" style="text-align: center;">组织名称</td>
           <td width="20%">${vdata.partyOrganizationManager.organizaName }</td>
         </tr>
         <tr height="29px;">
           <td style="text-align: center;">性别</td>
           <td>${vdata.partyOrganizationManager.sex }</td>
           <td style="text-align: center;">身份证号</td>
           <td>${vdata.partyOrganizationManager.cid }</td>
         </tr>
         <tr height="29px;">
           <td style="text-align:center; ">党组织类型</td>
           <td>${vdata.partyOrganizationManager.dicValueMap.codePartyOrganizationType }</td>
           <td style="text-align: center;">工作电话</td>
           <td>${vdata.partyOrganizationManager.phone }</td>
         </tr>
         <tr height="29px;">
           <td style="text-align: center;">联系电话</td>
           <td colspan="3">${vdata.partyOrganizationManager.mobile }</td>
         </tr>
       </table>
     </div>
     <div style="text-align: center;margin-top: 10px;">创建时间：${vdata.partyOrganizationManager.createDate }</div>
  </div>
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