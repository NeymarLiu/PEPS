package com.zrgk.pojo;

/**
 * @author wangmingyong
 * @version 2016年12月6日 16:18:14
 * @        塔杆管理模糊查询
 * */
public class FuzzyPoleParams {
	private String line_name;//线路名字
	private int startNumber=0;
	private int endNumber=0;
	
	public String getLine_name() {
		return line_name;
	}
	public void setLine_name(String line_name) {
		this.line_name = line_name;
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
