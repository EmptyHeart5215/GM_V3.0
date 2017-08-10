package com.dykj.GSM.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysSeatGridMapperImpl;
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.model.sys.SysTempGrid;
import com.dykj.GSM.service.sys.SysSeatGridService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月21日 上午9:26:00 修改人： 修改日期： 类说明:
 */
@Service
public class SysSeatGridServiceImpl implements SysSeatGridService {
	@Autowired
	private SysSeatGridMapperImpl sysSeatGridMapperImpl;

	@Override
	public int insert(SysSeatGrid entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return sysSeatGridMapperImpl.insert(entity);
	}

	@Override
	public int update(SysSeatGrid entity) {
		return sysSeatGridMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return sysSeatGridMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysSeatGrid queryByKey(String primaryKey) {
		return sysSeatGridMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysSeatGrid> queryList() {
		return sysSeatGridMapperImpl.queryList();
	}

	@Override
	public List<SysSeatGrid> queryListParam(Map param) {
		return sysSeatGridMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysSeatGrid> queryTListParam(SysSeatGrid param) {
		return sysSeatGridMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysSeatGrid> queryByParamPage(int page, int size, String sidx, String sord, SysSeatGrid param) {
		return sysSeatGridMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return sysSeatGridMapperImpl.deleteBatch(list);
	}

	/*
	 * 根据用户的管理权限gridCode，查询出所有的辖区或者组织机构
	 */
	@Override
	public List<SysTempGrid> queryGridTreeByUserGridCode(String gridCode, String flagDepartment, Integer length) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		map.put("flagDepartment", flagDepartment);
		map.put("length", length);
		return sysSeatGridMapperImpl.queryGridTreeByUserGridCode(map);
	}

	/*
	 * 根据用户的管理权限gridCode，查询出所有的辖区或者组织机构
	 */
	@Override
	public List<SysTempGrid> queryGridTreeByUserGridCode(String gridCode, String flagDepartment, Integer length,
			Integer leastLength) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		map.put("flagDepartment", flagDepartment);
		map.put("leastLength", leastLength);
		return sysSeatGridMapperImpl.queryGridTreeByUserGridCode(map);
	}

	/*
	 * 根据用户的管理权限gridCode，查询出所有职能部门/组织结构的树形
	 */
	@Override
	public List<SysTempGrid> queryDepartmentTreeByUserGridCode(String gridCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		return sysSeatGridMapperImpl.queryDepartmentTreeByUserGridCode(map);
	}

	/*
	 * 根据用户的管理权限gridCode，查询出所有职能部门和街道的树形
	 */
	@Override
	public List<SysTempGrid> queryDepartmentAndStreetTreeByUserGridCode(String gridCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		return sysSeatGridMapperImpl.queryDepartmentAndStreetTreeByUserGridCode(map);
	}

	/*
	 * 得到整个组织机构树,得到辖区和组织所有的信息
	 */
	@Override
	public List<SysTempGrid> queryAllOrgTreeForSelect() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", "01");
		map.put("flagDepartment", null);
		// 如果不进行排序，则表的顺序为二级辖区——三级辖区——四级辖区——五级辖区
		map.put("noOrder", "1");
		// Map<String, SysTempGrid> returnMap = new HashMap<String,
		// SysTempGrid>();
		List<SysTempGrid> list = sysSeatGridMapperImpl.queryGridTreeByUserGridCode(map);
		return list;
		/*for (int i = 0; i < list.size(); i++) {
			SysTempGrid grid = list.get(i);
			// 如果是部门
			if (grid.getFlagDepartment().equals(true)) {
				String code = grid.getCode();
				String pCode = grid.getParentCode();
				returnMap.put(code, grid);
				getGridTree(returnMap, code, pCode, i, list);
			}
		}*/
		// return new ArrayList(returnMap.values());
	}

	private void getGridTree(Map<String, SysTempGrid> returnMap, String code, String pCode, int i,
			List<SysTempGrid> list) {
		if (code.length() > 5) {
			for (int j = 0; j < i; j++) {
				SysTempGrid parentGrid = list.get(j);
				String parentCode = parentGrid.getCode();
				if (parentCode.equals(pCode)) {
					returnMap.put(parentCode, parentGrid);
					getGridTree(returnMap, parentCode, parentGrid.getParentCode(), j, list);
				}
			}
		}
	}

	@Override
	public SysSeatFour queryByparentCode(String parentCode) {
		return sysSeatGridMapperImpl.queryByparentCode(parentCode);
	}

	/*
	 * 批量删除操作
	 */
	@Override
	public int deleteGrid(String gridCode) {
		Map<Integer, String[][]> map = new HashMap<Integer, String[][]>();
		String[][] table_5 = { { "Sys_SEAT_SECOND", "''" }, { "Sys_SEAT_THIRD", "'%'" }, { "Sys_SEAT_FOUR", "'%'" },
				{ "Sys_SEAT_GRID", "'%'" } };
		String[][] table_8 = { { "Sys_SEAT_THIRD", "''" }, { "Sys_SEAT_FOUR", "'%'" }, { "Sys_SEAT_GRID", "'%'" } };
		String[][] table_12 = { { "Sys_SEAT_FOUR", "''" }, { "Sys_SEAT_GRID", "'%'" } };
		String[][] table_20 = { { "Sys_SEAT_GRID", "''" } };
		map.put(5, table_5);
		map.put(8, table_8);
		map.put(12, table_12);
		map.put(20, table_20);
		String[][] array = map.get(gridCode.length());
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < array.length; i++) {
			Map<String, String> m = new HashMap<String, String>();
			m.put("tableName", array[i][0]);
			m.put("likeChar", array[i][1]);
			list.add(m);
		}
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code", gridCode);
		m.put("list", list);
		return sysSeatGridMapperImpl.updateBatch(m);
	}

	@Override
	public List<SysTempGrid> queryImUserByGridCode() {
		return sysSeatGridMapperImpl.queryImUserByGridCode();
	}

	@Override
	public List<SysTempGrid> queryImTechnicalSupport() {
		return sysSeatGridMapperImpl.queryImTechnicalSupport();
	}
}
