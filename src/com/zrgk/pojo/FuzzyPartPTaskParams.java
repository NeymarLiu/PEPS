package com.zrgk.pojo;


/**
 *@author liucan
 *@version 2016年11月27日15:03:20
 *@巡检任务管理模块 模糊查询参数 和分页参数  
 * */
public class FuzzyPartPTaskParams {
	private String p_num;//任务编号
	private String p_state;//任务状态
	private int startNumber=0;
	private int endNumber=0;
	private int u_id;
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getU_id() {
		return u_id;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		p_num=p_num.toUpperCase();
		this.p_num = p_num;
	}
	public int getP_state() {
		return (p_state=="" || p_state==null) ?-1:Integer.parseInt(p_state);
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
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
