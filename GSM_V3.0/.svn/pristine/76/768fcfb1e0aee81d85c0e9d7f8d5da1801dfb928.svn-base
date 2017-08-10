<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script src="/GSM_V3.0/resource/js/highcharts/highcharts.js"
	type="text/javascript"></script>
<script src="/GSM_V3.0/resource/js/highcharts/exporting.js"
	type="text/javascript"></script>
<script src="/GSM_V3.0/resource/js/highcharts/export-excel.js"
	type="text/javascript"></script>
<script type="text/javascript">
	//饼状图或柱状图 pie/column
	//var globalType = "pie";
	//导出数据传值
	var exportData = "";
	//charts中需要用到的数据
	var cartegories = []; 
	var seriesdata = [];
	//显示的统计名称
	var chartTitle = "";
	//统计柱状图或是折线图的y轴标题提示
	var ytitle = "";
	function getTitle(_ytitle) {
		if (_ytitle) {
			ytitle = _ytitle;
		}
		return ytitle;
	}
	function getDefaultBackGround() {
		$('#bing').css("background-color", "#f4f4f4");
		$('#zhu').css("background-color", "#f4f4f4");
		$('#line').css("background-color", "#f4f4f4");
		$("#bing font").css("color", "#0097bb");
		$("#zhu font").css("color", "#0097bb");
		$('#line font').css("color", "#0097bb");
	}
	function excel(td) {
		$("#title").val(chartTitle + '统计列表');
		$("#tableValue").val(exportData);
		$("#exportExcelForm").submit();
	}
	function showChartPie(seriesdata, cartegories, type) {
		if (seriesdata.length == 0) {
			var noData = "暂无数据";
			var height=$('#containerPie').css("height");
			$('#containerPie').css("line-height",height);
			$('#containerPie').html("<center>"+noData+"</center>");
		} else {
			$('#containerPie').highcharts(
					{
						chart : {
							type : type,
							borderColor : '#99BCE8',
							borderWidth : 1,
						},
						title : {
							text : chartTitle + '统计饼状图',
							style : {
								fontSize : '12px',
								fontWeight : 'Bold',
								color : '#0096bb',
							}
						},
						tooltip : {
							formatter : function() {
								if (type == "pie") {
									return Highcharts.numberFormat(
											this.percentage, 2)
											+ '%';
								} else {
									return this.x + ":" + this.y;
								}
								//百分比保留小数
							}
						},

						plotOptions : {
							pie : {
								allowPointSelect : true, //选中某块区域是否允许分离
								cursor : 'pointer',
								dataLabels : {
									enabled : true
								//是否直接呈现数据 也就是外围显示数据与否
								},
								showInLegend : false
							},
							line : {
								dataLabels : {
									enabled : true
								},
								showInLegend : false
							},
							column : {
								dataLabels : {
									enabled : true
								//是否显示数据标签
								},
								showInLegend : false
							},
							series : {
								pointPadding : 5, //数据点之间的距离值
								groupPadding : 0, //分组之间的距离值
								borderWidth : 0,
								shadow : false,
								pointWidth : 15
							//柱子之间的距离值
							},

						},
						legend : {
							layout : 'vertical',
							backgroundColor : '#FFFFFF',
							floating : true,
							padding : 5,
							align : 'left',
							verticalAlign: 'top',
							x : 100,
							y : 45,
							labelFormatter : function() {
								return this.name
										+ '('
										+ Highcharts.numberFormat(
												this.percentage, 2) + '%)';
							}
						},
						xAxis : {
							tickmarkPlacement : 'on',
							labels : {
								// rotation:55,斜着
								style : {
									color : '#262626',
									fontSize : '12px',
									marginTop : 5
								}
							},
							categories : cartegories
						},
						yAxis : {
							min : 0,
							title : {
								text : getTitle()
							}
						},
						series : [ {
							size : '60%',
							data : seriesdata
						} ]
					});
		}
	}
	
	
	/* 折线图 */
	function showChartZhe(seriesdata, cartegories, type) {
		if (seriesdata.length == 0) {
			var noData = "暂无数据";
			var height=$('#containerLine').css("height");
			$('#containerLine').css("line-height",height);
			$('#containerLine').html("<center>"+noData+"</center>");
		} else {
			$('#containerLine').highcharts(
					{
						chart : {
							type : type,
							borderColor : '#99BCE8',
							borderWidth : 1,
						},
						title : {
							text : chartTitle + '统计折线图',
							style : {
								fontSize : '12px',
								fontWeight : 'Bold',
								color : '#0096bb',
							}
						},
						tooltip : {
							formatter : function() {
								if (type == "pie") {
									return Highcharts.numberFormat(
											this.percentage, 2)
											+ '%';
								} else {
									return this.x + ":" + this.y;
								}
								//百分比保留小数
							}
						},

						plotOptions : {
							pie : {
								allowPointSelect : true, //选中某块区域是否允许分离
								cursor : 'pointer',
								dataLabels : {
									enabled : true
								//是否直接呈现数据 也就是外围显示数据与否
								},
								showInLegend : false
							},
							line : {
								dataLabels : {
									enabled : true
								},
								showInLegend : false
							},
							column : {
								dataLabels : {
									enabled : true
								//是否显示数据标签
								},
								showInLegend : false
							},
							series : {
								pointPadding : 5, //数据点之间的距离值
								groupPadding : 0, //分组之间的距离值
								borderWidth : 0,
								shadow : false,
								pointWidth : 15
							//柱子之间的距离值
							},

						},
						legend : {
							layout : 'vertical',
							backgroundColor : '#FFFFFF',
							floating : true,
							padding : 5,
							align : 'left',
							verticalAlign: 'top',
							x : 100,
							y : 45,
							labelFormatter : function() {
								return this.name
										+ '('
										+ Highcharts.numberFormat(
												this.percentage, 2) + '%)';
							}
						},
						xAxis : {
							tickmarkPlacement : 'on',
							labels : {
								// rotation:55,斜着
								style : {
									color : '#262626',
									fontSize : '12px',
									marginTop : 5
								}
							},
							categories : cartegories
						},
						yAxis : {
							min : 0,
							title : {
								text : getTitle()
							}
						},
						series : [ {
							size : '60%',
							data : seriesdata
						} ]
					});
		}
	}
	
	/* 柱状图 */
	function showChartZhu(seriesdata, cartegories, type) {
		if (seriesdata.length == 0) {
			var noData = "暂无数据";
			var height=$('#containerColumn').css("height");
			$('#containerColumn').css("line-height",height);
			$('#containerColumn').html("<center>"+noData+"</center>");
		} else {
			$('#containerColumn').highcharts(
					{
						chart : {
							type : type,
							borderColor : '#99BCE8',
							borderWidth : 1,
						},
						title : {
							text : chartTitle + '统计柱状图',
							style : {
								fontSize : '12px',
								fontWeight : 'Bold',
								color : '#0096bb',
							}
						},
						tooltip : {
							formatter : function() {
								if (type == "pie") {
									return Highcharts.numberFormat(
											this.percentage, 2)
											+ '%';
								} else {
									return this.x + ":" + this.y;
								}
								//百分比保留小数
							}
						},

						plotOptions : {
							pie : {
								allowPointSelect : true, //选中某块区域是否允许分离
								cursor : 'pointer',
								dataLabels : {
									enabled : true
								//是否直接呈现数据 也就是外围显示数据与否
								},
								showInLegend : false
							},
							line : {
								dataLabels : {
									enabled : true
								},
								showInLegend : false
							},
							column : {
								dataLabels : {
									enabled : true
								//是否显示数据标签
								},
								showInLegend : false
							},
							series : {
								pointPadding : 5, //数据点之间的距离值
								groupPadding : 0, //分组之间的距离值
								borderWidth : 0,
								shadow : false,
								pointWidth : 15
							//柱子之间的距离值
							},

						},
						legend : {
							layout : 'vertical',
							backgroundColor : '#FFFFFF',
							floating : true,
							padding : 5,
							align : 'left',
							verticalAlign: 'top',
							x : 100,
							y : 45,
							labelFormatter : function() {
								return this.name
										+ '('
										+ Highcharts.numberFormat(
												this.percentage, 2) + '%)';
							}
						},
						xAxis : {
							tickmarkPlacement : 'on',
							labels : {
								// rotation:55,斜着
								style : {
									color : '#262626',
									fontSize : '12px',
									marginTop : 5
								}
							},
							categories : cartegories
						},
						yAxis : {
							min : 0,
							title : {
								text : getTitle()
							}
						},
						series : [ {
							size : '60%',
							data : seriesdata
						} ]
					});
		}
	}
	

	function chartInit(_chartTitle, data, url) {
		if (_chartTitle) {
			chartTitle = _chartTitle;
		}
		exportData = "";
		$('#listTableTitle').html(chartTitle + "统计列表");
		$('#numName').html(chartTitle + "数量");
		$.ajax({
					type : "post",
					url : url,
					dataType : 'text',
					async : true,
					data : data,
					success : function(data) {
						data = eval("(" + data + ")");
						var total = data.total;
						if (!total) {
							total = 0;
						}
						var table_html = "";
						if (data.categories) {
							var name = data.categories.split(',');
							var count = data.seriesdata.split(',');
							// var percentage=data.percentage.split(",");
							cartegories = [];
							seriesdata = [];
							for (var i = 0; i < count.length; i++) {
								seriesdata.push([ name[i] + "," + count[i],
										parseInt(count[i]) ]);
								cartegories.push(name[i]);
								var percen = ((count[i] / total) * 100)
										.toFixed(2)
										+ "%";
								//Math.round(count[i] / total * 10000) / 100.00 
								table_html += "<tr><td style='width: 40%; border-left: 0;border-bottom: 0px;'>"
										+ name[i]
										+ "</td><td style='width: 30%;border-bottom: 0px;'>"
										+ count[i]
										+ "</td><td style='width: 30%;border-bottom: 0px;'>" + percen + "</td></tr>";
								exportData += name[i] + "," + count[i] + ","
										+ percen + ";";
							}
						} else {
							seriesdata = [];
							cartegories = [];
						}
						showChartPie(seriesdata, cartegories, "pie");
						showChartZhe(seriesdata, cartegories, "line");
						showChartZhu(seriesdata, cartegories, "column");
						if(total!=0){
							table_html += "<tr><td style='width: 40%;border-left:0px;border-right:0px;border-bottom:0px;'>共计</td><td style='width: 30%;border-bottom:0'>"
								+ total + "</td><td style='width: 30%;border-bottom:0'>100%</td></tr>";
						}
						$('#listTable').html(table_html);
						exportData += "共计," + total + ", ;";
					}

				});
	}
</script>
<style>
.tdcss {
	padding-right: 15px;
}

.searchLabel {
	text-align: right;
}

#listTable td {
	text-align: center;
}

.tableHead td {
	border: 1px solid #dddddd;
	font-weight: bold;
	text-align: center;
}
</style>