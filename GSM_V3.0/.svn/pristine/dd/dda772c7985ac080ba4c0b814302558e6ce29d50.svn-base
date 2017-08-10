package com.dykj.GSM.mapper.sys.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.model.sys.SysTempGrid;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月20日 下午3:17:09 修改人： 修改日期： 类说明:
 */
public interface SysSeatGridMapper extends IBaseMapper<SysSeatGrid, String> {
	/**
	 * 通过自身权限获取辖区树
	 * 
	 * @author wangmingyuan
	 * @param gridCode
	 *            辖区code
	 * @return
	 */
	public List<SysTempGrid> queryGridTreeByUserGridCode(Map map);

	/**
	 * 根据四级坐落的主键查询
	 * 
	 * @author wangmingyuan
	 * @param parentCode
	 * @return
	 */
	public SysSeatFour queryByparentCode(String parentCode);

	public int updateBatch(Map<String, Object> map);

	/**
	 * 在更新二级辖区、三级辖区、四级辖区的时候去更新下属子孙辖区的gridtotalname
	 * 
	 * @param list
	 * @return
	 */
	public int updateTotalGridName(Map<String, Object> map);

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

	List<SysTempGrid> queryDepartmentTreeByUserGridCode(Map map);

	List<SysTempGrid> queryDepartmentAndStreetTreeByUserGridCode(Map map);

}
