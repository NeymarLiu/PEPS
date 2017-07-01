package com.zrgk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author longwenyu
 *  2016-11-23
 */
public class MenuPojo implements Serializable{

	private int m_id;
	private String m_name;
	private String m_url;
	private Date m_createtime;
	private String p_m_createtime;
	private int m_state;
	private int m_father;
	
	public String getP_m_createtime() {
		return p_m_createtime;
	}
	public void setP_m_createtime(String p_m_createtime) {
		this.p_m_createtime = p_m_createtime;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_url() {
		return m_url;
	}
	public void setM_url(String m_url) {
		this.m_url = m_url;
	}
	public Date getM_createtime() {
		return m_createtime;
	}
	public void setM_createtime(Date m_createtime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setP_m_createtime(sdf.format(m_createtime));
		this.m_createtime = m_createtime;
	}
	public int getM_state() {
		return m_state;
	}
	public void setM_state(int m_state) {
		this.m_state = m_state;
	}
	public int getM_father() {
		return m_father;
	}
	public void setM_father(int m_father) {
		this.m_father = m_father;
	}
	
}
