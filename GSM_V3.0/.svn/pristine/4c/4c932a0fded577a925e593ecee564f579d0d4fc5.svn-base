<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
var chanQuanDiv="";
$(function(){
	$("#form").validate({
		submitHandler: function (form) {
			var data = $("#form").serialize()+"&code=${vdata.house.code }";
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
		document.documentElement.scrollTop = document.body.scrollTop =0;
	});
	//房屋来源
	$("#codeHouseSource").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HOUSE_SOURCE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	//房屋性质
	$("#codeHouseNature").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HOUSE_NATURE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	//房屋用途
	$("#codeHouseUse").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HOUSE_USE',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	//使用人证件类型
	$("#codeHouseOwnerCard").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HOUSE_OWNER_CARD',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	//使用人证件类型
	$("#codeUseCard").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_USE_CARD',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	//使用人性质
	$("#codeUseProperty").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_USE_PROPERTY',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	
	//租赁公房
	$("[name='codeHouseHousing']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_HOUSE_HOUSING',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	$("[name^='is']").each(function(){
		 if($(this).attr("selectValue")==="true"||$(this).attr("selectValue")==="false"){
			$(this).val(Number(eval("("+$(this).attr("selectValue")+")")));
		} 
	});
	$("[name='haveRentContract']").each(function(){
		 if($(this).attr("selectValue")==="true"||$(this).attr("selectValue")==="false"){
			$(this).val(Number(eval("("+$(this).attr("selectValue")+")")));
		} 
	});
	
	$("[name$='ex']").each(function(){
		$(this).val($(this).attr("value"));
	});
});

function cloneChanQuanDiv(){
	var chanQuanDiv2=chanQuanDiv.clone();
	var id=(chanQuanDiv2.attr("id")+Math.random()).replace(".","_");
	var deleteBtn="<div class='col-xs-2'><button class='btn btn-xs btn-danger pull-right' onclick='deleteCQR(\""+id+"\")' type='button'> \
				<i class='icon-bolt bigger-110'></i> \
				删除此产权人  \
				</button></div>";
	chanQuanDiv2.find("[name='houseOwnerPhone']").parent().after(deleteBtn);
	chanQuanDiv2.attr("id",id);
	$("#dangShiRen_div").after(chanQuanDiv2).after("<hr/>");
	iFrameHeight(parent.document.getElementById("dialog_iframe"));
}
function deleteCQR(id){
	$("#"+id).prev().remove();
	$('#'+id).remove();
	iFrameHeight(parent.document.getElementById("dialog_iframe"));
}
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">房屋信息</h4>

					<div class="widget-toolbar" >
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属辖区</label>
			
					<div class="col-xs-4">
						<input type="text"value="${vdata.house.gridTotalName }" readonly="readonly" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属楼栋</label>
			
					<div class="col-xs-4">
						<input type="text" value="${vdata.house.buildName }" readonly="readonly"class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属单元</label>
			
					<div class="col-xs-4">
						<input type="hidden" max-length="50"id="unitCode" name="unitCode" value="${vdata.house.unitCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
						<input type="text" value="${vdata.house.unitName }" readonly="readonly"class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>房间号</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="houseNum" name="houseNum" value="${vdata.house.houseNum }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >本户建筑面积</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="houseArea" name="houseArea" value="${vdata.house.houseArea }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >本户户型</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeHouseLayout" name="codeHouseLayout" value="${vdata.house.codeHouseLayout }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >建成年份</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="buildYear" name="buildYear" value="${vdata.house.buildYear }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >房屋产权证号</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="housePropertyNum" name="housePropertyNum" value="${vdata.house.housePropertyNum }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >房屋产权证发证日期</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="housePropertyDate" name="housePropertyDate" value="${vdata.house.housePropertyDate }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >房屋土地证发证日期</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="houseLandDate" name="houseLandDate" value="${vdata.house.houseLandDate }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >房屋土地证号</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="houseLandNum" name="houseLandNum" value="${vdata.house.houseLandNum }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >房屋来源</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeHouseSource" name="codeHouseSource" value="${vdata.house.codeHouseSource }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>房屋性质</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeHouseNature" name="codeHouseNature" value="${vdata.house.codeHouseNature }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >房屋用途</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id=codeHouseUse name="codeHouseUse" value="${vdata.house.codeHouseUse }" class="col-xs-12 col-sm-12 tooltip-error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>当前层</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="currentLayer" name="currentLayer" value="${vdata.house.currentLayer }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所在层(跃层式示例：1-2)</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="ubietyLayer" name="ubietyLayer" value="${vdata.house.ubietyLayer }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>排序</label>
			
					<div class="col-xs-4">
						<input type="text" id="sort" name="sort" value="${vdata.house.sort }" class="col-xs-12 col-sm-12 tooltip-error required digits" />
					</div>
				</div>
			</div>
			</div>
			</div>
			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">产权信息</h4>
					<div class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main" >
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>产权人姓名</label>
				
						<div class="col-xs-4">
							<input type="text" max-length="50" name=houseOwnerName value="${vdata.house.houseOwnerName }" class="col-xs-12 col-sm-12 tooltip-error required  " />
						</div>
						<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>性别</label>
				
						<div class="col-xs-4">
							<select name="sex" selectValue="${vdata.house.sex }"class="col-xs-12 col-sm-12 tooltip-error required">
								<option value="">请选择</option>
								<option value="男" >男</option>
								<option value="女">女</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >证件类型</label>
				
						<div class="col-xs-4">
							<input type="text" max-length="50" id="codeHouseOwnerCard" name=codeHouseOwnerCard value="${vdata.house.codeHouseOwnerCard }" class="col-xs-12 col-sm-12" />
						</div>
						<label class="col-xs-2 control-label no-padding-right text-right" >证件号</label>
				
						<div class="col-xs-4">
							<input type="text" max-length="50" name="houseOwnerCardNum" value="${vdata.house.houseOwnerCardNum }" class="col-xs-12 col-sm-12" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >产权人户籍地</label>
				
						<div class="col-xs-4">
							<input type="text" max-length="50"name="houseOwnerAddress" value="${vdata.house.houseOwnerAddress }" class="col-xs-12 col-sm-12" />
						</div>
						<label class="col-xs-2 control-label no-padding-right text-right" >产权人现地址</label>
				
						<div class="col-xs-4">
							<input type="text" max-length="50" name=houseOwnerNowAddress value="${vdata.house.houseOwnerNowAddress }" class="col-xs-12 col-sm-12" />
						</div>
					</div>
					<div class="form-group">
						
						<label class="col-xs-2 control-label no-padding-right text-right" >工作单位</label>
				
						<div class="col-xs-4">
							<input type="text" max-length="50" name="houseOwnerCompany" value="${vdata.house.houseOwnerCompany }" class="col-xs-12 col-sm-12" />
						</div>
						<label class="col-xs-2 control-label no-padding-right text-right" >产权人电话</label>
				
						<div class="col-xs-4">
							<input type="text" max-length="50" name=houseOwnerPhone value="${vdata.house.houseOwnerPhone }" class="col-xs-12 col-sm-12" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right" >共有人姓名</label>
						<div class="col-xs-4">
							<input type="text" max-length="50"name="houseCommonName" value="${vdata.house.houseCommonName }" class="col-xs-12 col-sm-12" />
						</div>
						<label class="col-xs-2 control-label no-padding-right text-right" >与产权人关系</label>
						<div class="col-xs-4">
							<input type="text" max-length="50"name="commonOwnerRelation" value="${vdata.house.commonOwnerRelation }" class="col-xs-12 col-sm-12" />
						</div>
					</div>
			</div>
			</div>
			</div>
			<div class="widget-box transparent">
				<div class="widget-header  widget-header-flat" style="min-height:30px;">
					<h4 class="green">使用人信息</h4>
					<div class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
				<div class="form-group">
				
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>使用人\单位</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="useName" name="useName" value="${vdata.house.useName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
			
					<div class="col-xs-4">
						<!-- <button type="button" >获取产权人信息</button> -->
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >与产权人关系</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" name=useOwnerRelation value="${vdata.house.useOwnerRelation }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>性别</label>
			
					<div class="col-xs-4">
						<select name="useSex" value="${vdata.house.useSex }"class="col-xs-12 col-sm-12 tooltip-error required">
						<option value="">请选择</option>
								<option value="男" >男</option>
								<option value="女">女</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >法定代表人</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" name=legalPerson value="${vdata.house.legalPerson }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >使用人性质</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" id="codeUseProperty" name="codeUseProperty" value="${vdata.house.codeUseProperty }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >证件类型</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" id="codeUseCard" name=codeUseCard value="${vdata.house.codeUseCard }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >证件号码</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" name="useCardNumber" value="${vdata.house.useCardNumber }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >联系方式</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" name=usePhone value="${vdata.house.usePhone }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >户籍地址</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" name="useAddress" value="${vdata.house.useAddress }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >现住址</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" name=useCurrentAddress value="${vdata.house.useCurrentAddress }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >使用人是否流动人口</label>
					<div class="col-xs-4">
						<select name="isUserFlow" selectValue="${vdata.house.isUserFlow }"class="col-xs-12 col-sm-12 myselect" >
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
								
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >工作单位</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50" name=useWork value="${vdata.house.useWork }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >使用人居住证号</label>
					<div class="col-xs-4">
						<input type="text" max-length="50" name=useLiveNumber value="${vdata.house.useLiveNumber }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >共同使用人姓名</label>
					<div class="col-xs-4">
						<input type="text" max-length="50" name="useTogetherName" value="${vdata.house.useTogetherName }" class="col-xs-12 col-sm-12" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >与使用人关系</label>
					<div class="col-xs-4">
						<input type="text" max-length="50" name=useTogetherRelation value="${vdata.house.useTogetherRelation }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >租赁时间</label>
					<div class="col-xs-4">
					<div class="input-group">
						<input class="col-xs-12 col-sm-12 form-control date-picker"name="rentDate" value="${vdata.house.rentDate }"  id="rentDate" type="text"/>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >租赁期限</label>
					<div class="col-xs-4">
						<input type="text" max-length="50" name=rentTerm value="${vdata.house.rentTerm }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >是否租赁整体</label>
					<div class="col-xs-4">
					<select name="isRentWhole" selectValue="${vdata.house.isRentWhole }"class="col-xs-12 col-sm-12 myselect">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
								
						</select>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >租金</label>
					<div class="col-xs-4">
						<input type="text" max-length="50" name=rentFund value="${vdata.house.rentFund }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >租赁间数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50" name="rentRoomCount" value="${vdata.house.rentRoomCount }" class="col-xs-12 col-sm-12 digital" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >租赁面积</label>
					<div class="col-xs-4">
						<input type="text" max-length="50" name=rentArea value="${vdata.house.rentArea }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >租赁合同</label>
					<div class="col-xs-4">
						<select name="haveRentContract" selectValue="${vdata.house.haveRentContract }"class="col-xs-12 col-sm-12 myselect">
								<option value="">请选择</option>
								<option value="0">无</option>
								<option value="1">有</option>
								
						</select>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >登记备案</label>
					<div class="col-xs-4">
					<select name="isRegistration" selectValue="${vdata.house.isRegistration }"class="col-xs-12 col-sm-12 myselect" >
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
								
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >到期时间</label>
					<div class="col-xs-4">
						<div class="input-group">
							<input class="col-xs-12 col-sm-12 form-control date-picker"name="expiryDate" value="${vdata.house.expiryDate }"  id="expiryDate" type="text"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >租赁公房</label>
					<div class="col-xs-4">
						<input type="text" max-length="50" name=codeHouseHousing value="${vdata.house.codeHouseHousing }" class="col-xs-12 col-sm-12" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >双方签订计划生育保证书</label>
					<div class="col-xs-4">
						<select name="isSignBirth" selectValue="${vdata.house.isSignBirth }"class="col-xs-12 col-sm-12 myselect">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
						</select>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" >双方签订治安责任保证书</label>
					<div class="col-xs-4">
						<select name="isSignOrder" selectValue="${vdata.house.isSignOrder }"class="col-xs-12 col-sm-12 myselect">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
						</select>
					</div>
				</div>
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


