package com.zrgk.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author longwenyu
 *
 */
public class LogPageParams implements Serializable{

	private int uid;//用户id
	private String qtime;//操作时间
	private String htime;//页面显示时间
	private String p_qtime;//操作时间
	private String p_htime;//页面显示时间
	private int startNumber=-1;
	private int endNumber=-1;
	

	public String getP_qtime() {
		return p_qtime;
	}
	public void setP_qtime(String p_qtime) {
		this.p_qtime = p_qtime;
	}
	public String getP_htime() {
		return p_htime;
	}
	public void setP_htime(String p_htime) {
		this.p_htime = p_htime;
	}
	public String getQtime() {
		return qtime;
	}
	public void setQtime(String qtime) {
		if(qtime != null && !"".equals(qtime)){
			setP_qtime(qtime.split(" ")[0]);
			String qtime2=qtime.split(" ")[0]+" 0:00:00";
			this.qtime = qtime2;
		}else{
			this.qtime = qtime;
		}
		
	}
	public String getHtime() {
		return htime;
	}
	public void setHtime(String htime) {
		if(htime != null && !"".equals(htime)){
			setP_htime(htime.split(" ")[0]);
			String htime2=htime.split(" ")[0]+" 23:59:59";
			this.htime = htime2;
		}else{
			this.htime = htime;
		}
		
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
