package com.zrgk.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MoHuTask {
	private int id;//用户id
	private String stBid;//模糊查询任务编号
	private String stStatus;//任务状态
	private String e_security_id;//工作单据
	private String stUser;//下发人
	private int f_id;//缺陷id
	private Date d1;//最小时间
	private String stime;//小时间
	private Date d2;//最大时间
	private String btime;//大时间
	private int startNumber=0;
	private int endNumber=0;
	private UserPojo user;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStBid() {
		return stBid;
	}
	public void setStBid(String stBid) {
		this.stBid = stBid;
	}
	public int getStStatus() {
		return (stStatus=="" || stStatus==null) ?-1:Integer.parseInt(stStatus);
	}
	public void setStStatus(String stStatus) {
		this.stStatus = stStatus;
	}
	
	public int getE_security_id() {
		return (e_security_id=="" || e_security_id==null) ?-1:Integer.parseInt(e_security_id);
	}
	public void setE_security_id(String e_security_id) {
		this.e_security_id = e_security_id;
	}
	public String getStUser() {
		return stUser;
	}
	public void setStUser(String stUser) {
		this.stUser = stUser;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		if(d1!=null){
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			setStime(sdf.format(d1));
		}
		this.d1 = d1;
	}
	public Date getD2() {
		return d2;
	}
	public void setD2(Date d2) {
		if (d2!=null) {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			setBtime(sdf.format(d2));
		}
		this.d2 = d2;
	}
	
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
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
	
	public UserPojo getUser() {
		return user;
	}
	public void setUser(UserPojo user) {
		this.user = user;
	}
	
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	@Override
	public String toString() {
		return "MoHuTask [stBid=" + stBid + ", stStatus=" + stStatus
				+ ", stUser=" + stUser + ", d1=" + d1 + ", d2=" + d2
				+ ", startNumber=" + startNumber + ", endNumber=" + endNumber
				+ "]";
	}
	public MoHuTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
