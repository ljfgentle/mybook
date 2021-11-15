/**
 * @Title: Book.java
 * @Package com.ccx.data
 * @Description: 
 * @author ljf
 * @date 2021年11月9日
 * @version V1.0
 */
package com.ccx.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ccx.manager.BookManager;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @ClassName: Book
 * @Description: 
 * @author LJF
 * @date 2021年11月9日
 *
 */
public class Book {
	
	private Integer id;
	
	private Integer rowId;
	
	private String content;
	
	private Date createDate;
	
	//是否需要保存
	@JsonIgnore
	private boolean status = false;
	
	private List<LableMark> lables =new ArrayList<>();
	
	private Map<Integer,LableMark> lableMap =new HashMap<>();
	
	public boolean hasLableMark(Integer LableMarkId) {
		return lableMap.keySet().contains(LableMarkId);
	}
	
	public void addLableMark(LableMark lableMark) {
		lables.add(lableMark);
		lableMap.put(lableMark.getId(), lableMark);
		BookManager.store(this);
	}
	
	public void removeLableMark(Integer id) {
		Iterator<LableMark> iterator = lables.iterator();
		while (iterator.hasNext()) {
			LableMark lable = iterator.next();
			if(lable.getId().equals(id)) {
				iterator.remove();
			}
		}
		lableMap.remove(id);
		BookManager.store(this);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the lables
	 */
	public List<LableMark> getLables() {
		return lables;
	}

	/**
	 * @param lables the lables to set
	 */
	public void setLables(List<LableMark> lables) {
		this.lables = lables;
	}

	/**
	 * @return the rowId
	 */
	public Integer getRowId() {
		return rowId;
	}

	/**
	 * @param rowId the rowId to set
	 */
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
