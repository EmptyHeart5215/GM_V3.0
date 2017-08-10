<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript" src="${base }/resource/js/jqprint/jquery.jqprint-0.3.js"></script>
<script type="text/javascript">
$(function(){
	$("#form").validate({
		submitHandler: function (form) {
			var codePartyType = addPartyType();			
			$("#codePartyType").val(filterNullValue(codePartyType));
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
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random()	
	});
	/* $("[name=codeEducation]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EDUCATION',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	$("[name=codePolitical]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_POLITICAL',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	$("[name=codeNation]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_NATION',
		name:"dicValue",
		pIdKey:"parentCode",
	}); */
// 	$("[name=codePartyType]").ztreeGrid({
// 		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_PARTY_TYPE',
// 		name:"dicValue",
// 		pIdKey:"parentCode"
// 	});
	if('${vdata.allparty.sex }' == '男'){
		 $("#sex option[value='男']").attr("selected", "selected"); 
	 }else if('${vdata.allparty.sex }' == '女'){
		 $("#sex option[value='女']").attr("selected", "selected"); 
	 }else if('${vdata.allparty.sex }' == 0){
		 $("#sex option[value='0']").attr("selected", "selected"); 
	 }
	
	/* if('${vdata.allparty.codePartyType}' == 'zhiguanparty'){
		 $("#codePartyType option[value='zhiguanparty']").attr("selected", "selected"); 
	 }else if('${vdata.allparty.codePartyType}' == 'zaizhiparty'){
		 $("#codePartyType option[value='zaizhiparty']").attr("selected", "selected"); 
	 }else if('${vdata.allparty.codePartyType}' == 'tuixiuparty'){
		 $("#codePartyType option[value='tuixiuparty']").attr("selected", "selected"); 
	 }else if('${vdata.allparty.codePartyType}' == 'kunnanparty'){
		 $("#codePartyType option[value='kunnanparty']").attr("selected", "selected"); 
	 }else if('${vdata.allparty.codePartyType}' == 'zyzparty'){
		 $("#codePartyType option[value='zyzparty']").attr("selected", "selected"); 
	 }else if('${vdata.allparty.codePartyType }' == 0){
		 $("#codePartyType option[value='0']").attr("selected", "selected"); 
	 } */
	 
	 if('${vdata.allparty.codePartyType}'!=""){
		    
			var zaizhiparty = $("#zaizhiparty1").val();
		    var tuixiuparty = $("#tuixiuparty1").val();
			var zhiguanparty = $("#zhiguanparty1").val();
			var kunnanparty = $("#kunnanparty1").val();
			var zyzparty = $("#zyzparty1").val();
		 var str ='${vdata.allparty.codePartyType}';
		 var strs = str.split(";");
		 for(var i=0;i<strs.length;i++){
 			if(strs[i] == 'zaizhiparty'){
 				$("#zaizhiparty").attr("checked",true);
 				if(zaizhiparty == ""){
 					$("#zaizhiparty1").val("zaizhiparty");
 				}
 			}else if(strs[i] == 'tuixiuparty'){
 				$("#tuixiuparty").attr("checked",true);
 				if(tuixiuparty == ""){
 					$("#tuixiuparty1").val("tuixiuparty");
 				}
 			}else if(strs[i] == 'zhiguanparty'){
 				$("#zhiguanparty").attr("checked",true);
 				if(zhiguanparty == ""){
 					$("#zhiguanparty1").val("zhiguanparty");
 				}
 			}else if(strs[i] == 'kunnanparty'){
 				$("#kunnanparty").attr("checked",true);
 				if(kunnanparty == ""){
 					$("#kunnanparty1").val("kunnanparty");
 				}
     		}else if(strs[i] == 'zyzparty'){
     			$("#zyzparty").attr("checked",true);
     			if(zyzparty == ""){
     				$("#zyzparty1").val("zyzparty");
     			}
     		}
 			
 		} 
		 
	 }
});

/* 过滤党员类型中可能出现的null值 */
function filterNullValue(values){
	var strs = values.split(";");
	var vals = "";
	for(var i=0;i<strs.length;i++){
		if(strs[i] != "null"){
			vals+=strs[i]+";";
		}
	}
	return vals.substring(0, vals.length - 1);
}

function checkfun(val){
	
	if(val == "zaizhiparty"){
		
		var tuixiuparty = $("#tuixiuparty1").val();
		var zaizhiparty = $("#zaizhiparty1").val();
		if($("#zaizhiparty").attr("checked")){
			$("#zaizhiparty1").val(val)
		}else if(!$("#zaizhiparty").attr("checked")){
			$("#zaizhiparty1").val("");
		}
		if(tuixiuparty != ""){
			bootbox.alert('在职党员，退休党员不能同时存在');
			$("#zaizhiparty1").val("");
			$("[id='zaizhiparty']").removeAttr("checked");//取消全选  
		}
	}else if(val == "tuixiuparty"){
		var tuixiuparty = $("#tuixiuparty1").val();
		var zaizhiparty = $("#zaizhiparty1").val();
		if($("#tuixiuparty").attr("checked")){
			$("#tuixiuparty1").val(val);
		}else if(!$("#tuixiuparty").attr("checked")){
			$("#tuixiuparty1").val("");
		}
		if(zaizhiparty != ""){
			bootbox.alert('退休党员，在职党员不能同时存在');
			$("#tuixiuparty1").val("");
			$("[id='tuixiuparty']").removeAttr("checked");//取消全选  
		}
	}else if(val == "zhiguanparty"){
		if($("#zhiguanparty").attr("checked")){
			$("#zhiguanparty1").val(val)
		}else if(!$("#zhiguanparty").attr("checked")){
			$("#zhiguanparty1").val("");
		}
	}else if(val == "kunnanparty"){
		if($("#kunnanparty").attr("checked")){
			$("#kunnanparty1").val(val)
		}else if(!$("#kunnanparty").attr("checked")){
			$("#kunnanparty1").val("");
		}
	}else if(val == "zyzparty"){
		if($("#zyzparty").attr("checked")){
			$("#zyzparty1").val(val)
		}else if(!$("#zyzparty").attr("checked")){
			$("#zyzparty1").val("");
		}
	}
}

function addPartyType(){
	var tuixiuparty = $("#tuixiuparty1").val();
	var zaizhiparty = $("#zaizhiparty1").val();
	var zhiguanparty = $("#zhiguanparty1").val();
	var kunnanparty = $("#kunnanparty1").val();
	var zyzparty = $("#zyzparty1").val();
	var codePartyType = null;
	if(zaizhiparty != ""){
		codePartyType = zaizhiparty;
	}
	if(tuixiuparty != ""){
		codePartyType = codePartyType+";"+tuixiuparty
	}
	if(zhiguanparty != ""){
		codePartyType = codePartyType+";"+zhiguanparty
	}
	if(zyzparty != ""){
		codePartyType = codePartyType+";"+zyzparty
	}
    if(kunnanparty != ""){
    	codePartyType = codePartyType+";"+kunnanparty
	}
	return codePartyType;
}

function openPerssonInfo(){
	var gridCode = $("#gridCode").val();
	if(gridCode!= ""){
		var dialog=bootbox.dialog({
			  backdrop: true,
			  url:"${base}/base/person/partyByPersonManage?gridCode="+gridCode,
			  title: "人口信息",
			  iframeStyle:"height:240px;",
			  style:'width:690px;height:370px;',
			   buttons: {
				    /* success: {
				      id:"commitBtn",
				      label: "确认",
				      className: "btn-success",
				      callback: function(){
				    	  //return false 则dialog就不会关闭
				    	  return false;
				      }
				    },
				    close: {
				      id:"closeBtn",
				      label: "取消",
				      className: "btn-cancel",
				      callback: function() {
				      }
				    } */
				  } 
			});
		}else{
			bootbox.alert('请先选择网格！');
		}
	
}
function getValue(personCode,name,sex,cid,codeNation,codeEducation,codePolitical,position){
	if(personCode!=""){
		$("#personCode").val(personCode);
	}
	if(name!=""){
		$("#name").val(name);
	}
	if(sex!= ""){
		$("#sex").val(sex);
	}else{
		bootbox.alert('性别口人没有填，请自动填写！');
	}
	if(cid!= ""){
		$("#cid").val(cid);	
	}else{
		bootbox.alert('身份证号人口录入时没有填，请自动填写！');
	}
	if(codeNation!= ""){
		$("#codeNation").val(codeNation);	
	}else{
		bootbox.alert('民族人口录入时没有填，请自动填写！');
	}
	if(codeEducation!= ""){
		$("#codeEducation").val(codeEducation);	
	}else{
		bootbox.alert('教育程度人口录入时没有填，请自动填写！');
	}
	if(codePolitical!= ""){
		$("#codePolitical").val(codePolitical);	
	}else{
		bootbox.alert('政治面貌人口录入时没有填，请自动填写！');
	}
	if(position!= ""){
		$("#position").val(position);	
	}else{
		bootbox.alert('地图定位人口录入时没有填，请自动填写！');
	}
	bootbox.hideAll();
}
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.allparty.code}" />
			<input type="hidden" name="personCode" id="personCode" value="${vdata.allparty.personCode}" />
			<input type="hidden" name="position" id="position" class="noshow" value="${vdata.allparty.position}" />
			<input type="hidden" id="codeNation" name="codeNation" value="${vdata.allparty.codeNation}" />
			<input type="hidden" id="codeEducation" name="codeEducation" value="${vdata.allparty.codeEducation }"/>
			<input type="hidden" id="codePolitical" name="codePolitical" value="${vdata.allparty.codePolitical}"/>
			<input type="hidden" id="codePartyType" name="codePartyType" value="${vdata.allparty.codePartyType}"/>
			<input type="hidden" id="zaizhiparty1" />
			<input type="hidden" id="tuixiuparty1" />
			<input type="hidden" id="zhiguanparty1" />
			<input type="hidden" id="kunnanparty1" />
			<input type="hidden" id="zyzparty1" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-10">
						<input type="text"id="gridCode" name="gridCode" value="${vdata.allparty.gridCode }" class="col-xs-12 col-sm-12" />
					
<%-- 						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.allparty.gridCode}" class="col-xs-12 col-sm-12 tooltip-error required" /> --%>
					</div>
				
					
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="name"><span class="red">*</span>姓名</label>
					<div class="col-xs-4">
						<div class="clearfix">
						<input type="text" max-length="50" id="name" name="name" value="${vdata.allparty.name}" placeholder="请双击输入框" ondblclick="openPerssonInfo()" class="col-xs-12 col-sm-12 tooltip-error required" readOnly="true"/>
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="sex">性别 </label>		
					<div class="col-xs-4">
						 <select  id="sex" name = "sex"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="男">男</option>
                           <option  value="女">女</option>
                        </select>
					</div>
					
				
				</div>
				<div class="form-group">	
					<label class="col-xs-2 control-label no-padding-right text-right" for="cid"><span class="red">*</span>身份证 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<input type="text" max-length="50"id="cid" name="cid" value="${vdata.allparty.cid}" class="col-xs-12 col-sm-12 tooltip-error personcid" />
						</div>
					</div>	
				</div>
				<div class="form-group">
					<!-- <label class="col-xs-2 control-label no-padding-right text-right" for="codePartyType">党员类型 </label>
			
					<div class="col-xs-4">
						<select  id="codePartyType" name = "codePartyType"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option value="0">--请选择--</option>
                           <option value="zhiguanparty">直管党员</option>
                           <option value="zaizhiparty">在职党员</option>
                           <option value="tuixiuparty">退休党员</option>
                           <option value="kunnanparty">困难党员</option>
                           <option value="zyzparty">志愿者党员</option>
                        </select>
					</div> -->
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>入党时间</label>
					<div class="col-xs-10 input-group">
						<input class="form-control date-picker tooltip-error required" name="inPartyDate" value="${vdata.allparty.inPartyDate}"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="form-group">
					<h4 class="header smaller lighter blue">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;党员类型
						<small>注：请选择党员类型，根据实际情况勾选</small>
					</h4>
					<div class="checkbox">
						
						<label class="col-xs-2">
							<input type="checkbox" id="zaizhiparty" class="ace" value="zaizhiparty" onclick="checkfun(this.value)"/>
							<span class="lbl">在职党员</span>
					    </label>
					    <label class="col-xs-2">
							<input class="ace" id="tuixiuparty" type="checkbox" value="tuixiuparty" onclick="checkfun(this.value)"/>
							<span class="lbl">退休党员</span>
						</label>
						<label class="col-xs-2">
							<input type="checkbox" id="zhiguanparty" class="ace" value="zhiguanparty" onclick="checkfun(this.value)"/>
							<span class="lbl">直管党员</span>
						</label>
						 <label class="col-xs-2">
							<input class="ace" type="checkbox" id="kunnanparty" value="kunnanparty" onclick="checkfun(this.value)"/>
							<span class="lbl">困难党员</span>
						</label>
						 <label class="col-xs-2">
							<input class="ace" type="checkbox" id="zyzparty" value="zyzparty" onclick="checkfun(this.value)"/>
							<span class="lbl">志愿者党员</span>
						</label>
					</div>
					<h4 class="header smaller lighter blue"></h4>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="remark">备注 </label>
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="remark" name="remark" class="col-xs-12 col-sm-12">${vdata.allparty.remark }</textarea>
						</div>
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
</body>

</html>


