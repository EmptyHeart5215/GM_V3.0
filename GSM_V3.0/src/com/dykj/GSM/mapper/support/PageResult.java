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
 * 
 * @param <T>
 *            泛型
 */
public class PageResult<T> extends ArrayList<T>{
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
	/**
     * 当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果
     */
    private Boolean pageSizeZero;
    /**
     * 包含count查询
     */
    private boolean count;
    /**
     * count信号，3种情况，null的时候执行默认BoundSql,true的时候执行count，false执行分页
     */
    private Boolean countSignal;
    /**
     * 只增加排序
     */
    private boolean orderByOnly;
    /**
     * 分页合理化
     */
    private Boolean reasonable;

    public PageResult(int nowPage, int pageSize) {
        this(nowPage, pageSize, true, null);
    }
    
    public PageResult(int nowPage, int pageSize, boolean count) {
        this(nowPage, pageSize, count, null);
    }
    
    private PageResult(int nowPage, int pageSize, boolean count, Boolean reasonable) {
        super(0);
        if (nowPage == 1 && pageSize == Integer.MAX_VALUE) {
            pageSizeZero = true;
            pageSize = 0;
        }
        this.nowPage = nowPage;
        this.pageSize = pageSize;
        this.count = count;
        calculateStartAndEndRow();
        setReasonable(reasonable);
    }

    /**
     * 计算起止行号
     */
    private void calculateStartAndEndRow() {
        this.startRow = this.nowPage > 0 ? (this.nowPage - 1) * this.pageSize : 0;
        this.endRow = this.startRow + this.pageSize * (this.nowPage > 0 ? 1 : 0);
    }
    
	public PageResult() {
		this.nowPage = Constant.DEFAULT_CURRENT_PAGE;
		this.pageSize = Constant.DEFAULT_PAGE_SIZE;
		this.orderTurn = Constant.DEFAULT_ORDERTURN;
	}

	public PageResult(Integer nowPage, Integer pageSize, String orderColumn, String orderTurn) {
		super();
		this.nowPage = nowPage;
		this.pageSize = pageSize;
		this.startRow = nowPage > 0 ? (nowPage - 1) * pageSize : 0;
		this.endRow = nowPage * pageSize;
		this.orderColumn = Utils.transformPropertyToColumn(orderColumn);
		this.orderTurn = orderTurn;
	}
	

	public PageResult(int[] rowBounds, boolean count) {
        super(0);
        if (rowBounds[0] == 0 && rowBounds[1] == Integer.MAX_VALUE) {
            pageSizeZero = true;
            this.pageSize = 0;
        } else {
            this.pageSize = rowBounds[1];
            this.nowPage = rowBounds[1] != 0 ? (int) (Math.ceil(((double) rowBounds[0] + rowBounds[1]) / rowBounds[1])) : 0;
        }
        this.startRow = rowBounds[0];
        this.count = count;
        this.endRow = this.startRow + rowBounds[1];
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
		this.orderColumn = Utils.transformPropertyToColumn(orderColumn);
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

	 public void setRecords(int records) {
	        this.records = records;
	        if (records == -1) {
	        	total = 1;
	            return;
	        }
	        if (pageSize > 0) {
	        	total = (int) (records / pageSize + ((records % pageSize == 0) ? 0 : 1));
	        } else {
	        	total = 0;
	        }
	        //分页合理化，针对不合理的页码自动处理
	        if ((reasonable != null && reasonable) && nowPage > total) {
	        	nowPage = total;
	            calculateStartAndEndRow();
	        }
	    }

	public Integer getTotal() {
		return total;
	}

	public PageResult<T> setTotal(int total) {
        this.total = total;
        return this;
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
	
	public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public PageResult<T> setPageSizeZero(Boolean pageSizeZero) {
        if (pageSizeZero != null) {
            this.pageSizeZero = pageSizeZero;
        }
        return this;
    }
    
    public boolean isCount() {
        return this.count;
    }
	
	public PageResult<T> setCount(boolean count) {
	        this.count = count;
	        return this;
	}
	public Boolean getCountSignal() {
	        return countSignal;
	}

	public void setCountSignal(Boolean countSignal) {
	        this.countSignal = countSignal;
	}
	    
	public boolean isOrderByOnly() {
			return orderByOnly;
	}

	public void setOrderByOnly(boolean orderByOnly) {
			this.orderByOnly = orderByOnly;
	}
	public Boolean getReasonable() {
        return reasonable;
    }

    public PageResult<T> setReasonable(Boolean reasonable) {
        if (reasonable == null) {
            return this;
        }
        this.reasonable = reasonable;
        //分页合理化，针对不合理的页码自动处理
        if (this.reasonable && this.nowPage <= 0) {
            this.nowPage = 1;
            calculateStartAndEndRow();
        }
        return this;
    }
	
	@Override
	public String toString() {
		return "Page [nowPage=" + nowPage + ", pageSize=" + pageSize + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", records=" + records + ", total=" + total + ", orderColumn=" + orderColumn + ", orderTurn="
				+ orderTurn + ", rows=" + rows + "]";
	}

}
