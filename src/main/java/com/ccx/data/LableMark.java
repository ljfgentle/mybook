/**
 * @Title: Lable.java
 * @Package com.ccx.data
 * @Description: 
 * @author ljf
 * @date 2021年11月9日
 * @version V1.0
 */
package com.ccx.data;

import java.util.Date;

/**
 * @ClassName: Lable
 * @Description: 
 * @author LJF
 * @date 2021年11月9日
 *
 */
public class LableMark {
	
	private Integer id;
	
	private String name;
	
	private Date createDate;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
	

}
