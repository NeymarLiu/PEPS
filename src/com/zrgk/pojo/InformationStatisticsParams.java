package com.zrgk.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author licuan
 * @version 2016年12月3日21:41:31
 * @        巡检信息统计模糊查询封装类
 * */
public class InformationStatisticsParams {
	private String p_num;
	private Date start_time;
	private String stime;
	private Date end_time;
	private String etime;
	private int startNumber=0;
	private int endNumber=0;
	
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		p_num=p_num.toUpperCase();
		this.p_num = p_num;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		if(start_time!=null){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		setStime(sdf.format(start_time));}
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		if(end_time!=null){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		setEtime(sdf.format(end_time));}
		this.end_time = end_time;
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
