package com.dykj.GSM.mapper.support;

import java.util.ArrayList;
import java.util.List;

import com.dykj.GSM.constant.Constant;
import com.dykj.GSM.utils.Utils;

/**
 * 分页支持参数
 * 
 * @author wangmingyuan
 * @param <T>
 * @param <T>
 *            泛型
 */
public class Page<T> {
	/**
	 * 当前页
	 */
	private Integer nowPage;
	/**
	 * 每页记录数
	 */
	private Integer pageSize;
	/**
	 * 开始下标
	 */
	private Integer startRow;
	/**
	 * 结束下标
	 */
	private Integer endRow;
	/**
	 * 总记录数
	 */
	private Integer records;
	/**
	 * 总页数
	 */
	private Integer total;
	/**
	 * 排序字段
	 */
	private String orderColumn;
	/**
	 * 排序方式
	 */
	private String orderTurn;
	/**
	 * 查询结果集
	 */
	private List<T> rows = new ArrayList<T>();

	public Page() {
		this.nowPage = Constant.DEFAULT_CURRENT_PAGE;
		this.pageSize = Constant.DEFAULT_PAGE_SIZE;
		this.orderTurn = Constant.DEFAULT_ORDERTURN;
	}

	public Page(Integer nowPage, Integer pageSize, String orderColumn) {
		super();
		this.nowPage = nowPage;
		this.pageSize = pageSize;
		this.startRow = nowPage > 0 ? (nowPage - 1) * pageSize : 0;
		this.endRow = nowPage * pageSize;
		this.orderColumn = Utils.transformPropertyToColumn(orderColumn);

	}

	public Page(Integer nowPage, Integer pageSize, String orderColumn, String orderTurn) {
		super();
		this.nowPage = nowPage;
		this.pageSize = pageSize;
		this.startRow = nowPage > 0 ? (nowPage - 1) * pageSize : 0;
		this.endRow = nowPage * pageSize;
		this.orderColumn = Utils.transformPropertyToColumn(orderColumn);
		this.orderTurn = orderTurn;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderTurn() {
		return orderTurn;
	}

	public void setOrderTurn(String orderTurn) {
		this.orderTurn = orderTurn;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Page [nowPage=" + nowPage + ", pageSize=" + pageSize + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", records=" + records + ", total=" + total + ", orderColumn=" + orderColumn + ", orderTurn="
				+ orderTurn + ", rows=" + rows + "]";
	}
}
