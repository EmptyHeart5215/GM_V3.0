<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<script type="text/javascript">
$(function(){
	$("#form").validate({
		submitHandler: function (form) {
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
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),
		goToClick:function(e, treeId, treeNode){
			var datas=treeNode[this.idKey];
			if(treeNode[this.idKey].length<20){
				bootbox.alert('请选择网格！');
				return false;
			}else{
				//自动获取网格员及电话
				$.ajax({
					type : "post",
					url : "${base}/sys/user/userWangGeYuan?gridCode="+datas,
					dataType : 'json',
					async : false,
					success : function(data) {
						if(data != null){
					
							$("#gridContacts").val(data.realName); // 
							$("#gridContactsPhone").val(data.phone); // 
						
						}						
					}
				});
				//
			return true;
			}
		}
		
	});

	
	$("[name=codePolitical]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_POLITICAL',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	$("[name=codeJigouState]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JIGOU_STATE',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	$("[name=codeJigouFunction]").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JIGOU_FUNCTION',
		name:"dicValue",
		pIdKey:"parentCode"
	});
	
	if('${vdata.bjigou.jigouManagerSex }' == '男'){
		 $("#jigouManagerSex option[value='男']").attr("selected", "selected"); 
	 }else if('${vdata.bjigou.jigouManagerSex }' == '女'){
		 $("#jigouManagerSex option[value='女']").attr("selected", "selected"); 
	 }else if('${vdata.bjigou.jigouManagerSex }' == 0){
		 $("#jigouManagerSex option[value='0']").attr("selected", "selected"); 
	 }
});
function text(){
	
}
</script>
</head>
<body>

<div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
<!-- 			<h2 class="text-center">组织生活</h2> -->
			<input type="hidden" name="code" value="${vdata.bjigou.code }" />
			<div class="form-group">
					
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="titleName"><span class="red">*</span>所属辖区</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="gridCode" name="gridCode" value="${vdata.bjigou.gridCode }" onmousemove="text()" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode"><span class="red">*</span>机构队伍名称</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="jigouName" name="jigouName" value="${vdata.bjigou.jigouName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					
				 </div>
				 
				<div class="form-group">
				<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="jigouManager"><span class="red">*</span>机构队伍负责人</label>
					<div class="col-xs-4">
						<input type="text" max-length="100"id="jigouManager" name="jigouManager" value="${vdata.bjigou.jigouManager }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="jigouManagerSex">负责人性别</label>
					<div class="col-xs-4">
						 <select  id="jigouManagerSex" name = "jigouManagerSex"  class="form-control myselect"  style="width: 100%;" onchange="changeSelect(this.value)">
						   <option  value="0">--请选择--</option>
                           <option  value="男">男</option>
                           <option  value="女">女</option>
                        </select>
					</div>
					
				 </div>
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="managerPost">负责人团队职务</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managerPost" name="managerPost" value="${vdata.bjigou.managerPost }" class="col-xs-12 col-sm-12 " />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="managerPhone"><span class="red">*</span>负责人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managerPhone" name="managerPhone" value="${vdata.bjigou.managerPhone }" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
				</div>
	
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeJigouFunction"><span class="red">*</span>队伍类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeJigouFunction" name="codeJigouFunction" value="${vdata.bjigou.codeJigouFunction }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="beginTime"><span class="red">*</span>成立时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="beginTime" value="${vdata.bjigou.beginTime }"  type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>	
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="address">机构地址</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"id="address" name="address" value="${vdata.bjigou.address }" class="col-xs-12 col-sm-12 " />
					</div>
					
				</div>					
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="codeJigouState"><span class="red">*</span>队伍状态</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="codeJigouState" name="codeJigouState" value="${vdata.bjigou.codeJigouState }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridContacts"><span class="red">*</span>网格联系人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridContacts" name="gridContacts" value="${vdata.bjigou.gridContacts }" placeholder="选择辖区后自动获取" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridContactsPhone"><span class="red">*</span>网格联系人电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"id="gridContactsPhone" name="gridContactsPhone" value="${vdata.bjigou.gridContactsPhone }" placeholder="选择辖区后自动获取" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
<!-- 					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridContactsDuty">网格联系人职务</label> -->
<!-- 					<div class="col-xs-4"> -->
<%-- 						<input type="text" max-length="50"id="gridContactsDuty" name="gridContactsDuty" value="${vdata.bjigou.gridContactsDuty }" class="col-xs-12 col-sm-12 " /> --%>
<!-- 					</div> -->
				</div>					
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图定位</label>
					<div class="col-xs-10 input-group">
					    <input class="form-control position-picker tooltip-error required" onclick="getPointXY(this)" id="position" name="position" value="${vdata.bjigou.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					   </div>
				</div>				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="serviceDescriptione">队伍描述 </label>
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="serviceDescriptione" name="serviceDescriptione" class="col-xs-12 col-sm-12">${vdata.bjigou.serviceDescriptione }</textarea>
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
