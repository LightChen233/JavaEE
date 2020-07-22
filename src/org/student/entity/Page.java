package org.student.entity;

import java.util.List;

public class Page {
	private int currentnum;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	
	public Page() {
		super();
	}
	
	public Page(int currentnum, int pageSize, int totalCount) {
		super();
		this.currentnum = currentnum;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}

	public int getCurrentNum() {
		return currentnum;
	}
	public void setCurrentPage(int currentPage) {
		this.currentnum = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.totalPage=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

}
