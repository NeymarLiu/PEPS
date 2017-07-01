package com.zrgk.pojo;

import java.io.Serializable;

/**
 * @author licuan
 * @version 2016年11月23日12:28:24
 * */
public class PatrolUserPojo implements Serializable{
	private int p_id;//巡检任务id
	private int u_id;//巡检员id
	private String u_realname;
	private int up_state;//个人任务状态
	private UserPojo userPojo;
	public void setUserPojo(UserPojo userPojo) {
		this.userPojo = userPojo;
	}
	public UserPojo getUserPojo() {
		return userPojo;
	}
	public void setU_realname(String u_realname) {
		this.u_realname = u_realname;
	}
	public String getU_realname() {
		return u_realname;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getUp_state() {
		return up_state;
	}
	public void setUp_state(int up_state) {
		this.up_state = up_state;
	}
	
}
