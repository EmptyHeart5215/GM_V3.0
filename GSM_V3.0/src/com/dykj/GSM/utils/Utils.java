package com.dykj.GSM.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	public static String createEventNum(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}

	/**
	 * 将类中的字段转换为数据库中的字段的格式，主要用于分页的时候的order by
	 * 
	 * @param property
	 * @return
	 */
	public static String transformPropertyToColumn(String property) {
		if (property != null && !property.trim().isEmpty()) {
			Pattern p = Pattern.compile("[A-Z]");
			Matcher m = p.matcher(property);
			while (m.find()) {
				String a = m.group();
				property = property.replaceAll(a, "_" + a.toLowerCase());
				m = p.matcher(property);
			}
			return property.toUpperCase();
		} else {
			return null;
		}
	}

	public static Map<String, Object> transformMap(String args, Map<String, Object> map) throws JsonParseException,
			JsonMappingException, IOException {
		map = transformMap(args, map, null);
		return map;
	}

	public static Map<String, Object> transformMap(String args, Map<String, Object> map, String specials)
			throws JsonParseException, JsonMappingException, IOException {
		if (args != null) {
			ObjectMapper mapper = new ObjectMapper();
			map = mapper.readValue(args, Map.class);
		}
		String[] specialsArr = {};
		if (specials != null) {
			specialsArr = specials.split(",");
		}
		Iterator<String> it = map.keySet().iterator();
		if (specials == null) {
			while (it.hasNext()) {
				String key = it.next();
				if (key.startsWith("code")) {
					String value = map.get(key).toString();
					if (!value.trim().isEmpty()) {
						List list = Arrays.asList(value.split(";"));
						map.put(key, list);
					} else {
						map.put(key, null);
					}
				}
			}
		} else {
			while (it.hasNext()) {
				String key = it.next();
				if (key.startsWith("code")) {
					String value = map.get(key).toString();
					if (!value.trim().isEmpty()) {
						List list = Arrays.asList(value.split(";"));
						map.put(key, list);
					} else {
						map.put(key, null);
					}
				} else {
					for (String s : specialsArr) {
						if (key.equals(s)) {
							String value = map.get(key).toString();
							if (!value.trim().isEmpty()) {
								List list = Arrays.asList(value.split(";"));
								map.put(key, list);
							} else {
								map.put(key, null);
							}
						}
					}
				}
			}
		}
		return map;
	}

	public static Map<String, Object> handleDateValue(Map<String, Object> m, String dates) {
		String[] date = dates.split(",");
		for (int i = 0; i < date.length; i++) {
			String d = date[i];
			String value = (String) m.get(d);
			if (value != null && !value.isEmpty()) {
				String[] values = value.split("~");
				m.put(d + "Start", values[0]);
				m.put(d + "End", values[1]);
			}
		}
		return m;
	}
}
