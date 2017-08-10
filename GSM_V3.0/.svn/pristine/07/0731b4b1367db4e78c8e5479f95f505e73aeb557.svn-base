<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<jsp:include  page="/resource/base_import.jsp"/>
		<script type="text/javascript">
		//添加按钮方法，方法名固定，不可改变
		var addFun=function(){
			var dialog=bootbox.dialog({
				 url:"${base}/yanpanfenxi/renchaxun/addLoad",
				  title: "新增人",
				  style:'width:800px;height:520px;'
				});
		};
		//编辑按钮方法，方法名固定，不可改变
		function editFun(code){
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
				 url:"${base}/yanpanfenxi/renchaxun/modifyLoad?code="+code,
				  title: "人修改",
				  style:'width:800px;height:520px;'
				});
			}else{
				bootbox.alert("请刷新重试！");
			}
		}
		//删除按钮方法，方法名固定，不可改变
		var deleteFun=function(code){
			 if(code&&"string"!=typeof code){
					var code=$('#grid-table').jqGrid('getGridParam', "selarrrow");
					 if(code.length==0){
						 bootbox.alert('请至少选择一条信息！');
						 return;
					 }
				}
			bootbox.confirm('确定删除吗？',function(result){
				if(result){
					 $.ajax({
							type : "post",
							url : "${base}/yanpanfenxi/renchaxun/delete?codes="+code,			
							dataType : 'json',
							async : false,
							success : function(data) {
								bootbox.slideAlert('body',data.status,data.info);
								if(data.status){
									$("#grid-table").trigger("reloadGrid"); 	    
								}
							}
						}); 
				}
			});
		};
		var addValue=function(code,nameDic) {
			if(code&&""!=$.trim(code)){
				var dialog=bootbox.dialog({
					 url:"${base}/yanpanfenxi/renchaxun/manageLoad?sysDicCode=" + code,
					  title: "编辑 "+nameDic+" 人值",
					  style:'width:80%;height:600px',
					  iframeStyle:'height:500px;',
					  showFunctionBtn:false
					});
				}else{
					bootbox.alert("请刷新重试！");
			}
			
		}
	$(function(){
		 $("#grid-table").jqGrid({
			 	url : "${base }/yanpanfenxi/renchaxun/zongheManage",
		        datatype:"json", //数据来源，本地数据
		        mtype:"POST",//提交方式
		        height:"auto",//高度，表格高度。可为数值、百分比或'auto'
		        //width:1000,//这个宽度不能为百分比
		        autowidth:true,//自动宽
		        defaultCaozuo:false,
		        ondblClickRow:function(code){
						var personType="jingNei";
			    	  bootbox.dialog({
							 url:"${base}/base/person/infoSee?personCode="+code+"&personType="+personType,
							  title: "人口信息采集表",
							  iframeStyle:'height:1500px;',
							  showFunctionBtn:false,
							  style:'width:1000px;height:600px;'
							});
			      },
		        colNames:[ '主键', '所属辖区','楼栋','单元','姓名','性别','民族','电话','人户状态','管理类型','婚姻状况'],
		        colModel:[
					{name:'code',index:'code',sortable:false, hidden:true},
					{name:'seatGrid.gridTotalName',index:'gridCode', width:'38%',align:'center'},
		            {name:'buildName',index:'buildName', width:'15%',align:'center'},
		            {name:'unitName',index:'unitName', width:'15%',align:'center'},
		            {name:'name',index:'name', width:'15%',align:'center'},
		            {name:'sex',index:'sex', width:'15%', align:"center",formatter:
		            	function(cellvalue, options, rowObject){
	            		var sex =rowObject['sex'];
	            		if(sex == '男'){
	            			return '<font color="red">男</font>';
	            		}else if(sex == '女'){
	            			return '<font color="green">女</font>';
	            		}else if(sex == 0){
	            			return '<font color="#694d9f">未填写</font>';
	            		}
    	    	     }
		            },
		            {name:'dicValueMap.codeNation',index:'codeNation', width:'15%',align:'center'},
		            {name:'phone',index:'phone', width:'20%', align:"center"},
		            {name:'dicValueMap.codeHouseholdStatus',index:'codeHouseholdStatus', width:'15%',align:'center'},
		            {name:'dicValueMap.codeManageType',index:'codeManageType', width:'20%', align:"center"},
		            {name:'dicValueMap.codeMarriage',index:'codeMarriage', width:'15%',align:'center'}
		            
		        ],
		        sortable:true,
		        rownumbers:true,//添加左侧行号
		        altRows:true,//班玛线
		        sortname:'code',
		        sortorder:'desc',
		        viewrecords: true,//是否在浏览导航栏显示记录总数
		        rowNum:10,//每页显示记录数
		        rowList:[10,20,30],//用于改变显示行数的下拉列表框的元素数组。
		        multiselect: true,
		        jsonReader:{
		            id: "code",//设置返回参数中，表格ID的名字为CODE
		            repeatitems : false
		        },
		        pager:$('#grid-pager'),
		        caption: "人管理列表"
		    });
		 //搜索按钮方法
		 $("#search").click(function(){
				var  postData={"args":JSON.stringify($("#search_form").serializeJson())};
				$("#grid-table").jqGrid('setGridParam',{postData:postData}).trigger("reloadGrid"); 
			});
		 $("[name='gridCode']").ztreeGrid({
			 	url: '${base}/sys/seatgird/queryGridTreeByUserGridCode?t=' + Math.random(),
				name:"name",
				pIdKey:"parentCode",
				reset:true,
				checkBox:true,
				resetId:'redo'
				});
		//民族
		 $("[name='codeNation']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_NATION',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				checkBox:true,
				resetId:'redo'
				});
			
			//婚姻状况
			$("[name='codeMarriage']").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_MARRIAGE',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			checkBox:true,
			resetId:'redo'
			});
			//政治面貌
			$("[name='codePolitical']").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_POLITICAL',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			checkBox:true,
			resetId:'redo'
			});
			//学历
			$("[name='codeEducation']").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_EDUCATION',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			checkBox:true,
			resetId:'redo'
			});
			//宗教信仰
			$("[name='codeReligious']").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_RELIGIOUS',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			checkBox:true,
			resetId:'redo'
			});
			//管理类型
			$("[name='codeManageType']").ztreeGrid({
			url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_MANAGE_TYPE',
			name:"dicValue",
			pIdKey:"parentCode",
			reset:true,
			checkBox:true,
			resetId:'redo'
			});
			$("[name='codeIdType']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_ID_TYPE',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				resetId:'redo'
				});
			$("[name='codeVolunteerType']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_VOLUNTEER_TYPE',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				checkBox:true,
				resetId:'redo'
				});
			$("[name='codePerResources']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_PER_RESOURCES',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				checkBox:true,
				resetId:'redo'
				});
			$("[name='codeSamc']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_SAMC',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				checkBox:true,
				resetId:'redo'
				});
			$("[name='codeJiuYeType']").ztreeGrid({
				url:'${base}/sys/dicvalue/queryManageTree?name_dic=CODE_JIU_YE_TYPE',
				name:"dicValue",
				pIdKey:"parentCode",
				reset:true,
				checkBox:true,
				resetId:'redo'
				});
	 });
	//在提交或者修改单条信息成功后的调用方法，用于子页面调用
	 function successFun(){
		bootbox.hideAll();
		bootbox.slideAlert('body');
		jQuery("#grid-table").trigger("reloadGrid"); 	    
	 }
	
</script>
<style type="text/css">
fieldset {
  border: 1px solid #DDDDDD;
  padding: 10px;
}
</style>
</head>
<body>
	<div class="row">
	<div class="col-xs-12 col-sm-12" id="body">
		<div class="widget-box transparent collapsed" style="margin:0px">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter green">
						<i class="icon-search"></i>
						人查询
					</h4>

					<div class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-down"></i>
						</a>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-body-inner" style="display: none;">
							<div id="sales-charts" style="padding: 0px; width: 100%; height: auto; position: relative;">
								<form id="search_form">
								<table style="width:100%;">
										<tr>
											<td>
												<div class="search-group">
													<label class="col-xs-2 control-label text-right">所属辖区 </label>
													<input name="gridCode" type="text" class="text col-xs-2"  >
													<label class="col-xs-2  control-label text-right">姓名 </label>
													<input name="name" type="text" class="text col-xs-2">
													<label class="col-xs-2  control-label text-right">性别</label>
													<div style="width:16.6666%;float: left;">
													<select  id="sex" name = "sex"  class="form-control myselect col-xs-12"  style="width: 100%;" onchange="changeSelect(this.value)">
														<option value="">--请选择--</option>
										                <option value="男">男</option>
										                <option value="女">女</option>
										            </select>
										            </div>
												</div>
											</td>
											
											<td style="width:100px;" rowspan="2">
												<ul  class="pull-right list-unstyled" style="margin:0px" >
													<li style="padding-top:1px;">
													   <button type="button" class="btn btn-info" id="search">查询
														  <i class="icon-search bigger-110 "></i>
													   </button>
													</li>
													<li style="padding-top:5px;">
														<button type="reset" class="btn btn-info" id="reset">重置
															  <i class="glyphicon glyphicon-arrow-left bigger-110 "></i>
														</button>
													</li>
												</ul>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">楼栋</label>
															<input name="buildName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">单元</label>
															<input name="unitName" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">房间</label>
															<input name="houseNum" type="text" class="text col-xs-2"  >
															
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">管理类型 </label>
															<input name="codeManageType" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">证件类型 </label>
															<input name="codeIdType" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">证件号码</label>
															<input name="cid" type="text" class="text col-xs-2"  >
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">民族 </label>
															<input name="codeNation" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">文化程度 </label>
															<input name="codeEducation" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">宗教信仰</label>
															<input name="codeReligious" type="text" class="text col-xs-2"  >
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">政治面貌 </label>
															<input name="codePolitical" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">关注人群 </label>
															<div style="width:16.6666%;float: left;">
																<select  id="focusPeople" name = "focusPeople"  class="form-control myselect col-xs-12"  style="width: 100%;" onchange="changeSelect(this.value)">
																   <option value="0">--请选择--</option>
										                           <option value="TS_XING_SHI">刑释解教人员</option>
										                           <option value="TS_JIAO_ZHENG">社区矫正人员</option>
										                           <option value="TS_XI_DU">吸毒人员</option>
										                           <option value="TS_JING_SHEN">精神病人员</option>
										                           <option value="TS_AI_ZI">艾滋病人员</option>
										                           <option value="TS_XIE_JIAO">邪教人员</option>
										                        </select>
															</div>
															<label class="col-xs-2  control-label text-right">帮扶人群 </label>
															<div style="width:16.6666%;float: left;">
																<select  id="helpingPeople" name = "helpingPeople"  class="form-control myselect col-xs-12"  style="width: 100%;" onchange="changeSelect(this.value)">
																   <option value="0">--请选择--</option>
										                           <option value="BF_LIU_SHOU">留守人员</option>
										                           <option value="BF_CAN_JI">残疾人</option>
										                           <option value="BF_DI_BAO">低保户</option>
										                           <option value="BF_WU_BAO">五保户</option>
										                           <option value="BF_JIU_ZHU">社区救助人员</option>
										                           <option value="BF_KONG_CHAO">空巢老人</option>
													               <option value="BF_KUN_NAN_ZHI_GONG">困难职工</option>
										                           <option value="BF_TE_KUN_SHENG">特困学生</option>
										                        </select>
															</div>
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">资源人群</label>
															<input name="codePerResources" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">志愿者 </label>
															<input name="codeVolunteerType" type="text" class="text col-xs-2">
															<label class="col-xs-2  control-label text-right">拥军优抚 </label>
															<input name="codeSamc" type="text" class="text col-xs-2">
														</div>
											</td>
										</tr>
										<tr>
											<td>
											
														<div class="search-group">
															<label class="col-xs-2  control-label text-right">就业情况</label>
															<input name="codeJiuYeType" type="text" class="text col-xs-2"  >
															<label class="col-xs-2  control-label text-right">劳动保障 </label>
															<div style="width:16.6666%;float: left;">
																<select  id="laborSecurity" name = "laborSecurity"  class="form-control myselect col-xs-12"  style="width: 100%;" onchange="changeSelect(this.value)">
																   <option value="0">--请选择--</option>
										                           <option value="IS_ZI_GE">职业资格证</option>
										                           <option value="IS_HAS_JIU_YE_ZHENG">就业失业登记证</option>
										                           <option value="IS_HE_TONG">劳动合同</option>
										                           <option value="IS_YANG_LAO">养老保险</option>
										                           <option value="IS_SHI_YE_BAO_XIAN">失业保险</option>
										                           <option value="IS_YI_LIAO">医疗保险</option>
										                           <option value="IS_GONG_SHANG">工伤保险</option>
										                           <option value="IS_SHENG_YU">生育保险</option>
										                           <option value="IS_GONG_JI_JIN">住房公积金</option>
										                        </select>
															</div>
														</div>
											</td>
										</tr>
									</table>
								</form>
							</div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div>
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
		</div>
	    
	</div>
	<!-- 列表右下角按钮组代码 -->
		<script type="text/javascript" src="${base }/resource/js/jqGrid/gridImport.js"></script>
</body>
</html>


