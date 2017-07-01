package com.zrgk.pojo;

import java.io.Serializable;
/**
 * 
 * @author longwenyu
 *  2016-11-23
 */
public class MenuPageParams implements Serializable{

	private int startNumber=-1;
	private int endNumber=-1;
	private String m_name;
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
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	
}
