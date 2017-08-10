<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include  page="/resource/res.html"/>
 
<script type="text/javascript">
	$(function() {
		$("#file_upload_1").uploadify({
			
			height:30,
			width:120,
			removeCompleted:false,
			onUploadSuccess:function (file, data, response) { 
				alert(data);
			}
		});
	});
</script>


<script type="text/javascript">


function save(){
	var data = $("#form").serialize();
	$.ajax({
		type : "post",
		url : "${base}/${vdata.url}?t="+Math.random(),
		data : data,
		dataType : 'json',
		async : false,
		success : function(data) {
			parent.Dialog.alert(data.info);
            if(data.status){
            	parent.diag.close();
            }
		}
	});
}
</script>
</head>
<body>



<form id="form">
        <div id="List_Main2" style="overflow-x: hidden; overflow-y: auto;">
            <div class="List_from">
                <h1 class="from_h1">用户</h1>
                <input type="hidden" name="Code" value="${vdata.map.CODE }" />
                <table class="GSM_From2" width="100%" border="0" cellspacing="1" cellpadding="0">

                    <tr>                        
                        <td class="GSM_From2_bt" width="20%">
                            <div><span>*</span>名称</div>
                        </td>
                        <td>
                            <div>
                            <input type="text" class="validate[required]" id="LoginName" name="LoginName" value="${vdata.map.LOGIN_NAME }" />
                                </div>
                        </td>
                        <td class="GSM_From2_bt">
                            <div>真实名</div>
                        </td>
                        <td>
                            <div>                            
                            
                            <input type="text" name="NameUser"  value="${vdata.map.NAME_USER }"/>                           
                            </div>
                        </td>
                         
                   </tr>
                    <tr>
                        <td class="GSM_From2_bt" >
                            <div>手机</div>
                        </td>
                        <td>
                            <div>
                            <input type="text" id="Tel" name="Tel" value="${vdata.map.TEL }" />
                                </div>
                        </td>
                              <td class="GSM_From2_bt">
                            <div>所属辖区或部门</div>
                        </td>
                        <td>
                            <div>
                            <input type="text" id="GridCode" name="GridCode" value="${vdata.map.GRID_CODE }" />
                                </div>
                        </td>
                   </tr>
                    <tr>
                         <td class="GSM_From2_bt">
                            <div>分机号（接线员）</div>
                        </td>
                        <td>
                            <div>
                            <input type="text" id="CodeCard" name="CodeCard" value="${vdata.map.CODE_CARD }" />
                                </div>
                        </td>
                        <td class="GSM_From2_bt">
                            <div>角色</div>
                        </td>
                        <td>
                            <div>
                            <input type="text" id="RoleCode" name="RoleCode" value="${vdata.map.ROLE_CODE }" />
                                                            
                                </div>
                        </td>
                   </tr>                      
                </table>

            </div>
        </div>

        <div class="List_Foot">
            <div class="Button_div">
                <input name="提交" type="button" value="保存" class="btn" onclick="save()" />
                
            </div>
            <div>带有“<span style="color: #f00">*</span>”的为必填项，请认真填写。</div>
        </div>
    </form>
			
			
			    
    <input type="file" name="file_upload_1" id="file_upload_1" />
    <p>
      <a href="javascript:$('#uploadify').uploadifyUpload()">上传</a>| 
      <a href="javascript:$('#uploadify').uploadifyClearQueue()">取消上传</a>
    </p>
</body>
</html>

