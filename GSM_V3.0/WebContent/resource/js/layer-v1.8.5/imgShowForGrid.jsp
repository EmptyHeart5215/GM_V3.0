<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form-group">
					<label class="col-xs-2 control-label no-padding-right text-right">上传辖区图片/文件 </label>
			
					<div class="col-xs-10">
						<div class="clearfix">
						<div id='dropzoneDiv' class="dropzone">
							<button class="btn btn-purple btn-xs white" id="uploadBtn">
												<i class="icon-cloud-upload bigger-100"></i>
												上传
							</button>
							<br>
						</div>
							<input type="HIDDEN" id="url_pic" name="seatPicture" value="${map.seat.seatPicture }" />
						</div>
					</div>
				</div>
				<c:if test="${map.seat.seatPicture != null}">
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding-right text-right">已保存辖区图片/文件 </label>
				
						<div class="col-xs-10">
							<div class="clearfix">
								<div id="picDisplay_old" class="dropzone">
							    </div>
							</div>
						</div>
					</div>
				</c:if>