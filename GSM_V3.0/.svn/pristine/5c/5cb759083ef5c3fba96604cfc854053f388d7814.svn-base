package com.dykj.GSM.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dykj.GSM.model.charts.ChartsTemp;

public class ToHighChartsUtil {
	public static Map<String, Object> toHighCharts2(List<Map<String, Object>> list) {
		Map<String, Object> highMap = new HashMap();
		String categories = "";
		String seriesdata = "";
		Integer total = 0;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				categories += map.get("NAME") + ",";
				seriesdata += map.get("COUNTS") + ",";
				Integer count = Integer.valueOf(map.get("COUNTS").toString());
				total = total + count;
			}
			categories = categories.substring(0, categories.length() - 1);
			seriesdata = seriesdata.substring(0, seriesdata.length() - 1);
		}

		highMap.put("total", total);
		highMap.put("categories", categories);
		highMap.put("seriesdata", seriesdata);

		return highMap;
	}

	public static Map<String, Object> toHighCharts2s(List<Map<String, Object>> list) {
		Map<String, Object> highMap = new HashMap();
		String name = "", count = "";
		int counts = 0;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ChartsTemp ch = (ChartsTemp) list.get(i);
				counts += Integer.parseInt(ch.getCounts());
				name += ch.getName() + ",";
				System.out.println(name);
				count += ch.getCounts() + ",";
			}

			name = name.substring(0, name.length() - 1);
			count = count.substring(0, count.length() - 1);
			highMap.put("total", counts + "");
		}
		highMap.put("categories", name);
		highMap.put("seriesdata", count);

		return highMap;
	}

	public static Map<String, Object> toHighCharts(List<Map<String, Object>> list) {
		Map<String, Object> highMap = new HashMap();
		String name = "", count = "", percentage = "";
		if (list != null && list.size() > 0) {
			for (Map<String, Object> map : list) {
				name += map.get("NAME") + ",";
				count += map.get("COUNTS") + ",";
				percentage += map.get("percentage") + ",";
			}
			name = name.substring(0, name.length() - 1);
			count = count.substring(0, count.length() - 1);
			percentage = percentage.substring(0, percentage.length() - 1);
		}
		highMap.put("categories", name);
		highMap.put("seriesdata", count);
		highMap.put("percentage", percentage);
		return highMap;
	}

	public static Map<String, Object> toHighChartss(List<ChartsTemp> list) {
		Map<String, Object> highMap = new HashMap();
		String name = "", count = "", percentage = "";
		if (list != null && list.size() > 0) {
			for (ChartsTemp temp : list) {
				if (temp.getName() == null) {
					int total = Integer.parseInt(temp.getCounts());
					highMap.put("total", total);
				} else { 
					if(!temp.getName().contains(";")){
						if (temp.getName().equals("zaizhiparty")) {
							name += "在职党员" + ",";
							count += temp.getCounts() + ",";
						} else if (temp.getName().equals("zhiguanparty")) {
							name += "直管党员" + ",";
							count += temp.getCounts() + ",";
						} else if (temp.getName().equals("zyzparty")) {
							name += "志愿者党员" + ",";
							count += temp.getCounts() + ",";
						} else if (temp.getName().equals("kunnanparty")) {
							name += "困难党员" + ",";
							count += temp.getCounts() + ",";
						} else if (temp.getName().equals("tuixiuparty")) {
							name += "退休党员" + ",";
							count += temp.getCounts() + ",";
						} else {
							name += temp.getName() + ",";
							count += temp.getCounts() + ",";
						}
					}else{
						String names = temp.getName();
						String[] strs = names.split(";");
						String saveValue = "";
							for(int i=0;i<strs.length;i++){
		            			if(strs[i].equals("zaizhiparty")){
		            				saveValue = "在职党员";
		            			}else if(strs[i].equals("tuixiuparty")){
		            				if(saveValue!=""){
		            					saveValue = saveValue+";退休党员";
		            				}else{
		            					saveValue = "退休党员";
		            				}
		            			}else if(strs[i].equals("zhiguanparty")){
		            				if(saveValue!=""){
		            					saveValue = saveValue+";直管党员";
		            				}else{
		            					saveValue = "直管党员";
		            				}
		            			}else if(strs[i].equals("kunnanparty")){
		            				if(saveValue!=""){
		            					saveValue = saveValue+";困难党员";
		            				}else{
		            					saveValue = "困难党员";
		            				}
			            		}else if(strs[i].equals("zyzparty")){
			            			if(saveValue!=""){
		            					saveValue = saveValue+";志愿者党员";
		            				}else{
		            					saveValue = "志愿者党员";
		            				}
			            		}
		            			
		            		}
		            		name += saveValue+",";
		            		count += temp.getCounts() + ",";
					}
				}
			}
			name = name.substring(0, name.length() - 1);
			count = count.substring(0, count.length() - 1);
		}
		highMap.put("categories", name);
		highMap.put("seriesdata", count);
		return highMap;
	}
}
