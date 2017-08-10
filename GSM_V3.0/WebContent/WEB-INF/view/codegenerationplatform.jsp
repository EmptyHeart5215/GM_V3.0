<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include  page="/resource/base_import.jsp"/>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
$(function(){
	//父窗口中的提交按钮
	$("#createCodeBtn").bind("click",function(){
		var data = $("#form").serialize();
		$.ajax({
			type : "post",
			url : "${base}/${vdata.url}?t="+Math.random(),
			data : data,
			dataType : 'text',
			async : true,
			success : function(data) {
				$("#soundCode").val(data);
			}
		});
	});
	
	//父窗口中的提交按钮
	$("#createFileBtn").bind("click",function(){
		var data =  $("#form").serialize();
		$.ajax({
			type : "post",
			url : "${base}/${vdata.url1}?t="+Math.random(),
			data : data,
			dataType : 'text',
			async : true,
			success : function(data) {
				bootbox.alert(data);
			}
		});
	});
});
</script>
</head>
 <body>
    <div style="width: 100%">
       <div style="height: 50px;width: 100%;text-align: center;">
         <div style="width: 100%;height: 11px;"></div>
         <div style="font-size: 20px;"><strong>GSM_V3.0系统平台代码文件生成器_v1.0.0.1</strong></div>
       </div>
       <div style="height: 550px;width: 100%;">
           <form id="form">  
	           <div style="height: 100px;width: 100%;">
	               <div style="height: 10px;"></div>
	               <div style="height: 40px;width: 100%;">
	                   <div class="form-group">
						<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="modelName">输入Model名称</label>
				
						<div class="col-xs-4">
							<input type="text" id="modelName" name="modelName" value="${modelName }" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
						<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="realName">生成类型</label>
			
						<div class="col-xs-4">
	                         <select id="createType" class="form-control select2"  name="createType" style="width: 100%;">
							   <option id="createType"  value="0" selected="selected">----请选择----</option>
	                           <option id="createType"  value="Mapper" >Mapper接口</option>
	                           <option id="createType" value="MapperImpl">MapperImpl接口实现类</option>
	                           <option id="createType"  value="Mapper.xml" >Mapper.xml文件</option>
	                           <option id="createType" value="Service">Service接口</option>
	                           <option id="createType" value="ServiceImpl">ServiceImpl接口实现类</option>
	                           <option id="createType" value="Action">Action接口实现类</option>
	                        </select>
						</div>
				     </div>
	               </div>
	               <div style="height: 40px;width: 100%;">
	                   <div class="form-group">
						<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="authorName"><span class="red">*</span>创建人</label>
				
						<div class="col-xs-4">
							<input type="text" id="authorName" name="authorName" value="${authorName }" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
						<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="packageUrl"><span class="red">*</span>包名路径</label>
				
						<div class="col-xs-4">
							<input type="text"id="packageUrl" name="packageUrl" value="${packageUrl}"  placeholder="包名路径只写后部分便可，例如：sys.mapperinterf" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					 </div>
	               </div>
	           </div>
	           <div style="height: 390px;width: 100%;">
	              <div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="remark">生成源码 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="soundCode" rows="21" cols="15" name="soundCode" class="col-xs-12 col-sm-12 tooltip-error required" >${soundCode }</textarea>
						</div>
					</div>
				</div>
	           </div>
	           </form>
	           <div style="width: 60%;height: 50px;text-align: center;">
	               <table style="margin-left: 70%;" align="center" height="40px;" width="60%" cellpadding="0" cellspacing="1" border="0">
	                  <tr>
	                     <td><button type="button" class="btn btn-info" id="createCodeBtn">生成源码<i class="icon-search bigger-110 "></i> </button></td>
	                     <td><button type="button" class="btn btn-info" id="createFileBtn">生成文件<i class="icon-search bigger-110 "></i> </button></td>
	                  </tr>
	                  <tr>
	                    <td colspan="2"><span style="font-family: cursive;text-align: center;">注：(确定源码正确无误，点击生成文件按钮，生成文件到工作区间)</span></td>
	                  </tr>
	               </table>
	           </div>
       </div>
    </div>
 </body>
</html>