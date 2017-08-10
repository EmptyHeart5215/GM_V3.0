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
	var chartTitlesex = "";
    var chartTitlepartytype = "";
    var chartTitleage = "";

	/* 性别比例饼状图 */
	function showChartPiesex(seriesdata, cartegories, type) {
		if (seriesdata.length == 0) {
			var noData = "暂无数据";
			$('#containerPiesex').html(noData);
		} else {
			$('#containerPiesex').highcharts(
					{
						chart : {
							type : type,
							borderColor : '#99BCE8',
							borderWidth : 1,
						},
						title : {
							text : chartTitlesex + '统计饼状图',
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
								text : chartTitlesex
							}
						},
						series : [ {
							size : '60%',
							data : seriesdata
						} ]
					});
		}
	}
	
	
	/* 党员类型饼状图 */
	function showChartPiepartytype(seriesdata, cartegories, type) {
		if (seriesdata.length == 0) {
			var noData = "暂无数据";
			$('#containerPiepartytype').html(noData);
		} else {
			$('#containerPiepartytype').highcharts(
					{
						chart : {
							type : type,
							borderColor : '#99BCE8',
							borderWidth : 1,
						},
						title : {
							text : chartTitlepartytype + '统计饼状图',
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
								text : chartTitlepartytype
							}
						},
						series : [ {
							size : '60%',
							data : seriesdata
						} ]
					});
		}
	}
	
	/* 年龄饼状图 */
	function showChartPieage(seriesdata, cartegories, type) {
		if (seriesdata.length == 0) {
			var noData = "暂无数据";
			$('#containerPieage').html(noData);
		} else {
			$('#containerPieage').highcharts(
					{
						chart : {
							type : type,
							borderColor : '#99BCE8',
							borderWidth : 1,
						},
						title : {
							text : chartTitleage + '统计饼状图',
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
								text : chartTitleage
							}
						},
						series : [ {
							size : '60%',
							data : seriesdata
						} ]
					});
		}
	}
	

	function chartInitsex(_chartTitlesex, data, url) {
		if (_chartTitlesex) {
			chartTitlesex = _chartTitlesex;
		}
		exportData = "";
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
							}
						} else {
							seriesdata = [];
							cartegories = [];
						}
						showChartPiesex(seriesdata, cartegories, "pie");
					}

				});
	}
	function chartInitpartytype(_chartTitlepartytype, data, url) {
		if (_chartTitlepartytype) {
			chartTitlepartytype = _chartTitlepartytype;
		}
		exportData = "";
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
							}
						} else {
							seriesdata = [];
							cartegories = [];
						}
						showChartPiepartytype(seriesdata, cartegories, "pie");
					}

				});
	}
	function chartInitage(_chartTitleage, data, url) {
		if (_chartTitleage) {
			chartTitleage = _chartTitleage;
		}
		exportData = "";
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
							}
						} else {
							seriesdata = [];
							cartegories = [];
						}
						showChartPieage(seriesdata, cartegories, "pie");
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