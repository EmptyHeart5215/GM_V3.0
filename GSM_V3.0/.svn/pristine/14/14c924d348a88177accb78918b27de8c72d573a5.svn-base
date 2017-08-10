<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
<jsp:include  page="/resource/base_import.jsp"/>
<body>
 <div class="row">
		<div class="col-xs-12" id="body">
			<form class="form-horizontal" role="form" id="form">
			        <input type="hidden" id="parentCode" name="parentCode" value="${map.seat.parentCode}${map.parentCode}" />
                    <input type="hidden" name="code" value="${map.seat.code}" />
                    <input type="hidden" name="flagDepartment" value="0" />
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="name"><span class="red">*</span>街道/乡名</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="name" name="name" value="${map.seat.name}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" for="cityCode"><span class="red">*</span>行政区划代码</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="10"id="cityCode" name="cityCode" value="${map.seat.cityCode}" class="col-xs-12 col-sm-12 tooltip-error digits required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>党(工)委负责人</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="partyManagerName" name="partyManagerName" value="${map.seat.partyManagerName}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>党(工)委负责人电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="10"id="partyManagerPhone" name="partyManagerPhone" value="${map.seat.partyManagerPhone}" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>政府(办事处)负责人</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="governmentName" name="governmentName" value="${map.seat.governmentName}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>政府(办事处)负责人电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="10"id="governmentPhone" name="governmentPhone" value="${map.seat.governmentPhone}" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>综治办主任</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managementName" name="managementName" value="${map.seat.managementName}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right"><span class="red">*</span>综治办主任电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="10"id="managementPhone" name="managementPhone" value="${map.seat.managementPhone}" class="col-xs-12 col-sm-12 tooltip-error allPhone required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="managerName"><span class="red">*</span>网格化工作责任人</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managerName" name="managerName" value="${map.seat.managerName}" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
					<label class="col-xs-2 control-label no-padding-right text-right" ><span class="red">*</span>网格化工作责任人电话</label>
			
					<div class="col-xs-4">
						<input type="text" max-length="50"id="managerPhone" name="managerPhone" value="${map.seat.managerPhone}" class="col-xs-12 col-sm-12 tooltip-error required allPhone" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >网格化工作责任人地址 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea  max-length="100" class="col-xs-12 col-sm-12"id="managerAddress" name="managerAddress">${map.seat.managerAddress}</textarea>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="position"><span class="red">*</span>地图描边</label>
			
					<div class="col-xs-10">
						<input type="text"id="position" readonly="readonly" name="position" placeholder="点击进行地图描边"value="${map.seat.position}" onclick="getPointXY(this)" class="col-xs-12 col-sm-12 tooltip-error required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="sort"><span class="red">*</span>排序</label>
			
					<div class="col-xs-4">
						<input type="text"id="remark" name="sort" min="0" value="${map.seat.sort}" class="col-xs-12 col-sm-12 tooltip-error required digits" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="address">地址 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea max-length="5000" class="col-xs-12 col-sm-12"id="address" name="address">${map.seat.address}</textarea>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" >街道/乡描述 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea max-length="5000" class="col-xs-12 col-sm-12"id="description" name="description" rows="8">${map.seat.description}</textarea>
						</div>
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right" for="remark">备注 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
								<textarea id="remark" name="remark" sytle="height:100px;" max-length="5000" class="col-xs-12 col-sm-12">${map.seat.remark }</textarea>
						</div>
					</div>
				</div>
				<jsp:include page="/resource/js/layer-v1.8.5/imgShowForGrid.jsp"/>
				<div class="space-4"></div>
				 <div class="control-group">
                <label class="control-label">
                </label>
            </div>
			</form>
		</div>
	</div>
	<jsp:include page="/resource/js/layer-v1.8.5/imgOperator.jsp"/>
</body>
</html>