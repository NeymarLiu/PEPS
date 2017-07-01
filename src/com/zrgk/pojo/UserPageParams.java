package com.zrgk.pojo;

import java.io.Serializable;
/**
 * 
 * @author longwenyu
 *  2016-11-25
 */
public class UserPageParams implements Serializable{

	private int startNumber=-1;
	private int endNumber=-1;
	private String u_realname;
	private int u_state=-1;
	
	
	public int getU_state() {
		return u_state;
	}
	public void setU_state(int u_state) {
		this.u_state = u_state;
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
	public String getU_realname() {
		return u_realname;
	}
	public void setU_realname(String u_realname) {
		this.u_realname = u_realname;
	}
	
}
