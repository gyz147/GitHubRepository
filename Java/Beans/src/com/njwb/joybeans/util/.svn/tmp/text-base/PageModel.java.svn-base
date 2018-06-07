package com.njwb.joybeans.util;

import java.util.List;

/**
 * 分页模型 T表示数据集合中的类型，动态指定的，如果PageModel<Dept> dept的分页查询， PageModel<Emp> emp的分页查询
 * 
 * @author soft01
 * 
 */
public class PageModel<T> {
	/**
	 * 每页显示的数量
	 */
	private int pageSize;

	/**
	 * 当前页
	 */
	private int pageNo;

	/**
	 * 分页对应的表中总记录数
	 */
	private int cnt;

	/**
	 * 每一页中的数据集合
	 */
	private List<T> dataList;

	/**
	 * 获取首页
	 * 
	 * @return
	 */
	public int getFirstPage() {
		return 1;
	}

	/**
	 * 获取尾页
	 */
	public int getLastPage() {
		return this.getTotalPage();
	}

	/**
	 * 获取上一页
	 * 
	 * @return
	 */
	public int getPrePage() {
		if (this.pageNo <= 1) {
			return 1;
		} else {
			return this.pageNo - 1;
		}
	}

	/**
	 * 获取下一页的页码
	 */
	public int getNextPage() {
		if (this.pageNo >= this.getTotalPage()) {

			return this.getTotalPage();
		} else {
			return this.pageNo + 1;
		}
	}

	/**
	 * 获取页面总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		return this.cnt % this.pageSize == 0 ? this.cnt / this.pageSize : this.cnt / this.pageSize + 1;
	}

	/**
	 * 从前段获取当前页码
	 * 
	 * @param pageNoStr
	 * @return
	 */
	public static int getPageNoFromFront(String pageNoStr) {
		int pageNoFromFront = 0;
		if (pageNoStr == null) {
			pageNoFromFront = 1;
		}else {
			pageNoFromFront = Integer.valueOf(pageNoStr);// 有可能是0 1 2 -1 1000
		}
		return pageNoFromFront;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (pageNo <= 0) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
	}
	
	public void setPageNo2(int pageNo){
		this.pageNo = pageNo;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

}
