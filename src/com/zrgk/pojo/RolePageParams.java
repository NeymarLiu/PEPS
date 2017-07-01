package com.zrgk.pojo;

import java.io.Serializable;
/**
 * 
 * @author longwenyu
 *  2016-11-25
 */
public class RolePageParams implements Serializable{

	private int startNumber=-1;
	private int endNumber=-1;
	private String r_name;
	private int r_state=-1;
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
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public int getR_state() {
		return r_state;
	}
	public void setR_state(int r_state) {
		this.r_state = r_state;
	}

	
}
