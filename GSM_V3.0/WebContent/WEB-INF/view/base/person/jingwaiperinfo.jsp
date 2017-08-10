<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	//国籍
	$("[name='codeNationality']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_NATIONALITY',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//宗教信仰
	$("[name='codeReligious']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_RELIGIOUS',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//证件类型
	$("[name='codeIdType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ID_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//来华目的
	$("[name='codeComeChinaReason']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_COME_CHINA_REASON',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//职业类型
	$("[name='codeJobType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JOB_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//现住地
	$("[name='nowAddressCode']").ztreeGrid({
		url:'${base}/sys/seatgird/queryRegionTree',
		name:"NAME",
		pIdKey:"PARENTCODE",
		reset:true,
		idKey:"CODE",
		resetId:'redo'
	});
	$("[name='sex']").val($("[name='sex']").attr('value'));
	if($("[name='isGuanZhu']").attr('value')=='true'){
		$("[name='isGuanZhu']").val('1');
	}else if($("[name='isGuanZhu']").attr('value')=='false'){
		$("[name='isGuanZhu']").val('0');
	}
	
	
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize();
			var iframe=parent.document.getElementById("dialog_iframe");
			var subWeb = document.frames ? iframe.document : iframe.contentDocument;   
		 	iframe.style.height = subWeb.body.scrollHeight+"px";
			data=data+"&houseCode=${vdata.person.houseCode}&code=${vdata.person.code}";
			 $.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	parent.successFun("person");
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
	
});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>外文姓</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="lastName" name="lastName" value="${vdata.person.lastName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>外文名</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="firstName" name="firstName" value="${vdata.person.firstName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >中文名</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="name" name="name" value="${vdata.person.name }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>性别</label>
					<div class="col-xs-4 " >
						<select value="${vdata.person.sex }" name="sex" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
							<option value="">请选择</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >出生日期</label>
					<div class="col-xs-4">
						<div class="input-group">
							<input class="col-xs-12 col-sm-12 form-control date-picker"name="birthday" value="${vdata.person.birthday }" type="text"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
							</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>国籍</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeNationality" name="codeNationality" value="${vdata.person.codeNationality }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >宗教信仰</label>
					<div class="col-xs-4">
						<input type="text"  name="codeReligious" value="${vdata.person.codeReligious }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>联系电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="phone" name="phone" value="${vdata.person.phone }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>证件类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeIdType" name="codeIdType" value="${vdata.person.codeIdType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>证件号</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="cid" name="cid" value="${vdata.person.cid }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>证件有效期</label>
					<div class="col-xs-4">
						<div class="input-group">
							<input class="col-xs-12 col-sm-12 form-control date-picker required"name="idEndDate" value="${vdata.person.idEndDate }" type="text"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>来华目的</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="cid" name="codeComeChinaReason" value="${vdata.person.codeComeChinaReason }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >职业类别</label>
					<div class="col-xs-4">
						<input type="text"  name="codeJobType" value="${vdata.person.codeJobType }" class="col-xs-12 col-sm-12 tooltip-error " />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >职业</label>
					<div class="col-xs-4">
						<input type="text"  name="job" value="${vdata.person.job }" class="col-xs-12 col-sm-12 tooltip-error " />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >服务处所</label>
					<div class="col-xs-4">
						<input type="text" maxLength="100"  name="serverAddress" value="${vdata.person.serverAddress }" class="col-xs-12 col-sm-12 tooltip-error " />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>现住地</label>
					<div class="col-xs-4">
						<input type="text"  name="nowAddressCode" value="${vdata.person.nowAddressCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span> 现住地门（楼）详址</label>
					<div class="col-xs-4">
						<input type="text"  name="nowAddressDetail" value="${vdata.person.nowAddressDetail }" class="col-xs-12 col-sm-12  tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>抵达日期</label>
					<div class="col-xs-4">
						<div class="input-group">
							<input class="col-xs-12 col-sm-12 form-control date-picker required"name="comeDate" value="${vdata.person.comeDate }" type="text"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>预计离开日期</label>
					<div class="col-xs-4">
						<div class="input-group">
							<input class="col-xs-12 col-sm-12 form-control date-picker required"name="goDate" value="${vdata.person.goDate }" type="text"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>是否重点关注人员</label>
					<div class="col-xs-4 " >
						<select value="${vdata.person.isGuanZhu }" name="isGuanZhu"class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
							<option value="1" >是</option>
							<option value="0">否</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >备注 </label>
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="remark" name="remark" class="col-xs-12 col-sm-12">${vdata.person.remark }</textarea>
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


