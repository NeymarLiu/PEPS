package com.zrgk.pojo;

public class FuzzyFlawParams {
	
	/**
	 * @author wangmingyong
	 * @version 2016-12-7
	 * @  缺陷类型模糊查询 
	 */
	private String f_name;//类型名称
	private int startNumber=0;
	private int endNumber=0;
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public int getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	public int getEndNumber() {
		return endNumber;
	}
	public void setEndNumber(int endNumber) {
		this.endNumber = endNumber;
	}
	
}
