package com.zrgk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogPojo implements Serializable{

	private int log_id;//日志id
	private int u_id;//用户id
	private Date log_time;//操作时间
	private String p_log_time;//页面显示时间
	private String log_info;//日志的操作信息
	private int log_state;//日志状态
	private UserPojo up;	
	
	public UserPojo getUp() {
		return up;
	}
	public void setUp(UserPojo up) {
		this.up = up;
	}
	public String getP_log_time() {
		return p_log_time;
	}
	public void setP_log_time(String p_log_time) {
		this.p_log_time = p_log_time;
	}
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public Date getLog_time() {
		return log_time;
	}
	public void setLog_time(Date log_time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setP_log_time(sdf.format(log_time));
		this.log_time = log_time;
	}
	public String getLog_info() {
		return log_info;
	}
	public void setLog_info(String log_info) {
		this.log_info = log_info;
	}
	public int getLog_state() {
		return log_state;
	}
	public void setLog_state(int log_state) {
		this.log_state = log_state;
	}
	
}
