/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.omenk.services;


import java.io.Serializable;


/**
 *
 * @author ndh
 */
public class SearchCriteria implements  Serializable{
private static final long serialVersionUID = 1L;

	/**
	 * The user-provided search criteria for finding books.
	 */
	private String searchString;

	/**
	 * The maximum page size of the Book result list
	 */
	private int pageSize;

	/**
	 * The current page of the BUku result list.
	 */
	private int page;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
