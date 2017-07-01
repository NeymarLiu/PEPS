package com.zrgk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author longwenyu
 *2016-11-23
 */
public class RolePojo implements Serializable{

	private int r_id;
	private String r_name;
	private String r_createname;
	private Date r_uptime;
	private String p_r_uptime;
	private Date r_createtime;
	private String p_r_createtime;
	private int r_state;
	private int r_delete;
	private String r_number;
	
	public String getP_r_uptime() {
		return p_r_uptime;
	}
	public void setP_r_uptime(String p_r_uptime) {
		this.p_r_uptime = p_r_uptime;
	}
	public String getP_r_createtime() {
		return p_r_createtime;
	}
	public void setP_r_createtime(String p_r_createtime) {
		this.p_r_createtime = p_r_createtime;
	}
	public String getR_number() {
		return r_number;
	}
	public void setR_number(String r_number) {
		this.r_number = r_number;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_createname() {
		return r_createname;
	}
	public void setR_createname(String r_createname) {
		this.r_createname = r_createname;
	}
	public Date getR_uptime() {
		return r_uptime;
	}
	public void setR_uptime(Date r_uptime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setP_r_uptime(sdf.format(r_uptime));
		this.r_uptime = r_uptime;
	}
	public Date getR_createtime() {
		return r_createtime;
	}
	public void setR_createtime(Date r_createtime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setP_r_createtime(sdf.format(r_createtime));
		this.r_createtime = r_createtime;
	}
	public int getR_state() {
		return r_state;
	}
	public void setR_state(int r_state) {
		this.r_state = r_state;
	}
	public int getR_delete() {
		return r_delete;
	}
	public void setR_delete(int r_delete) {
		this.r_delete = r_delete;
	}
	
}
