package com.dykj.GSM.service.sys;

import java.util.List;

import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.model.sys.SysTempGrid;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月21日 上午9:25:14 修改人： 修改日期： 类说明:
 */
public interface SysSeatGridService extends IBaseService<SysSeatGrid, String> {
	public static final String DEPARTMENTFLAG_GRID = "0";
	public static final String DEPARTMENTFLAG_DEPARTMENT = "1";

	/**
	 * 根据四级坐落的主键查询
	 * 
	 * @author wangmingyuan
	 * @param parentCode
	 * @return
	 */
	public SysSeatFour queryByparentCode(String parentCode);

	/**
	 * @param list
	 * @return 批量删除操作
	 */
	public int deleteGrid(String gridCode);

	/*
	 * 得到整个组织机构树
	 */
	public List<SysTempGrid> queryAllOrgTreeForSelect();

	/**
	 * 通过gridcode查询通讯相关人员
	 * 
	 * @return
	 */
	public List<SysTempGrid> queryImUserByGridCode();

	/**
	 * 查询技术支持人员到通讯录
	 * 
	 * @return
	 */
	public List<SysTempGrid> queryImTechnicalSupport();

	List<SysTempGrid> queryGridTreeByUserGridCode(String gridCode, String flagDepartment, Integer length,
			Integer leastLength);

	List<SysTempGrid> queryGridTreeByUserGridCode(String gridCode, String flagDepartment, Integer length);

	List<SysTempGrid> queryDepartmentTreeByUserGridCode(String gridCode);

	List<SysTempGrid> queryDepartmentAndStreetTreeByUserGridCode(String gridCode);
}
