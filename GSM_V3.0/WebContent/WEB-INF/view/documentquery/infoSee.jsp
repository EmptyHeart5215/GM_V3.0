	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看文件内容</title>
<link rel="stylesheet"  href="${base}/resource/css/timeline.css" />
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<script>
$(function(){
if("${vdata.doc.fileCode}"!=""){
	var showOldImgName= "showImg1_old";
	  $.ajax({
		type : "post",
		url : "/GSM_V3.0/sys/sysupload/queryByCodes?codes=${vdata.doc.fileCode}&t="+Math.random(),
		dataType : 'json',
		async : false,
		success : function(data) {
			if(data.length>0){
				for(var i=0;i<data.length;i++){
					var preview=$('<div class="dz-preview dz-image-preview" id="'+data[i].code+'_div">  \
									<div class="dz-details">   \
										 <div class="dz-filename"> \
											 <span>'+data[i].name+'</span> \
										 </div> \
					   					 <img src="'+getImgPath(data[i].name,data[i].path)+'" id="'+data[i].code+'" alt="'+data[i].name+'" name="'+showOldImgName+'" > \
									</div> \
					   			</div>');
					 var downloadBtn=$('<button type="button" class="btn btn-xxs btn-primary" style="margin-right: 4px;" >\
											<i class="icon-cloud-download  bigger-100"></i>下载\
										</button>');
					
					 var code=data[i].code;
					 downloadBtn.bind('click',function(){
						 window.location.href ='/GSM_V3.0/sys/sysupload/downLoad?code='+code;
					 });
					 preview.append(downloadBtn);
					 $("#picDisplay_old1").append(preview);
				}
				layerGallery(showOldImgName);
			}
		}
	}); 
	  
	}
});


</script>
</head>
<style>
.dz-preview {
    background: rgba(255,255,255,0.8);
    position: relative;
    display: inline-block;
    margin: 2px 10px 2px 10px;
    vertical-align: top;
    border: 1px solid #acacac;
    padding: 6px 6px 6px 6px;
    box-shadow: 1px 1px 4px rgba(0,0,0,0.16);
font-size: 14px;
box-sizing: border-box;
}

</style>
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
					<h2><center>${vdata.doc.documentName}</center></h2>
					
					<table class="print-table" >
							<tr>
								<td class="col-xs-2">所属辖区或部门</td><td class="print-normal col-xs-4">${vdata.doc.gridTotalName }</td>
								<td class="col-xs-2">文件类型</td><td class="print-normal col-xs-4">${vdata.doc.dicValueMap.codeDocumnetType}</td>
							</tr>
							<tr>
								<td class="col-xs-2">文件大小</td><td class="print-normal col-xs-4">${vdata.doc.documentSize}</td>
								<td class="col-xs-2">上传时间</td><td class="print-normal col-xs-4">${vdata.doc.createDate}</td>
							</tr>
							<tr>
								<td class="col-xs-2">备注</td><td colspan="3" class="print-normal col-xs-10">${vdata.doc.remark}</td>
							</tr>
							<tr>
								<td class="col-xs-2">文件</td>
								<td colspan="3" class="print-normal col-xs-10">
											<div id="picDisplay_old1">
										    </div>
								</td>
							</tr>
						</table>
				</div>
		    </div>
       </div>
     </div>
   </div>
</div><!-- row -->
</body>
</html>