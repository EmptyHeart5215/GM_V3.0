<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
var dangShiRenDiv="";
$(function(){
	//矛盾类型
	$("[name='codeEventType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//
	$("[name='codeEventFrom']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_FROM',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//学历
	$("[name='codeXueLi']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EDUCATION',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//矛盾人员类型
	$("[name='codeEventRenYuanType']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_REN_YUAN_TYPE',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	//发生规模
	$("[name='codeEventGuimo']").ztreeGrid({
	url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EVENT_GUIMO',
	name:"dicValue",
	pIdKey:"parentCode",
	reset:true,
	resetId:'redo'
	});
	
	$("[name='codeNation']").ztreeGrid({
		url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_NATION',
		name:"dicValue",
		pIdKey:"parentCode",
		reset:true,
		resetId:'redo'
		});
	$("[name=gridCode]").ztreeGrid({
		url:'${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),
		goToClick:function(e, treeId, treeNode){
			if(treeNode[this.idKey].length<20){
				bootbox.alert('请选择网格！');
				return false;
			}
			return true;
		}
	});
	//如果子页面需要进行图片浏览，必须加上这句-------------
	layer.use('extend/layer.ext.js', function(){
		   layer.ext =function(){};
	}); 
	//基础配置，只需要添加urlBase:${base}即可
	 var dropzone1=new Dropzone("#dropzoneDiv",{
		 	urlBase:"${base}",
		 	existedFiles:$('#url_pic').val().split(";").length-1,
		 	uploadBtnId:'uploadBtn',
            imgName:'showImg',
	});
	//dropzone代表dropzone对象
	//urlPicI表示model中存放上传文件id的那个字段使用的input的id，type 是hidden的
	//showOldImgName表示在组装已经存在的的图片的时候用的img标签的name
	//showOldImgDivId表示用来展示已经存在的图片的div的id
	 getOldPics(dropzone1,"url_pic","showImg_old","picDisplay_old");
	$("#cloneBtn").bind("click",function(){
		cloneDangShiRen();
	});
	dangShiRenDiv=$("#dangShiRen_div").clone();
	$("[name='dangShiRenSex']").val($("[name='dangShiRenSex']").attr('value'));
});
function cloneDangShiRen(){
	var dangShiRenDiv2=dangShiRenDiv.clone();
	var id=(dangShiRenDiv2.attr("id")+Math.random()).replace(".","_");
	var deleteBtn="<div class='col-xs-2'><button class='btn btn-xs btn-danger pull-right' onclick='deleteDSR(\""+id+"\")' type='button'> \
				<i class='icon-bolt bigger-110'></i> \
				删除此当事人  \
				</button></div>";
	dangShiRenDiv2.find("[name='dangShiRenAddress']").parent().after(deleteBtn);
	dangShiRenDiv2.attr("id",id);
	$("#dangShiRen_div").after(dangShiRenDiv2).after("<hr/>");
	changeIframeHeight();
}
function deleteDSR(id){
	$("#"+id).prev().remove();
	$('#'+id).remove();
	changeIframeHeight();
}
function changeIframeHeight(){
	if(parent.document.getElementById("dialog_iframe")==null){
		iFrameHeight(top.document.getElementById("mainFrame"));
	}else{
		iFrameHeight(parent.document.getElementById("dialog_iframe"));
	}
}
</script>
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="owner" value="${vdata.userCode}#1"/>
			<input type="hidden" id="actionID" name="actionID" />
			<input type="hidden" id="actionName" name="actionName" />
			<input type="hidden" name="code" value="${vdata.event.code }" />
				<fieldset>
    <legend class="lighter green">基本信息</legend>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>所属辖区或网格</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="gridCode" value="${vdata.event.gridCode }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矛盾类型</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="codeEventType" value="${vdata.event.codeEventType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矛盾主题</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="eventTitle" value="${vdata.event.eventTitle }" class="col-xs-12 col-sm-12 tooltip-error required"  />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>上报来源</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="codeEventFrom" value="${vdata.event.codeEventFrom }" class="col-xs-12 col-sm-12  tooltip-error required"  />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>发生规模</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="codeEventGuimo" value="${vdata.event.codeEventGuimo }" class="col-xs-12 col-sm-12 tooltip-error required"  />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>涉及人数</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="personCount" value="${vdata.event.personCount }" class="col-xs-12 col-sm-12 tooltip-error required digits" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>发生地点</label>
					<div class="col-xs-10">
						<input type="text" max-length="50"name="eventAddress" value="${vdata.event.eventAddress }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>地图位置</label>
					<div class="col-xs-4 input-group">
					    <input class="form-control position-picker tooltip-error required" name="position"id="position"onclick="getPointXY(this)" value="${vdata.event.position }"type="text">
						<span class="input-group-addon">
							<i class="icon-globe bigger-110"></i>
						</span>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>发生时间</label>
					<div class="col-xs-4 input-group">
						<input class="form-control date-picker tooltip-error required" name="eventDate" value="${vdata.event.eventDate }" type="text">
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>矛盾详情</label>
					<div class="col-xs-10">
						<textarea name="description" class="col-xs-12 col-sm-12 tooltip-error required" >${vdata.event.description }</textarea>
					</div>
				</div>
				</fieldset>
				<fieldset>
    <legend class="lighter green">当事人信息
    	<!-- <button class="btn btn-xs btn-success pull-right" id="cloneBtn" type="button">
			<i class="icon-plus bigger-110"></i>
				新增当事人
		</button> -->
   </legend>
    <div id="dangShiRen_div">
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>当事人</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="dangShiRenName" value="${vdata.event.dangShiRenName }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>当事人身份证号</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="dangShiRenId" value="${vdata.event.dangShiRenId }" class="col-xs-12 col-sm-12 tooltip-error required personcid" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>当事人类别</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="codeEventRenYuanType" value="${vdata.event.codeEventRenYuanType }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>当事人民族</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="codeNation" value="${vdata.event.codeNation }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >当事人学历</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="codeXueLi" value="${vdata.event.codeXueLi }" class="col-xs-12 col-sm-12 " />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>当事人性别</label>
					<div class="col-xs-4">
						<select value="${vdata.event.dangShiRenSex }" name="dangShiRenSex" class="form-control myselect col-xs-12 col-sm-12 tooltip-error required">
							<option value="">请选择</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
					
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>当事人联系电话</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="dangShiRenPhone" value="${vdata.event.dangShiRenPhone }" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>当事人联系地址</label>
					<div class="col-xs-4">
						<input type="text" max-length="50"name="dangShiRenAddress" value="${vdata.event.dangShiRenAddress }" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				</div>
				</fieldset>
				<fieldset>
    <legend class="lighter green">矛盾图片</legend>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >图片</label>
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn" type="button">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic" name="img" value="${vdata.event.img}" />
						</div>
					</div>
				</div>	
				 <c:if test="${vdata.event.img!=null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存图片 </label>
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>	 
				</fieldset>	 
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
			</form>


