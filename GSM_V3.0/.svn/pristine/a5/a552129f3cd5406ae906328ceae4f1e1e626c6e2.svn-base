<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

	<div style="width: 100%;height:545px;">
		<div style="width: 100%;height: 50%;margin-top: 0.5%">
		    <div id="containerPie" style="width: 49%;height: 100%;float: left;">饼状</div>
		    <div id="biaoge" style="width: 49%;height: 100%;float: right;"><!-- 统计表格 -->
		      <div>
		        <table width="100%" cellspacing="1" bgcolor="#f4f4f4">
				   <tbody>
					  <tr>
						 <td width="20%"></td>
						 <td height="30" style="text-align: center;">
						 <b id="listTableTitle" style="color: #0096bb;"></b>
						 </td><td  width="20%">
						 <a href="javaScript:void(0)" onclick="excel(this)" class="easyui-linkbutton" iconCls="" style="float:right">导出excel</a></td>
					 </tr>
					 </tbody>
				 </table>
				 <table width="100%" cellspacing="0" id="tables"class="datagrid-body">
					 <thead class="tableHead">
					  <tr><td id="fenzuId" style="width: 40%; border-left: 0;height: 14px;border-bottom: 0px;">分组名称</td>
					  <td id="numName" style="width: 30%; border-bottom: 0px;"></td>
					  <td style="width: 30%;border-bottom: 0px;">所占比例</td></tr>
					  </thead>
					   <tbody id="listTable" style="overflow: auto;height: 218px;">				
				  </tbody>					
			    </table>
			   </div>
		    </div>
		</div>
		<div style="width:100%;height: 48%;margin-top: 1.5%">
		    <div id="containerLine" style="width: 49%;height: 100%;;float: left;">折线</div>
		    <div id="containerColumn" style="width: 49%;height: 100%;float: right;">柱状</div>
		</div>
	</div>
	<form id="exportExcelForm" action="${base }/charts/benterprisecharts/exportExcel" method="post">
		<input type="hidden" id="tableValue" name="tableValue"/>
		<input type="hidden" id="title" name="title"/>
	</form>