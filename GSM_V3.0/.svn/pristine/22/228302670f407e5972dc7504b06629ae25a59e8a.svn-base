/**
 * 
 */
package com.dykj.GSM.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysDicValueMapperImpl;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月28日 上午10:15:08
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:
 */
@Service("dicValueInputService")
public class DicValueInputServiceImpl implements DicValueInputService {
	@Autowired
	private SysDicValueMapperImpl dicvalueMapperImpl;

	/**
	 * @param p
	 * @param c
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 */
	@Override
	public void inputDicValue(Page p, Class<?> c) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Field> keys = new ArrayList<Field>();
		List<String> values = new ArrayList<String>();
		Field[] fs = c.getDeclaredFields();
		for (Field f : fs) {
			String fieldName = f.getName();
			if (fieldName.startsWith("code")) {
				keys.add(f);
			}
		}
		this.inputDicValue(p, c, keys);
	}

	private List<Field> getAllDeclaredFields(Class<?> c) {
		Field[] fs = c.getDeclaredFields();
		List<Field> list = Arrays.asList(fs);
		String superClassName = c.getSuperclass().getName();
		List<Field> f = new ArrayList<Field>();
		f.addAll(list);
		if (superClassName.contains("com.dykj.GSM")) {
			if (!superClassName.contains("BaseModel")) {
				f.addAll(Arrays.asList(c.getSuperclass().getDeclaredFields()));
			} else {
				getAllDeclaredFields(c.getSuperclass());
			}
		}
		return f;
	}

	/**
	 * 提供要查询的关于字典值得属性，如BHouse中的;codeHouseSource;codeHouseType;等
	 * 
	 * @param p
	 * @param c
	 * @param fieldNamesStr
	 *            用;号分割，并且前后用;包围，如;codeHouseSource;codeHouseType;
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@Override
	public void inputDicValue(Page p, Class<?> c, String fieldNamesStr) throws Exception {
		if (p != null) {
			List<Field> keys = new ArrayList<Field>();
			List<Field> fs = getAllDeclaredFields(c);
			for (Field f : fs) {
				String fieldName = f.getName();
				// ----------如果是自定义的类型
				if (f.getType().getName().contains("com.dykj.GSM")) {
					List<Field> fs2 = getAllDeclaredFields(f.getType());
					List<Field> keys2 = new ArrayList<Field>();
					for (Field f2 : fs2) {
						String fieldName2 = f2.getName();
						if (fieldNamesStr.contains(fieldName2)) {
							keys2.add(f2);
						}
					}
					this.inputDicValue2(p, f, keys2);
				}
				if (fieldNamesStr.contains(fieldName)) {
					keys.add(f);
				}
			}
			this.inputDicValue(p, c, keys);
		}
	}

	/**
	 * 提供要查询的关于字典值得属性，如BHouse中的;codeHouseSource;codeHouseType;等
	 * 
	 * @param p
	 * @param c
	 * @param fieldNamesStr
	 *            用;号分割，并且前后用;包围，如;codeHouseSource;codeHouseType;
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@Override
	public void inputDicValueForOne(Object o, Class<?> c, String fieldNamesStr) throws Exception {
		List<Field> keys = new ArrayList<Field>();
		List<Field> fs = getAllDeclaredFields(c);
		for (Field f : fs) {
			String fieldName = f.getName();
			// ----------如果是自定义的类型
			if (f.getType().getName().contains("com.dykj.GSM")) {
				List<Field> fs2 = getAllDeclaredFields(f.getType());
				List<Field> keys2 = new ArrayList<Field>();
				for (Field f2 : fs2) {
					String fieldName2 = f2.getName();
					if (fieldNamesStr.contains(fieldName2)) {
						keys2.add(f2);
					}
				}
				this.inputDicValue2ForOne(o, f, keys2);
			}
			if (fieldNamesStr.contains(fieldName)) {
				keys.add(f);
			}
		}
		this.inputDicValueForOne(o, c, keys);
	}

	/**
	 * 处理对象中的复杂对象的
	 * 
	 * @param p
	 * @param fi是类型为复杂类型的那个参数
	 * @param fields
	 * @throws Exception
	 */
	private void inputDicValue2ForOne(Object o, Field fi, List<Field> fields) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 将list中所有对象的字典值放入map中，防止出现重复值
		Map<String, String> valueMap = new HashMap<String, String>();
		putDicCodeAndValue2(o, valueMap, fi, fields);
		// 从字典值中得到数据，有CODE,TOTALNAME,NAME,DICCODE
		if (!valueMap.isEmpty()) {
			List<String> va = new ArrayList(valueMap.values());
			List<String> va2 = new ArrayList<String>();
			for (String v : va) {
				if (v.contains(";")) {
					va2.addAll(Arrays.asList(v.split(";")));
				} else {
					va2.add(v);
				}
			}
			List<Map<String, Object>> dicValueList = dicvalueMapperImpl.queryListByCodes(va2);
			putValueToDicValueMap2(dicValueList, map, fields, fi, o);
		}
	}

	private void inputDicValueForOne(Object b, Class<?> c, List<Field> fields) throws Exception {
		// 将list中所有对象的字典值放入map中，防止出现重复值
		Map<String, String> valueMap = new HashMap<String, String>();
		putDicCodeAndValue(b, valueMap, fields);
		// 从字典值中得到数据，有CODE,TOTALNAME,NAME,DICCODE
		if (!valueMap.isEmpty()) {
			List<String> va = new ArrayList(valueMap.values());
			List<String> va2 = new ArrayList<String>();
			for (String v : va) {
				if (v.contains(";")) {
					va2.addAll(Arrays.asList(v.split(";")));
				} else {
					va2.add(v);
				}
			}
			List<Map<String, Object>> dicValueList = dicvalueMapperImpl.queryListByCodes(va2);
			putValueToDicValueMap(dicValueList, fields, b, c);
		}
	}

	/**
	 * 处理对象中的复杂对象的
	 * 
	 * @param p
	 * @param fi是类型为复杂类型的那个参数
	 * @param fields
	 * @throws Exception
	 */
	private void inputDicValue2(Page p, Field fi, List<Field> fields) throws Exception {
		List list = p.getRows();
		Map<String, Object> map = new HashMap<String, Object>();
		// 将list中所有对象的字典值放入map中，防止出现重复值
		Map<String, String> valueMap = new HashMap<String, String>();
		for (Object b : list) {
			putDicCodeAndValue2(b, valueMap, fi, fields);
		}
		// 从字典值中得到数据，有CODE,TOTALNAME,NAME,DICCODE
		if (!valueMap.isEmpty()) {
			List<Map<String, Object>> dicValueList = dicvalueMapperImpl.queryListByCodes(new ArrayList(valueMap
					.values()));
			for (Object b : list) {
				putValueToDicValueMap2(dicValueList, map, fields, fi, b);
			}
		}
	}

	private void inputDicValue(Page p, Class<?> c, List<Field> fields) throws Exception {
		List list = p.getRows();

		// 将list中所有对象的字典值放入map中，防止出现重复值
		Map<String, String> valueMap = new HashMap<String, String>();
		for (Object b : list) {
			putDicCodeAndValue(b, valueMap, fields);
		}
		// 从字典值中得到数据，有CODE,TOTALNAME,NAME,DICCODE
		if (!valueMap.isEmpty()) {
			List<Map<String, Object>> dicValueList = dicvalueMapperImpl.queryListByCodes(new ArrayList(valueMap
					.values()));
			for (Object b : list) {
				putValueToDicValueMap(dicValueList, fields, b, c);
			}
			// System.out.println(list);
		}
	}

	/**
	 * 将最后的值放入某个对象的dicValueMap中
	 * 
	 * @param dicValueList
	 * @param dicValueMap
	 * @param fields
	 * @param b
	 * @throws Exception
	 */
	private void putValueToDicValueMap(List<Map<String, Object>> dicValueList, List<Field> fields, Object b, Class<?> c)
			throws Exception {
		Map<String, Object> dicValueMap = new HashMap<String, Object>();
		for (Field f : fields) {
			String value = (String) getValue(b, f);
			if (value != null) {
				if (!value.contains(";")) {
					// 将字典值进行对比
					for (Map<String, Object> m : dicValueList) {
						if (m.get("CODE").equals(value)) {
							dicValueMap.put(f.getName(), m.get("TOTALNAME"));
							if (m.get("TOTALNAME") == null) {
								dicValueMap.put(f.getName(), m.get("NAME"));
							}
						}
					}
				} else {
					String[] values = value.split(";");
					String dicValueMapValue = "";
					for (int i = 0; i < values.length; i++) {
						String v = values[i];
						for (Map<String, Object> m : dicValueList) {
							if (m.get("CODE").equals(v)) {
								dicValueMapValue += m.get("TOTALNAME") + ";";
								if (m.get("TOTALNAME") == null) {
									dicValueMapValue += m.get("NAME") + ";";
								}
								if (i == values.length - 1) {
									dicValueMap.put(f.getName(), dicValueMapValue);
								}
							}
						}
					}

				}
			}
		}
		// 规定每个model里边都有一个关于字典值的map类型的属性，其名称叫做dicValueMap
		if (!dicValueMap.isEmpty()) {
			Method me = c.getMethod("setDicValueMap", Map.class);
			me.invoke(b, dicValueMap);
			// System.out.println(b);
		}
	}

	/**
	 * 将字典code和字典值放入map中
	 * 
	 * @param b
	 * @param valueMap
	 * @param fields
	 * @throws Exception
	 */
	private void putDicCodeAndValue(Object b, Map<String, String> valueMap, List<Field> fields) throws Exception {
		for (Field f : fields) {
			String value = (String) getValue(b, f);
			if (value != null) {
				valueMap.put(value.toString(), value.toString());
			}
		}
	}

	/**
	 * 将最后的值放入某个对象的dicValueMap中,处理属性为复杂对象的情况
	 * 
	 * @param dicValueList
	 * @param dicValueMap
	 * @param fields
	 * @param b
	 * @throws Exception
	 */
	private void putValueToDicValueMap2(List<Map<String, Object>> dicValueList, Map<String, Object> dicValueMap,
			List<Field> fields, Field fi, Object b) throws Exception {
		for (Field f : fields) {
			// 找到需要的复杂类型的值
			Object ob = getValue(b, fi);
			String value = (String) getValue(ob, f);
			if (value != null) {
				if (!value.contains(";")) {
					// 将字典值进行对比
					for (Map<String, Object> m : dicValueList) {
						if (m.get("CODE").equals(value)) {
							dicValueMap.put(f.getName(), m.get("TOTALNAME"));
							if (m.get("TOTALNAME") == null) {
								dicValueMap.put(f.getName(), m.get("NAME"));
							}
						}
					}
				} else {
					String[] values = value.split(";");
					String dicValueMapValue = "";
					for (int i = 0; i < values.length; i++) {
						String v = values[i];
						for (Map<String, Object> m : dicValueList) {
							if (m.get("CODE").equals(v)) {
								dicValueMapValue += m.get("TOTALNAME") + ";";
								if (m.get("TOTALNAME") == null) {
									dicValueMapValue += m.get("NAME") + ";";
								}
								if (i == values.length - 1) {
									dicValueMap.put(f.getName(), dicValueMapValue);
								}
							}
						}
					}

				}
			}
			// 规定每个model里边都有一个关于字典值的map类型的属性，其名称叫做dicValueMap
			if (!dicValueMap.isEmpty()) {
				Method me = fi.getType().getMethod("setDicValueMap", Map.class);
				me.invoke(ob, dicValueMap);
			}
		}
	}

	/**
	 * 将字典code和字典值放入map中,处理属性为复杂对象的情况
	 * 
	 * @param b
	 * @param valueMap
	 * @param fields
	 * @throws Exception
	 */
	private void putDicCodeAndValue2(Object b, Map<String, String> valueMap, Field fi, List<Field> fields)
			throws Exception {
		for (Field f : fields) {
			// 找到需要的复杂类型的值，相对于户籍人口对象BPerHuJi而言，ob的就是这个对象的person属性
			Object ob = getValue(b, fi);
			String value = (String) getValue(ob, f);
			if (value != null) {
				valueMap.put(value.toString(), value.toString());
			}
		}
	}

	private Object getValue(Object c, Field f) throws Exception {
		String name = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
		Method me = c.getClass().getMethod("get" + name);
		return me.invoke(c); // 调用getter方法获取属性值
	}
}
