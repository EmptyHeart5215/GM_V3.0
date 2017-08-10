<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<link href="/GSM_V3.0/resource/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/GSM_V3.0/resource/css/font-awesome.min.css">
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
});
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-12" id="body">
		<center><h1>呼叫登记</h1></center>
			<form class="form-horizontal" role="form" id="form">
			<input type="hidden" name="code" value="${vdata.retiredparty.code}" />
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label no-padding-right text-right" for="gridCode">呼叫号码  </label>
			
					<div class="col-xs-3">
						<input type="text" max-length="50"id="gridCode" name="gridCode" value="${vdata.retiredparty.gridCode}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeEducation">事件地点</label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeEducation" name="codeEducation" value="${vdata.retiredparty.codeEducation}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="name">姓名</label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="name" name="name" value="${vdata.retiredparty.name}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
	
					<label class="col-xs-2 control-label no-padding-right text-right" for="cid">性别 </label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="cid" name="cid" value="${vdata.retiredparty.cid}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				
				</div>
				<div class="form-group">	
				<label class="col-xs-2 control-label no-padding-right text-right" for="sex">住址 </label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="sex" name="sex" value="${vdata.retiredparty.sex}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="codeNation">地图定位</label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="codeNation" name="codeNation" value="${vdata.retiredparty.codeNation}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
											
					
					
					
					
					
				</div>
				<div class="form-group">
					
				
					<label class="col-xs-2 control-label no-padding-right text-right" for="codePolitical">诉求申请 </label>
			
					<div class="col-xs-8">
					<div class="clearfix">
						<textarea max-length="50"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required"></textarea>
						</div>
					</div>
	
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codePartyType">其他联系方式 </label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="codePartyType" name="codePartyType" value="${vdata.retiredparty.codePartyType}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="inPartyDate">来电人身份证号</label>
					
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required personcid" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codePartyType">共同诉求人 </label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="codePartyType" name="codePartyType" value="${vdata.retiredparty.codePartyType}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="inPartyDate">诉求主题</label>
					
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codePartyType">事件类型 </label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="codePartyType" name="codePartyType" value="${vdata.retiredparty.codePartyType}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="inPartyDate">回复人姓名</label>
					
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="rmark">回复内容</label>
					<div class="col-xs-8">
					<div class="clearfix">
						<textarea max-length="50"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required"></textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label id="sss" class="col-xs-2 control-label text-right" for="rmark">上报意见</label>
					<div class="col-xs-8">
					<div class="clearfix">
						<textarea max-length="50"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required"></textarea>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="codePartyType">所属辖区 </label>
			
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="codePartyType" name="codePartyType" value="${vdata.retiredparty.codePartyType}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="inPartyDate">事件来源</label>
					
					<div class="col-xs-3">
						<div class="clearfix">
						<input type="text" max-length="50"id="inPartyDate" name="inPartyDate" value="${vdata.retiredparty.inPartyDate}" class="col-xs-12 col-sm-12 tooltip-error required" />
						</div>
					</div>
					
				</div>
				
				<div class="space-4"></div>
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
            
			</form>
			<div class="col-xs-10" style="text-align:right;padding-right:4px;">
		
			<button  id="draftBtn" type="button" class="btn btn-info">登记</button>
		</div>
		</div>
	</div>

</body>
</html>


