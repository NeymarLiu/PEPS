package com.zrgk.pojo;

import java.util.Date;
/**
 * @wangmingyong
 * 2016-11-23
 **/
	
public class PolePojo {

	private int id;
	private int pole_id;
	private String pole_code;
	private int pole_state;
	private Date pole_time;
	private LinePojo linePojo;
	private String  pole_descript;
	private int li_id;
	public void setLi_id(int li_id) {
		this.li_id = li_id;
	}
	public int getLi_id() {
		return li_id;
	}
	public void setPole_descript(String pole_descript) {
		this.pole_descript = pole_descript;
	}
	public String getPole_descript() {
		return pole_descript;
	}
	public LinePojo getLinePojo() {
		return linePojo;
	}
	public void setLinePojo(LinePojo linePojo) {
		this.linePojo = linePojo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPole_id() {
		return pole_id;
	}
	public void setPole_id(int pole_id) {
		this.pole_id = pole_id;
	}
	public String getPole_code() {
		return pole_code;
	}
	public void setPole_code(String pole_code) {
		this.pole_code = pole_code;
	}
	public int getPole_state() {
		return pole_state;
	}
	public void setPole_state(int pole_state) {
		this.pole_state = pole_state;
	}
	public Date getPole_time() {
		return pole_time;
	}
	public void setPole_time(Date pole_time) {
		this.pole_time = pole_time;
	}
}
