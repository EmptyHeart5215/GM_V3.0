<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
var peoples='${vdata.people}';
var grid_data = eval(peoples);
//添加按钮方法，方法名固定，不可改变
var addFun=function(){
	bootbox.dialog({
		url:"${base}/base/bjigouservice/addPeopleLoad?serviceId=${vdata.code}",
		 title: "被服务人员详细信息",
		  style:'width:600px;height:400px;'
		});
};
//编辑按钮方法，方法名固定，不可改变
function editFun(code,name,sex,phone,address){
	var url="${base}/base/bjigouservice/modifyPeopleLoad?code="+code+"&name="+encodeURIComponent(name)+"&phone="+encodeURIComponent(phone)+"&sex="+encodeURIComponent(sex)+"&address="+encodeURIComponent(address);
		var dialog=bootbox.dialog({
			url:url,
			  title: "被服务人员详细信息",
			  style:'width:600px;height:400px;'
		});
}
//删除按钮方法，方法名固定，不可改变
var deleteFun=function(code){
	 if(code&&"string"!=typeof code){
			var code=$('#grid-table2').jqGrid('getGridParam', "selarrrow");
			 if(code.length==0){
				 bootbox.alert('请至少选择一条信息！');
				 return;
			 }
		}
	bootbox.confirm('确定删除吗？',function(result){
		if(result){
		    var selectedRowIds = $("#grid-table2").jqGrid("getGridParam","selarrrow");  
		    var len = selectedRowIds.length;  
		    for(var i = 0;i < len ;i ++) {  
		    	$("#grid-table2").jqGrid("delRowData", selectedRowIds[0]);  
		    }  
			/*  $.ajax({
					type : "post",
					url : "${base}/base/bjigouservice/deletePeople?codes="+code,		
					dataType : 'json',
					async : false,
					success : function(data) {
						bootbox.slideAlert('body',data.status,data.info);
						if(data.status){
							$("#grid-table").trigger("reloadGrid"); 	  								}
					}
				});  */
		}
	});
};

$(function(){
	
	var grid_selector = "#grid-table2";
	var pager_selector = "#grid-pager2";

	var p=jQuery(grid_selector).jqGrid({
		data: grid_data,
		datatype: "local",
		defaultCaozuo:false,
		height: "auto",
		colNames:[ '','姓名', '性别', '联系电话','联系地址','操作'],
		colModel:[
			{name:'code',index:'code',sortable:false,hidden:true},
			{name:'name',index:'name', width:'20%',editable: true,editoptions:{size:"20",maxlength:"10"}},
			{name:'sex',index:'sex', width:'20%', editable: true,edittype:"select",editoptions: {value:"女:女;男:男"}},
			{name:'phone',index:'phone', width:'20%', editable: true,editoptions:{onblur:"checkPhone(this)",size:"20",maxlength:"50",class:"tooltip-error allPhone"}},
			{name:'address',index:'address', width:'30%', sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"20"}}
			,
            {name:'caozuo',width:120,fixed:true, sortable:false, resize:false,formatter:
           	function(cellvalue, options, rowObject){
	            	var code=rowObject['code'];
	            	var phone=rowObject['phone'];
	            	var name=rowObject['name'];
	            	var sex=rowObject['sex'];
	            	var address=rowObject['address'];
	            	var div='<div style="margin-left:8px;">';
	            	div+="<div class='ui-pg-div ui-inline-edit'title='编辑' style='float:left;cursor:pointer;' onclick='editFun(\""+code+"\",\""+name+"\",\""+sex+"\",\""+phone+"\",\""+address+"\")'>";
		            div+='<span class="ui-icon ui-icon-pencil"></span>';
      				div+="</div> <div  class='ui-pg-div ui-inline-del'title='删除' style='float:left;margin-left:5px;'onclick='deleteFun(\""+code+"\")'>";
      				div+='<span class="ui-icon ui-icon-trash"></span>';
     				div+='</div>';
     				div+='</div>';
	            	return div;
           	 }
            }
		], 

		viewrecords : true,
		rowNum:5,
		showRowList:false,
		pager : pager_selector,
		altRows: true,
		//toppager: true,
		
		multiselect: true,
		//multikey: "ctrlKey",
        multiboxonly: true,

		loadComplete : function() {
			var table = this;
			setTimeout(function(){
				/* styleCheckbox(table);
				
				updateActionIcons(table);
				updatePagerIcons(table);
				enableTooltips(table); */
			}, 0);
		},
		editurl: "${base}/sys/user/login",//nothing is saved
		caption: "被服务人员详细列表"
	});
	jQuery("#grid-table2").navGrid('#grid-pager2',{edit:false,add:false,del:false,search:false,refresh:false})
	.navButtonAdd('#grid-pager2',{  
	 caption:"",
	 buttonicon:"icon-plus-sign purple",
	 onClickButton:addFun,
	 position:"last"  ,
	 title:"新增"
	 })
	 .navButtonAdd('#grid-pager2',{  
		 caption:"",
		 buttonicon:" icon-trash red",
		 onClickButton:deleteFun,
		 position:"last"  ,
		 title:"删除"
		 }) ;
	/* $("#grid-table").jqGrid({
	 	url : "${base }/base/bjigouservice/queryPeopleManage",
	 	postData:{serviceId:"${vdata.bjigouser.code}",people:peoples},
	      ondblClickRow:function(rowid,iRow,iCol,e){
			    bootbox.dialog({
					url:"${base}/base/bjigouservice/queryPeopleManage?code="+rowid,
					title: "服务信息详情",
					iframeStyle:"height:450px;",
					style:'width:1000px;height:600px;',
					showFunctionBtn:false,
					});
		      },
	      
        colNames:[ '主键', '姓名','性别','联系电话','联系地址'],
        colModel:[
			{name:'code',index:'code',sortable:false, hidden:true},
			{name:'name',sortable:false, width:'15%',align:'center'},
            {name:'sex',index:'jigouName',sortable:false, width:'15%',align:'center'},
            {name:'phone',index:'jigouManager',sortable:false, width:'30%', align:"center"},
            {name:'address',index:'personAddress',sortable:false, width:'40%', align:"center"}
        ],
        sortable:true,
        rownumbers:true,//添加左侧行号
        altRows:true,//班玛线
        sortname:'createDate',
        sortorder:'desc',
        viewrecords: true,//是否在浏览导航栏显示记录总数
        rowNum:5,//每页显示记录数
        rowList:[5,5,5],//用于改变显示行数的下拉列表框的元素数组。
        multiselect: true,
        pager:$('#grid-pager'),
        caption: "被服务人员详细列表"
    });
	 */
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize();
			var data_grid=JSON.stringify($("#grid-table2").jqGrid('getGridParam',"data"));
			$.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data+"&people="+data_grid,
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
	$("#closeBtn",parent.document).bind("click",function(){
		$.ajax({
			type : "post",
			url : "${base}/base/bjigouservice/cleanPeople?t="+Math.random(),
			dataType : 'json',
			async : false,
			success : function(data) {
				
			}
		});
	});
	 $("[name=codeServiceType]").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SERVICE_TYPE',
			name:"dicValue",
			pIdKey:"parentCode"
		});
// 	 $("#jigouName").ztreeGrid({
// 		 url:'${base}/base/bjigou/queryAllRoleTreeForSelect?t=' + Math.random(),
// 		 name:"jigouName"
// 	});
if("${vdata.bjigouser.jiGouCode}"!=''){
	 $('#detail').html("(<b>所属辖区：</b>${vdata.bjigouser.jiGou.gridTotalName}&nbsp;&nbsp;<b>机构负责人：</b>${vdata.bjigouser.jiGou.jigouManager}<b>&nbsp;&nbsp;负责人联系电话：</b>${vdata.bjigouser.jiGou.managerPhone})")
}
changeIframeHeight();
	});
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
//在提交或者修改单条信息成功后的调用方法，用于子页面调用
/* function successFun(){
	bootbox.hideAll();
	bootbox.slideAlert('body');
	jQuery("#grid-table").trigger("reloadGrid"); 
	changeIframeHeight();
} */
function successFun(a){
	var flag=0;
	var data=$("#grid-table2").jqGrid('getGridParam',"data");
	for(var i=0;i<data.length;i++){
		if(data[i].code==a[0].code){
			data[i]=a[0];
			flag=1;
			break;
		}
	}
	if(flag==0){
		data=data.concat(a);
	}
	bootbox.hideAll();
	bootbox.slideAlert('body');
	$("#grid-table2").jqGrid('setGridParam',{data:data}).trigger("reloadGrid"); 
	changeIframeHeight();
}
function openPerssonInfo(){
		var dialog=bootbox.dialog({
			  backdrop: true,
			  url:"${base}/base/bjigou/queryjigouSelect",
			  title: "队伍信息",
			  iframeStyle:"height:240px;",
			  style:'width:700px;height:400px;',
			  buttons: {
				    close: {
				      id:"closeBtn",
				      label: "取消",
				      className: "btn-cancel",
				      callback: function() {
				      }
				    }
				  }
			});	
}
function getValue(jigouCode,jigouName,jigouManager,managerPhone,gridCode,gridName){
	if(jigouName!=""){
		$("#jigouName").val(jigouName);
	}
	$("#jiGouCode").val(jigouCode);
	$('#detail').html("(<b>所属辖区：</b>"+gridName+"&nbsp;&nbsp;<b>机构负责人：</b>"+jigouManager+"<b>&nbsp;&nbsp;负责人联系电话：</b>"+managerPhone+")")
	bootbox.hideAll();
}
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.bjigouser.code }" />
			<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="jigouName"><span class="red">*</span>机构队伍(<font size="1">双击选择</font>)</label>
					<div class="col-xs-4">
					<div class="clearfix">
						<input type="hidden" id="jiGouCode" name="jiGouCode" value="${vdata.bjigouser.jiGouCode}"/>
					    <input type="text" id="jigouName"readonly="readonly" title="请双击输入框选择机构" value="${vdata.bjigouser.jiGou.jigouName }" placeholder="请双击输入框选择机构" ondblclick="openPerssonInfo()" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					</div>
				 </div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ></label>
					<div class="col-xs-10" id="detail">
						
					</div>
				 </div>
				 <div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>服务事件标题</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="serviceEvent" name="serviceEvent" value="${vdata.bjigouser.serviceEvent }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>服务对象</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="serviceDuiXiang" name="serviceDuiXiang" value="${vdata.bjigouser.serviceDuiXiang }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					
					<label  class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>服务人数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="serviceNum" name="serviceNum" value="${vdata.bjigouser.serviceNum }" class="col-xs-12 col-sm-12 tooltip-error digits required" />
					</div>
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="codeServiceType"><span class="red">*</span>服务对象类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="codeServiceType" name="codeServiceType" value="${vdata.bjigouser.codeServiceType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label  class="col-xs-2 control-label no-padding-right text-right" for="serviceTime"><span class="red">*</span>服务时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="serviceTime" value="${vdata.bjigouser.serviceTime }"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>						
				</div>
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="personAddress">服务地点</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="sevieceAddress" name="sevieceAddress" value="${vdata.bjigouser.sevieceAddress }" class="col-xs-12 col-sm-12 " />
					</div>
				</div>
				<div class="form-group">	
					<label  class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
					<div class="col-xs-10 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.bjigouser.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					   </div>
				</div>				
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" for="responsibleName">具体服务信息</label>
					<div class="col-xs-10">
						<textarea rows="" cols=""id="serviceDescription" name="serviceDescription"class="col-xs-12 col-sm-12 " >${vdata.bjigouser.serviceDescription }</textarea>
					</div>
				</div>
				<!-- <div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >被服务人员信息</label>
					<div class="col-xs-10">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div>
				</div> -->
		
				<div class="form-group">
					<label  class="col-xs-2 control-label no-padding-right text-right" >被服务人员信息</label>
					<div class="col-xs-10">
						<table id="grid-table2"></table>
						<div id="grid-pager2"></div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="control-group">
                	 <label class="control-label">
                	 </label>
            	</div> 
		</form>
	</div>
</div>
<!-- 列表右下角按钮组代码 -->
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridImport.js"></script>
</body>
</html>
