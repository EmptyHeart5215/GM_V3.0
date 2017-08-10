<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
var personCode="${vdata.person.code}";
//控制Tab标签是否可用，如果没有保存基本信息则其他的tab是不可用 的
function controlTab(){
	$('#myTab3 a:first').tab('show');//初始化显示哪个tab 
	if(personCode==''){
		$('[id^="toggleA_"]').click(function(){
			if(personCode==''){
				bootbox.alert('请先保存基本信息！');
			}
		});
	}else{
        $('#myTab3 a').click(function (e) { 
          e.preventDefault();//阻止a链接的跳转行为 
          $(this).tab('show');//显示当前选中的链接及关联的content 
          setSrollHeight();
        }) 
	}
}
//
function setSrollHeight(){
	var iframe=parent.document.getElementById("dialog_iframe");
	var subWeb = document.frames ? iframe.document : iframe.contentDocument;  
 	iframe.style.height = subWeb.body.scrollHeight+"px";
}
//提交方法
function submitForm(type,url){
	 $("#"+type+"Form").validate({
		submitHandler: function (form) {
		 	var data = $("#"+type+"Form").serialize()+"&personCode="+personCode;
			$.ajax({
				type : "post",
				url : "${base}/"+url+"?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	bootbox.slideAlert('body',true,"操作成功！");
		            	$("#"+type+"Code").val(data.info.code);
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			});
        }
	}); 
	$("#"+type+"CommitBtn").bind("click",function(){
		$('.modal-body',parent.document)[0].scrollTop =0;
		$("#"+type+"Form").submit();
	});
}
//删除方法
function deleteForm(type,url){
	$("#"+type+"CloseBtn").bind('click',function(){
		bootbox.confirm('确定删除吗？',function(result){
			if(result){
				$.ajax({
					type : "post",
					url : "${base}/"+url+"?code="+$("#"+type+"Code").val()+"&t="+Math.random(),
					dataType : 'json',
					async : false,
					success : function(data) {
			            if(data.status){
			            	bootbox.slideAlert('body',true,"操作成功！");
			            	$("#"+type+"Form").find('input').val('');
			        		$("#"+type+"Form").find('select').val('');
			        		$("#"+type+"Form").find('textarea').val('');
			            }else{ 
			            	bootbox.slideAlert('body',false,data.info);
			             } 
					}
				});
			}
		});
	});
}
//初始化select
function defaultSelect(){
	$("select").each(function(){
		if($(this).attr('value')=='true'){
			$(this).val('1');
		}else if($(this).attr('value')=='false'){
			$(this).val('0');
		}
	});
}
$(function(){
	 /* var dropzone1=new Dropzone("#dropzoneDiv1",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic1').val().split(";").length-1,
		 	uploadBtnId:'uploadBtn1',
         imgName:'showImg1',
	});
	 getOldPics(dropzone1,"url_pic1","showImg1_old","picDisplay_old1"); */
	 
	controlTab();
	 $('.icon-remove',parent.document).on('click', function () {
	      parent.refreshFunction('person');
	      });
	$("#jiBenForm").validate({
		submitHandler: function (form) {
			/* $('#url_pic1').val('');
		 	//获取上传的图片的值
		 	var ids1='';
		 	$('[name^=showImg1]').each(function(i){
		 		if(this.id&&$.trim(this.id)!=''){
		 			ids1+=this.id+";";
		 		}
		 	});
		 	$('#url_pic1').val(ids1); */
		 	var data = $("#jiBenForm").serialize()+"&houseCode=${vdata.person.houseCode}&code="+personCode;
		 	parent.document.documentElement.scrollTop = parent.document.body.scrollTop =0;
			 $.ajax({
				type : "post",
				url : "${base}/${vdata.url}?t="+Math.random(),
				data : data,
				dataType : 'json',
				async : false,
				success : function(data) {
		            if(data.status){
		            	bootbox.slideAlert('body',true,"操作成功！");
		            	personCode=data.info.code;
		            	controlTab();
		            }else{ 
		            	bootbox.slideAlert('body',false,data.info);
		             } 
				}
			});
        }
	});
	$("#jiBenCommitBtn").bind("click",function(){
		$("#jiBenForm").submit();
	});
	
	
	
	
	
	$("input[name^='ts_'][type='checkbox']").on("click",function(){
		
		if($(this).prop("checked")==true){
			$("#"+$(this).attr("name").substr(3)+"Div").css("display","block");
		}else{
			$("#"+$(this).attr("name").substr(3)+"Div").css("display","none");
		}
		setSrollHeight();
	});
	$("input[name^='bf_'][type='checkbox']").on("click",function(){
		if($(this).prop("checked")==true){
			$("#"+$(this).attr("name").substr(3)+"Div").css("display","block");
		}else{
			$("#"+$(this).attr("name").substr(3)+"Div").css("display","none");
		}
		setSrollHeight();
	});
	$("input[name^='qsn_'][type='checkbox']").on("click",function(){
		if($(this).prop("checked")==true){
			$("#"+$(this).attr("name").substr(4)+"Div").css("display","block");
		}else{
			$("#"+$(this).attr("name").substr(4)+"Div").css("display","none");
		}
	});
	//民族
	$("[name='codeNation']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_NATION',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	//籍贯
	$("[name='nativePlaceCode']").ztreeGrid({
		url:'${base}/sys/seatgird/queryRegionTree',
		name:"NAME",
		pIdKey:"PARENTCODE",
		reset:true,
		idKey:"CODE",
		resetId:'redo'
		});
	//婚姻状况
	$("[name='codeMarriage']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_MARRIAGE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//政治面貌
	$("[name='codePolitical']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_POLITICAL',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//学历
	$("[name='codeEducation']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EDUCATION',
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
	//职业类别
	$("[name='codeJobType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JOB_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//户籍地
	$("[name='residenceAddressCode']").ztreeGrid({
		url:'${base}/sys/seatgird/queryRegionTree',
		name:"NAME",
		pIdKey:"PARENTCODE",
		reset:true,
		idKey:"CODE",
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
	//人户状态
	$("[name='codeHouseholdStatus']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HOUSEHOLD_STATUS',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//管理类型
	$("[name='codeManageType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_MANAGE_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//是否人户一致
	defaultSelect('isRenHuYiZhi');
	//是否犯罪
	defaultSelect('isFanZui');
});
</script>
</head>
<body id="a">
<div class="row">
		<div class="col-xs-12" id="body">
		<div class="tabbable tabs-left" >
			<ul class="nav nav-tabs" id="myTab3">
				<li class="active">
					<a  href="#jiBenDiv">
						<i class="pink icon-file-alt bigger-110"></i>
						基本信息
					</a>
				</li>
				<li>
					<a  id="toggleA_7"  href="#huJiDiv">
						<i class="blue icon-user bigger-110"></i>
						户籍人口
					</a>
				</li>
				<li>
					<a  id="toggleA_8"  href="#liuDongDiv">
					<i class="blue icon-user bigger-110"></i>
						流动人口
					</a>
				</li>
				<li>
					<a  id="toggleA_1"  href="#ziYuanDiv">
						<i class="blue icon-user bigger-110"></i>
						资源人群
					</a>
				</li>

				<li>
					<a  id="toggleA_2" href="#teShuDiv">
						<i class="blue icon-user bigger-110"></i>
						特殊人群
					</a>
				</li>
				<li>
					<a  id="toggleA_3" href="#bangFuDiv">
						<i class="blue icon-user bigger-110"></i>
						帮扶人群
					</a>
				</li>
				<li>
					<a id="toggleA_4"  href="#qingShaoNianDiv">
						<i class="blue icon-user bigger-110"></i>
						重点青少年
					</a>
				</li>
				<li>
					<a  id="toggleA_5" href="#yongJunDiv">
						<i class="blue icon-user bigger-110"></i>
						拥军抚优
					</a>
				</li>
				<li>
					<a  id="toggleA_6" href="#zhiYuanDiv">
						<i class="blue icon-user bigger-110"></i>
						志愿者
					</a>
				</li>
				<li>
					<a  id="toggleA_9" href="#laoDongDiv">
						<i class="blue icon-user bigger-110"></i>
						劳动保障
					</a>
				</li>
			</ul>

			<div class="tab-content" style="min-height:300px;">
			<!-- 基本信息 --> 
				<div id="jiBenDiv" class="tab-pane in active">
					<form class="form-horizontal" role="form" id="jiBenForm">
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>姓名</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="name" name="name" value="${vdata.person.name }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >曾用名</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="otherName" name="otherName" value="${vdata.person.otherName }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>联系电话</label>
			
					<div class="col-xs-10">
						<input type="text" max-length="50"id="phone" name="phone" value="${vdata.person.phone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>性别</label>
			
					<div class="col-xs-4 " >
						<select value="${vdata.person.sex }" name="sex" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
							<option value="">请选择</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>身份证号</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="cid" name="cid" value="${vdata.person.cid }" class="col-xs-12 col-sm-12 tooltip-error personcid" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>民族</label>
					<div class="col-xs-4">
							<input type="text" max-length="50"id="codeNation" name="codeNation" value="${vdata.person.codeNation }" class="col-xs-12 col-sm-12  tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >学历</label>
					<div class="col-xs-4">
						<input type="text"  name="codeEducation" value="${vdata.person.codeEducation }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>籍贯</label>
			
					<div class="col-xs-4">
						<input type="text" id="nativePlaceCode" name="nativePlaceCode" value="${vdata.person.nativePlaceCode }" class="col-xs-12 col-sm-12  tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>婚姻状况</label>
			
					<div class="col-xs-4">
						<input type="text"  name="codeMarriage" value="${vdata.person.codeMarriage }" class="col-xs-12 col-sm-12  tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>宗教信仰</label>
					<div class="col-xs-4">
						<input type="text"  name="codeReligious" value="${vdata.person.codeReligious }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>政治面貌</label>
					<div class="col-xs-4">
						<input type="text"  name="codePolitical" value="${vdata.person.codePolitical }" class="col-xs-12 col-sm-12  tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>职业类别</label>
					<div class="col-xs-4">
						<input type="text"  name="codeJobType" value="${vdata.person.codeJobType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>职业</label>
					<div class="col-xs-4">
						<input type="text"  name="job" value="${vdata.person.job }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >服务处所</label>
			
					<div class="col-xs-10">
						<input type="text" maxLength="100"  name="serverAddress" value="${vdata.person.serverAddress }" class="col-xs-12 col-sm-12 tooltip-error " />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>户籍地</label>
			
					<div class="col-xs-4">
						<input type="text"  name="residenceAddressCode" value="${vdata.person.residenceAddressCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>户籍地详址</label>
			
					<div class="col-xs-4">
						<input type="text"  name="residenceDetail" value="${vdata.person.residenceDetail }" class="col-xs-12 col-sm-12  tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>现住地</label>
					<div class="col-xs-4">
						<input type="text"  name="nowAddressCode" value="${vdata.person.nowAddressCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span> 现住地详址</label>
					<div class="col-xs-4">
						<input type="text"  name="nowAddressDetail" value="${vdata.person.nowAddressDetail }" class="col-xs-12 col-sm-12  tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>人户状态</label>
					<div class="col-xs-4">
						<input type="text" id="codeHouseholdStatus" name="codeHouseholdStatus" value="${vdata.person.codeHouseholdStatus }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>管理类型</label>
			
					<div class="col-xs-4">
						<input type="text"  name="codeManageType" value="${vdata.person.codeManageType }" class="col-xs-12 col-sm-12  tooltip-error required" />
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
				<%-- <div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">上传照片 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv1' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn1" type="button">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic1" name="img" value="${vdata.person.img }" />
						</div>
					</div>
				</div>
				<c:if test="${vdata.person.img != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存照片 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old1" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if> --%>
				<div class="space-4"></div>
				<div class="control-group">
	                <label class="control-label">
	                </label>
	            </div>
	           <div style="position: absolute;bottom: 20px;right: 10px;">
		           <button data-bb-handler="success" id="jiBenCommitBtn" type="button" class="btn btn-success">提交</button>
		           <button data-bb-handler="close" id="jiBenCloseBtn" type="button" class="btn btn-cancel">取消</button>
	           </div>
			</form>
				</div>
				<!-- 户籍人口 -->
				<div id="huJiDiv" class="tab-pane">
					<jsp:include page="../../include/person/hujiform.jsp"></jsp:include>
				</div>
					<!-- 流动人口 -->
				<div id="liuDongDiv" class="tab-pane">
					<jsp:include page="../../include/person/liudongform.jsp"></jsp:include>
				</div>
				<!-- 重点青少年 -->
				<div id="qingShaoNianDiv" class="tab-pane">
						<jsp:include page="../../include/person/qingshaonianform.jsp"></jsp:include>
				</div>
				<!-- 资源人群 -->
				<div id="ziYuanDiv" class="tab-pane">
					<jsp:include page="../../include/person/ziyuanform.jsp"></jsp:include>
				</div>

				<div id="teShuDiv" class="tab-pane">
					<div class="form-horizontal">
						<div class="checkbox col-xs-3">
							<label>
								<input name="ts_xingShi" class="ace" type="checkbox" >
								<span class="lbl"> 刑释解教人员</span>
							</label>
						</div>
						  
	   
						<div class="checkbox col-xs-3">
							<label>
								<input name="ts_jiaoZheng" class="ace" type="checkbox" >
								<span class="lbl"> 社区矫正人员</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="ts_xiDu" class="ace" type="checkbox" >
								<span class="lbl"> 吸毒人员</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="ts_jingShen" class="ace" type="checkbox" >
								<span class="lbl">精神病人员</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="ts_aiZi" class="ace" type="checkbox" >
								<span class="lbl">艾滋病人员</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="ts_xieJiao" class="ace" type="checkbox" >
								<span class="lbl">邪教人员</span>
							</label>
						</div>
					</div>
					
					
					<div id="xingShiDiv" style="display:none;">
						<div class="row">
							<div class="col-xs-12">
								<div class="widget-box transparent">
										<div class="widget-header  widget-header-flat" style="min-height:30px;">
											<h4 class="green">刑释解教人员 </h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<jsp:include page="../../include/teshuperson/xingshiform.jsp"></jsp:include>
											</div>
										</div>
									</div>
									<div class="hr hr-24"></div>
							</div>
						</div>
						
					</div>
					<div id="jiaoZhengDiv" style="display:none;">
						<div class="row">
							<div class="col-xs-12">
								<div class="widget-box transparent">
										<div class="widget-header  widget-header-flat" style="min-height:30px;">
											<h4 class="green">社区矫正人员 </h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<jsp:include page="../../include/teshuperson/jiaozhengform.jsp"></jsp:include>
											</div>
										</div>
								</div>
										<div class="hr hr-24"></div>
							</div>
						</div>
					</div>
					<div id="xiDuDiv" style="display:none;">
						<div class="row">
							<div class="col-xs-12">
							<div class="widget-box transparent">
										<div class="widget-header  widget-header-flat" style="min-height:30px;">
											<h4 class="green">吸毒人员 </h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<jsp:include page="../../include/teshuperson/xiduform.jsp"></jsp:include>
											</div>
										</div>
								</div>
								
										<div class="hr hr-24"></div>
							</div>
						</div>
					</div>
					<div id="jingShenDiv" style="display:none;">
						<div class="row">
							<div class="col-xs-12">
								<div class="widget-box transparent">
										<div class="widget-header  widget-header-flat" style="min-height:30px;">
											<h4 class="green">精神病人员 </h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<jsp:include page="../../include/teshuperson/jingshenform.jsp"></jsp:include>
											</div>
										</div>
								</div>
								
										<div class="hr hr-24"></div>
							</div>
						</div>
					</div>
					<div id="aiZiDiv" style="display:none;">
						<div class="row">
							<div class="col-xs-12">
							<div class="widget-box transparent">
										<div class="widget-header  widget-header-flat" style="min-height:30px;">
											<h4 class="green">艾滋病人员 </h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<jsp:include page="../../include/teshuperson/aiziform.jsp"></jsp:include>
											</div>
										</div>
								</div>
								
										<div class="hr hr-24"></div>
							</div>
						</div>
					</div>
					<div id="xieJiaoDiv" style="display:none;">
						<div class="row">
							<div class="col-xs-12">
							<div class="widget-box transparent">
										<div class="widget-header  widget-header-flat" style="min-height:30px;">
											<h4 class="green">邪教人员 </h4>
										</div>
										<div class="widget-body">
											<div class="widget-main">
												<jsp:include page="../../include/teshuperson/xiejiaoform.jsp"></jsp:include>
											</div>
										</div>
								</div>
								
										<div class="hr hr-24"></div>
							</div>
						</div>
					</div>
				</div>
				<div id="bangFuDiv" class="tab-pane">
					<div class="form-horizontal">
						<div class="checkbox col-xs-3">
							<label>
								<input name="bf_liuShou" class="ace" type="checkbox" >
								<span class="lbl">留守人员</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="bf_canJi" class="ace" type="checkbox" >
								<span class="lbl">残疾人</span>
							</label>
						</div>
						  
	   
						<div class="checkbox col-xs-3">
							<label>
								<input name="bf_diBao" class="ace" type="checkbox" >
								<span class="lbl">低保户</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="bf_wuBao" class="ace" type="checkbox" >
								<span class="lbl">五保户</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="bf_jiuZhu" class="ace" type="checkbox" >
								<span class="lbl">社区救助人员</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="bf_kongChao" class="ace" type="checkbox" >
								<span class="lbl">空巢老人</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="bf_kunNanZhiGong" class="ace" type="checkbox" >
								<span class="lbl">困难职工</span>
							</label>
						</div>
						<div class="checkbox col-xs-3">
							<label>
								<input name="bf_teKun" class="ace" type="checkbox" >
								<span class="lbl">特困学生</span>
							</label>
						</div>
						
					</div>
						
						<div id="liuShouDiv" style="display:none;">
							<div class="row">
								<div class="col-xs-12">
									<div class="widget-box transparent">
											<div class="widget-header  widget-header-flat" style="min-height:30px;">
												<h4 class="green">留守人员</h4>
											</div>
											<div class="widget-body">
												<div class="widget-main">
													<jsp:include page="../../include/person/liushouform.jsp"></jsp:include>
												</div>
											</div>
										</div>
										<div class="hr hr-24"></div>
								</div>
							</div>
						</div>
						<div id="canJiDiv" style="display:none;">
							<div class="row">
								<div class="col-xs-12">
									<div class="widget-box transparent">
											<div class="widget-header  widget-header-flat" style="min-height:30px;">
												<h4 class="green">残疾人</h4>
											</div>
											<div class="widget-body">
												<div class="widget-main">
													<jsp:include page="../../include/bangfuperson/canjiform.jsp"></jsp:include>
												</div>
											</div>
										</div>
										<div class="hr hr-24"></div>
								</div>
							</div>
						</div>
						<div id="diBaoDiv" style="display:none;">
							<div class="row">
								<div class="col-xs-12">
									<div class="widget-box transparent">
											<div class="widget-header  widget-header-flat" style="min-height:30px;">
												<h4 class="green">低保户</h4>
											</div>
											<div class="widget-body">
												<div class="widget-main">
													<jsp:include page="../../include/bangfuperson/dibaoform.jsp"></jsp:include>
												</div>
											</div>
										</div>
										<div class="hr hr-24"></div>
								</div>
							</div>
						</div>
						<div id="jiuZhuDiv" style="display:none;">
							<div class="row">
								<div class="col-xs-12">
									<div class="widget-box transparent">
											<div class="widget-header  widget-header-flat" style="min-height:30px;">
												<h4 class="green">社区救助人员</h4>
											</div>
											<div class="widget-body">
												<div class="widget-main">
													<jsp:include page="../../include/bangfuperson/jiuzhuform.jsp"></jsp:include>
												</div>
											</div>
										</div>
										<div class="hr hr-24"></div>
								</div>
							</div>
						</div>
						<div id="kongChaoDiv" style="display:none;">
							<div class="row">
								<div class="col-xs-12">
									<div class="widget-box transparent">
											<div class="widget-header  widget-header-flat" style="min-height:30px;">
												<h4 class="green">空巢老人</h4>
											</div>
											<div class="widget-body">
												<div class="widget-main">
													<jsp:include page="../../include/bangfuperson/kongchaoform.jsp"></jsp:include>
												</div>
											</div>
										</div>
										<div class="hr hr-24"></div>
								</div>
							</div>
						</div>
						<div id="kunNanZhiGongDiv" style="display:none;">
							<div class="row">
								<div class="col-xs-12">
									<div class="widget-box transparent">
											<div class="widget-header  widget-header-flat" style="min-height:30px;">
												<h4 class="green">困难职工</h4>
											</div>
											<div class="widget-body">
												<div class="widget-main">
													<jsp:include page="../../include/bangfuperson/kungnanzhigongform.jsp"></jsp:include>
												</div>
											</div>
										</div>
										<div class="hr hr-24"></div>
								</div>
							</div>
						</div>
						<div id="teKunDiv" style="display:none;">
							<div class="row">
								<div class="col-xs-12">
									<div class="widget-box transparent">
											<div class="widget-header  widget-header-flat" style="min-height:30px;">
												<h4 class="green">特困学生</h4>
											</div>
											<div class="widget-body">
												<div class="widget-main">
													<jsp:include page="../../include/bangfuperson/tekunform.jsp"></jsp:include>
												</div>
											</div>
										</div>
										<div class="hr hr-24"></div>
								</div>
							</div>
						</div>
						<div id="wuBaoDiv" style="display:none;">
							<div class="row">
								<div class="col-xs-12">
									<div class="widget-box transparent">
											<div class="widget-header  widget-header-flat" style="min-height:30px;">
												<h4 class="green">五保户 </h4>
											</div>
											<div class="widget-body">
												<div class="widget-main">
													<jsp:include page="../../include/bangfuperson/wubaoform.jsp"></jsp:include>
												</div>
											</div>
										</div>
										<div class="hr hr-24"></div>
								</div>
							</div>
						</div>
				</div>
				
				<div id="yongJunDiv" class="tab-pane">
					<jsp:include page="../../include/person/yongjunform.jsp"></jsp:include>
				</div>
				<div id="zhiYuanDiv" class="tab-pane">
					<jsp:include page="../../include/person/zhiyuanform.jsp"></jsp:include>
				</div><!--zhiYuanDiv-->
				<div id="laoDongDiv" class="tab-pane">
					<jsp:include page="../../include/person/laodongform.jsp"></jsp:include>
				</div>
			</div>
		</div>
			
		</div><!-- body -->
	</div><!-- row -->
	<script>
	$(function(){
		defaultSelect();
		$("[name='sex']").val($("[name='sex']").attr('value'));
	});
	</script>
</body>
</html>


