package com.zrgk.pojo;

public class FuzzyMyworkParams {
	private String p_name;
	private int startNumber=0;
	private int endNumber=0;
	private int [] state;
	private int u_id;
	private int p_id;
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setState(int[] state) {
		this.state = state;
	}
	public int[] getState() {
		return state;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
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
