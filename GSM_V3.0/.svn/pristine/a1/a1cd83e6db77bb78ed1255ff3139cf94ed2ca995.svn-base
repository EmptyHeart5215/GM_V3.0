
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script src="/GSM_V3.0/resource/js/ckeditor/ckeditor.js"></script>
<link href="/GSM_V3.0/resource/js/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" />
<script src="/GSM_V3.0/resource/js/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="/GSM_V3.0/resource/js/bootstrap-wysihtml5/jquery.base64.js"></script>
<script type="text/javascript">
var deleteFun=function(code,types){
	bootbox.confirm('确定删除吗？',function(result){
		if(result){
			var typ=$("#"+types).val();
			var typs=typ.replace(code,"");
			var newtyp=typs.replace(",,",",");
			if(newtyp.charAt(0)==","){
				newtyp = newtyp.substring(1,newtyp.length);
			}
			if(newtyp.charAt(newtyp.length-1)==","){
				newtyp = newtyp.substring(0,newtyp.length-1);
			}
			 $("#"+types).val(newtyp);
			 if(newtyp==null||newtyp==""){
					$("#grid-table"+types).hide();
				}else{
					getValues(types);
				}
		}
	});
};
function teamlist(postData,types){
	 $("#grid-table"+types).jqGrid({
		    postData:postData,
		 	url : "${base}/emergencyscheduling/emergencyteam/queryManage",
		 	defaultCaozuo:false,
		 	autowidth:false,
		 	width:860,
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
		    	  bootbox.dialog({
						 url:"${base}/emergencyscheduling/emergencyteam/detailLoad?code="+rowid+"&stepId=1&entryId=1",
						  title: "应急队伍详细信息表",
						  iframeStyle:'height:1500px;',
						  style:'width:1000px;height:600px;'
						});
		      },
		    colNames:[ '字典主键','队伍名称','队伍负责人','负责人联系电话','队伍类型','所属辖区','删除'],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
				{name:'teamName',index:'teamName',sortable:true, width:'20%', align:"left"},
	            {name:'teamPrincipal',index:'teamPrincipal',sortable:true, width:'20%', align:"left"},
	            {name:'principalPhone',index:'principalPhone',sortable:true, width:'20%', align:"left"},
	            {name:'dicValueMap.codeTeamType',index:'dicValueMap.codeTeamType',sortable:true, width:'10%', align:"left"},
	            {name:'gridTotalName',index:'gridTotalName',sortable:true, width:'20%', align:"left"},
	            {name:'caozuo',width:40,fixed:true, sortable:false, resize:false,formatter:
	            	function(cellvalue, options, rowObject){
	            	    var code=rowObject['code'];
	            	    var div='<div style="margin-left:8px;">';
            				div+="</div> <div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\",\""+types+"\")'>";
            				div+='<span class="ui-icon ui-icon-trash"></span>';
           					div+='</div>';
           					div+='</div>';
		            		return div;
	            	 }
	             } 
	            ],
	            sortable:true, 
		        rownumbers:false,//添加左侧行号
		        altRows:true,//班玛线
		        sortname:'createDate',
		        sortorder:'desc',
		        viewrecords: false,//是否在浏览导航栏显示记录总数
		        multiselect: false, 
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
	    });
}
function placelist(postData,types){
	 $("#grid-table"+types).jqGrid({
		    postData:postData,
		 	url : "${base }/emergencyscheduling/emergencyplace/queryManage",
		 	defaultCaozuo:false,
		 	autowidth:false,
		 	width:860,
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
		    	  bootbox.dialog({
						 url:"${base}/emergencyscheduling/emergencyplace/detailLoad?code="+rowid+"&stepId=1&entryId=1",
						  title: "应急场所详细信息表",
						  iframeStyle:'height:1500px;',
						  style:'width:1000px;height:600px;'
						});
		      },
		 	colNames:[ '主键','场所名称','场所地址','场所面积','容纳人数','所属辖区','删除'],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
				{name:'placeName',index:'placeName',sortable:false, width:'10%',align:'center'},
	            {name:'address',index:'address',sortable:false, width:'10%',align:'center'},
	            {name:'placeArea',index:'placeArea',sortable:false, width:'10%', align:"center"},
	            {name:'accommodateNum',index:'accommodateNum',sortable:false, width:'10%', align:"center"},
	            {name:'gridTotalName',sortable:false,width:'20%'},
	            {name:'caozuo',width:40,fixed:true, sortable:false, resize:false,formatter:
	            	function(cellvalue, options, rowObject){
	            	    var code=rowObject['code'];
	            	    var div='<div style="margin-left:8px;">';
            				div+="</div> <div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\",\""+types+"\")'>";
            				div+='<span class="ui-icon ui-icon-trash"></span>';
           					div+='</div>';
           					div+='</div>';
		            		return div;
	            	 }
	             }
	        ],
	            sortable:true, 
		        rownumbers:false,//添加左侧行号
		        altRows:true,//班玛线
		        sortname:'createDate',
		        sortorder:'desc',
		        viewrecords: false,//是否在浏览导航栏显示记录总数
		        multiselect: false, 
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
	    });
}
function supplieslist(postData,types){
	 $("#grid-table"+types).jqGrid({
		    postData:postData,
		 	url : "${base }/emergencyscheduling/emergencysupplies/queryManage",
		 	defaultCaozuo:false,
		 	autowidth:false,
		 	width:860,
		 	ondblClickRow:function(rowid,iRow,iCol,e){
		    	  var code=$('#grid-table').jqGrid('getGridParam', "selrow");
		    	  bootbox.dialog({
						 url:"${base}/emergencyscheduling/emergencysupplies/detailLoad?code="+rowid+"&stepId=1&entryId=1",
						  title: "应急物资详细信息表",
						  iframeStyle:'height:1500px;',
						  style:'width:1000px;height:600px;'
						});
		      },
		 	colNames:[ '主键','物资名称','物资存放地址','物资负责人','物资负责人电话','物资数量','物资类型','物资状态','所属辖区','删除'],
	        colModel:[
				{name:'code',index:'code',sortable:false, hidden:true},
				{name:'suppliesName',index:'suppliesName',sortable:false,width:'20%'},
				{name:'suppliesStoreAddress',index:'suppliesStoreAddress',sortable:false, width:'10%',align:'center'},
	            {name:'suppliesprincipal',index:'suppliesprincipal',sortable:false, width:'10%',align:'center'},
	            {name:'suppliesPhone',index:'suppliesPhone',sortable:false, width:'10%', align:"center"},
	            {name:'suppliesNum',index:'suppliesNum',sortable:false, width:'10%', align:"center"},
	            {name:'dicValueMap.codeSuppliesType',index:'dicValueMap.codeSuppliesType',sortable:false, width:'10%', align:"center"},
	            {name:'dicValueMap.codeSuppliesState',index:'dicValueMap.codeSuppliesState',sortable:false, width:'10%', align:"center"},
	            {name:'gridTotalName',sortable:false,width:'20%'},
	            {name:'caozuo',width:40,fixed:true, sortable:false, resize:false,formatter:
	            	function(cellvalue, options, rowObject){
	            	    var code=rowObject['code'];
	            	    var div='<div style="margin-left:8px;">';
            				div+="</div> <div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\",\""+types+"\")'>";
            				div+='<span class="ui-icon ui-icon-trash"></span>';
           					div+='</div>';
           					div+='</div>';
		            		return div;
	            	 }
	             }
	        ],
	            sortable:true, 
		        rownumbers:false,//添加左侧行号
		        altRows:true,//班玛线
		        sortname:'createDate',
		        sortorder:'desc',
		        viewrecords: false,//是否在浏览导航栏显示记录总数
		        multiselect: false, 
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
	    });
}
$(function(){;
	if($("#teamCode").val() != null&&$("#teamCode").val() !=''){
		getValues("teamCode");
	} 
	if($("#placeCode").val() != null&&$("#placeCode").val() !=''){
		getValues("placeCode");
	} 
	if($("#suppliesCode").val() != null&&$("#suppliesCode").val() !=''){
		getValues("suppliesCode");
	}
	changeIframeHeight();
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone1=new Dropzone("#dropzoneDiv1",{
		 	 urlBase:"${base}",
			 url: function(){
	         	return "${base}/sys/sysupload/uploadFile";
	         },
	         existedFiles:$('#url_pic1').val().split(";").length-1,
		 	uploadBtnId:'uploadBtn1',
            imgName:'showImg1',
            acceptedFiles:'.txt,.doc,.docx',
            maxFilesize: 10,//最大文件大小，MB
            maxFiles:1
	});
	//dropzone代表dropzone对象
	//urlPicI表示model中存放上传文件id的那个字段使用的input的id，type 是hidden的
	//showOldImgName表示在组装已经存在的的图片的时候用的img标签的name
	//showOldImgDivId表示用来展示已经存在的图片的div的id
	getOldPics(dropzone1,"url_pic1","showImg1_old","picDisplay_old1");
	$("#form").validate({
		submitHandler: function (form) {
		$('#url_pic1').val('');
		 	//获取上传文件的值
		 	var ids1='';
		 	$('[name^=showImg1]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids1+=this.id+";";
		 		}
		 	});
		 	var array = new Array();
			array = returnValue();
		 	$('#url_pic1').val(ids1);
		 	//var text= editor.document.getBody().getText();
		 	/* var text = editor.getData();
		 	$("#materialContent").val(text); */
			
			/* if(typeof(array[2]) == "undefined"){
				array[2] = 0;
				$("#materialSize").attr("value",array[2]);
			}else{
				$("#materialSize").attr("value",array[2]);
			} */
			var data = $("#form").serialize();
		    $.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
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
	    
	});
	//父窗口中的提交按钮
	$("#commitBtn",parent.document).bind("click",function(){
		$("#form").submit();
	});
	
	$("[name=gridCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryOrgnizationTree?t=' + Math.random()	
	});
	//预案类型
	$("[name='codePlanType']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_PLAN_TYPE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
});

function openPerssonInfo(url,name,style){
	var select=$("#"+style).val();
	url=url+"&select="+select;
	 var dialog=bootbox.dialog({
		  backdrop: true,
		  url:url,
		  title: name+"信息",
		  iframeStyle:"height:240px;",
		  style:'width:690px;height:360px;',
		  buttons: {
			    
			  success: {
			      id:"commitBtn",
			      label: "提交",
			      className: "btn-success",
			      callback: function(){
			    	  $("#dialog_iframe")[0].contentWindow.ids(); 
			    	  // return false 则dialog就不会关闭
			    	  return false;
			      }
			   }
			  }
		});	
}
function getValue(rowData,types){
	$("#"+types).val(rowData);
	changeIframeHeight();
	if(rowData==null||rowData==""){
		$("#grid-table"+types).hide();
	}else{
		getValues(types);
	}
	bootbox.hideAll();
}
function getValues(types){
	var  postData = "";
	postData={"args":JSON.stringify($("#"+types).serializeJson())};
	switch(types)
	{
	case "teamCode":
	  teamlist(postData,types);
	  $("#grid-table"+types).jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
	  break;
	case "placeCode":
	  placelist(postData,types);
	  $("#grid-table"+types).jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
	  break;
	case "suppliesCode":
	  supplieslist(postData,types);
	  $("#grid-table"+types).jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
	  break;
	}
}
function changeIframeHeight(){
	var iframe=parent.document.getElementById("dialog_iframe");
	var subWeb = document.frames ? iframe.document : iframe.contentDocument;   
	if(iframe != null && subWeb != null) {
		var height=iframe.style.height;
		if(height.substring(0, height.indexOf("px"))<subWeb.body.scrollHeight){
			iframe.style.height = (subWeb.body.scrollHeight+30)+"px";
		}
	}  
}

</script>
</head>
<body>
<div class="row">
       <div class="search-group">
       <input type="hidden" name="code" " />
       </div>
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.emergencyPlan.code }" />
			<input type="hidden" name="teamCode" id="teamCode" value="${vdata.emergencyPlan.teamCode }" />
			<input type="hidden" name="placeCode" id="placeCode" value="${vdata.emergencyPlan.placeCode }" />
			<input type="hidden" name="suppliesCode" id="suppliesCode" value="${vdata.emergencyPlan.suppliesCode }" />
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属辖区</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.emergencyPlan.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>	
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="emergencyName"><span class="red">*</span>预案名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="emergencyName" name="emergencyName" value="${vdata.emergencyPlan.emergencyName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" for="codePlanType"><span class="red">*</span>事件类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codePlanType" name="codePlanType" value="${vdata.emergencyPlan.codePlanType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>	
				
				<div class="form-group" id="fileUp">
					<label class="col-xs-2 control-label no-padding-right text-right">上传文件资料 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv1' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn1" type="button">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							 <!-- <span><font color="#FF0000">(多资料上传时，请注意须同时上传，以免使资料大小存在数据差异)</font></span> -->
							<br>
						</div>
							<input type="HIDDEN" id="url_pic1" name="materialFile" value="${vdata.emergencyPlan.materialFile }" />
						</div>
					</div>
				</div>
				<c:if test="${vdata.emergencyPlan.materialFile != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存文件 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old1" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="emergencyContent"><span class="red">*</span>预案说明</label>
					<div class="col-xs-10">
						<textarea  max-length="50000"id="emergencyContent" name="emergencyContent"  class="col-xs-12 col-sm-12 tooltip-error required">${vdata.emergencyPlan.emergencyContent}</textarea>
						</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="codePlanType"></label>
					<div class="col-xs-10">
					<div class="clearfix">
					    <input type="button" id="teamName" name="teamName" value="选择应急队伍" placeholder="请双击输入框重新选择" onclick="openPerssonInfo('${base}/emergencyscheduling/emergencyteam/queryteamSelect?code=teamCode','应急队伍','teamCode')" class="btn btn-success " />
					    <input type="button" id="placeName" name="placeName" value="选择应急场所" placeholder="请双击输入框重新选择" onclick="openPerssonInfo('${base}/emergencyscheduling/emergencyplace/queryplaceSelect?code=placeCode','应急场所','placeCode')" class="btn btn-success" />
					    <input type="button" id="suppliesName" name="suppliesName" value="选择应急物资" placeholder="请双击输入框重新选择" onclick="openPerssonInfo('${base}/emergencyscheduling/emergencysupplies/queryplaceSelect?code=suppliesCode','应急物资','suppliesCode')" class="btn btn-success " />
					</div>
					</div>
				</div>
				<div style="float:right">
				<table id="grid-tableteamCode" ></table>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="placeName">应急队伍列表</label>
				</div>
				<div style="float:right">
				<table id="grid-tableplaceCode" ></table>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="placeName">应急场所列表</label>
				</div>
				<div style="float:right">
				<table id="grid-tablesuppliesCode" ></table>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="placeName">应急物资列表</label>
				</div>
				
				<div class="space-4"></div>
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
			</form>
		</div>
	</div>
	</body>
</html>